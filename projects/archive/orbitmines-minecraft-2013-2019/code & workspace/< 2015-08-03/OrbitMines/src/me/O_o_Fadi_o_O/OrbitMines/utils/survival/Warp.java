package me.O_o_Fadi_o_O.OrbitMines.utils.survival;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warp {

	private int warpid;
	private UUID uuid;
	private String name;
	private Location location;
	private boolean enabled;
	private ItemStack item;
	
	public Warp(int warpid, UUID uuid, String name, Location location, boolean enabled, Material material, short durability){
		this.warpid = warpid;
		this.uuid = uuid;
		this.name = name;
		this.location = location;
		this.enabled = enabled;
		
		updateItemStack(material, durability);
	}

	public int getWarpID() {
		return warpid;
	}
	public void setWarpID(int warpid) {
		this.warpid = warpid;
	}

	public UUID getUUID() {
		return uuid;
	}
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	
	public String getUUIDName() {
		Player p = Utils.getPlayer(this.uuid);
		
		if(p != null){
			return p.getName();
		}
		return Utils.getName(this.uuid);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ItemStack getItemStack() {
		return item;
	}
	public void setItemStack(ItemStack item) {
		this.item = item;
	}
	
	public void updateItemStack(Material material, int durability){
		ItemStack item = new ItemStack(material, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§7§lWarp: §3§l" + name);
		List<String> lore = new ArrayList<String>();
		lore.add(" §7Owner: §3" + getUUIDName());
		lore.add(" §7XYZ: §3" + location.getBlockX() + "§7 / §3" + location.getBlockY() + "§7 / §3" + location.getBlockZ());
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setDurability((short) durability);
		
		this.item = item;
	}
	
	public void teleport(OMPlayer omp){
		SurvivalPlayer sp = omp.getSurvivalPlayer();
		
		omp.resetCooldown(Cooldown.TELEPORTING);
		sp.setWarpTeleporting(true);
		sp.setWarpingTo(this);
		
		omp.getPlayer().sendMessage("§7Teleporting to §3" + this.name + "§7...");
	}
	
	public void teleportInstantly(OMPlayer omp){
		omp.getSurvivalPlayer().setLastLocation(omp.getPlayer().getLocation());
		omp.getPlayer().teleport(this.location);
	}
	
	public static List<Warp> readFromConfig(){
		List<Warp> warps = new ArrayList<Warp>();
		
		for(String warpstring : ConfigManager.warps.getStringList("warps")){
			String[] warpparts = warpstring.split("\\;");
			
			warps.add(new Warp(Integer.parseInt(warpparts[0]), UUID.fromString(warpparts[6]), warpparts[1], Utils.getLocationFromString(warpparts[2]), Boolean.parseBoolean(warpparts[5]), Material.valueOf(warpparts[3]), Short.parseShort(warpparts[4])));
		}
		return warps;
	}
	
	public static void saveToConfig(){
		List<String> warps = new ArrayList<String>();
		
		for(Warp warp : ServerData.getSurvival().getWarps()){
			warps.add(warp.getWarpID() + ";" + warp.getName() + ";" + Utils.getStringFromLocation(warp.getLocation()) + ";" + warp.getItemStack().getType().toString() + ";" + warp.getItemStack().getDurability() + ";" + warp.isEnabled() + ";" + warp.getUUID().toString());
		}
		
		ConfigManager.warps.set("warps", warps);
		ConfigManager.saveWarps();
	}
	
	public static List<Warp> getWarps(){
		return ServerData.getSurvival().getWarps();
	}
	
	public static List<Warp> getWarps(Player player){
		List<Warp> warps = new ArrayList<Warp>();
		
		for(Warp warp : ServerData.getSurvival().getWarps()){
			if(warp.getUUID().toString().equals(player.getUniqueId().toString())){
				warps.add(warp);
			}
		}
		return warps;
	}
	
	public static Warp getWarp(int warpid){
		for(Warp warp : ServerData.getSurvival().getWarps()){
			if(warp.getWarpID() == warpid){
				return warp;
			}
		}
		return null;
	}
	public static Warp getWarp(String name){
		for(Warp warp : ServerData.getSurvival().getWarps()){
			if(warp.getName().equalsIgnoreCase(name)){
				return warp;
			}
		}
		return null;
	}
}
