package me.O_o_Fadi_o_O.OITC.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakBlock implements Listener{
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("OITC.Admin")){
			
		}
		else{
			e.setCancelled(true);	
		}
	}
}
