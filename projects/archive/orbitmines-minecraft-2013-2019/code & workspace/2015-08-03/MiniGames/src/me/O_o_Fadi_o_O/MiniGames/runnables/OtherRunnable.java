package me.O_o_Fadi_o_O.MiniGames.runnables;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Inventories.ChickenFightInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.SurvivalGamesInv;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class OtherRunnable {

	Start start = Start.getInstance();
	
	public int i = 0;
	
	public void startOtherRunnable(){
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.spectatorsinsurvivalgames.contains(p) || StorageManager.spectatorsinchickenfight.contains(p)){
						p.setFoodLevel(20);
						p.setGameMode(GameMode.CREATIVE);
						SpectatorKit.giveInventory(p);
					}
					if(StorageManager.playersinsurvivalgames.contains(p) || StorageManager.playersinchickenfight.contains(p)){
						p.setGameMode(GameMode.SURVIVAL);
						
						if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.INGAME || StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.DEATHMATCH){
							
							if(p.getInventory().contains(Material.COMPASS)){
								List<Player> list = new ArrayList<Player>();
								list.clear();
								
								Game game = StorageManager.playersgame.get(p);
								int arena = StorageManager.playersarena.get(p);
								
								for(Player player : Bukkit.getOnlinePlayers()){
									
									if(StorageManager.playersgame.containsKey(player)){
										if(StorageManager.playersgame.get(player) == game){
											if(StorageManager.playersarena.get(player) == arena){
												if(StorageManager.playersinsurvivalgames.contains(player)){
													if(player != p){
														list.add(player);
													}
												}
											}
										}
									}
								}
								
								if(list.size() != 0){
									double distance = 100000;
									Player tracker = null;
									
									for(Player player : list){
										
										if(p.getLocation().distance(player.getLocation()) <= distance){
											distance = p.getLocation().distance(player.getLocation());
											tracker = player;
										}
									}
									
									for(ItemStack item : p.getInventory().getContents()){
										try{
											if(item.getType() == Material.COMPASS){
												
												ItemMeta meta = item.getItemMeta();
												meta.setDisplayName("§6§lTracking: §f§l" + tracker.getName() + " §6§lDistance: §f§l" + (int) distance);
												item.setItemMeta(meta);
											}
										}catch(Exception ex){
											
										}
									}
									p.setCompassTarget(tracker.getLocation());
								}
							}
						}
					}
					if(!StorageManager.playersgame.containsKey(p)){
						if(StorageManager.loaded.get(p) == true){
							if(StorageManager.opmodeenabled.get(p) == false){
								p.setGameMode(GameMode.SURVIVAL);
							}
						}
					}
					
					if(p.getInventory().getItem(4) != null){
					
						ItemStack item = p.getInventory().getItem(4);
						if(item.getType() == Material.SKULL_ITEM){
							if(item.getDurability() != (short) 4){
								item.setDurability((short) (item.getDurability() + 1)); 
							}
							else{
								item.setDurability((short) 0);
							}
						}
					}
					
					if(StorageManager.playersinsurvivalgames.contains(p)){
						if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.WARMUP){
							Location l1 = p.getLocation();
							Location l2 = StorageManager.survivalgamesplayerspawn.get(p);
							if(l1.distance(l2) >= 1.3){
								p.teleport(l2);
								p.playSound(p.getLocation(), Sound.ANVIL_LAND, (float) 1, (float) 0.10);
								p.sendMessage("§6Survival Games §8| §7Stay on your platform!");
							}
						}
					}
				}
				i++;
				if(i == 5){
					i = 0;
				}
				ChickenFightInv.getMiniGameSelector(ChickenFightInv.inv, i);
				SurvivalGamesInv.getMiniGameSelector(SurvivalGamesInv.inv, i);
				
			}
		}.runTaskTimer(this.start, 20, 8);
		
	}
}
