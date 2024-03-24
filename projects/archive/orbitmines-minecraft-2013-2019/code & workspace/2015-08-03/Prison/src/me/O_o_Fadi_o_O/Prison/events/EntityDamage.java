package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		Entity en = e.getEntity();
		if(!(en instanceof Player)){
			if(en.getWorld().getName().equals(StorageManager.prisonworld.getName())){
				e.setCancelled(true);
			}
		}
		
		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
	}
}
