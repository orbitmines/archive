package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.Inv.OMTShop;
import me.O_o_Fadi_o_O.KitPvP.Inv.ServerSelector;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	Start start = Start.getInstance();
	
	private KitSelector kitselector = new KitSelector();
	
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		if(StorageManager.petentity.containsValue(en)){
			e.setCancelled(true);
		}
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.kitselectornpc == en){

				p.sendMessage(Start.TAG + "Opening the §bKit Selector§7...");
				p.openInventory(kitselector.getKitSelector(p));
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(StorageManager.spectatenpc == en){

				if(StorageManager.petentity.containsKey(p)){
					PlayerManager.removePet(p, "§7Pet");
				}
				if(PlayerManager.hasTrailEnabled(p)){
					PlayerManager.removeTrail(p);
				}
					
				StorageManager.spectators.add(p);
				Start.RandomSpawn(p);
					
				p.closeInventory();
				e.setCancelled(true);
				p.updateInventory();
			}
			if(StorageManager.serverselector == en){
				p.openInventory(ServerSelector.serverSelector);
				
				e.setCancelled(true);
				p.updateInventory();
			}
			if(StorageManager.omtnpc == en){
				p.openInventory(OMTShop.getOMTShop(p));
				
				e.setCancelled(true);
				p.updateInventory();
			}
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
