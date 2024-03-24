package me.O_o_Fadi_o_O.Prison.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkUnload implements Listener{
	
	@EventHandler
	public void onChunkUnload(ChunkUnloadEvent e){
		e.setCancelled(true);
	}
}
