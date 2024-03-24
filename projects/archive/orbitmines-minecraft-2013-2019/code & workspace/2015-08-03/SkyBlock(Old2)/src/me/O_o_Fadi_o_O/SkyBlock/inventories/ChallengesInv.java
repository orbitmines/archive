package me.O_o_Fadi_o_O.SkyBlock.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChallengesInv {

	public static Inventory getChallengesInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lChallenges");

		{
			ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lGather Challenges");
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.MELON, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lFarm Challenges");
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.BONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lMob Challenges");
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lExpert Challenges");
			List<String> lore = new ArrayList<String>();
			lore.add("§a§oComing Soon...");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
			inv.setItem(16, item);
		}
		
		return inv;
	}
}
