package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		if(p.getWorld().getName().equals(StorageManager.skyblockworld.getName())){
			if(PlayerManager.hasIsland(p)){
				if(a != Action.LEFT_CLICK_AIR && a != Action.RIGHT_CLICK_AIR){
					if(!PlayerManager.isOnOwnIsland(p, e.getClickedBlock().getLocation())){
						e.setCancelled(true);
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dIsland§7!");
					}
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
}
