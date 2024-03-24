package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.managers.Manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupEvent implements Listener{
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		
		if(Manager.Spectators.contains(p)){
			e.setCancelled(true);
		}
	}

}
