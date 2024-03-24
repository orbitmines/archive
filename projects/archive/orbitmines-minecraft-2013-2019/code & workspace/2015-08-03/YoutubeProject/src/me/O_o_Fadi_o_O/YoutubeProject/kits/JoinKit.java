package me.O_o_Fadi_o_O.YoutubeProject.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinKit {

	public static void giveJoinKit(Player p){
		{
			ItemStack item = new ItemStack(Material.COMPASS, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§9Warper");
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add("  §7§oTeleport naar een Warp  ");
			lore.add("");
			meta.setLore(lore);
			item.setItemMeta(meta);
			
			p.getInventory().setItem(4, item);
		}
		{
			ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			
			p.getInventory().setChestplate(item);
		}
	}
}
