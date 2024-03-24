package me.O_o_Fadi_o_O.OrbitMines.utils.prison;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMines.utils.NPC;
import me.O_o_Fadi_o_O.OrbitMines.utils.prison.PrisonUtils.Rank;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Lumberjack {

	private Rank rank;
	private NPC npc;
	private Location location;
	private Block workingon;
	private Block toremove;
	private List<Block> blocks;
	private boolean working;
	
	public Lumberjack(Rank rank, NPC npc, Location location, Block toremove, List<Block> blocks){
		this.rank = rank;
		this.npc = npc;
		this.location = location;
		this.workingon = null;
		this.toremove = toremove;
		this.blocks = blocks;
		this.working = false;
	}

	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public NPC getNPC() {
		return npc;
	}
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Block getWorkingOn() {
		return workingon;
	}
	public void setWorkingOn(Block workingon) {
		this.workingon = workingon;
	}
	
	public Block getToRemove() {
		return toremove;
	}
	public void setToRemove(Block toremove) {
		this.toremove = toremove;
	}
	
	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
	public List<Block> getTakenBlocks(){
		List<Block> blocks = new ArrayList<Block>();
		for(Block b : getBlocks()){
			if(b.getType() != Material.LOG){
				blocks.add(b);
			}
		}
		return blocks;
	}

	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
}
