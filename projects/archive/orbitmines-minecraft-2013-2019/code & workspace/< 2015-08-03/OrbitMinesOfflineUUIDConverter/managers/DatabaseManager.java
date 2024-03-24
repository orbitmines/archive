package me.O_o_Fadi_o_O.Survival.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.utils.StaffRank;
import me.O_o_Fadi_o_O.Survival.utils.TrailType;
import me.O_o_Fadi_o_O.Survival.utils.VIPRank;

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
	public static void insertInt(String player, String Table, String column, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch (SQLException ex){
			ex.printStackTrace();
			openConnection();
		}
	}
	public static void insertString(String player, String Table, String column, String i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i.replaceAll("'", "`") + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch (SQLException ex){
			ex.printStackTrace();
			openConnection();
		}
	}
	
	public static void insertPlayerName(String player, String Table){

		getquery = "INSERT INTO `" + Table + "` (`name`) VALUES ('" + player + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch (SQLException ex){
			ex.printStackTrace();
			openConnection();
		}
	}
	
	public static int getInt(String player, String Table, String column){
		int integer = 0;
		
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `name` = '" + player + "'"; 
		
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
	public static String getString(Player p, String Table, String column){
		String string = "";
		
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				string = rs.getString(column).replaceAll("`", "'");
			}
			
			rs.close();
		}catch (SQLException ex){
			ex.printStackTrace();
			openConnection();
		}
		return string;
	}
	
	public static void setVIPRank(Player p, VIPRank rank){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Rank-VIP` SET `vip` = '" + rank.toString() + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.viprank.put(p, rank);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setStaffRank(Player p, StaffRank rank){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Rank-Staff` SET `staff` = '" + rank.toString() + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.staffrank.put(p, rank);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setFireworkSettings(Player p, String fwsettings) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Settings` SET `settings` = '" + fwsettings + "' WHERE `name` = '" + p.getName() + "'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setNickname(Player p, String nickname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `PlayerNicknames` SET `nick` = '" + nickname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.nickname.put(p, nickname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeNickname(Player p) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("DELETE FROM `PlayerNicknames` WHERE `name` = '" + p.getName() + "'");
			StorageManager.nickname.remove(p);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setTrailTypeSpecial(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-TypeSpecial` SET `special` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.trailspecial.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setTrailTypeParticleAmount(Player p, int amount) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-TypeParticlesAmount` SET `amount` = '" + amount + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.trailparticlesamount.put(p, amount);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setTrailType(Player p, TrailType trailtype){
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Trails-Type` SET `type` = '" + trailtype.toString() + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.trailtype.put(p, trailtype);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void setDiscoWardrobe(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Wardrobe-Disco` SET `disco` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.wardrobedisco.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
	
	/*
	public static void addMindCraftWins(Player p) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int wins = getInt(p.getName(), "MasterMind-Wins", "wins") +1;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MasterMind-Wins` SET `wins` = '" + wins + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.mindcraftwins.put(p, wins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setMindCraftBestGame(Player p, int turns) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MasterMind-BestGame` SET `turns` = '" + turns + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.mindcraftbestgame.put(p, turns);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
	
	public static void addVote(String player) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int votes = getInt(player.toLowerCase(), "Votes", "votes") +1;
		
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Votes` SET `votes` = '" + votes + "' WHERE `name` = '" + player.toLowerCase() + "'");
			StorageManager.votes.put(player, votes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void setFireworksPasses(Player p, int passes) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + passes + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.fireworkpasses.put(p, passes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addFireworksPasses(Player p, int passes) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int newpasses = getInt(p.getName(), "Fireworks-Passes", "passes") + passes;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + newpasses + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.fireworkpasses.put(p, newpasses);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
	public static void addOMT(Player p, int OMT) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int newomt = getInt(p.getName(), "OrbitMinesTokens", "omt") + OMT;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + newomt + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.orbitminestokens.put(p, newomt);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeOMT(Player p, int OMT) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int newomt = getInt(p.getName(), "OrbitMinesTokens", "omt") - OMT;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + newomt + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.orbitminestokens.put(p, newomt);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void addVIPPoints(Player p, int points) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int vippoints = getInt(p.getName(), "VIPPoints", "points") + points;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + vippoints + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.vippoints.put(p, vippoints);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeVIPPoints(Player p, int points) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int vippoints = getInt(p.getName(), "VIPPoints", "points") - points;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + vippoints + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.vippoints.put(p, vippoints);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void addMiniGameCoins(Player p, int minigamecoins) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int coins = getInt(p.getName(), "MiniGameCoins", "coins") + minigamecoins;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + coins + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.minigamecoins.put(p, coins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void removeMiniGameCoins(Player p, int minigamecoins) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			int coins = getInt(p.getName(), "MiniGameCoins", "coins") - minigamecoins;
			
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + coins + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.minigamecoins.put(p, coins);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
	
	public static void setMushroomCowName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.mushroomcowpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setPigName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.pigpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setWolfName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.wolfpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSheepName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.sheeppet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setHorseName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.horsepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setMagmaCubeName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.magmacubepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSlimeName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname.replaceAll("'", "`").replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.slimepet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCowName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.cowpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSilverfishName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.silverfishpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setOcelotName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.ocelotpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCreeperName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Creeper` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.creeperpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSquidName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Squid` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.squidpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setSpiderName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Spider` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.spiderpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setChickenName(Player p, String petname) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Pets-Chicken` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.chickenpet.put(p, petname);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setBoldChatColor(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors-Bold` SET `bold` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.boldchatcolor.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setCursiveChatColor(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors-Cursive` SET `cursive` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.cursivechatcolor.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setChatColor(Player p, String i) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.chatcolor.put(p, i);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	public static void setBlockTrailHats(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hats-BlockTrail` SET `blocktrail` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.hatsblocktrail.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setPlayersEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Players` SET `players` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.playersenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setStackerEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Stacker` SET `stacker` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.stackerenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void setScoreboardEnabled(Player p, boolean bl) {
		try{if(connection.isClosed()){openConnection();}}catch(SQLException ex){ex.printStackTrace();}
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `Hub-Scoreboard` SET `scoreboard` = '" + bl + "' WHERE `name` = '" + p.getName() + "'");
			StorageManager.scoreboardenabled.put(p, bl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
}
