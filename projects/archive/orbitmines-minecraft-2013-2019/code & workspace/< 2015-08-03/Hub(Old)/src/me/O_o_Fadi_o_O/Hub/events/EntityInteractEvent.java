package me.O_o_Fadi_o_O.Hub.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
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
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

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
		if(StorageManager.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
		
		if(StorageManager.serverSelectorOcelots.contains(en)){
			e.setCancelled(true);
			Bukkit.getServer().dispatchCommand(p, "servers");
		}
		
		p.updateInventory();
		
		try{
			if(h != null && h.getType() == Material.SADDLE && h.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
				if (en instanceof Pig || en instanceof MushroomCow || en instanceof Wolf || en instanceof Sheep || en instanceof Horse || en instanceof MagmaCube || en instanceof Slime || en instanceof Cow || en instanceof Silverfish || en instanceof Ocelot){
					if(StorageManager.ownerpets.get(p) == en.getUniqueId()){
						
						en.setPassenger(p);
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
}
