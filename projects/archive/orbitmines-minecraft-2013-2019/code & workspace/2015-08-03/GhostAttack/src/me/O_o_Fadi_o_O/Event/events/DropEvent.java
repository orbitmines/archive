package me.O_o_Fadi_o_O.Event.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		
		e.setCancelled(true);
	}
}
