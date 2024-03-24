package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Manager;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class ToggleFlightEvent implements Listener{
	
	@EventHandler
	public void onFlightToggle(PlayerToggleFlightEvent e){
		
		Player p = e.getPlayer();
		
		if(p.getGameMode() != GameMode.CREATIVE && !Manager.Spectators.contains(p)){
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(1.15).setY(0.5));
			p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
		}
	}

}
