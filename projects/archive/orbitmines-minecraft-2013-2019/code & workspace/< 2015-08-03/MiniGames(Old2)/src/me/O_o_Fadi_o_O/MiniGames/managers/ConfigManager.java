package me.O_o_Fadi_o_O.MiniGames.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 



import java.io.File;
import java.io.IOException;
 
public class ConfigManager {
 
	private ConfigManager() { }
 
	static ConfigManager instance = new ConfigManager();
 
	public static ConfigManager getInstance() {
		return instance;
	}
 
	Plugin p;
	
	public static FileConfiguration chickenfight;
	static File cffile;
	
	public static FileConfiguration survivalgames;
	static File sgfile;
	
	public static FileConfiguration minigames;
	static File mfile;
	
	public static FileConfiguration votedata;
	static File vfile;

	public static void setup(Plugin p) {
	 
		if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
		}
	 
		cffile = new File(p.getDataFolder(), "chickenfight.yml");
		sgfile = new File(p.getDataFolder(), "survivalgames.yml");
		mfile = new File(p.getDataFolder(), "minigames.yml");
		vfile = new File(p.getDataFolder(), "votedata.yml");
		 
		if (!vfile.exists()) {
			try {
				vfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create votedata.yml!");
			}
		}
		if (!cffile.exists()) {
			try {
				cffile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create chickenfight.yml!");
			}
		}
		if (!mfile.exists()) {
			try {
				mfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create minigames.yml!");
			}
		}
		if (!sgfile.exists()) {
			try {
				sgfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create survivalgames.yml!");
			}
		}
		
		votedata = YamlConfiguration.loadConfiguration(vfile);
		chickenfight = YamlConfiguration.loadConfiguration(cffile);
		survivalgames = YamlConfiguration.loadConfiguration(sgfile);
		minigames = YamlConfiguration.loadConfiguration(mfile);
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
	
	public FileConfiguration getChickenFight() {
		return chickenfight;
	}
	 
	public static void saveChickenFight() {
		try {
			chickenfight.save(cffile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save chickenfight.yml!");
		}
	}
	public static void reloadMiniGames() {
		minigames = YamlConfiguration.loadConfiguration(mfile);
	}
	 
	public FileConfiguration getMiniGames() {
		return minigames;
	}
	
	public static void saveSurvivalGames() {
		try {
			survivalgames.save(sgfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save survivalgames.yml!");
		}
	}
	public static void reloadSurvivalGames() {
		survivalgames = YamlConfiguration.loadConfiguration(sgfile);
	}
	 
	public FileConfiguration getSurvivalGames() {
		return survivalgames;
	}
	 
	public static void saveMiniGames() {
		try {
			minigames.save(mfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save minigames.yml!");
		}
	}
	public static void reloadChickenFight() {
		chickenfight = YamlConfiguration.loadConfiguration(cffile);
	}
	 
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
