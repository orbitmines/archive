package me.O_o_Fadi_o_O.Hub.events;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener{
	
	@EventHandler
	public void onDeath(EntityDeathEvent e){
		
		if(e.getEntity() instanceof Creeper){
			e.getDrops().clear();
		}
	}
}
