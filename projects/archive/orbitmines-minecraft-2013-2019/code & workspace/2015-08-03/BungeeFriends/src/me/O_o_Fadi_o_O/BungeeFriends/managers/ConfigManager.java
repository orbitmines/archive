package me.O_o_Fadi_o_O.BungeeFriends.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import me.O_o_Fadi_o_O.BungeeFriends.Start;
import net.md_5.bungee.api.plugin.PluginDescription;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
 
public class ConfigManager {
 
	private ConfigManager() { }
 
	static ConfigManager plugin = new ConfigManager();
 
	static Start start = Start.getInstance();
	
	public static Configuration config;
	static File cfile;
	
	public static Configuration playerdata;
	static File pdfile;

	public static ConfigManager getInstance(){
		return plugin;
	}
	
	@SuppressWarnings("deprecation")
	public static void setup(){
	 
		if(!start.getDataFolder().exists()){
			start.getDataFolder().mkdir();
		}
	 
		cfile = new File(start.getDataFolder(), "config.yml");
		pdfile = new File(start.getDataFolder(), "playerdata.yml");
	 
		if(!cfile.exists()){
			try{
				Files.copy(start.getResourceAsStream("config.yml"), cfile.toPath());
			}catch(IOException ex){
				start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while creating config.yml");
				ex.printStackTrace();
			}
		}
		if(!pdfile.exists()){
			try{
				Files.copy(start.getResourceAsStream("playerdata.yml"), pdfile.toPath());
			}catch(IOException ex){
				start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while creating playerdata.yml");
				ex.printStackTrace();
			}
		}
		
		try{
			config = YamlConfiguration.getProvider(YamlConfiguration.class).load(cfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while loading config.yml");
			ex.printStackTrace();
		}
		try{
			playerdata = YamlConfiguration.getProvider(YamlConfiguration.class).load(pdfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while loading playerdata.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getConfig(){
		return config;
	}
	 
	@SuppressWarnings("deprecation")
	public static void saveConfig(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(start.getDataFolder(), "config.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while saving config.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadConfig(){
		try{
			config = YamlConfiguration.getProvider(YamlConfiguration.class).load(cfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while reloading config.yml");
			ex.printStackTrace();
		}
	}
	
	public Configuration getPlayerData(){
		return playerdata;
	}
	 
	@SuppressWarnings("deprecation")
	public static void savePlayerData(){
		try{
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(playerdata, new File(start.getDataFolder(), "playerdata.yml"));
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while saving playerdata.yml");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void reloadPlayerData(){
		try{
			playerdata = YamlConfiguration.getProvider(YamlConfiguration.class).load(pdfile);
		}catch(IOException ex){
			start.getProxy().getConsole().sendMessage("[BungeeFriends] Error while reloading playerdata.yml");
			ex.printStackTrace();
		}
	}
	 
	public PluginDescription getDesc(){
		return start.getDescription();
	}
}
