package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.PrisonServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.SkyBlockServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.Lumberjack;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils;
import me.O_o_Fadi_o_O.OrbitMines.utils.skyblock.SkyBlockPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.Region;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.ShopSign;
import me.O_o_Fadi_o_O.OrbitMines.utils.survival.SurvivalPlayer;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		OMPlayer omp = OMPlayer.getOMPlayer(p);
		
		if(omp.isLoaded()){
			if(!omp.isOpMode()){
				if(ServerData.isServer(Server.KITPVP) || !ServerData.isServer(Server.PRISON) && p.getWorld().getName().equals(ServerData.getLobbyWorld().getName())){
					e.setCancelled(true);
				}
				else if(ServerData.isServer(Server.CREATIVE)){
					if(p.getWorld().getName().equals(ServerData.getCreative().getPlotWorld().getName())){
						CreativePlayer cp = omp.getCreativePlayer();
						e.setCancelled(!cp.isOnPlot(e.getBlock().getLocation()));
					}
				}
				else if(ServerData.isServer(Server.SURVIVAL)){
					SurvivalPlayer sp = omp.getSurvivalPlayer();
					
					if(p.getWorld().getName().equals(ServerData.getSurvival().getSurvivalWorld().getName())){
						if(Region.isInRegion(omp, e.getBlock().getLocation())){
							e.setCancelled(true);
						}
						
						if(!e.isCancelled()){
							ShopSign sign = ShopSign.getShopSign(e.getBlock().getLocation());
							
							if(sign != null && sp.getShopSigns().contains(sign)){
								sign.delete();
								p.sendMessage("§7Your Chest Shop has been removed.");
							}
						}
					}
				}
				else if(ServerData.isServer(Server.SKYBLOCK)){
					SkyBlockServer skyblock = ServerData.getSkyBlock();
					SkyBlockPlayer sbp = omp.getSkyBlockPlayer();
					
					if(p.getWorld().getName().equals(skyblock.getSkyblockWorld().getName()) || p.getWorld().getName().equals(skyblock.getSkyblockNetherWorld().getName())){
						if(sbp.hasIsland()){
							if(!sbp.onIsland(e.getBlock().getLocation(), true)){
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
					ItemStack i = p.getItemInHand();
					
					if(p.getWorld().getName().equals(prison.getPrisonWorld().getName())){
						if(e.getBlock().getType() == Material.LOG || !pp.inMine(e.getBlock().getLocation(), true)){
							e.setCancelled(true);
							
							if(e.getBlock().getType() == Material.LOG){
								boolean canbreak = false;
								
								for(Lumberjack lj : prison.getLumberjacks()){
									if(!canbreak && pp.hasPerms(lj.getRank()) && lj.getBlocks().contains(e.getBlock())){
										canbreak = true;
									}
								}
								
								if(canbreak){
									p.getInventory().addItem(new ItemStack(Material.LOG));
									
									e.getBlock().setType(Material.STAINED_CLAY);
									e.getBlock().setData((byte) 15);
								}
								else{
									p.sendMessage("§7You cannot do that here!");
								}
							}
						}
						else{
							e.setCancelled(true);
							
							PrisonUtils.reduceDurability(omp, i);
							p.setTotalExperience(p.getTotalExperience() + e.getExpToDrop());
							
							if(e.getBlock().getType() == Material.IRON_ORE){
								p.getInventory().addItem(PrisonUtils.applyFortune(i, new ItemStack(Material.IRON_INGOT)));
							}
							else if(e.getBlock().getType() == Material.GOLD_ORE){
								p.getInventory().addItem(PrisonUtils.applyFortune(i, new ItemStack(Material.GOLD_INGOT)));
							}
							else{
								for(ItemStack item : e.getBlock().getDrops()){
									p.getInventory().addItem(PrisonUtils.applyFortune(i, item));
								}
							}
							
							e.getBlock().setType(Material.AIR);
						}
					}
					else if(p.getWorld().getName().equals(prison.getLobbyWorld().getName())){
						if(pp.getShop() == null || !pp.getShop().isInShop(e.getBlock().getLocation())){
							e.setCancelled(true);
						}
					}
					else{}
					
					if(!e.isCancelled()){
						ShopSign sign = ShopSign.getShopSign(e.getBlock().getLocation());
						
						if(sign != null && pp.getShopSigns().contains(sign)){
							sign.delete();
							p.sendMessage("§7Your Chest Shop has been removed.");
						}
					}
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
									Material m = e.getBlock().getType();
									
									if(m != Material.LEAVES && m != Material.LEAVES_2 && m != Material.LONG_GRASS && m != Material.DEAD_BUSH && m != Material.YELLOW_FLOWER && m != Material.RED_ROSE && m != Material.BROWN_MUSHROOM && m != Material.RED_MUSHROOM && m != Material.VINE && m != Material.DOUBLE_PLANT && m != Material.POTATO && m != Material.CARROT && m != Material.CROPS && m != Material.TORCH && m != Material.REDSTONE_TORCH_ON){
										p.damage(3D);
										p.sendMessage("§7§lDo not try to block glitch!");
										e.setCancelled(true);
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
									Block b = e.getBlock();
									
									if(b.getType() == Material.IRON_ORE){
										if((arena.getUHC().isDoubleIron() || omp.getUHCPlayer().isDoubleIron()) && !arena.getUHC().getIronOresPlaced().contains(b) && new Random().nextBoolean()){
											b.getWorld().dropItem(b.getLocation().add(0.5, 0, 0.5), new ItemStack(Material.IRON_ORE));
										}
									}
									else if(b.getType() == Material.LAPIS_ORE){
										if(omp.getUHCPlayer().isBlueGold() && new Random().nextBoolean()){
											b.getWorld().dropItem(b.getLocation().add(0.5, 0, 0.5), new ItemStack(Material.GOLD_ORE));
										}
									}
									else if(b.getType() == Material.GLOWING_REDSTONE_ORE){
										if(omp.getUHCPlayer().isRedGold() && new Random().nextBoolean()){
											b.getWorld().dropItem(b.getLocation().add(0.5, 0, 0.5), new ItemStack(Material.GOLD_ORE));
										}
									}
									else{}
								}
							}
							else if(arena.getType() == MiniGameType.SKYWARS){
								if(arena.getState() != GameState.IN_GAME){
									e.setCancelled(true);
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
			omp.notLoaded();
			e.setCancelled(true);
		}
	}
}
