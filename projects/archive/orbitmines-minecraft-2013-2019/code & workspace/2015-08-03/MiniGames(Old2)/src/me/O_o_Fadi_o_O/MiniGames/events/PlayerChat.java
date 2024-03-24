package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
			
		if(PlayerManager.isLoaded(p)){
			if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
				e.setFormat("§7Dead " + e.getFormat());
			}
			
			String s = e.getMessage();
			e.setMessage("§" + StorageManager.chatcolor.get(p) + s);
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
