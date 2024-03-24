package me.O_o_Fadi_o_O.KitPvP.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.O_o_Fadi_o_O.KitPvP.Start;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
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

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
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
				string = rs.getString(column);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void setBestStreak(Player p, int streak) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-BestStreak` SET `beststreak` = '" + streak + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.BestStreak.put(p.getName(), streak);
	}
	
	public static void addVote(String player) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Votes` SET `votes` = '" + (getInt(player.toLowerCase(), "Votes", "votes") + 1) + "' WHERE `name` = '" + player.toLowerCase() + "'");
		StorageManager.votes.put(player, getInt(player.toLowerCase(), "Votes", "votes"));
	}
	// ADD Kills
	public static void addKills(Player p, int kills) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Kills` SET `kills` = '" + (getInt(p.getName(), "KitPvP-Kills", "kills") + kills) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.kills.put(p.getName(), getInt(p.getName(), "KitPvP-Kills", "kills"));
	}
	// ADD DEATHS
	public static void addDeaths(Player p, int deaths) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Deaths` SET `deaths` = '" + (getInt(p.getName(), "KitPvP-Deaths", "deaths") + deaths) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.deaths.put(p.getName(), getInt(p.getName(), "KitPvP-Deaths", "deaths"));
	}
	// ADD COINS
	public static void addMoney(Player p, int money) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Money` SET `money` = '" + (getInt(p.getName(), "KitPvP-Money", "money") + money) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.money.put(p.getName(), getInt(p.getName(), "KitPvP-Money", "money"));
	}
	// REMOVE COINS
	public static void removeMoney(Player p, int money) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Money` SET `money` = '" + (getInt(p.getName(), "KitPvP-Money", "money") - money) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.money.put(p.getName(), getInt(p.getName(), "KitPvP-Money", "money"));
	}
	// ADD LEVELS
	public static void addLevel(Player p, int level) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `KitPvP-Levels` SET `levels` = '" + (getInt(p.getName(), "KitPvP-Levels", "levels") + level) + "' WHERE `name` = '" + p.getName() + "'");
		Bukkit.broadcastMessage(Start.TAG + "§6" + p.getName() + " §7reached level §6" + getInt(p.getName(), "KitPvP-Levels", "levels") + "§7!");
		
		p.setLevel(getInt(p.getName(), "KitPvP-Levels", "levels"));
		p.setExp(1);
	}
	// ADD KNIGHT LVL
	public static void addKnightLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Knight` SET `knight` = '" + (getInt(p.getName(), "Kits-Knight", "knight") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.knight.put(p.getName(), getInt(p.getName(), "Kits-Knight", "knight"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD ARCHER LVL
	public static void addArcherLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Archer` SET `archer` = '" + (getInt(p.getName(), "Kits-Archer", "archer") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.archer.put(p.getName(), getInt(p.getName(), "Kits-Archer", "archer"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD SOLDIER LVL
	public static void addSoldierLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Soldier` SET `soldier` = '" + (getInt(p.getName(), "Kits-Soldier", "soldier") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.soldier.put(p.getName(), getInt(p.getName(), "Kits-Soldier", "soldier"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD WIZARD LVL
	public static void addWizardLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Wizard` SET `wizard` = '" + (getInt(p.getName(), "Kits-Wizard", "wizard") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.wizard.put(p.getName(), getInt(p.getName(), "Kits-Wizard", "wizard"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD TANK LVL
	public static void addTankLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Tank` SET `tank` = '" + (getInt(p.getName(), "Kits-Tank", "tank") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.tank.put(p.getName(), getInt(p.getName(), "Kits-Tank", "tank"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD DRUNK LVL
	public static void addDrunkLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Drunk` SET `drunk` = '" + (getInt(p.getName(), "Kits-Drunk", "drunk") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.drunk.put(p.getName(), getInt(p.getName(), "Kits-Drunk", "drunk"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD PYRO LVL
	public static void addPyroLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Pyro` SET `pyro` = '" + (getInt(p.getName(), "Kits-Pyro", "pyro") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.pyro.put(p.getName(), getInt(p.getName(), "Kits-Pyro", "pyro"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD BUNNY LVL
	public static void addBunnyLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Bunny` SET `bunny` = '" + (getInt(p.getName(), "Kits-Bunny", "bunny") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.bunny.put(p.getName(), getInt(p.getName(), "Kits-Bunny", "bunny"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD NECROMANCER LVL
	public static void addNecromancerLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Necromancer` SET `necromancer` = '" + (getInt(p.getName(), "Kits-Necromancer", "necromancer") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.necromancer.put(p.getName(), getInt(p.getName(), "Kits-Necromancer", "necromancer"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD KING LVL
	public static void addKingLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-King` SET `king` = '" + (getInt(p.getName(), "Kits-King", "king") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.king.put(p.getName(), getInt(p.getName(), "Kits-King", "king"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD TREE LVL
	public static void addTreeLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Tree` SET `tree` = '" + (getInt(p.getName(), "Kits-Tree", "tree") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.tree.put(p.getName(), getInt(p.getName(), "Kits-Tree", "tree"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD BLAZE LVL
	public static void addBlazeLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Blaze` SET `blaze` = '" + (getInt(p.getName(), "Kits-Blaze", "blaze") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.blaze.put(p.getName(), getInt(p.getName(), "Kits-Blaze", "blaze"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD TNT LVL
	public static void addTNTLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-TNT` SET `tnt` = '" + (getInt(p.getName(), "Kits-TNT", "tnt") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.tnt.put(p.getName(), getInt(p.getName(), "Kits-TNT", "tnt"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD FISHERMAN LVL
	public static void addFishermanLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Fisherman` SET `fisherman` = '" + (getInt(p.getName(), "Kits-Fisherman", "fisherman") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.fisherman.put(p.getName(), getInt(p.getName(), "Kits-Fisherman", "fisherman"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD SNOWGOLEM LVL
	public static void addSnowGolemLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-SnowGolem` SET `snowgolem` = '" + (getInt(p.getName(), "Kits-SnowGolem", "snowgolem") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.snowgolem.put(p.getName(), getInt(p.getName(), "Kits-SnowGolem", "snowgolem"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD LIBRARIAN LVL
	public static void addLibrarianLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Librarian` SET `librarian` = '" + (getInt(p.getName(), "Kits-Librarian", "librarian") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.librarian.put(p.getName(), getInt(p.getName(), "Kits-Librarian", "librarian"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD SPIDER LVL
	public static void addSpiderLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Spider` SET `spider` = '" + (getInt(p.getName(), "Kits-Spider", "spider") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.spider.put(p.getName(), getInt(p.getName(), "Kits-Spider", "spider"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD VILLAGER LVL
	public static void addVillagerLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Villager` SET `villager` = '" + (getInt(p.getName(), "Kits-Villager", "villager") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.villager.put(p.getName(), getInt(p.getName(), "Kits-Villager", "villager"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD ASSASSIN LVL
	public static void addAssassinLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Assassin` SET `assassin` = '" + (getInt(p.getName(), "Kits-Assassin", "assassin") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.assassin.put(p.getName(), getInt(p.getName(), "Kits-Assassin", "assassin"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD LORD LVL
	public static void addLordLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Lord` SET `lord` = '" + (getInt(p.getName(), "Kits-Lord", "lord") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.lord.put(p.getName(), getInt(p.getName(), "Kits-Lord", "lord"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD VAMPIRE LVL
	public static void addVampireLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Vampire` SET `vampire` = '" + (getInt(p.getName(), "Kits-Vampire", "vampire") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.vampire.put(p.getName(), getInt(p.getName(), "Kits-Vampire", "vampire"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD DARKMAGE LVL
	public static void addDarkMageLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-DarkMage` SET `darkmage` = '" + (getInt(p.getName(), "Kits-DarkMage", "darkmage") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.darkmage.put(p.getName(), getInt(p.getName(), "Kits-DarkMage", "darkmage"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD BEAST LVL
	public static void addBeastLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Beast` SET `beast` = '" + (getInt(p.getName(), "Kits-Beast", "beast") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.beast.put(p.getName(), getInt(p.getName(), "Kits-Beast", "beast"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD FISH LVL
	public static void addFishLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Fish` SET `fish` = '" + (getInt(p.getName(), "Kits-Fish", "fish") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.fish.put(p.getName(), getInt(p.getName(), "Kits-Fish", "fish"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD HEAVY LVL
	public static void addHeavyLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Heavy` SET `heavy` = '" + (getInt(p.getName(), "Kits-Heavy", "heavy") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.heavy.put(p.getName(), getInt(p.getName(), "Kits-Heavy", "heavy"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD GRIMREAPER LVL
	public static void addGrimReaperLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-GrimReaper` SET `grimreaper` = '" + (getInt(p.getName(), "Kits-GrimReaper", "grimreaper") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.grimreaper.put(p.getName(), getInt(p.getName(), "Kits-GrimReaper", "grimreaper"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	// ADD MINER LVL
	public static void addMinerLvL(Player p, int lvl) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Kits-Miner` SET `miner` = '" + (getInt(p.getName(), "Kits-Miner", "miner") + lvl) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.miner.put(p.getName(), getInt(p.getName(), "Kits-Miner", "miner"));
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 6, 1);
	}
	
	
	public static void addVote(Player p) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Votes` SET `votes` = '" + (getInt(p.getName(), "Votes", "votes") + 1) + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.votes.put(p.getName(), getInt(p.getName(), "Votes", "votes"));
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
		s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.mushroomcow.put(p.getName(), petname);
	}
	public static void setPigName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.pig.put(p.getName(), petname);
	}
	public static void setWolfName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.wolf.put(p.getName(), petname);
	}
	public static void setSheepName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.sheep.put(p.getName(), petname);
	}
	public static void setHorseName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.horse.put(p.getName(), petname);
	}
	public static void setMagmaCubeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.magmacube.put(p.getName(), petname);
	}
	public static void setSlimeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.slime.put(p.getName(), petname);
	}
	public static void setCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.cow.put(p.getName(), petname);
	}
	public static void setSilverfishName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		StorageManager.silverfish.put(p.getName(), petname);
	}
	public static void setOcelotName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
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
