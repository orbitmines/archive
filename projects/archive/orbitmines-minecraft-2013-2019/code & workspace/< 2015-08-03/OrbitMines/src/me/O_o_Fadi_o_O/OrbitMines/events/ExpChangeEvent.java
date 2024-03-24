package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ExpChangeEvent implements Listener {
	
	@EventHandler
	public void onExpChange(PlayerExpChangeEvent e){
		Player p = e.getPlayer();
		final OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(omp.isLoaded()){
			new BukkitRunnable(){
				public void run(){
					omp.getKitPvPPlayer().updateLevel();
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
	}
}
