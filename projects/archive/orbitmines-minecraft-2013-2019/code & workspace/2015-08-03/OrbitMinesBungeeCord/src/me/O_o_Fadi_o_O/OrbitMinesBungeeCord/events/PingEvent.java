package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events;

import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PingEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPing(final ProxyPingEvent e){
		
		ServerPing r = e.getResponse();
		Protocol protocolVersion = null;
		if(Start.maintenancemode == false){
			protocolVersion = r.getVersion();
		}
		else{
			protocolVersion = new Protocol("§d§lMaintenance Mode", 1);
		}
		String motd = getRandomStringMessage();
		Players players = r.getPlayers();
		players.setMax(players.getOnline() +1);
		String s = "Test";
		ServerPing BF = new ServerPing(protocolVersion, players, motd, s);
		e.setResponse(BF);
		

	}
	
	public String getRandomStringMessage(){
		if(Start.maintenancemode == false){
			Random r = new Random();
			int i = r.nextInt(7);
			
			String s = " ";
			
			if(i == 1){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                          §4§l§k!§c§l§k!§6§l§k! §eSquirrels Everywhere! :O §6§l§k!§c§l§k!§4§l§k!";}
			else if(i == 2){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                               §4§l§k!§c§l§k!§6§l§k! §eVote with §o/vote §6§l§k!§c§l§k!§4§l§k!";}
			else if(i == 3){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                         §4§l§k!§c§l§k!§6§l§k! §eNullPointerException #Rage §6§l§k!§c§l§k!§4§l§k!";}
			else if(i == 4){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                        §4§l§k!§c§l§k!§6§l§k! §eShare your Wood over here! §6§l§k!§c§l§k!§4§l§k!";}
			else if(i == 5){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                      §4§l§k!§c§l§k!§6§l§k! §eOne does not simply walk into Orbit §6§l§k!§c§l§k!§4§l§k!";}
			else if(i == 6){s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                            §4§l§k!§c§l§k!§6§l§k! §eToo much Customness §6§l§k!§c§l§k!§4§l§k!";}
			else{s = "               §6§lOrbitMines §4§lNetwork §3§l1.7                   §4§l§k!§c§l§k!§6§l§k! §eThere's always a playerslot for you <3 §6§l§k!§c§l§k!§4§l§k!";}
			
			return s;
		}
		else{
			return "               §6§lOrbitMines §4§lNetwork §3§l1.7                      §5§l§k!§d§l§k!§5§l§k! §dYou'll be able to join in a moment §5§l§k!§d§l§k!§5§l§k!";
		}
	}
}
