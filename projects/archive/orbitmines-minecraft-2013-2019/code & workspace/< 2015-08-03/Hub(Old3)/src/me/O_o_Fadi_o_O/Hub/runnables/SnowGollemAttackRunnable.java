package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.scheduler.BukkitRunnable;

public class SnowGollemAttackRunnable {

	Hub hub = Hub.getInstance();
	
	public void startPetSnowGollemAttackRunnable(){
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.snowgolemattackseconds.containsKey(p)){
						int seconds = StorageManager.snowgolemattackseconds.get(p);
						Location l = StorageManager.snowgolemattackitem.get(p).getLocation();
						
						StorageManager.snowgolemattackseconds.put(p, seconds +1);
						
						if(seconds <= 10){
							l.getWorld().playSound(l, Sound.WITHER_SPAWN, 5, 1);
							try{
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
									EnumParticle.FLAME, true, (float) l.getX(), (float) l.getY(), (float) l.getZ(), 1, 1, 1, 0, 30, null));
								}
							}catch(Exception ex){}
						}
						if(seconds == 11){
							l.getWorld().playSound(l, Sound.WITHER_DEATH, 5, 1);
							Snowman s1 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
							Snowman s2 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
							Snowman s3 = (Snowman) l.getWorld().spawnEntity(l, EntityType.SNOWMAN);
							
							s1.setPassenger(s2);
							s2.setPassenger(s3);
							StorageManager.snowgolemattackitem.get(p).remove();
							
							List<Entity> snowgolems = new ArrayList<Entity>();
							snowgolems.add(s1);
							snowgolems.add(s2);
							snowgolems.add(s3);
							StorageManager.snowgolemattacksnowgolems.put(p, snowgolems);
						}
					}
				}
			}
		}.runTaskTimer(this.hub, 0, 20);
		
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.snowgolemattackseconds.containsKey(p)){
						int seconds = StorageManager.snowgolemattackseconds.get(p);
						
						List<Entity> snowgolems = StorageManager.snowgolemattacksnowgolems.get(p);
						
						List<Player> players = new ArrayList<Player>();
						for(Player player : Bukkit.getOnlinePlayers()){
							players.add(player);
						}
						
						if(seconds >= 12){
							Entity en = snowgolems.get(2);
							Player player = players.get(new Random().nextInt(players.size()));
							
							Location l1 = en.getLocation();
							Location l2 = player.getLocation();
							 
							Snowball s = ((Snowman) en).launchProjectile(Snowball.class, l2.toVector().subtract(l1.toVector()).multiply(0.15));
							en.getWorld().playSound(l1, Sound.DIG_SNOW, 2, 1);
							StorageManager.snowgolemattackballs.add(s);
						}
						
						if(seconds == 50){
							Location l = snowgolems.get(1).getLocation();
							l.getWorld().playSound(l, Sound.WITHER_DEATH, 5, 1);
							
							try{
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
									EnumParticle.FLAME, true, (float) l.getX(), (float) l.getY(), (float) l.getZ(), 2, 2, 2, 0, 30, null));
								}
							}catch(Exception ex){}
							
							for(Entity en : snowgolems){
								en.remove();
							}
							
							StorageManager.snowgolemattackseconds.remove(p);
							StorageManager.snowgolemattackitem.remove(p);
							StorageManager.snowgolemattacksnowgolems.remove(p);
						}
					}
				}
			}
		}.runTaskTimer(this.hub, 0, 5);
		
	}
}
