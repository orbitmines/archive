package me.O_o_Fadi_o_O.OrbitMines.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPMap;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockChangeEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChange(final EntityChangeBlockEvent e){
		Entity en = e.getEntity();
		
		if(en instanceof FallingBlock){
			FallingBlock b = (FallingBlock) en;
			
			if(b.getMaterial() == Material.WEB || b.getMaterial() == Material.FIRE){
				int delay = 100;
				if(ServerData.isServer(Server.HUB, Server.MINIGAMES) && b.getMaterial() == Material.FIRE){
					delay = 40;
				}
				
				new BukkitRunnable(){
					public void run(){
						e.getBlock().setType(Material.AIR);
					}
				}.runTaskLater(Start.getInstance(), delay);
			}
			else if(b.getMaterial() == Material.ICE && ServerData.isServer(Server.KITPVP)){
				e.setCancelled(true);
			}
			else if(ServerData.isServer(Server.KITPVP) && b.getCustomName() != null && b.getCustomName().equals("BlockExplosion")){
				e.setCancelled(true);
				
				for(Entity ent : en.getNearbyEntities(3, 3, 3)){
					if(ent instanceof Player){
						OMPlayer omp = OMPlayer.getOMPlayer((Player) ent);
						omp.addPotionEffect(PotionEffectType.BLINDNESS, 10, 0);
						omp.addPotionEffect(PotionEffectType.SLOW, 10, 5);
					}
				}
				KitPvPMap map = ServerData.getKitPvP().getCurrentMap();
				List<Material> materials = new ArrayList<Material>();
				if(map.getMapName().equals("Snow Town")){
					materials.add(Material.SNOW_BLOCK);
					materials.add(Material.PACKED_ICE);
				}
				else if(map.getMapName().equals("Mountain Village")){
					materials.add(Material.GRASS);
					materials.add(Material.DIRT);
					materials.add(Material.GRAVEL);
				}
				else if(map.getMapName().equals("Desert")){
					materials.add(Material.SAND);
					materials.add(Material.CACTUS);
				}
				else{}
				
				for(int i = 0; i <= 25; i++){
			        FallingBlock fb = en.getWorld().spawnFallingBlock(en.getLocation(), materials.get(new Random().nextInt(materials.size())), (byte) 0);
		            fb.setDropItem(false);
		            fb.setVelocity(Utils.getRandomVelocity().multiply(2));
				}
			}
			else{
				en.remove();
				e.setCancelled(true);
			}
		}
	}
}
