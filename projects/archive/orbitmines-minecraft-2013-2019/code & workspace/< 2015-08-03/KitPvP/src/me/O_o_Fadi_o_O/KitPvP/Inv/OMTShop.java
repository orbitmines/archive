package me.O_o_Fadi_o_O.KitPvP.Inv;

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
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, 2);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+200 Coins");
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
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, 10);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+1000 Coins");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e4 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(12, item);
		}
		
		{
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, 25);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+2500 Coins");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e9 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(14, item);
		}
		
		{
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, 50);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§l+5000 Coins");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e16 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(16, item);
		}
		
		return inv;
	}
}
