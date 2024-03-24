package me.O_o_Fadi_o_O.Creative.events;

import me.O_o_Fadi_o_O.Creative.Start;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplodeEvent implements Listener{
	
	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void EntityExplodeEvent(ExplosionPrimeEvent e) {
		e.setFire(false);
		
        if(e.getEntity() instanceof TNTPrimed){
        	e.setCancelled(true);
        	for(Player player : Bukkit.getOnlinePlayers()){
        		if(player.getWorld().getName().equals(e.getEntity().getWorld().getName())){
        			Location l = e.getEntity().getLocation();
        			player.playSound(l, Sound.EXPLODE, 5, 1);
        			try{
        				((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
        					EnumParticle.EXPLOSION_HUGE, true, (float) l.getX(), (float) l.getY(), (float) l.getZ(), 0, 0, 0, 4, 1, null));
        			}catch(Exception ex){}
        		}
        	}
        }
	}
}
