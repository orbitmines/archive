package me.O_o_Fadi_o_O.MiniGames.runnables;

import java.util.HashMap;

import me.O_o_Fadi_o_O.MiniGames.PlayerScoreboard;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Inventories.ChickenFightInv;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ChickenFightRunnable {

	Start plugin;
	 
	public ChickenFightRunnable(Start instance) {
		plugin = instance;
	}
	
	public HashMap<Integer, Integer> i = new HashMap<Integer, Integer>();
	
	public void startChickenFightRunnable(){
		
		i.put(1, 0);
		i.put(2, 0);
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				ChickenFightInv.getChickenFightGame(ChickenFightInv.inv, 1);
				ChickenFightInv.getChickenFightGame(ChickenFightInv.inv, 2);
				
				clearEggsInLobby();
				
				for(int arena = 1; arena <= 2; arena++){
					try{
						if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.ENDING)){
							i.put(arena, i.get(arena) + 1);
							
							if(i.get(arena) < 5){
								for(Player player : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInChickenFight.contains(player) || StorageManager.SpectatorsInChickenFight.contains(player)){
										
										if(StorageManager.PlayersArena.get(player).equals(arena)){
											player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
											
											for(Player p : Bukkit.getOnlinePlayers()){
												player.showPlayer(p);
											}
										}
									}
								}
							}
							else{
								
								i.put(arena, 0);
								for(Player player : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInChickenFight.contains(player) || StorageManager.SpectatorsInChickenFight.contains(player)){
										
										if(StorageManager.PlayersArena.get(player).equals(arena)){
											player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											ChickenFight.giveReward(player, arena);
											ChickenFight.leaveArena(player, arena);
											
											for(Player p : Bukkit.getOnlinePlayers()){
												player.showPlayer(p);
											}
										}
									}
								}
					
								ChickenFight.startArenaData(arena);
							}
						}
						if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.WARMUP)){
							
							i.put(arena, i.get(arena) + 1);
				
							if(i.get(arena) < 5){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInChickenFight.contains(p)){
										
										if(StorageManager.PlayersArena.get(p).equals(arena)){
											p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											
											Start.clearInventory(p);
											
											if(StorageManager.PlayersInChickenFight.contains(p)){
												ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5 - i.get(arena));
												ItemMeta itemmeta = item.getItemMeta();
												itemmeta.setDisplayName("§f§oStarting in §6§o" + (5 - i.get(arena)) + "§f§o...");
												item.setItemMeta(itemmeta);
												item.setDurability((short) 4);
												p.getInventory().setItem(0, item);
												p.getInventory().setItem(1, item);
												p.getInventory().setItem(2, item);
												p.getInventory().setItem(3, item);
												p.getInventory().setItem(4, item);
												p.getInventory().setItem(5, item);
												p.getInventory().setItem(6, item);
												p.getInventory().setItem(7, item);
												p.getInventory().setItem(8, item);
												
												p.updateInventory();
											
												p.setAllowFlight(false);
												p.setFlying(false);
											}
										}
									}
								}
							}
							else{
								ChickenFight.startGame(arena);
							}
							if(i.get(arena) < 5){
								
					        }
							else{
								i.put(arena, 0);
							}
						}
						if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LOBBY) || StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LASTSECONDS)){
							
							ChickenFight.spawnCountdownWord(Bukkit.getWorld("ChickenFightLobby" + arena), arena);
							ChickenFight.spawnGameWord(Bukkit.getWorld("ChickenFightLobby" + arena), arena);
							ChickenFight.spawnMapWord(Bukkit.getWorld("ChickenFightLobby" + arena), arena);
						
							if(StorageManager.ChickenFightPlayers.get(arena) >= 2){
								
								if(StorageManager.ChickenFightSeconds.get(arena) != -1){
									StorageManager.ChickenFightSeconds.put(arena, StorageManager.ChickenFightSeconds.get(arena) -1);
								}
								if(StorageManager.ChickenFightSeconds.get(arena) == -1){
									StorageManager.ChickenFightMinutes.put(arena, StorageManager.ChickenFightMinutes.get(arena) -1);
									StorageManager.ChickenFightSeconds.put(arena, 59);
								}
								if(StorageManager.ChickenFightSeconds.get(arena) == 10){
									ChickenFight.prepareStart(arena);
								}
								if(StorageManager.ChickenFightSeconds.get(arena) <= 10 && StorageManager.ChickenFightSeconds.get(arena) != 0){
									
									for(Player p : Bukkit.getOnlinePlayers()){
										if(StorageManager.PlayersInChickenFight.contains(p)){
											
											if(StorageManager.PlayersArena.get(p).equals(arena)){
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												p.sendMessage("§f§oStarting in §6§o" + StorageManager.ChickenFightSeconds.get(arena) + "§f§o...");
											}
										}
									}
								}
								if(StorageManager.ChickenFightMinutes.get(arena) == 0 && StorageManager.ChickenFightSeconds.get(arena) == 0){
									ChickenFight.startWarmup(arena);
								}
							}
						}
						if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.INGAME)){
							if(StorageManager.ChickenFightSeconds.get(arena) != -1){
								StorageManager.ChickenFightSeconds.put(arena, StorageManager.ChickenFightSeconds.get(arena) -1);
							}
							if(StorageManager.ChickenFightSeconds.get(arena) == -1){
								StorageManager.ChickenFightMinutes.put(arena, StorageManager.ChickenFightMinutes.get(arena) -1);
								StorageManager.ChickenFightSeconds.put(arena, 59);
							}
							if(StorageManager.ChickenFightMinutes.get(arena) == 0 && StorageManager.ChickenFightSeconds.get(arena) == 0){
								ChickenFight.endGame(arena);
							}
							for(Player p : Bukkit.getOnlinePlayers()){
								if(StorageManager.PlayersGame.containsKey(p)){
									if(StorageManager.PlayersArena.get(p).equals(arena)){
										if(StorageManager.PlayersInChickenFight.contains(p)){
											StorageManager.ChickenFightRoundSecondsSurvived.put(p, StorageManager.ChickenFightRoundSecondsSurvived.get(p) +1);
											if(StorageManager.ChickenFightGameEffectBlindness.get(arena) == true){
												p.removePotionEffect(PotionEffectType.BLINDNESS);
												p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
											}
											if(StorageManager.ChickenFightGameEffectJump.get(arena) == true){
												p.removePotionEffect(PotionEffectType.JUMP);
												p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60, 4));
											}
											if(StorageManager.ChickenFightGameEffectSpeed.get(arena) == true){
												p.removePotionEffect(PotionEffectType.SPEED);
												p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3));
											}
											if(StorageManager.ChickenFightKit.get(p).equals("Chicken Warrior")){
												p.removePotionEffect(PotionEffectType.SLOW);
												p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
											}
										}
									}
								}
							}
						}
					}catch(Exception ex){
						
					}
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					PlayerScoreboard.setScoreboard(p);
				}
			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
	
	public void clearEggsInLobby(){
		try{
			for(Entity en : Bukkit.getWorld("ChickenFightLobby1").getEntities()){
				if(en instanceof Item){
					Item i = (Item) en;
					
					if(i.getItemStack().getType() == Material.EGG){
						i.remove();
					}
				}
			}
		}catch(Exception ex){
			
		}
		try{
			for(Entity en : Bukkit.getWorld("ChickenFightLobby2").getEntities()){
				if(en instanceof Item){
					Item i = (Item) en;
					
					if(i.getItemStack().getType() == Material.EGG){
						i.remove();
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
}
