package me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp;

import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.ComponentMessage;
import net.md_5.bungee.api.chat.HoverEvent.Action;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class KitPvPMap {

	private String mapname;
	private String builders;
	private Location spectatorspawn;
	private List<Location> spawns;
	private int maxy;
	private int minutes;
	private int seconds;
	
	public KitPvPMap(String mapname){
		this.mapname = mapname;
	}

	public String getMapName() {
		return mapname;
	}

	public void setMapName(String mapname) {
		this.mapname = mapname;
	}

	public String getBuilders() {
		return builders;
	}

	public void setBuilders(String builders) {
		this.builders = builders;
	}

	public Location getSpectatorSpawn() {
		return spectatorspawn;
	}

	public void setSpectatorSpawn(Location spectatorspawn) {
		this.spectatorspawn = spectatorspawn;
	}

	public List<Location> getSpawns() {
		return spawns;
	}

	public void setSpawns(List<Location> spawns) {
		this.spawns = spawns;
	}
	
	public int getMaxY(){
		return maxy;
	}
	
	public void setMaxY(int maxy){
		this.maxy = maxy;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public int getSeconds(){
		return seconds;
	}
	
	public void resetTimer(){
		this.minutes = 30;
		this.seconds = 0;
	}
	
	public void tickTimer(){
		if(seconds != -1){
			seconds = seconds -1;
		}
		if(seconds == -1){
			minutes = minutes -1;
			seconds = 59;
		}
	}
	
	public boolean nextSwitch(){
		if(this.minutes == 0 && this.seconds == 0){
			return true;
		}
		return false;
	}
	
	public Location getRandomSpawn(){
		return this.spawns.get(new Random().nextInt(this.spawns.size()));
	}
	
	public void sendJoinMessage(Player p){
		p.sendMessage("§7§m----------------------------------------");
		p.sendMessage(" §6§lOrbitMines§4§lNetwork §7- §c§lKitPvP");
		p.sendMessage(" ");
		p.sendMessage(" §7§lMap: §9§l§n" + getMapName());
		p.sendMessage(" ");
		
		ComponentMessage cm = new ComponentMessage();
		cm.addPart(" §7§lBuilt By: ", null, null, null, null);
		cm.addPart("§e§l[View]", null, null, Action.SHOW_TEXT, getBuilders());
		cm.send(p);
		
		p.sendMessage("§7§m----------------------------------------");
	}
}
