package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false){
			e.setQuitMessage(null);
		}
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			if(sp.isInArena()){
				sp.quitSpleef();
			}
		}
	}
}
