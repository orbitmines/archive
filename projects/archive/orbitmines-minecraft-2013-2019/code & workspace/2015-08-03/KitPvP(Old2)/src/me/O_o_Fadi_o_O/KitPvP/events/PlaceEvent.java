package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
	
	Start plugin;
	 
	public PlaceEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		final Player p = e.getPlayer();
		if(PlayerManager.isLoaded(p)){
			if(!PlayerManager.isInOPMode(p)){
				e.setCancelled(true);
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}

}
