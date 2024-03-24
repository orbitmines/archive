package me.O_o_Fadi_o_O.Survival.jobs.invs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.Job;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NetherExpertInv {

	public static Inventory getNetherExpertInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lNether Expert");
		{
			ItemStack item = new ItemStack(Material.NETHER_STALK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cNether Wart");
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.QUARTZ_ORE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cQuartz Ore");
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_BRICK_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Nether Brick");
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
				
		}
		{
		{
			ItemStack item = new ItemStack(Material.NETHERRACK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cNetherrack");
			item.setItemMeta(itemmeta);
			inv.setItem(29, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.QUARTZ, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fQuartz");
			item.setItemMeta(itemmeta);
			inv.setItem(31, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_BRICK, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Nether Brick");
			item.setItemMeta(itemmeta);
			inv.setItem(33, item);
				
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta itemmeta = item.getItemMeta();
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					itemmeta.setDisplayName("§c§lNether Expert Job §8| §a§lCurrent Job");
				}
				else{
					itemmeta.setDisplayName("§c§lNether Expert Job §8| §c§lUnavailable");
				}
			}
			else{
				itemmeta.setDisplayName("§c§lNether Expert Job §8| §f§lJoin the Nether Expert Job");
			}
			item.setItemMeta(itemmeta);
			inv.setItem(0, item);
		}
		{
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§cLevel: §9" + JobManager.joblevel.get(p));
					List<String> itemlore = new ArrayList<String>();
					
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(1, item);
				}
			}
		}
		{
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					ItemStack item = new ItemStack(Material.PAPER, 1);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.merchantdealsid.containsKey(p.getName())){
						if(MerchantManager.merchantdealsid.get(p.getName()).size() >= 1){
							int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(0));
							JobMaterial material = MerchantManager.merchantidtomaterial.get(dealid);
							
							itemmeta.setDisplayName("§6§lDeal 1:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + dealid);
							lore.add("§e Item: " + JobManager.getItemDisplayColorName(material));
							lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(material).get(dealid).getAmount());
							lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(material).get(dealid) + "$");
						
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
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					ItemStack item = new ItemStack(Material.PAPER, 2);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.merchantdealsid.containsKey(p.getName())){
						if(MerchantManager.merchantdealsid.get(p.getName()).size() >= 2){
							int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(1));
							JobMaterial material = MerchantManager.merchantidtomaterial.get(dealid);
							
							itemmeta.setDisplayName("§6§lDeal 2:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + dealid);
							
							lore.add("§e Item: " + JobManager.getItemDisplayColorName(material));
							lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(material).get(dealid).getAmount());
							lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(material).get(dealid) + "$");
						
							
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
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					ItemStack item = new ItemStack(Material.PAPER, 3);
					ItemMeta itemmeta = item.getItemMeta();
					if(MerchantManager.merchantdealsid.containsKey(p.getName())){
						if(MerchantManager.merchantdealsid.get(p.getName()).size() >= 3){
							int dealid = Integer.parseInt(MerchantManager.merchantdealsid.get(p.getName()).get(2));
							JobMaterial material = MerchantManager.merchantidtomaterial.get(dealid);
							
							itemmeta.setDisplayName("§6§lDeal 3:");
							List<String> lore = new ArrayList<String>();
							lore.add("§e DealID: §7#" + dealid);
							
							lore.add("§e Item: " + JobManager.getItemDisplayColorName(material));
							lore.add("§e Amount: §7" + MerchantManager.merchantdealitemstacks.get(material).get(dealid).getAmount());
							lore.add("§e Price: §7" + MerchantManager.merchantdealprices.get(material).get(dealid) + "$");
						
							
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
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.FARMER){
					ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§cLeave Job");
					List<String> itemlore = new ArrayList<String>();
					itemlore.add("§4§nThis will reset your level and job!");
					itemmeta.setLore(itemlore);
					item.setItemMeta(itemmeta);
					inv.setItem(53, item);
				}
			}
		}
		
		return inv;
		}
	}
}
