package me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

public class BungeeServer {

	private String server;
	private int arenaid;
	
	public BungeeServer(String server, int arenaid){
		this.server = server;
		this.arenaid = arenaid;
	}

	public String getServer(){
		return server;
	}
	public void setServer(String server){
		this.server = server;
	}

	public int getArenaID(){
		return arenaid;
	}
	public void setArenaID(int arenaid){
		this.arenaid = arenaid;
	}
	
	public static BungeeServer getServerFromID(int arenaid){
		for(BungeeServer server : StorageManager.bungeeservers){
			if(server.getArenaID() == arenaid){
				return server;
			}
		}
		return null;
	}
}
