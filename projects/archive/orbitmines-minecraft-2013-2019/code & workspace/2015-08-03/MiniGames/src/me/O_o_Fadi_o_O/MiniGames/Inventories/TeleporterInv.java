package me.O_o_Fadi_o_O.MiniGames.Inventories;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

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
		
		Game game = StorageManager.playersgame.get(p);
		int arena = StorageManager.playersarena.get(p);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			
			if(StorageManager.playersgame.containsKey(player)){
				if(StorageManager.playersgame.get(player) == game){
					if(StorageManager.playersarena.get(player) == arena){
						if(StorageManager.playersinsurvivalgames.contains(player)){
							list.add(player);
						}
					}
				}
			}
		}

		int i = 0;
		for(Player player : list){
			try{
				getPlayerItem(inv, player, i);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			i++;
		}
	}
	
	public static void getPlayerItem(Inventory inv, Player p, int slot){
		
		double health = getDecimal(((CraftPlayer) p).getHealth() / 2);
		double food = getDecimal(p.getFoodLevel() / 2);
		int totalkills = StorageManager.survivalgameskills.get(p);
		int roundkills = StorageManager.survivalgamesroundkills.get(p);
		int wins = StorageManager.survivalgameswins.get(p);
		int loses = StorageManager.survivalgamesloses.get(p);
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		item.setDurability((short) 3);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setOwner(p.getName());
		itemmeta.setDisplayName(getPlayerDisplayname(p));
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add("§cHealth: §f" + health + "/10.0");
		lore.add("§6Food: §f" + food + "/10.0");
		lore.add("§7Kills this Round: §f" + roundkills);
		lore.add("");
		lore.add("§2§lSurvival Games Stats:");
		lore.add("§7Total Kills: §f" + totalkills);
		lore.add("§aGames Won: §f" + wins);
		lore.add("§4Games Lost: §f" + loses);
		lore.add("");
		lore.add("§e§lClick Here to Teleport");
		lore.add("");
		
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
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
