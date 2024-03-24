package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkEvent implements Listener {

	@EventHandler
	public void chunkUnload(ChunkUnloadEvent e){
		if(ServerData.isServer(Server.PRISON)){
			e.setCancelled(true);
		}
		else if(ServerData.isServer(Server.MINIGAMES)){
			if(e.getWorld().getName().equals(ServerData.getMiniGames().getLobbyWorld().getName())){
				e.setCancelled(true);
			}
		}
		else{}
	}
}
