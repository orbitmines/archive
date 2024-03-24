package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		final Player p = e.getPlayer();
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				e.setCancelled(true);
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}
}
