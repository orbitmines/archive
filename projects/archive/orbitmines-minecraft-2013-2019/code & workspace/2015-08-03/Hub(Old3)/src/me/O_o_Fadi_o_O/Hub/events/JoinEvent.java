package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {
	
	Hub hub = Hub.getInstance();
	PlayerManager pmanager = new PlayerManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		
		StorageManager.loaded.put(p, false);
		
		pmanager.loadPlayer(p);
		
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.spawn);
			}
		}.runTaskLater(this.hub, 5);
		
	}
}
