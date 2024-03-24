package me.O_o_Fadi_o_O.Survival.jobs.invs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MerchantInv {

	public static Inventory getMerchantInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 54, "§0§lMerchant");
		
		List<JobMaterial> materials = new ArrayList<JobMaterial>();
		
		for(int i = 0; i <= 53; i++){
			JobMaterial m = getHighest(materials);
			if(m != null){
				materials.add(m);
				inv.setItem(i, getHighestItemStack(m));
			}
		}

		return inv;
	}
	
	public static ItemStack getHighestItemStack(JobMaterial material){

		int i = MerchantManager.merchantdealamount.get(material);
		if(i > 64){
			i = 64;
		}
		Material m = JobMaterial.getMaterial(material);
		
		ItemStack item = new ItemStack(m, i);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(JobManager.getItemDisplayColorName(material));
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(" §7Total Deals: §a" + MerchantManager.merchantdealamount.get(material) + " ");
		lore.add(" §7Average Price: §a" + MerchantManager.merchantaverageprice.get(material) + "$ ");
		lore.add("");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability(JobMaterial.getDurability(material));
			
		return item;
	}
	
	public static JobMaterial getHighest(List<JobMaterial> materials){
		
		JobMaterial material = null;
		int i = 1;
		for(JobMaterial m : JobMaterial.values()){
			if(MerchantManager.merchantdealamount.containsKey(m) && !materials.contains(m)){
				if(MerchantManager.merchantdealamount.get(m) >= i){
					material = m;
					i = MerchantManager.merchantdealamount.get(m);
				}
			}
		}
		
		return material;
	}
	
	public static void setMaterialInv(Inventory inv, JobMaterial material){
		inv.clear();
		
		int amount = 0;
		
		for(int i = 0; i < MerchantManager.merchantdealitemstacks.get(material).size(); i++){
			ItemStack item = MerchantManager.merchantdealitemstacks.get(material).get(i);
			
			if(item != null && amount != 44){
				inv.setItem(amount, getDealItemStack(material, i));
				amount++;
			}
		}
		
		{
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§l§o<< Back");
			item.setItemMeta(itemmeta);
			inv.setItem(45, item);
		}
	}
	
	public static ItemStack getDealItemStack(JobMaterial material, int dealid){

		List<ItemStack> itemstacks = MerchantManager.merchantdealitemstacks.get(material);
		ItemStack i = itemstacks.get(dealid);
		
		ItemStack item = new ItemStack(i.getType(), i.getAmount());
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(JobManager.getItemDisplayColorName(material));
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(" §7Amount: §a" + i.getAmount() + " ");
		lore.add(" §7Price: §a" + MerchantManager.merchantdealprices.get(material).get(dealid) + "$ ");
		lore.add(" §7Seller: §a" + MerchantManager.merchantdealplayers.get(material).get(dealid));
		lore.add(" §7DealID: §a" + dealid);
		lore.add("");
		lore.add("§2§lClick Here to Buy");
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability(i.getDurability());
			
		return item;
	}
}
