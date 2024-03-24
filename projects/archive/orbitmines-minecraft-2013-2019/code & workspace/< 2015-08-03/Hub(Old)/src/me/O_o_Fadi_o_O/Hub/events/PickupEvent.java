package me.O_o_Fadi_o_O.Hub.events;

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

public class PickupEvent implements Listener{

	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		
		Item item = e.getItem();
		ItemStack i = item.getItemStack();
		Player p = e.getPlayer();
		
		if(!p.getWorld().getName().equals("TestWorld")){
			e.setCancelled(true);
		}
		
		if(i.getType() == Material.PAPER){
		
			try{
				
				if(i.getItemMeta().getDisplayName().startsWith("Paper ")){
					
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
	}
}
