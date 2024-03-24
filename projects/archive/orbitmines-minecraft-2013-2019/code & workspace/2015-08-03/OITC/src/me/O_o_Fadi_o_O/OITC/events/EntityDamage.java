package me.O_o_Fadi_o_O.OITC.events;

import me.O_o_Fadi_o_O.OITC.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if(Start.spectators.contains(p.getName())){
				e.setCancelled(true);
			}
		}
	}

}
