package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		final OMPlayer omp = OMPlayer.addOMPlayer(p, false);
		
		e.setJoinMessage(null);

		omp.load();
		
		if(!ServerData.isServer(Server.SURVIVAL)){
			new BukkitRunnable(){
				public void run(){
					if(ServerData.isServer(Server.HUB)){
						if(!p.getWorld().getName().equals(ServerData.getLobbyWorld().getName()) || p.getLocation().distance(ServerData.getHub().getMGLocation()) > 16){
							p.teleport(ServerData.getHub().getSpawn());
						}
					}
					else if(ServerData.isServer(Server.KITPVP)){
						p.teleport(ServerData.getKitPvP().getSpawn());
					}
					else if(ServerData.isServer(Server.CREATIVE)){
						CreativePlayer cp = omp.getCreativePlayer();
						
						if(cp == null || !cp.hasPlot()){
							p.teleport(ServerData.getCreative().getSpawn());
						}
					}
					else if(ServerData.isServer(Server.SKYBLOCK)){
						SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
						
						if(!sbp.hasIsland()){
							p.teleport(ServerData.getSkyBlock().getSpawn());
						}
						else{
							if(sbp.isOwner()){
								sbp.getIsland().setMaxMembers(sbp.getMaxMembers());
							}
						}
					}
					else{}
				}
			}.runTaskLater(Start.getInstance(), 5);
		}
	}
}
