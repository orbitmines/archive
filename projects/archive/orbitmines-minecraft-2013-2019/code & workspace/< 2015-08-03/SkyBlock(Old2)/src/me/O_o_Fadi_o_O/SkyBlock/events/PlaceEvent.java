package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener{
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		
		if(!p.isOp()){
			if(p.getWorld().getName().equals("SkyBlock")){
				if(PlayerManager.hasIsland(p)){
					if(!PlayerManager.isOnOwnIsland(p)){
						e.setCancelled(true);
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dIsland§7!");
					}
				}
				else{
					e.setCancelled(true);
				}
			}
		}
	}
}
