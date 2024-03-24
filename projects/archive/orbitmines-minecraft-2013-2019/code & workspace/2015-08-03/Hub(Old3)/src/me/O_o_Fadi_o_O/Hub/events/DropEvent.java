package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DropEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
	
		final Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
			if(StorageManager.opmodeenabled.get(p) == false){
				e.setCancelled(true);
			}
		}	
		
		new BukkitRunnable(){
			public void run(){
				p.updateInventory();
			}
		}.runTaskLater(this.hub, 1);
	}
}
