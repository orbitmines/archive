package me.O_o_Fadi_o_O.Survival.events;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.RegionManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInteract(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		
		ItemStack i = e.getItem();
		//final Block b = e.getClickedBlock();
		Action a = e.getAction();
		
		if(i != null && i.getType() != null && p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			if(i.getType() == Material.STONE_HOE){
				e.setCancelled(true);
				return;
			}
		}
		
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
			}
			else{
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
			}
			StorageManager.afk.remove(p);
		}
		if(e.getClickedBlock() != null && a != Action.RIGHT_CLICK_AIR && a != Action.LEFT_CLICK_AIR){
			if(p.getWorld().getName().equals(StorageManager.survivalworld1.getName())){
				if(RegionManager.isBlockInRegion(p, e.getClickedBlock())){
					e.setCancelled(true);
				}
			}
		}
	}
}
