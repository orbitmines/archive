package me.O_o_Fadi_o_O.Prison.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Prison.Start;
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		if(StorageManager.Villagers.contains(en)){
			e.setCancelled(true);
			if(PlayerManager.isLoaded(p)){
				VillagerGamble.openVillagerGambleInv(p);
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
		}
		if(StorageManager.ShopNPCs.contains(en)){
			e.setCancelled(true);
			if(PlayerManager.isLoaded(p)){
				Shop.openShopInv(p);
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
		}
		if(StorageManager.SpawnTeleportNPCs.containsValue(en)){
			e.setCancelled(true);
			if(PlayerManager.isLoaded(p)){
				
				long lastUsed2 = 0;
				if(lastUsage2.containsKey(p.getName())){
					lastUsed2 = lastUsage2.get(p.getName());
				}
				int cdmillis2 = cdtime2 * 1000;
						
				if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
					
					p.sendMessage(Start.TAG + "Teleporting to §a§lSpawn§7...");
					p.teleport(new Location(StorageManager.PrisonWorld, StorageManager.PrisonSpawn.getX(), StorageManager.PrisonSpawn.getY() +4, StorageManager.PrisonSpawn.getZ(), -90, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					
					lastUsage2.put(p.getName(), System.currentTimeMillis());
				}
				
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
		}
		else{
			if(en instanceof Skeleton){
				if(((Skeleton) en).getCustomName().equals("§3§lTeleport to §a§lSpawn")){
					e.setCancelled(true);
					if(PlayerManager.isLoaded(p)){
						
						long lastUsed2 = 0;
						if(lastUsage2.containsKey(p.getName())){
							lastUsed2 = lastUsage2.get(p.getName());
						}
						int cdmillis2 = cdtime2 * 1000;
								
						if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
							
							p.sendMessage(Start.TAG + "Teleporting to §a§lSpawn§7...");
							p.teleport(new Location(StorageManager.PrisonWorld, StorageManager.PrisonSpawn.getX(), StorageManager.PrisonSpawn.getY() +4, StorageManager.PrisonSpawn.getZ(), -90, 0));
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
							
							lastUsage2.put(p.getName(), System.currentTimeMillis());
						}
						
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				}
			}
		}
		if(StorageManager.RankTeleportNPCs.containsValue(en)){
			e.setCancelled(true);
			if(PlayerManager.isLoaded(p)){
				
				long lastUsed2 = 0;
				if(lastUsage2.containsKey(p.getName())){
					lastUsed2 = lastUsage2.get(p.getName());
				}
				int cdmillis2 = cdtime2 * 1000;
						
				if(System.currentTimeMillis()-lastUsed2>=cdmillis2){
					
					String displayName = ((LivingEntity) en).getCustomName();
					String rankString = displayName.substring(20);
					if(rankString.contains("+")){rankString = rankString.substring(0, 1) + "Plus";}
					
					Prison.teleportToMines(p, Rank.valueOf(rankString));
					
					lastUsage2.put(p.getName(), System.currentTimeMillis());
				}
				
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
		}
		if(StorageManager.RankupNPCs.containsValue(en)){
			e.setCancelled(true);
			if(PlayerManager.isLoaded(p)){
				
				long lastUsed = 0;
				if(lastUsage.containsKey(p.getName())){
					lastUsed = lastUsage.get(p.getName());
				}
				int cdmillis = cdtime * 1000;
						
				if(System.currentTimeMillis()-lastUsed>=cdmillis){
				
					String displayName = ((LivingEntity) en).getCustomName();
					
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
					else if(displayName.contains("§a§lJ ")){rankupPrice = 210000;}
					else if(displayName.contains("§a§lI ")){rankupPrice = 250000;}
					else if(displayName.contains("§a§lH ")){rankupPrice = 300000;}
					else if(displayName.contains("§a§lG ")){rankupPrice = 350000;}
					else if(displayName.contains("§a§lF ")){rankupPrice = 425000;}
					else if(displayName.contains("§a§lE ")){rankupPrice = 500000;}
					else if(displayName.contains("§a§lD ")){rankupPrice = 600000;}
					else if(displayName.contains("§a§lC ")){rankupPrice = 700000;}
					else if(displayName.contains("§a§lB ")){rankupPrice = 815000;}
					else if(displayName.contains("§a§lA ")){rankupPrice = 940000;}
					else if(displayName.contains("§a§lZ+ ")){rankupPrice = 1100000;}
					else if(displayName.contains("§a§lY+ ")){rankupPrice = 1275000;}
					else if(displayName.contains("§a§lX+ ")){rankupPrice = 1500000;}
					else if(displayName.contains("§a§lW+ ")){rankupPrice = 1750000;}
					else if(displayName.contains("§a§lV+ ")){rankupPrice = 2000000;}
					else if(displayName.contains("§a§lU+ ")){rankupPrice = 2500000;}
					else{}
					
					if(PlayerManager.hasMoney(p, rankupPrice)){
						PlayerManager.rankupRank(p);
						PlayerManager.removeMoney(p, rankupPrice);
					}
					else{
						int needed = rankupPrice - StorageManager.PlayerMoney.get(p);
						p.sendMessage("§4§lPrison §8| §7You need §6" + needed + "§7 more §6§lGold§7 to §9Rankup§7!");
					}
					lastUsage.put(p.getName(), System.currentTimeMillis());
				}
			}
			else{
				PlayerManager.warnPlayerNotLoaded(p);
			}
		}
		
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
		p.updateInventory();
	}
}
