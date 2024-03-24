package me.O_o_Fadi_o_O.KitPvP.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.utils.StaffRank;
import me.O_o_Fadi_o_O.KitPvP.utils.TrailType;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DatabaseManager {

	public static String getquery = "";
	public static String containsquery = "";
	public static Connection connection;
	
	Start start = Start.getInstance();
	
	public static synchronized void openConnection(){
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	public static boolean containsPath(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try{
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		}catch(SQLException ex){
			ex.printStackTrace();
			openConnection();
			return false;
		}
	}
	
	public static synchronized void insertInt(String player, String Table, String column, int i){

		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		getquery = "INSERT INTO `" + Table + "` (`uuid`, `" + column + "`) VALUES ('" + uuid + "', '" + i + "')";		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public static synchronized void insertString(String player, String Table, String column, String i){

		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		getquery = "INSERT INTO `" + Table + "` (`uuid`, `" + column + "`) VALUES ('" + uuid + "', '" + i.replaceAll("'", "`") + "')";
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static void removeUUID(String uuid, String Table){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("DELETE FROM `" + Table + "` WHERE `uuid` = '" + uuid + "'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void insertUUID(String uuid, String Table){
		
		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		getquery = "INSERT INTO `" + Table + "` (`uuid`) VALUES ('" + uuid + "')";	
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			
			ps.execute();
			ps.close();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static int getInt(String player, String Table, String column){
		int integer = 0;
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `uuid` = '" + uuid + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				integer = rs.getInt(column);
			}
			
			rs.close();
		}catch (SQLException ex){
			ex.printStackTrace();
			openConnection();
		}
		return integer;
	}
	public static String getString(String player, String Table, String column){
		
		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		String uuid = Start.getUUIDfromString(player).toString();
		
		String string = "";
		
		String query = "SELECT `" + column +"` FROM `" + Table +"` WHERE `uuid` = '" + uuid + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				string = rs.getString(column);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void setVIPRank(Player p, VIPRank rank){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Rank-VIP` SET `vip` = '" + rank.toString() + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.viprank.put(p, rank);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setStaffRank(Player p, StaffRank rank){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Rank-Staff` SET `staff` = '" + rank.toString() + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.staffrank.put(p, rank);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setFireworkSettings(Player p, String fwsettings) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Settings` SET `settings` = '" + fwsettings + "' WHERE `uuid` = '" + uuid + "'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setNickname(Player p, String nickname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `PlayerNicknames` SET `nick` = '" + nickname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.nickname.put(p, nickname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeNickname(Player p) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("DELETE FROM `PlayerNicknames` WHERE `uuid` = '" + uuid + "'");
			StorageManager.nickname.remove(p);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setTrailTypeSpecial(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-TypeSpecial` SET `special` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.trailspecial.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setTrailTypeParticleAmount(Player p, int amount) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-TypeParticlesAmount` SET `amount` = '" + amount + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.trailparticlesamount.put(p, amount);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setTrailType(Player p, TrailType trailtype){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-Type` SET `type` = '" + trailtype.toString() + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.trailtype.put(p, trailtype);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void setDiscoWardrobe(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Wardrobe-Disco` SET `disco` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.wardrobedisco.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public static void addMindCraftWins(Player p) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int wins = getInt(p.getName(), "MasterMind-Wins", "wins") +1;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MasterMind-Wins` SET `wins` = '" + wins + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.mindcraftwins.put(p, wins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setMindCraftBestGame(Player p, int turns) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MasterMind-BestGame` SET `turns` = '" + turns + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.mindcraftbestgame.put(p, turns);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	public static void addVote(String player) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		try{
			int votes = getInt(player.toLowerCase(), "Votes", "votes") +1;
		
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Votes` SET `votes` = '" + votes + "' WHERE `name` = '" + player.toLowerCase() + "'");
			StorageManager.votes.put(Start.getUUIDfromString(player), votes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/*
	public static void setFireworksPasses(Player p, int passes) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + passes + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.fireworkpasses.put(p, passes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addFireworksPasses(Player p, int passes) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int newpasses = getInt(p.getName(), "Fireworks-Passes", "passes") + passes;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + newpasses + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.fireworkpasses.put(p, newpasses);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	public static void addOMT(Player p, int OMT) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int newomt = getInt(p.getName(), "OrbitMinesTokens", "omt") + OMT;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + newomt + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.orbitminestokens.put(p, newomt);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeOMT(Player p, int OMT) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int newomt = getInt(p.getName(), "OrbitMinesTokens", "omt") - OMT;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + newomt + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.orbitminestokens.put(p, newomt);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addVIPPoints(Player p, int points) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int vippoints = getInt(p.getName(), "VIPPoints", "points") + points;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + vippoints + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.vippoints.put(p, vippoints);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeVIPPoints(Player p, int points) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int vippoints = getInt(p.getName(), "VIPPoints", "points") - points;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + vippoints + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.vippoints.put(p, vippoints);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void addMiniGameCoins(Player p, int minigamecoins) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int coins = getInt(p.getName(), "MiniGameCoins", "coins") + minigamecoins;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + coins + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.minigamecoins.put(p, coins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeMiniGameCoins(Player p, int minigamecoins) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			int coins = getInt(p.getName(), "MiniGameCoins", "coins") - minigamecoins;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + coins + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.minigamecoins.put(p, coins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	public static void setMushroomCowName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.mushroomcowpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setPigName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.pigpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setWolfName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.wolfpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSheepName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.sheeppet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setHorseName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.horsepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setMagmaCubeName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.magmacubepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSlimeName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname.replaceAll("'", "`").replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.slimepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCowName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.cowpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSilverfishName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.silverfishpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setOcelotName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.ocelotpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCreeperName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Creeper` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.creeperpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSquidName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Squid` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.squidpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSpiderName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Spider` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.spiderpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setChickenName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Chicken` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.chickenpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setBoldChatColor(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors-Bold` SET `bold` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.boldchatcolor.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCursiveChatColor(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors-Cursive` SET `cursive` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.cursivechatcolor.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setChatColor(Player p, String i) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.chatcolor.put(p, i);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void setBlockTrailHats(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hats-BlockTrail` SET `blocktrail` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.hatsblocktrail.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	public static String getUUID(String player){
		
		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		String string = "";
		
		String query = "SELECT `uuid` FROM `PlayerUUIDs` WHERE `name` = '" + player + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				string = rs.getString("uuid");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	public static String getNameFromUUID(UUID uuid){
		
		String uuidstring = uuid.toString();
		
		try {
			if(connection.isClosed()){
				openConnection();
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		String string = "";
		
		String query = "SELECT `name` FROM `PlayerUUIDs` WHERE `uuid` = '" + uuidstring + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				string = rs.getString("name");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void setBestStreak(Player p, int streak){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-BestStreak` SET `beststreak` = '" + streak + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.beststreak.put(p, streak);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD Kills
	public static void addKills(Player p, int kills){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-Kills` SET `kills` = '" + (StorageManager.kills.get(p) + kills) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.kills.put(p, StorageManager.kills.get(p) + kills);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD DEATHS
	public static void addDeaths(Player p, int deaths){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-Deaths` SET `deaths` = '" + (StorageManager.deaths.get(p) + deaths) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.deaths.put(p, StorageManager.deaths.get(p) + deaths);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD COINS
	public static void addMoney(Player p, int money){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-Money` SET `money` = '" + (StorageManager.money.get(p) + money) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.money.put(p, StorageManager.money.get(p) + money);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// REMOVE COINS
	public static void removeMoney(Player p, int money){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-Money` SET `money` = '" + (StorageManager.money.get(p) - money) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.money.put(p, StorageManager.money.get(p) - money);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD LEVELS
	public static void addLevel(Player p, int level){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `KitPvP-Levels` SET `levels` = '" + (StorageManager.levels.get(p) + level) + "' WHERE `uuid` = '" + uuid + "'");
			Bukkit.broadcastMessage(Start.TAG + "§6" + p.getName() + " §7reached level §6" + (StorageManager.levels.get(p) + level) + "§7!");
			
			StorageManager.levels.put(p, StorageManager.levels.get(p) + level);
			p.setLevel(StorageManager.levels.get(p) + level);
			p.setExp(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD KNIGHT LVL
	public static void addKnightLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Knight` SET `knight` = '" + (getInt(p.getName(), "Kits-Knight", "knight") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.knight.put(p, getInt(p.getName(), "Kits-Knight", "knight"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD ARCHER LVL
	public static void addArcherLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Archer` SET `archer` = '" + (getInt(p.getName(), "Kits-Archer", "archer") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.archer.put(p, getInt(p.getName(), "Kits-Archer", "archer"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD SOLDIER LVL
	public static void addSoldierLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Soldier` SET `soldier` = '" + (getInt(p.getName(), "Kits-Soldier", "soldier") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.soldier.put(p, getInt(p.getName(), "Kits-Soldier", "soldier"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD WIZARD LVL
	public static void addWizardLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Wizard` SET `wizard` = '" + (getInt(p.getName(), "Kits-Wizard", "wizard") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.wizard.put(p, getInt(p.getName(), "Kits-Wizard", "wizard"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD TANK LVL
	public static void addTankLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Tank` SET `tank` = '" + (getInt(p.getName(), "Kits-Tank", "tank") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.tank.put(p, getInt(p.getName(), "Kits-Tank", "tank"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD DRUNK LVL
	public static void addDrunkLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Drunk` SET `drunk` = '" + (getInt(p.getName(), "Kits-Drunk", "drunk") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.drunk.put(p, getInt(p.getName(), "Kits-Drunk", "drunk"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD PYRO LVL
	public static void addPyroLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Pyro` SET `pyro` = '" + (getInt(p.getName(), "Kits-Pyro", "pyro") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.pyro.put(p, getInt(p.getName(), "Kits-Pyro", "pyro"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD BUNNY LVL
	public static void addBunnyLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Bunny` SET `bunny` = '" + (getInt(p.getName(), "Kits-Bunny", "bunny") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.bunny.put(p, getInt(p.getName(), "Kits-Bunny", "bunny"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD NECROMANCER LVL
	public static void addNecromancerLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Necromancer` SET `necromancer` = '" + (getInt(p.getName(), "Kits-Necromancer", "necromancer") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.necromancer.put(p, getInt(p.getName(), "Kits-Necromancer", "necromancer"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD KING LVL
	public static void addKingLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-King` SET `king` = '" + (getInt(p.getName(), "Kits-King", "king") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.king.put(p, getInt(p.getName(), "Kits-King", "king"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD TREE LVL
	public static void addTreeLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Tree` SET `tree` = '" + (getInt(p.getName(), "Kits-Tree", "tree") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.tree.put(p, getInt(p.getName(), "Kits-Tree", "tree"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD BLAZE LVL
	public static void addBlazeLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Blaze` SET `blaze` = '" + (getInt(p.getName(), "Kits-Blaze", "blaze") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.blaze.put(p, getInt(p.getName(), "Kits-Blaze", "blaze"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		}
	// ADD TNT LVL
	public static void addTNTLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-TNT` SET `tnt` = '" + (getInt(p.getName(), "Kits-TNT", "tnt") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.tnt.put(p, getInt(p.getName(), "Kits-TNT", "tnt"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD FISHERMAN LVL
	public static void addFishermanLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Fisherman` SET `fisherman` = '" + (getInt(p.getName(), "Kits-Fisherman", "fisherman") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.fisherman.put(p, getInt(p.getName(), "Kits-Fisherman", "fisherman"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD SNOWGOLEM LVL
	public static void addSnowGolemLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-SnowGolem` SET `snowgolem` = '" + (getInt(p.getName(), "Kits-SnowGolem", "snowgolem") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.snowgolem.put(p, getInt(p.getName(), "Kits-SnowGolem", "snowgolem"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD LIBRARIAN LVL
	public static void addLibrarianLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Librarian` SET `librarian` = '" + (getInt(p.getName(), "Kits-Librarian", "librarian") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.librarian.put(p, getInt(p.getName(), "Kits-Librarian", "librarian"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD SPIDER LVL
	public static void addSpiderLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Spider` SET `spider` = '" + (getInt(p.getName(), "Kits-Spider", "spider") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.spider.put(p, getInt(p.getName(), "Kits-Spider", "spider"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD VILLAGER LVL
	public static void addVillagerLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Villager` SET `villager` = '" + (getInt(p.getName(), "Kits-Villager", "villager") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.villager.put(p, getInt(p.getName(), "Kits-Villager", "villager"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD ASSASSIN LVL
	public static void addAssassinLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Assassin` SET `assassin` = '" + (getInt(p.getName(), "Kits-Assassin", "assassin") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.assassin.put(p, getInt(p.getName(), "Kits-Assassin", "assassin"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD LORD LVL
	public static void addLordLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Lord` SET `lord` = '" + (getInt(p.getName(), "Kits-Lord", "lord") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.lord.put(p, getInt(p.getName(), "Kits-Lord", "lord"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD VAMPIRE LVL
	public static void addVampireLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Vampire` SET `vampire` = '" + (getInt(p.getName(), "Kits-Vampire", "vampire") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.vampire.put(p, getInt(p.getName(), "Kits-Vampire", "vampire"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD DARKMAGE LVL
	public static void addDarkMageLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-DarkMage` SET `darkmage` = '" + (getInt(p.getName(), "Kits-DarkMage", "darkmage") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.darkmage.put(p, getInt(p.getName(), "Kits-DarkMage", "darkmage"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD BEAST LVL
	public static void addBeastLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Beast` SET `beast` = '" + (getInt(p.getName(), "Kits-Beast", "beast") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.beast.put(p, getInt(p.getName(), "Kits-Beast", "beast"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD FISH LVL
	public static void addFishLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Fish` SET `fish` = '" + (getInt(p.getName(), "Kits-Fish", "fish") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.fish.put(p, getInt(p.getName(), "Kits-Fish", "fish"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD HEAVY LVL
	public static void addHeavyLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Heavy` SET `heavy` = '" + (getInt(p.getName(), "Kits-Heavy", "heavy") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.heavy.put(p, getInt(p.getName(), "Kits-Heavy", "heavy"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD GRIMREAPER LVL
	public static void addGrimReaperLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-GrimReaper` SET `grimreaper` = '" + (getInt(p.getName(), "Kits-GrimReaper", "grimreaper") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.grimreaper.put(p, getInt(p.getName(), "Kits-GrimReaper", "grimreaper"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ADD MINER LVL
	public static void addMinerLvL(Player p, int lvl){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Kits-Miner` SET `miner` = '" + (getInt(p.getName(), "Kits-Miner", "miner") + lvl) + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.miner.put(p, getInt(p.getName(), "Kits-Miner", "miner"));
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
