package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import com.google.common.io.Files;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.world.DataException;

@SuppressWarnings("deprecation")
public class Map {

	private String mapname;
	private String builder;
	private String worldname;
	private boolean uhc;
	private World world;
	private Location spectatorlocation;
	private List<Location> spawns;
	private boolean inuse;
	private HashMap<OMPlayer, Location> playerspawns;
	private List<Location> swtiertwochests;
	
	public Map(String mapname, String builder, MiniGameType type, String worldname, boolean uhc){
		this.mapname = mapname;
		this.builder = builder;
		this.worldname = worldname;
		this.uhc = uhc;
		this.inuse = false;
		this.playerspawns = new HashMap<OMPlayer, Location>();
		this.swtiertwochests = new ArrayList<Location>();
		
		restoreWorld();
	}

	public String getMapName() {
		return mapname;
	}
	public void setMapName(String mapname) {
		this.mapname = mapname;
	}

	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}

	public String getWorldName() {
		return worldname;
	}
	public void setWorldName(String worldname) {
		this.worldname = worldname;
	}

	public Location getSpectatorLocation() {
		return spectatorlocation;
	}
	public void setSpectatorLocation(Location spectatorlocation) {
		this.spectatorlocation = spectatorlocation;
	}

	public List<Location> getSpawns() {
		return spawns;
	}
	public void setSpawns(List<Location> spawns) {
		this.spawns = spawns;
	}

	public boolean isInUse() {
		return inuse;
	}
	public void setInUse(boolean inuse) {
		this.inuse = inuse;
	}

	public HashMap<OMPlayer, Location> getPlayerSpawns() {
		return playerspawns;
	}
	public void setPlayerSpawns(HashMap<OMPlayer, Location> playerspawns) {
		this.playerspawns = playerspawns;
	}

	public List<Location> getSWTier2Chests() {
		return swtiertwochests;
	}
	public void setSWTier2Chests(List<Location> swtiertwochests) {
		this.swtiertwochests = swtiertwochests;
	}
	
	public void restoreWorld(){
		File file = new File(getWorldName());
		
		if(!uhc){
			if(file != null){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv remove " + getWorldName());
				for(String filename : file.list()){
					File f = new File(file.getPath() + "/" + filename);
					f.delete();
				}
			}
			
			try{
				File file2 = new File("plugins/MiniGame Worlds", getWorldName());
				new File(getWorldName() + "/data").mkdirs();
				new File(getWorldName() + "/region").mkdirs();
				for(String filename : file2.list()){
					try{
						Files.copy(new File(file2.getPath() + "/" + filename), new File(getWorldName() + "/" + filename));
					}catch(FileNotFoundException ex){
						File file3 = new File(file2.getPath() + "/" + filename);
						for(String filename2 : file3.list()){
							Files.copy(new File(file3.getPath() + "/" + filename2), new File(getWorldName() + "/" + filename + "/" + filename2));
						}
					}
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + getWorldName() + " normal -g OrbitMinesEmptyWorldGenerator");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv modify set weather false " + getWorldName());
		}
		else{
			if(file != null){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv remove " + getWorldName());
				try{
					FileUtils.deleteDirectory(file);
				}catch(IOException e){
					e.printStackTrace();
				}
			}

			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv create " + getWorldName() + " normal");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv modify set weather false " + getWorldName());
		}
		setWorld(Bukkit.getWorld(getWorldName()));
		
		if(uhc){
			getWorld().setGameRuleValue("naturalRegeneration", "false");
			getWorld().setDifficulty(Difficulty.HARD);
			
		    EditSession es = new EditSession(new BukkitWorld(getWorld()), 999999999);
		    CuboidClipboard cc = null;
		    
			try{
				cc = CuboidClipboard.loadSchematic(new File("plugins/WorldEdit/schematics", "UHCSpawn.schematic"));
			}catch(DataException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		    try {
		    	int y = getHighestYPos(new Location(getWorld(), 0.5, 100, 0.5)) +1;
		    	setSpectatorLocation(new Location(getWorld(), 0.5, y, 0.5));
		    	
				cc.paste(es, new Vector(0.5, y, 0.5), true);
			}catch(MaxChangedBlocksException e){
				e.printStackTrace();
			}
		}
		else{
			getWorld().setGameRuleValue("doMobSpawning", "false");
		}
	}
	
	public int getHighestYPos(Location l){
		for(int i = 250; i > 0; i--){
			Block b = l.getWorld().getBlockAt(l.getBlockX(), i, l.getBlockZ());
			
			if(b != null && !b.isEmpty()){
				return i +1;
			}
		}
		return 100;
	}
}
