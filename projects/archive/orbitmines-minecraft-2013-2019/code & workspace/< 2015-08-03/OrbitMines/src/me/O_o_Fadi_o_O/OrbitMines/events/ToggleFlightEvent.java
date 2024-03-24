package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

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
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		Arena arena = omp.getArena();
		
		if(arena != null && arena.getType() == MiniGameType.CHICKEN_FIGHT && p.getGameMode() != GameMode.CREATIVE){
			if(!omp.onCooldown(Cooldown.NPC_INTERACT)){
				p.setFlying(false);
				p.setVelocity(p.getLocation().getDirection().multiply(1.15).setY(0.5));
	            p.setAllowFlight(false);
	            e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
				
				omp.resetCooldown(Cooldown.NPC_INTERACT);
			}
			else{
				p.setAllowFlight(false);
				p.setFlying(false);
				e.setCancelled(true);
			}
		}
	}
}
