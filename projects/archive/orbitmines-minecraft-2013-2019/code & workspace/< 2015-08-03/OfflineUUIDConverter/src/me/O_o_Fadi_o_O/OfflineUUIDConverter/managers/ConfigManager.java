package me.O_o_Fadi_o_O.OfflineUUIDConverter.managers;

import java.io.File;
import java.util.UUID;

import me.O_o_Fadi_o_O.OfflineUUIDConverter.Start;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 
public class ConfigManager {
 
	private ConfigManager() { }
 
	static ConfigManager instance = new ConfigManager();
 
	public static ConfigManager getInstance() {
		return instance;
	}
 
	Plugin p;

	public static void setup(Plugin p) {
	 
		String[] files = p.getDataFolder().list();
		
		for(String file : files){
			try{
				File f = new File(p.getDataFolder(), file);
				OfflinePlayer fp = Bukkit.getOfflinePlayer(UUID.fromString(file.replaceAll(".dat", "")));
				f.renameTo(new File(Start.getInstance().getDataFolder(), fp.getName() + ".dat"));
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
