package me.O_o_Fadi_o_O.Survival.jobs.invs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.ConfirmReason;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmInv {

	public static Inventory getConfirmInv(Player p, ConfirmReason reason){
		
		final Inventory inv = Bukkit.createInventory(null, 27, "§0§lAre you sure?");
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(reason == ConfirmReason.LEAVE_JOB){
				itemmeta.setDisplayName("§aYes, I want to quit my Job.");
			}
			else{
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
			if(reason == ConfirmReason.LEAVE_JOB){
				itemmeta.setDisplayName("§4§nLeaving your Job will your level and job!");
				List<String> lore = new ArrayList<String>();
				lore.add("§4§nYou'll have to wait 1 hour before joining an other job.");
				itemmeta.setLore(lore);
			}
			else if(reason == ConfirmReason.REMOVE_DEAL_1){
				int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(0));
				Material material = MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getType();
				JobMaterial m = JobMaterial.getJobMaterial(material, MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getDurability());
				
				itemmeta.setDisplayName("§6§lDeal 1:");
				List<String> lore = new ArrayList<String>();
				lore.add("§e DealID: §7#" + dealid);
					
				lore.add("§e Item: " + JobManager.getItemDisplayColorName(m));
				lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(m).get(dealid).getAmount());
				lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(m).get(dealid) + "$");
			
				itemmeta.setLore(lore);
			}
			else if(reason == ConfirmReason.REMOVE_DEAL_2){
				int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(1));
				Material material = MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getType();
				JobMaterial m = JobMaterial.getJobMaterial(material, MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getDurability());
				
				itemmeta.setDisplayName("§6§lDeal 2:");
				List<String> lore = new ArrayList<String>();
				lore.add("§e DealID: §7#" + dealid);
					
				lore.add("§e Item: " + JobManager.getItemDisplayColorName(m));
				lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(m).get(dealid).getAmount());
				lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(m).get(dealid) + "$");
			
				itemmeta.setLore(lore);
			}
			else if(reason == ConfirmReason.REMOVE_DEAL_3){
				int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(2));
				Material material = MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getType();
				JobMaterial m = JobMaterial.getJobMaterial(material, MerchantManager.merchantdealitemstacks.get(MerchantManager.merchantidtomaterial.get(dealid)).get(dealid).getDurability());
				
				itemmeta.setDisplayName("§6§lDeal 3:");
				List<String> lore = new ArrayList<String>();
				lore.add("§e DealID: §7#" + dealid);
					
				lore.add("§e Item: " + JobManager.getItemDisplayColorName(m));
				lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(m).get(dealid).getAmount());
				lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(m).get(dealid) + "$");
			
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
			if(reason == ConfirmReason.LEAVE_JOB){
				itemmeta.setDisplayName("§cNo, I don't want to quit my Job.");
			}
			else{
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
