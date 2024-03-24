package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MapRunnable {

	Start start = Start.getInstance();
	
	public static int seconds = 0;
	public static int minutes = 30;
	
	public void startMapRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				if(seconds != -1){
					seconds = seconds -1;
				}
				if(seconds == -1){
					minutes = minutes -1;
					seconds = 59;
				}
				if(seconds <= 10 && seconds != 0 && minutes == 0){
					
					for(Player p : Bukkit.getOnlinePlayers()){
						p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						p.sendMessage(Start.TAG + "§7Switching Maps in §6§l" + seconds +"§7...");
					}
				}
				if(minutes == 0 && seconds == 0){
					if(StorageManager.currentmap == KitPvPMap.Mountain_Village){
						StorageManager.currentmap = KitPvPMap.Snow_Town;
					}
					else if(StorageManager.currentmap == KitPvPMap.Snow_Town){
						StorageManager.currentmap = KitPvPMap.Desert;
					}
					else if(StorageManager.currentmap == KitPvPMap.Desert){
						StorageManager.currentmap = KitPvPMap.Mountain_Village;
					}
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(StorageManager.kitselected.containsKey(p) || StorageManager.spectators.contains(p)){
							Start.RandomSpawn(p);
						}
						p.sendMessage(Start.TAG + "§7§lMaps Switched!");
					}
					
					seconds = 0;
					minutes = 30;
				}	
				
				for(Player p : Bukkit.getOnlinePlayers()){
					PlayerManager.setBossBar(p);
				}
			}
		}.runTaskTimer(this.start, 0, 20);
	}
}
