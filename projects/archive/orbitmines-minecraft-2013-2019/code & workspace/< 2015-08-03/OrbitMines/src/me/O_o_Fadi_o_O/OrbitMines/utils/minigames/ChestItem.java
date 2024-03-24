package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChestItem {

	private Material material;
	private int amount;
	private int maxamount;
	private String displayname;
	private int durability;
	private double percentage;
	private HashMap<Enchantment, Integer> enchantments;
	
	public ChestItem(Material material, int amount, int maxamount, String displayname, int durability, double percentage){
		this.material = material;
		this.amount = amount;
		this.maxamount = maxamount;
		this.displayname = displayname;
		this.durability = durability;
		this.percentage = percentage;
		this.enchantments = new HashMap<Enchantment, Integer>();
	}
	
	public ChestItem(Material material, int amount, int maxamount, String displayname, int durability, double percentage, Enchantment enchantment, int level){
		this.material = material;
		this.amount = amount;
		this.maxamount = maxamount;
		this.displayname = displayname;
		this.durability = durability;
		this.percentage = percentage;
		this.enchantments = new HashMap<Enchantment, Integer>();
		addEnchantment(enchantment, level);
	}

	public Material getMaterial() {
		return material;
	}

	public int getMaxAmount() {
		return maxamount;
	}
	public String getDisplayName() {
		return displayname;
	}

	public short getDurability() {
		return (short) durability;
	}

	public double getPercentage() {
		return percentage;
	}
	
	public void addEnchantment(Enchantment enchantment, int level){
		this.enchantments.put(enchantment, level);
	}
	
	public int getAmount(){
		if(amount == maxamount){
			return amount;
		}
		return new Random().nextInt(getMaxAmount()) +1;
	}
	
	public ItemStack getItemStack(){
		ItemStack item = new ItemStack(getMaterial(), getAmount());
		item.setDurability(getDurability());
		if(getDisplayName() != null){
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(getDisplayName());
			item.setItemMeta(meta);
		}
		for(Enchantment ench : enchantments.keySet()){
			item.addUnsafeEnchantment(ench, enchantments.get(ench));
		}
		return item;
	}
}
