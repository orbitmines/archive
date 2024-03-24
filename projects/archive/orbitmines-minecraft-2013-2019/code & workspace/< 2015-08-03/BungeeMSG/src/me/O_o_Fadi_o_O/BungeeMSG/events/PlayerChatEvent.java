package me.O_o_Fadi_o_O.BungeeMSG.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import me.O_o_Fadi_o_O.BungeeMSG.managers.AdvertiseManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.BannedWordsManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.ColorManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.IgnoreManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.LogManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.MuteManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.SpamManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.StorageManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.TitleManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerChatEvent implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(ChatEvent e){
		Connection c = e.getSender();
		
		if(c instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) c;
			String[] a = e.getMessage().split(" ");
			
			String ch = "";
			String symb = "";
				
			if(!StorageManager.toggle.containsKey(p.getName()) || StorageManager.toggle.get(p.getName()) == true){
				for(String channel : StorageManager.channelstartingsymbols.keySet()){
					if(p.hasPermission(StorageManager.channelpermissions.get(channel))){
						for(String symbol : StorageManager.channelstartingsymbols.get(channel)){
							if(e.getMessage().toLowerCase().startsWith(symbol.toLowerCase())){
								ch = channel;
								symb = symbol;
							}
						}
					}
				}
			}
			
			if(!ch.equals("")){
				e.setCancelled(true);
				
				int symbollength = symb.length();
				String message = e.getMessage().substring(symbollength);
				
				if(!MuteManager.isMuted(p)){
					if(SpamManager.canMessage(p, message, false)){
						if(AdvertiseManager.canChat(p, message)){
							message = SpamManager.checkForCaps(p, message);
							message = BannedWordsManager.checkForBannedWords(p, message);
							message = ColorManager.checkforColors(p, message);
							
							String tosend = StorageManager.channelmessages.get(ch).replace("&", "§").replace("%sender%", p.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§"));
				
							Collection<ProxiedPlayer> players = IgnoreManager.getPlayersNotIgnored(p, ProxyServer.getInstance().getPlayers());
							
							for(ProxiedPlayer player : players){
								if(player.hasPermission(StorageManager.channelpermissions.get(ch))){
									Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, tosend));
								}
							}
							
							if(StorageManager.uselog == true && StorageManager.readchannels == true){
								LogManager.getLog().info("[CHANNEL | " + ch + "] " + p.getName() + ": " + message);
							}
						}
					}
				}
				else{
					Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
				}
			}
			else{
				String ch1 = "";
					
				for(String channel : StorageManager.channeltogglesymbols.keySet()){
					if(p.hasPermission(StorageManager.channelpermissions.get(channel))){
						for(String symbol : StorageManager.channeltogglesymbols.get(channel)){
							if(e.getMessage().length() >= symbol.length() && e.getMessage().equalsIgnoreCase(symbol)){
								ch1 = channel;
							}
						}
					}
				}
				
				if(!ch1.equals("")){
					e.setCancelled(true);
					
					if(StorageManager.toggledchannel.containsKey(p)){
						String channel = StorageManager.toggledchannel.get(p);
						
						if(channel.equalsIgnoreCase(ch1)){
							String tosend = StorageManager.channeltoggledisabled.get(ch1).replace("&", "§");
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, tosend));
							
							StorageManager.toggledchannel.remove(p);
						}
						else{
							String tosend1 = StorageManager.channeltoggledisabled.get(channel).replace("&", "§");
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, tosend1));
							
							String tosend2 = StorageManager.channeltoggleenabled.get(ch1).replace("&", "§");
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, tosend2));
							
							StorageManager.toggledchannel.put(p, ch1);
						}
					}
					else{
						String tosend = StorageManager.channeltoggleenabled.get(ch1).replace("&", "§");
						Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, tosend));
						
						StorageManager.toggledchannel.put(p, ch1);
					}
				}
				else{
					String bc = "";
					
					for(String broadcast : StorageManager.broadcastcommands.keySet()){
						for(String command : StorageManager.broadcastcommands.get(broadcast)){
							if(a[0].equalsIgnoreCase(command)){
								bc = broadcast;
							}
						}
					}
					
					if(!bc.equals("")){
						e.setCancelled(true);
						
						int commandlength = a[0].length();

						if(p.hasPermission(StorageManager.broadcastpermissions.get(bc))){
							if(a.length > 1){
								String message = e.getMessage().substring(commandlength + 1);
								message = ColorManager.checkforColors(p, message);
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									for(String tosend : StorageManager.broadcastmessages.get(bc)){
										Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, tosend.replace("&", "§").replace("%sender%", p.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§"))));
									}
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.broadcastwrongusage.get(bc).replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
							}
						}
						else{	
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.broadcastnopermissions.get(bc).replace("&", "§")));
						}
					}
					else{
						if(StorageManager.toggledchannel.containsKey(p)){
							if(!a[0].startsWith("/")){	
								e.setCancelled(true);
								
								String channel = StorageManager.toggledchannel.get(p);
								
								String message = e.getMessage();
								
								if(!MuteManager.isMuted(p)){
									if(SpamManager.canMessage(p, message, false)){
										if(AdvertiseManager.canChat(p, message)){
											message = SpamManager.checkForCaps(p, message);
											message = BannedWordsManager.checkForBannedWords(p, message);
											message = ColorManager.checkforColors(p, message);
											
											String tosend = StorageManager.channelmessages.get(channel).replace("&", "§").replace("%sender%", p.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§"));
								
											Collection<ProxiedPlayer> players = IgnoreManager.getPlayersNotIgnored(p, ProxyServer.getInstance().getPlayers());
											
											for(ProxiedPlayer player : players){
												if(player.hasPermission(StorageManager.channelpermissions.get(channel))){
													Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, tosend));
												}
											}
											
											if(StorageManager.uselog == true && StorageManager.readchannels == true){
												LogManager.getLog().info("[CHANNEL | " + channel + "] " + p.getName() + ": " + message);
											}
										}
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
								}
							}
						}
						else{
							if(!a[0].startsWith("/")){	
								if(StorageManager.useautoglobalchat == true){
									int key = 0;
									String message = e.getMessage();
					
									for(int groupid : StorageManager.groupmessages.keySet()){
										if(StorageManager.groupservers.get(groupid).contains(p.getServer().getInfo())){
											key = groupid;
										}
									}
									
									if(StorageManager.groupmessages.containsKey(key)){
										e.setCancelled(true);
										
										if(!MuteManager.isMuted(p)){
											if(SpamManager.canMessage(p, message, false)){
												if(AdvertiseManager.canChat(p, message)){
													message = SpamManager.checkForCaps(p, message);
													message = BannedWordsManager.checkForBannedWords(p, message);
													message = ColorManager.checkforColors(p, message);
													
													String tosend = StorageManager.groupmessages.get(key).replace("&", "§").replace("%sender%", p.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§"));
													
													for(ServerInfo info : StorageManager.groupservers.get(key)){
														Collection<ProxiedPlayer> players = IgnoreManager.getPlayersNotIgnored(p, info.getPlayers());
														
														for(ProxiedPlayer player : players){
															Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, tosend));
														}
													}
													
													if(StorageManager.uselog == true && StorageManager.readglobal == true){
														LogManager.getLog().info("[GLOBAL-AUTO] " + p.getName() + ": " + message);
													}
												}
											}
										}
										else{
											Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
										}
									}
								}
							}
						}
					}
					if(StorageManager.reloadcommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(p.hasPermission("BungeeMSG.reload")){
							if(StorageManager.uselog == true && StorageManager.readreloads == true){
								LogManager.getLog().info("[RELOAD] " + p.getName() + " started a reload...");
							}
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Reloading §6config.yml§7..."));
							ConfigManager.reloadConfig();
							Start.loadConfigData();
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Reloading §6muted.yml§7..."));
							ConfigManager.reloadMuted();
							Start.loadMutedData();
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Reloading §6banned-words.yml§7..."));
							ConfigManager.reloadBannedWords();
							Start.loadBannedWordsData();
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Reloading §6domain-whitelist.yml§7..."));
							ConfigManager.reloadDomainWhitelist();
							Start.loadDomainWhitelistData();
							int amount = ProxyServer.getInstance().getPlayers().size();
							if(amount == 1){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Restoring data for §6" + amount + " Player§7..."));
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Restoring data for §6" + amount + " Players§7..."));
							}
							ConfigManager.reloadPlayerData();
							Start.loadPlayerDataData(false);
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, "§7Reload §aCompleted§7!"));
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noreloadpermission.replace("&", "§")));
						}
					}
					if(StorageManager.spycommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(p.hasPermission("BungeeMSG.spy")){
							if(!StorageManager.spy.containsKey(p.getName())){
								StorageManager.spy.put(p.getName(), false);
							}
							
							if(StorageManager.spy.get(p.getName()) == true){
								StorageManager.spy.put(p.getName(), false);
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spydisable.replace("&", "§")));
		
								if(StorageManager.uselog == true && StorageManager.readspies == true){
									LogManager.getLog().info("[SPY] " + p.getName() + " Disabled Spy Mode.");
								}
							}
							else{
								StorageManager.spy.put(p.getName(), true);
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.spyenable.replace("&", "§")));
								
								if(StorageManager.uselog == true && StorageManager.readspies == true){
									LogManager.getLog().info("[SPY] " + p.getName() + " Enabled Spy Mode.");
								}
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.nospypermission.replace("&", "§")));
						}
					}
					if(StorageManager.togglecommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(a.length == 1){
							if(p.hasPermission("BungeeMSG.toggle")){
								if(!StorageManager.toggle.containsKey(p.getName())){
									StorageManager.toggle.put(p.getName(), true);
								}
								
								if(StorageManager.toggle.get(p.getName()) == true){
									StorageManager.toggle.put(p.getName(), false);
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.toggledisable.replace("&", "§")));
									
									if(StorageManager.uselog == true && StorageManager.readtoggles == true){
										LogManager.getLog().info("[TOGGLE] " + p.getName() + " Disabled receiving Private Messages.");
									}
								}
								else{
									StorageManager.toggle.put(p.getName(), true);
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.toggleenable.replace("&", "§")));
									
									if(StorageManager.uselog == true && StorageManager.readtoggles == true){
										LogManager.getLog().info("[TOGGLE] " + p.getName() + " Enabled receiving Private Messages.");
									}
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notogglepermission.replace("&", "§")));
							}
						}
						else if(a.length == 2){
							if(p.hasPermission("BungeeMSG.toggle.other")){
								ProxiedPlayer p2 = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(player.getName().equalsIgnoreCase(a[1])){
										p2 = player;
									}
								}
								
								if(p2 != null){
									if(!StorageManager.toggle.containsKey(p2.getName())){
										StorageManager.toggle.put(p2.getName(), true);
									}
									
									if(StorageManager.toggle.get(p2.getName()) == true){
										StorageManager.toggle.put(p2.getName(), false);
										Start.sendMessageNullCheck(p, p2, TitleManager.importTitle(p, StorageManager.toggledisabletosender.replace("&", "§").replace("%toggled%", p2.getName())));
										Start.sendMessageNullCheck(p2, p, TitleManager.importTitle(p2, StorageManager.toggledisabletoplayer.replace("&", "§").replace("%sender%", p.getName())));
										
										if(StorageManager.uselog == true && StorageManager.readtoggles == true){
											LogManager.getLog().info("[TOGGLE] " + p.getName() + " Disabled receiving Private Messages for player " + p2.getName() + ".");
										}
									}
									else{
										StorageManager.toggle.put(p2.getName(), true);
										Start.sendMessageNullCheck(p, p2, TitleManager.importTitle(p, StorageManager.toggleenabletosender.replace("&", "§").replace("%toggled%", p2.getName())));
										Start.sendMessageNullCheck(p2, p, TitleManager.importTitle(p2, StorageManager.toggleenabletoplayer.replace("&", "§").replace("%sender%", p.getName())));
										
										if(StorageManager.uselog == true && StorageManager.readtoggles == true){
											LogManager.getLog().info("[TOGGLE] " + p.getName() + " Enabled receiving Private Messages for player " + p2.getName() + ".");
										}
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notonline.replace("&", "§").replace("%receiver%", a[1])));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notoggleotherpermission.replace("&", "§")));
							}
						}
						else{
							if(p.hasPermission("BungeeMSG.toggle") || p.hasPermission("BungeeMSG.toggle.other")){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagetoggle.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notogglepermission.replace("&", "§")));
							}
						}
					}
					if(StorageManager.mutecommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(a.length == 2){
							if(p.hasPermission("BungeeMSG.mute")){
								ProxiedPlayer p2 = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(player.getName().equalsIgnoreCase(a[1])){
										p2 = player;
									}
								}
								
								if(p2 != null){
									UUID uuid = p2.getUniqueId();
									
									if(StorageManager.mute.contains(uuid)){
										StorageManager.mute.remove(uuid);
										Start.sendMessageNullCheck(p, p2, TitleManager.importTitle(p, StorageManager.unmutetosender.replace("&", "§").replace("%muted%", p2.getName())));
										Start.sendMessageNullCheck(p2, p, TitleManager.importTitle(p2, StorageManager.unmutetoplayer.replace("&", "§").replace("%sender%", p.getName())));
										
										if(StorageManager.uselog == true && StorageManager.readmutes == true){
											LogManager.getLog().info("[MUTE] " + p.getName() + " unmuted " + p2.getName() + " (UUID: " + p2.getUniqueId().toString() + ").");
										}
									}
									else{
										StorageManager.mute.add(uuid);
										Start.sendMessageNullCheck(p, p2, TitleManager.importTitle(p, StorageManager.mutetosender.replace("&", "§").replace("%muted%", p2.getName())));
										Start.sendMessageNullCheck(p2, p, TitleManager.importTitle(p2, StorageManager.mutetoplayer.replace("&", "§").replace("%sender%", p.getName())));
		
										if(StorageManager.uselog == true && StorageManager.readmutes == true){
											LogManager.getLog().info("[MUTE] " + p.getName() + " muted " + p2.getName() + " (UUID: " + p2.getUniqueId().toString() + ").");
										}
									}
									
									List<String> mutedlist = new ArrayList<String>();
									for(UUID muteduuid : StorageManager.mute){
										mutedlist.add(muteduuid.toString());
									}
									ConfigManager.muted.set("MutedUUIDs", mutedlist);
									ConfigManager.saveMuted();
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notonline.replace("&", "§").replace("%receiver%", a[1])));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notoggleotherpermission.replace("&", "§")));
							}
						}
						else{
							if(p.hasPermission("BungeeMSG.mute")){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagemute.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.nomutepermission.replace("&", "§")));
							}
						}
					}
					if(StorageManager.globalcommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						int commandlength = a[0].length();
						boolean hasperm = false;
						
						if(StorageManager.permissionrequiredforglobalmessage == true){
							if(p.hasPermission("BungeeMSG.global")){
								hasperm = true;
							}
						}
						else{
							hasperm = true;
						}
						
						if(hasperm){
							if(!MuteManager.isMuted(p)){
								if(a.length > 1){
									String message = e.getMessage().substring(commandlength + 1);
			
									if(SpamManager.canMessage(p, message, false)){
										if(AdvertiseManager.canChat(p, message)){
											message = SpamManager.checkForCaps(p, message);
											message = BannedWordsManager.checkForBannedWords(p, message);
											message = ColorManager.checkforColors(p, message);
											
											String tosend = StorageManager.globalmessage.replace("&", "§").replace("%cmd%", a[0].toLowerCase()).replace("%msg%", message).replace("%sender%", p.getName()).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§"));
											for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
												Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, tosend));
											}
											
											if(StorageManager.uselog == true && StorageManager.readglobal == true){
												LogManager.getLog().info("[GLOBAL-CMD] " + p.getName() + ": " + message);
											}
										}
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusageglobal.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noglobalpermission.replace("&", "§")));
						}
					}
					if(StorageManager.muteallcommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(p.hasPermission("BungeeMSG.muteall")){
							if(a.length == 1){
								if(StorageManager.allplayersmuted == false){
									StorageManager.allplayersmuted = true;
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutealltosender.replace("&", "§")));
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, StorageManager.mutealltoplayer.replace("&", "§").replace("%sender%", p.getName())));
									}
									
									if(StorageManager.uselog == true && StorageManager.readmuteall == true){
										LogManager.getLog().info("[MUTE-ALL] " + p.getName() + " Enabled Mute All Mode.");
									}
								}
								else{
									StorageManager.allplayersmuted = false;
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.unmutealltosender.replace("&", "§")));
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, StorageManager.unmutealltoplayer.replace("&", "§").replace("%sender%", p.getName())));
									}
			
									if(StorageManager.uselog == true && StorageManager.readmuteall == true){
										LogManager.getLog().info("[MUTE-ALL] " + p.getName() + " Disabled Mute All Mode.");
									}
								}
							}
							else if(a.length == 2){
								ServerInfo server = ProxyServer.getInstance().getServerInfo(a[1]);
								
								if(server != null){
									if(!StorageManager.mutedservers.contains(server)){
										StorageManager.mutedservers.add(server);
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.muteservertosender.replace("&", "§").replace("%server-name%", StorageManager.servernames.get(server).replace("&", "§"))));
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, StorageManager.mutealltoplayer.replace("&", "§").replace("%sender%", p.getName())));
										}
										
										if(StorageManager.uselog == true && StorageManager.readmuteall == true){
											LogManager.getLog().info("[MUTE-ALL] " + p.getName() + " Enabled Mute All Mode for server '" + server.getName() + "'.");
										}
									}
									else{
										StorageManager.mutedservers.remove(server);
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.unmuteservertosender.replace("&", "§").replace("%server-name%", StorageManager.servernames.get(server).replace("&", "§"))));
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											Start.sendMessageNullCheck(player, p, TitleManager.importTitle(player, StorageManager.unmutealltoplayer.replace("&", "§").replace("%sender%", p.getName())));
										}
										
										if(StorageManager.uselog == true && StorageManager.readmuteall == true){
											LogManager.getLog().info("[MUTE-ALL] " + p.getName() + " Disabled Mute All Mode for server '" + server.getName() + "'.");
										}
									}
								}
								else{	
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagemuteall.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
								}
							}
							else{	
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagemuteall.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.nomuteallpermission.replace("&", "§")));
						}
					}
					if(StorageManager.ignorecommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(StorageManager.useignorepermission == false || p.hasPermission("BungeeMSG.ignore")){
							if(a.length > 1){
								ProxiedPlayer toPlayer = null;
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(a[1].equalsIgnoreCase(player.getName())){
										toPlayer = player;
									}
								}
								
								if(toPlayer != null){
									if(toPlayer != p){
										UUID uuid = p.getUniqueId();
										List<UUID> ignored = StorageManager.ignored.get(uuid);
										
										if(ignored != null && ignored.contains(toPlayer.getUniqueId())){
											ignored.remove(toPlayer.getUniqueId());
											Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, StorageManager.noignore.replace("&", "§").replace("%ignored%", toPlayer.getName())));
										}
										else{
											if(ignored == null){
												ignored = new ArrayList<UUID>();
											}
											ignored.add(toPlayer.getUniqueId());;
											Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, StorageManager.ignore.replace("&", "§").replace("%ignored%", toPlayer.getName())));
										}
										StorageManager.ignored.put(uuid, ignored);
			
										if(ignored.size() > 0){
											String ignoredstring = "";
											for(UUID ignoreduuid : ignored){
												if(ignoredstring.equals("")){
													ignoredstring = ignoreduuid.toString();
												}
												else{
													ignoredstring = ignoredstring + "|" + ignoreduuid.toString();
												}
											}
											ConfigManager.playerdata.set("players." + uuid.toString() + ".Ignored", ignoredstring);
										}
										else{
											ConfigManager.playerdata.set("players." + uuid.toString() + ".Ignored", null);
										}
										ConfigManager.savePlayerData();
									}
									else{
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.tothemselves.replace("&", "§")));
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notonline.replace("&", "§").replace("%receiver%", a[1])));
								}
							}
							else{	
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusageignore.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noignorepermission.replace("&", "§")));
						}
					}
					if(StorageManager.reportcommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(a.length >= 3){
							int commandlength = a[0].length();
							
							ProxiedPlayer toPlayer = null;
							
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								if(a[1].equalsIgnoreCase(player.getName())){
									toPlayer = player;
								}
							}
							
							if(toPlayer != null){
								if(toPlayer != p){
									String reason = e.getMessage().substring(commandlength + toPlayer.getName().length() + 2);
									reason = ColorManager.checkforColors(p, reason);
									
									long lastreport = 0;
									if(StorageManager.reportcooldowns.containsKey(p.getName())){
										lastreport = StorageManager.reportcooldowns.get(p.getName());
									}
									int cooldown = StorageManager.reportcooldown * 1000;
											
									if(System.currentTimeMillis() - lastreport >= cooldown){
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.reportedmessage.replace("&", "§").replace("%reported%", toPlayer.getName()).replace("%server-reported%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§")).replace("%reason%", reason)));
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											if(player != p && player.hasPermission("BungeeMSG.notifyreport")){
												Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, StorageManager.reportedstaffmessage.replace("&", "§").replace("%reported%", toPlayer.getName()).replace("%server-reported%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§")).replace("%sender%", p.getName()).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%reason%", reason)));
											}
										}
										
										if(StorageManager.uselog == true && StorageManager.readreports == true){
											LogManager.getLog().info("[REPORT] (" + p.getServer().getInfo().getName() + ") " + p.getName() + " > (" + toPlayer.getServer().getInfo().getName() + ") " + toPlayer.getName() + " (Reason: " + reason + ")");
										}
										
										StorageManager.reportcooldowns.put(p.getName(), System.currentTimeMillis());
									}
									else{
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.reportoncooldown.replace("&", "§")));
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.tothemselves.replace("&", "§")));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notonline.replace("&", "§").replace("%receiver%", a[1])));
							}
						}
						else{	
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagereport.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
						}
					}
					if(StorageManager.helpopcommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(a.length >= 2){
							int commandlength = a[0].length();
							
							String reason = e.getMessage().substring(commandlength +1);
							reason = ColorManager.checkforColors(p, reason);
							
							long lasthelpop = 0;
							if(StorageManager.helpopcooldowns.containsKey(p.getName())){
								lasthelpop = StorageManager.helpopcooldowns.get(p.getName());
							}
							int cooldown = StorageManager.helpopcooldown * 1000;
									
							if(System.currentTimeMillis() - lasthelpop >= cooldown){
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.helpopmessage.replace("&", "§").replace("%reason%", reason)));
								
								for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
									if(player != p && player.hasPermission("BungeeMSG.notifyhelpop")){
										Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, StorageManager.helpopstaffmessage.replace("&", "§").replace("&", "§")).replace("%sender%", p.getName()).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%reason%", reason));
									}
								}
								
								if(StorageManager.uselog == true && StorageManager.readhelpops == true){
									LogManager.getLog().info("[HELPOP] (" + p.getServer().getInfo().getName() + ") " + p.getName() + ": " + reason);
								}
								
								StorageManager.helpopcooldowns.put(p.getName(), System.currentTimeMillis());
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.helpoponcooldown.replace("&", "§")));
							}
						}
						else{	
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagehelpop.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
						}
					}
					if(StorageManager.messagecommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
							
						if(StorageManager.usemessagepermission == true && p.hasPermission("BungeeMSG.msg") || StorageManager.usemessagepermission == false){
							int commandlength = a[0].length();
							
							if(!MuteManager.isMuted(p)){
								if(a.length >= 3){
									ProxiedPlayer toPlayer = null;
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(a[1].equalsIgnoreCase(player.getName())){
											toPlayer = player;
										}
									}
									
									if(toPlayer != null){
										if(toPlayer != p){
											if(!StorageManager.toggle.containsKey(p.getName()) || StorageManager.toggle.get(p.getName()) == true){
												String message = e.getMessage().substring(commandlength + toPlayer.getName().length() + 2);
												
												if(SpamManager.canMessage(p, message, true)){
													if(AdvertiseManager.canChat(p, message)){
														message = SpamManager.checkForCaps(p, message);
														message = BannedWordsManager.checkForBannedWords(p, message);
														message = ColorManager.checkforColors(p, message);
														
														if(StorageManager.toggle.containsKey(toPlayer.getName()) && StorageManager.toggle.get(toPlayer.getName()) == false){
															if(StorageManager.tellsenderifdisabled == true){
																Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.disabledmessage.replace("&", "§").replace("%receiver%", toPlayer.getName())));
															}
															else{
																String tosender = StorageManager.tosender.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));
																if(!IgnoreManager.isIgnored(p, toPlayer, tosender)){
																	Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, tosender));
																}
															}
														}
														else{
															String tosender = StorageManager.tosender.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));
															
															if(!IgnoreManager.isIgnored(p, toPlayer, tosender)){
																String toreceiver = StorageManager.toreceiver.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));
																Start.sendMessageNullCheck(toPlayer, p, TitleManager.importTitle(toPlayer, toreceiver));
															
																Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, tosender));
																for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
																	if(StorageManager.spy.containsKey(player.getName()) && StorageManager.spy.get(player.getName()) == true){
																		String tospy = StorageManager.spyprefix.replace("&", "§") + StorageManager.spymessage.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));;
																		Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, tospy));
																	}
																	else{
																		if(player.hasPermission("BungeeMSG.spy.on") || player.hasPermission("BungeeMSG.spy.*")){
																			StorageManager.spy.put(player.getName(), true);
																			String tospy = StorageManager.spyprefix.replace("&", "§") + StorageManager.spymessage.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));;
																			Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, tospy));
																		}
																	}
																}
																if(StorageManager.infoenabled == true && StorageManager.lastmsg.get(toPlayer) == null){
																	Start.sendMessageNullCheck(toPlayer, null, TitleManager.importTitle(toPlayer, StorageManager.info.replace("&", "§")));
																}
																StorageManager.lastmsg.put(toPlayer, p);
																StorageManager.lastmsg.put(p, toPlayer);
																
																if(StorageManager.uselog == true && StorageManager.readprivatemessages == true){
																	LogManager.getLog().info("[MSG] " + p.getName() + " > " + toPlayer.getName() + ": " + message);
																}
															}
														}
													}
												}
											}
											else{
												Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.toggleonsend.replace("&", "§")));
											}
										}
										else{
											Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.tothemselves.replace("&", "§")));
										}
									}
									else{
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.notonline.replace("&", "§").replace("%receiver%", a[1])));
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagemsg.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.nomessagepermission.replace("&", "§")));
						}
					}
					if(StorageManager.replycommand.contains(a[0].toLowerCase())){
						e.setCancelled(true);
						
						if(StorageManager.usereplypermission == true && p.hasPermission("BungeeMSG.reply") || StorageManager.usereplypermission == false){
							int commandlength = a[0].length();
							
							if(!MuteManager.isMuted(p)){
								if(a.length >= 2){
									if(StorageManager.lastmsg.containsKey(p)){
										ProxiedPlayer toPlayer = null;
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											if(StorageManager.lastmsg.get(p) == player){
												toPlayer = player;
											}
										}
										
										if(toPlayer != null){
											if(!StorageManager.toggle.containsKey(p.getName()) || StorageManager.toggle.get(p.getName()) == true){
												String message = e.getMessage().substring(commandlength + 1);
			
												if(SpamManager.canMessage(p, message, true)){
													if(AdvertiseManager.canChat(p, message)){
														message = SpamManager.checkForCaps(p, message);
														message = BannedWordsManager.checkForBannedWords(p, message);
														message = ColorManager.checkforColors(p, message);
														
														if(StorageManager.toggle.containsKey(toPlayer.getName()) && StorageManager.toggle.get(toPlayer.getName()) == false){
															if(StorageManager.tellsenderifdisabled == true){
																Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, StorageManager.disabledmessage.replace("&", "§").replace("%receiver%", toPlayer.getName())));
															}
															else{
																String tosender = StorageManager.tosender.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));
																if(!IgnoreManager.isIgnored(p, toPlayer, tosender)){
																	Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, tosender));
																}
															}
														}
														else{
															String tosender = StorageManager.tosender.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));
			
															if(!IgnoreManager.isIgnored(p, toPlayer, tosender)){
																Start.sendMessageNullCheck(toPlayer, p, TitleManager.importTitle(toPlayer, StorageManager.toreceiver.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message)).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§")));
																
																Start.sendMessageNullCheck(p, toPlayer, TitleManager.importTitle(p, tosender));
																for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
																	if(StorageManager.spy.containsKey(player.getName()) && StorageManager.spy.get(player.getName()) == true){
																		String tospy = StorageManager.spyprefix.replace("&", "§") + StorageManager.spymessage.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));;
																		Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, tospy));
																	}
																	else{
																		if(player.hasPermission("BungeeMSG.spy.on") || player.hasPermission("BungeeMSG.spy.*")){
																			StorageManager.spy.put(player.getName(), true);
																			String tospy = StorageManager.spyprefix.replace("&", "§") + StorageManager.spymessage.replace("&", "§").replace("%sender%", p.getName()).replace("%receiver%", toPlayer.getName()).replace("%msg%", message).replace("%server-sender%", StorageManager.servernames.get(p.getServer().getInfo()).replace("&", "§")).replace("%server-receiver%", StorageManager.servernames.get(toPlayer.getServer().getInfo()).replace("&", "§"));;
																			Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, tospy));
																		}
																	}
																}
																StorageManager.lastmsg.put(toPlayer, p);
																StorageManager.lastmsg.put(p, toPlayer);
																
																if(StorageManager.uselog == true && StorageManager.readprivatemessages == true){
																	LogManager.getLog().info("[MSG] " + p.getName() + " > " + toPlayer.getName() + ": " + message);
																}
															}
														}
													}
												}
											}
											else{
												Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.toggleonsend.replace("&", "§")));
											}
										}						
										else{
											StorageManager.lastmsg.remove(p);
											Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noreceiver.replace("&", "§")));
										}
									}
									else{
										Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noreceiver.replace("&", "§")));
									}
								}
								else{
									Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.wrongusagereply.replace("&", "§").replace("%cmd%", a[0].toLowerCase())));
								}
							}
							else{
								Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.mutedmessage.replace("&", "§")));
							}
						}
						else{
							Start.sendMessageNullCheck(p, null, TitleManager.importTitle(p, StorageManager.noreplypermission.replace("&", "§")));
						}
					}
				}
			}
		}
	}
}
