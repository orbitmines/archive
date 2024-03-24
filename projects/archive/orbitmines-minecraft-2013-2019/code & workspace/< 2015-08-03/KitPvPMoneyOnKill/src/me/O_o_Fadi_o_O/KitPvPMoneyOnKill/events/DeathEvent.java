package me.O_o_Fadi_o_O.KitPvPMoneyOnKill.events;

import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.Start;
import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.mobs.Spawn;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
	
	Start plugin;
	 
	public DeathEvent(Start instance) {
	plugin = instance;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		// SKELETON
		if(Start.type.get(p.getName()).equals("Skeleton")){
			Spawn.Skeleton(p);
		}
		// ZOMBIE
		if(Start.type.get(p.getName()).equals("Zombie")){
			Spawn.Zombie(p);
		}
		// BLAZE
		if(Start.type.get(p.getName()).equals("Blaze")){
			Spawn.Blaze(p);
		}
		// CREEPER
		if(Start.type.get(p.getName()).equals("Creeper")){
			Spawn.Creeper(p);
		}
		// WITCH
		if(Start.type.get(p.getName()).equals("Witch")){
			Spawn.Witch(p);
		}
		// SPIDER
		if(Start.type.get(p.getName()).equals("Spider")){
			Spawn.Spider(p);
		}
		if(Start.type.get(p.getName()).equals("None")){
			p.sendMessage(Start.TAG + "Don't forget to buy a §6Mob§7 at §6Spawn§7!");
		}
		
		// KILL MESSAGE + GIVE MONEY
		if(p.getKiller() instanceof Player){
			if(p.getKiller().hasPermission("KitPvP.VIP")){
				// OLD VIP BOOSTER
				p.getKiller().sendMessage(Start.TAG + "You killed: §6" + p.getName() + "§7! You earned: §650$ §cx2 §7(§6VIP§7)");
				Start.economy.depositPlayer(p.getKiller().getName(), 100);
				plugin.getConfig().set(p.getKiller().getName() + ".Kills", plugin.getConfig().getInt(p.getKiller().getName() + ".Kills") + 1);
				plugin.saveConfig();
				plugin.onScoreboard(p.getKiller());
			} else {
				p.getKiller().sendMessage(Start.TAG + "You killed: §6" + p.getName() + "§7! You earned: §650$");
				Start.economy.depositPlayer(p.getKiller().getName(), 50);
			}
		}
		plugin.getConfig().set(p.getName() + ".Deaths", plugin.getConfig().getInt(p.getName() + ".Deaths") + 1);
		plugin.saveConfig();
		plugin.onScoreboard(p);
	}
}
