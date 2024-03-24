package me.O_o_Fadi_o_O.MiniGames.Inventories;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChickenFightInv {
	
	public static Inventory inv = Bukkit.createInventory(null, 45, "§0§lMiniGame Selector");
	
	public static Inventory getChickenFightInv(Player p, int i){
		
		getChickenFightGame(inv, 1);
		getChickenFightGame(inv, 2);
		getChickenFightGame(inv, 3);
		getChickenFightGame(inv, 4);
		getChickenFightGame(inv, 5);
		getChickenFightGame(inv, 6);
		getChickenFightGame(inv, 7);
		
		getMiniGameSelector(inv, i);
		
		ItemStack item = new ItemStack(Material.FEATHER, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§lChicken Fight");
		item.setItemMeta(itemmeta);
		inv.setItem(0, item);
		
		return inv;
	}
	
	public static void getMiniGameSelector(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("§f§nMiniGame Selector");
		item.setItemMeta(itemmeta);
		item.setDurability((short) i);
		inv.setItem(40, item);
		
	}
	
	public static void getChickenFightGame(Inventory inv, int arena){
		
		int slot = 18 + arena;
		try{
			int players = StorageManager.chickenfightplayers.get(arena);
			int spectators = StorageManager.chickenfightspectators.get(arena);
			boolean enabled = StorageManager.chickenfightenabled.get(arena);
			int minutes = StorageManager.chickenfightminutes.get(arena);
			int seconds = StorageManager.chickenfightseconds.get(arena);
			ChickenFightState state = StorageManager.chickenfightstate.get(arena);
			String map = StorageManager.chickenfightcurrentmap.get(arena);
			
			if(players >= 64){
				players = 64;
			}
			if(players == 0){
				players = 1;
			}
			if(enabled == true){
				ItemStack item = new ItemStack(Material.STAINED_CLAY, players);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§f§lChicken Fight " + arena);
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(state == ChickenFightState.LOBBY || state == ChickenFightState.LASTSECONDS){
					if(players <= 1){
						itemlore.add("§f§lStatus: §aWaiting");
					}
					else{
						itemlore.add("§f§lStatus: §aLobby");
					}
					itemlore.add("§f§lPlayers: §a" + StorageManager.chickenfightplayers.get(arena));
					if(players >= 2){
						itemlore.add("§f§lTime Left: §a" + minutes + "m " + seconds + "s");
					}
					itemlore.add("§f§lMap: §a" + map);
					
					item.setDurability((short) 5);
				}
				if(state == ChickenFightState.INGAME){
					itemlore.add("§f§lStatus: §eIn Game");
					itemlore.add("§f§lPlayers Alive: §e" + StorageManager.chickenfightplayers.get(arena));
					itemlore.add("§f§lSpectators: §e" + spectators);
					itemlore.add("§f§lTime Left: §e" + minutes + "m " + seconds + "s");
					itemlore.add("§f§lMap: §e" + map);
					
					item.setDurability((short) 4);
				}
				if(state == ChickenFightState.WARMUP){
					itemlore.add("§f§lStatus: §2Starting...");
					
					item.setDurability((short) 13);
				}
				if(state == ChickenFightState.ENDING){
					itemlore.add("§f§lStatus: §cRestarting...");
					
					item.setDurability((short) 14);
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_CLAY, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§f§lChicken Fight " + arena);
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				itemlore.add(" §8§lClosed ");
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 15);
				inv.setItem(slot, item);
			}
		}catch(Exception ex){
			ItemStack item = new ItemStack(Material.STAINED_CLAY, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§f§lChicken Fight " + arena);
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add(" §8§lClosed ");
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 15);
			inv.setItem(slot, item);
		}
	}
}
