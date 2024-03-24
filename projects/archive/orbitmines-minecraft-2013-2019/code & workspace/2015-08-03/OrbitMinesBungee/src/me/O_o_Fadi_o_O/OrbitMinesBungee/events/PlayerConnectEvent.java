package me.O_o_Fadi_o_O.OrbitMinesBungee.events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BannedIP;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BannedPlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BungeePlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData.BungeeServer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.StaffRank;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerConnectEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(ServerConnectEvent e) throws ParseException {
		ProxiedPlayer p = e.getPlayer();
		BungeePlayer bp = BungeePlayer.getBungeePlayer(p);
		BungeeServer bungee = ServerData.getBungee();
		
		if(bp == null){
			bp = new BungeePlayer(p);
			
			if(BannedPlayer.getBannedPlayer(p.getUniqueId()) != null){
				BannedPlayer bannedp = BannedPlayer.getBannedPlayer(p.getUniqueId());
				Date banneduntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(bannedp.getBannedUntil());
				
				if(new Date(Calendar.getInstance().getTimeInMillis()).compareTo(banneduntil) >= 0){
					bp.unban(p.getUniqueId());
				}
				else{
					p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + bannedp.getBannedBy() + "§c)\n§cUnban On: §6§l" + bannedp.getBannedUntil() + "\n§cReason: §6§l" + bannedp.getReason());
					e.setCancelled(true);
				}
			}
			else if(BannedIP.getBannedIP(p.getAddress().getHostString()) != null){
				BannedIP bannedip = BannedIP.getBannedIP(p.getAddress().getHostString());
				Date banneduntil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(bannedip.getBannedUntil());
				
				if(new Date(Calendar.getInstance().getTimeInMillis()).compareTo(banneduntil) >= 0){
					bp.unban(p.getAddress().getHostString());
				}
				else{
					p.disconnect("§cYou've been §4§lBANNED§c! (By §b" + bannedip.getBannedBy() + "§c)\n§cUnban On: §6§l" + bannedip.getBannedUntil() + "\n§cReason: §6§l" + bannedip.getReason());
					e.setCancelled(true);
				}
			}
			else{
				bp.load();
				
				if(bungee.inMaintenanceMode()){
					if(!bp.hasPerms(StaffRank.Owner)){
						e.setCancelled(true);
						p.disconnect("§d§lMaintenance Mode\n§dWe're currently working on something!\n§d§oThank you, for your understanding!");
					}
				}
			}
		}
	}
}
