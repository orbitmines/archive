package me.O_o_Fadi_o_O.MiniGames.Kits.Others;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpectatorKit {

	@SuppressWarnings("deprecation")
	public static void giveInventory(Player p){
		
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nBack to the Lobby");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, item);
		}
		if(StorageManager.PlayersGame.containsKey(p)){
			if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
				ItemStack item = new ItemStack(Material.NAME_TAG, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§e§nTeleporter");
				item.setItemMeta(itemmeta);
				p.getInventory().setItem(6, item);
			}
		}
		
		p.updateInventory();
		
	}
}
