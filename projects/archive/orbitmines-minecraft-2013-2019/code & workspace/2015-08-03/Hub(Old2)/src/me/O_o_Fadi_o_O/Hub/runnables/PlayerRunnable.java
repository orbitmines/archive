package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.JoinItems;
import me.O_o_Fadi_o_O.Hub.Inv.Wardrobe;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRunnable {
	
	Hub plugin;
	 
	public PlayerRunnable(Hub instance) {
		plugin = instance;
	}
	
	private int i = 0;
	
	public void startPlayerRunnable(){
		
		new BukkitRunnable(){
			
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(!BarAPI.hasBar(p)){
						
						if(i == 0){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!", 10);
							i++;
						}
						else if(i == 1){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.omt.get(p.getName()) + "§6 OMT", 10);
							i++;
						}
						else if(i == 2){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com", 10);
							i++;
						}
						else if(i == 3){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com", 10);
							i++;
						}
						else if(i == 4){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.points.get(p.getName()) + "§6 VIP Points", 10);
							i++;
						}
						else if(i == 5){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(p.getName()) + "§6 Votes", 10);
							i = 0;
						}
					}
					
					if(StorageManager.EnablePlayers.containsKey(p.getName())){
						if(StorageManager.EnablePlayers.get(p.getName()) == false){
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
						}
					}
					
					if(PlayerManager.isLoaded(p)){
						if(p.getWorld().getName().equals("Hub")){
							boolean petInv = false;
							
							if(!StorageManager.PlayersInMasterMind.contains(p)){
								if(StorageManager.ownerpets.containsKey(p)){
									if(p.getVehicle() != null && p.getVehicle() == StorageManager.ownerpets.get(p)){
										petInv = true;
									}
								}
								
								if(petInv == true){
									
									PlayerManager.givePetInv(p);
									
								}
								else{
									if(!PlayerManager.isInOPMode(p)){
										JoinItems.giveItems(p);
									}
								}
							}
						}
						if(StorageManager.wardrobeDisco.containsKey(p.getName()) && StorageManager.wardrobeDisco.get(p.getName()) == true){
							
							List<Color> unlockedColors = StorageManager.wardrobeUnlockedColors.get(p.getName());
							int rInt = new Random().nextInt(unlockedColors.size());
							
							Color c = unlockedColors.get(rInt);
							
							String color = null;

							if(c == Color.AQUA){ color = "§b";}
							if(c == Color.BLACK){ color = "§0";}
							if(c == Color.BLUE){ color = "§9";}
							if(c == Color.FUCHSIA){ color = "§d";}
							if(c == Color.GRAY){ color = "§7";}
							if(c == Color.GREEN){ color = "§2";}
							if(c == Color.LIME){ color = "§a";}
							if(c == Color.NAVY){ color = "§1";}
							if(c == Color.ORANGE){ color = "§6";}
							if(c == Color.PURPLE){ color = "§5";}
							if(c == Color.RED){ color = "§c";}
							if(c == Color.TEAL){ color = "§3";}
							if(c == Color.WHITE){ color = "§f";}
							if(c == Color.YELLOW){ color = "§e";}
							
							PlayerManager.giveLeatherWardrobeArmor(p, c, color + "Disco Armor");
							
						}
						if(p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lWardrobe")){
							
							Color c = null;
							String color = null;
							
							int rInt = new Random().nextInt(14);
							
							if(rInt == 0){c = Color.AQUA; color = "§b";}
							if(rInt == 1){c = Color.BLACK; color = "§0";}
							if(rInt == 2){c = Color.BLUE; color = "§9";}
							if(rInt == 3){c = Color.FUCHSIA; color = "§d";}
							if(rInt == 4){c = Color.GRAY; color = "§7";}
							if(rInt == 5){c = Color.GREEN; color = "§2";}
							if(rInt == 6){c = Color.LIME; color = "§a";}
							if(rInt == 7){c = Color.NAVY; color = "§1";}
							if(rInt == 8){c = Color.ORANGE; color = "§6";}
							if(rInt == 9){c = Color.PURPLE; color = "§5";}
							if(rInt == 10){c = Color.RED; color = "§c";}
							if(rInt == 11){c = Color.TEAL; color = "§3";}
							if(rInt == 12){c = Color.WHITE; color = "§f";}
							if(rInt == 13){c = Color.YELLOW; color = "§e";}
							
							Wardrobe.setDiscoItem(p.getOpenInventory().getTopInventory(), p, c, color);
							
						}
					}
					if(p.getOpenInventory().getTopInventory() instanceof AnvilInventory){
						{
							ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§9§nCosmetic Perks");
							item.setItemMeta(meta);
							p.getInventory().setItem(12, item);
						}
						{
							ItemStack item = new ItemStack(Material.NAME_TAG, 1);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§f§oClick the §6§oRight§f§o Egg to rename your Pet!");
							item.setItemMeta(meta);
							p.getInventory().setItem(14, item);
						}
					}
					else{
						p.getInventory().setItem(12, null);
						p.getInventory().setItem(14, null);
					}
				}

			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}

