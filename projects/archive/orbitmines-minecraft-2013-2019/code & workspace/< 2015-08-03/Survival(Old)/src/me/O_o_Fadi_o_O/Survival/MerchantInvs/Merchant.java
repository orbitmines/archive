package me.O_o_Fadi_o_O.Survival.MerchantInvs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Managers.MerchantManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Merchant {

	public static Inventory getMerchantInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMerchant");
		
		/*
		 * 1
		 */
		String h1 = getHighest1();
		if(!h1.equals("")){
			
			inv.setItem(0, getHighestItemStack(h1));	
		}
		else{
			inv.setItem(22, getNoDealsItemStack());
		}
		
		/*
		 * 2
		 */
		String h2 = getHighest2(h1);
		if(!h2.equals("")){
			inv.setItem(1, getHighestItemStack(h2));	
		}
		
		/*
		 * 3
		 */
		String h3 = getHighest3(h1, h2);
		if(!h3.equals("")){
			inv.setItem(2, getHighestItemStack(h3));	
		}
		
		/*
		 * 4
		 */
		String h4 = getHighest4(h1, h2, h3);
		if(!h4.equals("")){
			inv.setItem(3, getHighestItemStack(h4));	
		}
		
		/*
		 * 5
		 */
		String h5 = getHighest5(h1, h2, h3, h4);
		if(!h5.equals("")){
			inv.setItem(4, getHighestItemStack(h5));	
		}
		
		/*
		 * 6
		 */
		String h6 = getHighest6(h1, h2, h3, h4, h5);
		if(!h6.equals("")){
			inv.setItem(5, getHighestItemStack(h6));	
		}
		
		/*
		 * 7
		 */
		String h7 = getHighest7(h1, h2, h3, h4, h5, h6);
		if(!h7.equals("")){
			inv.setItem(6, getHighestItemStack(h7));	
		}
		
		/*
		 * 8
		 */
		String h8 = getHighest8(h1, h2, h3, h4, h5, h6, h7);
		if(!h8.equals("")){
			inv.setItem(7, getHighestItemStack(h8));	
		}
		return inv;

	}
	
	public static ItemStack getHighestItemStack(String h){
		
		if(h.equals("Coal")){
			int i = MerchantManager.CoalDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.COAL, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Coal");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.CoalDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("IronIngot")){
			int i = MerchantManager.IronIngotDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.IRON_INGOT, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Ingot");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.IronIngotDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("Cobblestone")){
			int i = MerchantManager.CobblestoneDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.COBBLESTONE, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Cobblestone");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.CobblestoneDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("LapisLazuli")){
			int i = MerchantManager.LapisLazuliDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.INK_SACK, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Lazuli");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.LapisLazuliDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 4);
			
			return item;
		}
		if(h.equals("Emerald")){
			int i = MerchantManager.EmeraldDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.EMERALD, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.EmeraldDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("Diamond")){
			int i = MerchantManager.DiamondDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.DIAMOND, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.DiamondDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("GoldIngot")){
			int i = MerchantManager.GoldIngotDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.GOLD_INGOT, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Ingot");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.GoldIngotDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}
		if(h.equals("Redstone")){
			int i = MerchantManager.RedstoneDeals;
			if(i > 64){
				i = 64;
			}
			ItemStack item = new ItemStack(Material.REDSTONE, i);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(" §6Total Deals: §7" + MerchantManager.RedstoneDeals);
			lore.add("");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			
			return item;
		}

		return null;
	}
	
	public static ItemStack getNoDealsItemStack(){
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§c§lThere are currently no Deals.");
		item.setItemMeta(itemmeta);
		item.setDurability((short) 14);
				
		return item;
	}
	
	public static String getHighest1(){
		
		String h1 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i){
			i = MerchantManager.CoalDeals;
			h1 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i){
			i = MerchantManager.IronIngotDeals;
			h1 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i){
			i = MerchantManager.CobblestoneDeals;
			h1 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i){
			i = MerchantManager.LapisLazuliDeals;
			h1 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i){
			i = MerchantManager.EmeraldDeals;
			h1 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i){
			i = MerchantManager.DiamondDeals;
			h1 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i){
			i = MerchantManager.GoldIngotDeals;
			h1 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i){
			i = MerchantManager.RedstoneDeals;
			h1 = "Redstone";
		}
		
		return h1;
	}
	
	public static String getHighest2(String h1){
		
		String h2 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h2 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h2 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone")){
			i = MerchantManager.CobblestoneDeals;
			h2 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h2 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h2 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h2 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h2 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h2 = "Redstone";
		}
		
		return h2;
	}
	
	public static String getHighest3(String h1, String h2){
		
		String h3 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h3 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h3 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h3 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h3 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h3 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h3 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h3 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h3 = "Redstone";
		}
		
		return h3;
	}
	
	public static String getHighest4(String h1, String h2, String h3){
		
		String h4 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal") && !h3.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h4 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot") && !h3.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h4 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone") && !h3.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h4 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli") && !h3.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h4 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald") && !h3.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h4 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond") && !h3.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h4 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot") && !h3.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h4 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone") && !h3.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h4 = "Redstone";
		}
		
		return h4;
	}
	
	public static String getHighest5(String h1, String h2, String h3, String h4){
		
		String h5 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal") && !h3.equals("Coal") && !h4.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h5 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot") && !h3.equals("IronIngot") && !h4.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h5 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone") && !h3.equals("Cobblestone") && !h4.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h5 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli") && !h3.equals("LapisLazuli") && !h4.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h5 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald") && !h3.equals("Emerald") && !h4.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h5 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond") && !h3.equals("Diamond") && !h4.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h5 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot") && !h3.equals("GoldIngot") && !h4.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h5 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone") && !h3.equals("Redstone") && !h4.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h5 = "Redstone";
		}
		
		return h5;
	}
	
	public static String getHighest6(String h1, String h2, String h3, String h4, String h5){
		
		String h6 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal") && !h3.equals("Coal") && !h4.equals("Coal") && !h5.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h6 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot") && !h3.equals("IronIngot") && !h4.equals("IronIngot") && !h5.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h6 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone") && !h3.equals("Cobblestone") && !h4.equals("Cobblestone") && !h5.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h6 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli") && !h3.equals("LapisLazuli") && !h4.equals("LapisLazuli") && !h5.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h6 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald") && !h3.equals("Emerald") && !h4.equals("Emerald") && !h5.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h6 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond") && !h3.equals("Diamond") && !h4.equals("Diamond") && !h5.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h6 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot") && !h3.equals("GoldIngot") && !h4.equals("GoldIngot") && !h5.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h6 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone") && !h3.equals("Redstone") && !h4.equals("Redstone")  && !h5.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h6 = "Redstone";
		}
		
		return h6;
	}
	
	public static String getHighest7(String h1, String h2, String h3, String h4, String h5, String h6){
		
		String h7 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal") && !h3.equals("Coal") && !h4.equals("Coal") && !h5.equals("Coal")  && !h6.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h7 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot") && !h3.equals("IronIngot") && !h4.equals("IronIngot") && !h5.equals("IronIngot") && !h6.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h7 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone") && !h3.equals("Cobblestone") && !h4.equals("Cobblestone") && !h5.equals("Cobblestone") && !h6.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h7 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli") && !h3.equals("LapisLazuli") && !h4.equals("LapisLazuli") && !h5.equals("LapisLazuli") && !h6.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h7 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald") && !h3.equals("Emerald") && !h4.equals("Emerald") && !h5.equals("Emerald") && !h6.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h7 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond") && !h3.equals("Diamond") && !h4.equals("Diamond") && !h5.equals("Diamond") && !h6.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h7 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot") && !h3.equals("GoldIngot") && !h4.equals("GoldIngot") && !h5.equals("GoldIngot") && !h6.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h7 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone") && !h3.equals("Redstone") && !h4.equals("Redstone") && !h5.equals("Redstone") && !h6.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h7 = "Redstone";
		}
		
		return h7;
	}
	
	public static String getHighest8(String h1, String h2, String h3, String h4, String h5, String h6, String h7){
		
		String h8 = "";
		int i = 1;
		if(MerchantManager.CoalDeals >= i && !h1.equals("Coal") && !h2.equals("Coal") && !h3.equals("Coal") && !h4.equals("Coal") && !h5.equals("Coal") && !h6.equals("Coal") && !h7.equals("Coal")){
			i = MerchantManager.CoalDeals;
			h8 = "Coal";
		}
		if(MerchantManager.IronIngotDeals >= i && !h1.equals("IronIngot") && !h2.equals("IronIngot") && !h3.equals("IronIngot") && !h4.equals("IronIngot") && !h5.equals("IronIngot") && !h6.equals("IronIngot") && !h7.equals("IronIngot")){
			i = MerchantManager.IronIngotDeals;
			h8 = "IronIngot";
		}
		if(MerchantManager.CobblestoneDeals >= i && !h1.equals("CobbleStone") && !h2.equals("Cobblestone") && !h3.equals("Cobblestone") && !h4.equals("Cobblestone") && !h5.equals("Cobblestone") && !h6.equals("Cobblestone") && !h7.equals("Cobblestone")){
			i = MerchantManager.CobblestoneDeals;
			h8 = "CobbleStone";
		}
		if(MerchantManager.LapisLazuliDeals >= i && !h1.equals("LapisLazuli") && !h2.equals("LapisLazuli") && !h3.equals("LapisLazuli") && !h4.equals("LapisLazuli") && !h5.equals("LapisLazuli") && !h6.equals("LapisLazuli") && !h7.equals("LapisLazuli")){
			i = MerchantManager.LapisLazuliDeals;
			h8 = "LapisLazuli";
		}
		if(MerchantManager.EmeraldDeals >= i && !h1.equals("Emerald") && !h2.equals("Emerald") && !h3.equals("Emerald") && !h4.equals("Emerald") && !h5.equals("Emerald") && !h6.equals("Emerald") && !h7.equals("Emerald")){
			i = MerchantManager.EmeraldDeals;
			h8 = "Emerald";
		}
		if(MerchantManager.DiamondDeals >= i && !h1.equals("Diamond") && !h2.equals("Diamond") && !h3.equals("Diamond") && !h4.equals("Diamond") && !h5.equals("Diamond") && !h6.equals("Diamond") && !h7.equals("Diamond")){
			i = MerchantManager.DiamondDeals;
			h8 = "Diamond";
		}
		if(MerchantManager.GoldIngotDeals >= i && !h1.equals("GoldIngot") && !h2.equals("GoldIngot") && !h3.equals("GoldIngot") && !h4.equals("GoldIngot") && !h5.equals("GoldIngot") && !h6.equals("GoldIngot") && !h7.equals("GoldIngot")){
			i = MerchantManager.GoldIngotDeals;
			h8 = "GoldIngot";
		}
		if(MerchantManager.RedstoneDeals >= i && !h1.equals("Redstone") && !h2.equals("Redstone") && !h3.equals("Redstone") && !h4.equals("Redstone") && !h5.equals("Redstone") && !h6.equals("Redstone") && !h7.equals("Redstone")){
			i = MerchantManager.RedstoneDeals;
			h8 = "Redstone";
		}
		
		return h8;
	}
}
