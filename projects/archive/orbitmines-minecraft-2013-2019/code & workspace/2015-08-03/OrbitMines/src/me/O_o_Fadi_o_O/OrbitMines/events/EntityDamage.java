package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		Entity en = e.getEntity();
		
		if(ServerData.isServer(Server.HUB)){
			e.setCancelled(true);
		}
		else if(ServerData.isServer(Server.KITPVP)){
			if(en instanceof Player){
				Player p = (Player) en;
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				KitPvPPlayer kp = omp.getKitPvPPlayer();
				
				if(kp.getKitSelected() == null){
					e.setCancelled(true);
				}
				else{
					if(!e.isCancelled()){
						for(int i = 0; i < 2; i++){
							final Item item = p.getWorld().dropItem(p.getLocation(), Utils.setDurability(Utils.setDisplayname(new ItemStack(Material.INK_SACK), "Blood " + p.getName() + i), 1));
							item.setPickupDelay(Integer.MAX_VALUE);
							item.setVelocity(Utils.getRandomVelocity());
							
							new BukkitRunnable(){
								public void run(){
									item.remove();
								}
							}.runTaskLater(Start.getInstance(), 50);
						}
					}
				}
			}
		}
		else if(ServerData.isServer(Server.PRISON)){
			if(en instanceof Player){
				Player p = (Player) en;
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				
				if(!omp.getPrisonPlayer().isInPvP()){
					e.setCancelled(true);
				}
			}
			else{
				e.setCancelled(true);
			}
		}
		else if(ServerData.isServer(Server.MINIGAMES)){
			if(en instanceof Player){
				Player p = (Player) en;
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				Arena arena = omp.getArena();
				
				if(arena != null){
					if(arena.getState() != GameState.IN_GAME || arena.isSpectator(omp) || arena.getType() == MiniGameType.SKYWARS && (arena.getMinutes() == 15 && arena.getSeconds() == 0 || arena.getMinutes() == 14 && arena.getSeconds() >= 57) || arena.getType() == MiniGameType.CHICKEN_FIGHT && e.getCause() == DamageCause.FALL){
						e.setCancelled(true);
					}
					
					if(arena.getType() == MiniGameType.CHICKEN_FIGHT && arena.getState() == GameState.IN_GAME && !arena.isSpectator(omp)){
						Kit kit = omp.getCFPlayer().getKit();
						
						if(kit != null){
							if(kit.getKitName().equals(TicketType.CHICKEN_MAMA_KIT.toString())){
								//e.setDamage(e.getDamage() * 1);
							}
							else if(kit.getKitName().equals(TicketType.BABY_CHICKEN_KIT.toString())){
								e.setDamage(e.getDamage() * 1.1);
							}
							else if(kit.getKitName().equals(TicketType.HOT_WING_KIT.toString())){
								e.setDamage(e.getDamage() * 1.5);
							}
							else if(kit.getKitName().equals(TicketType.CHICKEN_WARLORD_KIT.toString())){
								e.setDamage(e.getDamage() * 0.8);
							}
							else if(kit.getKitName().equals(TicketType.CHICKEN_KIT.toString())){
								e.setDamage(e.getDamage() * 0.9);
							}
							else{}
						}
					}
				}
			}
		}
		else{}
		
		if(ServerStorage.pets.contains(en) || NPC.getNPC(en) != null){
			e.setCancelled(true);
		}
	}
}
