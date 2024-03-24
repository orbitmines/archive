package me.O_o_Fadi_o_O.SkyGamesRuleBook.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.Start;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
 
public class ConfigManager {
 
	private ConfigManager(){}
 
	static ConfigManager instance = new ConfigManager();
 
	public static ConfigManager getInstance(){
		return instance;
	}
 
	static Start start = Start.getInstance();
	
	public static FileConfiguration config;
	static File cfile;

	public static void setup(){
	 
		if(!start.getDataFolder().exists()){
			start.getDataFolder().mkdir();
		}

		cfile = new File(start.getDataFolder(), "config.yml");
		
		if(!cfile.exists()){
			try{
				Files.copy(start.getResource("config.yml"), cfile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[RuleBook] Error while creating config.yml");
			}
		}
		
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public FileConfiguration getConfig(){
		return config;
	}
	 
	public static void saveConfig(){
		try{
			config.save(cfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[RuleBook] Error while saving config.yml");
		}
	}
	
	public static void reloadConfig(){
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	 
	public PluginDescriptionFile getDesc(){
		return start.getDescription();
	}
}
