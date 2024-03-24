package me.O_o_Fadi_o_O.Survival;

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
	
	public static FileConfiguration jobs;
	static File jfile;

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		jfile = new File(p.getDataFolder(), "jobs.yml");
	 
		if (!jfile.exists()) {
			try {
				jfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create jobs.yml!");
			}
		}
		jobs = YamlConfiguration.loadConfiguration(jfile);
	}
	
	public FileConfiguration getJobs() {
		return jobs;
	}
	 
	public static void saveJobs() {
		try {
			jobs.save(jfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save jobs.yml!");
		}
	}
	public static void reloadJobs() {
		jobs = YamlConfiguration.loadConfiguration(jfile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
