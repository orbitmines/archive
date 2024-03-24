package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ArrowPickup implements Listener{

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
	
		if(e.getItem().getItemStack().getType() == Material.ARROW){
			e.setCancelled(true);
		}
	}
}
