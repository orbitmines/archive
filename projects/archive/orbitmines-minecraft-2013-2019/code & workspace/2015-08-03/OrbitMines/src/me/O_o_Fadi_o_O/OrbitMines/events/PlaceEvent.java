package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.PrisonServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Region;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
	
	@EventHandler
	public void onPlace(final BlockPlaceEvent e){
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(omp.isLoaded()){
			if(!omp.isOpMode()){
				if(ServerData.isServer(Server.KITPVP) || ServerData.isServer(Server.HUB, Server.SURVIVAL) && p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
					e.setCancelled(true);
					omp.updateInventory();
				}
				else if(ServerData.isServer(Server.CREATIVE)){
					CreativeServer creative = ServerData.getCreative();
					CreativePlayer cp = omp.getCreativePlayer();
					
					if(p.getWorld().getName().equals(creative.getPlotWorld().getName())){
						e.setCancelled(!cp.isOnPlot(e.getBlockPlaced().getLocation()));
					}
					else if(p.getWorld().getName().equals(creative.getCreativeWorld().getName())){
						e.setCancelled(true);
					}
					else{}
				}
				else if(ServerData.isServer(Server.SURVIVAL)){
					if(p.getWorld().getName().equals(ServerData.getSurvival().getSurvivalWorld().getName())){
						if(Region.isInRegion(omp, e.getBlockPlaced().getLocation())){
							e.setCancelled(true);
							omp.updateInventory();
						}
					}
				}
				else if(ServerData.isServer(Server.SKYBLOCK)){
					SkyBlockServer skyblock = ServerData.getSkyBlock();
					SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
					
					if(p.getWorld().getName().equals(skyblock.getSkyblockWorld().getName()) || p.getWorld().getName().equals(skyblock.getSkyblockNetherWorld().getName())){
						if(sbp.hasIsland()){
							if(!sbp.onIsland(e.getBlockPlaced().getLocation(), true)){
								e.setCancelled(true);
							}
						}
						else{
							e.setCancelled(true);
						}
					}
					else if(p.getWorld().getName().equals(skyblock.getLobbyWorld().getName())){
						e.setCancelled(true);
					}
					else{}
				}
				else if(ServerData.isServer(Server.PRISON)){
					PrisonServer prison = ServerData.getPrison();
					PrisonPlayer pp = omp.getPrisonPlayer();
					
					if(p.getWorld().getName().equals(prison.getPrisonWorld().getName())){
						if(!pp.inMine(e.getBlockPlaced().getLocation(), true)){
							e.setCancelled(true);
						}
					}
					else if(p.getWorld().getName().equals(prison.getLobbyWorld().getName())){
						if(pp.getShop() == null || !pp.getShop().isInShop(e.getBlockPlaced().getLocation())){
							e.setCancelled(true);
						}
					}
					else{}
				}
				else if(ServerData.isServer(Server.MINIGAMES)){
					Arena arena = omp.getArena();
					
					if(arena != null){
						if(arena.isSpectator(omp)){
							e.setCancelled(true);
						}
						else{
							if(arena.getType() == MiniGameType.SURVIVAL_GAMES){
								if(arena.getState() == GameState.IN_GAME){
									Block b = e.getBlockPlaced();
									Material m = b.getType();
									
									if(m == Material.TNT){
										b.setType(Material.AIR);
										TNTPrimed tnt = (TNTPrimed) b.getWorld().spawnEntity(b.getLocation().add(0, 1, 0), EntityType.PRIMED_TNT);
										tnt.setFuseTicks((int) (20 * 1.5));
									}
									else{
										if(m != Material.CAKE_BLOCK && m != Material.FIRE){
											p.damage(3D);
											p.sendMessage("§7§lDo not try to block glitch!");
											e.setCancelled(true);
										}
									}
								}
								else{
									e.setCancelled(true);
								}
							}
							else if(arena.getType() == MiniGameType.ULTRA_HARD_CORE){
								if(arena.getState() != GameState.IN_GAME){
									e.setCancelled(true);
								}
								else{
									Block b = e.getBlockPlaced();
									
									if(b.getType() == Material.IRON_ORE){
										if(!arena.getUHC().getIronOresPlaced().contains(b)){
											arena.getUHC().getIronOresPlaced().add(b);
										}
									}
								}
							}
							else if(arena.getType() == MiniGameType.SKYWARS){
								if(arena.getState() != GameState.IN_GAME){
									e.setCancelled(true);
								}
								else{
									Block b = e.getBlockPlaced();
									
									if(b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST){
										arena.getSW().getPlacedChests().add(b);
									}
								}
							}
							else{
								e.setCancelled(true);
							}
						}
					}
				}
				else{}
			}
		}
		else{
			e.setCancelled(true);
			omp.notLoaded();
		}
	}
}
