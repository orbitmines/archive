package me.O_o_Fadi_o_O.OrbitMines.utils.hub;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MGArena {

	private MiniGameType type;
	private int arenaid;
	private Location signlocation;
	private GameState state;
	private int secondsrestarting;
	private int players;
	private int minutes;
	private int seconds;
	private int lastresponse;
	
	public MGArena(MiniGameType type, int arenaid, Location signlocation){
		this.type = type;
		this.arenaid = arenaid;
		this.signlocation = signlocation;
		this.state = GameState.CLOSED;
		this.players = 0;
		this.minutes = 0;
		this.seconds = 0;
		this.secondsrestarting = 0;
	}
	
	public MGArena(MiniGameType type, int arenaid, GameState state, Location signlocation){
		this.type = type;
		this.arenaid = arenaid;
		this.signlocation = signlocation;
		this.state = state;
		this.players = 0;
		this.minutes = 0;
		this.seconds = 0;
		this.secondsrestarting = 0;
	}

	public MiniGameType getType() {
		return type;
	}
	public void setType(MiniGameType type) {
		this.type = type;
	}

	public int getArenaID() {
		return arenaid;
	}
	public void setArenaID(int arenaid) {
		this.arenaid = arenaid;
	}

	public Location getSignLocation() {
		return signlocation;
	}
	public void setSignLocation(Location signlocation) {
		this.signlocation = signlocation;
	}

	public GameState getState() {
		return state;
	}
	public void setState(GameState state) {
		this.state = state;
	}

	public int getSecondsRestarting() {
		return secondsrestarting;
	}
	public void setSecondsRestarting(int secondsrestarting) {
		this.secondsrestarting = secondsrestarting;
	}

	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}

	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getLastResponse() {
		return lastresponse;
	}
	public void setLastResponse(int lastresponse) {
		this.lastresponse = lastresponse;
	}
	
	public void updateSign(){
		String color = getState().getColor();
		if((getState() == GameState.WAITING || getState() == GameState.STARTING) && getPlayers() == getType().getMaxPlayers()){
			color = "§4";
		}
		
		String[] lines = new String[4];
		if(getState() != GameState.CLOSED && getState() != GameState.RESTARTING && getState() != GameState.ENDING){
			lines[0] = color + "§l" + getType().getSignName() + " " + getArenaID();
			lines[1] = color + "§l" + getState().getStatus(this);
			lines[2] = getPlayers() + color + "/§0" + getType().getMaxPlayers();
			if(getState() == GameState.WAITING && getPlayers() < 3){
				lines[3] = color + "Waiting...";
			}
			else{
				lines[3] = color + getMinutes() + "m " + getSeconds() + "s";
			}
		}
		else{
			lines[0] = color + "§m            ";
			lines[1] = color + "§l" + getType().getSignName() + " " + getArenaID();
			lines[2] = color + color + "§l" + getState().getStatus(this);
			lines[3] = color + "§m            ";
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getWorld().getName().equals(getSignLocation().getWorld().getName()) && p.getLocation().distance(getSignLocation()) <= 16){
				p.sendSignChange(getSignLocation(), lines);
			}
		}
	}
	
	public static MGArena getMGArena(MiniGameType type, int arenaid){
		for(MGArena arena : ServerData.getHub().getMGArenas()){
			if(arena.getType() == type && arena.getArenaID() == arenaid){
				return arena;
			}
		}
		return null;
	}
	public static MGArena getMGArena(Location signlocation){
		for(MGArena arena : ServerData.getHub().getMGArenas()){
			Location l = arena.getSignLocation();
			if(l.getBlockX() == signlocation.getBlockX() && l.getBlockY() == signlocation.getBlockY() && l.getBlockZ() == signlocation.getBlockZ()){
				return arena;
			}
		}
		return null;
	}
}
