package me.O_o_Fadi_o_O.MiniGames.CosmeticPerks;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Hat;
import me.O_o_Fadi_o_O.MiniGames.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hats {

	Start start = Start.getInstance();
	
	public static Inventory getHatsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lHats");
		
		setInvPage(inv, p, StorageManager.hatsinvpage.get(p));
		
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(48, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Hat Block Trail: §c§lDISABLED");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.hasunlockedhat.get(p) == true){
				if(!StorageManager.hatsblocktrail.containsKey(p)){
					itemlore.add("§c§oPrice: §b750 VIP Points");
					itemlore.add("§7§o§nClick Here to Buy");
					item.setDurability((short) 14);
				}
				else{
					if(StorageManager.hatsblocktrail.get(p) == true){
						itemmeta.setDisplayName("§7Hat Block Trail: §a§lENABLED");
						itemlore.add("§a§lUnlocked");
						itemlore.add("§7§o§nClick Here to Deactivate");
						item.setDurability((short) 5);
					}
					else{
						itemlore.add("§a§lUnlocked");
						itemlore.add("§7§o§nClick Here to Activate");
						item.setDurability((short) 14);
					}
				}
			}
			else{
				itemlore.add("§c§oPrice: §b750 VIP Points");
				itemlore.add("§c§oRequired: §6An Hat");
				item.setDurability((short) 14);
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(49, item);
		}
		{
			ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nRemove Current Hat");
			item.setItemMeta(itemmeta);
			inv.setItem(50, item);
		}
		return inv;
	}
	
	public static void setMoreHatsItemRight(Inventory inv, Player p){
		ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§e§nMore Hats >>");
		item.setItemMeta(itemmeta);
		inv.setItem(44, item);
	}
	public static void setMoreHatsItemLeft(Inventory inv, Player p){
		ItemStack item = new ItemStack(Material.EMPTY_MAP, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§e§n<< More Hats");
		item.setItemMeta(itemmeta);
		inv.setItem(36, item);
	}
	
	public static void setInvPage(Inventory inv, Player p, int page){
		
		if(page == 1){
			inv.setItem(36, null);
			setMoreHatsItemRight(inv, p);
			
			setHatItem(inv, p, Hat.GOLD_ORE, 0);
			setHatItem(inv, p, Hat.STONE_BRICKS, 1);
			setHatItem(inv, p, Hat.GREEN_GLASS, 2);
			setHatItem(inv, p, Hat.CACTUS, 3);
			setHatItem(inv, p, Hat.EMERALD_ORE, 4);
			setHatItem(inv, p, Hat.IRON_BLOCK, 5);
			setHatItem(inv, p, Hat.SNOW, 6);
			setHatItem(inv, p, Hat.TNT, 7);
			setHatItem(inv, p, Hat.COAL_ORE, 8);
			setHatItem(inv, p, Hat.BLACK_GLASS, 9);
			setHatItem(inv, p, Hat.GOLD_BLOCK, 10);
			setHatItem(inv, p, Hat.FURNACE, 11);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 12);
			setHatItem(inv, p, Hat.HAY_BALE, 13);
			setHatItem(inv, p, Hat.REDSTONE_ORE, 14);
			setHatItem(inv, p, Hat.ICE, 15);
			setHatItem(inv, p, Hat.WORKBENCH, 16);
			setHatItem(inv, p, Hat.DIAMOND_BLOCK, 17);
			setHatItem(inv, p, Hat.IRON_ORE, 18);
			setHatItem(inv, p, Hat.GRASS, 19);
			setHatItem(inv, p, Hat.RED_GLASS, 20);
			setHatItem(inv, p, Hat.BEDROCK, 21);
			setHatItem(inv, p, Hat.LAPIS_ORE, 22);
			setHatItem(inv, p, Hat.REDSTONE_BLOCK, 23);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 24);
			setHatItem(inv, p, Hat.LAPIS_BLOCK, 25);
			setHatItem(inv, p, Hat.MAGENTA_GLASS, 26);
			setHatItem(inv, p, Hat.COAL_BLOCK, 27);
			setHatItem(inv, p, Hat.EMERALD_BLOCK, 28);
			setHatItem(inv, p, Hat.MELON, 29);
			setHatItem(inv, p, Hat.GLASS, 30);
			setHatItem(inv, p, Hat.YELLOW_GLASS, 31);
			setHatItem(inv, p, Hat.MYCELIUM, 32);
			setHatItem(inv, p, Hat.LEAVES, 33);
			setHatItem(inv, p, Hat.DIAMOND_ORE, 34);
			setHatItem(inv, p, Hat.ORANGE_GLASS, 35);
		}
		else if(page == 2){
			setMoreHatsItemLeft(inv, p);
			setMoreHatsItemRight(inv, p);
			
			setHatItem(inv, p, Hat.STONE_BRICKS, 0);
			setHatItem(inv, p, Hat.GREEN_GLASS, 1);
			setHatItem(inv, p, Hat.CACTUS, 2);
			setHatItem(inv, p, Hat.EMERALD_ORE, 3);
			setHatItem(inv, p, Hat.IRON_BLOCK, 4);
			setHatItem(inv, p, Hat.SNOW, 5);
			setHatItem(inv, p, Hat.TNT, 6);
			setHatItem(inv, p, Hat.COAL_ORE, 7);
			setHatItem(inv, p, Hat.DIORITE, 8);
			setHatItem(inv, p, Hat.GOLD_BLOCK, 9);
			setHatItem(inv, p, Hat.FURNACE, 10);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 11);
			setHatItem(inv, p, Hat.HAY_BALE, 12);
			setHatItem(inv, p, Hat.REDSTONE_ORE, 13);
			setHatItem(inv, p, Hat.ICE, 14);
			setHatItem(inv, p, Hat.WORKBENCH, 15);
			setHatItem(inv, p, Hat.DIAMOND_BLOCK, 16);
			setHatItem(inv, p, Hat.DARK_PRISMARINE, 17);
			setHatItem(inv, p, Hat.GRASS, 18);
			setHatItem(inv, p, Hat.RED_GLASS, 19);
			setHatItem(inv, p, Hat.BEDROCK, 20);
			setHatItem(inv, p, Hat.LAPIS_ORE, 21);
			setHatItem(inv, p, Hat.REDSTONE_BLOCK, 22);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 23);
			setHatItem(inv, p, Hat.LAPIS_BLOCK, 24);
			setHatItem(inv, p, Hat.MAGENTA_GLASS, 25);
			setHatItem(inv, p, Hat.SPONGE, 26);
			setHatItem(inv, p, Hat.EMERALD_BLOCK, 27);
			setHatItem(inv, p, Hat.MELON, 28);
			setHatItem(inv, p, Hat.GLASS, 29);
			setHatItem(inv, p, Hat.YELLOW_GLASS, 30);
			setHatItem(inv, p, Hat.MYCELIUM, 31);
			setHatItem(inv, p, Hat.LEAVES, 32);
			setHatItem(inv, p, Hat.DIAMOND_ORE, 33);
			setHatItem(inv, p, Hat.ORANGE_GLASS, 34);
			setHatItem(inv, p, Hat.SLIME_BLOCK, 35);
		}
		else if(page == 3){
			setMoreHatsItemLeft(inv, p);
			setMoreHatsItemRight(inv, p);
			
			setHatItem(inv, p, Hat.GREEN_GLASS, 0);
			setHatItem(inv, p, Hat.CACTUS, 1);
			setHatItem(inv, p, Hat.EMERALD_ORE, 2);
			setHatItem(inv, p, Hat.IRON_BLOCK, 3);
			setHatItem(inv, p, Hat.SNOW, 4);
			setHatItem(inv, p, Hat.TNT, 5);
			setHatItem(inv, p, Hat.COAL_ORE, 6);
			setHatItem(inv, p, Hat.DIORITE, 7);
			setHatItem(inv, p, Hat.SEA_LANTERN, 8);
			setHatItem(inv, p, Hat.FURNACE, 9);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 10);
			setHatItem(inv, p, Hat.HAY_BALE, 11);
			setHatItem(inv, p, Hat.REDSTONE_ORE, 12);
			setHatItem(inv, p, Hat.ICE, 13);
			setHatItem(inv, p, Hat.WORKBENCH, 14);
			setHatItem(inv, p, Hat.DIAMOND_BLOCK, 15);
			setHatItem(inv, p, Hat.DARK_PRISMARINE, 16);
			setHatItem(inv, p, Hat.PRISMARINE_BRICKS, 17);
			setHatItem(inv, p, Hat.RED_GLASS, 18);
			setHatItem(inv, p, Hat.BEDROCK, 19);
			setHatItem(inv, p, Hat.LAPIS_ORE, 20);
			setHatItem(inv, p, Hat.REDSTONE_BLOCK, 21);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 22);
			setHatItem(inv, p, Hat.LAPIS_BLOCK, 23);
			setHatItem(inv, p, Hat.MAGENTA_GLASS, 24);
			setHatItem(inv, p, Hat.SPONGE, 25);
			setHatItem(inv, p, Hat.GRANITE, 26);
			setHatItem(inv, p, Hat.MELON, 27);
			setHatItem(inv, p, Hat.GLASS, 28);
			setHatItem(inv, p, Hat.YELLOW_GLASS, 29);
			setHatItem(inv, p, Hat.MYCELIUM, 30);
			setHatItem(inv, p, Hat.LEAVES, 31);
			setHatItem(inv, p, Hat.DIAMOND_ORE, 32);
			setHatItem(inv, p, Hat.ORANGE_GLASS, 33);
			setHatItem(inv, p, Hat.SLIME_BLOCK, 34);
			setHatItem(inv, p, Hat.CHEST, 35);
		}
		else if(page == 4){
			setMoreHatsItemLeft(inv, p);
			inv.setItem(44, null);
			
			setHatItem(inv, p, Hat.CACTUS, 0);
			setHatItem(inv, p, Hat.EMERALD_ORE, 1);
			setHatItem(inv, p, Hat.IRON_BLOCK, 2);
			setHatItem(inv, p, Hat.SNOW, 3);
			setHatItem(inv, p, Hat.TNT, 4);
			setHatItem(inv, p, Hat.COAL_ORE, 5);
			setHatItem(inv, p, Hat.DIORITE, 6);
			setHatItem(inv, p, Hat.SEA_LANTERN, 7);
			setHatItem(inv, p, Hat.GLOWSTONE, 8);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 9);
			setHatItem(inv, p, Hat.HAY_BALE, 10);
			setHatItem(inv, p, Hat.REDSTONE_ORE, 11);
			setHatItem(inv, p, Hat.ICE, 12);
			setHatItem(inv, p, Hat.WORKBENCH, 13);
			setHatItem(inv, p, Hat.DIAMOND_BLOCK, 14);
			setHatItem(inv, p, Hat.DARK_PRISMARINE, 15);
			setHatItem(inv, p, Hat.PRISMARINE_BRICKS, 16);
			setHatItem(inv, p, Hat.WET_SPONGE, 17);
			setHatItem(inv, p, Hat.BEDROCK, 18);
			setHatItem(inv, p, Hat.LAPIS_ORE, 19);
			setHatItem(inv, p, Hat.REDSTONE_BLOCK, 20);
			setHatItem(inv, p, Hat.QUARTZ_BLOCK, 21);
			setHatItem(inv, p, Hat.LAPIS_BLOCK, 22);
			setHatItem(inv, p, Hat.MAGENTA_GLASS, 23);
			setHatItem(inv, p, Hat.SPONGE, 24);
			setHatItem(inv, p, Hat.GRANITE, 25);
			setHatItem(inv, p, Hat.ANDESITE, 26);
			setHatItem(inv, p, Hat.GLASS, 27);
			setHatItem(inv, p, Hat.YELLOW_GLASS, 28);
			setHatItem(inv, p, Hat.MYCELIUM, 29);
			setHatItem(inv, p, Hat.LEAVES, 30);
			setHatItem(inv, p, Hat.DIAMOND_ORE, 31);
			setHatItem(inv, p, Hat.ORANGE_GLASS, 32);
			setHatItem(inv, p, Hat.SLIME_BLOCK, 33);
			setHatItem(inv, p, Hat.CHEST, 34);
			setHatItem(inv, p, Hat.BLUE_GLASS, 35);
		}
		
	}
	
	public static void setHatItem(Inventory inv, Player p, Hat hat, int slot){
		if(hat == Hat.GOLD_ORE){
			ItemStack item = new ItemStack(Material.GOLD_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Ore Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.STONE_BRICKS){
			ItemStack item = new ItemStack(Material.SMOOTH_BRICK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Stone Bricks Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.STONE_BRICKS).contains(p)){
				itemlore.add("§c§oPrice: §b75 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.GREEN_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aLime Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.GREEN_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 5);
			inv.setItem(slot, item);
		}
		if(hat == Hat.CACTUS){
			ItemStack item = new ItemStack(Material.CACTUS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Cactus Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.CACTUS).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.EMERALD_ORE){
			ItemStack item = new ItemStack(Material.EMERALD_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald Ore Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.IRON_BLOCK){
			ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Block Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.SNOW){
			ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSnow Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.SNOW).contains(p)){
				itemlore.add("§c§oPrice: §b75 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.TNT){
			ItemStack item = new ItemStack(Material.TNT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cTNT Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.TNT).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.COAL_ORE){
			ItemStack item = new ItemStack(Material.COAL_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Coal Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.COAL_ORE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.BLACK_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Black Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.BLACK_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 15);
			inv.setItem(slot, item);
		}
		if(hat == Hat.GOLD_BLOCK){
			ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Block Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.FURNACE){
			ItemStack item = new ItemStack(Material.FURNACE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Furnace Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.FURNACE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.QUARTZ_ORE){
			ItemStack item = new ItemStack(Material.QUARTZ_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cQuartz Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.QUARTZ_ORE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.HAY_BALE){
			ItemStack item = new ItemStack(Material.HAY_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eHay Bale Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.HAY_BALE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.REDSTONE_ORE){
			ItemStack item = new ItemStack(Material.REDSTONE_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.REDSTONE_ORE).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.ICE){
			ItemStack item = new ItemStack(Material.ICE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bIce Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.ICE).contains(p)){
				itemlore.add("§c§oPrice: §b150 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.WORKBENCH){
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Workbench Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.WORKBENCH).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.DIAMOND_BLOCK){
			ItemStack item = new ItemStack(Material.DIAMOND_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond Block Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.IRON_ORE){
			ItemStack item = new ItemStack(Material.IRON_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Ore Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.GRASS){
			ItemStack item = new ItemStack(Material.GRASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aGrass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.GRASS).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.RED_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Red Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.RED_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.BEDROCK){
			ItemStack item = new ItemStack(Material.BEDROCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Bedrock Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.BEDROCK).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.LAPIS_ORE){
			ItemStack item = new ItemStack(Material.LAPIS_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.LAPIS_ORE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.REDSTONE_BLOCK){
			ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.REDSTONE_BLOCK).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.QUARTZ_BLOCK){
			ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fQuartz Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.QUARTZ_BLOCK).contains(p)){
				itemlore.add("§c§oPrice: §b75 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.LAPIS_BLOCK){
			ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.LAPIS_BLOCK).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.MAGENTA_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dMagenta Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.MAGENTA_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 2);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.COAL_BLOCK){
			ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§0Coal Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.COAL_BLOCK).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.EMERALD_BLOCK){
			ItemStack item = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald Block Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.MELON){
			ItemStack item = new ItemStack(Material.MELON_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Melon Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.MELON).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.GLASS){
			ItemStack item = new ItemStack(Material.GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fGlass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b150 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.YELLOW_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eYellow Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.YELLOW_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
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
			inv.setItem(slot, item); 
		}
		if(hat == Hat.MYCELIUM){
			ItemStack item = new ItemStack(Material.MYCEL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Mycelium Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.MYCELIUM).contains(p)){
				itemlore.add("§c§oPrice: §b75 VIP Points");
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
			inv.setItem(slot, item); 
		}
		if(hat == Hat.LEAVES){
			ItemStack item = new ItemStack(Material.LEAVES, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Leaves Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.LEAVES).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.DIAMOND_ORE){
			ItemStack item = new ItemStack(Material.DIAMOND_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond Ore Hat");
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
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item);
		}
		if(hat == Hat.ORANGE_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Orange Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.ORANGE_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.DIORITE){
			ItemStack item = new ItemStack(Material.STONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fPolished Diorite Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.DIORITE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
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
			inv.setItem(slot, item); 
		}
		if(hat == Hat.DARK_PRISMARINE){
			ItemStack item = new ItemStack(Material.PRISMARINE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3Dark Prismarine Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.DARK_PRISMARINE).contains(p)){
				itemlore.add("§c§oPrice: §b150 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 2);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.SLIME_BLOCK){
			ItemStack item = new ItemStack(Material.SLIME_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.SLIME_BLOCK).contains(p)){
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
			inv.setItem(slot, item); 
		}
		if(hat == Hat.GRANITE){
			ItemStack item = new ItemStack(Material.STONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cPolished Granite Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.GRANITE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 2);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.SEA_LANTERN){
			ItemStack item = new ItemStack(Material.SEA_LANTERN, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSea Lantern Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.SEA_LANTERN).contains(p)){
				itemlore.add("§c§oPrice: §b225 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.PRISMARINE_BRICKS){
			ItemStack item = new ItemStack(Material.PRISMARINE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9Prismarine Bricks Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.PRISMARINE_BRICKS).contains(p)){
				itemlore.add("§c§oPrice: §b150 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.SPONGE){
			ItemStack item = new ItemStack(Material.SPONGE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eSponge Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.SPONGE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.CHEST){
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3EnderChest Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.CHEST).contains(p)){
				itemlore.add("§c§oPrice: §b175 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.GLOWSTONE){
			ItemStack item = new ItemStack(Material.GLOWSTONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Glowstone Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.GLOWSTONE).contains(p)){
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
			inv.setItem(slot, item); 
		}
		if(hat == Hat.WET_SPONGE){
			ItemStack item = new ItemStack(Material.SPONGE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eWet Sponge Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.WET_SPONGE).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 1);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.ANDESITE){
			ItemStack item = new ItemStack(Material.STONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Polished Andesite Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.ANDESITE).contains(p)){
				itemlore.add("§c§oPrice: §b100 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 6);
			inv.setItem(slot, item); 
		}
		if(hat == Hat.BLUE_GLASS){
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Blue Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hats.get(Hat.BLUE_GLASS).contains(p)){
				itemlore.add("§c§oPrice: §b125 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 11);
			inv.setItem(slot, item); 
		}
	}
}
