package me.O_o_Fadi_o_O.KitPvP;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleporterInv {
	
	public static Inventory inv = Bukkit.createInventory(null, 27, "§0§lTeleporter");
	
	public static Inventory getTeleporterInv(Player p){
		
		getAllPlayers(inv, p);
		
		return inv;
	}
	
	public static void getAllPlayers(Inventory inv, Player p){
		List<Player> list = new ArrayList<Player>();
		list.clear();
		inv.clear();
		
		for(Player player : Bukkit.getOnlinePlayers()){
			
			if(!StorageManager.Spectators.contains(player) && StorageManager.PlayerKitSelected.containsKey(player)){
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
		
		double Health = getDecimal(((CraftPlayer) p).getHealth() / 2);
		double Food = getDecimal(p.getFoodLevel() / 2);
		int CurrentStreak = StorageManager.CurrentStreak.get(p.getName());
		int BestStreak = StorageManager.BestStreak.get(p.getName());
		int Kills = StorageManager.kills.get(p.getName());
		int Deaths = StorageManager.deaths.get(p.getName());
		int Level = StorageManager.levels.get(p.getName());
		String[] Kit = StorageManager.PlayerKitSelected.get(p).toString().split("_");
		String KitString = "§b§l" + Kit[0] + " §7(§a" + Kit[1] + " " + Kit[2] + "§7)";
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(getPlayerDisplayname(p));
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add("§7Kit: " + KitString);
		lore.add("§cHealth: §f" + Health + "/10.0");
		lore.add("§6Food: §f" + Food + "/10.0");
		lore.add("§9Current Streak: §f" + CurrentStreak);
		lore.add("");
		lore.add("§c§lKitPvP Stats:");
		lore.add("§cKills: §f" + Kills);
		lore.add("§4Deaths: §f" + Deaths);
		lore.add("§eLevel: §f" + Level);
		lore.add("§bBest Streak: §f" + BestStreak);
		lore.add("");
		lore.add("§e§lClick Here to Teleport");
		lore.add("");
		
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		item.setDurability((short) 3);
		inv.setItem(slot, item);
		
	}
	
    public static double getDecimal(double d) {
    	 
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Double.valueOf(twoDForm.format(d));
 
    }
	
	public static String getPlayerDisplayname(Player p){
		String s = "";
		if(p.hasPermission("Rank.Owner")){
			s = "§4§lOwner §4" + p.getName();
		}
		else if(p.hasPermission("Rank.Moderator")){
			s = "§b§lMod §b" + p.getName();
		}
		else if(p.hasPermission("Rank.Builder")){
			s = "§d§lBuilder §d" + p.getName();
		}
		else if(p.hasPermission("Rank.Emerald")){
			s = "§a§lEmerald §a" + p.getName();
		}
		else if(p.hasPermission("Rank.Diamond")){
			s = "§9§lDiamond §9" + p.getName();
		}
		else if(p.hasPermission("Rank.Gold")){
			s = "§6§lGold §6" + p.getName();
		}
		else if(p.hasPermission("Rank.Iron")){
			s = "§7§lIron §7" + p.getName();
		}
		else{
			s = "§8" + p.getName();
		}
		return s;
	}
}
