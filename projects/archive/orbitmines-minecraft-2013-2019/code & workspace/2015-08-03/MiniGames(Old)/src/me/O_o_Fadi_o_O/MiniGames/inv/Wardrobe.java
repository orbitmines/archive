package me.O_o_Fadi_o_O.MiniGames.inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Wardrobe {

	public static Inventory getWardrobeInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lWardrobe");
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§fWhite Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.white.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.WHITE);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§9Blue Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.blue.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.BLUE);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§2Green Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.green.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.GREEN);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§0Black Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.black.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.BLACK);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§bLight Blue Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.lightblue.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.AQUA);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§dPink Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.pink.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.FUCHSIA);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§aLight Green Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.lightgreen.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.LIME);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§1Dark Blue Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.darkblue.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.NAVY);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§5Purple Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.purple.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.PURPLE);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§6Orange Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.orange.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.ORANGE);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§cRed Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.red.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.RED);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§3Cyan Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.cyan.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.TEAL);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§eYellow Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.yellow.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.YELLOW);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName("§7Gray Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.gray.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b250 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setColor(Color.GRAY);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(25, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!p.hasPermission("Rank.Iron")){
				itemlore.add("§c§oRequired: §7§lIron VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(29, item);
		}
		{
			ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!p.hasPermission("Rank.Gold")){
				itemlore.add("§c§oRequired: §6§lGold VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(30, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!p.hasPermission("Rank.Diamond")){
				itemlore.add("§c§oRequired: §b§lDiamond VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(32, item);
		}
		{
			ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Chainmail Armor");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!p.hasPermission("Rank.Emerald")){
				itemlore.add("§c§oRequired: §a§lEmerald VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(33, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(48, item);
		}
		{
			ItemStack item = new ItemStack(Material.FIRE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nRemove Current Armor");
			item.setItemMeta(itemmeta);
			inv.setItem(50, item);
		}
	return inv;
	}
}
