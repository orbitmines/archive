package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.ItemType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.LobbyItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyManager {

	public static void loadLobbyInventory(){
		List<LobbyItemStack> items = new ArrayList<LobbyItemStack>();
		for(int i = 1; i <= 40; i++){
			if(ConfigManager.config.contains("Settings.LobbyInventory." + i)){
				String name = ConfigManager.config.getString("Settings.LobbyInventory." + i + ".Name");
				ItemType itemtype = ItemType.valueOf(ConfigManager.config.getString("Settings.LobbyInventory." + i + ".ItemType"));
				Material material = Material.valueOf(ConfigManager.config.getString("Settings.LobbyInventory." + i + ".Type"));
				short durability = (short) ConfigManager.config.getInt("Settings.LobbyInventory." + i + ".Durability");
				int amount = ConfigManager.config.getInt("Settings.LobbyInventory." + i + ".Amount");
				
				ItemStack item = new ItemStack(material, amount);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(name);
				item.setItemMeta(meta);
				item.setDurability(durability);
				items.add(new LobbyItemStack(item, name, itemtype));
			}
			else{
				items.add(new LobbyItemStack(new ItemStack(Material.AIR), null, null));
			}
		}
		
		StorageManager.lobbyinv = items;
	}
	
	public static void give(SpleefPlayer sp){
		Player p = sp.getPlayer();
		
		int index = 0;
		for(LobbyItemStack item : StorageManager.lobbyinv){
			item.update();
			ItemStack i = item.getItemStack();
			p.getInventory().setItem(index, i);
			index++;
		}
		p.updateInventory();
	}
}
