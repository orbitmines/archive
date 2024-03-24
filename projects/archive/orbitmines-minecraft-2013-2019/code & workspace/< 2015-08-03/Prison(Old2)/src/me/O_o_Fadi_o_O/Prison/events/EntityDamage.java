package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
		Entity en = e.getEntity();
		if(en instanceof Skeleton){
			if(((Skeleton) en).getCustomName().equals("§3§lTeleport to §a§lSpawn")){
				e.setCancelled(true);
			}
		}
		if(StorageManager.RankTeleportNPCs.containsValue(en) || StorageManager.RankupNPCs.containsValue(en) || StorageManager.ShopNPCs.contains(en) || StorageManager.SpawnTeleportNPCs.containsValue(en) || StorageManager.Villagers.contains(en)){
			e.setCancelled(true);
		}
		if(StorageManager.RankWoodmen.containsValue(en)){
			e.setCancelled(true);
		}
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
	}

}
