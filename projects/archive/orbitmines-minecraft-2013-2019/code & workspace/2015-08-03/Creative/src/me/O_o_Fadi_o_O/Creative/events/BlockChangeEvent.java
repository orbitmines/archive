package me.O_o_Fadi_o_O.Creative.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class BlockChangeEvent implements Listener{

	@EventHandler
	public void onChange(final BlockFromToEvent e){
		
		Block b = e.getBlock();
		
		e.setCancelled(b.getType() == Material.WATER || b.getType() == Material.LAVA || b.getType() == Material.STATIONARY_WATER || b.getType() == Material.STATIONARY_LAVA);
	}
}
