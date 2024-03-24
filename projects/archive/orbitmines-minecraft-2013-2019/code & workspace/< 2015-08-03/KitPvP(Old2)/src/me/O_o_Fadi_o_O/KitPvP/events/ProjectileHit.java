package me.O_o_Fadi_o_O.KitPvP.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener{

	@EventHandler
    public void onHit(ProjectileHitEvent e){
		Projectile proj = e.getEntity();
		if((proj instanceof Arrow)){
			proj.remove();
		}
	}
}
