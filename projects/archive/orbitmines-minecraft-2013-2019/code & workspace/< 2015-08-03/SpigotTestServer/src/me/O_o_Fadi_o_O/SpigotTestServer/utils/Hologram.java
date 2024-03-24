package me.O_o_Fadi_o_O.SpigotTestServer.utils;

import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class Hologram {
	
	public static void createHologram(Location l, String name){
		
		final ArmorStand as1 = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() -1.25, l.getZ()), EntityType.ARMOR_STAND);
		as1.setCustomName(name);
		as1.setCustomNameVisible(true);
		as1.setGravity(false);
		as1.setVisible(false);
		
		StorageManager.armorstands.add(as1);
	}
	
	public static void createItemHologram(Location l, String name){
		
		final ArmorStand as1 = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ()), EntityType.ARMOR_STAND);
		as1.setGravity(false);
		as1.setVisible(false);
		
		Item item = as1.getWorld().dropItem(l, new ItemStack(Material.PAPER, 1));
		item.setPickupDelay(Integer.MAX_VALUE);
		item.setCustomName(name);
		item.setCustomNameVisible(true);
		as1.setPassenger(item);
		
		StorageManager.armorstands.add(as1);
	}
}
