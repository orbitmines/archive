package me.O_o_Fadi_o_O.Prison.runnables;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.TextManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MineRunnable {
	Start plugin;
	 
	public MineRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startMineRunnable(){
		
		new BukkitRunnable(){
			@Override
			public void run() {
				for(Rank rank : Rank.values()){
					try{//TODO REMOVE
						if(StorageManager.RankMineSeconds.get(rank) != -1){
							StorageManager.RankMineSeconds.put(rank, StorageManager.RankMineSeconds.get(rank) -1);
						}
						if(StorageManager.RankMineSeconds.get(rank) == -1){
							StorageManager.RankMineMinutes.put(rank, StorageManager.RankMineMinutes.get(rank) -1);
							StorageManager.RankMineSeconds.put(rank, 59);
						}
						if(StorageManager.RankMineMinutes.get(rank) == 0 && StorageManager.RankMineSeconds.get(rank) == 0){
							StorageManager.RankMineMinutes.put(rank, 20);
							StorageManager.RankMineSeconds.put(rank, 0);
							Prison.resetMine(rank, true);
							
							for(Player p : Bukkit.getOnlinePlayers()){
								if(PlayerManager.getAllRanksPassed(p).contains(rank)){
									if(StorageManager.RankMines.get(rank).contains(p.getWorld().getBlockAt(p.getLocation()))){
										Location l = StorageManager.RankMineCountdownLocation.get(rank);
										Location l2 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() +2, l.getBlockZ());
										p.teleport(l2);
									}
								}
							}
							//TODO TELEPORT
						}
						TextManager.createCountdownWord(StorageManager.RankMineCountdownLocation.get(rank), StorageManager.RankMineMinutes.get(rank), StorageManager.RankMineSeconds.get(rank));
					
					}catch(Exception ex){}
				}
			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}
