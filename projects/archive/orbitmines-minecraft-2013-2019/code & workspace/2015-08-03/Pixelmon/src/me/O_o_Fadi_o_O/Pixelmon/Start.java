package me.O_o_Fadi_o_O.Pixelmon;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	public Map<String, String> playerData = new HashMap<String, String>();
	
	public int Hours = 24;
	
	public String TAG = "§8[§4§lPixel§f§lmon§8] ";
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		Hours = getConfig().getInt("Hours");
		Time();
	}
	
	public void addDays(Player p, int i){
		getConfig().set("players." + p.getName() + ".Days", getConfig().getInt("players." + p.getName() + ".Days", 0) + i);
		saveConfig();
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] a) {
		
				if(cmd.getName().equalsIgnoreCase("givedays")){
					if(sender.hasPermission("GiveDays.Pixelmon")){
			
					if(a.length != 2){
						sender.sendMessage("§7Type §b/givedays <player> <amount>");
					}
					else{
						try{
							
							int amount = Integer.parseInt(a[1]);
							getConfig().set("players." + a[0] + ".Days", getConfig().getInt("players." + a[0] + ".Days") + amount);
							saveConfig();
							
							sender.sendMessage("§7You gave §b" + a[0] + "§6 " + a[1] + " §7more Days!");
						}
						catch(Exception ex){
							sender.sendMessage("§cInvalid Amount!: " + a[1]);
						}
					}		
			}
		}
				if(cmd.getName().equalsIgnoreCase("givelifetime")){
					if(sender.hasPermission("GiveLiftime.Pixelmon")){
					if(a.length != 1){
						sender.sendMessage("§7Type §b/givelifetime <player>");
					}
					else{
						getConfig().set("players." + a[0] + ".Lifetime", true);
						saveConfig();
						sender.sendMessage("§7You gave §b" + a[0] + " §6Lifetime§7!");
					}
					}
				}
				if(cmd.getName().equalsIgnoreCase("days")){
					if(sender instanceof Player){
						Player p = (Player)sender;
						if(getConfig().getBoolean("players." + p.getName() + ".Lifetime") == true){
							p.sendMessage(TAG + "§a§lLIFETIME! :D");
						}
						else{
							p.sendMessage(TAG + "§6You have §f§l" + getConfig().getInt("players." + p.getName() + ".Days") + " §6Days left!");
						}
					}
				}
		return false;
	}
	
	
	public void Time(){
		Hours = Hours+1;
		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new Runnable() {
					public void run() {
						
						getConfig().set("Hours", getConfig().getInt("Hours") - 1);
						saveConfig();
						Hours--;
						
						if(Hours == 0){
							getConfig().set("Hours", 24);
							saveConfig();
							Hours = 24;
							
							for(String p : getConfig().getStringList("AllPlayers")){
								getConfig().set("players." + p + ".Days", getConfig().getInt("players." + p + ".Days") - 1);
								if(getConfig().getInt("players." + p + ".Days") <= 0){
									getConfig().set("players." + p + ".Days", 0);
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										if(getConfig().getBoolean("players." + player.getName() + ".Lifetime") == true){
											
										}
										else{
										if(getConfig().getInt("players." + player.getName() + ".Days") <= 0){
											player.kickPlayer("§6Access Expired!");
										}
									}
								}
							}
							
						}
					}
		}, 0L, 72000L);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		String playerIP = p.getAddress().getAddress().toString();
    	playerIP = playerIP.replaceAll("/", "");
	    playerIP = playerIP.replaceAll("\\.", "-");
	    if (!(playerData.containsKey(playerIP))) {
	        playerData.put(playerIP, p.getName());
	    }
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(!getConfig().contains("players." + p.getName() + ".Days")){
			getConfig().set("players." + p.getName() + ".Days", 30);
			saveConfig();
			
		}
		if(!getConfig().contains("players." + p.getName() + ".Lifetime")){
			getConfig().set("players." + p.getName() + ".Lifetime", false);
			saveConfig();
		}
		if(!getConfig().getStringList("AllPlayers").contains(p.getName())){
			List<String> players = getConfig().getStringList("AllPlayers");
			players.add(p.getName());
			getConfig().set("AllPlayers", players);
			saveConfig();
		}
		
		if(getConfig().getBoolean("players." + p.getName() + ".Lifetime") == true){
			
		}
		else{
		if((getConfig().getInt("players." + p.getName() + ".Days")) <= 0){
			e.setKickMessage("§aBuy access at §6http://shop.orbitmines.com");
			e.setResult(Result.KICK_OTHER);
		} 
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPing(ServerListPingEvent e){
		
		String playerIP = e.getAddress().toString();
	    playerIP = playerIP.replaceAll("/", "");
	    playerIP = playerIP.replaceAll("\\.", "-");
	    
	    if (playerData.containsKey(playerIP)) {
	    	if(getConfig().getBoolean("players." + playerData.get(playerIP) + ".Lifetime") == true){
	    		e.setMotd("                §8[§6§lOrbitMines §4§lPixel§f§lmon§7§8]                                       §6§k! §a§lYay! Lifetime Yay! §6§k!");
	    	}
	    	else{
	    	if((getConfig().getInt("players." + playerData.get(playerIP) + ".Days") == 1)){
	    		e.setMotd("                §8[§6§lOrbitMines §4§lPixel§f§lmon§7§8]                                              §f§l" + getConfig().getInt("players." + playerData.get(playerIP) + ".Days") + " §6Day Left");
	    	}
	    	else{
	    		e.setMotd("                §8[§6§lOrbitMines §4§lPixel§f§lmon§7§8]                                             §f§l" + getConfig().getInt("players." + playerData.get(playerIP) + ".Days") + " §6Days Left");
	    	}
	    	}
	        
	    } else {
	        e.setMotd("                §8[§6§lOrbitMines §4§lPixel§f§lmon§7§8]                                    §a§lPixelmon.OrbitMines.com");
	    }
	}
}
