package me.O_o_Fadi_o_O.SkyBlock.managers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.SkyBlock.Start;
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
		String uuid = p.getUniqueId().toString();
		int IslandNumber = ConfigManager.playerdata.getInt("players." + uuid + ".IslandInfo.IslandNumber");
		return IslandNumber;
	}
	public static IslandRank getPlayersIslandRank(Player p){
		String uuid = p.getUniqueId().toString();
		String rank = ConfigManager.playerdata.getString("players." + uuid + ".IslandInfo.IslandRank");
		if(rank.equals("Owner")){
			return IslandRank.OWNER;
		}
		else{
			return IslandRank.MEMBER;
		}
	}
	public static Location getPlayersIslandHomeLocation(Player p){
		String uuid = p.getUniqueId().toString();
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + uuid + ".IslandInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + uuid + ".IslandInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + uuid + ".IslandInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	public static Location getOfflinePlayersIslandHomeLocation(UUID uuids){
		String uuid = uuids.toString();
		World w = Bukkit.getWorld(ConfigManager.playerdata.getString("players." + uuid + ".IslandInfo.HomeLocation.world"));
		double x = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.x");
		double y = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.y");
		double z = ConfigManager.playerdata.getDouble("players." + uuid + ".IslandInfo.HomeLocation.z");
		float yaw = ConfigManager.playerdata.getInt("players." + uuid + ".IslandInfo.HomeLocation.yaw");
		float pitch = ConfigManager.playerdata.getInt("players." + uuid + ".IslandInfo.HomeLocation.pitch");
		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
	public static int getChallengeCompletedAmount(Player p, String challenge){
		String uuid = p.getUniqueId().toString();
		return ConfigManager.playerdata.getInt("players." + uuid + ".Challenges." + challenge);
	}
	
	public static void setPlayersIslandNumber(Player p, int IslandNumber){
		String uuid = p.getUniqueId().toString();
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.IslandNumber", IslandNumber);
		ConfigManager.savePlayerdata();
		
		StorageManager.playersislandnumber.put(p, IslandNumber);
	}
	public static void setPlayersIslandRank(Player p, IslandRank rank){
		String uuid = p.getUniqueId().toString();
		if(rank == IslandRank.OWNER){
			ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.IslandRank", "Owner");
			ConfigManager.savePlayerdata();
			
			StorageManager.playersislandrank.put(p, IslandRank.OWNER);
		}
		if(rank == IslandRank.MEMBER){
			ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.IslandRank", "Member");
			ConfigManager.savePlayerdata();
			
			StorageManager.playersislandrank.put(p, IslandRank.MEMBER);
		}
	}

	public static void setOfflinePlayersIslandRank(UUID pluuid, IslandRank rank){
		String uuid = pluuid.toString();
		if(rank == IslandRank.OWNER){
			ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.IslandRank", "Owner");
			ConfigManager.savePlayerdata();
			
			try{
				StorageManager.playersislandrank.put(Bukkit.getPlayer(pluuid), IslandRank.OWNER);
			}catch(Exception ex){
				
			}
		}
		if(rank == IslandRank.MEMBER){
			ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.IslandRank", "Member");
			ConfigManager.savePlayerdata();
			
			try{
				StorageManager.playersislandrank.put(Bukkit.getPlayer(pluuid), IslandRank.MEMBER);
			}catch(Exception ex){
				
			}
		}
	}
	public static void setPlayersIslandHomeLocation(Player p, Location l){
		String uuid = p.getUniqueId().toString();
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.world", l.getWorld().getName());
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.x", l.getX());
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.y", l.getY());
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.z", l.getZ());
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.yaw", l.getYaw());
		ConfigManager.playerdata.set("players." + uuid + ".IslandInfo.HomeLocation.pitch", l.getPitch());
		ConfigManager.savePlayerdata();
		
		StorageManager.playersislandhomelocation.put(p, l);
	}
	public static void setChallengeCompletedAmount(Player p, String challenge, int amount){
		String uuid = p.getUniqueId().toString();
		ConfigManager.playerdata.set("players." + uuid + ".Challenges." + challenge, amount);
		ConfigManager.savePlayerdata();
		
		List<String> challenges1 = new ArrayList<String>();
		for(String s1 : StorageManager.playerschallengescompleteamount.get(p)){
			challenges1.add(s1);
			if(s1.startsWith(challenge)){
				challenges1.set(challenges1.indexOf(s1), challenge + "|" + amount);
			}
		}
		StorageManager.playerschallengescompleteamount.put(p, challenges1);
	}
	public static void resetChallenges(Player p){
		List<String> challenges = new ArrayList<String>();
		for(String s : StorageManager.challenges){
			IslandManager.setChallengeCompletedAmount(p, s, 0);
			challenges.add(s + "|" + IslandManager.getChallengeCompletedAmount(p, s));
		}
		StorageManager.playerschallengescompleteamount.put(p, challenges);
	}
	
	/*
	 * islands.yml
	 */
	public static UUID getIslandOwner(int IslandNumber){
		try{
			String owner = ConfigManager.islands.getString("islands." + IslandNumber + ".Players.Owner");
			
			if(owner.length() <= 16){
				UUID uuid = Start.getUUIDfromString(owner);
				owner = uuid.toString();
				ConfigManager.islands.set("islands." + IslandNumber + ".Players.Owner", owner);
				ConfigManager.saveIslands();
			}
			
			return UUID.fromString(owner);
		}catch(Exception ex){
			return null;
		}
	}
	public static List<UUID> getIslandMembers(int IslandNumber){
		try{
			List<String> members = ConfigManager.islands.getStringList("islands." + IslandNumber + ".Players.Members");
			List<UUID> memberuuids = new ArrayList<UUID>();
			boolean oldparse = false;
			for(String uuid : members){	
				
				if(uuid.length() <= 16){
					UUID realuuid = Start.getUUIDfromString(uuid);
					members.remove(uuid);
					uuid = realuuid.toString();
					members.add(uuid);
					oldparse = true;
				}
				
				memberuuids.add(UUID.fromString(uuid));
			}
			
			if(oldparse){
				ConfigManager.islands.set("islands." + IslandNumber + ".Players.Members", members);
				ConfigManager.saveIslands();
			}
			
			return memberuuids;
		}catch(Exception ex){
			return new ArrayList<UUID>();
		}
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
		
		StorageManager.islandteleportenabled.put(IslandNumber, falseOrtrue);
	}
	public static void setIslandCreatedDate(int IslandNumber){
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		
		String DateCreated = fm.format(date);
		
		ConfigManager.islands.set("islands." + IslandNumber + ".CreatedDate", DateCreated);
		ConfigManager.saveIslands();
		
		StorageManager.islandcreateddate.put(IslandNumber, DateCreated);
	}
	public static void setIslandOwner(int IslandNumber, Player p){
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Owner", p.getUniqueId().toString());
		ConfigManager.saveIslands();
		
		StorageManager.islandowner.put(IslandNumber, p.getUniqueId());
	}
	public static void setIslandOfflineOwner(int IslandNumber, UUID pluuid){
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Owner", pluuid.toString());
		ConfigManager.saveIslands();
		
		StorageManager.islandowner.put(IslandNumber, pluuid);
	}
	public static void setIslandMembers(int IslandNumber, List<UUID> members){
		List<String> memberlist = new ArrayList<String>();
		if(members != null){
			for(UUID uuid : members){
				memberlist.add(uuid.toString());
			}
		}
		
		ConfigManager.islands.set("islands." + IslandNumber + ".Players.Members", memberlist);
		ConfigManager.saveIslands();
		
		StorageManager.islandmembers.put(IslandNumber, members);
	}
	public static void addIslandMember(int IslandNumber, Player p){
		List<UUID> members = getIslandMembers(IslandNumber);
		members.add(p.getUniqueId());
		setIslandMembers(IslandNumber, members);
	}
	public static void setIslandLocation(int IslandNumber, Location l){
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.world", l.getWorld().getName());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.x", l.getBlockX());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.y", l.getBlockY());
		ConfigManager.islands.set("islands." + IslandNumber + ".IslandLocation.z", l.getBlockZ());
		ConfigManager.saveIslands();
		
		StorageManager.islandlocation.put(IslandNumber, l);
	}
}
