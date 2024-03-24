package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DropEvent implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
	
		final Player p = e.getPlayer();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena()){
				e.setCancelled(true);
				
				new BukkitRunnable(){
					public void run(){
						p.updateInventory();
					}
				}.runTaskLater(Start.getInstance(), 1);
			}
		}	
	}
}
