package me.O_o_Fadi_o_O.SpigotTestServer.events;

import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
	
	@EventHandler
	public void onBreak(EntityDamageEvent e){
		Entity en = e.getEntity();
		
		if(en.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			e.setCancelled(true);
		}
	}
}
