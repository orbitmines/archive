package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if(StorageManager.petowner.containsKey(e.getEntity()) || StorageManager.serverselector == e.getEntity() || StorageManager.merchantnpc == e.getEntity() || StorageManager.jobmanagernpc == e.getEntity() || StorageManager.omtnpc == e.getEntity() || StorageManager.regiontpworld1 == e.getEntity()){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(!StorageManager.playersinpvp.contains(p)){
					e.setCancelled(true);
				}
			}
		}
	}
}
