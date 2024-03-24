package me.O_o_Fadi_o_O.Survival.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.O_o_Fadi_o_O.Survival.DisguisePlayer;
import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RegionManager {

	Start start = Start.getInstance();
	NPCManager nmanager = new NPCManager();
	
	private static Inventory inv = Bukkit.createInventory(null, 45, "§0§lRegion Teleporter");
	
	public static Inventory getRegionInv(Player p){		
		return inv;
	}
	
	private static void createRegionInv(){
		inv.setItem(22, getRegionItem(1));
		inv.setItem(21, getRegionItem(2));
		inv.setItem(20, getRegionItem(3));
		inv.setItem(19, getRegionItem(4));
		inv.setItem(18, getRegionItem(5));
		inv.setItem(13, getRegionItem(6));
		inv.setItem(4, getRegionItem(7));
		inv.setItem(23, getRegionItem(8));
		inv.setItem(24, getRegionItem(9));
		inv.setItem(25, getRegionItem(10));
		inv.setItem(26, getRegionItem(11));
		inv.setItem(31, getRegionItem(12));
		inv.setItem(40, getRegionItem(13));
		inv.setItem(12, getRegionItem(14));
		inv.setItem(3, getRegionItem(15));
		inv.setItem(11, getRegionItem(16));
		inv.setItem(2, getRegionItem(17));
		inv.setItem(10, getRegionItem(18));
		inv.setItem(1, getRegionItem(19));
		inv.setItem(9, getRegionItem(20));
		inv.setItem(0, getRegionItem(21));
		inv.setItem(14, getRegionItem(22));
		inv.setItem(5, getRegionItem(23));
		inv.setItem(15, getRegionItem(24));
		inv.setItem(6, getRegionItem(25));
		inv.setItem(16, getRegionItem(26));
		inv.setItem(7, getRegionItem(27));
		inv.setItem(17, getRegionItem(28));
		inv.setItem(8, getRegionItem(29));
		inv.setItem(32, getRegionItem(30));
		inv.setItem(41, getRegionItem(31));
		inv.setItem(33, getRegionItem(32));
		inv.setItem(42, getRegionItem(33));
		inv.setItem(34, getRegionItem(34));
		inv.setItem(43, getRegionItem(35));
		inv.setItem(35, getRegionItem(36));
		inv.setItem(44, getRegionItem(37));
		inv.setItem(30, getRegionItem(38));
		inv.setItem(39, getRegionItem(39));
		inv.setItem(29, getRegionItem(40));
		inv.setItem(38, getRegionItem(41));
		inv.setItem(28, getRegionItem(42));
		inv.setItem(37, getRegionItem(43));
		inv.setItem(27, getRegionItem(44));
		inv.setItem(36, getRegionItem(45));
	}
	
	public static void teleportToRegion(Player p, int region){
		p.teleport(StorageManager.regionlocation.get(region));
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
		TitleManager.setTitle(p, "", "§7Teleported to §aRegion " + region + "§7.");
		if(StorageManager.disguise.containsKey(p)){
			DisguisePlayer.undisguisePlayer(p);
		}
	}
	
	public static ItemStack getRegionItem(int region){
		
		Biome b = StorageManager.regionbiome.get(region);
		String bstring = getBiomeName(b);
		Location l = StorageManager.regionlocation.get(region);
		String lstring = " §7XYZ: §a" + l.getBlockX() + " §7/ §a" + l.getBlockY() + " §7/ §a" + l.getBlockZ();
		
		ItemStack item = getRegionItemType(b);
		item.setAmount(region);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§7§lRegion §a§l" + region);
		List<String> lore = new ArrayList<String>();
		lore.add(" §7Biome: " + bstring);
		lore.add(lstring);
		meta.setLore(lore);
		item.setItemMeta(meta);

		return item;
	}
	
	public void registerRegions(World w){
		{
			Location l = new Location(w, -445.5, 67, -279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(1, l);
			StorageManager.regionbiome.put(1, Biome.BIRCH_FOREST);
			StorageManager.regionblocks.put(1, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 84, -1279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(2, l);
			StorageManager.regionbiome.put(2, Biome.FOREST_HILLS);
			StorageManager.regionblocks.put(2, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 63, -2279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(3, l);
			StorageManager.regionbiome.put(3, Biome.SWAMPLAND);
			StorageManager.regionblocks.put(3, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 72, -3279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(4, l);
			StorageManager.regionbiome.put(4, Biome.EXTREME_HILLS);
			StorageManager.regionblocks.put(4, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 63, -4279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(5, l);
			StorageManager.regionbiome.put(5, Biome.RIVER);
			StorageManager.regionblocks.put(5, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 68, -279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(6, l);
			StorageManager.regionbiome.put(6, Biome.SAVANNA);
			StorageManager.regionblocks.put(6, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 63, -279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(7, l);
			StorageManager.regionbiome.put(7, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(7, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 63, 721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(8, l);
			StorageManager.regionbiome.put(8, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(8, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 63, 1721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(9, l);
			StorageManager.regionbiome.put(9, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(9, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 80, 2721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(10, l);
			StorageManager.regionbiome.put(10, Biome.FOREST_HILLS);
			StorageManager.regionblocks.put(10, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -445.5, 63, 3721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(11, l);
			StorageManager.regionbiome.put(11, Biome.BEACH);
			StorageManager.regionblocks.put(11, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 69, -279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(12, l);
			StorageManager.regionbiome.put(12, Biome.FOREST);
			StorageManager.regionblocks.put(12, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 64, -279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(13, l);
			StorageManager.regionbiome.put(13, Biome.ROOFED_FOREST);
			StorageManager.regionblocks.put(13, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 63, -1279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(14, l);
			StorageManager.regionbiome.put(14, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(14, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 70, -1279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(15, l);
			StorageManager.regionbiome.put(15, Biome.SAVANNA);
			StorageManager.regionblocks.put(15, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 71, -2279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(16, l);
			StorageManager.regionbiome.put(16, Biome.TAIGA);
			StorageManager.regionblocks.put(16, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 63, -2279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(17, l);
			StorageManager.regionbiome.put(17, Biome.OCEAN);
			StorageManager.regionblocks.put(17, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 63, -3279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(18, l);
			StorageManager.regionbiome.put(18, Biome.OCEAN);
			StorageManager.regionblocks.put(18, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 63, -3279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(19, l);
			StorageManager.regionbiome.put(19, Biome.OCEAN);
			StorageManager.regionblocks.put(19, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 67, -4279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(20, l);
			StorageManager.regionbiome.put(20, Biome.FOREST_HILLS);
			StorageManager.regionblocks.put(20, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 71, -4279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(21, l);
			StorageManager.regionbiome.put(21, Biome.SAVANNA);
			StorageManager.regionblocks.put(21, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 63, 721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(22, l);
			StorageManager.regionbiome.put(22, Biome.OCEAN);
			StorageManager.regionblocks.put(22, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 65, 721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(23, l);
			StorageManager.regionbiome.put(23, Biome.BEACH);
			StorageManager.regionblocks.put(23, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 66, 1721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(24, l);
			StorageManager.regionbiome.put(24, Biome.SWAMPLAND);
			StorageManager.regionblocks.put(24, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 63, 1721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(25, l);
			StorageManager.regionbiome.put(25, Biome.DESERT);
			StorageManager.regionblocks.put(25, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 70, 2721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(26, l);
			StorageManager.regionbiome.put(26, Biome.FOREST);
			StorageManager.regionblocks.put(26, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 63, 2721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(27, l);
			StorageManager.regionbiome.put(27, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(27, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 1055.5, 73, 3721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(28, l);
			StorageManager.regionbiome.put(28, Biome.COLD_TAIGA);
			StorageManager.regionblocks.put(28, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, 2555.5, 66, 3721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(29, l);
			StorageManager.regionbiome.put(29, Biome.DEEP_OCEAN);
			StorageManager.regionblocks.put(29, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 65, 721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(30, l);
			StorageManager.regionbiome.put(30, Biome.SWAMPLAND);
			StorageManager.regionblocks.put(30, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 64, 721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(31, l);
			StorageManager.regionbiome.put(31, Biome.PLAINS);
			StorageManager.regionblocks.put(31, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 80, 1721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(32, l);
			StorageManager.regionbiome.put(32, Biome.FOREST);
			StorageManager.regionblocks.put(32, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 86, 1721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(33, l);
			StorageManager.regionbiome.put(33, Biome.EXTREME_HILLS);
			StorageManager.regionblocks.put(33, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 66, 2721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(34, l);
			StorageManager.regionbiome.put(34, Biome.FOREST);
			StorageManager.regionblocks.put(34, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 68, 2721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(35, l);
			StorageManager.regionbiome.put(35, Biome.ICE_PLAINS);
			StorageManager.regionblocks.put(35, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 63, 3721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(36, l);
			StorageManager.regionbiome.put(36, Biome.RIVER);
			StorageManager.regionblocks.put(36, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 71, 3721.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(37, l);
			StorageManager.regionbiome.put(37, Biome.TAIGA);
			StorageManager.regionblocks.put(37, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 67, -1279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(38, l);
			StorageManager.regionbiome.put(38, Biome.TAIGA);
			StorageManager.regionblocks.put(38, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 66, -1279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(39, l);
			StorageManager.regionbiome.put(39, Biome.PLAINS);
			StorageManager.regionblocks.put(39, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 71, -2279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(40, l);
			StorageManager.regionbiome.put(40, Biome.PLAINS);
			StorageManager.regionblocks.put(40, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 72, -2279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(41, l);
			StorageManager.regionbiome.put(41, Biome.BIRCH_FOREST);
			StorageManager.regionblocks.put(41, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 64, -3279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(42, l);
			StorageManager.regionbiome.put(42, Biome.BEACH);
			StorageManager.regionblocks.put(42, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 70, -3279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(43, l);
			StorageManager.regionbiome.put(43, Biome.PLAINS);
			StorageManager.regionblocks.put(43, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -1945.5, 67, -4279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(44, l);
			StorageManager.regionbiome.put(44, Biome.PLAINS);
			StorageManager.regionblocks.put(44, start.getBlocksBetween(l2, l3));
		}
		{
			Location l = new Location(w, -3445.5, 63, -4279.5, -70, -90);
			Location l2 = new Location(w, l.getX() +8, 70, l.getZ() +8);
			Location l3 = new Location(w, l.getX() -8, 70, l.getZ() -8);
			StorageManager.regionlocation.put(45, l);
			StorageManager.regionbiome.put(45, Biome.TAIGA);
			StorageManager.regionblocks.put(45, start.getBlocksBetween(l2, l3));
		}
		createRegionInv();
	}
	
	private static Map<String, Long> lastinteract = new HashMap<String, Long>();
	private static int interactcooldown = 2;
	
	public static boolean isBlockInRegion(Player p, Block b){

		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				for(int i = 1; i <= StorageManager.regionlocation.size(); i++){
					
					for(Block block : StorageManager.regionblocks.get(i)){
						Block b2 = block.getWorld().getBlockAt(block.getLocation().getBlockX(), b.getLocation().getBlockY(), block.getLocation().getBlockZ());
		
						if(b2.getLocation().getBlockX() == b.getLocation().getBlockX() && b2.getLocation().getBlockZ() == b.getLocation().getBlockZ()){
							long lastinteracted = 0;
							if(lastinteract.containsKey(p.getName())){
								lastinteracted = lastinteract.get(p.getName());
							}
							int cdmillis = interactcooldown * 1000;
									
							if(System.currentTimeMillis()-lastinteracted>=cdmillis){
								p.sendMessage("§a§lRegions §8| §7You cannot do such things that close to a Region!");
								lastinteract.put(p.getName(), System.currentTimeMillis());
							}
							return true;
						}
					}
				}
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
		
		return false;
	}
	
	private static ItemStack getRegionItemType(Biome b){
		ItemStack item = new ItemStack(Material.AIR, 1);
		switch(b){
			case BEACH:
				item.setType(Material.SAND); item.setDurability((short) 0);
				break;
			case BIRCH_FOREST:
				item.setType(Material.SAPLING); item.setDurability((short) 2);
				break;
			case BIRCH_FOREST_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 2);
				break;
			case BIRCH_FOREST_HILLS_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 2);
				break;
			case BIRCH_FOREST_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 2);
				break;
			case COLD_BEACH:
				item.setType(Material.SAND); item.setDurability((short) 0);
				break;
			case COLD_TAIGA:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case COLD_TAIGA_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case COLD_TAIGA_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case DEEP_OCEAN:
				item.setType(Material.WATER_BUCKET); item.setDurability((short) 0);
				break;
			case DESERT:
				item.setType(Material.SAND); item.setDurability((short) 0);
				break;
			case DESERT_HILLS:
				item.setType(Material.SAND); item.setDurability((short) 0);
				break;
			case DESERT_MOUNTAINS:
				item.setType(Material.SAND); item.setDurability((short) 0);
				break;
			case EXTREME_HILLS:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case EXTREME_HILLS_MOUNTAINS:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case EXTREME_HILLS_PLUS:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case EXTREME_HILLS_PLUS_MOUNTAINS:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case FLOWER_FOREST:
				item.setType(Material.RED_ROSE); item.setDurability((short) 0);
				break;
			case FOREST:
				item.setType(Material.SAPLING); item.setDurability((short) 0);
				break;
			case FOREST_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 0);
				break;
			case FROZEN_OCEAN:
				item.setType(Material.ICE); item.setDurability((short) 0);
				break;
			case FROZEN_RIVER:
				item.setType(Material.ICE); item.setDurability((short) 0);
				break;
			case HELL:
				item.setType(Material.NETHERRACK); item.setDurability((short) 0);
				break;
			case ICE_MOUNTAINS:
				item.setType(Material.ICE); item.setDurability((short) 0);
				break;
			case ICE_PLAINS:
				item.setType(Material.ICE); item.setDurability((short) 0);
				break;
			case ICE_PLAINS_SPIKES:
				item.setType(Material.ICE); item.setDurability((short) 0);
				break;
			case JUNGLE:
				item.setType(Material.SAPLING); item.setDurability((short) 3);
				break;
			case JUNGLE_EDGE:
				item.setType(Material.SAPLING); item.setDurability((short) 3);
				break;
			case JUNGLE_EDGE_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 3);
				break;
			case JUNGLE_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 3);
				break;
			case JUNGLE_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 3);
				break;
			case MEGA_SPRUCE_TAIGA:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case MEGA_SPRUCE_TAIGA_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case MEGA_TAIGA:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case MEGA_TAIGA_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case MESA:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MESA_BRYCE:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MESA_PLATEAU:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MESA_PLATEAU_FOREST:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MESA_PLATEAU_FOREST_MOUNTAINS:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MESA_PLATEAU_MOUNTAINS:
				item.setType(Material.STAINED_CLAY); item.setDurability((short) 4);
				break;
			case MUSHROOM_ISLAND:
				item.setType(Material.HUGE_MUSHROOM_2); item.setDurability((short) 0);
				break;
			case MUSHROOM_SHORE:
				item.setType(Material.HUGE_MUSHROOM_2); item.setDurability((short) 0);
				break;
			case OCEAN:
				item.setType(Material.WATER_BUCKET); item.setDurability((short) 0);
				break;
			case PLAINS:
				item.setType(Material.GRASS); item.setDurability((short) 0);
				break;
			case RIVER:
				item.setType(Material.WATER_BUCKET); item.setDurability((short) 0);
				break;
			case ROOFED_FOREST:
				item.setType(Material.SAPLING); item.setDurability((short) 5);
				break;
			case ROOFED_FOREST_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 5);
				break;
			case SAVANNA:
				item.setType(Material.SAPLING); item.setDurability((short) 4);
				break;
			case SAVANNA_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 4);
				break;
			case SAVANNA_PLATEAU:
				item.setType(Material.SAPLING); item.setDurability((short) 4);
				break;
			case SAVANNA_PLATEAU_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 4);
				break;
			case SKY:
				item.setType(Material.SNOW_BLOCK); item.setDurability((short) 0);
				break;
			case SMALL_MOUNTAINS:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case STONE_BEACH:
				item.setType(Material.STONE); item.setDurability((short) 0);
				break;
			case SUNFLOWER_PLAINS:
				item.setType(Material.DOUBLE_PLANT); item.setDurability((short) 0);
				break;
			case SWAMPLAND:
				item.setType(Material.VINE); item.setDurability((short) 0);
				break;
			case SWAMPLAND_MOUNTAINS:
				item.setType(Material.VINE); item.setDurability((short) 0);
				break;
			case TAIGA:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case TAIGA_HILLS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			case TAIGA_MOUNTAINS:
				item.setType(Material.SAPLING); item.setDurability((short) 1);
				break;
			default:
				break;
		}
		
		return item;
	}
	
	public static String getBiomeName(Biome b){
		
		switch(b){
			case BEACH:
				return "§eBeach"; 
			case BIRCH_FOREST:
				return "§fBirch Forest"; 
			case BIRCH_FOREST_HILLS:
				return "§fBirch Forest Hills"; 
			case BIRCH_FOREST_HILLS_MOUNTAINS:
				return "§fBirch Forest Mountain Hills"; 
			case BIRCH_FOREST_MOUNTAINS:
				return "§fBirch Forest Mountains"; 
			case COLD_BEACH:
				return "§bCold Beach"; 
			case COLD_TAIGA:
				return "§2Cold Taiga"; 
			case COLD_TAIGA_HILLS:
				return "§2Cold Taiga Hills"; 
			case COLD_TAIGA_MOUNTAINS:
				return "§2Cold Taiga Mountains"; 
			case DEEP_OCEAN:
				return "§9Deep Ocean"; 
			case DESERT:
				return "§eDesert"; 
			case DESERT_HILLS:
				return "§eDesert Hills"; 
			case DESERT_MOUNTAINS:
				return "§eDesert Mountains"; 
			case EXTREME_HILLS:
				return "§7Extreme Hills"; 
			case EXTREME_HILLS_MOUNTAINS:
				return "§7Extreme Mountain Hills"; 
			case EXTREME_HILLS_PLUS:
				return "§7Extreme Hills"; 
			case EXTREME_HILLS_PLUS_MOUNTAINS:
				return "§7Extreme Mountain Hills"; 
			case FLOWER_FOREST:
				return "§cFlower Forest"; 
			case FOREST:
				return "§aForest"; 
			case FOREST_HILLS:
				return "§aForest Hills"; 
			case FROZEN_OCEAN:
				return "§bFrozen Ocean"; 
			case FROZEN_RIVER:
				return "§fFrozen River"; 
			case HELL:
				return "§cNether"; 
			case ICE_MOUNTAINS:
				return "§bCold Mountains"; 
			case ICE_PLAINS:
				return "§bIce Plains"; 
			case ICE_PLAINS_SPIKES:
				return "§bIce Spike Plains"; 
			case JUNGLE:
				return "§2Jungle"; 
			case JUNGLE_EDGE:
				return "§2Jungle"; 
			case JUNGLE_EDGE_MOUNTAINS:
				return "§2Jungle Mountains"; 
			case JUNGLE_HILLS:
				return "§2Jungle Hills"; 
			case JUNGLE_MOUNTAINS:
				return "§2Jungle Mountains"; 
			case MEGA_SPRUCE_TAIGA:
				return "§2Mega Taiga"; 
			case MEGA_SPRUCE_TAIGA_HILLS:
				return "§2Mega Taiga Hills"; 
			case MEGA_TAIGA:
				return "§2Mega Taiga"; 
			case MEGA_TAIGA_HILLS:
				return "§2Mega Taiga Hills"; 
			case MESA:
				return "§6Mesa"; 
			case MESA_BRYCE:
				return "§6Mesa"; 
			case MESA_PLATEAU:
				return "§6Mesa"; 
			case MESA_PLATEAU_FOREST:
				return "§6Mesa"; 
			case MESA_PLATEAU_FOREST_MOUNTAINS:
				return "§6Mesa"; 
			case MESA_PLATEAU_MOUNTAINS:
				return "§6Mesa"; 
			case MUSHROOM_ISLAND:
				return "§cMushroom"; 
			case MUSHROOM_SHORE:
				return "§cMushroom"; 
			case OCEAN:
				return "§9Ocean"; 
			case PLAINS:
				return "§aPlains"; 
			case RIVER:
				return "§9River"; 
			case ROOFED_FOREST:
				return "§2Roofed Forest"; 
			case ROOFED_FOREST_MOUNTAINS:
				return "§2Roofed Mountain Forest"; 
			case SAVANNA:
				return "§eSavanna"; 
			case SAVANNA_MOUNTAINS:
				return "§eSavanna Mountains"; 
			case SAVANNA_PLATEAU:
				return "§eSavanna"; 
			case SAVANNA_PLATEAU_MOUNTAINS:
				return "§eSavanna Mountains"; 
			case SKY:
				return "§fSky"; 
			case SMALL_MOUNTAINS:
				return "§7Mountains"; 
			case STONE_BEACH:
				return "§7Stone Beach"; 
			case SUNFLOWER_PLAINS:
				return "§6Sunflower Plains"; 
			case SWAMPLAND:
				return "§8Swampland"; 
			case SWAMPLAND_MOUNTAINS:
				return "§8Swampland"; 
			case TAIGA:
				return "§2Taiga"; 
			case TAIGA_HILLS:
				return "§2Taiga Hills"; 
			case TAIGA_MOUNTAINS:
				return "§2Taiga Mountains"; 
			default:
				return null;
		}
	}
}
