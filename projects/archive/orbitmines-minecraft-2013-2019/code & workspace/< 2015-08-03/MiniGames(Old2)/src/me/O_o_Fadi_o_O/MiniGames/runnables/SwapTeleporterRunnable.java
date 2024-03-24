package me.O_o_Fadi_o_O.MiniGames.runnables;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SwapTeleporterRunnable {
	
	Start plugin;
	 
	public SwapTeleporterRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startSwapTeleporterRunnable(){
		new BukkitRunnable(){
			public void run(){
				for(World w : Bukkit.getWorlds()){
					for(Entity en : w.getEntities()){
						if(en instanceof Item){
							if(StorageManager.SwapTeleporter.containsKey(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("largesmoke", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 10));
								}
								Player player = StorageManager.SwapTeleporter.get(en);
								for(Entity e : en.getNearbyEntities(0.5, 1, 0.5)){
									if(e instanceof Player){
										if(player != e){
											Player player2 = (Player) e;
											Location l1 = player.getLocation();
											Location l2 = player2.getLocation();
											
											player.teleport(l2);
											player2.teleport(l1);
											
											player.sendMessage("§fYou've §2§lswapped§f positions with " + PlayerManager.playerDisplayName(player2) + "§f!");
											player2.sendMessage(PlayerManager.playerDisplayName(player) + " §2§lswapped§f positions with you!");
											
											player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											player2.playSound(player2.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
											
											StorageManager.SwapTeleporter.remove(en);
											en.remove();
										}
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this.plugin, 0, 2);
	}
}
