package me.O_o_Fadi_o_O.OrbitMines.managers;

import me.O_o_Fadi_o_O.OrbitMines.utils.ActionBar;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPMap;

import org.bukkit.entity.Player;

public class BossBarManager {
	
	public static int i;

	public static void setBossBar(OMPlayer omp){
		Player p = omp.getPlayer();
		
		if(ServerData.isServer(Server.KITPVP)){
			KitPvPMap map = ServerData.getKitPvP().getCurrentMap();
			
			ActionBar ab = new ActionBar("§7Map Switch in §6§l" + map.getMinutes() + "m " + map.getSeconds() + "s§7...");
			ab.send(p);
		}
	}
}
