package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

import org.bukkit.Location;

public class Map {

	private int mapid;
	private String mapname;
	private Location spectatorspawn;
	private List<Location> spawns;
	private boolean inuse;
	
	public Map(int mapid, String mapname, Location spectatorspawn, List<Location> spawns, boolean inuse){
		this.mapid = mapid;
		this.mapname = mapname;
		this.spectatorspawn = spectatorspawn;
		this.spawns = spawns;
	}
	
	public int getMapID(){
		return this.mapid;
	}
	public void setMapID(int mapid){
		this.mapid = mapid;
	}
	
	public String getName(){
		return this.mapname;
	}
	public void setName(String mapname){
		this.mapname = mapname;
	}
	
	public Location getSpectatorLocation(){
		return this.spectatorspawn;
	}
	public void setSpectatorLocation(Location spectatorspawn){
		this.spectatorspawn = spectatorspawn;
	}
	
	public List<Location> getSpawns(){
		return spawns;
	}
	public void addSpawn(Location spawn){
		spawns.add(spawn);
	}
	public void setSpawn(int index, Location spawn){
		spawns.set(index, spawn);
	}
	
	public void setInUse(boolean inuse){
		this.inuse = inuse;
	}
	public boolean isInUse(){
		return this.inuse;
	}
	
	public void teleport(List<SpleefPlayer> players){
		int index = 0;
		for(SpleefPlayer sp : players){
			if(index > (spawns.size() -1)){index = 0;}
			sp.getPlayer().teleport(getSpawns().get(index));
			index++;
		}
	}
	
	public static Map getMapFromID(int mapid){
		for(Map map : StorageManager.maps){
			if(map.getMapID() == mapid){
				return map;
			}
		}
		return null;
	}
}
