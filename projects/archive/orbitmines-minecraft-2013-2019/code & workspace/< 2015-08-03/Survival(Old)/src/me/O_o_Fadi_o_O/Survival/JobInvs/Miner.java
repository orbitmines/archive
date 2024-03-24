package me.O_o_Fadi_o_O.Survival.JobInvs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Managers.JobManager;
import me.O_o_Fadi_o_O.Survival.Managers.MerchantManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Miner {

	public static Inventory getMinerInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMiner");
		{
			ItemStack item = new ItemStack(Material.COAL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Coal");
			item.setItemMeta(itemmeta);
			inv.setItem(19, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Iron Ingot");
			item.setItemMeta(itemmeta);
			inv.setItem(21, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Cobblestone");
			item.setItemMeta(itemmeta);
			inv.setItem(23, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.INK_SACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§1Lapis Lazuli");
			item.setItemMeta(itemmeta);
			item.setDurability((short) 4);
			inv.setItem(25, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.EMERALD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aEmerald");
			item.setItemMeta(itemmeta);
			inv.setItem(28, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§bDiamond");
			item.setItemMeta(itemmeta);
			inv.setItem(30, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Gold Ingot");
			item.setItemMeta(itemmeta);
			inv.setItem(32, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.REDSTONE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Redstone");
			item.setItemMeta(itemmeta);
			inv.setItem(34, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					itemmeta.setDisplayName("§9§lMiner Job §8| §a§lCurrent Job");
				}
				else{
					itemmeta.setDisplayName("§9§lMiner Job §8| §c§lUnavailable");
				}
			}
			else{
				itemmeta.setDisplayName("§9§lMiner Job §8| §f§lJoin the Miner Job");
			}
			item.setItemMeta(itemmeta);
			inv.setItem(0, item);
		}
		{
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§cLevel: §9" + JobManager.JobLevel.get(p));
					List<String> itemlore = new ArrayList<String>();
					
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(1, item);
				}
			}
		}
		{
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					ItemStack item = new ItemStack(Material.PAPER, 1);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.PlayerDealsAmount.containsKey(p)){
						if(MerchantManager.PlayerDealsAmount.get(p) >= 1){
							int DealID = MerchantManager.PlayerDeals1ID.get(p);
							itemmeta.setDisplayName("§6§lDeal 1:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + DealID);
							if(MerchantManager.CoalItemStack.get(DealID) != null){
								lore.add("§e Item: §8§lCoal");
								lore.add("§e Amount: §7" + MerchantManager.CoalItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CoalPrice.get(DealID) + "$");
							}
							if(MerchantManager.IronIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lIron Ingot");
								lore.add("§e Amount: §7" + MerchantManager.IronIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.IronIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.CobblestoneItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lCobblestone");
								lore.add("§e Amount: §7" + MerchantManager.CobblestoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CobblestonePrice.get(DealID) + "$");
							}
							if(MerchantManager.LapisLazuliItemStack.get(DealID) != null){
								lore.add("§e Item: §1§lLapis Lazuli");
								lore.add("§e Amount: §7" + MerchantManager.LapisLazuliItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.LapisLazuliPrice.get(DealID) + "$");
							}
							if(MerchantManager.EmeraldItemStack.get(DealID) != null){
								lore.add("§e Item: §a§lEmerald");
								lore.add("§e Amount: §7" + MerchantManager.EmeraldItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.EmeraldPrice.get(DealID) + "$");
							}
							if(MerchantManager.DiamondItemStack.get(DealID) != null){
								lore.add("§e Item: §b§lDiamond");
								lore.add("§e Amount: §7" + MerchantManager.DiamondItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.DiamondPrice.get(DealID) + "$");
							}
							if(MerchantManager.GoldIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §6§lGold Ingot");
								lore.add("§e Amount: §7" + MerchantManager.GoldIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.GoldIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.RedstoneItemStack.get(DealID) != null){
								lore.add("§e Item: §4§lRedstone");
								lore.add("§e Amount: §7" + MerchantManager.RedstoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.RedstonePrice.get(DealID) + "$");
							}
							lore.add("");
							lore.add("§c§l§oRemove Deal");
							itemmeta.setLore(lore);
						}
						else{
							itemmeta.setDisplayName("§6§lDeal 1: §c§lEMPTY");
						}
					}
					else{
						itemmeta.setDisplayName("§6§lDeal 1: §c§lEMPTY");
					}
					item.setItemMeta(itemmeta);
					inv.setItem(6, item);
				}
			}	
		}
		{
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					ItemStack item = new ItemStack(Material.PAPER, 2);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.PlayerDealsAmount.containsKey(p)){
						if(MerchantManager.PlayerDealsAmount.get(p) >= 2){
							int DealID = MerchantManager.PlayerDeals2ID.get(p);
							itemmeta.setDisplayName("§6§lDeal 2:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + DealID);
							if(MerchantManager.CoalItemStack.get(DealID) != null){
								lore.add("§e Item: §8§lCoal");
								lore.add("§e Amount: §7" + MerchantManager.CoalItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CoalPrice.get(DealID) + "$");
							}
							if(MerchantManager.IronIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lIron Ingot");
								lore.add("§e Amount: §7" + MerchantManager.IronIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.IronIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.CobblestoneItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lCobblestone");
								lore.add("§e Amount: §7" + MerchantManager.CobblestoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CobblestonePrice.get(DealID) + "$");
							}
							if(MerchantManager.LapisLazuliItemStack.get(DealID) != null){
								lore.add("§e Item: §1§lLapis Lazuli");
								lore.add("§e Amount: §7" + MerchantManager.LapisLazuliItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.LapisLazuliPrice.get(DealID) + "$");
							}
							if(MerchantManager.EmeraldItemStack.get(DealID) != null){
								lore.add("§e Item: §a§lEmerald");
								lore.add("§e Amount: §7" + MerchantManager.EmeraldItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.EmeraldPrice.get(DealID) + "$");
							}
							if(MerchantManager.DiamondItemStack.get(DealID) != null){
								lore.add("§e Item: §b§lDiamond");
								lore.add("§e Amount: §7" + MerchantManager.DiamondItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.DiamondPrice.get(DealID) + "$");
							}
							if(MerchantManager.GoldIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §6§lGold Ingot");
								lore.add("§e Amount: §7" + MerchantManager.GoldIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.GoldIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.RedstoneItemStack.get(DealID) != null){
								lore.add("§e Item: §4§lRedstone");
								lore.add("§e Amount: §7" + MerchantManager.RedstoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.RedstonePrice.get(DealID) + "$");
							}
							lore.add("");
							lore.add("§c§l§oRemove Deal");
							itemmeta.setLore(lore);
						}
						else{
							itemmeta.setDisplayName("§6§lDeal 2: §c§lEMPTY");
						}
					}
					else{
						itemmeta.setDisplayName("§6§lDeal 2: §c§lEMPTY");
					}
					item.setItemMeta(itemmeta);
					inv.setItem(7, item);
				}
			}	
		}
		{
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					ItemStack item = new ItemStack(Material.PAPER, 3);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.PlayerDealsAmount.containsKey(p)){
						if(MerchantManager.PlayerDealsAmount.get(p) >= 3){
							int DealID = MerchantManager.PlayerDeals3ID.get(p);
							itemmeta.setDisplayName("§6§lDeal 3:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + DealID);
							if(MerchantManager.CoalItemStack.get(DealID) != null){
								lore.add("§e Item: §8§lCoal");
								lore.add("§e Amount: §7" + MerchantManager.CoalItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CoalPrice.get(DealID) + "$");
							}
							if(MerchantManager.IronIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lIron Ingot");
								lore.add("§e Amount: §7" + MerchantManager.IronIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.IronIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.CobblestoneItemStack.get(DealID) != null){
								lore.add("§e Item: §7§lCobblestone");
								lore.add("§e Amount: §7" + MerchantManager.CobblestoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.CobblestonePrice.get(DealID) + "$");
							}
							if(MerchantManager.LapisLazuliItemStack.get(DealID) != null){
								lore.add("§e Item: §1§lLapis Lazuli");
								lore.add("§e Amount: §7" + MerchantManager.LapisLazuliItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.LapisLazuliPrice.get(DealID) + "$");
							}
							if(MerchantManager.EmeraldItemStack.get(DealID) != null){
								lore.add("§e Item: §a§lEmerald");
								lore.add("§e Amount: §7" + MerchantManager.EmeraldItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.EmeraldPrice.get(DealID) + "$");
							}
							if(MerchantManager.DiamondItemStack.get(DealID) != null){
								lore.add("§e Item: §b§lDiamond");
								lore.add("§e Amount: §7" + MerchantManager.DiamondItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.DiamondPrice.get(DealID) + "$");
							}
							if(MerchantManager.GoldIngotItemStack.get(DealID) != null){
								lore.add("§e Item: §6§lGold Ingot");
								lore.add("§e Amount: §7" + MerchantManager.GoldIngotItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.GoldIngotPrice.get(DealID) + "$");
							}
							if(MerchantManager.RedstoneItemStack.get(DealID) != null){
								lore.add("§e Item: §4§lRedstone");
								lore.add("§e Amount: §7" + MerchantManager.RedstoneItemStack.get(DealID).getAmount());
								lore.add("§e Price: §7" + MerchantManager.RedstonePrice.get(DealID) + "$");
							}
							lore.add("");
							lore.add("§c§l§oRemove Deal");
							itemmeta.setLore(lore);
						}
						else{
							itemmeta.setDisplayName("§6§lDeal 3: §c§lEMPTY");
						}
					}
					else{
						itemmeta.setDisplayName("§6§lDeal 3: §c§lEMPTY");
					}
					item.setItemMeta(itemmeta);
					inv.setItem(8, item);
				}
			}	
		}
		{
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§l§o<< Back");
			item.setItemMeta(itemmeta);
			inv.setItem(45, item);
				
		}
		{
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					ItemStack item = new ItemStack(Material.FIRE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§cLeave Job");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("§4§nThis will reset your Level and Job!");
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(53, item);
				}
			}
		}
		return inv;
	}
}
