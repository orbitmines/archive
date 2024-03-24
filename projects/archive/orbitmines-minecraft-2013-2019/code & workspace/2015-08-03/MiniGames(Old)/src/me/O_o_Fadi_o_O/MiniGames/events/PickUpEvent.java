package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.utils.State;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PickUpEvent implements Listener{
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		
		Player p = e.getPlayer();
		
		Item item = e.getItem();
		ItemStack i = item.getItemStack();
		
		if(i.getType() == Material.PAPER){
			
			try{
				
				if(i.getItemMeta().getDisplayName().startsWith("Paper ")){
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.JUMP);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 4));
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 5, 4));
					
					item.remove();
				}
				
			}catch(Exception ex){
				
			}
		}
		
		if(!p.isOp()){
			e.setCancelled(true);
		}
		else{
			if(Start.state != State.LOBBY){
				e.setCancelled(true);
			}
		}
	}
}
