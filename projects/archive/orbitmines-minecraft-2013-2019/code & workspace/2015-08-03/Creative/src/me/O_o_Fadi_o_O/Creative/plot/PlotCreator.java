package me.O_o_Fadi_o_O.Creative.plot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.ConfigManager;
import me.O_o_Fadi_o_O.Creative.managers.PlotManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlotCreator {

	Start start = Start.getInstance();
	
	public synchronized void createPlot(int PlotNumber, Player p){
	
		p.sendMessage(Start.TAG + "§dPreparing World...");
		TitleManager.setTitle(p, "", "§dPreparing World...", 20, 100, 0);
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		prepareWorld(p, PlotNumber);
		
	}
	
	public void prepareWorld(final Player p, final int PlotNumber){
		new BukkitRunnable(){
			public void run(){
				World w = StorageManager.creativeworld;
				
				p.sendMessage(Start.TAG + "§dGenerating Plot...");
				TitleManager.setTitle(p, "", "§dGenerating Plot...", 0, 1000, 0);
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				generatingPlot(p, PlotNumber, w);
			}
		}.runTaskLater(this.start, 5);
	}
	
	public void generatingPlot(final Player p, final int PlotNumber, final World w){
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				Location l = null;
				
				if(PlotNumber == 1){
					l = new Location(w, 0, 100, 0);
				}
				else{
					l = newPlotLocation(StorageManager.plotlocation.get(StorageManager.plotsamount));
				}
				
				for(Player player : Bukkit.getOnlinePlayers()){
					if(player.getName().equals("O_o_Fadi_o_O")){
						if(l != null){
							player.sendMessage(l.getWorld().getName() + ", " + l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ());
						}
						else{
							player.sendMessage("null");
						}
					}
				}
				
				generatePlotBlocks(l);
				
				p.sendMessage(Start.TAG + "§dSaving Data...");
				TitleManager.setTitle(p, "", "§dSaving Data...", 0, 100, 0);
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				savingData(p, PlotNumber, w, l);
			}
		}.runTaskLater(this.start, 20);
	}
	
	public void savingData(final Player p, final int PlotNumber, final World w, final Location l){
		new BukkitRunnable(){
			public void run(){
				start.setPlotAmount(PlotNumber);
				PlotManager.setPlotLocation(PlotNumber, l);
				PlotManager.setPlotMembers(PlotNumber, null);
				PlotManager.setPlotOwner(PlotNumber, p);
				PlotManager.setPlayersPlotHomeLocation(p, new Location(w, l.getBlockX() +0.5, l.getBlockY(), l.getBlockZ() +0.5, 180, 0));
				PlotManager.setPlayersPlotNumber(p, PlotNumber);
				PlotManager.setPlotCreatedDate(PlotNumber);
				PlotManager.setPlotColor(PlotNumber, DyeColor.GRAY);
				PlotManager.setPlotMode(PlotNumber, PlotMode.NORMAL);
				StorageManager.plotmembers.put(PlotNumber, PlotManager.getPlotMembers(PlotNumber));
				StorageManager.playerhasplot.put(p, true);
				
				for(String s : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
					int PlotNumbers = Integer.parseInt(s);
					
					StorageManager.plotmode.put(PlotNumbers, PlotManager.getPlotMode(PlotNumbers));
					StorageManager.plotcolor.put(PlotNumbers, PlotManager.getPlotColor(PlotNumbers));
					StorageManager.plotlocation.put(PlotNumbers, PlotManager.getPlotLocation(PlotNumbers));
					try{StorageManager.plotmembers.put(PlotNumbers, PlotManager.getPlotMembers(PlotNumbers));}catch(IllegalArgumentException ex){}
					try{StorageManager.plotowner.put(PlotNumbers, PlotManager.getPlotOwner(PlotNumbers));}catch(IllegalArgumentException ex){}
					StorageManager.plotcreateddate.put(PlotNumbers, PlotManager.getPlotCreatedDate(PlotNumbers));
				}
				
				p.sendMessage(Start.TAG + "§dPlot Ready!");
				TitleManager.setTitle(p, "", "§dPlot Ready!", 0, 100, 0);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
				
				generatePlotSigns(p);
				
				teleportPlayer(p);
			}
		}.runTaskLater(this.start, 20);
	}
	
	public void teleportPlayer(final Player p){
		p.sendMessage(Start.TAG + "§7Teleporting to your §dPlot§7...");
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.playersplothomelocation.get(p));
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
				TitleManager.setTitle(p, "", "§7Teleported to your §dPlot§7.", 0, 20, 20);
			}
		}.runTaskLater(this.start, 10);
	}
	
	@SuppressWarnings("deprecation")
	public static void generatePlotSigns(Player p){
		int PlotNumber = StorageManager.playersplotnumber.get(p);
		Location l = StorageManager.plotlocation.get(PlotNumber);
		String date = StorageManager.plotcreateddate.get(PlotNumber);
		
		World w = l.getWorld();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		{
			Location l1 = new Location(w, x +46, y -2, z -46); 
			w.getBlockAt(l1).setType(Material.SIGN_POST);
			w.getBlockAt(l1).setData((byte) 10);
			Sign s = (Sign) w.getBlockAt(l1).getState();
			s.setLine(0, "#" + PlotNumber);
			s.setLine(1, "§lOwner:");
			s.setLine(2, p.getName());
			s.setLine(3, date);
			
			s.update();
		}
		{
			Location l1 = new Location(w, x +46, y -2, z +46); 
			w.getBlockAt(l1).setType(Material.SIGN_POST);
			w.getBlockAt(l1).setData((byte) 14);
			Sign s = (Sign) w.getBlockAt(l1).getState();
			s.setLine(0, "#" + PlotNumber);
			s.setLine(1, "§lOwner:");
			s.setLine(2, p.getName());
			s.setLine(3, date);
			
			s.update();
		}
		{
			Location l1 = new Location(w, x -46, y -2, z +46); 
			w.getBlockAt(l1).setType(Material.SIGN_POST);
			w.getBlockAt(l1).setData((byte) 2);
			Sign s = (Sign) w.getBlockAt(l1).getState();
			s.setLine(0, "#" + PlotNumber);
			s.setLine(1, "§lOwner:");
			s.setLine(2, p.getName());
			s.setLine(3, date);
			
			s.update();
		}
		{
			Location l1 = new Location(w, x -46, y -2, z -46); 
			w.getBlockAt(l1).setType(Material.SIGN_POST);
			w.getBlockAt(l1).setData((byte) 6);
			Sign s = (Sign) w.getBlockAt(l1).getState();
			s.setLine(0, "#" + PlotNumber);
			s.setLine(1, "§lOwner:");
			s.setLine(2, p.getName());
			s.setLine(3, date);
			
			s.update();
		}
	}
	
	private Map<String, Long> lastReset = new HashMap<String, Long>();
	private final int resetcooldown = 900;
	
	public void resetPlot(Player p){
		long lastReset = 0;
		if(this.lastReset.containsKey(p.getName())){
			lastReset = this.lastReset.get(p.getName());
		}
		int cdmillis2 = resetcooldown * 1000;
				
		if(System.currentTimeMillis()-lastReset>=cdmillis2){
		
			int PlotNumber = StorageManager.playersplotnumber.get(p);
			Location l = StorageManager.plotlocation.get(PlotNumber);
			
			World w = l.getWorld();
			
			int x = l.getBlockX();
			int y = 93;
			int z = l.getBlockZ();
	
	
			resetPlotLayer(p, w, x -44, z -44, x +44, z +44, y);
			this.lastReset.put(p.getName(), System.currentTimeMillis());
		}
		else{
			p.sendMessage(Start.TAG + "You can only reset your §dPlot§7 once every §d15 minutes§7.");
		}
	}
	
	public void resetPlotLayer(final Player p, final World w, final int x1, final int z1, final int x2, final int z2, final int y){
		final Location l1 = new Location(w, x1, y, z1);
		final Location l2 = new Location(w, x2, y, z2);
		
		new BukkitRunnable(){
			public void run(){
				for(Block b : Start.getBlocksBetween(l1, l2)){
					b.setType(Material.AIR);
				}
				if(y != 255){
					TitleManager.setTitle(p, "§7Clearing §dPlot§7...", "§d" + (y - 92) + "§7/§d" + (255 - 93), 0, 20, 0);
					resetPlotLayer(p, w, x1, z1, x2, z2, y +1);
				}
				else{
					TitleManager.setTitle(p, "", "§7Cleared your §dPlot§7!", 0, 30, 40);
				}
			}
		}.runTaskLater(this.start, 3);
	}
	
	@SuppressWarnings("deprecation")
	public static void setOutlines(Location l, int data, Material m){
		World w = l.getWorld();
	
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
	
	
		{
			Location l1 = new Location(w, x -45, y -3, z +45);
			Location l2 = new Location(w, x +45, y -7, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x -45, y -3, z -45);
			Location l2 = new Location(w, x +45, y -7, z -45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x +45, y -3, z -44);
			Location l2 = new Location(w, x +45, y -7, z +44);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x -45, y -3, z -44);
			Location l2 = new Location(w, x -45, y -7, z +44);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		
		{
			Location l1 = new Location(w, x -47, y -3, z +47);
			Location l2 = new Location(w, x +47, y -7, z +47);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x -47, y -3, z -47);
			Location l2 = new Location(w, x +47, y -7, z -47);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x +47, y -3, z -46);
			Location l2 = new Location(w, x +47, y -7, z +46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
		{
			Location l1 = new Location(w, x -47, y -3, z -46);
			Location l2 = new Location(w, x -47, y -7, z +46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				 b.setType(m); 
				 b.setData((byte) data);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void setMidline(Location l, int data, Material m){
		World w = l.getWorld();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		List<Block> blocks = new ArrayList<Block>();
		
		{
			Location l1 = new Location(w, x -46, y -3, z +46);
			Location l2 = new Location(w, x +46, y -7, z +46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x -46, y -3, z -46);
			Location l2 = new Location(w, x +46, y -7, z -46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x +46, y -3, z -45);
			Location l2 = new Location(w, x +46, y -7, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x -46, y -3, z -45);
			Location l2 = new Location(w, x -46, y -7, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		
		for(Block b : blocks){
			 b.setType(m); 
			 b.setData((byte) data);
		}
	}
	
	public static void setPvPBarrier(Location l, Material barrier){
		World w = l.getWorld();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		List<Block> blocks = new ArrayList<Block>();
		
		{
			Location l1 = new Location(w, x -45, 255, z -45);
			Location l2 = new Location(w, x +45, 255, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x -46, y -2, z +46);
			Location l2 = new Location(w, x +46, 255, z +46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x -46, y -2, z -46);
			Location l2 = new Location(w, x +46, 255, z -46);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x +46, y -2, z -45);
			Location l2 = new Location(w, x +46, 255, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		{
			Location l1 = new Location(w, x -46, y -2, z -45);
			Location l2 = new Location(w, x -46, 255, z +45);
			for(Block b : Start.getBlocksBetween(l1, l2)){
				blocks.add(b);
			}
		}
		
		for(Block b : blocks){
			 b.setType(barrier); 
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void generatePlotBlocks(Location l){

		World w = l.getWorld();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		{Location l1 = new Location(w, x +0, y -1, z +0); w.getBlockAt(l1).setType(Material.WOOL); w.getBlockAt(l1).setData((byte) 15);}
		
		setOutlines(l, 15, Material.WOOL);
		setMidline(l, 7, Material.WOOL);
		
	}
	
	public static Location newPlotLocation(Location lastPlot){
		
		final int x = (int) lastPlot.getX();
		final int z = (int) lastPlot.getZ();
		final Location nextL = lastPlot;
		if (x < z) {
			if (-1 * x < z) {
				nextL.setX(nextL.getX() + 105);
				return nextL;
			}
			nextL.setZ(nextL.getZ() + 105);
			return nextL;
		}
		if (x > z) {
			if (-1 * x >= z) {
				nextL.setX(nextL.getX() - 105);
				return nextL;
			}
			nextL.setZ(nextL.getZ() - 105);
			return nextL;
		}
		if (x <= 0) {
			nextL.setZ(nextL.getZ() + 105);
			return nextL;
		}
		nextL.setZ(nextL.getZ() - 105);
		return nextL;
		
	}
}
