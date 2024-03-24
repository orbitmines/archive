package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParkourRunnable {
	
	Hub hub = Hub.getInstance();
	
	private Map<String, Long> lastcompleted = new HashMap<String, Long>();
	private final int lastcompletedcooldown = 1;
	
	public void startParkourRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersinlapisparkour.contains(p)){
						try{
							if(p.getLocation().distance(StorageManager.lapisparkourlocation) > 2){
								Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -1, p.getLocation().getZ());

								 Material m = p.getWorld().getBlockAt(l).getType();
								
								if(m != Material.GLOWSTONE){
									if(!p.isSprinting()){
										p.teleport(StorageManager.lapisparkourlocation);
										p.sendMessage("§1§lLapis Parkour §8| §7You can't stop sprinting!");
									}
									else if(p.isOnGround()){
										 if(m == Material.GLOWSTONE){
											 
											long lastcomplete = 0;
											if(lastcompleted.containsKey(p.getName())){
												lastcomplete = lastcompleted.get(p.getName());
											}
											int cdmillis = lastcompletedcooldown * 1000;
													
											if(System.currentTimeMillis()-lastcomplete>=cdmillis){
												if(StorageManager.completedlapisparkour.get(p) == false){
													 StorageManager.completedlapisparkour.put(p, true);
													 
													 p.sendMessage("§1§lLapis Parkour §8| §7You received §b§l250 VIP Points§7!");
													 
													 p.teleport(StorageManager.lapisparkourlocation);
													 StorageManager.playersinlapisparkour.remove(p);
													 
													 DatabaseManager.insertUUID(Hub.getUUIDfromPlayer(p).toString(), "ParkourCompleted");
													 DatabaseManager.addVIPPoints(p, 250);
												 }
												 
												 Bukkit.broadcastMessage("§1§lLapis Parkour §8| §6" + p.getName() + "§7 completed the §1Lapis Parkour§7!");
												 for(Player player : Bukkit.getOnlinePlayers()){
													 player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
												 }
												 
												 lastcompleted.put(p.getName(), System.currentTimeMillis());
											 }
										 }
										 else{
											 if(m != Material.LAPIS_BLOCK && m != Material.AIR){
												 p.teleport(StorageManager.lapisparkourlocation);
											 }
										 }
									}
									else if(p.getLocation().getY() <= 74){
										p.teleport(StorageManager.lapisparkourlocation);
									}
									else{}
								}
								else{
									long lastcomplete = 0;
									if(lastcompleted.containsKey(p.getName())){
										lastcomplete = lastcompleted.get(p.getName());
									}
									int cdmillis = lastcompletedcooldown * 1000;
											
									if(System.currentTimeMillis()-lastcomplete>=cdmillis){
										if(StorageManager.completedlapisparkour.get(p) == false){
											 StorageManager.completedlapisparkour.put(p, true);
											 
											 p.sendMessage("§1§lLapis Parkour §8| §7You received §b§l250 VIP Points§7!");
											 
											 p.teleport(StorageManager.lapisparkourlocation);
											 StorageManager.playersinlapisparkour.remove(p);
											 
											 DatabaseManager.insertUUID(Hub.getUUIDfromPlayer(p).toString(), "ParkourCompleted");
											 DatabaseManager.addVIPPoints(p, 250);
										 }
										 
										 Bukkit.broadcastMessage("§1§lLapis Parkour §8| " + PlayerManager.getPlayerDisplayname(p) + "§7 completed the §1Lapis Parkour§7!");
										 for(Player player : Bukkit.getOnlinePlayers()){
											 player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
										 }
										 
										 lastcompleted.put(p.getName(), System.currentTimeMillis());
									 }
								}
							}
						}catch(Exception ex){p.teleport(StorageManager.lapisparkourlocation);}
						if(p.getAllowFlight() == true){
							p.setAllowFlight(false);
							p.setFlying(false);
							p.sendMessage("§1§lLapis Parkour §8| §f§l§oFly §c§lDISABLED");
						}
					}
				}

			}
		}.runTaskTimer(this.hub, 0, 10);
	}
}

