package me.O_o_Fadi_o_O.MiniGames.events;

import java.sql.SQLException;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener{
	
	Start plugin;
	 
	public DeathEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
	
		final Player died = e.getEntity();
		e.setDeathMessage(null);
		
		if(StorageManager.PlayersGame.containsKey(died)){
			if(StorageManager.PlayersGame.get(died) == Game.CHICKENFIGHT){
				died.setHealth(20D);
				e.getDrops().clear();
				died.setLevel(0);
				died.setExp(0);
				
				int arena = StorageManager.PlayersArena.get(died);
				if(StorageManager.ChickenFightState.get(arena) == ChickenFightState.INGAME){
					if(died.getKiller() instanceof Player){
						Player killer = died.getKiller();
						
						StorageManager.ChickenFightPlayersDied.put(arena, StorageManager.ChickenFightPlayersDied.get(arena) + 1);
						StorageManager.DeadPlayersInChickenFight.add(died);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.PlayersGame.containsKey(player)){
								if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
									if(StorageManager.PlayersArena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName() + "§7 killed by §c" + killer.getName());
										
									}
								}
							}
						}
						
						killer.sendMessage("§7Stats §6| §2§l+ 1 Kill");
						try {
							DatabaseManager.addChickenFightKills(killer, 1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						killer.playSound(killer.getLocation(), Sound.LAVA_POP, 5, 1);
						
						StorageManager.ChickenFightRoundKills.put(killer, StorageManager.ChickenFightRoundKills.get(killer) +1);
						killer.sendMessage("§7Stats §6| §f§lCurrent Streak: §2§l" + StorageManager.ChickenFightRoundKills.get(killer) + " §f§lBest Streak: §2§l" + StorageManager.ChickenFightBestStreak.get(killer.getName()));
						if(StorageManager.ChickenFightBestStreak.get(killer.getName()) < StorageManager.ChickenFightRoundKills.get(killer)){
							killer.sendMessage("§7Stats §6| §f§lNew Best Streak: §2§l" + StorageManager.ChickenFightRoundKills.get(killer));
							try {
								DatabaseManager.setBestChickenFightStreak(killer, StorageManager.ChickenFightRoundKills.get(killer));
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						
						StorageManager.PlayersInChickenFight.remove(died);
						StorageManager.ChickenFightPlayers.put(arena, StorageManager.ChickenFightPlayers.get(arena) - 1);
						
						StorageManager.SpectatorsInChickenFight.add(died);
						StorageManager.ChickenFightSpectators.put(arena, StorageManager.ChickenFightSpectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    died.teleport(StorageManager.ChickenFightSpectatorLocation.get(StorageManager.ChickenFightCurrentMap.get(arena)));
						
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguiseAPI.undisguiseToAll(died);
						
							} 
						}, 1L);
					    
						if(StorageManager.ChickenFightPlayers.get(arena) == 1){
							ChickenFight.endGame(arena);
						}
						
					}	
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.PlayersGame.containsKey(player)){
								if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
									if(StorageManager.PlayersArena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName());
										
									}
								}
							}
						}
						
						StorageManager.ChickenFightPlayersDied.put(arena, StorageManager.ChickenFightPlayersDied.get(arena) + 1);
						StorageManager.DeadPlayersInChickenFight.add(died);
						
						StorageManager.PlayersInChickenFight.remove(died);
						StorageManager.ChickenFightPlayers.put(arena, StorageManager.ChickenFightPlayers.get(arena) - 1);
						
						StorageManager.SpectatorsInChickenFight.add(died);
						StorageManager.ChickenFightSpectators.put(arena, StorageManager.ChickenFightSpectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    died.teleport(StorageManager.ChickenFightSpectatorLocation.get(StorageManager.ChickenFightCurrentMap.get(arena)));
					    
					    
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguiseAPI.undisguiseToAll(died);
						
							} 
						}, 1L);
						
						if(StorageManager.ChickenFightPlayers.get(arena) == 1){
							ChickenFight.endGame(arena);
						}
						
					}
				}
			}
			if(StorageManager.PlayersGame.get(died) == Game.SURVIVALGAMES){
				died.setHealth(20D);
				final int arena = StorageManager.PlayersArena.get(died);
				if(StorageManager.SurvivalGamesState.get(arena) == SurvivalGamesState.INGAME || StorageManager.SurvivalGamesState.get(arena) == SurvivalGamesState.DEATHMATCH){
					if(died.getKiller() instanceof Player){
						Player killer = died.getKiller();
						
						StorageManager.SurvivalGamesPlayersDied.put(arena, StorageManager.SurvivalGamesPlayersDied.get(arena) + 1);
						StorageManager.DeadPlayersInSurvivalGames.add(died);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.PlayersGame.containsKey(player)){
								if(StorageManager.PlayersGame.get(player) == Game.SURVIVALGAMES){
									if(StorageManager.PlayersArena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName() + "§7 killed by §c" + killer.getName());
										
									}
								}
							}
						}
						
						killer.sendMessage("§7Stats §6| §2§l+ 1 Kill");
						try {
							DatabaseManager.addSurvivalGamesKills(killer, 1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						killer.playSound(killer.getLocation(), Sound.LAVA_POP, 5, 1);
						
						StorageManager.SurvivalGamesRoundKills.put(killer, StorageManager.SurvivalGamesRoundKills.get(killer) +1);
						killer.sendMessage("§7Stats §6| §f§lCurrent Streak: §2§l" + StorageManager.SurvivalGamesRoundKills.get(killer) + " §f§lBest Streak: §2§l" + StorageManager.SurvivalGamesBestStreak.get(killer.getName()));
						if(StorageManager.SurvivalGamesBestStreak.get(killer.getName()) < StorageManager.SurvivalGamesRoundKills.get(killer)){
							killer.sendMessage("§7Stats §6| §f§lNew Best Streak: §2§l" + StorageManager.SurvivalGamesRoundKills.get(killer));
							try {
								DatabaseManager.setBestSurvivalGamesStreak(killer, StorageManager.SurvivalGamesRoundKills.get(killer));
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						
						StorageManager.PlayersInSurvivalGames.remove(died);
						StorageManager.SurvivalGamesPlayers.put(arena, StorageManager.SurvivalGamesPlayers.get(arena) - 1);
						
						StorageManager.SpectatorsInSurvivalGames.add(died);
						StorageManager.SurvivalGamesSpectators.put(arena, StorageManager.SurvivalGamesSpectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
						
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguiseAPI.undisguiseToAll(died);
								//died.teleport(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)));
								died.setFoodLevel(20);
							} 
						}, 1L);
					    
						if(StorageManager.SurvivalGamesPlayers.get(arena) == 1){
							SurvivalGames.endGame(arena);
						}
						
						if(StorageManager.SurvivalGamesMinutes.get(arena) != 0){
							
							if(StorageManager.SurvivalGamesPlayers.get(arena) <= 3 && StorageManager.SurvivalGamesPlayers.get(arena) != 1){
								
								if(StorageManager.SurvivalGamesState.get(arena) == SurvivalGamesState.INGAME){
								
									StorageManager.SurvivalGamesMinutes.put(arena, 1);
									StorageManager.SurvivalGamesSeconds.put(arena, 0);
									
									for(Player p : Bukkit.getOnlinePlayers()){
										
										if(StorageManager.PlayersGame.containsKey(p)){
											if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
												if(StorageManager.PlayersArena.get(p) == arena){
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
							if(StorageManager.PlayersGame.containsKey(player)){
								if(StorageManager.PlayersGame.get(player) == Game.SURVIVALGAMES){
									if(StorageManager.PlayersArena.get(player).equals(arena)){
										
										player.sendMessage("§7Death §6| §c" + died.getName());
										
									}
								}
							}
						}
						
						StorageManager.SurvivalGamesPlayersDied.put(arena, StorageManager.SurvivalGamesPlayersDied.get(arena) + 1);
						StorageManager.DeadPlayersInSurvivalGames.add(died);
						
						StorageManager.PlayersInSurvivalGames.remove(died);
						StorageManager.SurvivalGamesPlayers.put(arena, StorageManager.SurvivalGamesPlayers.get(arena) - 1);
						
						StorageManager.SpectatorsInSurvivalGames.add(died);
						StorageManager.SurvivalGamesSpectators.put(arena, StorageManager.SurvivalGamesSpectators.get(arena) + 1);
						
						died.setAllowFlight(true);
						died.setFlying(true);
					    ((CraftPlayer) died).getHandle().setInvisible(true);
					    
					    
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
							public void run(){
								SpectatorKit.giveInventory(died);
								DisguiseAPI.undisguiseToAll(died);
								//died.teleport(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)));
								died.setFoodLevel(20);
						
							} 
						}, 1L);
						
						if(StorageManager.SurvivalGamesPlayers.get(arena) == 1){
							SurvivalGames.endGame(arena);
						}
						
						if(StorageManager.SurvivalGamesMinutes.get(arena) != 0){
							
							if(StorageManager.SurvivalGamesPlayers.get(arena) <= 3 && StorageManager.SurvivalGamesPlayers.get(arena) != 1){
								
								if(StorageManager.SurvivalGamesState.get(arena) == SurvivalGamesState.INGAME){
									StorageManager.SurvivalGamesMinutes.put(arena, 1);
									StorageManager.SurvivalGamesSeconds.put(arena, 0);
									
									for(Player p : Bukkit.getOnlinePlayers()){
										
										if(StorageManager.PlayersGame.containsKey(p)){
											if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
												if(StorageManager.PlayersArena.get(p) == arena){
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
