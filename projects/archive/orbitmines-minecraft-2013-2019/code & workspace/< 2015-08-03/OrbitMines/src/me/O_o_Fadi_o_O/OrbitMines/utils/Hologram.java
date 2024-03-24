package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Hologram {

	private int hologramid;
	private Location location;
	private List<ArmorStand> armorstands;
	private HashMap<String, ArmorStand> displaynames;
	
	public Hologram(Location location){
		this.location = location;
		this.hologramid = ServerStorage.holograms.size() +1;
		this.armorstands = new ArrayList<ArmorStand>();
		this.displaynames = new HashMap<String, ArmorStand>();
	}

	public int getHologramID(){
		return hologramid;
	}
	public void setHologramID(int hologramid){
		this.hologramid = hologramid;
	}

	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}

	public List<ArmorStand> getArmorstands(){
		return armorstands;
	}
	public void setArmorstands(List<ArmorStand> armorstands){
		this.armorstands = armorstands;
	}
	public void addArmorStand(ArmorStand armorstand){
		this.armorstands.add(armorstand);
	}

	public HashMap<String, ArmorStand> getDisplaynames(){
		return displaynames;
	}
	public void setDisplaynames(HashMap<String, ArmorStand> displaynames){
		this.displaynames = displaynames;
	}
	public void setDisplayname(String displayname, ArmorStand armorstand){
		this.displaynames.put(displayname, armorstand);
	}
	
	public void addLine(String line){
		setDisplayname(line, null);
	}
	
	public void create(){
		if(getArmorstands().size() > 0){
			delete();
			this.armorstands.clear();
		}
		
		int index = 0;
		Location l = getLocation();
		if(l != null){
			for(String displayname : getDisplaynames().keySet()){
				
				ArmorStand armorstand = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() -(index * 0.25), l.getZ()), EntityType.ARMOR_STAND);
				armorstand.setCustomName(displayname);
				armorstand.setCustomNameVisible(true);
				armorstand.setGravity(false);
				
				((CraftArmorStand) armorstand).getHandle().setInvisible(true);
				
				setDisplayname(displayname, armorstand);
				addArmorStand(armorstand);
				
				index++;
			}
		}
	}
	
	public void create(Player... players){
		if(getArmorstands().size() > 0){
			delete();
			this.armorstands.clear();
		}
		
		int index = 0;
		Location l = getLocation();
		if(l != null){
			for(String displayname : getDisplaynames().keySet()){
				
				ArmorStand armorstand = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() -(index * 0.25), l.getZ()), EntityType.ARMOR_STAND);
				armorstand.setCustomName(displayname);
				armorstand.setCustomNameVisible(true);
				armorstand.setGravity(false);
				
				((CraftArmorStand) armorstand).getHandle().setInvisible(true);
				
		        for(Player player : Bukkit.getOnlinePlayers()){
		        	if(!Arrays.asList(players).contains(player)){
		        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftArmorStand) armorstand).getHandle().getId()));
		        	}
		        }
				
				setDisplayname(displayname, armorstand);
				addArmorStand(armorstand);
				
				index++;
			}
		}
	}
	
	public void createHideFor(Player... players){
		if(getArmorstands().size() > 0){
			delete();
			this.armorstands.clear();
		}
		
		int index = 0;
		Location l = getLocation();
		if(l != null){
			for(String displayname : getDisplaynames().keySet()){
				
				ArmorStand armorstand = (ArmorStand) l.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() -(index * 0.25), l.getZ()), EntityType.ARMOR_STAND);
				armorstand.setCustomName(displayname);
				armorstand.setCustomNameVisible(true);
				armorstand.setGravity(false);
				
				((CraftArmorStand) armorstand).getHandle().setInvisible(true);
				
		        for(Player player : Bukkit.getOnlinePlayers()){
		        	if(Arrays.asList(players).contains(player)){
		        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftArmorStand) armorstand).getHandle().getId()));
		        	}
		        }
				
				setDisplayname(displayname, armorstand);
				addArmorStand(armorstand);
				
				index++;
			}
		}
	}
	
	public void delete(){
		for(ArmorStand as : getArmorstands()){
			as.remove();
		}
	}
	
	public static List<Hologram> getHolograms(){
		return ServerStorage.holograms;
	}
	
	public static Hologram getHologram(int hologramid){
		for(Hologram hologram : ServerStorage.holograms){
			if(hologram.getHologramID() == hologramid){
				return hologram;
			}
		}
		return null;
	}
	public static Hologram getHologram(ArmorStand as){
		for(Hologram hologram : ServerStorage.holograms){
			if(hologram.getArmorstands().contains(as)){
				return hologram;
			}
		}
		return null;
	}
	
	public static Hologram addHologram(Location location){
		Hologram hologram = new Hologram(location);
		ServerStorage.holograms.add(hologram);
		return hologram;
	}
}
