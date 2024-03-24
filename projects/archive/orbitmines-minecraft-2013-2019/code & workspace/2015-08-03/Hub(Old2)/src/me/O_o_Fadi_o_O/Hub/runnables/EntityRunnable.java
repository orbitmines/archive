package me.O_o_Fadi_o_O.Hub.runnables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Item;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class EntityRunnable {

	Hub plugin;
	 
	public EntityRunnable(Hub instance) {
		plugin = instance;
	}
	
	public void startEntityRunnable(){
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void run(){
				
				try{
			        FallingBlock block1 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -419, 14, 1054), Material.WATER, (byte) 0);
		            float x1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z1 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            block1.setDropItem(false);
		            
			        FallingBlock block2 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -375, 14, 1054), Material.WATER, (byte) 0);
		            float x2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z2 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            block2.setDropItem(false);
		            
			        FallingBlock block3 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -376, 14, 1011), Material.WATER, (byte) 0);
		            float x3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z3 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            block3.setDropItem(false);
		            
			        FallingBlock block4 = Bukkit.getWorld("Hub").spawnFallingBlock(new Location(Bukkit.getWorld("Hub"), -419, 14, 1011), Material.WATER, (byte) 0);
		            float x4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float y4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            float z4 = (float) -0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3));
		            block4.setDropItem(false);
		            
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block1.getLocation().getX(), (float) block1.getLocation().getY(), (float) block1.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block2.getLocation().getX(), (float) block2.getLocation().getY(), (float) block2.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block3.getLocation().getX(), (float) block3.getLocation().getY(), (float) block3.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("splash", (float) block4.getLocation().getX(), (float) block4.getLocation().getY(), (float) block4.getLocation().getZ(), 1, 1, 1,(float) 0, 28));
					}
		            
		            Random i = new Random();
		            int iInt;
		            
		            for(int iCount = 1; iCount <= 1; iCount++){
		            	iInt = 1 + i.nextInt(4);
		            	
		            	if(iInt == 1){
		            		block1.setVelocity(new Vector(x1 -0.2, y1, z1 -0.2));
		            		block2.setVelocity(new Vector(x2 -0.2, y2, z2 -0.2));
		            		block3.setVelocity(new Vector(x3 -0.2, y3, z3 -0.2));
		            		block4.setVelocity(new Vector(x4 -0.2, y4, z4 -0.2));
		            	}
		            	else if(iInt == 2){
		            		block1.setVelocity(new Vector(x1, y1, z1));
		            		block2.setVelocity(new Vector(x2, y2, z2));
		            		block3.setVelocity(new Vector(x3, y3, z3));
		            		block4.setVelocity(new Vector(x4, y4, z4));
		            	}
		            	else if(iInt == 3){
		            		block1.setVelocity(new Vector(x1 -0.2, y1, z1));
		            		block2.setVelocity(new Vector(x2 -0.2, y2, z2));
		            		block3.setVelocity(new Vector(x3 -0.2, y3, z3));
		            		block4.setVelocity(new Vector(x4 -0.2, y4, z4));
		            	}
		              	else if(iInt == 4){
		            		block1.setVelocity(new Vector(x1, y1, z1 -0.2));
		            		block2.setVelocity(new Vector(x2, y2, z2 -0.2));
		            		block3.setVelocity(new Vector(x3, y3, z3 -0.2));
		            		block4.setVelocity(new Vector(x4, y4, z4 -0.2));
		            	}
		            }
					
					for(Entity en : Bukkit.getWorld("Hub").getEntities()){
						if(en instanceof Fireball){
							Fireball b = (Fireball) en;
							if(StorageManager.Fireballs.contains(b)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("flame", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 1));
								}
							}
						}
						if(en instanceof MagmaCube){
							if(StorageManager.SoccerMagmaCubes.contains(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
			                                "flame", 
			                                (float) en.getLocation().getX(),
			                                (float) en.getLocation().getY(), 
			                                (float) en.getLocation().getZ(), 
			                                0, 0, 0,(float) 0, 1));
								}
							}
						}
						if(en instanceof Egg){
							if(StorageManager.EggBombs.contains(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("fireworksSpark", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 1));
								}
							}
						}
						if(en instanceof Item){
							if(StorageManager.SilverfishBombs.contains(en)){
								if(en.isOnGround()){
									Location l = en.getLocation();
									l.getWorld().createExplosion(l, 4F);
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
									StorageManager.SilverfishBombs.remove(en);
								}
							}
							if(StorageManager.InkBombs.contains(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("largesmoke", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 1));
								}
								StorageManager.InkBombTime.put(en, StorageManager.InkBombTime.get(en) -1);
								
								if(StorageManager.InkBombTime.get(en) == 0){
									
									Location l1 = en.getLocation();
									Location l2 = new Location(l1.getWorld(), l1.getX() +1, l1.getY(), l1.getZ() +0);
									Location l3 = new Location(l1.getWorld(), l1.getX() +0, l1.getY(), l1.getZ() +1);
									Location l4 = new Location(l1.getWorld(), l1.getX() -1, l1.getY(), l1.getZ() -0);
									Location l5 = new Location(l1.getWorld(), l1.getX() -0, l1.getY(), l1.getZ() -1);
									
									for(Player player : Bukkit.getOnlinePlayers()){
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("lava", (float) l1.getX(), (float) l1.getY(), (float) l1.getZ(), 0, 0, 0,(float) 0, 3));
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("lava", (float) l2.getX(), (float) l2.getY(), (float) l2.getZ(), 0, 0, 0,(float) 0, 3));
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("lava", (float) l3.getX(), (float) l3.getY(), (float) l3.getZ(), 0, 0, 0,(float) 0, 3));
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("lava", (float) l4.getX(), (float) l4.getY(), (float) l4.getZ(), 0, 0, 0,(float) 0, 3));
										((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("lava", (float) l5.getX(), (float) l5.getY(), (float) l5.getZ(), 0, 0, 0,(float) 0, 3));
									}
									
									l1.getWorld().playSound(l1, Sound.EXPLODE, 10, 1);
									
									for(Entity ens : en.getNearbyEntities(3, 3, 3)){
										if(ens instanceof Player){
											Player p = (Player) ens;
											p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
										}
									}
									
									en.remove();
									StorageManager.InkBombs.remove(en);
									StorageManager.InkBombTime.remove(en);
								}
							}
							if(StorageManager.SwapTeleporter.containsKey(en)){
								for(Player player : Bukkit.getOnlinePlayers()){
									((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles("largesmoke", (float) en.getLocation().getX(), (float) en.getLocation().getY(), (float) en.getLocation().getZ(), 0, 0, 0,(float) 0, 10));
								}
								Player player = StorageManager.SwapTeleporter.get(en);
								for(Entity e : en.getNearbyEntities(0.5, 1, 0.5)){
									if(e instanceof Player){
										if(player != e){
											Player player2 = (Player) e;
											if(!StorageManager.PlayersInParkour.contains(player2) && !StorageManager.PlayersInParkour.contains(player)){
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
				}catch(Exception ex){
					
				}
			}
			
		}.runTaskTimer(this.plugin, 40, 2);
		
	}
	
	public void removeEntity(final Entity en){
		new BukkitRunnable(){
			
			@Override
			public void run() {
				en.remove();
			}
		}.runTaskLater(this.plugin, 60);	
	}
}
