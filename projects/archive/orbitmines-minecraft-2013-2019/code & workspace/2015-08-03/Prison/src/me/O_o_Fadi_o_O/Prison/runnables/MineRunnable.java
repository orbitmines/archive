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
	
	Start start = Start.getInstance();
	
	public void startMineRunnable(){
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(Rank rank : Rank.values()){
					try{//TODO REMOVE
						if(StorageManager.rankmineseconds.get(rank) != -1){
							StorageManager.rankmineseconds.put(rank, StorageManager.rankmineseconds.get(rank) -1);
						}
						if(StorageManager.rankmineseconds.get(rank) == -1){
							StorageManager.rankmineminutes.put(rank, StorageManager.rankmineminutes.get(rank) -1);
							StorageManager.rankmineseconds.put(rank, 59);
						}
						if(StorageManager.rankmineminutes.get(rank) == 0 && StorageManager.rankmineseconds.get(rank) == 0){
							StorageManager.rankmineminutes.put(rank, 20);
							StorageManager.rankmineseconds.put(rank, 0);
							Prison.resetMine(rank, true);
							
							for(Player p : Bukkit.getOnlinePlayers()){
								if(PlayerManager.getAllRanksPassed(p).contains(rank)){
									if(StorageManager.rankmines.get(rank).contains(p.getWorld().getBlockAt(p.getLocation()))){
										Location l = StorageManager.rankminecountdownlocation.get(rank);
										Location l2 = new Location(l.getWorld(), l.getBlockX(), l.getBlockY() +2, l.getBlockZ());
										p.teleport(l2);
									}
								}
							}
							//TODO TELEPORT
						}
						TextManager.createCountdownWord(StorageManager.rankminecountdownlocation.get(rank), StorageManager.rankmineminutes.get(rank), StorageManager.rankmineseconds.get(rank));
					
					}catch(Exception ex){}
				}
			}
		}.runTaskTimer(this.start, 0, 20);
	}
}
