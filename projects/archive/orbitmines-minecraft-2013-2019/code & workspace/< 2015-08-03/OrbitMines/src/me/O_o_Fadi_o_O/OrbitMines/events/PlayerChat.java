package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(omp.isLoaded()){
			if(omp.isAFK()){
				omp.noLongerAFK();
			}
			
			if(omp.canChat() || !ServerData.isServer(Server.HUB)){
				if(!ServerData.isServer(Server.MINIGAMES)){
					e.setFormat(omp.getChatFormat());
				}
				else{
					Arena arena = omp.getArena();
					
					if(arena != null){
						String format = omp.getChatFormat().replace("%2$s", e.getMessage());
						arena.sendMessage(format);
					}
					e.setCancelled(true);
				}
			}
			else{
				e.setCancelled(true);
				p.sendMessage("§3§lHub §8| §7Move from spawn to §a§lENABLE§7 your chat!");
			}
		}
		else{
			omp.notLoaded();
		}
	}
}
