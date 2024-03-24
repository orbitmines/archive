package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageEvent implements Listener{
	
	Hub plugin;
	 
	public DamageEvent(Hub instance) {
		plugin = instance;
	}
	
	ServerSelector sinv = new ServerSelector(this.plugin);
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Spider && !StorageManager.owners.containsKey(e.getDamager())){
			final Player p = (Player) e.getEntity();
			p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 0));
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				} 
			}, 1L);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				} 
			}, 2L);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
				public void run(){
					p.playSound(p.getLocation(), Sound.SPIDER_IDLE, 5, 1);
				} 
			}, 3L);
		}
		
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			
			ItemStack i = ((Player) e.getDamager()).getItemInHand();
			
			if(i != null){
				if(i.getType() == Material.LEASH && i.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
					
					if(!StorageManager.PlayersInParkour.contains(pE) && !StorageManager.PlayersInParkour.contains(pD)){
						if(StorageManager.EnableStacker.get(pE.getName()) == true){
							if(StorageManager.EnableStacker.get(pD.getName()) == true){
								pD.setPassenger(pE);
								
								pD.sendMessage("§fYou've §6§lstacked§f " + PlayerManager.playerDisplayName(pE) + "§f on your Head!");
								pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
								pE.sendMessage("§f" + PlayerManager.playerDisplayName(pD) + " §6§lstacked§f you on their Head!");
								e.setCancelled(true);
							}
							else{
								pD.sendMessage("§fYou §c§lDISABLED§6§l stacking§f! Enable it in your §c§nSettings§f!");
							}
						}
						else{
							pD.sendMessage("§fThis player has §c§lDISABLED §6§lstacking§f!");
						}
					}
				}
			}
		}
	}
}
