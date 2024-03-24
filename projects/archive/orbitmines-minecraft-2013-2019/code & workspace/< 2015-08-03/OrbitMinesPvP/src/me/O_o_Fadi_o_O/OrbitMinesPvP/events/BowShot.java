package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class BowShot implements Listener{
	
	@EventHandler
	public void onBowShot(EntityShootBowEvent e){
		Start.arrow.add((Projectile) e.getProjectile());
		
		if(e.getEntity() instanceof Player){
			
			Player p = (Player) e.getEntity();
			ItemStack h = p.getItemInHand();
			
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getDisplayName().equalsIgnoreCase("§bRocket Launcher §8|| §cLocked")){
					p.sendMessage("§7Your §bRocket Launcher§7 is §cLocked§7! You can't use it!");
					e.setCancelled(true);
					Start.arrow.remove((Projectile) e.getProjectile());
			}
			}
			catch(NullPointerException exception){
				
			}
			h.setDurability((short) 0);
		}
	}
}
