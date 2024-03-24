package me.O_o_Fadi_o_O.Prison.runnables;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.MathUtils;
import me.O_o_Fadi_o_O.Prison.utils.VectorUtils;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ChestRunnable {

	Start start = Start.getInstance();
	
	public int i = 0;
	
	public void startChestRunnable(){
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				for(Block c : StorageManager.rarechests){
				
					final Location l = c.getLocation();
							
					if(i == 64){
						i = 1;
					}
					
				    double angle = (i/2) * (Math.PI / 16) + 0.0;
		            float radius = 20 * 0.02F;
		            Vector v = new Vector(Math.cos(angle) * radius, 0, Math.sin(angle) * radius);
		            VectorUtils.rotateAroundAxisY(v, -l.getYaw() * MathUtils.degreesToRadians);
		            
		            l.add(v);

		            try{
		            	for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
							EnumParticle.REDSTONE, true, (float) (l.getX() + 0.5), (float) (l.getY() +1), (float) (l.getZ() +0.5), 0, 0, 0, 0, 1, null));
						}
		            }catch(Exception ex){ex.printStackTrace();}
		            
		            l.subtract(v);
				}
				
				i++;
			}
		}.runTaskTimer(this.start, 0, 1 /10);
		
	}
}
