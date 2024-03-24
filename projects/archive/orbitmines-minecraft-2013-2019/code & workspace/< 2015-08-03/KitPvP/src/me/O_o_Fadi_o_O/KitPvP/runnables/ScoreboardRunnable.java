package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.TeleporterInv;
import me.O_o_Fadi_o_O.KitPvP.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

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
						if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("§0§lTeleporter")){
							TeleporterInv.getAllPlayers(TeleporterInv.inv, p);
						}
					}
				}
			}
		}.runTaskTimer(this.start, 0, 100);
	}
}
