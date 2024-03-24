package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.KitPvPServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativePlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ProjectileHit implements Listener {
	
	@EventHandler
	@SuppressWarnings("deprecation")
    public void onHit(ProjectileHitEvent e){
		Projectile proj = e.getEntity();
		
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			if(proj instanceof FishHook){
				if(proj.getShooter() instanceof Player){
					Player p = (Player) proj.getShooter();
					ItemStack item = p.getItemInHand();
					
					if(item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null && item.getType() == Material.FISHING_ROD && item.getItemMeta().getDisplayName().equals("§7§nGrappling Hook")){
						Location l1 = proj.getLocation();
						Location l2 = p.getLocation();
						
						p.setVelocity(l1.toVector().subtract(l2.toVector()).multiply(1.1).add(new Vector(0, 0.5, 0)));
						
						proj.remove();
					}
				}
			}
			if(proj instanceof Fireball){
				Fireball b = (Fireball) proj;
				if(ServerStorage.fireballs.contains(b)){
					ServerStorage.fireballs.remove(b);
				}
			}
			if(proj instanceof Egg){
				Egg egg = (Egg) proj;
				if(ServerStorage.eggbombs.contains(egg)){
					ServerStorage.eggbombs.remove(egg);
					egg.getWorld().playEffect(egg.getLocation(), Effect.EXPLOSION_LARGE, 1);
					egg.getWorld().playSound(egg.getLocation(), Sound.EXPLODE, 5, 1);
					egg.remove();
				}
				
				if(ServerData.isServer(Server.MINIGAMES)){
					if(proj.getShooter() instanceof Player){
						Player p = (Player) proj.getShooter();
						OMPlayer omp = OMPlayer.getOMPlayer(p);
						Arena arena = omp.getArena();
						
						if(arena != null && arena.getType() == MiniGameType.CHICKEN_FIGHT && arena.getState() == GameState.IN_GAME){
							egg.getWorld().createExplosion(egg.getLocation().getX(), egg.getLocation().getY(), egg.getLocation().getZ(), 1.1F, false, false);
							proj.remove();
						}
					}
				}
			}
			if(proj instanceof Snowball){
				Snowball ball = (Snowball) proj;
				
				if(ServerStorage.paintballs.contains(ball)){
					final World w = ball.getWorld();
					
					final List<Location> locs = Utils.getPaintballLocations(ball.getLocation());
					
					int i = Utils.getRandom(0, 15);
					
					for(Player p : Bukkit.getOnlinePlayers()){
						for(Location l : locs){
							if(canTransform(w.getBlockAt(l))){
								p.sendBlockChange(l, 159, (byte) i);
							}
						}
					}
					
					new BukkitRunnable(){
						public void run(){
							for(Player p : Bukkit.getOnlinePlayers()){
								for(Location l : locs){
									p.sendBlockChange(l, w.getBlockAt(l).getType(), w.getBlockAt(l).getData());
								}
							}
							
						}
					}.runTaskLater(Start.getInstance(), 200);
				}
			}
		}
		else if(ServerData.isServer(Server.KITPVP)){
			final KitPvPServer kitpvp = ServerData.getKitPvP();
			
			if(kitpvp.isProjectile(proj)){
				switch(kitpvp.getProjectileType(proj)){
					case PAINTBALLS_I:
						final List<Location> locs = Utils.getPaintballLocations(proj.getLocation());
						int color = 14;
						if(proj.getCustomName().endsWith("Red §8|| §bWeapon§f")){
							color = 14;
						}
						else if(proj.getCustomName().endsWith("Blue §8|| §bWeapon§f")){
							color = 3;
						}
						else if(proj.getCustomName().endsWith("Black §8|| §bWeapon§f")){
							color = 15;
						}
						else if(proj.getCustomName().endsWith("Gray §8|| §bWeapon§f")){
							color = 8;
						}
						else if(proj.getCustomName().endsWith("Green §8|| §bWeapon§f")){
							color = 5;
						}
						else{}
					
						for(Location l : locs){
							for(Player p : Bukkit.getOnlinePlayers()){
								Block b = l.getWorld().getBlockAt(l);
								if(canTransform(b)){
									p.sendBlockChange(l, Material.WOOL, (byte) color);
									kitpvp.getPaintballBlocks().put(b, color);
									kitpvp.getPaintballBlockPlayers().put(b, (Player) proj.getShooter());
								}
							}
						}
						
						new BukkitRunnable(){
							public void run(){
								for(Location l : locs){
									Block b = l.getWorld().getBlockAt(l);
									for(Player p : Bukkit.getOnlinePlayers()){
										p.sendBlockChange(l, b.getType(), b.getData());
										kitpvp.getPaintballBlocks().remove(b);
										kitpvp.getPaintballBlockPlayers().remove(b);
									}
								}
							}
						}.runTaskLater(Start.getInstance(), 40);
						
						kitpvp.removeProjectile(proj);
						proj.remove();
						break;
					default:
						break;
				}
			}
			
			if(proj instanceof Arrow){
				proj.remove();
			}
		}
		else if(ServerData.isServer(Server.CREATIVE)){
			if(proj instanceof Arrow && proj.getShooter() instanceof Player){
				Player p = (Player) proj.getShooter();
				OMPlayer omp = OMPlayer.getOMPlayer(p);
				CreativePlayer cp = omp.getCreativePlayer();
				
				if(cp.isInPvPPlot() && !cp.getPvPPlot().hasPvPArrows()){
					proj.remove();
				}
			}
		}
		else{}
    }
	
	@SuppressWarnings("deprecation")
	private boolean canTransform(Block b){
		if(!b.isEmpty() && b.getTypeId() != 31 && b.getTypeId() != 37 && b.getTypeId() != 38 && b.getTypeId() != 175 && b.getType() != Material.WOOD_STEP && b.getType() != Material.WOOD_STAIRS && b.getType() != Material.COBBLESTONE_STAIRS && b.getType() != Material.TRAP_DOOR && b.getType() != Material.IRON_TRAPDOOR && b.getType() != Material.SKULL && b.getType() != Material.WATER_LILY && b.getType() != Material.SIGN_POST && b.getType() != Material.WALL_SIGN && b.getType() != Material.TORCH && b.getType() != Material.FENCE && b.getType() != Material.WATER && b.getType() != Material.STATIONARY_WATER){
			return true;
		}
		else{
			return false;
		}
	}
}
