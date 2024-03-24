package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.ItemType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpectatorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpectatorManager {

	public static void loadSpectatorInventory(){
		List<SpectatorItemStack> items = new ArrayList<SpectatorItemStack>();
		for(int i = 1; i <= 40; i++){
			if(ConfigManager.config.contains("Settings.SpectatorInventory." + i)){
				String name = ConfigManager.config.getString("Settings.SpectatorInventory." + i + ".Name");
				ItemType itemtype = ItemType.valueOf(ConfigManager.config.getString("Settings.SpectatorInventory." + i + ".ItemType"));
				Material material = Material.valueOf(ConfigManager.config.getString("Settings.SpectatorInventory." + i + ".Type"));
				short durability = (short) ConfigManager.config.getInt("Settings.SpectatorInventory." + i + ".Durability");
				int amount = ConfigManager.config.getInt("Settings.SpectatorInventory." + i + ".Amount");
				
				ItemStack item = new ItemStack(material, amount);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(name);
				item.setItemMeta(meta);
				item.setDurability(durability);
				items.add(new SpectatorItemStack(item, name, itemtype));
			}
			else{
				items.add(new SpectatorItemStack(new ItemStack(Material.AIR), null, null));
			}
		}
		
		StorageManager.spectatorinv = items;
	}
	
	public static void give(SpleefPlayer sp){
		Player p = sp.getPlayer();
		
		int index = 0;
		for(SpectatorItemStack item : StorageManager.spectatorinv){
			item.update();
			ItemStack i = item.getItemStack();
			p.getInventory().setItem(index, i);
			index++;
		}
		p.updateInventory();
	}
}
