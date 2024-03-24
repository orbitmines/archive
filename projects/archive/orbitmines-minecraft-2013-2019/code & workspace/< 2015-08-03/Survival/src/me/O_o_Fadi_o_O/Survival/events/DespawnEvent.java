package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class DespawnEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onDespawn(ItemDespawnEvent e){
		if(e.getEntity().getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			e.setCancelled(true);
		}
	}
}
