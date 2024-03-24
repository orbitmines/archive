package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandPreprocessEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			
			String s = e.getMessage().split(" ") [0];
			
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(s);
			
			if(topic == null){
				
				p.sendMessage(Start.TAG + "Unknown Command: §4" + s + "§7. Use §4/help§7 for Help!");
				e.setCancelled(true);
			}
			
		    String[] args = e.getMessage().split(" ");
		    if(args[0].startsWith("/bukkit:me")){
		    	e.setCancelled(true);
		    	p.sendMessage(Start.TAG + "§4§lDENIED§7! Can't perform commands that start with §6/bukkit:§7!");
		    }
		    if(args[0].equalsIgnoreCase("/plugins") || args[0].equalsIgnoreCase("/pl")){
		    	e.setCancelled(true);
		    	p.sendMessage("§fPlugins (1): §aPrison");
		    }
		    if(args[0].equalsIgnoreCase("/spawn")){
		    	e.setCancelled(true);
				p.sendMessage(Start.TAG + "Teleporting to §a§lSpawn§7...");
				p.teleport(new Location(StorageManager.PrisonWorld, StorageManager.PrisonSpawn.getX(), StorageManager.PrisonSpawn.getY() +4, StorageManager.PrisonSpawn.getZ(), -90, 0));
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
		    }
		    if(args[0].equalsIgnoreCase("/money") || args[0].equalsIgnoreCase("/gold")){
		    	e.setCancelled(true);
		    	if(PlayerManager.isLoaded(p)){
		    		if(!p.hasPermission("Rank.Moderator") && !p.hasPermission("Rank.Owner")){
		    			p.sendMessage("§4§lPrison §8| §7Your §6§LGold§7: §6§l" + StorageManager.PlayerMoney.get(p));
		    		}
		    		else{
		    			if(args.length == 1){
		    				p.sendMessage("§4§lPrison §8| §7Your §6§LGold§7: §6§l" + StorageManager.PlayerMoney.get(p));
		    			}
		    			else if(args[1].equalsIgnoreCase("give")){
		    				if(args.length == 4){
		    					if(!args[3].contains("-") || args[2].contains("+")){
			    					String playerString = args[2];
						    		Player givenPlayer = null;
						    		for(Player player : Bukkit.getOnlinePlayers()){
						    			if(player.getName().equalsIgnoreCase(playerString)){
						    				givenPlayer = player;
						    			}
						    		}
						    		
						    		if(givenPlayer != null){
						    			try{
						    				int amount = Integer.parseInt(args[3]);
						    				
						    				PlayerManager.giveMoney(givenPlayer, amount);
						    				p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " §6§l" + amount + " Gold§7!");
						    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you §6§l" + amount + " Gold§7!");
						    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				
						    			}catch(Exception ex){
						    				p.sendMessage("§4§lPrison §8| §6" + args[3] + "§7 isn't a correct number§7!");
						    			}
						    		}
						    		else{
						    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
						    		}
		    					}
		    					else{
		    						p.sendMessage("§4§lPrison §8| §7You can't use §6- §7and §6+ §7symbols!");
		    					}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/gold give <player> <amount>");
		    				}
		    			}
		    			else if(args[1].equalsIgnoreCase("remove")){
		    				if(args.length == 4){
		    					if(!args[3].contains("-") || args[2].contains("+")){
			    					String playerString = args[2];
						    		Player givenPlayer = null;
						    		for(Player player : Bukkit.getOnlinePlayers()){
						    			if(player.getName().equalsIgnoreCase(playerString)){
						    				givenPlayer = player;
						    			}
						    		}
						    		
						    		if(givenPlayer != null){
						    			try{
						    				int amount = Integer.parseInt(args[3]);
						    				
						    				PlayerManager.giveMoney(givenPlayer, amount);
						    				p.sendMessage("§4§lPrison §8| §7You removed §6§l" + amount + " Gold §7from §6" + givenPlayer.getName() + "§7's Balance!");
						    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 removed §6§l" + amount + " Gold§7 from your Balance!");
						    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				
						    			}catch(Exception ex){
						    				p.sendMessage("§4§lPrison §8| §6" + args[3] + "§7 isn't a correct number§7!");
						    			}
						    		}
						    		else{
						    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
						    		}
		    					}
		    					else{
		    						p.sendMessage("§4§lPrison §8| §7You can't use §6- §7and §6+ §7symbols!");
		    					}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/gold remove <player> <amount>");
		    				}
		    			}
		    			else if(args[1].equalsIgnoreCase("view")){
		    				if(args.length == 3){
		    					String playerString = args[2];
					    		Player givenPlayer = null;
					    		for(Player player : Bukkit.getOnlinePlayers()){
					    			if(player.getName().equalsIgnoreCase(playerString)){
					    				givenPlayer = player;
					    			}
					    		}
					    		
					    		if(givenPlayer != null){
					    			p.sendMessage("§4§lPrison §8| §6" + givenPlayer.getName() + "§7 has §6§l" + StorageManager.PlayerMoney.get(givenPlayer) + " Gold§7.");
					    		}
					    		else{
					    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
					    		}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/gold view <player>");
		    				}
		    			}
		    			else{
		    				p.sendMessage("§4§lPrison §8| §7Your §6§LGold§7: §6§l" + StorageManager.PlayerMoney.get(p));
		    			}
		    		}
		    	}
		    	else{
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/gtickets") || args[0].equalsIgnoreCase("/gambletickets")){
		    	e.setCancelled(true);
		    	if(PlayerManager.isLoaded(p)){
		    		if(!p.hasPermission("Rank.Moderator") && !p.hasPermission("Rank.Owner")){
		    			p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.PlayerGambleTickets.get(p));
		    		}
		    		else{
		    			if(args.length == 1){
		    				p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.PlayerGambleTickets.get(p));
		    			}
		    			else if(args[1].equalsIgnoreCase("give")){
		    				if(args.length == 4){
		    					if(!args[3].contains("-") || args[2].contains("+")){
			    					String playerString = args[2];
						    		Player givenPlayer = null;
						    		for(Player player : Bukkit.getOnlinePlayers()){
						    			if(player.getName().equalsIgnoreCase(playerString)){
						    				givenPlayer = player;
						    			}
						    		}
						    		
						    		if(givenPlayer != null){
						    			try{
						    				int amount = Integer.parseInt(args[3]);
						    				
						    				PlayerManager.giveGambleTickets(givenPlayer, amount);
						    				if(amount == 1){
						    					p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " §a" + amount + " Gamble Ticket§7!");
						    					givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you §a" + amount + " Gamble Ticket§7!");
						    				}
						    				else{
						    					p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " §a" + amount + " Gamble Tickets§7!");
							    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you §a" + amount + " Gamble Tickets§7!");
						    				}
						    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				
						    			}catch(Exception ex){
						    				p.sendMessage("§4§lPrison §8| §6" + args[3] + "§7 isn't a correct number§7!");
						    			}
						    		}
						    		else{
						    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
						    		}
		    					}
		    					else{
		    						p.sendMessage("§4§lPrison §8| §7You can't use §6- §7and §6+ §7symbols!");
		    					}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/gtickets give <player> <amount>");
		    				}
		    			}
		    			else if(args[1].equalsIgnoreCase("view")){
		    				if(args.length == 3){
		    					String playerString = args[2];
					    		Player givenPlayer = null;
					    		for(Player player : Bukkit.getOnlinePlayers()){
					    			if(player.getName().equalsIgnoreCase(playerString)){
					    				givenPlayer = player;
					    			}
					    		}
					    		
					    		if(givenPlayer != null){
					    			if(StorageManager.PlayerMoney.get(givenPlayer) == 1){
					    				p.sendMessage("§4§lPrison §8| §6" + givenPlayer.getName() + "§7 has §a" + StorageManager.PlayerGambleTickets.get(givenPlayer) + " Gamble Ticket§7.");
					    			}
					    			else{
					    				p.sendMessage("§4§lPrison §8| §6" + givenPlayer.getName() + "§7 has §a" + StorageManager.PlayerGambleTickets.get(givenPlayer) + " Gamble Tickets§7.");
					    			}
					    		}
					    		else{
					    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
					    		}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/gtickets view <player>");
		    				}
		    			}
		    			else{
		    				p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.PlayerGambleTickets.get(p));
		    			}
		    		}
		    	}
		    	else{
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/rarechest")){
		    	e.setCancelled(true);
		    	if(PlayerManager.isLoaded(p)){
		    		if(p.hasPermission("Rank.Moderator") || p.hasPermission("Rank.Owner")){
		    			if(args.length == 1){
		    				p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
		    			}
		    			else if(args[1].equalsIgnoreCase("give")){
		    				if(args.length == 3){
		    					String playerString = args[2];
					    		Player givenPlayer = null;
					    		for(Player player : Bukkit.getOnlinePlayers()){
					    			if(player.getName().equalsIgnoreCase(playerString)){
					    				givenPlayer = player;
					    			}
					    		}
					    		
					    		if(givenPlayer != null){
					    			ItemStack item = new ItemStack(Material.CHEST, 1);
					    			ItemMeta meta = item.getItemMeta();
					    			meta.setDisplayName("§cRare Chest");
					    			item.setItemMeta(meta);
					    			givenPlayer.getInventory().addItem(item);
					    			
									p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " a §cRare Chest§7!");
				    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you a §cRare Chest§7!");
				    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
				    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					    		}
					    		else{
					    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
					    		}
		    				}
		    				else{
		    					p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
		    				}
		    			}
		    			else{
		    				p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
		    			}
		    		}
		    		else{
		    			p.sendMessage(Start.TAG + "§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
		    		}
		    	}
		    	else{
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/bal") || args[0].equalsIgnoreCase("/balance")){
		    	e.setCancelled(true);
		    	p.sendMessage("§4§lPrison §8| §7Use §6/money §7or §6/gold");
		    }
		    if(args[0].equalsIgnoreCase("/pay")){
		    	e.setCancelled(true);
		    	if(PlayerManager.isLoaded(p)){
			    	if(args.length == 1){
			    		p.sendMessage("§4§lPrison §8| §7Use §6/pay <player> <amount>");
			    	}
			    	else if(args.length == 3){
			    		String playerString = args[1];
			    		Player givenPlayer = null;
			    		for(Player player : Bukkit.getOnlinePlayers()){
			    			if(player.getName().equalsIgnoreCase(playerString)){
			    				givenPlayer = player;
			    			}
			    		}
			    		
			    		if(givenPlayer != null){
			    			if(givenPlayer != p){
			    				if(!args[2].contains("-") || args[2].contains("+")){
					    			try{
					    				int amount = Integer.parseInt(args[2]);
					    				
					    				if(PlayerManager.hasMoney(givenPlayer, amount)){
						    				
						    				p.sendMessage("§4§lPrison §8| §7You paid §6" + givenPlayer.getName() + " §6§l" + amount + " Gold§7!");
						    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 paid you §6§l" + amount + " Gold§7!");
						    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						    				
						    				PlayerManager.removeMoney(p, amount);
						    				PlayerManager.giveMoney(givenPlayer, amount);
					    				}
					    				else{
					    					int needed = amount - StorageManager.PlayerMoney.get(p);
					    					p.sendMessage("§4§lPrison §8| §7You need§6 " + needed + "§7 more §6§lGold§7!");
					    				}
					    				
					    			}catch(Exception ex){
					    				p.sendMessage("§4§lPrison §8| §6" + args[2] + "§7 isn't a correct number§7!");
					    			}
			    				}
			    				else{
			    					p.sendMessage("§4§lPrison §8| §7You can't use §6- §7and §6+ §7symbols!");
			    				}
			    			}
			    			else{
			    				p.sendMessage("§4§lPrison §8| §7You can't pay yourself §6§lGold§7!");
			    			}
			    		}
			    		else{
			    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
			    		}
			    	}
			    	else{
			    		p.sendMessage("§4§lPrison §8| §7Use: §6/pay <player> <amount>");
			    	}
		    	}
		    	else{
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		    if(args[0].equalsIgnoreCase("/vote")){
		    	e.setCancelled(true);
		    	
		    	if(PlayerManager.isLoaded(p)){
					p.sendMessage("");
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §4§lPrison§7 Server:");
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
					if(p.hasPermission("nametag.group.A")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l2.500.000$ §7(§c§lA§7)");	
					}
					else if(p.hasPermission("nametag.group.B")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l2.000.000$ §7(§a§lB§7)");	
					}
					else if(p.hasPermission("nametag.group.C")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l1.500.000$ §7(§b§lC§7)");	
					}
					else if(p.hasPermission("nametag.group.D")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l1.000.000$ §7(§d§lD§7)");	
					}
					else if(p.hasPermission("nametag.group.E")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l600.000$ §7(§5§lE§7)");	
					}
					else if(p.hasPermission("nametag.group.F")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l400.000$ §7(§1§lF§7)");	
					}
					else if(p.hasPermission("nametag.group.G")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l300.000$ §7(§e§lG§7)");	
					}
					else if(p.hasPermission("nametag.group.H")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l200.000$ §7(§4§lH§7)");	
					}
					else if(p.hasPermission("nametag.group.I")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l175.000$ §7(§2§lI§7)");	
					}
					else if(p.hasPermission("nametag.group.J")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l150.000$ §7(§f§lJ§7)");	
					}
					else if(p.hasPermission("nametag.group.K")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l125.000$ §7(§6§lK§7)");	
					}
					else if(p.hasPermission("nametag.group.L")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l100.000$ §7(§7§lL§7)");	
					}
					else if(p.hasPermission("nametag.group.M")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l75.000$ §7(§8§lM§7)");	
					}
					else if(p.hasPermission("nametag.group.N")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l50.000$ §7(§0§lN§7)");	
					}
					else if(p.hasPermission("nametag.group.O")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l40.000$ §7(§3§lO§7)");	
					}
					else if(p.hasPermission("nametag.group.P")){
						p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §c§l25.000$ §7(§f§lP§7)");	
					}
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l10 EXP Levels");
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
					p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    	}
		    	else{
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		}
	}
}
