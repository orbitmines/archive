package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.AbilityManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Ability;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class MoveEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena() && sp.isPlayer()){
				if(sp.getArena().isStatus(SpleefStatus.INGAME)){
					if(p.getLocation().getY() <= StorageManager.diewhenyis){
						sp.die();
					}
					
					Kit kit = sp.getKit();
					ItemStack boots = p.getInventory().getBoots();
					if(boots != null && boots.getType() != null && boots.getType() != Material.AIR){
						KitItemStack item = kit.getItems().get(36);
						
						if(item.containsAbility(Ability.RUNNER) && p.isOnGround()){
							Block b = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() -1, p.getLocation().getBlockZ());
							new AbilityManager().checkRunner(sp, b, item);
						}
					}
				}
			}
		}
	}
}
