package me.O_o_Fadi_o_O.Survival.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OMT {

	public Inventory getOMTInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 27, "§0§lOrbitMines Tokens");
		
		{
			ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§nYour OMT:§6 " + Start.omt.get(p.getName()));
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("§eVote for more OMT!");
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eVote at §6www.orbitmines.com");
			item.setDurability((short) 4);
			item.setItemMeta(itemmeta);
			inv.setItem(0, item);
			inv.setItem(1, item);
			inv.setItem(2, item);
			inv.setItem(3, item);
			inv.setItem(4, item);
			inv.setItem(5, item);
			inv.setItem(6, item);
			inv.setItem(7, item);
			inv.setItem(8, item);
			inv.setItem(9, item);
			inv.setItem(10, item);
			inv.setItem(11, item);
			inv.setItem(12, item);
			inv.setItem(14, item);
			inv.setItem(15, item);
			inv.setItem(16, item);
			inv.setItem(17, item);
			inv.setItem(18, item);
			inv.setItem(19, item);
			inv.setItem(20, item);
			inv.setItem(21, item);
			inv.setItem(22, item);
			inv.setItem(23, item);
			inv.setItem(24, item);
			inv.setItem(25, item);
			inv.setItem(26, item);
		}
		
		return inv;
	}
}
