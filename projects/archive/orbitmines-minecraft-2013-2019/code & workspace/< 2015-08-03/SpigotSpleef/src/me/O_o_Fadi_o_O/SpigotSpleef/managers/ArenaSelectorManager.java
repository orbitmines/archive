package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelectorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ItemType;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArenaSelectorManager {

	public static void loadArenaSelector(){
		String path = "Settings.NPCInventory.ArenaSelector";
		
		int size = ConfigManager.config.getInt(path + ".Size");
		String name = ConfigManager.config.getString(path + ".Name");
		Inventory inv = Bukkit.createInventory(null, size, name.replace("&", "§"));
		List<ArenaSelectorItemStack> itemstacks = new ArrayList<ArenaSelectorItemStack>();
		
		for(int slot = 1; slot <= size; slot++){
			if(ConfigManager.config.contains(path + ".Inventory." + slot)){
				ItemType type = ItemType.valueOf(ConfigManager.config.getString(path + ".Inventory." + slot + ".ItemType"));
				
				if(type == ItemType.NORMAL){
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
					itemstacks.add(new ArenaSelectorItemStack(item, displayname, lore, ItemType.NORMAL));
				}
				else if(type == ItemType.ARENA){
					int arenaid = ConfigManager.config.getInt(path + ".Inventory." + slot + ".ArenaID");
					
					itemstacks.add(new ArenaSelectorItemStack(ItemType.ARENA, arenaid, Arena.getArenaFromID(arenaid)));
				}
				else{
					itemstacks.add(null);
				}
			}
			else{
				itemstacks.add(null);
			}
		}
		
		StorageManager.npcinvwaitingname = ConfigManager.config.getString(path + ".ItemTypes.Waiting.Name");
		StorageManager.npcinvwaitinglore = ConfigManager.config.getStringList(path + ".ItemTypes.Waiting.Lore");
		StorageManager.npcinvwaitingmaterial = Material.valueOf(ConfigManager.config.getString(path + ".ItemTypes.Waiting.Type"));
		StorageManager.npcinvwaitingdurability = ConfigManager.config.getInt(path + ".ItemTypes.Waiting.Durability");
		StorageManager.npcinvwaitingamount = ConfigManager.config.getString(path + ".ItemTypes.Waiting.Amount");
		
		StorageManager.npcinvenoughplayersname = ConfigManager.config.getString(path + ".ItemTypes.EnoughPlayers.Name");
		StorageManager.npcinvenoughplayerslore = ConfigManager.config.getStringList(path + ".ItemTypes.EnoughPlayers.Lore");
		StorageManager.npcinvenoughplayersmaterial = Material.valueOf(ConfigManager.config.getString(path + ".ItemTypes.EnoughPlayers.Type"));
		StorageManager.npcinvenoughplayersdurability = ConfigManager.config.getInt(path + ".ItemTypes.EnoughPlayers.Durability");
		StorageManager.npcinvenoughplayersamount = ConfigManager.config.getString(path + ".ItemTypes.EnoughPlayers.Amount");
		
		StorageManager.npcinvfullname = ConfigManager.config.getString(path + ".ItemTypes.Full.Name");
		StorageManager.npcinvfulllore = ConfigManager.config.getStringList(path + ".ItemTypes.Full.Lore");
		StorageManager.npcinvfullmaterial = Material.valueOf(ConfigManager.config.getString(path + ".ItemTypes.Full.Type"));
		StorageManager.npcinvfulldurability = ConfigManager.config.getInt(path + ".ItemTypes.Full.Durability");
		StorageManager.npcinvfullamount = ConfigManager.config.getString(path + ".ItemTypes.Full.Amount");
		
		StorageManager.npcinvingamename = ConfigManager.config.getString(path + ".ItemTypes.InGame.Name");
		StorageManager.npcinvingamelore = ConfigManager.config.getStringList(path + ".ItemTypes.InGame.Lore");
		StorageManager.npcinvingamematerial = Material.valueOf(ConfigManager.config.getString(path + ".ItemTypes.InGame.Type"));
		StorageManager.npcinvingamedurability = ConfigManager.config.getInt(path + ".ItemTypes.InGame.Durability");
		StorageManager.npcinvingameamount = ConfigManager.config.getString(path + ".ItemTypes.InGame.Amount");
		
		StorageManager.npcinvrestartingname = ConfigManager.config.getString(path + ".ItemTypes.Restarting.Name");
		StorageManager.npcinvrestartinglore = ConfigManager.config.getStringList(path + ".ItemTypes.Restarting.Lore");
		StorageManager.npcinvrestartingmaterial = Material.valueOf(ConfigManager.config.getString(path + ".ItemTypes.Restarting.Type"));
		StorageManager.npcinvrestartingdurability = ConfigManager.config.getInt(path + ".ItemTypes.Restarting.Durability");
		StorageManager.npcinvrestartingamount = ConfigManager.config.getString(path + ".ItemTypes.Restarting.Amount");
		
		ArenaSelector arenaselector = new ArenaSelector(inv, size, name, itemstacks);
		StorageManager.arenaselector = arenaselector;
	}
}
