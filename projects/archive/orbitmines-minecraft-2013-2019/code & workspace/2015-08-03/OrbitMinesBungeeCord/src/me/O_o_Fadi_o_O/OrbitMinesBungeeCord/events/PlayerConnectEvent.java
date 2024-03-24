package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.BanManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DatabaseManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.FriendManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.VIPRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.scheduler.BungeeScheduler;

public class PlayerConnectEvent implements Listener{
	
	Start start = Start.getInstance();
	
	private Map<String, Long> lastconnected = new HashMap<String, Long>();
	private final int connectcooldown = 1;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(ServerConnectEvent e) throws ParseException{
		
		final ProxiedPlayer p = e.getPlayer();
		
		DatabaseManager.checkForOldUser(p);

		UUID uuid = p.getUniqueId();
		
		if(Start.staffpasswords.containsKey(p.getName()) && !Start.stafflogin.containsKey(p)){
			Start.stafflogin.put(p, false);
			Start.stafflogintimeleft.put(p, 15);
		}
			
		long lastconnect = 0;
		if(lastconnected.containsKey(p.getName())){
			lastconnect = lastconnected.get(p.getName());
		}
		int cdmillis = connectcooldown * 1000;
				
		if(System.currentTimeMillis()-lastconnect>=cdmillis){
			DatabaseManager.setLastOnline(p);
		
			DatabaseManager.setUUID(p);
			
			if(!Start.ips.containsKey(uuid)){
				String ip = p.getAddress().getHostString();
				if(DatabaseManager.containsPath("uuid", "PlayerIPs", uuid.toString())){
					DatabaseManager.setIP(p.getUniqueId(), ip);
					Start.ips.put(uuid, ip);
				}
				else{
					DatabaseManager.insertString(uuid, "PlayerIPs", "ip", ip);
					Start.ips.put(uuid, ip);
				}
			}
			
			if(DatabaseManager.containsPath("uuid", "Rank-VIP", uuid.toString())){
				Start.viprank.put(uuid, VIPRank.valueOf(DatabaseManager.getString(p.getUniqueId(), "Rank-VIP", "vip")));
			}
			else{
				Start.viprank.put(uuid, VIPRank.User);
			}
			
			if(DatabaseManager.containsPath("uuid", "Rank-Staff", uuid.toString())){
				Start.staffrank.put(uuid, StaffRank.valueOf(DatabaseManager.getString(p.getUniqueId(), "Rank-Staff", "staff")));
			}
			else{
				Start.staffrank.put(uuid, StaffRank.User);
			}
			
			if(Start.maintenancemode == true){
				if(!Start.hasStaffPerms(p, StaffRank.Owner)){
					e.setCancelled(true);
					p.disconnect("§d§lMaintenance Mode\n§dWe're currently working on something!\n§d§oThank you, for your understanding!");
				}
			}
			if(Start.hasStaffPerms(p, StaffRank.Moderator)){
				if(!Start.showstaffmessage.containsKey(uuid)){
					Start.showstaffmessage.put(uuid, true);
				}
				if(!Start.allchat.containsKey(uuid)){
					Start.allchat.put(uuid, false);
				}
				if(!Start.silent.containsKey(uuid)){
					if(DatabaseManager.containsPath("uuid", "PlayerSilentJoin", uuid.toString())){
						boolean b = Boolean.parseBoolean(DatabaseManager.getString(p.getUniqueId(), "PlayerSilentJoin", "silentjoin"));
						Start.silent.put(uuid, b);
					}
					else{
						DatabaseManager.insertString(p.getUniqueId(), "PlayerSilentJoin", "silentjoin", "false");
						Start.silent.put(uuid, false);
					}
				}
			}
			
			if(DatabaseManager.containsPath("uuid", "Friends", uuid.toString())){
				String[] friends = DatabaseManager.getString(p.getUniqueId(), "Friends", "friends").split("\\|");
				List<UUID> friendsL = new ArrayList<UUID>();
				
				for(String friend : friends){
					friendsL.add(UUID.fromString(friend));
				}
				
				FriendManager.playerfriends.put(uuid, friendsL);
			}
			
			if(!Start.bannedplayers.contains(uuid)){
				if(DatabaseManager.containsPath("uuid", "PlayerBans", uuid.toString())){
					
					String BannedByPlayer = DatabaseManager.getBannedInfo(p.getUniqueId(), "bannedby");
					String BannedReason = DatabaseManager.getBannedInfo(p.getUniqueId(), "reason");
					String BannedOn = DatabaseManager.getBannedInfo(p.getUniqueId(), "bannedon");
					String BannedUntil = DatabaseManager.getBannedInfo(p.getUniqueId(), "banneduntil");
					
					Date now = new Date(Calendar.getInstance().getTimeInMillis());
	
					DateFormat dfUntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date bannedUntilDate = dfUntil.parse(BannedUntil);
					
					if(now.compareTo(bannedUntilDate) >= 0){
						
						BanManager.unbanPlayer(p.getName());
						
					}
					else{
						
						Start.bannedplayers.add(uuid.toString());
						Start.bannedby.put(uuid.toString(), BannedByPlayer);
						Start.bannedreason.put(uuid.toString(), BannedReason.replaceAll("`", "'"));
						Start.bannedon.put(uuid.toString(), BannedOn);
						Start.banneduntil.put(uuid.toString(), BannedUntil);
						
						p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(uuid.toString()) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(uuid.toString()) + "\n§cReason: §6§l" + Start.bannedreason.get(uuid.toString()));
						e.setCancelled(true);
					}
				}
			}
			else{
				Date now = new Date(Calendar.getInstance().getTimeInMillis());
				
				DateFormat dfUntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date bannedUntilDate = dfUntil.parse(Start.banneduntil.get(uuid.toString()));
				
				
				if(now.compareTo(bannedUntilDate) >= 0){
					
					BanManager.unbanPlayer(p.getName());
					
				}
				else{
					p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(uuid.toString()) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(uuid.toString()) + "\n§cReason: §6§l" + Start.bannedreason.get(uuid.toString()));
					e.setCancelled(true);
				}
			}
			
