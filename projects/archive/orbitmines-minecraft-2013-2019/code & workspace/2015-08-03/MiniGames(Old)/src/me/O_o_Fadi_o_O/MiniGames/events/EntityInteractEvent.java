package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.IronGolem;
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		ItemStack h = p.getItemInHand();
		p.updateInventory();
		if(Start.owners.containsKey(en.getUniqueId())){
			e.setCancelled(true);
		}
		try{
			if(h != null && h.getType() == Material.SADDLE && h.getItemMeta().getDisplayName().equals("§e§nPet Ride")){
				if (en instanceof Pig || en instanceof MushroomCow || en instanceof Wolf || en instanceof Sheep || en instanceof Horse || en instanceof MagmaCube || en instanceof Slime || en instanceof Cow || en instanceof Silverfish || en instanceof Ocelot){
					if(Start.ownerpets.get(p) == en.getUniqueId()){
						
						en.setPassenger(p);
					}
				}
			}
			if(h != null && h.getType() == Material.LEASH && h.getItemMeta().getDisplayName().equals("§6§nStacker")){
				e.setCancelled(true);
			}
			if(en instanceof Chicken){
				Chicken c = (Chicken) en;
				if(c.getCustomName().equals("§fChicken Mama §8| §a§lClick to Equip")){
					
					Manager.selectKit(p, "Chicken Mama");
					
				}
				if(c.getCustomName().equals("§fBaby Chicken §8| §a§lClick to Equip")){
					
					Manager.selectKit(p, "Baby Chicken");
					
				}
				if(c.getCustomName().equals("§fHot Wing §8| §a§lClick to Equip")){
					
					Manager.selectKit(p, "Hot Wing");
					
				}
				
				if(c.getCustomName().equals("§fBaby Chicken §8| §c§lClick to Buy")){
					
					Manager.buyKit(p, "Baby Chicken");
					
				}
				if(c.getCustomName().equals("§fHot Wing §8| §c§lClick to Buy")){
					
					Manager.buyKit(p, "Hot Wing");
					
				}
			}
			if(en instanceof IronGolem){
				IronGolem c = (IronGolem) en;
				if(c.getCustomName().equals("§fChicken Warrior §8| §a§lClick to Equip")){
					
					Manager.selectKit(p, "Chicken Warrior");
					
				}
				if(c.getCustomName().equals("§fChicken Warrior §8| §c§lClick to Buy")){
					
					Manager.buyKit(p, "Chicken Warrior");
					
				}
			}
		}catch(Exception ex){
			
		}
	}
}
