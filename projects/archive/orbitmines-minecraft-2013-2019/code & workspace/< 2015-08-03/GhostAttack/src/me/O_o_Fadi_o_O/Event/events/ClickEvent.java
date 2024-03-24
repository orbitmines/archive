package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.managers.Manager;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		HumanEntity h = e.getWhoClicked();
		
		if(h instanceof Player){
			Player p = (Player) h;
			if(Manager.Spectators.contains(p)){
				e.setCancelled(true);
			}
		}
	}
}
