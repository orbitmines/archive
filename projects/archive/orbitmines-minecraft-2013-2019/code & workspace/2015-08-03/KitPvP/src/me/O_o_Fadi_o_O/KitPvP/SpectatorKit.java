package me.O_o_Fadi_o_O.KitPvP;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpectatorKit {

	public static void giveInventory(Player p){
		
		Start.clearInventory(p);
		
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nBack to the Lobby");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, item);
		}
		{
			ItemStack item = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§e§nTeleporter");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(6, item);
		}
		
		p.updateInventory();
	}
}
