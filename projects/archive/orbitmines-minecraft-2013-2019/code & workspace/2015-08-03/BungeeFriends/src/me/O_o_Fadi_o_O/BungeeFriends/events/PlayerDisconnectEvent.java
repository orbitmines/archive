package me.O_o_Fadi_o_O.BungeeFriends.events;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.BungeeFriends.Start;
import me.O_o_Fadi_o_O.BungeeFriends.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.FriendManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.StorageManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectEvent implements Listener{
	
	@EventHandler
	public void onDisconnect(ServerDisconnectEvent e){
		ProxiedPlayer p = e.getPlayer();
		
		if(e.getTarget() == null || e.getTarget() == e.getPlayer().getServer().getInfo()){
			updatePlayerData(p, e.getPlayer().getServer().getInfo().getName());
		}
	}
	
	public static void updatePlayerData(ProxiedPlayer p, String server){
		UUID uuid = p.getUniqueId();
		String date = Start.getDate();
		
		ConfigManager.playerdata.set(uuid.toString() + ".LastName", p.getName());
		ConfigManager.playerdata.set(uuid.toString() + ".LastOnline", date);
		ConfigManager.playerdata.set(uuid.toString() + ".LastSeen", server);
		if(StorageManager.friends.containsKey(uuid)){
			List<UUID> friends = StorageManager.friends.get(uuid);
			String friendsS = "";
			for(UUID friend : friends){
				friendsS = friendsS + "|" + friend.toString();
			}
			
			if(friendsS.startsWith("|")){
				friendsS = friendsS.substring(1);
			}
			
			FriendManager.setFriends(uuid, friendsS);
		}
		ConfigManager.savePlayerData();
	}
}
