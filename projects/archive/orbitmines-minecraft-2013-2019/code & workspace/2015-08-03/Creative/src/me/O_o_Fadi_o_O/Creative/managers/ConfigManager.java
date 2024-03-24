package me.O_o_Fadi_o_O.Creative.managers;
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

 
	public static FileConfiguration plots;
	static File pfile;
	 
	public static FileConfiguration playerdata;
	static File pdfile;
	
	public static FileConfiguration votedata;
	static File vfile;

	public static void setup(Plugin p) {
	 
		if(!p.getDataFolder().exists()){
			p.getDataFolder().mkdir();
		}
	 
		pfile = new File(p.getDataFolder(), "plots.yml");
		pdfile = new File(p.getDataFolder(), "playerdata.yml");
		vfile = new File(p.getDataFolder(), "votedata.yml");
		 
		if (!vfile.exists()) {
			try {
				vfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create votedata.yml!");
			}
		}
		if(!pfile.exists()){
			try{
				pfile.createNewFile();
			}
			catch(IOException e){
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create plots.yml!");
			}
		}
		if(!pdfile.exists()){
			try{
				pdfile.createNewFile();
			}
			catch(IOException e){
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
			}
		}
		votedata = YamlConfiguration.loadConfiguration(vfile);
		plots = YamlConfiguration.loadConfiguration(pfile);
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
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
	
	public FileConfiguration getPlots(){
		return plots;
	}
	 
	public static void savePlots(){
		try{
			plots.save(pfile);
		}
		catch(IOException e){
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save plots.yml!");
		}
	}
	 
	public static void reloadPlots() {
		plots = YamlConfiguration.loadConfiguration(pfile);
	}
	
	public FileConfiguration getPlayerdata(){
		return playerdata;
	}
	 
	public static void savePlayerdata(){
		try{
			playerdata.save(pdfile);
		}
		catch(IOException e){
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save playerdata.yml!");
		}
	}
	 
	public static void reloadPlayerdata() {
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
	}
		
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
