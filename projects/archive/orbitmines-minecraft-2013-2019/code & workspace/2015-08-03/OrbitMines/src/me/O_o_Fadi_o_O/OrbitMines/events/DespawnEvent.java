package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class DespawnEvent implements Listener {
	
	@EventHandler
	public void onDespawn(ItemDespawnEvent e){
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			e.setCancelled(true);
		}
	}
}
