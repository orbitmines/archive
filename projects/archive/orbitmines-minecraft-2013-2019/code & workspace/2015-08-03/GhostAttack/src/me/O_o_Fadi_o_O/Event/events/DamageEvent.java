package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.utils.GameState;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		
		if(Start.state != GameState.INGAME){
			e.setCancelled(true);
		}
	}
}
