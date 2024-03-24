package me.O_o_Fadi_o_O.OrbitMinesBungee.events;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Database;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectEvent implements Listener{
	
	@EventHandler
	public void onDisconnect(ServerDisconnectEvent e){
		ProxiedPlayer p = e.getPlayer();
		
		if(p.getServer().getInfo() == e.getTarget()){
			String lastonline = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(Calendar.getInstance().getTimeInMillis()));
			ServerData.getBungee().getLastOnline().put(p.getUniqueId(), lastonline);
			Database.get().update("PlayerLastOnline", "date", lastonline, "uuid", p.getUniqueId().toString());
		}
	}
}
