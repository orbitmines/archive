package me.O_o_Fadi_o_O.MiniGames.runnables;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerInteract;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class EXPBarRunnable {

	Start start = Start.getInstance();
	
	public int i = 0;
	
	public void startEXPBarRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run(){
				
				i++;
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersinchickenfight.contains(p)){
						
						if(StorageManager.playersgame.get(p).equals(Game.CHICKENFIGHT)){
							if(!StorageManager.deadplayersinchickenfight.contains(p)){
								if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(p)) == ChickenFightState.INGAME){
									float currentexp = p.getExp();
									
									if(StorageManager.chickenfightkit.get(p).equals("Chicken Mama")){
										long lastUsed = 0;
										if(PlayerInteract.lastUsage.containsKey(p.getName())){
											lastUsed = PlayerInteract.lastUsage.get(p.getName());
										}
										
										if(currentexp <= 1){
											int timeLeft = (int) (PlayerInteract.cdtime-((System.currentTimeMillis()-lastUsed)/1000));
											
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName("§f§lFeather §8(" + timeLeft +"...)");
													item.setItemMeta(meta);
												}
											}
											
											p.setExp(currentexp + 1F / 120F);
											
										}
										else{
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													if(i == 1){
														meta.setDisplayName("§f§lFeather §6(Right Click)");
													}
													else{
														meta.setDisplayName("§f§lFeather §e(Right Click)");
														
														i = 0;
													}
													item.setItemMeta(meta);
												}
											}
										}
									}
									if(StorageManager.chickenfightkit.get(p).equals("Baby Chicken")){
										long lastUsed2 = 0;
										if(PlayerInteract.lastUsage2.containsKey(p.getName())){
											lastUsed2 = PlayerInteract.lastUsage2.get(p.getName());
										}
										
										if(currentexp <= 1){
											int timeLeft = (int) (PlayerInteract.cdtime2-((System.currentTimeMillis()-lastUsed2)/1000));
											
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName("§f§lFeather §8(" + timeLeft +"...)");
													item.setItemMeta(meta);
												}
											}
											
											p.setExp(currentexp + 1F / 140F);
											
										}
										else{
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													if(i == 1){
														meta.setDisplayName("§f§lFeather §6(Right Click)");
													}
													else{
														meta.setDisplayName("§f§lFeather §e(Right Click)");
														
														i = 0;
													}
													item.setItemMeta(meta);
												}
											}
										}
									}
									if(StorageManager.chickenfightkit.get(p).equals("Hot Wing")){
										long lastUsed3 = 0;
										if(PlayerInteract.lastUsage3.containsKey(p.getName())){
											lastUsed3 = PlayerInteract.lastUsage3.get(p.getName());
										}
										
										if(currentexp <= 1){
											int timeLeft = (int) (PlayerInteract.cdtime3-((System.currentTimeMillis()-lastUsed3)/1000));
											
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName("§f§lFeather §8(" + timeLeft +"...)");
													item.setItemMeta(meta);
												}
											}
											
											p.setExp(currentexp + 1F / 200F);
											
										}
										else{
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													if(i == 1){
														meta.setDisplayName("§f§lFeather §6(Right Click)");
													}
													else{
														meta.setDisplayName("§f§lFeather §e(Right Click)");
														
														i = 0;
													}
													item.setItemMeta(meta);
												}
											}
										}
									}
									if(StorageManager.chickenfightkit.get(p).equals("Chicken Warrior")){
										long lastUsed4 = 0;
										if(PlayerInteract.lastUsage4.containsKey(p.getName())){
											lastUsed4 = PlayerInteract.lastUsage4.get(p.getName());
										}
										
										if(currentexp <= 1){
											int timeLeft = (int) (PlayerInteract.cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
											
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName("§f§lFeather §8(" + timeLeft +"...)");
													item.setItemMeta(meta);
												}
											}
											
											p.setExp(currentexp + 1F / 160F);
											
										}
										else{
											for(ItemStack item : p.getInventory().getContents()){
												if(item != null && item.getType() == Material.FEATHER){
													ItemMeta meta = item.getItemMeta();
													if(i == 1){
														meta.setDisplayName("§f§lFeather §6(Right Click)");
													}
													else{
														meta.setDisplayName("§f§lFeather §e(Right Click)");
														
														i = 0;
													}
													item.setItemMeta(meta);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	// 3, 60 Ticks, 1 / 60
	// 6, 120 Ticks, 1 / 120
	// 7, 140 Ticks, 1 / 140
	// 10, 200 Ticks, 1 / 200
	// 8, 160 Ticks, 1 / 160
}
