package me.O_o_Fadi_o_O.SkyBlock.managers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.utils.IslandRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class IslandManager {

	/*
	 * playerdata.yml
	 */
	
	public static int getPlayersIslandNumber(Player p){
		int IslandNumber = ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.IslandNumber");
		return IslandNumber;
	}
	public static IslandRank getPlayersIslandRank(Player p){
		String rank = ConfigManager.playerdata.getString("players." + p.getName() + ".IslandInfo.IslandRank");
		if(rank.equals("Owner")){
			return IslandRank.OWNER;
		}
		else{
			return IslandRank.MEMBER;
		}
	}
	public static Location getPlayersIslandHomeLocation(Player p){
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + p.getName() + ".IslandInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + p.getName() + ".IslandInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + p.getName() + ".IslandInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	public static Location getOfflinePlayersIslandHomeLocation(String p){
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + p + ".IslandInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + p + ".IslandInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + p + ".IslandInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + p + ".IslandInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + p + ".IslandInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + p + ".IslandInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	public static int getChallengeCompletedAmount(Player p, String challenge){
		int amount = ConfigManager.playerdata.getInt("players." + p.getName() + ".Challenges." + challenge +".CompleteAmount");
		return amount;
	}
	
	public static void setPlayersIslandNumber(Player p, int IslandNumber){
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.IslandNumber", IslandNumber);
		ConfigManager.savePlayerdata();
		
		StorageManager.PlayersIslandNumber.put(p, IslandNumber);
	}
	public static void setPlayersIslandRank(Player p, IslandRank rank){
		if(rank == IslandRank.OWNER){
			ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.IslandRank", "Owner");
			ConfigManager.savePlayerdata();
			
			StorageManager.PlayersIslandRank.put(p, IslandRank.OWNER);
		}
		if(rank == IslandRank.MEMBER){
			ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.IslandRank", "Member");
			ConfigManager.savePlayerdata();
			
			StorageManager.PlayersIslandRank.put(p, IslandRank.MEMBER);
		}
	}
	@SuppressWarnings("deprecation")
	public static void setOfflinePlayersIslandRank(String p, IslandRank rank){
		if(rank == IslandRank.OWNER){
			ConfigManager.playerdata.set("players." + p + ".IslandInfo.IslandRank", "Owner");
			ConfigManager.savePlayerdata();
			
			try{
				StorageManager.PlayersIslandRank.put(Bukkit.getPlayer(p), IslandRank.OWNER);
			}catch(Exception ex){
				
			}
		}
		if(rank == IslandRank.MEMBER){
			ConfigManager.playerdata.set("players." + p + ".IslandInfo.IslandRank", "Member");
			ConfigManager.savePlayerdata();
			
			try{
				StorageManager.PlayersIslandRank.put(Bukkit.getPlayer(p), IslandRank.MEMBER);
			}catch(Exception ex){
				
			}
		}
	}
	public static void setPlayersIslandHomeLocation(Player p, Location l){
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.world", l.getWorld().getName());
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.x", l.getX());
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.y", l.getY());
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.z", l.getZ());
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.yaw", l.getYaw());
		ConfigManager.playerdata.set("players." + p.getName() + ".IslandInfo.HomeLocation.pitch", l.getPitch());
		ConfigManager.savePlayerdata();
		
		StorageManager.PlayersIslandHomeLocation.put(p, l);
	}
	public static void setChallengeCompletedAmount(Player p, String challenge, int amount){
		ConfigManager.playerdata.set("players." + p.getName() + ".Challenges." + challenge +".CompleteAmount", amount);
		ConfigManager.savePlayerdata();
		
	}
	public static void resetChallenges(Player p){
		List<String> challenges = new ArrayList<String>();
		for(String s : StorageManager.Challenges){
			IslandManager.setChallengeCompletedAmount(p, s, 0);
			challenges.add(s + "|" + IslandManager.getChallengeCompletedAmount(p, s));
		}
		StorageManager.PlayersChallengesCompleteAmount.put(p, challenges);
	}
	
	/*
	 * islands.yml
	 */
	public static String getIslandOwner(int IslandNumber){
		String owner = ConfigManager.islands.getString("islands." + IslandNumber + ".Players.Owner");
		return owner;
	}
	public static List<String> getIslandMembers(int IslandNumber){
		List<String> members = ConfigManager.islands.getStringList("islands." + IslandNumber + ".Players.Members");
		return members;
	}
	public static Location getIslandLocation(int IslandNumber){
		World w = Bukkit.getWorld(ConfigManager.islands.getString("islands." + IslandNumber + ".IslandLocation.world"));
		int x = ConfigManager.islands.getInt("islands." + IslandNumber + ".IslandLocation.x");
		int y = ConfigManager.islands.getInt("islands." + IslandNumber + ".IslandLocation.y");
		int z = ConfigManager.islands.getInt("islands." + IslandNumber + ".IslandLocation.z");
		Location l = new Location(w, x, y, z);
		return l;
	}
	public static String getIslandCreatedDate(int IslandNumber){
		String date = ConfigManager.islands.getString("islands." + IslandNumber + ".CreatedDate");
		return date;
	}
	public static boolean getIslandTeleportEnabled(int IslandNumber){
		boolean teleport = ConfigManager.islands.getBoolean("islands." + IslandNumber + ".TeleportEnabled");
		return teleport;
	}
	
	public static void setIslandTeleportEnabled(int IslandNumber, boolean falseOrtrue){
		ConfigManager.islands.set("islands." + IslandNumber + ".TeleportEnabled", falseOrtrue);
		ConfigManager.saveIslands();
		
		StorageManager.IslandTeleportEnabled.put(IslandNumber, falseOrtrue);
	}
	public static void setIslandCreatedDate(int IslandNumber){
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		
		String DateCreated = fm.format(date);
		
		ConfigManager.islands.set("islands." + IslandNumber + ".CreatedDate", DateCreated);
		ConfigManager.saveIslands();
		
		StorageManager.IslandCreatedDate.put(IslandNumber, DateCreated);
	}
	public static void setIslandOwner(int IslandNumber, Player p){
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Owner", p.getName());
		ConfigManager.saveIslands();
		
		StorageManager.IslandOwner.put(IslandNumber, p.getName());
	}
	public static void setIslandOfflineOwner(int IslandNumber, String p){
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Owner", p);
		ConfigManager.saveIslands();
		
		StorageManager.IslandOwner.put(IslandNumber, p);
	}
	public static void setIslandMembers(int IslandNumber, List<String> members){
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Members", members);
		ConfigManager.saveIslands();
		
		StorageManager.IslandMembers.put(IslandNumber, members);
	}
	public static void addIslandMember(int IslandNumber, Player p){
		List<String> members = getIslandMembers(IslandNumber);
		members.add(p.getName());
		setIslandMembers(IslandNumber, members);
	}
	public static void setIslandLocation(int IslandNumber, Location l){
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.world", l.getWorld().getName());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.x", l.getBlockX());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.y", l.getBlockY());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.z", l.getBlockZ());
		ConfigManager.saveIslands();
		
		StorageManager.IslandLocation.put(IslandNumber, l);
	}
}
