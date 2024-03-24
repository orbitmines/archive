package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

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

	Hub hub = Hub.getInstance();
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		
		Item item = e.getItem();
		ItemStack i = item.getItemStack();
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
			e.setCancelled(true);
		}
		
		if(i.getType() == Material.PAPER){

			if(i.getItemMeta() != null && i.getItemMeta().getDisplayName() != null && i.getItemMeta().getDisplayName().startsWith("Paper ")){
				
				if(!StorageManager.playersinlapisparkour.contains(p)){
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.JUMP);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 4));
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 5, 4));
					
					item.remove();
				}
			}
		}
	}
}
