package me.O_o_Fadi_o_O.KitPvP.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		
		if(StorageManager.ownerpets.containsValue(e.getDamager().getUniqueId())){
			e.setCancelled(true);
		}
		
		if(e.getDamager() instanceof Projectile){
			
			Projectile proj = (Projectile) e.getDamager();
			
			if(StorageManager.arrow.contains(proj)){
				Location l = proj.getLocation();
				World w = proj.getWorld();
				w.strikeLightning(l);
				StorageManager.arrow.remove(proj);
			}
			if(StorageManager.necromancerarrowlvl1.contains(proj)){
				Location l = proj.getLocation();
				
					Zombie z1 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z1.setCustomName("§4Undeath Knight");
					z1.setCustomNameVisible(true);
			    
					Zombie z2 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z2.setCustomName("§4Undeath Knight");
					z2.setCustomNameVisible(true);
			    
					Zombie z3 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z3.setCustomName("§4Undeath Knight");
					z3.setCustomNameVisible(true);
				StorageManager.necromancerarrowlvl1.remove(proj);
			}
			if(StorageManager.necromancerarrowlvl2.contains(proj)){
				Location l = proj.getLocation();
				
					Zombie z1 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z1.setCustomName("§4Undeath Knight");
					z1.setCustomNameVisible(true);
			    
					Zombie z2 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z2.setCustomName("§4Undeath Knight");
					z2.setCustomNameVisible(true);
			    
					Zombie z3 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
					z3.setCustomName("§4Undeath Knight");
					z3.setCustomNameVisible(true);
					
					Skeleton s1 = (Skeleton) (l.getWorld().spawnEntity(l, EntityType.SKELETON));
					s1.setSkeletonType(SkeletonType.NORMAL);
					s1.setCustomName("§4Undeath Archer");
					s1.setCustomNameVisible(true);
				StorageManager.necromancerarrowlvl2.remove(proj);
			}
			if(StorageManager.tntlvl2.contains(proj)){
				
				TNTPrimed tnt = (TNTPrimed) proj.getWorld().spawn(proj.getLocation(), TNTPrimed.class);
				tnt.setFuseTicks(10);
					
					
				StorageManager.tntlvl2.remove(proj);
			}
	    }
		
		if(e.getDamager() instanceof Player){
		
			Player p = (Player) e.getDamager();
			ItemStack h = p.getItemInHand();
			try{
				if(h != null && h.getType() == Material.STONE_SWORD && h.getItemMeta().getLore().contains("§7Lightning I")){
				
					// 25% CHANCE OF STRIKING A LIGHTNING ON HIT
			        Random Lightning = new Random();
			        int LightningInt;
			        
			        for(int LightningCount = 1; LightningCount <= 1; LightningCount++){
			        	LightningInt = 1 + Lightning.nextInt(4);
			        	
			        	if(LightningInt == 1){
			        		
			        	}
			        	else if(LightningInt == 2){
			        		
			        	}
			        	else if(LightningInt == 3){
							Entity en = e.getEntity();
							World w = en.getWorld();
							Location l = en.getLocation();
								
							w.strikeLightning(l);
			        	}
			        	else if(LightningInt == 4){
			        		
			        	}
			        }
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.STONE_SWORD && h.getItemMeta().getLore().contains("§7Lightning II")){
				
					// 33% CHANCE OF STRIKING A LIGHTNING ON HIT
			        Random Lightning = new Random();
			        int LightningInt;
			        
			        for(int LightningCount = 1; LightningCount <= 1; LightningCount++){
			        	LightningInt = 1 + Lightning.nextInt(3);
			        	
			        	if(LightningInt == 1){
			        		
			        	}
			        	else if(LightningInt == 2){
			        		
			        	}
			        	else if(LightningInt == 3){
							Entity en = e.getEntity();
							World w = en.getWorld();
							Location l = en.getLocation();
								
							w.strikeLightning(l);
			        	}
			        }
				}
			}
			catch(NullPointerException exception){
				
			}
			// VAMPIRE 1
			try{
				if(h != null && h.getType() == Material.IRON_SWORD && h.getItemMeta().getLore().contains("§7Vampire I")){
				
			        if(e.getEntity() instanceof Player){
			        	
			        	try{
			        	p.setHealth(((CraftPlayer) p).getHandle().getHealth() + 2);
			        	}
			        	catch(Exception ex){
			        		
			        	}
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// KNOCKUP 1
			try{
				if(h != null && h.getType() == Material.IRON_AXE && h.getItemMeta().getLore().contains("§7Knockup I")){
					
			        if(e.getEntity() instanceof Player){
				
			        	Player player = (Player) e.getEntity();
			        	
			        	 Random Launch = new Random();
					        int LaunchInt;
					        
					        for(int LaunchCount = 1; LaunchCount <= 1; LaunchCount++){
					        	LaunchInt = 1 + Launch.nextInt(2);
					        	
					        	if(LaunchInt == 1){
					        		
					        	}
					        	else if(LaunchInt == 2){
					        		player.setVelocity(new Vector(0, 0.9, 0));
						        	
						        	player.playSound(player.getLocation(), Sound.FALL_BIG, 6, 2);	
					        	}
					        }
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// GRIM REAPER CHESTPLATE
			try{
				if(e.getEntity() instanceof Player){
					if(h != null && ((CraftHumanEntity) e.getEntity()).getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE && ((CraftHumanEntity) e.getEntity()).getInventory().getChestplate().getItemMeta().getLore().contains("§7Molten Armor I")){
				
			        	
			        	// SLOW & BLINDESS
						((CraftLivingEntity) e.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
						if(!((CraftLivingEntity) e.getDamager()).getActivePotionEffects().contains(PotionEffectType.SLOW)){
							((CraftLivingEntity) e.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 5));
						}
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// BLINDNESS 1 CHESTPLATE
			try{
				if(e.getEntity() instanceof Player){
					if(h != null && ((CraftHumanEntity) e.getEntity()).getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE && ((CraftHumanEntity) e.getEntity()).getInventory().getChestplate().getItemMeta().getLore().contains("§7Wither Armor I")){
				
			        	
			        	// WITHER & BLINDESS
						((CraftLivingEntity) e.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
			    		((CraftLivingEntity) e.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0));
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// BLINDNESS 1
			try{
				if(h != null && h.getType() == Material.IRON_SWORD && h.getItemMeta().getLore().contains("§7Blindness I")){
				
			        if(e.getEntity() instanceof Player){
			        	
			        	Player player = (Player) e.getEntity();
			        	// BLINDNESS
			    		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// BLINDNESS 2
			try{
				if(h != null && h.getType() == Material.DIAMOND_SWORD && h.getItemMeta().getLore().contains("§7Blindness II")){
				
			        if(e.getEntity() instanceof Player){
			        	
			        	Player player = (Player) e.getEntity();
			        	// BLINDNESS
			    		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// VILLAGER TRADE
			try{
				if(h != null && h.getType() == Material.BREAD && h.getItemMeta().getLore().contains("§7Trade I")){
				
			        if(e.getEntity() instanceof Player){
			        	
			        	Player player = (Player) e.getEntity();

			        	ItemStack bread = new ItemStack(Material.BREAD, 1);
			    		ItemMeta breadmeta = bread.getItemMeta();
			    		breadmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §aTrade System");
			    		List<String> breadlore = new ArrayList<String>();
			    		breadlore.add("§7Trade I");
			    		breadmeta.setLore(breadlore);
			    		bread.setItemMeta(breadmeta);
			    		bread.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			        	
			    		if(p.getInventory().containsAtLeast(bread, 1)){
			        		p.getInventory().removeItem(bread);
			        		
			        		ItemStack h2 = player.getItemInHand();
			        		if(h2 != null){
			        			p.getInventory().addItem(h2);
			        			player.getInventory().removeItem(h2);
			        			p.playSound(p.getLocation(), Sound.VILLAGER_HAGGLE, 5, 1);
			        			player.playSound(player.getLocation(), Sound.VILLAGER_HAGGLE, 5, 1);
			        		}
			        	}
			        	
			        }
				}
			}
			catch(NullPointerException exception){
				
			}
			// ARTHROPODS I
			try{
				if(h != null && h.getType() == Material.SPIDER_EYE && h.getItemMeta().getLore().contains("§7Arthropods I")){
				
			        if(e.getEntity() instanceof Player){
			        	
			        	Player player = (Player) e.getEntity();
			        	
			        	Random Spider = new Random();
				        int SpiderInt;
				        
				        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
				        	SpiderInt = 1 + Spider.nextInt(6);
				        	
				        	if(SpiderInt == 1){
				        		
				        	}
				        	else if(SpiderInt == 2){
				        		
				        	}
				        	else if(SpiderInt == 3){
					        	Spider s1 = (Spider) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SPIDER));
								s1.setCustomName("§6Spiderman");
								s1.setCustomNameVisible(true);
								s1.setTarget((LivingEntity) e.getEntity());
				        	}
				        	else if(SpiderInt == 4){
				        		
				        	}
				        	else if(SpiderInt == 5){
				        		
				        	}
				        	else if(SpiderInt == 6){
				        		
				        	}
				        }
			        	
			        	// POISON
			    		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 2));
			        }
					
				}
			}
			catch(NullPointerException exception){
				
			}
			// ARTHROPODS II
				try{
					if(h != null && h.getType() == Material.SPIDER_EYE && h.getItemMeta().getLore().contains("§7Arthropods II")){
						
				        if(e.getEntity() instanceof Player){
						        	
				        	Player player = (Player) e.getEntity();
						        	
				        	Random Spider = new Random();
					        int SpiderInt;
							        
					        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
					        	SpiderInt = 1 + Spider.nextInt(5);
							        	
					        	if(SpiderInt == 1){
							        		
					        	}
					        	else if(SpiderInt == 2){
							        		
					        	}
					        	else if(SpiderInt == 3){
							        		
					        		Skeleton s = (Skeleton) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SKELETON));
					        		s.setSkeletonType(SkeletonType.NORMAL);
					        		s.setTarget((LivingEntity) e.getEntity());

						        	Spider s1 = (Spider) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SPIDER));
									s1.setCustomName("§6Spiderman");
									s1.setCustomNameVisible(true);
									s1.setPassenger(s);
									s1.setTarget((LivingEntity) e.getEntity());
					        	}
					        	else if(SpiderInt == 4){
							        		
					        	}
					        	else if(SpiderInt == 5){
					        		
					        	}
					        }
						        	
				        	// POISON
				    		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 2));
					        }
								
						}
					}
					catch(NullPointerException exception){
							
					}
					// ARTHROPODS III
					try{
						if(h != null && h.getType() == Material.SPIDER_EYE && h.getItemMeta().getLore().contains("§7Arthropods III")){
						
					        if(e.getEntity() instanceof Player){
						        	
					        	Player player = (Player) e.getEntity();
						        	
					        	Random Spider = new Random();
						        int SpiderInt;
						        
						        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
						        	SpiderInt = 1 + Spider.nextInt(4);
							        	
						        	if(SpiderInt == 1){
							        		
						        	}
						        	else if(SpiderInt == 2){
							        		
						        	}
						        	else if(SpiderInt == 3){
							        		
						        		Skeleton s = (Skeleton) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SKELETON));
						        		s.setSkeletonType(SkeletonType.NORMAL);
						        		s.setTarget((LivingEntity) e.getEntity());

							        	Spider s1 = (Spider) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SPIDER));
										s1.setCustomName("§6Spiderman");
										s1.setCustomNameVisible(true);
										s1.setPassenger(s);
										s1.setTarget((LivingEntity) e.getEntity());
						        	}
						        	else if(SpiderInt == 4){
							        	Spider s = (Spider) (e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SPIDER));
										s.setCustomName("§6Spiderman");
										s.setCustomNameVisible(true);
										s.setTarget((LivingEntity) e.getEntity());
							        		
						        	}
						        }
						        	
					        	// POISON
					    		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 2));
					        }
								
						}
					}
					catch(NullPointerException exception){
							
					}
		}
		if(e.getDamager() instanceof WitherSkull && e.getEntity() instanceof Player){
			
			Player p = (Player) e.getEntity();
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0));
			
		}
	}
}