			String ip = p.getAddress().getHostString();
			if(!Start.bannedips.contains(ip)){
				if(DatabaseManager.containsPath("ip", "PlayerIPBans", ip)){
					
					String BannedByPlayer = DatabaseManager.getBannedIPInfo(ip, "bannedby");
					String BannedReason = DatabaseManager.getBannedIPInfo(ip, "reason");
					String BannedOn = DatabaseManager.getBannedIPInfo(ip, "bannedon");
					String BannedUntil = DatabaseManager.getBannedIPInfo(ip, "banneduntil");
					
					Date now = new Date(Calendar.getInstance().getTimeInMillis());
	
					DateFormat dfUntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date bannedUntilDate = dfUntil.parse(BannedUntil);
					
					if(now.compareTo(bannedUntilDate) >= 0){
						
						BanManager.unbanIP(ip);
						
					}
					else{
						
						Start.bannedips.add(ip);
						Start.bannedby.put(ip, BannedByPlayer);
						Start.bannedreason.put(ip, BannedReason.replaceAll("`", "'"));
						Start.bannedon.put(ip, BannedOn);
						Start.banneduntil.put(ip, BannedUntil);
						
						p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(ip) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(ip) + "\n§cReason: §6§l" + Start.bannedreason.get(ip));
						e.setCancelled(true);
					}
				}
			}
			else{
				Date now = new Date(Calendar.getInstance().getTimeInMillis());
				
				DateFormat dfUntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date bannedUntilDate = dfUntil.parse(Start.banneduntil.get(ip));
				
				
				if(now.compareTo(bannedUntilDate) >= 0){
					
					BanManager.unbanIP(ip);
					
				}
				else{
					p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + Start.bannedby.get(ip) + "§c)\n§cUnban On: §6§l" + Start.banneduntil.get(ip) + "\n§cReason: §6§l" + Start.bannedreason.get(ip));
					e.setCancelled(true);
				}
			}
			
			boolean joinquit = true;
			
			if(p.getServer() != null){
				if(p.getServer().getInfo() == e.getTarget()){
					joinquit = false;
				}
			}
			
			if(!e.isCancelled() && joinquit){
				
				isTruelyConnected(e.getTarget(), p);

			}
			lastconnected.put(p.getName(), System.currentTimeMillis());
		}
	}
	
	public synchronized void isTruelyConnected(final ServerInfo target, final ProxiedPlayer p){
		
		final UUID uuid = p.getUniqueId();
		
		new BungeeScheduler().schedule(this.start, new Runnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				if(Start.connectedto.get(uuid) == target){
					if(!Start.silent.containsKey(uuid) || Start.silent.containsKey(uuid) && Start.silent.get(uuid) == false){
						if(target != null){
							for(ProxiedPlayer player : target.getPlayers()){
								player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§o" + Start.getServerNameWithoutColor(target.getName()) + "§2§o)");
							}
							if(FriendManager.playerfriends.containsKey(uuid)){
								List<UUID> friends = FriendManager.playerfriends.get(uuid);
								
								if(!Start.silent.containsKey(uuid) || Start.silent.containsKey(uuid) && Start.silent.get(uuid) == false){
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(friends.contains(player.getUniqueId())){
											player.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 joined " + Start.getServerName(target.getName()) + "§7.");
										}
									}
								}
							}
						}
					}
					else{
						if(target != null){
							for(ProxiedPlayer player : target.getPlayers()){
								if(Start.hasStaffPerms(player, StaffRank.Moderator)){
									player.sendMessage("§2§l§o>> " + p.getName() + " §2§o(§a§o" + Start.getServerNameWithoutColor(target.getName()) + "§2§o) §6§l[Silent Mode]");
								}
							}
							if(FriendManager.playerfriends.containsKey(uuid)){
								List<UUID> friends = FriendManager.playerfriends.get(uuid);
								
								if(!Start.silent.containsKey(uuid) || Start.silent.containsKey(uuid) && Start.silent.get(uuid) == false){
									for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
										if(friends.contains(player.getUniqueId())){
											player.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 joined " + Start.getServerName(target.getName()) + "§7. §6§l[Silent Mode]");
										}
									}
								}
							}
						}
					}
				}
			}
		}, 2, TimeUnit.SECONDS);

	}
}
