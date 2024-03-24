package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.Location;
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
		
		ItemStack item = p.getItemInHand();
		Action a = e.getAction();
		
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					if(!StorageManager.playerspvpplot.containsKey(p)){
						Location l = null;
						if(item != null && item.getType() != null && item.getType() == Material.WATER_BUCKET || item != null && item.getType() != null && item.getType() == Material.LAVA_BUCKET){
							if(a == Action.RIGHT_CLICK_BLOCK){
								l = e.getClickedBlock().getLocation();
							}
							else if(a == Action.LEFT_CLICK_BLOCK){
								l = e.getClickedBlock().getLocation();
							}
							else if(a == Action.PHYSICAL){
								l = e.getClickedBlock().getLocation();
							}
							else{
								l = p.getLocation();
							}
						}
						else if(item != null && item.getType() != null && item.getType() == Material.EXPLOSIVE_MINECART){
							e.setCancelled(true);
							p.updateInventory();
						}
						else{
							l = p.getLocation();
						}
						
						if(l != null){
							e.setCancelled(!PlayerManager.isOnOwnPlot(p, l));
						}
					}
				}
			}
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
			}
			if(item != null && item.getType() != null && item.getType() == Material.MONSTER_EGG){
				e.setCancelled(true);
				p.updateInventory();
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}
}
