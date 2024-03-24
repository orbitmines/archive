package me.O_o_Fadi_o_O.Survival.managers;

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
	
	public static FileConfiguration votedata;
	static File vfile;

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		vfile = new File(p.getDataFolder(), "votedata.yml");
	 
		if (!vfile.exists()) {
			try {
				vfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create votedata.yml!");
			}
		}
		
		votedata = YamlConfiguration.loadConfiguration(vfile);
		
	}
	
	public FileConfiguration getVoteData() {
		return votedata;
	}
	 
	public static void saveVoteData() {
		try {
			votedata.save(vfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save votedata.yml!");
		}
	}
	
	public static void reloadVoteData() {
		votedata = YamlConfiguration.loadConfiguration(vfile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
