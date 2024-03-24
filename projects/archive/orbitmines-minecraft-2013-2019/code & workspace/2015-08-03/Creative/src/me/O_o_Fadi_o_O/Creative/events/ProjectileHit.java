package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
    public void onHit(ProjectileHitEvent e){
		Projectile proj = e.getEntity();
		if((proj instanceof Arrow)){
			if(proj.getShooter() instanceof Player){
				Player p = (Player) proj.getShooter();
				
				if(StorageManager.playerspvpplot.containsKey(p)){
					int PlotNumber = StorageManager.playerspvpplot.get(p);
					
					if(StorageManager.plotpvparrows.get(PlotNumber) == false){
						proj.remove();
					}
				}
			}
		}
	}
}
