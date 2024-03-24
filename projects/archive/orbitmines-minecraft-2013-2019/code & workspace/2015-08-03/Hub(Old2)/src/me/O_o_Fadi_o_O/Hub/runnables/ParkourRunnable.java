package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParkourRunnable {
	
	Hub plugin;
	 
	public ParkourRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startParkourRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersInParkour.contains(p)){
						try{
							if(p.getLocation().distance(StorageManager.ParkourLocation) > 1.5){
								Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -1, p.getLocation().getZ());

								 Material m = p.getWorld().getBlockAt(l).getType();
								
								if(m != Material.GLOWSTONE){
									if(!p.isSprinting()){
										p.teleport(StorageManager.ParkourLocation);
										p.sendMessage("§6Parkour §8| §7You can't stop sprinting!");
									}
									else if(p.isOnGround()){
										 if(m == Material.GLOWSTONE){
											 
											 if(StorageManager.PlayerCompletedParkour.get(p) == false){
												 StorageManager.PlayerCompletedParkour.put(p, true);
												 DatabaseManager.insertPlayerName(p.getName(), "ParkourCompleted");
												 DatabaseManager.addVIPPoints(p, 250);
												 
												 p.sendMessage("§6Parkour §8| §7You received §b§l250 VIP Points§7!");
												 
												 p.teleport(StorageManager.ParkourLocation);
												 StorageManager.PlayersInParkour.remove(p);
											 }
											 
											 Bukkit.broadcastMessage("§6Parkour §8| §6" + p.getName() + "§7 completed the §6Parkour§7!");
											 for(Player player : Bukkit.getOnlinePlayers()){
												 player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
											 }
										 }
										 else{
											 if(m != Material.LAPIS_BLOCK && m != Material.AIR){
												 p.teleport(StorageManager.ParkourLocation);
											 }
										 }
									}
									else{}
								}
								else{
									if(StorageManager.PlayerCompletedParkour.get(p) == false){
									 	StorageManager.PlayerCompletedParkour.put(p, true);
										DatabaseManager.insertPlayerName(p.getName(), "ParkourCompleted");
										DatabaseManager.addVIPPoints(p, 250);
									 
									 	p.sendMessage("§6Parkour §8| §7You received §b§l250 VIP Points§7!");
									 
									 	p.teleport(StorageManager.ParkourLocation);
									 	StorageManager.PlayersInParkour.remove(p);
								 	}
								 
								 	Bukkit.broadcastMessage("§6Parkour §8| §6" + p.getName() + "§7 completed the §6Parkour§7!");
								 	for(Player player : Bukkit.getOnlinePlayers()){
								 		player.playSound(player.getLocation(), Sound.LEVEL_UP, 5, 1);
								 	}
								}
							}
						}catch(Exception ex){p.teleport(StorageManager.ParkourLocation);}
						if(p.getAllowFlight() == true){
							p.setAllowFlight(false);
							p.setFlying(false);
							p.sendMessage("§6Parkour §8| §7You aren't allowed to fly!");
						}
					}
				}

			}
		}.runTaskTimer(this.plugin, 0, 10);
	}
}

