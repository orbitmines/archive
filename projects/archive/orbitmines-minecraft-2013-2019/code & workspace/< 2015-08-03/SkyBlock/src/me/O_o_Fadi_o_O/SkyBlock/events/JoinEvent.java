package me.O_o_Fadi_o_O.SkyBlock.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.ConfigManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.IslandManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{

	Start start = Start.getInstance();
	PlayerManager pmanager = new PlayerManager();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);

		loadPlayerIslandInfo(p);
		
		if(!PlayerManager.hasIsland(p)){
			start.teleportToSpawn(p);
		}
		
		pmanager.loadPlayer(p);
	}
	
	public void loadPlayerIslandInfo(Player p){
		if(ConfigManager.playerdata.contains("players." + p.getName())){
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.world", ConfigManager.playerdata.getString("players." + p.getName() + ".IslandInfo.HomeLocation.world"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.x", ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.x"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.y", ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.y"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.z", ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.z"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.yaw", ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.HomeLocation.yaw"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.HomeLocation.pitch", ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.HomeLocation.pitch"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.IslandNumber", ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.IslandNumber"));
			ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".IslandInfo.IslandRank", ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.IslandRank"));
			for(String s : ConfigManager.playerdata.getConfigurationSection("players." + p.getName() + ".Challenges").getKeys(false)){
				ConfigManager.playerdata.set("players." + p.getUniqueId().toString() + ".Challenges." + s, ConfigManager.playerdata.getInt("players." + p.getName() + ".Challenges." + s));
			}
			ConfigManager.playerdata.set("players." + p.getName(), null);
			ConfigManager.savePlayerdata();
		}
		
		if(!ConfigManager.playerdata.contains("players." + p.getUniqueId().toString())){
			StorageManager.playerhasisland.put(p, false);
			
			List<String> challenges = new ArrayList<String>();
			for(String s : StorageManager.challenges){
				challenges.add(s + "|0");
			}
			StorageManager.playerschallengescompleteamount.put(p, challenges);
		}
		else{
			StorageManager.playerhasisland.put(p, true);
			int IslandNumber = IslandManager.getPlayersIslandNumber(p);

			StorageManager.playersislandnumber.put(p, IslandNumber);
			StorageManager.playersislandrank.put(p, IslandManager.getPlayersIslandRank(p));
			StorageManager.playersislandhomelocation.put(p, IslandManager.getPlayersIslandHomeLocation(p));
			
			List<String> challenges = new ArrayList<String>();
			for(String s : StorageManager.challenges){
				if(!ConfigManager.playerdata.contains("players." + p.getUniqueId().toString() + ".Challenges." + s)){
					IslandManager.setChallengeCompletedAmount(p, s, 0);
				}
				challenges.add(s + "|" + IslandManager.getChallengeCompletedAmount(p, s));
			}
			StorageManager.playerschallengescompleteamount.put(p, challenges);
		}
	}
}
