package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.ShopSign;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalUtils;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalUtils.ShopType;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class SignEvent implements Listener {

	@EventHandler
	public void onSign(SignChangeEvent e){
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		boolean chestshop = false;
		if(!e.isCancelled() && ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
			String[] lines = e.getLines();
			
			if(lines[0] != null && (lines[0].equalsIgnoreCase("Shop:Buy") || lines[0].equalsIgnoreCase("Shop:Sell"))){
				if(ServerData.isServer(Server.PRISON) || omp.getSurvivalPlayer().getShopSigns().size() < omp.getSurvivalPlayer().getShopsAllowed()){
					if(new SurvivalUtils().getChestShop(e.getBlock()) != null){	
						boolean cancreate = true;
						
						ShopType shoptype = ShopType.valueOf(lines[0].substring(5).toUpperCase());
						int materialid = 1;
						int durability = 0;
						int amount = 1;
						int price = 1;
						
						if(lines[1] != null && !lines[1].equals("")){
							String[] lineparts = lines[1].replace(" ", "").split("\\:");
							
							boolean isnumeric = true;
							
							for(int i = 0; i < lineparts[0].length(); i++){
								if(!Character.isDigit(lineparts[0].charAt(i))){
									isnumeric = false;
								}
							}
							
							if(isnumeric){
								materialid = Integer.parseInt(lineparts[0]);
							}
							
							if(lineparts[1] != null){
								boolean isnumeric2 = true;
								
								for(int i = 0; i < lineparts[1].length(); i++){
									if(!Character.isDigit(lineparts[1].charAt(i))){
										isnumeric2 = false;
									}
								}
								
								if(isnumeric2){
									durability = Integer.parseInt(lineparts[1]);
								}
							}
						}
						else{
							cancreate = false;
						}
						
						if(lines[2] != null && !lines[2].equals("")){
							String[] lineparts = lines[2].replace(" ", "").replace("$", "").replace("G", "").split("\\:");
							
							boolean isnumeric = true;
							
							for(int i = 0; i < lineparts[0].length(); i++){
								if(!Character.isDigit(lineparts[0].charAt(i))){
									isnumeric = false;
								}
							}
							
							if(isnumeric){
								amount = Integer.parseInt(lineparts[0]);
								
								if(amount == 0){
									cancreate = false;
								}
							}
							
							if(lineparts[1] != null){
								boolean isnumeric2 = true;
								
								for(int i = 0; i < lineparts[1].length(); i++){
									if(!Character.isDigit(lineparts[1].charAt(i))){
										isnumeric2 = false;
									}
								}
								
								if(isnumeric2){
									price = Integer.parseInt(lineparts[1]);
									
									if(price == 0){
										cancreate = false;
									}
								}
							}
						}
						else{
							cancreate = false;
						}
						
						if(cancreate){
							if(price <= 1000000){
								final ShopSign sign = new ShopSign(p.getUniqueId(), e.getBlock().getLocation(), materialid, (short) durability, shoptype, amount, price);
		
								ShopSign.getShopSigns().add(sign);
								if(ServerData.isServer(Server.SURVIVAL)){
									p.sendMessage("§7Created new shop! §7(§6" + (omp.getSurvivalPlayer().getShopSigns().size() +1) + "§7/§6" + omp.getSurvivalPlayer().getShopsAllowed() + "§7)");
									omp.getSurvivalPlayer().getShopSigns().add(sign);
								}
								else{
									p.sendMessage("§7Created new shop!");
									omp.getPrisonPlayer().getShopSigns().add(sign);
								}
								ShopSign.saveToConfig();
								
								new BukkitRunnable(){
									public void run(){
										sign.update();
									}
								}.runTaskLater(Start.getInstance(), 1);
							}
							else{
								e.getBlock().breakNaturally();
								p.sendMessage("§7You cannot set the price higher than §61.000.000$§7!");
							}
						}
						else{
							e.getBlock().breakNaturally();
							p.sendMessage("§7Unable to create Chest Shop. Go to §6/spawn§7 for a tutorial.");
						}
					}
					else{
						e.getBlock().breakNaturally();
						p.sendMessage("§7The sign has to be connected to a chest!");
					}
				}
				else{
					e.getBlock().breakNaturally();
					p.sendMessage("§7You already reached the maximum amount of shops! (§6" + omp.getSurvivalPlayer().getShopsAllowed() + "§7)");
				}
			}
		}
		
		if(omp.isLoaded() && !chestshop && (omp.hasPerms(StaffRank.Owner) && omp.isOpMode() || ServerData.isServer(Server.SURVIVAL, Server.SKYBLOCK, Server.PRISON) && omp.hasPerms(VIPRank.Emerald_VIP))){
			e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
			e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
			e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
			e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
		}
	}
}
