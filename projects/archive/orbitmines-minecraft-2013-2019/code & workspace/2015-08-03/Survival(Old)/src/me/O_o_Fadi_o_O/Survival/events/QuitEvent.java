package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		
		e.setQuitMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oSurvival§4§o)");
		
		if(Start.ownerpets.containsKey(p)){
			
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					if(Start.ownerpets.containsKey(p)){
						if(en.getUniqueId() == Start.ownerpets.get(p)){
							if(en instanceof LivingEntity){
								en.remove();
								Start.owners.remove(Start.ownerpets.get(p));
								Start.ownerpets.remove(p);
							}
						}
					}
					
				}
			}
		}
	}
}
