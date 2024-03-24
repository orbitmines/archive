package me.O_o_Fadi_o_O.Survival.jobs.invs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.managers.MerchantManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.JobMaterial;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SellInv {

	public static void getSellInv(Player p, Inventory inv, JobMaterial m){
		
		int durability = JobMaterial.getDurability(m);
		Material material = JobMaterial.getMaterial(m);
		
		SellItem1(p, inv, material, durability);
		SellItem2(p, inv, material, durability);
		SellItem3(p, inv, material, durability);
		SellItem4(p, inv, material, durability);
		SellItem5(p, inv, material, durability);
		SellItem6(p, inv, material, durability);
		SellItem64(p, inv, material, durability);
		
		if(material == Material.INK_SACK){
			StatsItem(p, inv, 0, 0, material, 4);
		}
		else{
			StatsItem(p, inv, 0, 0, material, 0);
		}
			
		p.openInventory(inv);
		
		{
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§l§o<< Back");
			item.setItemMeta(itemmeta);
			inv.setItem(45, item);
				
		}
	}
	
	public static void confirmDeal(Player p, Inventory inv, String display){
		
		String s = inv.getItem(40).getItemMeta().getLore().get(1);	
		int price = Integer.parseInt(s.substring(12));

		ItemStack item1 = inv.getItem(40);
		JobMaterial m = JobMaterial.getJobMaterial(item1.getType(), item1.getDurability());
		
		MerchantManager.insertDeal(p, m, item1.getDurability(), item1.getAmount() , price);
		
		p.playSound(p.getLocation(), Sound.VILLAGER_YES, 5, 1);
		p.sendMessage("§6§lJobs §8| §7Your " + display + "§7 deal has been added to our System! Other players can buy it at the §a§lMerchant§7!");
		p.sendMessage("");
		p.sendMessage("§a§lMerchant: §7Your deal:");
		p.sendMessage("§a§lMerchant: §7Item: " + display);
		p.sendMessage("§a§lMerchant: §7Amount: §b" + inv.getItem(40).getAmount());
		p.sendMessage("§a§lMerchant: §7Price: §6" + price + "$");
	
		ItemStack itemR = new ItemStack(item1.getType());
		itemR.setDurability(item1.getDurability());			
		
		int totalamount = 0;
		
		for(ItemStack item : p.getInventory().getContents()){
			try{
				if(item.getType() == itemR.getType() && item.getDurability() == itemR.getDurability()){
					totalamount = totalamount + item.getAmount();
					p.getInventory().remove(item);
				}
			}catch(Exception ex){}
		}
		
		totalamount = totalamount -item1.getAmount();

		for(int i = 1; i <= totalamount; i++){
			p.getInventory().addItem(itemR);
		}
			
		//if(p.getInventory().containsAtLeast(itemR, 225)){		
		//}
			
		p.closeInventory();
	}
	
	public static ItemStack Money1(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+1$");
		item.setItemMeta(itemmeta);
		inv.setItem(19, item);
		
		return item;
	}
	public static ItemStack Money5(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_NUGGET, 5);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+5$");
		item.setItemMeta(itemmeta);
		inv.setItem(20, item);
		
		return item;
	}
	public static ItemStack Money10(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_NUGGET, 10);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+10$");
		item.setItemMeta(itemmeta);
		inv.setItem(21, item);
		
		return item;
	}
	public static ItemStack Money50(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_NUGGET, 50);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+50$");
		item.setItemMeta(itemmeta);
		inv.setItem(22, item);
		
		return item;
	}
	public static ItemStack Money100(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+100$");
		item.setItemMeta(itemmeta);
		inv.setItem(23, item);
		
		return item;
	}
	public static ItemStack Money500(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_INGOT, 5);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+500$");
		item.setItemMeta(itemmeta);
		inv.setItem(24, item);
		
		return item;
	}
	public static ItemStack Money1000(Player p, Inventory inv){
		ItemStack item = new ItemStack(Material.GOLD_INGOT, 10);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§6+1000$");
		item.setItemMeta(itemmeta);
		inv.setItem(25, item);
		
		return item;
	}
	public static ItemStack StatsItem(Player p, Inventory inv, int amount, int price, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			
			ItemStack item = new ItemStack(material, amount);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(JobManager.getItemDisplayColorName(m));
			List<String> lore = new ArrayList<String>();
			lore.add(" §7Amount:§b " + amount);
			lore.add(" §7Price:§6 " + price);
			lore.add("");
			lore.add("§a§l§oConfirm Deal");
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) durability);
			inv.setItem(40, item);
			
			return item;
			
		}
		else{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(JobManager.getItemDisplayColorName(m));
			List<String> lore = new ArrayList<String>();
			lore.add(" §7Amount:§b " + amount);
			lore.add(" §7Price:§6 " + price);
			itemmeta.setLore(lore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 15);
			inv.setItem(40, item);
			
			return item;
		}
	}
	
	public static ItemStack SellItem1(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "1"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
				ItemStack i = new ItemStack(material, 1);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(10, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 1);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 1)){
				ItemStack item = new ItemStack(material, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(10, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(10, item);
			
				return item;
			}
		}
	}

	public static ItemStack SellItem2(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "2"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() <= (65 -2)){
				ItemStack i = new ItemStack(material, 2);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(11, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 2);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 2)){
				ItemStack item = new ItemStack(material, 2);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(11, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(11, item);
			
				return item;
			}
		}
	}
	
	public static ItemStack SellItem3(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "3"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() < (65 -3)){
				ItemStack i = new ItemStack(material, 3);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(12, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 3);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 3)){
				ItemStack item = new ItemStack(material, 3);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(12, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(12, item);
			
				return item;
			}
		}
	}
	
	public static ItemStack SellItem4(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "4"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() < (65 -4)){
				ItemStack i = new ItemStack(material, 4);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(13, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 4);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 4)){
				ItemStack item = new ItemStack(material, 4);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(13, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(13, item);
			
				return item;
			}
		}
	}
	
	public static ItemStack SellItem5(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "5"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() < (65 -5)){
				ItemStack i = new ItemStack(material, 5);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(14, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 5);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 5)){
				ItemStack item = new ItemStack(material, 5);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(14, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(14, item);
			
				return item;
			}
		}
	}
	
	public static ItemStack SellItem6(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "6"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() < (65 -6)){
				ItemStack i = new ItemStack(material, 6);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
					ItemStack item = new ItemStack(material, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(15, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 6);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 6)){
				ItemStack item = new ItemStack(material, 6);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(15, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(15, item);
			
				return item;
			}
		}
	}
	
	public static ItemStack SellItem64(Player p, Inventory inv, Material material, int durability){
		JobMaterial m = JobMaterial.getJobMaterial(material, durability);
		String displayname = JobManager.getItemDisplayColorName(m).substring(0, 4) + "+" + "64"+ " " + JobManager.getItemDisplayColorName(m).substring(4);
		
		if(p.getOpenInventory().getTopInventory().getItem(40) != null){
			if(p.getOpenInventory().getTopInventory().getItem(40).getType() == Material.STAINED_GLASS_PANE){
				ItemStack i = new ItemStack(material, 64);
				i.setDurability((short) durability);
				if(p.getInventory().containsAtLeast(i, 64)){
					ItemStack item = new ItemStack(material, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName(displayname);
					item.setItemMeta(itemmeta);
					item.setDurability((short) durability);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c" + displayname.substring(2));
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(16, item);
			
				return item;
			}
		}
		else{
			ItemStack i = new ItemStack(material, 64);
			i.setDurability((short) durability);
			if(p.getInventory().containsAtLeast(i, 64)){
				ItemStack item = new ItemStack(material, 64);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName(displayname);
				item.setItemMeta(itemmeta);
				item.setDurability((short) durability);
				inv.setItem(16, item);
				
				return item;
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§c" + displayname.substring(2));
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(16, item);
			
				return item;
			}
		}
	}
}
