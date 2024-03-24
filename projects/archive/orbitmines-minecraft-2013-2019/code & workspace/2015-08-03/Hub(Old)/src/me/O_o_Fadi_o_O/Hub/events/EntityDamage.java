package me.O_o_Fadi_o_O.Hub.events;

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

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		if(e.getEntity() instanceof Player){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Creeper || e.getEntity() instanceof Bat || e.getEntity() instanceof MushroomCow || e.getEntity() instanceof Pig || e.getEntity() instanceof Wolf || e.getEntity() instanceof Sheep || e.getEntity() instanceof Horse || e.getEntity() instanceof MagmaCube || e.getEntity() instanceof Slime || e.getEntity() instanceof Cow || e.getEntity() instanceof Silverfish || e.getEntity() instanceof Ocelot){
			e.setCancelled(true);
		}
	}

}
