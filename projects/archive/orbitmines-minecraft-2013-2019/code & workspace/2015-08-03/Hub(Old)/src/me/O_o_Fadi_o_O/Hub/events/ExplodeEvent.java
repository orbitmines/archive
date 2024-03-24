package me.O_o_Fadi_o_O.Hub.events;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class ExplodeEvent implements Listener{
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void EntityExplodeEvent(EntityExplodeEvent e) {
        e.blockList().clear();

        if(e.getEntity() instanceof Creeper){
        	
        	for(Entity en : e.getEntity().getNearbyEntities(3, 3, 3)){
        		
        		if(en instanceof Player){
        			Player p = (Player) en;
        			Vector v = p.getLocation().getDirection();
        			p.setVelocity(v.multiply(-1).add(new Vector(0, 1.3, 0)));
        			
        		}
        	}
        }
    }
}
