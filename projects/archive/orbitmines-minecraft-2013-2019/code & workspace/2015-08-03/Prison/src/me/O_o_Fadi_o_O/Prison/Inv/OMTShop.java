package me.O_o_Fadi_o_O.Prison.Inv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OMTShop {

	public static Inventory getOMTShop(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lOMT Shop");
		
		{
			ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7§l+32 Cobblestone");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e1 OrbitMines Token");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(10, item);
		}
		
		{
			ItemStack item = new ItemStack(Material.SAPLING, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§2§l+1 Oak Sapling");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e5 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(12, item);
		}
		
		{
			ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+1 Lava Bucket");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e20 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(14, item);
		}
		
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§e§l+1 Horse Egg");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e100 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			item.setDurability((short) 100);
			inv.setItem(16, item);
		}
		
		return inv;
	}
}
