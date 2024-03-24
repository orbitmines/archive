package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

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
		
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			for(final Entity en : p.getNearbyEntities(0.7, 0.7, 0.7)){
				if(en instanceof MagmaCube && ServerStorage.soccermagmacubes.contains(en)){
					en.setVelocity(p.getLocation().getDirection().multiply(1.2));
				}
			}
		}
	}
}
