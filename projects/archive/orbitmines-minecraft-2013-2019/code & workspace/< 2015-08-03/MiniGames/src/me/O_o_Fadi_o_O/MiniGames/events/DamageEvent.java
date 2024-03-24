package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		
		if(e.getEntity().getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			e.setCancelled(true);
		}
		
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(StorageManager.spectatorsinsurvivalgames.contains(p)){
				e.setCancelled(true);
			}
			if(StorageManager.playersgame.containsKey(p)){
				if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
					if(StorageManager.chickenfightstate.get(StorageManager.playersarena.get(p)) != ChickenFightState.INGAME){
						e.setCancelled(true);
					}
				}
				if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) != SurvivalGamesState.INGAME && StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) != SurvivalGamesState.DEATHMATCH){
						e.setCancelled(true);
					}
				}
			}
			else{
				e.setCancelled(true);
			}
			if(StorageManager.spectatorsinchickenfight.contains(p)){
				e.setCancelled(true);
			}
		}
		if(e.getCause() == DamageCause.FALL){
			if(e.getEntity() instanceof Player){
				Player p = (Player) e.getEntity();
				if(StorageManager.playersgame.containsKey(p)){
					if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
						e.setCancelled(true);
					}
				}
			}
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if(StorageManager.chickenfightkit.containsKey(p)){
				if(StorageManager.chickenfightkit.get(p).equals("Hot Wing")){
					e.setDamage(e.getDamage() * 1.5);
				}
				if(StorageManager.chickenfightkit.get(p).equals("Chicken Warrior")){
					e.setDamage(e.getDamage() * 0.9);
				}
			}
		}
		
	}
}
