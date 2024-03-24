package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.GameMode;
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

public class PickupEvent implements Listener {
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		Item item = e.getItem();
		ItemStack i = item.getItemStack();
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			if(i.getType() == Material.PAPER && i.getItemMeta() != null && i.getItemMeta().getDisplayName() != null && i.getItemMeta().getDisplayName().startsWith("Paper ") && !omp.isInLapisParkour()){
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.JUMP);
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 4));
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 5, 4));
				
				item.remove();
			}
			
			if(p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
				e.setCancelled(true);
			}
			
			if(ServerData.isServer(Server.MINIGAMES)){
				Arena arena = omp.getArena();
				
				if(arena != null){
					if(arena.getType() == MiniGameType.SURVIVAL_GAMES || arena.getType() == MiniGameType.ULTRA_HARD_CORE || arena.getType() == MiniGameType.SKYWARS){
						if(arena.getState() != GameState.IN_GAME || arena.isSpectator(omp)){
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
					}
				}
			}
		}
		else if(ServerData.isServer(Server.KITPVP)){
			e.setCancelled(true);
		}
		else if(ServerData.isServer(Server.CREATIVE)){
			CreativePlayer cp = omp.getCreativePlayer();
			
			e.setCancelled(p.getGameMode() == GameMode.CREATIVE || (cp.isInPvPPlot() && cp.getSelectedKit() == null));
		}
		else{}
	}
}
