package me.O_o_Fadi_o_O.Prison.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 
public class ConfigManager {
 
	private ConfigManager() { }
 
	static ConfigManager instance = new ConfigManager();
 
	public static ConfigManager getInstance() {
		return instance;
	}
 
	Plugin p;
	
	public static FileConfiguration playerdata;
	static File pdfile;
	
	public static FileConfiguration mines;
	static File mifile;

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		pdfile = new File(p.getDataFolder(), "playerdata.yml");
		mifile = new File(p.getDataFolder(), "mines.yml");
	 
		if (!pdfile.exists()) {
			try {
				pdfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
			}
		}
		if (!mifile.exists()) {
			try {
				mifile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create mines.yml!");
			}
		}
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
		mines = YamlConfiguration.loadConfiguration(mifile);
	}
	
	public FileConfiguration getPlayerData() {
		return playerdata;
	}
	 
	public static void savePlayerData() {
		try {
			playerdata.save(pdfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save playerdata.yml!");
		}
	}
	
	public static void saveMines() {
		try {
			mines.save(mifile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save mines.yml!");
		}
	}
	public static void reloadMines() {
		mines = YamlConfiguration.loadConfiguration(mifile);
	}
	 
	public FileConfiguration getMines() {
		return mines;
	}
	public static void reloadPlayerData() {
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
