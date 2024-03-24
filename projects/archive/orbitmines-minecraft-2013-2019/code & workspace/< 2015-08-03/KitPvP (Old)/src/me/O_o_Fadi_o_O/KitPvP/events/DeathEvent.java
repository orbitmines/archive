package me.O_o_Fadi_o_O.KitPvP.events;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DeathEvent implements Listener {
	
	Start plugin;
	 
	public DeathEvent(Start instance) {
	plugin = instance;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		
		// KILL MESSAGE + GIVE MONEY
		if(p.getKiller() instanceof Player){
			
			Player killer = p.getKiller();
			
			if(killer != p){
				ItemStack stick = new ItemStack(Material.STICK, 1);
				ItemMeta stickmeta = stick.getItemMeta();
				stickmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff");
				List<String> sticklore = new ArrayList<String>();
				sticklore.add("§7Wither I");
				stickmeta.setLore(sticklore);
				stick.setItemMeta(stickmeta);
				stick.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
				
				if(killer.getInventory().containsAtLeast(stick, 1)){
					ItemStack soul = new ItemStack(Material.REDSTONE, 1);
					ItemMeta soulmeta = soul.getItemMeta();
					soulmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §cSoul");
					soul.setItemMeta(soulmeta);
					killer.getInventory().addItem(soul);
				}
				
				if(killer.hasPermission("KitPvP.VIP")){
					// OLD VIP BOOSTER
					killer.sendMessage(Start.TAG + "You killed: §6" + p.getName() + "§7! You earned: §650 Coins §cx2 §7(§6VIP§7)");
					// ADD 100$
					try {
						DatabaseManager.addMoney(killer, 100);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
				} else {
					killer.sendMessage(Start.TAG + "You killed: §6" + p.getName() + "§7! You earned: §650 Coins");
					// ADD 50$
					try {
						DatabaseManager.addMoney(killer, 50);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
				}
				
				// ADD KILL
				try {
					DatabaseManager.addKills(killer, 1);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				// NEEDED ON LEVEL 0 : (10 * 1) + (1 * 0) = 10
				// NEEDED ON LEVEL 1 : (10 * 2) + (1 * 1) = 21
				
				// GIVE LEVELS IF NEEDED
				int currentlevel = StorageManager.levels.get(killer.getName());
				int killsneeded = (10 * (currentlevel + 1)) + (1 * currentlevel);
				
				if(StorageManager.kills.get(killer.getName()) == killsneeded){
					
					// ADD LEVEL
					try {
						DatabaseManager.addLevel(killer, 1);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
				}
				
				if(StorageManager.kills.get(killer.getName()) == 10){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d10§7 Kills! (§d+250 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 250);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 100){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d100§7 Kills! (§d+1000 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 1000);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 250){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d250§7 Kills! (§d+1500 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 1500);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 500){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d500§7 Kills! (§d+2000 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 2000);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 1000){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d1000§7 Kills! (§d+5000 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 5000);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 2500){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d2500§7 Kills! (§d+20000 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 20000);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				if(StorageManager.kills.get(killer.getName()) == 5000){
					
					killer.playSound(killer.getLocation(), Sound.VILLAGER_YES, 10, 1);
					killer.sendMessage("§8[§d§lAchievements§8]§7 You reached §d5000§7 Kills! (§d+50000 Coins§7)");
					try {
						DatabaseManager.addMoney(killer, 50000);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
			
		}
		// ADD DEATH
		try {
			DatabaseManager.addDeaths(p, 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
