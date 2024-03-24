package me.O_o_Fadi_o_O.KitPvP.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
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
	
	Start plugin;
	 
	public DamageEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){

		if(StorageManager.ownerpets.containsValue(e.getDamager().getUniqueId())){
			e.setCancelled(true);
		}
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			
			if(!StorageManager.PlayerKitSelected.containsKey(p)){
				e.setCancelled(true);
			}
			
			if(StorageManager.Spectators.contains(p)){
				e.setCancelled(true);
			}
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
				
				useUndeathI(l);
					
				StorageManager.necromancerarrowlvl1.remove(proj);
			}
			if(StorageManager.necromancerarrowlvl2.contains(proj)){
				Location l = proj.getLocation();
				
				useUndeathII(l);
					
				StorageManager.necromancerarrowlvl2.remove(proj);
				
			}
			if(StorageManager.tntlvl2.contains(proj)){
				
				TNTPrimed tnt = (TNTPrimed) proj.getWorld().spawn(proj.getLocation(), TNTPrimed.class);
				tnt.setFuseTicks(10);
					
				StorageManager.tntlvl2.remove(proj);
			}
	    }
		
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
		
			Player p = (Player) e.getDamager();
			Player enP = (Player) e.getEntity();
			ItemStack h = p.getItemInHand();
			try{
				Material m = enP.getInventory().getChestplate().getType();
				List<String> lore = enP.getInventory().getChestplate().getItemMeta().getLore();
				
				if(m == Material.LEATHER_CHESTPLATE && lore.contains("§7Molten Armor I")){
					useMoltenArmorI(p);
		        }
				if(m == Material.LEATHER_CHESTPLATE && lore.contains("§7Wither Armor I")){
		        	useWitherArmorI(p);	
		        }
			}catch(Exception ex){}
			try{
				KitPlaying KitSelected = StorageManager.PlayerKitSelected.get(p);
				List<String> lore = h.getItemMeta().getLore();
				
				if(lore != null){
				
					if(KitSelected == KitPlaying.DarkMage_LvL_1){
							useMagicI(enP);
						}
					}
					if(KitSelected == KitPlaying.Soldier_LvL_1 || KitSelected == KitPlaying.Soldier_LvL_2 || KitSelected == KitPlaying.Soldier_LvL_3){
						if(lore.contains("§7Lightning I")){
							useLightningISword(enP);
						}
		
						if(lore.contains("§7Lightning II")){
					        useLightningIISword(enP);
						}
					}
					if(KitSelected == KitPlaying.Vampire_LvL_1){
						if(lore.contains("§7Vampire I")){
					        useVampireI(p);
						}
					}
					if(KitSelected == KitPlaying.Beast_LvL_1){
						if(lore.contains("§7Knockup I")){
					        useKnockupI(enP);
						}
					}
					if(KitSelected == KitPlaying.Drunk_LvL_1 || KitSelected == KitPlaying.Drunk_LvL_2 || KitSelected == KitPlaying.Drunk_LvL_3){
						if(lore.contains("§7Blindness I")){
					        useBlindnessI(enP);
						}
						if(lore.contains("§7Blindness II")){
					        useBlindnessII(enP);
						}
					}
					if(KitSelected == KitPlaying.Villager_LvL_1 || KitSelected == KitPlaying.Villager_LvL_2 || KitSelected == KitPlaying.Villager_LvL_3){
						if(lore.contains("§7Trade I")){
					        useTradeI(p, enP);
					}
					if(KitSelected == KitPlaying.Spider_LvL_1 || KitSelected == KitPlaying.Spider_LvL_2 || KitSelected == KitPlaying.Spider_LvL_3){
						if(lore.contains("§7Arthropods I")){
					        useArthropodsI(enP);
						}
						if(lore.contains("§7Arthropods II")){
					        useArthropodsII(enP);
						}
						if(lore.contains("§7Arthropods III")){
							useArthropodsIII(enP);
						}
					}
				}
			}catch(Exception ex){}
		}
		if(e.getDamager() instanceof WitherSkull && e.getEntity() instanceof Player){	
			Player p = (Player) e.getEntity();
			p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0));
		}
	}
	
	public void useUndeathI(Location l){
		final Zombie z1 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z1.setCustomName("§4Undeath Knight");
		z1.setCustomNameVisible(true);
    
		final Zombie z2 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z2.setCustomName("§4Undeath Knight");
		z2.setCustomNameVisible(true);
    
		final Zombie z3 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z3.setCustomName("§4Undeath Knight");
		z3.setCustomNameVisible(true);
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
			public void run(){
				
				if(z1 instanceof LivingEntity){
					z1.getWorld().playEffect(z1.getLocation(), Effect.STEP_SOUND, 152);
					z1.remove();
				}
				if(z2 instanceof LivingEntity){
					z2.getWorld().playEffect(z2.getLocation(), Effect.STEP_SOUND, 152);
					z2.remove();
				}
				if(z3 instanceof LivingEntity){
					z3.getWorld().playEffect(z3.getLocation(), Effect.STEP_SOUND, 152);
					z3.remove();
				}
				
			}
		}, 300);
	}
	
	public void useUndeathII(Location l){
		final Zombie z1 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z1.setCustomName("§4Undeath Knight");
		z1.setCustomNameVisible(true);
    
		final Zombie z2 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z2.setCustomName("§4Undeath Knight");
		z2.setCustomNameVisible(true);
    
		final Zombie z3 = (Zombie) (l.getWorld().spawnEntity(l, EntityType.ZOMBIE));
		z3.setCustomName("§4Undeath Knight");
		z3.setCustomNameVisible(true);
		
		final Skeleton s1 = (Skeleton) (l.getWorld().spawnEntity(l, EntityType.SKELETON));
		s1.setSkeletonType(SkeletonType.NORMAL);
		s1.setCustomName("§4Undeath Archer");
		s1.setCustomNameVisible(true);
		
	
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
			public void run(){
				
				if(z1 instanceof LivingEntity){
					z1.getWorld().playEffect(z1.getLocation(), Effect.STEP_SOUND, 152);
					z1.remove();
				}
				if(z2 instanceof LivingEntity){
					z2.getWorld().playEffect(z2.getLocation(), Effect.STEP_SOUND, 152);
					z2.remove();
				}
				if(z3 instanceof LivingEntity){
					z3.getWorld().playEffect(z3.getLocation(), Effect.STEP_SOUND, 152);
					z3.remove();
				}
				if(s1 instanceof LivingEntity){
					s1.getWorld().playEffect(s1.getLocation(), Effect.STEP_SOUND, 152);
					s1.remove();
				}
			}
		}, 300);
	}
	
	public void useMoltenArmorI(Player p){
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
		if(!p.getActivePotionEffects().contains(PotionEffectType.SLOW)){
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 5));
		}
	}
	
	public void useWitherArmorI(Player p){
		p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
	}
	
	public void useMagicI(Player p){
		p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 0));
	}
	
	public void useLightningISword(Player p){
        Random Lightning = new Random();
        int LightningInt;
        
        for(int LightningCount = 1; LightningCount <= 1; LightningCount++){
        	LightningInt = 1 + Lightning.nextInt(4);
        	
        	if(LightningInt == 3){
				World w = p.getWorld();
				Location l = p.getLocation();
					
				w.strikeLightning(l);
        	}
        }
	}
	
	public void useLightningIISword(Player p){
        Random Lightning = new Random();
        int LightningInt;
        
        for(int LightningCount = 1; LightningCount <= 1; LightningCount++){
        	LightningInt = 1 + Lightning.nextInt(3);
        	
        	if(LightningInt == 3){
        		World w = p.getWorld();
				Location l = p.getLocation();
					
				w.strikeLightning(l);
        	}
        }
	}
	
	public void useVampireI(Player p){
		try{p.setHealth(((CraftPlayer) p).getHandle().getHealth() + 1.5);}catch(Exception ex){}
	}
	
	public void useKnockupI(Player p){
      	Random Launch = new Random();
      	int LaunchInt;
       
      	for(int LaunchCount = 1; LaunchCount <= 1; LaunchCount++){
	       	LaunchInt = 1 + Launch.nextInt(2);
	       	
	       	
	       	if(LaunchInt == 2){
	   			p.setVelocity(new Vector(0, 0.9, 0));
		        	
	        	p.playSound(p.getLocation(), Sound.FALL_BIG, 6, 2);	
	       	}
      	}
	}
	
	public void useBlindnessI(Player p){
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
	}
	
	public void useBlindnessII(Player p){
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
	}
	
	public void useTradeI(Player p1, Player p2){
		ItemStack bread = new ItemStack(Material.BREAD, 1);
		ItemMeta breadmeta = bread.getItemMeta();
		breadmeta.setDisplayName("§b§lVillager §a§lLvL 3§8 || §aTrade System");
		List<String> breadlore = new ArrayList<String>();
		breadlore.add("§7Trade I");
		breadmeta.setLore(breadlore);
		bread.setItemMeta(breadmeta);
		bread.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
    	
		if(p1.getInventory().containsAtLeast(bread, 1)){
    		p1.getInventory().removeItem(bread);
    		
    		ItemStack h2 = p2.getItemInHand();
    		if(h2 != null){
    			p1.getInventory().addItem(h2);
    			p2.getInventory().removeItem(h2);
    			p1.playSound(p1.getLocation(), Sound.VILLAGER_HAGGLE, 5, 1);
    			p2.playSound(p2.getLocation(), Sound.VILLAGER_HAGGLE, 5, 1);
    		}
    	}
	}
	
	public void useArthropodsI(Player p){
		Random Spider = new Random();
        int SpiderInt;
        
        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
        	SpiderInt = 1 + Spider.nextInt(6);
        	
        	if(SpiderInt == 3){
	        	final Spider s1 = (Spider) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER));
				s1.setCustomName("§6Spiderman");
				s1.setCustomNameVisible(true);
				s1.setTarget((LivingEntity) p);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						
						if(s1 instanceof LivingEntity){
							s1.getWorld().playEffect(s1.getLocation(), Effect.STEP_SOUND, 152);
							s1.remove();
						}
					}
				}, 200);
        	}
        }
        
		p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 2));
	}
	
	public void useArthropodsII(Player p){
    	Random Spider = new Random();
        int SpiderInt;
		        
        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
        	SpiderInt = 1 + Spider.nextInt(5);
		        	
        	if(SpiderInt == 3){
		        		
        		final Skeleton s = (Skeleton) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON));
        		s.setSkeletonType(SkeletonType.NORMAL);
        		s.setTarget((LivingEntity) p);

	        	final Spider s1 = (Spider) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER));
				s1.setCustomName("§6Spiderman");
				s1.setCustomNameVisible(true);
				s1.setPassenger(s);
				s1.setTarget((LivingEntity) p);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						
						if(s instanceof LivingEntity){
							s.getWorld().playEffect(s.getLocation(), Effect.STEP_SOUND, 152);
							s.remove();
						}
						if(s1 instanceof LivingEntity){
							s1.getWorld().playEffect(s1.getLocation(), Effect.STEP_SOUND, 152);
							s1.remove();
						}
					}
				}, 200);
        	}
        }
	        	
		p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 2));
	}
	
	public void useArthropodsIII(Player p){
    	
    	Random Spider = new Random();
        int SpiderInt;
        
        for(int SpiderCount = 1; SpiderCount <= 1; SpiderCount++){
        	SpiderInt = 1 + Spider.nextInt(4);
	        	
        	if(SpiderInt == 3){
	        		
        		final Skeleton s = (Skeleton) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON));
        		s.setSkeletonType(SkeletonType.NORMAL);
        		s.setTarget((LivingEntity) p);

	        	final Spider s1 = (Spider) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER));
				s1.setCustomName("§6Spiderman");
				s1.setCustomNameVisible(true);
				s1.setPassenger(s);
				s1.setTarget((LivingEntity) p);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						
						if(s instanceof LivingEntity){
							s.getWorld().playEffect(s.getLocation(), Effect.STEP_SOUND, 152);
							s.remove();
						}
						if(s1 instanceof LivingEntity){
							s1.getWorld().playEffect(s1.getLocation(), Effect.STEP_SOUND, 152);
							s1.remove();
						}
					}
				}, 200);
        	}
        	if(SpiderInt == 4){
	        	final Spider s = (Spider) (p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER));
				s.setCustomName("§6Spiderman");
				s.setCustomNameVisible(true);
				s.setTarget((LivingEntity) p);
	        		
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						
						if(s instanceof LivingEntity){
							s.getWorld().playEffect(s.getLocation(), Effect.STEP_SOUND, 152);
							s.remove();
						}
					}
				}, 200);
        	}
        }
        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 2));
	}
}
