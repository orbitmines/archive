package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.DisguisePlayer;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.BabyChicken;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.ChickenMama;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.ChickenWarrior;
import me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight.HotWing;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.LobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ChickenFight {

	/*
	 * 
	 * Game Managing:
	 * 
	 */
	
	public static HashMap<Integer, Integer> spawns = new HashMap<Integer, Integer>();
	
	@SuppressWarnings("deprecation")
	public static void endGame(int arena){
		
		if(StorageManager.chickenfightplayers.get(arena) == 1){
			
			Player p1 = null;
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.playersinchickenfight.contains(player)){
								p1 = player;
							}
							else{
								if(StorageManager.deadplayersinchickenfight.contains(player)){
									player.sendMessage("§7Stats §6| §2§l+ 1 Lose");
									
									DatabaseManager.addChickenFightLoses(player, 1);
								}
							}
						}
					}
				}
			}
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.playSound(player.getLocation(), Sound.WITHER_DEATH, 5, 1);
							player.sendMessage("§c§l§m###############################");
							player.sendMessage("");
							player.sendMessage("                §f§l Chicken Fight");
							player.sendMessage("");
							player.sendMessage("              §6§lWinner: §e" + p1.getName());
							player.sendMessage("");
							player.sendMessage("§c§l§m###############################");	
						}
					}
				}
			}
			
			StorageManager.chickenfightwinner.put(arena, p1);
			StorageManager.chickenfightstate.put(arena, ChickenFightState.ENDING);
			
			p1.sendMessage("§7Stats §6| §2§l+ 1 Win");

			DatabaseManager.addChickenFightWins(p1, 1);
			
		}
		else{
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(p)){
					if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
						if(StorageManager.playersarena.get(p).equals(arena)){
							p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
							p.sendMessage("§c§l§m###############################");
							p.sendMessage("");
							p.sendMessage("                §f§l Chicken Fight");
							p.sendMessage("");
							p.sendMessage("               §6§lWinner: §4§lNONE");
							p.sendMessage("");
							p.sendMessage("§c§l§m###############################");	
						}
					}
				}
			}
			
			StorageManager.chickenfightstate.put(arena, ChickenFightState.ENDING);
		}
	}
	
	public static void selectKit(Player p, String kit){
		
		StorageManager.chickenfightkit.put(p, kit);
		p.sendMessage("§e§l§m###############################");
		p.sendMessage("");
		p.sendMessage("§e Kit: §7" + kit);
		p.sendMessage("");
		if(kit.equals("Chicken Mama")){
			p.sendMessage("§e Ability: §7(§f§lFeather Attack§7)");
			p.sendMessage("   §e§oDamages & Knocks back nearby players.");
			p.sendMessage("   §eCooldown: §76 Seconds");
			p.sendMessage("   §eKnockback: §7220% - 240%");
			p.sendMessage("   §eDamage: §72 - 4");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7120%");
			p.sendMessage("§e Damage: §71");
			StorageManager.kitchickenmama.put(p, true);
			if(StorageManager.kitbabychicken.containsKey(p.getName())){
				StorageManager.kitbabychicken.put(p, false);
			}
			if(StorageManager.kithotwing.containsKey(p.getName())){
				StorageManager.kithotwing.put(p, false);
			}
			if(StorageManager.kitchickenwarrior.containsKey(p.getName())){
				StorageManager.kitchickenwarrior.put(p, false);
			}
		}
		if(kit.equals("Baby Chicken")){
			p.sendMessage("§e Ability: §7(§f§lEgg Bom§7)");
			p.sendMessage("   §e§oShoots an Exploding Egg.");
			p.sendMessage("   §eCooldown: §77 Seconds");
			p.sendMessage("   §eKnockback: §7110% - 165%");
			p.sendMessage("   §eDamage: §71 - 8");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7140%");
			p.sendMessage("§e Damage: §71");
			StorageManager.kitbabychicken.put(p, true);
			if(StorageManager.kitchickenmama.containsKey(p.getName())){
				StorageManager.kitchickenmama.put(p, false);
			}
			if(StorageManager.kithotwing.containsKey(p.getName())){
				StorageManager.kithotwing.put(p, false);
			}
			if(StorageManager.kitchickenwarrior.containsKey(p.getName())){
				StorageManager.kitchickenwarrior.put(p, false);
			}
		}
		if(kit.equals("Hot Wing")){
			p.sendMessage("§e Ability: §7(§f§lFire Shield§7)");
			p.sendMessage("   §e§oYou'll get a fire shield around you which sets nearby players on fire.");
			p.sendMessage("   §eCooldown: §710 Seconds");
			p.sendMessage("   §eDamage: §71 - 4 (Fire)");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7130%");
			p.sendMessage("§e Damage Taken: §7150%");
			p.sendMessage("§e Damage: §71 + 1 - 4 (Fire)");
			StorageManager.kithotwing.put(p, true);
			if(StorageManager.kitbabychicken.containsKey(p.getName())){
				StorageManager.kitbabychicken.put(p, false);
			}
			if(StorageManager.kitchickenmama.containsKey(p.getName())){
				StorageManager.kitchickenmama.put(p, false);
			}
			if(StorageManager.kitchickenwarrior.containsKey(p.getName())){
				StorageManager.kitchickenwarrior.put(p, false);
			}
		}
		if(kit.equals("Chicken Warrior")){
			p.sendMessage("§e Ability: §7(§f§lKnock Knock§7)");
			p.sendMessage("   §e§oKnocks up and damages nearby players.");
			p.sendMessage("   §eCooldown: §78 Seconds");
			p.sendMessage("   §eDamage: §75");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7105%");
			p.sendMessage("§e Damage Taken: §790%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("§e Potion Effect: §7Slowness 3");
			StorageManager.kitchickenwarrior.put(p, true);
			if(StorageManager.kitbabychicken.containsKey(p.getName())){
				StorageManager.kitbabychicken.put(p, false);
			}
			if(StorageManager.kithotwing.containsKey(p.getName())){
				StorageManager.kithotwing.put(p, false);
			}
			if(StorageManager.kitchickenmama.containsKey(p.getName())){
				StorageManager.kitchickenmama.put(p, false);
			}
		}
		p.sendMessage("");
		p.sendMessage("§e§l§m###############################");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
	}
	
	public static void buyKit(Player p, String kit){
		
		p.sendMessage("§e§l§m###############################");
		p.sendMessage("");
		p.sendMessage("§e Kit: §7" + kit);
		p.sendMessage("");
		if(kit.equals("Baby Chicken")){
			p.sendMessage("§e Ability: §7(§f§lEgg Bom§7)");
			p.sendMessage("   §e§oShoots an Exploding Egg.");
			p.sendMessage("   §eCooldown: §77 Seconds");
			p.sendMessage("   §eKnockback: §7110% - 165%");
			p.sendMessage("   §eDamage: §71 - 8");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7140%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("");
			ComponentMessageManager.sendComponentMessage(p, "", "§cClick here to Buy '§7§lBaby Chicken§c' (§f§l1000 Coins§c)", "show_text", "run_command", "§cBuy '§7§lBaby Chicken§c'", "/mgbuykit BabyChicken");
		}
		if(kit.equals("Hot Wing")){
			p.sendMessage("§e Ability: §7(§f§lFire Shield§7)");
			p.sendMessage("   §e§oYou'll get a fire shield around you which sets nearby players on fire.");
			p.sendMessage("   §eCooldown: §710 Seconds");
			p.sendMessage("   §eDamage: §71 - 4 (Fire)");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7130%");
			p.sendMessage("§e Damage Taken: §7150%");
			p.sendMessage("§e Damage: §71 + 1 - 4 (Fire)");
			p.sendMessage("");
			ComponentMessageManager.sendComponentMessage(p, "", "§cClick here to Buy '§7§lHot Wing§c' (§f§l1000 Coins§c)", "show_text", "run_command", "§cBuy '§7§lHot Wing§c'", "/mgbuykit HotWing");
		}
		if(kit.equals("Chicken Warrior")){
			p.sendMessage("§e Ability: §7(§f§lKnock Knock§7)");
			p.sendMessage("   §e§oKnocks up and damages nearby players.");
			p.sendMessage("   §eCooldown: §78 Seconds");
			p.sendMessage("   §eDamage: §75");
			p.sendMessage("");
			p.sendMessage("§e Taken Knockback: §7105%");
			p.sendMessage("§e Damage Taken: §790%");
			p.sendMessage("§e Damage: §71");
			p.sendMessage("§e Potion Effect: §7Slowness 3");
			p.sendMessage("");
			ComponentMessageManager.sendComponentMessage(p, "", "§cClick here to Buy '§7§lChicken Warrior§c' (§f§l1000 Coins§c)", "show_text", "run_command", "§cBuy '§7§lChicken Warrior§c'", "/mgbuykit ChickenWarrior");
		}
		p.sendMessage("");
		p.sendMessage("§e§l§m###############################");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		
	}
	
	public static void giveReward(Player p, int arena){
		
		try{
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			int i = 0;
	
			p.sendMessage("§c§l§m###############################");
			p.sendMessage("");
			p.sendMessage("                §f§l Chicken Fight");
			p.sendMessage("");
			if(StorageManager.chickenfightwinner.get(arena) == p){
				p.sendMessage("§f§l +10 §7(Won Game)");
				i = i + 10;
			}
			p.sendMessage("§f§l +5 §7(Patient)");
			i = i + 5;
			if(StorageManager.chickenfightroundkills.get(p) != 0){
				if(StorageManager.chickenfightroundkills.get(p) == 1){
					p.sendMessage("§f§l +" + (StorageManager.chickenfightroundkills.get(p) * 2) + " §7(" + StorageManager.chickenfightroundkills.get(p) + " Kill)");
					i = i + StorageManager.chickenfightroundkills.get(p);
				}
				else{
					p.sendMessage("§f§l +" + (StorageManager.chickenfightroundkills.get(p) * 2) + " §7(" + StorageManager.chickenfightroundkills.get(p) + " Kills)");
					i = i + (StorageManager.chickenfightroundkills.get(p) * 2);
				}
			}
			int sR = (int) StorageManager.chickenfightroundsecondssurvived.get(p) / 25;
			if(sR != 0){
				p.sendMessage("§f§l +" + sR + " §7(Survived " + StorageManager.chickenfightroundsecondssurvived.get(p) + "s)");
				i = i + sR;
			}
			if(StorageManager.chickenfightboostermultiply.get(arena) != 0){
				p.sendMessage("§f§l +" + i * StorageManager.chickenfightboostermultiply.get(arena) + " §b(Game Effect Booster " + StorageManager.chickenfightboostermultiply.get(arena) + "00%)");
				i = i * StorageManager.chickenfightboostermultiply.get(arena);
			}

			DatabaseManager.addMiniGameCoins(p, i);
			
			p.sendMessage("");
			p.sendMessage("§c§l§m###############################");	
		}catch(Exception ex){
			
		}
		
	}
	
	public static void teleportToArena(Player p, int arena){
		if(StorageManager.playersgame.containsKey(p)){
			if(StorageManager.playersarena.get(p).equals(arena)){
				String map = StorageManager.chickenfightcurrentmap.get(arena);
				if(StorageManager.playersinchickenfight.contains(p)){//TODO
				
					int max = StorageManager.chickenfightspawnamount.get(map);
		
					spawns.put(arena, spawns.get(arena) +1);
			
					if(spawns.get(arena) == max){
						spawns.put(arena, 1);
					}
					Location l = StorageManager.chickenfightspawnlocations.get(map + spawns.get(arena));
					p.teleport(l);
				}
				else{
					Location l = StorageManager.chickenfightspectatorlocation.get(map);
					p.teleport(l);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startWarmup(int arena){
		StorageManager.chickenfightstate.put(arena, ChickenFightState.WARMUP);
		
		String map = StorageManager.chickenfightcurrentmap.get(arena);
		String builder = StorageManager.chickenfightbuiltby.get(map);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinchickenfight.contains(p)){
				
				if(StorageManager.playersarena.get(p).equals(arena)){
					p.setHealth(20D);
					teleportToArena(p, arena);
					p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
					
					Start.clearInventory(p);
					p.updateInventory();
					
					p.sendMessage("§c§l§m###############################");
					p.sendMessage("");
					p.sendMessage("                §f§l Chicken Fight");
					p.sendMessage("");
					p.sendMessage("§a§o Kill all enemies or knock them into the void!");
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
	}
	
	@SuppressWarnings("deprecation")
	public static void prepareStart(int arena){
		StorageManager.chickenfightstate.put(arena, ChickenFightState.LASTSECONDS);
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinchickenfight.contains(p)){
				
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
		StorageManager.chickenfightstate.put(arena, ChickenFightState.INGAME);
		StorageManager.chickenfightminutes.put(arena, 20);
		StorageManager.chickenfightseconds.put(arena, 0);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersinchickenfight.contains(p)){
				
				if(StorageManager.playersarena.get(p).equals(arena)){
				
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					
					if(StorageManager.chickenfightkit.get(p).equals("None") || StorageManager.chickenfightkit.get(p).equals("Chicken Mama")){
						StorageManager.chickenfightkit.put(p, "Chicken Mama");
						ChickenMama.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, false, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Baby Chicken")){
						BabyChicken.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, false, false, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Hot Wing")){
						HotWing.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.CHICKEN, true, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					if(StorageManager.chickenfightkit.get(p).equals("Chicken Warrior")){
						ChickenWarrior.giveInventory(p);
						DisguisePlayer.disguisePlayer(p, EntityType.IRON_GOLEM, false, true, true, p.getName(), Bukkit.getOnlinePlayers());
					}
					p.setLevel(0);
					p.setExp(1);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 5, 1);
					p.getInventory().setHeldItemSlot(0);
					
				}	
			}
		}
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
		
	    StorageManager.playersgame.put(p, Game.CHICKENFIGHT);
	    StorageManager.playersarena.put(p, arena);
	    
	    // Default Kit
	    StorageManager.kitchickenmama.put(p, false);
	    
		if(StorageManager.kitbabychicken.containsKey(p.getName())){
			StorageManager.kitbabychicken.put(p, false);
		}
		if(StorageManager.kithotwing.containsKey(p.getName())){
			StorageManager.kithotwing.put(p, false);
		}
		if(StorageManager.kitchickenwarrior.containsKey(p.getName())){
			StorageManager.kitchickenwarrior.put(p, false);
		}
	    
		if(StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.LOBBY) || StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.LASTSECONDS)){
			
			StorageManager.playersinchickenfight.add(p);
			StorageManager.chickenfightroundkills.put(p, 0);
			StorageManager.chickenfightroundsecondssurvived.put(p, 0);
			StorageManager.chickenfightplayers.put(arena, StorageManager.chickenfightplayers.get(arena) +1);
			StorageManager.chickenfightkit.put(p, "None");
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oChickenFight " + arena + "§2§o)");
						}
					}
				}
			}
			
			p.teleport(StorageManager.chickenfightlobbylocation.get(arena));
			LobbyKit.giveInventory(p);
		}
		else{
			StorageManager.spectatorsinchickenfight.add(p);
			StorageManager.chickenfightspectators.put(arena, StorageManager.chickenfightspectators.get(arena) +1);
			StorageManager.chickenfightroundkills.put(p, 0);
			StorageManager.chickenfightroundsecondssurvived.put(p, 0);

			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersgame.containsKey(player)){
					if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oChickenFight " + arena + "§2§o) §c§o[Spectator]");
						}
					}
				}
			}
		    p.teleport(StorageManager.chickenfightspectatorlocation.get(StorageManager.chickenfightcurrentmap.get(arena)));
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
		if(StorageManager.playersinchickenfight.contains(p)){
			StorageManager.playersinchickenfight.remove(p);
			StorageManager.chickenfightplayers.put(arena, StorageManager.chickenfightplayers.get(arena) -1);
			StorageManager.chickenfightroundkills.remove(p);
			StorageManager.chickenfightkit.remove(p);
			
			if(StorageManager.chickenfightstate.get(arena) != ChickenFightState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersgame.get(player) == Game.CHICKENFIGHT){
							if(StorageManager.playersarena.get(player).equals(arena)){
								player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oChickenFight " + arena + "§4§o)");
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
			
			//Default Kit
			StorageManager.kitchickenmama.put(p, false);
		    
			if(StorageManager.kitbabychicken.containsKey(p.getName())){
				StorageManager.kitbabychicken.put(p, false);
			}
			if(StorageManager.kithotwing.containsKey(p.getName())){
				StorageManager.kithotwing.put(p, false);
			}
			if(StorageManager.kitchickenwarrior.containsKey(p.getName())){
				StorageManager.kitchickenwarrior.put(p, false);
			}
			StorageManager.chickenfightkit.put(p, "None");
			p.setLevel(0);
			p.setExp(0);
			
			if(StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.INGAME) || StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.WARMUP)){
				if(StorageManager.chickenfightplayers.get(arena) == 1){
					endGame(arena);
				}
			}
			
			MiniGamesLobbyKit.giveInventory(p, true);
		}
		if(StorageManager.spectatorsinchickenfight.contains(p)){
			
			if(StorageManager.chickenfightstate.get(arena) != ChickenFightState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersarena.get(player).equals(arena)){
							player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oChickenFight " + arena + "§4§o) §c§o[Spectator]");
							p.showPlayer(player);
							player.showPlayer(p);
						}
					}
				}
			}
		    StorageManager.playersgame.remove(p);
		    StorageManager.playersarena.remove(p);
			StorageManager.spectatorsinchickenfight.remove(p);
			StorageManager.chickenfightspectators.put(arena, StorageManager.chickenfightspectators.get(arena) -1);
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		if(StorageManager.deadplayersinchickenfight.contains(p)){
			StorageManager.deadplayersinchickenfight.remove(p);
		}
		if(StorageManager.usedeffectinchickenfight.contains(p)){
			StorageManager.usedeffectinchickenfight.remove(p);
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
	
	public static void spawnCountdownWord(World w, int arena){
		if(StorageManager.chickenfightplayers.get(arena) >= 2){
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.chickenfightseconds.get(arena) -1, true);
		}
		else{
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.chickenfightseconds.get(arena) -1, false);
		}
	}
	
	public static void spawnMapWord(World w, int arena){
		
		if(StorageManager.chickenfightcurrentmap.get(arena).equals("Lava Island")){
			TextManager.createLavaIslandWord(new Location(w, -41, 70, 32));
		}
		if(StorageManager.chickenfightcurrentmap.get(arena).equals("Gladiator Arena")){
			TextManager.createHerobrinesTrainingWord(new Location(w, -41, 70, 40));
		}
		if(StorageManager.chickenfightcurrentmap.get(arena).equals("The Netherlands")){
			TextManager.createTheNetherlandsWord(new Location(w, -41, 70, 40));
		}
	}
	
	public static void spawnGameWord(World w, int arena){
		TextManager.createChickenFightWord(new Location(w, 42, 70, -29));
	}
	
	public static String getRandomMap(int arena){
		
		Random r = new Random();
		
		List<String> maps = new ArrayList<String>();
		
		for(String s : ConfigManager.chickenfight.getConfigurationSection("ChickenFightMaps").getKeys(false)){
			if(!StorageManager.chickenfightcurrentmap.containsValue(s)){
				maps.add(s);
			}
		}
		String map = maps.get(r.nextInt(maps.size()));
		
		return map;
	}
	
	public static void startArenaData(int arena){
		
		StorageManager.chickenfightminutes.put(arena, 1);
		StorageManager.chickenfightseconds.put(arena, 0);
		
		StorageManager.chickenfightgameeffectspeed.put(arena, false);
		StorageManager.chickenfightgameeffectblindness.put(arena, false);
		StorageManager.chickenfightgameeffectjump.put(arena, false);
		
		StorageManager.chickenfightboostermultiply.put(arena, 0);
		
		StorageManager.chickenfightwinner.put(arena, null);
		
		StorageManager.chickenfightplayers.put(arena, 0);
		StorageManager.chickenfightspectators.put(arena, 0);
		StorageManager.chickenfightplayersdied.put(arena, 0);
	
		if(StorageManager.chickenfightcurrentmap.containsKey(arena)){
			StorageManager.chickenfightcurrentmap.remove(arena);
		}
		StorageManager.chickenfightcurrentmap.put(arena, getRandomMap(arena));
		
		StorageManager.chickenfightstate.put(arena, ChickenFightState.LOBBY);
		spawns.put(arena, 0);
	}
	
	public static void registerArenaData(int arena){
		
		if(isArenaEnabled(arena) == true){
			StorageManager.chickenfightenabled.put(arena, true);
		}
		else{
			StorageManager.chickenfightenabled.put(arena, false);
		}
		StorageManager.chickenfightlobbylocation.put(arena, getArenaLobbyLocation(arena));
		
		startArenaData(arena);
	}
	
	public static void registerMapData(String map){
		
		StorageManager.chickenfightspawnamount.put(map, getMapSpawnsAmount(map));
		int i = 0;
		for(Location l : getMapSpawnLocations(map)){
			i++;
			StorageManager.chickenfightspawnlocations.put(map + i, l);
		}
		StorageManager.chickenfightspectatorlocation.put(map, getMapSpectatorLocation(map));
		StorageManager.chickenfightbuiltby.put(map, getMapBuilder(map));
	}
	
	public static void setArenaEnabled(int arena){
		
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".Enabled", true);
		ConfigManager.saveChickenFight();
		
	}
	
	public static void setArenaDisabled(int arena){
		
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".Enabled", false);
		ConfigManager.saveChickenFight();
		
	}
	
	public static boolean isArenaEnabled(int arena){
		
		boolean bl = ConfigManager.chickenfight.getBoolean("ChickenFightArenas." + arena + ".Enabled");
		
		return bl;
	}
	
	public static void setArenaLobbyLocation(int arena, Location l){
		
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.world", l.getWorld().getName());
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.x", l.getX());
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.y", l.getY());
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.z", l.getZ());
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.yaw", l.getYaw());
		ConfigManager.chickenfight.set("ChickenFightArenas." + arena + ".LobbyLocation.pitch", l.getPitch());
		ConfigManager.saveChickenFight();
		
	}
	
	public static Location getArenaLobbyLocation(int arena){
		
		World w = Bukkit.getWorld(ConfigManager.chickenfight.getString("ChickenFightArenas." + arena + ".LobbyLocation.world"));
		double x = ConfigManager.chickenfight.getDouble("ChickenFightArenas." + arena + ".LobbyLocation.x");
		double y = ConfigManager.chickenfight.getDouble("ChickenFightArenas." + arena + ".LobbyLocation.y");
		double z = ConfigManager.chickenfight.getDouble("ChickenFightArenas." + arena + ".LobbyLocation.z");
		float yaw = ConfigManager.chickenfight.getInt("ChickenFightArenas." + arena + ".LobbyLocation.yaw");
		float pitch = ConfigManager.chickenfight.getInt("ChickenFightArenas." + arena + ".LobbyLocation.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		
		return l;
	}
	
	public static void setMapSpawnsAmount(String map, int amount){
		
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpawnsAmount", amount);		
		ConfigManager.saveChickenFight();
		
	}
	
	public static int getMapSpawnsAmount(String map){
		
		int i = ConfigManager.chickenfight.getInt("ChickenFightMaps." + map + ".SpawnsAmount");
		
		return i;
	}
	
	public static void setMapSpectatorLocation(String map, Location l){
		
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.world", l.getWorld().getName());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.x", l.getX());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.y", l.getY());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.z", l.getZ());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.yaw", l.getYaw());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".SpectatorLocation.pitch", l.getPitch());
		ConfigManager.saveChickenFight();
		
	}
	
	public static Location getMapSpectatorLocation(String map){
		
		World w = Bukkit.getWorld(ConfigManager.chickenfight.getString("ChickenFightMaps." + map + ".SpectatorLocation.world"));
		double x = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".SpectatorLocation.x");
		double y = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".SpectatorLocation.y");
		double z = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".SpectatorLocation.z");
		float yaw = ConfigManager.chickenfight.getInt("ChickenFightMaps." + map + ".SpectatorLocation.yaw");
		float pitch = ConfigManager.chickenfight.getInt("ChickenFightMaps." + map + ".SpectatorLocation.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		
		return l;
	}
	
	public static void setMapSpawnLocation(String map, Location l, int number){
		
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".world", l.getWorld().getName());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".x", l.getX());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".y", l.getY());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".z", l.getZ());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".yaw", l.getYaw());
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".Spawns." + number +".pitch", l.getPitch());
		ConfigManager.saveChickenFight();
		
	}
	
	public static List<Location> getMapSpawnLocations(String map){
		
		List<Location> list = new ArrayList<Location>();
		
		for(String s : ConfigManager.chickenfight.getConfigurationSection("ChickenFightMaps." + map + ".Spawns").getKeys(false)){
			
			int i = Integer.parseInt(s);
			
			World w = Bukkit.getWorld(ConfigManager.chickenfight.getString("ChickenFightMaps." + map + ".Spawns." + i + ".world"));
			double x = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".Spawns." + i + ".x");
			double y = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".Spawns." + i + ".y");
			double z = ConfigManager.chickenfight.getDouble("ChickenFightMaps." + map + ".Spawns." + i + ".z");
			float yaw = ConfigManager.chickenfight.getInt("ChickenFightMaps." + map + ".Spawns." + i + ".yaw");
			float pitch = ConfigManager.chickenfight.getInt("ChickenFightMaps." + map + ".Spawns." + i + ".pitch");
		
			Location l = new Location(w, x, y, z, yaw, pitch);
			list.add(l);
		}
		
		return list;
	}
	
	public static void setMapBuilder(String map, String builder){	
		
		ConfigManager.chickenfight.set("ChickenFightMaps." + map + ".BuiltBy", builder);
		ConfigManager.saveChickenFight();
		
	}
	
	public static String getMapBuilder(String map){	
		
		String s = ConfigManager.chickenfight.getString("ChickenFightMaps." + map + ".BuiltBy");
		
		return s;
	}
}
