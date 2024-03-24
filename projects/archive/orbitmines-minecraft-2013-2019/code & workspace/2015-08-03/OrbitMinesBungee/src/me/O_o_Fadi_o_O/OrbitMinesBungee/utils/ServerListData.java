package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.util.ArrayList;
import java.util.Collection;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.Server;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ServerListData {

	private Server server;
	private String players;
	private int silentplayers;
	private Collection<ProxiedPlayer> pplayers;
	
	public ServerListData(Server server){
		this.server = server;
		this.players = "";
		this.silentplayers = 0;
		
		net.md_5.bungee.api.config.ServerInfo info = ProxyServer.getInstance().getServerInfo(server.toString().toLowerCase());
		if(info != null){
			this.pplayers = ProxyServer.getInstance().getServerInfo(server.toString().toLowerCase()).getPlayers();
		}
		else{
			this.pplayers = new ArrayList<ProxiedPlayer>();
		}
		
		if(pplayers != null){
			for(ProxiedPlayer p : pplayers){
				BungeePlayer bp = BungeePlayer.getBungeePlayer(p);
				
				if(!bp.isSilent()){
					if(players.equals("")){
						players = bp.getColor() + p.getName();
					}
					else{
						players += "§7, " + bp.getColor() + p.getName();
					}
				}
				else{
					silentplayers++;
				}
			}
		}
	}

	public Server getServer() {
		return server;
	}
	
	public String getPlayers() {
		return players;
	}
	
	public int getTotalPlayers() {
		return pplayers.size() - silentplayers;
	}
	
	public String getToSend(){
		if(pplayers != null){
			return " " + server.getName() + "§7(" + getTotalPlayers() + "§7) " + getPlayers();
		}
		return " " + server.getName() + "§7(§4§lOffline§7)";
	}
}
