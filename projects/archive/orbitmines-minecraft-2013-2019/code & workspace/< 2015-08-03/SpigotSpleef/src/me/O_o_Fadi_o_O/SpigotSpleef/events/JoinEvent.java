package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.PlayerDataManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		PlayerDataManager.loadPlayerData(p);
		
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false){
			e.setJoinMessage(null);
			
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			if(StorageManager.arenas.size() > 0 && StorageManager.arenas.get(0) != null){
				Arena arena = StorageManager.arenas.get(0);
				
				if(!arena.isFull() && !arena.isStatus(SpleefStatus.ENDING) && !arena.isStatus(SpleefStatus.RESTARTING)){
					sp.joinSpleef(arena);
				}
				else{
					sp.teleportToServer(StorageManager.hubserver);
				}
			}
			else{
				sp.teleportToServer(StorageManager.hubserver);
			}
		}
	}
}
