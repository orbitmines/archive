package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.DisguisePlayer;
import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.SkyBlock.Inv.ServerSelector;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;
import me.O_o_Fadi_o_O.SkyBlock.utils.StaffRank;
import me.O_o_Fadi_o_O.SkyBlock.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
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

	Start start = Start.getInstance();
	
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
			if(args[0].toLowerCase().startsWith("/bukkit:")){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
		    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
				}
			}
		    if(args[0].equalsIgnoreCase("/pl") || args[0].equalsIgnoreCase("/plugins")){
		    	e.setCancelled(true);
		    	p.sendMessage("§fPlugins (1): §aSkyBlock");
		    }
		    if(args[0].equalsIgnoreCase("/servers")){
		    	e.setCancelled(true);
				//if(!StorageManager.playersinlapisparkour.contains(p)){
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(ServerSelector.serverSelector);
				//}
			}
		    if(args[0].equalsIgnoreCase("/perks")){
		    	e.setCancelled(true);
				//if(!StorageManager.playersinlapisparkour.contains(p)){
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				//}
			}
		    if(args[0].equalsIgnoreCase("/spawn")){
		    	e.setCancelled(true);
		    	
		    	StorageManager.spawnteleporting.put(p, 11);
		    	p.sendMessage("§7Teleporting to §6Spawn§7...");
		    }
		    if(args[0].equalsIgnoreCase("/opmode")){
		    	e.setCancelled(true);
				if(StorageManager.staffrank.get(p) == StaffRank.Owner){
					if(StorageManager.opmodeenabled.get(p) == true){
						StorageManager.opmodeenabled.put(p, false);
						p.sendMessage("§5§lSkyBlock §8| §7Your §4§lOP Mode§7 is now §c§lDISABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
					else{
						StorageManager.opmodeenabled.put(p, true);
						p.sendMessage("§5§lSkyBlock §8| §7Your §4§lOP Mode§7 is now §a§lENABLED§7!");
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					}
				}
				else{
					p.sendMessage("§5§lSkyBlock §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
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
		    if(args[0].equalsIgnoreCase("/disguise")){
		    	e.setCancelled(true);
		    	
		    	if(p.hasPermission("command.disguise") || StorageManager.opmodeenabled.get(p) == true){
			    	if(args.length == 1){
			    		p.sendMessage("§7Use §6/disguise <mob>");
			    	}
			    	else if(args.length == 2){
			    		try{
			    			
			    			EntityType type = EntityType.valueOf(args[1].toUpperCase());
			    			
			    			DisguisePlayer.disguisePlayer(p, type, Bukkit.getOnlinePlayers());
			    		}
			    		catch(Exception ex){
			    			p.sendMessage("§7There's no such mob as §6" + args[1] + "§7!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§7Use §6/disguise <mob>");
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
		    if(args[0].equalsIgnoreCase("/heal")){
		    	e.setCancelled(true);
		    	
		    	if(args.length == 1){
			    	if(p.hasPermission("command.heal") || StorageManager.opmodeenabled.get(p) == true){
			    		p.setHealth(20D);
			    		p.sendMessage("§7Restored your §6Healthbar§7!");
			    	}
			    	else{
			    		p.sendMessage("§4§lDENIED§7! You don't have Permission to use §6" + args[0].toLowerCase() + "§7.");
			    	}
		    	}
		    	else if(args.length == 2){
		    		if(p.hasPermission("command.heal.other") || StorageManager.opmodeenabled.get(p) == true){
			    		Player p2 = null;
			    		
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(args[1])){
			    				p2 = player;
			    			}
			    		}
			    		
			    		if(p2 != null){
			    			if(p2 == p){
			    				p.setHealth(20D);
			    				p.sendMessage("§7Restored your §6Healthbar§7!");
			    			}
			    			else{
			    				p.sendMessage("§7Restored " + PlayerManager.getPlayerDisplayname(p2) + "'s §6Healthbar§7!");
			    				p2.sendMessage("§7" + PlayerManager.getPlayerDisplayname(p) + "§7 restored your §6Healthbar§7!");
			    				p2.setHealth(20);
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
			    	if(p.hasPermission("command.heal") || StorageManager.opmodeenabled.get(p) == true){
			    		p.setHealth(20);
			    		p.sendMessage("§7Restored your §6Healthbar§7!");
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
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §5§lSkyBlock§7 Server:");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §8§l32 Cobblestone");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §7§l1 Iron Ingot");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §0§l4 Coal");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    	
		    }
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
