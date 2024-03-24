package me.O_o_Fadi_o_O.Prison.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Trails {

	public static Inventory getTrailsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lTrails");
		{
			ItemStack item = new ItemStack(Material.FIREWORK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cFireWork Spark Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsfirework.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.EMERALD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aHappy Villager Trail");
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
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STALK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cHeart Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailshearts.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b300 VIP Points");
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
			ItemStack item = new ItemStack(Material.TNT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4TNT Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsexplode.containsKey(p.getName())){
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
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3Magic Trail");
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
			item.setDurability((short) 6);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.COAL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Angry Villager Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsangryvillager.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b400 VIP Points");
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
			ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Lava Trail");
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
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsslime.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b275 VIP Points");
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
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§0Smoke Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailssmoke.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b325 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(17, item);
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§5Witch Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailswitch.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b350 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setDurability((short) 5);
			item.setItemMeta(itemmeta);
			inv.setItem(18, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bCrit Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailscrit.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b375 VIP Points");
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
			ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9Water Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailswater.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.NOTE_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dMusic Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsnote.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b625 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
		}
		{
			ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSnow Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailssnow.containsKey(p.getName())){
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
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Enchantment Table Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsenchantmenttable.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Rainbow Trail");
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
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.WEB, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fBubble Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsbubbles.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b375 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(25, item);
		}
		{
			ItemStack item = new ItemStack(Material.MOB_SPAWNER, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Mob Spawner Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trailsmobspawner.containsKey(p.getName())){
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
			inv.setItem(26, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(39, item);
		}
		{
			ItemStack item = new ItemStack(Material.FIRE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nRemove Current Trail");
			item.setItemMeta(itemmeta);
			inv.setItem(41, item);
		}
		return inv;
	}
}
