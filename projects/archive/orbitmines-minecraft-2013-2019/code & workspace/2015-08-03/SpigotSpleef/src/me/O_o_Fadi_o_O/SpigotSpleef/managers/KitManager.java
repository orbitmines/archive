package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.Ability;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitItemStack;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitManager {

	public static void loadKits(){
		for(String kitid : ConfigManager.config.getConfigurationSection("Kits").getKeys(false)){
			String kitname = ConfigManager.config.getString("Kits." + kitid + ".KitName");
			int price = ConfigManager.config.getInt("Kits." + kitid + ".Price");
			
			List<KitItemStack> items = new ArrayList<KitItemStack>();
			for(int i = 1; i <= 40; i++){
				if(ConfigManager.config.contains("Kits." + kitid + ".Inventory." + i)){
					String name = ConfigManager.config.getString("Kits." + kitid + ".Inventory." + i + ".Name");
					Material material = Material.valueOf(ConfigManager.config.getString("Kits." + kitid + ".Inventory." + i + ".Type"));
					short durability = (short) ConfigManager.config.getInt("Kits." + kitid + ".Inventory." + i + ".Durability");
					int amount = ConfigManager.config.getInt("Kits." + kitid + ".Inventory." + i + ".Amount");
					List<Ability> abilities = stringArrayToAbilityList(ConfigManager.config.getString("Kits." + kitid + ".Inventory." + i + ".Ability").split("\\|"));
					
					ItemStack item = new ItemStack(material, amount);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(name);
					item.setItemMeta(meta);
					item.setDurability(durability);
					items.add(new KitItemStack(item, abilities));
				}
				else{
					items.add(new KitItemStack(new ItemStack(Material.AIR), null));
				}
			}
			
			Kit kit = new Kit(Integer.parseInt(kitid), kitname, price, items);
			StorageManager.kits.add(kit);
		}
	}
	
	public static List<Ability> stringArrayToAbilityList(String[] list){
		List<Ability> abilities = new ArrayList<Ability>();
		for(String ability : list){
			abilities.add(Ability.valueOf(ability));
		}
		return abilities;
	}
}
