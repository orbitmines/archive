package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyItemStack {

	private ItemStack itemstack;
	private String displayname;
	private ItemType itemtype;
	
	public LobbyItemStack(ItemStack itemstack, String displayname, ItemType itemtype){
		this.itemstack = itemstack;
		this.displayname = displayname;
		this.itemtype = itemtype;
	}

	public ItemStack getItemStack(){
		return this.itemstack;
	}
	public void setItemStack(ItemStack itemstack){
		this.itemstack = itemstack;
	}

	public String getDisplayname(){
		return this.displayname;
	}
	public void setDisplayname(String displayname){
		this.displayname = displayname;
	}

	public ItemType getItemType(){
		return this.itemtype;
	}
	public void setItemType(ItemType itemtype){
		this.itemtype = itemtype;
	}
	
	public void update(){
		if(getItemStack() != null && getDisplayname() != null){
			ItemMeta meta = getItemStack().getItemMeta();
			meta.setDisplayName(getDisplayname().replace("&", "§"));
			getItemStack().setItemMeta(meta);
		}
	}
}
