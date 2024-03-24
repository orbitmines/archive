package me.O_o_Fadi_o_O.Hub.events;

import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.DisguisePlayer;
import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.TitleManager;
import me.O_o_Fadi_o_O.Hub.utils.StaffRank;
import me.O_o_Fadi_o_O.Hub.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandPreprocessEvent implements Listener{

	Hub hub = Hub.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreCommand(PlayerCommandPreprocessEvent e){
		
		Player p = e.getPlayer();
	    String[] args = e.getMessage().split(" ");
	    
		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(args[0]);
		if(topic == null){
			if(!args[0].toLowerCase().startsWith("/bukkit:")){
				e.setCancelled(true);
				p.sendMessage("§7Unknown command. Use §6/help§7 for help.");
			}
		}
		
		if(StorageManager.loaded.get(p) == true){
			if(args[0].toLowerCase().startsWith("/mv")){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
					p.sendMessage("§7Unknown command. Use §6/help§7 for help.");
				}
			}
			if(args[0].toLowerCase().startsWith("/pname")){
				e.setCancelled(true);
				
				if(PlayerManager.hasStaffPerms(p, StaffRank.Owner)){
					String uuidstring = args[1];
					
					try{
						String name = Bukkit.getOfflinePlayer(UUID.fromString(uuidstring)).getName();
						
						if(name != null){
							p.sendMessage("§4§lOP §8| §7Offline UUID Offline §6" + uuidstring + "§7 is §6" + name + "§7.");
						}
						else{
							p.sendMessage("§4§lOP §8| §7Invalid Offline UUID.");
						}
					}catch(Exception ex){
						p.sendMessage("§4§lOP §8| §7Invalid Offline UUID.");
					}
				}
				else{
					p.sendMessage("§4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
				}
			}
			if(args[0].toLowerCase().startsWith("/bukkit:")){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
		    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
				}
			}
		    if(args[0].equalsIgnoreCase("/pl") || args[0].equalsIgnoreCase("/plugins")){
		    	e.setCancelled(true);
		    	p.sendMessage("§fPlugins (1): §aHub");
		    }
		    if(args[0].equalsIgnoreCase("/builder")){
		    	if(PlayerManager.hasStaffPerms(p, StaffRank.Builder)){
		    		p.sendMessage("§7Teleporting to the §d§lBuilder World§7...");
		    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " BuilderWorld");
		    		TitleManager.setTitle(p, "", "§d§lBuilder World");
		    	}
		    	else{
		    		p.sendMessage("§4§lDENIED§7! You have to be a §d§lBuilder§7 to do this.");
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/servers")){
		    	e.setCancelled(true);
				if(!StorageManager.playersinlapisparkour.contains(p)){
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(ServerSelector.serverSelector);
				}
			}
		    if(args[0].equalsIgnoreCase("/perks")){
		    	e.setCancelled(true);
				if(!StorageManager.playersinlapisparkour.contains(p)){
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				}
			}
		    if(args[0].equalsIgnoreCase("/opmode")){
		    	e.setCancelled(true);
				if(StorageManager.staffrank.get(p) == StaffRank.Owner){
					if(StorageManager.opmodeenabled.get(p) == true){
						StorageManager.opmodeenabled.put(p, false);
						p.sendMessage("§3§lHub §8| §7Your §4§lOP Mode§7 is now §c§lDISABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					else{
						StorageManager.opmodeenabled.put(p, true);
						p.sendMessage("§3§lHub §8| §7Your §4§lOP Mode§7 is now §a§lENABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
				}
				else{
					p.sendMessage("§3§lHub §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
				}
			}
		    if(args[0].equalsIgnoreCase("/topvoters")){
		    	e.setCancelled(true);
		    	
				int votes1 = 0;
				int votes2 = 0;
				int votes3 = 0;
				int votes4 = 0;
				int votes5 = 0;
				
				UUID uuid1 = null;
				UUID uuid2 = null;
				UUID uuid3 = null;
				UUID uuid4 = null;
				UUID uuid5 = null;
				
				for(UUID uuid : StorageManager.allvoters){
					int votes = StorageManager.votes.get(uuid);
					if(votes >= votes1){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes2;
						votes2 = votes1;
						votes1 = votes;
						
						uuid5 = uuid4;
						uuid4 = uuid3;
						uuid3 = uuid2;
						uuid2 = uuid1;
						uuid1 = uuid;
						
					}
					else if(votes >= votes2){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes2;
						votes2 = votes;
						
						uuid5 = uuid4;
						uuid4 = uuid3;
						uuid3 = uuid2;
						uuid2 = uuid;
					}
					else if(votes >= votes3){
						votes5 = votes4;
						votes4 = votes3;
						votes3 = votes;
						
						uuid5 = uuid4;
						uuid4 = uuid3;
						uuid3 = uuid;
					}
					else if(votes >= votes4){
						votes5 = votes4;
						votes4 = votes;
						
						uuid5 = uuid4;
						uuid4 = uuid;
					}
					else if(votes >= votes5){
						votes5 = votes;
						
						uuid5 = uuid;
					}
					else{}
				}
				
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §b§lTop 5 Voters:");
				if(votes1 == 1){
					p.sendMessage("  §6§l1. §6" + Hub.getPlayerNamefromUUID(uuid1) + " §7| §b" + votes1 + " Vote");
				}
				else{
					if(uuid1 == null){
						p.sendMessage("  §6§l1. §6");
					}
					else{
						p.sendMessage("  §6§l1. §6" + Hub.getPlayerNamefromUUID(uuid1) + " §7| §b" + votes1 + " Votes");
					}
				}
				if(votes2 == 1){
					p.sendMessage("  §6§l1. §6" + Hub.getPlayerNamefromUUID(uuid2) + " §7| §b" + votes2 + " Vote");
				}
				else{
					if(uuid2 == null){
						p.sendMessage("  §7§l2. §7");
					}
					else{
						p.sendMessage("  §7§l2. §7" + Hub.getPlayerNamefromUUID(uuid2) + " §7| §b" + votes2 + " Votes");
					}
				}
				if(votes3 == 1){
					p.sendMessage("  §c§l3. §6" + Hub.getPlayerNamefromUUID(uuid3) + " §7| §b" + votes3 + " Vote");
				}
				else{
					if(uuid3 == null){
						p.sendMessage("  §c§l3. §c");
					}
					else{
						p.sendMessage("  §c§l3. §c" + Hub.getPlayerNamefromUUID(uuid3) + " §7| §b" + votes3 + " Votes");
					}
				}
				if(votes4 == 1){
					p.sendMessage("  §8§l4. §8" + Hub.getPlayerNamefromUUID(uuid4) + " §7| §b" + votes4 + " Vote");
				}
				else{
					if(uuid4 == null){
						p.sendMessage("  §8§l4. §8");
					}
					else{
						p.sendMessage("  §8§l4. §8" + Hub.getPlayerNamefromUUID(uuid4) + " §7| §b" + votes4 + " Votes");
					}
				}
				if(votes5 == 1){
					p.sendMessage("  §8§l5. §8" + Hub.getPlayerNamefromUUID(uuid5) + " §7| §b" + votes5 + " Vote");
				}
				else{
					if(uuid5 == null){
						p.sendMessage("  §8§l5. §8");
					}
					else{
						p.sendMessage("  §8§l5. §8" + Hub.getPlayerNamefromUUID(uuid5) + " §7| §b" + votes5 + " Votes");
					}
				}
		    }
		    if(args[0].equalsIgnoreCase("/afk")){
		    	e.setCancelled(true);
		    	if(PlayerManager.hasVIPPerms(p, VIPRank.Iron_VIP)){
		    		if(StorageManager.afk.containsKey(p)){
		    			if(StorageManager.afk.get(p).equals("")){
		    				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
		    			}
		    			else{
		    				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
		    			}
		    			StorageManager.afk.remove(p);
		    		}
		    		else{
			    		if(args.length == 1){
			    			StorageManager.afk.put(p, "");
			    			Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is now §6AFK§7.");
			    		}
			    		else if(args.length == 2){
				    		if(PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
					    		if(args[1].length() <= 20){
					    			if(PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
						    			String afkmessage = args[1].replaceAll("&a", "§a").replaceAll("&b", "§b").replaceAll("&c", "§c").replaceAll("&d", "§d").replaceAll("&e", "§e").replaceAll("&f", "§f").replaceAll("&0", "§0").replaceAll("&1", "§1").replaceAll("&2", "§2").replaceAll("&3", "§3").replaceAll("&4", "§4").replaceAll("&5", "§5").replaceAll("&6", "§6").replaceAll("&7", "§7").replaceAll("&8", "§8").replaceAll("&9", "§9");
						    			Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is now §6AFK§7. (§7" + afkmessage + "§7)");
						    			StorageManager.afk.put(p, afkmessage);
					    			}
					    			else{
					    				String afkmessage = args[1];
					    				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is now §6AFK§7. (§7" + afkmessage + "§7)");
						    			StorageManager.afk.put(p, afkmessage);
					    			}
					    		}
					    		else{
					    			p.sendMessage("§7Your §6afk text§7 can't be longer than §620 characters§7!");
					    		}
				    		}
				    		else{
				    			p.sendMessage("§4§lDENIED§7! Required: §b§lDiamond VIP§7.");
				    		}
				    	}
				    	else{
				    		p.sendMessage("§7Use §6/afk or /afk <reason>");
				    	}
		    		}
		    	}
		    	else{
		    		p.sendMessage("§4§lDENIED§7! Required: §7§lIron VIP§7.");
		    		p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/nick")){
		    	e.setCancelled(true);
		    	
		    	if(PlayerManager.hasVIPPerms(p, VIPRank.Gold_VIP)){
			    	if(args.length == 2){
			    		if(args[1].length() <= 30){
			    			
			    			if(args[1].equalsIgnoreCase("off")){
			    				p.sendMessage("§7Removed your §6nickname§7!");
			    				StorageManager.nickname.remove(p);
			    			}
			    			else{
				    			if(PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
				    				String newnickname = args[1].replaceAll("&a", "§a").replaceAll("&b", "§b").replaceAll("&c", "§c").replaceAll("&d", "§d").replaceAll("&e", "§e").replaceAll("&f", "§f").replaceAll("&0", "§0").replaceAll("&1", "§1").replaceAll("&2", "§2").replaceAll("&3", "§3").replaceAll("&4", "§4").replaceAll("&5", "§5").replaceAll("&6", "§6").replaceAll("&7", "§7").replaceAll("&8", "§8").replaceAll("&9", "§9").replaceAll("&r", "§r").replaceAll("&k", "§k").replaceAll("&m", "§m").replaceAll("&n", "§n").replaceAll("&l", "§l");
				    				p.sendMessage("§7Changed your §6nickname§7 to '§a" + newnickname + "§7'");
				    				StorageManager.nickname.put(p, newnickname);
				    			}
				    			else if(PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
				    				String newnickname = args[1].replaceAll("&a", "§a").replaceAll("&b", "§b").replaceAll("&c", "§c").replaceAll("&d", "§d").replaceAll("&e", "§e").replaceAll("&f", "§f").replaceAll("&0", "§0").replaceAll("&1", "§1").replaceAll("&2", "§2").replaceAll("&3", "§3").replaceAll("&4", "§4").replaceAll("&5", "§5").replaceAll("&6", "§6").replaceAll("&7", "§7").replaceAll("&8", "§8").replaceAll("&9", "§9");
				    				p.sendMessage("§7Changed your §6nickname§7 to '§9" + newnickname + "§7'");
				    				StorageManager.nickname.put(p, newnickname);
				    			}
				    			else{
				    				p.sendMessage("§7Changed your §6nickname§7 to '§6" + args[1] + "§7'");
				    				StorageManager.nickname.put(p, args[1]);
				    			}
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Your §6nickname§7 can't be longer than §630 characters§7!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§7Use §6/nick <nickname> §7or§6 /nick off");
			    	}
		    	}
		    	else{
		    		p.sendMessage("§4§lDENIED§7! Required: §6§lGold VIP§7.");
		    		p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/disguise") || args[0].equalsIgnoreCase("/d") || args[0].equalsIgnoreCase("/dis")){
		    	e.setCancelled(true);
		    	
		    	if(p.hasPermission("command.disguise") || StorageManager.opmodeenabled.get(p) == true){
			    	if(args.length == 1){
			    		p.sendMessage("§2§lDisguises:");
			    		p.sendMessage("§a§l§oMobs §7(§a/d (player <player>) <mob>§7): §aBat§7, §aBlaze§7, §aArmor_Stand§7, §aCave_Spider§7, §aChicken§7, §aCow§7, §aCreeper§7, §aEnderman§7, §aEnderman§7, §aEndermite§7, §aEnder_Dragon§7, §aGhast§7, §aGiant§7, §aGuardian§7, §aHorse§7, §aIron_Golem§7, §aMagma_Cube§7, §aMushroom_Cow§7, §aOcelot§7, §aPig§7, §aPig_Zombie§7, §aRabbit§7, §aSheep§7, §aSilverfish§7, §aSkeleton§7, §aSlime§7, §aSnowman§7, §aSpider§7, §aSquid§7, §aVillager§7, §aWitch§7, §aWither§7, §aWolf§7, §aZombie");
			    		p.sendMessage("§a§l§oBlocks §7(§a/d (player <player>) block <id>§7)");
			    		p.sendMessage("§a§l§oDisguise Near to Mob §7(§a/d near <radius> <mob>§7)");
			    		p.sendMessage("§a§l§oDisguise Near to Block §7(§a/d near <radius> block <id>§7)");
			    	}
			    	else if(args.length == 2){
			    		if(args[1].equalsIgnoreCase("block")){
			    			p.sendMessage("§7Use §a/disguise block <id>§7.");
			    		}
			    		else{
				    		try{
				    			EntityType type = EntityType.valueOf(args[1].toUpperCase());
				    			
				    			DisguisePlayer.disguisePlayer(p, type, Bukkit.getOnlinePlayers());
				    			p.sendMessage("§7Disguised as: §a" + args[1].toUpperCase() + "§7.");
				    		}
				    		catch(Exception ex){
				    			p.sendMessage("§7Cannot find that §2Disguise§7!");
				    		}
			    		}
			    	}
			    	else if(args.length == 3){
			    		if(args[1].equalsIgnoreCase("block")){
			    			try{
			    				int id = Integer.parseInt(args[2]);
			    				
			    				DisguisePlayer.disguiseAsBlock(p, id, Bukkit.getOnlinePlayers());
			    				p.sendMessage("§7Disguised as: §aBLOCK§7. (§a" + id + "§7)");
			    			}
			    			catch(Exception ex){
			    				p.sendMessage("§6" + args[2] + "§7 isn't a number.");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Cannot find that §2Disguise§7!");
			    		}
			    	}
			    	else if(args.length == 4){
			    		if(args[1].equalsIgnoreCase("player")){
			    			Player p2 = null;
			    			for(Player player : Bukkit.getOnlinePlayers()){
			    				if(player.getName().equalsIgnoreCase(args[2])){
			    					p2 = player;
			    				}
			    			}
			    			
			    			if(p2 != null){
			    				try{
					    			EntityType type = EntityType.valueOf(args[3].toUpperCase());
					    			
					    			DisguisePlayer.disguisePlayer(p2, type, Bukkit.getOnlinePlayers());
					    			p.sendMessage("§7Disguised " + PlayerManager.getPlayerDisplayname(p2) + " §7as: §a" + args[3].toUpperCase() + "§7.");
					    			p2.sendMessage("§7Disguised as: §a" + args[3].toUpperCase() + "§7.");
					    		}
					    		catch(Exception ex){
					    			p.sendMessage("§7Cannot find that §2Disguise§7!");
					    		}
			    			}
			    			else{
			    				p.sendMessage("§7Player §6" + args[2] + " §7isn't §aOnline§7!");
			    			}
			    		}
			    		else if(args[1].equalsIgnoreCase("near")){
			    			try{
			    				int radius = Integer.parseInt(args[2]);
			    				
			    				try{
					    			EntityType type = EntityType.valueOf(args[3].toUpperCase());
					    			
					    			int amount = 1;
					    			
					    			for(Entity en : p.getNearbyEntities(radius, radius, radius)){
					    				if(en instanceof Player){
					    					amount++;
					    					Player player = (Player) en;
					    					DisguisePlayer.disguisePlayer(player, type, Bukkit.getOnlinePlayers());
					    					player.sendMessage("§7Disguised as: §a" + args[3].toUpperCase() + "§7.");
					    				}
					    			}
					    			
			    					DisguisePlayer.disguisePlayer(p, type, Bukkit.getOnlinePlayers());
					    			p.sendMessage("§7Disguised near players (§a" + amount + "§7) §7as: §a" + args[3].toUpperCase() + "§7.");
			    					
					    			p.sendMessage("§7Disguised as: §a" + args[3].toUpperCase() + "§7.");
					    			
					    		}
					    		catch(Exception ex){
					    			p.sendMessage("§7Cannot find that §2Disguise§7!");
					    		}
			    			}
			    			catch(Exception ex){
			    				p.sendMessage("§7That is not a valid radius!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Cannot find that §2Disguise§7!");
			    		}
			    	}
			    	else if(args.length == 5){
			    		if(args[1].equalsIgnoreCase("player")){
			    			Player p2 = null;
			    			for(Player player : Bukkit.getOnlinePlayers()){
			    				if(player.getName().equalsIgnoreCase(args[2])){
			    					p2 = player;
			    				}
			    			}
			    			
			    			if(p2 != null){
			    				if(args[3].equalsIgnoreCase("block")){
					    			try{
					    				int id = Integer.parseInt(args[4]);
					    				
					    				DisguisePlayer.disguiseAsBlock(p2, id, Bukkit.getOnlinePlayers());
					    				p.sendMessage("§7Disguised " + PlayerManager.getPlayerDisplayname(p2) + " §7as: §aBlock§7. (§a" + id + "§7)");
					    				p2.sendMessage("§7Disguised as: §aBLOCK§7. (§a" + id + "§7)");
					    			}
					    			catch(Exception ex){
					    				p.sendMessage("§6" + args[4] + "§7 isn't a number.");
					    			}
					    		}
					    		else{
					    			p.sendMessage("§7Cannot find that §2Disguise§7!");
					    		}
			    			}
			    			else{
			    				p.sendMessage("§7Player §6" + args[2] + " §7isn't §aOnline§7!");
			    			}
			    		}
			    		else if(args[1].equalsIgnoreCase("near")){
			    			try{
			    				int radius = Integer.parseInt(args[2]);
			    				
			    				if(args[3].equalsIgnoreCase("block")){
				    				try{
				    					int id = Integer.parseInt(args[4]);
						    			
						    			int amount = 1;
						    			
						    			for(Entity en : p.getNearbyEntities(radius, radius, radius)){
						    				if(en instanceof Player){
						    					amount++;
						    					Player player = (Player) en;
						    					DisguisePlayer.disguiseAsBlock(player, id, Bukkit.getOnlinePlayers());
						    					player.sendMessage("§7Disguised as: §aBLOCK§7. (§a" + id + "§7)");
						    				}
						    			}
						    			
						    			DisguisePlayer.disguiseAsBlock(p, id, Bukkit.getOnlinePlayers());
						    			p.sendMessage("§7Disguised near players (§a" + amount + "§7) §7as: §aBLOCK§7. (§a" + id + "§7)");
						    			
						    			p.sendMessage("§7Disguised as: §aBLOCK§7. (§a" + id + "§7)");
						    
						    		}
						    		catch(Exception ex){
						    			p.sendMessage("§6" + args[4] + "§7 isn't a number.");
						    		}
			    				}
			    				else{
			    					p.sendMessage("§7Cannot find that §2Disguise§7!");
			    				}
			    			}
			    			catch(Exception ex){
			    				p.sendMessage("§7That is not a valid radius!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Cannot find that §2Disguise§7!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§7Incorrect Use!");
			    	}
		    	}
		    	else{
		    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/undisguise")){
		    	if(p.hasPermission("command.disguise") || StorageManager.opmodeenabled.get(p) == true){
		    		DisguisePlayer.undisguisePlayer(p);
		    		p.sendMessage("§7Removed your §6disguise§7!");
		    	}
		    	else{
		    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/give")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.give.other") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6/give <player> <item> <amount>§7.");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 3){
		    		if(p.hasPermission("command.give.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(args[2].contains(":")){
			    				String[] itemstrings = args[2].split("\\:");
			    				
			    				try{
			    					int durability = Integer.parseInt(itemstrings[1]);
			    					
			    					try{
				    					int id = Integer.parseInt(itemstrings[0]);
				    					
				    					if(p2 == p){
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), 64);
					    						item.setDurability((short) durability);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(Exception ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					else{
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), 64);
					    						item.setDurability((short) durability);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(Exception ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					
				    				}catch(Exception ex){
				    					Material m = null;
				    					
				    					for(Material ma : Material.values()){
				    						if(ma.toString().equalsIgnoreCase(itemstrings[0])){
				    							m = ma;
				    						}
				    						else if(ma.toString().replaceAll("_", "").equalsIgnoreCase(itemstrings[0])){
				    							m = ma;
				    						}
				    						else{}
				    					}
				    					
				    					if(m != null){
					    					if(p2 == p){
					    						ItemStack item = new ItemStack(m, 64);
					    						item.setDurability((short) durability);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
					    					else{
					    						ItemStack item = new ItemStack(m, 64);
					    						item.setDurability((short) durability);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
				    					}
				    					else{
				    						p.sendMessage("§7There's no §6Item§7 with the name §6" + itemstrings[0] + "§7!");
				    					}
				    				}
			    				}
			    				catch(Exception ex){
			    					p.sendMessage("§7The Durability §6" + itemstrings[1] + "§7 isn't a number!");
			    				}
			    			}
			    			else{
			    				try{
			    					int id = Integer.parseInt(args[2]);
			    					
			    					if(p2 == p){
			    						try{
				    						ItemStack item = new ItemStack(Material.getMaterial(id), 64);
				    						p.getInventory().addItem(item);
				    						p.updateInventory();
				    						
						    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
			    						}catch(Exception ex){
			    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
			    						}
			    					}
			    					else{
			    						try{
				    						ItemStack item = new ItemStack(Material.getMaterial(id), 64);
				    						p2.getInventory().addItem(item);
				    						p2.updateInventory();
				    						
						    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
			    						}catch(Exception ex){
			    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
			    						}
			    					}
			    					
			    				}catch(Exception ex){
			    					Material m = null;
			    					
			    					for(Material ma : Material.values()){
			    						if(ma.toString().equalsIgnoreCase(args[2])){
			    							m = ma;
			    						}
			    						else if(ma.toString().replaceAll("_", "").equalsIgnoreCase(args[2])){
			    							m = ma;
			    						}
			    						else{}
			    					}
			    					
			    					if(m != null){
				    					if(p2 == p){
				    						ItemStack item = new ItemStack(m, 64);
				    						p.getInventory().addItem(item);
				    						p.updateInventory();
				    						
						    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    					}
				    					else{
				    						ItemStack item = new ItemStack(m, 64);
				    						p2.getInventory().addItem(item);
				    						p2.updateInventory();
				    						
						    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    					}
			    					}
			    					else{
			    						p.sendMessage("§7There's no §6Item§7 with the name §6" + args[2] + "§7!");
			    					}
			    				}
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 4){
		    		if(p.hasPermission("command.give.other") || StorageManager.opmodeenabled.get(p) == true){
		    			try{
		    				int amount = Integer.parseInt(args[3]);
		    				
				    		Player p2 = null;
				    		
				    		for(Player player : Bukkit.getOnlinePlayers()){
				    			if(player.getName().equalsIgnoreCase(args[1])){
				    				p2 = player;
				    			}
				    		}
				    		
				    		if(p2 != null){
				    			if(args[2].contains(":")){
				    				String[] itemstrings = args[2].split("\\:");
				    				
				    				try{
				    					int durability = Integer.parseInt(itemstrings[1]);
				    					
				    					try{
					    					int id = Integer.parseInt(itemstrings[0]);
					    					
					    					if(p2 == p){
					    						try{
						    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
						    						item.setDurability((short) durability);
						    						p.getInventory().addItem(item);
						    						p.updateInventory();
						    						
								    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    						}catch(Exception ex){
					    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
					    						}
					    					}
					    					else{
					    						try{
						    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
						    						item.setDurability((short) durability);
						    						p2.getInventory().addItem(item);
						    						p2.updateInventory();
						    						
								    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
								    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    						}catch(Exception ex){
					    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
					    						}
					    					}
					    					
					    				}catch(Exception ex){
					    					Material m = null;
					    					
					    					for(Material ma : Material.values()){
					    						if(ma.toString().equalsIgnoreCase(itemstrings[0])){
					    							m = ma;
					    						}
					    						else if(ma.toString().replaceAll("_", "").equalsIgnoreCase(itemstrings[0])){
					    							m = ma;
					    						}
					    						else{}
					    					}
					    					
					    					if(m != null){
						    					if(p2 == p){
						    						ItemStack item = new ItemStack(m, amount);
						    						item.setDurability((short) durability);
						    						p.getInventory().addItem(item);
						    						p.updateInventory();
						    						
								    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    					}
						    					else{
						    						ItemStack item = new ItemStack(m, amount);
						    						item.setDurability((short) durability);
						    						p2.getInventory().addItem(item);
						    						p2.updateInventory();
						    						
								    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
								    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
						    					}
					    					}
					    					else{
					    						p.sendMessage("§7There's no §6Item§7 with the name §6" + itemstrings[0] + "§7!");
					    					}
					    				}
				    				}
				    				catch(Exception ex){
				    					p.sendMessage("§7The Durability §6" + itemstrings[1] + "§7 isn't a number!");
				    				}
				    			}
				    			else{
				    				try{
				    					int id = Integer.parseInt(args[2]);
				    					
				    					if(p2 == p){
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(Exception ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					else{
				    						try{
					    						ItemStack item = new ItemStack(Material.getMaterial(id), amount);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
				    						}catch(Exception ex){
				    							p.sendMessage("§7There's no §6Item§7 with the ID §6" + id + "§7!");
				    						}
				    					}
				    					
				    				}catch(Exception ex){
				    					Material m = null;
				    					
				    					for(Material ma : Material.values()){
				    						if(ma.toString().equalsIgnoreCase(args[2])){
				    							m = ma;
				    						}
				    						else if(ma.toString().replaceAll("_", "").equalsIgnoreCase(args[2])){
				    							m = ma;
				    						}
				    						else{}
				    					}
				    					
				    					if(m != null){
					    					if(p2 == p){
					    						ItemStack item = new ItemStack(m, amount);
					    						p.getInventory().addItem(item);
					    						p.updateInventory();
					    						
							    				p.sendMessage("§7You gave yourself §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
					    					else{
					    						ItemStack item = new ItemStack(m, amount);
					    						p2.getInventory().addItem(item);
					    						p2.updateInventory();
					    						
							    				p.sendMessage("§7You gave " + PlayerManager.getPlayerDisplayname(p2) + " §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
							    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) +"§7 gave you §6§l" + item.getAmount() + " §6" + item.getType().toString().toLowerCase() + "§7!");
					    					}
				    					}
				    					else{
				    						p.sendMessage("§7There's no §6Item§7 with the name §6" + args[2] + "§7!");
				    					}
				    				}
				    			}
				    		}
				    		else{
				    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
				    		}
		    			}
		    			catch(Exception ex){
		    				p.sendMessage("§7The Amount §6" + args[3] + "§7 isn't a Number!");
		    			}
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else{
			    	if(p.hasPermission("command.give.other") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6/give <player> <item> <amount>§7.");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/tp") || args[0].equalsIgnoreCase("/teleport")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.tp") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player1> <player2>");
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player>");
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player> <x> <y> <z>");
		    		}
		    		else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.tp") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 != p){
					    		p.teleport(p2);
					    		p.sendMessage("§7Teleported to " + PlayerManager.getPlayerDisplayname(p2) + "§7!");
			    			}
			    			else{
			    				p.sendMessage("§7You can't §6teleport§7 to yourself!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
		    		}
		    	}
		    	else if(args.length == 3){
		    		if(p.hasPermission("command.tp.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		Player p3 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    			if(player.getName().equalsIgnoreCase(args[2])){
			    				p3 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p3 != null){
						    	p2.teleport(p3);
						    	p.sendMessage("§7Teleported " + PlayerManager.getPlayerDisplayname(p2) + "§7 to " + PlayerManager.getPlayerDisplayname(p3) + "§7!");
			    			}
			    			else{
			    				p.sendMessage("§7Player §6" + args[2] + " §7isn't §aOnline§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
		    		}
		    	}
		    	else if(args.length == 5){
		    		if(p.hasPermission("command.tp.cords") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			
			    			try{
				    			int x = Integer.parseInt(args[2]);
				    			int y = Integer.parseInt(args[3]);
				    			int z = Integer.parseInt(args[4]);
				    			
				    			Location l = new Location(p2.getWorld(), x, y, z);
				    			
						    	p2.teleport(l);
						    	
						    	if(p2 != p){
						    		p.sendMessage("§7Teleported " + PlayerManager.getPlayerDisplayname(p2) + "§7 to §6" + x + "§7, §6" + y + "§7, §6" + z + "§7!");
						    	}
						    	else{
						    		p.sendMessage("§7Teleported yourself to §6" + x + "§7, §6" + y + "§7, §6" + z + "§7!");
						    	}
						    }catch(Exception ex){
			    				p.sendMessage("The Cords aren't Numbers!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
		    		}
		    	}
	    		else{
			    	if(p.hasPermission("command.tp") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player1> <player2>");
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player>");
			    		p.sendMessage("§7Use §6" + args[0].toLowerCase() + " <player> <x> <y> <z>");
		    		}
		    		else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
	    		}
		    }
		    if(args[0].equalsIgnoreCase("/skull")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.skull") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6/skull <player>§7.");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.skull") || StorageManager.opmodeenabled.get(p) == true){
	    				p.sendMessage("§7You gave yourself §6" + args[1] + "'s§7 skull.");

	    				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
	    				SkullMeta meta = (SkullMeta) item.getItemMeta();
	    				meta.setDisplayName("§6" + args[1] + "'s §7Skull");
	    				meta.setOwner(args[1]);
	    				item.setItemMeta(meta);
	    				item.setDurability((short) 3);
	    				
	    				p.getInventory().addItem(item);
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
			    	if(p.hasPermission("command.skull") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6/skull <player>§7.");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/eat") || args[0].equalsIgnoreCase("/feed")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.feed") || StorageManager.opmodeenabled.get(p) == true){
			    		p.setFoodLevel(20);
			    		p.sendMessage("§7Restored your §6Hungerbar§7!");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.feed.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
			    				p.setFoodLevel(20);
			    				p.sendMessage("§7Restored your §6Hungerbar§7!");
			    			}
			    			else{
			    				p.sendMessage("§7Restored " + PlayerManager.getPlayerDisplayname(p2) + "'s §6Hungerbar§7!");
			    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + "§7 restored your §6Hungerbar§7!");
			    				p2.setFoodLevel(20);
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
			    	if(p.hasPermission("command.feed") || StorageManager.opmodeenabled.get(p) == true){
			    		p.setFoodLevel(20);
			    		p.sendMessage("§7Restored your §6Hungerbar§7!");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/fly")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.fly") || StorageManager.opmodeenabled.get(p) == true){
			    		if(p.getAllowFlight() == false){
				    		p.setAllowFlight(true);
				    		p.setFlying(true);
				    		p.sendMessage("§a§lENABLED §7your §fFly§7 mode!");
			    		}
			    		else{
				    		p.setAllowFlight(false);
				    		p.setFlying(false);
				    		p.sendMessage("§c§lDISABLED §7your §fFly§7 mode!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.fly.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
					    		if(p.getAllowFlight() == false){
						    		p.setAllowFlight(true);
						    		p.setFlying(true);
						    		p.sendMessage("§a§lENABLED §7your §fFly§7 mode!");
					    		}
					    		else{
						    		p.setAllowFlight(false);
						    		p.setFlying(false);
						    		p.sendMessage("§c§lDISABLED §7your §fFly§7 mode!");
					    		}
			    			}
			    			else{
					    		if(p2.getAllowFlight() == false){
						    		p2.setAllowFlight(true);
						    		p2.setFlying(true);
						    		p.sendMessage("§a§lENABLED " + PlayerManager.getPlayerDisplayname(p2) + "'s §fFly§7 mode!");
						    		p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §a§lENABLED§7 §7your §fFly§7 mode!");
					    		}
					    		else{
						    		p2.setAllowFlight(false);
						    		p2.setFlying(false);
						    		p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §c§lDISABLED§7 §7your §fFly§7 mode!");
					    		}
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
			    	if(p.hasPermission("command.fly") || StorageManager.opmodeenabled.get(p) == true){
			    		if(p.getAllowFlight() == false){
				    		p.setAllowFlight(true);
				    		p.setFlying(true);
				    		p.sendMessage("§a§lENABLED §7your §fFly§7 mode!");
			    		}
			    		else{
				    		p.setAllowFlight(false);
				    		p.setFlying(false);
				    		p.sendMessage("§c§lDISABLED §7your §fFly§7 mode!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gms")){
		    	if(args.length == 1){
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.SURVIVAL);
		    			p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.gamemode.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
				    			p.setGameMode(GameMode.SURVIVAL);
				    			p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
			    			}
			    			else{
				    			p2.setGameMode(GameMode.SURVIVAL);
				    			p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §a§lSurvival§7!");
				    			p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §a§lSurvival§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.SURVIVAL);
		    			p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gmc")){
		    	if(args.length == 1){
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.CREATIVE);
		    			p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.gamemode.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
				    			p.setGameMode(GameMode.CREATIVE);
				    			p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
			    			}
			    			else{
				    			p2.setGameMode(GameMode.CREATIVE);
				    			p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §d§lCreative§7!");
				    			p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §d§lCreative§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.CREATIVE);
		    			p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gma")){
		    	if(args.length == 1){
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.ADVENTURE);
		    			p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.gamemode.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
				    			p.setGameMode(GameMode.ADVENTURE);
				    			p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
			    			}
			    			else{
				    			p2.setGameMode(GameMode.ADVENTURE);
				    			p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §2§lAdventure§7!");
				    			p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §2§lAdventure§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.ADVENTURE);
		    			p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gmspec")){
		    	if(args.length == 1){
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.SPECTATOR);
		    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.gamemode.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
				    			p.setGameMode(GameMode.SPECTATOR);
				    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
			    			}
			    			else{
				    			p2.setGameMode(GameMode.SPECTATOR);
				    			p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §e§lSpectate§7!");
				    			p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §e§lSpectate§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[1] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <player>§7.");
		    		}
		    	}
		    	else{
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			p.setGameMode(GameMode.SPECTATOR);
		    			p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gamemode") || args[0].equalsIgnoreCase("/gm")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
			    		p.sendMessage("§7Use §6" + args[0] + " s|c|a|spec");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <gamemode>§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("survival")){
		    				p.setGameMode(GameMode.SURVIVAL);
		    				p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("creative")){
		    				p.setGameMode(GameMode.CREATIVE);
		    				p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("adventure")){
		    				p.setGameMode(GameMode.ADVENTURE);
		    				p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("spec") || args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("spectate")){
		    				p.setGameMode(GameMode.SPECTATOR);
		    				p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    			}
		    			else{
		    				p.sendMessage("§7Use §6" + args[0] + " s|c|a|spec");
		    			}
		    		}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <gamemode>§7.");
			    	}
		    	}
		    	else if(args.length == 3){
		    		if(p.hasPermission("command.gamemode.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[2])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
				    			if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("survival")){
				    				p.setGameMode(GameMode.SURVIVAL);
				    				p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("creative")){
				    				p.setGameMode(GameMode.CREATIVE);
				    				p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("adventure")){
				    				p.setGameMode(GameMode.ADVENTURE);
				    				p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("spec") || args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("spectate")){
				    				p.setGameMode(GameMode.SPECTATOR);
				    				p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
				    			}
				    			else{
				    				p.sendMessage("§7Use §6" + args[0] + " s|c|a|spec <player>");
				    			}
			    			}
			    			else{
				    			if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("survival")){
				    				p2.setGameMode(GameMode.SURVIVAL);
				    				p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §a§lSurvival§7!");
				    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §a§lSurvival§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("creative")){
				    				p2.setGameMode(GameMode.CREATIVE);
				    				p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §d§lCreative§7!");
				    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §d§lCreative§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("adventure")){
				    				p2.setGameMode(GameMode.ADVENTURE);
				    				p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §2§lAdventure§7!");
				    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §2§lAdventure§7!");
				    			}
				    			else if(args[1].equalsIgnoreCase("spec") || args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("spectate")){
				    				p2.setGameMode(GameMode.SPECTATOR);
				    				p.sendMessage("§7Set " + PlayerManager.getPlayerDisplayname(p2) + "'s §6GameMode§7 to §e§lSpectate§7!");
				    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + " §7set your §6GameMode§7 to §e§lSpectate§7!");
				    			}
				    			else{
				    				p.sendMessage("§7Use §6" + args[0] + " s|c|a|spec <player>");
				    			}
			    			}
			    		}
			    		else{
			    			p.sendMessage("§7Player §6" + args[2] + " §7isn't §aOnline§7!");
			    		}
		    		}
		    		else{
		    			p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <gamemode> <player>§7.");
		    		}
		    	}
		    	else{
			    	if(p.hasPermission("command.gamemode") || StorageManager.opmodeenabled.get(p) == true){
		    			if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("survival")){
		    				p.setGameMode(GameMode.SURVIVAL);
		    				p.sendMessage("§7Set your §6GameMode§7 to §a§lSurvival§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("creative")){
		    				p.setGameMode(GameMode.CREATIVE);
		    				p.sendMessage("§7Set your §6GameMode§7 to §d§lCreative§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("adventure")){
		    				p.setGameMode(GameMode.ADVENTURE);
		    				p.sendMessage("§7Set your §6GameMode§7 to §2§lAdventure§7!");
		    			}
		    			else if(args[1].equalsIgnoreCase("spec") || args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("spectate")){
		    				p.setGameMode(GameMode.SPECTATOR);
		    				p.sendMessage("§7Set your §6GameMode§7 to §e§lSpectate§7!");
		    			}
		    			else{
		    				p.sendMessage("§7Use §6" + args[0] + " s|c|a|spec");
		    			}
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + " <gamemode>§7.");
			    	}
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/vote")){
		    	e.setCancelled(true);
		    	
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §3§lHub§7 Server:");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(Hub.getUUIDfromPlayer(p)));
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    	
		    }
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
