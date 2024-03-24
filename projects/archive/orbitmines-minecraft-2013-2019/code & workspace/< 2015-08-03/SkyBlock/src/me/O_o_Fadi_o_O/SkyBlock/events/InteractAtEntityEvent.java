package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractAtEntityEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.armorstands.contains(e.getRightClicked())){
			e.setCancelled(true);
		}
		if(p.getWorld().getName().equals(StorageManager.skyblockworld.getName())){
			if(PlayerManager.hasIsland(p)){
				if(!PlayerManager.isOnOwnIsland(p, e.getRightClicked().getLocation())){
					e.setCancelled(true);
					p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dPlot§7!");
				}
			}
			else{
				e.setCancelled(true);
			}
		}
	}
}
