package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.utils.State;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		
		if(e.getEntity() instanceof Creeper || e.getEntity() instanceof Bat || e.getEntity() instanceof MushroomCow || e.getEntity() instanceof Pig || e.getEntity() instanceof Wolf || e.getEntity() instanceof Sheep || e.getEntity() instanceof Horse || e.getEntity() instanceof MagmaCube || e.getEntity() instanceof Slime || e.getEntity() instanceof Cow || e.getEntity() instanceof Silverfish || e.getEntity() instanceof Ocelot){
			e.setCancelled(true);
		}
		if(Start.state != State.INGAME){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(Manager.Spectators.contains(p)){
				e.setCancelled(true);
			}
		}
		if(e.getCause() == DamageCause.FALL){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if(Manager.Kit.containsKey(p)){
				if(Manager.Kit.get(p).equals("Hot Wing")){
					e.setDamage(e.getDamage() * 1.5);
				}
				if(Manager.Kit.get(p).equals("Chicken Warrior")){
					e.setDamage(e.getDamage() * 0.9);
				}
			}
		}
		
	}

}
