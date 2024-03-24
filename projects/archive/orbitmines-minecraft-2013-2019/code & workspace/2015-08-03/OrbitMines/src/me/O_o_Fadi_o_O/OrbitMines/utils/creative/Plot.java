package me.O_o_Fadi_o_O.OrbitMines.utils.creative;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.NPCArmorStand;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.NPCType;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.CreativeUtils.PlotType;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Inventories.PlotKitInv;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Plot {

	private int plotid;
	private Location location;
	private UUID owneruuid;
	private List<UUID> memberuuids;
	private Location homelocation;
	private String createddate;
	private PlotType plottype;
	private boolean setupfinished;
	private boolean resetting;
	private long lastreset;
	private Location pvplobbylocation;
	private List<Location> pvpspawns;
	private boolean pvpdrops;
	private boolean pvparrows;
	private boolean pvpbuild;
	private int pvpmaxplayers;
	private List<Kit> pvpkits;
	private HashMap<Kit, PlotKitInv> pvpinventories;
	private HashMap<Kit, Location> pvpnpclocations;
	private HashMap<Kit, NPCArmorStand> pvpnpcs;
	
	public Plot(int plotid){
		this.plotid = plotid;
		this.memberuuids = new ArrayList<UUID>();
		this.pvpspawns = new ArrayList<Location>();
		this.pvpkits = new ArrayList<Kit>();
		this.pvpinventories = new HashMap<Kit, PlotKitInv>();
		this.pvpnpclocations = new HashMap<Kit, Location>();
		this.pvpnpcs = new HashMap<Kit, NPCArmorStand>();
		this.lastreset = 0;
	}

	public int getPlotID() {
		return plotid;
	}
	public void setPlotID(int plotid) {
		this.plotid = plotid;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Location", Utils.getStringFromLocation(this.location));
		ConfigManager.savePlots();
	}

	public UUID getOwnerUUID() {
		return owneruuid;
	}
	public void setOwnerUUID(UUID owneruuid) {
		this.owneruuid = owneruuid;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Players.Owner", this.owneruuid.toString());
		ConfigManager.savePlots();
	}

	public List<UUID> getMemberUUIDs() {
		return memberuuids;
	}
	public void setMemberUUIDs(List<UUID> memberuuids) {
		this.memberuuids = memberuuids;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Players.Members", Utils.getStringList(this.memberuuids));
		ConfigManager.savePlots();
	}
	public void addMemberUUID(UUID memberuuid) {
		this.memberuuids.add(memberuuid);
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Players.Members", Utils.getStringList(this.memberuuids));
		ConfigManager.savePlots();
	}
	public void removeMemberUUID(UUID memberuuid) {
		this.memberuuids.remove(memberuuid);
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Players.Members", Utils.getStringList(this.memberuuids));
		ConfigManager.savePlots();
	}

	public Location getHomeLocation() {
		return homelocation;
	}
	public void setHomeLocation(Location homelocation) {
		this.homelocation = homelocation;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".HomeLocation", Utils.getStringFromLocation(this.homelocation));
		ConfigManager.savePlots();
	}

	public String getCreatedDate() {
		return createddate;
	}
	public void setCreatedDate() {
		String createddate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		this.createddate = createddate;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".CreatedDate", this.createddate);
		ConfigManager.savePlots();
	}

	public PlotType getPlotType() {
		return plottype;
	}
	public void setPlotType(PlotType plottype) {
		this.plottype = plottype;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".Type", this.plottype.toString());
		ConfigManager.savePlots();
	}

	public boolean isSetupFinished() {
		return setupfinished;
	}
	public void setSetupFinished(boolean setupfinished) {
		this.setupfinished = setupfinished;
		
		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.SetupFinished", this.setupfinished);
		ConfigManager.savePlots();
	}

	public boolean isResetting() {
		return resetting;
	}
	public void setResetting(boolean resetting) {
		this.resetting = resetting;
	}

	public long getLastReset() {
		return lastreset;
	}
	public void setLastReset(long lastreset) {
		this.lastreset = lastreset;
	}
	public void updateLastReset() {
		this.lastreset = System.currentTimeMillis();
	}
	public boolean canReset(){
		if(System.currentTimeMillis() - this.lastreset >= 900000){
			return true;
		}
		return false;
	}

	public Location getPvPLobbyLocation() {
		return pvplobbylocation;
	}
	public void setPvPLobbyLocation(Location pvplobbylocation) {
		this.pvplobbylocation = pvplobbylocation;

		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.Locations.Lobby", Utils.getStringFromLocation(this.pvplobbylocation));
		ConfigManager.savePlots();
	}

	public List<Location> getPvPSpawns() {
		return pvpspawns;
	}
	public void setPvPSpawns(List<Location> pvpspawns) {
		this.pvpspawns = pvpspawns;
		
		List<String> spawns = new ArrayList<String>();
		for(Location pvpspawn : this.pvpspawns){
			spawns.add(Utils.getStringFromLocation(pvpspawn));
		}
		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.Locations.Spawns", spawns);
		ConfigManager.savePlots();
	}

	public boolean hasPvPDrops() {
		return pvpdrops;
	}
	public void setPvPDrops(boolean pvpdrops) {
		this.pvpdrops = pvpdrops;

		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.EnableDrops", this.pvpdrops);
		ConfigManager.savePlots();
	}

	public boolean hasPvPArrows() {
		return pvparrows;
	}
	public void setPvPArrows(boolean pvparrows) {
		this.pvparrows = pvparrows;

		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.EnableArrows", this.pvparrows);
		ConfigManager.savePlots();
	}

	public boolean canPvPBuild() {
		return pvpbuild;
	}
	public void setPvPBuild(boolean pvpbuild) {
		this.pvpbuild = pvpbuild;

		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.EnableBuild", this.pvpbuild);
		ConfigManager.savePlots();
	}

	public int getPvPMaxPlayers() {
		return pvpmaxplayers;
	}
	public void setPvPMaxPlayers(int pvpmaxplayers) {
		this.pvpmaxplayers = pvpmaxplayers;

		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.MaxPlayers", this.pvpmaxplayers);
		ConfigManager.savePlots();
	}

	public List<Kit> getPvPKits() {
		return pvpkits;
	}
	public void setPvPKits(List<Kit> pvpkits) {
		this.pvpkits = pvpkits;
		
		for(Kit kit : this.pvpkits){
			kit.saveToConfig(ConfigManager.plots, "plots." + getPlotID() + ".PvPInfo.Kits." + kit.getKitName(), Material.STAINED_GLASS_PANE);
		}
		ConfigManager.savePlots();
	}

	public HashMap<Kit, PlotKitInv> getPvPInventories() {
		return pvpinventories;
	}
	public void setPvPInventories(HashMap<Kit, PlotKitInv> pvpinventories) {
		this.pvpinventories = pvpinventories;
	}

	public HashMap<Kit, Location> getPvPNPCLocations() {
		return pvpnpclocations;
	}
	public void setPvPNPCLocations(HashMap<Kit, Location> pvpnpclocations) {
		this.pvpnpclocations = pvpnpclocations;
		
		for(Kit kit : this.pvpkits){
			ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.Locations.NPCs." + kit.getKitName(), Utils.getStringFromLocation(this.pvpnpclocations.get(kit)));
		}
		ConfigManager.savePlots();
	}

	public HashMap<Kit, NPCArmorStand> getPvPNPCs() {
		return pvpnpcs;
	}
	public void setPvPNPCs(HashMap<Kit, NPCArmorStand> pvpnpcs) {
		this.pvpnpcs = pvpnpcs;
	}
	public void createKit(Location l, String kitname){
		Kit kit = new Kit(kitname);
		this.pvpkits.add(kit);
		this.pvpnpclocations.put(kit, l);
		setPvPKits(this.pvpkits);
		setPvPNPCLocations(this.pvpnpclocations);
		
		spawnNPC(kit);
		updateNPC(kit);
	}
	public void removeKit(Kit kit){
		this.pvpkits.remove(kit);
		this.pvpnpclocations.remove(kit);
		this.pvpnpcs.get(kit).delete();
		this.pvpnpcs.remove(kit);
		setPvPKits(this.pvpkits);
		setPvPNPCLocations(this.pvpnpclocations);
		
		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.Kits." + kit.getKitName(), null);
		ConfigManager.plots.set("plots." + getPlotID() + ".PvPInfo.Locations.NPCs." + kit.getKitName(), null);
		ConfigManager.savePlots();
	}
	public void spawnNPCs(){
		for(Kit kit : this.pvpkits){
			spawnNPC(kit);
			updateNPC(kit);
		}
	}
	private void spawnNPC(Kit kit){
		Location l = this.pvpnpclocations.get(kit);
		
		NPCArmorStand npcas = NPCArmorStand.addNPCArmorStand(NPCType.PLOT_KIT_SELECTOR, l);
		npcas.setGravity(false);
		npcas.setCustomName("§7§lKit §8| §a" + kit.getKitName());
		npcas.setCustomNameVisible(true);
		npcas.spawn();
		this.pvpnpcs.put(kit, npcas);
	}
	public void updateNPCs(){
		for(Kit kit : this.pvpkits){
			updateNPC(kit);
		}
	}
	public void updateNPC(Kit kit){
		NPCArmorStand npcas = this.pvpnpcs.get(kit);
		npcas.setCustomName("§7§lKit §8| §a" + kit.getKitName());
		npcas.setCustomNameVisible(true);

		ItemStack helmet = kit.getHelmet();
		ItemStack chestplate = kit.getChestplate();
		ItemStack leggings = kit.getLeggings();
		ItemStack boots = kit.getBoots();
		ItemStack firstitem = kit.getFirstItem();
		
		if(helmet == null || helmet.getType() != Material.STAINED_GLASS_PANE){
			npcas.setHelmet(helmet);
		}
		if(chestplate == null || chestplate.getType() != Material.STAINED_GLASS_PANE){
			npcas.setChestplate(chestplate);
		}
		if(leggings == null || leggings.getType() != Material.STAINED_GLASS_PANE){
			npcas.setLeggings(leggings);
		}
		if(boots == null || boots.getType() != Material.STAINED_GLASS_PANE){
			npcas.setBoots(boots);
		}
		if(firstitem == null || firstitem.getType() != Material.STAINED_GLASS_PANE){
			npcas.setItemInHand(firstitem);
		}
		else{
			npcas.setItemInHand(null);
		}
		npcas.update();
	}
	public void removeNPCs(){
		for(NPCArmorStand npc : this.pvpnpcs.values()){
			npc.delete();
		}
	}
	
	public void reset(){
		this.resetting = true;
		updateLastReset();
		resetLayer(0);
	}
	
	private void resetLayer(final int y){
		World w = ServerData.getCreative().getPlotWorld();
		final List<Block> blocks = Utils.getBlocksBetween(new Location(w, this.location.getX() + 43.5, y, this.location.getZ() + 43.5), new Location(w, this.location.getX() - 44, y, this.location.getZ() - 44));
	
		new BukkitRunnable(){
			public void run(){
				Material m = Material.BEDROCK;
				if(y == 0){}
				else if(y < 70){m = Material.DIRT;}
				else if(y == 70){m = Material.GRASS;}
				else{m = Material.AIR;}
				
				for(Block b : blocks){
					b.setType(m);
				}
				
				Player p = Utils.getPlayer(getOwnerUUID());
				if(y != 255){
					if(p != null){
						Title t = new Title("§7Clearing §dPlot§7...", "§d" + (y +1) + "§7/§d255", 0, 20, 0);
						t.send(p);
					}
					resetLayer(y +1);
				}
				else{
					if(p != null){
						Title t = new Title("", "§7Cleared your §dPlot§7!", 0, 30, 40);
						t.send(p);
					}
				}
			}
		}.runTaskLater(Start.getInstance(), 2);
	}
	
	public void generatePvPBorder(boolean border){
		Location l = this.location;
		World w = l.getWorld();
		double x = l.getX();
		double y = l.getY();
		double z = l.getZ();
		Material m = Material.AIR;
		if(border){
			m = Material.BARRIER;
		}
		
		List<Block> blocks = new ArrayList<Block>();
		blocks.addAll(Utils.getBlocksBetween(new Location(w, x -44, 255, z -44), new Location(w, x +43.5, 255, z +43.5)));
		blocks.addAll(Utils.getBlocksBetween(new Location(w, x -45, y +1, z +44.5), new Location(w, x +44.5, 255, z +44.5)));
		blocks.addAll(Utils.getBlocksBetween(new Location(w, x -45, y +1, z -45), new Location(w, x +44.5, 255, z -45)));
		blocks.addAll(Utils.getBlocksBetween(new Location(w, x +44.5, y +1, z -45), new Location(w, x +44.5, 255, z +44.5)));
		blocks.addAll(Utils.getBlocksBetween(new Location(w, x -45, y +1, z -45), new Location(w, x -45, 255, z +44.5)));
		
		for(Block b : blocks){
			 b.setType(m); 
		}
	}
	
	public void load(){
		FileConfiguration plots = ConfigManager.plots;
		
		this.location = Utils.getLocationFromString(plots.getString("plots." + getPlotID() + ".Location"));
		this.homelocation = Utils.getLocationFromString(plots.getString("plots." + getPlotID() + ".HomeLocation"));
		this.createddate = plots.getString("plots." + getPlotID() + ".CreatedDate");
		this.plottype = PlotType.valueOf(plots.getString("plots." + getPlotID() + ".Type"));
		this.owneruuid = UUID.fromString(plots.getString("plots." + getPlotID() + ".Players.Owner"));
		this.memberuuids = Utils.getUUIDList(plots.getStringList("plots." + getPlotID() + ".Players.Members"));
		
		this.setupfinished = false;
		this.pvpdrops = false;
		this.pvparrows = false;
		this.pvpbuild = false;
		this.pvpmaxplayers = 50;
		
		if(plots.contains("plots." + getPlotID() + ".PvPInfo")){
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.SetupFinished")){
				this.setupfinished = plots.getBoolean("plots." + getPlotID() + ".PvPInfo.SetupFinished");
			}
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.EnableDrops")){
				this.pvpdrops = plots.getBoolean("plots." + getPlotID() + ".PvPInfo.EnableDrops");
			}
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.EnableArrows")){
				this.pvparrows = plots.getBoolean("plots." + getPlotID() + ".PvPInfo.EnableArrows");
			}
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.EnableBuild")){
				this.pvpbuild = plots.getBoolean("plots." + getPlotID() + ".PvPInfo.EnableBuild");
			}
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.MaxPlayers")){
				this.pvpmaxplayers = plots.getInt("plots." + getPlotID() + ".PvPInfo.MaxPlayers");
			}
			
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.Kits")){
				List<Kit> pvpkits = new ArrayList<Kit>();
				for(String kitname : plots.getConfigurationSection("plots." + getPlotID() + ".PvPInfo.Kits").getKeys(false)){
					Kit kit = Kit.getKitFromConfig(kitname, ConfigManager.plots, "plots." + getPlotID() + ".PvPInfo.Kits." + kitname);
					pvpkits.add(kit);
				}
				this.pvpkits = pvpkits;
				
				new BukkitRunnable(){
					public void run(){
						spawnNPCs();
					}
				}.runTaskLater(Start.getInstance(), 100);
			}
			
			this.pvplobbylocation = Utils.getLocationFromString(plots.getString("plots." + getPlotID() + ".PvPInfo.Locations.Lobby"));
			if(plots.contains("plots." + getPlotID() + ".PvPInfo.Locations.NPCs")){
				HashMap<Kit, Location> pvpnpclocations = new HashMap<Kit, Location>();
				for(String kitname : plots.getConfigurationSection("plots." + getPlotID() + ".PvPInfo.Locations.NPCs").getKeys(false)){
					pvpnpclocations.put(Kit.getKit(kitname), Utils.getLocationFromString(plots.getString("plots." + getPlotID() + ".PvPInfo.Locations.NPCs." + kitname)));
				}
				this.pvpnpclocations = pvpnpclocations;
			}
			this.pvpspawns = Utils.getLocationList(plots.getStringList("plots." + getPlotID() + ".PvPInfo.Locations.Spawns"));
		}
	}
	
	public static List<Plot> getPlots(){
		return ServerData.getCreative().getPlots();
	}
	
	public static Plot getPlot(int plotid){
		for(Plot plot : ServerData.getCreative().getPlots()){
			if(plot.getPlotID() == plotid){
				return plot;
			}
		}
		return null;
	}
	
	public static Plot getPlot(UUID uuid){
		for(Plot plot : ServerData.getCreative().getPlots()){
			if(plot.getOwnerUUID().toString().equals(uuid.toString())){
				return plot;
			}
		}
		return null;
	}
	
	public static void removeAllPlotNPCs(){
		for(Plot plot : ServerData.getCreative().getPlots()){
			plot.removeNPCs();
		}
	}
	
	public static List<Plot> getMemberOn(UUID uuid){
		List<Plot> plots = new ArrayList<Plot>();
		for(Plot plot : ServerData.getCreative().getPlots()){
			if(Utils.getStringList(plot.getMemberUUIDs()).contains(uuid.toString())){
				plots.add(plot);
			}
		}
		return plots;
	}
	
	public static List<CreativePlayer> getPvPPlayers(Plot plot){
		List<CreativePlayer> cplayers = new ArrayList<CreativePlayer>();
		for(Player player : Bukkit.getOnlinePlayers()){
			CreativePlayer cplayer = OMPlayer.getOMPlayer(player).getCreativePlayer();
			if(cplayer.getPvPPlot() != null && cplayer.getPvPPlot().getPlotID() == plot.getPlotID()){
				cplayers.add(cplayer);
			}
		}
		return cplayers;
	}
	
	public static Plot nextPlot(CreativePlayer cp){
		CreativeServer creative = ServerData.getCreative();
		int lastplotid = creative.getLastPlotID();
		
		Plot plot = new Plot(lastplotid +1);
		if(lastplotid == 0){
			plot.setLocation(new Location(creative.getPlotWorld(), -51, 71, 52));
		}
		else{
			plot.setLocation(nextPlotLocation(getPlot(lastplotid).getLocation()));
		}
		plot.setHomeLocation(plot.getLocation());
		plot.setCreatedDate();
		plot.setPlotType(PlotType.NORMAL);
		plot.setOwnerUUID(cp.getPlayer().getUniqueId());
		plot.setMemberUUIDs(new ArrayList<UUID>());
		
		cp.setPlot(plot);
		creative.setLastPlotID(lastplotid +1);
		creative.getPlots().add(plot);
		
		return plot;
	}
	
	private static Location nextPlotLocation(Location prevplot){
		final int x = (int) prevplot.getX();
		final int z = (int) prevplot.getZ();
		final Location nextplot = prevplot;
		
		if(x < z){
			if(-1 * x < z){
				nextplot.setX(nextplot.getX() + 103);
				return nextplot;
			}
			nextplot.setZ(nextplot.getZ() + 103);
			return nextplot;
		}
		if(x > z){
			if(-1 * x >= z){
				nextplot.setX(nextplot.getX() - 103);
				return nextplot;
			}
			nextplot.setZ(nextplot.getZ() - 103);
			return nextplot;
		}
		if(x <= 0){
			nextplot.setZ(nextplot.getZ() + 103);
			return nextplot;
		}
		nextplot.setZ(nextplot.getZ() - 103);
		
		return nextplot;
	}
}
