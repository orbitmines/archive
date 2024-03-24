package me.O_o_Fadi_o_O.Prison.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pets {
	
	public static Inventory getPetsInv(Player p){
		
		final Inventory inv = Bukkit.createInventory(null, 45, "§0§lPets");
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4Mushroom Cow Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.mushroomcow.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 96);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(9, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dPig Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.pig.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 90);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(11, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Wolf Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.wolf.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 95);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(13, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§fSheep Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.sheep.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 91);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(15, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Horse Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.horse.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b525 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 100);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(17, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cMagma Cube Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.magmacube.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b500 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 62);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(18, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§aSlime Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.slime.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b475 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 55);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(20, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Cow Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.cow.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b425 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 92);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(22, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Silverfish Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.silverfish.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b450 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 60);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(24, item);
		}
		{
			ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eOcelot Pet");
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			if(!Start.ocelot.containsKey(p.getName())){
				itemlore.add("§c§oPrice: §b450 VIP Points");
				itemlore.add("§7§o§nClick Here to Buy");
			}
			else{
				itemlore.add("§a§lUnlocked");
				itemlore.add("§7§o§nClick Here to Activate");
			}
			itemlore.add("");
			item.setDurability((short) 98);
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			inv.setItem(26, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			inv.setItem(39, item);
		}
		{
			ItemStack item = new ItemStack(Material.FIRE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§4§nDisable Pet");
			item.setItemMeta(itemmeta);
			inv.setItem(41, item);
		}
		
		return inv;
	}
}
