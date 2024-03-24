package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

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
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		
		final Player p = e.getPlayer();
		final Item i = e.getItemDrop();
		final ItemStack c = i.getItemStack();
		
		if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
			e.setCancelled(true);
		}
		try{
			if(c != null){
				if(c.getType() == Material.ENDER_PEARL && c.getItemMeta().getDisplayName().equals("§3§nBack to the Lobby") || c.getItemMeta().getDisplayName().equals("§3§nBack to the Hub")){
					e.setCancelled(true);
					p.getInventory().removeItem(c);
					if(StorageManager.PlayersGame.containsKey(p)){
						p.getInventory().setItem(4, c);
					}
					else{
						p.getInventory().setItem(2, c);
					}
				
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
						public void run(){
							p.getInventory().removeItem(c);
							if(StorageManager.PlayersGame.containsKey(p)){
								p.getInventory().setItem(4, c);
							}
							else{
								p.getInventory().setItem(2, c);
							}
					
						} 
					}, 1L);
				}
			}
			if(c != null){
				if(c.getType() == Material.NAME_TAG && c.getItemMeta().getDisplayName().equals("§e§nTeleporter")){
					e.setCancelled(true);
					p.getInventory().removeItem(c);
					p.getInventory().setItem(6, c);
				
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
						public void run(){
							p.getInventory().removeItem(c);
							p.getInventory().setItem(6, c);
					
						} 
					}, 1L);
				}
			}
			if(c != null){
				if(c.getType() == Material.ENDER_CHEST && c.getItemMeta().getDisplayName().equals("§9§nCosmetic Perks")){
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
			}
			if(c != null){
				if(c.getType() == Material.EMERALD && c.getItemMeta().getDisplayName().equals("§2§nStats")){
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
			}
			if(c != null){
				if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§f§nMiniGame Selector")){
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
			}
			if(c != null){
				if(c.getType() == Material.POTION && c.getItemMeta().getDisplayName().equals("§b§nGame Effects")){
					e.setCancelled(true);
					p.getInventory().removeItem(c);
					p.getInventory().setItem(2, c);
				
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
						public void run(){
							p.getInventory().removeItem(c);
							p.getInventory().setItem(2, c);
					
						} 
					}, 1L);
				}
			}
			if(c.getType() == Material.LEASH && c.getItemMeta().getDisplayName().equals("§6§nStacker")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SNOW_BALL && c.getItemMeta().getDisplayName().equals("§f§nPaintballs")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SKULL_ITEM && c.getItemMeta().getDisplayName().equals("§a§nCreeper Launcher")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.SADDLE && c.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.BOOK && c.getItemMeta().getDisplayName().equals("§7§nBook Explosion")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.EYE_OF_ENDER && c.getItemMeta().getDisplayName().equals("§2§nSwap Teleporter")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(c.getType() == Material.FIREBALL && c.getItemMeta().getDisplayName().startsWith("§c§nFirework Gun")){
				e.setCancelled(true);
				p.getInventory().removeItem(c);
				p.getInventory().setItem(6, c);
			
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						p.getInventory().removeItem(c);
						p.getInventory().setItem(6, c);
				
					} 
				}, 1L);
			}
			if(!p.isOp()){
				e.setCancelled(true);
			}
			else{
				if(StorageManager.PlayersGame.containsKey(p)){
					if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
						if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p)) != ChickenFightState.LOBBY){
							e.setCancelled(true);
						}
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
}
