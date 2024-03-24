package me.O_o_Fadi_o_O.BungeeFriends.events;

import java.util.UUID;

import me.O_o_Fadi_o_O.BungeeFriends.Start;
import me.O_o_Fadi_o_O.BungeeFriends.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.StorageManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerConnectEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onJoin(ServerConnectEvent e){
		
		final ProxiedPlayer p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		
		if(!StorageManager.lastname.containsKey(uuid)){
			loadNewPlayer(p, e.getTarget().getName());
		}
	}
	
	private void loadNewPlayer(ProxiedPlayer p, String target){
		UUID uuid = p.getUniqueId();
		String date = Start.getDate();
		
		ConfigManager.playerdata.set(uuid.toString() + ".LastName", p.getName());
		ConfigManager.playerdata.set(uuid.toString() + ".LastOnline", date);
		ConfigManager.playerdata.set(uuid.toString() + ".LastSeen", target);
		ConfigManager.savePlayerData();
		
		StorageManager.lastname.put(uuid, p.getName());
		StorageManager.lastonline.put(uuid, date);
		StorageManager.lastseen.put(uuid, target);
	}
}
