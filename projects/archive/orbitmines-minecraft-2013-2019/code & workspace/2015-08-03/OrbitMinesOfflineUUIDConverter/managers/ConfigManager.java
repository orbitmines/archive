package me.O_o_Fadi_o_O.Survival.managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
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
	
	public static boolean loadessentialshomes = true;
	private static HashMap<String, File> playerfiles = new HashMap<String, File>();

	public static void setup(Plugin p) {
	 
		if(!p.getDataFolder().exists()){
			p.getDataFolder().mkdir();
		}
	 
		pdfile = new File(p.getDataFolder(), "playerdata.yml");
	 
		if(!pdfile.exists()){
			try{
				pdfile.createNewFile();
			}
			catch(IOException e){
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
			}
		}
		
		playerdata = YamlConfiguration.loadConfiguration(pdfile);
		
		if(loadessentialshomes == true){
			String[] files = p.getDataFolder().list();
			
			for(String file : files){
				if(!file.equals("playerdata.yml") && !file.equals("config.yml") && !file.startsWith(" DONE")){
					playerfiles.put(file.replaceAll(".yml", ""), new File(p.getDataFolder(), file));
					Bukkit.broadcastMessage(file);
				}
			}
		}
	}
	
	public static void checkForOldHomes(Player p){
		FileConfiguration file;
		
		if(playerfiles.containsKey(p.getName().toLowerCase())){
			file = YamlConfiguration.loadConfiguration(playerfiles.get(p.getName().toLowerCase()));
			
			if(file.contains("homes")){
				p.sendMessage("§7Loading old §6Homes§7...");
				for(String home : file.getConfigurationSection("homes").getKeys(false)){
					
					if(file.getString("homes." + home + ".world").equals("SurvivalWorld")){
						World w = Bukkit.getWorld(file.getString("homes." + home + ".world"));
						double x = Double.parseDouble(file.getString("homes." + home + ".x"));
						double y = Double.parseDouble(file.getString("homes." + home + ".y"));
						double z = Double.parseDouble(file.getString("homes." + home + ".z"));
						float yaw = Float.parseFloat(file.getString("homes." + home + ".yaw"));
						float pitch = Float.parseFloat(file.getString("homes." + home + ".pitch"));
						
						Location l = new Location(w, x, y, z, yaw, pitch);
						
						try{
							File f = playerfiles.get(p.getName().toLowerCase());
							f.renameTo(new File(Start.getInstance().getDataFolder(), " DONE " + p.getName() + ".yml"));
						}catch(Exception ex){}
						playerfiles.remove(p.getName().toLowerCase());
						
						HomeManager.setHome(p, l, home);
					}
					else{
						p.sendMessage("§7Your old home §6" + home + "§7 has been deleted!");
					}
				}
				p.sendMessage("§7Old §6Homes§7 loaded!");
			}
		}
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
