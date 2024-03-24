package me.O_o_Fadi_o_O.OrbitMines.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

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
	
	public static FileConfiguration plots;
	static File pfile;
	
	public static FileConfiguration playerdata;
	static File pdfile;
	
	public static FileConfiguration chestshops;
	static File csfile;
	
	public static FileConfiguration warps;
	static File wfile;
	
	public static FileConfiguration islands;
	static File isfile;
	
	public static FileConfiguration shops;
	static File sfile;


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
				Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating config.yml");
			}
		}

		config = YamlConfiguration.loadConfiguration(cfile);
		
		if(ServerData.isServer(Server.CREATIVE)){
			pfile = new File(start.getDataFolder(), "plots.yml");
			
			if(!pfile.exists()){
				try{
					Files.copy(start.getResource("plots.yml"), pfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating plots.yml");
				}
			}

			plots = YamlConfiguration.loadConfiguration(pfile);
		}
		else if(ServerData.isServer(Server.SURVIVAL)){
			wfile = new File(start.getDataFolder(), "warps.yml");
			
			if(!wfile.exists()){
				try{
					Files.copy(start.getResource("warps.yml"), wfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating warps.yml");
				}
			}

			warps = YamlConfiguration.loadConfiguration(wfile);
		}
		else if(ServerData.isServer(Server.SKYBLOCK)){
			isfile = new File(start.getDataFolder(), "islands.yml");
			
			if(!isfile.exists()){
				try{
					Files.copy(start.getResource("islands.yml"), isfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating islands.yml");
				}
			}

			islands = YamlConfiguration.loadConfiguration(isfile);
		}
		else if(ServerData.isServer(Server.PRISON)){
			sfile = new File(start.getDataFolder(), "shops.yml");
			
			if(!sfile.exists()){
				try{
					Files.copy(start.getResource("shops.yml"), sfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating shops.yml");
				}
			}

			shops = YamlConfiguration.loadConfiguration(sfile);
		}
		else{}
		
		if(ServerData.isServer(Server.SURVIVAL, Server.PRISON)){
			csfile = new File(start.getDataFolder(), "chestshops.yml");
			
			if(!csfile.exists()){
				try{
					Files.copy(start.getResource("chestshops.yml"), csfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating chestshops.yml");
				}
			}
			
			chestshops = YamlConfiguration.loadConfiguration(csfile);
		}
		
		if(ServerData.isServer(Server.CREATIVE, Server.SURVIVAL, Server.SKYBLOCK)){
			pdfile = new File(start.getDataFolder(), "playerdata.yml");
			
			if(!pdfile.exists()){
				try{
					Files.copy(start.getResource("playerdata.yml"), pdfile.toPath());
				}
				catch(IOException ex){
					Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while creating playerdata.yml");
				}
			}

			playerdata = YamlConfiguration.loadConfiguration(pdfile);
		}
	}
	
	public FileConfiguration getConfig(){
		return config;
	}
	 
	public static void saveConfig(){
		try{
			config.save(cfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving config.yml");
		}
	}
	
	public static void reloadConfig(){
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public FileConfiguration getPlots(){
		return plots;
	}
	 
	public static void savePlots(){
		try{
			plots.save(pfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving plots.yml");
		}
	}
	
	public static void reloadPlots(){
		plots = YamlConfiguration.loadConfiguration(pfile);
	}
	
	public FileConfiguration getPlayerData(){
		return playerdata;
	}
	 
	public static void savePlayerData(){
		try{
			playerdata.save(pdfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving playerdata.yml");
		}
	}
	
	public static void reloadPlayerData(){
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
	}
	
	public FileConfiguration getChestShops(){
		return chestshops;
	}
	 
	public static void saveChestShops(){
		try{
			chestshops.save(csfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving chestshops.yml");
		}
	}
	
	public static void reloadChestShops(){
		chestshops = YamlConfiguration.loadConfiguration(csfile);
	}
	
	public FileConfiguration getWarps(){
		return warps;
	}
	 
	public static void saveWarps(){
		try{
			warps.save(wfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving warps.yml");
		}
	}
	
	public static void reloadWarps(){
		warps = YamlConfiguration.loadConfiguration(wfile);
	}
	
	public FileConfiguration getIslands(){
		return islands;
	}
	 
	public static void saveIslands(){
		try{
			islands.save(isfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving islands.yml");
		}
	}
	
	public static void reloadIslands(){
		islands = YamlConfiguration.loadConfiguration(isfile);
	}
	
	public FileConfiguration getShops(){
		return shops;
	}
	 
	public static void saveShops(){
		try{
			shops.save(sfile);
		}
		catch(IOException ex){
			Bukkit.getConsoleSender().sendMessage("[OrbitMines] Error while saving shops.yml");
		}
	}
	
	public static void reloadShops(){
		shops = YamlConfiguration.loadConfiguration(sfile);
	}
	 
	public PluginDescriptionFile getDesc(){
		return start.getDescription();
	}
}
