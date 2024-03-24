package me.O_o_Fadi_o_O.YoutubeProject.events;

import me.O_o_Fadi_o_O.YoutubeProject.kits.JoinKit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		e.setJoinMessage("§2§l§o>> " + p.getName() + " §2§o(§a§oYoutubeProject§2§o)");
	
		JoinKit.giveJoinKit(p);
		
	}
}
