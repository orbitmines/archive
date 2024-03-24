package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener{
	
	
	ServerSelector sinv = new ServerSelector();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		
		Entity en = e.getDamager();
		
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
	}
}
