package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener{

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		e.setQuitMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oCreative§4§o)");
		
		if(StorageManager.ownerpets.containsKey(p)){
			
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
						if(en instanceof LivingEntity){
							en.remove();
							StorageManager.owners.remove(StorageManager.ownerpets.get(p));
							StorageManager.ownerpets.remove(p);
						}
					}
				}
			}
		}
	}
}
