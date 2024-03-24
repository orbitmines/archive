package me.O_o_Fadi_o_O.MiniGames.CosmeticPerks;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gadgets {

	Start start = Start.getInstance();
	
	public static Inventory getGadgetsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lGadgets");
		{
			ItemStack item = new ItemStack(Material.LEASH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§lStacker");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("§a§lUnlocked");
			itemlore.add("§7§o§nClick Here to Activate");
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lPaintballs");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.paintballsgadget.contains(p)){
				itemlore.add("§c§oPrice: §b700 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§a§lCreeper Launcher");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.creeperlaunchergadget.contains(p)){
				itemlore.add("§c§oPrice: §b525 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 4);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.SADDLE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§lPet Ride");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.hasunlockedpet.get(p) == false){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§c§oRequired: §7§lA Pet");
			}
			else{
				if(!StorageManager.petridegadget.contains(p)){
					itemlore.add("§c§oPrice: §b500 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.BOOK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7§lBook Explosion");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.bookexplosiongadget.contains(p)){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.EYE_OF_ENDER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2§lSwap Teleporter");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.swapteleportergadget.contains(p)){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§c§lMagmaCube Soccer");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.magmacubesoccergadget.contains(p)){
				itemlore.add("§c§oPrice: §b1000 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.PUMPKIN, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§lSnowman Attack");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.snowmanattackgadget.contains(p)){
				itemlore.add("§c§oPrice: §b1200 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(39, item);
		}
		{
			try{
				ItemStack itemInInv = p.getInventory().getItem(5);
				ItemStack item = new ItemStack(itemInInv.getType());
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(itemInInv.getItemMeta().getDisplayName());
				List<String> lore = new ArrayList<String>();
				lore.add("§c§lDISABLE §bGadget");
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(41, item);
			}catch(Exception ex){
				
			}
		}
		return inv;
	}
}
