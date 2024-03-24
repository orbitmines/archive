package me.O_o_Fadi_o_O.OrbitMinesPvP.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SellMaterials {
	
public static Inventory getSellMaterialsInventory(){
		
		Inventory i = Bukkit.createInventory(null, 9, "          §c§lSell Materials");
		
		{
			
			ItemStack redstone = new ItemStack(Material.INK_SACK, 1);
			ItemMeta redstonemeta = redstone.getItemMeta();
			redstonemeta.setDisplayName("§cRed Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o5 Coins");
			redstonemeta.setLore(l);
			redstone.setItemMeta(redstonemeta);
			redstone.setDurability((short) 1);
			i.setItem(0, redstone);
			
		}
		{
			
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			ItemMeta lapismeta = lapis.getItemMeta();
			lapismeta.setDisplayName("§1Blue Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o10 Coins");
			lapismeta.setLore(l);
			lapis.setItemMeta(lapismeta);
			lapis.setDurability((short) 4);
			i.setItem(1, lapis);
			
		}
		{
			
			ItemStack green = new ItemStack(Material.INK_SACK, 1);
			ItemMeta greenmeta = green.getItemMeta();
			greenmeta.setDisplayName("§2Green Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o15 Coins");
			greenmeta.setLore(l);
			green.setItemMeta(greenmeta);
			green.setDurability((short) 2);
			i.setItem(2, green);
			
		}
		{
			
			ItemStack yellow = new ItemStack(Material.INK_SACK, 1);
			ItemMeta yellowmeta = yellow.getItemMeta();
			yellowmeta.setDisplayName("§eYellow Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o20 Coins");
			yellowmeta.setLore(l);
			yellow.setItemMeta(yellowmeta);
			yellow.setDurability((short) 11);
			i.setItem(3, yellow);
			
		}
		{
			
			ItemStack purple = new ItemStack(Material.INK_SACK, 1);
			ItemMeta purplemeta = purple.getItemMeta();
			purplemeta.setDisplayName("§5Purple Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o100 Coins");
			purplemeta.setLore(l);
			purple.setItemMeta(purplemeta);
			purple.setDurability((short) 5);
			i.setItem(4, purple);
			
		}
		{
			
			ItemStack cyan = new ItemStack(Material.INK_SACK, 1);
			ItemMeta cyanmeta = cyan.getItemMeta();
			cyanmeta.setDisplayName("§3Cyan Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o250 Coins");
			cyanmeta.setLore(l);
			cyan.setItemMeta(cyanmeta);
			cyan.setDurability((short) 6);
			i.setItem(5, cyan);
			
		}
		{
			
			ItemStack lime = new ItemStack(Material.INK_SACK, 1);
			ItemMeta limemeta = lime.getItemMeta();
			limemeta.setDisplayName("§aLime Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o275 Coins");
			limemeta.setLore(l);
			lime.setItemMeta(limemeta);
			lime.setDurability((short) 10);
			i.setItem(6, lime);
			
		}
		{	
			
			ItemStack magenta = new ItemStack(Material.INK_SACK, 1);
			ItemMeta magentameta = magenta.getItemMeta();
			magentameta.setDisplayName("§dMagenta Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o4000 Coins");
			magentameta.setLore(l);
			magenta.setItemMeta(magentameta);
			magenta.setDurability((short) 13);
			i.setItem(7, magenta);
			
		}
		{	
			
			ItemStack blue = new ItemStack(Material.INK_SACK, 1);
			ItemMeta bluemeta = blue.getItemMeta();
			bluemeta.setDisplayName("§bLight Blue Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oSell Price: §e§o6625 Coins");
			bluemeta.setLore(l);
			blue.setItemMeta(bluemeta);
			blue.setDurability((short) 12);
			i.setItem(8, blue);
			
		}
		
		return i;
		
	}
}
