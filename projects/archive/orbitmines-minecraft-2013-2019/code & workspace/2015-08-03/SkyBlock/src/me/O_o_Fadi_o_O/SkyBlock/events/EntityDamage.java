package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		Entity en = e.getEntity();
		
		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
		if(en.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			e.setCancelled(true);
		}
	}
}
