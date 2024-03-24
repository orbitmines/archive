package me.O_o_Fadi_o_O.Hub.managers;

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

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		pdfile = new File(p.getDataFolder(), "playerdata.yml");
	 
		if (!pdfile.exists()) {
			try {
				pdfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
			}
		}
		
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
		
		/*
		String[] files = p.getDataFolder().list();
		
		for(String file : files){
			
			if(!file.startsWith("playerdata") && file.length() <= 16){
				try{
					UUID s = Hub.getUUIDfromString(file);
					File f = new File(p.getDataFolder(), file);
					f.renameTo(new File(Hub.getInstance().getDataFolder(), s.toString()));
					Bukkit.broadcastMessage(file);
				}catch(Exception ex){}
			}
			if(!file.equals("_nextClaimID") && !file.equals("playerdata.yml") && file.endsWith(".yml")){
				File f = new File(p.getDataFolder(), file);
				//f.renameTo(new File(Hub.getInstance().getDataFolder(), file + ".yml"));
				
				FileConfiguration fdata = YamlConfiguration.loadConfiguration(f);
				
				try {
					fdata.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				for(String s : fdata.getConfigurationSection("").getKeys(false)){
					Bukkit.broadcastMessage(file + "| " + s);
				}
			}
		}*/
		
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
	
	public static void reloadPlayerData() {
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
