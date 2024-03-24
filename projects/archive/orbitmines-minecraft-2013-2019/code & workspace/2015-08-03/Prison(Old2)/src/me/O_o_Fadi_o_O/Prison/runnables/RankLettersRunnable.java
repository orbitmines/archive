package me.O_o_Fadi_o_O.Prison.runnables;

import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RankLettersRunnable {

	Start plugin;
	 
	public RankLettersRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startRankLetterRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
			
				for(Player p : Bukkit.getOnlinePlayers()){	
					for(Rank rank : PlayerManager.getAllRanksPassed(p)){
					
						List<Block> blocks = StorageManager.RankBlocks.get(rank);
						
						for(Block b : blocks){
							if(b.getType() == Material.STAINED_CLAY){							
								p.sendBlockChange(b.getLocation(), Material.STAINED_CLAY, (byte) 5);	
							}
						}
						
						Block b = StorageManager.RankTorchBlock.get(rank);
						p.sendBlockChange(b.getLocation(), Material.TORCH, (byte) 0);
						
					}
				}
			}
			
		}.runTaskTimer(this.plugin, 0, 20);
	}
}
