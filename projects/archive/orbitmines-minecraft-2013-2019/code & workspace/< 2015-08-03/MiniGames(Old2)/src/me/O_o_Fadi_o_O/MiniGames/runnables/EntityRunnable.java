package me.O_o_Fadi_o_O.MiniGames.runnables;

import java.util.UUID;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.events.ClickEventENG;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

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
					
					if(StorageManager.PlayersGame.containsKey(p)){
						if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
							int arena = StorageManager.PlayersArena.get(p);
							if(StorageManager.ChickenFightState.get(arena) == ChickenFightState.LOBBY || StorageManager.ChickenFightState.get(arena) == ChickenFightState.LASTSECONDS){
								if(arena == 1){
									try{
										Start.showChickenFightNPCs(p, 1);
									}catch(Exception ex){
										
									}
								}
								if(arena == 2){
									try{
										Start.showChickenFightNPCs(p, 2);
									}catch(Exception ex){
										
									}
								}
							}
						}
					}
					
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
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
