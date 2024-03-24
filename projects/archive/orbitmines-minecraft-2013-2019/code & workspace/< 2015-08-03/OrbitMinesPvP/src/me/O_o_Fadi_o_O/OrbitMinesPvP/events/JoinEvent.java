package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;
import me.O_o_Fadi_o_O.OrbitMinesPvP.StarterItems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	Start plugin;
	 
	public JoinEvent(Start instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(e.getJoinMessage() != null){
			e.setJoinMessage(Start.Join + p.getName());
		}
		
		if(!plugin.getConfig().contains("players." + p.getName())){
			plugin.getConfig().set("players." + p.getName() + ".Kills", 0);
			plugin.getConfig().set("players." + p.getName() + ".Deaths", 0);
			plugin.getConfig().set("players." + p.getName() + ".Coins", 0);
			plugin.getConfig().set("players." + p.getName() + ".Gold", 0);
			plugin.getConfig().set("players." + p.getName() + ".Level", 0);
			plugin.getConfig().set("players." + p.getName() + ".WeaponTier", 0);
			plugin.getConfig().set("players." + p.getName() + ".WeaponTierEquiped", 0);
			plugin.getConfig().set("players." + p.getName() + ".Ship", "None");
			plugin.getConfig().set("players." + p.getName() + ".Team", "None");
			plugin.saveConfig();
			StarterItems.giveStarterItems(p);
			plugin.CurrentMap.put(p.getName(), "§fSpawn");
			
		}

		int level = plugin.getConfig().getInt("players." + p.getName() + ".Level");
		
		p.setLevel(level);
		p.setExp(1);
		
		plugin.MapScoreboard(p);
		
		Start.WeaponTier.put(p.getName(), plugin.getConfig().getInt("players." + p.getName() + ".WeaponTier"));
		Start.WeaponTierEquiped.put(p.getName(), plugin.getConfig().getInt("players." + p.getName() + ".WeaponTierEquiped"));
	}
}
