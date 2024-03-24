package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class BowShot implements Listener{
	
	@EventHandler
	public void onBowShot(EntityShootBowEvent e){
		
		if(e.getEntity() instanceof Player){
			
			Player p = (Player) e.getEntity();
			ItemStack h = p.getItemInHand();
			
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getLore().contains("§7Lightning I")){
					StorageManager.arrow.add((Projectile) e.getProjectile());
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getLore().contains("§7Undeath I")){
					StorageManager.necromancerarrowlvl1.add((Projectile) e.getProjectile());
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getLore().contains("§7Undeath II")){
					StorageManager.necromancerarrowlvl2.add((Projectile) e.getProjectile());
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getLore().contains("§7Explode I")){
					StorageManager.tntlvl2.add((Projectile) e.getProjectile());
				}
			}
			catch(NullPointerException exception){
				
			}
			try{
				if(h != null && h.getType() == Material.BOW && h.getItemMeta().getLore().contains("§7Arrow Split I")){
					if(e.getProjectile() instanceof Arrow){
						Vector velocity = e.getProjectile().getVelocity();
						double speed = velocity.length();
						Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
						// you can tune the following value for different spray. Higher number means less spray.
						double spray = 3.5D;
						 
						for (int i = 0; i < 4; i++) {
						  Arrow arrow = p.launchProjectile(Arrow.class);
						  arrow.setVelocity(new Vector(direction.getX() + (Math.random() - 0.5) / spray, direction.getY() + (Math.random() - 0.5) / spray, direction.getZ() + (Math.random() - 0.5) / spray).normalize().multiply(speed));
						}
					}
				}
			}
			catch(NullPointerException exception){
				
			}
		}
	}
}
