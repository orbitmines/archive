package me.O_o_Fadi_o_O.YoutubeProject.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
	
		HumanEntity en = e.getWhoClicked();
		
		if(en instanceof Player){
			
			Player p = (Player) en;
			ItemStack item = e.getCurrentItem();
			
			if(e.getInventory().getName().equals("§0§lWarper")){
				
				e.setCancelled(true);
				
				if(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null){
				
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().equals("§aTeleport naar de §6§lSpawn§a.")){
						
						World w = Bukkit.getWorld("world");
						Location l = w.getSpawnLocation();
						
						p.sendMessage("§9Warpen naar de §6§lSpawn§9...");
						p.teleport(l);
						
					}
					if(item.getType() == Material.STAINED_GLASS_PANE && item.getItemMeta().getDisplayName().equals("§aTeleport naar de §c§lNether§a.")){
						
						World w = Bukkit.getWorld("world_nether");
						Location l = new Location(w, 4.5, 44, -32.5, 128, 0);
						
						p.sendMessage("§9Warpen naar de §c§lNether§9...");
						p.teleport(l);
						
					}
				}
			}
		}
	}
}
