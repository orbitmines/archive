package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

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
		
		if(!StorageManager.playersinchickenfight.contains(p) && !StorageManager.playersinsurvivalgames.contains(p)){
			if(StorageManager.opmodeenabled.get(p) == false){
				e.setCancelled(true);
				
				new BukkitRunnable(){
					public void run(){
						p.updateInventory();
					}
				}.runTaskLater(this.start, 1);		
			}
		}
	}
}
