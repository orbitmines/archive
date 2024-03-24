package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DamageByEntity implements Listener{
	
	Start plugin;
	 
	public DamageByEntity(Start instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			final Player damager = (Player) e.getDamager();
			final Player damaged = (Player) e.getEntity();
			
			ItemStack c = damager.getItemInHand();
			
			if(StorageManager.PlayersInChickenFight.contains(damager) && StorageManager.PlayersInChickenFight.contains(damaged)){
				
				if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(damager)) == ChickenFightState.INGAME){
					damaged.getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, 152, 3);
				}
			}
			if(c != null){
				if(c.getType() == Material.LEASH && c.getItemMeta().getDisplayName().equals("§6§nStacker")){
					Player pE = (Player) e.getEntity();
					Player pD = (Player) e.getDamager();
						if(PlayerManager.isLoaded(pD)){
						pD.setPassenger(pE);
						
						pD.sendMessage("§fYou've §6§lstacked§f " + pE.getName() + " on your Head!");
						pD.playEffect(pD.getLocation(), Effect.STEP_SOUND, 152);
						pE.sendMessage("§f" + pD.getName() + " §6§lstacked§f you on their Head!");
						e.setCancelled(true);
					}
					else{
						PlayerManager.warnPlayerNotLoaded(pD);
					}
				}
			}
			if(c != null && c.getType() == Material.FEATHER){
				
				new BukkitRunnable(){
					
					public void run(){
						if(StorageManager.ChickenFightKit.get(damaged).equals("Baby Chicken")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.4);
							damaged.setVelocity(velocity.add(new Vector(0, 0.6, 0)));
						}
						if(StorageManager.ChickenFightKit.get(damaged).equals("Chicken Mama")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.2);
							damaged.setVelocity(velocity.add(new Vector(0, 0.45, 0)));
						}
						if(StorageManager.ChickenFightKit.get(damaged).equals("Hot Wing")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.3);
							damaged.setVelocity(velocity.add(new Vector(0, 0.53, 0)));
						}
						if(StorageManager.ChickenFightKit.get(damaged).equals("Chicken Warrior")){
							Vector velocity = damaged.getLocation().subtract(damager.getLocation()).toVector().normalize().multiply(1.05);
							damaged.setVelocity(velocity.add(new Vector(0, 0.24, 0)));
						}
					}
				}.runTaskLater(this.plugin, 1L);
				
			}
			
			if(StorageManager.SpectatorsInChickenFight.contains(damager)){
				e.setCancelled(true);
			}
			
			if(StorageManager.SpectatorsInSurvivalGames.contains(damager)){
				e.setCancelled(true);
			}
			if(StorageManager.PlayersGame.containsKey(damager)){
				if(StorageManager.PlayersGame.get(damager) == Game.CHICKENFIGHT){
					if(StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(damager)) != ChickenFightState.INGAME){
						e.setCancelled(true);
					}
				}
				if(StorageManager.PlayersGame.get(damager) == Game.SURVIVALGAMES){
					if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(damager)) != SurvivalGamesState.INGAME && StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(damager)) != SurvivalGamesState.DEATHMATCH){
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
