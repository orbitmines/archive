package me.O_o_Fadi_o_O.Prison.runnables;

import java.util.UUID;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.events.ClickEventENG;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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
					
					Start.showTeleportNPCs(p);
					Start.showRankupNPCs(p);
					
					if(StorageManager.ownerpets.containsKey(p)){
						UUID uuid = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = StorageManager.owners.get(uuid).getLocation();
											
											if(ClickEventENG.getDistance(l, ent.getLocation()) < 20){
												ClickEventENG.navigate(ent, l, 1.2);
											}
											else{
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
