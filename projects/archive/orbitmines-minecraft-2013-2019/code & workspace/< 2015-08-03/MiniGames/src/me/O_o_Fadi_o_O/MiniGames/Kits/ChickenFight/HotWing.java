package me.O_o_Fadi_o_O.MiniGames.Kits.ChickenFight;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HotWing {
	
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
		item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		p.getInventory().setItem(0, item);
		
		p.updateInventory();
		
	}
}
