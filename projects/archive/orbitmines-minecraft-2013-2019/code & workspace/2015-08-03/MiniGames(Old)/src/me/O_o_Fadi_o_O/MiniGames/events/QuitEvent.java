package me.O_o_Fadi_o_O.MiniGames.events;

import java.sql.SQLException;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		
		Manager.leaveChickenFight(p);	
		
		if(Start.FireworkPasses.get(p.getName()) != null){
			try {
				Start.setFireworksPasses(p, Start.FireworkPasses.get(p.getName()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(Start.ownerpets.containsKey(p)){
			
			for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
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
