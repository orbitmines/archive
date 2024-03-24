package me.O_o_Fadi_o_O.Survival.jobs.invs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.CustomItem;
import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.Job;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JobSelector {
	
	public static Inventory getJobSelector(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lJob Manager");
		{
			ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§lMiner Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.MINER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.BREWING_STAND_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§lPotion Master Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.POTION_MASTER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§a§o§nComing Soon...");
				}
			}
			else{
				itemlore.add("§a§o§nComing Soon...");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§b§lHunter Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.HUNTER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_HOE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7§lFarmer Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.FARMER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.WHEAT, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§a§lAnimal Farmer Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.ANIMAL_FARMER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_AXE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§lLumberjack Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.LUMBERJACK){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item = CustomItem.hideFlags(item, 2);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§c§lNether Expert Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.NETHER_EXPERT){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§7§o§nClick Here for Details");
				}
			}
			else{
				itemlore.add("§7§o§nClick Here for Details");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(29, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§lEnchanter Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.ENCHANTER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§a§o§nComing Soon...");
				}
			}
			else{
				itemlore.add("§a§o§nComing Soon...");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(31, item);
		}
		{
			ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§d§lFisher Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.job.containsKey(p)){
				if(JobManager.job.get(p) == Job.FISHER){
					itemlore.add("§cLevel: §9" + JobManager.joblevel.get(p));
					int i = JobManager.joblevel.get(p) * 125 + 75;
					
					itemlore.add("§cXP: §9" + JobManager.jobxp.get(p) + "§7/§9" + i);
					itemlore.add("§7§o§nClick Here for Details");
				}
				else{
					itemlore.add("§a§o§nComing Soon...");
				}
			}
			else{
				itemlore.add("§a§o§nComing Soon...");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(33, item);
		}
		return inv;
	}
}
