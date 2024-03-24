package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Spider && !StorageManager.petentity.containsValue(e.getDamager())){
			final Player p = (Player) e.getEntity();
			p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 0));
			hub.getServer().getScheduler().scheduleSyncDelayedTask(this.hub, new Runnable(){
				public void run(){
					p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				} 
			}, 1L);
			hub.getServer().getScheduler().scheduleSyncDelayedTask(this.hub, new Runnable(){
				public void run(){
					p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				} 
			}, 2L);
			hub.getServer().getScheduler().scheduleSyncDelayedTask(this.hub, new Runnable(){
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
						if(!StorageManager.playersinlapisparkour.contains(p)){
							p.playSound(p.getLocation(), Sound.WITHER_IDLE, 5, 1);
							p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
							p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 4));
						}
					}
				}
			}
		}
		
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			
			ItemStack i = ((Player) e.getDamager()).getItemInHand();
			
			if(i != null){
				if(i.getType() == Material.LEASH && i.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
					
					if(!StorageManager.playersinlapisparkour.contains(pE) && !StorageManager.playersinlapisparkour.contains(pD)){
						if(StorageManager.loaded.get(pE) == true && StorageManager.loaded.get(pD) == true)
						if(StorageManager.stackerenabled.get(pE) == true){
							if(StorageManager.stackerenabled.get(pD) == true){
								if(StorageManager.playersenabled.get(pE) == true){
									pD.setPassenger(pE);
									
									pD.sendMessage("§7You've §6§lstacked§f " + PlayerManager.getPlayerDisplayname(pE) + "§7 on your Head!");
									pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
									pE.sendMessage("§7" + PlayerManager.getPlayerDisplayname(pD) + " §6§lstacked§7 you on their Head!");
									e.setCancelled(true);
								}
								else{
									pD.sendMessage("§7This player has §c§lDISABLED §3§lPlayers§7!");
								}
							}
							else{
								pD.sendMessage("§7You §c§lDISABLED§6§l stacking§7! Enable it in your §c§nSettings§7!");
							}
						}
						else{
							pD.sendMessage("§7This player has §c§lDISABLED §6§lstacking§7!");
						}
					}
				}
			}
		}
	}
}
