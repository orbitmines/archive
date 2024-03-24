package me.O_o_Fadi_o_O.KitPvP.runnables;

import java.util.UUID;

import me.O_o_Fadi_o_O.KitPvP.SpectatorKit;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityRunnable {

	Start plugin;
	 
	public EntityRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startEntityRunnable(){
		new BukkitRunnable(){
	
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(StorageManager.Spectators.contains(p)){
						p.setGameMode(GameMode.CREATIVE);
						SpectatorKit.giveInventory(p);
						
						if(p.getOpenInventory().getTopInventory() != null && p.getOpenInventory().getTopInventory().getName() != null && p.getOpenInventory().getTopInventory().getName().equals("                §c§lKitPvP")){
							p.closeInventory();
						}
					}
					else{
						if(!PlayerManager.isInOPMode(p)){
							p.setGameMode(GameMode.SURVIVAL);
						}
					}
					
					try{
						if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Fly I")){
							if(p.getAllowFlight() == true){
								Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() -1, p.getLocation().getBlockZ()));
								if(b.getType() == Material.AIR || b.isEmpty()){
									for(Player player : Bukkit.getOnlinePlayers()){
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
						                        "largesmoke", 
						                        (float) p.getLocation().getX(),
						                        (float) p.getLocation().getY() - 1, 
						                        (float) p.getLocation().getZ(), 
						                        1, 0, 1,(float) 0, 3));
									}
								}
							}
						}
					}catch(Exception ex){}
					
					if(StorageManager.ownerpets.containsKey(p)){
						UUID uuid = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = StorageManager.owners.get(uuid).getLocation();
											
											try{
												if(ClickEvent.getDistance(l, ent.getLocation()) < 20){
													ClickEvent.navigate(ent, l, 1.2);
												}
												else{
													ent.teleport(l);
												}
											}catch(Exception ex){
												ent.teleport(l);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this.plugin, 20, 3);
	}
}
