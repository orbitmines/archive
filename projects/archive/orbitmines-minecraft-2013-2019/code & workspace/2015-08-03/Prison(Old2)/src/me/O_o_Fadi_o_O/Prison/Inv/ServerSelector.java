package me.O_o_Fadi_o_O.Prison.Inv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerSelector {
	
	public static Inventory sinv = Bukkit.createInventory(null, 27, "§0§lServer Selector");
	
	public Inventory getServerSelectorInv(Player p, int i){

		KitPvPServerItem(sinv, 1);
		PrisonServerItem(sinv, 1);
		CreativeServerItem(sinv, 1);
		SurvivalServerItem(sinv, 1);
		SkyBlockServerItem(sinv, 1);
		MiniGamesServerItem(sinv, 1);
		
		return sinv;
	}
	
	public static void KitPvPServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§c§lKitPvP §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lKitPvP §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(10, item);
		}
	}
	
	public static void PrisonServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§4§lPrison §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lPrison §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
	}
	
	public static void CreativeServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§d§lCreative §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lCreative §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(12, item);
		}
	}
	
	public static void SurvivalServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.STONE_HOE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§a§lSurvival §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lSurvival §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(14, item);
		}
	}
	
	public static void SkyBlockServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.GRASS, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§5§lSkyBlock §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lSkyBlock §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
	}
	
	public static void MiniGamesServerItem(Inventory inv, int i){
		
		{
			ItemStack item = new ItemStack(Material.BOW, 1);
			ItemMeta itemmeta = item.getItemMeta();
			List<String> itemlore = new ArrayList<String>();
			if(i == 1){
				itemmeta.setDisplayName("§f§lMiniGames §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§o§nClick Here to Connect");
				itemlore.add("");
			}
			if(i == 2){
				itemmeta.setDisplayName("§7§lMiniGames §8>> §71.7.9 - 1.7.10");
				itemlore.add("");
				itemlore.add("§7§oClick Here to Connect");
				itemlore.add("");
			}
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(16, item);
		}
	}

}
