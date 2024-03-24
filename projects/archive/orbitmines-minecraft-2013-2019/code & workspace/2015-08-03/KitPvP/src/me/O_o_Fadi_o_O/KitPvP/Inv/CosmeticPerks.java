package me.O_o_Fadi_o_O.KitPvP.Inv;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CosmeticPerks {

	public static Inventory getCosmeticPerks(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 36, "§0§lCosmetic Perks");
		
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Pets");
			item.setDurability((short) 95);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4ChatColors");
			item.setDurability((short) 1);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Disguises §8| §c§lDISABLED");
			item.setDurability((short) 2);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.COMPASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bGadgets §8| §c§lDISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§1Wardrobe §8| §c§lDISABLED");
			itemmeta.setColor(Color.fromBGR(204, 100, 2));
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.STRING, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fTrails");
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
		}
		{
			ItemStack item = new ItemStack(Material.PUMPKIN, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Hats §8| §c§lDISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
		}
		{
			ItemStack item = new ItemStack(Material.FIREWORK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cFireworks §8| §c§lDISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(25, item);
		}
		
		return inv;
	}
}
