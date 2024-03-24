package me.O_o_Fadi_o_O.OnKill;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 



import java.io.File;
import java.io.IOException;
 
public class SettingsManager {
 
private SettingsManager() { }
 
static SettingsManager instance = new SettingsManager();
 
public static SettingsManager getInstance() {
return instance;
}
 
Plugin p;
 
static FileConfiguration config;
static File cfile;
 
static FileConfiguration data;
static File dfile;

static FileConfiguration scoreboard;
static File sfile;

public static void setup(Plugin p) {
	cfile = new File(p.getDataFolder(), "config.yml");
	config = p.getConfig();
	//config.options().copyDefaults(true);
	//saveConfig();
 
	if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
	}
 
	// PLAYERDATA & SCOREBOARD
	dfile = new File(p.getDataFolder(), "data.yml");
	sfile = new File(p.getDataFolder(), "scoreboard.yml");
 
	// DATA FOLDER
	if (!dfile.exists()) {
			try {
				dfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
			}
	}
	// SCOREBOARD FOLDER
	if (!sfile.exists()) {
		try {
			sfile.createNewFile();
			
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create scoreboard.yml!");
		}
	}
	// REGISTER
	data = YamlConfiguration.loadConfiguration(dfile);
	scoreboard = YamlConfiguration.loadConfiguration(sfile);
	}
 	// API PLAYERDATA
	public FileConfiguration getData() {
		return data;
	}
 
	public static void saveData() {
		try {
			data.save(dfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
		}
	}
 
	public static void reloadData() {
		data = YamlConfiguration.loadConfiguration(dfile);
	}
	
 	// API SCOREBOARD
	public FileConfiguration getScoreboardData() {
		return scoreboard;
	}
 
	public static void saveScoreboardData() {
		try {
			scoreboard.save(sfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save scoreboard.yml!");
		}
	}
 
	public static void reloadScoreboardData() {
		scoreboard = YamlConfiguration.loadConfiguration(sfile);
	}
	// CONFIG
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public static void saveConfig() {
		try {
			config.save(cfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
		}
	}
 
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}
 
	public PluginDescriptionFile getDesc() {
	return p.getDescription();
	}
}
