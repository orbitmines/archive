package me.O_o_Fadi_o_O.MiniGames.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.inv.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.inv.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.inv.StatsInv;
import me.O_o_Fadi_o_O.MiniGames.inv.VIPInv;
import me.O_o_Fadi_o_O.MiniGames.utils.State;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class InteractEvent implements Listener{
	
	Start plugin;
	 
	public InteractEvent(Start instance) {
		plugin = instance;
	}
	
	ServerSelector sinv = new ServerSelector();
	 
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 6;
	
	private Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	private final int cdtime2 = 7;
	
	private Map<String, Long> lastUsage3 = new HashMap<String, Long>();
	private final int cdtime3 = 10;
	
	private Map<String, Long> lastUsage4 = new HashMap<String, Long>();
	private final int cdtime4 = 8;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		
		Action a = e.getAction();
		ItemStack i = e.getItem();
		try{
			if(i != null){
				if(i.getType() == Material.SADDLE && i.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.LEASH){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.ENDER_PEARL){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.EXP_BOTTLE){
					e.setCancelled(true);
					p.updateInventory();
				}
				if(i.getType() == Material.SKULL_ITEM && i.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					long lastUsed = 0;
					if(lastUsage.containsKey(p.getName())){
						lastUsed = lastUsage.get(p.getName());
					}
					int cdmillis = cdtime * 1000;
							
					if(System.currentTimeMillis()-lastUsed>=cdmillis){
						
						Creeper creeper = (Creeper) p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
						creeper.setPowered(true);
						
						Vector vector = p.getLocation().getDirection().normalize().multiply(1.5);
						
						creeper.setVelocity(vector);
						
						lastUsage.put(p.getName(), System.currentTimeMillis());
					}
				}
				if(i.getType() == Material.SNOW_BALL && i.getItemMeta().getDisplayName().equals("§f§nPaintballs")){
					e.setCancelled(true);
					p.updateInventory();
					
					if(Start.state == State.LOBBY){
						Snowball ball = p.launchProjectile(Snowball.class);
						Start.Paintballs.add(ball);
					}
				}
				if(i.getType() == Material.BOOK && i.getItemMeta().getDisplayName().equals("§7§nBook Explosion")){
					e.setCancelled(true);
					p.updateInventory();
					
					if(Start.state == State.LOBBY){
						long lastUsed2 = 0;
						if(lastUsage2.containsKey(p.getName())){
							lastUsed2 = lastUsage2.get(p.getName());
						}
						int cdmillis2 = cdtime2 * 1000;
								
						if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
							p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 5, 1);
							for(int i1 = 1; i1 <= 12; i1++){
								int upper1 = 5;
								Random random1 = new Random();
								random1.nextInt((upper1));
								int upper2 = 4;
								Random random2 = new Random();
								random2.nextInt((upper2));
								int upper3 = 6;
								Random random3 = new Random();
								random3.nextInt((upper3));
								
								ItemStack item = new ItemStack(Material.PAPER);
								ItemMeta meta = item.getItemMeta();
								meta.setDisplayName("Paper " + i1);
								item.setItemMeta(meta);
								
								final Item paper = p.getWorld().dropItem(p.getLocation(), item);
					            	
				            	if(i1 == 1 || i1 == 2 || i1 == 3){
						            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
						            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
						            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
				            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
				            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
				            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
				            		paper.setVelocity(new Vector(x -0.2, y, z -0.2));
				            	}
				            	else if(i1 == 4 || i1 == 5 || i1 == 6){
						            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
						            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
						            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
				            		paper.setVelocity(new Vector(x, y, z));
				            		paper.setVelocity(new Vector(x, y, z));
				            		paper.setVelocity(new Vector(x, y, z));
				            		paper.setVelocity(new Vector(x, y, z));
				            	}
				            	else if(i1 == 7 || i1 == 8 || i1 == 9){
						            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
						            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
						            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
				            		paper.setVelocity(new Vector(x -0.2, y, z));
				            		paper.setVelocity(new Vector(x -0.2, y, z));
				            		paper.setVelocity(new Vector(x -0.2, y, z));
				            		paper.setVelocity(new Vector(x -0.2, y, z));
				            	}
				              	else if(i1 == 10 || i1 == 11 || i1 == 12){
						            float x = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3)));
						            float y = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * 3;
						            float z = (float) (-0.03 + (float) (Math.random() * ((0.03 - -0.03) + 0.3))) * -3;
				            		paper.setVelocity(new Vector(x, y, z -0.2));
				            		paper.setVelocity(new Vector(x, y, z -0.2));
				            		paper.setVelocity(new Vector(x, y, z -0.2));
				            		paper.setVelocity(new Vector(x, y, z -0.2));
				            	}
								
								new BukkitRunnable(){
								  @Override
								  public void run(){
								    paper.remove();
								  }
								}.runTaskLater(this.plugin, 20 * 10L);
								
								lastUsage2.put(p.getName(), System.currentTimeMillis());
							}
						}
					}
				}
				if(i.getType() == Material.FIREBALL && i.getItemMeta().getDisplayName().startsWith("§c§nFirework Gun")){
					e.setCancelled(true);
					p.updateInventory();
					
					if(Start.state == State.LOBBY){
						if(Start.FireworkPasses.get(p.getName()) >= 1){
							Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
					        FireworkMeta fwmeta = fw.getFireworkMeta();
					        FireworkEffect.Builder builder = FireworkEffect.builder();
					        if(Start.FireworkTrail.get(p.getName()) != null && Start.FireworkTrail.get(p.getName()) == true){
					        	builder.withTrail();
					        }
					        if(Start.FireworkFlicker.get(p.getName()) != null && Start.FireworkFlicker.get(p.getName()) == true){
					        	builder.withFlicker();
					        }
					        if(Start.FireworkFade1.get(p.getName()) != null){
					        	builder.withFade(Start.FireworkFade1.get(p.getName()));
					        }
					        if(Start.FireworkFade2.get(p.getName()) != null){
					        	builder.withFade(Start.FireworkFade2.get(p.getName()));
					        }
					        if(Start.FireworkColor1.get(p.getName()) != null){
					        	builder.withColor(Start.FireworkColor1.get(p.getName()));
					        }
					        else{
					        	builder.withColor(Color.AQUA);
					        }
					        if(Start.FireworkColor2.get(p.getName()) != null){
					        	builder.withColor(Start.FireworkColor2.get(p.getName()));
					        }
					        if(Start.FireworkType.get(p.getName()) != null){
					        	builder.with(Start.FireworkType.get(p.getName()));
					        }
					        else{
					        	builder.with(Type.BALL);
					        }
					        
					        fwmeta.addEffects(builder.build());
					        fw.setFireworkMeta(fwmeta);
					        
					        fw.setVelocity(p.getLocation().getDirection().multiply(0.2));
					        
					        Start.FireworkPasses.put(p.getName(), Start.FireworkPasses.get(p.getName()) -1);
					        
							ItemStack item = new ItemStack(Material.FIREBALL, 1);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§c§nFirework Gun§r §c(§6" + Start.FireworkPasses.get(p.getName()) + "§c)");
							item.setItemMeta(itemmeta);
							p.getInventory().setItem(6, new ItemStack(item));
						}
						else{
							p.sendMessage("§c§oYou don't have any §6§lFirework Passes§c§o!");
						}
					}
				}
				if(i.getType() == Material.ENDER_CHEST && i.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
					
					e.setCancelled(true);
					p.updateInventory();
					
					if(Start.state == State.LOBBY){
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
					}
				}
			}
		}catch(Exception ex){
			
		}
		
		if(e.getItem() != null){
			if(e.getItem().getType() == Material.POTION){
				e.setCancelled(true);
				p.openInventory(VIPInv.getVIPInv(p));
				p.playSound(p.getLocation(), Sound.DRINK, 5, 1);
			}
			if(e.getItem().getType() == Material.FEATHER){
				if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){
			
				
					if(Start.state == State.INGAME){
						
						if(Manager.Kit.get(p).equals("Chicken Mama")){
							
							long lastUsed = 0;
							if(lastUsage.containsKey(p.getName())){
								lastUsed = lastUsage.get(p.getName());
							}
							int cdmillis = cdtime * 1000;
									
							if(System.currentTimeMillis()-lastUsed>=cdmillis){
								p.getWorld().playSound(p.getLocation(), Sound.CHICKEN_HURT, 5, 1);
								
								p.sendMessage("§7You used §f§lFeather Attack§7!");
								
								for(Entity en : p.getNearbyEntities(2, 2, 2)){
									
									if(en instanceof Player){
										
										Player player = (Player) en;
										if(Manager.Kit.containsKey(player)){
											if(Manager.Kit.get(player).equals("Baby Chicken")){
												Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.4);
												player.setVelocity(velocity.add(new Vector(0, 1.1, 0)));
											}
											if(Manager.Kit.get(player).equals("Chicken Mama")){
												Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.2);
												player.setVelocity(velocity.add(new Vector(0, 0.55, 0)));
											}
											if(Manager.Kit.get(player).equals("Hot Wing")){
												Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.3);
												player.setVelocity(velocity.add(new Vector(0, 0.825, 0)));
											}
											if(Manager.Kit.get(player).equals("Chicken Warrior")){
												Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2);
												player.setVelocity(velocity.add(new Vector(0, 0.28, 0)));
											}
											player.damage(4D, p);
										}
									}
								}
								
								for(int i1 = 1; i1 <= 25; i1++){
									int upper1 = 5;
									Random random1 = new Random();
									random1.nextInt((upper1));
									int upper2 = 4;
									Random random2 = new Random();
									random2.nextInt((upper2));
									int upper3 = 6;
									Random random3 = new Random();
									random3.nextInt((upper3));
									
									ItemStack toDrop = new ItemStack(Material.FEATHER);
									ItemMeta meta = toDrop.getItemMeta();
									meta.setDisplayName("Feather" + i1);
									toDrop.setItemMeta(meta);
									
									int upper4 = 2;
									Random random4 = new Random();
									random4.nextInt(upper4);
									
									if(random4.nextInt(upper4) == 1){
										final Item item = p.getWorld().dropItem(p.getLocation().add(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
										item.setPickupDelay(Integer.MAX_VALUE);
										 
										new BukkitRunnable(){
										  @Override
										  public void run(){
										    item.remove();
										  }
										}.runTaskLater(this.plugin, 40L);
									}
									if(random4.nextInt(upper4) == 2){
										final Item item = p.getWorld().dropItem(p.getLocation().subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
										item.setPickupDelay(Integer.MAX_VALUE);
										 
										new BukkitRunnable(){
										  @Override
										  public void run(){
										    item.remove();
										  }
										}.runTaskLater(this.plugin, 40L);
									}
								}
								p.setLevel(0);
								p.setExp(0);
								lastUsage.put(p.getName(), System.currentTimeMillis());
							}
							else{
								double timeLeft = (double) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
								p.sendMessage("§cCooldown §6| §7You can use §f§lFeather Attack§7 in §6" + timeLeft + "s");
							}
						}
						if(Manager.Kit.get(p).equals("Baby Chicken")){
							long lastUsed2 = 0;
							if(lastUsage2.containsKey(p.getName())){
								lastUsed2 = lastUsage2.get(p.getName());
							}
							int cdmillis2 = cdtime2 * 1000;
									
							if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
								p.getWorld().playSound(p.getLocation(), Sound.CLICK, 5, 1);
								
								p.sendMessage("§7You used §f§lEgg Bom§7!");
								p.launchProjectile(Egg.class);
								
								p.setLevel(0);
								p.setExp(0);
								lastUsage2.put(p.getName(), System.currentTimeMillis());
							}
							else{
								double timeLeft = (double) (cdtime2-((System.currentTimeMillis()-lastUsed2)/1000));
								p.sendMessage("§cCooldown §6| §7You can use §f§lEgg Bom§7 in §6" + timeLeft + "s");
							}
							
						}
						if(Manager.Kit.get(p).equals("Hot Wing")){
							long lastUsed3 = 0;
							if(lastUsage3.containsKey(p.getName())){
								lastUsed3 = lastUsage3.get(p.getName());
							}
							int cdmillis3 = cdtime3 * 1000;
									
							if(System.currentTimeMillis()-lastUsed3>=cdmillis3){
								p.getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 1);
								
								p.sendMessage("§7You used §f§lFire Shield§7!");
								
								ShieldEffect effect = new ShieldEffect(Start.effectManager);
								effect.setLocation(p.getLocation());
				                effect.iterations = 15;
				                effect.particle = ParticleEffect.FLAME;
				
				                effect.start();
								
				                for(Entity en : p.getNearbyEntities(2.5, 2.5, 2.5)){
				                	
				                	if(en instanceof Player){
				                		
				                		Player player = (Player) en;
				                		
				                		player.setFireTicks(80);
				                		player.playSound(player.getLocation(), Sound.FIRE_IGNITE, 5, 1);
				                		
				                	}
				                	
				                }
								
								p.setLevel(0);
								p.setExp(0);
								lastUsage3.put(p.getName(), System.currentTimeMillis());
							}
							else{
								double timeLeft = (double) (cdtime3-((System.currentTimeMillis()-lastUsed3)/1000));
								p.sendMessage("§cCooldown §6| §7You can use §f§lFire Shield§7 in §6" + timeLeft + "s");
							}
							
						}
						if(Manager.Kit.get(p).equals("Chicken Warrior")){
							long lastUsed4 = 0;
							if(lastUsage4.containsKey(p.getName())){
								lastUsed4 = lastUsage4.get(p.getName());
							}
							int cdmillis4 = cdtime4 * 1000;
									
							if(System.currentTimeMillis()-lastUsed4>=cdmillis4){
								
								p.sendMessage("§7You used §f§lKnock Knock§7!");
								p.playSound(p.getLocation(), Sound.IRONGOLEM_THROW, 5, 1);
								
				                for(Entity en : p.getNearbyEntities(3, 3, 3)){
				                	
				                	if(en instanceof Player){
				                		
				                		final Player player = (Player) en;
				                		
				                		player.playSound(player.getLocation(), Sound.IRONGOLEM_THROW, 5, 1);
				                		
				                		new BukkitRunnable(){
										  @Override
										  public void run(){
												if(Manager.Kit.containsKey(player)){
													if(Manager.Kit.get(player).equals("Baby Chicken")){
								                		player.setVelocity(new Vector(0, 0.9, 0).multiply(2.5));
													}
													if(Manager.Kit.get(player).equals("Chicken Mama")){
								                		player.setVelocity(new Vector(0, 0.7, 0).multiply(2.5));
													}
													if(Manager.Kit.get(player).equals("Hot Wing")){
								                		player.setVelocity(new Vector(0, 0.8, 0).multiply(2.5));
													}
													if(Manager.Kit.get(player).equals("Chicken Warrior")){
								                		player.setVelocity(new Vector(0, 0.5, 0).multiply(2.5));
													}
													player.damage(5D, p);
												}
										  }
										}.runTaskLater(this.plugin, 1L);
				                	}
				                	
				                }
								
								p.setLevel(0);
								p.setExp(0);
								lastUsage4.put(p.getName(), System.currentTimeMillis());
							}
							else{
								double timeLeft = (double) (cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
								p.sendMessage("§cCooldown §6| §7You can use §f§lKnock Knock§7 in §6" + timeLeft + "s");
							}
						}
						
					}
					
				}
			}
			if(e.getItem().getType() == Material.EMERALD){
				
				p.playEffect(p.getLocation(), Effect.STEP_SOUND, 133);
				p.openInventory(StatsInv.getStatsInv(p));
				
			}
			if(e.getItem().getType() == Material.ENDER_PEARL){
				e.setCancelled(true);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.updateInventory();
				
					} 
				}, 1L);
				
		        ByteArrayOutputStream b = new ByteArrayOutputStream();
		        DataOutputStream out = new DataOutputStream(b);
		 
		        try {
		            out.writeUTF("Connect");
		            out.writeUTF("hub");
		        } catch (IOException eee) {
		         
		        }
		 
		        p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
			}
			
		}
	}
}
