package me.O_o_Fadi_o_O.SkyBlock.island;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class IslandChest {
	
	public static void setIslandChest(World w, int x, int y, int z){
		
		Block b = w.getBlockAt(x, y, z);
		b.setType(Material.CHEST);
		
		Chest c = (Chest) b.getState();
		
		c.getInventory().setItem(10, new ItemStack(Material.SAPLING, 1));
		
		c.getInventory().setItem(12, new ItemStack(Material.ICE, 1));
		c.getInventory().setItem(13, new ItemStack(Material.LAVA_BUCKET, 1));
		c.getInventory().setItem(14, new ItemStack(Material.ICE, 1));
		
		c.getInventory().setItem(16, new ItemStack(Material.SAPLING, 1));
		
		c.update();
	}
}
