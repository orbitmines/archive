package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityDeath implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onDeath(final EntityDeathEvent e){
		
		if(e.getEntity() instanceof Player){
			final Player p = (Player) e.getEntity();
			new BukkitRunnable(){
				public void run(){
					p.setHealth(20D);
					p.teleport(StorageManager.spawn);
				}
			}.runTaskLater(this.start, 1);
		}
	}
}
