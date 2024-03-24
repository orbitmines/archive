package me.O_o_Fadi_o_O.SpigotSpleef.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplodeEvent implements Listener{
	
	@EventHandler
    public void EntityExplodeEvent(ExplosionPrimeEvent e){
		Entity en = e.getEntity();
		
		if(en instanceof TNTPrimed && StorageManager.instanttnt.contains((TNTPrimed) en)){
			e.setCancelled(true);
			Location l = en.getLocation();
			l.getWorld().playEffect(l, Effect.EXPLOSION_HUGE, 5);
			
        	SpleefPlayer sp = null;
			
			for(SpleefPlayer sps : StorageManager.spleefplayer.values()){
				if(sps != null && sps.getPlayer() != null){
					if(sps.getInstantTNT() == null){
						sps.setInstantTNT(new ArrayList<TNTPrimed>());
					}
					
					if(sps.getInstantTNT().contains((TNTPrimed) en)){
						sp = sps;
					}
				}
			}
			if(sp != null){
				sp.removeInstantTNT((TNTPrimed) en); 
			
				Location l1 = new Location(l.getWorld(), l.getBlockX() +3, l.getBlockY() +2, l.getBlockZ() +3);
				Location l2 = new Location(l.getWorld(), l.getBlockX() -3, l.getBlockY() -2, l.getBlockZ() -3);
				Location l3 = new Location(l.getWorld(), l.getBlockX() -3, l.getBlockY() +2, l.getBlockZ() +3);
				Location l4 = new Location(l.getWorld(), l.getBlockX() +3, l.getBlockY() -2, l.getBlockZ() -3);
				
				for(Block b : getBlocksBetween(l1, l2)){
					Location bl = b.getLocation();
					if(bl.getBlockX() != l1.getBlockX() && bl.getBlockZ() != l1.getBlockZ() || bl.getBlockX() != l2.getBlockX() && bl.getBlockZ() != l2.getBlockZ() || bl.getBlockX() != l3.getBlockX() && bl.getBlockZ() != l3.getBlockZ() || bl.getBlockX() != l4.getBlockX() && bl.getBlockZ() != l4.getBlockZ()){
						int r = new Random().nextInt(3);
						if(r <= 1){
							sp.getArena().breakBlock(sp, b);
						}
					}
				}
			}

			l.getWorld().playSound(l, Sound.EXPLODE, 5, 1);
			en.remove();
        }
	}
	
    public List<Block> getBlocksBetween(Location l1, Location l2){
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++) {
            for(int z = bottomBlockZ; z <= topBlockZ; z++){
                for(int y = bottomBlockY; y <= topBlockY; y++){
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
}
