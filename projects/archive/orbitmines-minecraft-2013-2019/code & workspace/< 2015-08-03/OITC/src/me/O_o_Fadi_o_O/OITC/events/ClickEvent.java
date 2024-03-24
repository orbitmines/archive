package me.O_o_Fadi_o_O.OITC.events;

import me.O_o_Fadi_o_O.OITC.Start;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK){
			
			ItemStack hand = p.getItemInHand();
			if(hand != null && hand.getType() == Material.COMPASS){
				
				// TODO REPLACE KICK WITH SEND TO HUB
				p.kickPlayer(Start.TAG + "§7Test Kick. Change this to the Hub Connect.");
				
			}
		}
	}
}
