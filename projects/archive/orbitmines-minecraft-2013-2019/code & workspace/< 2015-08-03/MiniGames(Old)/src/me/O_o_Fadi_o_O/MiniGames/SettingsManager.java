package me.O_o_Fadi_o_O.MiniGames;

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
	
	public static FileConfiguration arenas;
	static File afile;

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		afile = new File(p.getDataFolder(), "arenas.yml");
	 
		if (!afile.exists()) {
			try {
				afile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create arenas.yml!");
			}
		}
		arenas = YamlConfiguration.loadConfiguration(afile);
	}
	
	public FileConfiguration getArenas() {
		return arenas;
	}
	 
	public static void saveArenas() {
		try {
			arenas.save(afile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save arenas.yml!");
		}
	}
	public static void reloadArenas() {
		arenas = YamlConfiguration.loadConfiguration(afile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
