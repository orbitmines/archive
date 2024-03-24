package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.LobbyItems;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{

	Start start = Start.getInstance();
	PlayerManager pmanager = new PlayerManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		Start.clearInventory(p);
		p.teleport(StorageManager.spawn);
		LobbyItems.giveItems(p);
		
		e.setJoinMessage(null);
		
		StorageManager.loaded.put(p, false);
		
		pmanager.loadPlayer(p);
		
		setCurrentLevel(p);
	}
	
	public void setCurrentLevel(Player p){
		p.setLevel(StorageManager.levels.get(p));
		p.setExp(1);	
	}
}
