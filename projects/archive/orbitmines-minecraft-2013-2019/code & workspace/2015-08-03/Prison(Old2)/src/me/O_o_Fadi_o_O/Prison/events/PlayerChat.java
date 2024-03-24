package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{
	Start plugin;
	 
	public PlayerChat(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(PlayerManager.isLoaded(p)){
			
			String s = e.getMessage();
			e.setMessage("§" + StorageManager.chatcolor.get(p) + s);
			e.setFormat("§7>§a§l" + PlayerManager.getRankString(p) + "§7< " + e.getFormat());
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
