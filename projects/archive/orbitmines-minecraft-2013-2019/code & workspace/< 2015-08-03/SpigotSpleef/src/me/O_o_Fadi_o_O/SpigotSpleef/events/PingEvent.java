package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEvent implements Listener {

	@EventHandler
	public void onPing(ServerListPingEvent e){
		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false && StorageManager.usemotd == true){
			Arena arena = StorageManager.arenas.get(0);
			if(arena != null){
				if(arena.isStatus(SpleefStatus.WAITING) || arena.isStatus(SpleefStatus.STARTING)){
					if(arena.enoughPlayers()){
						if(arena.isFull()){
							e.setMotd(getReplacedMOTD(arena, StorageManager.motdfull));
							if(StorageManager.updatemaxplayers == true){
								e.setMaxPlayers(arena.getMaxPlayers());
							}
						}
						else{
							e.setMotd(getReplacedMOTD(arena, StorageManager.motdenoughplayers));
							if(StorageManager.updatemaxplayers == true){
								e.setMaxPlayers(arena.getMaxPlayers());
							}
						}
					}
					else{
						e.setMotd(getReplacedMOTD(arena, StorageManager.motdwaiting));
						if(StorageManager.updatemaxplayers == true){
							e.setMaxPlayers(arena.getMaxPlayers());
						}
					}
				}
				else if(arena.isStatus(SpleefStatus.WARMUP) || arena.isStatus(SpleefStatus.INGAME)){
					e.setMotd(getReplacedMOTD(arena, StorageManager.motdingame));
					if(StorageManager.updatemaxplayers == true){
						e.setMaxPlayers(arena.getMaxPlayers());
					}
				}
				else{
					e.setMotd(getReplacedMOTD(arena, StorageManager.motdrestarting));
					if(StorageManager.updatemaxplayers == true){
						e.setMaxPlayers(0);
					}
				}
			}
			else{
				e.setMotd("");
			}
		}
	}

	private String getReplacedMOTD(Arena arena, String motd){
		motd = motd.replace("&", "§").replace("%minutes%", "" + arena.getMinutes()).replace("%seconds%", "" + arena.getSeconds()).replace("%min-players%", "" + arena.getMinPlayers()).replace("%players%", "" + arena.getPlayers().size()).replace("%max-players%", "" + arena.getMaxPlayers()).replace("%arena-id%", "" + StorageManager.thisarenaidforhub).replace("%spectators%", "" + arena.getSpectators().size()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
		if(arena.getMap() != null){
			motd = motd.replace("%map-name%", arena.getMap().getName());
		}
		
		return motd;
	}
}
