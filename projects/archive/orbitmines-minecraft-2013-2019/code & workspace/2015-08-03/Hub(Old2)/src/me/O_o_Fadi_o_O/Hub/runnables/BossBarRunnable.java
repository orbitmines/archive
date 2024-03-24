package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarRunnable {

	int i = 0;
	
	Hub plugin;
	 
	public BossBarRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startBossBarRunnable(){
		
		new BukkitRunnable(){
			
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(!BarAPI.hasBar(p)){
						
						if(i == 0){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!", 10);
							i++;
						}
						else if(i == 1){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.omt.get(p.getName()) + "§6 OMT", 10);
							i++;
						}
						else if(i == 2){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com", 10);
							i++;
						}
						else if(i == 3){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com", 10);
							i++;
						}
						else if(i == 4){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.points.get(p.getName()) + "§6 VIP Points", 10);
							i++;
						}
						else if(i == 5){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(p.getName()) + "§6 Votes", 10);
							i = 0;
						}
					}
					
					if(StorageManager.EnablePlayers.containsKey(p.getName())){
						if(StorageManager.EnablePlayers.get(p.getName()) == false){
							for(Player player : Bukkit.getOnlinePlayers()){
								p.hidePlayer(player);
							}
						}
					}
				}

			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}

