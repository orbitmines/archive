package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;

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
	
	public static FileConfiguration messages;
	static File msgfile;
	
	public static FileConfiguration playerdata;
	static File pdfile;
	
	public static FileConfiguration arenas;
	static File afile;
	
	public static FileConfiguration maps;
	static File mfile;

	public static void setup(){
	 
		if(!start.getDataFolder().exists()){
			start.getDataFolder().mkdir();
		}

		cfile = new File(start.getDataFolder(), "config.yml");
		msgfile = new File(start.getDataFolder(), "messages.yml");
		pdfile = new File(start.getDataFolder(), "playerdata.yml");
		afile = new File(start.getDataFolder(), "arenas.yml");
		mfile = new File(start.getDataFolder(), "maps.yml");
		
		if(!cfile.exists()){
			try{
				Files.copy(start.getResource("config.yml"), cfile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while creating config.yml");
			}
		}
		if(!msgfile.exists()){
			try{
				Files.copy(start.getResource("messages.yml"), msgfile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while creating messages.yml");
			}
		}
		if(!pdfile.exists()){
			try{
				Files.copy(start.getResource("playerdata.yml"), pdfile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while creating playerdata.yml");
			}
		}
		if(!afile.exists()){
			try{
				Files.copy(start.getResource("arenas.yml"), afile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while creating arenas.yml");
			}
		}
		if(!mfile.exists()){
			try{
				Files.copy(start.getResource("maps.yml"), mfile.toPath());
			}
			catch(IOException ex){
				Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while creating maps.yml");
			}
		}

		config = YamlConfiguration.loadConfiguration(cfile);
		messages = YamlConfiguration.loadConfiguration(msgfile);
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
		arenas = YamlConfiguration.loadConfiguration(afile);
		maps = YamlConfiguration.loadConfiguration(mfile);
	}
	
	public FileConfiguration getConfig(){
		return config;
	}
	 
	public static void saveConfig(){
		try{
			config.save(cfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while saving config.yml");
		}
	}
	
	public static void reloadConfig(){
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public FileConfiguration getMessages(){
		return messages;
	}
	 
	public static void saveMessage(){
		try{
			messages.save(msgfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while saving messages.yml");
		}
	}
	
	public static void reloadMessages(){
		messages = YamlConfiguration.loadConfiguration(msgfile);
	}
	
	public FileConfiguration getPlayerData(){
		return playerdata;
	}
	 
	public static void savePlayerData(){
		try{
			playerdata.save(pdfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while saving playerdata.yml");
		}
	}
	
	public static void reloadPlayerData(){
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
	}
	
	public FileConfiguration getArenas(){
		return arenas;
	}
	 
	public static void saveArenas(){
		try{
			arenas.save(afile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while saving arenas.yml");
		}
	}
	
	public static void reloadArenas(){
		arenas = YamlConfiguration.loadConfiguration(afile);
	}
	
	public FileConfiguration getMaps(){
		return maps;
	}
	 
	public static void saveMaps(){
		try{
			maps.save(mfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] Error while saving maps.yml");
		}
	}
	
	public static void reloadMaps(){
		maps = YamlConfiguration.loadConfiguration(mfile);
	}
	 
	public PluginDescriptionFile getDesc(){
		return start.getDescription();
	}
}
