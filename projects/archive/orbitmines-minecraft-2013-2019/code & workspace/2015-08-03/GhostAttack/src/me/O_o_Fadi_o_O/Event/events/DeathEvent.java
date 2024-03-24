package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.managers.Manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			p.setHealth(20D);
			if(Manager.Players.contains(p)){
				Manager.Players.remove(p);
				Manager.setSpectator(p);
				
				if(Manager.Players.size() == 1){
				
					Player winner = null;
					for(Player player : Bukkit.getOnlinePlayers()){
						if(Manager.Players.contains(player)){
							winner = player;
						}
					}
					
					Manager.endGame(winner);
				}
			}
		}
	}
}
