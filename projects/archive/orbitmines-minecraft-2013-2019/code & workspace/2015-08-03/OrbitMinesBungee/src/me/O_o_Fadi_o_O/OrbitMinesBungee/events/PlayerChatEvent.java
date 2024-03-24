package me.O_o_Fadi_o_O.OrbitMinesBungee.events;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BannedIP;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BannedPlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BungeePlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Database;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData.BungeeServer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerListData;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.ComponentMessage;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.StaffRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerChatEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(ChatEvent e){
		Connection c = e.getSender();
		
		if(c instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) c;
			BungeePlayer bp = BungeePlayer.getBungeePlayer(p);
			String[] a = e.getMessage().split(" ");
			
			if(!a[0].startsWith("/")){
				if(a[0].startsWith("@") && bp.hasPerms(StaffRank.Moderator)){
					e.setCancelled(true);
					
					for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
						if(bplayer.hasPerms(StaffRank.Moderator)){
							bplayer.getPlayer().sendMessage("§d§lStaffChat §8| " + bp.getName() + "§d: §f" + e.getMessage().substring(1));
						}
					}
				}
				else{
					for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
						if(bplayer.getPlayer() != p && bplayer.hasAllChat() && !p.getServer().getInfo().getName().equals(bplayer.getPlayer().getServer().getInfo().getName())){
							bplayer.getPlayer().sendMessage(bp.getServer().getName() + " §8| §8" + p.getName() + "§7 » " + e.getMessage());
						}
					}
				}
			}
			else{
				if(bp.hasPassword() && !bp.isLoggedIn()){
					if(a[0].equalsIgnoreCase("/l")){
						e.setCancelled(true);
						
						if(a.length == 1){
							p.sendMessage("§4§lSTAFF PROTECTION §8| §c§l/l <pass>");
						}
						else if(a.length == 2){
							if(bp.getPassword().getPassword().equals(a[1])){
								bp.setLoggedIn(true);
								
								Title t = ProxyServer.getInstance().createTitle();
								t.fadeIn(20);
								t.fadeOut(20);
								t.title(new TextComponent("§4§lSTAFF PROTECTION"));
								t.subTitle(new TextComponent("§7Welcome back!"));
								t.send(p);
							}
							else{
								p.disconnect("§4§lSTAFF PROTECTION\n§7Kicked!");
							}
						}
						else{
							p.sendMessage("§4§lSTAFF PROTECTION §8| §c§l/l <pass>");
						}
					}
				}
				else{
					if(a[0].startsWith("/")){
						if(!a[0].equalsIgnoreCase("/l") && !a[0].equalsIgnoreCase("/login")){
							for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
								if(bplayer.hasPerms(StaffRank.Moderator) && bplayer.canShowStaffMessage()){
									bplayer.getPlayer().sendMessage("§e§lCMD §8| §e§o" + p.getName() + "§7§o: " + e.getMessage());
								}
							}
						}
					}
					
					if(a[0].equalsIgnoreCase("/silent")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							bp.setSilent(!bp.isSilent());
							p.sendMessage("§6§lSilent Mode §8| " + Utils.statusString(bp.isSilent()) + "§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("/allchat") || a[0].equalsIgnoreCase("/all")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);

							bp.setAllChat(!bp.hasAllChat());
							p.sendMessage("§d§lAllChat §8| " + Utils.statusString(bp.hasAllChat()) + "§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("/list") || a[0].equalsIgnoreCase("/glist")){
						e.setCancelled(true);
						
						int totalplayers = 0;
						ServerListData kitpvp = new ServerListData(Server.KITPVP); totalplayers += kitpvp.getTotalPlayers();
						ServerListData prison = new ServerListData(Server.PRISON); totalplayers += prison.getTotalPlayers();
						ServerListData creative = new ServerListData(Server.CREATIVE); totalplayers += creative.getTotalPlayers();
						ServerListData hub = new ServerListData(Server.HUB); totalplayers += hub.getTotalPlayers();
						ServerListData survival = new ServerListData(Server.SURVIVAL); totalplayers += survival.getTotalPlayers();
						ServerListData skyblock = new ServerListData(Server.SKYBLOCK); totalplayers += skyblock.getTotalPlayers();
						ServerListData minigames = new ServerListData(Server.MINIGAMES); totalplayers += minigames.getTotalPlayers();
						ServerListData alpha = new ServerListData(Server.ALPHA); totalplayers += alpha.getTotalPlayers();
						
						p.sendMessage("§6§lOrbitMines§4§lNetwork§7(" + totalplayers + "§7)");
						p.sendMessage(kitpvp.getToSend());
						p.sendMessage(prison.getToSend());
						p.sendMessage(creative.getToSend());
						p.sendMessage(hub.getToSend());
						p.sendMessage(survival.getToSend());
						p.sendMessage(skyblock.getToSend());
						p.sendMessage(minigames.getToSend());
						p.sendMessage(alpha.getToSend());
					}
					else if(a[0].equalsIgnoreCase("/friends")){
						e.setCancelled(true);
						
						if(a.length > 1 && a[1].equalsIgnoreCase("remove")){
							if(a.length == 3){
								List<UUID> friends = bp.getFriends();
								ProxiedPlayer p2 = Utils.getPlayer(a[2]);
								UUID friendUUID = null;
								
								if(p2 != null){
									friendUUID = p2.getUniqueId();
								}
								else{
									friendUUID = Utils.getUUID(a[2]);
								}
								
								if(Utils.getStringList(friends).contains(friendUUID.toString())){
									friends.remove(friendUUID);
									
									if(friends.size() != 0){
										String friendsS = "";
										for(UUID friend : friends){
											friendsS += "|" + friend.toString();
										}
										if(friendsS.startsWith("|")){
											friendsS = friendsS.substring(1);
										}
										Database.get().update("Friends", "friends", friendsS, "uuid", p.getUniqueId().toString());
									}
									else{
										Database.get().delete("Friends", "uuid", p.getUniqueId().toString());
									}
									p.sendMessage("§7You §cremoved §2" + a[2] + "§7 from your friends§7!");
									
									List<UUID> friends2 = null;
									
									if(p2 != null){
										BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
										friends2 = bp2.getFriends();
										
										p2.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 removed you from their friend list§7!");
									}
									else{
										friends2 = Utils.getUUIDList(Arrays.asList(Database.get().getString("Friends", "friends", "uuid", friendUUID.toString()).split("\\|")));
									}
									friends2.remove(p.getUniqueId());
									
									if(friends2.size() != 0){
										String friendsS2 = "";
										for(UUID friend2 : friends2){
											friendsS2 += "|" + friend2.toString();
										}
										if(friendsS2.startsWith("|")){
											friendsS2 = friendsS2.substring(1);
										}
										Database.get().update("Friends", "friends", friendsS2, "uuid", friendUUID.toString());
									}
									else{
										Database.get().delete("Friends", "uuid", friendUUID.toString());
									}
								}
							}
							else{
								p.sendMessage("§7Use §2/friends remove <player>§7.");
							}
						}
						else if(a.length > 1 && a[1].equalsIgnoreCase("accept")){
							if(bp.hasFriendRequest()){
								ProxiedPlayer p2 = Utils.getPlayer(bp.getFriendRequest());
								String friendname = null;
								
								if(p2 != null){
									friendname = p2.getName();
								}
								else{
									friendname = Utils.getName(bp.getFriendRequest());
								}
								
								if(!Utils.getStringList(bp.getFriends()).contains(bp.getFriendRequest().toString())){
									if(bp.getFriends().size() != bp.getMaxFriendsAllowed()){
										List<UUID> friends = bp.getFriends();
										friends.add(bp.getFriendRequest());
										
										String friendsS = "";
										for(UUID friend : friends){
											friendsS = friendsS + "|" + friend.toString();
										}
										if(friendsS.startsWith("|")){
											friendsS = friendsS.substring(1);
										}
										
										if(friends.size() == 1){
											Database.get().insert("Friends", "uuid`, `friends", p.getUniqueId().toString() + "', '" + friendsS);
										}
										else{
											Database.get().update("Friends", "friends", friendsS, "uuid", p.getUniqueId().toString());
										}

										p.sendMessage("§7You're now friends with §2" + friendname + "§7!");
										
											
										List<UUID> friends2 = null;
										
										if(p2 != null){
											BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
											friends2 = bp2.getFriends();
											
											p2.sendMessage("§2" + p.getName() + " §aaccepted§7 your friend request!");
										}
										else{
											friends2 = Utils.getUUIDList(Arrays.asList(Database.get().getString("Friends", "friends", "uuid", bp.getFriendRequest().toString()).split("\\|")));
										}
										friends2.add(p.getUniqueId());
										
										String friendsS2 = "";
										for(UUID friend2 : friends2){
											friendsS2 = friendsS2 + "|" + friend2.toString();
										}
										if(friendsS2.startsWith("|")){
											friendsS2 = friendsS2.substring(1);
										}
										
										if(friends2.size() == 1){
											Database.get().insert("Friends", "uuid`, `friends", bp.getFriendRequest().toString() + "', '" + friendsS2);
										}
										else{
											Database.get().update("Friends", "friends", friendsS2, "uuid", bp.getFriendRequest().toString());
										}
										
										bp.setFriendRequest(null);
									}
									else{
										bp.setFriendRequest(null);
										p.sendMessage("§7You reached the maximum amount of friends!");
									}
								}
								else{
									bp.setFriendRequest(null);
									p.sendMessage("§7You are already friends with §2" + friendname + "§7!");
								}
							}
						}
						else if(a.length > 1 && a[1].equalsIgnoreCase("reject")){
							if(bp.hasFriendRequest()){
								ProxiedPlayer p2 = Utils.getPlayer(bp.getFriendRequest());
								String friendname = null;
								
								if(p2 != null){
									friendname = p2.getName();
									p2.sendMessage("§2" + p.getName() + " §crejected§7 your friend request!");
								}
								else{
									friendname = Utils.getName(bp.getFriendRequest());
								}
								
								p.sendMessage("§7You §crejected §2" + friendname + "'s§7 friend request!");
								bp.setFriendRequest(null);
							}
						}
						else{
							if(bp.getFriends().size() > 0){
								p.sendMessage("§a§m----------------------------------------");
								p.sendMessage(" §6§lOrbitMines§2§lFriends §7- §a§l" + p.getName());
								p.sendMessage("");
								for(UUID friendUUID : bp.getFriends()){
									ProxiedPlayer p2 = Utils.getPlayer(friendUUID);
									String friendname = null;
									
									if(p2 != null){
										friendname = p2.getName();

										ComponentMessage cm = new ComponentMessage();
										cm.addPart(" §2" + friendname + "§7 - ", null, null, null, null);
										cm.addPart("§c§lRemove Friend", ClickEvent.Action.RUN_COMMAND, "/friends remove " + friendname, HoverEvent.Action.SHOW_TEXT, "§cRemove " + friendname);
										Server server = Server.getServer(p2.getServer().getInfo().getName());
										cm.addPart(" §7- " + server.getName(), ClickEvent.Action.RUN_COMMAND, "/server " + server.toString().toLowerCase(), HoverEvent.Action.SHOW_TEXT, "§3Connect to " + server.getName());
										cm.send(p);
									}
									else{
										friendname = Utils.getName(friendUUID);
										
										ComponentMessage cm = new ComponentMessage();
										cm.addPart(" §2" + friendname + "§7 - ", null, null, null, null);
										cm.addPart("§c§lRemove Friend", ClickEvent.Action.RUN_COMMAND, "/friends remove " + friendname, HoverEvent.Action.SHOW_TEXT, "§cRemove " + friendname);
										if(Database.get().containsPath("PlayerLastOnline", "date", "uuid", friendUUID.toString())){
											cm.addPart(" §7- §4§lOffline", null, null, HoverEvent.Action.SHOW_TEXT, "§4Offline since:\n §c" + Database.get().getString("PlayerLastOnline", "date", "uuid", friendUUID.toString()) + " (CET)");
										}
										else{
											cm.addPart(" §7- §4§lOffline", null, null, HoverEvent.Action.SHOW_TEXT, "§4Offline since:\n §cUnknown");
										}
										cm.send(p);
									}
								}
								p.sendMessage("");
								p.sendMessage(" §7Friends: §a" + bp.getFriends().size() + "§7/§a" + bp.getMaxFriendsAllowed());
								p.sendMessage("§a§m----------------------------------------");
							}
							else{
								p.sendMessage("§a§m----------------------------------------");
								p.sendMessage(" §6§lOrbitMines§2§lFriends §7- §a§l" + p.getName());
								p.sendMessage("");
								p.sendMessage(" §7Add Friends! §2/friend <player>§7.");
								p.sendMessage("");
								p.sendMessage(" §7Friends: §a0§7/§a" + bp.getMaxFriendsAllowed());
								p.sendMessage("§a§m----------------------------------------");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/friend")){
						e.setCancelled(true);
						
						if(a.length == 2){
							ProxiedPlayer p2 = Utils.getPlayer(a[1]);
							
							if(p2 != null){	
								if(p2 != p){
									if(!Utils.getStringList(bp.getFriends()).contains(p2.getUniqueId().toString())){
										if(bp.getFriends().size() != bp.getMaxFriendsAllowed()){
											BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
											bp2.setFriendRequest(p.getUniqueId());

											p.sendMessage("§7Sent a friend request to §2" + p2.getName() + "§7!");
											p2.sendMessage("§2" + p.getName() + "§7 wants to be friends.");
											
											ComponentMessage cm = new ComponentMessage();
											cm.addPart("§a§lAccept", ClickEvent.Action.RUN_COMMAND, "/friends accept", HoverEvent.Action.SHOW_TEXT, "§7Click Here to §aAccept§7.");
											cm.addPart(" §7or ", null, null, null, null);
											cm.addPart("§c§lReject", ClickEvent.Action.RUN_COMMAND, "/friends reject", HoverEvent.Action.SHOW_TEXT, "§7Click Here to §cReject§7.");
											cm.send(p2);
										}
										else{
											p.sendMessage("§7You reached the maximum amount of friends!");
										}
									}
									else{
										p.sendMessage("§7You are already friends with §2" + p2.getName() + "§7!");
									}
								}
								else{
									p.sendMessage("§7You can't add yourself as a friend!");
								}
							}
							else{
								p.sendMessage("§7Player §2" + a[1] + "§7 isn't §aonline§7!");
							}
							
						}
						else{
							p.sendMessage("§7Use §2/friend <player>§7.");
						}
					}
					else if(a[0].equalsIgnoreCase("/hub") || a[0].equalsIgnoreCase("/lobby")){
						e.setCancelled(true);
						
						p.sendMessage("§7Connecting to " + Server.HUB.getName() + "§7...");
						p.connect(ProxyServer.getInstance().getServerInfo("hub"));
					}
					else if(a[0].equalsIgnoreCase("/server")){
						e.setCancelled(true);
						
						if(a.length == 1){
							p.sendMessage("§7Currently connected to " + bp.getServer().getName() + "§7.");
						}
						else if(a.length == 2){
							try{
								if(a[1].equalsIgnoreCase("minigames")){
									a[1] = "hub";
									bp.toMiniGameArea();
								}
								p.sendMessage("§7Connecting to " + Server.valueOf(a[1].toUpperCase()).getName() + "§7...");
							    p.connect(ProxyServer.getInstance().getServerInfo(a[1].toLowerCase()));
							}catch(IllegalArgumentException ex){
								p.sendMessage("§7Server §6" + a[1] + "§7 doesn't exist.");
							}
						}
						else{
							p.sendMessage("§7Use §6/server <server>§7.");
						}
					}
					else if(a[0].equalsIgnoreCase("/donate")){
						e.setCancelled(true);
						
						p.sendMessage("§7§lDonate: §3shop.orbitmines.com");
					}
					else if(a[0].equalsIgnoreCase("/website") || a[0].equalsIgnoreCase("/site")){
						e.setCancelled(true);
						
						p.sendMessage("§7§lWebsite: §6www.orbitmines.com");
					}
					else if(a[0].equalsIgnoreCase("/report")){
						e.setCancelled(true);
						
						if(a.length >= 3){
							if(!bp.onCooldown(Cooldown.REPORT)){
								ProxiedPlayer p2 = Utils.getPlayer(a[1]);
								
								if(p2 != null){	
									if(p2 != p){
										BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
										String reason = e.getMessage().substring(a[0].length() + a[1].length() +2);
										
										p.sendMessage("§7You §c§lREPORTED §c" + p2.getName() + " §7for §c" + reason + "§7.");
										
										for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
											if(bplayer.hasPerms(StaffRank.Moderator) && bplayer.canShowStaffMessage()){
												bplayer.getPlayer().sendMessage("§7(" + bp.getServer().getName() + "§7) §7§o" + p.getName() + " §7> §c§o" + p2.getName() + "§7. (§c§o" + reason + "§7)");
											}
										}
										
										bp.report(bp2, reason);
									}
									else{
										p.sendMessage("§7Your can't §creport §7yourself!");
									}
								}
								else{
									p.sendMessage("§7Player §c" + a[1] + "§7 isn't §aOnline§7!");
								}
								
								bp.resetCooldown(Cooldown.REPORT);
							}
							else{
								p.sendMessage("§7You can only §creport§7 a player once every §c30 minutes§7!");
							}
						}
						else{
							p.sendMessage("§7Use §c" + a[0].toLowerCase() +" <player> <reason>§7.");
							p.sendMessage("§7Don't abuse this command! Doing so, will get you a 3 day ban!");
						}
					}
					else if(a[0].equalsIgnoreCase("/help") || a[0].equalsIgnoreCase("/?")){
						e.setCancelled(true);
						
						p.sendMessage("§7§m----------------------------------------");
						p.sendMessage(" §6§lOrbitMines§4§lNetwork §7- §e§lPlayer Commands");
						p.sendMessage(" ");
						p.sendMessage(" §7Use your§9 Cosmetic Perks§7 with §9/perks§7.");
						p.sendMessage(" §cReport§7 a Player with §c/report§7.");
						p.sendMessage(" §bVote§7 for Rewards with §b/vote§7.");
						p.sendMessage(" §7Show your§2 Friends§7 with §2/friends§7.");
						p.sendMessage(" §7Add§2 Friends§7 with §2/friend <player>§7.");
						p.sendMessage(" §3Donate§7 for VIP with §3/donate§7.");
						p.sendMessage(" §7Send§9 Private Messages§7 with §9/msg§7.");
						p.sendMessage(" §7Show your§e OrbitMines Tokens§7 with §e/omt§7.");
						p.sendMessage(" §7Show your§b VIP Points§7 with §b/vippoints§7.");
						p.sendMessage(" §7Open the§3 Server Selector§7 with §3/servers§7.");
						p.sendMessage(" §7View all §aOnline Players§7 with §a/list§7.");
						p.sendMessage(" §7View our §6website§7 with §6/website§7.");
						
						if(bp.getServer() == Server.KITPVP){
							p.sendMessage(" §c§lKitPvP Commands");
							p.sendMessage(" §7Open the §bKit Selector§7 with §b/kit§7.");
						}
						else if(bp.getServer() == Server.SKYBLOCK){
							p.sendMessage(" §5§lSkyBlock Commands");
							p.sendMessage(" §7Show §dIsland Commands§7 with §d/is§7 or §d/island§7.");
						}
						else if(bp.getServer() == Server.CREATIVE){
							p.sendMessage(" §d§lCreative Commands");
							p.sendMessage(" §7Show §dPlot Help§7 with §d/plot§7.");
						}
						else if(bp.getServer() == Server.SKYBLOCK){
							p.sendMessage(" §a§lSurvival Commands");
							p.sendMessage(" §7Set your §ahome§7 with §a/sethome <name>§7.");
							p.sendMessage(" §7Teleport to your §ahome§7 with §a/home <name>§7.");
							p.sendMessage(" §7View your §ahomes§7 with §a/homes§7.");
							p.sendMessage(" §7Delete your §ahome§7 with §a/delhome <name>§7.");
							p.sendMessage(" §7Teleport to §aspawn§7 with §a/spawn§7.");
						}
						else if(bp.getServer() == Server.PRISON){
							p.sendMessage(" §4§lPrison Commands");
							p.sendMessage(" §7View your §6Gold§7 with §6/gold§7.");
							p.sendMessage(" §7Pay someone with §6/pay§7.");
						}
						else{}
						p.sendMessage(" ");
						p.sendMessage("§7§m----------------------------------------");
					}
					else if(a[0].equalsIgnoreCase("/ip")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							if(a.length == 2){
								BungeeServer bungee = ServerData.getBungee();
								UUID uuid = Utils.getUUID(a[1]);
								
								if(bungee.getIPs().containsKey(uuid)){
									p.sendMessage("§4§lOP §8| §7" + a[1] + "'s IP is §6" + bungee.getIPs().get(uuid) + "§7.");
								}
								else{
									if(Database.get().containsPath("PlayerIPs", "ip", "uuid", uuid.toString())){
										bungee.getIPs().put(uuid, Database.get().getString("PlayerIPS", "ip", "uuid", uuid.toString()));

										p.sendMessage("§4§lOP §8| §7" + a[1] + "'s IP is §6" + bungee.getIPs().get(uuid) + "§7.");
									}
									else{
										p.sendMessage("§4§lOP §8| §7Cannot find player §6" + a[1] + "§7.");
									}
								}
							}
							else{
								p.sendMessage("§4§lOP §8| §7Use §6/ip <player>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/seen")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							if(a.length == 2){
								BungeeServer bungee = ServerData.getBungee();
								ProxiedPlayer p2 = Utils.getPlayer(a[1]);
								UUID uuid = null;
								
								if(p2 != null){
									uuid = p2.getUniqueId();
								}
								else{
									uuid = Utils.getUUID(a[1]);
								}
								
								if(bungee.getLastOnline().containsKey(uuid)){
									if(p2 != null){
										p.sendMessage("§6" + p2.getName() + "§7 is currently §aonline§7.");
									}
									else{
										p.sendMessage("§6" + a[1] + "§7 was last seen at §6" + bungee.getLastOnline().get(uuid) + "§7.");
									}
								}
								else{
									p.sendMessage("§7Cannot find player §6" + a[1] + "§7.");
								}
							}
							else{
								p.sendMessage("§7Use §6/seen <player>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/say")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							if(a.length >= 2){
								for(ProxiedPlayer player : p.getServer().getInfo().getPlayers()){
									player.sendMessage("§7\n§d§lSay §8| " + bp.getName() + " §7» §d" + e.getMessage().substring(5) + "\n§7");
								}
							}
							else{
								p.sendMessage("§7Use §d/say <message>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/maintenance")){
						if(bp.hasPerms(StaffRank.Owner)){
							e.setCancelled(true);
						
							BungeeServer bungee = ServerData.getBungee();
							bungee.setMaintenanceMode(!bungee.inMaintenanceMode());
							p.sendMessage(Utils.statusString(bungee.inMaintenanceMode())  + "§d Maintenance Mode§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("/staffhelp")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							p.sendMessage("§6§lOrbitMines§4§lNetwork §7- §e§lStaff Commands:");
							p.sendMessage(" §4§lOwner");
							p.sendMessage(" §7 /maintenance");
							p.sendMessage(" §7 /opmode");
							p.sendMessage(" §b§lModerator");
							p.sendMessage(" §7 /ban <player> <y> <d> <h> <m> (reason)");
							p.sendMessage(" §7 /unban <player>");
							p.sendMessage(" §7 /kick <player> (reason)");
							p.sendMessage(" §7 /kickall (reason)");
							p.sendMessage(" §7 /staffMSG");
							p.sendMessage(" §7 /broadcast <message>");
							p.sendMessage(" §7 /allchat | /all");
							p.sendMessage(" §7 /silent");
							p.sendMessage(" §7 /say <message>");
							p.sendMessage(" §7 /ip <player>");
							p.sendMessage(" §7 /banip <ip> <y> <d> <h> <m> (reason)");
							p.sendMessage(" §7 /unbanip <ip>");
							p.sendMessage(" §7 /seen <player>");
							p.sendMessage(" §7 /uuid <player>");
							p.sendMessage(" §7 /invsee <player>");
							p.sendMessage(" §7 /tp <player | player1> (player2 | x) (y) (z)");
							p.sendMessage(" §7 /fly (player)");
						}
					}
					else if(a[0].equalsIgnoreCase("/kickall")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								if(a.length > 1){
									player.disconnect("§cYou've been §4§lKICKED§c! (By " + bp.getName() + "§c)\n§cReason: §6§l" + e.getMessage().substring(a[0].length() +1).replaceAll("&", "§"));
								}
								else{
									player.disconnect("§cYou've been §4§lKICKED§c! (By " + bp.getName() + "§c)");
								}
							}	
						}
					}
					else if(a[0].equalsIgnoreCase("/kick")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							if(a.length >= 2){
								ProxiedPlayer p2 = Utils.getPlayer(a[1]);
								
								if(p2 != null){	
									p.sendMessage("§7You §4§lKICKED §7" + p2.getName() + "!");
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										player.sendMessage("§4§l§m--------------------------------------------");
										player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oKick §c(" + bp.getName() + "§c)");
										player.sendMessage("");
										player.sendMessage("  §c" + p2.getName() + "§7 has been §4§lKICKED§7!");
										if(a.length > 2){
											player.sendMessage("   §cReason: §7" + e.getMessage().substring(a[0].length() + a[1].length() +2).replaceAll("&", "§"));
										}
										player.sendMessage("");
										player.sendMessage("§4§l§m--------------------------------------------");
									}
									
									if(a.length > 2){
										p2.disconnect("§cYou've been §4§lKICKED§c! (By " + bp.getName() + "§c)\n§cReason: §6§l" + e.getMessage().substring(a[0].length() + a[1].length() +2));
									}
									else{
										p2.disconnect("§cYou've been §4§lKICKED§c! (By " + bp.getName() + "§c)");
									}
								}
								else{
									p.sendMessage("§7Player §d" + a[1] + "§7 isn't §aonline§7!");
								}
							}
							else{
								p.sendMessage("§7Use §d" + a[0].toLowerCase() + " <player> <reason>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/unban")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							if(a.length == 2){
								UUID uuid = Utils.getUUID(a[1]);
								
								if(uuid != null && BannedPlayer.getBannedPlayer(uuid) != null){
									bp.unban(uuid);
									
									p.sendMessage("§7You §a§lUNBANNED §7" + a[1] + "§7.");
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										player.sendMessage("§4§l§m--------------------------------------------");
										player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §a§l§oUnban §c(" + bp.getName() + "§c)");
										player.sendMessage("");
										player.sendMessage("  §c" + a[1] + "§7 has been §a§lUNBANNED§7!");
										player.sendMessage("");
										player.sendMessage("§4§l§m--------------------------------------------");
									}
								}
								else{
									p.sendMessage("§d" + a[1] + "§7 hasn't been §4§lBANNED§7!");
								}
							}
							else{
								p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <player>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/unbanip")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							if(a.length == 2){
								if(BannedIP.getBannedIP(a[1]) != null){
									bp.unban(a[1]);
									
									p.sendMessage("§d§lStaff §8| §7You §a§lUNBANNED the IP §7" + a[1]);
									
									for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
										if(bplayer.hasPerms(StaffRank.Moderator)){
											bplayer.getPlayer().sendMessage("§4§l§m--------------------------------------------");
											bplayer.getPlayer().sendMessage("§6§lOrbitMines§4§lNetwork §7- §a§l§oUnbanIP §c(" + bp.getName() + "§c)");
											bplayer.getPlayer().sendMessage("");
											bplayer.getPlayer().sendMessage("  §cIP " + a[1] + "§7 has been §a§lUNBANNED§7!");
											bplayer.getPlayer().sendMessage("");
											bplayer.getPlayer().sendMessage("§4§l§m--------------------------------------------");
										}
									}
								}
								else{
									p.sendMessage("§7IP§d " + a[1] +"§7 hasn't been §4§lBANNED§7!");
								}
							}
							else{
								p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <ip>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/ban")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							if(a.length >= 7){
								UUID uuid = Utils.getUUID(a[1]);
								
								if(uuid != null){
									if(BannedPlayer.getBannedPlayer(uuid) == null){
										try{
											int years = Integer.parseInt(a[2]);
											int days = Integer.parseInt(a[3]);
											int hours = Integer.parseInt(a[4]);
											int minutes = Integer.parseInt(a[5]);
										
											String reason = e.getMessage().substring(a[0].length() + a[1].length() + a[2].length() + a[3].length() + a[4].length() + a[5].length() + 6).replaceAll("'", "`").replaceAll("&", "§");
										
											BannedPlayer bannedp = bp.ban(uuid, reason, years, days, hours, minutes);
											
											p.sendMessage("§d§lStaff §8| §7You §4§lBANNED §7" + a[1] + "!");
											
											for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
												player.sendMessage("§4§l§m--------------------------------------------");
												player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oBan §c(" + bp.getName() + "§c)");
												player.sendMessage("");
												player.sendMessage("  §c" + a[1] + "§7 has been §4§lBANNED§7! §c(" + years + "y " + days + "d " + hours + "h " + minutes + "m)");
												player.sendMessage("   §cReason: §7" + reason);
												player.sendMessage("");
												player.sendMessage("§4§l§m--------------------------------------------");
												
												if(player.getName().equalsIgnoreCase(a[1])){
													player.disconnect("§cYou've been §4§lBANNED§c! (By §b" + bp.getName() + "§c)\n§cUnban On: §6§l" + bannedp.getBannedUntil() + "\n§cReason: §6§l" + bannedp.getReason());
												}
											}
										}catch(NumberFormatException ex){
											p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <player> <years> <days> <hours> <minutes> <reason>§7.");
										}
									}
									else{
										p.sendMessage("§7Player §d" + a[1] + "§7 has already been §4§lBANNED§7!");
									}
								}
								else{
									p.sendMessage("§6" + a[1] + "§7 has never been on §6§lOrbitMines§7!");
								}
							}
							else{
								p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <player> <years> <days> <hours> <minutes> <reason>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/banip")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							if(a.length >= 7){
								try{
									if(BannedIP.getBannedIP(a[1]) == null){
										int years = Integer.parseInt(a[2]);
										int days = Integer.parseInt(a[3]);
										int hours = Integer.parseInt(a[4]);
										int minutes = Integer.parseInt(a[5]);
										
										String reason = e.getMessage().substring(a[0].length() + a[1].length() + a[2].length() + a[3].length() + a[4].length() + a[5].length() + 6).replaceAll("'", "`").replaceAll("&", "§");
									
										BannedIP bannedip = bp.banIP(a[1], reason, years, days, hours, minutes);
										
										p.sendMessage("§d§lStaff §8| §7You §4§lBANNED the IP §7" + a[1] + "!");
										
										for(BungeePlayer bplayer : BungeePlayer.getPlayers()){
											ProxiedPlayer player = bplayer.getPlayer();
											
											if(bplayer.hasPerms(StaffRank.Moderator)){
												player.sendMessage("§4§l§m--------------------------------------------");
												player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oBanIP §c(" + bp.getName() + "§c)");
												player.sendMessage("");
												player.sendMessage("  §c" + a[1] + "§7 has been §4§lBANNED§7! §c(" + years + "y " + days + "d " + hours + "h " + minutes + "m)");
												player.sendMessage("   §cReason: §7" + reason);
												player.sendMessage("");
												player.sendMessage("§4§l§m--------------------------------------------");
											}
											
											if(player.getAddress().getHostString().equals(a[1])){
												player.disconnect("§cYou've been §4§lBANNED§c! (By §b" + bp.getName() + "§c)\n§cUnban On: §6§l" + bannedip.getBannedUntil() + "\n§cReason: §6§l" + reason);
											}
										}
									}
									else{
										p.sendMessage("§7IP §d" + a[1] + "§7 has already been §4§lBANNED§7!");
									}
									
								}catch(NumberFormatException ex){
									p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <ip> <years> <days> <hours> <minutes> <reason>§7.");
								}
							}
							else{
								p.sendMessage("§7Use §d" + a[0].toLowerCase() +" <ip> <years> <days> <hours> <minutes> <reason>§7.");
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/staffmsg")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
							
							bp.setShowStaffMessage(!bp.canShowStaffMessage());
							p.sendMessage(Utils.statusString(bp.canShowStaffMessage()) + "§d Staff Messages§7!");
						}
					}
					else if(a[0].equalsIgnoreCase("/broadcast")){
						if(bp.hasPerms(StaffRank.Moderator)){
							e.setCancelled(true);
						
							if(a.length == 1){
								p.sendMessage("§7Use §c/broadcast <message>§7.");
							}
							else{
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									player.sendMessage("§4§l§m--------------------------------------------");
									player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §c§l§oBroadcast");
									player.sendMessage("");
									player.sendMessage("  " + bp.getName() + "§c:");
									player.sendMessage("   §7" + e.getMessage().replaceAll("&", "§").replaceAll("/broadcast ", ""));
									player.sendMessage("");
									player.sendMessage("§4§l§m--------------------------------------------");
									
								}
							}
						}
					}
					else if(a[0].equalsIgnoreCase("/msg") || a[0].equalsIgnoreCase("/m") || a[0].equalsIgnoreCase("/t") || a[0].equalsIgnoreCase("/tell") || a[0].equalsIgnoreCase("/w") || a[0].equalsIgnoreCase("/whisper")){
						e.setCancelled(true);
						
						int commandlength = a[0].length();
						
						if(a.length >= 3){
							ProxiedPlayer p2 = Utils.getPlayer(a[1]);
							
							if(p2 != null){
								BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
								
								p2.sendMessage("§9§lMSG §8|§9§l " + p.getName() + "§7 » §7§lYou§7: §f" + e.getMessage().substring(commandlength + p2.getName().length() + 2));
								p.sendMessage("§9§lMSG §8| §7§lYou§7 »§9§l " + p2.getName() + "§7: §f" + e.getMessage().substring(commandlength + p2.getName().length() + 2));
								if(!bp2.hasLastMSG()){
									p2.sendMessage("§9§lMSG §8|§7 Use §9/r <message>§7 to reply.");
								}
								
								bp.setLastMSG(bp2.getPlayer().getUniqueId());
								bp2.setLastMSG(bp.getPlayer().getUniqueId());
							}
							else{
								p.sendMessage("§9§lMSG §8| §7Player §9" + a[1] + "§7 isn't §aonline§7!");
							}
						}
						else{
							p.sendMessage("§9§lMSG §8| §7Use §9" + a[0].toLowerCase() +" <player> <message>§7.");
						}
					}
					else if(a[0].equalsIgnoreCase("/r") || a[0].equalsIgnoreCase("/reply")){
						e.setCancelled(true);
						int commandlength = a[0].length();
						
						if(a.length >= 2){
							if(bp.hasLastMSG()){
								ProxiedPlayer p2 = Utils.getPlayer(bp.getLastMSG());
								
								if(p2 != null){
									BungeePlayer bp2 = BungeePlayer.getBungeePlayer(p2);
									
									p2.sendMessage("§9§lMSG §8|§9§l " + p.getName() + "§7 > §7§lYou§7: §f" + e.getMessage().substring(commandlength + 1));
									p.sendMessage("§9§lMSG §8| §7§lYou§7 >§9§l " + p2.getName() + "§7: §f" + e.getMessage().substring(commandlength + 1));
									
									bp.setLastMSG(bp2.getPlayer().getUniqueId());
									bp2.setLastMSG(bp.getPlayer().getUniqueId());
								}
								else{
									bp.setLastMSG(null);
									p.sendMessage("§9§lMSG §8| §7Player §9" + a[1] + "§7 isn't §aonline§7 anymore!");
								}
							}
							else{
								p.sendMessage("§9§lMSG §8| §7You have nobody to reply to.");
							}
						}
						else{
							p.sendMessage("§9§lMSG §8| §7Use §9" + a[0].toLowerCase() +" <message>§7.");
						}
					}
					else{}
				}
			}
		}	
	}
}
