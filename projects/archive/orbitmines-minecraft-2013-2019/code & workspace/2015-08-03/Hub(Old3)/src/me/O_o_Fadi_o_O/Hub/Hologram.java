package me.O_o_Fadi_o_O.Hub;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class Hologram {

	Hub hub = Hub.getInstance();
	
	public void createHologram(Location l, String name) {
		
		final ArmorStand as1 = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() -1.25, l.getZ()), EntityType.ARMOR_STAND);
		as1.setCustomName(name);
		as1.setCustomNameVisible(true);
		as1.setGravity(false);
		as1.setVisible(false);
		
		StorageManager.armorstands.add(as1);
	}
}
