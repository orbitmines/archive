package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener{
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(!PlayerManager.isOnOwnPlot(p, e.getBlockPlaced().getLocation()));
				}
			}
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}
}
