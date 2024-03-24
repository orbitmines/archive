package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkUnload implements Listener{
	
	@EventHandler
	public void onChunkUnload(ChunkUnloadEvent e){
		
		Chunk c = e.getChunk();
		
		if(StorageManager.Chunks.contains(c)){
			e.setCancelled(true);
		}
		
	}
}
