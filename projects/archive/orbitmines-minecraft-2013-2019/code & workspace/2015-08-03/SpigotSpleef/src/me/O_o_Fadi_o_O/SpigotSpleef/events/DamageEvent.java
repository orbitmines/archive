package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if(!(e.getEntity() instanceof Player)){
			for(NPC npc : StorageManager.npcs){
				if(npc.getEntity() == e.getEntity()){
					e.setCancelled(true);
				}
			}
		}
		else{
			Player p = (Player) e.getEntity();
			
			if(StorageManager.spleefplayer.containsKey(p)){
				SpleefPlayer sp = StorageManager.spleefplayer.get(p);
				
				if(sp.isInArena()){
					if(sp.getArena().isStatus(SpleefStatus.INGAME)){
						e.setDamage(0D);
					}
					else{
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
