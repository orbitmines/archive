package me.O_o_Fadi_o_O.KitPvP;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class TeleporterInv {
	
	public static Inventory inv = Bukkit.createInventory(null, 27, "§0§lTeleporter");
	
	public static Inventory getTeleporterInv(Player p){
		
		getAllPlayers(inv, p);
		
		return inv;
	}
	
	@SuppressWarnings("deprecation")
	public static void getAllPlayers(Inventory inv, Player p){
		List<Player> list = new ArrayList<Player>();
		list.clear();
		inv.clear();
		
		for(Player player : Bukkit.getOnlinePlayers()){
			
			if(!StorageManager.spectators.contains(player) && StorageManager.kitselected.containsKey(player)){
				list.add(player);
			}
		}

		if(list.size() > 27){
			inv.setMaxStackSize(36);
		}
		if(list.size() > 36){
			inv.setMaxStackSize(45);
		}
		if(list.size() > 45){
			inv.setMaxStackSize(54);
		}
		
		int i = 0;
		for(Player player : list){
			try{
				if(!(i > 53)){
					getPlayerItem(inv, player, i);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			i++;
		}
	}
	
	public static void getPlayerItem(Inventory inv, Player p, int slot){

		String health = String.format("%.1f", (double) ((CraftPlayer) p).getHealth() / 2).replaceAll(",", ".");
		String food = String.format("%.1f", (double) p.getFoodLevel() / 2).replaceAll(",", ".");
		int currentstreak = StorageManager.currentstreak.get(p);
		int beststreak = StorageManager.beststreak.get(p);
		int kills = StorageManager.kills.get(p);
		int deaths = StorageManager.deaths.get(p);
		int level = StorageManager.levels.get(p);
		String[] kit = StorageManager.kitselected.get(p).toString().split("_");
		String kitstring = "§b§l" + kit[0] + " §7(§a" + kit[1] + " " + kit[2] + "§7)";
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setOwner(p.getName());
		itemmeta.setDisplayName(PlayerManager.getPlayerDisplayname(p));
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add("§7Kit: " + kitstring);
		lore.add("§cHealth: §f" + health + "/10.0");
		lore.add("§6Food: §f" + food + "/10.0");
		lore.add("§9Current Streak: §f" + currentstreak);
		lore.add("");
		lore.add("§c§lKitPvP Stats:");
		lore.add("§cKills: §f" + kills);
		lore.add("§4Deaths: §f" + deaths);
		lore.add("§eLevel: §f" + level);
		lore.add("§bBest Streak: §f" + beststreak);
		lore.add("");
		lore.add("§e§lClick Here to Teleport");
		lore.add("");
		
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability((short) 3);
		inv.setItem(slot, item);
		
	}
}
