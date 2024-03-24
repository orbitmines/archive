package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e){
	
		Player p = e.getPlayer();
		
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				if(StorageManager.playersgame.containsKey(p)){
					if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
						e.setCancelled(true);
					}
					else if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
						if(StorageManager.playersinsurvivalgames.contains(p)){
							if(StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.INGAME || StorageManager.survivalgamesstate.get(StorageManager.playersarena.get(p)) == SurvivalGamesState.DEATHMATCH){
								Block b = e.getBlock();
								int id = b.getTypeId();
								if(id == 18 // LEAVES
								|| id == 31 // GRASS
								|| id == 32 // DEAD BUSH
								|| id == 37 // FLOWER 1
								|| id == 38 // FLOWER 2
								|| id == 39 // BROWN MUSHROOM
								|| id == 40 // RED MUSHROOM
								|| id == 106 // VINES
								|| id == 161 // LEAVES 2
								|| id == 175 // FLOWER 3
								|| id == 142 // POTATO PLANT
								|| id == 141 // CARROT PLANT
								|| id == 59 // WHEAT PLANT
										){
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
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
