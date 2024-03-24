package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import me.O_o_Fadi_o_O.OrbitMinesPvP.Start;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.Teleporter;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.TradeMaterials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener{
	Start plugin;
	 
	public InventoryClick(Start instance) {
	plugin = instance;
	}
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		
		Action a = e.getAction();
		Player p = e.getPlayer();
			
		ItemStack h = p.getItemInHand();
				
		// GOLD
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.GOLD_INGOT && h.getItemMeta().getDisplayName().equalsIgnoreCase("§6Gold§7§o (Right Click)")){
						
					int currentgold = plugin.getConfig().getInt("players." + p.getName() + ".Gold");
					p.sendMessage("§8[§6§lGold§8] §7Current Gold: §6" + currentgold);
				}
			}
			catch(NullPointerException exception){
						
			}
		}
	    // COINS
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.GOLD_NUGGET && h.getItemMeta().getDisplayName().equalsIgnoreCase("§eCoins§7§o (Right Click)")){
					
					int currentcoins = plugin.getConfig().getInt("players." + p.getName() + ".Coins");
					p.sendMessage("§8[§e§lCoins§8] §7Current Coins: §e" + currentcoins);
				}
			}
			catch(NullPointerException exception){
						
			}
		}
		// PAPER
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.PAPER && h.getItemMeta().getDisplayName().equalsIgnoreCase("§fVIP Perks§7§o (Right Click)")){
					
					p.sendMessage("- TODO ADD INVENTORY");
				}
			}
			catch(NullPointerException exception){
						
			}
		}
		// ENDERPEARL
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.ENDER_PEARL && h.getItemMeta().getDisplayName().equalsIgnoreCase("§3Teleporter§7§o (Right Click)")){
					
					p.sendMessage("§8[§3§lTeleporter§8] §7Opening the World Teleporter...");
					p.openInventory(Teleporter.getTeleportInventory(p));
					
					}
				}	
				catch(NullPointerException exception){
					
			}
		}
		// BOOSTERS
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.GOLDEN_APPLE && h.getItemMeta().getDisplayName().equalsIgnoreCase("§aBoosters§7§o (Right Click)")){
					
					//TODO ADD BOOSTER INVENTORY
					p.sendMessage("- TODO ADD INVENTORY");
					
					}
				}	
				catch(NullPointerException exception){
					
			}
		}
		// MATERIALS
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.REDSTONE && h.getItemMeta().getDisplayName().equalsIgnoreCase("§cMaterials§7§o (Right Click)")){
					
					//TODO ADD MATERIALS INVENTORY
					p.sendMessage("§8[§c§lMaterials§8] §7Opening the Materials Craft System...");
					p.openInventory(TradeMaterials.getMaterialsInventory());
					
					}
				}	
				catch(NullPointerException exception){
					
			}
		}
		// SHOP
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			try{
				if(h != null && h.getType() == Material.NETHER_STAR && h.getItemMeta().getDisplayName().equalsIgnoreCase("§dQuick Shop§7§o (Right Click)")){
					
					//TODO ADD SHOP INVENTORY
					p.sendMessage("- TODO ADD INVENTORY");
					}
				}	
				catch(NullPointerException exception){
				
			}
		}
	}
}
