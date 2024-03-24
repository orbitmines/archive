package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DropEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
	
		final Player p = e.getPlayer();
		
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				e.setCancelled(true);
			}
		}
		
		new BukkitRunnable(){
			public void run(){
				p.updateInventory();
			}
		}.runTaskLater(this.start, 1);
	}
}
