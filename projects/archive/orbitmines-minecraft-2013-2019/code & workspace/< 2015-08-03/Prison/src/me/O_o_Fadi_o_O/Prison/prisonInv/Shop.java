package me.O_o_Fadi_o_O.Prison.prisonInv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.CustomItem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop {

	public static void openShopInv(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "§0§lShop");
		
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 10, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 11, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 12, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 13, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 14, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 15, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 16, false);
		
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 19, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 20, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 21, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 22, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 23, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 24, false);
		setItem(inv, p, false, Material.STAINED_GLASS_PANE, (short) 15, 1, "§8§l???", "", 0, 25, false);
		
		setRowBelowToDefault(inv, p);
		
		p.openInventory(inv);
	}
	
	public static void setInventoryToGold(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 1, "§61 Gold", "§81 Gold", 1*300, 10, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 4, "§64 Gold", "§84 Gold", 4*300, 11, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 8, "§68 Gold", "§88 Gold", 8*300, 12, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 16, "§616 Gold", "§816 Gold", 16*300, 13, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 32, "§632 Gold", "§832 Gold", 32*300, 14, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 48, "§648 Gold", "§848 Gold", 48*300, 15, false);
		setItem(inv, p, true, Material.GOLD_INGOT, (short) 0, 64, "§664 Gold", "§864 Gold", 64*300, 16, false);
		
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 1, "§61 Gold Block", "§81 Gold Block", 1*2700, 19, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 4, "§64 Gold Blocks", "§84 Gold Blocks", 4*2700, 20, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 8, "§68 Gold Blocks", "§88 Gold Blocks", 8*2700, 21, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 16, "§616 Gold Blocks", "§816 Gold Blocks", 16*2700, 22, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 32, "§632 Gold Blocks", "§832 Gold Blocks", 32*2700, 23, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 48, "§648 Gold Blocks", "§848 Gold Blocks", 48*2700, 24, false);
		setItem(inv, p, true, Material.GOLD_BLOCK, (short) 0, 64, "§664 Gold Blocks", "§864 Gold Blocks", 64*2700, 25, false);
		
		setItem(inv, p, false, Material.GOLD_INGOT, (short) 0, 1, "§6Gold", "", 0, 44, true);
	}
	
	public static void setInventoryToLapis(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 1, "§11 Lapis Lazuli", "§81 Lapis Lazuli", 1*50, 10, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 4, "§14 Lapis Lazuli", "§84 Lapis Lazuli", 4*50, 11, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 8, "§18 Lapis Lazuli", "§88 Lapis Lazuli", 8*50, 12, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 16, "§116 Lapis Lazuli", "§816 Lapis Lazuli", 16*50, 13, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 32, "§132 Lapis Lazuli", "§832 Lapis Lazuli", 32*50, 14, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 48, "§148 Lapis Lazuli", "§848 Lapis Lazuli", 48*50, 15, false);
		setItem(inv, p, true, Material.INK_SACK, (short) 4, 64, "§164 Lapis Lazuli", "§864 Lapis Lazuli", 64*50, 16, false);
		
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 1, "§11 Lapis Lazuli Block", "§81 Lapis Lazuli Block", 1*450, 19, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 4, "§14 Lapis Lazuli Blocks", "§84 Lapis Lazuli Blocks", 4*450, 20, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 8, "§18 Lapis Lazuli Blocks", "§88 Lapis Lazuli Blocks", 8*450, 21, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 16, "§116 Lapis Lazuli Blocks", "§816 Lapis Lazuli Blocks", 16*450, 22, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 32, "§132 Lapis Lazuli Blocks", "§832 Lapis Lazuli Blocks", 32*450, 23, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 48, "§148 Lapis Lazuli Blocks", "§848 Lapis Lazuli Blocks", 48*450, 24, false);
		setItem(inv, p, true, Material.LAPIS_BLOCK, (short) 0, 64, "§164 Lapis Lazuli Blocks", "§864 Lapis Lazuli Blocks", 64*450, 25, false);
		
		setItem(inv, p, false, Material.INK_SACK, (short) 4, 1, "§1Lapis Lazuli", "", 0, 43, true);
	}
	
	public static void setInventoryToRedstone(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 1, "§c1 Redstone", "§81 Redstone", 1*35, 10, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 4, "§c4 Redstone", "§84 Redstone", 4*35, 11, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 8, "§c8 Redstone", "§88 Redstone", 8*35, 12, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 16, "§c16 Redstone", "§816 Redstone", 16*35, 13, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 32, "§c32 Redstone", "§832 Redstone", 32*35, 14, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 48, "§c48 Redstone", "§848 Redstone", 48*35, 15, false);
		setItem(inv, p, true, Material.REDSTONE, (short) 0, 64, "§c64 Redstone", "§864 Redstone", 64*35, 16, false);
		
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 1, "§c1 Redstone Block", "§81 Redstone Block", 1*315, 19, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 4, "§c4 Redstone Blocks", "§84 Redstone Blocks", 4*315, 20, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 8, "§c8 Redstone Blocks", "§88 Redstone Blocks", 8*315, 21, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 16, "§c16 Redstone Blocks", "§816 Redstone Blocks", 16*315, 22, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 32, "§c32 Redstone Blocks", "§832 Redstone Blocks", 32*315, 23, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 48, "§c48 Redstone Blocks", "§848 Redstone Blocks", 48*315, 24, false);
		setItem(inv, p, true, Material.REDSTONE_BLOCK, (short) 0, 64, "§c64 Redstone Blocks", "§864 Redstone Blocks", 64*315, 25, false);
		
		setItem(inv, p, false, Material.REDSTONE, (short) 0, 1, "§cRedstone", "", 0, 42, true);
	}
	
	public static void setInventoryToEmerald(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 1, "§a1 Emerald", "§81 Emerald", 1*200, 10, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 4, "§a4 Emeralds", "§84 Emeralds", 4*200, 11, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 8, "§a8 Emeralds", "§88 Emeralds", 8*200, 12, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 16, "§a16 Emeralds", "§816 Emeralds", 16*200, 13, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 32, "§a32 Emeralds", "§832 Emeralds", 32*200, 14, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 48, "§a48 Emeralds", "§848 Emeralds", 48*200, 15, false);
		setItem(inv, p, true, Material.EMERALD, (short) 0, 64, "§a64 Emeralds", "§864 Emeralds", 64*200, 16, false);
		
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 1, "§a1 Emerald Block", "§81 Emerald Block", 1*1800, 19, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 4, "§a4 Emerald Blocks", "§84 Emerald Blocks", 4*1800, 20, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 8, "§a8 Emerald Blocks", "§88 Emerald Blocks", 8*1800, 21, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 16, "§a16 Emerald Blocks", "§816 Emerald Blocks", 16*1800, 22, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 32, "§a32 Emerald Blocks", "§832 Emerald Blocks", 32*1800, 23, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 48, "§a48 Emerald Blocks", "§848 Emerald Blocks", 48*1800, 24, false);
		setItem(inv, p, true, Material.EMERALD_BLOCK, (short) 0, 64, "§a64 Emerald Blocks", "§864 Emerald Blocks", 64*1800, 25, false);
		
		setItem(inv, p, false, Material.EMERALD, (short) 0, 1, "§aEmerald", "", 0, 41, true);
	}
	
	public static void setInventoryToDiamond(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 1, "§b1 Diamond", "§81 Diamond", 1*100, 10, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 4, "§b4 Diamonds", "§84 Diamonds", 4*100, 11, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 8, "§b8 Diamonds", "§88 Diamonds", 8*100, 12, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 16, "§b16 Diamonds", "§816 Diamonds", 16*100, 13, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 32, "§b32 Diamonds", "§832 Diamonds", 32*100, 14, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 48, "§b48 Diamonds", "§848 Diamonds", 48*100, 15, false);
		setItem(inv, p, true, Material.DIAMOND, (short) 0, 64, "§b64 Diamonds", "§864 Diamonds", 64*100, 16, false);
		
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 1, "§b1 Diamond Block", "§81 Diamond Block", 1*900, 19, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 4, "§b4 Diamond Blocks", "§84 Diamond Blocks", 4*900, 20, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 8, "§b8 Diamond Blocks", "§88 Diamond Blocks", 8*900, 21, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 16, "§b16 Diamond Blocks", "§816 Diamond Blocks", 16*900, 22, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 32, "§b32 Diamond Blocks", "§832 Diamond Blocks", 32*900, 23, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 48, "§b48 Diamond Blocks", "§848 Diamond Blocks", 48*900, 24, false);
		setItem(inv, p, true, Material.DIAMOND_BLOCK, (short) 0, 64, "§b64 Diamond Blocks", "§864 Diamond Blocks", 64*900, 25, false);
		
		setItem(inv, p, false, Material.DIAMOND, (short) 0, 1, "§bDiamond", "", 0, 40, true);
	}
	
	public static void setInventoryToIron(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 1, "§71 Iron Ingot", "§81 Iron Ingot", 1*25, 10, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 4, "§74 Iron Ingots", "§84 Iron Ingots", 4*25, 11, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 8, "§78 Iron Ingots", "§88 Iron Ingots", 8*25, 12, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 16, "§716 Iron Ingots", "§816 Iron Ingots", 16*25, 13, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 32, "§732 Iron Ingots", "§832 Iron Ingots", 32*25, 14, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 48, "§748 Iron Ingots", "§848 Iron Ingots", 48*25, 15, false);
		setItem(inv, p, true, Material.IRON_INGOT, (short) 0, 64, "§764 Iron Ingots", "§864 Iron Ingots", 64*25, 16, false);
		
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 1, "§71 Iron Block", "§81 Iron Block", 1*225, 19, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 4, "§74 Iron Blocks", "§84 Iron Blocks", 4*225, 20, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 8, "§78 Iron Blocks", "§88 Iron Blocks", 8*225, 21, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 16, "§716 Iron Blocks", "§816 Iron Blocks", 16*225, 22, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 32, "§732 Iron Blocks", "§832 Iron Blocks", 32*225, 23, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 48, "§748 Iron Blocks", "§848 Iron Blocks", 48*225, 24, false);
		setItem(inv, p, true, Material.IRON_BLOCK, (short) 0, 64, "§764 Iron Blocks", "§864 Iron Blocks", 64*225, 25, false);
		
		setItem(inv, p, false, Material.IRON_INGOT, (short) 0, 1, "§7Iron", "", 0, 39, true);
	}
	
	public static void setInventoryToCoal(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.COAL, (short) 0, 1, "§81 Coal", "§81 Coal", 1*10, 10, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 4, "§84 Coal", "§84 Coal", 4*10, 11, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 8, "§88 Coal", "§88 Coal", 8*10, 12, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 16, "§816 Coal", "§816 Coal", 16*10, 13, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 32, "§832 Coal", "§832 Coal", 32*10, 14, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 48, "§848 Coal", "§848 Coal", 48*10, 15, false);
		setItem(inv, p, true, Material.COAL, (short) 0, 64, "§864 Coal", "§864 Coal", 64*10, 16, false);
		
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 1, "§81 Coal Block", "§81 Coal Block", 1*90, 19, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 4, "§84 Coal Blocks", "§84 Coal Blocks", 4*90, 20, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 8, "§88 Coal Blocks", "§88 Coal Blocks", 8*90, 21, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 16, "§816 Coal Blocks", "§816 Coal Blocks", 16*90, 22, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 32, "§832 Coal Blocks", "§832 Coal Blocks", 32*90, 23, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 48, "§848 Coal Blocks", "§848 Coal Blocks", 48*90, 24, false);
		setItem(inv, p, true, Material.COAL_BLOCK, (short) 0, 64, "§864 Coal Blocks", "§864 Coal Blocks", 64*90, 25, false);
		
		setItem(inv, p, false, Material.COAL, (short) 0, 1, "§8Coal", "", 0, 38, true);
	}
	
	public static void setInventoryToStone(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 1, "§71 Cobblestone", "§81 Cobblestone", 1*2, 10, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 4, "§74 Cobblestone", "§84 Cobblestone", 4*2, 11, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 8, "§78 Cobblestone", "§88 Cobblestone", 8*2, 12, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 16, "§716 Cobblestone", "§816 Cobblestone", 16*2, 13, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 32, "§732 Cobblestone", "§832 Cobblestone", 32*2, 14, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 48, "§748 Cobblestone", "§848 Cobblestone", 48*2, 15, false);
		setItem(inv, p, true, Material.COBBLESTONE, (short) 0, 64, "§764 Cobblestone", "§864 Cobblestone", 64*2, 16, false);
		
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 1, "§71 Stone Brick", "§81 Stone Brick", 1*7, 19, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 4, "§74 Stone Bricks", "§84 Stone Bricks", 4*7, 20, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 8, "§78 Stone Bricks", "§88 Stone Bricks", 8*7, 21, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 16, "§716 Stone Bricks", "§816 Stone Bricks", 16*7, 22, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 32, "§732 Stone Bricks", "§832 Stone Bricks", 32*7, 23, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 48, "§748 Stone Bricks", "§848 Stone Bricks", 48*7, 24, false);
		setItem(inv, p, true, Material.SMOOTH_BRICK, (short) 0, 64, "§764 Stone Bricks", "§864 Stone Bricks", 64*7, 25, false);
		
		setItem(inv, p, false, Material.COBBLESTONE, (short) 0, 1, "§7Stone", "", 0, 37, true);
	}
	
	public static void setInventoryToWood(Inventory inv, Player p){
		setRowBelowToDefault(inv, p);
		setItem(inv, p, true, Material.LOG, (short) 0, 1, "§e1 Oak Log", "§81 Oak Log", 1*5, 10, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 4, "§e4 Oak Logs", "§84 Oak Logs", 4*5, 11, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 8, "§e8 Oak Logs", "§88 Oak Logs", 8*5, 12, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 16, "§e16 Oak Logs", "§816 Oak Logs", 16*5, 13, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 32, "§e32 Oak Logs", "§832 Oak Logs", 32*5, 14, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 48, "§e48 Oak Logs", "§848 Oak Logs", 48*5, 15, false);
		setItem(inv, p, true, Material.LOG, (short) 0, 64, "§e64 Oak Logs", "§864 Oak Logs", 64*5, 16, false);
		
		setItem(inv, p, true, Material.WOOD, (short) 0, 1, "§e1 Oak Plank", "§81 Oak Plank", 1*1, 19, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 4, "§e4 Oak Planks", "§84 Oak Planks", 4*1, 20, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 8, "§e8 Oak Planks", "§88 Oak Planks", 8*1, 21, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 16, "§e16 Oak Planks", "§816 Oak Planks", 16*1, 22, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 32, "§e32 Oak Planks", "§832 Oak Planks", 32*1, 23, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 48, "§e48 Oak Planks", "§848 Oak Planks", 48*1, 24, false);
		setItem(inv, p, true, Material.WOOD, (short) 0, 64, "§e64 Oak Planks", "§864 Oak Planks", 64*1, 25, false);
		
		setItem(inv, p, false, Material.LOG, (short) 0, 1, "§eWood", "", 0, 36, true);
	}
	
	public static void setRowBelowToDefault(Inventory inv, Player p){
		setItem(inv, p, false, Material.LOG, (short) 0, 1, "§eWood", "", 0, 36, false);
		setItem(inv, p, false, Material.COBBLESTONE, (short) 0, 1, "§7Stone", "", 0, 37, false);
		setItem(inv, p, false, Material.COAL, (short) 0, 1, "§8Coal", "", 0, 38, false);
		setItem(inv, p, false, Material.IRON_INGOT, (short) 0, 1, "§7Iron", "", 0, 39, false);
		setItem(inv, p, false, Material.DIAMOND, (short) 0, 1, "§bDiamond", "", 0, 40, false);
		setItem(inv, p, false, Material.EMERALD, (short) 0, 1, "§aEmerald", "", 0, 41, false);
		setItem(inv, p, false, Material.REDSTONE, (short) 0, 1, "§cRedstone", "", 0, 42, false);
		setItem(inv, p, false, Material.INK_SACK, (short) 4, 1, "§1Lapis Lazuli", "", 0, 43, false);
		setItem(inv, p, false, Material.GOLD_INGOT, (short) 0, 1, "§6Gold", "", 0, 44, false);
	}
	
	public static void setItem(Inventory inv, Player p, boolean forSellItem, Material material, short durability, int amount, String displayName, String displayNameIfFailed, int goldReward, int slot, boolean setGlowing){
		
		if(forSellItem == true){
			ItemStack rItem = new ItemStack(material);
			rItem.setDurability(durability);
			
			if(p.getInventory().containsAtLeast(rItem, amount)){
				ItemStack item = new ItemStack(material, amount);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(displayName);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§2Reward: §6§l" + goldReward + " Gold");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(durability);
				if(setGlowing == true){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				}
				item = CustomItem.hideFlags(item, 3);
				inv.setItem(slot, item);
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(displayNameIfFailed);
				List<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add("§cReward: §6§l" + goldReward + " Gold");
				lore.add("");
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability((short) 15);
				if(setGlowing == true){
					item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				}
				item = CustomItem.hideFlags(item, 3);
				inv.setItem(slot, item);
			}
		}
		else{
			ItemStack item = new ItemStack(material, amount);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(displayName);
			item.setItemMeta(meta);
			item.setDurability(durability);
			if(setGlowing == true){
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}
			item = CustomItem.hideFlags(item, 3);
			inv.setItem(slot, item);
		}
	}
}
