package me.O_o_Fadi_o_O.KitPvP.events;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.LobbyItems;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DeathEvent implements Listener {
	
	Start plugin;
	 
	public DeathEvent(Start instance) {
	plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e){
		final Player p = (Player) e.getEntity();
		p.setHealth(20D);
		e.getDrops().clear();
		p.teleport(StorageManager.spawnLocation);
		p.setFireTicks(0);
		
		e.setDeathMessage(getDeathMessage(p));
		
		new BukkitRunnable(){
			public void run(){
				p.setVelocity(new Vector(0, 0, 0));
				Start.clearInventory(p);
				LobbyItems.giveItems(p);
			}
		}.runTaskLater(this.plugin, 1);
		
		if(StorageManager.PlayerKitSelected.containsKey(p)){
			StorageManager.PlayerKitSelected.remove(p);
		}
		
		if(p.getKiller() instanceof Player){
			
			final Player killer = p.getKiller();
			
			if(killer != p){
				ItemStack stick = new ItemStack(Material.STICK, 1);
				ItemMeta stickmeta = stick.getItemMeta();
				stickmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §8Necromancer's Staff");
				List<String> sticklore = new ArrayList<String>();
				sticklore.add("§7Wither I");
				stickmeta.setLore(sticklore);
				stick.setItemMeta(stickmeta);
				stick.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
				
				if(killer.getInventory().containsAtLeast(stick, 1)){
					ItemStack soul = new ItemStack(Material.REDSTONE, 1);
					ItemMeta soulmeta = soul.getItemMeta();
					soulmeta.setDisplayName("§b§lNecromancer §a§lLvL 3§8 || §cSoul");
					soul.setItemMeta(soulmeta);
					killer.getInventory().addItem(soul);
				}
			
				if(StorageManager.BoosterPlayer.equals("")){
					try {
						DatabaseManager.addMoney(killer, 50);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
					killer.sendMessage(Start.TAG + "§7You killed §6" + p.getName() + "§7! §6§l+50 Coins");
				}
				else{
					int addedMoney = (int) (50 * StorageManager.BoosterAmount);
					int extraAdded = addedMoney - 50;
					
					try {
						DatabaseManager.addMoney(killer, addedMoney);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
					killer.sendMessage(Start.TAG + "§7You killed §6" + p.getName() + "§7! §6§l+50 Coins");
					killer.sendMessage(Start.TAG + "§6§l+" + extraAdded + " Coins §7(§a" + StorageManager.BoosterPlayer + "'s Booster§7)");
				}
				
				try {
					DatabaseManager.addKills(killer, 1);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
				StorageManager.CurrentStreak.put(killer.getName(), StorageManager.CurrentStreak.get(killer.getName()) +1);
				killer.sendMessage(Start.TAG + "§f§lCurrent Streak: §c§l" + StorageManager.CurrentStreak.get(killer.getName()) + " §f§lBest Streak: §c§l" + StorageManager.BestStreak.get(killer.getName()));
				if(StorageManager.BestStreak.get(killer.getName()) < StorageManager.CurrentStreak.get(killer.getName())){
					killer.sendMessage(Start.TAG + "§f§lNew Best Streak: §c§l" + StorageManager.CurrentStreak.get(killer.getName()));
					try {
						DatabaseManager.setBestStreak(killer, StorageManager.CurrentStreak.get(killer.getName()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 5, 1);
				}
				
				// NEEDED ON LEVEL 0 : (10 * 1) + (1 * 0) = 10
				// NEEDED ON LEVEL 1 : (10 * 2) + (1 * 1) = 21
				
				int currentlevel = StorageManager.levels.get(killer.getName());
				int killsneeded = (10 * (currentlevel + 1)) + (1 * currentlevel);
				
				if(StorageManager.kills.get(killer.getName()) == killsneeded){
					try {
						DatabaseManager.addLevel(killer, 1);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				
				final int CurrentStreak = StorageManager.CurrentStreak.get(killer.getName());
				if(CurrentStreak > 2){
					new BukkitRunnable(){
						public void run(){
							Bukkit.broadcastMessage(Start.TAG + "§c§l" + killer.getName() + "§7 has a §c§l" + CurrentStreak + " Kill Streak§7!");
						}
					}.runTaskLater(this.plugin, 1);
				}
			}
			
		}
		StorageManager.CurrentStreak.put(p.getName(), 0);
		try {
			DatabaseManager.addDeaths(p, 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getDeathMessage(Player p){
		
		Random r = new Random();
		int i = r.nextInt(2); 
	
		if(p.getKiller() instanceof Player){

			Player p2 = (Player) p.getKiller();
			
			if(p2.getItemInHand().getType() != null && p2.getItemInHand().getType() != Material.BOW){
				if(i == 0){
					return Start.TAG + "§6" + p.getName() + "§7 was killed by §6" + p2.getName() + "§7!";
				}
				else{
					return Start.TAG + "§6" + p.getName() + "§7 was slaughtered by §6" + p2.getName() + "§7!";
				}
			}
			else{
				if(i == 0){
					return Start.TAG + "§6" + p.getName() + "§7 was shot by §6" + p2.getName() + "§7!";
				}
				else{
					return Start.TAG + "§6" + p.getName() + "§7 was sniped by §6" + p2.getName() + "§7!";
				}
			}
		}
		else{
			return Start.TAG + "§6" + p.getName() + "§7 died.";
		}
	}
}
