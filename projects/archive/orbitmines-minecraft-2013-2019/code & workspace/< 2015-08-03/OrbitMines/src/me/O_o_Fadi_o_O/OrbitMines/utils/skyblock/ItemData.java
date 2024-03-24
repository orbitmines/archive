package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import org.bukkit.Material;

public class ItemData {

	private String displayname;
	private int amount;
	private Material material;
	private short durability;
	
	public ItemData(String displayname, int amount, Material material, int durability){
		this.displayname = displayname;
		this.amount = amount;
		this.material = material;
		this.durability = (short) durability;
	}

	public String getDisplayName() {
		return displayname;
	}
	public void setDisplayName(String displayname) {
		this.displayname = displayname;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}

	public short getDurability() {
		return durability;
	}
	public void setDurability(short durability) {
		this.durability = durability;
	}
}
