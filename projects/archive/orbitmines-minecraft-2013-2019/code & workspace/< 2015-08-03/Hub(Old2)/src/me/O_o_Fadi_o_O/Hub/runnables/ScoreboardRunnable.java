package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardRunnable {

	Hub plugin;
	 
	public ScoreboardRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startScoreboardRunnable(){
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					ScoreboardManager.setScoreboard(p);
				}
				
			}
		}.runTaskTimer(this.plugin, 0, 100);
	}
	
}
