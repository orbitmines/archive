package me.O_o_Fadi_o_O.Hub.runnables;

import org.bukkit.scheduler.BukkitRunnable;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

public class VoteRunnable {

	Hub plugin;
	 
	public VoteRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startVoteRunnable(){
		
		new BukkitRunnable(){

			@Override
			public void run() {
				try{
					for(String s : ConfigManager.playerdata.getConfigurationSection("players").getKeys(false)){
						StorageManager.votes.put(s, ConfigManager.playerdata.getInt("players." + s + ".Votes"));
						if(StorageManager.votesPlayers.contains(s)){
							StorageManager.votesPlayers.remove(s);
						}
						StorageManager.votesPlayers.add(s);
					}
				}
				catch(Exception ex){}
				
			}
		}.runTaskTimer(this.plugin, 0, 20 * 60 * 60);
		
	}
}
