package me.O_o_Fadi_o_O.KitPvP.events;

import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityDamage implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		Entity en = e.getEntity();
		
		if(StorageManager.petentity.containsValue(en) || StorageManager.kitselectornpc == en || StorageManager.spectatenpc == en || StorageManager.serverselector == en){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(!StorageManager.kitselected.containsKey(p)){
				e.setCancelled(true);
			}
			else{
				if(!e.isCancelled()){
					spawnBodyParts(p.getLocation());
				}
			}
		}
	}
	
	public void spawnBodyParts(Location l){
		for(int i1 = 0; i1 <= 2; i1++){
			int upper1 = 5;
			Random random1 = new Random();
			random1.nextInt((upper1));
			int upper2 = 4;
			Random random2 = new Random();
			random2.nextInt((upper2));
			int upper3 = 6;
			Random random3 = new Random();
			random3.nextInt((upper3));
			
			ItemStack toDrop = new ItemStack(Material.INK_SACK);
			ItemMeta meta = toDrop.getItemMeta();
			meta.setDisplayName("Blood " + i1);
			toDrop.setItemMeta(meta);
			toDrop.setDurability((short) 1);
			
			int upper4 = 2;
			Random random4 = new Random();
			random4.nextInt(upper4);
			
			if(random4.nextInt(upper4) == 1){
				final Item item = l.getWorld().dropItem(l.add(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 50L);
			}
			if(random4.nextInt(upper4) == 2){
				final Item item = l.getWorld().dropItem(l.subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 50L);
			}
		}
	}
}
