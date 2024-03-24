package me.O_o_Fadi_o_O.OrbitMines.utils.skyblock;

import java.io.File;
import java.io.IOException;

import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.world.DataException;

@SuppressWarnings("deprecation")
public class SkyBlockUtils {

	public static Location getNextLocation(World w){
		if(ServerData.getSkyBlock().getTotalIslands() == 0){
			return new Location(w, 0, 100, 0);
		}
		
		Location lastl = ServerData.getSkyBlock().getLastLocation();
		
		final int x = (int) lastl.getX();
		final int z = (int) lastl.getZ();
		final Location nextl = lastl;
		if(x < z){
			if(-1 * x < z){
				nextl.setX(nextl.getX() + 130);
				return nextl;
			}
			nextl.setZ(nextl.getZ() + 130);
			return nextl;
		}
		if(x > z){
			if(-1 * x >= z){
				nextl.setX(nextl.getX() - 130);
				return nextl;
			}
			nextl.setZ(nextl.getZ() - 130);
			return nextl;
		}
		if(x <= 0){
			nextl.setZ(nextl.getZ() + 130);
			return nextl;
		}
		nextl.setZ(nextl.getZ() - 130);
		return nextl;
	}
	
	public static void generateNetherIsland(Location l){
	    EditSession es = new EditSession(new BukkitWorld(l.getWorld()), 999999999);
	    CuboidClipboard cc = null;
	    
		try{
			cc = CuboidClipboard.loadSchematic(new File("plugins/WorldEdit/schematics", "NetherSkyBlock.schematic"));
		}catch(DataException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	    try {
			cc.paste(es, new Vector(l.getX(), l.getY() +1, l.getZ()), false);
		}catch(MaxChangedBlocksException e){
			e.printStackTrace();
		}
	    
	    BlockState bs = l.getWorld().getBlockAt(l.getBlockX() +11, l.getBlockY() +19, l.getBlockZ() +19).getState();
	    CreatureSpawner spawner = (CreatureSpawner) bs;
	    spawner.setSpawnedType(EntityType.BLAZE);
	    bs.update();
	}
	
	public static void generateIsland(Location l){
		World w = l.getWorld();
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		// LAYER 1
		w.getBlockAt(new Location(w, x +0, y +6, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +6, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +6, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +6, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +6, z -1)).setType(Material.LEAVES);
		
		// LAYER 2
		w.getBlockAt(new Location(w, x +0, y +5, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +5, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +5, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +5, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +5, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +5, z -1)).setType(Material.LEAVES);
		
		// LAYER 3
		w.getBlockAt(new Location(w, x +0, y +4, z +0)).setType(Material.LOG);
		w.getBlockAt(new Location(w, x +1, y +4, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +4, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +4, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +4, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +4, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +4, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +4, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +4, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +4, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +4, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +4, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +4, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +4, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +4, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +4, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +4, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +4, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +4, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +4, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +4, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +4, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +4, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +4, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +4, z +2)).setType(Material.LEAVES);
		
		// LAYER 4
		w.getBlockAt(new Location(w, x +0, y +3, z +0)).setType(Material.LOG);
		w.getBlockAt(new Location(w, x +1, y +3, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +3, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +3, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +3, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +3, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +3, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +3, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +3, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +3, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +3, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +3, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +2, y +3, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +3, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +3, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +3, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +3, z -2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +3, z -1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +3, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +3, z +1)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -2, y +3, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x -1, y +3, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +0, y +3, z +2)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +3, z +0)).setType(Material.LEAVES);
		w.getBlockAt(new Location(w, x +1, y +3, z +2)).setType(Material.LEAVES);

		// LAYER 5
		w.getBlockAt(new Location(w, x +0, y +2, z +0)).setType(Material.LOG);
		
		// LAYER 6
		w.getBlockAt(new Location(w, x +0, y +1, z +0)).setType(Material.LOG);
		
		// LAYER 7
		w.getBlockAt(new Location(w, x +0, y +0, z +0)).setType(Material.LOG);
		
		Block b = w.getBlockAt(x, y, z -1);
		b.setType(Material.CHEST);
		Chest c = (Chest) b.getState();
		c.getInventory().setItem(10, new ItemStack(Material.SAPLING, 1));
		c.getInventory().setItem(12, new ItemStack(Material.ICE, 1));
		c.getInventory().setItem(13, new ItemStack(Material.LAVA_BUCKET, 1));
		c.getInventory().setItem(14, new ItemStack(Material.ICE, 1));
		c.getInventory().setItem(16, new ItemStack(Material.SAPLING, 1));
		c.update();
		
		// LAYER 8
		w.getBlockAt(new Location(w, x +0, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +2, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +2, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +2, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +2, y -1, z -2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z -2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z -2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z -2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -2, y -1, z -2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -2, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -2, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -2, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -2, y -1, z +2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z +2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z +2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z +2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +2, y -1, z +2)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +3, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +3, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +3, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -3, y -1, z +0)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -3, y -1, z -1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -3, y -1, z +1)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z +3)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z +3)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z +3)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +0, y -1, z -3)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x -1, y -1, z -3)).setType(Material.GRASS);
		w.getBlockAt(new Location(w, x +1, y -1, z -3)).setType(Material.GRASS);
		
		// LAYER 9
		w.getBlockAt(new Location(w, x +0, y -2, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z +0)).setType(Material.SAND);
		w.getBlockAt(new Location(w, x +0, y -2, z +1)).setType(Material.SAND);
		w.getBlockAt(new Location(w, x -1, y -2, z +0)).setType(Material.SAND);
		w.getBlockAt(new Location(w, x +0, y -2, z -1)).setType(Material.SAND);
		w.getBlockAt(new Location(w, x -1, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -2, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -2, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -2, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -2, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -2, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -2, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -2, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -2, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -2, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -2, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +3, y -2, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +3, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +3, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -3, y -2, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -3, y -2, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -3, y -2, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -2, z +3)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -2, z +3)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z +3)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -2, z -3)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -2, z -3)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -2, z -3)).setType(Material.DIRT);
		
		// LAYER 10
		w.getBlockAt(new Location(w, x +0, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -3, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -3, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -3, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -3, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -3, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +2, y -3, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -3, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -3, z -2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -3, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -2, y -3, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -3, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -3, z +2)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -3, z +2)).setType(Material.DIRT);
		
		// LAYER 11
		w.getBlockAt(new Location(w, x +0, y -4, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -4, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -4, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -4, z +0)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +0, y -4, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -4, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x +1, y -4, z -1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -4, z +1)).setType(Material.DIRT);
		w.getBlockAt(new Location(w, x -1, y -4, z -1)).setType(Material.DIRT);
		
		// LAYER 12
		w.getBlockAt(new Location(w, x +0, y -5, z +0)).setType(Material.BEDROCK);
	}
	
	public static enum IslandRank {
		
		MEMBER,
		OWNER;
		
	}
	
	public static enum ChallengeType {
		
		GATHER,
		FARM,
		MOB;
		
	}
}
