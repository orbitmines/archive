package me.O_o_Fadi_o_O.SpigotSpleef.events;

import me.O_o_Fadi_o_O.SpigotSpleef.managers.AbilityManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Ability;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		ItemStack i = e.getItemInHand();
		
		if(StorageManager.spleefplayer.containsKey(p)){
			SpleefPlayer sp = StorageManager.spleefplayer.get(p);
			
			if(sp.isInArena() && sp.isPlayer()){
				e.setCancelled(true);

				if(sp.getArena().isStatus(SpleefStatus.INGAME) && i.getType() != null && i.getType() != Material.AIR){
					Kit kit = sp.getKit();
					int index = p.getInventory().first(i);
					
					KitItemStack item = kit.getItems().get(index);
					if(item.containsAbility(Ability.INSTANT_TNT) && i.getType() == Material.TNT){
						sp.removeItem(i, index);
						new AbilityManager().checkInstantTNT(sp, e.getBlockPlaced(), item);
					}
					if(item.containsAbility(Ability.PLACE_ABLE)){
						sp.removeItem(i, index);
						new AbilityManager().checkPlaceAble(sp, e.getBlockPlaced(), i.getType(), (byte) i.getDurability());
					}
				}
			}
		}
	}
}
