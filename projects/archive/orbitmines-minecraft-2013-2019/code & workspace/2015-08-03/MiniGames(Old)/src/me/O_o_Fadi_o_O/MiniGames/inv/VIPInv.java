package me.O_o_Fadi_o_O.MiniGames.inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VIPInv {

	public static Inventory getVIPInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 36, "§0§lGame Effects");
		
		{
			ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§l§o+100% Coins Booster");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b1 VIP Point");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.SNOW_BALL, 2);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§l§o+200% Coins Booster");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oRequired: §a§lEmerald VIP");
			lore.add("");
			lore.add("§c§oPrice: §b1 VIP Point");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.POTION, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§l§oSpeed 4");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b1 VIP Point");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8§l§oBlindness");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b1 VIP Point");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7§l§oJump Boost 5");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §b1 VIP Point");
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			inv.setItem(17, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§b§lYour VIP Points: " + Start.points.get(p.getName()));
			item.setItemMeta(itemmeta);
			inv.setItem(31, item);
		}
		return inv;
	}
}
