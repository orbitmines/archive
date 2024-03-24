package me.O_o_Fadi_o_O.Prison.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Start;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class EmptyWorldGenerator extends ChunkGenerator {

	Start plugin;
	 
	public EmptyWorldGenerator(Start instance) {
		plugin = instance;
	}
	
	public Location getFixedSpawnLocation(World w, Random r){
		Location l = new Location(w, 0, 74, 0);
		
		return l;
	}
	
	public List<BlockPopulator> getWorldPopulators(World w){
		
		List<BlockPopulator> list = new ArrayList<BlockPopulator>();
		
		return list;
	}
	
	public byte[][] generateEmptyWorld(World w, Random r, int cX, int cY, int cZ, BiomeGrid bg){
		
		byte[][] res = new byte[w.getMaxHeight() / 16][];
		
		int x; int z;
		
		for(x= 0; x < 16; x++){
			for(z = 0; z < 16; z++){
				setBlock(res, x, 0, z, (byte) 0);
			}
		}
		
		return res;
	}

	@Override
	public short[][] generateExtBlockSections(World w, Random r,
			int xC, int zC, BiomeGrid biomes) {
		
		short[][] res = new short[w.getMaxHeight() / 16][];
		
		int x; int z;
		
		for(x= 0; x < 16; x++){
			for(z = 0; z < 16; z++){
				setBlock(res, x, 0, z, (short) 0);
			}
		}
		
		return res;
	}
	
	private void setBlock(byte[][] res, int x, int y, int z, byte b) {

		if(res[y >> 4] == null){
			res[y >> 4] = new byte[4096];
		}
		res[y >> 4][((y&0xF) << 8) | (z << 4) | x] = b;
		
	}
	
	private void setBlock(short[][] res, int x, int y, int z, short s) {

		if(res[y >> 4] == null){
			res[y >> 4] = new short[4096];
		}
		res[y >> 4][((y&0xF) << 8) | (z << 4) | x] = s;
		
	}
	
}
