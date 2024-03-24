package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BoosterRunnable {

	Start plugin;
	 
	public BoosterRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startBoosterRunnable(){
		
		new BukkitRunnable(){
			
			public void run(){
				
				if(!StorageManager.BoosterPlayer.equals("")){
					if(StorageManager.BoosterSeconds != -1){
						StorageManager.BoosterSeconds = StorageManager.BoosterSeconds -1;
					}
					if(StorageManager.BoosterSeconds == -1){
						StorageManager.BoosterMinutes = StorageManager.BoosterMinutes -1;
						StorageManager.BoosterSeconds = 59;
					}
					if(StorageManager.BoosterSeconds == 0 && StorageManager.BoosterMinutes != 0){
						Bukkit.broadcastMessage(Start.TAG + "§a" + StorageManager.BoosterPlayer + "'s Booster§7 (§ax" + StorageManager.BoosterAmount +"§7) remains for §a" + StorageManager.BoosterMinutes + "m " + StorageManager.BoosterSeconds + "s§7.");
					}
					if(StorageManager.BoosterMinutes == 0 && StorageManager.BoosterSeconds == 0){
						
						Bukkit.broadcastMessage(Start.TAG + "§a" + StorageManager.BoosterPlayer + "'s Booster§7 (§ax" + StorageManager.BoosterAmount +"§7) has been expired.");
						
						StorageManager.BoosterPlayer = "";
						StorageManager.BoosterAmount = 1.0;
						
						StorageManager.BoosterSeconds = 0;
						StorageManager.BoosterMinutes = 30;
					}	
				}
			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}
