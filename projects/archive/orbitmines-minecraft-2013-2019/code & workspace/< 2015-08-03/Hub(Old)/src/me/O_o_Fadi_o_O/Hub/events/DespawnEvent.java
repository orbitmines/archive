package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class DespawnEvent implements Listener{
	
	@EventHandler
	public void onDespawn(ItemDespawnEvent e){
		Item item = e.getEntity();
		
		if(StorageManager.serverSelectorOcelotItem.containsValue(item)){
			e.setCancelled(true);
		}
	}

}
