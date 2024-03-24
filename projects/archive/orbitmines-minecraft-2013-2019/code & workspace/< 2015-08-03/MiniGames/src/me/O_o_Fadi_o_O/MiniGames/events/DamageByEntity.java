package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DamageByEntity implements Listener{
	
	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			final Player damager = (Player) e.getDamager();
			final Player damaged = (Player) e.getEntity();
			
			ItemStack c = damager.getItemInHand();
			
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Spider && !StorageManager.petentity.containsValue(e.getDamager())){
				final Player p = (Player) e.getEntity();
				p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 0));
				start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}, 1L);
				start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}, 2L);
				start.getServer().getScheduler().scheduleSyncDelayedTask(this.start, new Runnable(){
					public void run(){
						p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
					} 
				}, 3L);
			}
			
			if(e.getDamager() instanceof Snowball){
				Entity end = e.getDamager();
				if(StorageManager.snowgolemattackballs.contains(end)){
					
					for(Entity en : end.getNearbyEntities(0.5, 0.5, 0.5)){
						if(en instanceof Player){
							Player p = (Player) en;
							p.playSound(p.getLocation(), Sound.WITHER_IDLE, 5, 1);
							p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
							p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 4));
						}
					}
				}
			}
			
			if(StorageManager.playersinchickenfight.contains(damager) && StorageManager.playersinchickenfight.contains(damaged)){
				
				if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(damager)) == ChickenFightState.INGAME){
					damaged.getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, 152, 3);
				}
			}
			if(c != null){
				if(c.getType() == Material.LEASH && c.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
					if(StorageManager.loaded.get(pD) == true){
						pD.setPassenger(pE);
						
						pD.sendMessage("§7You've §6§lstacked§7 " + PlayerManager.getPlayerDisplayname(pE) + " on your Head!");
						pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
						pE.sendMessage("§7" + PlayerManager.getPlayerDisplayname(pD) + " §6§lstacked§7 you on their Head!");
						e.setCancelled(true);
					}
					else{
						PlayerManager.warnPlayerNotLoaded(pD);
					}
				}
			}
			if(c != null && c.getType() == Material.FEATHER){
				
				new BukkitRunnable(){
					
					public void run(){
						if(StorageManager.chickenfightkit.get(damaged).equals("Baby Chicken")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.4);
							damaged.setVelocity(velocity.add(new Vector(0, 0.6, 0)));
						}
						if(StorageManager.chickenfightkit.get(damaged).equals("Chicken Mama")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.2);
							damaged.setVelocity(velocity.add(new Vector(0, 0.45, 0)));
						}
						if(StorageManager.chickenfightkit.get(damaged).equals("Hot Wing")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.3);
							damaged.setVelocity(velocity.add(new Vector(0, 0.53, 0)));
						}
						if(StorageManager.chickenfightkit.get(damaged).equals("Chicken Warrior")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.05);
							damaged.setVelocity(velocity.add(new Vector(0, 0.24, 0)));
						}
					}
				}.runTaskLater(this.start, 1L);
				
			}
			
			if(StorageManager.spectatorsinchickenfight.contains(damager)){
				e.setCancelled(true);
			}
			
			if(StorageManager.spectatorsinsurvivalgames.contains(damager)){
				e.setCancelled(true);
			}
			if(StorageManager.playersgame.containsKey(damager)){
				if(StorageManager.playersgame.get(damager) == Game.CHICKENFIGHT){
					if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(damager)) != ChickenFightState.INGAME){
						e.setCancelled(true);
					}
				}
				if(StorageManager.playersgame.get(damager) == Game.SURVIVALGAMES){
					if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(damager)) != SurvivalGamesState.INGAME && StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(damager)) != SurvivalGamesState.DEATHMATCH){
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
