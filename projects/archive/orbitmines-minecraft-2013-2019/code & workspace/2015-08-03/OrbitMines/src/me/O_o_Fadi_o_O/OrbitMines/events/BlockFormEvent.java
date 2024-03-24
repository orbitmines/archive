package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockFormEvent implements Listener{
	
	@EventHandler
	public void onForm(final EntityBlockFormEvent e){
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES) && e.getEntity() instanceof Snowman){
			new BukkitRunnable(){
				public void run(){
		            if(e.getBlock().getState().getType() == Material.SNOW){
		                e.getBlock().setType(Material.AIR);
					}
				}
			}.runTaskLater(Start.getInstance(), 100);
		}
	}
	
	@EventHandler
	public void onChange(final BlockFromToEvent e){
		if(ServerData.isServer(Server.CREATIVE)){
			Block b = e.getBlock();
			e.setCancelled(b.getType() == Material.WATER || b.getType() == Material.LAVA || b.getType() == Material.STATIONARY_WATER || b.getType() == Material.STATIONARY_LAVA);
		}
	}
}
