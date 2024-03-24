package me.O_o_Fadi_o_O.MiniGames.Kits.Others;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyKit {

	public static void giveInventory(Player p){
		
		p.setHealth(20D);
		
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		{
			ItemStack item = new ItemStack(Material.EMERALD, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§2§nStats");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(0, item);
		}
		if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
			{
				ItemStack item = new ItemStack(Material.POTION, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§b§nGame Effects");
				item.setItemMeta(itemmeta);
				p.getInventory().setItem(2, item);
			}	
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nBack to the Lobby");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, item);
		}
		if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
			if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(p)) == ChickenFightState.LOBBY){
				{
					ItemStack item = new ItemStack(Material.LEASH, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6§nStacker");
					item.setItemMeta(itemmeta);
					p.getInventory().setItem(6, new ItemStack(item));
				}
			}
		}
		if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
			if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.LOBBY){
				{
					ItemStack item = new ItemStack(Material.LEASH, 1);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6§nStacker");
					item.setItemMeta(itemmeta);
					p.getInventory().setItem(6, new ItemStack(item));
				}
			}
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
