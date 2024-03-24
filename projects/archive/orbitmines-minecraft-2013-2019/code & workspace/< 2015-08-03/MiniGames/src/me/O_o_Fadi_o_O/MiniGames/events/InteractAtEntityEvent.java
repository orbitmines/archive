package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Inventories.ChickenFightInv;
import me.O_o_Fadi_o_O.MiniGames.Inventories.SurvivalGamesInv;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractAtEntityEvent implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent e){
		Entity en = e.getRightClicked();
		Player p = e.getPlayer();
		
		if(StorageManager.armorstands.contains(en)){
			e.setCancelled(true);
		}
		try{
			if(en.getCustomName().equals("§f§lChicken Fight")){
				e.setCancelled(true);
				p.openInventory(ChickenFightInv.getChickenFightInv(p, 0));
			}
			if(en.getCustomName().equals("§6§lSurvival Games")){
				e.setCancelled(true);
				p.openInventory(SurvivalGamesInv.getSurvivalGamesInv(p, 0));
			}
			
			if(en.getCustomName().equals("§fChicken Mama §8| §a§lClick to Equip")){
				e.setCancelled(true);
				ChickenFight.selectKit(p, "Chicken Mama");
				
			}
			if(en.getCustomName().equals("§fBaby Chicken §8| §a§lClick to Equip")){
				e.setCancelled(true);
				ChickenFight.selectKit(p, "Baby Chicken");
				
			}
			if(en.getCustomName().equals("§fHot Wing §8| §a§lClick to Equip")){
				e.setCancelled(true);
				ChickenFight.selectKit(p, "Hot Wing");
				
			}
			
			if(en.getCustomName().equals("§fBaby Chicken §8| §c§lClick to Buy")){
				e.setCancelled(true);
				ChickenFight.buyKit(p, "Baby Chicken");
				
			}
			if(en.getCustomName().equals("§fHot Wing §8| §c§lClick to Buy")){
				e.setCancelled(true);
				ChickenFight.buyKit(p, "Hot Wing");
				
			}
			
			if(en.getCustomName().equals("§fChicken Warrior §8| §a§lClick to Equip")){
				e.setCancelled(true);
				ChickenFight.selectKit(p, "Chicken Warrior");
				
			}
			if(en.getCustomName().equals("§fChicken Warrior §8| §c§lClick to Buy")){
				e.setCancelled(true);
				ChickenFight.buyKit(p, "Chicken Warrior");
				
			}
		}catch(Exception ex){}
	}
}
