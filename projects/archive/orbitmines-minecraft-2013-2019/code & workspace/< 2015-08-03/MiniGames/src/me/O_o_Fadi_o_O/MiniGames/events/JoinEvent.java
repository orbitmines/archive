package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener{
	
	Start start = Start.getInstance();
	PlayerManager pmanager = new PlayerManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		
		p.setAllowFlight(false);
		
		StorageManager.loaded.put(p, false);
		
		pmanager.loadPlayer(p);
		
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.spawn);
			}
		}.runTaskLater(this.start, 5);
		
	}
}
