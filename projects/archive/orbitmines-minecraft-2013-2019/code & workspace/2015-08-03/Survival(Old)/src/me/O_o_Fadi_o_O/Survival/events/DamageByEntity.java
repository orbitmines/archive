package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntity implements Listener{
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e){
		
		if(Start.ownerpets.containsValue(e.getDamager().getUniqueId())){
			e.setCancelled(true);
		}
	}
}
