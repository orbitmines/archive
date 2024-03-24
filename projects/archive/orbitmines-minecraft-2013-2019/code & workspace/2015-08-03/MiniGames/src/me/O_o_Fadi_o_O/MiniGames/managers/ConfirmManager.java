package me.O_o_Fadi_o_O.MiniGames.managers;

import me.O_o_Fadi_o_O.MiniGames.utils.Currency;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmManager {

	public static Inventory getConfirmInv(ItemStack item, Currency currency, int price){
		
		Inventory inv = Bukkit.createInventory(null, 45, "§0§lConfirm your Purchase");
		
		ItemStack confirm = getConfirmItemStack();
		ItemStack cancel = getCancelItemStack();
		
		inv.setItem(0, confirm);
		inv.setItem(1, confirm);
		inv.setItem(2, confirm);
		inv.setItem(9, confirm);
		inv.setItem(10, confirm);
		inv.setItem(11, confirm);
		inv.setItem(18, confirm);
		inv.setItem(19, confirm);
		inv.setItem(20, confirm);
		inv.setItem(27, confirm);
		inv.setItem(28, confirm);
		inv.setItem(29, confirm);
		inv.setItem(36, confirm);
		inv.setItem(37, confirm);
		inv.setItem(38, confirm);
		
		inv.setItem(13, getBuyingItemStack(item));
		inv.setItem(31, getPriceItemStack(currency, price));
		
		inv.setItem(6, cancel);
		inv.setItem(7, cancel);
		inv.setItem(8, cancel);
		inv.setItem(15, cancel);
		inv.setItem(16, cancel);
		inv.setItem(17, cancel);
		inv.setItem(24, cancel);
		inv.setItem(25, cancel);
		inv.setItem(26, cancel);
		inv.setItem(33, cancel);
		inv.setItem(34, cancel);
		inv.setItem(35, cancel);
		inv.setItem(42, cancel);
		inv.setItem(43, cancel);
		inv.setItem(44, cancel);
		
		return inv;
	}
	
	public static ItemStack getBuyingItemStack(ItemStack item){
		
		if(item.getItemMeta().getLore() != null){
			ItemMeta meta = item.getItemMeta();
			if(meta.getDisplayName().equals("§6§l+5 Firework Passes")){
				meta.setDisplayName("§6§l5 Firework Passes");
			}
			if(meta.getDisplayName().equals("§6§l+25 Firework Passes")){
				meta.setDisplayName("§6§l25 Firework Passes");
			}
			if(meta.getDisplayName().startsWith("§7Hat Block Trail")){
				meta.setDisplayName("§7Hat Block Trail");
			}
			if(meta.getDisplayName().contains("Bold ChatColor")){
				meta.setDisplayName(meta.getDisplayName().substring(0, 18));
			}
			if(meta.getDisplayName().contains("Cursive ChatColor")){
				meta.setDisplayName(meta.getDisplayName().substring(0, 21));
			}
			if(meta.getDisplayName().startsWith("§7§lGround Trail")){
				meta.setDisplayName("§7§lGround Trail");
			}
			if(meta.getDisplayName().startsWith("§7§lHead Trail")){
				meta.setDisplayName("§7§lHead Trail");
			}
			if(meta.getDisplayName().startsWith("§7§lBody Trail")){
				meta.setDisplayName("§7§lBody Trail");
			}
			if(meta.getDisplayName().startsWith("§7§lBig Trail")){
				meta.setDisplayName("§7§lBig Trail");
			}
			if(meta.getDisplayName().startsWith("§7§lVertical Trail")){
				meta.setDisplayName("§7§lVertical Trail");
			}
			if(meta.getDisplayName().startsWith("§7§lSpecial Trail")){
				meta.setDisplayName("§7§lSpecial Trail");
			}
			meta.setLore(null);
			item.setItemMeta(meta);
		}
		
		return item;
		
	}
	
	private static ItemStack getPriceItemStack(Currency currency, int price){
		
		ItemStack item = new ItemStack(Material.DIAMOND, 1);
		ItemMeta meta = item.getItemMeta();
		
		if(currency == Currency.VIP_POINTS){
			item.setType(Material.DIAMOND);
			meta.setDisplayName("§cPrice: §b§l" + price + " VIP Points");
		}
		if(currency == Currency.ORBITMINES_TOKENS){
			item.setType(Material.GOLD_INGOT);
			meta.setDisplayName("§cPrice: §e§l" + price + " OrbitMines Tokens");
		}
		if(currency == Currency.MINIGAME_POINTS){
			item.setType(Material.SNOW_BALL);
			meta.setDisplayName("§cPrice: §f§l" + price + " MiniGame Coins");
		}
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	private static ItemStack getConfirmItemStack(){
	
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§a§lConfirm");
		item.setItemMeta(meta);
		item.setDurability((short) 5);
		
		return item;
	}
	
	private static ItemStack getCancelItemStack(){
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§c§lCancel");
		item.setItemMeta(meta);
		item.setDurability((short) 14);
		
		return item;
	}
}
