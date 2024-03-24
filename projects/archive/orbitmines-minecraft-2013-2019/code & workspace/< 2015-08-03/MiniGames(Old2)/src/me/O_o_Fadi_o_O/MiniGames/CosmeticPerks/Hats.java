package me.O_o_Fadi_o_O.MiniGames.CosmeticPerks;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hats {

	public static Inventory getHatsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lHats");
		{
			ItemStack item = new ItemStack(Material.GOLD_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Ore Hat");
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
			inv.setItem(0, item);
		}
		{
			ItemStack item = new ItemStack(Material.SMOOTH_BRICK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Stone Bricks Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsStoneBricks.containsKey(p.getName())){
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
			inv.setItem(1, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aLime Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsGreenGlass.containsKey(p.getName())){
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
			inv.setItem(2, item);
		}
		{
			ItemStack item = new ItemStack(Material.CACTUS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Cactus Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsCactus.containsKey(p.getName())){
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
			inv.setItem(3, item);
		}
		{
			ItemStack item = new ItemStack(Material.EMERALD_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald Ore Hat");
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
			inv.setItem(4, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Block Hat");
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
			inv.setItem(5, item);
		}
		{
			ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSnow Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsSnow.containsKey(p.getName())){
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
			inv.setItem(6, item);
		}
		{
			ItemStack item = new ItemStack(Material.TNT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cTNT Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsTNT.containsKey(p.getName())){
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
			inv.setItem(7, item);
		}
		{
			ItemStack item = new ItemStack(Material.COAL_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Coal Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsCoalOre.containsKey(p.getName())){
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
			inv.setItem(8, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Black Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsBlackGlass.containsKey(p.getName())){
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
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Block Hat");
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
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.FURNACE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Furnace Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsFurnace.containsKey(p.getName())){
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
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.QUARTZ_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cQuartz Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsQuartzOre.containsKey(p.getName())){
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
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.HAY_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eHay Bale Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsHayBale.containsKey(p.getName())){
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
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsRedstoneOre.containsKey(p.getName())){
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
			inv.setItem(14, item);
		}
		{
			ItemStack item = new ItemStack(Material.ICE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bIce Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsIce.containsKey(p.getName())){
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
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Workbench Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsWorkbench.containsKey(p.getName())){
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
			inv.setItem(16, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond Block Hat");
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
			inv.setItem(17, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Ore Hat");
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
			inv.setItem(18, item);
		}
		{
			ItemStack item = new ItemStack(Material.GRASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aGrass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsGrass.containsKey(p.getName())){
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
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Red Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsRedGlass.containsKey(p.getName())){
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
			inv.setItem(20, item); 
		}
		{
			ItemStack item = new ItemStack(Material.BEDROCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Bedrock Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsBedrock.containsKey(p.getName())){
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
			inv.setItem(21, item); 
		}
		{
			ItemStack item = new ItemStack(Material.LAPIS_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Ore Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsLapisOre.containsKey(p.getName())){
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
			inv.setItem(22, item); 
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsRedstoneBlock.containsKey(p.getName())){
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
			inv.setItem(23, item); 
		}
		{
			ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fQuartz Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsQuartzBlock.containsKey(p.getName())){
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
			inv.setItem(24, item); 
		}
		{
			ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsLapisBlock.containsKey(p.getName())){
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
			inv.setItem(25, item); 
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dMagenta Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsMagentaGlass.containsKey(p.getName())){
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
			inv.setItem(26, item); 
		}
		{
			ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§0Coal Block Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsCoalBlock.containsKey(p.getName())){
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
			inv.setItem(27, item); 
		}
		{
			ItemStack item = new ItemStack(Material.EMERALD_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald Block Hat");
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
			inv.setItem(28, item);
		}
		{
			ItemStack item = new ItemStack(Material.MELON_BLOCK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Melon Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsMelon.containsKey(p.getName())){
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
			inv.setItem(29, item); 
		}
		{
			ItemStack item = new ItemStack(Material.GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fGlass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsGlass.containsKey(p.getName())){
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
			inv.setItem(30, item); 
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eYellow Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsYellowGlass.containsKey(p.getName())){
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
			inv.setItem(31, item); 
		}
		{
			ItemStack item = new ItemStack(Material.MYCEL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Mycelium Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsMycelium.containsKey(p.getName())){
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
			inv.setItem(32, item); 
		}
		{
			ItemStack item = new ItemStack(Material.LEAVES, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2Leaves Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsLeaves.containsKey(p.getName())){
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
			inv.setItem(33, item); 
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond Ore Hat");
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
			inv.setItem(34, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Orange Stained Glass Hat");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.hatsOrangeGlass.containsKey(p.getName())){
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
			ItemStack item = new ItemStack(Material.FIRE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nRemove Current Hat");
			item.setItemMeta(itemmeta);
			inv.setItem(50, item);
		}
		return inv;
	}
}
