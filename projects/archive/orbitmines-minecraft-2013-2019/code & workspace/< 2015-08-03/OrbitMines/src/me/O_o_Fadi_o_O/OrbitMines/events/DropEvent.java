package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		final Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(omp.isLoaded()){
			if(!omp.isOpMode()){
				if(ServerData.isServer(Server.KITPVP, Server.CREATIVE) || ServerData.isServer(Server.HUB) && p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
					e.setCancelled(true);
					omp.updateInventory();
				}
				else if(ServerData.isServer(Server.MINIGAMES)){
					Arena arena = omp.getArena();
					
					if(arena != null){
						if(arena.getType() != MiniGameType.SURVIVAL_GAMES && arena.getType() != MiniGameType.ULTRA_HARD_CORE && arena.getType() != MiniGameType.SKYWARS || (arena.getState() != GameState.IN_GAME || !arena.getPlayers().contains(omp))){
							e.setCancelled(true);
							omp.updateInventory();
						}
					}
				}
				else{}
			}
		}
		else{
			omp.notLoaded();
			e.setCancelled(true);
			omp.updateInventory();
		}
	}
}
