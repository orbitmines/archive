package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop implements Listener{

	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(!p.hasPermission("Test.Test")){
		e.setCancelled(true);
		}
	}
}
