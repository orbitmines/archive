package me.O_o_Fadi_o_O.OrbitMines.events;

import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Particle;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import net.minecraft.server.v1_8_R3.EnumParticle;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.util.Vector;

public class ExplodeEvent implements Listener{
	
	@EventHandler
    public void EntityExplodeEvent(ExplosionPrimeEvent e){
		if(ServerData.isServer(Server.HUB, Server.MINIGAMES)){
			e.setFire(false);
			
	        if(e.getEntity() instanceof Creeper){
	        	if(ServerStorage.creeperlaunched.contains(e.getEntity())){
		        	for(Entity en : e.getEntity().getNearbyEntities(3, 3, 3)){
		        		if(NPC.getNPC(en) != null){
		        			e.setRadius(0);
		        		}
		        		
		        		if(en instanceof Player){
		        			Player p = (Player) en;
		        			OMPlayer omp = OMPlayer.getOMPlayer(p);
		        			if(!omp.isInLapisParkour()){
		        				Vector v = p.getLocation().getDirection();
		        				p.setVelocity(v.multiply(-1).add(new Vector(0, 1.3, 0)));
		        			}	
		        		}
	        		}
	        	}
	        }
		}
		else if(ServerData.isServer(Server.CREATIVE)){
			e.setFire(false);
			
			if(e.getEntity() instanceof TNTPrimed){
				e.setCancelled(true);
				
				for(Player player : Bukkit.getOnlinePlayers()){
					player.playSound(e.getEntity().getLocation(), Sound.EXPLODE, 5, 1);
					
					Particle p = new Particle(EnumParticle.EXPLOSION_HUGE, e.getEntity().getLocation());
					p.setAmount(4);
					p.send(Bukkit.getOnlinePlayers());
				}
			}
		}
		else{}
	}
	
	@EventHandler
	public void EntityExplodeEvent(EntityExplodeEvent e){
		if(ServerData.isServer(Server.HUB, Server.KITPVP, Server.MINIGAMES)){
			if(!ServerData.isServer(Server.MINIGAMES) || e.getEntity().getWorld().getName().equals(ServerData.getMiniGames().getLobbyWorld().getName())){
				e.blockList().clear();
			}
		}
	}
}
