package me.O_o_Fadi_o_O.Survival.JobInvs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Managers.MerchantManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Confirm {

	public static Inventory getConfirmInv(Player p, String reason){
		
		final Inventory inv = Bukkit.createInventory(null, 27, "§0§lAre you sure?");
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(reason.equals("LeaveJob")){
				itemmeta.setDisplayName("§aYes, I want to quit my Job.");
			}
			if(reason.equals("RemoveDeal1") || reason.equals("RemoveDeal2") || reason.equals("RemoveDeal3")){
				itemmeta.setDisplayName("§aYes, I want to remove this Deal.");
			}
			item.setItemMeta(itemmeta);
			item.setDurability((short) 5);
			inv.setItem(0, item);
			inv.setItem(1, item);
			inv.setItem(2, item);
			inv.setItem(3, item);
			
			inv.setItem(9, item);
			inv.setItem(10, item);
			inv.setItem(11, item);
			inv.setItem(12, item);
			
			inv.setItem(18, item);
			inv.setItem(19, item);
			inv.setItem(20, item);
			inv.setItem(21, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(reason.equals("LeaveJob")){
				itemmeta.setDisplayName("§4§nLeaving your Job will reset your Level and Job!");
				List<String> lore = new ArrayList<String>();
				lore.add("§4§nYou need to wait 1 hour before joining a job again!");
				itemmeta.setLore(lore);
			}
			if(reason.equals("RemoveDeal1")){
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
				itemmeta.setLore(lore);
			}
			if(reason.equals("RemoveDeal2")){
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
				itemmeta.setLore(lore);
			}
			if(reason.equals("RemoveDeal3")){
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
				itemmeta.setLore(lore);
			}
			item.setItemMeta(itemmeta);
			item.setDurability((short) 15);
			inv.setItem(4, item);
			inv.setItem(13, item);
			inv.setItem(22, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(reason.equals("LeaveJob")){
				itemmeta.setDisplayName("§cNo, I don't want to quit my Job.");
			}
			if(reason.equals("RemoveDeal1") || reason.equals("RemoveDeal2") || reason.equals("RemoveDeal3")){
				itemmeta.setDisplayName("§cNo, I don't want to remove this Deal.");
			}
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(5, item);
			inv.setItem(6, item);
			inv.setItem(7, item);
			inv.setItem(8, item);
			
			inv.setItem(14, item);
			inv.setItem(15, item);
			inv.setItem(16, item);
			inv.setItem(17, item);
			
			inv.setItem(23, item);
			inv.setItem(24, item);
			inv.setItem(25, item);
			inv.setItem(26, item);
				
		}
		return inv;
	}
}
