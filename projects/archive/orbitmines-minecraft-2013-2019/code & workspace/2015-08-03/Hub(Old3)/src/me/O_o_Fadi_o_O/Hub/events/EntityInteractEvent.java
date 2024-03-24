package me.O_o_Fadi_o_O.Hub.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Hub.managers.MindCraftManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.TitleManager;
import me.O_o_Fadi_o_O.Hub.utils.Pet;
import me.O_o_Fadi_o_O.Hub.utils.Server;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityInteractEvent implements Listener{
	
	Hub hub = Hub.getInstance();
	
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
			if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
				if(StorageManager.opmodeenabled.get(p) == false){
					e.setCancelled(true);
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
						hub.teleportToServer(p, Server.ALPHA);
					}
					else{
						p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §e§lAlpha§7 Server is §4§lOffline§7!");
					}
			        
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.mindcraftnpc == en){
					if(StorageManager.playersinmindcraft.contains(p)){
						MindCraftManager.leaveMindCraft(p);
					}
					else{
						MindCraftManager.joinMindCraft(p);
					}
					
					lastclicked.put(p.getName(), System.currentTimeMillis());
				}
				if(StorageManager.lapisparkournpc == en){
					
					if(StorageManager.playersinlapisparkour.contains(p)){
						StorageManager.playersinlapisparkour.remove(p);
						p.sendMessage("§1§lLapis Parkour §8| §7You left the Parkour. Try again an other time!");
					}
					else{
						StorageManager.playersinlapisparkour.add(p);
						p.sendMessage("");
						p.sendMessage("§1§lLapis Parkour");
						p.sendMessage(" §7- You can't stop sprinting.");
						p.sendMessage(" §7- Reward: §b§l250 VIP Points§7.");
						p.sendMessage("");
						p.sendMessage("§f§lGood Luck!");
						
						TitleManager.setTitle(p, "§1§lLapis Parkour", "§7You can't stop sprinting!");
						
						if(StorageManager.pet.get(p) != Pet.NONE){
							PlayerManager.removePet(p, "§7Pet");
						}
						for(PotionEffect eff : p.getActivePotionEffects()){
							p.removePotionEffect(eff.getType());
						}
					}
					
					if(p.getVehicle() != null){
						p.leaveVehicle();
					}
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					
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
		}.runTaskLater(this.hub, 1);
	}
}
