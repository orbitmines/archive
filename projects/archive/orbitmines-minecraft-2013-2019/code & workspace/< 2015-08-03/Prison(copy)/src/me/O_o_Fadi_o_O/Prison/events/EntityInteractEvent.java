package me.O_o_Fadi_o_O.Prison.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.Inv.OMTShop;
import me.O_o_Fadi_o_O.Prison.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.prisonInv.Shop;
import me.O_o_Fadi_o_O.Prison.prisonInv.VillagerGamble;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractEvent implements Listener{
	
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 5;
	
	private Map<String, Long> lastUsage2 = new HashMap<String, Long>();
	private final int cdtime2 = 3;
	
	NPCManager npcmanager = new NPCManager();
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent e){
		
			
			if(StorageManager.villagers.contains(en)){
				e.setCancelled(true);
				VillagerGamble.openVillagerGambleInv(p);
			}
			
		
	}
}
