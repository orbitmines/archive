package me.O_o_Fadi_o_O.Hub.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.MasterMindManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class EntityInteractEvent implements Listener{
	
	Hub plugin;
	 
	public EntityInteractEvent(Hub instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		ItemStack h = p.getItemInHand();
		
		if(p.getWorld().getName().equals("Hub")){
			if(!PlayerManager.isInOPMode(p)){
				e.setCancelled(true);
			}
		}
		
		if(en instanceof MagmaCube){
			if(StorageManager.SoccerMagmaCubes.contains(en)){
				if(StorageManager.SoccerPlayerMagmaCubes.get(p) == en){
					PlayerManager.removeSoccerBall(p);
				}
			}
		}
		try{
			if(StorageManager.alphaEntity == en){
				if(PlayerManager.isLoaded(p)){
			        ByteArrayOutputStream b = new ByteArrayOutputStream();
			        DataOutputStream out = new DataOutputStream(b);
			 
			        try {
			            out.writeUTF("Connect");
			            out.writeUTF("alpha");
			        } catch (IOException eee) {
			         
			        }
			 
			        p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
		}
		catch(Exception ex){p.sendMessage("§3§lHub §8| §4§lERROR§7!");}
		if(StorageManager.owners.containsKey(en)){
			e.setCancelled(true);
		}
		
		if(PlayerManager.isLoaded(p)){
			if(StorageManager.MasterMindNPC == en){
				if(StorageManager.PlayersInMasterMind.contains(p)){
					MasterMindManager.leaveMasterMind(p);
				}
				else{
					MasterMindManager.joinMasterMind(p);
				}
			}
			if(StorageManager.ParkourNPC == en){
				if(StorageManager.PlayersInParkour.contains(p)){
					StorageManager.PlayersInParkour.remove(p);
					p.sendMessage("§6Parkour §8| §7You left the Parkour. Try again an other time!");
				}
				else{
					StorageManager.PlayersInParkour.add(p);
					p.sendMessage("§6Parkour §8| §7You joined the Parkour. §6Don't stop sprinting§7!");
					
					if(PlayerManager.isPetActive(p)){
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
			}
		}
		else{
			PlayerManager.warnPlayerNotLoaded(p);
		}
		
		if(StorageManager.serverSelectorOcelots.contains(en)){
			e.setCancelled(true);
			Bukkit.getServer().dispatchCommand(p, "servers");
		}
		
		p.updateInventory();
		
		try{
			if(h != null && h.getType() == Material.SADDLE && h.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
				if(StorageManager.ownerpets.get(p) == en){					
					en.setPassenger(p);
				}
			}
			if(h != null && h.getType() == Material.MONSTER_EGG || h != null && h.getType() == Material.EGG){
				e.setCancelled(true);
				p.updateInventory();
			}
		}catch(Exception ex){
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
