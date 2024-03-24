package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		Entity en = e.getEntity();
		
		if(en instanceof Player || en instanceof Pig || en instanceof Creeper || en instanceof Silverfish || en instanceof MushroomCow || en == StorageManager.MasterMindNPC || en == StorageManager.ParkourNPC || StorageManager.SoccerMagmaCubes.contains(en) || StorageManager.alphaEntity == en || StorageManager.serverSelectorOcelots.contains(en) || StorageManager.owners.containsKey(en)){
			e.setCancelled(true);
		}
	}

}
