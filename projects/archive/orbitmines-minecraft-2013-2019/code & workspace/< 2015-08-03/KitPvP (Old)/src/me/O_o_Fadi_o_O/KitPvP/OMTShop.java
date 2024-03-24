package me.O_o_Fadi_o_O.KitPvP;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OMTShop {

	Start plugin;
	 
	public OMTShop(Start instance) {
	plugin = instance;
	}
	
	public Inventory getOMTShop(final Player p){
		
		final Inventory i = Bukkit.createInventory(null, 54, "§6§lOMT Shop: §c§lKitPvP");
		
		{		
			i.setItem(20, OMT1(p));
			i.setItem(24, OMT10(p));
			
			i.setItem(49, Back(p));
		}

		
		return i;
	}
	public ItemStack OMT1(Player p){
		ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6§l250 Coins");
		List<String> l = new ArrayList<String>();		
		l.add("");
		l.add("§7§oYour OMT Balance: §e§o" + StorageManager.omt.get(p.getName()));
		l.add("");
		l.add("§7§oPrice: §e§o1 OMT");
		l.add("");	
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
			
	return item;
	}
	public ItemStack OMT10(Player p){
		ItemStack item = new ItemStack(Material.GOLD_INGOT, 10);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6§l2500 Coins");
		List<String> l = new ArrayList<String>();		
		l.add("");
		l.add("§7§oYour OMT Balance: §e§o" + StorageManager.omt.get(p.getName()));
		l.add("");
		l.add("§7§oPrice: §e10 OMT");
		l.add("");	
		itemmeta.setLore(l);
		item.setItemMeta(itemmeta);
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
			
	return item;
	}
	public ItemStack Back(Player p){
		ItemStack back = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("§4§l§o<< Back");
		List<String> backlore = new ArrayList<String>();		
		backlore.add("");
		backlore.add("§7§oBack to the Kit Selector");
		backlore.add("");
		backmeta.setLore(backlore);
		back.setItemMeta(backmeta);
			
	return back;
	}
}
