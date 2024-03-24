package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
		p.updateInventory();
	}
}
