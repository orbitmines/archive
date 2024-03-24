package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Horse;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageEvent implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		
		if(e.getEntity() instanceof Skeleton || e.getEntity() instanceof IronGolem || e.getEntity() instanceof Chicken || e.getEntity() instanceof Creeper || e.getEntity() instanceof Bat || e.getEntity() instanceof MushroomCow || e.getEntity() instanceof Pig || e.getEntity() instanceof Wolf || e.getEntity() instanceof Sheep || e.getEntity() instanceof Horse || e.getEntity() instanceof MagmaCube || e.getEntity() instanceof Slime || e.getEntity() instanceof Cow || e.getEntity() instanceof Silverfish || e.getEntity() instanceof Ocelot){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(StorageManager.SpectatorsInSurvivalGames.contains(p)){
				e.setCancelled(true);
			}
			if(StorageManager.PlayersGame.containsKey(p)){
				if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
					if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p)) != ChickenFightState.INGAME){
						e.setCancelled(true);
					}
				}
				if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
					if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) != SurvivalGamesState.INGAME && StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) != SurvivalGamesState.DEATHMATCH){
						e.setCancelled(true);
					}
				}
			}
			else{
				e.setCancelled(true);
			}
			if(StorageManager.SpectatorsInChickenFight.contains(p)){
				e.setCancelled(true);
			}
		}
		if(e.getCause() == DamageCause.FALL){
			if(e.getEntity() instanceof Player){
				Player p = (Player) e.getEntity();
				if(StorageManager.PlayersGame.containsKey(p)){
					if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
						e.setCancelled(true);
					}
				}
			}
		}
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if(StorageManager.ChickenFightKit.containsKey(p)){
				if(StorageManager.ChickenFightKit.get(p).equals("Hot Wing")){
					e.setDamage(e.getDamage() * 1.5);
				}
				if(StorageManager.ChickenFightKit.get(p).equals("Chicken Warrior")){
					e.setDamage(e.getDamage() * 0.9);
				}
			}
		}
		
	}

}
