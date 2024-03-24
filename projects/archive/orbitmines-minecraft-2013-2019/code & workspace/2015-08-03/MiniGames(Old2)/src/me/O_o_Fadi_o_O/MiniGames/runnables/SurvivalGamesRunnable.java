package me.O_o_Fadi_o_O.MiniGames.runnables;

import java.util.HashMap;

import me.O_o_Fadi_o_O.MiniGames.PlayerScoreboard;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Inventories.SurvivalGamesInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.TeleporterInv;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class SurvivalGamesRunnable {

	Start plugin;
	 
	public SurvivalGamesRunnable(Start instance) {
		plugin = instance;
	}
	
	public HashMap<Integer, Integer> i = new HashMap<Integer, Integer>();
	
	public void startSurvivalGamesRunnable(){
		
		i.put(1, 0);
		i.put(2, 0);
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				SurvivalGamesInv.getSurvivalGamesGame(SurvivalGamesInv.inv, 1);
				SurvivalGamesInv.getSurvivalGamesGame(SurvivalGamesInv.inv, 2);
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getOpenInventory().getTopInventory() != null){
						if(p.getOpenInventory().getTopInventory().getTitle() == "§0§lTeleporter"){
							
							TeleporterInv.getAllPlayers(TeleporterInv.inv, p);
							
						}
					}
				}
				
				for(int arena = 1; arena <= 2; arena++){
					try{
						if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.ENDING)){
							i.put(arena, i.get(arena) + 1);
							
							if(i.get(arena) < 5){
								for(Player player : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInSurvivalGames.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(player)){
										
										if(StorageManager.PlayersArena.get(player).equals(arena)){
											player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
										}
									}
								}
							}
							else{
								i.put(arena, 0);
								for(Player player : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInSurvivalGames.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(player)){
										
										if(StorageManager.PlayersArena.get(player).equals(arena)){
											player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											SurvivalGames.giveReward(player, arena);
											SurvivalGames.leaveArena(player, arena);
											for(Player p : Bukkit.getOnlinePlayers()){
												player.showPlayer(p);
											}
										}
									}
								}
								Start.rollback(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)).getWorld().getName());
								SurvivalGames.startArenaData(arena);
							}
						}
						if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.WARMUP)){
							
							i.put(arena, i.get(arena) + 1);
				
							if(i.get(arena) < 5){
								
								World w = Bukkit.getWorld(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)).getWorld().getName());
								w.strikeLightning(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena)));
								
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInSurvivalGames.contains(p)){
										
										if(StorageManager.PlayersArena.get(p).equals(arena)){
											p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											
											Start.clearInventory(p);
											
											if(StorageManager.PlayersInSurvivalGames.contains(p)){
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
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersInSurvivalGames.contains(p)){
										
										if(StorageManager.PlayersArena.get(p).equals(arena)){
											Start.clearInventory(p);
										}
									}
								}
								SurvivalGames.startGame(arena);
							}
							if(i.get(arena) < 5){
								
					        }
							else{
								i.put(arena, 0);
							}
						}
						if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.LOBBY) || StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.LASTSECONDS)){
							
							SurvivalGames.spawnCountdownWord(Bukkit.getWorld("SurvivalGamesLobby" + arena), arena);
							SurvivalGames.spawnGameWord(Bukkit.getWorld("SurvivalGamesLobby" + arena), arena);
							SurvivalGames.spawnMapWord(Bukkit.getWorld("SurvivalGamesLobby" + arena), arena);
						
							if(StorageManager.SurvivalGamesPlayers.get(arena) >= 2){
								
								if(StorageManager.SurvivalGamesSeconds.get(arena) != -1){
									StorageManager.SurvivalGamesSeconds.put(arena, StorageManager.SurvivalGamesSeconds.get(arena) -1);
								}
								if(StorageManager.SurvivalGamesSeconds.get(arena) == -1){
									StorageManager.SurvivalGamesMinutes.put(arena, StorageManager.SurvivalGamesMinutes.get(arena) -1);
									StorageManager.SurvivalGamesSeconds.put(arena, 59);
								}
								if(StorageManager.SurvivalGamesSeconds.get(arena) == 10){
									SurvivalGames.prepareStart(arena);
								}
								if(StorageManager.SurvivalGamesSeconds.get(arena) <= 10 && StorageManager.SurvivalGamesSeconds.get(arena) != 0){
									
									for(Player p : Bukkit.getOnlinePlayers()){
										if(StorageManager.PlayersInSurvivalGames.contains(p)){
											
											if(StorageManager.PlayersArena.get(p).equals(arena)){
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												p.sendMessage("§f§oStarting in §6§o" + StorageManager.SurvivalGamesSeconds.get(arena) + "§f§o...");
											}
										}
									}
								}
								if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) == 0){
									SurvivalGames.startWarmup(arena);
								}
							}
						}
						if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.INGAME)){
							if(StorageManager.SurvivalGamesSeconds.get(arena) != -1){
								StorageManager.SurvivalGamesSeconds.put(arena, StorageManager.SurvivalGamesSeconds.get(arena) -1);
							}
							if(StorageManager.SurvivalGamesSeconds.get(arena) == -1){
								StorageManager.SurvivalGamesMinutes.put(arena, StorageManager.SurvivalGamesMinutes.get(arena) -1);
								StorageManager.SurvivalGamesSeconds.put(arena, 59);
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 10 && StorageManager.SurvivalGamesSeconds.get(arena) == 0){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §a§l§oAll Chests have been restocked!");
												p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											}
										}
									}
								}
								if(arena == 1){
									StorageManager.SurvivalGamesAllChestsArena1.clear();
									StorageManager.SurvivalGamesChests.clear();
								}
								//TODO
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) == 30){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch starting in §f§l§o0m 30s§c§l§o!");
												p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											}
										}
									}
								}
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) <= 10 && StorageManager.SurvivalGamesSeconds.get(arena) != 0){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch starting in §f§l§o0m " + StorageManager.SurvivalGamesSeconds.get(arena) +"s§c§l§o!");
												p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											}
										}
									}
								}
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) == 0){
								SurvivalGames.startDeathMatch(arena);
							}
						}
						if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
							if(StorageManager.SurvivalGamesSeconds.get(arena) != -1){
								StorageManager.SurvivalGamesSeconds.put(arena, StorageManager.SurvivalGamesSeconds.get(arena) -1);
							}
							if(StorageManager.SurvivalGamesSeconds.get(arena) == -1){
								StorageManager.SurvivalGamesMinutes.put(arena, StorageManager.SurvivalGamesMinutes.get(arena) -1);
								StorageManager.SurvivalGamesSeconds.put(arena, 59);
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 1 && StorageManager.SurvivalGamesSeconds.get(arena) == 00){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch ending in §f§l§o1m 0s§c§l§o!");
												p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											}
										}
									}
								}
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) == 30){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch ending in §f§l§o0m 30s§c§l§o!");
												p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											}
										}
									}
								}
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) <= 10 && StorageManager.SurvivalGamesSeconds.get(arena) != 0){
								for(Player p : Bukkit.getOnlinePlayers()){
									if(StorageManager.PlayersGame.containsKey(p)){
										if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
											if(StorageManager.PlayersArena.get(p) == arena){
												
												p.sendMessage("§6SurvivalGames §8| §c§l§oDeathmatch ending in §f§l§o0m " + StorageManager.SurvivalGamesSeconds.get(arena) +"s§c§l§o!");
												p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
											}
										}
									}
								}
							}
							if(StorageManager.SurvivalGamesMinutes.get(arena) == 0 && StorageManager.SurvivalGamesSeconds.get(arena) == 0){
								SurvivalGames.endGame(arena);
							}
							
							for(Player p : Bukkit.getOnlinePlayers()){
								if(StorageManager.PlayersInSurvivalGames.contains(p)){
									if(StorageManager.PlayersArena.get(p) == arena){
										
										Location l = StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(arena));
										int x = l.getBlockX();
										int z = l.getBlockZ();
										
										int bDistance = 0;
										int xB = p.getLocation().getBlockX() -x;
										int zB = p.getLocation().getBlockZ() -z;
										
										if(xB < 0){
											xB = -xB;
										}
										if(zB < 0){
											zB = -zB;
										}
										
										if(xB <= zB){
											bDistance = zB;
										}
										else{
											bDistance = xB;
										}
										
										bDistance = 40 - bDistance;
										
										if(bDistance < 0){
											p.sendMessage("§6SurvivalGames §8| §4§l§oStay in the Arena!");
											p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
											p.damage(3);
											
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
}
