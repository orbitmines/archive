package me.O_o_Fadi_o_O.Hub.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.utils.StaffRank;
import me.O_o_Fadi_o_O.Hub.utils.TrailType;
import me.O_o_Fadi_o_O.Hub.utils.VIPRank;

import org.bukkit.entity.Player;

public class DatabaseManager {

	public static String getquery = "";
	public static String containsquery = "";
	public static Connection connection;
	
	Hub hub = Hub.getInstance();
	
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
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
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
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
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
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
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
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Settings` SET `settings` = '" + fwsettings + "' WHERE `uuid` = '" + uuid + "'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setNickname(Player p, String nickname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-Type` SET `type` = '" + trailtype.toString() + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.trailtype.put(p, trailtype);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setDiscoWardrobe(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MasterMind-BestGame` SET `turns` = '" + turns + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.mindcraftbestgame.put(p, turns);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void addVote(String player) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
		try{
			int votes = getInt(player.toLowerCase(), "Votes", "votes") +1;
		
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Votes` SET `votes` = '" + votes + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.votes.put(Hub.getUUIDfromString(player), votes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setFireworksPasses(Player p, int passes) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			int newpasses = getInt(p.getName(), "Fireworks-Passes", "passes") + passes;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + newpasses + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.fireworkpasses.put(p, newpasses);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addOMT(Player p, int OMT) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			int vippoints = getInt(p.getName(), "VIPPoints", "points") - points;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + vippoints + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.vippoints.put(p, vippoints);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addMiniGameCoins(Player p, int minigamecoins) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			int coins = getInt(p.getName(), "MiniGameCoins", "coins") - minigamecoins;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + coins + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.minigamecoins.put(p, coins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setMushroomCowName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
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
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.chatcolor.put(p, i);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setBlockTrailHats(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hats-BlockTrail` SET `blocktrail` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.hatsblocktrail.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setPlayersEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Players` SET `players` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.playersenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setStackerEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Stacker` SET `stacker` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.stackerenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setScoreboardEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Scoreboard` SET `scoreboard` = '" + bl + "' WHERE `uuid` = '" + uuid + "'");
			StorageManager.scoreboardenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
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
}
