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
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		if(StorageManager.loaded.get(p) == true){
			if(StorageManager.opmodeenabled.get(p) == false){
				e.setCancelled(true);
			}
			if(en == StorageManager.serverselector){
				p.openInventory(ServerSelector.serverSelector);
			}
			if(en == StorageManager.omtnpc){
				p.openInventory(OMTShop.getOMTShop(p));
			}
			if(StorageManager.villagers.contains(en)){
				e.setCancelled(true);
				VillagerGamble.openVillagerGambleInv(p);
			}
			if(StorageManager.shopnpcs.contains(en)){
				e.setCancelled(true);
				Shop.openShopInv(p);
			}
			if(StorageManager.spawnteleportnpcs.containsValue(en)){
				e.setCancelled(true);
				long lastUsed2 = 0;
				if(lastUsage2.containsKey(p.getName())){
					lastUsed2 = lastUsage2.get(p.getName());
				}
				int cdmillis2 = cdtime2 * 1000;
						
				if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
					
					p.sendMessage(Start.TAG + "Teleporting to §a§lSpawn§7...");
					p.teleport(new Location(StorageManager.spawn.getWorld(), StorageManager.spawn.getX(), StorageManager.spawn.getY() +4, StorageManager.spawn.getZ(), -90, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					
					lastUsage2.put(p.getName(), System.currentTimeMillis());
				}
			}
			else{
				if(en instanceof Skeleton){
					if(((Skeleton) en).getCustomName().equals("§3§lTeleport to §a§lSpawn")){
						e.setCancelled(true);
						long lastUsed2 = 0;
						if(lastUsage2.containsKey(p.getName())){
							lastUsed2 = lastUsage2.get(p.getName());
						}
						int cdmillis2 = cdtime2 * 1000;
								
						if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
							
							p.sendMessage(Start.TAG + "Teleporting to §a§lSpawn§7...");
							p.teleport(new Location(StorageManager.spawn.getWorld(), StorageManager.spawn.getX(), StorageManager.spawn.getY() +4, StorageManager.spawn.getZ(), -90, 0));
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
							
							lastUsage2.put(p.getName(), System.currentTimeMillis());
						}
					}
				}
			}
			try{
				String displayName = ((LivingEntity) en).getCustomName();
				
				if(displayName.startsWith("§3§lTeleport to") && !displayName.equals("§3§lTeleport to §a§lSpawn")){
					e.setCancelled(true);
					long lastUsed2 = 0;
					if(lastUsage2.containsKey(p.getName())){
						lastUsed2 = lastUsage2.get(p.getName());
					}
					int cdmillis2 = cdtime2 * 1000;
							
					if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
						
						String rankString = displayName.substring(20);
						if(rankString.contains("+")){rankString = rankString.substring(0, 1) + "Plus";}
						
						Prison.teleportToMines(p, Rank.valueOf(rankString));
						
						lastUsage2.put(p.getName(), System.currentTimeMillis());
					}
				}
				
				if(displayName.startsWith("§9§lRankup to")){
					e.setCancelled(true);
					long lastUsed = 0;
					if(lastUsage.containsKey(p.getName())){
						lastUsed = lastUsage.get(p.getName());
					}
					int cdmillis = cdtime * 1000;
							
					if(System.currentTimeMillis()-lastUsed>=cdmillis){
						
						int rankupPrice = 0;
						
						//if(displayName.contains("§a§lZ")){rankupPrice = 0;}
						if(displayName.contains("§a§lY ")){rankupPrice = 1000;}
						else if(displayName.contains("§a§lX ")){rankupPrice = 2500;}
						else if(displayName.contains("§a§lW ")){rankupPrice = 5000;}
						else if(displayName.contains("§a§lV ")){rankupPrice = 7500;}
						else if(displayName.contains("§a§lU ")){rankupPrice = 10000;}
						else if(displayName.contains("§a§lT ")){rankupPrice = 15000;}
						else if(displayName.contains("§a§lS ")){rankupPrice = 20000;}
						else if(displayName.contains("§a§lR ")){rankupPrice = 30000;}
						else if(displayName.contains("§a§lQ ")){rankupPrice = 40000;}
						else if(displayName.contains("§a§lP ")){rankupPrice = 50000;}
						else if(displayName.contains("§a§lO ")){rankupPrice = 70000;}
						else if(displayName.contains("§a§lN ")){rankupPrice = 90000;}
						else if(displayName.contains("§a§lM ")){rankupPrice = 115000;}
						else if(displayName.contains("§a§lL ")){rankupPrice = 140000;}
						else if(displayName.contains("§a§lK ")){rankupPrice = 175000;}
						else if(displayName.contains("§a§lJ ")){rankupPrice = 250000;}
						else if(displayName.contains("§a§lI ")){rankupPrice = 500000;}
						else if(displayName.contains("§a§lH ")){rankupPrice = 750000;}
						else if(displayName.contains("§a§lG ")){rankupPrice = 1000000;}
						else if(displayName.contains("§a§lF ")){rankupPrice = 1250000;}
						else if(displayName.contains("§a§lE ")){rankupPrice = 1500000;}
						else if(displayName.contains("§a§lD ")){rankupPrice = 1750000;}
						else if(displayName.contains("§a§lC ")){rankupPrice = 2000000;}
						else if(displayName.contains("§a§lB ")){rankupPrice = 2500000;}
						else if(displayName.contains("§a§lA ")){rankupPrice = 3000000;}
						else if(displayName.contains("§a§lZ+ ")){rankupPrice = 3500000;}
						else if(displayName.contains("§a§lY+ ")){rankupPrice = 4000000;}
						else if(displayName.contains("§a§lX+ ")){rankupPrice = 4750000;}
						else if(displayName.contains("§a§lW+ ")){rankupPrice = 5500000;}
						else if(displayName.contains("§a§lV+ ")){rankupPrice = 7000000;}
						else if(displayName.contains("§a§lU+ ")){rankupPrice = 8500000;}
						else{}
						
						if(PlayerManager.hasMoney(p, rankupPrice)){
							PlayerManager.rankupRank(p);
							PlayerManager.removeMoney(p, rankupPrice);
							npcmanager.loadNPCs(p);
						}
						else{
							int needed = rankupPrice - StorageManager.money.get(p);
							p.sendMessage("§4§lPrison §8| §7You need §6" + needed + "§7 more §6§lGold§7 to §9Rankup§7!");
						}
						lastUsage.put(p.getName(), System.currentTimeMillis());
					}
				}
			}catch(Exception ex){
				
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
			e.setCancelled(true);
		}	

		if(StorageManager.petowner.containsKey(en)){
			e.setCancelled(true);
		}
		p.updateInventory();
	}
}
