package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.ItemType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitSelectorItemStack;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelectorManager {

	public static void loadKitSelector(){
		String path = "Settings.NPCInventory.BuyKit";
		
		int size = ConfigManager.config.getInt(path + ".Size");
		String name = ConfigManager.config.getString(path + ".Name");
		List<KitSelectorItemStack> itemstacks = new ArrayList<KitSelectorItemStack>();
		
		for(int slot = 1; slot <= size; slot++){
			if(ConfigManager.config.contains(path + ".Inventory." + slot)){
				ItemType type = ItemType.valueOf(ConfigManager.config.getString(path + ".Inventory." + slot + ".ItemType"));
				
				String displayname = ConfigManager.config.getString(path + ".Inventory." + slot + ".Name");
				List<String> lore = ConfigManager.config.getStringList(path + ".Inventory." + slot + ".Lore");
				Material material = Material.valueOf(ConfigManager.config.getString(path + ".Inventory." + slot + ".Type"));
				short durability = (short) ConfigManager.config.getInt(path + ".Inventory." + slot + ".Durability");
				int amount = ConfigManager.config.getInt(path + ".Inventory." + slot + ".Amount");
				
				ItemStack item = new ItemStack(material, amount);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(displayname);
				meta.setLore(lore);
				item.setItemMeta(meta);
				item.setDurability(durability);
				itemstacks.add(new KitSelectorItemStack(item, displayname, lore, type));
			}
			else{
				itemstacks.add(null);
			}
		}
		
		KitSelector kitselector = new KitSelector(size, name, itemstacks);
		StorageManager.kitselector = kitselector;
	}
}
