package me.O_o_Fadi_o_O.KitPvP.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.Hologram;
import me.O_o_Fadi_o_O.KitPvP.LobbyItems;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
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
	
	Start start = Start.getInstance();
	Hologram hologram = new Hologram();
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e){
		final Player p = (Player) e.getEntity();
		p.setHealth(20D);
		e.getDrops().clear();
		
		Location deathlocation = p.getLocation();
		
		spawnBodyParts(p.getLocation());
		
		p.teleport(StorageManager.spawn);
		p.setFireTicks(0);
		
		e.setDeathMessage(getDeathMessage(p));
		
		new BukkitRunnable(){
			public void run(){
				p.setVelocity(new Vector(0, 0, 0));
				Start.clearInventory(p);
				LobbyItems.giveItems(p);
			}
		}.runTaskLater(this.start, 1);
		
		if(StorageManager.kitselected.containsKey(p)){
			StorageManager.kitselected.remove(p);
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
			
				if(StorageManager.boosterplayer.equals("")){
					DatabaseManager.addMoney(killer, 50);
					
					hologram.createKillHologram(killer, p, deathlocation, 50);
					
					killer.sendMessage(Start.TAG + "§7You killed §6" + p.getName() + "§7! §6§l+50 Coins");
				}
				else{
					int addedMoney = (int) (50 * StorageManager.boosteramount);
					int extraAdded = addedMoney - 50;
					
					DatabaseManager.addMoney(killer, addedMoney);
					
					hologram.createKillHologram(killer, p, deathlocation, addedMoney);
					
					killer.sendMessage(Start.TAG + "§7You killed §6" + p.getName() + "§7! §6§l+50 Coins");
					killer.sendMessage(Start.TAG + "§6§l+" + extraAdded + " Coins §7(§a" + StorageManager.boosterplayer + "'s Booster§7)");
				}
				
				DatabaseManager.addKills(killer, 1);

				StorageManager.currentstreak.put(killer, StorageManager.currentstreak.get(killer) +1);
				killer.sendMessage(Start.TAG + "§f§lCurrent Streak: §c§l" + StorageManager.currentstreak.get(killer) + " §f§lBest Streak: §c§l" + StorageManager.beststreak.get(killer));
				if(StorageManager.beststreak.get(killer) < StorageManager.currentstreak.get(killer)){
					killer.sendMessage(Start.TAG + "§f§lNew Best Streak: §c§l" + StorageManager.currentstreak.get(killer));

					DatabaseManager.setBestStreak(killer, StorageManager.currentstreak.get(killer));

					killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 5, 1);
				}
				
				// NEEDED ON LEVEL 0 : (10 * 1) + (1 * 0) = 10
				// NEEDED ON LEVEL 1 : (10 * 2) + (1 * 1) = 21
				
				int currentlevel = StorageManager.levels.get(killer);
				int killsneeded = (10 * (currentlevel + 1)) + (1 * currentlevel);
				
				if(StorageManager.kills.get(killer) == killsneeded){
					DatabaseManager.addLevel(killer, 1);
				}
				
				final int CurrentStreak = StorageManager.currentstreak.get(killer);
				if(CurrentStreak > 2){
					new BukkitRunnable(){
						public void run(){
							Bukkit.broadcastMessage(Start.TAG + "§c§l" + killer.getName() + "§7 has a §c§l" + CurrentStreak + " Kill Streak§7!");
						}
					}.runTaskLater(this.start, 1);
				}
			}
			
		}
		StorageManager.currentstreak.put(p, 0);
		
		DatabaseManager.addDeaths(p, 1);
	}
	
	public void spawnBodyParts(Location l){
		for(int i1 = 0; i1 <= 2; i1++){
			int upper1 = 5;
			Random random1 = new Random();
			random1.nextInt((upper1));
			int upper2 = 4;
			Random random2 = new Random();
			random2.nextInt((upper2));
			int upper3 = 6;
			Random random3 = new Random();
			random3.nextInt((upper3));
			
			ItemStack toDrop = new ItemStack(Material.INK_SACK);
			ItemMeta meta = toDrop.getItemMeta();
			meta.setDisplayName("Blood" + i1);
			toDrop.setItemMeta(meta);
			toDrop.setDurability((short) 1);
			
			int upper4 = 2;
			Random random4 = new Random();
			random4.nextInt(upper4);
			
			if(random4.nextInt(upper4) == 1){
				final Item item = l.getWorld().dropItem(l.add(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 40L);
			}
			if(random4.nextInt(upper4) == 2){
				final Item item = l.getWorld().dropItem(l.subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 40L);
			}
		}
		for(int i1 = 0; i1 <= 3; i1++){
			int upper1 = 5;
			Random random1 = new Random();
			random1.nextInt((upper1));
			int upper2 = 4;
			Random random2 = new Random();
			random2.nextInt((upper2));
			int upper3 = 6;
			Random random3 = new Random();
			random3.nextInt((upper3));
			
			ItemStack toDrop = new ItemStack(Material.BONE);
			ItemMeta meta = toDrop.getItemMeta();
			meta.setDisplayName("Bone" + i1);
			toDrop.setItemMeta(meta);
			
			int upper4 = 2;
			Random random4 = new Random();
			random4.nextInt(upper4);
			
			if(random4.nextInt(upper4) == 1){
				final Item item = l.getWorld().dropItem(l.add(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 60L);
			}
			if(random4.nextInt(upper4) == 2){
				final Item item = l.getWorld().dropItem(l.subtract(4 / upper1, 4 / upper2, 4 / upper3), toDrop);
				item.setPickupDelay(Integer.MAX_VALUE);
				 
				new BukkitRunnable(){
				  @Override
				  public void run(){
				    item.remove();
				  }
				}.runTaskLater(this.start, 60L);
			}
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
