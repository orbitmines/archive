package me.O_o_Fadi_o_O.SkyGamesRuleBook.events;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.Start;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ClickEvent implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			final Player p = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			
			if(item != null && item.getType() == Material.WRITTEN_BOOK && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals(Start.getInstance().getRuleBook().getDisplayName().replace("&", "§"))){
				e.setResult(Result.DENY);
				
				new BukkitRunnable(){
					public void run(){
						p.updateInventory();
					}
				}.runTaskLater(Start.getInstance(), 1);
			}
		}
	}
}
