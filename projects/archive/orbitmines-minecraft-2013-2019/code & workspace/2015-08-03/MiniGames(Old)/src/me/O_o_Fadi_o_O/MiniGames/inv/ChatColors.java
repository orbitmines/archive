package me.O_o_Fadi_o_O.MiniGames.inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColors {

	Start plugin;
	 
	public ChatColors(Start instance) {
	plugin = instance;
	}
	
	public static Inventory getChatColors(final Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lChatColors");
		
		{		
			
			{
				ItemStack item = new ItemStack(Material.REDSTONE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Dark Red ChatColor");
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(!Start.chatcolordarkred.containsKey(p.getName())){
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
				if(!Start.chatcolorlightgreen.containsKey(p.getName())){
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
				if(!Start.chatcolordarkgray.containsKey(p.getName())){
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
				if(!Start.chatcolorred.containsKey(p.getName())){
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
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§eYellow ChatColor");
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
				if(!Start.chatcolorwhite.containsKey(p.getName())){
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
				if(!Start.chatcolorlightblue.containsKey(p.getName())){
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
				if(!Start.chatcolorpink.containsKey(p.getName())){
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
				if(!Start.chatcolorblue.containsKey(p.getName())){
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
				if(!Start.chatcolordarkblue.containsKey(p.getName())){
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
				if(!p.hasPermission("Rank.Emerald")){
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
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§5Purple ChatColor");
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
				if(!p.hasPermission("Rank.Diamond")){
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
				if(!Start.chatcolorgreen.containsKey(p.getName())){
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
				if(!Start.chatcolorblack.containsKey(p.getName())){
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
				if(Start.chatcolor.get(p).equals("4")){
					ItemStack item = new ItemStack(Material.REDSTONE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4Dark Red ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("a")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§aLight Green ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 10);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("8")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8Dark Gray ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 8);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("c")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§cRed ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 1);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("e")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§eYellow ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 11);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("f")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§fWhite ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 15);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("b")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§bLight Blue ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 12);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("d")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§dPink ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 9);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("9")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§9Blue ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 12);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("1")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1Dark Blue ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 4);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("7")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Gray ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 7);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("6")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6Orange ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 14);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("5")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§5Purple ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 5);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("3")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§3Cyan ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 6);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("2")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§2Green ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setDurability((short) 2);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
				if(Start.chatcolor.get(p).equals("0")){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§0Black ChatColor ");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("");
					itemlore.add("§7§o§nCurrently Activated");
					itemlore.add("");
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(41, item);
				}
			}
		}

		
		return inv;
	}
}
