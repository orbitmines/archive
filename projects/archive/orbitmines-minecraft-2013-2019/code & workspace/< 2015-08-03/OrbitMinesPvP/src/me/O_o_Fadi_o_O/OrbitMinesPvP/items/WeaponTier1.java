package me.O_o_Fadi_o_O.OrbitMinesPvP.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponTier1 {
	
	public static void giveWeaponTier1(Player p){
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§bWeapon §8|| §9+1 Attack Damage");
		List<String> l = new ArrayList<String>();
		l.add("§7§oTier 1");
		swordmeta.setLore(l);
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack((sword)));
	}
}
