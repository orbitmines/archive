package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.Inv.OMTShop;
import me.O_o_Fadi_o_O.Creative.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityInteractEvent implements Listener{
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		ItemStack item = p.getItemInHand();
		
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					if(!(en instanceof Player)){
						e.setCancelled(!PlayerManager.isOnOwnPlot(p, en.getLocation()));
					}
				}
			}
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
				if(en == StorageManager.serverselector){
					p.openInventory(ServerSelector.serverSelector);
				}
				if(en == StorageManager.omtnpc){
					p.openInventory(OMTShop.getOMTShop(p));
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

		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
		p.updateInventory();
	}
}
