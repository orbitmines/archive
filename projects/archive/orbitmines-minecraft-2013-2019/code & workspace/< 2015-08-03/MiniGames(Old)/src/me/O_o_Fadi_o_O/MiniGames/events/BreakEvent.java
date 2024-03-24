package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.utils.State;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener{
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
	
		Player p = e.getPlayer();
		
		if(!p.isOp()){
			e.setCancelled(true);
		}
		else{
			if(Start.state != State.LOBBY){
				e.setCancelled(true);
			}
		}
	}
}
