package me.O_o_Fadi_o_O.OrbitMinesPvP.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TradeMaterials {
	
	public static Inventory getMaterialsInventory(){
		
		Inventory i = Bukkit.createInventory(null, 54, "             §c§lMaterials");
		
		{
			
			ItemStack redstone = new ItemStack(Material.INK_SACK, 1);
			ItemMeta redstonemeta = redstone.getItemMeta();
			redstonemeta.setDisplayName("§cRed Material");
			redstone.setItemMeta(redstonemeta);
			redstone.setDurability((short) 1);
			i.setItem(10, redstone);
			
		}
		{
			
			ItemStack lapis = new ItemStack(Material.INK_SACK, 1);
			ItemMeta lapismeta = lapis.getItemMeta();
			lapismeta.setDisplayName("§1Blue Material");
			lapis.setItemMeta(lapismeta);
			lapis.setDurability((short) 4);
			i.setItem(12, lapis);
			
		}
		{
			
			ItemStack green = new ItemStack(Material.INK_SACK, 1);
			ItemMeta greenmeta = green.getItemMeta();
			greenmeta.setDisplayName("§2Green Material");
			green.setItemMeta(greenmeta);
			green.setDurability((short) 2);
			i.setItem(14, green);
			
		}
		{
			
			ItemStack yellow = new ItemStack(Material.INK_SACK, 1);
			ItemMeta yellowmeta = yellow.getItemMeta();
			yellowmeta.setDisplayName("§eYellow Material");
			yellow.setItemMeta(yellowmeta);
			yellow.setDurability((short) 11);
			i.setItem(16, yellow);
			
		}
		{
			
			ItemStack purple = new ItemStack(Material.INK_SACK, 1);
			ItemMeta purplemeta = purple.getItemMeta();
			purplemeta.setDisplayName("§5Purple Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§c§o10 Red Material");
			l.add("§1§o5 Blue Material");
			purplemeta.setLore(l);
			purple.setItemMeta(purplemeta);
			purple.setDurability((short) 5);
			i.setItem(20, purple);
			
		}
		{
			
			ItemStack cyan = new ItemStack(Material.INK_SACK, 1);
			ItemMeta cyanmeta = cyan.getItemMeta();
			cyanmeta.setDisplayName("§3Cyan Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§1§o10 Blue Material");
			l.add("§2§o10 Green Material");
			cyanmeta.setLore(l);
			cyan.setItemMeta(cyanmeta);
			cyan.setDurability((short) 6);
			i.setItem(22, cyan);
			
		}
		{
			
			ItemStack lime = new ItemStack(Material.INK_SACK, 1);
			ItemMeta limemeta = lime.getItemMeta();
			limemeta.setDisplayName("§aLime Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§e§o10 Yellow Material");
			l.add("§2§o5 Green Material");
			limemeta.setLore(l);
			lime.setItemMeta(limemeta);
			lime.setDurability((short) 10);
			i.setItem(24, lime);
			
		}
		{	
			
			ItemStack magenta = new ItemStack(Material.INK_SACK, 1);
			ItemMeta magentameta = magenta.getItemMeta();
			magentameta.setDisplayName("§dMagenta Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§5§o15 Purple Material");
			l.add("§3§o10 Cyan Material");
			magentameta.setLore(l);
			magenta.setItemMeta(magentameta);
			magenta.setDurability((short) 13);
			i.setItem(30, magenta);
			
		}
		{	
			
			ItemStack blue = new ItemStack(Material.INK_SACK, 1);
			ItemMeta bluemeta = blue.getItemMeta();
			bluemeta.setDisplayName("§bLight Blue Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§a§o15 Lime Material");
			l.add("§3§o10 Cyan Material");
			bluemeta.setLore(l);
			blue.setItemMeta(bluemeta);
			blue.setDurability((short) 12);
			i.setItem(32, blue);
			
		}
		{	
			
			ItemStack gray = new ItemStack(Material.INK_SACK, 1);
			ItemMeta graymeta = gray.getItemMeta();
			graymeta.setDisplayName("§7Gray Material");
			List<String> l = new ArrayList<String>();
			l.add(" ");
			l.add("§7§oCraft Price:");
			l.add("§d§o10 Magenta Material");
			l.add("§b§o10 Light Blue Material");
			graymeta.setLore(l);
			gray.setItemMeta(graymeta);
			gray.setDurability((short) 8);
			i.setItem(40, gray);
			
		}
		
		
		return i;
		
	}
}
