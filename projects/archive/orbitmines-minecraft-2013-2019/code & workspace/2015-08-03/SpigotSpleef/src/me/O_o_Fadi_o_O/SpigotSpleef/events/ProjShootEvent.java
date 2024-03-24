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
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ProjShootEvent implements Listener {
	
	@EventHandler
	public void onShot(ProjectileLaunchEvent e){
		Projectile proj = e.getEntity();
		
		if(proj.getShooter() instanceof Player){
			Player p = (Player) proj.getShooter();
			if(StorageManager.spleefplayer.containsKey(p)){
				SpleefPlayer sp = StorageManager.spleefplayer.get(p);
				ItemStack i = p.getItemInHand();
				
				if(sp.isInArena() && sp.isPlayer()){
					if(sp.getArena().isStatus(SpleefStatus.INGAME) && i.getType() != null){
						Kit kit = sp.getKit();
						int index = p.getInventory().first(i);
						KitItemStack item = kit.getItems().get(index);
						
						if(item != null && item.getItemStack() != null){
							if(i.getType() == Material.BOW){
								if(item.containsAbility(Ability.RANGE_SMALL)){
									new AbilityManager().checkRangeSmall(sp, proj, item);
								}
								else if(item.containsAbility(Ability.RANGE_MEDIUM)){
									new AbilityManager().checkRangeMedium(sp, proj, item);
								}
								else if(item.containsAbility(Ability.RANGE_BIG)){
									new AbilityManager().checkRangeBig(sp, proj, item);
								}
								else if(item.containsAbility(Ability.TELEPORT_ARROWS)){
									new AbilityManager().checkTeleportArrows(sp, proj, item);
								}
								else{}
							}
						}
					}
				}
			}
		}
	}
}
