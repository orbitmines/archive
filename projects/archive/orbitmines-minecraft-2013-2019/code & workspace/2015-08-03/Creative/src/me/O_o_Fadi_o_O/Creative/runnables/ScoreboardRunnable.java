package me.O_o_Fadi_o_O.Creative.runnables;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardRunnable {

	Start start = Start.getInstance();
	
	public void startScoreboardRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.loaded.get(p) == true){
						ScoreboardManager.setScoreboard(p);
					}
				}
			}
		}.runTaskTimer(this.start, 0, 100);
	}
}
