package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BoosterRunnable {

	Start start = Start.getInstance();
	
	public void startBoosterRunnable(){
		
		new BukkitRunnable(){
			
			public void run(){
				
				if(!StorageManager.boosterplayer.equals("")){
					if(StorageManager.boosterseconds != -1){
						StorageManager.boosterseconds = StorageManager.boosterseconds -1;
					}
					if(StorageManager.boosterseconds == -1){
						StorageManager.boosterminutes = StorageManager.boosterminutes -1;
						StorageManager.boosterseconds = 59;
					}
					if(StorageManager.boosterseconds == 0 && StorageManager.boosterminutes != 0){
						Bukkit.broadcastMessage(Start.TAG + "§a" + StorageManager.boosterplayer + "'s Booster§7 (§ax" + StorageManager.boosteramount +"§7) remains for §a" + StorageManager.boosterminutes + "m " + StorageManager.boosterseconds + "s§7.");
					}
					if(StorageManager.boosterminutes == 0 && StorageManager.boosterseconds == 0){
						
						Bukkit.broadcastMessage(Start.TAG + "§a" + StorageManager.boosterplayer + "'s Booster§7 (§ax" + StorageManager.boosteramount +"§7) has been expired.");
						
						StorageManager.boosterplayer = "";
						StorageManager.boosteramount = 1.0;
						
						StorageManager.boosterseconds = 0;
						StorageManager.boosterminutes = 30;
					}	
				}
			}
		}.runTaskTimer(this.start, 0, 20);
	}
}
