package me.O_o_Fadi_o_O.Hub.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class DatabaseManager {

	private static String getquery = "";
	private static String containsquery = "";
	static Connection connection;
	
	public static synchronized void openConnection(){
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static boolean containsPath(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public static synchronized void insertInt(String player, String Table, String column, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public static synchronized void insertString(String player, String Table, String column, String i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i.replaceAll("'", "`") + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
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
		} catch (SQLException ex){
			ex.printStackTrace();
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
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void addVote(String player) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Votes` SET `votes` = '" + (getInt(player.toLowerCase(), "Votes", "votes") + 1) + "' WHERE `name` = '" + player.toLowerCase() + "'");
		StorageManager.votes.put(player, getInt(player.toLowerCase(), "Votes", "votes"));
	}
	public static void setFireworksPasses(Player p, int passes) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + passes + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.FireworkPasses.put(p.getName(), passes);
	}
	public static void addFireworksPasses(Player p, int passes) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + (getInt(p.getName(), "Fireworks-Passes", "passes") + passes) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.FireworkPasses.put(p.getName(), getInt(p.getName(), "Fireworks-Passes", "passes"));
	}
	public static void addOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getInt(p.getName(), "OrbitMinesTokens", "omt") + OMT) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.omt.put(p.getName(), getInt(p.getName(), "OrbitMinesTokens", "omt"));
	}
	public static void removeOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getInt(p.getName(), "OrbitMinesTokens", "omt") - OMT) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.omt.put(p.getName(), getInt(p.getName(), "OrbitMinesTokens", "omt"));
	}
	public static void addVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getInt(p.getName(), "VIPPoints", "points") + points) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.points.put(p.getName(), getInt(p.getName(), "VIPPoints", "points"));
	}
	public static void removeVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getInt(p.getName(), "VIPPoints", "points") - points) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.points.put(p.getName(), getInt(p.getName(), "VIPPoints", "points"));
	}
	public static void addMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getInt(p.getName(), "MiniGameCoins", "coins") + points) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.coins.put(p.getName(), getInt(p.getName(), "MiniGameCoins", "coins"));
	}
	public static void removeMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getInt(p.getName(), "MiniGameCoins", "coins") - points) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.coins.put(p.getName(), getInt(p.getName(), "MiniGameCoins", "coins"));
	}
	
	public static void setMushroomCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.mushroomcow.put(p.getName(), petname);
	}
	public static void setPigName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.pig.put(p.getName(), petname);
	}
	public static void setWolfName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.wolf.put(p.getName(), petname);
	}
	public static void setSheepName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.sheep.put(p.getName(), petname);
	}
	public static void setHorseName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.horse.put(p.getName(), petname);
	}
	public static void setMagmaCubeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.magmacube.put(p.getName(), petname);
	}
	public static void setSlimeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname.replaceAll("'", "`").replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.slime.put(p.getName(), petname.replaceAll("'", "`").replaceAll("'", "`"));
	}
	public static void setCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.cow.put(p.getName(), petname);
	}
	public static void setSilverfishName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.silverfish.put(p.getName(), petname);
	}
	public static void setOcelotName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname.replaceAll("'", "`") + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.ocelot.put(p.getName(), petname);
	}
	public static void setWhiteWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.white.put(p.getName(), i);
	}
	public static void setBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.blue.put(p.getName(), i);
	}
	public static void setGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.green.put(p.getName(), i);
	}
	public static void setBlackWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.black.put(p.getName(), i);
	}
	public static void setLightBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.lightblue.put(p.getName(), i);
	}
	public static void setPinkWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.pink.put(p.getName(), i);
	}
	public static void setLightGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.lightgreen.put(p.getName(), i);
	}
	public static void setDarkBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.darkblue.put(p.getName(), i);
	}
	public static void setPurpleWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Purple` SET `purple` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.purple.put(p.getName(), i);
	}
	public static void setOrangeWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Orange` SET `orange` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.orange.put(p.getName(), i);
	}
	public static void setRedWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.red.put(p.getName(), i);
	}
	public static void setCyanWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Cyan` SET `cyan` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.cyan.put(p.getName(), i);
	}
	public static void setYellowWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Yellow` SET `yellow` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.yellow.put(p.getName(), i);
	}
	public static void setGrayWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Gray` SET `gray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.gray.put(p.getName(), i);
	}
	public static void setChatColor(Player p, String i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolor.put(p, i);
	}
	public static void setChatColorDarkRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkRed` SET `darkred` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolordarkred.put(p.getName(), i);
	}
	public static void setChatColorLightGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorlightgreen.put(p.getName(), i);
	}
	public static void setChatColorDarkGray(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkGray` SET `darkgray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolordarkgray.put(p.getName(), i);
	}
	public static void setChatColorRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorred.put(p.getName(), i);
	}
	public static void setChatColorWhite(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorwhite.put(p.getName(), i);
	}
	public static void setChatColorLightBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorlightblue.put(p.getName(), i);
	}
	public static void setChatColorPink(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorpink.put(p.getName(), i);
	}
	public static void setChatColorBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorblue.put(p.getName(), i);
	}
	public static void setChatColorDarkBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolordarkblue.put(p.getName(), i);
	}
	public static void setChatColorGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorgreen.put(p.getName(), i);
	}
	public static void setChatColorBlack(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.chatcolorblack.put(p.getName(), i);
	}
}
