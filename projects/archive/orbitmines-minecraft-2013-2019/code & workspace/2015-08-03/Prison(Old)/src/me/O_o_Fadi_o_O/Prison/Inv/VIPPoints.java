package me.O_o_Fadi_o_O.Prison.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VIPPoints {

	Start plugin;
	 
	public VIPPoints(Start instance) {
	plugin = instance;
	}
	
	public static Inventory inv = Bukkit.createInventory(null, 27, "§0§lVIP Points");
	
	public Inventory getVIPPointsInv(Player p, int i){
		
		getVIPPoints1(inv, i);	
		getVIPPoints5(inv, i);
		getVIPPoints10(inv, i);
		getVIPPoints25(inv, i);
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§bDonate at §6www.orbitmines.com");
		item.setDurability((short) 3);
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
		inv.setItem(11, item);
		inv.setItem(13, item);
		inv.setItem(15, item);
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
		
		return inv;
	}
	
	public static void getVIPPoints1(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.DIAMOND, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§b§l1000 VIP Points");
		List<String> itemlore = new ArrayList<String>();
		itemlore.add("");
		if(i == 1){
			itemlore.add("§c§oPrice: §63.00 EUR");
		}
		if(i == 2){
			itemlore.add("§c§oPrice: §63.94 USD");
		}
		if(i == 3){
			itemlore.add("§c§oPrice: §64.21 AUD");
		}
		if(i == 4){
			itemlore.add("§c§oPrice: §64.28 CAD");
		}
		if(i == 5){
			itemlore.add("§c§oPrice: §62.37 GBP");
		}
		itemlore.add("");
		itemmeta.setLore(itemlore);
		item.setItemMeta(itemmeta);
		inv.setItem(10, item);
	}
	
	public static void getVIPPoints5(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.DIAMOND, 5);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§b§l5000 VIP Points");
		List<String> itemlore = new ArrayList<String>();
		itemlore.add("");
		if(i == 1){
			itemlore.add("§c§oPrice: §612.50 EUR");
		}
		if(i == 2){
			itemlore.add("§c§oPrice: §616.41 USD");
		}
		if(i == 3){
			itemlore.add("§c§oPrice: §617.58 AUD");
		}
		if(i == 4){
			itemlore.add("§c§oPrice: §617.85 CAD");
		}
		if(i == 5){
			itemlore.add("§c§oPrice: §69.89 GBP");
		}
		itemlore.add("");
		itemmeta.setLore(itemlore);
		item.setItemMeta(itemmeta);
		inv.setItem(12, item);
	}
	
	public static void getVIPPoints10(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.DIAMOND, 10);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§b§l10000 VIP Points");
		List<String> itemlore = new ArrayList<String>();
		itemlore.add("");
		if(i == 1){
			itemlore.add("§c§oPrice: §620.00 EUR");
		}
		if(i == 2){
			itemlore.add("§c§oPrice: §626.26 USD");
		}
		if(i == 3){
			itemlore.add("§c§oPrice: §628.12 AUD");
		}
		if(i == 4){
			itemlore.add("§c§oPrice: §628.56 CAD");
		}
		if(i == 5){
			itemlore.add("§c§oPrice: §615.82 GBP");
		}
		itemlore.add("");
		itemmeta.setLore(itemlore);
		item.setItemMeta(itemmeta);
		inv.setItem(14, item);
	}
	
	public static void getVIPPoints25(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.DIAMOND, 25);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§b§l25000 VIP Points");
		List<String> itemlore = new ArrayList<String>();
		itemlore.add("");
		if(i == 1){
			itemlore.add("§c§oPrice: §635.00 EUR");
		}
		if(i == 2){
			itemlore.add("§c§oPrice: §645.96 USD");
		}
		if(i == 3){
			itemlore.add("§c§oPrice: §649.22 AUD");
		}
		if(i == 4){
			itemlore.add("§c§oPrice: §649.98 CAD");
		}
		if(i == 5){
			itemlore.add("§c§oPrice: §627.69 GBP");
		}
		itemlore.add("");
		itemmeta.setLore(itemlore);
		item.setItemMeta(itemmeta);
		inv.setItem(16, item);
	}
}
