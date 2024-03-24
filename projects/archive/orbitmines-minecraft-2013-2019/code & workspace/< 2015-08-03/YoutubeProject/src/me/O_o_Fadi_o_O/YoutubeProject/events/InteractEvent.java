package me.O_o_Fadi_o_O.YoutubeProject.events;

import me.O_o_Fadi_o_O.YoutubeProject.invs.WarperInv;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener{

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		ItemStack item = p.getItemInHand();
		
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			
			if(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
				
				if(item.getType() == Material.COMPASS && item.getItemMeta().getDisplayName().equals("§9Warper")){
					
					p.openInventory(WarperInv.getWarperInv(p));
					p.sendMessage("§9De Warper Inventory openen...");
					
				}
			}
		}
	}
}