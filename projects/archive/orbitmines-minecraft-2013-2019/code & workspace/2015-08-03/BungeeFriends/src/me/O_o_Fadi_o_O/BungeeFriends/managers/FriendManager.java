package me.O_o_Fadi_o_O.BungeeFriends.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class FriendManager {

	@SuppressWarnings("deprecation")
	public static void sendFriendMessage(ProxiedPlayer p){
		UUID uuid = p.getUniqueId();
	
		if(StorageManager.friends.containsKey(uuid)){
			for(String s : StorageManager.friendsmessage){
				if(!s.startsWith("%if-no-friends%") || s.startsWith("%import-all-friends%")){
					if(s.startsWith("%import-all-friends%")){
						String tosend = s.replaceAll("&", "§").replaceAll("%import-all-friends%", "");
						for(UUID friendUUID : StorageManager.friends.get(uuid)){
							String friend = StorageManager.lastname.get(friendUUID);

							if(isOnline(friend)){
								tosend = tosend.replaceAll("%online-color%", StorageManager.statuscoloronline.replaceAll("&", "§"));
								String[] tosendparts = tosend.split("\\%");
								TextComponent[] tcs = new TextComponent[tosendparts.length];
								int index = 0;
								
								for(String s2 : tosendparts){
									if(s2.equals("friend-name")){
										TextComponent tc = new TextComponent(friend);
										tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hoverfriendonlinebutton.replaceAll("&", "§").replaceAll("%uuid%", friendUUID.toString())).create()));
										tcs[index] = tc;
									}
									else if(s2.equals("server-name")){
										ProxiedPlayer p2 = null;
										
										for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
											if(friend.equalsIgnoreCase(player.getName())){
												p2 = player;
											}
										}
										ServerInfo si = p2.getServer().getInfo();
										
										TextComponent tc = new TextComponent(StorageManager.servernames.get(si).replaceAll("&", "§"));
										tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server " + si.getName()));
										tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hoverserverbutton.replaceAll("&", "§").replaceAll("%server-name%", si.getName())).create()));
										tcs[index] = tc;
									}
									else if(s2.equals("remove-button")){
										TextComponent tc = new TextComponent(StorageManager.removebutton.replaceAll("&", "§"));
										tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friend remove " + friend));
										tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hoverremovebutton.replaceAll("&", "§").replaceAll("%friend-name%", friend)).create()));
										tcs[index] = tc;
									}
									else{
										TextComponent tc = new TextComponent(s2);
										tcs[index] = tc;
									}
									index++;
								}
								
								p.sendMessage(tcs);
							}
							else{
								
								//TODO
							}
						}
					}
					else{
						p.sendMessage(s.replaceAll("&", "§"));
					}
				}
			}
		}
		else{
			for(String s : StorageManager.friendsmessage){
				if(s.startsWith("%if-no-friends%") || !s.startsWith("%import-all-friends%")){
					p.sendMessage(s.replaceAll("&", "§").replaceAll("%if-no-friends%", ""));
				}
			}
		}
	}
	
	public static boolean isOnline(String p){
		
		boolean online = false;
		
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(p.equalsIgnoreCase(player.getName())){
				online = true;
			}
		}
		
		return online;
	}
	
	@SuppressWarnings("deprecation")
	public static void sendInvite(ProxiedPlayer p, ProxiedPlayer invitedPlayer){
		for(String s : StorageManager.invitedmessage){
			String tosend = s.replaceAll("&", "§").replaceAll("%inviter%", p.getName());
			if(tosend.contains("%accept-button%") || tosend.contains("%deny-button%")){
				String[] tosendparts = tosend.split("\\%");
				TextComponent[] tcs = new TextComponent[tosendparts.length];
				int index = 0;
				for(String s2 : tosendparts){
					if(s2.equals("accept-button")){
						TextComponent tc = new TextComponent(StorageManager.acceptbutton.replaceAll("&", "§"));
						tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends accept"));
						tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hoveracceptbutton.replaceAll("&", "§")).create()));
						tcs[index] = tc;
					}
					else if(s2.equals("deny-button")){
						TextComponent tc = new TextComponent(StorageManager.denybutton.replaceAll("&", "§"));
						tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends deny"));
						tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hoverdenybutton.replaceAll("&", "§")).create()));
						tcs[index] = tc;
					}
					else{
						TextComponent tc = new TextComponent(s2);
						tcs[index] = tc;
					}
					index++;
				}
				
				invitedPlayer.sendMessage(tcs);
			}
			else{
				invitedPlayer.sendMessage(tosend);
			}
		}
		
		for(String s : StorageManager.invitermessage){
			p.sendMessage(s.replaceAll("&", "§").replaceAll("%invited%", invitedPlayer.getName()));
		}
		StorageManager.friendrequest.put(invitedPlayer, p);
	}
	
	@SuppressWarnings("deprecation")
	public static void removeFriend(ProxiedPlayer p, UUID friendUUID, String friendString){
		UUID uuid = p.getUniqueId();
		
		List<UUID> friends = StorageManager.friends.get(uuid);
		friends.remove(friendUUID);
		
		if(friends.size() != 0){
			StorageManager.friends.put(uuid, friends);
			
			String friendsS = "";
			
			for(UUID friend : friends){
				friendsS = friendsS + "|" + friend.toString();
			}
			
			if(friendsS.startsWith("|")){
				friendsS = friendsS.substring(1);
			}
			setFriends(uuid, friendsS);
		}
		else{
			StorageManager.friends.remove(uuid);
			removeFriendsPath(uuid);
		}
		p.sendMessage(StorageManager.removed.replaceAll("&", "§").replaceAll("%removed%", friendString));
		
		List<UUID> friends2 = StorageManager.friends.get(friendUUID);
		friends2.remove(uuid);
		
		if(friends2.size() != 0){
			StorageManager.friends.put(friendUUID, friends2);
			
			String friendsS2 = "";
			
			for(UUID friend2 : friends2){
				friendsS2 = friendsS2 + "|" + friend2.toString();
			}
			
			if(friendsS2.startsWith("|")){
				friendsS2 = friendsS2.substring(1);
			}
			setFriends(uuid, friendsS2);
		}
		else{
			StorageManager.friends.remove(friendUUID);
			removeFriendsPath(uuid);
		}
		
		ProxiedPlayer p2 = null;
		
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(friendString.equalsIgnoreCase(player.getName())){
				p2 = player;
			}
		}
		
		if(p2 != null){
			p2.sendMessage(StorageManager.removedfriend.replaceAll("&", "§").replaceAll("%remover%", p.getName()));
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void acceptInvite(ProxiedPlayer p){
		UUID uuid = p.getUniqueId();
		if(StorageManager.friends.containsKey(uuid)){
			List<UUID> friends = StorageManager.friends.get(uuid);
			UUID friendUUID = StorageManager.friendrequest.get(p).getUniqueId();
			friends.add(friendUUID);
			
			String friendsS = "";
			
			for(UUID friend : friends){
				friendsS = friendsS + "|" + friend.toString();
			}
			
			if(friendsS.startsWith("|")){
				friendsS = friendsS.substring(1);
			}
			
			setFriends(uuid, friendsS);
	
			String friend = StorageManager.friendrequest.get(p).getName();
			p.sendMessage(StorageManager.acceptinvited.replaceAll("&", "§").replaceAll("%inviter%", friend));
			
			if(StorageManager.friends.containsKey(friendUUID)){
				
				List<UUID> friends2 = StorageManager.friends.get(friendUUID);
				friends2.add(uuid);
				
				String friendsS2 = "";
				
				for(UUID friend2 : friends2){
					friendsS2 = friendsS2 + "|" + friend2.toString();
				}
				
				if(friendsS2.startsWith("|")){
					friendsS2 = friendsS2.substring(1);
				}
				
				setFriends(friendUUID, friendsS2);
				
				ProxiedPlayer p2 = null;
				
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(friend.equalsIgnoreCase(player.getName())){
						p2 = player;
					}
				}
				
				if(p2 != null){
					p2.sendMessage(StorageManager.acceptinviter.replaceAll("&", "§").replaceAll("%invited%", p.getName()));
				}
			}
			else{
				List<UUID> friends2 = new ArrayList<UUID>();
				friends2.add(uuid);
				StorageManager.friends.put(friendUUID, friends2);
				
				setFriends(friendUUID, uuid.toString());
				
				ProxiedPlayer p2 = null;
				
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(friend.equalsIgnoreCase(player.getName())){
						p2 = player;
					}
				}
				
				if(p2 != null){
					p2.sendMessage(StorageManager.acceptinviter.replaceAll("&", "§").replaceAll("%invited%", p.getName()));
				}
			}
		}
		else{
			List<UUID> friends = new ArrayList<UUID>();
			UUID friendUUID = StorageManager.friendrequest.get(p).getUniqueId();
			String friend = StorageManager.friendrequest.get(p).getName();
			friends.add(friendUUID);
			StorageManager.friends.put(uuid, friends);
			StorageManager.friendrequest.remove(p);
			
			setFriends(uuid, friendUUID.toString());
			p.sendMessage(StorageManager.acceptinvited.replaceAll("&", "§").replaceAll("%inviter%", friend));
			
			if(StorageManager.friends.containsKey(friendUUID)){
				
				List<UUID> friends2 = StorageManager.friends.get(friendUUID);
				friends2.add(uuid);
				
				String friendsS2 = "";
				
				for(UUID friend2 : friends2){
					friendsS2 = friendsS2 + "|" + friend2.toString();
				}
				
				if(friendsS2.startsWith("|")){
					friendsS2 = friendsS2.substring(1);
				}
				
				setFriends(friendUUID, friendsS2);
				
				ProxiedPlayer p2 = null;
				
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(friend.equalsIgnoreCase(player.getName())){
						p2 = player;
					}
				}
				
				if(p2 != null){
					p2.sendMessage(StorageManager.acceptinviter.replaceAll("&", "§").replaceAll("%invited%", p.getName()));
				}
			}
			else{
				List<UUID> friends2 = new ArrayList<UUID>();
				friends2.add(uuid);
				StorageManager.friends.put(friendUUID, friends2);
				
				setFriends(friendUUID, uuid.toString());
				
				ProxiedPlayer p2 = null;
				
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(friend.equalsIgnoreCase(player.getName())){
						p2 = player;
					}
				}
				
				if(p2 != null){
					p2.sendMessage(StorageManager.acceptinviter.replaceAll("&", "§").replaceAll("%invited%", p.getName()));
				}
			}
		}
	}
	
	public static void setFriends(UUID uuid, String friends){
		ConfigManager.playerdata.set(uuid.toString() + ".Friends", friends);
		ConfigManager.savePlayerData();
	}
	
	public static void removeFriendsPath(UUID uuid){
		ConfigManager.playerdata.set(uuid.toString() + ".Friends", null);
		ConfigManager.savePlayerData();
	}
}
