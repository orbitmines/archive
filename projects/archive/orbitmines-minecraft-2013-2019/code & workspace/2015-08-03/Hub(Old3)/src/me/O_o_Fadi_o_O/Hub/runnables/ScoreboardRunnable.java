package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardRunnable {

	Hub hub = Hub.getInstance();
	
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
		}.runTaskTimer(this.hub, 0, 100);
	}
}
