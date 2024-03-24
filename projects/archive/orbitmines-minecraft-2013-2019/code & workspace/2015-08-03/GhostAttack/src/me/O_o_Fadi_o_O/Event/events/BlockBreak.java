package me.O_o_Fadi_o_O.Event.events;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.managers.Manager;
import me.O_o_Fadi_o_O.Event.utils.GameState;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		
		Player p = e.getPlayer();
		if(!p.isOp()){
			e.setCancelled(true);
		}
		else{
			if(Start.state != GameState.LOBBY){
				e.setCancelled(true);
			}
		}
		if(Manager.Spectators.contains(p)){
			e.setCancelled(true);
		}
	}
}
