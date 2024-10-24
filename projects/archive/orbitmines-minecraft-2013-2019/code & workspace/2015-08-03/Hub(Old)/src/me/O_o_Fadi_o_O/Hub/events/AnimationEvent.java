package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;

public class AnimationEvent implements Listener{
	
	@EventHandler
	public void onAnimation(PlayerAnimationEvent e){
		
		final Player p = e.getPlayer();
		
		for(final Entity en : p.getNearbyEntities(0.7, 0.7, 0.7)){
			
			if(en instanceof MagmaCube){
				
				if(StorageManager.SoccerMagmaCubes.contains(en)){
					
					en.setVelocity(p.getLocation().getDirection().multiply(1.2));
					
				}
			}
		}
	}
}
