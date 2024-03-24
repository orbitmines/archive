package me.O_o_Fadi_o_O.OrbitMines.utils.survival;

import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Region {

	private int regionid;
	private Location location;
	private Biome biome;
	private List<Block> blocks;
	private ItemStack itemstack;
	private int invslot;
	
	public Region(int regionid, Location location, Biome biome, int invslot){
		this.regionid = regionid;
		this.location = location;
		this.biome = biome;
		this.invslot = invslot;
		this.blocks = Utils.getBlocksBetween(new Location(location.getWorld(), location.getX() +8, 70, location.getZ() +8), new Location(location.getWorld(), location.getX() -8, 70, location.getZ() -8));
		this.itemstack = new SurvivalUtils().getRegionItemStack(this);
	}

	public int getRegionID() {
		return regionid;
	}
	public void setRegionID(int regionid) {
		this.regionid = regionid;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public Biome getBiome() {
		return biome;
	}
	public void setBiome(Biome biome) {
		this.biome = biome;
	}

	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public int getSlot() {
		return invslot;
	}
	public void setSlot(int invslot) {
		this.invslot = invslot;
	}
	
	public static boolean isInRegion(OMPlayer omp, Location l){
		if(omp.isLoaded()){
			if(!omp.isOpMode()){
				boolean found = false;
				for(Region r : Region.getRegions()){
					if(!found){
						for(Block b : r.getBlocks()){
							if(l.getBlockX() == b.getLocation().getBlockX() && l.getBlockZ() == b.getLocation().getBlockZ()){
								found = true;
								
								if(!omp.onCooldown(Cooldown.MESSAGE)){
									omp.getPlayer().sendMessage("§7You cannot do such things that close to a Region!");
									
									omp.resetCooldown(Cooldown.MESSAGE);
								}
							}
						}
					}
				}
				return found;
			}
			return false;
		}
		return true;
	}
	
	public void teleport(OMPlayer omp){
		Player p = omp.getPlayer();
		
		p.teleport(this.location);
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
		
		Title t = new Title("", "§7Teleported to §aRegion " + this.regionid + "§7.");
		t.send(p);
	}
	
	public ItemStack getItemStack(){
		return itemstack;
	}
	
	public static List<Region> getRegions(){
		return ServerData.getSurvival().getRegions();
	}
	public static Region getRegion(int regionid){
		for(Region r : ServerData.getSurvival().getRegions()){
			if(r.getRegionID() == regionid){
				return r;
			}
		}
		return null;
	}
	public static Region getRandomRegion(){
		List<Region> regions = ServerData.getSurvival().getRegions();
		return regions.get(new Random().nextInt(regions.size()));
	}
}
