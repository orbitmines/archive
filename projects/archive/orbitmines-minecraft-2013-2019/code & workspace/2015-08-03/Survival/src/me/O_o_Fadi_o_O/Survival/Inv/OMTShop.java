package me.O_o_Fadi_o_O.Survival.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class OMTShop {

	public static Inventory getOMTShop(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "§0§lOMT Shop");
		
		{
			ItemStack item = new ItemStack(Material.STONE_HOE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§8§l+100 Claimblocks");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e2 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§2§l+400$");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e3 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
			item.setDurability((short) 3);
			SkullMeta meta = (SkullMeta) item.getItemMeta();
			meta.setDisplayName("§7§lYour Skull");
			meta.setOwner(p.getName());
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("§c§oPrice: §e50 OrbitMines Tokens");
			lore.add("§7§o§nClick Here to Buy");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			if(MerchantManager.merchantannouncements.contains(p)){
				meta.setDisplayName("§a§lMerchant Announcements");
				item.setDurability((short) 5);
			}
			else{
				meta.setDisplayName("§c§lMerchant Announcements");
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§c§oPrice: §e100 OrbitMines Tokens");
				lore.add("§7§o§nClick Here to Buy");
				lore.add("");
				item.setDurability((short) 14);
				meta.setLore(lore);
			}
			item.setItemMeta(meta);
			inv.setItem(16, item);
		}
		
		return inv;
	}
}
