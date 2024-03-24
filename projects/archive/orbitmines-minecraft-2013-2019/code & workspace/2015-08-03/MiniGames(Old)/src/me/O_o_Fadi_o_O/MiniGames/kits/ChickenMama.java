package me.O_o_Fadi_o_O.MiniGames.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChickenMama {

	@SuppressWarnings("deprecation")
	public static void giveInventory(Player p){
		
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		ItemStack item = new ItemStack(Material.FEATHER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§lFeather");
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(0, item);
		
		p.updateInventory();
		
	}
}
