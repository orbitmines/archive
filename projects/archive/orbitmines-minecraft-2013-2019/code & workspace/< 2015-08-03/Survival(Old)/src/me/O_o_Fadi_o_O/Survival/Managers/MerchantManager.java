package me.O_o_Fadi_o_O.Survival.Managers;

import java.util.HashMap;

import me.O_o_Fadi_o_O.Survival.SettingsManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MerchantManager {

	public static HashMap<Player, Integer> PlayerDealsAmount = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Integer> PlayerDeals1ID = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> PlayerDeals2ID = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> PlayerDeals3ID = new HashMap<Player, Integer>();
	
	public static int CoalDeals = 0;
	public static int IronIngotDeals = 0;
	public static int CobblestoneDeals = 0;
	public static int LapisLazuliDeals = 0;
	public static int EmeraldDeals = 0;
	public static int DiamondDeals = 0;
	public static int GoldIngotDeals = 0;
	public static int RedstoneDeals = 0;
	
	/*
	 * 
	 * 
	 */
			public static HashMap<Integer, ItemStack> CoalItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> CoalPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> CoalPrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> IronIngotItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> IronIngotPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> IronIngotPrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> CobblestoneItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> CobblestonePlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> CobblestonePrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> LapisLazuliItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> LapisLazuliPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> LapisLazuliPrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> EmeraldItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> EmeraldPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> EmeraldPrice = new HashMap<Integer, Integer>();
		
			public static HashMap<Integer, ItemStack> DiamondItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> DiamondPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> DiamondPrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> GoldIngotItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> GoldIngotPlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> GoldIngotPrice = new HashMap<Integer, Integer>();
			
			public static HashMap<Integer, ItemStack> RedstoneItemStack = new HashMap<Integer, ItemStack>();
			public static HashMap<Integer, Player> RedstonePlayer = new HashMap<Integer, Player>();
			public static HashMap<Integer, Integer> RedstonePrice = new HashMap<Integer, Integer>();
	/*
	 * 
	 * 
	 */
	
	public static void removeDeal(Player p, String material, int DealNumber, int DealID){
		
		/*
		 * 
		 * TODO: ADD TO BANK
		 * 
		 */
		
		if(DealNumber == 1){
			
			if(material.equals("Coal")){
				MerchantManager.CoalDeals = MerchantManager.CoalDeals -1;
				MerchantManager.CoalItemStack.remove(DealID);
				MerchantManager.CoalPlayer.remove(DealID);
				MerchantManager.CoalPrice.remove(DealID);
			}
			if(material.equals("Iron Ingot")){
				MerchantManager.IronIngotDeals = MerchantManager.IronIngotDeals -1;
				MerchantManager.IronIngotItemStack.remove(DealID);
				MerchantManager.IronIngotPlayer.remove(DealID);
				MerchantManager.IronIngotPrice.remove(DealID);
			}
			if(material.equals("Cobblestone")){
				MerchantManager.CobblestoneDeals = MerchantManager.CobblestoneDeals -1;
				MerchantManager.CobblestoneItemStack.remove(DealID);
				MerchantManager.CobblestonePlayer.remove(DealID);
				MerchantManager.CobblestonePrice.remove(DealID);
			}
			if(material.equals("Lapis Lazuli")){
				MerchantManager.LapisLazuliDeals = MerchantManager.LapisLazuliDeals -1;
				MerchantManager.LapisLazuliItemStack.remove(DealID);
				MerchantManager.LapisLazuliPlayer.remove(DealID);
				MerchantManager.LapisLazuliPrice.remove(DealID);
			}
			if(material.equals("Emerald")){
				MerchantManager.EmeraldDeals = MerchantManager.EmeraldDeals -1;
				MerchantManager.EmeraldItemStack.remove(DealID);
				MerchantManager.EmeraldPlayer.remove(DealID);
				MerchantManager.EmeraldPrice.remove(DealID);
			}
			if(material.equals("Diamond")){
				MerchantManager.DiamondDeals = MerchantManager.DiamondDeals -1;
				MerchantManager.DiamondItemStack.remove(DealID);
				MerchantManager.DiamondPlayer.remove(DealID);
				MerchantManager.DiamondPrice.remove(DealID);
			}
			if(material.equals("Gold Ingot")){
				MerchantManager.GoldIngotDeals = MerchantManager.GoldIngotDeals -1;
				MerchantManager.GoldIngotItemStack.remove(DealID);
				MerchantManager.GoldIngotPlayer.remove(DealID);
				MerchantManager.GoldIngotPrice.remove(DealID);
			}
			if(material.equals("Redstone")){
				MerchantManager.RedstoneDeals = MerchantManager.RedstoneDeals -1;
				MerchantManager.RedstoneItemStack.remove(DealID);
				MerchantManager.RedstonePlayer.remove(DealID);
				MerchantManager.RedstonePrice.remove(DealID);
			}
			
			int DealsAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".DealsAmount");
			
			if(DealsAmount == 1){
				SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", DealsAmount -1);
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1", null);
				SettingsManager.saveJobs();
				
				MerchantManager.PlayerDeals1ID.remove(p);
			}
			else if(DealsAmount == 2){
				
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.DealNumber", MerchantManager.PlayerDeals2ID.get(p));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Material", SettingsManager.jobs.getString("players." + p.getName() + ".Deals.Deal2.Material"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Durability", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Durability"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Amount", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Amount"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Price", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Price"));
				
				SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", DealsAmount -1);
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2", null);
				SettingsManager.saveJobs();
				
				MerchantManager.PlayerDeals1ID.put(p, MerchantManager.PlayerDeals2ID.get(p));
				MerchantManager.PlayerDeals2ID.remove(p);
			}
			else if(DealsAmount == 3){
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.DealNumber", MerchantManager.PlayerDeals2ID.get(p));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Material", SettingsManager.jobs.getString("players." + p.getName() + ".Deals.Deal2.Material"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Durability", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Durability"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Amount", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Amount"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal1.Price", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Price"));
				
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2.DealNumber", MerchantManager.PlayerDeals3ID.get(p));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2.Material", SettingsManager.jobs.getString("players." + p.getName() + ".Deals.Deal3.Material"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2.Durability", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal3.Durability"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2.Amount", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal3.Amount"));
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal2.Price", SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal3.Price"));
				
				SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", DealsAmount -1);
				SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal3", null);
				SettingsManager.saveJobs();
				
				MerchantManager.PlayerDeals1ID.put(p, MerchantManager.PlayerDeals2ID.get(p));
				MerchantManager.PlayerDeals2ID.put(p, MerchantManager.PlayerDeals3ID.get(p));
				MerchantManager.PlayerDeals3ID.remove(p);
			}
			
			MerchantManager.PlayerDealsAmount.put(p, MerchantManager.PlayerDealsAmount.get(p) -1);
		}
		else if(DealNumber == 2){
			
		}
		else if(DealNumber == 3){
			
		}
		
	}
			
	public static void insertDeal(Player p, String material, int amount, int price, int durability){
		
		int PlayerDealID = SettingsManager.jobs.getInt("players." + p.getName() + ".DealsAmount") +1;
		
		int DealID = SettingsManager.jobs.getInt("LastDeal") +1;
		SettingsManager.jobs.set("LastDeal", DealID);
		SettingsManager.jobs.set("players." + p.getName() + ".DealsAmount", PlayerDealID);
		SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal" + PlayerDealID + ".DealNumber", DealID);
		SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal" + PlayerDealID + ".Material", material);
		SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal" + PlayerDealID + ".Durability", durability);
		SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal" + PlayerDealID + ".Amount", amount);
		SettingsManager.jobs.set("players." + p.getName() + ".Deals.Deal" + PlayerDealID + ".Price", price);
		SettingsManager.saveJobs();
		
		MerchantManager.PlayerDealsAmount.put(p, PlayerDealID);
		
		if(PlayerDealID == 1){
			MerchantManager.PlayerDeals1ID.put(p, DealID);
			
			int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal1.Amount");
			int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal1.Price");
			
			if(material.equals("Coal")){
				ItemStack item = new ItemStack(Material.COAL, ItemAmount);
				MerchantManager.CoalItemStack.put(DealID, item);
				MerchantManager.CoalPlayer.put(DealID, p);
				MerchantManager.CoalPrice.put(DealID, Price);
				MerchantManager.CoalDeals = MerchantManager.CoalDeals +1;
			}
			if(material.equals("Iron Ingot")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, ItemAmount);
				MerchantManager.IronIngotItemStack.put(DealID, item);
				MerchantManager.IronIngotPlayer.put(DealID, p);
				MerchantManager.IronIngotPrice.put(DealID, Price);
				MerchantManager.IronIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Cobblestone")){
				ItemStack item = new ItemStack(Material.COBBLESTONE, ItemAmount);
				MerchantManager.CobblestoneItemStack.put(DealID, item);
				MerchantManager.CobblestonePlayer.put(DealID, p);
				MerchantManager.CobblestonePrice.put(DealID, Price);
				MerchantManager.CobblestoneDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Lapis Lazuli")){
				ItemStack item = new ItemStack(Material.INK_SACK, ItemAmount);
				item.setDurability((short) 4);
				MerchantManager.LapisLazuliItemStack.put(DealID, item);
				MerchantManager.LapisLazuliPlayer.put(DealID, p);
				MerchantManager.LapisLazuliPrice.put(DealID, Price);
				MerchantManager.LapisLazuliDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Emerald")){
				ItemStack item = new ItemStack(Material.EMERALD, ItemAmount);
				MerchantManager.EmeraldItemStack.put(DealID, item);
				MerchantManager.EmeraldPlayer.put(DealID, p);
				MerchantManager.EmeraldPrice.put(DealID, Price);
				MerchantManager.EmeraldDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Diamond")){
				ItemStack item = new ItemStack(Material.DIAMOND, ItemAmount);
				MerchantManager.DiamondItemStack.put(DealID, item);
				MerchantManager.DiamondPlayer.put(DealID, p);
				MerchantManager.DiamondPrice.put(DealID, Price);
				MerchantManager.DiamondDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Gold Ingot")){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, ItemAmount);
				MerchantManager.GoldIngotItemStack.put(DealID, item);
				MerchantManager.GoldIngotPlayer.put(DealID, p);
				MerchantManager.GoldIngotPrice.put(DealID, Price);
				MerchantManager.GoldIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Redstone")){
				ItemStack item = new ItemStack(Material.REDSTONE, ItemAmount);
				MerchantManager.RedstoneItemStack.put(DealID, item);
				MerchantManager.RedstonePlayer.put(DealID, p);
				MerchantManager.RedstonePrice.put(DealID, Price);
				MerchantManager.RedstoneDeals = MerchantManager.RedstoneDeals +1;
			}
		}
		if(PlayerDealID == 2){
			MerchantManager.PlayerDeals2ID.put(p, DealID);
			
			int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Amount");
			int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal2.Price");
			
			if(material.equals("Coal")){
				ItemStack item = new ItemStack(Material.COAL, ItemAmount);
				MerchantManager.CoalItemStack.put(DealID, item);
				MerchantManager.CoalPlayer.put(DealID, p);
				MerchantManager.CoalPrice.put(DealID, Price);
				MerchantManager.CoalDeals = MerchantManager.CoalDeals +1;
			}
			if(material.equals("Iron Ingot")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, ItemAmount);
				MerchantManager.IronIngotItemStack.put(DealID, item);
				MerchantManager.IronIngotPlayer.put(DealID, p);
				MerchantManager.IronIngotPrice.put(DealID, Price);
				MerchantManager.IronIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Cobblestone")){
				ItemStack item = new ItemStack(Material.COBBLESTONE, ItemAmount);
				MerchantManager.CobblestoneItemStack.put(DealID, item);
				MerchantManager.CobblestonePlayer.put(DealID, p);
				MerchantManager.CobblestonePrice.put(DealID, Price);
				MerchantManager.CobblestoneDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Lapis Lazuli")){
				ItemStack item = new ItemStack(Material.INK_SACK, ItemAmount);
				item.setDurability((short) 4);
				MerchantManager.LapisLazuliItemStack.put(DealID, item);
				MerchantManager.LapisLazuliPlayer.put(DealID, p);
				MerchantManager.LapisLazuliPrice.put(DealID, Price);
				MerchantManager.LapisLazuliDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Emerald")){
				ItemStack item = new ItemStack(Material.EMERALD, ItemAmount);
				MerchantManager.EmeraldItemStack.put(DealID, item);
				MerchantManager.EmeraldPlayer.put(DealID, p);
				MerchantManager.EmeraldPrice.put(DealID, Price);
				MerchantManager.EmeraldDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Diamond")){
				ItemStack item = new ItemStack(Material.DIAMOND, ItemAmount);
				MerchantManager.DiamondItemStack.put(DealID, item);
				MerchantManager.DiamondPlayer.put(DealID, p);
				MerchantManager.DiamondPrice.put(DealID, Price);
				MerchantManager.DiamondDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Gold Ingot")){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, ItemAmount);
				MerchantManager.GoldIngotItemStack.put(DealID, item);
				MerchantManager.GoldIngotPlayer.put(DealID, p);
				MerchantManager.GoldIngotPrice.put(DealID, Price);
				MerchantManager.GoldIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Redstone")){
				ItemStack item = new ItemStack(Material.REDSTONE, ItemAmount);
				MerchantManager.RedstoneItemStack.put(DealID, item);
				MerchantManager.RedstonePlayer.put(DealID, p);
				MerchantManager.RedstonePrice.put(DealID, Price);
				MerchantManager.RedstoneDeals = MerchantManager.RedstoneDeals +1;
			}
		}
		if(PlayerDealID == 3){
			MerchantManager.PlayerDeals3ID.put(p, DealID);
			
			int ItemAmount = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal3.Amount");
			int Price = SettingsManager.jobs.getInt("players." + p.getName() + ".Deals.Deal3.Price");
			
			if(material.equals("Coal")){
				ItemStack item = new ItemStack(Material.COAL, ItemAmount);
				MerchantManager.CoalItemStack.put(DealID, item);
				MerchantManager.CoalPlayer.put(DealID, p);
				MerchantManager.CoalPrice.put(DealID, Price);
				MerchantManager.CoalDeals = MerchantManager.CoalDeals +1;
			}
			if(material.equals("Iron Ingot")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, ItemAmount);
				MerchantManager.IronIngotItemStack.put(DealID, item);
				MerchantManager.IronIngotPlayer.put(DealID, p);
				MerchantManager.IronIngotPrice.put(DealID, Price);
				MerchantManager.IronIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Cobblestone")){
				ItemStack item = new ItemStack(Material.COBBLESTONE, ItemAmount);
				MerchantManager.CobblestoneItemStack.put(DealID, item);
				MerchantManager.CobblestonePlayer.put(DealID, p);
				MerchantManager.CobblestonePrice.put(DealID, Price);
				MerchantManager.CobblestoneDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Lapis Lazuli")){
				ItemStack item = new ItemStack(Material.INK_SACK, ItemAmount);
				item.setDurability((short) 4);
				MerchantManager.LapisLazuliItemStack.put(DealID, item);
				MerchantManager.LapisLazuliPlayer.put(DealID, p);
				MerchantManager.LapisLazuliPrice.put(DealID, Price);
				MerchantManager.LapisLazuliDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Emerald")){
				ItemStack item = new ItemStack(Material.EMERALD, ItemAmount);
				MerchantManager.EmeraldItemStack.put(DealID, item);
				MerchantManager.EmeraldPlayer.put(DealID, p);
				MerchantManager.EmeraldPrice.put(DealID, Price);
				MerchantManager.EmeraldDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Diamond")){
				ItemStack item = new ItemStack(Material.DIAMOND, ItemAmount);
				MerchantManager.DiamondItemStack.put(DealID, item);
				MerchantManager.DiamondPlayer.put(DealID, p);
				MerchantManager.DiamondPrice.put(DealID, Price);
				MerchantManager.DiamondDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Gold Ingot")){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, ItemAmount);
				MerchantManager.GoldIngotItemStack.put(DealID, item);
				MerchantManager.GoldIngotPlayer.put(DealID, p);
				MerchantManager.GoldIngotPrice.put(DealID, Price);
				MerchantManager.GoldIngotDeals = MerchantManager.IronIngotDeals +1;
			}
			if(material.equals("Redstone")){
				ItemStack item = new ItemStack(Material.REDSTONE, ItemAmount);
				MerchantManager.RedstoneItemStack.put(DealID, item);
				MerchantManager.RedstonePlayer.put(DealID, p);
				MerchantManager.RedstonePrice.put(DealID, Price);
				MerchantManager.RedstoneDeals = MerchantManager.RedstoneDeals +1;
			}
		}
	}
}
