package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MapRunnable {

	Start plugin;
	 
	public MapRunnable(Start instance) {
		plugin = instance;
	}
	
	public static int Seconds = 0;
	public static int Minutes = 60;
	
	public void startMapRunnable(){
		
		new BukkitRunnable(){
			
			public void run(){
				
				if(Seconds != -1){
					Seconds = Seconds -1;
				}
				if(Seconds == -1){
					Minutes = Minutes -1;
					Seconds = 59;
				}
				if(Seconds <= 10 && Seconds != 0 && Minutes == 0){
					
					for(Player p : Bukkit.getOnlinePlayers()){
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						p.sendMessage(Start.TAG + "§cSwitching Maps in §6§l" + Seconds +"§c...");
					}
				}
				if(Minutes == 0 && Seconds == 0){
					if(StorageManager.currentMap == KitPvPMap.Mountain_Village){
						StorageManager.currentMap = KitPvPMap.Snow_Town;
					}
					else if(StorageManager.currentMap == KitPvPMap.Snow_Town){
						StorageManager.currentMap = KitPvPMap.Mountain_Village;
					}
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(StorageManager.PlayerKitSelected.containsKey(p) || StorageManager.Spectators.contains(p)){
							Start.RandomSpawn(p);
						}
						p.sendMessage(Start.TAG + "§cMaps Switched!");
					}
					
					Seconds = 0;
					Minutes = 60;
				}	
			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}
