package me.O_o_Fadi_o_O.Survival.JobInvs;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Survival.Managers.MerchantManager;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sell {

	public static void getSellInv(Player p, Inventory inv, String material){
		
		SellItem1(p, inv, material);
		SellItem2(p, inv, material);
		SellItem3(p, inv, material);
		SellItem4(p, inv, material);
		SellItem5(p, inv, material);
		SellItem6(p, inv, material);
		SellItem64(p, inv, material);
		
		StatsItem(p, inv, 0, 0, material);
		
		p.openInventory(inv);
		
		{
			ItemStack item = new ItemStack(Material.WORKBENCH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§l§o<< Back");
			item.setItemMeta(itemmeta);
			inv.setItem(45, item);
				
		}
	}
	
	public static void confirmDeal(Player p, Inventory inv, String material){
		
		String s = inv.getItem(40).getItemMeta().getLore().get(1);	
		int price = Integer.parseInt(s.substring(10));
		
		if(material.equals("§8§lCoal")){
			MerchantManager.insertDeal(p, "Coal", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§7§lIron Ingot")){
			MerchantManager.insertDeal(p, "Iron Ingot", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§7§lCobblestone")){
			MerchantManager.insertDeal(p, "Cobblestone", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§1§lLapis Lazuli")){
			MerchantManager.insertDeal(p, "Lapis Lazuli", inv.getItem(40).getAmount(), price, (short) 4);
		}
		if(material.equals("§a§lEmerald")){
			MerchantManager.insertDeal(p, "Emerald", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§b§lDiamond")){
			MerchantManager.insertDeal(p, "Diamond", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§6§lGold Ingot")){
			MerchantManager.insertDeal(p, "Gold Ingot", inv.getItem(40).getAmount(), price, (short) 0);
		}
		if(material.equals("§4§lRedstone")){
			MerchantManager.insertDeal(p, "Redstone", inv.getItem(40).getAmount(), price, (short) 0);
		}
		p.playSound(p.getLocation(), Sound.VILLAGER_YES, 5, 1);
		p.sendMessage("§6§lJobs §8| §7Your " + material + "§7 deal has been added to our System! Other players can buy it at the §a§lMerchant§7!");
		p.sendMessage("");
		p.sendMessage("§a§lMerchant: §7Your deal:");
		p.sendMessage("§a§lMerchant: §7Item: " + material);
		p.sendMessage("§a§lMerchant: §7Amount: §b" + inv.getItem(40).getAmount());
		p.sendMessage("§a§lMerchant: §7Price: §6" + price + "$");
		ItemStack item = new ItemStack(inv.getItem(40).getType(), inv.getItem(40).getAmount());
		if(material.equals("§1§lLapis Lazuli")){
			item.setDurability((short) inv.getItem(40).getDurability());
		}
		p.getInventory().removeItem(item);
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
	public static ItemStack StatsItem(Player p, Inventory inv, int amount, int price, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.COAL, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§8Coal");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§8Coal");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.IRON_INGOT, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Iron Ingot");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Iron Ingot");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.COBBLESTONE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Cobblestone");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Cobblestone");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Lapis Lazuli")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.INK_SACK, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§1Lapis Lazuli");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 4);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§1Lapis Lazuli");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.EMERALD, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§aEmerald");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§aEmerald");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.DIAMOND, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§bDiamond");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§bDiamond");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.GOLD_INGOT, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Gold Ingot");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Gold Ingot");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				
				ItemStack item = new ItemStack(Material.REDSTONE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Redstone");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				lore.add("");
				lore.add("§a§l§oConfirm Deal");
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
				
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Redstone");
				List<String> lore = new ArrayList<String>();
				lore.add(" §bAmount: " + amount);
				lore.add(" §cPrice: " + price);
				itemmeta.setLore(lore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(40, item);
				
				return item;
			}
		}
		return null;
	}
	
	public static ItemStack SellItem1(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+1 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 1)){
					ItemStack item = new ItemStack(Material.COAL, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+1 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+1 Iron Ingot");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Iron Ingot");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Iron Ingot");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 1)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+1 Iron Ingot");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Iron Ingot");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+1 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 1)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+1 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+1 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 1)){
					ItemStack item = new ItemStack(Material.INK_SACK, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+1 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+1 Emerald");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Emerald");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Emerald");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 1)){
					ItemStack item = new ItemStack(Material.EMERALD, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+1 Emerald");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Emerald");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+1 Diamond");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Diamond");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Diamond");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 1)){
					ItemStack item = new ItemStack(Material.DIAMOND, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+1 Diamond");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Diamond");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+1 Gold Ingot");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Gold Ingot");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Gold Ingot");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 1)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+1 Gold Ingot");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Gold Ingot");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+1 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(10, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+1 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(10, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 1)){
					ItemStack item = new ItemStack(Material.REDSTONE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+1 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(10, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+1 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(10, item);
				
					return item;
				}
			}
		}
		return null;
	}

	public static ItemStack SellItem2(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+2 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 2)){
					ItemStack item = new ItemStack(Material.COAL, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+2 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+2 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 2)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+2 Iron Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+2 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 2)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+2 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+2 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 2)){
					ItemStack item = new ItemStack(Material.INK_SACK, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+2 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+2 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 2)){
					ItemStack item = new ItemStack(Material.EMERALD, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+2 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+2 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 2)){
					ItemStack item = new ItemStack(Material.DIAMOND, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+2 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+2 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 2)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+2 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 2 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+2 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(11, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+2 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(11, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 2)){
					ItemStack item = new ItemStack(Material.REDSTONE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+2 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(11, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 2);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+2 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(11, item);
				
					return item;
				}
			}
		}
		return null;
	}
	
	public static ItemStack SellItem3(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+3 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 3)){
					ItemStack item = new ItemStack(Material.COAL, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+3 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+3 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 3)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+3 Iron Ingot");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Iron Ingot");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+3 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 3)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+3 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+3 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 3)){
					ItemStack item = new ItemStack(Material.INK_SACK, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+3 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+3 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 3)){
					ItemStack item = new ItemStack(Material.EMERALD, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+3 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+3 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 3)){
					ItemStack item = new ItemStack(Material.DIAMOND, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+3 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+3 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 3)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+3 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 3 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+3 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(12, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+3 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(12, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 3)){
					ItemStack item = new ItemStack(Material.REDSTONE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+3 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(12, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 3);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+3 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(12, item);
				
					return item;
				}
			}
		}
		return null;
	}
	
	public static ItemStack SellItem4(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+4 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 4)){
					ItemStack item = new ItemStack(Material.COAL, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+4 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+4 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+4 Iron Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+4 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 4)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+4 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+4 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 4)){
					ItemStack item = new ItemStack(Material.INK_SACK, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+4 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+4 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)){
					ItemStack item = new ItemStack(Material.EMERALD, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+4 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+4 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 4)){
					ItemStack item = new ItemStack(Material.DIAMOND, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+4 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+4 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+4 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 4 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+4 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(13, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+4 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(13, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 4)){
					ItemStack item = new ItemStack(Material.REDSTONE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+4 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(13, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 4);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+4 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(13, item);
				
					return item;
				}
			}
		}
		return null;
	}
	
	public static ItemStack SellItem5(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+5 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 5)){
					ItemStack item = new ItemStack(Material.COAL, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+5 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+5 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 5)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+5 Iron Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+5 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 5)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+5 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+5 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 5)){
					ItemStack item = new ItemStack(Material.INK_SACK, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+5 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+5 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 5)){
					ItemStack item = new ItemStack(Material.EMERALD, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+5 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+5 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 5)){
					ItemStack item = new ItemStack(Material.DIAMOND, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+5 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+5 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 5)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+5 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 5 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+5 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(14, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+5 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(14, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 5)){
					ItemStack item = new ItemStack(Material.REDSTONE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+5 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(14, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+5 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(14, item);
				
					return item;
				}
			}
		}
		return null;
	}
	
	public static ItemStack SellItem6(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+6 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 6)){
					ItemStack item = new ItemStack(Material.COAL, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+6 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 && 
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+6 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 6)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+6 Iron Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+6 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 6)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+6 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(lapis, 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+6 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 6)){
					ItemStack item = new ItemStack(Material.INK_SACK, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+6 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+6 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 6)){
					ItemStack item = new ItemStack(Material.EMERALD, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+6 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+6 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 6)){
					ItemStack item = new ItemStack(Material.DIAMOND, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+6 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
						p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+6 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 6)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+6 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 59 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 60 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 61 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 62 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 63 &&
					p.getOpenInventory().getTopInventory().getItem(40).getAmount() != 64){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 6 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+6 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(15, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+6 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(15, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 6)){
					ItemStack item = new ItemStack(Material.REDSTONE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+6 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(15, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 6);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+6 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(15, item);
				
					return item;
				}
			}
		}
		return null;
	}
	
	public static ItemStack SellItem64(Player p, Inventory inv, String material){
		
		if(material.equals("Coal")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COAL, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§8+64 Coal");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Coal");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 64)){
					ItemStack item = new ItemStack(Material.COAL, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§8+64 Coal");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Coal");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Iron Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.IRON_INGOT, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+64 Iron Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Iron Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 64)){
					ItemStack item = new ItemStack(Material.IRON_INGOT, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+64 Iron Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Iron Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Cobblestone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.COBBLESTONE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7+64 Cobblestone");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Cobblestone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 64)){
					ItemStack item = new ItemStack(Material.COBBLESTONE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7+64 Cobblestone");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Cobblestone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Lapis Lazuli")){
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			lapis.setDurability((short) 4);
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(lapis, 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.INK_SACK, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§1+64 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 4);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+12 Lapis Lazuli");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(lapis, 64)){
					ItemStack item = new ItemStack(Material.INK_SACK, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§1+64 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 4);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Lapis Lazuli");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Emerald")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.EMERALD, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§a+64 Emeralds");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Emeralds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 64)){
					ItemStack item = new ItemStack(Material.EMERALD, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§a+64 Emeralds");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Emeralds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Diamond")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.DIAMOND, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§b+64 Diamonds");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Diamonds");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 64)){
					ItemStack item = new ItemStack(Material.DIAMOND, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§b+64 Diamonds");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Diamonds");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Gold Ingot")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.GOLD_INGOT, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§6+64 Gold Ingots");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Gold Ingots");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 64)){
					ItemStack item = new ItemStack(Material.GOLD_INGOT, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6+64 Gold Ingots");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Gold Ingots");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		if(material.equals("Redstone")){
			if(p.getOpenInventory().getTopInventory().getItem(40) != null){
				if(p.getOpenInventory().getTopInventory().getItem(40).getAmount() == 0){
					if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64 + p.getOpenInventory().getTopInventory().getItem(40).getAmount())){
						ItemStack item = new ItemStack(Material.REDSTONE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§4+64 Redstone");
						item.setItemMeta(itemmeta);
						inv.setItem(16, item);
						
						return item;
					}
					else{
						ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§c+64 Redstone");
						item.setItemMeta(itemmeta);
						item.setDurability((short) 14);
						inv.setItem(16, item);
					
						return item;
					}
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
			else{
				if(p.getInventory().containsAtLeast(new ItemStack(Material.REDSTONE), 64)){
					ItemStack item = new ItemStack(Material.REDSTONE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4+64 Redstone");
					item.setItemMeta(itemmeta);
					inv.setItem(16, item);
					
					return item;
				}
				else{
					ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 64);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§c+64 Redstone");
					item.setItemMeta(itemmeta);
					item.setDurability((short) 14);
					inv.setItem(16, item);
				
					return item;
				}
			}
		}
		return null;
	}
}
