package me.O_o_Fadi_o_O.MiniGames.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.AgeableWatcher;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ChickenFight {

	/*
	 * 
	 * Game Managing:
	 * 
	 */
	
	public static HashMap<Integer, Integer> spawns = new HashMap<Integer, Integer>();
	
	public static void endGame(int arena){
		
		if(StorageManager.ChickenFightPlayers.get(arena) == 1){
			
			Player p1 = null;
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.PlayersGame.containsKey(player)){
					if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							if(StorageManager.PlayersInChickenFight.contains(player)){
								p1 = player;
							}
							else{
								if(StorageManager.DeadPlayersInChickenFight.contains(player)){
									player.sendMessage("§7Stats §6| §2§l+ 1 Lose");
									try {
										DatabaseManager.addChickenFightLoses(player, 1);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.PlayersGame.containsKey(player)){
					if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
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
			
			StorageManager.ChickenFightWinner.put(arena, p1);
			StorageManager.ChickenFightState.put(arena, ChickenFightState.ENDING);
			
			p1.sendMessage("§7Stats §6| §2§l+ 1 Win");
			try {
				DatabaseManager.addChickenFightWins(p1, 1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			
			for(Player p : Bukkit.getOnlinePlayers()){
				if(StorageManager.PlayersGame.containsKey(p)){
					if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
						if(StorageManager.PlayersArena.get(p).equals(arena)){
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
			
			StorageManager.ChickenFightState.put(arena, ChickenFightState.ENDING);
		}
	}
	
	public static void selectKit(Player p, String kit){
		
		StorageManager.ChickenFightKit.put(p, kit);
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
			StorageManager.KitChickenMama.put(p.getName(), true);
			if(StorageManager.KitBabyChicken.containsKey(p.getName())){
				StorageManager.KitBabyChicken.put(p.getName(), false);
			}
			if(StorageManager.KitHotWing.containsKey(p.getName())){
				StorageManager.KitHotWing.put(p.getName(), false);
			}
			if(StorageManager.KitChickenWarrior.containsKey(p.getName())){
				StorageManager.KitChickenWarrior.put(p.getName(), false);
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
			StorageManager.KitBabyChicken.put(p.getName(), true);
			if(StorageManager.KitChickenMama.containsKey(p.getName())){
				StorageManager.KitChickenMama.put(p.getName(), false);
			}
			if(StorageManager.KitHotWing.containsKey(p.getName())){
				StorageManager.KitHotWing.put(p.getName(), false);
			}
			if(StorageManager.KitChickenWarrior.containsKey(p.getName())){
				StorageManager.KitChickenWarrior.put(p.getName(), false);
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
			StorageManager.KitHotWing.put(p.getName(), true);
			if(StorageManager.KitBabyChicken.containsKey(p.getName())){
				StorageManager.KitBabyChicken.put(p.getName(), false);
			}
			if(StorageManager.KitChickenMama.containsKey(p.getName())){
				StorageManager.KitChickenMama.put(p.getName(), false);
			}
			if(StorageManager.KitChickenWarrior.containsKey(p.getName())){
				StorageManager.KitChickenWarrior.put(p.getName(), false);
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
			StorageManager.KitChickenWarrior.put(p.getName(), true);
			if(StorageManager.KitBabyChicken.containsKey(p.getName())){
				StorageManager.KitBabyChicken.put(p.getName(), false);
			}
			if(StorageManager.KitHotWing.containsKey(p.getName())){
				StorageManager.KitHotWing.put(p.getName(), false);
			}
			if(StorageManager.KitChickenMama.containsKey(p.getName())){
				StorageManager.KitChickenMama.put(p.getName(), false);
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
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lBaby Chicken§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lBaby Chicken§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit BabyChicken\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
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
			p.sendMessage("");
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lHot Wing§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lHot Wing§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit HotWing\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
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
			p.sendMessage("");
			{
				IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\" \",\"extra\":[{\"text\":\"§cClick here to Buy '§7§lChicken Warrior§c' (§f§l1000 Coins§c)\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§cBuy '§7§lChickenWarrior§c'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mgbuykit ChickenWarrior\"}}]}");
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
			}
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
			if(StorageManager.ChickenFightWinner.get(arena) == p){
				p.sendMessage("§f§l +10 §7(Won Game)");
				i = i + 10;
			}
			p.sendMessage("§f§l +5 §7(Patient)");
			i = i + 5;
			if(StorageManager.ChickenFightRoundKills.get(p) != 0){
				if(StorageManager.ChickenFightRoundKills.get(p) == 1){
					p.sendMessage("§f§l +" + (StorageManager.ChickenFightRoundKills.get(p) * 2) + " §7(" + StorageManager.ChickenFightRoundKills.get(p) + " Kill)");
					i = i + StorageManager.ChickenFightRoundKills.get(p);
				}
				else{
					p.sendMessage("§f§l +" + (StorageManager.ChickenFightRoundKills.get(p) * 2) + " §7(" + StorageManager.ChickenFightRoundKills.get(p) + " Kills)");
					i = i + (StorageManager.ChickenFightRoundKills.get(p) * 2);
				}
			}
			int sR = (int) StorageManager.ChickenFightRoundSecondsSurvived.get(p) / 25;
			if(sR != 0){
				p.sendMessage("§f§l +" + sR + " §7(Survived " + StorageManager.ChickenFightRoundSecondsSurvived.get(p) + "s)");
				i = i + sR;
			}
			if(StorageManager.ChickenFightBoosterMultiply.get(arena) != 0){
				p.sendMessage("§f§l +" + i * StorageManager.ChickenFightBoosterMultiply.get(arena) + " §b(Game Effect Booster " + StorageManager.ChickenFightBoosterMultiply.get(arena) + "00%)");
				i = i * StorageManager.ChickenFightBoosterMultiply.get(arena);
			}
			try {
				DatabaseManager.addMiniGameCoins(p, i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			p.sendMessage("");
			p.sendMessage("§c§l§m###############################");	
		}catch(Exception ex){
			
		}
		
	}
	
	public static void teleportToArena(Player p, int arena){
		if(StorageManager.PlayersGame.containsKey(p)){
			if(StorageManager.PlayersArena.get(p).equals(arena)){
				String map = StorageManager.ChickenFightCurrentMap.get(arena);
				if(StorageManager.PlayersInChickenFight.contains(p)){//TODO
				
					int max = StorageManager.ChickenFightSpawnAmount.get(map);
		
					spawns.put(arena, spawns.get(arena) +1);
			
					if(spawns.get(arena) == max){
						spawns.put(arena, 1);
					}
					Location l = StorageManager.ChickenFightSpawnLocations.get(map + spawns.get(arena));
					p.teleport(l);
				}
				else{
					Location l = StorageManager.ChickenFightSpectatorLocation.get(map);
					p.teleport(l);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startWarmup(int arena){
		StorageManager.ChickenFightState.put(arena, ChickenFightState.WARMUP);
		
		String map = StorageManager.ChickenFightCurrentMap.get(arena);
		String builder = StorageManager.ChickenFightBuiltBy.get(map);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.PlayersInChickenFight.contains(p)){
				
				if(StorageManager.PlayersArena.get(p).equals(arena)){
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
	
	public static void prepareStart(int arena){
		StorageManager.ChickenFightState.put(arena, ChickenFightState.LASTSECONDS);
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.PlayersInChickenFight.contains(p)){
				
				if(StorageManager.PlayersArena.get(p).equals(arena)){
					
					if(PlayerManager.isPetActive(p)){
						PlayerManager.removePet(p, "§7Pet");
					}
					if(PlayerManager.hasWardrobeArmor(p)){
						PlayerManager.removeWardrobeArmor(p);
					}
					if(PlayerManager.isDisguised(p)){
						PlayerManager.removeDisguise(p);
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
					if(StorageManager.ownerpets.containsKey(p)){
						
						for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
							if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
								if(en instanceof LivingEntity){
									en.remove();
									StorageManager.owners.remove(StorageManager.ownerpets.get(p));
									StorageManager.ownerpets.remove(p);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void startGame(int arena){
		StorageManager.ChickenFightState.put(arena, ChickenFightState.INGAME);
		StorageManager.ChickenFightMinutes.put(arena, 20);
		StorageManager.ChickenFightSeconds.put(arena, 0);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.PlayersInChickenFight.contains(p)){
				
				if(StorageManager.PlayersArena.get(p).equals(arena)){
				
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					
					if(StorageManager.ChickenFightKit.get(p).equals("None") || StorageManager.ChickenFightKit.get(p).equals("Chicken Mama")){
						StorageManager.ChickenFightKit.put(p, "Chicken Mama");
						ChickenMama.giveInventory(p);
						MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
						mob.setViewSelfDisguise(true);
						FlagWatcher watcher = mob.getWatcher();
						((LivingWatcher) watcher).setCustomName(p.getName());
						((LivingWatcher) watcher).setCustomNameVisible(true);
						DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
					}
					if(StorageManager.ChickenFightKit.get(p).equals("Baby Chicken")){
						BabyChicken.giveInventory(p);
						MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
						mob.setViewSelfDisguise(true);
						FlagWatcher watcher = mob.getWatcher();
						((LivingWatcher) watcher).setCustomName(p.getName());
						((LivingWatcher) watcher).setCustomNameVisible(true);
						((AgeableWatcher) watcher).setBaby();
						DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
					}
					if(StorageManager.ChickenFightKit.get(p).equals("Hot Wing")){
						HotWing.giveInventory(p);
						MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
						mob.setViewSelfDisguise(true);
						FlagWatcher watcher = mob.getWatcher();
						((LivingWatcher) watcher).setCustomName(p.getName());
						((LivingWatcher) watcher).setCustomNameVisible(true);
						((LivingWatcher) watcher).setBurning(true);
						DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
					}
					if(StorageManager.ChickenFightKit.get(p).equals("Chicken Warrior")){
						ChickenWarrior.giveInventory(p);
						MobDisguise mob = new MobDisguise(DisguiseType.IRON_GOLEM);
						mob.setViewSelfDisguise(true);
						FlagWatcher watcher = mob.getWatcher();
						((LivingWatcher) watcher).setCustomName(p.getName());
						((LivingWatcher) watcher).setCustomNameVisible(true);
						DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
					}
					p.setLevel(0);
					p.setExp(1);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 5, 1);
					p.getInventory().setHeldItemSlot(0);
					
				}	
			}
		}
	}
	
	public static void joinArena(Player p, int arena){
		if(PlayerManager.isPetActive(p)){
			PlayerManager.removePet(p, "§7Pet");
		}
		if(PlayerManager.isDisguised(p)){
			PlayerManager.removeDisguise(p);
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
		
	    StorageManager.PlayersGame.put(p, Game.CHICKENFIGHT);
	    StorageManager.PlayersArena.put(p, arena);
	    
	    // Default Kit
	    StorageManager.KitChickenMama.put(p.getName(), false);
	    
		if(StorageManager.KitBabyChicken.containsKey(p.getName())){
			StorageManager.KitBabyChicken.put(p.getName(), false);
		}
		if(StorageManager.KitHotWing.containsKey(p.getName())){
			StorageManager.KitHotWing.put(p.getName(), false);
		}
		if(StorageManager.KitChickenWarrior.containsKey(p.getName())){
			StorageManager.KitChickenWarrior.put(p.getName(), false);
		}
	    
		if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LOBBY) || StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LASTSECONDS)){
			
			StorageManager.PlayersInChickenFight.add(p);
			StorageManager.ChickenFightRoundKills.put(p, 0);
			StorageManager.ChickenFightRoundSecondsSurvived.put(p, 0);
			StorageManager.ChickenFightPlayers.put(arena, StorageManager.ChickenFightPlayers.get(arena) +1);
			StorageManager.ChickenFightKit.put(p, "None");
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.PlayersGame.containsKey(player)){
					if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oChickenFight " + arena + "§2§o)");
						}
					}
				}
			}
			
			p.teleport(StorageManager.ChickenFightLobbyLocation.get(arena));
			LobbyKit.giveInventory(p);
		}
		else{
			StorageManager.SpectatorsInChickenFight.add(p);
			StorageManager.ChickenFightSpectators.put(arena, StorageManager.ChickenFightSpectators.get(arena) +1);
			StorageManager.ChickenFightRoundKills.put(p, 0);
			StorageManager.ChickenFightRoundSecondsSurvived.put(p, 0);

			for(Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.PlayersGame.containsKey(player)){
					if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oChickenFight " + arena + "§2§o) §c§o[Spectator]");
						}
					}
				}
			}
		    p.teleport(StorageManager.ChickenFightSpectatorLocation.get(StorageManager.ChickenFightCurrentMap.get(arena)));
		    ((CraftPlayer) p).getHandle().setInvisible(true);
		    SpectatorKit.giveInventory(p);
			p.setAllowFlight(true);
			p.setFlying(true);
		}
	}
	
	public static void leaveArena(Player p, int arena){
		if(PlayerManager.isPetActive(p)){
			PlayerManager.removePet(p, "§7Pet");
		}
		if(PlayerManager.isDisguised(p)){
			PlayerManager.removeDisguise(p);
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
		if(StorageManager.PlayersInChickenFight.contains(p)){
			StorageManager.PlayersInChickenFight.remove(p);
			StorageManager.ChickenFightPlayers.put(arena, StorageManager.ChickenFightPlayers.get(arena) -1);
			StorageManager.ChickenFightRoundKills.remove(p);
			StorageManager.ChickenFightKit.remove(p);
			
			if(StorageManager.ChickenFightState.get(arena) != ChickenFightState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersGame.get(player) == Game.CHICKENFIGHT){
							if(StorageManager.PlayersArena.get(player).equals(arena)){
								player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oChickenFight " + arena + "§4§o)");
								p.showPlayer(player);
								player.showPlayer(p);
							}
						}
					}
				}
			}
			
		    StorageManager.PlayersGame.remove(p);
		    StorageManager.PlayersArena.remove(p);
			
			p.setAllowFlight(false);
			p.setFlying(false);
			
			//Default Kit
			StorageManager.KitChickenMama.put(p.getName(), false);
		    
			if(StorageManager.KitBabyChicken.containsKey(p.getName())){
				StorageManager.KitBabyChicken.put(p.getName(), false);
			}
			if(StorageManager.KitHotWing.containsKey(p.getName())){
				StorageManager.KitHotWing.put(p.getName(), false);
			}
			if(StorageManager.KitChickenWarrior.containsKey(p.getName())){
				StorageManager.KitChickenWarrior.put(p.getName(), false);
			}
			StorageManager.ChickenFightKit.put(p, "None");
			p.setLevel(0);
			p.setExp(0);
			
			if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.INGAME) || StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.WARMUP)){
				if(StorageManager.ChickenFightPlayers.get(arena) == 1){
					endGame(arena);
				}
			}
			
			MiniGamesLobbyKit.giveInventory(p);
		}
		if(StorageManager.SpectatorsInChickenFight.contains(p)){
			
			if(StorageManager.ChickenFightState.get(arena) != ChickenFightState.ENDING){
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oChickenFight " + arena + "§4§o) §c§o[Spectator]");
							p.showPlayer(player);
							player.showPlayer(p);
						}
					}
				}
			}
		    StorageManager.PlayersGame.remove(p);
		    StorageManager.PlayersArena.remove(p);
			StorageManager.SpectatorsInChickenFight.remove(p);
			StorageManager.ChickenFightSpectators.put(arena, StorageManager.ChickenFightSpectators.get(arena) -1);
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		if(StorageManager.DeadPlayersInChickenFight.contains(p)){
			StorageManager.DeadPlayersInChickenFight.remove(p);
		}
		if(StorageManager.UsedEffectInChickenFight.contains(p)){
			StorageManager.UsedEffectInChickenFight.remove(p);
		}
		Start.teleportToLobby(p);
		Start.clearInventory(p);
		MiniGamesLobbyKit.giveInventory(p);
	}
	
	/*
	 * 
	 * Storing & Saving Data:
	 * 
	 */
	
	public static void spawnCountdownWord(World w, int arena){
		if(StorageManager.ChickenFightPlayers.get(arena) >= 2){
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.ChickenFightSeconds.get(arena) -1, true);
		}
		else{
			TextManager.createCountdownWord(new Location(w, -26, 70, -37), StorageManager.ChickenFightSeconds.get(arena) -1, false);
		}
	}
	
	public static void spawnMapWord(World w, int arena){
		
		if(StorageManager.ChickenFightCurrentMap.get(arena).equals("Lava Island")){
			TextManager.createLavaIslandWord(new Location(w, -41, 70, 32));
		}
		if(StorageManager.ChickenFightCurrentMap.get(arena).equals("Gladiator Arena")){
			TextManager.createHerobrinesTrainingWord(new Location(w, -41, 70, 40));
		}
		if(StorageManager.ChickenFightCurrentMap.get(arena).equals("The Netherlands")){
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
			if(!StorageManager.ChickenFightCurrentMap.containsValue(s)){
				maps.add(s);
			}
		}
		String map = maps.get(r.nextInt(maps.size()));
		
		return map;
	}
	
	public static void startArenaData(int arena){
		
		StorageManager.ChickenFightMinutes.put(arena, 1);
		StorageManager.ChickenFightSeconds.put(arena, 0);
		
		StorageManager.ChickenFightGameEffectSpeed.put(arena, false);
		StorageManager.ChickenFightGameEffectBlindness.put(arena, false);
		StorageManager.ChickenFightGameEffectJump.put(arena, false);
		
		StorageManager.ChickenFightBoosterMultiply.put(arena, 0);
		
		StorageManager.ChickenFightWinner.put(arena, null);
		
		StorageManager.ChickenFightPlayers.put(arena, 0);
		StorageManager.ChickenFightSpectators.put(arena, 0);
		StorageManager.ChickenFightPlayersDied.put(arena, 0);
	
		if(StorageManager.ChickenFightCurrentMap.containsKey(arena)){
			StorageManager.ChickenFightCurrentMap.remove(arena);
		}
		StorageManager.ChickenFightCurrentMap.put(arena, getRandomMap(arena));
		
		StorageManager.ChickenFightState.put(arena, ChickenFightState.LOBBY);
		spawns.put(arena, 0);
	}
	
	public static void registerArenaData(int arena){
		
		if(isArenaEnabled(arena) == true){
			StorageManager.ChickenFightEnabled.put(arena, true);
		}
		else{
			StorageManager.ChickenFightEnabled.put(arena, false);
		}
		StorageManager.ChickenFightLobbyLocation.put(arena, getArenaLobbyLocation(arena));
		
		startArenaData(arena);
	}
	
	public static void registerMapData(String map){
		
		StorageManager.ChickenFightSpawnAmount.put(map, getMapSpawnsAmount(map));
		int i = 0;
		for(Location l : getMapSpawnLocations(map)){
			i++;
			StorageManager.ChickenFightSpawnLocations.put(map + i, l);
		}
		StorageManager.ChickenFightSpectatorLocation.put(map, getMapSpectatorLocation(map));
		StorageManager.ChickenFightBuiltBy.put(map, getMapBuilder(map));
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
