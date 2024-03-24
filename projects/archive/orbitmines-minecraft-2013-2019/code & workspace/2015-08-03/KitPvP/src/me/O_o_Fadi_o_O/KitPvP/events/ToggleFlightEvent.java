package me.O_o_Fadi_o_O.KitPvP.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class ToggleFlightEvent implements Listener{
	
	@EventHandler
	public void onFlightToggle(PlayerToggleFlightEvent e){
		
		Player p = e.getPlayer();
		
		if(p.getGameMode() != GameMode.CREATIVE){
			p.setAllowFlight(false);
			p.setFlying(false);
			e.setCancelled(true);
		}
	}
}
