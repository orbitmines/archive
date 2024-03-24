package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

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
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
