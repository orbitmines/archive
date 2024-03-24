package me.O_o_Fadi_o_O.MiniGames.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.Inventories.ChickenFightInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.SurvivalGamesInv;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Server;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityInteractEvent implements Listener{
	
	Start start = Start.getInstance();
	
	private Map<String, Long> lastclicked = new HashMap<String, Long>();
	private final int clickcooldown = 1;
	
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		final Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		ItemStack item = p.getItemInHand();
		if(en instanceof ArmorStand){
			e.setCancelled(true);
			p.updateInventory();
		}
		if(StorageManager.loaded.get(p) == true){
			if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
				}
				if(en == StorageManager.chickenfightnpc){
					e.setCancelled(true);
					p.openInventory(ChickenFightInv.getChickenFightInv(p, 0));
				}
				if(en == StorageManager.survivalgamesnpc){
					e.setCancelled(true);
					p.openInventory(SurvivalGamesInv.getSurvivalGamesInv(p, 0));
				}
			}
			
			long lastclick = 0;
			if(lastclicked.containsKey(p.getName())){
				lastclick = lastclicked.get(p.getName());
			}
			int cdmillis = clickcooldown * 1000;
					
			if(System.currentTimeMillis()-lastclick>=cdmillis){
				if(StorageManager.soccermagmacubes.contains(en)){
					if(StorageManager.soccermagmacube.get(p) == en){
						en.remove();
						StorageManager.soccermagmacube.remove(p);
						p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED§7 your §cMagmaCube Ball§7!");
					}
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.alphanpc == en){
					if(StorageManager.onlineplayers.get(Server.ALPHA) != -1){
						start.teleportToServer(p, Server.ALPHA);
					}
					else{
						p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §e§lAlpha§7 Server is §4§lOffline§7!");
					}
			        
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.serverselector == en){
					e.setCancelled(true);
					p.openInventory(ServerSelector.serverSelector);
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}				
				if(item != null && item.getType() == Material.SADDLE && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
					if(StorageManager.petentity.containsKey(p)){
						if(StorageManager.petentity.get(p) == en){					
							en.setPassenger(p);
						}
					}
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
			}
		}
		else{
			e.setCancelled(true);
			p.updateInventory();
			PlayerManager.warnPlayerNotLoaded(p);
		}
		
		if(item != null && item.getType() == Material.MONSTER_EGG || item != null && item.getType() == Material.EGG){
			e.setCancelled(true);
			p.updateInventory();
		}
		
		new BukkitRunnable(){
			public void run(){
				p.updateInventory();
			}
		}.runTaskLater(this.start, 1);
	}
}
