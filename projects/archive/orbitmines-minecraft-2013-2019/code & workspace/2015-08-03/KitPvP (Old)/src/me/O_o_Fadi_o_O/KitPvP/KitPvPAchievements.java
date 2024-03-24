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

public class KitPvPAchievements {
	
	Start plugin;
	 
	public KitPvPAchievements(Start instance) {
	plugin = instance;
	}
	
	public Inventory getAchievements(final Player p){
		
		final Inventory i = Bukkit.createInventory(null, 54, "§d§lAchievements: §c§lKitPvP");
		
		{		
			i.setItem(19, Kills10(p));
			i.setItem(20, Kills100(p));
			i.setItem(21, Kills250(p));
			i.setItem(22, Kills500(p));
			i.setItem(23, Kills1000(p));
			i.setItem(24, Kills2500(p));
			i.setItem(25, Kills5000(p));
			
			i.setItem(49, Back(p));
		}

		
		return i;
	}
	public ItemStack Kills10(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 10){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 10 Kills");
			l.add("");
			l.add("§c§o§mReward: 250 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 10 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o250 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills100(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 100){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 100 Kills");
			l.add("");
			l.add("§c§o§mReward: 1000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 100 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o1000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills250(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 250){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 250 Kills");
			l.add("");
			l.add("§c§o§mReward: 1500 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 250 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o1500 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills500(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 500){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 500 Kills");
			l.add("");
			l.add("§c§o§mReward: 2000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 500 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o2000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills1000(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 1000){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 1000 Kills");
			l.add("");
			l.add("§c§o§mReward: 5000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 1000 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o5000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills2500(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 2500){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 2500 Kills");
			l.add("");
			l.add("§c§o§mReward: 20000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 2500 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o20000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
	return item;
	}
	public ItemStack Kills5000(Player p){
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lAchievement");
		if(StorageManager.kills.get(p.getName()) >= 5000){
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§a§o§nReach 5000 Kills");
			l.add("");
			l.add("§c§o§mReward: 50000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		}
		else{
			List<String> l = new ArrayList<String>();		
			l.add("");
			l.add("§c§o§nReach 5000 Kills");
			l.add("");	
			l.add("§a§oReward: §6§o50000 Coins");
			l.add("");	
			itemmeta.setLore(l);
			item.setItemMeta(itemmeta);
		}
			
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