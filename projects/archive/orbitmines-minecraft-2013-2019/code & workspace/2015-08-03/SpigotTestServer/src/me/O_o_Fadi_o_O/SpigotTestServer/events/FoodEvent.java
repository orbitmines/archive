package me.O_o_Fadi_o_O.SpigotTestServer.events;

import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				e.setCancelled(true);
			}
		}
	}
}
