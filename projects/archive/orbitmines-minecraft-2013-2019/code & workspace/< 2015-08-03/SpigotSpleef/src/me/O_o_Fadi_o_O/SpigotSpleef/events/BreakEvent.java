package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSign;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if(b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN){
			e.setCancelled(ArenaSign.isSignArenaSign(b.getLocation()));
		}
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena()){
				e.setCancelled(true);
			}
		}
	}
}
