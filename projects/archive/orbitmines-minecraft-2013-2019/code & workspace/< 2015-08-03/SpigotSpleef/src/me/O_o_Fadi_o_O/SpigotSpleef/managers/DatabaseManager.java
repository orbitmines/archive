package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.Bukkit;

public class DatabaseManager {
	
	public static String getquery = "";
	public static String containsquery = "";
	public static Connection connection;
	
	public static synchronized void openConnection(String hostname, String port, String databasename, String username, String password){		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + databasename, username, password);
		}catch (SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot connect to MySQL Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
	}
	
	public static synchronized void createTable(){
		checkConnection();
		
		getquery = "CREATE TABLE IF NOT EXISTS `SpigotSpleef` (`uuid` VARCHAR(50), `kits` VARCHAR(100), `kills` INTEGER(100), `wins` INTEGER(100), `loses` INTEGER(100), `tokens` INTEGER(100))";
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot insert String to Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
	}
	
	public static void insertNewPlayer(UUID uuid, String kits, int kills, int wins, int loses, int tokens){
		checkConnection();
		
		getquery = "INSERT INTO `SpigotSpleef` (`uuid`, `kits`, `kills`, `wins`, `loses`, `tokens`) VALUES ('" + uuid.toString() + "', '" + kits + "', '" + kills + "', '" + wins + "', '" + loses + "', '" + tokens + "')";		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot insert new UUID " + uuid.toString() + " to Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
	}
	
	public static boolean containsPath(String name, String Table, UUID uuid){
		checkConnection();

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `uuid`='" + uuid.toString() + "'";
		
		try{
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot search for uuid " + uuid.toString() + " in the Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
			return false;
		}
	}
	public static synchronized void insertInt(UUID uuid, String Table, String column, int i){
		checkConnection();
		
		getquery = "INSERT INTO `" + Table + "` (`uuid`, `" + column + "`) VALUES ('" + uuid.toString() + "', '" + i + "')";		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot insert Integer to Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
	}
	public static synchronized void insertString(UUID uuid, String Table, String column, String i){
		checkConnection();
		
		getquery = "INSERT INTO `" + Table + "` (`uuid`, `" + column + "`) VALUES ('" + uuid.toString() + "', '" + i.replaceAll("'", "`") + "')";
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot insert String to Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
	}
	
	public static int getInt(UUID uuid, String Table, String column){
		checkConnection();
		
		int integer = 0;
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `uuid` = '" + uuid.toString() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while(rs.next()){
				integer = rs.getInt(column);
			}
			rs.close();
			
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot receive Integer from Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
		return integer;
	}
	public static String getString(UUID uuid, String Table, String column){
		checkConnection();
		
		String string = "";
		String query = "SELECT `" + column +"` FROM `" + Table +"` WHERE `uuid` = '" + uuid.toString() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while(rs.next()){
				string = rs.getString(column);
			}
			rs.close();
			
		}catch(SQLException ex){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot receive String from Database. Error:");
			Bukkit.getLogger().warning("");
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void set(UUID uuid, String Table, String column, Object i){
		checkConnection();
		
		try{
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE `" + Table + "` SET `" + column + "` = '" + i + "' WHERE `uuid` = '" + uuid.toString() + "'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void checkConnection(){
		try{
			if(connection.isClosed()){
				openConnection(StorageManager.databasehostname, StorageManager.databaseport, StorageManager.databasename, StorageManager.databaseusername, StorageManager.databasepassword);
			}
		}catch(SQLException e){
			Bukkit.getLogger().warning("");
			Bukkit.getLogger().warning("[SpigotSpleef] Cannot reconnect to MySQL Database. Error:");
			Bukkit.getLogger().warning("");
			e.printStackTrace();
		}
	}
}
