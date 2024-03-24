package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.managers.Manager;
import me.O_o_Fadi_o_O.Event.utils.GameState;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntityEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(Start.state != GameState.INGAME){
			e.setCancelled(true);
		}
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			if(Manager.Spectators.contains(p)){
				e.setCancelled(true);
			}
		}
	}
}
