package me.O_o_Fadi_o_O.MiniGames.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class ToggleFlightEvent implements Listener{
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 1;
	
	@EventHandler
	public void onFlightToggle(PlayerToggleFlightEvent e){
		
		Player p = e.getPlayer();
		
		if(p.getGameMode() != GameMode.CREATIVE){
			long lastUsed = 0;
			if(lastUsage.containsKey(p.getName())){
				lastUsed = lastUsage.get(p.getName());
			}
			int cdmillis = cdtime * 1000;
					
			if(System.currentTimeMillis()-lastUsed>=cdmillis){
				
				if(StorageManager.playersgame.containsKey(p)){
					if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
							
			            p.setFlying(false);
						p.setVelocity(p.getLocation().getDirection().multiply(1.15).setY(0.5));
			            p.setAllowFlight(false);
			            e.setCancelled(true);
						p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
					}
					if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
						if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.LOBBY || StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.LASTSECONDS){
							p.setAllowFlight(false);
							p.setFlying(false);
							p.setVelocity(p.getLocation().getDirection().multiply(1.15).setY(0.5));
							p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
							e.setCancelled(true);
						}
						else{
							p.setAllowFlight(false);
							p.setFlying(false);
							e.setCancelled(true);
						}
					}
				}
				else{
					p.setAllowFlight(false);
					p.setFlying(false);
					p.setVelocity(p.getLocation().getDirection().multiply(1.15).setY(0.5));
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
					e.setCancelled(true);
				}
				
				lastUsage.put(p.getName(), System.currentTimeMillis());
			}
			else{
				p.setAllowFlight(false);
				p.setFlying(false);
				e.setCancelled(true);
			}
		}
	}
}
