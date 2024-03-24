package me.O_o_Fadi_o_O.Event.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Event.managers.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		if(Manager.Spectators.contains(p)){
			e.setCancelled(true);
		}
		
		Action a = e.getAction();
		ItemStack item = e.getItem();
		
		if(item != null){
			try{
				if(Manager.Spectators.contains(p)){
					
					if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
						if(item.getType() == Material.COMPASS){
							
							List<Player> list = new ArrayList<Player>();
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(Manager.Players.contains(player)){
									list.add(player);
								}
							}
							
							Random r = new Random();
							
							p.teleport(list.get(r.nextInt(list.size())));
							
						}
					}
					
				}
				
			}catch(Exception ex){
				
			}
		}
	}
}
