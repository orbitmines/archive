package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		
		Player p = e.getPlayer();
		
		if(StorageManager.PlayersGame.containsKey(p)){
			if(StorageManager.PlayersGame.get(p).equals(Game.CHICKENFIGHT)){
				e.setCancelled(true);
			}
			if(StorageManager.PlayersGame.get(p).equals(Game.SURVIVALGAMES)){
				if(StorageManager.PlayersInSurvivalGames.contains(p)){
					if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.INGAME || StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.DEATHMATCH){
						
						Block b2 = e.getBlockPlaced();
						if(b2.getTypeId() == 92 //CAKE
						|| b2.getTypeId() == 51 //FIRE
								){
						}
						else if(b2.getTypeId() == 46){
							
							b2.setType(Material.AIR);
							TNTPrimed tnt = (TNTPrimed) b2.getWorld().spawnEntity(b2.getLocation().add(0, 1, 0), EntityType.PRIMED_TNT);
							tnt.setFuseTicks((int) (20 * 1.5));
						}
						else{
							p.damage(5D);
							p.sendMessage("§4Block Glitch §8| §7Do not try to block glitch!");
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
					}
				}
				else{
					e.setCancelled(true);
				}
				
			}
		}
		else{
			e.setCancelled(true);
		}
	}
}
