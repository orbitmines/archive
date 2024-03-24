package me.O_o_Fadi_o_O.Prison.runnables;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.MathUtils;
import me.O_o_Fadi_o_O.Prison.utils.VectorUtils;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ChestRunnable {

	Start plugin;
	 
	public ChestRunnable(Start instance) {
		plugin = instance;
	}
	
	public int i = 0;
	
	public void startChestRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				for(Block c : StorageManager.rareChests){
				
					final Location l = c.getLocation();
							
					if(i == 64){
						i = 1;
					}
					
				    double angle = (i/2) * (Math.PI / 16) + 0.0;
		            float radius = 20 * 0.02F;
		            Vector v = new Vector(Math.cos(angle) * radius, 0, Math.sin(angle) * radius);
		            VectorUtils.rotateAroundAxisY(v, -l.getYaw() * MathUtils.degreesToRadians);
		            
		            l.add(v);

		            for(Player player : Bukkit.getOnlinePlayers()){
		    			((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
				                "reddust",
				                (float) ((float) l.getX() + 0.5),
				                (float) l.getY() +1, 
				                (float) ((float) l.getZ() + 0.5), 
				                0, 0, 0,(float) 0, 0));
		            }	
		            
		            l.subtract(v);
		            
		            
		            final Location l2 = c.getLocation();
		            for(Player player : Bukkit.getOnlinePlayers()){
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 0);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 1);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 2);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 3);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 4);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 5);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 6);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 7);
		    			player.playEffect(new Location(l2.getWorld(), l2.getX(), l2.getY(), l2.getZ()), Effect.SMOKE, 8);
		            }
				}
				
				i++;
			}
		}.runTaskTimer(this.plugin, 0, 1 /10);
		
	}
}
