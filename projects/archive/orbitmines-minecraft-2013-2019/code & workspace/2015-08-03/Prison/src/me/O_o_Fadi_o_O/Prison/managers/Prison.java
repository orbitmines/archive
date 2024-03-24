package me.O_o_Fadi_o_O.Prison.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Prison {

	public static void teleportToMines(final Player p, Rank rank){
		p.sendMessage("§4§lPrison §8| §7Teleporting to the §a§l" + rank.toString().replaceAll("Plus", "+") + " Mine§7...");
		p.teleport(StorageManager.ranklocation.get(rank));
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	}
	
	public static void resetAllMines(boolean broadcastMessage){
		for(Rank rank : Rank.values()){
			try{
			resetMine(rank, broadcastMessage);
			}catch(Exception ex){}
		}
	}
	
	public static void resetMine(Rank rank, boolean broadcastMessage){
		
		for(Block b : StorageManager.rankmines.get(rank)){
			Random r = new Random();
			int randomInt = r.nextInt(101);
			
			if(rank == Rank.Z){
				if(isIntEqualTo(randomInt, 1, 95)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.COAL_ORE);}
			}
			if(rank == Rank.Y){
				if(isIntEqualTo(randomInt, 1, 90)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.COAL_ORE);}
			}
			if(rank == Rank.X){
				if(isIntEqualTo(randomInt, 1, 90)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 91, 95)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.IRON_ORE);}
			}
			if(rank == Rank.W){
				if(isIntEqualTo(randomInt, 1, 85)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 86, 95)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.IRON_ORE);}
			}
			if(rank == Rank.V){
				if(isIntEqualTo(randomInt, 1, 80)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 81, 90)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.IRON_ORE);}
			}
			if(rank == Rank.U){
				if(isIntEqualTo(randomInt, 1, 70)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 71, 80)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 81, 100)){b.setType(Material.IRON_ORE);}
			}
			if(rank == Rank.T){
				if(isIntEqualTo(randomInt, 1, 65)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 66, 79)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 80, 99)){b.setType(Material.IRON_ORE);}
				if(randomInt == 100){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.S){
				if(isIntEqualTo(randomInt, 1, 60)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 61, 75)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 76, 98)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 99, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.R){
				if(isIntEqualTo(randomInt, 1, 55)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 56, 72)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 73, 97)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 98, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.Q){
				if(isIntEqualTo(randomInt, 1, 50)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 51, 65)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 66, 95)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.P){
				if(isIntEqualTo(randomInt, 1, 50)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 51, 60)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 61, 93)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 94, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.O){
				if(isIntEqualTo(randomInt, 1, 45)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 46, 55)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 56, 90)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.N){
				if(isIntEqualTo(randomInt, 1, 40)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 41, 50)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 51, 85)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 86, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.M){
				if(isIntEqualTo(randomInt, 1, 40)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 41, 45)){b.setType(Material.COAL_ORE);}
				if(isIntEqualTo(randomInt, 46, 80)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 81, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.L){
				if(isIntEqualTo(randomInt, 1, 35)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 36, 75)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 76, 100)){b.setType(Material.DIAMOND_ORE);}
			}
			if(rank == Rank.K){
				if(isIntEqualTo(randomInt, 1, 35)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 36, 70)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 71, 99)){b.setType(Material.DIAMOND_ORE);}
				if(randomInt == 100){b.setType(Material.EMERALD_ORE);}
			}
			if(rank == Rank.J){
				if(isIntEqualTo(randomInt, 1, 30)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 31, 60)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 61, 95)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.EMERALD_ORE);}
			}
			if(rank == Rank.I){
				if(isIntEqualTo(randomInt, 1, 30)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 31, 50)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 51, 90)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 91, 99)){b.setType(Material.EMERALD_ORE);}
				if(randomInt == 100){b.setType(Material.DIAMOND_BLOCK);}
			}
			if(rank == Rank.H){
				if(isIntEqualTo(randomInt, 1, 25)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 26, 40)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 41, 85)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 86, 98)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 99, 100)){b.setType(Material.DIAMOND_BLOCK);}
			}
			if(rank == Rank.G){
				if(isIntEqualTo(randomInt, 1, 20)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 21, 35)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 36, 80)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 81, 95)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.DIAMOND_BLOCK);}
			}
			if(rank == Rank.F){
				if(isIntEqualTo(randomInt, 1, 20)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 21, 25)){b.setType(Material.IRON_ORE);}
				if(isIntEqualTo(randomInt, 26, 75)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 76, 90)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 91, 95)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.REDSTONE_ORE);}
			}
			if(rank == Rank.E){
				if(isIntEqualTo(randomInt, 1, 15)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 16, 65)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 66, 85)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 86, 90)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.REDSTONE_ORE);}
			}
			if(rank == Rank.D){
				if(isIntEqualTo(randomInt, 1, 10)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 11, 60)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 61, 80)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 81, 90)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.REDSTONE_ORE);}
			}
			if(rank == Rank.C){
				if(isIntEqualTo(randomInt, 1, 5)){b.setType(Material.STONE);}
				if(isIntEqualTo(randomInt, 6, 50)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 51, 75)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 76, 85)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 86, 95)){b.setType(Material.REDSTONE_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.LAPIS_ORE);}
			}
			if(rank == Rank.B){
				if(isIntEqualTo(randomInt, 1, 40)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 41, 65)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 66, 75)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 76, 85)){b.setType(Material.REDSTONE_ORE);}
				if(isIntEqualTo(randomInt, 86, 95)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.A){
				if(isIntEqualTo(randomInt, 1, 30)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 31, 55)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 56, 70)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 71, 80)){b.setType(Material.REDSTONE_ORE);}
				if(isIntEqualTo(randomInt, 81, 90)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.ZPlus){
				if(isIntEqualTo(randomInt, 1, 25)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 26, 55)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 56, 70)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 71, 75)){b.setType(Material.REDSTONE_ORE);}
				if(isIntEqualTo(randomInt, 76, 85)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 86, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.YPlus){
				if(isIntEqualTo(randomInt, 1, 20)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 21, 50)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 51, 70)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 71, 85)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 86, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.XPlus){
				if(isIntEqualTo(randomInt, 1, 10)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 11, 40)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 41, 60)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 61, 80)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 81, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.WPlus){
				if(isIntEqualTo(randomInt, 1, 5)){b.setType(Material.DIAMOND_ORE);}
				if(isIntEqualTo(randomInt, 6, 30)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 31, 55)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 56, 80)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 81, 100)){b.setType(Material.EMERALD_BLOCK);}
			}
			if(rank == Rank.VPlus){
				if(isIntEqualTo(randomInt, 1, 20)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 21, 45)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 46, 70)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 71, 95)){b.setType(Material.EMERALD_BLOCK);}
				if(isIntEqualTo(randomInt, 96, 100)){b.setType(Material.GOLD_ORE);}
			}
			if(rank == Rank.UPlus){
				if(isIntEqualTo(randomInt, 1, 15)){b.setType(Material.EMERALD_ORE);}
				if(isIntEqualTo(randomInt, 16, 45)){b.setType(Material.DIAMOND_BLOCK);}
				if(isIntEqualTo(randomInt, 46, 70)){b.setType(Material.LAPIS_ORE);}
				if(isIntEqualTo(randomInt, 71, 90)){b.setType(Material.EMERALD_BLOCK);}
				if(isIntEqualTo(randomInt, 91, 100)){b.setType(Material.GOLD_ORE);}
			}
		}
		
		if(broadcastMessage == true){
			Bukkit.broadcastMessage(Start.TAG + "The §a§l" + rank.toString().replace("Plus", "+") + " Mine§7 has been §6reset§7!");
		}
	}
	
	public static boolean isIntEqualTo(int number, int lowest, int highest){
		boolean equalTo = false;
		for(int i = lowest; i <= highest; i++){
			if(number == i){
				equalTo = true;
			}
		}
		return equalTo;
	}
	
	public static void getAllMineLocations(World w){
		for(Rank rank : Rank.values()){
			try{
			List<Block> allMineBlocks = new ArrayList<Block>();
			for(String s : ConfigManager.mines.getConfigurationSection("mines." + rank.toString() + ".Blocks").getKeys(false)){
				int x = ConfigManager.mines.getInt("mines." + rank.toString() + ".Blocks." + s + ".x");
				int y = ConfigManager.mines.getInt("mines." + rank.toString() + ".Blocks." + s + ".y");
				int z = ConfigManager.mines.getInt("mines." + rank.toString() + ".Blocks." + s + ".z");
				allMineBlocks.add(w.getBlockAt(new Location(w, x, y, z)));
			}
			StorageManager.rankmines.put(rank, allMineBlocks);
			}catch(Exception ex){}
		}
	}
	
	public static void setMineLocation(World w, Rank rank){
		
		Location l1 = null;
		Location l2 = null;
		
		if(rank == Rank.Z){l1 = new Location(w, -1498, 11, -360); l2 = new Location(w, -1472, 2, -333);}
		if(rank == Rank.Y){l1 = new Location(w, -1535, 11, -542); l2 = new Location(w, -1509, 2, -515);}
		if(rank == Rank.X){l1 = new Location(w, -1712, 11, -567); l2 = new Location(w, -1686, 2, -540);}
		if(rank == Rank.W){l1 = new Location(w, -1692, 11, -367); l2 = new Location(w, -1666, 2, -340);}
		if(rank == Rank.V){l1 = new Location(w, -1869, 11, -558); l2 = new Location(w, -1843, 2, -531);}
		if(rank == Rank.U){l1 = new Location(w, -1829, 11, -340); l2 = new Location(w, -1803, 2, -313);}
		if(rank == Rank.T){l1 = new Location(w, -2008, 11, -545); l2 = new Location(w, -1982, 2, -518);}
		if(rank == Rank.S){l1 = new Location(w, -1970, 11, -331); l2 = new Location(w, -1944, 2, -304);}
		if(rank == Rank.R){l1 = new Location(w, -2137, 11, -535); l2 = new Location(w, -2111, 2, -508);}
		if(rank == Rank.Q){l1 = new Location(w, -2100, 11, -324); l2 = new Location(w, -2074, 2, -297);}
		if(rank == Rank.P){l1 = new Location(w, -2268, 11, -513); l2 = new Location(w, -2242, 2, -486);}
		if(rank == Rank.O){l1 = new Location(w, -2234, 11, -302); l2 = new Location(w, -2208, 2, -275);}
		if(rank == Rank.N){l1 = new Location(w, -2383, 11, -510); l2 = new Location(w, -2357, 2, -483);}
		if(rank == Rank.M){l1 = new Location(w, -2365, 11, -293); l2 = new Location(w, -2339, 2, -266);}
		if(rank == Rank.L){l1 = new Location(w, -2531, 11, -505); l2 = new Location(w, -2505, 2, -478);}
		if(rank == Rank.K){l1 = new Location(w, -2501, 11, -283); l2 = new Location(w, -2475, 2, -256);}
		if(rank == Rank.J){l1 = new Location(w, -2664, 11, -508); l2 = new Location(w, -2638, 2, -481);}
		if(rank == Rank.I){l1 = new Location(w, -2628, 11, -285); l2 = new Location(w, -2602, 2, -258);}
		if(rank == Rank.H){l1 = new Location(w, -2823, 11, -498); l2 = new Location(w, -2797, 2, -471);}
		if(rank == Rank.G){l1 = new Location(w, -2768, 11, -288); l2 = new Location(w, -2742, 2, -261);}
		if(rank == Rank.F){l1 = new Location(w, -2955, 11, -501); l2 = new Location(w, -2929, 2, -474);}
		if(rank == Rank.E){l1 = new Location(w, -2917, 11, -287); l2 = new Location(w, -2891, 2, -260);}
		if(rank == Rank.D){l1 = new Location(w, -3087, 11, -493); l2 = new Location(w, -3061, 2, -466);}
		if(rank == Rank.C){l1 = new Location(w, -3049, 11, -281); l2 = new Location(w, -3023, 2, -254);}
		if(rank == Rank.B){l1 = new Location(w, -3268, 11, -480); l2 = new Location(w, -3242, 2, -453);}
		if(rank == Rank.A){l1 = new Location(w, -3215, 11, -278); l2 = new Location(w, -3189, 2, -251);}
		if(rank == Rank.ZPlus){l1 = new Location(w, -3426, 11, -482); l2 = new Location(w, -3400, 2, -455);}
		if(rank == Rank.YPlus){l1 = new Location(w, -3362, 11, -274); l2 = new Location(w, -3336, 2, -247);}
		if(rank == Rank.XPlus){l1 = new Location(w, -3545, 11, -481); l2 = new Location(w, -3519, 2, -454);}
		if(rank == Rank.WPlus){l1 = new Location(w, -3498, 11, -265); l2 = new Location(w, -3472, 2, -238);}
		if(rank == Rank.VPlus){l1 = new Location(w, -3695, 11, -462); l2 = new Location(w, -3669, 2, -435);}
		if(rank == Rank.UPlus){l1 = new Location(w, -3646, 11, -261); l2 = new Location(w, -3620, 2, -234);}
		//TODO
		
		List<Block> blocks = getBlocksBetween(l1, l2);
		
		int i = 0;
		
		for(Block b : blocks){
			if(b.getType() == Material.STAINED_CLAY){
				i++;
				ConfigManager.mines.set("mines." + rank.toString() + ".Blocks." + i + ".x", b.getLocation().getBlockX());
				ConfigManager.mines.set("mines." + rank.toString() + ".Blocks." + i + ".y", b.getLocation().getBlockY());
				ConfigManager.mines.set("mines." + rank.toString() + ".Blocks." + i + ".z", b.getLocation().getBlockZ());
			}
		}
		ConfigManager.saveMines();
		
	}
	
	public static void registerAllRankLocations(World w){
		StorageManager.ranklocation.put(Rank.Z, new Location(StorageManager.prisonworld, -1451.5, 11, -372.5, 90, 0));
		StorageManager.ranklocation.put(Rank.Y, new Location(StorageManager.prisonworld, -1488.5, 11, -554.5, 90, 0));
		StorageManager.ranklocation.put(Rank.X, new Location(StorageManager.prisonworld, -1665.5, 11, -579.5, 90, 0));
		StorageManager.ranklocation.put(Rank.W, new Location(StorageManager.prisonworld, -1645.5, 11, -379.5, 90, 0));
		StorageManager.ranklocation.put(Rank.V, new Location(StorageManager.prisonworld, -1822.5, 11, -570.5, 90, 0));
		StorageManager.ranklocation.put(Rank.U, new Location(StorageManager.prisonworld, -1782.5, 11, -352.5, 90, 0));
		StorageManager.ranklocation.put(Rank.T, new Location(StorageManager.prisonworld, -1961.5, 11, -557.5, 90, 0));
		StorageManager.ranklocation.put(Rank.S, new Location(StorageManager.prisonworld, -1923.5, 11, -343.5, 90, 0));
		StorageManager.ranklocation.put(Rank.R, new Location(StorageManager.prisonworld, -2090.5, 11, -547.5, 90, 0));
		StorageManager.ranklocation.put(Rank.Q, new Location(StorageManager.prisonworld, -2053.5, 11, -336.5, 90, 0));
		StorageManager.ranklocation.put(Rank.P, new Location(StorageManager.prisonworld, -2221.5, 11, -525.5, 90, 0));
		StorageManager.ranklocation.put(Rank.O, new Location(StorageManager.prisonworld, -2187.5, 11, -314.5, 90, 0));
		StorageManager.ranklocation.put(Rank.N, new Location(StorageManager.prisonworld, -2336.5, 11, -522.5, 90, 0));
		StorageManager.ranklocation.put(Rank.M, new Location(StorageManager.prisonworld, -2318.5, 11, -305.5, 90, 0));
		StorageManager.ranklocation.put(Rank.L, new Location(StorageManager.prisonworld, -2484.5, 11, -517.5, 90, 0));
		StorageManager.ranklocation.put(Rank.K, new Location(StorageManager.prisonworld, -2454.5, 11, -295.5, 90, 0));
		StorageManager.ranklocation.put(Rank.J, new Location(StorageManager.prisonworld, -2617.5, 11, -520.5, 90, 0));
		StorageManager.ranklocation.put(Rank.I, new Location(StorageManager.prisonworld, -2581.5, 11, -297.5, 90, 0));
		StorageManager.ranklocation.put(Rank.H, new Location(StorageManager.prisonworld, -2776.5, 11, -510.5, 90, 0));
		StorageManager.ranklocation.put(Rank.G, new Location(StorageManager.prisonworld, -2721.5, 11, -300.5, 90, 0));
		StorageManager.ranklocation.put(Rank.F, new Location(StorageManager.prisonworld, -2908.5, 11, -513.5, 90, 0));
		StorageManager.ranklocation.put(Rank.E, new Location(StorageManager.prisonworld, -2870.5, 11, -299.5, 90, 0));
		StorageManager.ranklocation.put(Rank.D, new Location(StorageManager.prisonworld, -3040.5, 11, -505.5, 90, 0));
		StorageManager.ranklocation.put(Rank.C, new Location(StorageManager.prisonworld, -3002.5, 11, -293.5, 90, 0));
		StorageManager.ranklocation.put(Rank.B, new Location(StorageManager.prisonworld, -3221.5, 11, -492.5, 90, 0));
		StorageManager.ranklocation.put(Rank.A, new Location(StorageManager.prisonworld, -3168.5, 11, -290.5, 90, 0));
		StorageManager.ranklocation.put(Rank.ZPlus, new Location(StorageManager.prisonworld, -3379.5, 11, -494.5, 90, 0));
		StorageManager.ranklocation.put(Rank.YPlus, new Location(StorageManager.prisonworld, -3315.5, 11, -286.5, 90, 0));
		StorageManager.ranklocation.put(Rank.XPlus, new Location(StorageManager.prisonworld, -3498.5, 11, -493.5, 90, 0));
		StorageManager.ranklocation.put(Rank.WPlus, new Location(StorageManager.prisonworld, -3451.5, 11, -277.5, 90, 0));
		StorageManager.ranklocation.put(Rank.VPlus, new Location(StorageManager.prisonworld, -3648.5, 11, -474.5, 90, 0));
		StorageManager.ranklocation.put(Rank.UPlus, new Location(StorageManager.prisonworld, -3599.5, 11, -273.5, 90, 0));
		
		//TODO
	}
	
	public static void registerAllMineCountdowns(World w){
		
		StorageManager.rankmineminutes.put(Rank.Z, 1);
		StorageManager.rankmineseconds.put(Rank.Z, 0);
		
		StorageManager.rankmineminutes.put(Rank.Y, 2);
		StorageManager.rankmineseconds.put(Rank.Y, 0);
		
		StorageManager.rankmineminutes.put(Rank.X, 3);
		StorageManager.rankmineseconds.put(Rank.X, 0);
		
		StorageManager.rankmineminutes.put(Rank.W, 4);
		StorageManager.rankmineseconds.put(Rank.W, 0);
		
		StorageManager.rankmineminutes.put(Rank.V, 5);
		StorageManager.rankmineseconds.put(Rank.V, 0);
		
		StorageManager.rankmineminutes.put(Rank.U, 6);
		StorageManager.rankmineseconds.put(Rank.U, 0);
		
		StorageManager.rankmineminutes.put(Rank.T, 7);
		StorageManager.rankmineseconds.put(Rank.T, 0);
		
		StorageManager.rankmineminutes.put(Rank.S, 8);
		StorageManager.rankmineseconds.put(Rank.S, 0);
		
		StorageManager.rankmineminutes.put(Rank.R, 9);
		StorageManager.rankmineseconds.put(Rank.R, 0);
		
		StorageManager.rankmineminutes.put(Rank.Q, 10);
		StorageManager.rankmineseconds.put(Rank.Q, 0);
		
		StorageManager.rankmineminutes.put(Rank.P, 11);
		StorageManager.rankmineseconds.put(Rank.P, 0);
		
		StorageManager.rankmineminutes.put(Rank.O, 12);
		StorageManager.rankmineseconds.put(Rank.O, 0);
		
		StorageManager.rankmineminutes.put(Rank.N, 13);
		StorageManager.rankmineseconds.put(Rank.N, 0);
		
		StorageManager.rankmineminutes.put(Rank.M, 14);
		StorageManager.rankmineseconds.put(Rank.M, 0);
		
		StorageManager.rankmineminutes.put(Rank.L, 15);
		StorageManager.rankmineseconds.put(Rank.L, 0);

		StorageManager.rankmineminutes.put(Rank.K, 16);
		StorageManager.rankmineseconds.put(Rank.K, 0);

		StorageManager.rankmineminutes.put(Rank.J, 17);
		StorageManager.rankmineseconds.put(Rank.J, 0);
		
		StorageManager.rankmineminutes.put(Rank.I, 18);
		StorageManager.rankmineseconds.put(Rank.I, 0);
		
		StorageManager.rankmineminutes.put(Rank.H, 19);
		StorageManager.rankmineseconds.put(Rank.H, 0);
		
		StorageManager.rankmineminutes.put(Rank.G, 20);
		StorageManager.rankmineseconds.put(Rank.G, 0);
		
		StorageManager.rankmineminutes.put(Rank.F, 21);
		StorageManager.rankmineseconds.put(Rank.F, 0);
		
		StorageManager.rankmineminutes.put(Rank.E, 22);
		StorageManager.rankmineseconds.put(Rank.E, 0);
		
		StorageManager.rankmineminutes.put(Rank.D, 23);
		StorageManager.rankmineseconds.put(Rank.D, 0);
		
		StorageManager.rankmineminutes.put(Rank.C, 24);
		StorageManager.rankmineseconds.put(Rank.C, 0);
		
		StorageManager.rankmineminutes.put(Rank.B, 25);
		StorageManager.rankmineseconds.put(Rank.B, 0);
		
		StorageManager.rankmineminutes.put(Rank.A, 26);
		StorageManager.rankmineseconds.put(Rank.A, 0);
		
		StorageManager.rankmineminutes.put(Rank.ZPlus, 27);
		StorageManager.rankmineseconds.put(Rank.ZPlus, 0);
		
		StorageManager.rankmineminutes.put(Rank.YPlus, 28);
		StorageManager.rankmineseconds.put(Rank.YPlus, 0);
		
		StorageManager.rankmineminutes.put(Rank.XPlus, 29);
		StorageManager.rankmineseconds.put(Rank.XPlus, 0);
		
		StorageManager.rankmineminutes.put(Rank.WPlus, 30);
		StorageManager.rankmineseconds.put(Rank.WPlus, 0);
		
		StorageManager.rankmineminutes.put(Rank.VPlus, 31);
		StorageManager.rankmineseconds.put(Rank.VPlus, 0);
		
		StorageManager.rankmineminutes.put(Rank.UPlus, 32);
		StorageManager.rankmineseconds.put(Rank.UPlus, 0);
	}
	
	public static void registerAllMineCountdownLocation(World w){
		StorageManager.rankminecountdownlocation.put(Rank.Z, new Location(w, -1485, 15, -346));
		StorageManager.rankminecountdownlocation.put(Rank.Y, new Location(w, -1522, 15, -528));
		StorageManager.rankminecountdownlocation.put(Rank.X, new Location(w, -1699, 15, -553));
		StorageManager.rankminecountdownlocation.put(Rank.W, new Location(w, -1679, 15, -353));
		StorageManager.rankminecountdownlocation.put(Rank.V, new Location(w, -1856, 15, -544));
		StorageManager.rankminecountdownlocation.put(Rank.U, new Location(w, -1816, 15, -326));
		StorageManager.rankminecountdownlocation.put(Rank.T, new Location(w, -1995, 15, -531));
		StorageManager.rankminecountdownlocation.put(Rank.S, new Location(w, -1957, 15, -317));
		StorageManager.rankminecountdownlocation.put(Rank.R, new Location(w, -2124, 15, -521));
		StorageManager.rankminecountdownlocation.put(Rank.Q, new Location(w, -2087, 15, -310));
		StorageManager.rankminecountdownlocation.put(Rank.P, new Location(w, -2255, 15, -499));
		StorageManager.rankminecountdownlocation.put(Rank.O, new Location(w, -2221, 15, -288));
		StorageManager.rankminecountdownlocation.put(Rank.N, new Location(w, -2370, 15, -496));
		StorageManager.rankminecountdownlocation.put(Rank.M, new Location(w, -2352, 15, -279));
		StorageManager.rankminecountdownlocation.put(Rank.L, new Location(w, -2518, 15, -491));
		StorageManager.rankminecountdownlocation.put(Rank.K, new Location(w, -2488, 15, -269));
		StorageManager.rankminecountdownlocation.put(Rank.J, new Location(w, -2651, 15, -494));
		StorageManager.rankminecountdownlocation.put(Rank.I, new Location(w, -2615, 15, -271));
		StorageManager.rankminecountdownlocation.put(Rank.H, new Location(w, -2810, 15, -484));
		StorageManager.rankminecountdownlocation.put(Rank.G, new Location(w, -2755, 15, -274));
		StorageManager.rankminecountdownlocation.put(Rank.F, new Location(w, -2942, 15, -487));
		StorageManager.rankminecountdownlocation.put(Rank.E, new Location(w, -2904, 15, -273));
		StorageManager.rankminecountdownlocation.put(Rank.D, new Location(w, -3074, 15, -479));
		StorageManager.rankminecountdownlocation.put(Rank.C, new Location(w, -3036, 15, -267));
		StorageManager.rankminecountdownlocation.put(Rank.B, new Location(w, -3255, 15, -466));
		StorageManager.rankminecountdownlocation.put(Rank.A, new Location(w, -3202, 15, -264));
		StorageManager.rankminecountdownlocation.put(Rank.ZPlus, new Location(w, -3413, 15, -468));
		StorageManager.rankminecountdownlocation.put(Rank.YPlus, new Location(w, -3349, 15, -260));
		StorageManager.rankminecountdownlocation.put(Rank.XPlus, new Location(w, -3532, 15, -467));
		StorageManager.rankminecountdownlocation.put(Rank.WPlus, new Location(w, -3485, 15, -251));
		StorageManager.rankminecountdownlocation.put(Rank.VPlus, new Location(w, -3682, 15, -448));
		StorageManager.rankminecountdownlocation.put(Rank.UPlus, new Location(w, -3633, 15, -247));
		
		//TODO
	}
	
	public static void registerAllSignBlocks(World w){
		for(Rank rank : Rank.values()){
			try{
				List<Location> locList = getSignBlocks(w, rank);
				StorageManager.ranksigns.put(rank, locList);
			}catch(Exception ex){}
		}
	}
	
	public static List<Location> getSignBlocks(World w, Rank rank){
		List<Location> locList = new ArrayList<Location>();
		if(rank == Rank.Z){
			{Location l = new Location(w, -1454, 13, -373); locList.add(l);}
			{Location l = new Location(w, -1454, 12, -372); locList.add(l);}
			{Location l = new Location(w, -1454, 12, -373); locList.add(l);}
			{Location l = new Location(w, -1454, 12, -374); locList.add(l);}
			{Location l = new Location(w, -1467, 10, -360); locList.add(l);}
			{Location l = new Location(w, -1468, 10, -360); locList.add(l);}
		}
		if(rank == Rank.Y){
			{Location l = new Location(w, -1491, 13, -555); locList.add(l);}
			{Location l = new Location(w, -1491, 12, -554); locList.add(l);}
			{Location l = new Location(w, -1491, 12, -555); locList.add(l);}
			{Location l = new Location(w, -1491, 12, -556); locList.add(l);}
			{Location l = new Location(w, -1504, 10, -542); locList.add(l);}
			{Location l = new Location(w, -1505, 10, -542); locList.add(l);}
		}
		if(rank == Rank.X){
			{Location l = new Location(w, -1668, 13, -580); locList.add(l);}
			{Location l = new Location(w, -1668, 12, -579); locList.add(l);}
			{Location l = new Location(w, -1668, 12, -580); locList.add(l);}
			{Location l = new Location(w, -1668, 12, -581); locList.add(l);}
			{Location l = new Location(w, -1681, 10, -567); locList.add(l);}
			{Location l = new Location(w, -1682, 10, -567); locList.add(l);}
		}
		if(rank == Rank.W){
			{Location l = new Location(w, -1648, 13, -380); locList.add(l);}
			{Location l = new Location(w, -1648, 12, -379); locList.add(l);}
			{Location l = new Location(w, -1648, 12, -380); locList.add(l);}
			{Location l = new Location(w, -1648, 12, -381); locList.add(l);}
			{Location l = new Location(w, -1661, 10, -367); locList.add(l);}
			{Location l = new Location(w, -1662, 10, -367); locList.add(l);}
		}
		if(rank == Rank.V){
			{Location l = new Location(w, -1825, 13, -571); locList.add(l);}
			{Location l = new Location(w, -1825, 12, -570); locList.add(l);}
			{Location l = new Location(w, -1825, 12, -571); locList.add(l);}
			{Location l = new Location(w, -1825, 12, -572); locList.add(l);}
			{Location l = new Location(w, -1838, 10, -558); locList.add(l);}
			{Location l = new Location(w, -1839, 10, -558); locList.add(l);}
		}
		if(rank == Rank.U){
			{Location l = new Location(w, -1785, 13, -353); locList.add(l);}
			{Location l = new Location(w, -1785, 12, -352); locList.add(l);}
			{Location l = new Location(w, -1785, 12, -353); locList.add(l);}
			{Location l = new Location(w, -1785, 12, -354); locList.add(l);}
			{Location l = new Location(w, -1798, 10, -340); locList.add(l);}
			{Location l = new Location(w, -1799, 10, -340); locList.add(l);}
		}
		if(rank == Rank.T){
			{Location l = new Location(w, -1964, 13, -558); locList.add(l);}
			{Location l = new Location(w, -1964, 12, -557); locList.add(l);}
			{Location l = new Location(w, -1964, 12, -558); locList.add(l);}
			{Location l = new Location(w, -1964, 12, -559); locList.add(l);}
			{Location l = new Location(w, -1977, 10, -545); locList.add(l);}
			{Location l = new Location(w, -1978, 10, -545); locList.add(l);}
		}
		if(rank == Rank.S){
			{Location l = new Location(w, -1926, 13, -344); locList.add(l);}
			{Location l = new Location(w, -1926, 12, -343); locList.add(l);}
			{Location l = new Location(w, -1926, 12, -344); locList.add(l);}
			{Location l = new Location(w, -1926, 12, -345); locList.add(l);}
			{Location l = new Location(w, -1939, 10, -331); locList.add(l);}
			{Location l = new Location(w, -1940, 10, -331); locList.add(l);}
		}
		if(rank == Rank.R){
			{Location l = new Location(w, -2093, 13, -548); locList.add(l);}
			{Location l = new Location(w, -2093, 12, -547); locList.add(l);}
			{Location l = new Location(w, -2093, 12, -548); locList.add(l);}
			{Location l = new Location(w, -2093, 12, -549); locList.add(l);}
			{Location l = new Location(w, -2106, 10, -535); locList.add(l);}
			{Location l = new Location(w, -2107, 10, -535); locList.add(l);}
		}
		if(rank == Rank.Q){
			{Location l = new Location(w, -2056, 13, -337); locList.add(l);}
			{Location l = new Location(w, -2056, 12, -336); locList.add(l);}
			{Location l = new Location(w, -2056, 12, -337); locList.add(l);}
			{Location l = new Location(w, -2056, 12, -338); locList.add(l);}
			{Location l = new Location(w, -2069, 10, -324); locList.add(l);}
			{Location l = new Location(w, -2070, 10, -324); locList.add(l);}
		}
		if(rank == Rank.P){
			{Location l = new Location(w, -2224, 13, -526); locList.add(l);}
			{Location l = new Location(w, -2224, 12, -525); locList.add(l);}
			{Location l = new Location(w, -2224, 12, -526); locList.add(l);}
			{Location l = new Location(w, -2224, 12, -527); locList.add(l);}
			{Location l = new Location(w, -2237, 10, -513); locList.add(l);}
			{Location l = new Location(w, -2238, 10, -513); locList.add(l);}
		}
		if(rank == Rank.O){
			{Location l = new Location(w, -2190, 13, -315); locList.add(l);}
			{Location l = new Location(w, -2190, 12, -314); locList.add(l);}
			{Location l = new Location(w, -2190, 12, -315); locList.add(l);}
			{Location l = new Location(w, -2190, 12, -316); locList.add(l);}
			{Location l = new Location(w, -2203, 10, -302); locList.add(l);}
			{Location l = new Location(w, -2204, 10, -302); locList.add(l);}
		}
		if(rank == Rank.N){
			{Location l = new Location(w, -2339, 13, -523); locList.add(l);}
			{Location l = new Location(w, -2339, 12, -522); locList.add(l);}
			{Location l = new Location(w, -2339, 12, -523); locList.add(l);}
			{Location l = new Location(w, -2339, 12, -524); locList.add(l);}
			{Location l = new Location(w, -2352, 10, -510); locList.add(l);}
			{Location l = new Location(w, -2353, 10, -510); locList.add(l);}
		}
		if(rank == Rank.M){
			{Location l = new Location(w, -2321, 13, -306); locList.add(l);}
			{Location l = new Location(w, -2321, 12, -305); locList.add(l);}
			{Location l = new Location(w, -2321, 12, -306); locList.add(l);}
			{Location l = new Location(w, -2321, 12, -307); locList.add(l);}
			{Location l = new Location(w, -2334, 10, -293); locList.add(l);}
			{Location l = new Location(w, -2335, 10, -293); locList.add(l);}
		}
		if(rank == Rank.L){
			{Location l = new Location(w, -2487, 13, -518); locList.add(l);}
			{Location l = new Location(w, -2487, 12, -517); locList.add(l);}
			{Location l = new Location(w, -2487, 12, -518); locList.add(l);}
			{Location l = new Location(w, -2487, 12, -519); locList.add(l);}
			{Location l = new Location(w, -2500, 10, -505); locList.add(l);}
			{Location l = new Location(w, -2501, 10, -505); locList.add(l);}
		}
		if(rank == Rank.K){
			{Location l = new Location(w, -2457, 13, -296); locList.add(l);}
			{Location l = new Location(w, -2457, 12, -295); locList.add(l);}
			{Location l = new Location(w, -2457, 12, -296); locList.add(l);}
			{Location l = new Location(w, -2457, 12, -297); locList.add(l);}
			{Location l = new Location(w, -2470, 10, -283); locList.add(l);}
			{Location l = new Location(w, -2471, 10, -283); locList.add(l);}
		}
		if(rank == Rank.J){
			{Location l = new Location(w, -2620, 13, -521); locList.add(l);}
			{Location l = new Location(w, -2620, 12, -520); locList.add(l);}
			{Location l = new Location(w, -2620, 12, -521); locList.add(l);}
			{Location l = new Location(w, -2620, 12, -522); locList.add(l);}
			{Location l = new Location(w, -2633, 10, -508); locList.add(l);}
			{Location l = new Location(w, -2634, 10, -508); locList.add(l);}
		}
		if(rank == Rank.I){
			{Location l = new Location(w, -2584, 13, -298); locList.add(l);}
			{Location l = new Location(w, -2584, 12, -297); locList.add(l);}
			{Location l = new Location(w, -2584, 12, -298); locList.add(l);}
			{Location l = new Location(w, -2584, 12, -299); locList.add(l);}
			{Location l = new Location(w, -2597, 10, -285); locList.add(l);}
			{Location l = new Location(w, -2598, 10, -285); locList.add(l);}
		}
		if(rank == Rank.H){
			{Location l = new Location(w, -2779, 13, -511); locList.add(l);}
			{Location l = new Location(w, -2779, 12, -510); locList.add(l);}
			{Location l = new Location(w, -2779, 12, -511); locList.add(l);}
			{Location l = new Location(w, -2779, 12, -512); locList.add(l);}
			{Location l = new Location(w, -2792, 10, -498); locList.add(l);}
			{Location l = new Location(w, -2793, 10, -498); locList.add(l);}
		}
		if(rank == Rank.G){
			{Location l = new Location(w, -2724, 13, -301); locList.add(l);}
			{Location l = new Location(w, -2724, 12, -300); locList.add(l);}
			{Location l = new Location(w, -2724, 12, -301); locList.add(l);}
			{Location l = new Location(w, -2724, 12, -302); locList.add(l);}
			{Location l = new Location(w, -2737, 10, -288); locList.add(l);}
			{Location l = new Location(w, -2738, 10, -288); locList.add(l);}
		}
		if(rank == Rank.F){
			{Location l = new Location(w, -2911, 13, -514); locList.add(l);}
			{Location l = new Location(w, -2911, 12, -513); locList.add(l);}
			{Location l = new Location(w, -2911, 12, -514); locList.add(l);}
			{Location l = new Location(w, -2911, 12, -515); locList.add(l);}
			{Location l = new Location(w, -2924, 10, -501); locList.add(l);}
			{Location l = new Location(w, -2925, 10, -501); locList.add(l);}
		}
		if(rank == Rank.E){
			{Location l = new Location(w, -2873, 13, -300); locList.add(l);}
			{Location l = new Location(w, -2873, 12, -299); locList.add(l);}
			{Location l = new Location(w, -2873, 12, -300); locList.add(l);}
			{Location l = new Location(w, -2873, 12, -301); locList.add(l);}
			{Location l = new Location(w, -2886, 10, -287); locList.add(l);}
			{Location l = new Location(w, -2887, 10, -287); locList.add(l);}
		}
		if(rank == Rank.D){
			{Location l = new Location(w, -3043, 13, -506); locList.add(l);}
			{Location l = new Location(w, -3043, 12, -505); locList.add(l);}
			{Location l = new Location(w, -3043, 12, -506); locList.add(l);}
			{Location l = new Location(w, -3043, 12, -507); locList.add(l);}
			{Location l = new Location(w, -3056, 10, -493); locList.add(l);}
			{Location l = new Location(w, -3057, 10, -493); locList.add(l);}
		}
		if(rank == Rank.C){
			{Location l = new Location(w, -3005, 13, -294); locList.add(l);}
			{Location l = new Location(w, -3005, 12, -293); locList.add(l);}
			{Location l = new Location(w, -3005, 12, -294); locList.add(l);}
			{Location l = new Location(w, -3005, 12, -295); locList.add(l);}
			{Location l = new Location(w, -3018, 10, -281); locList.add(l);}
			{Location l = new Location(w, -3019, 10, -281); locList.add(l);}
		}
		if(rank == Rank.B){
			{Location l = new Location(w, -3224, 13, -493); locList.add(l);}
			{Location l = new Location(w, -3224, 12, -492); locList.add(l);}
			{Location l = new Location(w, -3224, 12, -493); locList.add(l);}
			{Location l = new Location(w, -3224, 12, -494); locList.add(l);}
			{Location l = new Location(w, -3237, 10, -480); locList.add(l);}
			{Location l = new Location(w, -3238, 10, -480); locList.add(l);}
		}
		if(rank == Rank.A){
			{Location l = new Location(w, -3171, 13, -291); locList.add(l);}
			{Location l = new Location(w, -3171, 12, -290); locList.add(l);}
			{Location l = new Location(w, -3171, 12, -291); locList.add(l);}
			{Location l = new Location(w, -3171, 12, -292); locList.add(l);}
			{Location l = new Location(w, -3184, 10, -278); locList.add(l);}
			{Location l = new Location(w, -3185, 10, -278); locList.add(l);}
		}
		if(rank == Rank.ZPlus){
			{Location l = new Location(w, -3382, 13, -495); locList.add(l);}
			{Location l = new Location(w, -3382, 12, -494); locList.add(l);}
			{Location l = new Location(w, -3382, 12, -495); locList.add(l);}
			{Location l = new Location(w, -3382, 12, -496); locList.add(l);}
			{Location l = new Location(w, -3395, 10, -482); locList.add(l);}
			{Location l = new Location(w, -3396, 10, -482); locList.add(l);}
		}
		if(rank == Rank.YPlus){
			{Location l = new Location(w, -3318, 13, -287); locList.add(l);}
			{Location l = new Location(w, -3318, 12, -286); locList.add(l);}
			{Location l = new Location(w, -3318, 12, -287); locList.add(l);}
			{Location l = new Location(w, -3318, 12, -288); locList.add(l);}
			{Location l = new Location(w, -3331, 10, -274); locList.add(l);}
			{Location l = new Location(w, -3332, 10, -274); locList.add(l);}
		}
		if(rank == Rank.XPlus){
			{Location l = new Location(w, -3501, 13, -494); locList.add(l);}
			{Location l = new Location(w, -3501, 12, -493); locList.add(l);}
			{Location l = new Location(w, -3501, 12, -494); locList.add(l);}
			{Location l = new Location(w, -3501, 12, -495); locList.add(l);}
			{Location l = new Location(w, -3514, 10, -481); locList.add(l);}
			{Location l = new Location(w, -3515, 10, -481); locList.add(l);}
		}
		if(rank == Rank.WPlus){
			{Location l = new Location(w, -3454, 13, -278); locList.add(l);}
			{Location l = new Location(w, -3454, 12, -277); locList.add(l);}
			{Location l = new Location(w, -3454, 12, -278); locList.add(l);}
			{Location l = new Location(w, -3454, 12, -279); locList.add(l);}
			{Location l = new Location(w, -3467, 10, -265); locList.add(l);}
			{Location l = new Location(w, -3468, 10, -265); locList.add(l);}
		}
		if(rank == Rank.VPlus){
			{Location l = new Location(w, -3651, 13, -475); locList.add(l);}
			{Location l = new Location(w, -3651, 12, -474); locList.add(l);}
			{Location l = new Location(w, -3651, 12, -475); locList.add(l);}
			{Location l = new Location(w, -3651, 12, -476); locList.add(l);}
			{Location l = new Location(w, -3664, 10, -462); locList.add(l);}
			{Location l = new Location(w, -3665, 10, -462); locList.add(l);}
		}
		if(rank == Rank.UPlus){
			{Location l = new Location(w, -3602, 13, -274); locList.add(l);}
			{Location l = new Location(w, -3602, 12, -273); locList.add(l);}
			{Location l = new Location(w, -3602, 12, -274); locList.add(l);}
			{Location l = new Location(w, -3602, 12, -275); locList.add(l);}
			{Location l = new Location(w, -3615, 10, -261); locList.add(l);}
			{Location l = new Location(w, -3616, 10, -261); locList.add(l);}
		}
		
		//TODO ADD MORE	
		
		return locList;
	}
	
	public static void registerAllWoodmenBlocks(World w){
		for(Rank rank : Rank.values()){
			registerWoodmenBlockRank(w, rank);
		}
    }
	
	@SuppressWarnings("deprecation")
	public static void registerWoodmenBlockRank(World w, Rank rank){
		if(rank == Rank.Z){
			Location l1 = new Location(w, -1479, 15, -401);
			Location l2 = new Location(w, -1479, 15, -415);
			StorageManager.rankwoodmenblocks.put(Rank.Z, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.Z, w.getBlockAt(new Location(w, -1478, 17, -418)));
		}
		if(rank == Rank.Y){
			Location l1 = new Location(w, -1516, 15, -597);
			Location l2 = new Location(w, -1516, 15, -583);
			StorageManager.rankwoodmenblocks.put(Rank.Y, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.Y, w.getBlockAt(new Location(w, -1515, 17, -600)));
		}
		if(rank == Rank.X){
			Location l1 = new Location(w, -1693, 15, -622);
			Location l2 = new Location(w, -1693, 15, -608);
			StorageManager.rankwoodmenblocks.put(Rank.X, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.X, w.getBlockAt(new Location(w, -1692, 17, -625)));
		}
		if(rank == Rank.W){
			Location l1 = new Location(w, -1673, 15, -422);
			Location l2 = new Location(w, -1673, 15, -408);
			StorageManager.rankwoodmenblocks.put(Rank.W, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.W, w.getBlockAt(new Location(w, -1672, 17, -425)));
		}
		if(rank == Rank.V){
			Location l1 = new Location(w, -1850, 15, -613);
			Location l2 = new Location(w, -1850, 15, -599);
			StorageManager.rankwoodmenblocks.put(Rank.V, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.V, w.getBlockAt(new Location(w, -1849, 17, -616)));
		}
		if(rank == Rank.U){
			Location l1 = new Location(w, -1810, 15, -395);
			Location l2 = new Location(w, -1810, 15, -381);
			StorageManager.rankwoodmenblocks.put(Rank.U, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.U, w.getBlockAt(new Location(w, -1809, 17, -398)));
		}
		if(rank == Rank.T){
			Location l1 = new Location(w, -1989, 15, -600);
			Location l2 = new Location(w, -1989, 15, -586);
			StorageManager.rankwoodmenblocks.put(Rank.T, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.T, w.getBlockAt(new Location(w, -1988, 17, -603)));
		}
		if(rank == Rank.S){
			Location l1 = new Location(w, -1951, 15, -386);
			Location l2 = new Location(w, -1951, 15, -372);
			StorageManager.rankwoodmenblocks.put(Rank.S, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.S, w.getBlockAt(new Location(w, -1950, 17, -389)));
		}
		if(rank == Rank.R){
			Location l1 = new Location(w, -2118, 15, -590);
			Location l2 = new Location(w, -2118, 15, -576);
			StorageManager.rankwoodmenblocks.put(Rank.R, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.R, w.getBlockAt(new Location(w, -2117, 17, -593)));
		}	
		if(rank == Rank.Q){
			Location l1 = new Location(w, -2081, 15, -379);
			Location l2 = new Location(w, -2081, 15, -365);
			StorageManager.rankwoodmenblocks.put(Rank.Q, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.Q, w.getBlockAt(new Location(w, -2080, 17, -382)));
		}
		if(rank == Rank.P){
			Location l1 = new Location(w, -2249, 15, -568);
			Location l2 = new Location(w, -2249, 15, -554);
			StorageManager.rankwoodmenblocks.put(Rank.P, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.P, w.getBlockAt(new Location(w, -2248, 17, -571)));
		}
		if(rank == Rank.O){
			Location l1 = new Location(w, -2215, 15, -357);
			Location l2 = new Location(w, -2215, 15, -343);
			StorageManager.rankwoodmenblocks.put(Rank.O, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.O, w.getBlockAt(new Location(w, -2214, 17, -360)));
		}
		if(rank == Rank.N){
			Location l1 = new Location(w, -2364, 15, -565);
			Location l2 = new Location(w, -2364, 15, -551);
			StorageManager.rankwoodmenblocks.put(Rank.N, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.N, w.getBlockAt(new Location(w, -2363, 17, -568)));
		}
		if(rank == Rank.M){
			Location l1 = new Location(w, -2346, 15, -348);
			Location l2 = new Location(w, -2346, 15, -334);
			StorageManager.rankwoodmenblocks.put(Rank.M, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.M, w.getBlockAt(new Location(w, -2345, 17, -351)));
		}
		if(rank == Rank.L){
			Location l1 = new Location(w, -2512, 15, -560);
			Location l2 = new Location(w, -2512, 15, -546);
			StorageManager.rankwoodmenblocks.put(Rank.L, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.L, w.getBlockAt(new Location(w, -2511, 17, -563)));
		}
		if(rank == Rank.K){
			Location l1 = new Location(w, -2482, 15, -338);
			Location l2 = new Location(w, -2482, 15, -324);
			StorageManager.rankwoodmenblocks.put(Rank.K, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.K, w.getBlockAt(new Location(w, -2481, 17, -341)));
		}
		if(rank == Rank.J){
			Location l1 = new Location(w, -2645, 15, -563);
			Location l2 = new Location(w, -2645, 15, -549);
			StorageManager.rankwoodmenblocks.put(Rank.J, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.J, w.getBlockAt(new Location(w, -2644, 17, -566)));
		}
		if(rank == Rank.I){
			Location l1 = new Location(w, -2609, 15, -340);
			Location l2 = new Location(w, -2609, 15, -326);
			StorageManager.rankwoodmenblocks.put(Rank.I, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.I, w.getBlockAt(new Location(w, -2608, 17, -343)));
		}
		if(rank == Rank.H){
			Location l1 = new Location(w, -2804, 15, -553);
			Location l2 = new Location(w, -2804, 15, -539);
			StorageManager.rankwoodmenblocks.put(Rank.H, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.H, w.getBlockAt(new Location(w, -2803, 17, -556)));
		}
		if(rank == Rank.G){
			Location l1 = new Location(w, -2749, 15, -343);
			Location l2 = new Location(w, -2749, 15, -329);
			StorageManager.rankwoodmenblocks.put(Rank.G, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.G, w.getBlockAt(new Location(w, -2748, 17, -346)));
		}
		if(rank == Rank.F){
			Location l1 = new Location(w, -2936, 15, -556);
			Location l2 = new Location(w, -2936, 15, -542);
			StorageManager.rankwoodmenblocks.put(Rank.F, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.F, w.getBlockAt(new Location(w, -2935, 17, -559)));
		}
		if(rank == Rank.E){
			Location l1 = new Location(w, -2898, 15, -342);
			Location l2 = new Location(w, -2898, 15, -328);
			StorageManager.rankwoodmenblocks.put(Rank.E, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.E, w.getBlockAt(new Location(w, -2897, 17, -345)));
		}
		if(rank == Rank.D){
			Location l1 = new Location(w, -3068, 15, -548);
			Location l2 = new Location(w, -3068, 15, -534);
			StorageManager.rankwoodmenblocks.put(Rank.D, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.D, w.getBlockAt(new Location(w, -3067, 17, -551)));
		}
		if(rank == Rank.C){
			Location l1 = new Location(w, -3030, 15, -336);
			Location l2 = new Location(w, -3030, 15, -322);
			StorageManager.rankwoodmenblocks.put(Rank.C, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.C, w.getBlockAt(new Location(w, -3029, 17, -339)));
		}
		if(rank == Rank.B){
			Location l1 = new Location(w, -3249, 15, -535);
			Location l2 = new Location(w, -3249, 15, -521);
			StorageManager.rankwoodmenblocks.put(Rank.B, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.B, w.getBlockAt(new Location(w, -3248, 17, -538)));
		}
		if(rank == Rank.A){
			Location l1 = new Location(w, -3196, 15, -333);
			Location l2 = new Location(w, -3196, 15, -319);
			StorageManager.rankwoodmenblocks.put(Rank.A, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.A, w.getBlockAt(new Location(w, -3195, 17, -336)));
		}
		if(rank == Rank.ZPlus){
			Location l1 = new Location(w, -3407, 15, -537);
			Location l2 = new Location(w, -3407, 15, -523);
			StorageManager.rankwoodmenblocks.put(Rank.ZPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.ZPlus, w.getBlockAt(new Location(w, -3406, 17, -540)));
		}
		if(rank == Rank.YPlus){
			Location l1 = new Location(w, -3343, 15, -329);
			Location l2 = new Location(w, -3343, 15, -315);
			StorageManager.rankwoodmenblocks.put(Rank.YPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.YPlus, w.getBlockAt(new Location(w, -3342, 17, -332)));
		}
		if(rank == Rank.XPlus){
			Location l1 = new Location(w, -3526, 15, -536);
			Location l2 = new Location(w, -3526, 15, -522);
			StorageManager.rankwoodmenblocks.put(Rank.XPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.XPlus, w.getBlockAt(new Location(w, -3525, 17, -539)));
		}
		if(rank == Rank.WPlus){
			Location l1 = new Location(w, -3479, 15, -320);
			Location l2 = new Location(w, -3479, 15, -306);
			StorageManager.rankwoodmenblocks.put(Rank.WPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.WPlus, w.getBlockAt(new Location(w, -3478, 17, -323)));
		}
		if(rank == Rank.VPlus){
			Location l1 = new Location(w, -3676, 15, -516);
			Location l2 = new Location(w, -3676, 15, -503);
			StorageManager.rankwoodmenblocks.put(Rank.VPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.VPlus, w.getBlockAt(new Location(w, -3675, 17, -520)));
		}
		if(rank == Rank.UPlus){
			Location l1 = new Location(w, -3627, 15, -316);
			Location l2 = new Location(w, -3627, 15, -302);
			StorageManager.rankwoodmenblocks.put(Rank.UPlus, getBlocksBetween(l1, l2));
			for(Block b : getBlocksBetween(l1, l2)){
				b.setType(Material.LOG);
				b.setData((byte) 8);
			}
			StorageManager.rankwoodblockwillbetaken.put(Rank.UPlus, w.getBlockAt(new Location(w, -3626, 17, -319)));
		}
		
		//TODO
	}
	
	public static void registerAllWoodmenLocations(World w){
		StorageManager.rankwoodmenlocation.put(Rank.Z, new Location(w, -1478, 16, -416));
		StorageManager.rankwoodmenlocation.put(Rank.Y, new Location(w, -1515, 16, -598));
		StorageManager.rankwoodmenlocation.put(Rank.X, new Location(w, -1691, 16, -622));
		StorageManager.rankwoodmenlocation.put(Rank.W, new Location(w, -1671, 16, -422));
		StorageManager.rankwoodmenlocation.put(Rank.V, new Location(w, -1848, 16, -613));
		StorageManager.rankwoodmenlocation.put(Rank.U, new Location(w, -1808, 16, -395));
		StorageManager.rankwoodmenlocation.put(Rank.T, new Location(w, -1987, 16, -600));
		StorageManager.rankwoodmenlocation.put(Rank.S, new Location(w, -1949, 16, -386));
		StorageManager.rankwoodmenlocation.put(Rank.R, new Location(w, -2116, 16, -590));
		StorageManager.rankwoodmenlocation.put(Rank.Q, new Location(w, -2079, 16, -379));
		StorageManager.rankwoodmenlocation.put(Rank.P, new Location(w, -2247, 16, -568));
		StorageManager.rankwoodmenlocation.put(Rank.O, new Location(w, -2213, 16, -357));
		StorageManager.rankwoodmenlocation.put(Rank.N, new Location(w, -2362, 16, -565));
		StorageManager.rankwoodmenlocation.put(Rank.M, new Location(w, -2344, 16, -348));
		StorageManager.rankwoodmenlocation.put(Rank.L, new Location(w, -2510, 16, -560));
		StorageManager.rankwoodmenlocation.put(Rank.K, new Location(w, -2480, 16, -338));
		StorageManager.rankwoodmenlocation.put(Rank.J, new Location(w, -2643, 16, -563));
		StorageManager.rankwoodmenlocation.put(Rank.I, new Location(w, -2607, 16, -340));
		StorageManager.rankwoodmenlocation.put(Rank.H, new Location(w, -2802, 16, -553));
		StorageManager.rankwoodmenlocation.put(Rank.G, new Location(w, -2746, 16, -343));
		StorageManager.rankwoodmenlocation.put(Rank.F, new Location(w, -2935, 16, -556));
		StorageManager.rankwoodmenlocation.put(Rank.E, new Location(w, -2896, 16, -342));
		StorageManager.rankwoodmenlocation.put(Rank.D, new Location(w, -3066, 16, -548));
		StorageManager.rankwoodmenlocation.put(Rank.C, new Location(w, -3028, 16, -336));
		StorageManager.rankwoodmenlocation.put(Rank.B, new Location(w, -3247, 16, -535));
		StorageManager.rankwoodmenlocation.put(Rank.A, new Location(w, -3194, 16, -333));
		StorageManager.rankwoodmenlocation.put(Rank.ZPlus, new Location(w, -3405, 16, -537));
		StorageManager.rankwoodmenlocation.put(Rank.YPlus, new Location(w, -3341, 16, -329));
		StorageManager.rankwoodmenlocation.put(Rank.XPlus, new Location(w, -3524, 16, -536));
		StorageManager.rankwoodmenlocation.put(Rank.WPlus, new Location(w, -3477, 16, -320));
		StorageManager.rankwoodmenlocation.put(Rank.VPlus, new Location(w, -3674, 16, -517));
		StorageManager.rankwoodmenlocation.put(Rank.UPlus, new Location(w, -3625, 16, -316));
		
		//TODO
	}
	
    public static void registerAllRankBlocks(World w){
    	registerrankblocks(Rank.Z, w);
    	registerrankblocks(Rank.Y, w);
    	registerrankblocks(Rank.X, w);
    	registerrankblocks(Rank.W, w);
    	registerrankblocks(Rank.V, w);
    	registerrankblocks(Rank.U, w);
    	registerrankblocks(Rank.T, w);
    	registerrankblocks(Rank.S, w);
    	registerrankblocks(Rank.R, w);
    	registerrankblocks(Rank.Q, w);
    	registerrankblocks(Rank.P, w);
    	registerrankblocks(Rank.O, w);
    	registerrankblocks(Rank.N, w);
    	registerrankblocks(Rank.M, w);
    	registerrankblocks(Rank.L, w);
    	registerrankblocks(Rank.K, w);
    	registerrankblocks(Rank.J, w);
    	registerrankblocks(Rank.I, w);
    	registerrankblocks(Rank.H, w);
    	registerrankblocks(Rank.G, w);
    	registerrankblocks(Rank.F, w);
    	registerrankblocks(Rank.E, w);
    	registerrankblocks(Rank.D, w);
    	registerrankblocks(Rank.C, w);
    	registerrankblocks(Rank.B, w);
    	registerrankblocks(Rank.A, w);
    	registerrankblocks(Rank.ZPlus, w);
    	registerrankblocks(Rank.YPlus, w);
    	registerrankblocks(Rank.XPlus, w);
    	registerrankblocks(Rank.WPlus, w);
    	registerrankblocks(Rank.VPlus, w);
    	registerrankblocks(Rank.UPlus, w);
    }
    
    public static void registerrankblocks(Rank rank, World w){
    	if(rank == Rank.Z){
    		Location l1 = new Location(w, -1171, 9, -599);
    		Location l2 = new Location(w, -1167, 21, -595);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1169, 15, -597);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.Y){
    		Location l1 = new Location(w, -1172, 9, -592);
    		Location l2 = new Location(w, -1168, 21, -588);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1170, 15, -590);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.X){
    		Location l1 = new Location(w, -1173, 9, -585);
    		Location l2 = new Location(w, -1169, 21, -581);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1171, 15, -583);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.W){
    		Location l1 = new Location(w, -1177, 9, -578);
    		Location l2 = new Location(w, -1173, 21, -574);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1175, 15, -576);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.V){
    		Location l1 = new Location(w, -1183, 9, -571);
    		Location l2 = new Location(w, -1179, 21, -567);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1181, 15, -569);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.U){
    		Location l1 = new Location(w, -1186, 9, -565);
    		Location l2 = new Location(w, -1190, 21, -561);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1188, 15, -563);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.T){
    		Location l1 = new Location(w, -1193, 9, -561);
    		Location l2 = new Location(w, -1197, 21, -557);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1195, 15, -559);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.S){
    		Location l1 = new Location(w, -1200, 9, -560);
    		Location l2 = new Location(w, -1204, 21, -556);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1202, 15, -558);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.R){
    		Location l1 = new Location(w, -1207, 9, -559);
    		Location l2 = new Location(w, -1211, 21, -555);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1209, 15, -557);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.Q){
    		Location l1 = new Location(w, -1214, 9, -560);
    		Location l2 = new Location(w, -1218, 21, -556);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1216, 15, -558);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.P){
    		Location l1 = new Location(w, -1221, 9, -561);
    		Location l2 = new Location(w, -1225, 21, -557);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1223, 15, -559);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.O){
    		Location l1 = new Location(w, -1228, 9, -565);
    		Location l2 = new Location(w, -1232, 21, -561);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1230, 15, -563);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.N){
    		Location l1 = new Location(w, -1235, 9, -571);
    		Location l2 = new Location(w, -1239, 21, -567);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1237, 15, -569);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.M){
    		Location l1 = new Location(w, -1241, 9, -574);
    		Location l2 = new Location(w, -1245, 21, -578);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1243, 15, -576);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.L){
    		Location l1 = new Location(w, -1245, 9, -581);
    		Location l2 = new Location(w, -1249, 21, -585);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1247, 15, -583);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.K){
    		Location l1 = new Location(w, -1246, 9, -588);
    		Location l2 = new Location(w, -1250, 21, -592);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1248, 15, -590);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.J){
    		Location l1 = new Location(w, -1247, 9, -595);
    		Location l2 = new Location(w, -1251, 21, -599);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1249, 15, -597);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.I){
    		Location l1 = new Location(w, -1246, 9, -602);
    		Location l2 = new Location(w, -1250, 21, -606);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1248, 15, -604);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.H){
    		Location l1 = new Location(w, -1245, 9, -609);
    		Location l2 = new Location(w, -1249, 21, -613);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1247, 15, -611);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.G){
    		Location l1 = new Location(w, -1241, 9, -616);
    		Location l2 = new Location(w, -1245, 21, -620);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1243, 15, -618);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.F){
    		Location l1 = new Location(w, -1235, 9, -623);
    		Location l2 = new Location(w, -1239, 21, -627);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1237, 15, -625);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.E){
    		Location l1 = new Location(w, -1228, 9, -629);
    		Location l2 = new Location(w, -1232, 21, -633);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1230, 15, -631);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.D){
    		Location l1 = new Location(w, -1221, 9, -633);
    		Location l2 = new Location(w, -1225, 21, -637);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1223, 15, -635);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.C){
    		Location l1 = new Location(w, -1218, 9, -634);
    		Location l2 = new Location(w, -1214, 21, -638);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1216, 15, -636);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.B){
    		Location l1 = new Location(w, -1211, 9, -635);
    		Location l2 = new Location(w, -1207, 21, -639);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1209, 15, -637);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.A){
    		Location l1 = new Location(w, -1204, 9, -634);
    		Location l2 = new Location(w, -1200, 21, -638);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1202, 15, -636);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.ZPlus){
    		Location l1 = new Location(w, -1197, 9, -633);
    		Location l2 = new Location(w, -1193, 25, -637);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1195, 15, -635);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.YPlus){
    		Location l1 = new Location(w, -1190, 9, -629);
    		Location l2 = new Location(w, -1186, 25, -633);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1188, 15, -631);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.XPlus){
    		Location l1 = new Location(w, -1183, 9, -623);
    		Location l2 = new Location(w, -1179, 25, -627);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1181, 15, -625);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.WPlus){
    		Location l1 = new Location(w, -1177, 9, -620);
    		Location l2 = new Location(w, -1173, 25, -616);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1175, 15, -618);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.VPlus){
    		Location l1 = new Location(w, -1173, 9, -613);
    		Location l2 = new Location(w, -1169, 25, -609);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1171, 15, -611);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	if(rank == Rank.UPlus){
    		Location l1 = new Location(w, -1172, 9, -606);
    		Location l2 = new Location(w, -1168, 25, -602);
    		StorageManager.rankblocks.put(rank, getBlocksBetween(l1, l2));
    		
    		Location l3 = new Location(w, -1170, 15, -604);
    		StorageManager.ranktorchblock.put(rank, w.getBlockAt(l3));
    	}
    	
    }
    
    public static List<Block> getBlocksBetween(Location l1, Location l2)
    {
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
    
}
