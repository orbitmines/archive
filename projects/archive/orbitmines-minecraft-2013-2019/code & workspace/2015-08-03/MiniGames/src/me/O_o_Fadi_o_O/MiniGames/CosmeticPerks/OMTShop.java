package me.O_o_Fadi_o_O.MiniGames.CosmeticPerks;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.CustomItem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OMTShop {

	public static Inventory getOMTShop(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lOMT Shop");
		
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7WorldEdit Command: §d§l//set");
			List<String> lore = new ArrayList<String>();
			//if(!PlotManager.hasWorldEditAccess(p, "//set")){
				lore.add("");
				lore.add("§c§oPrice: §e100 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item = CustomItem.hideFlags(item, 2);
			//}
			//else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 3);
			//}
			//inv.setItem(10, item);
		}
		
		return inv;
	}
}
