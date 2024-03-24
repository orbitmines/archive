package me.O_o_Fadi_o_O.MiniGames.events;

import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ProjectileHit implements Listener{
	
	Start start = Start.getInstance();
	
	@EventHandler
	@SuppressWarnings("deprecation")
    public void onHit(ProjectileHitEvent e){

		Projectile proj = e.getEntity();
		if(proj instanceof Fireball){
			Fireball b = (Fireball) proj;
			if(StorageManager.fireballs.contains(b)){
				StorageManager.fireballs.remove(b);
			}
		}
		if(proj instanceof Egg){
			Egg egg = (Egg) proj;
			if(StorageManager.eggbombs.contains(egg)){
				StorageManager.eggbombs.remove(egg);
				egg.getWorld().playEffect(egg.getLocation(), Effect.EXPLOSION_LARGE, 1);
				egg.getWorld().playSound(egg.getLocation(), Sound.EXPLODE, 5, 1);
				egg.remove();
			}
		}
		if(proj instanceof Snowball){
			Snowball ball = (Snowball)proj;
			
			if(StorageManager.paintballs.contains(ball)){
				
				final World w = ball.getWorld();
				
				final Location l1 = ball.getLocation().subtract(0, 1, 0);
				final Location l2 = ball.getLocation().subtract(0, 1, 0).add(0, 1, 0);
				final Location l3 = ball.getLocation().subtract(0, 1, 0).add(1, 0, 0);
				final Location l4 = ball.getLocation().subtract(0, 1, 0).add(0, 0, 1);
				final Location l5 = ball.getLocation().subtract(0, 1, 0).subtract(1, 0, 0);
				final Location l6 = ball.getLocation().subtract(0, 1, 0).subtract(0, 1, 0);
				final Location l7 = ball.getLocation().subtract(0, 1, 0).subtract(0, 0, 1);
				
				final Location l8 = ball.getLocation().subtract(0, 1, 0).add(0, 2, 0);
				final Location l9 = ball.getLocation().subtract(0, 1, 0).add(0, 1, 0).add(1, 0, 0);
				final Location l10 = ball.getLocation().subtract(0, 1, 0).add(0, 1, 0).subtract(1, 0, 0);
				final Location l11 = ball.getLocation().subtract(0, 1, 0).add(0, 1, 0).add(0, 0, 1);
				final Location l12 = ball.getLocation().subtract(0, 1, 0).add(0, 1, 0).subtract(0, 0, 1);
				final Location l13 = ball.getLocation().subtract(0, 1, 0).add(2, 0, 0);
				final Location l14 = ball.getLocation().subtract(0, 1, 0).add(0, 0, 2);
				final Location l15 = ball.getLocation().subtract(0, 1, 0).subtract(2, 0, 0);
				final Location l16 = ball.getLocation().subtract(0, 1, 0).subtract(0, 0, 2);
				final Location l17 = ball.getLocation().subtract(0, 1, 0).add(1, 0, 0).add(0, 0, 1);
				final Location l18 = ball.getLocation().subtract(0, 1, 0).add(1, 0, 0).subtract(0, 0, 1);
				final Location l19 = ball.getLocation().subtract(0, 1, 0).add(0, 0, 1).subtract(1, 0, 0);
				final Location l20 = ball.getLocation().subtract(0, 1, 0).subtract(0, 0, 1).subtract(1, 0, 0);
				
				final Location l21 = ball.getLocation().subtract(0, 1, 0).subtract(0, 2, 0);
				final Location l22 = ball.getLocation().subtract(0, 1, 0).subtract(0, 1, 0).add(1, 0, 0);
				final Location l23 = ball.getLocation().subtract(0, 1, 0).subtract(0, 1, 0).subtract(1, 0, 0);
				final Location l24 = ball.getLocation().subtract(0, 1, 0).subtract(0, 1, 0).add(0, 0, 1);
				final Location l25 = ball.getLocation().subtract(0, 1, 0).subtract(0, 1, 0).subtract(0, 0, 1);
				
				int i = getRandom(0, 15);
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(canTransform(w.getBlockAt(l1))){
						p.sendBlockChange(l1, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l2))){
						p.sendBlockChange(l2, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l3))){
						p.sendBlockChange(l3, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l4))){
						p.sendBlockChange(l4, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l5))){
						p.sendBlockChange(l5, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l6))){
						p.sendBlockChange(l6, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l7))){
						p.sendBlockChange(l7, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l8))){
						p.sendBlockChange(l8, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l9))){
						p.sendBlockChange(l9, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l10))){
						p.sendBlockChange(l10, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l11))){
						p.sendBlockChange(l11, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l12))){
						p.sendBlockChange(l12, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l13))){
						p.sendBlockChange(l13, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l14))){
						p.sendBlockChange(l14, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l15))){
						p.sendBlockChange(l15, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l16))){
						p.sendBlockChange(l16, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l17))){
						p.sendBlockChange(l17, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l18))){
						p.sendBlockChange(l18, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l19))){
						p.sendBlockChange(l19, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l20))){
						p.sendBlockChange(l20, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l21))){
						p.sendBlockChange(l21, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l22))){
						p.sendBlockChange(l22, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l23))){
						p.sendBlockChange(l23, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l24))){
						p.sendBlockChange(l24, 159, (byte) i);
					}
					if(canTransform(w.getBlockAt(l25))){
						p.sendBlockChange(l25, 159, (byte) i);
					}
				}
				
				new BukkitRunnable(){
					
					@Override
					public void run(){
						
						for(Player p : Bukkit.getOnlinePlayers()){
							p.sendBlockChange(l1, w.getBlockAt(l1).getType(), w.getBlockAt(l1).getData());
							p.sendBlockChange(l2, w.getBlockAt(l2).getType(), w.getBlockAt(l2).getData());
							p.sendBlockChange(l3, w.getBlockAt(l3).getType(), w.getBlockAt(l3).getData());
							p.sendBlockChange(l4, w.getBlockAt(l4).getType(), w.getBlockAt(l4).getData());
							p.sendBlockChange(l5, w.getBlockAt(l5).getType(), w.getBlockAt(l5).getData());
							p.sendBlockChange(l6, w.getBlockAt(l6).getType(), w.getBlockAt(l6).getData());
							p.sendBlockChange(l7, w.getBlockAt(l7).getType(), w.getBlockAt(l7).getData());
							p.sendBlockChange(l8, w.getBlockAt(l8).getType(), w.getBlockAt(l8).getData());
							p.sendBlockChange(l9, w.getBlockAt(l9).getType(), w.getBlockAt(l9).getData());
							p.sendBlockChange(l10, w.getBlockAt(l10).getType(), w.getBlockAt(l10).getData());
							p.sendBlockChange(l11, w.getBlockAt(l11).getType(), w.getBlockAt(l11).getData());
							p.sendBlockChange(l12, w.getBlockAt(l12).getType(), w.getBlockAt(l12).getData());
							p.sendBlockChange(l13, w.getBlockAt(l13).getType(), w.getBlockAt(l13).getData());
							p.sendBlockChange(l14, w.getBlockAt(l14).getType(), w.getBlockAt(l14).getData());
							p.sendBlockChange(l15, w.getBlockAt(l15).getType(), w.getBlockAt(l15).getData());
							p.sendBlockChange(l16, w.getBlockAt(l16).getType(), w.getBlockAt(l16).getData());
							p.sendBlockChange(l17, w.getBlockAt(l17).getType(), w.getBlockAt(l17).getData());
							p.sendBlockChange(l18, w.getBlockAt(l18).getType(), w.getBlockAt(l18).getData());
							p.sendBlockChange(l19, w.getBlockAt(l19).getType(), w.getBlockAt(l19).getData());
							p.sendBlockChange(l20, w.getBlockAt(l20).getType(), w.getBlockAt(l20).getData());
							p.sendBlockChange(l21, w.getBlockAt(l21).getType(), w.getBlockAt(l21).getData());
							p.sendBlockChange(l22, w.getBlockAt(l22).getType(), w.getBlockAt(l22).getData());
							p.sendBlockChange(l23, w.getBlockAt(l23).getType(), w.getBlockAt(l23).getData());
							p.sendBlockChange(l24, w.getBlockAt(l24).getType(), w.getBlockAt(l24).getData());
							p.sendBlockChange(l25, w.getBlockAt(l25).getType(), w.getBlockAt(l25).getData());
						}
						
					}
				}.runTaskLater(this.start, 10 * 20);
			}
		}
    }
	
	@SuppressWarnings("deprecation")
	private boolean canTransform(Block b){
		if(!b.isEmpty() && b.getTypeId() != 31 && b.getTypeId() != 175 && b.getType() != Material.WOOD_STEP && b.getType() != Material.WOOD_STAIRS && b.getType() != Material.COBBLESTONE_STAIRS && b.getType() != Material.TRAP_DOOR && b.getType() != Material.IRON_TRAPDOOR && b.getType() != Material.SKULL && b.getType() != Material.WATER_LILY && b.getType() != Material.SIGN_POST && b.getType() != Material.WALL_SIGN && b.getType() != Material.TORCH && b.getType() != Material.FENCE){
			return true;
		}
		else{
			return false;
		}
	}
	
    public int getRandom(int lower, int upper){
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }
}
