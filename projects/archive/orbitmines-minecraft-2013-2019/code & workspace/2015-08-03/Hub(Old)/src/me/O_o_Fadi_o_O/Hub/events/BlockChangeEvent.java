package me.O_o_Fadi_o_O.Hub.events;

import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockChangeEvent implements Listener{
	
	@EventHandler
	public void onChange(final EntityChangeBlockEvent e){
		
		if(e.getEntity() instanceof FallingBlock){
			e.getEntity().remove();
			e.setCancelled(true);
		}
		
	}
}
