package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		if(StorageManager.petowner.containsKey(e.getDamager())){
			e.setCancelled(true);
		}
	}
}
