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
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener{
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e){
		if(ServerData.isServer(Server.HUB, Server.KITPVP, Server.CREATIVE)){
			e.setFoodLevel(20);
		}
		else if(ServerData.isServer(Server.MINIGAMES)){
			Player p = (Player) e.getEntity();
			OMPlayer omp = OMPlayer.getOMPlayer(p);
			Arena arena = omp.getArena();
			
			if(arena != null){
				if(arena.getType() == MiniGameType.SURVIVAL_GAMES || arena.getType() == MiniGameType.ULTRA_HARD_CORE || arena.getType() == MiniGameType.SKYWARS){
					if(arena.getState() != GameState.IN_GAME){
						e.setFoodLevel(20);
					}
				}
				else{
					e.setFoodLevel(20);
				}
			}
		}
		else{}
	}
}
