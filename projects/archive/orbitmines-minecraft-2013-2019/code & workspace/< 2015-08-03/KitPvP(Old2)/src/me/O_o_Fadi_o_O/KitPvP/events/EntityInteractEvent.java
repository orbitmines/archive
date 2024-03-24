package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	Start plugin;
	 
	public EntityInteractEvent(Start instance) {
		plugin = instance;
	}
	
	private KitSelector kitselector = new KitSelector(this.plugin);
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		if(StorageManager.ownerpets.containsValue(en.getUniqueId())){
			e.setCancelled(true);
		}
		if(StorageManager.KitSelectorNPCs.contains(en)){
			
			if(PlayerManager.isLoaded(p)){
				p.sendMessage(Start.TAG + "Opening the §bKit Selector§7...");
				p.openInventory(kitselector.getKitSelector(p));
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
			
			e.setCancelled(true);
			p.updateInventory();
		}
		if(StorageManager.SpectateNPCs.contains(en)){
			if(PlayerManager.isLoaded(p)){
				
				if(PlayerManager.isPetActive(p)){
					PlayerManager.removePet(p, "§7Pet");
				}
				if(PlayerManager.hasTrailEnabled(p)){
					PlayerManager.removeTrail(p);
				}
				
				StorageManager.Spectators.add(p);
				Start.RandomSpawn(p);
				
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
			p.closeInventory();
			e.setCancelled(true);
			p.updateInventory();
		}
	}
}
