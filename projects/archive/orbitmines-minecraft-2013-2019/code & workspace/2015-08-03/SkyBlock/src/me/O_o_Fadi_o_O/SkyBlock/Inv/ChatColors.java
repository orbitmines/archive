package me.O_o_Fadi_o_O.SkyBlock.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;
import me.O_o_Fadi_o_O.SkyBlock.utils.ChatColor;
import me.O_o_Fadi_o_O.SkyBlock.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColors {

	Start start = Start.getInstance();
	
	public static Inventory getChatColors(final Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lChatColors");
		
		{		
			
			{
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Dark Red ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.DARK_RED).contains(p)){
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
				inv.setItem(9, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§aLight Green ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.LIGHT_GREEN).contains(p)){
					itemlore.add("§c§oPrice: §b575 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 10);
				item.setItemMeta(itemmeta);
				inv.setItem(10, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§8Dark Gray ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.DARK_GRAY).contains(p)){
					itemlore.add("§c§oPrice: §b250 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 8);
				item.setItemMeta(itemmeta);
				inv.setItem(11, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§cRed ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.RED).contains(p)){
					itemlore.add("§c§oPrice: §b650 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 1);
				item.setItemMeta(itemmeta);
				inv.setItem(12, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) +"§lBold ChatColor: §c§lDISABLED");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
					itemlore.add("§c§oPrice: §b3000 VIP Points");
					itemlore.add("§c§oRequired: §a§lEmerald VIP");
					item.setDurability((short) 14);
				}
				else{
					if(!StorageManager.boldchatcolor.containsKey(p)){
						itemlore.add("§c§oPrice: §b3000 VIP Points");
						itemlore.add("§7§o§nClick Here to Buy");
						item.setDurability((short) 14);
					}
					else{
						if(StorageManager.boldchatcolor.get(p) == true){
							itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) +"§lBold ChatColor: §a§lENABLED");
							itemlore.add("§a§lUnlocked");
							itemlore.add("§7§o§nClick Here to Deactivate");
							item.setDurability((short) 5);
						}
						else{
							itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) +"§lBold ChatColor: §c§lDISABLED");
							itemlore.add("§a§lUnlocked");
							itemlore.add("§7§o§nClick Here to Activate");
							item.setDurability((short) 14);
						}
					}
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				inv.setItem(13, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§eYellow ChatColor");
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
				itemmeta.setLore(itemlore);
				item.setDurability((short) 11);
				item.setItemMeta(itemmeta);
				inv.setItem(14, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fWhite ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.WHITE).contains(p)){
					itemlore.add("§c§oPrice: §b500 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 15);
				item.setItemMeta(itemmeta);
				inv.setItem(15, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§bLight Blue ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.LIGHT_BLUE).contains(p)){
					itemlore.add("§c§oPrice: §b700 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 12);
				item.setItemMeta(itemmeta);
				inv.setItem(16, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§dPink ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.PINK).contains(p)){
					itemlore.add("§c§oPrice: §b525 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 9);
				item.setItemMeta(itemmeta);
				inv.setItem(17, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9Blue ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.BLUE).contains(p)){
					itemlore.add("§c§oPrice: §b475 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 12);
				item.setItemMeta(itemmeta);
				inv.setItem(18, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§1Dark Blue ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.DARK_BLUE).contains(p)){
					itemlore.add("§c§oPrice: §b350 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 4);
				item.setItemMeta(itemmeta);
				inv.setItem(19, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Gray ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 7);
				item.setItemMeta(itemmeta);
				inv.setItem(20, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Orange ChatColor");
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
				itemmeta.setLore(itemlore);
				item.setDurability((short) 14);
				item.setItemMeta(itemmeta);
				inv.setItem(21, item);
			}
			{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) + "§oCursive ChatColor: §c§lDISABLED");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!PlayerManager.hasVIPPerms(p, VIPRank.Diamond_VIP)){
					itemlore.add("§c§oPrice: §b2000 VIP Points");
					itemlore.add("§c§oRequired: §b§lDiamond VIP");
					item.setDurability((short) 14);
				}
				else{
					if(!StorageManager.cursivechatcolor.containsKey(p)){
						itemlore.add("§c§oPrice: §b2000 VIP Points");
						itemlore.add("§7§o§nClick Here to Buy");
						item.setDurability((short) 14);
					}
					else{
						if(StorageManager.cursivechatcolor.get(p) == true){
							itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) +"§oCursive ChatColor: §a§lENABLED");
							itemlore.add("§a§lUnlocked");
							itemlore.add("§7§o§nClick Here to Deactivate");
							item.setDurability((short) 5);
						}
						else{
							itemmeta.setDisplayName("§" + StorageManager.chatcolor.get(p) +"§oCursive ChatColor: §c§lDISABLED");
							itemlore.add("§a§lUnlocked");
							itemlore.add("§7§o§nClick Here to Activate");
							item.setDurability((short) 14);
						}
					}
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				inv.setItem(22, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§5Purple ChatColor");
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
				itemmeta.setLore(itemlore);
				item.setDurability((short) 5);
				item.setItemMeta(itemmeta);
				inv.setItem(23, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§3Cyan ChatColor");
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
				itemmeta.setLore(itemlore);
				item.setDurability((short) 6);
				item.setItemMeta(itemmeta);
				inv.setItem(24, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§2Green ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.GREEN).contains(p)){
					itemlore.add("§c§oPrice: §b475 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
				}
				else{
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setDurability((short) 2);
				item.setItemMeta(itemmeta);
				inv.setItem(25, item);
			}
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§0Black ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!StorageManager.chatcolors.get(ChatColor.BLACK).contains(p)){
					itemlore.add("§c§oPrice: §b200 VIP Points");
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
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("");
				if(StorageManager.chatcolor.get(p).equals("4")){
					item.setType(Material.REDSTONE);
					itemmeta.setDisplayName("§4Dark Red ChatColor");
				}
				if(StorageManager.chatcolor.get(p).equals("a")){
					itemmeta.setDisplayName("§aLight Green ChatColor");
					item.setDurability((short) 10);
				}
				if(StorageManager.chatcolor.get(p).equals("8")){
					itemmeta.setDisplayName("§8Dark Gray ChatColor");
					item.setDurability((short) 8);
				}
				if(StorageManager.chatcolor.get(p).equals("c")){
					itemmeta.setDisplayName("§cRed ChatColor");
					item.setDurability((short) 1);
				}
				if(StorageManager.chatcolor.get(p).equals("e")){
					itemmeta.setDisplayName("§eYellow ChatColor");
					item.setDurability((short) 11);
				}
				if(StorageManager.chatcolor.get(p).equals("f")){
					itemmeta.setDisplayName("§fWhite ChatColor");
					item.setDurability((short) 15);
				}
				if(StorageManager.chatcolor.get(p).equals("b")){
					itemmeta.setDisplayName("§bLight Blue ChatColor");
					item.setDurability((short) 12);
				}
				if(StorageManager.chatcolor.get(p).equals("d")){
					itemmeta.setDisplayName("§dPink ChatColor");
					item.setDurability((short) 9);
				}
				if(StorageManager.chatcolor.get(p).equals("9")){
					itemmeta.setDisplayName("§9Blue ChatColor");
					item.setDurability((short) 12);
				}
				if(StorageManager.chatcolor.get(p).equals("1")){
					itemmeta.setDisplayName("§1Dark Blue ChatColor");
					item.setDurability((short) 4);
				}
				if(StorageManager.chatcolor.get(p).equals("7")){
					itemmeta.setDisplayName("§7Gray ChatColor");
					item.setDurability((short) 7);
				}
				if(StorageManager.chatcolor.get(p).equals("6")){
					itemmeta.setDisplayName("§6Orange ChatColor");
					item.setDurability((short) 14);
				}
				if(StorageManager.chatcolor.get(p).equals("5")){
					itemmeta.setDisplayName("§5Purple ChatColor");
					item.setDurability((short) 5);
				}
				if(StorageManager.chatcolor.get(p).equals("3")){
					itemmeta.setDisplayName("§3Cyan ChatColor");
					item.setDurability((short) 6);
				}
				if(StorageManager.chatcolor.get(p).equals("2")){
					itemmeta.setDisplayName("§2Green ChatColor");
					item.setDurability((short) 2);
				}
				if(StorageManager.chatcolor.get(p).equals("0")){
					itemmeta.setDisplayName("§0Black ChatColor");
				}
				item.setItemMeta(itemmeta);
				inv.setItem(41, item);
			}
		}

		
		return inv;
	}
}
