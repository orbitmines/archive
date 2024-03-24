package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntityEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			
			if(StorageManager.loaded.get(p) == true){
				if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
					Entity en = e.getEntity();
					
					if(en instanceof Player){
						Player p2 = (Player) en;
						
						if(p.getGameMode() == GameMode.SURVIVAL && p2.getGameMode() == GameMode.SURVIVAL){
							if(StorageManager.playerspvpplot.containsKey(p) && StorageManager.playerspvpplot.containsKey(p2)){
								if(StorageManager.playerspvpplot.get(p) == StorageManager.playerspvpplot.get(p2)){
									int PlotNumber = StorageManager.playerspvpplot.get(p);
									
									if(!StorageManager.plotpvpplayersselectedkit.get(PlotNumber).contains(p) || !StorageManager.plotpvpplayersselectedkit.get(PlotNumber).contains(p2)){
										e.setCancelled(true);
									}
								}
								else{
									e.setCancelled(true);
								}
							}
							else{
								e.setCancelled(true);
							}
						}
						else{
							e.setCancelled(true);
						}
					}
					else{
						if(StorageManager.opmodeenabled.get(p) == false){
							e.setCancelled(!PlayerManager.isOnOwnPlot(p, en.getLocation()));
						}
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
		
		Entity en = e.getDamager();
		
		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
	}
}
