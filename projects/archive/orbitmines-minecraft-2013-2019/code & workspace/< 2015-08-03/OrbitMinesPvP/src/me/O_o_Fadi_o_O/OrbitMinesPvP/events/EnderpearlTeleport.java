package me.O_o_Fadi_o_O.OrbitMinesPvP.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderpearlTeleport implements Listener{
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if(e.getCause().equals(TeleportCause.ENDER_PEARL)) { 
				e.setCancelled(true);
				
				Player p = e.getPlayer();
				
				ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta enderpearlmeta = enderpearl.getItemMeta();
				enderpearlmeta.setDisplayName("§3Teleporter§7§o (Right Click)");
				enderpearl.setItemMeta(enderpearlmeta);
				p.getInventory().setItem(5, new ItemStack((enderpearl)));
				
		}
	}

}
