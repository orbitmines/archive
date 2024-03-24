package me.O_o_Fadi_o_O.MiniGames.events;

import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.utils.State;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ProjectileHit implements Listener{
	
	Start plugin;
	 
	public ProjectileHit(Start instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onHit(ProjectileHitEvent e){

		if(Start.state != State.LOBBY){
			Projectile proj = e.getEntity();
			if((proj instanceof Egg)){
				Egg egg = (Egg) proj;
				
				egg.getWorld().createExplosion(egg.getLocation().getX(), egg.getLocation().getY(), egg.getLocation().getZ(), 1.1F, false, false);
				
				proj.remove();
			}
		}
		Projectile proj = e.getEntity();
		if((proj instanceof Snowball)){
			Snowball ball = (Snowball)proj;
			
			if(Start.Paintballs.contains(ball)){
				
				World w = ball.getWorld();
				
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
				
				final int id1 = l1.getWorld().getBlockAt(l1).getTypeId();
				final byte durability1 = l1.getWorld().getBlockAt(l1).getData();
				
				final int id2 = l2.getWorld().getBlockAt(l2).getTypeId();
				final byte durability2 = l2.getWorld().getBlockAt(l2).getData();
				
				final int id3 = l3.getWorld().getBlockAt(l3).getTypeId();
				final byte durability3 = l3.getWorld().getBlockAt(l3).getData();
				
				final int id4 = l4.getWorld().getBlockAt(l4).getTypeId();
				final byte durability4 = l4.getWorld().getBlockAt(l4).getData();
				
				final int id5 = l5.getWorld().getBlockAt(l5).getTypeId();
				final byte durability5 = l5.getWorld().getBlockAt(l5).getData();
				
				final int id6 = l6.getWorld().getBlockAt(l6).getTypeId();
				final byte durability6 = l6.getWorld().getBlockAt(l6).getData();
				
				final int id7 = l7.getWorld().getBlockAt(l7).getTypeId();
				final byte durability7 = l7.getWorld().getBlockAt(l7).getData();
				
				final int id8 = l8.getWorld().getBlockAt(l8).getTypeId();
				final byte durability8 = l8.getWorld().getBlockAt(l8).getData();
				
				final int id9 = l9.getWorld().getBlockAt(l9).getTypeId();
				final byte durability9 = l9.getWorld().getBlockAt(l9).getData();
				
				final int id10 = l10.getWorld().getBlockAt(l10).getTypeId();
				final byte durability10 = l10.getWorld().getBlockAt(l10).getData();
				
				final int id11 = l11.getWorld().getBlockAt(l11).getTypeId();
				final byte durability11 = l11.getWorld().getBlockAt(l11).getData();
				
				final int id12 = l12.getWorld().getBlockAt(l12).getTypeId();
				final byte durability12 = l12.getWorld().getBlockAt(l12).getData();
				
				final int id13 = l13.getWorld().getBlockAt(l13).getTypeId();
				final byte durability13 = l13.getWorld().getBlockAt(l13).getData();
				
				final int id14 = l14.getWorld().getBlockAt(l14).getTypeId();
				final byte durability14 = l14.getWorld().getBlockAt(l14).getData();
				
				final int id15 = l15.getWorld().getBlockAt(l15).getTypeId();
				final byte durability15 = l15.getWorld().getBlockAt(l15).getData();
				
				final int id16 = l16.getWorld().getBlockAt(l16).getTypeId();
				final byte durability16 = l16.getWorld().getBlockAt(l16).getData();
				
				final int id17 = l17.getWorld().getBlockAt(l17).getTypeId();
				final byte durability17 = l17.getWorld().getBlockAt(l17).getData();
				
				final int id18 = l18.getWorld().getBlockAt(l18).getTypeId();
				final byte durability18 = l18.getWorld().getBlockAt(l18).getData();
				
				final int id19 = l19.getWorld().getBlockAt(l19).getTypeId();
				final byte durability19 = l19.getWorld().getBlockAt(l19).getData();
				
				final int id20 = l20.getWorld().getBlockAt(l20).getTypeId();
				final byte durability20 = l20.getWorld().getBlockAt(l20).getData();
				
				final int id21 = l21.getWorld().getBlockAt(l21).getTypeId();
				final byte durability21 = l21.getWorld().getBlockAt(l21).getData();
				
				final int id22 = l22.getWorld().getBlockAt(l22).getTypeId();
				final byte durability22 = l22.getWorld().getBlockAt(l22).getData();
				
				final int id23 = l23.getWorld().getBlockAt(l23).getTypeId();
				final byte durability23 = l23.getWorld().getBlockAt(l23).getData();
				
				final int id24 = l24.getWorld().getBlockAt(l24).getTypeId();
				final byte durability24 = l24.getWorld().getBlockAt(l24).getData();
				
				final int id25 = l25.getWorld().getBlockAt(l25).getTypeId();
				final byte durability25 = l25.getWorld().getBlockAt(l25).getData();
				
				int i = getRandom(0, 15);
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(!w.getBlockAt(l1).isEmpty() && w.getBlockAt(l1).getTypeId() != 31 && w.getBlockAt(l1).getType() != Material.WATER_LILY && w.getBlockAt(l1).getType() != Material.SIGN_POST && w.getBlockAt(l1).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l1, 159, (byte) i);
					}
					if(!w.getBlockAt(l2).isEmpty() && w.getBlockAt(l2).getTypeId() != 31 && w.getBlockAt(l2).getType() != Material.WATER_LILY && w.getBlockAt(l2).getType() != Material.SIGN_POST && w.getBlockAt(l2).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l2, 159, (byte) i);
					}
					if(!w.getBlockAt(l3).isEmpty() && w.getBlockAt(l3).getTypeId() != 31 && w.getBlockAt(l3).getType() != Material.WATER_LILY && w.getBlockAt(l3).getType() != Material.SIGN_POST && w.getBlockAt(l3).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l3, 159, (byte) i);
					}
					if(!w.getBlockAt(l4).isEmpty() && w.getBlockAt(l4).getTypeId() != 31 && w.getBlockAt(l4).getType() != Material.WATER_LILY && w.getBlockAt(l4).getType() != Material.SIGN_POST && w.getBlockAt(l4).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l4, 159, (byte) i);
					}
					if(!w.getBlockAt(l5).isEmpty() && w.getBlockAt(l5).getTypeId() != 31 && w.getBlockAt(l5).getType() != Material.WATER_LILY && w.getBlockAt(l5).getType() != Material.SIGN_POST && w.getBlockAt(l5).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l5, 159, (byte) i);
					}
					if(!w.getBlockAt(l6).isEmpty() && w.getBlockAt(l6).getTypeId() != 31 && w.getBlockAt(l6).getType() != Material.WATER_LILY && w.getBlockAt(l6).getType() != Material.SIGN_POST && w.getBlockAt(l6).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l6, 159, (byte) i);
					}
					if(!w.getBlockAt(l7).isEmpty() && w.getBlockAt(l7).getTypeId() != 31 && w.getBlockAt(l7).getType() != Material.WATER_LILY && w.getBlockAt(l7).getType() != Material.SIGN_POST && w.getBlockAt(l7).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l7, 159, (byte) i);
					}
					if(!w.getBlockAt(l8).isEmpty() && w.getBlockAt(l8).getTypeId() != 31 && w.getBlockAt(l8).getType() != Material.WATER_LILY && w.getBlockAt(l8).getType() != Material.SIGN_POST && w.getBlockAt(l8).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l8, 159, (byte) i);
					}
					if(!w.getBlockAt(l9).isEmpty() && w.getBlockAt(l9).getTypeId() != 31 && w.getBlockAt(l9).getType() != Material.WATER_LILY && w.getBlockAt(l9).getType() != Material.SIGN_POST && w.getBlockAt(l9).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l9, 159, (byte) i);
					}
					if(!w.getBlockAt(l10).isEmpty() && w.getBlockAt(l10).getTypeId() != 31 && w.getBlockAt(l10).getType() != Material.WATER_LILY && w.getBlockAt(l10).getType() != Material.SIGN_POST && w.getBlockAt(l10).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l10, 159, (byte) i);
					}
					if(!w.getBlockAt(l11).isEmpty() && w.getBlockAt(l11).getTypeId() != 31 && w.getBlockAt(l11).getType() != Material.WATER_LILY && w.getBlockAt(l11).getType() != Material.SIGN_POST && w.getBlockAt(l11).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l11, 159, (byte) i);
					}
					if(!w.getBlockAt(l12).isEmpty() && w.getBlockAt(l12).getTypeId() != 31 && w.getBlockAt(l12).getType() != Material.WATER_LILY && w.getBlockAt(l12).getType() != Material.SIGN_POST && w.getBlockAt(l12).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l12, 159, (byte) i);
					}
					if(!w.getBlockAt(l13).isEmpty() && w.getBlockAt(l13).getTypeId() != 31 && w.getBlockAt(l13).getType() != Material.WATER_LILY && w.getBlockAt(l13).getType() != Material.SIGN_POST && w.getBlockAt(l13).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l13, 159, (byte) i);
					}
					if(!w.getBlockAt(l14).isEmpty() && w.getBlockAt(l14).getTypeId() != 31 && w.getBlockAt(l14).getType() != Material.WATER_LILY && w.getBlockAt(l14).getType() != Material.SIGN_POST && w.getBlockAt(l14).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l14, 159, (byte) i);
					}
					if(!w.getBlockAt(l15).isEmpty() && w.getBlockAt(l15).getTypeId() != 31 && w.getBlockAt(l15).getType() != Material.WATER_LILY && w.getBlockAt(l15).getType() != Material.SIGN_POST && w.getBlockAt(l15).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l15, 159, (byte) i);
					}
					if(!w.getBlockAt(l16).isEmpty() && w.getBlockAt(l16).getTypeId() != 31 && w.getBlockAt(l16).getType() != Material.WATER_LILY && w.getBlockAt(l16).getType() != Material.SIGN_POST && w.getBlockAt(l16).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l16, 159, (byte) i);
					}
					if(!w.getBlockAt(l17).isEmpty() && w.getBlockAt(l17).getTypeId() != 31 && w.getBlockAt(l17).getType() != Material.WATER_LILY && w.getBlockAt(l17).getType() != Material.SIGN_POST && w.getBlockAt(l17).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l17, 159, (byte) i);
					}
					if(!w.getBlockAt(l18).isEmpty() && w.getBlockAt(l18).getTypeId() != 31 && w.getBlockAt(l18).getType() != Material.WATER_LILY & w.getBlockAt(l18).getType() != Material.SIGN_POST && w.getBlockAt(l18).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l18, 159, (byte) i);
					}
					if(!w.getBlockAt(l19).isEmpty() && w.getBlockAt(l19).getTypeId() != 31 && w.getBlockAt(l19).getType() != Material.WATER_LILY && w.getBlockAt(l19).getType() != Material.SIGN_POST && w.getBlockAt(l19).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l19, 159, (byte) i);
					}
					if(!w.getBlockAt(l20).isEmpty() && w.getBlockAt(l20).getTypeId() != 31 && w.getBlockAt(l20).getType() != Material.WATER_LILY && w.getBlockAt(l20).getType() != Material.SIGN_POST && w.getBlockAt(l20).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l20, 159, (byte) i);
					}
					if(!w.getBlockAt(l21).isEmpty() && w.getBlockAt(l21).getTypeId() != 31 && w.getBlockAt(l21).getType() != Material.WATER_LILY && w.getBlockAt(l21).getType() != Material.SIGN_POST && w.getBlockAt(l21).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l21, 159, (byte) i);
					}
					if(!w.getBlockAt(l22).isEmpty() && w.getBlockAt(l22).getTypeId() != 31 && w.getBlockAt(l22).getType() != Material.WATER_LILY && w.getBlockAt(l22).getType() != Material.SIGN_POST && w.getBlockAt(l22).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l22, 159, (byte) i);
					}
					if(!w.getBlockAt(l23).isEmpty() && w.getBlockAt(l23).getTypeId() != 31 && w.getBlockAt(l23).getType() != Material.WATER_LILY && w.getBlockAt(l23).getType() != Material.SIGN_POST && w.getBlockAt(l23).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l23, 159, (byte) i);
					}
					if(!w.getBlockAt(l24).isEmpty() && w.getBlockAt(l24).getTypeId() != 31 && w.getBlockAt(l24).getType() != Material.WATER_LILY && w.getBlockAt(l24).getType() != Material.SIGN_POST && w.getBlockAt(l24).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l24, 159, (byte) i);
					}
					if(!w.getBlockAt(l25).isEmpty() && w.getBlockAt(l25).getTypeId() != 31 && w.getBlockAt(l25).getType() != Material.WATER_LILY && w.getBlockAt(l25).getType() != Material.SIGN_POST && w.getBlockAt(l25).getType() != Material.WALL_SIGN){
						p.sendBlockChange(l25, 159, (byte) i);
					}
				}
				
				new BukkitRunnable(){
					
					@Override
					public void run(){
						
						for(Player p : Bukkit.getOnlinePlayers()){
							p.sendBlockChange(l1, id1, durability1);
							p.sendBlockChange(l2, id2, durability2);
							p.sendBlockChange(l3, id3, durability3);
							p.sendBlockChange(l4, id4, durability4);
							p.sendBlockChange(l5, id5, durability5);
							p.sendBlockChange(l6, id6, durability6);
							p.sendBlockChange(l7, id7, durability7);
							p.sendBlockChange(l8, id8, durability8);
							p.sendBlockChange(l9, id9, durability9);
							p.sendBlockChange(l10, id10, durability10);
							p.sendBlockChange(l11, id11, durability11);
							p.sendBlockChange(l12, id12, durability12);
							p.sendBlockChange(l13, id13, durability13);
							p.sendBlockChange(l14, id14, durability14);
							p.sendBlockChange(l15, id15, durability15);
							p.sendBlockChange(l16, id16, durability16);
							p.sendBlockChange(l17, id17, durability17);
							p.sendBlockChange(l18, id18, durability18);
							p.sendBlockChange(l19, id19, durability19);
							p.sendBlockChange(l20, id20, durability20);
							p.sendBlockChange(l21, id21, durability21);
							p.sendBlockChange(l22, id22, durability22);
							p.sendBlockChange(l23, id23, durability23);
							p.sendBlockChange(l24, id24, durability24);
							p.sendBlockChange(l25, id25, durability25);
						}
						
					}
				}.runTaskLater(this.plugin, 10 * 20);
			}
		}
    }
	
    public int getRandom(int lower, int upper){
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }
}
