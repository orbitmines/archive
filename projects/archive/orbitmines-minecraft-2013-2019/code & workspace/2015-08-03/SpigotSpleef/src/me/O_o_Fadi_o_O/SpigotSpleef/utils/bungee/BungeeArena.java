package me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

public class BungeeArena {

	private String server;
	private int arenaid;
	private int minplayers;
	private int maxplayers;
	private String mapname;
	private int players;
	private int spectators;
	private SpleefStatus status;
	private int minutes;
	private int seconds;
	
	public BungeeArena(String server, int arenaid, int minplayers, int maxplayers, String mapname, int players, int spectators, SpleefStatus status, int minutes, int seconds){
		this.server = server;
		this.arenaid = arenaid;
		this.minplayers = minplayers;
		this.maxplayers = maxplayers;
		this.mapname = mapname;
		this.players = players;
		this.spectators = spectators;
		this.status = status;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public String getServer(){
		return this.server;
	}
	public void setServer(String server){
		this.server = server;
	}
	
	public int getArenaID(){
		return this.arenaid;
	}
	
	public int getMinPlayers(){
		return this.minplayers;
	}
	public void setMinPlayers(int minplayers){
		this.minplayers = minplayers;
	}
	
	public int getMaxPlayers(){
		return this.maxplayers;
	}
	public void setMaxPlayers(int maxplayers){
		this.maxplayers = maxplayers;
	}
	
	public String getMapName(){
		return this.mapname;
	}
	public void setMapName(String mapname){
		this.mapname = mapname;
	}
	
	public int getPlayers(){
		return players;
	}
	public void setPlayers(int players){
		this.players = players;
	}
	
	public int getSpectators(){
		return spectators;
	}
	public void setSpectators(int spectators){
		this.spectators = spectators;
	}
	
	public SpleefStatus getStatus(){
		return status;
	}
	public boolean isStatus(SpleefStatus status){
		return this.status == status;
	}
	public void setStatus(SpleefStatus status){
		this.status = status;
	}
	
	public int getMinutes(){
		return this.minutes;
	}
	public void subtractMinute(){
		this.minutes = this.minutes -1;
	}
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	public int getSeconds(){
		return this.seconds;
	}
	public void subtractSecond(){
		this.seconds = this.seconds -1;
	}
	public void setSeconds(int seconds){
		this.seconds = seconds;
	}
	
	public boolean enoughPlayers(){
		if(getPlayers() >= getMinPlayers()){
			return true;
		}
		return false;
	}
	public boolean isFull(){
		if(getPlayers() >= getMaxPlayers()){
			return true;
		}
		return false;
	}
	
	public static BungeeArena getArenaFromID(int arenaid){
		for(BungeeArena arena : StorageManager.bungeearenas){
			if(arena.getArenaID() == arenaid){
				return arena;
			}
		}
		return null;
	}
}
