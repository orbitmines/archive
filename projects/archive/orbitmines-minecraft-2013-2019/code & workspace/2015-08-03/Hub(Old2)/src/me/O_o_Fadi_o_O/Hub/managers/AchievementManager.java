package me.O_o_Fadi_o_O.Hub.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AchievementManager {

	public static Inventory getAchievementInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "§0§lAchievements");
		
		setAllServerItems(inv, p);
		setAllAchievementItems(inv, p, "kitpvp");
		
		return inv;
		
	}
	
	public static void setAllAchievementItems(Inventory inv, Player p, String server){
		setAchievementItem(inv, p, server, 0, 28);
		setAchievementItem(inv, p, server, 1, 29);
		setAchievementItem(inv, p, server, 2, 30);
		setAchievementItem(inv, p, server, 3, 31);
		setAchievementItem(inv, p, server, 4, 37);
		setAchievementItem(inv, p, server, 5, 38);
		setAchievementItem(inv, p, server, 6, 39);
		setAchievementItem(inv, p, server, 7, 40);
	}
	
	public static void setAchievementItem(Inventory inv, Player p, String server, int achievement, int slot){
		
		ItemStack item = new ItemStack(Material.GLASS_BOTTLE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		if(server.equals("kitpvp")){
			inv.getItem(10).addEnchantment(Enchantment.SILK_TOUCH, 32);
			if(StorageManager.KitPvPAchievementsAmount >= (achievement +1)){
				boolean completed = StorageManager.KitPvPAchievements.get(p).get(achievement);
				if(completed == true){
					item.setType(Material.EXP_BOTTLE);
					if(achievement == 0){
						meta.setDisplayName("§a§lJoin the Undeath");
						lore.add("§7§oReach 1500 Deaths.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 1){
						meta.setDisplayName("§a§lMonster");
						lore.add("§7§oReach a 25 Kill Streak.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 2){
						meta.setDisplayName("§a§lArcher");
						lore.add("§7§oKill 200 Players as the Archer Kit.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 3){
						meta.setDisplayName("§a§lJust in Time");
						lore.add("§7§oKill a Player 2 seconds before the Map Switch.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 4){
						meta.setDisplayName("§a§lKiller");
						lore.add("§7§oKill 1000 Players.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 5){
						meta.setDisplayName("§a§lAssassination");
						lore.add("§7§oKill 3000 Players.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 6){
						meta.setDisplayName("§a§lRapid Kill Streak");
						lore.add("§7§oGet 3 Kills within 5 seconds.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 7){
						meta.setDisplayName("§a§lThe Return of the King");
						lore.add("§7§oKill 250 as the King Kit Level 3.");
						lore.add("");
						lore.add("§dReward:	");
					}
				}
				else{
					item.setType(Material.POTION);
					if(achievement == 0){
						meta.setDisplayName("§c§lJoin the Undeath");
						lore.add("§7§oReach 1500 Deaths.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 1){
						meta.setDisplayName("§c§lMonster");
						lore.add("§7§oReach a 25 Kill Streak.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 2){
						meta.setDisplayName("§c§lArcher");
						lore.add("§7§oKill 200 Players as the Archer Kit.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 3){
						meta.setDisplayName("§c§lJust in Time");
						lore.add("§7§oKill a Player 2 seconds before the Map Switch.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 4){
						meta.setDisplayName("§c§lKiller");
						lore.add("§7§oKill 1000 Players.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 5){
						meta.setDisplayName("§c§lAssassination");
						lore.add("§7§oKill 3000 Players.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 6){
						meta.setDisplayName("§c§lRapid Kill Streak");
						lore.add("§7§oGet 3 Kills within 5 seconds.");
						lore.add("");
						lore.add("§dReward:	");
					}
					else if(achievement == 7){
						meta.setDisplayName("§c§lThe Return of the King");
						lore.add("§7§oKill 250 as the King Kit Level 3.");
						lore.add("");
						lore.add("§dReward:	");
					}
				}
			}
			else{}
		}
		else if(server.equals("prison")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("creative")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("hub")){
			lore.add(" §dAchievements: §7" + StorageManager.HubAchievementsCompleted.get(p) + "§d/§7" + StorageManager.HubAchievementsAmount + " ");
		}
		else if(server.equals("survival")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("skyblock")){
			lore.add(" §dAchievements: §7" + StorageManager.SkyBlockAchievementsCompleted.get(p) + "§d/§7" + StorageManager.SkyBlockAchievementsAmount + " ");
		}
		else if(server.equals("minigames")){
			lore.add(" §dAchievements: §7" + StorageManager.MiniGamesAchievementsCompleted.get(p) + "§d/§7" + StorageManager.MiniGamesAchievementsAmount + " ");
		}
		lore.add("");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(slot, item);
	}
	
	public static void setAllServerItems(Inventory inv, Player p){
	    
		setServerItem(inv, p, "kitpvp", "§c§lKitPvP", Material.IRON_SWORD, 10);
		setServerItem(inv, p, "prison", "§4§lPrison", Material.DIAMOND_PICKAXE, 11);
		setServerItem(inv, p, "creative", "§d§lCreative", Material.WOOD_AXE, 12);
		setServerItem(inv, p, "hub", "§3§lHub", Material.WATCH, 13);
		setServerItem(inv, p, "survival", "§a§lSurvival", Material.STONE_HOE, 14);
		setServerItem(inv, p, "skyblock", "§5§lSkyBlock", Material.FISHING_ROD, 15);
		setServerItem(inv, p, "minigames", "§f§lMiniGames", Material.BOW, 16);
    
	}
  
	public static void setServerItem(Inventory inv, Player p, String server, String displayName, Material m, int slot){
    
		ItemStack item = new ItemStack(m, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		List<String> lore = new ArrayList<String>();
		lore.add("");
		if(server.equals("kitpvp")){
			lore.add(" §dAchievements: §7" + StorageManager.KitPvPAchievementsCompleted.get(p) + "§d/§7" + StorageManager.KitPvPAchievementsAmount + " ");
		}
		else if(server.equals("prison")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("creative")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("hub")){
			lore.add(" §dAchievements: §7" + StorageManager.HubAchievementsCompleted.get(p) + "§d/§7" + StorageManager.HubAchievementsAmount + " ");
		}
		else if(server.equals("survival")){
			lore.add(" §dAchievements: §70§d/§70 ");
		}
		else if(server.equals("skyblock")){
			lore.add(" §dAchievements: §7" + StorageManager.SkyBlockAchievementsCompleted.get(p) + "§d/§7" + StorageManager.SkyBlockAchievementsAmount + " ");
		}
		else if(server.equals("minigames")){
			lore.add(" §dAchievements: §7" + StorageManager.MiniGamesAchievementsCompleted.get(p) + "§d/§7" + StorageManager.MiniGamesAchievementsAmount + " ");
		}
		lore.add("");
		meta.setLore(lore);
		item.setItemMeta(meta);
      
		//if(server.equals(Hub.Server)){
		//	item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		//}
		
		inv.setItem(slot, item);
	}
}
