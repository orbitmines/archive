package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.RegionManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaceEvent implements Listener {
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onPlace(final BlockPlaceEvent e){
		final Player p = e.getPlayer();
		if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			if(StorageManager.loaded.get(p) == true){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
					
					
					new BukkitRunnable(){
						public void run(){
							p.updateInventory();
						}
					}.runTaskLater(this.start, 1);
				}
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
				e.setCancelled(true);
			}
		}
		if(p.getWorld().getName().equals(StorageManager.survivalworld1.getName())){
			if(RegionManager.isBlockInRegion(p, e.getBlock())){
				e.setCancelled(true);
			}
		}
	}
}
