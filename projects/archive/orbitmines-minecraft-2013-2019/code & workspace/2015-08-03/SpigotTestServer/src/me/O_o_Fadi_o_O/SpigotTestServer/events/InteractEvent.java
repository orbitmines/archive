package me.O_o_Fadi_o_O.SpigotTestServer.events;

import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			e.setCancelled(true);
		}
	}
}
