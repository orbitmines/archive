package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageEvent implements Listener{
	
	
	ServerSelector sinv = new ServerSelector();
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e){
		
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			
			ItemStack i = ((Player) e.getDamager()).getItemInHand();
			
			if(i != null){
				if(i.getType() == Material.LEASH && i.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
					
					if(StorageManager.EnableStacker.get(pE.getName()) == true){
						if(StorageManager.EnableStacker.get(pD.getName()) == true){
							pD.setPassenger(pE);
							
							pD.sendMessage("§fYou've §6§lstacked§f " + PlayerManager.playerDisplayName(pE) + "§f on your Head!");
							pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
							pE.sendMessage("§f" + PlayerManager.playerDisplayName(pD) + " §6§lstacked§f you on their Head!");
							e.setCancelled(true);
						}
						else{
							pD.sendMessage("§fYou §c§lDISABLED§6§l stacking§f! Enable it in your §c§nSettings§f!");
						}
					}
					else{
						pD.sendMessage("§fThis player has §c§lDISABLED §6§lstacking§f!");
					}
				}
			}
		}
	}
}
