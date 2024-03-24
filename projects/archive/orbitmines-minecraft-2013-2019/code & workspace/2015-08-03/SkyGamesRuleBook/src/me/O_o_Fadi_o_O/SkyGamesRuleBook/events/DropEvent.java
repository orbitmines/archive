package me.O_o_Fadi_o_O.SkyGamesRuleBook.events;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.Start;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class DropEvent implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		final Player p = e.getPlayer();
		ItemStack item = e.getItemDrop().getItemStack();
		
		if(item != null && item.getType() == Material.WRITTEN_BOOK && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals(Start.getInstance().getRuleBook().getDisplayName().replace("&", "§"))){
			e.setCancelled(true);
			
			new BukkitRunnable(){
				public void run(){
					p.updateInventory();
				}
			}.runTaskLater(Start.getInstance(), 1);
		}
	}
}
