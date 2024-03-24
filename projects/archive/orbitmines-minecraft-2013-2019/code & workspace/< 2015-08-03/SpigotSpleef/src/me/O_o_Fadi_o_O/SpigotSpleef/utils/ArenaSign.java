package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ArenaSign {

	private int arenaid;
	private Location location;
	private Arena arena;
	private BungeeArena bungeearena;
	
	public ArenaSign(int arenaid, Location location, Arena arena, BungeeArena bungeearena){
		this.arenaid = arenaid;
		this.location = location;
		this.arena = arena;
		this.bungeearena = bungeearena;
	}
	
	public int getArenaID(){
		return this.arenaid;
	}
	public void setArenaID(int arenaid){
		this.arenaid = arenaid;
	}
	
	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
	public Arena getArena(){
		return this.arena;
	}
	public void setArena(Arena arena){
		this.arena = arena;
	}

	public BungeeArena getBungeeArena(){
		return this.bungeearena;
	}
	public void setBungeeArena(final BungeeArena bungeearena){
		this.bungeearena = bungeearena;
		
		new BukkitRunnable(){
			public void run(){
				setBungeeArena(null);
				List<BungeeArena> arenas = StorageManager.bungeearenas;
				arenas.remove(bungeearena);
				StorageManager.bungeearenas = arenas;
			}
		}.runTaskLater(Start.getInstance(), 40);
	}
	
	public void update(){
		Block b = location.getWorld().getBlockAt(getLocation());
		if(b.getType() != Material.SIGN_POST && b.getType() != Material.WALL_SIGN){
			b.setType(Material.WALL_SIGN);
		}
		
		if(StorageManager.bungeecord == true){
			BungeeArena bungeearena = BungeeArena.getArenaFromID(getArenaID());
			setBungeeArena(bungeearena);
				
			if(getBungeeArena() != null){
				if(getBungeeArena().isStatus(SpleefStatus.WAITING) || getBungeeArena().isStatus(SpleefStatus.STARTING)){
					if(getBungeeArena().enoughPlayers()){
						if(getBungeeArena().isFull()){
							sendUpdate(listToArray(StorageManager.signsfull));
						}
						else{
							sendUpdate(listToArray(StorageManager.signsenoughplayers));
						}
					}
					else{
						sendUpdate(listToArray(StorageManager.signswaiting));
					}
				}
				else if(getBungeeArena().isStatus(SpleefStatus.WARMUP) || getBungeeArena().isStatus(SpleefStatus.INGAME)){
					sendUpdate(listToArray(StorageManager.signsingame));
				}
				else{
					sendUpdate(listToArray(StorageManager.signsrestarting));
				}
			}
			else{
				sendUpdate(listToArray(StorageManager.signswaiting));
			}
		}
		else if(getArena() != null){
			if(getArena().isStatus(SpleefStatus.WAITING) || getArena().isStatus(SpleefStatus.STARTING)){
				if(getArena().enoughPlayers()){
					if(getArena().isFull()){
						sendUpdate(listToArray(StorageManager.signsfull));
					}
					else{
						sendUpdate(listToArray(StorageManager.signsenoughplayers));
					}
				}
				else{
					sendUpdate(listToArray(StorageManager.signswaiting));
				}
			}
			else if(getArena().isStatus(SpleefStatus.WARMUP) || getArena().isStatus(SpleefStatus.INGAME)){
				sendUpdate(listToArray(StorageManager.signsingame));
			}
			else{
				sendUpdate(listToArray(StorageManager.signsrestarting));
			}
		}
		else{}
	}
	
	public String[] listToArray(List<String> list){
		String[] newlist = new String[4];
		newlist[0] = getReplacedLine(list.get(0).replace("&", "§"));
		newlist[1] = getReplacedLine(list.get(1).replace("&", "§"));
		newlist[2] = getReplacedLine(list.get(2).replace("&", "§"));
		newlist[3] = getReplacedLine(list.get(3).replace("&", "§"));
		return newlist;
	}
	
	public void sendUpdate(String[] lines){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getWorld().getName().equals(getLocation().getWorld().getName())){
				if(p.getLocation().distance(getLocation()) <= 16){
					p.sendSignChange(getLocation(), lines);
				}
			}
		}
	}
	
	public boolean isArena(int arenaid){
		if(this.arena.getArenaID() == arenaid){
			return true;
		}
		return false;
	}
	
	public String getReplacedLine(String line){
		if(StorageManager.bungeecord == true){
			if(getBungeeArena() != null){
				line = line.replace("%minutes%", "" + getBungeeArena().getMinutes()).replace("%map-name%", getBungeeArena().getMapName()).replace("%seconds%", "" + getBungeeArena().getSeconds()).replace("%min-players%", "" + getBungeeArena().getMinPlayers()).replace("%players%", "" + getBungeeArena().getPlayers()).replace("%max-players%", "" + getBungeeArena().getMaxPlayers()).replace("%arena-id%", "" + getBungeeArena().getArenaID()).replace("%spectators%", "" + getBungeeArena().getSpectators()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
			}
			else{
				line = line.replace("%minutes%", "" + StorageManager.waittimeminutes).replace("%map-name%", "").replace("%seconds%", "" + StorageManager.waittimeseconds).replace("%min-players%", "" + StorageManager.minplayers).replace("%players%", "" + 0).replace("%max-players%", "" + StorageManager.maxplayers).replace("%arena-id%", "" + getArenaID()).replace("%spectators%", "" + 0).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
			}
		}
		else if(getArena() != null){
			line = line.replace("%minutes%", "" + getArena().getMinutes()).replace("%seconds%", "" + getArena().getSeconds()).replace("%min-players%", "" + getArena().getMinPlayers()).replace("%players%", "" + getArena().getPlayers().size()).replace("%max-players%", "" + getArena().getMaxPlayers()).replace("%arena-id%", "" + getArena().getArenaID()).replace("%spectators%", "" + getArena().getSpectators().size()).replace("%animated-dots%", StorageManager.arenaselector.getAnimatedDotsString());
			if(getArena().getMap() != null){
				line = line.replace("%map-name%", getArena().getMap().getName());
			}
		}
		else{
			return "";
		}
		return line;
	}
	
	public static ArenaSign getArenaSign(Location location){
		for(ArenaSign arenasign : StorageManager.signs){
			if(arenasign.getLocation().getBlockX() == location.getBlockX() && arenasign.getLocation().getBlockY() == location.getBlockY() && arenasign.getLocation().getBlockZ() == location.getBlockZ()){
				return arenasign;
			}
		}
		return null;
	}
	public static boolean isSignArenaSign(Location location){
		for(ArenaSign arenasign : StorageManager.signs){
			if(arenasign.getLocation().getBlockX() == location.getBlockX() && arenasign.getLocation().getBlockY() == location.getBlockY() && arenasign.getLocation().getBlockZ() == location.getBlockZ()){
				return true;
			}
		}
		return false;
	}
}
