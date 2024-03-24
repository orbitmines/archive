package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntityEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			
			if(p.getWorld().getName().equals(StorageManager.skyblockworld.getName())){
				if(PlayerManager.hasIsland(p)){
					if(!PlayerManager.isOnOwnIsland(p, e.getEntity().getLocation())){
						e.setCancelled(true);
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dIsland§7!");
					}
				}
				else{
					e.setCancelled(true);
				}
			}
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.loaded.get(p) == true){
					if(StorageManager.opmodeenabled.get(p) == false){
						e.setCancelled(true);
					}
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
					e.setCancelled(true);
				}	
			}
		}
		
		Entity en = e.getDamager();
		
		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
	}
}
