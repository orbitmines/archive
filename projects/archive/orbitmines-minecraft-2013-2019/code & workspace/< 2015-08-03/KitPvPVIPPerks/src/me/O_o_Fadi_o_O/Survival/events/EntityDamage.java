package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		if(Start.ownerpets.containsValue(e.getEntity())){
			e.setCancelled(true);
		}
	}

}
