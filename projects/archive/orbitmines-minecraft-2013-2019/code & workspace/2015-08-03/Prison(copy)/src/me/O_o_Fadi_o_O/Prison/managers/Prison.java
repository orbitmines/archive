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
}
