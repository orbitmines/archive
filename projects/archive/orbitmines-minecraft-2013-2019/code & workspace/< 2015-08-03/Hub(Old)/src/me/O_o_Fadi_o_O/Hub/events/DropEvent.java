package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropEvent implements Listener{
	
	Hub plugin;
	 
	public DropEvent(Hub instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
	
	final Player p = e.getPlayer();
	final Item i = e.getItemDrop();
	final ItemStack c = i.getItemStack();
		try{
			if(c.getType() == Material.WRITTEN_BOOK && c.getItemMeta().getDisplayName().equals("§4§nServer Rules")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(0, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(0, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.EXP_BOTTLE && c.getItemMeta().getDisplayName().equals("§d§nAchievements")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(1, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(1, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.REDSTONE_TORCH_ON && c.getItemMeta().getDisplayName().equals("§c§nSettings")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(3, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(3, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§nServer Selector")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(4, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(4, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.LEASH && c.getItemMeta().getDisplayName().equals("§6§nStacker")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§f§nPaintballs")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SADDLE && c.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.BOOK && c.getItemMeta().getDisplayName().equals("§7§nBook Explosion")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.FIREBALL && c.getItemMeta().getDisplayName().startsWith("§c§nFirework Gun")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.EYE_OF_ENDER && c.getItemMeta().getDisplayName().equals("§2§nSwap Teleporter")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§nMagmaCube Soccer")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.ENDER_CHEST && c.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(7, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(7, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§nFly")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(8, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(8, c);
				
					} 
				}, 1L);
			}
			
		}catch(Exception ex){
			
		}
	}
}
