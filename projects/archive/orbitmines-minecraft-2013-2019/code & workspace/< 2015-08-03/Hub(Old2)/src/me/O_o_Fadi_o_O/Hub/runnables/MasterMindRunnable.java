package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.List;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.MasterMindManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MasterMindRunnable {
	
	Hub plugin;
	 
	public MasterMindRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startMasterMindRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getWorld().getName().equals("Hub")){
						if(p.getLocation().distance(StorageManager.MasterMindWinsSign.getLocation()) < 16){
							{
								String[] sign = new String[4];
								sign[0] = "";
								sign[1] = "§lWins";
								if(StorageManager.PlayerMasterMindWins.get(p) != null){
									sign[2] = "" + StorageManager.PlayerMasterMindWins.get(p);
								}
								else{
									sign[2] = "Loading...";
								}
								sign[3] = "";
								p.sendSignChange(StorageManager.MasterMindWinsSign.getLocation(), sign);
							}
							{
								String[] sign = new String[4];
								sign[0] = "";
								sign[1] = "§lBest Game";
								if(StorageManager.PlayerMasterMindBestGame.get(p) != null){
									if(StorageManager.PlayerMasterMindBestGame.get(p) != 1){
										sign[2] = "" + StorageManager.PlayerMasterMindBestGame.get(p) + " Turns";
									}
									else{
										sign[2] = "" + StorageManager.PlayerMasterMindBestGame.get(p) + " Turn";
									}
								}
								else{
									sign[2] = "None";
								}
								sign[3] = "";
								p.sendSignChange(StorageManager.MasterMindBestGameSign.getLocation(), sign);
							}
						}
					}
					
					if(StorageManager.PlayersInMasterMind.contains(p)){
						if(StorageManager.MasterMindAnimation.get(p) == false){
							
							for(int i = 0; i <= 11; i++){
								
								List<Block> blocks = StorageManager.MasterMindBlocksForTurn.get(i);
								
								List<String> blocksfromturns = StorageManager.MasterMindBlocksFromTurns.get(p);
								String turn = blocksfromturns.get(i);
								String[] turnblocks = turn.split("\\|");
								
								for(Block b : blocks){
									int bint = Integer.parseInt(turnblocks[blocks.indexOf(b)]);
									p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) bint);
								}
								
								if(i != 0 && i != 11){
									List<Block> blocks2 = StorageManager.MasterMindBlocksForTurnStatus.get(i);
									
									List<String> blockstatusfromturns = StorageManager.MasterMindStatusFromTurns.get(p);
									String status = blockstatusfromturns.get(i);
									String[] statusblocks = status.split("\\|");
									
									for(Block b : blocks2){
										int data = Integer.parseInt(statusblocks[blocks2.indexOf(b)]);
										
										p.sendBlockChange(b.getLocation(), Material.STAINED_GLASS, (byte) data);
									}
								}
							}
						}
						else{
							int Seconds = StorageManager.MasterMindAnimationSeconds.get(p);
							
							MasterMindManager.animateBlocks(p, Seconds);
							
							Seconds++;
							StorageManager.MasterMindAnimationSeconds.put(p, Seconds);
						}
					}
					else{
						for(int i = 0; i <= 11; i++){
							List<Block> blocks = StorageManager.MasterMindBlocksForTurn.get(i);
							
							for(Block b : blocks){
								p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 0);
							}
							
							if(i != 0 && i != 11){
								List<Block> blocks2 = StorageManager.MasterMindBlocksForTurnStatus.get(i);
								for(Block b : blocks2){
									p.sendBlockChange(b.getLocation(), Material.STAINED_GLASS, (byte) 0);
								}
							}
						}
					}
				}

			}
		}.runTaskTimer(this.plugin, 0, 20);
	}
}

