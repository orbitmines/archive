package me.O_o_Fadi_o_O.KitPvP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BoosterInv {
	
	public static Inventory getBoostersInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 9, "§0§lBoosters");
		
		setItem(inv, 1, "§7§lIron VIP Booster", Material.IRON_INGOT, getItemLore(p, Material.IRON_INGOT), 1, 0);
		setItem(inv, 3, "§6§lGold VIP Booster", Material.GOLD_INGOT, getItemLore(p, Material.GOLD_INGOT), 1, 0);
		setItem(inv, 5, "§b§lDiamond VIP Booster", Material.DIAMOND, getItemLore(p, Material.DIAMOND), 1, 0);
		setItem(inv, 7, "§a§lEmerald VIP Booster", Material.EMERALD, getItemLore(p, Material.EMERALD), 1, 0);
		
		return inv;
	}
	
	public static void setItem(Inventory inv, int slot, String DisplayName, Material m, List<String> lore, int amount, int durability){
		
		ItemStack item = new ItemStack(m, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(DisplayName);
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) durability);
		inv.setItem(slot, item);
		
	}
	
	public static List<String> getItemLore(Player p, Material m){
		
		List<String> lore = new ArrayList<String>();
		
		if(m == Material.IRON_INGOT){
			lore.add("");
			lore.add("§7Multiplier: §ax1.25");
			lore.add("§7Duration: §a30 Minutes");
			lore.add("");
			lore.add("§c§oPrice: §b200 VIP Points");
			if(!p.hasPermission("Rank.Iron")){
				lore.add("§c§oRequired: §7§lIron VIP");
			}
			else{
				lore.add("§7§o§nClick Here to Buy");
			}
			lore.add("");
		}
		if(m == Material.GOLD_INGOT){
			lore.add("");
			lore.add("§7Multiplier: §ax1.5");
			lore.add("§7Duration: §a30 Minutes");
			lore.add("");
			lore.add("§c§oPrice: §b200 VIP Points");
			if(!p.hasPermission("Rank.Gold")){
				lore.add("§c§oRequired: §6§lGold VIP");
			}
			else{
				lore.add("§7§o§nClick Here to Buy");
			}
			lore.add("");
		}
		if(m == Material.DIAMOND){
			lore.add("");
			lore.add("§7Multiplier: §ax2");
			lore.add("§7Duration: §a30 Minutes");
			lore.add("");
			lore.add("§c§oPrice: §b200 VIP Points");
			if(!p.hasPermission("Rank.Diamond")){
				lore.add("§c§oRequired: §b§lDiamond VIP");
			}
			else{
				lore.add("§7§o§nClick Here to Buy");
			}
			lore.add("");
		}
		if(m == Material.EMERALD){
			lore.add("");
			lore.add("§7Multiplier: §ax2.5");
			lore.add("§7Duration: §a30 Minutes");
			lore.add("");
			lore.add("§c§oPrice: §b200 VIP Points");
			if(!p.hasPermission("Rank.Emerald")){
				lore.add("§c§oRequired: §a§lEmerald VIP");
			}
			else{
				lore.add("§7§o§nClick Here to Buy");
			}
			lore.add("");
		}
		
		return lore;
		
	}
}
