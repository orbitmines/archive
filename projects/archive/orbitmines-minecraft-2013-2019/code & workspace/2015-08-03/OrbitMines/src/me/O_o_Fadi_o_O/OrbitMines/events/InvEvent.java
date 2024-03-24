package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

public class InvEvent implements Listener {

	@EventHandler
    public void onInventoryOpen(InventoryOpenEvent e){
		if(e.getPlayer() instanceof Player){
			Player p = (Player) e.getPlayer();
			OMPlayer omp = OMPlayer.getOMPlayer(p);
			Arena arena = omp.getArena();
			
	        if(arena != null && (arena.getType() == MiniGameType.SURVIVAL_GAMES || arena.getType() == MiniGameType.SKYWARS) && e.getInventory() instanceof EnchantingInventory){
	            EnchantingInventory inv = (EnchantingInventory) e.getInventory();
	            ItemStack item = new ItemStack(Material.INK_SACK, 3);
	            item.setDurability((short) 4);
	            inv.setItem(1, item);
	        }
		}
    }
	
	@EventHandler
    public void onInventoryOpen(InventoryCloseEvent e){
		if(e.getPlayer() instanceof Player){
			Player p = (Player) e.getPlayer();
			OMPlayer omp = OMPlayer.getOMPlayer(p);
			Arena arena = omp.getArena();
			
	        if(arena != null && (arena.getType() == MiniGameType.SURVIVAL_GAMES || arena.getType() == MiniGameType.SKYWARS) && e.getInventory() instanceof EnchantingInventory){
	            EnchantingInventory inv = (EnchantingInventory) e.getInventory();
	            ItemStack item = new ItemStack(Material.INK_SACK, 3);
	            item.setDurability((short) 4);
	            inv.setItem(1, null);
	        }
		}
    }
}
