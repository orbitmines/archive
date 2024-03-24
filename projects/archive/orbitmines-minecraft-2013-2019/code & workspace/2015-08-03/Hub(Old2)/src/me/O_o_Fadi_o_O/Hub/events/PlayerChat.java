package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{
	Hub plugin;
	 
	public PlayerChat(Hub instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(PlayerManager.isLoaded(p)){
			
			String bold = "";
			if(StorageManager.BoldChatColor.containsKey(p) && StorageManager.BoldChatColor.get(p) == true){
				bold = "§l";
			}
			
			String cursive = "";
			if(StorageManager.CursiveChatColor.containsKey(p) && StorageManager.CursiveChatColor.get(p) == true){
				bold = "§o";
			}
			
			String s = e.getMessage();
			e.setMessage("§" + StorageManager.chatcolor.get(p) + bold + cursive + s);
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
