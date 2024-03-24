package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.List;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MindCraftRunnable {
	
	Hub hub = Hub.getInstance();
	
	public void startMindCraftRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.loaded.get(p) == true){
						if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
							if(p.getLocation().distance(StorageManager.mindcraftwinssignlocation) < 16){
								{
									String[] sign = new String[4];
									sign[0] = "";
									sign[1] = "§lWins";
									if(StorageManager.mindcraftwins.containsKey(p)){
										sign[2] = "" + StorageManager.mindcraftwins.get(p);
									}
									else{
										sign[2] = "Loading...";
									}
									sign[3] = "";
									p.sendSignChange(StorageManager.mindcraftwinssignlocation, sign);
								}
								{
									String[] sign = new String[4];
									sign[0] = "";
									sign[1] = "§lBest Game";
									if(StorageManager.mindcraftbestgame.containsKey(p)){
										if(StorageManager.mindcraftbestgame.get(p) != 1){
											sign[2] = "" + StorageManager.mindcraftbestgame.get(p) + " Turns";
										}
										else{
											sign[2] = "" + StorageManager.mindcraftbestgame.get(p) + " Turn";
										}
									}
									else{
										sign[2] = "None";
									}
									sign[3] = "";
									p.sendSignChange(StorageManager.mindcraftbestgamesignlocation, sign);
								}
							}
						}
						
						if(StorageManager.playersinmindcraft.contains(p)){
							for(int i = 0; i <= 11; i++){
								
								List<Block> blocks = StorageManager.mindcraftblocksforturn.get(i);
								
								List<String> blocksfromturns = StorageManager.mindcraftblocksfromturns.get(p);
								String turn = blocksfromturns.get(i);
								String[] turnblocks = turn.split("\\|");
								
								for(Block b : blocks){
									int bint = Integer.parseInt(turnblocks[blocks.indexOf(b)]);
									p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) bint);
								}
								
								if(i != 0 && i != 11){
									List<Block> blocks2 = StorageManager.mindcraftblocksforturnstatus.get(i);
									
									List<String> blockstatusfromturns = StorageManager.mindcraftstatusfromturns.get(p);
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
							for(int i = 0; i <= 11; i++){
								List<Block> blocks = StorageManager.mindcraftblocksforturn.get(i);
								
								for(Block b : blocks){
									p.sendBlockChange(b.getLocation(), Material.WOOL, (byte) 0);
								}
								
								if(i != 0 && i != 11){
									List<Block> blocks2 = StorageManager.mindcraftblocksforturnstatus.get(i);
									for(Block b : blocks2){
										p.sendBlockChange(b.getLocation(), Material.STAINED_GLASS, (byte) 0);
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this.hub, 0, 20);
	}
}

