package me.O_o_Fadi_o_O.Creative.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.ConfigManager;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.PlotManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

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

		loadPlayerPlotInfo(p);
		
		if(!PlayerManager.hasPlot(p)){
			start.teleportToSpawn(p);
		}
		
		pmanager.loadPlayer(p);
	}
	
	public void loadPlayerPlotInfo(Player p){
		Start.permission.playerAddTransient(p, "worldedit.wand");
		Start.permission.playerAddTransient(p, "worldedit.selection.pos");
		Start.permission.playerAddTransient(p, "worldedit.region.set");
		Start.permission.playerAddTransient(p, "worldedit.region.line");
		Start.permission.playerAddTransient(p, "worldedit.region.walls");
		Start.permission.playerAddTransient(p, "worldedit.region.replace");
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		if(ConfigManager.playerdata.contains("players." + p.getName())){
			ConfigManager.playerdata.set("players." + uuid + ".WorldEdit", ConfigManager.playerdata.getStringList("players." + p.getName() + ".WorldEdit"));
			
			try{
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.world", ConfigManager.playerdata.getString("players." + p.getName() + ".PlotInfo.HomeLocation.world"));
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.x", ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.HomeLocation.x"));
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.y", ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.HomeLocation.y"));
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.z", ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.HomeLocation.z"));
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.yaw", ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.HomeLocation.yaw"));
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.pitch", ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.HomeLocation.pitch"));
				
				int PlotNumber = ConfigManager.playerdata.getInt("players." + p.getName() + ".PlotInfo.PlotNumber");
				
				ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.PlotNumber", PlotNumber);
				ConfigManager.savePlayerdata();
				
				ConfigManager.plots.set("plots." + PlotNumber + ".Players.Owner", Start.getUUIDfromPlayer(p).toString());
				
				if(ConfigManager.plots.contains("plots." + PlotNumber + ".Members")){
					List<String> members = ConfigManager.plots.getStringList("plots." + PlotNumber + ".Members");
					List<String> uuidmembers = new ArrayList<String>();
					for(String member : members){
						uuidmembers.add(Start.getUUIDfromString(member).toString());
					}
					ConfigManager.plots.set("plots." + PlotNumber + ".Members", uuidmembers);
				}
				ConfigManager.savePlots();
			}catch(Exception ex){}
			
			ConfigManager.playerdata.set("players." + p.getName(), null);
			ConfigManager.savePlayerdata();
		}
		
		try{
			if(!ConfigManager.playerdata.contains("players." + uuid + ".PlotInfo")){
				StorageManager.playerhasplot.put(p, false);
			}
			else{
				StorageManager.playerhasplot.put(p, true);
				int PlotNumber = PlotManager.getPlayersPlotNumber(p);
	
				StorageManager.playersplotnumber.put(p, PlotNumber);
				StorageManager.playersplothomelocation.put(p, PlotManager.getPlayersPlotHomeLocation(p));
			}
			
			if(!ConfigManager.playerdata.contains("players." + uuid + ".WorldEdit")){
				List<String> accessto = new ArrayList<String>();
				StorageManager.playersworldeditaccess.put(p, accessto);
				ConfigManager.playerdata.set("players." + uuid + ".WorldEdit", accessto);
			}
			else{
				StorageManager.playersworldeditaccess.put(p, PlotManager.getWorldEditAccess(p));
			}
		}catch(Exception ex){
			
		}
	}
}
