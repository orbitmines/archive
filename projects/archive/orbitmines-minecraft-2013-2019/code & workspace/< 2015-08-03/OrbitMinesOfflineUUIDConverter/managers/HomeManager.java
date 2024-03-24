package me.O_o_Fadi_o_O.Survival.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class HomeManager {

	public static void loadHomes(Player p){
		if(!ConfigManager.playerdata.contains("players." + p.getName() + ".MaxHomesAllowed")){
			ConfigManager.playerdata.set("players." + p.getName() + ".MaxHomesAllowed", 3);
			ConfigManager.savePlayerData();
			
			StorageManager.homesallowed.put(p, 3);
		}
		else{
			StorageManager.homesallowed.put(p, ConfigManager.playerdata.getInt("players." + p.getName() + ".MaxHomesAllowed"));
		}
		
		if(ConfigManager.playerdata.contains("players." + p.getName() + ".Homes")){
			List<String> homes = new ArrayList<String>();
			List<Location> homelocations = new ArrayList<Location>();
			for(String home : ConfigManager.playerdata.getConfigurationSection("players." + p.getName() + ".Homes").getKeys(false)){
				String[] location = ConfigManager.playerdata.getString("players." + p.getName() + ".Homes." + home).split("\\|");
				World w = Bukkit.getWorld(location[0]);
				Location l = new Location(w, Double.parseDouble(location[1]), Double.parseDouble(location[2]), Double.parseDouble(location[3]), Float.parseFloat(location[4]), Float.parseFloat(location[5]));
				
				homes.add(home);
				homelocations.add(l);
			}
			
			StorageManager.homes.put(p, homes);
			StorageManager.homelocations.put(p, homelocations);
		}
		else{
			StorageManager.homes.put(p, new ArrayList<String>());
			StorageManager.homelocations.put(p, new ArrayList<Location>());
		}
	}
	
	public static void teleportToHome(Player p, String home){
		if(StorageManager.homes.get(p).contains(home)){
			Location l = StorageManager.homelocations.get(p).get(StorageManager.homes.get(p).indexOf(home));
			StorageManager.hometeleporting.put(p, 11);
			StorageManager.hometeleportinglocation.put(p, l);
			StorageManager.hometeleportingto.put(p, home);
			
			p.sendMessage("§7Teleporting to §6" + home + "§7...");
		}
		else{
			p.sendMessage("§7You don't have a §6home§7 named '§6" + home + "§7'.");
		}
	}
	
	public static void removeHome(Player p, String home){
		if(StorageManager.homes.get(p).contains(home)){
			ConfigManager.playerdata.set("players." + p.getName() + ".Homes." + home, null);
			ConfigManager.savePlayerData();
			
			StorageManager.homelocations.get(p).remove(StorageManager.homes.get(p).indexOf(home));
			StorageManager.homes.get(p).remove(home);
			
			p.sendMessage("§7Removed your home! (§6" + home + "§7)");
		}
		else{
			p.sendMessage("§7You don't have a §6home§7 named '§6" + home + "§7'.");
		}
	}
	
	public static void setHome(Player p, String home){
		if(StorageManager.homesallowed.get(p) > StorageManager.homes.get(p).size() || StorageManager.homes.get(p).contains(home)){
			Location l = p.getLocation();
			World w = l.getWorld();
			double x = l.getX();
			double y = l.getY();
			double z = l.getZ();
			float yaw = l.getYaw();
			float pitch = l.getPitch();
			
			String location = w.getName() + "|" + x + "|" + y + "|" + z + "|" + yaw + "|" + pitch;
			ConfigManager.playerdata.set("players." + p.getName() + ".Homes." + home, location);
			ConfigManager.savePlayerData();
			
			List<String> homes = StorageManager.homes.get(p);
			List<Location> homelocations = StorageManager.homelocations.get(p);
			if(!homes.contains(home)){
				homes.add(home);
				homelocations.add(p.getLocation());
				p.sendMessage("§7New home §6set§7! (§6" + home + "§7)");
			}
			else{
				homelocations.set(homes.indexOf(home), p.getLocation());
				p.sendMessage("§7Home §6set§7! (§6" + home + "§7)");
			}
			StorageManager.homes.put(p, homes);
			StorageManager.homelocations.put(p, homelocations);
		}
		else{
			p.sendMessage("§7You already reached the maximum amount of homes! (§6" + StorageManager.homesallowed.get(p) + "§7)");
		}
	}
	
	public static void setHome(Player p, Location l, String home){
		if(StorageManager.homesallowed.get(p) > StorageManager.homes.get(p).size() || StorageManager.homes.get(p).contains(home)){
			World w = l.getWorld();
			double x = l.getX();
			double y = l.getY();
			double z = l.getZ();
			float yaw = l.getYaw();
			float pitch = l.getPitch();
			
			String location = w.getName() + "|" + x + "|" + y + "|" + z + "|" + yaw + "|" + pitch;
			ConfigManager.playerdata.set("players." + p.getName() + ".Homes." + home, location);
			ConfigManager.savePlayerData();
			
			List<String> homes = StorageManager.homes.get(p);
			List<Location> homelocations = StorageManager.homelocations.get(p);
			if(!homes.contains(home)){
				homes.add(home);
				homelocations.add(l);
				p.sendMessage("§7New home §6set§7! (§6" + home + "§7)");
			}
			else{
				homelocations.set(homes.indexOf(home), l);
				p.sendMessage("§7Home §6set§7! (§6" + home + "§7)");
			}
			StorageManager.homes.put(p, homes);
			StorageManager.homelocations.put(p, homelocations);
		}
		else{
			p.sendMessage("§7You already reached the maximum amount of homes! (§6" + StorageManager.homesallowed.get(p) + "§7)");
		}
	}
	
	public static void displayHomes(Player p){
    	String homes = "";
    	for(String home : StorageManager.homes.get(p)){
    		if(homes.equals("")){
    			homes = "§6" + home;
    		}
    		else{
    			homes = homes + "§7, §6" + home;
    		}
    	}
    	
    	if(homes.equals("")){
    		p.sendMessage("§7No §6homes§7 to display. Set one with §6/sethome <name>§7.");
    	}
    	else{
    		p.sendMessage("§7Your Homes: " + homes);
    	}
	}
}
