package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockChangeEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onChange(final EntityChangeBlockEvent e){
		
		Entity en = e.getEntity();
		if(en instanceof FallingBlock){
			
			FallingBlock b = (FallingBlock) en;
			
			if(b.getMaterial() == Material.WEB){
			
				new BukkitRunnable(){
					public void run(){
						e.getBlock().setType(Material.AIR);
					}
				}.runTaskLater(this.start, 100);
			}
			else{
				e.getEntity().remove();
				e.setCancelled(true);
			}
		}
	}
}
