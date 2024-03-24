package me.O_o_Fadi_o_O.KitPvP.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.Trail;
import me.O_o_Fadi_o_O.KitPvP.utils.TrailType;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Trails {

	Start start = Start.getInstance();
	
	public static Inventory getTrailsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lTrails");
		{
			ItemStack item = new ItemStack(Material.FIREWORK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cFireWork Spark Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trails.get(Trail.FIREWORK_SPARK).contains(p)){
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
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STALK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cHeart Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trails.get(Trail.HEART).contains(p)){
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
			if(!StorageManager.trails.get(Trail.TNT).contains(p)){
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
			if(!PlayerManager.hasVIPPerms(p, VIPRank.Iron_VIP)){
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
			if(!StorageManager.trails.get(Trail.ANGRY_VILLAGER).contains(p)){
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
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trails.get(Trail.SLIME).contains(p)){
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
			if(!StorageManager.trails.get(Trail.SMOKE).contains(p)){
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
			if(!StorageManager.trails.get(Trail.WITCH).contains(p)){
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
			if(!StorageManager.trails.get(Trail.CRIT).contains(p)){
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
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(19, item);
		}
		{
			ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9Water Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trails.get(Trail.WATER).contains(p)){
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
			if(!StorageManager.trails.get(Trail.MUSIC).contains(p)){
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
			if(!StorageManager.trails.get(Trail.SNOW).contains(p)){
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
			if(!StorageManager.trails.get(Trail.ENCHANTMENT_TABLE).contains(p)){
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
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.WEB, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fBubble Trail");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!StorageManager.trails.get(Trail.BUBBLE).contains(p)){
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
			if(!StorageManager.trails.get(Trail.MOB_SPAWNER).contains(p)){
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
			ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§nTrail Settings");	
			item.setItemMeta(itemmeta);
			inv.setItem(40, item);
		}
		{
			ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nRemove Current Trail");
			item.setItemMeta(itemmeta);
			inv.setItem(41, item);
		}
		return inv;
	}
	
	public static Inventory setTrailSettingsInv(Player p){
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lTrail Settings");
		{
			ItemStack item = new ItemStack(Material.COMPASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Trail Types");
			item.setItemMeta(itemmeta);
			inv.setItem(4, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtype.get(p) == TrailType.BASIC_TRAIL){
				itemmeta.setDisplayName("§7§lBasic Trail: §a§lENABLED");
				item.setDurability((short) 5);
				
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			else{
				itemmeta.setDisplayName("§7§lBasic Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtypes.get(TrailType.GROUND_TRAIL).contains(p)){
				if(StorageManager.trailtype.get(p) == TrailType.GROUND_TRAIL){
					itemmeta.setDisplayName("§7§lGround Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lGround Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lGround Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b600 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtypes.get(TrailType.HEAD_TRAIL).contains(p)){
				if(StorageManager.trailtype.get(p) == TrailType.HEAD_TRAIL){
					itemmeta.setDisplayName("§7§lHead Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lHead Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lHead Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtypes.get(TrailType.BODY_TRAIL).contains(p)){
				if(StorageManager.trailtype.get(p) == TrailType.BODY_TRAIL){
					itemmeta.setDisplayName("§7§lBody Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lBody Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lBody Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b400 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtypes.get(TrailType.BIG_TRAIL).contains(p)){
				if(StorageManager.trailtype.get(p) == TrailType.BIG_TRAIL){
					itemmeta.setDisplayName("§7§lBig Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lBig Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lBig Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b650 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailtypes.get(TrailType.VERTICAL_TRAIL).contains(p)){
				if(StorageManager.trailtype.get(p) == TrailType.VERTICAL_TRAIL){
					itemmeta.setDisplayName("§7§lVertical Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lVertical Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lVertical Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
		
		inv.setItem(15, getComingSoonTrailType());
		inv.setItem(16, getComingSoonTrailType());
		inv.setItem(17, getComingSoonTrailType());
		inv.setItem(18, getComingSoonTrailType());
		inv.setItem(19, getComingSoonTrailType());
		inv.setItem(20, getComingSoonTrailType());
		inv.setItem(21, getComingSoonTrailType());
		inv.setItem(22, getComingSoonTrailType());
		inv.setItem(23, getComingSoonTrailType());
		inv.setItem(24, getComingSoonTrailType());
		inv.setItem(25, getComingSoonTrailType());
		inv.setItem(26, getComingSoonTrailType());
		
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(StorageManager.trailspecial.containsKey(p)){
				if(StorageManager.trailspecial.get(p) == true){
					itemmeta.setDisplayName("§7§lSpecial Trail: §a§lENABLED");
					item.setDurability((short) 5);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Activate");
				}
				else{
					itemmeta.setDisplayName("§7§lSpecial Trail: §c§lDISABLED");
					item.setDurability((short) 14);
					
					itemlore.add("§a§lUnlocked");
					itemlore.add("§7§o§nClick Here to Deactivate");
				}
			}
			else{
				itemmeta.setDisplayName("§7§lSpecial Trail: §c§lDISABLED");
				item.setDurability((short) 14);
				
				itemlore.add("§c§oPrice: §b750 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(37, item);
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STAR, StorageManager.trailparticlesamount.get(p));
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(PlayerManager.hasVIPPerms(p, VIPRank.Gold_VIP)){
				itemmeta.setDisplayName("§7§lParticle Amount: §f§l" + StorageManager.trailparticlesamount.get(p));
				
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Change");
			}
			else{
				itemmeta.setDisplayName("§7§lParticle Amount: §f§l" + StorageManager.trailparticlesamount.get(p));
				
				itemlore.add("§c§oRequired: §6§lGold VIP");
				itemlore.add("§7§o§n(Change Particle Amount)");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(43, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(49, item);
		}
		
		return inv;
	}
	
	private static ItemStack getComingSoonTrailType(){
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§fComing Soon...");
		item.setItemMeta(itemmeta);
		
		return item;
	}
}
