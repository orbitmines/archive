package me.O_o_Fadi_o_O.Hub.Inv;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.runnables.ServerSelectorRunnable;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerSelector {
	
	public static Inventory serverSelector = Bukkit.createInventory(null, 27, "§0§lServer Selector");
	
	Hub plugin;
	 
	public ServerSelector(Hub instance) {
		plugin = instance;
	}
	
	public void setAllServerSelectorItems(){
		    
		setServerSelectorItem("kitpvp", "§c§lKitPvP §8>> §7§l1.7", Material.IRON_SWORD, 10, "c");
		setServerSelectorItem("prison", "§4§lPrison §8>> §7§l1.7", Material.DIAMOND_PICKAXE, 11, "4");
		setServerSelectorItem("creative", "§d§lCreative §8>> §7§l1.7", Material.WOOD_AXE, 12, "d");
		setServerSelectorItem("hub", "§3§lHub §8>> §7§l1.7", Material.WATCH, 13, "3");
		setServerSelectorItem("survival", "§a§lSurvival §8>> §7§l1.7", Material.STONE_HOE, 14, "a");
		setServerSelectorItem("skyblock", "§5§lSkyBlock §8>> §7§l1.7", Material.FISHING_ROD, 15, "5");
		setServerSelectorItem("minigames", "§f§lMiniGames §8>> §7§l1.7", Material.BOW, 16, "f");
    
	}
  
	public void setServerSelectorItem(String server, String displayName, Material m, int slot, String color){
    
		ItemStack item = new ItemStack(m, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		List<String> lore = new ArrayList<String>();
		lore.add("");
		if(isServerOnline(server)){
			lore.add(" §7Status: §a§lOnline ");
 
			if(!Hub.Server.equals(server)){
				lore.add(" §7Players: §a§l" + StorageManager.ServerOnlinePlayers.get(server) + "§7/§a§l100 ");
			}
			else{
				lore.add(" §7Players: §a§l" + StorageManager.ServerOnlinePlayers.get(server) + "§7/§a§l1000 ");
			}
		}
		else{
			lore.add(" §7Status: §c§lOffline ");
		}
		lore.add("");
		if(isServerOnline(server)){
			if(!Hub.Server.equals(server)){
				if(ServerSelectorRunnable.i == 1){
					lore.add(" §" + color +"§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 2){
					lore.add(" §7§oC"
							+ "§" + color +"§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 3){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§" + color +"§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 4){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§" + color +"§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 5){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§" + color +"§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 6){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§" + color +"§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 7){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§" + color +"§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 8){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§" + color +"§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 9){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§" + color +"§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 10){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§" + color +"§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 11){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§" + color +"§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 12){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§" + color +"§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 13){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§" + color +"§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 14){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§" + color +"§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 15){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§" + color +"§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 16){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§" + color +"§oe"
							+ "§7§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 17){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§" + color +"§oc"
							+ "§7§ot"
							+ "§r ");
				}
				else if(ServerSelectorRunnable.i == 18){
					lore.add(" §7§oC"
							+ "§7§ol"
							+ "§7§oi"
							+ "§7§oc"
							+ "§7§ok"
							+ " "
							+ "§7§oH"
							+ "§7§oe"
							+ "§7§or"
							+ "§7§oe"
							+ " "
							+ "§7§ot"
							+ "§7§oo"
							+ " "
							+ "§7§oC"
							+ "§7§oo"
							+ "§7§on"
							+ "§7§on"
							+ "§7§oe"
							+ "§7§oc"
							+ "§" + color +"§ot"
							+ "§r ");
				}
			}
			else{
				lore.add(" §7§oCurrently Connected ");
			}
			lore.add("");
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
      
		if(server.equals(Hub.Server)){
			item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
		}
		
		serverSelector.setItem(slot, item);
    
	}
  
	public boolean isServerOnline(String server){
    
		if(StorageManager.ServerOnlinePlayers.containsKey(server)){
  			return true;
  		}
  		else{
  			return false;
    	}
	}
}
