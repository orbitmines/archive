package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Material;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockFormEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	public void onForm(final EntityBlockFormEvent e){
		if(e.getEntity() instanceof Snowman){
			new BukkitRunnable(){
				public void run(){
		            if(e.getBlock().getState().getType() == Material.SNOW){
		                e.getBlock().setType(Material.AIR);
					}
				}
			}.runTaskLater(this.start, 100);
		}
	}

}
