package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityChangeBlock implements Listener{
	
	Start plugin;
	 
	public EntityChangeBlock(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockChange(final EntityChangeBlockEvent e){
		Entity en = e.getEntity();
		if(en instanceof FallingBlock){
			FallingBlock b = (FallingBlock) en;
			
			if(b.getMaterial() == Material.FIRE){
			
				new BukkitRunnable(){
					public void run(){
						e.getBlock().setType(Material.AIR);
					}
				}.runTaskLater(this.plugin, 40);
			}
		}
	}

	
}
