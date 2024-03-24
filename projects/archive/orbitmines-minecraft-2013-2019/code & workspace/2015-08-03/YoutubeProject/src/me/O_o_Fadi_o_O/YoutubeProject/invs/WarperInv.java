package me.O_o_Fadi_o_O.YoutubeProject.invs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarperInv {

	public static Inventory getWarperInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 9, "§0§lWarper");
		
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§aTeleport naar de §6§lSpawn§a.");
			item.setItemMeta(meta);
			item.setDurability((short) 5);
			
			inv.setItem(2, item);
		}
		{
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§aTeleport naar de §c§lNether§a.");
			item.setItemMeta(meta);
			item.setDurability((short) 14);
			
			inv.setItem(6, item);
		}
		
		return inv;
	}
}
