package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class UnloadChunkEvent implements Listener {

	@EventHandler
	public void unloadChunk(ChunkUnloadEvent e){
		for(NPC npc : StorageManager.npcs){
			if(npc.getEntity() != null && npc.getEntity().getLocation().getChunk() == e.getChunk()){
				e.setCancelled(true);
			}
		}
	}
}
