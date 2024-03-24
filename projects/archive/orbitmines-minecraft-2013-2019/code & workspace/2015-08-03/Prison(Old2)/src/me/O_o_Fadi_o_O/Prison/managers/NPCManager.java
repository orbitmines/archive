package me.O_o_Fadi_o_O.Prison.managers;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomSkeleton;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomVillager;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomZombie;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.O_o_Fadi_o_O.Prison.utils.RankNPCType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class NPCManager {
	
	public static void spawnAllWoodmen(World w){
		for(Rank rank : Rank.values()){
			try{
			spawnZombie(w, StorageManager.RankWoodmenLocation.get(rank), "§e§lLumberjack §a§l" + rank.toString().replaceAll("Plus", "+"), Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET, Material.IRON_AXE, rank);
		
			}catch(Exception ex){}
		}
	}
	
	public static void spawnAllVillager(World w){
		spawnVillager(w, new Location(w, -1199.5, 11.5, -587.5, 135, 1), "§2§lVillager Gamble");
	}
	
	public static void spawnAllSkeletons(World w){
		spawnSkeleton(w, new Location(w, -1205.5, 13.5, -593.5, 135, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP);
		spawnSkeleton(w, new Location(w, -1211.5, 13.5, -593.5, -135, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP);
		spawnSkeleton(w, new Location(w, -1211.5, 13.5, -599.5, -45, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP);
		spawnSkeleton(w, new Location(w, -1205.5, 13.5, -599.5, 45, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP);
		
		spawnSkeleton(w, new Location(w, -1447.5, 11, -372.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Z, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1484.5, 11, -554.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Y, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1661.5, 11, -579.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.X, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1641.5, 11, -379.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.X, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1818.5, 11, -570.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.V, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1778.5, 11, -352.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.U, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1957.5, 11, -557.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.T, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -1919.5, 11, -343.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.S, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2086.5, 11, -547.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.R, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2049.5, 11, -336.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Q, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2217.5, 11, -525.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.P, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2183.5, 11, -314.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.O, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2332.5, 11, -522.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.N, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2314.5, 11, -305.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.M, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2480.5, 11, -517.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.L, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2450.5, 11, -295.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.K, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2613.5, 11, -520.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.J, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2577.5, 11, -297.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.I, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2772.5, 11, -510.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.H, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2717.5, 11, -300.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.G, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2904.5, 11, -513.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.F, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2866.5, 11, -299.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.E, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3036.5, 11, -505.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.D, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -2998.5, 11, -293.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.C, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3217.5, 11, -492.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.B, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3164.5, 11, -290.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.A, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3375.5, 11, -494.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.ZPlus, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3311.5, 11, -286.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.YPlus, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3494.5, 11, -493.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.XPlus, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3447.5, 11, -277.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.WPlus, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3644.5, 11, -474.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.VPlus, RankNPCType.SPAWNTELEPORT);
		spawnSkeleton(w, new Location(w, -3595.5, 11, -273.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.UPlus, RankNPCType.SPAWNTELEPORT);
		
		//TODO
		
		//spawnSkeleton(w, new Location(w, -1168.5, 11, -596.5, 90, 0), "§9§lRankup to §a§lZ §8| §6§l0 Gold", Material.DIAMOND_PICKAXE, Rank.Z, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1169.5, 11, -589.5, 100, 0), "§9§lRankup to §a§lY §8| §6§l1000 Gold", Material.DIAMOND_PICKAXE, Rank.Y, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1170.5, 11, -582.5, 110, 0), "§9§lRankup to §a§lX §8| §6§l2500 Gold", Material.DIAMOND_PICKAXE, Rank.X, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 122, 0), "§9§lRankup to §a§lW §8| §6§l5000 Gold", Material.DIAMOND_PICKAXE, Rank.W, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1180.5, 11, -568.5, 135, 0), "§9§lRankup to §a§lV §8| §6§l7500 Gold", Material.DIAMOND_PICKAXE, Rank.V, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1187.5, 11, -562.5, 148, 0), "§9§lRankup to §a§lU §8| §6§l10000 Gold", Material.DIAMOND_PICKAXE, Rank.U, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1194.5, 11, -558.5, 160, 0), "§9§lRankup to §a§lT §8| §6§l15000 Gold", Material.DIAMOND_PICKAXE, Rank.T, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1201.5, 11, -557.5, 170, 0), "§9§lRankup to §a§lS §8| §6§l20000 Gold", Material.DIAMOND_PICKAXE, Rank.S, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1208.5, 11, -556.5, 180, 0), "§9§lRankup to §a§lR §8| §6§l30000 Gold", Material.DIAMOND_PICKAXE, Rank.R, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1215.5, 11, -557.5, -170, 0), "§9§lRankup to §a§lQ §8| §6§l40000 Gold", Material.DIAMOND_PICKAXE, Rank.Q, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1222.5, 11, -558.5, -160, 0), "§9§lRankup to §a§lP §8| §6§l50000 Gold", Material.DIAMOND_PICKAXE, Rank.P, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1229.5, 11, -562.5, -148, 0), "§9§lRankup to §a§lO §8| §6§l70000 Gold", Material.DIAMOND_PICKAXE, Rank.O, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1236.5, 11, -568.5, -135, 0), "§9§lRankup to §a§lN §8| §6§l90000 Gold", Material.DIAMOND_PICKAXE, Rank.N, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1242.5, 11, -575.5, -121, 0), "§9§lRankup to §a§lM §8| §6§l115000 Gold", Material.DIAMOND_PICKAXE, Rank.M, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1246.5, 11, -582.5, -110, 0), "§9§lRankup to §a§lL §8| §6§l140000 Gold", Material.DIAMOND_PICKAXE, Rank.L, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1247.5, 11, -589.5, -100, 0), "§9§lRankup to §a§lK §8| §6§l175000 Gold", Material.DIAMOND_PICKAXE, Rank.K, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1248.5, 11, -596.5, -90, 0), "§9§lRankup to §a§lJ §8| §6§l210000 Gold", Material.DIAMOND_PICKAXE, Rank.J, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1247.5, 11, -603.5, -80, 0), "§9§lRankup to §a§lI §8| §6§l250000 Gold", Material.DIAMOND_PICKAXE, Rank.I, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1246.5, 11, -610.5, -70, 0), "§9§lRankup to §a§lH §8| §6§l300000 Gold", Material.DIAMOND_PICKAXE, Rank.H, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1242.5, 11, -617.5, -59, 0), "§9§lRankup to §a§lG §8| §6§l350000 Gold", Material.DIAMOND_PICKAXE, Rank.G, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1236.5, 11, -624.5, -45, 0), "§9§lRankup to §a§lF §8| §6§l425000 Gold", Material.DIAMOND_PICKAXE, Rank.F, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1229.5, 11, -630.5, -32, 0), "§9§lRankup to §a§lE §8| §6§l500000 Gold", Material.DIAMOND_PICKAXE, Rank.E, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1222.5, 11, -634.5, -20, 0), "§9§lRankup to §a§lD §8| §6§l600000 Gold", Material.DIAMOND_PICKAXE, Rank.D, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1215.5, 11, -635.5, -10, 0), "§9§lRankup to §a§lC §8| §6§l700000 Gold", Material.DIAMOND_PICKAXE, Rank.C, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1208.5, 11, -636.5, 0, 0), "§9§lRankup to §a§lB §8| §6§l815000 Gold", Material.DIAMOND_PICKAXE, Rank.B, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1201.5, 11, -635.5, 10, 0), "§9§lRankup to §a§lA §8| §6§l940000 Gold", Material.DIAMOND_PICKAXE, Rank.A, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1194.5, 11, -634.5, 20, 0), "§9§lRankup to §a§lZ+ §8| §6§l1100000 Gold", Material.DIAMOND_PICKAXE, Rank.ZPlus, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1187.5, 11, -630.5, 32, 0), "§9§lRankup to §a§lY+ §8| §6§l1275000 Gold", Material.DIAMOND_PICKAXE, Rank.YPlus, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1180.5, 11, -624.5, 45, 0), "§9§lRankup to §a§lX+ §8| §6§l1500000 Gold", Material.DIAMOND_PICKAXE, Rank.XPlus, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1174.5, 11, -617.5, 59, 0), "§9§lRankup to §a§lW+ §8| §6§l1750000 Gold", Material.DIAMOND_PICKAXE, Rank.WPlus, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1170.5, 11, -610.5, 70, 0), "§9§lRankup to §a§lV+ §8| §6§l2000000 Gold", Material.DIAMOND_PICKAXE, Rank.VPlus, RankNPCType.RANKUP);
		spawnSkeleton(w, new Location(w, -1169.5, 11, -603.5, 80, 0), "§9§lRankup to §a§lU+ §8| §6§l2500000 Gold", Material.DIAMOND_PICKAXE, Rank.UPlus, RankNPCType.RANKUP);
		//spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 120, 0), "§9§lRankup to §a§l §8| §6§l Gold", Material.DIAMOND_PICKAXE, null, RankNPCType.RANKUP); 
		//TODO: ADD NEW RANKS
		
		spawnSkeleton(w, new Location(w, -1168.5, 11, -596.5, 90, 0), "§3§lTeleport to §a§lZ", Material.ENDER_PEARL, Rank.Z, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1169.5, 11, -589.5, 100, 0), "§3§lTeleport to §a§lY", Material.ENDER_PEARL, Rank.Y, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1170.5, 11, -582.5, 110, 0), "§3§lTeleport to §a§lX", Material.ENDER_PEARL, Rank.X, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 122, 0), "§3§lTeleport to §a§lW", Material.ENDER_PEARL, Rank.W, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1180.5, 11, -568.5, 135, 0), "§3§lTeleport to §a§lV", Material.ENDER_PEARL, Rank.V, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1187.5, 11, -562.5, 148, 0), "§3§lTeleport to §a§lU", Material.ENDER_PEARL, Rank.U, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1194.5, 11, -558.5, 160, 0), "§3§lTeleport to §a§lT", Material.ENDER_PEARL, Rank.T, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1201.5, 11, -557.5, 170, 0), "§3§lTeleport to §a§lS", Material.ENDER_PEARL, Rank.S, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1208.5, 11, -556.5, 180, 0), "§3§lTeleport to §a§lR", Material.ENDER_PEARL, Rank.R, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1215.5, 11, -557.5, -170, 0), "§3§lTeleport to §a§lQ", Material.ENDER_PEARL, Rank.Q, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1222.5, 11, -558.5, -160, 0), "§3§lTeleport to §a§lP", Material.ENDER_PEARL, Rank.P, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1229.5, 11, -562.5, -148, 0), "§3§lTeleport to §a§lO", Material.ENDER_PEARL, Rank.O, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1236.5, 11, -568.5, -135, 0), "§3§lTeleport to §a§lN", Material.ENDER_PEARL, Rank.N, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1242.5, 11, -575.5, -121, 0), "§3§lTeleport to §a§lM", Material.ENDER_PEARL, Rank.M, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1246.5, 11, -582.5, -110, 0), "§3§lTeleport to §a§lL", Material.ENDER_PEARL, Rank.L, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1247.5, 11, -589.5, -100, 0), "§3§lTeleport to §a§lK", Material.ENDER_PEARL, Rank.K, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1248.5, 11, -596.5, -90, 0), "§3§lTeleport to §a§lJ", Material.ENDER_PEARL, Rank.J, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1247.5, 11, -603.5, -80, 0), "§3§lTeleport to §a§lI", Material.ENDER_PEARL, Rank.I, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1246.5, 11, -610.5, -70, 0), "§3§lTeleport to §a§lH", Material.ENDER_PEARL, Rank.H, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1242.5, 11, -617.5, -59, 0), "§3§lTeleport to §a§lG", Material.ENDER_PEARL, Rank.G, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1236.5, 11, -624.5, -45, 0), "§3§lTeleport to §a§lF", Material.ENDER_PEARL, Rank.F, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1229.5, 11, -630.5, -32, 0), "§3§lTeleport to §a§lE", Material.ENDER_PEARL, Rank.E, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1222.5, 11, -634.5, -20, 0), "§3§lTeleport to §a§lD", Material.ENDER_PEARL, Rank.D, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1215.5, 11, -635.5, -10, 0), "§3§lTeleport to §a§lC", Material.ENDER_PEARL, Rank.C, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1208.5, 11, -636.5, 0, 0), "§3§lTeleport to §a§lB", Material.ENDER_PEARL, Rank.B, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1201.5, 11, -635.5, 10, 0), "§3§lTeleport to §a§lA", Material.ENDER_PEARL, Rank.A, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1194.5, 11, -634.5, 20, 0), "§3§lTeleport to §a§lZ+", Material.ENDER_PEARL, Rank.ZPlus, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1187.5, 11, -630.5, 32, 0), "§3§lTeleport to §a§lY+", Material.ENDER_PEARL, Rank.YPlus, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1180.5, 11, -624.5, 45, 0), "§3§lTeleport to §a§lX+", Material.ENDER_PEARL, Rank.XPlus, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1174.5, 11, -617.5, 59, 0), "§3§lTeleport to §a§lW+", Material.ENDER_PEARL, Rank.WPlus, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1170.5, 11, -610.5, 70, 0), "§3§lTeleport to §a§lV+", Material.ENDER_PEARL, Rank.VPlus, RankNPCType.TELEPORT);
		spawnSkeleton(w, new Location(w, -1169.5, 11, -603.5, 80, 0), "§3§lTeleport to §a§lU+", Material.ENDER_PEARL, Rank.UPlus, RankNPCType.TELEPORT);
		//TODO: ADD NEW RANKS
		
	}
	
	public static void spawnZombie(World w, Location l, String displayName, Material boots, Material leggings, Material chestplate, Material helmet, Material hand, Rank rank){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    CustomZombie zombie = new CustomZombie(nmsWorld);
	    zombie.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(zombie);
	   // zombie.setCustomName(displayName);
	   // zombie.setCustomNameVisible(true);
	    ((LivingEntity) zombie.getBukkitEntity()).setRemoveWhenFarAway(false);

	    EntityEquipment ee = ((LivingEntity) zombie.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(hand));
	    ee.setBoots(new ItemStack(boots));
	    ee.setLeggings(new ItemStack(leggings));
	    ee.setChestplate(new ItemStack(chestplate));
	    ee.setHelmet(new ItemStack(helmet));
	    
	    StorageManager.RankWoodmen.put(rank, zombie.getBukkitEntity());
	    StorageManager.Chunks.add(l.getChunk());
	
	   
	}
	
	public static void spawnVillager(World w, Location l, String displayName){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    CustomVillager villager = new CustomVillager(nmsWorld);
	    villager.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(villager);
	    villager.setCustomName(displayName);
	    villager.setCustomNameVisible(true);
	    villager.setSkeletonType(1);
	    
	    ((LivingEntity) villager.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.Villagers.add(villager.getBukkitEntity());
	}
	
	public static void spawnSkeleton(World w, Location l, String displayName, Material material, Rank rank, RankNPCType type){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(material));
	    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    for(Player p : Bukkit.getOnlinePlayers()){
	    	if(type != RankNPCType.SPAWNTELEPORT && type != RankNPCType.SHOP){
	    		Start.entityHider.hideEntity(p, skeleton.getBukkitEntity());
	    	}
	    }
	    if(type == RankNPCType.SHOP){
	    	StorageManager.ShopNPCs.add(skeleton.getBukkitEntity());
	    }
	    else if(type == RankNPCType.RANKUP){
	    	StorageManager.RankupNPCs.put(rank, skeleton.getBukkitEntity());
	    }
	    else if(type == RankNPCType.TELEPORT){
	    	StorageManager.RankTeleportNPCs.put(rank, skeleton.getBukkitEntity());
	    }
	    else if(type == RankNPCType.SPAWNTELEPORT){
	    	StorageManager.SpawnTeleportNPCs.put(rank, skeleton.getBukkitEntity());
	    }
	    else{}
	   
	}
}
