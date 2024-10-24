package me.O_o_Fadi_o_O.MiniGames.Inventories;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StatsInv {

	public static Inventory getStatsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 27, "�0�lStats");
		
		{
			ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�7�lKills");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("�f�lChicken Fight: �7" + StorageManager.chickenfightkills.get(p));
			itemlore.add("�f�lSurvival Games: �7" + StorageManager.survivalgameskills.get(p));
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�b�lBest Streak");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("�f�lChicken Fight: �7" + StorageManager.chickenfightbeststreak.get(p));
			itemlore.add("�f�lSurvival Games: �7" + StorageManager.survivalgamesbeststreak.get(p));
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�a�lGames Won");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("�f�lChicken Fight: �7" + StorageManager.chickenfightwins.get(p));
			itemlore.add("�f�lSurvival Games: �7" + StorageManager.survivalgameswins.get(p));
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 10);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�4�lGames Lost");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("�f�lChicken Fight: �7" + StorageManager.chickenfightloses.get(p));
			itemlore.add("�f�lSurvival Games: �7" + StorageManager.survivalgamesloses.get(p));
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
			inv.setItem(16, item);
		}
		return inv;
	}
}
