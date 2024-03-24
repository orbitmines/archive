package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class KitItemStack {

	private ItemStack itemstack;
	private List<Ability> abilities;
	
	public KitItemStack(ItemStack itemstack, List<Ability> abilities){
		this.itemstack = itemstack;
		this.abilities = abilities;
	}

	public ItemStack getItemStack(){
		return this.itemstack;
	}

	public void setItemStack(ItemStack itemstack){
		this.itemstack = itemstack;
	}

	public List<Ability> getAbilities(){
		return this.abilities;
	}

	public void setAbilities(List<Ability> abilities){
		this.abilities = abilities;
	}
	
	public boolean containsAbility(Ability ability){
		if(getAbilities() != null){
			return getAbilities().contains(ability);
		}
		return false;
	}
}
