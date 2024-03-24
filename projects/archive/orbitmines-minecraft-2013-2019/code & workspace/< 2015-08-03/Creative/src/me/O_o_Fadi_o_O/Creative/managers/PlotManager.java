package me.O_o_Fadi_o_O.Creative.managers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlotManager {

	/*
	 * WorldEdit Commands
	 */
	
	public static List<String> getWorldEditAccess(Player p){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		List<String> accessto = new ArrayList<String>();
		if(ConfigManager.playerdata.contains("players." + uuid + ".WorldEdit")){
			for(String s : ConfigManager.playerdata.getStringList("players." + uuid + ".WorldEdit")){
				accessto.add(s);
			}
		}
		
		return accessto;
	}
	
	public static void addWorldEditAccess(Player p, String command){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		List<String> accessto = StorageManager.playersworldeditaccess.get(p);
		accessto.add(command);
		
		StorageManager.playersworldeditaccess.put(p, accessto);
		
		ConfigManager.playerdata.set("players." + uuid + ".WorldEdit", accessto);
		ConfigManager.savePlayerdata();
	}
	
	public static boolean hasWorldEditAccess(Player p, String command){
		if(StorageManager.playersworldeditaccess.get(p).contains(command)){
			return true;
		}
		else{
			return false;
		}
	}

	
	/*
	 * playerdata.yml
	 */
	
	public static int getPlayersPlotNumber(Player p){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		int PlotNumber = ConfigManager.playerdata.getInt("players." + uuid + ".PlotInfo.PlotNumber");
		return PlotNumber;
	}
	public static Location getPlayersPlotHomeLocation(Player p){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + uuid + ".PlotInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + uuid + ".PlotInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + uuid + ".PlotInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	public static Location getOfflinePlayersPlotHomeLocation(String p){
		String uuid = Start.getUUIDfromString(p).toString();
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + uuid + ".PlotInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + uuid + ".PlotInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + uuid + ".PlotInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + uuid + ".PlotInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	
	public static void setPlayersPlotNumber(Player p, int PlotNumber){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.PlotNumber", PlotNumber);
		ConfigManager.savePlayerdata();
		
		StorageManager.playersplotnumber.put(p, PlotNumber);
	}

	public static void setPlayersPlotHomeLocation(Player p, Location l){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.world", l.getWorld().getName());
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.x", l.getX());
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.y", l.getY());
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.z", l.getZ());
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.yaw", l.getYaw());
		ConfigManager.playerdata.set("players." + uuid + ".PlotInfo.HomeLocation.pitch", l.getPitch());
		ConfigManager.savePlayerdata();
		
		StorageManager.playersplothomelocation.put(p, l);
	}
	
	/*
	 * plots.yml
	 */
	public static String getPlotOwner(int PlotNumber){
		String owner = ConfigManager.plots.getString("plots." + PlotNumber + ".Players.Owner");
		return Start.getPlayerNamefromUUID(UUID.fromString(owner));
	}
	public static List<String> getPlotMembers(int PlotNumber){
		List<String> members = ConfigManager.plots.getStringList("plots." + PlotNumber + ".Players.Members");
		
		if(members != null && members.size() > 0){
			for(String member : members){
				List<String> memberon = new ArrayList<String>();
				if(StorageManager.playersplotmemberson.containsKey(Start.getPlayerNamefromUUID(UUID.fromString(member)))){
					for(String s : StorageManager.playersplotmemberson.get(Start.getPlayerNamefromUUID(UUID.fromString(member)))){
						memberon.add("" + s);
					}
				}
				memberon.remove("" + PlotNumber);
				memberon.add("" + PlotNumber);
				
				StorageManager.playersplotmemberson.put(member, memberon);
			}
		}
		return members;
	}
	public static Location getPlotLocation(int PlotNumber){
		World w = Bukkit.getWorld(ConfigManager.plots.getString("plots." + PlotNumber + ".PlotLocation.world"));
		int x = ConfigManager.plots.getInt("plots." + PlotNumber + ".PlotLocation.x");
		int y = ConfigManager.plots.getInt("plots." + PlotNumber + ".PlotLocation.y");
		int z = ConfigManager.plots.getInt("plots." + PlotNumber + ".PlotLocation.z");
		Location l = new Location(w, x, y, z);
		return l;
	}
	public static String getPlotCreatedDate(int PlotNumber){
		String date = ConfigManager.plots.getString("plots." + PlotNumber + ".CreatedDate");
		return date;
	}
	public static DyeColor getPlotColor(int PlotNumber){
		return DyeColor.valueOf(ConfigManager.plots.getString("plots." + PlotNumber + ".Color"));
	}
	public static PlotMode getPlotMode(int PlotNumber){
		return PlotMode.valueOf(ConfigManager.plots.getString("plots." + PlotNumber + ".Mode"));
	}
	
	public static void setPlotMode(int PlotNumber, PlotMode mode){
		ConfigManager.plots.set("plots." + PlotNumber + ".Mode", mode.toString());
		ConfigManager.savePlots();
		
		StorageManager.plotmode.put(PlotNumber, mode);
	}
	public static void setPlotColor(int PlotNumber, DyeColor color){
		ConfigManager.plots.set("plots." + PlotNumber + ".Color", color.toString());
		ConfigManager.savePlots();
		
		StorageManager.plotcolor.put(PlotNumber, color);
	}
	public static void setPlotCreatedDate(int PlotNumber){
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		
		String DateCreated = fm.format(date);
		
		ConfigManager.plots.set("plots." + PlotNumber + ".CreatedDate", DateCreated);
		ConfigManager.savePlots();
		
		StorageManager.plotcreateddate.put(PlotNumber, DateCreated);
	}
	public static void setPlotOwner(int PlotNumber, Player p){
		ConfigManager.plots.set("plots." + PlotNumber + ".Players.Owner", Start.getUUIDfromPlayer(p).toString());
		ConfigManager.savePlots();
		
		StorageManager.plotowner.put(PlotNumber, p.getName());
	}
	public static void setPlotOfflineOwner(int PlotNumber, String p){
		ConfigManager.plots.set("plots." + PlotNumber + ".Players.Owner", Start.getUUIDfromString(p).toString());
		ConfigManager.savePlots();
		
		StorageManager.plotowner.put(PlotNumber, p);
	}
	public static void setPlotMembers(int PlotNumber, List<String> members){
		ConfigManager.plots.set("plots." + PlotNumber + ".Members", members);
		ConfigManager.savePlots();
		
		StorageManager.plotmembers.put(PlotNumber, members);
	}
	public static void addPlotMember(int PlotNumber, Player p){
		List<String> members = getPlotMembers(PlotNumber);
		members.add(Start.getUUIDfromPlayer(p).toString());
		setPlotMembers(PlotNumber, members);
	}
	public static void setPlotLocation(int PlotNumber, Location l){
		ConfigManager.plots.set("plots." + PlotNumber + ".PlotLocation.world", l.getWorld().getName());
		ConfigManager.plots.set("plots." + PlotNumber + ".PlotLocation.x", l.getBlockX());
		ConfigManager.plots.set("plots." + PlotNumber + ".PlotLocation.y", l.getBlockY());
		ConfigManager.plots.set("plots." + PlotNumber + ".PlotLocation.z", l.getBlockZ());
		ConfigManager.savePlots();
		
		StorageManager.plotlocation.put(PlotNumber, l);
	}
}
