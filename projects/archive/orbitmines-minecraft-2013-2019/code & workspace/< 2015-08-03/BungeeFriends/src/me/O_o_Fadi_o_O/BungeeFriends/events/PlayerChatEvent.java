package me.O_o_Fadi_o_O.BungeeFriends.events;

import java.util.UUID;

import me.O_o_Fadi_o_O.BungeeFriends.Start;
import me.O_o_Fadi_o_O.BungeeFriends.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.FriendManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.StorageManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerChatEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(ChatEvent e){
		Connection c = e.getSender();
		
		String lowercaseMessage = e.getMessage().toLowerCase();
		
		if(c instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) c;
			if(lowercaseMessage.startsWith("/friends")){
				String[] a = e.getMessage().split(" ");
				
				if(a[0].equalsIgnoreCase("/friends")){
					e.setCancelled(true);
					
					if(a.length == 1){
						FriendManager.sendFriendMessage(p);
					}
					else if(a.length == 3){
						if(a[1].equalsIgnoreCase("invite")){
							ProxiedPlayer invitedPlayer = null;
							
							for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
								if(a[2].equalsIgnoreCase(player.getName())){
									invitedPlayer = player;
								}
							}
							
							if(invitedPlayer != null){	
								if(invitedPlayer != p){
									if(!StorageManager.friends.containsKey(p.getUniqueId())){
										FriendManager.sendInvite(p, invitedPlayer);
									}
									else{
										if(!StorageManager.friends.get(p.getUniqueId()).contains(invitedPlayer.getUniqueId())){
											if(StorageManager.friends.get(p.getUniqueId()).size() != StorageManager.maxfriends){
												FriendManager.sendInvite(p, invitedPlayer);
											}
											else{
												p.sendMessage(StorageManager.hasmaxfriends.replaceAll("&", "§").replaceAll("%max%", "" + StorageManager.maxfriends));
											}
										}
										else{
											p.sendMessage(StorageManager.alreadyfriend.replaceAll("&", "§").replaceAll("%invited%", invitedPlayer.getName()));
										}
									}
								}
								else{
									p.sendMessage(StorageManager.tothemselves.replaceAll("&", "§"));
								}
							}
							else{
								p.sendMessage(StorageManager.notonline.replaceAll("&", "§").replaceAll("%invited%", a[1]));
							}
						}
						else if(a[1].equalsIgnoreCase("remove")){
							UUID friendUUID = null;
							UUID uuid = p.getUniqueId();
							for(UUID uuids : StorageManager.lastname.keySet()){
								if(StorageManager.lastname.get(uuids).equalsIgnoreCase(a[2])){
									friendUUID = uuids;
								}
							}
							if(StorageManager.friends.containsKey(uuid) && StorageManager.friends.get(uuid).contains(friendUUID)){
								FriendManager.removeFriend(p, friendUUID, a[2]);
							}
							else{
								StorageManager.notyourfriend.replaceAll("&", "§").replaceAll("%removed%", a[2]);
							}
						}
						else{
							FriendManager.sendFriendMessage(p);
						}
					}
					else if(a.length == 2){
						if(a[1].equalsIgnoreCase("reload")){
							if(p.hasPermission("BungeeFriends.reload")){
								p.sendMessage("§7Reloading §6config.yml§7...");
								ConfigManager.reloadConfig();
								Start.loadConfigData();
								p.sendMessage("§7Reloading §6playerdata.yml§7...");
								ConfigManager.reloadPlayerData();
								Start.loadPlayerDataData();
								p.sendMessage("§7Reload §aCompleted§7!");
							}
							else{
								p.sendMessage(StorageManager.noreloadpermission.replaceAll("&", "§"));
							}
						}
						else if(a[1].equalsIgnoreCase("accept")){
							if(StorageManager.friendrequest.containsKey(p)){
								if(StorageManager.friendrequest.get(p) != null){
									UUID uuid = p.getUniqueId();
									if(StorageManager.friends.containsKey(uuid)){
										if(!StorageManager.friends.get(uuid).contains(StorageManager.friendrequest.get(p).getUniqueId())){
											if(StorageManager.friends.get(uuid).size() != StorageManager.maxfriends){
												FriendManager.acceptInvite(p);
											}
											else{
												p.sendMessage(StorageManager.hasmaxfriends.replaceAll("&", "§").replaceAll("%max%", "" + StorageManager.maxfriends));
												StorageManager.friendrequest.remove(p);
											}
										}
										else{
											p.sendMessage(StorageManager.alreadyfriend.replaceAll("&", "§").replaceAll("%invited%", StorageManager.friendrequest.get(p).getName()));
											StorageManager.friendrequest.remove(p);
										}
									}
									else{
										FriendManager.acceptInvite(p);
									}
								}
								else{
									p.sendMessage(StorageManager.norequest.replaceAll("&", "§"));
								}
							}
							else{
								p.sendMessage(StorageManager.norequest.replaceAll("&", "§"));
							}
						}
						else if(a[1].equalsIgnoreCase("reject")){
							if(StorageManager.friendrequest.containsKey(p)){
								if(StorageManager.friendrequest.get(p) != null){
									String friend = StorageManager.friendrequest.get(p).getName();
									StorageManager.friendrequest.remove(p);
									p.sendMessage(StorageManager.denyinvited.replaceAll("&", "§").replaceAll("%inviter%", friend));
									
									ProxiedPlayer p2 = null;
									
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(friend.equalsIgnoreCase(player.getName())){
											p2 = player;
										}
									}
									
									if(p2 != null){
										p2.sendMessage(StorageManager.denyinviter.replaceAll("&", "§").replaceAll("%invited%", p.getName()));
									}
								}
								else{
									p.sendMessage(StorageManager.norequest.replaceAll("&", "§"));
								}
							}
							else{
								p.sendMessage(StorageManager.norequest.replaceAll("&", "§"));
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
		}
	}
}
