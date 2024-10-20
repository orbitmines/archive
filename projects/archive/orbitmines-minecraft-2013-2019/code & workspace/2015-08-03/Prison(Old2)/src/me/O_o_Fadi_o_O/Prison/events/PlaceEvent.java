package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
	
	Start plugin;
	 
	public PlaceEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		final Player p = e.getPlayer();
		final Block b = e.getBlockPlaced();
		if(PlayerManager.isLoaded(p)){
			if(!PlayerManager.isInOPMode(p)){
				if(b.getType() == Material.CHEST){
					try{
						if(p.getItemInHand().getType() != Material.AIR  && p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("�cRare Chest")){
							for(final Rank rank : PlayerManager.getAllRanksPassed(p)){
								if(!StorageManager.RankMines.get(rank).contains(b)){
									
									StorageManager.rareChests.add(b);
									StorageManager.rareChestPlayer.put(b, p);
									StorageManager.rareChestIsOpened.put(b, false);
								}
								else{
									e.setCancelled(true);
									p.sendMessage(Start.TAG + "You can't place a �cRare Chest�7 in a �a�lMine�7!");
								}
							}
						}
						else{
							e.setCancelled(true);
						}
					}catch(Exception ex){e.setCancelled(true); p.sendMessage(Start.TAG + "�4�lERROR �7Try Again!");}
				}
				else{
					e.setCancelled(true);
				}
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}
	}

}
