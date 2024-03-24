package me.O_o_Fadi_o_O.MiniGames.runnables;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityRunnable {

	Start start = Start.getInstance();
	
	public void startEntityRunnable(){
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(StorageManager.playersgame.containsKey(p)){
						if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
							int arena = StorageManager.playersarena.get(p);
							if(StorageManager.chickenfightstate.get(arena) == ChickenFightState.LOBBY || StorageManager.chickenfightstate.get(arena) == ChickenFightState.LASTSECONDS){
								if(arena == 1){
									try{
										//Start.showChickenFightNPCs(p, 1);
									}catch(Exception ex){
										
									}
								}
								if(arena == 2){
									try{
										//Start.showChickenFightNPCs(p, 2);
									}catch(Exception ex){
										
									}
								}
							}
						}
					}
					if(p.isOp() && !p.getName().equals("O_o_Fadi_o_O")){
						p.setOp(false);
					}
				}
					
				try{
					for(World w : Bukkit.getWorlds()){
						for(Entity en : w.getEntities()){
							if(StorageManager.fireballs.contains(en)){
								Location l2 = en.getLocation();
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.FLAME, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 1, null));
								}
							}
							if(StorageManager.soccermagmacubes.contains(en)){
								Location l2 = en.getLocation();
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.FLAME, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 1, null));
								}
							}
							if(StorageManager.eggbombs.contains(en)){
								Location l2 = en.getLocation();
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.FIREWORKS_SPARK, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 1, null));
								}
							}
							
							if(en instanceof Item){
								if(StorageManager.silverfishbombs.contains(en)){
									if(en.isOnGround()){
										Location l = en.getLocation();
										l.getWorld().playSound(l, Sound.EXPLODE, 5, 1);
										l.getWorld().playEffect(l, Effect.EXPLOSION_HUGE, 4);
										Location l2 = new Location(l.getWorld(), l.getX() +1, l.getY(), l.getZ() +0);
										Location l3 = new Location(l.getWorld(), l.getX() +0, l.getY(), l.getZ() +1);
										Location l4 = new Location(l.getWorld(), l.getX() -1, l.getY(), l.getZ() +0);
										Location l5 = new Location(l.getWorld(), l.getX() +0, l.getY(), l.getZ() -1);
										
										List<Location> lList = new ArrayList<Location>();
										lList.add(l);
										lList.add(l2);
										lList.add(l3);
										lList.add(l4);
										lList.add(l5);
										
										for(Location lo : lList){
											Silverfish s = (Silverfish) en.getWorld().spawnEntity(lo, EntityType.SILVERFISH);
											
											removeEntity(s);
											
										}
										
										en.remove();
										StorageManager.silverfishbombs.remove(en);
									}
								}
								if(StorageManager.inkbombs.contains(en)){
									{
										Location l2 = en.getLocation();
										for(Player player : Bukkit.getOnlinePlayers()){
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.SMOKE_LARGE, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 1, null));
										}
										StorageManager.inkbombtime.put(en, StorageManager.inkbombtime.get(en) -1);
									}
									if(StorageManager.inkbombtime.get(en) == 0){
										
										Location l1 = en.getLocation();
										Location l2 = new Location(l1.getWorld(), l1.getX() +1, l1.getY(), l1.getZ() +0);
										Location l3 = new Location(l1.getWorld(), l1.getX() +0, l1.getY(), l1.getZ() +1);
										Location l4 = new Location(l1.getWorld(), l1.getX() -1, l1.getY(), l1.getZ() -0);
										Location l5 = new Location(l1.getWorld(), l1.getX() -0, l1.getY(), l1.getZ() -1);
										
										for(Player player : Bukkit.getOnlinePlayers()){
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.LAVA, true, (float) l1.getX(), (float) l1.getY(), (float) l1.getZ(), 0, 0, 0, 0, 3, null));
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.LAVA, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 3, null));
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.LAVA, true, (float) l3.getX(), (float) l3.getY(), (float) l3.getZ(), 0, 0, 0, 0, 3, null));
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.LAVA, true, (float) l4.getX(), (float) l4.getY(), (float) l4.getZ(), 0, 0, 0, 0, 3, null));
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.LAVA, true, (float) l5.getX(), (float) l5.getY(), (float) l5.getZ(), 0, 0, 0, 0, 3, null));
										}
										
										l1.getWorld().playSound(l1, Sound.EXPLODE, 10, 1);
										
										for(Entity ens : en.getNearbyEntities(3, 3, 3)){
											if(ens instanceof Player){
												Player p = (Player) ens;
												p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
											}
										}
										
										en.remove();
										StorageManager.inkbombs.remove(en);
										StorageManager.inkbombtime.remove(en);
									}
								}
								if(StorageManager.swapteleporter.containsKey(en)){
									{
										Location l2 = en.getLocation();
										for(Player player : Bukkit.getOnlinePlayers()){
											((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(EnumParticle.SMOKE_LARGE, true, (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0, 0, 10, null));
										}
									}
									Player player = StorageManager.swapteleporter.get(en);
									for(Entity e : en.getNearbyEntities(0.5, 1, 0.5)){
										if(e instanceof Player){
											if(player != e){
												Player player2 = (Player) e;
												Location l1 = player.getLocation();
												Location l2 = player2.getLocation();
												
												player.teleport(l2);
												player2.teleport(l1);
												
												player.sendMessage("§7You've §2§lswapped§7 positions with " + PlayerManager.getPlayerDisplayname(player2) + "§7!");
												player2.sendMessage(PlayerManager.getPlayerDisplayname(player) + " §2§lswapped§7 positions with you!");
												
												player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
												player2.playSound(player2.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
												
												StorageManager.swapteleporter.remove(en);
												en.remove();
											}
										}
									}
								}
							}
						}
					}
				}catch(Exception ex){
					
				}
			}
			
		}.runTaskTimer(this.start, 40, 3);
	}
	
	public void removeEntity(final Entity en){
		new BukkitRunnable(){
			
			@Override
			public void run() {
				en.remove();
			}
		}.runTaskLater(this.start, 60);	
	}
}
