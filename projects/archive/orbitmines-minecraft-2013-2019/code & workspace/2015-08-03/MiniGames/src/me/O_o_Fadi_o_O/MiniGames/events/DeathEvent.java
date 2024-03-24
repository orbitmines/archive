package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.DisguisePlayer;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
	
		final Player died = e.getEntity();
		e.setDeathMessage(null);
		
		if(StorageManager.playersgame.containsKey(died)){
			if(StorageManager.playersgame.get(died) == Game.CHICKENFIGHT){
				died.setHealth(20D);
				e.getDrops().clear();
				died.setLevel(0);
				died.setExp(0);
				
				int arena = StorageManager.playersarena.get(died);
				if(StorageManager.chickenfightstate.get(arena) == ChickenFightState.INGAME){
					if(died.getKiller() instanceof Player){
						Player killer = died.getKiller();
						
						StorageManager.chickenfightplayersdied.put(arena, StorageManager.chickenfightplayersdied.get(arena) + 1);
						StorageManager.deadplayersinchickenfight.add(died);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.playersgame.containsKey(player)){
								if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
									if(StorageManager.playersarena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName() + "§7 killed by §c" + killer.getName());
										
									}
								}
							}
						}
						
						killer.sendMessage("§7Stats §6| §2§l+ 1 Kill");

						DatabaseManager.addChickenFightKills(killer, 1);
						killer.playSound(killer.getLocation(), Sound.LAVA_POP, 5, 1);
						
						StorageManager.chickenfightroundkills.put(killer, StorageManager.chickenfightroundkills.get(killer) +1);
						killer.sendMessage("§7Stats §6| §f§lCurrent Streak: §2§l" + StorageManager.chickenfightroundkills.get(killer) + " §f§lBest Streak: §2§l" + StorageManager.chickenfightbeststreak.get(killer));
						if(StorageManager.chickenfightbeststreak.get(killer) < StorageManager.chickenfightroundkills.get(killer)){
							killer.sendMessage("§7Stats §6| §f§lNew Best Streak: §2§l" + StorageManager.chickenfightroundkills.get(killer));

							DatabaseManager.setBestChickenFightStreak(killer, StorageManager.chickenfightroundkills.get(killer));
						}
						
						StorageManager.playersinchickenfight.remove(died);
						StorageManager.chickenfightplayers.put(arena, StorageManager.chickenfightplayers.get(arena) - 1);
						
						StorageManager.spectatorsinchickenfight.add(died);
						StorageManager.chickenfightspectators.put(arena, StorageManager.chickenfightspectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    died.teleport(StorageManager.chickenfightspectatorlocation.get(StorageManager.chickenfightcurrentmap.get(arena)));
						
						start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguisePlayer.undisguisePlayer(died);
							} 
						}, 1L);
					    
						if(StorageManager.chickenfightplayers.get(arena) == 1){
							ChickenFight.endGame(arena);
						}
						
					}	
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.playersgame.containsKey(player)){
								if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
									if(StorageManager.playersarena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName());
										
									}
								}
							}
						}
						
						StorageManager.chickenfightplayersdied.put(arena, StorageManager.chickenfightplayersdied.get(arena) + 1);
						StorageManager.deadplayersinchickenfight.add(died);
						
						StorageManager.playersinchickenfight.remove(died);
						StorageManager.chickenfightplayers.put(arena, StorageManager.chickenfightplayers.get(arena) - 1);
						
						StorageManager.spectatorsinchickenfight.add(died);
						StorageManager.chickenfightspectators.put(arena, StorageManager.chickenfightspectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    died.teleport(StorageManager.chickenfightspectatorlocation.get(StorageManager.chickenfightcurrentmap.get(arena)));
					    
					    
						start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguisePlayer.undisguisePlayer(died);
							} 
						}, 1L);
						
						if(StorageManager.chickenfightplayers.get(arena) == 1){
							ChickenFight.endGame(arena);
						}
						
					}
				}
			}
			if(StorageManager.playersgame.get(died) == Game.SURVIVALGAMES){
				died.setHealth(20D);
				final int arena = StorageManager.playersarena.get(died);
				if(StorageManager.survivalgamesstate.get(arena) == SurvivalGamesState.INGAME || StorageManager.survivalgamesstate.get(arena) == SurvivalGamesState.DEATHMATCH){
					if(died.getKiller() instanceof Player){
						Player killer = died.getKiller();
						
						StorageManager.survivalgamesplayersdied.put(arena, StorageManager.survivalgamesplayersdied.get(arena) + 1);
						StorageManager.deadplayersinsurvivalgames.add(died);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.playersgame.containsKey(player)){
								if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
									if(StorageManager.playersarena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName() + "§7 killed by §c" + killer.getName());
										
									}
								}
							}
						}
						
						killer.sendMessage("§7Stats §6| §2§l+ 1 Kill");
						DatabaseManager.addSurvivalGamesKills(killer, 1);
						killer.playSound(killer.getLocation(), Sound.LAVA_POP, 5, 1);
						
						StorageManager.survivalgamesroundkills.put(killer, StorageManager.survivalgamesroundkills.get(killer) +1);
						killer.sendMessage("§7Stats §6| §f§lCurrent Streak: §2§l" + StorageManager.survivalgamesroundkills.get(killer) + " §f§lBest Streak: §2§l" + StorageManager.survivalgamesbeststreak.get(killer));
						if(StorageManager.survivalgamesbeststreak.get(killer) < StorageManager.survivalgamesroundkills.get(killer)){
							killer.sendMessage("§7Stats §6| §f§lNew Best Streak: §2§l" + StorageManager.survivalgamesroundkills.get(killer));
							
							DatabaseManager.setBestSurvivalGamesStreak(killer, StorageManager.survivalgamesroundkills.get(killer));
						}
						
						StorageManager.playersinsurvivalgames.remove(died);
						StorageManager.survivalgamesplayers.put(arena, StorageManager.survivalgamesplayers.get(arena) - 1);
						
						StorageManager.spectatorsinsurvivalgames.add(died);
						StorageManager.survivalgamesspectators.put(arena, StorageManager.survivalgamesspectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
						
						start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								//died.teleport(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)));
								died.setFoodLevel(20);
							} 
						}, 1L);
					    
						if(StorageManager.survivalgamesplayers.get(arena) == 1){
							SurvivalGames.endGame(arena);
						}
						
						if(StorageManager.survivalgamesminutes.get(arena) != 0){
							
							if(StorageManager.survivalgamesplayers.get(arena) <= 3 && StorageManager.survivalgamesplayers.get(arena) != 1){
								
								if(StorageManager.survivalgamesstate.get(arena) == SurvivalGamesState.INGAME){
								
									StorageManager.survivalgamesminutes.put(arena, 1);
									StorageManager.survivalgamesseconds.put(arena, 0);
									
									for(Player p : Bukkit.getOnlinePlayers()){
										
										if(StorageManager.playersgame.containsKey(p)){
											if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
												if(StorageManager.playersarena.get(p) == arena){
													p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch starting in §f§l§o1m 0s§c§l§o!");
													p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
												}
											}
										}
									}
								}
							}
						}
					}	
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.playersgame.containsKey(player)){
								if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
									if(StorageManager.playersarena.get(player) == arena){
										
										player.sendMessage("§7Death §6| §c" + died.getName());
										
									}
								}
							}
						}
						
						StorageManager.survivalgamesplayersdied.put(arena, StorageManager.survivalgamesplayersdied.get(arena) + 1);
						StorageManager.deadplayersinsurvivalgames.add(died);
						
						StorageManager.playersinsurvivalgames.remove(died);
						StorageManager.survivalgamesplayers.put(arena, StorageManager.survivalgamesplayers.get(arena) - 1);
						
						StorageManager.spectatorsinsurvivalgames.add(died);
						StorageManager.survivalgamesspectators.put(arena, StorageManager.survivalgamesspectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    
					    
						start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								//died.teleport(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)));
								died.setFoodLevel(20);
						
							} 
						}, 1L);
						
						if(StorageManager.survivalgamesplayers.get(arena) == 1){
							SurvivalGames.endGame(arena);
						}
						
						if(StorageManager.survivalgamesminutes.get(arena) != 0){
							
							if(StorageManager.survivalgamesplayers.get(arena) <= 3 && StorageManager.survivalgamesplayers.get(arena) != 1){
								
								if(StorageManager.survivalgamesstate.get(arena) == SurvivalGamesState.INGAME){
									StorageManager.survivalgamesminutes.put(arena, 1);
									StorageManager.survivalgamesseconds.put(arena, 0);
									
									for(Player p : Bukkit.getOnlinePlayers()){
										
										if(StorageManager.playersgame.containsKey(p)){
											if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
												if(StorageManager.playersarena.get(p) == arena){
													p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch starting in §f§l§o1m 0s§c§l§o!");
													p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
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
		}
	}
}
