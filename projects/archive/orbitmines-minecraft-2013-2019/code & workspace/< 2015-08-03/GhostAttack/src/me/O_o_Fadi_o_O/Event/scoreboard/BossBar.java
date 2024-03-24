package me.O_o_Fadi_o_O.Event.scoreboard;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.managers.Manager;
import me.O_o_Fadi_o_O.Event.utils.GameState;
import me.confuser.barapi.BarAPI;

import org.bukkit.entity.Player;

public class BossBar {

	public static int iB = 0;
	public static void setBossbar(Player p){
		
		if(Start.state == GameState.ENDING){
			BarAPI.setMessage(p, "§7§lWinner: §a§l" + Manager.Winner.getName());
		}
		else if(Start.state == GameState.LOBBY){
			if(iB == 1){
				BarAPI.setMessage(p, "§6§lWaiting.");
			}
			else if(iB == 2){
				BarAPI.setMessage(p, "§6§lWaiting..");
			}
			else if(iB == 3){
				BarAPI.setMessage(p, "§6§lWaiting...");
			}
		}
		else if(Start.state == GameState.WARMUP){
			BarAPI.setMessage(p, "§7§lStarting in §3§l" + Manager.Seconds + "§7§l...");
		}
		else if(Start.state == GameState.INGAME){
			BarAPI.setMessage(p, "§6§lTime Left: §f§l" + Manager.Minutes + "m " + Manager.Seconds + "s");
		}
		else{
			if(BarAPI.hasBar(p)){
				BarAPI.removeBar(p);
			}
		}
	}
}
