package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntityEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		Entity en = e.getDamager();
		
		if(en instanceof Player && e.getEntity() instanceof Player){
			Player dPlayer = (Player) en;
			Player ePlayer = (Player) e.getEntity();
			
			if(PlayerManager.isInPvP(dPlayer)){
				if(!PlayerManager.isInPvP(ePlayer)){
					e.setCancelled(true);
					dPlayer.sendMessage("§4§lPrison §8| §7" + ePlayer.getName() + " isn't in a §c§lPvP Area§7!");
				}
			}
			else{
				e.setCancelled(true);
				dPlayer.sendMessage("§4§lPrison §8| §7You aren't in a §c§lPvP Area§7!");
			}
			
		}
		if(StorageManager.RankWoodmen.containsValue(e.getEntity())){
			e.setCancelled(true);
		}
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
	}
}
