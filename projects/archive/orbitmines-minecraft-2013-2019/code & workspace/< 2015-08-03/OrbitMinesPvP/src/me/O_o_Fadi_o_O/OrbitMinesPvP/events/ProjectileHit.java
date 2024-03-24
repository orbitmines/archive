package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener{
	
	@EventHandler
    public void onHit(ProjectileHitEvent e){
		Start.arrow.remove(e.getEntity());
 
    }
}
