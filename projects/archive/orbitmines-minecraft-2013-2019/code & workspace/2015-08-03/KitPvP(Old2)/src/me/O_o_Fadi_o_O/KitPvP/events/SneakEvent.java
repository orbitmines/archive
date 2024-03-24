package me.O_o_Fadi_o_O.KitPvP.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakEvent implements Listener{
	
	@EventHandler
	public void onSneakToggle(PlayerToggleSneakEvent e){
		
		Player p = e.getPlayer();
		
		try{
			if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Fly I")){
				if(e.isSneaking()){
					p.setVelocity(p.getLocation().getDirection().setY(0.5));
					p.setAllowFlight(true);
					p.setFlying(false);
					e.setCancelled(true);
					
				}
			}
		}catch(Exception ex){}
	}
}
