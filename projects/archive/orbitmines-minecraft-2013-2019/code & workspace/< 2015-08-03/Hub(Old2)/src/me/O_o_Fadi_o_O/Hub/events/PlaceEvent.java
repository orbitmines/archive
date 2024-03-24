package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
	
	Hub plugin;
	 
	public PlaceEvent(Hub instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		final Player p = e.getPlayer();
		if(p.getWorld().getName().equals(StorageManager.HubWorld.getName())){
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
}
