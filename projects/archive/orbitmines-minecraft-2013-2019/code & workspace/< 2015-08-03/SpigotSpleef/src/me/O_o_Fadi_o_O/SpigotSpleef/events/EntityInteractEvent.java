package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPCType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena()){
				Arena arena = sp.getArena();
				if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
					e.setCancelled(true);
				}
			}
		}
		
		if(!(e.getRightClicked() instanceof Player)){
			for(NPC npc : StorageManager.npcs){
				if(npc.getEntity() == e.getRightClicked()){
					e.setCancelled(true);
					
					if(npc.isNPCType(NPCType.ARENA_SELECTOR)){
						if(StorageManager.spleefplayer.containsKey(p)){
							SpleefPlayer sp = StorageManager.spleefplayer.get(p);
							sp.openArenaSelector();
						}
					}
					if(npc.isNPCType(NPCType.KIT_SELECTOR)){
						if(StorageManager.spleefplayer.containsKey(p)){
							SpleefPlayer sp = StorageManager.spleefplayer.get(p);
							Kit kit = npc.getKit();
							sp.openKitSelector(kit);
						}
					}
				}
			}
		}
	}
}
