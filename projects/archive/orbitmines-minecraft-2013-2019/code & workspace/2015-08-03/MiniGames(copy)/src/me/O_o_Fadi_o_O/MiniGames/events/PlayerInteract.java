package me.O_o_Fadi_o_O.MiniGames.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.Inventories.MiniGameSelector;
import me.O_o_Fadi_o_O.MiniGames.Inventories.StatsInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.TeleporterInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.VIPInv;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;
import me.O_o_Fadi_o_O.MiniGames.utils.Server;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.GenericAttributes;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftFirework;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerInteract implements Listener{
	
	Start start = Start.getInstance();
	 
	public static Map<String, Long> lastUsage = new HashMap<String, Long>();
	public static final int cdtime = 6;
	
	public static Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	public static final int cdtime2 = 7;
	
	public static Map<String, Long> lastUsage3 = new HashMap<String, Long>();
	public static final int cdtime3 = 10;
	
	public static Map<String, Long> lastUsage4 = new HashMap<String, Long>();
	public static final int cdtime4 = 8;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			
			
			if(e.getItem().getType() == Material.FEATHER){
				if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){
			
					if(StorageManager.playersgame.containsKey(p)){
						if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
							if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(p)) == ChickenFightState.INGAME){
						
								if(StorageManager.chickenfightkit.get(p).equals("Chicken Mama")){
									
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
												if(StorageManager.chickenfightkit.containsKey(player)){
													if(StorageManager.chickenfightkit.get(player).equals("Baby Chicken")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.4);
														player.setVelocity(velocity.add(new Vector(0, 1.1, 0)));
													}
													if(StorageManager.chickenfightkit.get(player).equals("Chicken Mama")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.2);
														player.setVelocity(velocity.add(new Vector(0, 0.55, 0)));
													}
													if(StorageManager.chickenfightkit.get(player).equals("Hot Wing")){
														Vector velocity = player.getLocation().subtract(p.getLocation()).toVector().normalize().multiply(2.3);
														player.setVelocity(velocity.add(new Vector(0, 0.825, 0)));
													}
													if(StorageManager.chickenfightkit.get(player).equals("Chicken Warrior")){
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
												}.runTaskLater(this.start, 40L);
											}
											if(random4.nextInt(upper4) == 2){
												final Item item = p.getWorld().dropItem(p.getLocation().subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
												item.setPickupDelay(Integer.MAX_VALUE);
												 
												new BukkitRunnable(){
												  @Override
												  public void run(){
												    item.remove();
												  }
												}.runTaskLater(this.start, 40L);
											}
										}
										p.setLevel(0);
										p.setExp(0);
										lastUsage.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime-((System.currentTimeMillis()-lastUsed)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lFeather Attack§7 in §6" + timeLeft + "s");
									}
								}
								if(StorageManager.chickenfightkit.get(p).equals("Baby Chicken")){
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
										int timeLeft = (int) (cdtime2-((System.currentTimeMillis()-lastUsed2)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lEgg Bom§7 in §6" + timeLeft + "s");
									}
									
								}
								if(StorageManager.chickenfightkit.get(p).equals("Hot Wing")){
									long lastUsed3 = 0;
									if(lastUsage3.containsKey(p.getName())){
										lastUsed3 = lastUsage3.get(p.getName());
									}
									int cdmillis3 = cdtime3 * 1000;
											
									if(System.currentTimeMillis()-lastUsed3>=cdmillis3){
										p.getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 1);
										
										p.sendMessage("§7You used §f§lFire Shield§7!");
										
										//TODO
										/*
										ShieldEffect effect = new ShieldEffect(Start.effectManager);
										effect.setLocation(p.getLocation());
						                effect.iterations = 15;
						                effect.particle = ParticleEffect.FLAME;
						
						                effect.start();
						                */
										
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
										int timeLeft = (int) (cdtime3-((System.currentTimeMillis()-lastUsed3)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lFire Shield§7 in §6" + timeLeft + "s");
									}
									
								}
								if(StorageManager.chickenfightkit.get(p).equals("Chicken Warrior")){
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
														if(StorageManager.chickenfightkit.containsKey(player)){
															if(StorageManager.chickenfightkit.get(player).equals("Baby Chicken")){
										                		player.setVelocity(new Vector(0, 0.9, 0).multiply(2.5));
															}
															if(StorageManager.chickenfightkit.get(player).equals("Chicken Mama")){
										                		player.setVelocity(new Vector(0, 0.7, 0).multiply(2.5));
															}
															if(StorageManager.chickenfightkit.get(player).equals("Hot Wing")){
										                		player.setVelocity(new Vector(0, 0.8, 0).multiply(2.5));
															}
															if(StorageManager.chickenfightkit.get(player).equals("Chicken Warrior")){
										                		player.setVelocity(new Vector(0, 0.5, 0).multiply(2.5));
															}
															player.damage(5D, p);
														}
												  }
												}.runTaskLater(this.start, 1L);
						                	}
						                	
						                }
										
										p.setLevel(0);
										p.setExp(0);
										lastUsage4.put(p.getName(), System.currentTimeMillis());
									}
									else{
										int timeLeft = (int) (cdtime4-((System.currentTimeMillis()-lastUsed4)/1000));
										p.sendMessage("§cCooldown §6| §7You can use §f§lKnock Knock§7 in §6" + timeLeft + "s");
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
