package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PickUpEvent implements Listener{
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		
		Player p = e.getPlayer();
		
		Item item = e.getItem();
		ItemStack i = item.getItemStack();
		
		if(i.getType() == Material.PAPER){
			
			try{
				
				if(i.getItemMeta().getDisplayName().startsWith("Paper ")){
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
					
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.JUMP);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 4));
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 5, 4));
					
					item.remove();
				}
				
			}catch(Exception ex){
				
			}
		}
		
		if(!p.isOp()){
			if(StorageManager.PlayersGame.containsKey(p)){
				if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
					e.setCancelled(true);
				}
				if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.INGAME || StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.DEATHMATCH){
						if(!StorageManager.PlayersInSurvivalGames.contains(p)){
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
					}
				}
			}
			else{
				e.setCancelled(true);
			}
		}
		else{
			if(StorageManager.PlayersGame.containsKey(p)){
				if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
					if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p)) != ChickenFightState.LOBBY){
						e.setCancelled(true);
					}
				}
				if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.INGAME || StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.DEATHMATCH){
						if(!StorageManager.PlayersInSurvivalGames.contains(p)){
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
