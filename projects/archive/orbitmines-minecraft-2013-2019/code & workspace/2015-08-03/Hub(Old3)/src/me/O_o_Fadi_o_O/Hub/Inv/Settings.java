package me.O_o_Fadi_o_O.Hub.Inv;

import me.O_o_Fadi_o_O.Hub.CustomItem;
import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Settings {
	
	Hub hub = Hub.getInstance();
	
	public static void getSettingsInv(Player p, Inventory invs){
		
		getPlayerVisibility(invs, p);
		getScoreboardEnabled(invs, p);
		getStackerEnabled(invs, p);
		
		p.openInventory(invs);
	}
	
	public static void getPlayerVisibility(Inventory inv, Player p){
		
		if(StorageManager.playersenabled.get(p) == true){
			ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�3�lPlayers�a�l ENABLED");
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			item = CustomItem.hideFlags(item, 1);
			inv.setItem(11, item);
		}
		else{
			ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�3�lPlayers�c�l DISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
	}
	
	public static void getStackerEnabled(Inventory inv, Player p){
		
		if(StorageManager.stackerenabled.get(p) == true){
			ItemStack item = new ItemStack(Material.LEASH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�6�lStacker�a�l ENABLED");
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			item = CustomItem.hideFlags(item, 1);
			inv.setItem(15, item);
		}
		else{
			ItemStack item = new ItemStack(Material.LEASH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�6�lStacker�c�l DISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
	}
	
	public static void getScoreboardEnabled(Inventory inv, Player p){
		
		if(StorageManager.scoreboardenabled.get(p) == true){
			ItemStack item = new ItemStack(Material.PAPER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�f�lScoreboard�a�l ENABLED");
			item.setItemMeta(itemmeta);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			item = CustomItem.hideFlags(item, 1);
			inv.setItem(13, item);
		}
		else{
			ItemStack item = new ItemStack(Material.PAPER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�f�lScoreboard�c�l DISABLED");
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
	}
}
