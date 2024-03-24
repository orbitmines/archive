package me.O_o_Fadi_o_O.SkyBlock.inventories;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class IslandInfoInv {
	
	public static Inventory getIslandInfoInv(Player p){
		int IslandNumber = StorageManager.playersislandnumber.get(p);
		
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lIsland Info");

		setIslandPartyItem(inv, 11, p, IslandNumber);
		setIslandInfoItem(inv, 13, p, IslandNumber);
		setTeleportEnabledItem(inv, 15, p, IslandNumber);
		
		return inv;
	}
	
	public static void setIslandPartyItem(Inventory inv, int slot, Player p, int IslandNumber){
		int totalplayers = StorageManager.islandmembers.get(IslandNumber).size() +1;
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		item.setDurability((short) 3);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setDisplayName("§6§lIsland Party §6(§7" + totalplayers + "§6/§710§6)");
		itemmeta.setOwner(p.getName());
		item.setItemMeta(itemmeta);
		inv.setItem(slot, item);
	}
	
	public static void setIslandInfoItem(Inventory inv, int slot, Player p, int IslandNumber){
		
		ItemStack item = new ItemStack(Material.PAPER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lIsland " + IslandNumber);
		List<String> lore = new ArrayList<String>();
		lore.add("  §dOwner: §7" + StorageManager.islandowner.get(IslandNumber));
		lore.add("  §dCreated: §7" + StorageManager.islandcreateddate.get(IslandNumber));
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		inv.setItem(slot, item);
	}
	
	public static void setTeleportEnabledItem(Inventory inv, int slot, Player p, int IslandNumber){
		
		boolean bl = StorageManager.islandteleportenabled.get(IslandNumber);
		
		ItemStack item = new ItemStack(Material.INK_SACK, 1);
		ItemMeta itemmeta = item.getItemMeta();
		if(bl == true){
			itemmeta.setDisplayName("§3§lTeleport §a§lENABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 10);
		}
		else{
			itemmeta.setDisplayName("§3§lTeleport §c§lDISABLED");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
		}
		inv.setItem(slot, item);
	}
}
