package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import org.bukkit.Material;

public class MineBlock {

	private Material material;
	private int durability;
	private double percentage;
	
	public MineBlock(Material material, int durability, double percentage){
		this.material = material;
		this.durability = durability;
		this.percentage = percentage;
	}
	
	public MineBlock(MineBlock mineblock){
		this.material = mineblock.getMaterial();
		this.durability = mineblock.getDurability();
		this.percentage = mineblock.getPercentage();
	}

	public Material getMaterial() {
		return material;
	}

	public byte getDurability() {
		return (byte) durability;
	}

	public double getPercentage() {
		return percentage;
	}
}
