package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageEvent implements Listener{
	
	Start plugin;
	 
	public DamageEvent(Start instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		
		if(e.getDamager() instanceof Player){
		
			Player p = (Player) e.getDamager();
			ItemStack h = p.getItemInHand();
			try{
				if(h != null && h.getType() == Material.WOOD_SWORD && h.getItemMeta().getDisplayName().equalsIgnoreCase("§bWeapon §8|| §cLocked")){
				
					e.setCancelled(true);
					p.sendMessage("§7Your §bWeapon§7 is §cLocked§7! You can't use it!");
				
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.WOOD_SWORD && h.getItemMeta().getDisplayName().equalsIgnoreCase("§bWeapon §8|| §9+1 Attack Damage")){
				
					e.setDamage(1D);
					h.setDurability((short) 0);
				
				}
			}
			catch(NullPointerException exception){
				
			}
		}
	}
}
