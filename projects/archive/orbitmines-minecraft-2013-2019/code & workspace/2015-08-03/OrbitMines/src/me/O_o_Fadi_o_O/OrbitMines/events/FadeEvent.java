package me.O_o_Fadi_o_O.OrbitMines.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class FadeEvent implements Listener {

	@EventHandler
	public void onFade(BlockFadeEvent e){
		Block b = e.getBlock();
		
		if(b.getType() == Material.ICE){
			e.setCancelled(true);
		}
	}
}
