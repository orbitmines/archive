package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.KitPvPServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.ProjectileType;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ShootBowEvent implements Listener {
	
	@EventHandler
	public void onShot(EntityShootBowEvent e){
		Entity en = e.getEntity();
		
		if(en instanceof Player){
			Player p = (Player) en;
			ItemStack item = p.getItemInHand();
			
			if(ServerData.isServer(Server.KITPVP) && item != null && item.getType() == Material.BOW && item.getItemMeta() != null && item.getItemMeta().getLore() != null){
				KitPvPServer kitpvp = ServerData.getKitPvP();
				List<String> itemlore = item.getItemMeta().getLore();
				
				if(itemlore.contains(ProjectileType.LIGHTNING_I.getName())){
					kitpvp.addProjectile((Projectile) e.getProjectile(), ProjectileType.LIGHTNING_I);
				}
				else if(itemlore.contains(ProjectileType.UNDEATH_I.getName())){
					kitpvp.addProjectile((Projectile) e.getProjectile(), ProjectileType.UNDEATH_I);
				}
				if(itemlore.contains(ProjectileType.UNDEATH_II.getName())){
					kitpvp.addProjectile((Projectile) e.getProjectile(), ProjectileType.UNDEATH_II);
				}
				if(itemlore.contains(ProjectileType.EXPLOSIVE_I.getName())){
					kitpvp.addProjectile((Projectile) e.getProjectile(), ProjectileType.EXPLOSIVE_I);
				}
				if(itemlore.contains(ProjectileType.ARROW_SPLIT_I.getName())){
					if(e.getProjectile() instanceof Arrow){
						Vector velocity = e.getProjectile().getVelocity();
						double speed = velocity.length();
						Vector direction = new Vector(velocity.getX() / speed, velocity.getY() / speed, velocity.getZ() / speed);
						double spray = 3.5D;
						 
						for(int i = 0; i < 4; i++){
							Arrow arrow = p.launchProjectile(Arrow.class);
							arrow.setVelocity(new Vector(direction.getX() + (Math.random() - 0.5) / spray, direction.getY() + (Math.random() - 0.5) / spray, direction.getZ() + (Math.random() - 0.5) / spray).normalize().multiply(speed));
						}
					}
				}
			}
		}
	}
}
