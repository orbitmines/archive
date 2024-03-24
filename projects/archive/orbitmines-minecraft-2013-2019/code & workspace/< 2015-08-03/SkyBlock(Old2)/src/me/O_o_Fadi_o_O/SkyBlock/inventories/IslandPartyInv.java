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

public class IslandPartyInv {
	
	public static Inventory getIslandPartyInv(Player p){
		int IslandNumber = StorageManager.PlayersIslandNumber.get(p);
		
		Inventory inv = Bukkit.createInventory(null, 45, "§0§lIsland Party");

		setIslandParty(inv, p, IslandNumber);
		setIslandInfoItem(inv, 40, p, IslandNumber);
		
		return inv;
	}
	
	public static void setIslandParty(Inventory inv, Player p, int IslandNumber){
		
		setOwnerItem(inv, 11, p, IslandNumber, StorageManager.IslandOwner.get(IslandNumber));
		
		int members = StorageManager.IslandMembers.get(IslandNumber).size();
		List<String> allmembers = StorageManager.IslandMembers.get(IslandNumber);
		for(int i = 1; i <= 9; i++){
			if(members >= i){
				if(i == 1 || i == 2 || i == 3 || i == 4){
					setMemberItem(inv, 11 + i, p, IslandNumber, allmembers.get(i -1));
				}
				else{
					setMemberItem(inv, 15 + i, p, IslandNumber, allmembers.get(i -1));
				}
			}
			else{
				if(i == 1 || i == 2 || i == 3 || i == 4){
					setEmptySlot(inv, 11 + i, p, IslandNumber);
				}
				else{
					setEmptySlot(inv, 15 + i, p, IslandNumber);
				}
			}
		}
	}
	
	public static void setIslandInfoItem(Inventory inv, int slot, Player p, int IslandNumber){
		
		ItemStack item = new ItemStack(Material.PAPER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§d§lIsland Info");
		item.setItemMeta(itemmeta);
		inv.setItem(slot, item);
	}
	
	public static void setOwnerItem(Inventory inv, int slot, Player p, int IslandNumber, String player){
		
		boolean bl = false;
		for(Player pl : Bukkit.getOnlinePlayers()){
			if(pl.getName().equals(player)){
				bl = true;
			}
		}
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6" + player);
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("  §dRank: §7Owner");
		if(bl == true){
			lore.add("  §dStatus: §aOnline  ");
		}
		else{
			lore.add("  §dStatus: §cOffline  ");
		}
		lore.add("");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability((short) 3);
		inv.setItem(slot, item);
	}
	
	public static void setMemberItem(Inventory inv, int slot, Player p, int IslandNumber, String player){
		
		boolean bl = false;
		for(Player pl : Bukkit.getOnlinePlayers()){
			if(pl.getName().equals(player)){
				bl = true;
			}
		}
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6" + player);
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("  §dRank: §7Member");
		if(bl == true){
			lore.add("  §dStatus: §aOnline  ");
		}
		else{
			lore.add("  §dStatus: §cOffline  ");
		}
		lore.add("");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability((short) 3);
		inv.setItem(slot, item);
	}
	
	public static void setEmptySlot(Inventory inv, int slot, Player p, int IslandNumber){
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§7§lEmpty Slot");
		item.setItemMeta(itemmeta);
		item.setDurability((short) 1);
		inv.setItem(slot, item);
	}
}
