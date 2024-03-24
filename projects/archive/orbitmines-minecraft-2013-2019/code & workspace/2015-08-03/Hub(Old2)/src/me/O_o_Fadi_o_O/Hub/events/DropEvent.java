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
			if(c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§4§lReset Colors")){
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
			if(c.getType() == Material.REDSTONE_TORCH_ON && c.getItemMeta().getDisplayName().equals("§c§lEnd Turn")){
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
			if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().equals("§e§lYellow")){
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
			if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().equals("§a§lGreen")){
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
			if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().equals("§c§lRed")){
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
			if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().equals("§b§lLight Blue")){
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
			if(c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().equals("§6§lOrange")){
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
			if(c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().equals("§8§nInk Bomb")
			|| c.getType() == Material.WEB && c.getItemMeta().getDisplayName().equals("§f§nWebs")
			|| c.getType() == Material.HUGE_MUSHROOM_1 && c.getItemMeta().getDisplayName().equals("§4§nShroom Trail§7 (§c§lDISABLED§7)") || c.getType() == Material.HUGE_MUSHROOM_2 && c.getItemMeta().getDisplayName().equals("§4§nShroom Trail§7 (§a§lENABLED§7)")
			|| c.getType() == Material.FIREBALL && c.getItemMeta().getDisplayName().equals("§6§nFireball")
			|| c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§d§nBaby Pigs§7 (§c§lDISABLED§7)") || c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§d§nBaby Pigs§7 (§a§lENABLED§7)")
			|| c.getType() == Material.LEATHER_BOOTS && c.getItemMeta().getDisplayName().equals("§6§nSuper Jump")
			|| c.getType() == Material.COOKED_BEEF && c.getItemMeta().getDisplayName().equals("§6§nBark")
			|| c.getType() == Material.MILK_BUCKET && c.getItemMeta().getDisplayName().equals("§f§nMilk Explosion")
			|| c.getType() == Material.WOOL && c.getItemMeta().getDisplayName().startsWith("§f§nSheep Disco")
			|| c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§7§nSilverfish Bomb")
			|| c.getType() == Material.FEATHER && c.getItemMeta().getDisplayName().equals("§f§nChange Speed")
			|| c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().equals("§e§nKitty Cannon")
			|| c.getType() == Material.TNT && c.getItemMeta().getDisplayName().equals("§c§nExplode")
			|| c.getType() == Material.EGG && c.getItemMeta().getDisplayName().equals("§7§nEgg Bomb")
			){
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
			if(c.getType() == Material.WATER_BUCKET && c.getItemMeta().getDisplayName().equals("§9§nWater Spout")
			|| c.getType() == Material.SPIDER_EYE && c.getItemMeta().getDisplayName().equals("§5§nSpider Launcher")
			|| c.getType() == Material.FIREWORK && c.getItemMeta().getDisplayName().equals("§c§nBaby Firework")
			|| c.getType() == Material.MAGMA_CREAM && c.getItemMeta().getDisplayName().equals("§c§nChange Size")
			|| c.getType() == Material.PORK && c.getItemMeta().getDisplayName().equals("§d§nChange Age")
			|| c.getType() == Material.SLIME_BALL && c.getItemMeta().getDisplayName().equals("§a§nChange Size")
			|| c.getType() == Material.BONE && c.getItemMeta().getDisplayName().equals("§7§nChange Age")
			|| c.getType() == Material.RAW_BEEF && c.getItemMeta().getDisplayName().equals("§c§nChange Age")
			|| c.getType() == Material.INK_SACK && c.getItemMeta().getDisplayName().startsWith("§f§nChange Color")
			|| c.getType() == Material.STONE_HOE && c.getItemMeta().getDisplayName().equals("§8§nLeap")
			|| c.getType() == Material.LEATHER && c.getItemMeta().getDisplayName().equals("§e§nChange Color")
			|| c.getType() == Material.RAW_FISH && c.getItemMeta().getDisplayName().equals("§9§nChange Color")
			|| c.getType() == Material.MONSTER_EGG && c.getItemMeta().getDisplayName().startsWith("§a§nChange Type")
			|| c.getType() == Material.RAW_CHICKEN && c.getItemMeta().getDisplayName().startsWith("§c§nChange Age")
			){
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
