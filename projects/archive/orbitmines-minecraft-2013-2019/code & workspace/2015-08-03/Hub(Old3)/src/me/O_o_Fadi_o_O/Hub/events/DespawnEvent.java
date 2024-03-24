package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class DespawnEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
	@EventHandler
	public void onDespawn(ItemDespawnEvent e){
		e.setCancelled(true);
	}
}
