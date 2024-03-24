package me.O_o_Fadi_o_O.Prison.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Hologram;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener{
	
	Hologram hologram = new Hologram();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();
		
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				try{
					if(p.getItemInHand().getType() != Material.AIR  && p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("§cRare Chest")){
						for(final Rank rank : PlayerManager.getAllRanksPassed(p)){
							if(!StorageManager.rankmines.get(rank).contains(b)){
								
								StorageManager.rarechests.add(b);
								StorageManager.rarechestplayer.put(b, p);
								StorageManager.rarechestisopened.put(b, false);
								
								{
									Location l2 = new Location(b.getWorld(), b.getX() + 0.5, b.getY() +0.1, b.getZ() + 0.5);
									List<Entity> holograms = new ArrayList<Entity>();
									holograms.add(hologram.createHologram(l2, "§cRare Chest"));
									StorageManager.rarechestholograms.put(b, holograms);
								}
							}
							else{
								e.setCancelled(true);
								p.sendMessage(Start.TAG + "You can't place a §cRare Chest§7 in a §a§lMine§7!");
							}
						}
					}
					else{
						e.setCancelled(true);
					}
				}catch(Exception ex){e.setCancelled(true); p.sendMessage(Start.TAG + "§4§lERROR §7Try Again!");}
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}	
	}
}
