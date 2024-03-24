package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractAtEntityEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent e){
		if(StorageManager.armorstands.contains(e.getRightClicked())){
			e.setCancelled(true);
		}
		if(StorageManager.pvpnpc == e.getRightClicked()){
			Player p = (Player) e.getPlayer();
			if(!StorageManager.pvpteleporting.containsKey(p)){
				StorageManager.pvpteleporting.put(p, 16);
				p.teleport(StorageManager.pvpspawn);
			}
		}
	}
}
