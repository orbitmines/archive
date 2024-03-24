package me.O_o_Fadi_o_O.Creative.events;

import java.util.List;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityDeath implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onDeath(EntityDeathEvent e){
		
		if(e.getEntity() instanceof Player){
			final Player p = (Player) e.getEntity();
			
			if(StorageManager.playerspvpplot.containsKey(p)){
				final int PlotNumber = StorageManager.playerspvpplot.get(p);
				
				if(StorageManager.plotpvpdrops.get(PlotNumber) == false){
					e.getDrops().clear();
				}
				
				List<Player> pvpplayers = StorageManager.plotpvpplayersselectedkit.get(PlotNumber);
				pvpplayers.remove(p);
				StorageManager.plotpvpplayersselectedkit.put(PlotNumber, pvpplayers);
				
				p.setHealth(20D);
				
				new BukkitRunnable(){
					public void run(){
						Start.clearInventory(p);
						p.teleport(StorageManager.plotpvpspawnlocation.get(PlotNumber));
						
					    for(PotionEffect effect : p.getActivePotionEffects()){
					        p.removePotionEffect(effect.getType());
					    }
					}
				}.runTaskLater(this.start, 3);
			}
		}
	}
}
