package me.O_o_Fadi_o_O.Survival.events;

import java.util.List;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.managers.ConfigManager;
import me.O_o_Fadi_o_O.Survival.managers.PlayerManager;
import me.O_o_Fadi_o_O.Survival.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {
	
	Start start = Start.getInstance();
	PlayerManager pmanager = new PlayerManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		
		StorageManager.loaded.put(p, false);
		
		pmanager.loadPlayer(p);
		
		List<String> playerstoreward = getPlayersToReward();
		if(!playerstoreward.contains(p.getName())){
			playerstoreward.add(p.getName());
			ConfigManager.playerdata.set("ClaimBugToGive", playerstoreward);
			ConfigManager.savePlayerData();
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "acb " + p.getName() + " 20000");
			
			new BukkitRunnable(){
				public void run(){
					p.sendMessage("");
					p.sendMessage("§f§lSurvival Claims had some problems lately.");
					p.sendMessage("§f§oCheck the website for more information!");
					p.sendMessage("§7§l  New Total Claimblocks: §6§l20000§7§l.");
					p.sendMessage("");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				}
			}.runTaskLater(this.start, 100);
		}
	}
	
	private List<String> getPlayersToReward(){
		return ConfigManager.playerdata.getStringList("ClaimBugToGive");
	}
}
