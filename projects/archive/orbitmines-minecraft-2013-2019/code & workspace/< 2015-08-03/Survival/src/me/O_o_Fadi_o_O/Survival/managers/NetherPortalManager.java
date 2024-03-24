package me.O_o_Fadi_o_O.Survival.managers;

import java.util.HashMap;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NetherPortalManager {

	Start start = Start.getInstance();
	
	public static HashMap<Player, Integer> timeinportal = new HashMap<Player, Integer>();
	
	public void startNetherPortalRunnable(){
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				for(Player p : Bukkit.getOnlinePlayers()){
					if(p.getWorld().getName().equals("SurvivalWorld2")){
						if(p.getLocation().getBlock().getType() == Material.PORTAL){
							if(timeinportal.containsKey(p)){
								timeinportal.put(p, timeinportal.get(p) +1);
								if(timeinportal.get(p) == 10){
									Location l1 = p.getLocation();
									Location l2 = new Location(Bukkit.getWorld("SurvivalWorld2_nether"), l1.getX() / 8, l1.getY() / 2, l1.getZ() / 8);
									
									Location l3 = new Location(l2.getWorld(), l2.getX() -5, l2.getY() -5, l2.getZ() -5);
									Location l4 = new Location(l2.getWorld(), l2.getX() +5, l2.getY() +5, l2.getZ() +5);
									
									Block b = getFirstPortalBlockBetween(l3, l4);
									
									if(b == null){
										Location newl = generateNetherPortal(l2, p.getLocation().getBlock().getData());
										p.teleport(newl);
										teleportAgain(p, newl);
										timeinportal.remove(p);
									}
									else{
										p.teleport(b.getLocation().add(0.5, 0, 0.5));
										teleportAgain(p, b.getLocation().add(0.5, 0, 0.5));
										timeinportal.remove(p);
									}
								}
							}
							else{
								timeinportal.put(p, 0);
							}
						}
						else{
							if(timeinportal.containsKey(p)){
								timeinportal.remove(p);
							}
						}
					}
					if(p.getWorld().getName().equals("SurvivalWorld2_nether")){
						if(p.getLocation().getBlock().getType() == Material.PORTAL){
							if(timeinportal.containsKey(p)){
								timeinportal.put(p, timeinportal.get(p) +1);
								if(timeinportal.get(p) == 10){
									Location l1 = p.getLocation();
									Location l2 = new Location(Bukkit.getWorld("SurvivalWorld2"), l1.getX() * 8, l1.getY() * 2, l1.getZ() * 8);
									
									Location l3 = new Location(l2.getWorld(), l2.getX() -10, l2.getY() -10, l2.getZ() -10);
									Location l4 = new Location(l2.getWorld(), l2.getX() +10, l2.getY() +10, l2.getZ() +10);
									
									Block b = getFirstPortalBlockBetween(l3, l4);
									
									if(b == null){
										Location newl = generateNetherPortal(l2, p.getLocation().getBlock().getData());
										p.teleport(newl);
										teleportAgain(p, newl);
										timeinportal.remove(p);
									}
									else{
										p.teleport(b.getLocation().add(0.5, 0, 0.5));
										teleportAgain(p, b.getLocation().add(0.5, 0, 0.5));
										timeinportal.remove(p);
									}
								}
							}
							else{
								timeinportal.put(p, 0);
							}
						}
						else{
							if(timeinportal.containsKey(p)){
								timeinportal.remove(p);
							}
						}
					}
				}
			}
		}.runTaskTimer(this.start, 0, 10);
	}
	
	public void teleportAgain(final Player p, final Location l){
		new BukkitRunnable(){
			public void run(){
				p.teleport(l);
			}
		}.runTaskLater(this.start, 10);
	}
	
	public Location generateNetherPortal(Location l, int portaldata){
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		if(portaldata == 1){
			Location l1 = new Location(w, x +1, y -1, z +0); l1.getBlock().setType(Material.OBSIDIAN);
			Location l2 = new Location(w, x +1, y +0, z +0); l2.getBlock().setType(Material.OBSIDIAN);
			Location l3 = new Location(w, x +1, y +1, z +0); l3.getBlock().setType(Material.OBSIDIAN);
			Location l4 = new Location(w, x +1, y +2, z +0); l4.getBlock().setType(Material.OBSIDIAN);
			Location l5 = new Location(w, x +1, y +3, z +0); l5.getBlock().setType(Material.OBSIDIAN);
			Location l6 = new Location(w, x -2, y -1, z +0); l6.getBlock().setType(Material.OBSIDIAN);
			Location l7 = new Location(w, x -2, y +0, z +0); l7.getBlock().setType(Material.OBSIDIAN);
			Location l8 = new Location(w, x -2, y +1, z +0); l8.getBlock().setType(Material.OBSIDIAN);
			Location l9 = new Location(w, x -2, y +2, z +0); l9.getBlock().setType(Material.OBSIDIAN);
			Location l10 = new Location(w, x -2, y +3, z +0); l10.getBlock().setType(Material.OBSIDIAN);
			Location l11 = new Location(w, x +0, y -1, z +0); l11.getBlock().setType(Material.OBSIDIAN);
			Location l12 = new Location(w, x -1, y -1, z +0); l12.getBlock().setType(Material.OBSIDIAN);
			Location l13 = new Location(w, x +0, y +3, z +0); l13.getBlock().setType(Material.OBSIDIAN);
			Location l14 = new Location(w, x -1, y +3, z +0); l14.getBlock().setType(Material.OBSIDIAN);
			
			Location l33 = new Location(w, x +0, y +0, z +0); l33.getBlock().setType(Material.AIR);
			Location l34 = new Location(w, x +0, y +1, z +0); l34.getBlock().setType(Material.AIR);
			Location l35 = new Location(w, x +0, y +2, z +0); l35.getBlock().setType(Material.AIR);	
			Location l36 = new Location(w, x -1, y +0, z +0); l36.getBlock().setType(Material.AIR);
			Location l37 = new Location(w, x -1, y +1, z +0); l37.getBlock().setType(Material.AIR);
			Location l38 = new Location(w, x -1, y +2, z +0); l38.getBlock().setType(Material.AIR);
			
			Location l15 = new Location(w, x +0, y +0, z +0); l15.getBlock().setType(Material.FIRE);
			
			if(w.getName().equals("SurvivalWorld2_nether")){
				Location l21 = new Location(w, x +0, y +0, z +1); l21.getBlock().setType(Material.AIR);
				Location l22 = new Location(w, x +0, y +1, z +1); l22.getBlock().setType(Material.AIR);
				Location l23 = new Location(w, x +0, y +2, z +1); l23.getBlock().setType(Material.AIR);	
				Location l24 = new Location(w, x -1, y +0, z +1); l24.getBlock().setType(Material.AIR);
				Location l25 = new Location(w, x -1, y +1, z +1); l25.getBlock().setType(Material.AIR);
				Location l26 = new Location(w, x -1, y +2, z +1); l26.getBlock().setType(Material.AIR);
				
				Location l27 = new Location(w, x +0, y +0, z -1); l27.getBlock().setType(Material.AIR);
				Location l28 = new Location(w, x +0, y +1, z -1); l28.getBlock().setType(Material.AIR);
				Location l29 = new Location(w, x +0, y +2, z -1); l29.getBlock().setType(Material.AIR);	
				Location l30 = new Location(w, x -1, y +0, z -1); l30.getBlock().setType(Material.AIR);
				Location l31 = new Location(w, x -1, y +1, z -1); l31.getBlock().setType(Material.AIR);
				Location l32 = new Location(w, x -1, y +2, z -1); l32.getBlock().setType(Material.AIR);
			}
		}
		if(portaldata == 2){
			Location l1 = new Location(w, x +0, y -1, z +1); l1.getBlock().setType(Material.OBSIDIAN);
			Location l2 = new Location(w, x +0, y +0, z +1); l2.getBlock().setType(Material.OBSIDIAN);
			Location l3 = new Location(w, x +0, y +1, z +1); l3.getBlock().setType(Material.OBSIDIAN);
			Location l4 = new Location(w, x +0, y +2, z +1); l4.getBlock().setType(Material.OBSIDIAN);
			Location l5 = new Location(w, x +0, y +3, z +1); l5.getBlock().setType(Material.OBSIDIAN);
			Location l6 = new Location(w, x +0, y -1, z -2); l6.getBlock().setType(Material.OBSIDIAN);
			Location l7 = new Location(w, x +0, y +0, z -2); l7.getBlock().setType(Material.OBSIDIAN);
			Location l8 = new Location(w, x +0, y +1, z -2); l8.getBlock().setType(Material.OBSIDIAN);
			Location l9 = new Location(w, x +0, y +2, z -2); l9.getBlock().setType(Material.OBSIDIAN);
			Location l10 = new Location(w, x +0, y +3, z -2); l10.getBlock().setType(Material.OBSIDIAN);
			Location l11 = new Location(w, x +0, y -1, z +0); l11.getBlock().setType(Material.OBSIDIAN);
			Location l12 = new Location(w, x +0, y -1, z -1); l12.getBlock().setType(Material.OBSIDIAN);
			Location l13 = new Location(w, x +0, y +3, z +0); l13.getBlock().setType(Material.OBSIDIAN);
			Location l14 = new Location(w, x +0, y +3, z -1); l14.getBlock().setType(Material.OBSIDIAN);
			
			Location l33 = new Location(w, x +0, y +0, z +0); l33.getBlock().setType(Material.AIR);
			Location l34 = new Location(w, x +0, y +1, z +0); l34.getBlock().setType(Material.AIR);
			Location l35 = new Location(w, x +0, y +2, z +0); l35.getBlock().setType(Material.AIR);	
			Location l36 = new Location(w, x +0, y +0, z -1); l36.getBlock().setType(Material.AIR);
			Location l37 = new Location(w, x +0, y +1, z -1); l37.getBlock().setType(Material.AIR);
			Location l38 = new Location(w, x +0, y +2, z -1); l38.getBlock().setType(Material.AIR);
			
			Location l15 = new Location(w, x +0, y +0, z -1); l15.getBlock().setType(Material.FIRE);
			
			if(w.getName().equals("SurvivalWorld2_nether")){
				Location l21 = new Location(w, x +1, y +0, z +0); l21.getBlock().setType(Material.AIR);
				Location l22 = new Location(w, x +1, y +1, z +0); l22.getBlock().setType(Material.AIR);
				Location l23 = new Location(w, x +1, y +2, z +0); l23.getBlock().setType(Material.AIR);	
				Location l24 = new Location(w, x +1, y +0, z -1); l24.getBlock().setType(Material.AIR);
				Location l25 = new Location(w, x +1, y +1, z -1); l25.getBlock().setType(Material.AIR);
				Location l26 = new Location(w, x +1, y +2, z -1); l26.getBlock().setType(Material.AIR);
				
				Location l27 = new Location(w, x -1, y +0, z +0); l27.getBlock().setType(Material.AIR);
				Location l28 = new Location(w, x -1, y +1, z +0); l28.getBlock().setType(Material.AIR);
				Location l29 = new Location(w, x -1, y +2, z +0); l29.getBlock().setType(Material.AIR);	
				Location l30 = new Location(w, x -1, y +0, z -1); l30.getBlock().setType(Material.AIR);
				Location l31 = new Location(w, x -1, y +1, z -1); l31.getBlock().setType(Material.AIR);
				Location l32 = new Location(w, x -1, y +2, z -1); l32.getBlock().setType(Material.AIR);
			}
		}
		
		return new Location(w, x, y, z);
	}
	
    public Block getFirstPortalBlockBetween(Location l1, Location l2){
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++) {
            for(int z = bottomBlockZ; z <= topBlockZ; z++){
                for(int y = bottomBlockY; y <= topBlockY; y++){
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    if(block.getType() == Material.PORTAL){
                    	return block;
                    }
                }
            }
        }
       
        return null;
    }
}
