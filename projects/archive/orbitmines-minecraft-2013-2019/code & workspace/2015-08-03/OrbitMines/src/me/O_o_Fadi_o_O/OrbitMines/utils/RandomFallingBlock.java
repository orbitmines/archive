package me.O_o_Fadi_o_O.OrbitMines.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

public class RandomFallingBlock {
		
	private Location location;
	private Material material;
	private byte durability;
	private boolean drop;
	private double multiply;
	
	public RandomFallingBlock(Location location){
		this.location = location;
		this.multiply = 1;
	}

	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}

	public Material getMaterial(){
		return material;
	}
	public void setMaterial(Material material){
		this.material = material;
	}

	public byte getDurability(){
		return durability;
	}
	public void setDurability(byte durability){
		this.durability = durability;
	}

	public boolean hasDrop(){
		return drop;
	}
	public void setDrop(boolean drop){
		this.drop = drop;
	}
	
	public double getMultiply(){
		return multiply;
	}
	public void setMultiply(double multiply){
		this.multiply = multiply;
	}
	
	@SuppressWarnings("deprecation")
	public void spawn(){
		Vector v = Utils.getRandomVelocity();	
		if(v != null){
	        FallingBlock fb = getLocation().getWorld().spawnFallingBlock(getLocation(), getMaterial(), getDurability());
            fb.setDropItem(hasDrop());
            fb.setVelocity(v.multiply(getMultiply()));
		}
	}
}
