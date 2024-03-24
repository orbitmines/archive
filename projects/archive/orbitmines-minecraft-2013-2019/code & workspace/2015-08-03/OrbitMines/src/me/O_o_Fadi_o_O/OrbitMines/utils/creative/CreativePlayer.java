package me.O_o_Fadi_o_O.OrbitMines.utils.creative;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.managers.ConfigManager;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.CreativeServer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Title;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Cooldown;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.VIPRank;
import me.O_o_Fadi_o_O.OrbitMines.utils.creative.Inventories.PlotKitInv;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CreativePlayer {

	private Player player;
	private Plot plot;
	private List<String> worldeditcommands;
	private Kit selectedkit;
	private Plot pvpplot;
	
	public CreativePlayer(Player player){
		this.player = player;
		this.worldeditcommands = new ArrayList<String>();
		
		if(ConfigManager.playerdata.contains("players." + getUUID().toString() + ".PlotID")){
			this.plot = Plot.getPlot(ConfigManager.playerdata.getInt("players." + getUUID().toString() + ".PlotID"));
		}
		if(ConfigManager.playerdata.contains("players." + getUUID().toString() + ".WorldEdit")){
			this.worldeditcommands = ConfigManager.playerdata.getStringList("players." + getUUID().toString() + ".WorldEdit");
		}

		Start start = Start.getInstance();
		CreativeServer creative = ServerData.getCreative();
		String plotworld = creative.getPlotWorld().getName();
		
		start.permission.playerAddTransient(plotworld, player, "worldedit.wand");
		start.permission.playerAddTransient(plotworld, player, "worldedit.selection.pos");
		start.permission.playerAddTransient(plotworld, player, "worldedit.region.set");
		start.permission.playerAddTransient(plotworld, player, "worldedit.region.line");
		start.permission.playerAddTransient(plotworld, player, "worldedit.region.walls");
		start.permission.playerAddTransient(plotworld, player, "worldedit.region.replace");
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".PlotID", plot.getPlotID());
		ConfigManager.savePlayerData();
	}
	public boolean hasPlot(){
		return plot != null;
	}

	public List<String> getWECommands() {
		return worldeditcommands;
	}
	public void setWECommands(List<String> worldeditcommands) {
		this.worldeditcommands = worldeditcommands;
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".WorldEdit", this.worldeditcommands);
		ConfigManager.savePlayerData();
	}
	public void addWECommand(String worldeditcommand) {
		this.worldeditcommands.add(worldeditcommand);
		
		ConfigManager.playerdata.set("players." + getUUID().toString() + ".WorldEdit", this.worldeditcommands);
		ConfigManager.savePlayerData();
	}
	public boolean hasWEAccess(String cmd){
		return this.worldeditcommands.contains(cmd);
	}

	public Kit getSelectedKit() {
		return selectedkit;
	}
	public void setSelectedKit(Kit selectedkit) {
		this.selectedkit = selectedkit;
	}

	public Plot getPvPPlot() {
		return pvpplot;
	}
	public void setPvPPlot(Plot pvpplot) {
		this.pvpplot = pvpplot;
	}
	public boolean isInPvPPlot(){
		return pvpplot != null;
	}
	public void selectKit(Kit kit){
		OMPlayer omp = OMPlayer.getOMPlayer(this.player);
		Plot plot = this.pvpplot;
		
		this.selectedkit = kit;
		this.player.teleport(plot.getPvPSpawns().get(new Random().nextInt(plot.getPvPSpawns().size())));
		kit.setItems(this.player);
		omp.clearPotionEffects();
		
		Title t = new Title("", "§7Selected Kit: '§d§l" + kit.getKitName() + "§7'");
		t.send(this.player);
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public int getMaxMembers(){
		OMPlayer omp = OMPlayer.getOMPlayer(player);
		
		if(omp.hasPerms(VIPRank.Emerald_VIP)){
			return 21;
		}
		else if(omp.hasPerms(VIPRank.Diamond_VIP)){
			return 14;
		}
		else if(omp.hasPerms(VIPRank.Gold_VIP)){
			return 9;
		}
		else if(omp.hasPerms(VIPRank.Iron_VIP)){
			return 5;
		}
		else{
			return 3;
		}
	}
	
	public boolean isOnPlot(Location l){
		boolean onplot = false;
		if(l.getBlockY() != 0){
			if(!isInPvPPlot()){
				if(getPvPPlot() == null && hasPlot()){
					onplot = onPlot(this.plot, l);
				}
				
				if(!onplot){
					for(Plot p : Plot.getMemberOn(getUUID())){
						if(!onplot){
							onplot = onPlot(p, l);
						}
					}
				}
			}
			else{
				if(this.pvpplot.canPvPBuild() && this.selectedkit != null){
					onplot = onPlot(this.pvpplot, l);
				}
			}
		}
		if(!onplot){
			OMPlayer omp = OMPlayer.getOMPlayer(this.player);
			
			if(!omp.onCooldown(Cooldown.MESSAGE)){
				this.player.sendMessage("§7You cannot do that here!");
				
				omp.resetCooldown(Cooldown.MESSAGE);
			}
		}
		
		return onplot;
	}
	
	private boolean onPlot(Plot plot, Location l2){
		Location l = plot.getLocation();
		int x = l.getBlockX();
		int z = l.getBlockZ();
		
		double bDistance = 0;
		double xB = l2.getBlockX() -x;
		double zB = l2.getBlockZ() -z;
		
		if(xB < 0){
			xB = -xB -1;
		}
		if(zB < 0){
			zB = -zB -1;
		}
		
		if(xB <= zB){
			bDistance = zB;
		}
		else{
			bDistance = xB;
		}
		
		bDistance = 43.5 - bDistance;
		
		if(bDistance < 0){
			return false;
		}
		return true;
	}
	
	public void openKitInventory(Kit kit){
		if(this.plot.getPvPInventories().containsKey(kit)){
			this.plot.getPvPInventories().get(kit).open(this.player);
		}
		else{
			PlotKitInv inv = new PlotKitInv(this.plot, kit);
			this.plot.getPvPInventories().put(kit, inv);
			inv.open(this.player);
		}
	}
	public void updateNPCInventory(final Inventory inv){
		new BukkitRunnable(){
			public void run(){
				CreativePlayer cp = OMPlayer.getOMPlayer(getPlayer()).getCreativePlayer();
				Plot plot = cp.getPlot();
				String kitname = inv.getName().substring(9);
				
				ItemStack[] contents = new ItemStack[36];
				ItemStack[] armorcontents = new ItemStack[4];
				armorcontents[0] = inv.getItem(0);
				armorcontents[1] = inv.getItem(1);
				armorcontents[2] = inv.getItem(2);
				armorcontents[3] = inv.getItem(3);
				
				contents[0] = inv.getItem(18);
				contents[1] = inv.getItem(19);
				contents[2] = inv.getItem(20);
				contents[3] = inv.getItem(21);
				contents[4] = inv.getItem(22);
				contents[5] = inv.getItem(23);
				contents[6] = inv.getItem(24);
				contents[7] = inv.getItem(25);
				contents[8] = inv.getItem(26);
				
				for(Kit kit : plot.getPvPKits()){
					if(kit.getKitName().equals(kitname)){
						kit.setContents(contents);
						kit.setArmorContents(armorcontents);
						plot.setPvPKits(plot.getPvPKits());
						plot.updateNPC(kit);
						inv.setContents(plot.getPvPInventories().get(kit).getContects());
					}
				}
			}
		}.runTaskLater(Start.getInstance(), 1);
	}
	
	public static List<CreativePlayer> getCreativePlayers(){
		return ServerStorage.creativeplayers;
	}
	
	public static CreativePlayer getCreativePlayer(Player player){
		for(CreativePlayer cp : ServerStorage.creativeplayers){
			if(cp.getPlayer() == player){
				return cp;
			}
		}
		return null;
	}
	
	public static CreativePlayer addCreativePlayer(Player player){
		CreativePlayer cp = new CreativePlayer(player);
		ServerStorage.creativeplayers.add(cp);
		return cp;
	}
}
