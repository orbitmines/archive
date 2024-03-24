package me.O_o_Fadi_o_O.SkyGamesRuleBook.events;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		Start.getInstance().getRuleBook().give(p);
	}
}
