package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.DisguisePlayer;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.LobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class SurvivalGames {

	/*
	 * 
	 * Game Managing:
	 * 
	 */
	
	public static HashMap<Integer, Integer> spawns = new HashMap<Integer, Integer>();
	
	@SuppressWarnings("deprecation")
	public static void startDeathMatch(int arena){
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(StorageManager.playersgame.containsKey(p)){
				if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.playersarena.get(p) == arena){
						
						p.sendMessage("§6SurvivalGames §8| §a§l§oAll Chests have been restocked!");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
					}
				}
			}
		}
		if(arena == 1){
			StorageManager.survivalgamesallchestsarena1.clear();
			StorageManager.survivalgameschests.clear();
		}
		
		StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.DEATHMATCH);
		
		StorageManager.survivalgamesminutes.put(arena, 3);
		StorageManager.survivalgamesseconds.put(arena, 0);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersgame.containsKey(p)){
				if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.playersarena.get(p) == arena){
						
						if(StorageManager.playersinsurvivalgames.contains(p)){
							
							if(p.getVehicle() != null){
								p.leaveVehicle();
							}
							Location l = StorageManager.survivalgamesplayerspawn.get(p);
							p.teleport(l);
							
						}
						if(StorageManager.spectatorsinsurvivalgames.contains(p)){
							
							Location l = StorageManager.survivalgamesspectatorlocation.get(StorageManager.survivalgamescurrentmap.get(arena));
							p.teleport(l);
							
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void endGame(int arena){
		
		if(StorageManager.survivalgamesplayers.get(arena) == 1){
			
			Player p1 = null;
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.playersinsurvivalgames.contains(player)){
								p1 = player;
							}
							else{
								if(StorageManager.deadplayersinsurvivalgames.contains(player)){
									player.sendMessage("§7Stats §6| §2§l+ 1 Lose");
									
									DatabaseManager.addSurvivalGamesLoses(player, 1);
								}
							}
						}
					}
				}
			}
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.playSound(player.getLocation(), Sound.WITHER_DEATH, 5, 1);
							player.sendMessage("§c§l§m###############################");
							player.sendMessage("");
							player.sendMessage("               §6§l Survival Games");
							player.sendMessage("");
							player.sendMessage("              §6§lWinner: §e" + p1.getName());
							player.sendMessage("");
							player.sendMessage("§c§l§m###############################");	
						}
					}
				}
			}
			
			StorageManager.survivalgameswinner.put(arena, p1);
			StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.ENDING);
			
			p1.sendMessage("§7Stats §6| §2§l+ 1 Win");

			DatabaseManager.addSurvivalGamesWins(p1, 1);

		}
		else{
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(p)){
					if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
						if(StorageManager.playersarena.get(p).equals(arena)){
							p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
							p.sendMessage("§c§l§m###############################");
							p.sendMessage("");
							p.sendMessage("               §6§l Survival Games");
							p.sendMessage("");
							p.sendMessage("               §6§lWinner: §4§lNONE");
							p.sendMessage("");
							p.sendMessage("§c§l§m###############################");	
						}
					}
				}
			}
			
			StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.ENDING);
		}
	}
	
	public static void giveReward(Player p, int arena){
		
		try{
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			int i = 0;
	
			p.sendMessage("§c§l§m###############################");
			p.sendMessage("");
			p.sendMessage("               §6§l Survival Games");
			p.sendMessage("");
			if(StorageManager.survivalgameswinner.get(arena) == p){
				p.sendMessage("§f§l +15 §7(Won Game)");
				i = i + 15;
			}
			p.sendMessage("§f§l +5 §7(Patient)");
			i = i + 5;
			if(StorageManager.survivalgamesroundkills.get(p) != 0){
				if(StorageManager.survivalgamesroundkills.get(p) == 1){
					p.sendMessage("§f§l +" + (StorageManager.survivalgamesroundkills.get(p) * 4) + " §7(" + StorageManager.survivalgamesroundkills.get(p) + " Kill)");
					i = i + StorageManager.survivalgamesroundkills.get(p);
				}
				else{
					p.sendMessage("§f§l +" + (StorageManager.survivalgamesroundkills.get(p) * 4) + " §7(" + StorageManager.survivalgamesroundkills.get(p) + " Kills)");
					i = i + (StorageManager.survivalgamesroundkills.get(p) * 4);
				}
			}
			if(StorageManager.survivalgamesboostermultiply.get(arena) != 0){
				p.sendMessage("§f§l +" + i * StorageManager.survivalgamesboostermultiply.get(arena) + " §b(Game Effect Booster " + StorageManager.survivalgamesboostermultiply.get(arena) + "00%)");
				i = i * StorageManager.survivalgamesboostermultiply.get(arena);
			}

			DatabaseManager.addMiniGameCoins(p, i);

			p.sendMessage("");
			p.sendMessage("§c§l§m###############################");	
		}catch(Exception ex){
			
		}
		
	}
	
	public static void teleportToArena(Player p, int arena){
		if(StorageManager.playersgame.containsKey(p)){
			if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
				if(StorageManager.playersarena.get(p).equals(arena)){
					String map = StorageManager.survivalgamescurrentmap.get(arena);
					if(StorageManager.playersinsurvivalgames.contains(p)){
					
						int max = StorageManager.survivalgamesspawnamount.get(map);
			
						spawns.put(arena, spawns.get(arena) +1);
				
						if(spawns.get(arena) == max){
							spawns.put(arena, 1);
						}
						Location l = StorageManager.survivalgamesspawnlocations.get(map + spawns.get(arena));
						p.teleport(l);
						StorageManager.survivalgamesplayerspawn.put(p, l);
						p.setVelocity(new Vector(0, 0, 0));
					}
					else{
						Location l = StorageManager.survivalgamesspectatorlocation.get(map);
						p.teleport(l);
						p.setVelocity(new Vector(0, 0, 0));
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startWarmup(int arena){
		StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.WARMUP);
		
		String map = StorageManager.survivalgamescurrentmap.get(arena);
		String builder = StorageManager.survivalgamesbuiltby.get(map);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinsurvivalgames.contains(p)){
				
				if(StorageManager.playersarena.get(p).equals(arena)){
					p.setHealth(20D);
					teleportToArena(p, arena);
					p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
					
					Start.clearInventory(p);
					p.updateInventory();
					
					p.sendMessage("§c§l§m###############################");
					p.sendMessage("");
					p.sendMessage("               §6§l Survival Games");
					p.sendMessage("");
					p.sendMessage("§a§o Gather loot from chests and kill all opponents!");
					p.sendMessage("");
					p.sendMessage("§cMap: §f" + map);	
					p.sendMessage("§cBuilder(s): §f" +  builder);
					p.sendMessage("§c§l§m###############################");
					
				    for(Player player : Bukkit.getOnlinePlayers()){
				    	p.showPlayer(player);
				    }
				}
			}
		}
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "day night " + StorageManager.survivalgamesspectatorlocation.get(map).getWorld().getName());
		World w = Bukkit.getWorld(StorageManager.survivalgamesspectatorlocation.get(map).getWorld().getName());
		//for(Chunk ch : w.getLoadedChunks()){
		//	for(BlockState b : ch.getTileEntities()){
		//		if(b.getType() == Material.CHEST){
		//			Chest c = (Chest) b;
		//			SurvivalGames.setRandomChestContents(c);
		//		}
		//	}
		//}
		for(Entity en : w.getEntities()){
			if(en instanceof Player){
				
			}
			else{
				en.remove();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void prepareStart(int arena){
		StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.LASTSECONDS);
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinsurvivalgames.contains(p)){
				
				if(StorageManager.playersarena.get(p).equals(arena)){
				
					if(StorageManager.petentity.containsKey(p)){
						PlayerManager.removePet(p, "§7Pet");
					}
					if(PlayerManager.hasWardrobeArmor(p)){
						PlayerManager.removeWardrobeArmor(p);
					}
					if(StorageManager.disguise.containsKey(p)){
						DisguisePlayer.undisguisePlayer(p);
					}
					PlayerManager.removeGadget(p);
					if(PlayerManager.hasHat(p)){
						PlayerManager.removeHat(p);
					}
					
					if(p.getOpenInventory().getTopInventory() != null){
						p.closeInventory();
					}
					if(p.getVehicle() != null){
						p.leaveVehicle();
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startGame(int arena){
		StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.INGAME);
		StorageManager.survivalgamesminutes.put(arena, 20);
		StorageManager.survivalgamesseconds.put(arena, 0);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinsurvivalgames.contains(p)){
				
				if(StorageManager.playersarena.get(p).equals(arena)){
				
					p.setFoodLevel(20);
					p.setHealth(20D);
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					p.setLevel(0);
					p.setExp(0);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 5, 1);
					p.getInventory().setHeldItemSlot(0);
					
				}	
			}
		}
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "day day " + StorageManager.survivalgamesspectatorlocation.get(StorageManager.survivalgamescurrentmap.get(arena)).getWorld().getName());
	}
	
	@SuppressWarnings("deprecation")
	public static void joinArena(Player p, int arena){
		if(StorageManager.petentity.containsKey(p)){
			PlayerManager.removePet(p, "§7Pet");
		}
		if(StorageManager.disguise.containsKey(p)){
			DisguisePlayer.undisguisePlayer(p);
		}
		
		if(p.getVehicle() != null){
			p.leaveVehicle();
		}
		if(p.getPassenger() != null){
			if(p.getPassenger().getVehicle() != null){
				p.getPassenger().leaveVehicle();
			}
		}
	    ((CraftPlayer) p).getHandle().setInvisible(false);
		
	    StorageManager.playersgame.put(p, Game.SURVIVALGAMES);
	    StorageManager.playersarena.put(p, arena);
	    
		if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.LOBBY) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.LASTSECONDS)){
			
			StorageManager.playersinsurvivalgames.add(p);
			StorageManager.survivalgamesroundkills.put(p, 0);
			StorageManager.survivalgamesplayers.put(arena, StorageManager.survivalgamesplayers.get(arena) +1);
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oSurvivalGames " + arena + "§2§o)");
						}
					}
				}
			}
			
			p.teleport(StorageManager.survivalgameslobbylocation.get(arena));
			LobbyKit.giveInventory(p);
		}
		else{
			StorageManager.spectatorsinsurvivalgames.add(p);
			StorageManager.survivalgamesspectators.put(arena, StorageManager.survivalgamesspectators.get(arena) +1);
			StorageManager.survivalgamesroundkills.put(p, 0);

			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oSurvivalGames " + arena + "§2§o) §c§o[Spectator]");
						}
					}
				}
			}
		    p.teleport(StorageManager.survivalgamesspectatorlocation.get(StorageManager.survivalgamescurrentmap.get(arena)));
		    ((CraftPlayer) p).getHandle().setInvisible(true);
		    SpectatorKit.giveInventory(p);
			p.setAllowFlight(true);
			p.setFlying(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void leaveArena(Player p, int arena){
		if(StorageManager.petentity.containsKey(p)){
			PlayerManager.removePet(p, "§7Pet");
		}
		if(StorageManager.disguise.containsKey(p)){
			DisguisePlayer.undisguisePlayer(p);
		}
	    ((CraftPlayer) p).getHandle().setInvisible(false);
		if(p.getVehicle() != null){
			p.leaveVehicle();
		}
		if(p.getPassenger() != null){
			if(p.getPassenger().getVehicle() != null){
				p.getPassenger().leaveVehicle();
			}
		}
		if(StorageManager.playersinsurvivalgames.contains(p)){
			StorageManager.playersinsurvivalgames.remove(p);
			StorageManager.survivalgamesplayers.put(arena, StorageManager.survivalgamesplayers.get(arena) -1);
			StorageManager.survivalgamesroundkills.remove(p);
			
			if(StorageManager.survivalgamesstate.get(arena) != SurvivalGamesState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
							if(StorageManager.playersarena.get(player).equals(arena)){
								player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oSurvivalGames " + arena + "§4§o)");
								p.showPlayer(player);
								player.showPlayer(p);
							}
						}
					}
				}
			}
			
		    StorageManager.playersgame.remove(p);
		    StorageManager.playersarena.remove(p);
			
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setLevel(0);
			p.setExp(0);
			
			if(StorageManager.survivalgamesplayerspawn.containsKey(p)){
				StorageManager.survivalgamesplayerspawn.remove(p);
			}
			
			if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.INGAME) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.WARMUP) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
				if(StorageManager.survivalgamesplayers.get(arena) == 1){
					endGame(arena);
				}
			}
			
			MiniGamesLobbyKit.giveInventory(p, true);
		}
		if(StorageManager.spectatorsinsurvivalgames.contains(p)){
			
			if(StorageManager.survivalgamesstate.get(arena) != SurvivalGamesState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersgame.get(player) == Game.SURVIVALGAMES){
							if(StorageManager.playersarena.get(player).equals(arena)){
								player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oSurvivalGames " + arena + "§4§o) §c§o[Spectator]");
								p.showPlayer(player);
								player.showPlayer(p);
							}
						}
					}
				}
			}
		    StorageManager.playersgame.remove(p);
		    StorageManager.playersarena.remove(p);
			StorageManager.spectatorsinsurvivalgames.remove(p);
			StorageManager.survivalgamesspectators.put(arena, StorageManager.survivalgamesspectators.get(arena) -1);
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		if(StorageManager.deadplayersinsurvivalgames.contains(p)){
			StorageManager.deadplayersinsurvivalgames.remove(p);
		}
		if(StorageManager.usedeffectinsurvivalgames.contains(p)){
			StorageManager.usedeffectinsurvivalgames.remove(p);
		}
		Start.teleportToLobby(p);
		Start.clearInventory(p);
		MiniGamesLobbyKit.giveInventory(p, true);
	}
	
	/*
	 * 
	 * Storing & Saving Data:
	 * 
	 */
	
	public static ArrayList<ItemStack> chestContents = new ArrayList<ItemStack>();
	
	public static void setRandomChestContents(Chest c){
		
		c.getInventory().clear();
		
		int i = c.getInventory().getSize();
		
		int itemamount = getRandomAmount(6);
		
		for(int in = 1; in <= itemamount; in++){
			
			chestContents.clear();
			registerAllItemStacksToContents();
			
			Random r2 = new Random();
			int i3 = r2.nextInt(chestContents.size());
			ItemStack item = chestContents.get(i3);
			
			Random r = new Random();
			int i2 = r.nextInt(i);
			c.getInventory().setItem(i2, item);
			
		}
		
		c.update();
		
	}
	
	public static void registerAllItemStacksToContents(){
		registerItemStackToContents(Material.STONE_SWORD, 1, false, "", (byte) 0, 8);
		registerItemStackToContents(Material.COOKED_BEEF, getRandomAmount(2), false, "", (byte) 0, 30);
		registerItemStackToContents(Material.DIAMOND, 1, false, "", (byte) 0, 2);
		registerItemStackToContents(Material.GOLD_AXE, 1, false, "", (byte) 0, 10);
		registerItemStackToContents(Material.CAKE, 1, false, "", (byte) 0, 15);
		registerItemStackToContents(Material.COOKED_CHICKEN, getRandomAmount(3), true, "§cChili Chicken", (byte) 0, 35);
		registerItemStackToContents(Material.BAKED_POTATO, getRandomAmount(4), false, "", (byte) 0, 40);
		registerItemStackToContents(Material.PORK, getRandomAmount(3), false, "", (byte) 0, 38);
		registerItemStackToContents(Material.WOOD_SWORD, 1, false, "", (byte) 0, 10);
		registerItemStackToContents(Material.CHAINMAIL_CHESTPLATE, 1, false, "", (byte) 0, 9);
		registerItemStackToContents(Material.CHAINMAIL_LEGGINGS, 1, false, "", (byte) 0, 8);
		registerItemStackToContents(Material.CHAINMAIL_HELMET, 1, false, "", (byte) 0, 10);
		registerItemStackToContents(Material.CHAINMAIL_BOOTS, 1, false, "", (byte) 0, 11);
		registerItemStackToContents(Material.LEATHER_CHESTPLATE, 1, false, "", (byte) 0, 21);
		registerItemStackToContents(Material.LEATHER_LEGGINGS, 1, false, "", (byte) 0, 22);
		registerItemStackToContents(Material.LEATHER_HELMET, 1, false, "", (byte) 0, 26);
		registerItemStackToContents(Material.LEATHER_BOOTS, 1, false, "", (byte) 0, 26);
		registerItemStackToContents(Material.IRON_HELMET, 1, false, "", (byte) 0, 8);
		registerItemStackToContents(Material.IRON_BOOTS, 1, false, "", (byte) 0, 8);
		registerItemStackToContents(Material.IRON_CHESTPLATE, 1, false, "", (byte) 0, 5);
		registerItemStackToContents(Material.IRON_LEGGINGS, 1, false, "", (byte) 0, 5);
		registerItemStackToContents(Material.GOLD_HELMET, 1, false, "", (byte) 0, 16);
		registerItemStackToContents(Material.GOLD_BOOTS, 1, false, "", (byte) 0, 17);
		registerItemStackToContents(Material.GOLD_CHESTPLATE, 1, false, "", (byte) 0, 14);
		registerItemStackToContents(Material.GOLD_LEGGINGS, 1, false, "", (byte) 0, 13);
		registerItemStackToContents(Material.STICK, getRandomAmount(2), false, "", (byte) 0, 13);
		registerItemStackToContents(Material.APPLE, getRandomAmount(2), false, "", (byte) 0, 17);
		registerItemStackToContents(Material.GOLD_INGOT, getRandomAmount(5), false, "", (byte) 0, 14);
		registerItemStackToContents(Material.IRON_INGOT, 1, false, "", (byte) 0, 4);
		registerItemStackToContents(Material.WOOD_AXE, 1, false, "", (byte) 0, 25);
		registerItemStackToContents(Material.STONE_AXE, 1, false, "", (byte) 0, 9);
		registerItemStackToContents(Material.BOW, 1, false, "", (byte) 0, 10);
		registerItemStackToContents(Material.ARROW, getRandomAmount(5), false, "", (byte) 0, 15);
		registerItemStackToContents(Material.ROTTEN_FLESH, getRandomAmount(4), false, "", (byte) 0, 45);
		registerItemStackToContents(Material.BOWL, getRandomAmount(4), false, "", (byte) 0, 30);
		registerItemStackToContents(Material.EXP_BOTTLE, getRandomAmount(5), false, "", (byte) 0, 13);
		registerItemStackToContents(Material.GOLD_SWORD, 1, false, "", (byte) 0, 11);
		registerItemStackToContents(Material.FISHING_ROD, 1, false, "", (byte) 0, 16);
		registerItemStackToContents(Material.FLINT, getRandomAmount(3), false, "", (byte) 0, 13);
		registerItemStackToContents(Material.FEATHER, getRandomAmount(3), false, "", (byte) 0, 11);
		registerItemStackToContents(Material.STRING, getRandomAmount(2), false, "", (byte) 0, 16);
		registerItemStackToContents(Material.FLINT_AND_STEEL, 1, false, "", (byte) 64, 6);
		registerItemStackToContents(Material.BOAT, 1, false, "", (byte) 0, 12);
		registerItemStackToContents(Material.WHEAT, getRandomAmount(5), false, "", (byte) 0, 8);
		registerItemStackToContents(Material.COOKIE, getRandomAmount(3), false, "", (byte) 0, 6);
		registerItemStackToContents(Material.MELON, getRandomAmount(5), false, "", (byte) 0, 8);
		registerItemStackToContents(Material.COOKED_FISH, getRandomAmount(2), false, "", (byte) 0, 9);
		registerItemStackToContents(Material.RAW_FISH, getRandomAmount(4), false, "", (byte) 0, 8);
		registerItemStackToContents(Material.CARROT_ITEM, getRandomAmount(2), false, "", (byte) 0, 11);
		registerItemStackToContents(Material.POTATO_ITEM, getRandomAmount(6), false, "", (byte) 0, 13);
		registerItemStackToContents(Material.COMPASS, 1, true, "§6§lPlayer Tracker", (byte) 0, 4);
		registerItemStackToContents(Material.TNT, getRandomAmount(3), false, "", (byte) 0, 6);
	}
	
	public static void registerItemStackToContents(Material material, int amount, boolean useCustomDisplayname, String Displayname, byte durability, int precent){
		for(int in = 1; in <= precent; in++){
			ItemStack item = new ItemStack(material, amount);
			if(useCustomDisplayname == true){
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(Displayname);
				item.setItemMeta(meta);
			}
			item.setDurability(durability);
			
			chestContents.add(item);
		}
	}
	
    public static int getRandomAmount(int highest) {
        Random random = new Random();
        return random.nextInt((highest - 1) + 1) + 1;
    }
	
	public static void spawnCountdownWord(World w, int arena){
		if(StorageManager.survivalgamesplayers.get(arena) >= 2){
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.survivalgamesseconds.get(arena) -1, true);
		}
		else{
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.survivalgamesseconds.get(arena) -1, false);
		}
	}
	
	public static void spawnMapWord(World w, int arena){
		//TODO: MAPS
		//if(StorageManager.survivalgamescurrentmap.get(arena).equals("Lava Island")){
		//	TextManager.createLavaIslandWord(new Location(w, -41, 70, 32));
		//}
		if(StorageManager.survivalgamescurrentmap.get(arena).equals("Breeze Island")){
			TextManager.createBreezeIslandWord(new Location(w, -41, 70, 36));
		}
		if(StorageManager.survivalgamescurrentmap.get(arena).equals("Abrax Park")){
			TextManager.createAbraxParkWord(new Location(w, -41, 70, 30));
		}
		if(StorageManager.survivalgamescurrentmap.get(arena).equals("Estyr")){
			TextManager.createEstyrWord(new Location(w, -41, 70, 21));
		}
	}
	
	public static void spawnGameWord(World w, int arena){
		TextManager.createSurvivalGamesWord(new Location(w, 42, 70, -31));
	}
	
	public static String getRandomMap(int arena){
		
		Random r = new Random();
		
		List<String> maps = new ArrayList<String>();
		
		for(String s : ConfigManager.survivalgames.getConfigurationSection("SurvivalGamesMaps").getKeys(false)){
			if(!StorageManager.survivalgamescurrentmap.containsValue(s)){
				maps.add(s);
			}
		}
		String map = maps.get(r.nextInt(maps.size()));
		
		return map;
	}
	
	public static void startArenaData(int arena){
		
		if(arena == 1){
			for(int in = 1; in <= StorageManager.survivalgamesallchestsarena1.size(); in++){
				
				Chest c = StorageManager.survivalgamesallchestsarena1.get(in);
				
				StorageManager.survivalgameschests.remove(c);
			}
			StorageManager.survivalgamesallchestsarena1.clear();
		}
		
		StorageManager.survivalgamesminutes.put(arena, 1);
		StorageManager.survivalgamesseconds.put(arena, 0);
		
		StorageManager.survivalgamesboostermultiply.put(arena, 0);
		
		StorageManager.survivalgameswinner.put(arena, null);
		
		StorageManager.survivalgamesplayers.put(arena, 0);
		StorageManager.survivalgamesspectators.put(arena, 0);
		StorageManager.survivalgamesplayersdied.put(arena, 0);
	
		if(StorageManager.survivalgamescurrentmap.containsKey(arena)){
			StorageManager.survivalgamescurrentmap.remove(arena);
		}
		StorageManager.survivalgamescurrentmap.put(arena, getRandomMap(arena));
		
		StorageManager.survivalgamesstate.put(arena, SurvivalGamesState.LOBBY);
		spawns.put(arena, 0);
	}
	
	public static void registerArenaData(int arena){
		
		if(isArenaEnabled(arena) == true){
			StorageManager.survivalgamesenabled.put(arena, true);
		}
		else{
			StorageManager.survivalgamesenabled.put(arena, false);
		}
		StorageManager.survivalgameslobbylocation.put(arena, getArenaLobbyLocation(arena));
		
		startArenaData(arena);
	}
	
	public static void registerMapData(String map){
		
		StorageManager.survivalgamesspawnamount.put(map, getMapSpawnsAmount(map));
		int i = 0;
		for(Location l : getMapSpawnLocations(map)){
			i++;
			StorageManager.survivalgamesspawnlocations.put(map + i, l);
		}
		StorageManager.survivalgamesspectatorlocation.put(map, getMapSpectatorLocation(map));
		StorageManager.survivalgamesbuiltby.put(map, getMapBuilder(map));
		Bukkit.getWorld(ConfigManager.survivalgames.getString("SurvivalGamesMaps." + map + ".SpectatorLocation.world")).setAutoSave(false);
	}
	
	public static void setArenaEnabled(int arena){
		
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".Enabled", true);
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static void setArenaDisabled(int arena){
		
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".Enabled", false);
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static boolean isArenaEnabled(int arena){
		
		boolean bl = ConfigManager.survivalgames.getBoolean("SurvivalGamesArenas." + arena + ".Enabled");
		
		return bl;
	}
	
	public static void setArenaLobbyLocation(int arena, Location l){
		
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.world", l.getWorld().getName());
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.x", l.getX());
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.y", l.getY());
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.z", l.getZ());
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.yaw", l.getYaw());
		ConfigManager.survivalgames.set("SurvivalGamesArenas." + arena + ".LobbyLocation.pitch", l.getPitch());
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static Location getArenaLobbyLocation(int arena){
		
		World w = Bukkit.getWorld(ConfigManager.survivalgames.getString("SurvivalGamesArenas." + arena + ".LobbyLocation.world"));
		double x = ConfigManager.survivalgames.getDouble("SurvivalGamesArenas." + arena + ".LobbyLocation.x");
		double y = ConfigManager.survivalgames.getDouble("SurvivalGamesArenas." + arena + ".LobbyLocation.y");
		double z = ConfigManager.survivalgames.getDouble("SurvivalGamesArenas." + arena + ".LobbyLocation.z");
		float yaw = ConfigManager.survivalgames.getInt("SurvivalGamesArenas." + arena + ".LobbyLocation.yaw");
		float pitch = ConfigManager.survivalgames.getInt("SurvivalGamesArenas." + arena + ".LobbyLocation.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		
		return l;
	}
	
	public static void setMapSpawnsAmount(String map, int amount){
		
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpawnsAmount", amount);		
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static int getMapSpawnsAmount(String map){
		
		int i = ConfigManager.survivalgames.getInt("SurvivalGamesMaps." + map + ".SpawnsAmount");
		
		return i;
	}
	
	public static void setMapSpectatorLocation(String map, Location l){
		
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.world", l.getWorld().getName());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.x", l.getX());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.y", l.getY());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.z", l.getZ());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.yaw", l.getYaw());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".SpectatorLocation.pitch", l.getPitch());
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static Location getMapSpectatorLocation(String map){
		
		World w = Bukkit.getWorld(ConfigManager.survivalgames.getString("SurvivalGamesMaps." + map + ".SpectatorLocation.world"));
		double x = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".SpectatorLocation.x");
		double y = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".SpectatorLocation.y");
		double z = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".SpectatorLocation.z");
		float yaw = ConfigManager.survivalgames.getInt("SurvivalGamesMaps." + map + ".SpectatorLocation.yaw");
		float pitch = ConfigManager.survivalgames.getInt("SurvivalGamesMaps." + map + ".SpectatorLocation.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		
		return l;
	}
	
	public static void setMapSpawnLocation(String map, Location l, int number){
		
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".world", l.getWorld().getName());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".x", l.getX());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".y", l.getY());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".z", l.getZ());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".yaw", l.getYaw());
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".Spawns." + number +".pitch", l.getPitch());
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static List<Location> getMapSpawnLocations(String map){
		
		List<Location> list = new ArrayList<Location>();
		
		for(String s : ConfigManager.survivalgames.getConfigurationSection("SurvivalGamesMaps." + map + ".Spawns").getKeys(false)){
			
			int i = Integer.parseInt(s);
			
			World w = Bukkit.getWorld(ConfigManager.survivalgames.getString("SurvivalGamesMaps." + map + ".Spawns." + i + ".world"));
			double x = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".Spawns." + i + ".x");
			double y = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".Spawns." + i + ".y");
			double z = ConfigManager.survivalgames.getDouble("SurvivalGamesMaps." + map + ".Spawns." + i + ".z");
			float yaw = ConfigManager.survivalgames.getInt("SurvivalGamesMaps." + map + ".Spawns." + i + ".yaw");
			float pitch = ConfigManager.survivalgames.getInt("SurvivalGamesMaps." + map + ".Spawns." + i + ".pitch");
		
			Location l = new Location(w, x, y, z, yaw, pitch);
			list.add(l);
		}
		
		return list;
	}
	
	public static void setMapBuilder(String map, String builder){	
		
		ConfigManager.survivalgames.set("SurvivalGamesMaps." + map + ".BuiltBy", builder);
		ConfigManager.saveSurvivalGames();
		
	}
	
	public static String getMapBuilder(String map){	
		
		String s = ConfigManager.survivalgames.getString("SurvivalGamesMaps." + map + ".BuiltBy");
		
		return s;
	}
}
