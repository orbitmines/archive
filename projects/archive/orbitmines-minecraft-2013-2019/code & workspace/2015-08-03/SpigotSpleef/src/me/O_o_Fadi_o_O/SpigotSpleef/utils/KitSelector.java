package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.CustomItem;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class KitSelector {

	private int size;
	private String name;
	private List<KitSelectorItemStack> itemstacks;
	private HashMap<SpleefPlayer, Kit> lasttriedpurchase = new HashMap<SpleefPlayer, Kit>();
	
	public KitSelector(int size, String name, List<KitSelectorItemStack> itemstacks){
		this.size = size;
		this.name = name;
		this.itemstacks = itemstacks;
	}

	public int getSize(){
		return this.size;
	}
	public void setSize(int size){
		this.size = size;
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public List<KitSelectorItemStack> getItemStacks(){
		return this.itemstacks;
	}
	public void setItemStacks(List<KitSelectorItemStack> itemstacks){
		this.itemstacks = itemstacks;
	}
	
	public HashMap<SpleefPlayer, Kit> getLastTriedPurchase(){
		return lasttriedpurchase;
	}
	public void setLastTriedPurchase(SpleefPlayer sp, Kit kit){
		this.lasttriedpurchase.put(sp, kit);
	}
	public Kit getLastTriedPurchase(SpleefPlayer sp){
		return this.lasttriedpurchase.get(sp);
	}

	public void openInventory(Player p, Kit kit){
		SpleefPlayer sp = StorageManager.spleefplayer.get(p);
		setLastTriedPurchase(sp, kit);
		
		Inventory inv = Bukkit.createInventory(null, getSize(), getReplacedString(sp, kit, getName().replace("&", "§")));
		
		int index = 0;
		for(KitSelectorItemStack item : getItemStacks()){
			if(item != null){
				item.update(sp, kit);
				inv.setItem(index, CustomItem.hideFlags(item.getItemStack(), 2));
			}
			else{
				inv.setItem(index, null);
			}
			index++;
		}
		
		p.openInventory(inv);
	}
	
	public String getReplacedString(SpleefPlayer sp, Kit kit, String s){
		return s.replace("%kit-name%", kit.getName()).replace("%tokens%", "" + sp.getTokens()).replace("%price%", "" + kit.getPrice());
	}
}
