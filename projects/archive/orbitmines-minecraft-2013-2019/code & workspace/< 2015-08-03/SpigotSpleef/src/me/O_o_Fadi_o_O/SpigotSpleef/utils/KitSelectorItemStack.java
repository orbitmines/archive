package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelectorItemStack {

	private ItemStack itemstack;
	private String displayname;
	private List<String> lore;
	private ItemType itemtype;
	
	public KitSelectorItemStack(ItemStack itemstack, String displayname, List<String> lore, ItemType itemtype){
		this.itemstack = itemstack;
		this.displayname = displayname;
		this.lore = lore;
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

	public List<String> getLore(){
		return this.lore;
	}
	public void setLore(List<String> lore){
		this.lore = lore;
	}

	public ItemType getItemType(){
		return this.itemtype;
	}
	public void setItemType(ItemType itemtype){
		this.itemtype = itemtype;
	}
	
	public void update(SpleefPlayer sp, Kit kit){
		ItemMeta meta = getItemStack().getItemMeta();
		meta.setDisplayName(getReplacedString(sp, kit, getDisplayname().replace("&", "§")));
		List<String> lore = new ArrayList<String>();
		for(String s : getLore()){
			lore.add(getReplacedString(sp, kit, s.replace("&", "§")));
		}
		meta.setLore(lore);
		getItemStack().setItemMeta(meta);
	}
	
	public String getReplacedString(SpleefPlayer sp, Kit kit, String s){
		return s.replace("%kit-name%", kit.getName()).replace("%price%", "" + kit.getPrice()).replace("%tokens%", "" + sp.getTokens());
	}
}
