package me.O_o_Fadi_o_O.Creative.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpEvent implements Listener{
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(true);
		}
	}
}
