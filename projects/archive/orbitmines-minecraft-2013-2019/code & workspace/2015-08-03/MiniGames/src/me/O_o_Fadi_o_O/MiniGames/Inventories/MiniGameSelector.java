package me.O_o_Fadi_o_O.MiniGames.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MiniGameSelector {
	
	public static Inventory getMiniGameSelectorInv(Player p, int i){
		
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lMiniGame Selector ");
		
		{
			ItemStack item = new ItemStack(Material.FEATHER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lChicken Fight");
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§lSurvival Games");
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		
		return inv;
	}
}
