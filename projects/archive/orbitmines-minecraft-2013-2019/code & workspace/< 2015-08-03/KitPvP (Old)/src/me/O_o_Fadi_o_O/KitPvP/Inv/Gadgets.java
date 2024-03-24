package me.O_o_Fadi_o_O.KitPvP.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gadgets {

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
			if(!StorageManager.gadgetsPaintballs.containsKey(p.getName())){
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
			if(!StorageManager.gadgetsCreeperLauncher.containsKey(p.getName())){
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
			if(!StorageManager.mushroomcow.containsKey(p.getName()) && !StorageManager.pig.containsKey(p.getName()) && !StorageManager.wolf.containsKey(p.getName())&& !StorageManager.sheep.containsKey(p.getName()) && !StorageManager.horse.containsKey(p.getName()) && !StorageManager.magmacube.containsKey(p.getName()) && !StorageManager.slime.containsKey(p.getName()) && !StorageManager.cow.containsKey(p.getName()) && !StorageManager.silverfish.containsKey(p.getName()) && !StorageManager.ocelot.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§c§oPet Required");
			}
			else{
				if(!StorageManager.gadgetsPetRide.containsKey(p.getName())){
					itemlore.add("§c§oPrice: §b100 VIP Points");
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
			if(!StorageManager.gadgetsBookExplosion.containsKey(p.getName())){
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
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(39, item);
		}
		{
			try{
				ItemStack item = p.getInventory().getItem(5);
				inv.setItem(41, item);
			}catch(Exception ex){
				
			}
		}
		return inv;
	}
}
