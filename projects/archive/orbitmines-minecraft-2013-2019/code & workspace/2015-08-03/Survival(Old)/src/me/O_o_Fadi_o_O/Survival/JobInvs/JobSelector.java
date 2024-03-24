package me.O_o_Fadi_o_O.Survival.JobInvs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Managers.JobManager;

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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Miner")){
					itemlore.add("");
					itemlore.add("§cLevel: §9" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §9" + JobManager.MinerRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.BREWING_STAND_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§lPotion Master Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Potion Master")){
					itemlore.add("");
					itemlore.add("§cLevel: §e" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §e" + JobManager.PotionMasterRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Hunter")){
					itemlore.add("");
					itemlore.add("§cLevel: §b" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §b" + JobManager.HunterRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_HOE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7§lFarmer Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Farmer")){
					itemlore.add("");
					itemlore.add("§cLevel: §7" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §7" + JobManager.FarmerRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Animal Farmer")){
					itemlore.add("");
					itemlore.add("§cLevel: §a" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §a" + JobManager.AnimalFarmerRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Lumberjack")){
					itemlore.add("");
					itemlore.add("§cLevel: §6" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §6" + JobManager.LumberjackRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§c§lNether Expert Job");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Nether Expert")){
					itemlore.add("");
					itemlore.add("§cLevel: §c" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §c" + JobManager.NetherExpertRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Enchanter")){
					itemlore.add("");
					itemlore.add("§cLevel: §3" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §3" + JobManager.EnchanterRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
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
			if(JobManager.JobName.containsKey(p)){
				if(JobManager.JobName.get(p).equals("Fisher")){
					itemlore.add("");
					itemlore.add("§cLevel: §d" + JobManager.JobLevel.get(p));
					int i = JobManager.JobLevel.get(p) * 125 + 75;
					
					itemlore.add("§cEXP: §9" + JobManager.JobEXP.get(p) + " / " + i);
					itemlore.add("§fRequests: §d" + JobManager.FisherRequests);
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
				else{
					itemlore.add("");
					itemlore.add("§7§o§nClick Here for Details");
					itemlore.add("");
				}
			}
			else{
				itemlore.add("");
				itemlore.add("§7§o§nClick Here for Details");
				itemlore.add("");
			}
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(33, item);
		}
		return inv;
	}
}
