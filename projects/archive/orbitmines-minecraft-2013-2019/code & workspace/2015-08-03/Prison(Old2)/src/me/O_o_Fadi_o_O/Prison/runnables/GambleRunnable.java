package me.O_o_Fadi_o_O.Prison.runnables;

import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.prisonInv.VillagerGamble;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class GambleRunnable {

	Start plugin;
	 
	public GambleRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startGambleRunnable(){
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGambling.containsKey(p)){
						int Seconds = StorageManager.PlayerGamblingSeconds.get(p);
						try{
							if(p.getOpenInventory().getTopInventory().getTitle().equals("§0§lVillager Gamble")){
								if(Seconds <= 8 && Seconds >= 1){
									VillagerGamble.setAllPreviousItemIronGamble(p.getOpenInventory().getTopInventory());
								}
							}
							else{
								p.openInventory(StorageManager.PlayersGambling.get(p));
							}
							
						}catch(Exception ex){p.openInventory(StorageManager.PlayersGambling.get(p));}
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 5);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGambling.containsKey(p)){
						int Seconds = StorageManager.PlayerGamblingSeconds.get(p);
						try{
							if(p.getOpenInventory().getTopInventory().getTitle().equals("§0§lVillager Gamble")){
								if(Seconds <= 13 && Seconds >= 9){
									VillagerGamble.setAllPreviousItemIronGamble(p.getOpenInventory().getTopInventory());
								}
							}
							else{
								p.openInventory(StorageManager.PlayersGambling.get(p));
							}
							
						}catch(Exception ex){p.openInventory(StorageManager.PlayersGambling.get(p));}
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 10);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGambling.containsKey(p)){
						int Seconds = StorageManager.PlayerGamblingSeconds.get(p);
						try{
							if(p.getOpenInventory().getTopInventory().getTitle().equals("§0§lVillager Gamble")){
								VillagerGamble.setItem(p.getOpenInventory().getTopInventory(), p, Material.STAINED_GLASS_PANE, (short) 15, 25 - Seconds, "§8§l" + (25 - Seconds) + "...", null, 26, true);
								VillagerGamble.setItem(p.getOpenInventory().getTopInventory(), p, Material.STAINED_GLASS_PANE, (short) 15, 25 - Seconds, "§8§l" + (25 - Seconds) + "...", null, 18, true);
								if(Seconds <= 15 && Seconds >= 14){
									VillagerGamble.setAllPreviousItemIronGamble(p.getOpenInventory().getTopInventory());
								}
							}
							else{
								p.openInventory(StorageManager.PlayersGambling.get(p));
							}
							
						}catch(Exception ex){p.openInventory(StorageManager.PlayersGambling.get(p));}
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 20);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGambling.containsKey(p)){
						int Seconds = StorageManager.PlayerGamblingSeconds.get(p);
						try{
							if(p.getOpenInventory().getTopInventory().getTitle().equals("§0§lVillager Gamble")){
								if(Seconds <= 20 && Seconds >= 16){
									p.getOpenInventory().getTopInventory().setItem(2, null);
									p.getOpenInventory().getTopInventory().setItem(4, null);
									p.getOpenInventory().getTopInventory().setItem(6, null);
									
									p.getOpenInventory().getTopInventory().setItem(11, null);
									p.getOpenInventory().getTopInventory().setItem(13, null);
									p.getOpenInventory().getTopInventory().setItem(15, null);
									
									p.getOpenInventory().getTopInventory().setItem(29, null);
									p.getOpenInventory().getTopInventory().setItem(31, null);
									p.getOpenInventory().getTopInventory().setItem(33, null);
									
									p.getOpenInventory().getTopInventory().setItem(38, null);
									p.getOpenInventory().getTopInventory().setItem(40, null);
									p.getOpenInventory().getTopInventory().setItem(42, null);
								}
								if(Seconds <= 25 && Seconds >= 21){
									if(p.getOpenInventory().getTopInventory().getItem(20) != null && p.getOpenInventory().getTopInventory().getItem(22) != null && p.getOpenInventory().getTopInventory().getItem(20) != null){
										Random r = new Random();
										int rInt = r.nextInt(4);
										
										if(rInt == 1){
											p.getOpenInventory().getTopInventory().setItem(20, null);
											p.getOpenInventory().getTopInventory().setItem(22, null);
										}
										if(rInt == 2){
											p.getOpenInventory().getTopInventory().setItem(20, null);
											p.getOpenInventory().getTopInventory().setItem(24, null);
										}
										if(rInt == 3){
											p.getOpenInventory().getTopInventory().setItem(22, null);
											p.getOpenInventory().getTopInventory().setItem(24, null);
										}
									}
								}
								if(Seconds >= 26){
									for(ItemStack item : p.getOpenInventory().getTopInventory().getContents()){
										if(item != null){
											if(item.getType() != Material.STAINED_GLASS_PANE){
												if(StorageManager.PlayersGambling.containsKey(p)){
													StorageManager.PlayersGambling.remove(p);
													StorageManager.PlayerGamblingSeconds.remove(p);
													
													if(item.getType() == Material.GOLD_INGOT){
														String s = item.getItemMeta().getDisplayName();
														int amount = Integer.parseInt(s.replaceAll(" Gold", "").replaceAll("§6§l", ""));
														
														PlayerManager.giveMoney(p, amount);
														p.sendMessage("§2§lVillager Gamble §8| §7You have received " + s + "§7!");
													}
													else if(item.getType() == Material.EMERALD){
														String s = item.getItemMeta().getDisplayName();
														int amount = 0;
														if(s.startsWith("§a1")){
															amount = Integer.parseInt(s.replaceAll(" Gamble Ticket", "").replaceAll("§a", ""));
														}
														else{
															amount = Integer.parseInt(s.replaceAll(" Gamble Tickets", "").replaceAll("§a", ""));
														}
														
														PlayerManager.giveGambleTickets(p, amount);
														p.sendMessage("§2§lVillager Gamble §8| §7You have received " + s + "§7!");
													}
													else if(item.getType() == Material.CHEST){
														String s = item.getItemMeta().getDisplayName();
													
														p.sendMessage("§2§lVillager Gamble §8| §7You have received " + s + "§7!");
														
														ItemMeta meta = item.getItemMeta();
														meta.setDisplayName("§cRare Chest");
														item.setItemMeta(meta);
														
														p.getInventory().addItem(item);
														
													}
													else if(item.getType() == Material.IRON_PICKAXE){
														p.getInventory().addItem(item);
														p.sendMessage("§2§lVillager Gamble §8| §7You have received an §7Iron Pickaxe!");
													}
													else if(item.getType() == Material.DIAMOND_PICKAXE){
														p.getInventory().addItem(item);
														p.sendMessage("§2§lVillager Gamble §8| §7You have received a §bDiamond Pickaxe!");
													}
													else{}
													
													p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
												}
													
												p.closeInventory();
											}
										}
									}
								}
							}
							else{
								p.openInventory(StorageManager.PlayersGambling.get(p));
							}
							
						}catch(Exception ex){try{p.openInventory(StorageManager.PlayersGambling.get(p));}catch(Exception ex2){}}
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 40);
	}
}
