package me.O_o_Fadi_o_O.KitPvPMoneyOnKill.events;

import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.Start;

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
		
		// CONFIG 
		if(!plugin.getConfig().contains(p.getName())){
			plugin.getConfig().set(p.getName() + ".Kills", 0);
			plugin.getConfig().set(p.getName() + ".Deaths", 0);
			plugin.getConfig().set(p.getName() + ".Type", "None");
			plugin.saveConfig();
		}
		
		Start.type.put(p.getName(), plugin.getConfig().getString(p.getName() + ".Type"));
		plugin.onScoreboard(p);
	}
}
