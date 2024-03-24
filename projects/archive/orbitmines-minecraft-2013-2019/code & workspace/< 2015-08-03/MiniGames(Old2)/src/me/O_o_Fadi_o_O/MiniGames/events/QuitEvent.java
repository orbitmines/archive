package me.O_o_Fadi_o_O.MiniGames.events;

import java.sql.SQLException;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(!StorageManager.PlayersGame.containsKey(player)){
				player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§oMiniGames§4§o)");
			}
		}
		
		if(StorageManager.PlayersGame.containsKey(p)){
			if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
				ChickenFight.leaveArena(p, StorageManager.PlayersArena.get(p));
			}
			if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
				SurvivalGames.leaveArena(p, StorageManager.PlayersArena.get(p));
			}
		}
		else{
			Start.teleportToLobby(p);
		}
		
		if(StorageManager.FireworkPasses.get(p.getName()) != null){
			try {
				DatabaseManager.setFireworksPasses(p, StorageManager.FireworkPasses.get(p.getName()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(StorageManager.ownerpets.containsKey(p)){
			
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
						if(en instanceof LivingEntity){
							en.remove();
							StorageManager.owners.remove(StorageManager.ownerpets.get(p));
							StorageManager.ownerpets.remove(p);
						}
					}
				}
			}
		}
	}
}
