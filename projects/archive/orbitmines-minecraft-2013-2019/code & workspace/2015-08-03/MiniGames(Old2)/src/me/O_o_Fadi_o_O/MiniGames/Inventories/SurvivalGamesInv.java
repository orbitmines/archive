package me.O_o_Fadi_o_O.MiniGames.Inventories;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SurvivalGamesInv {
	
	public static Inventory inv = Bukkit.createInventory(null, 45, "�0�lMiniGame Selector  ");
	
	public static Inventory getSurvivalGamesInv(Player p, int i){
		
		getSurvivalGamesGame(inv, 1);
		getSurvivalGamesGame(inv, 2);
		
		getMiniGameSelector(inv, i);
		
		ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("�6�lSurvival Games");
		item.setItemMeta(itemmeta);
		inv.setItem(0, item);
		
		return inv;
	}
	
	public static void getMiniGameSelector(Inventory inv, int i){
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName("�f�nMiniGame Selector");
		item.setItemMeta(itemmeta);
		item.setDurability((short) i);
		inv.setItem(40, item);
		
	}
	
	public static void getSurvivalGamesGame(Inventory inv, int arena){
		
		int slot = 18 + arena;
			try{
				int players = StorageManager.SurvivalGamesPlayers.get(arena);
				int spectators = StorageManager.SurvivalGamesSpectators.get(arena);
				boolean enabled = StorageManager.SurvivalGamesEnabled.get(arena);
				int minutes = StorageManager.SurvivalGamesMinutes.get(arena);
				int seconds = StorageManager.SurvivalGamesSeconds.get(arena);
				SurvivalGamesState state = StorageManager.SurvivalGamesState.get(arena);
				String map = StorageManager.SurvivalGamesCurrentMap.get(arena);
			if(players >= 64){
				players = 64;
			}
			if(players == 0){
				players = 1;
			}
			if(enabled == true){
				ItemStack item = new ItemStack(Material.STAINED_CLAY, players);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("�6�lSurvival Games " + arena);
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				if(state == SurvivalGamesState.LOBBY || state == SurvivalGamesState.LASTSECONDS){
					if(players <= 1){
						itemlore.add("�f�lStatus: �aWaiting");
					}
					else{
						itemlore.add("�f�lStatus: �aLobby");
					}
					itemlore.add("�f�lPlayers: �a" + StorageManager.SurvivalGamesPlayers.get(arena));
					if(players >= 2){
						itemlore.add("�f�lTime Left: �a" + minutes + "m " + seconds + "s");
					}
					itemlore.add("�f�lMap: �a" + map);
					
					item.setDurability((short) 5);
				}
				if(state == SurvivalGamesState.INGAME){
					itemlore.add("�f�lStatus: �eIn Game");
					itemlore.add("�f�lPlayers Alive: �e" + StorageManager.SurvivalGamesPlayers.get(arena));
					itemlore.add("�f�lSpectators: �e" + spectators);
					itemlore.add("�f�lDeathmatch in: �e" + minutes + "m " + seconds + "s");
					itemlore.add("�f�lMap: �e" + map);
					
					item.setDurability((short) 4);
				}
				if(state == SurvivalGamesState.DEATHMATCH){
					itemlore.add("�f�lStatus: �eDeathmatch");
					itemlore.add("�f�lPlayers Alive: �e" + StorageManager.SurvivalGamesPlayers.get(arena));
					itemlore.add("�f�lSpectators: �e" + spectators);
					itemlore.add("�f�lTime Left: �e" + minutes + "m " + seconds + "s");
					itemlore.add("�f�lMap: �e" + map);
					
					item.setDurability((short) 4);
				}
				if(state == SurvivalGamesState.WARMUP){
					itemlore.add("�f�lStatus: �2Starting...");
					
					item.setDurability((short) 13);
				}
				if(state == SurvivalGamesState.ENDING){
					itemlore.add("�f�lStatus: �cRestarting...");
					
					item.setDurability((short) 14);
				}
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				inv.setItem(slot, item);
			}
			else{
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("�6�lSurvival Games " + arena);
				List<String> itemlore = new ArrayList<String>();
				itemlore.add("");
				itemlore.add("�4�lClosed");
				itemlore.add("");
				itemmeta.setLore(itemlore);
				item.setItemMeta(itemmeta);
				item.setDurability((short) 14);
				inv.setItem(slot, item);
			}
		}catch(Exception ex){
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("�6�lSurvival Games " + arena);
			List<String> itemlore = new ArrayList<String>();
			itemlore.add("");
			itemlore.add("�4�lClosed");
			itemlore.add("");
			itemmeta.setLore(itemlore);
			item.setItemMeta(itemmeta);
			item.setDurability((short) 14);
			inv.setItem(slot, item);
		}
	}
}
