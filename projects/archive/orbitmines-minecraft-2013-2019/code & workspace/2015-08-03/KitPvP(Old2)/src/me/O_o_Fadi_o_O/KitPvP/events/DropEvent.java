package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropEvent implements Listener{
	
	Start plugin;
	 
	public DropEvent(Start instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
	
	final Player p = e.getPlayer();
	final Item i = e.getItemDrop();
	final ItemStack c = i.getItemStack();
	
	if(p.getWorld().getName().equals("KitPvPLobby")){
		try{
			if(c.getType() == Material.WRITTEN_BOOK && c.getItemMeta().getDisplayName().equals("§c§nBook of Enchantments")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(0, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(0, c);
						p.updateInventory();
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
						p.updateInventory();
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
						p.updateInventory();
					} 
				}, 1L);
			}
			if(c.getType() == Material.GOLD_NUGGET && c.getItemMeta().getDisplayName().equals("§a§nBoosters")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(5, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(5, c);
						p.updateInventory();
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
						p.updateInventory();
					} 
				}, 1L);
			}
			if(c.getType() == Material.DIAMOND_CHESTPLATE && c.getItemMeta().getDisplayName().equals("§b§nKit Selector")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(8, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(8, c);
						p.updateInventory();
					} 
				}, 1L);
			}
				
			}catch(Exception ex){}
		}
		else{
			e.setCancelled(true);
			p.updateInventory();
		}
	p.updateInventory();
	}
}
