package me.O_o_Fadi_o_O.MiniGames.Kits.Others;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MiniGamesLobbyKit {

	public static void giveInventory(Player p, boolean clear){
		
		p.setHealth(20D);
		
		if(clear == true){
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
		}
		
		{
			ItemStack item = new ItemStack(Material.EMERALD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2§nStats");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(0, item);
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nBack to the Hub");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(2, item);
		}
		{
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§nMiniGame Selector");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, item);
		}	
		if(p.getInventory().getItem(6) == null || p.getInventory().getItem(6).getType() != Material.PUMPKIN && p.getInventory().getItem(6).getType() != Material.SNOW_BALL && p.getInventory().getItem(6).getType() != Material.SKULL_ITEM && p.getInventory().getItem(6).getType() != Material.SADDLE && p.getInventory().getItem(6).getType() != Material.BOOK && p.getInventory().getItem(6).getType() != Material.EYE_OF_ENDER && p.getInventory().getItem(6).getType() != Material.MAGMA_CREAM){
			ItemStack item = new ItemStack(Material.LEASH, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6§nStacker");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(6, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(8, item);
		}
		
		p.updateInventory();
		
	}
}
