package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.util.Vector;

public class ExplodeEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
	@EventHandler
    public void EntityExplodeEvent(ExplosionPrimeEvent e) {
		e.setFire(false);
		
        if(e.getEntity() instanceof Creeper){
        	for(Entity en : e.getEntity().getNearbyEntities(3, 3, 3)){
        		if(en instanceof Skeleton && !StorageManager.petentity.containsValue(en) || en instanceof Creeper && !((Creeper) en).isPowered() && !StorageManager.petentity.containsValue(en)){
        			e.setRadius(0);
        		}
        		
        		if(en instanceof Player){
        			Player p = (Player) en;
        			if(!StorageManager.playersinlapisparkour.contains(p)){
        				Vector v = p.getLocation().getDirection();
        				p.setVelocity(v.multiply(-1).add(new Vector(0, 1.3, 0)));
        			}	
        		}
        	}
        }
	}
}
