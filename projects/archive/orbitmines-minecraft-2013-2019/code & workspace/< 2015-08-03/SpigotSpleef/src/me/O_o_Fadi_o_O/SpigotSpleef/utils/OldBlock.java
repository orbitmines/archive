package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import org.bukkit.Location;
import org.bukkit.Material;

public class OldBlock {

	private Arena arena;
	private Location location;
	private Material material;
	private byte durability;
	
	public OldBlock(Arena arena, Location location, Material material, byte durability){
		this.arena = arena;
		this.location = location;
		this.material = material;
		this.durability = durability;
	}

	public Arena getArena(){
		return this.arena;
	}
	public void setArena(Arena arena){
		this.arena = arena;
	}

	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}

	public Material getMaterial(){
		return this.material;
	}
	public void setMaterial(Material material){
		this.material = material;
	}

	public byte getDurability(){
		return this.durability;
	}
	public void setDurability(byte durability){
		this.durability = durability;
	}
}
