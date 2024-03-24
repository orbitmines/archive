package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.BanManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DatabaseManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.FriendManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.Utils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerChatEvent implements Listener{
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 20 * 60 * 30;
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(ChatEvent e){
		Connection c = e.getSender();
		
		String lowercaseMessage = e.getMessage().toLowerCase();
		
		if(c instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) c;
			UUID uuid = p.getUniqueId();
			
			if(!lowercaseMessage.startsWith("/")){
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(player != p && !player.getServer().getInfo().getName().equals(p.getServer().getInfo().getName())){
						if(Start.allchat.containsKey(uuid) && Start.allchat.get(uuid) == true){
							player.sendMessage(Start.getServer(p.getName()) + " §8| §8" + p.getName() + "§7 » " + e.getMessage());
						}
					}
				}
			}
			
			if(Start.staffpasswords.containsKey(p.getName()) && Start.stafflogin.get(p) == false){
				e.setCancelled(true);
				
				if(lowercaseMessage.startsWith("/l")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/l")){
						e.setCancelled(true);
						if(Start.staffpasswords.containsKey(p.getName())){
							if(a.length == 1){
								p.sendMessage("§4§lSTAFF PROTECTION §8| §c§l/l <pass>");
							}
							else if(a.length == 2){
								if(Start.staffpasswords.get(p.getName()).equals(a[1])){
									Start.stafflogin.put(p, true);
									TextComponent title = new TextComponent("§4§lSTAFF PROTECTION");
									TextComponent subtitle = new TextComponent("§7Welcome back!");
									Title t = ProxyServer.getInstance().createTitle();
									t.fadeIn(20);
									t.fadeOut(20);
									t.title(title);
									t.subTitle(subtitle);
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
				}
			}
			else{
				if(lowercaseMessage.startsWith("/") && !lowercaseMessage.startsWith("/l") && !lowercaseMessage.startsWith("/login")){
					for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
						if(Start.hasStaffPerms(player, StaffRank.Moderator)){
							if(Start.showstaffmessage.get(player.getUniqueId()) == true){
								player.sendMessage("§e§lCMD §8| §e§o" + p.getName() + "§7§o: " + e.getMessage());
							}
						}
					}
				}
				if(lowercaseMessage.startsWith("/silent")){
					String[] a = e.getMessage().split(" ");
					
					if(Start.silent.containsKey(uuid)){
						if(a[0].equalsIgnoreCase("/silent")){
							e.setCancelled(true);
						
							if(Start.silent.get(uuid) == true){
								p.sendMessage("§6§lSilent Mode §8| §c§lDISABLED§7!");
								Start.silent.put(uuid, false);
								DatabaseManager.setSilentJoin(p.getUniqueId(), false);
							}
							else{
								p.sendMessage("§6§lSilent Mode §8| §a§lENABLED§7!");
								Start.silent.put(uuid, true);
								DatabaseManager.setSilentJoin(p.getUniqueId(), true);
							}
						}
					}
				}
				if(lowercaseMessage.startsWith("/allchat") || lowercaseMessage.startsWith("/all")){
					String[] a = e.getMessage().split(" ");
					
					if(Start.allchat.containsKey(uuid)){
						if(a[0].equalsIgnoreCase("/allchat") || a[0].equalsIgnoreCase("/all")){
							e.setCancelled(true);
						
							if(Start.allchat.get(uuid) == true){
								p.sendMessage("§d§lAllChat §8| §c§lDISABLED§7!");
								Start.allchat.put(uuid, false);
							}
							else{
								p.sendMessage("§d§lAllChat §8| §a§lENABLED§7!");
								Start.allchat.put(uuid, true);
							}
						}
					}
				}
				if(lowercaseMessage.startsWith("/list") || lowercaseMessage.startsWith("/glist")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/list") || a[0].equalsIgnoreCase("/glist")){
						e.setCancelled(true);
						
						ServerInfo kitpvp = ProxyServer.getInstance().getServerInfo("kitpvp");
						String kitpvpplayers = "";
						boolean kitpvponline = true;
						int kitpvpsilent = 0;
						ServerInfo prison = ProxyServer.getInstance().getServerInfo("prison");
						String prisonplayers = "";
						boolean prisononline = true;
						int prisonsilent = 0;
						ServerInfo creative = ProxyServer.getInstance().getServerInfo("creative");
						String creativeplayers = "";
						boolean creativeonline = true;
						int creativesilent = 0;
						ServerInfo hub = ProxyServer.getInstance().getServerInfo("hub");
						String hubplayers = "";
						boolean hubonline = true;
						int hubsilent = 0;
						ServerInfo survival = ProxyServer.getInstance().getServerInfo("survival");
						String survivalplayers = "";
						boolean survivalonline = true;
						int survivalsilent = 0;
						ServerInfo skyblock = ProxyServer.getInstance().getServerInfo("skyblock");
						String skyblockplayers = "";
						boolean skyblockonline = true;
						int skyblocksilent = 0;
						ServerInfo minigames = ProxyServer.getInstance().getServerInfo("minigames");
						String minigamesplayers = "";
						boolean minigamesonline = true;
						int minigamessilent = 0;
						ServerInfo alpha = ProxyServer.getInstance().getServerInfo("alpha");
						String alphaplayers = "";
						boolean alphaonline = true;
						int alphasilent = 0;
						
						try{for(ProxiedPlayer player : kitpvp.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(kitpvpplayers.equals("")){kitpvpplayers = "§f" + player.getName();}else{kitpvpplayers = kitpvpplayers + "§8, §f" + player.getName();}}else{kitpvpsilent = kitpvpsilent +1;}}}catch(Exception ex){kitpvponline = false;}
						try{for(ProxiedPlayer player : prison.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(prisonplayers.equals("")){prisonplayers = "§f" + player.getName();}else{prisonplayers = prisonplayers + "§8, §f" + player.getName();}}else{prisonsilent = prisonsilent +1;}}}catch(Exception ex){prisononline = false;}
						try{for(ProxiedPlayer player : creative.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(creativeplayers.equals("")){creativeplayers = "§f" + player.getName();}else{creativeplayers = creativeplayers + "§8, §f" + player.getName();}}else{creativesilent = creativesilent +1;}}}catch(Exception ex){creativeonline = false;}
						try{for(ProxiedPlayer player : hub.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(hubplayers.equals("")){hubplayers = "§f" + player.getName();}else{hubplayers = hubplayers + "§8, §f" + player.getName();}}else{hubsilent = hubsilent +1;}}}catch(Exception ex){hubonline = false;}
						try{for(ProxiedPlayer player : survival.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(survivalplayers.equals("")){survivalplayers = "§f" + player.getName();}else{survivalplayers = survivalplayers + "§8, §f" + player.getName();}}else{survivalsilent = survivalsilent +1;}}}catch(Exception ex){survivalonline = false;}
						try{for(ProxiedPlayer player : skyblock.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(skyblockplayers.equals("")){skyblockplayers = "§f" + player.getName();}else{skyblockplayers = skyblockplayers + "§8, §f" + player.getName();}}else{skyblocksilent = skyblocksilent +1;}}}catch(Exception ex){skyblockonline = false;}
						try{for(ProxiedPlayer player : minigames.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(minigamesplayers.equals("")){minigamesplayers = "§f" + player.getName();}else{minigamesplayers = minigamesplayers + "§8, §f" + player.getName();}}else{minigamessilent = minigamessilent +1;}}}catch(Exception ex){minigamesonline = false;}
						try{for(ProxiedPlayer player : alpha.getPlayers()){if(!Start.silent.containsKey(player.getUniqueId()) || Start.silent.containsKey(player.getUniqueId()) && Start.silent.get(player.getUniqueId()) == false){if(alphaplayers.equals("")){alphaplayers = "§f" + player.getName();}else{alphaplayers = alphaplayers + "§8, §f" + player.getName();}}else{alphasilent = alphasilent +1;}}}catch(Exception ex){alphaonline = false;}
						
						int totalsilent = kitpvpsilent + prisonsilent + creativesilent + hubsilent + survivalsilent + skyblocksilent + minigamessilent + alphasilent;
						
						p.sendMessage("");
						p.sendMessage("§6§lOrbitMines§4§lNetwork§7(" + (ProxyServer.getInstance().getOnlineCount() - totalsilent) + ")");
						if(kitpvponline == true){p.sendMessage(" §c§lKitPvP§7(" + (kitpvp.getPlayers().size() - kitpvpsilent) + "§7) " + kitpvpplayers);}else{p.sendMessage(" §c§lKitPvP§7(§4§lOffline§7)");}
						if(prisononline == true){p.sendMessage(" §4§lPrison§7(" + (prison.getPlayers().size() - prisonsilent) + "§7) " + prisonplayers);}else{p.sendMessage(" §4§lPrison§7(§4§lOffline§7)");}
						if(creativeonline == true){p.sendMessage(" §d§lCreative§7(" + (creative.getPlayers().size() - creativesilent) + "§7) " + creativeplayers);}else{p.sendMessage(" §d§lCreative§7(§4§lOffline§7)");}
						if(hubonline == true){p.sendMessage(" §3§lHub§7(" + (hub.getPlayers().size() - hubsilent) + "§7) " + hubplayers);}else{p.sendMessage(" §3§lHub§7(§4§lOffline§7)");}
						if(survivalonline == true){p.sendMessage(" §a§lSurvival§7(" + (survival.getPlayers().size() - survivalsilent) + "§7) " + survivalplayers);}else{p.sendMessage(" §a§lSurvival§7(§4§lOffline§7)");}
						if(skyblockonline == true){p.sendMessage(" §5§lSkyBlock§7(" + (skyblock.getPlayers().size() - skyblocksilent) + "§7) " + skyblockplayers);}else{p.sendMessage(" §5§lSkyBlock§7(§4§lOffline§7)");}
						if(minigamesonline == true){p.sendMessage(" §f§lMiniGames§7(" + (minigames.getPlayers().size() - minigamessilent) + "§7) " + minigamesplayers);}else{p.sendMessage(" §f§lMiniGames§7(§4§lOffline§7)");}
						if(alphaonline == true){p.sendMessage(" §e§lAlpha§7(" + (alpha.getPlayers().size() - alphasilent) + "§7) " + alphaplayers);}else{p.sendMessage(" §e§lAlpha§7(§4§lOffline§7)");}
						
					}
				}
				if(lowercaseMessage.startsWith("/friends")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/friends")){
						e.setCancelled(true);
						if(a.length == 1){
							FriendManager.sendFriendMessage(p);
						}
						else if(a.length == 3){
							if(a[1].equalsIgnoreCase("remove")){
								UUID friendUUID = Utils.getUUID(a[2]);
								if(FriendManager.playerfriends.containsKey(uuid) && FriendManager.playerfriends.get(uuid).contains(friendUUID)){
									List<UUID> friends = FriendManager.playerfriends.get(uuid);
									friends.remove(friendUUID);
									
									if(friends.size() != 0){
										FriendManager.playerfriends.put(uuid, friends);
										
										String friendsS = "";
										
										for(UUID friend : friends){
											friendsS = friendsS + "|" + friend.toString();
										}
										
										if(friendsS.startsWith("|")){
											friendsS = friendsS.substring(1);
										}
										DatabaseManager.setFriends(p.getUniqueId(), friendsS);
									}
									else{
										FriendManager.playerfriends.remove(uuid);
										DatabaseManager.removeFriends(p.getUniqueId());
									}
									p.sendMessage("§2§lFriends §8| §7You §cremoved §2" + a[2] + "§7 from your friends§7!");
									
									if(!FriendManager.playerfriends.containsKey(friendUUID)){
										String[] friends2 = DatabaseManager.getString(friendUUID, "Friends", "friends").split("\\|");
										List<UUID> friendsL = new ArrayList<UUID>();
										
										for(String friend : friends2){
											friendsL.add(UUID.fromString(friend));
										}
										
										FriendManager.playerfriends.put(friendUUID, friendsL);
									}
									
									List<UUID> friends2 = FriendManager.playerfriends.get(friendUUID);
									friends2.remove(uuid);
									
									if(friends2.size() != 0){
										FriendManager.playerfriends.put(friendUUID, friends2);
										
										String friendsS2 = "";
										
										for(UUID friend2 : friends2){
											friendsS2 = friendsS2 + "|" + friend2.toString();
										}
										
										if(friendsS2.startsWith("|")){
											friendsS2 = friendsS2.substring(1);
										}
										DatabaseManager.setFriends(friendUUID, friendsS2);
									}
									else{
										FriendManager.playerfriends.remove(friendUUID);
										DatabaseManager.removeFriends(friendUUID);
									}
									
									ProxiedPlayer p2 = null;
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(a[2].equalsIgnoreCase(player.getName())){
											p2 = player;
										}
									}
									
									if(p2 != null){
										p2.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 removed you from their friend list§7!");
									}
								}
							}
							else{
								FriendManager.sendFriendMessage(p);
							}
						}
						else if(a.length == 2){
							if(a[1].equalsIgnoreCase("accept")){
								if(Start.playerfriendrequest.containsKey(uuid)){
									if(FriendManager.playerfriends.containsKey(uuid)){
										if(!FriendManager.playerfriends.get(uuid).contains(Start.playerfriendrequest.get(uuid))){
											if(FriendManager.playerfriends.get(uuid).size() != FriendManager.getAmountFriendsAllowed(p)){
												
												List<UUID> friends = FriendManager.playerfriends.get(uuid);
												UUID friendUUID = Start.playerfriendrequest.get(uuid);
												friends.add(friendUUID);
												
												String friendsS = "";
												
												for(UUID friend : friends){
													friendsS = friendsS + "|" + friend.toString();
												}
												
												if(friendsS.startsWith("|")){
													friendsS = friendsS.substring(1);
												}
												
												DatabaseManager.setFriends(p.getUniqueId(), friendsS);
	
												String friend = Utils.getName(friendUUID);
												p.sendMessage("§2§lFriends §8| §7You're now friends with §2" + friend + "§7!");
												
												if(FriendManager.playerfriends.containsKey(friendUUID)){
													
													List<UUID> friends2 = FriendManager.playerfriends.get(friendUUID);
													friends2.add(uuid);
													
													String friendsS2 = "";
													
													for(UUID friend2 : friends2){
														friendsS2 = friendsS2 + "|" + friend2.toString();
													}
													
													if(friendsS2.startsWith("|")){
														friendsS2 = friendsS2.substring(1);
													}
													
													DatabaseManager.setFriends(friendUUID, friendsS2);
													
													ProxiedPlayer p2 = null;
													
													for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
														if(friend.equalsIgnoreCase(player.getName())){
															p2 = player;
														}
													}
													
													if(p2 != null){
														p2.sendMessage("§2§lFriends §8| §2" + p.getName() + " §aaccepted§7 your friend request!");
													}
												}
												else{
													List<UUID> friends2 = new ArrayList<UUID>();
													friends2.add(uuid);
													FriendManager.playerfriends.put(friendUUID, friends2);
													
													DatabaseManager.insertString(friendUUID, "Friends", "friends", uuid.toString());
													
													ProxiedPlayer p2 = null;
													
													for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
														if(friend.equalsIgnoreCase(player.getName())){
															p2 = player;
														}
													}
													
													if(p2 != null){
														p2.sendMessage("§2§lFriends §8| §2" + p.getName() + " §aaccepted§7 your friend request!");
													}
												}
											}
											else{
												p.sendMessage("§2§lFriends §8| §7You reached the maximum amount of friends!");
												Start.playerfriendrequest.remove(uuid);
											}
										}
										else{
											p.sendMessage("§2§lFriends §8| §7You are already friends with §2" + Start.playerfriendrequest.get(uuid) + "§7!");
											Start.playerfriendrequest.remove(uuid);
										}
									}
									else{
										List<UUID> friends = new ArrayList<UUID>();
										UUID friendUUID = Start.playerfriendrequest.get(uuid);
										String friend = Utils.getName(friendUUID);
										friends.add(friendUUID);
										FriendManager.playerfriends.put(uuid, friends);
										Start.playerfriendrequest.remove(uuid);
										
										DatabaseManager.insertString(p.getUniqueId(), "Friends", "friends", friendUUID.toString());
										p.sendMessage("§2§lFriends §8| §7You're now friends with §2" + friend + "§7!");
										
										if(FriendManager.playerfriends.containsKey(friendUUID)){
											
											List<UUID> friends2 = FriendManager.playerfriends.get(friendUUID);
											friends2.add(uuid);
											
											String friendsS2 = "";
											
											for(UUID friend2 : friends2){
												friendsS2 = friendsS2 + "|" + friend2.toString();
											}
											
											if(friendsS2.startsWith("|")){
												friendsS2 = friendsS2.substring(1);
											}
											
											DatabaseManager.setFriends(friendUUID, friendsS2);
											
											ProxiedPlayer p2 = null;
											
											for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
												if(friend.equalsIgnoreCase(player.getName())){
													p2 = player;
												}
											}
											
											if(p2 != null){
												p2.sendMessage("§2§lFriends §8| §2" + p.getName() + " §aaccepted§7 your friend request!");
											}
										}
										else{
											List<UUID> friends2 = new ArrayList<UUID>();
											friends2.add(uuid);
											FriendManager.playerfriends.put(friendUUID, friends2);
											
											DatabaseManager.insertString(friendUUID, "Friends", "friends", uuid.toString());
											
											ProxiedPlayer p2 = null;
											
											for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
												if(friend.equalsIgnoreCase(player.getName())){
													p2 = player;
												}
											}
											
											if(p2 != null){
												p2.sendMessage("§2§lFriends §8| §2" + p.getName() + " §aaccepted§7 your friend request!");
											}
										}
									}
								}
							}
							else if(a[1].equalsIgnoreCase("reject")){
								if(Start.playerfriendrequest.containsKey(uuid)){
									
									UUID friendUUID = Start.playerfriendrequest.get(uuid);
									String friend = Utils.getName(friendUUID);
									Start.playerfriendrequest.remove(uuid);
									p.sendMessage("§2§lFriends §8| §7You §crejected §2" + friend + "'s§7 friend request!");
									
									ProxiedPlayer p2 = null;
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(friend.equalsIgnoreCase(player.getName())){
											p2 = player;
										}
									}
									
									if(p2 != null){
										p2.sendMessage("§2§lFriends §8| §2" + p.getName() + " §crejected§7 your friend request!");
									}
								}
							}
							else{
								FriendManager.sendFriendMessage(p);
							}
						}
						else{
							FriendManager.sendFriendMessage(p);
						}
					}
				}
				if(lowercaseMessage.startsWith("/friend")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/friend")){
						e.setCancelled(true);
						
						if(a.length == 1){
							p.sendMessage("§2§lFriends §8| §7Use §2/friend <player>");
						}
						else if(a.length == 2){
							ProxiedPlayer invitedPlayer = null;
							
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								if(a[1].equalsIgnoreCase(player.getName())){
									invitedPlayer = player;
								}
							}
							
							if(invitedPlayer != null){	
								if(invitedPlayer != p){
									if(!FriendManager.playerfriends.containsKey(p.getUniqueId())){
										invitedPlayer.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 wants to be friends.");
										TextComponent accept = new TextComponent("§a§lAccept");
										accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends accept"));
										accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click Here to §aAccept§7.").create()));
										
										TextComponent reject = new TextComponent("§c§lReject");
										reject.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends reject"));
										reject.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click Here to §cReject§7.").create()));
										
										TextComponent omF = new TextComponent("§2§lFriends §8| ");
										TextComponent or = new TextComponent(" §7or ");
										TextComponent end = new TextComponent("§7.");
										
										invitedPlayer.sendMessage(omF, accept, or, reject, end);
										
										p.sendMessage("§2§lFriends §8| §7Sent a friend request to §2" + invitedPlayer.getName() + "§7!");
										
										Start.playerfriendrequest.put(invitedPlayer.getUniqueId(), uuid);
									}
									else{
										try{
											if(!FriendManager.playerfriends.get(p.getUniqueId()).contains(Utils.getUUID(a[1]))){
												if(FriendManager.playerfriends.get(p.getUniqueId()).size() != FriendManager.getAmountFriendsAllowed(p)){
													invitedPlayer.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 wants to be friends.");
													TextComponent accept = new TextComponent("§a§lAccept");
													accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends accept"));
													accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click Here to §aAccept§7.").create()));
													
													TextComponent reject = new TextComponent("§c§lReject");
													reject.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends reject"));
													reject.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click Here to §cReject§7.").create()));
													
													TextComponent omF = new TextComponent("§2§lFriends §8| ");
													TextComponent or = new TextComponent(" §7or ");
													TextComponent end = new TextComponent("§7.");
													
													invitedPlayer.sendMessage(omF, accept, or, reject, end);
													
													p.sendMessage("§2§lFriends §8| §7Sent a friend request to §2" + invitedPlayer.getName() + "§7!");
													
													Start.playerfriendrequest.put(invitedPlayer.getUniqueId(), uuid);
												}
												else{
													p.sendMessage("§2§lFriends §8| §7You reached the maximum amount of friends!");
												}
											}
											else{
												p.sendMessage("§2§lFriends §8| §7You are already friends with §2" + a[1] + "§7!");
											}
										}catch(Exception ex){
											ex.printStackTrace();
											p.sendMessage("§2§lFriends §8| §7Player §2" + a[1] + "§7 isn't §aOnline§7!");
										}
									}
								}
								else{
									p.sendMessage("§2§lFriends §8| §7You can't add yourself as a friend!");
								}
							}
							else{
								p.sendMessage("§2§lFriends §8| §7Player §2" + a[1] + "§7 isn't §aOnline§7!");
							}
							
						}
						else{
							p.sendMessage("§2§lFriends §8| §7Use §2/friend <player>");
						}
						
					}
				}
				if(lowercaseMessage.startsWith("/hub") || lowercaseMessage.startsWith("/lobby")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/hub") || a[0].equalsIgnoreCase("/lobby")){
						e.setCancelled(true);
						
						p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6Hub§7...");
						p.connect(ProxyServer.getInstance().getServerInfo("hub"));
					}
				}
				if(lowercaseMessage.startsWith("/server")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/server")){
						e.setCancelled(true);
						
						if(a.length == 1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Currently connected to §6" + p.getServer().getInfo().getName().substring(0, 1).toUpperCase() + p.getServer().getInfo().getName().substring(1));
						}
						else if(a.length == 2){
							if(ProxyServer.getInstance().getServers().containsKey(a[1])){
								p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6" + a[1].substring(0, 1).toUpperCase() + a[1].substring(1) + "§7...");
							    p.connect(ProxyServer.getInstance().getServerInfo(a[1].toLowerCase()));
							}
							else{
								p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Server §6" + a[1] + "§7 doesn't exist.");
							}
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Use §6/server <server>");
						}
					}
				}
				if(lowercaseMessage.startsWith("/donate")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/donate")){
						e.setCancelled(true);
						
						p.sendMessage("§7§lDonate: §3shop.orbitmines.com");
					}
				}
				if(lowercaseMessage.startsWith("/report")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/report")){
						e.setCancelled(true);
						
						if(a.length >= 3){
							long lastUsed = 0;
							if(lastUsage.containsKey(p.getName())){
								lastUsed = lastUsage.get(p.getName());
							}
							int cdmillis = cdtime * 1000;
							
							if(System.currentTimeMillis()-lastUsed>=cdmillis){
								ProxiedPlayer reportedPlayer = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(a[1].equalsIgnoreCase(player.getName())){
										reportedPlayer = player;
									}
								}
								
								if(reportedPlayer != null){	
								
									if(reportedPlayer != p){
										p.sendMessage("§c§lReport §8| §7You §c§lREPORTED §c" + reportedPlayer.getName() + " for §c"  + e.getMessage().substring(a[0].length() + a[1].length() +2));
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											if(Start.hasStaffPerms(player, StaffRank.Moderator)){
												if(Start.showstaffmessage.get(uuid) == true){
													player.sendMessage("§c§lReport §8| §7(" + Start.getServer(p.getName()) + "§7) §7§o" + p.getName() + " §7> §c§o" + reportedPlayer.getName() + "§7. (§c§o" + e.getMessage().substring(a[0].length() + a[1].length() +2) + "§7)");
												}
											}
										}
										
										BanManager.reportPlayer(reportedPlayer.getName(), p.getName(), e.getMessage().substring(a[0].length() + a[1].length() +2), p.getServer().getInfo().getName());
									}
									else{
										p.sendMessage("§c§lReport §8| §7Your can't §creport §7yourself!");
									}
								}
								else{
									p.sendMessage("§c§lReport §8| §7Player §c" + a[1] + "§7 isn't §aOnline§7!");
								}
								
								lastUsage.put(p.getName(), System.currentTimeMillis());
							}
							else{
								p.sendMessage("§c§lReport §8| §7You can only §creport§7 a player once every §c30 minutes§7!");
							}
						}
						else{
							p.sendMessage("§c§lReport §8| §7Use §c" + a[0].toLowerCase() +" <player> <reason>");
							p.sendMessage("§c§lReport §8| §7Don't abuse this command! Doing so, will get you a 3 day ban!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/website") || lowercaseMessage.startsWith("/site")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/website") || a[0].equalsIgnoreCase("/site")){
						e.setCancelled(true);
						
						p.sendMessage("§7§lWebsite: §6www.orbitmines.com");
					}
				}
				if(lowercaseMessage.startsWith("/help") || lowercaseMessage.startsWith("/?")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/help") || a[0].equalsIgnoreCase("/?")){
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
						
						if(p.getServer().getInfo().getName().equalsIgnoreCase("kitpvp")){
							p.sendMessage(" §c§lKitPvP Commands");
							p.sendMessage(" §7Open the §bKit Selector§7 with §b/kit§7.");
						}
						if(p.getServer().getInfo().getName().equalsIgnoreCase("skyblock")){
							p.sendMessage(" §5§lSkyBlock Commands");
							p.sendMessage(" §7Show §dIsland Commands§7 with §d/is§7 or §d/island§7.");
						}
						if(p.getServer().getInfo().getName().equalsIgnoreCase("creative")){
							p.sendMessage(" §d§lCreative Commands");
							p.sendMessage(" §7Show §dPlot Help§7 with §d/plot§7.");
						}
						if(p.getServer().getInfo().getName().equalsIgnoreCase("survival")){
							p.sendMessage(" §a§lSurvival Commands");
							p.sendMessage(" §7Set your §ahome§7 with §a/sethome <name>§7.");
							p.sendMessage(" §7Teleport to your §ahome§7 with §a/home <name>§7.");
							p.sendMessage(" §7View your §ahomes§7 with §a/homes§7.");
							p.sendMessage(" §7Delete your §ahome§7 with §a/delhome <name>§7.");
							p.sendMessage(" §7Teleport to §aspawn§7 with §a/spawn§7.");
						}
						if(p.getServer().getInfo().getName().equalsIgnoreCase("prison")){
							p.sendMessage(" §4§lPrison Commands");
							p.sendMessage(" §7View your §6Gold§7 with §6/gold§7.");
							p.sendMessage(" §7Pay someone with §6/pay§7.");
						}
						p.sendMessage(" ");
						p.sendMessage("§7§m----------------------------------------");
					}
				}
				if(lowercaseMessage.startsWith("/ip")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/ip")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Owner)){
							if(a.length == 2){
								String player = a[1];
								UUID playerUUID = Utils.getUUID(player);
								
								if(Start.ips.containsKey(playerUUID)){
									p.sendMessage("§4§lOP §8| §7" + player + "'s IP is §6" + Start.ips.get(playerUUID) + "§7.");
								}
								else{
									try{
										if(DatabaseManager.containsPath("uuid", "PlayerIPs", playerUUID.toString())){
											Start.ips.put(playerUUID, DatabaseManager.getString(playerUUID, "PlayerIPs", "ip"));
											p.sendMessage("§4§lOP §8| §7" + player + "'s IP is §6" + Start.ips.get(playerUUID) + "§7.");
										}
										else{
											p.sendMessage("§4§lOP §8| §7Cannot find player §6" + player + "§7.");
										}
									}catch(Exception ex){
										p.sendMessage("§d§lStaff §8| §6" + player + "§7 has never been on §6§lOrbitMines§7!");
									}
								}
							}
							else{
								p.sendMessage("§4§lOP §8| §7Use §6/ip <player>§7.");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/say")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/say")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							if(a.length >= 2){
								for(ProxiedPlayer player : p.getServer().getInfo().getPlayers()){
									player.sendMessage("§7\n§d§lSay §8| " + Start.getPlayerDisplayname(p) + " §7» §d" + e.getMessage().substring(5) + "\n§7");
								}
							}
							else{
								p.sendMessage("§d§lSay §8| §7Use §d/say <message>§7.");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/maintenance")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/maintenance")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Owner)){
							if(Start.maintenancemode == true){
								p.sendMessage("§d§lStaffMSG §8| §c§lDISABLED§d Maintenance Mode§7!");
								Start.maintenancemode = false;
							}
							else{
								p.sendMessage("§d§lStaffMSG §8| §a§lENABLED§d Maintenance Mode§7!");
								Start.maintenancemode = true;
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/staffhelp")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/staffhelp")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
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
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/kickall")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/kickall")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								try{
									player.disconnect("§cYou've been §4§lKICKED§c! (By " + Start.getPlayerDisplayname(p) + "§c)\n§cReason: §6§l" + e.getMessage().substring(a[0].length() +1).replaceAll("&", "§"));
								}catch(Exception ex){
									player.disconnect("§cYou've been §4§lKICKED§c! (By " + Start.getPlayerDisplayname(p) + "§c)");
								}
							}	
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/kick")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/kick")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							
							if(a.length >= 2){
								ProxiedPlayer kickedPlayer = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(a[1].equalsIgnoreCase(player.getName())){
										kickedPlayer = player;
									}
								}
								
								if(kickedPlayer != null){	
								
									p.sendMessage("§d§lStaff §8| §7You §4§lKICKED §7" + kickedPlayer.getName() + "!");
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										player.sendMessage("§4§l§m--------------------------------------------");
										player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oKick §c(" + Start.getPlayerDisplayname(p) + "§c)");
										player.sendMessage("");
										player.sendMessage("  §c" + kickedPlayer.getName() + "§7 has been §4§lKICKED§7!");
										try{
											player.sendMessage("   §cReason: §7" + e.getMessage().substring(a[0].length() + a[1].length() +2).replaceAll("&", "§"));
										}catch(Exception ex){}
										player.sendMessage("");
										player.sendMessage("§4§l§m--------------------------------------------");
									}
									
									try{
										kickedPlayer.disconnect("§cYou've been §4§lKICKED§c! (By " + Start.getPlayerDisplayname(p) + "§c)\n§cReason: §6§l" + e.getMessage().substring(a[0].length() + a[1].length() +2));
									}catch(Exception ex){
										kickedPlayer.disconnect("§cYou've been §4§lKICKED§c! (By " + Start.getPlayerDisplayname(p) + "§c)");
									}
								}
								else{
									p.sendMessage("§d§lStaff §8| §7Player §d" + a[1] + "§7 isn't §aOnline§7!");
								}
							}
							else{
								p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <player> <reason>");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/unban")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/unban")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							
							if(a.length == 2){
								
								try{
									if(DatabaseManager.containsPath("uuid", "PlayerBans", Utils.getUUID(a[1]).toString())){
										
										BanManager.unbanPlayer(a[1]);
										
										p.sendMessage("§d§lStaff §8| §7You §a§lUNBANNED §7" + a[1]);
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											player.sendMessage("§4§l§m--------------------------------------------");
											player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §a§l§oUnban §c(" + Start.getPlayerDisplayname(p) + "§c)");
											player.sendMessage("");
											player.sendMessage("  §c" + a[1] + "§7 has been §a§lUNBANNED§7!");
											player.sendMessage("");
											player.sendMessage("§4§l§m--------------------------------------------");
										}
										
									}
									else{
										p.sendMessage("§d§lStaff §8| §d" + a[1] +"§7 hasn't been §4§lBANNED§7!");
									}
								}catch(Exception ex){
									p.sendMessage("§d§lStaff §8| §d" + a[1] +"§7 hasn't been §4§lBANNED§7!");
								}
							}
							else{
								p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <player>");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/unbanip")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/unbanip")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							
							if(a.length == 2){
								
								if(DatabaseManager.containsPath("ip", "PlayerIPBans", a[1])){
									
									BanManager.unbanIP(a[1]);
									
									p.sendMessage("§d§lStaff §8| §7You §a§lUNBANNED the IP §7" + a[1]);
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(Start.hasStaffPerms(player, StaffRank.Moderator)){
											player.sendMessage("§4§l§m--------------------------------------------");
											player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §a§l§oUnbanIP §c(" + Start.getPlayerDisplayname(p) + "§c)");
											player.sendMessage("");
											player.sendMessage("  §cIP " + a[1] + "§7 has been §a§lUNBANNED§7!");
											player.sendMessage("");
											player.sendMessage("§4§l§m--------------------------------------------");
										}
									}
									
								}
								else{
									p.sendMessage("§d§lStaff §8| §7IP§d " + a[1] +"§7 hasn't been §4§lBANNED§7!");
								}
								
							}
							else{
								p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <ip>");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/ban")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/ban")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							
							if(a.length >= 7){
								String BannedPlayer = a[1];
								
								try{
									if(!DatabaseManager.containsPath("uuid", "PlayerBans", Utils.getUUID(BannedPlayer).toString())){

										try{
											int years = Integer.parseInt(a[2]);
											int days = Integer.parseInt(a[3]);
											int hours = Integer.parseInt(a[4]);
											int minutes = Integer.parseInt(a[5]);
										
											String BannedReason = e.getMessage().substring(a[0].length() + a[1].length() + a[2].length() + a[3].length() + a[4].length() + a[5].length() + 6).replaceAll("'", "`").replaceAll("&", "§");
										
											BanManager.banPlayer(Start.getPlayerDisplayname(p), BannedPlayer, BannedReason, years, days, hours, minutes);
											
											p.sendMessage("§d§lStaff §8| §7You §4§lBANNED §7" + BannedPlayer + "!");
											
											for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
												player.sendMessage("§4§l§m--------------------------------------------");
												player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oBan §c(" + Start.getPlayerDisplayname(p) + "§c)");
												player.sendMessage("");
												player.sendMessage("  §c" + BannedPlayer + "§7 has been §4§lBANNED§7! §c(" + years + "y " + days + "d " + hours + "h " + minutes + "m)");
												player.sendMessage("   §cReason: §7" + BannedReason);
												player.sendMessage("");
												player.sendMessage("§4§l§m--------------------------------------------");
												
												if(player.getName().equalsIgnoreCase(BannedPlayer)){
											        UUID banneduuid = Utils.getUUID(BannedPlayer);
											        String uuidString = banneduuid.toString();
											        
													player.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(uuidString) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(uuidString) + "\n§cReason: §6§l" + Start.bannedreason.get(uuidString));
												}
											}
										}catch(Exception ex){
											p.sendMessage("§d§lStaff §8| §7Incorrect Number!");
											p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <player> <years> <days> <hours> <minutes> <reason>");
										}
									}
									else{
										p.sendMessage("§d§lStaff §8| §7Player §d" + BannedPlayer + "§7 has already been §4§lBANNED§7!");
									}
								}catch(Exception ex){
									p.sendMessage("§d§lStaff §8| §6" + BannedPlayer + "§7 has never been on §6§lOrbitMines§7!");
								}
							}
							else{
								p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <player> <years> <days> <hours> <minutes> <reason>");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/banip")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/banip")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							
							if(a.length >= 7){
								
								try{
									String BannedIP = a[1];
									if(!DatabaseManager.containsPath("ip", "PlayerIPBans", BannedIP)){
										int years = Integer.parseInt(a[2]);
										int days = Integer.parseInt(a[3]);
										int hours = Integer.parseInt(a[4]);
										int minutes = Integer.parseInt(a[5]);
										
										String BannedReason = e.getMessage().substring(a[0].length() + a[1].length() + a[2].length() + a[3].length() + a[4].length() + a[5].length() + 6).replaceAll("'", "`").replaceAll("&", "§");
									
										BanManager.banIP(Start.getPlayerDisplayname(p), BannedIP, BannedReason, years, days, hours, minutes);
										
										p.sendMessage("§d§lStaff §8| §7You §4§lBANNED the IP §7" + BannedIP + "!");
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											if(Start.hasStaffPerms(player, StaffRank.Moderator)){
												player.sendMessage("§4§l§m--------------------------------------------");
												player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §4§l§oBanIP §c(" + Start.getPlayerDisplayname(p) + "§c)");
												player.sendMessage("");
												player.sendMessage("  §c" + BannedIP + "§7 has been §4§lBANNED§7! §c(" + years + "y " + days + "d " + hours + "h " + minutes + "m)");
												player.sendMessage("   §cReason: §7" + BannedReason);
												player.sendMessage("");
												player.sendMessage("§4§l§m--------------------------------------------");
											}
											
											if(player.getAddress().getHostString().equals(BannedIP)){
												player.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(BannedIP) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(BannedIP) + "\n§cReason: §6§l" + Start.bannedreason.get(BannedIP));
											}
										}
									}
									else{
										p.sendMessage("§d§lStaff §8| §7IP §d" + BannedIP + "§7 has already been §4§lBANNED§7!");
									}
									
								}catch(Exception ex){
									p.sendMessage("§d§lStaff §8| §7Incorrect Number!");
									p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <ip> <years> <days> <hours> <minutes> <reason>");
								}
							}
							else{
								p.sendMessage("§d§lStaff §8| §7Use §d" + a[0].toLowerCase() +" <ip> <years> <days> <hours> <minutes> <reason>");
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/staffmsg")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/staffmsg")){
						e.setCancelled(true);
						
						if(Start.hasStaffPerms(p, StaffRank.Moderator)){
							if(Start.showstaffmessage.get(uuid) == true){
								p.sendMessage("§d§lStaffMSG §8| §c§lDISABLED§d Staff Messages§7!");
								Start.showstaffmessage.put(uuid, false);
							}
							else{
								p.sendMessage("§d§lStaffMSG §8| §a§lENABLED§d Staff Messages§7!");
								Start.showstaffmessage.put(uuid, true);
							}
						}
						else{
							p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
						}
					}
				}
				if(lowercaseMessage.startsWith("/broadcast")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/broadcast")){
						e.setCancelled(true);
						
						if(a.length == 1){
							if(Start.hasStaffPerms(p, StaffRank.Moderator)){
								p.sendMessage("§c§l§oBroadcast §8| §7Use §c/broadcast <message>");
							}
							else{
								p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
							}
						}
						else{
							if(Start.hasStaffPerms(p, StaffRank.Moderator)){
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									player.sendMessage("§4§l§m--------------------------------------------");
									player.sendMessage("§6§lOrbitMines§4§lNetwork §7- §c§l§oBroadcast");
									player.sendMessage("");
									player.sendMessage("  " + Start.getPlayerDisplayname(p) + "§c:");
									player.sendMessage("   §7" + e.getMessage().replaceAll("&", "§").replaceAll("/broadcast ", ""));
									player.sendMessage("");
									player.sendMessage("§4§l§m--------------------------------------------");
									
								}
							}
							else{
								p.sendMessage("§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
							}
						}
					}
				}
				if(lowercaseMessage.startsWith("@")){
					if(Start.hasStaffPerms(p, StaffRank.Moderator)){
						e.setCancelled(true);
						for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
							if(Start.hasStaffPerms(player, StaffRank.Moderator)){
								player.sendMessage("§d§lStaffChat §8| " + Start.getPlayerDisplayname(p) + "§d: §f" + e.getMessage().substring(1));
							}
						}
					}
				}
				if(lowercaseMessage.startsWith("/msg") || lowercaseMessage.startsWith("/m") || lowercaseMessage.startsWith("/t") || lowercaseMessage.startsWith("/tell") || lowercaseMessage.startsWith("/w") || lowercaseMessage.startsWith("/whisper")){
					
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/msg") || a[0].equalsIgnoreCase("/m") || a[0].equalsIgnoreCase("/t") || a[0].equalsIgnoreCase("/tell") || a[0].equalsIgnoreCase("/w") || a[0].equalsIgnoreCase("/whisper")){
						e.setCancelled(true);
						
						int commandlength = a[0].length();
						
						if(a.length >= 3){
							ProxiedPlayer toPlayer = null;
							
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								if(a[1].equalsIgnoreCase(player.getName())){
									toPlayer = player;
								}
							}
							
							if(toPlayer != null){
								UUID toUUID = toPlayer.getUniqueId();
								
								toPlayer.sendMessage("§9§lMSG §8|§9§l " + p.getName() + "§7 » §7§lYou§7: §f" + e.getMessage().substring(commandlength + toPlayer.getName().length() + 2));
								p.sendMessage("§9§lMSG §8| §7§lYou§7 »§9§l " + toPlayer.getName() + "§7: §f" + e.getMessage().substring(commandlength + toPlayer.getName().length() + 2));
								if(Start.lastmsg.get(toUUID) == null){
									toPlayer.sendMessage("§9§lMSG §8|§7 Use §9/r <message>§7 to reply.");
								}
								Start.lastmsg.put(toUUID, uuid);
								Start.lastmsg.put(uuid, toUUID);
							}
							else{
								p.sendMessage("§9§lMSG §8| §7Player §9" + a[1] + "§7 isn't §aOnline§7!");
							}
						}
						else{
							p.sendMessage("§9§lMSG §8| §7Use §9" + a[0].toLowerCase() +" <player> <message>");
						}
					}
				}
				if(lowercaseMessage.startsWith("/r") || lowercaseMessage.startsWith("/reply")){
					String[] a = e.getMessage().split(" ");
					
					if(a[0].equalsIgnoreCase("/r") || a[0].equalsIgnoreCase("/reply")){
						e.setCancelled(true);
						int commandlength = a[0].length();
						
						if(a.length >= 2){
							if(Start.lastmsg.containsKey(uuid)){
								ProxiedPlayer toPlayer = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(Start.lastmsg.get(uuid) == player.getUniqueId()){
										toPlayer = player;
									}
								}
								
								if(toPlayer != null){
									UUID toUUID = toPlayer.getUniqueId();
									
									toPlayer.sendMessage("§9§lMSG §8|§9§l " + p.getName() + "§7 > §7§lYou§7: §f" + e.getMessage().substring(commandlength + 1));
									p.sendMessage("§9§lMSG §8| §7§lYou§7 >§9§l " + toPlayer.getName() + "§7: §f" + e.getMessage().substring(commandlength + 1));
									Start.lastmsg.put(toUUID, uuid);
									Start.lastmsg.put(uuid, toUUID);
								}
								else{
									p.sendMessage("§9§lMSG §8| §7Player §9" + a[1] + "§7 isn't §aOnline§7 anymore!");
									Start.lastmsg.remove(uuid);
								}
							}
							else{
								p.sendMessage("§9§lMSG §8| §7You have nobody to reply to.");
							}
						}
						else{
							p.sendMessage("§9§lMSG §8| §7Use §9" + a[0].toLowerCase() +" <message>");
						}
					}
				}
			}
		}
	}
}
