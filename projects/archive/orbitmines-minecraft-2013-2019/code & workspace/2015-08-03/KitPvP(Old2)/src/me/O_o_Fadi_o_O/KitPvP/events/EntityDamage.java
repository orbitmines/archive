package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		if(StorageManager.ownerpets.containsValue(e.getEntity().getUniqueId())){
			e.setCancelled(true);
		}
		if(StorageManager.KitSelectorNPCs.contains(e.getEntity())){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(!StorageManager.PlayerKitSelected.containsKey(p)){
				e.setCancelled(true);
			}
		}
	}

}
