package me.O_o_Fadi_o_O.Creative.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.utils.Disguise;
import me.O_o_Fadi_o_O.Creative.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Disguises {
	
	Start start = Start.getInstance();
	
	public static Inventory getDisguisesInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lDisguises");

		setDisguiseInvItems(inv, p);
		
		return inv;
	}
	
	public static void setDisguiseInvItems(Inventory inv, Player p){
		inv.clear();
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Enderman Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.ENDERMAN).contains(p)){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 58);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Witch Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.WITCH).contains(p)){
				itemlore.add("§c§oPrice: §b450 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 66);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Bat Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.BAT).contains(p)){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 65);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fChicken Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.CHICKEN).contains(p)){
				itemlore.add("§c§oPrice: §b325 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 93);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eOcelot Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.OCELOT).contains(p)){
				itemlore.add("§c§oPrice: §b375 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 98);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Mushroom Cow Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.MUSHROOM_COW).contains(p)){
				itemlore.add("§c§oPrice: §b350 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 96);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9Squid Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SQUID).contains(p)){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 94);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dPig Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Iron_VIP)){
				itemlore.add("§c§oRequired: §7§lIron VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 90);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fIron Golem Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.IRON_GOLEM).contains(p)){
				itemlore.add("§c§oPrice: §b575 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 99);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(17, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Ghast Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.GHAST).contains(p)){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 56);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(18, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Blaze Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
				itemlore.add("§c§oRequired: §a§lEmerald VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 61);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SLIME).contains(p)){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 55);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dZombie Pigman Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.ZOMBIE_PIGMAN).contains(p)){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 57);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cMagma Cube Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.MAGMA_CUBE).contains(p)){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 62);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Skeleton Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SKELETON).contains(p)){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 51);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Zombie Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Gold_VIP)){
				itemlore.add("§c§oRequired: §6§lGold VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 54);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Villager Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
				itemlore.add("§c§oRequired: §b§lDiamond VIP");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 120);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(25, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Horse Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.HORSE).contains(p)){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 100);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(26, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Rabbit Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.RABBIT).contains(p)){
				itemlore.add("§c§oPrice: §b650 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 101);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(27, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Wolf Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.WOLF).contains(p)){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 95);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(28, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Spider Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SPIDER).contains(p)){
				itemlore.add("§c§oPrice: §b375 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 52);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(29, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Silverfish Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SILVERFISH).contains(p)){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 60);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(30, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSheep Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SHEEP).contains(p)){
				itemlore.add("§c§oPrice: §b375 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 91);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(31, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3Cave Spider Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.CAVE_SPIDER).contains(p)){
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 59);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(32, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aCreeper Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.CREEPER).contains(p)){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 50);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(33, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Cow Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.COW).contains(p)){
				itemlore.add("§c§oPrice: §b350 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 92);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(34, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSnowman Disguise");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.disguises.get(Disguise.SNOWMAN).contains(p)){
				itemlore.add("§a§oAchieved at Christmas 2014");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 97);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(35, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(48, item);
		}
		{
			ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nDisable Disguise");
			item.setItemMeta(itemmeta);
			inv.setItem(50, item);
		}
	}
}
