package me.O_o_Fadi_o_O.Creative.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Creative.CustomItem;
import me.O_o_Fadi_o_O.Creative.managers.PlotManager;

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
			if(!PlotManager.hasWorldEditAccess(p, "//set")){
				lore.add("");
				lore.add("§c§oPrice: §e100 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item = CustomItem.hideFlags(item, 2);
			}
			else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 3);
			}
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE, 2);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7WorldEdit Command: §d§l//walls");
			List<String> lore = new ArrayList<String>();
			if(!PlotManager.hasWorldEditAccess(p, "//walls")){
				lore.add("");
				lore.add("§c§oPrice: §e75 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item = CustomItem.hideFlags(item, 2);
			}
			else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 3);
			}
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE, 3);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7WorldEdit Command: §d§l//line");
			List<String> lore = new ArrayList<String>();
			if(!PlotManager.hasWorldEditAccess(p, "//line")){
				lore.add("");
				lore.add("§c§oPrice: §e50 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item = CustomItem.hideFlags(item, 2);
			}
			else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 3);
			}
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE, 4);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7WorldEdit Command: §d§l//replace");
			List<String> lore = new ArrayList<String>();
			if(!PlotManager.hasWorldEditAccess(p, "//replace")){
				lore.add("");
				lore.add("§c§oPrice: §e200 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item = CustomItem.hideFlags(item, 2);
			}
			else{
				lore.add("");
				lore.add("§a§lUnlocked");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				item = CustomItem.hideFlags(item, 3);
			}
			inv.setItem(16, item);
		}
		
		return inv;
	}
}
