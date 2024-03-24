package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener{
	
	Start plugin;
	 
	public PlayerDeath(Start instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		
		Player p = e.getEntity();
		
		plugin.addDeath(p);
		
		if((p.getKiller() instanceof Player)){
			
			plugin.addKill(p.getKiller());
			
		}
	}
}
