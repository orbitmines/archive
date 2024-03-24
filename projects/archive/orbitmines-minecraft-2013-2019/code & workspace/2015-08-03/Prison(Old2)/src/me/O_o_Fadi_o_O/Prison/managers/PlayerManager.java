package me.O_o_Fadi_o_O.Prison.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.NMS.CustomCow;
import me.O_o_Fadi_o_O.Prison.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.Prison.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.Prison.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.Prison.NMS.CustomPig;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSheep;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSlime;
import me.O_o_Fadi_o_O.Prison.NMS.CustomWolf;
import me.O_o_Fadi_o_O.Prison.utils.Pet;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerManager {
	
	
	/*
	 * 
	 * Other:
	 * 
	 */
	
	public static boolean hasMoney(Player p, int amount){
		if(StorageManager.PlayerMoney.get(p) >= amount){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isInOPMode(Player p){
		if(StorageManager.PlayerInOPMode.get(p) != null){
			if(StorageManager.PlayerInOPMode.get(p) == true){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public static boolean isInPvP(Player p){
		if(StorageManager.PlayerInPvP.get(p) != null){
			if(StorageManager.PlayerInPvP.get(p) == true){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	
	
	public static void updateClockEnabled(Player p){
		StorageManager.PlayerClockEnabled.put(p, ConfigManager.playerdata.getBoolean("players." + p.getName() + ".Clock"));
	}
	public static void toggleClockEnabled(Player p){
		if(StorageManager.PlayerClockEnabled.get(p) == true){
			ConfigManager.playerdata.set("players." + p.getName() + ".Clock", false);
			ConfigManager.savePlayerData();
			StorageManager.PlayerClockEnabled.put(p, false);
			p.sendMessage(Start.TAG + "Clock §c§lDISABLED§7!");
		}
		else{
			ConfigManager.playerdata.set("players." + p.getName() + ".Clock", true);
			ConfigManager.savePlayerData();
			StorageManager.PlayerClockEnabled.put(p, true);
			p.sendMessage(Start.TAG + "Clock §a§lENABLED§7!");
		}
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
	}

	public static void updateGambleTickets(Player p){
		StorageManager.PlayerGambleTickets.put(p, ConfigManager.playerdata.getInt("players." + p.getName() + ".GambleTickets"));
	}
	public static void giveGambleTickets(Player p, int amount){
		ConfigManager.playerdata.set("players." + p.getName() + ".GambleTickets", StorageManager.PlayerGambleTickets.get(p) + amount);
		ConfigManager.savePlayerData();
		StorageManager.PlayerGambleTickets.put(p, StorageManager.PlayerGambleTickets.get(p) + amount);
	}
	public static void removeGambleTickets(Player p, int amount){
		ConfigManager.playerdata.set("players." + p.getName() + ".GambleTickets", StorageManager.PlayerGambleTickets.get(p) - amount);
		ConfigManager.savePlayerData();
		StorageManager.PlayerGambleTickets.put(p, StorageManager.PlayerGambleTickets.get(p) - amount);
	}
	
	public static void updateMoney(Player p){
		StorageManager.PlayerMoney.put(p, ConfigManager.playerdata.getInt("players." + p.getName() + ".Money"));
	}
	public static void giveMoney(Player p, int amount){
		ConfigManager.playerdata.set("players." + p.getName() + ".Money", StorageManager.PlayerMoney.get(p) + amount);
		ConfigManager.savePlayerData();
		StorageManager.PlayerMoney.put(p, StorageManager.PlayerMoney.get(p) + amount);
	}
	public static void removeMoney(Player p, int amount){
		ConfigManager.playerdata.set("players." + p.getName() + ".Money", StorageManager.PlayerMoney.get(p) - amount);
		ConfigManager.savePlayerData();
		StorageManager.PlayerMoney.put(p, StorageManager.PlayerMoney.get(p) - amount);
	}
	
	public static String getRankString(Player p){
		Rank rank = StorageManager.PlayerRank.get(p);
		
		String rankString = rank.toString().replaceAll("Plus", "+");
		
		return rankString;
	}
	
	public static int getRankupPrice(Player p){
		int rankupPrice = 0;
		Rank rank = getRankupRank(p);
		
		if(rank == Rank.Y){rankupPrice = 1000;}
		else if(rank == Rank.X){rankupPrice = 2500;}
		else if(rank == Rank.W){rankupPrice = 5000;}
		else if(rank == Rank.V){rankupPrice = 7500;}
		else if(rank == Rank.U){rankupPrice = 10000;}
		else if(rank == Rank.T){rankupPrice = 15000;}
		else if(rank == Rank.S){rankupPrice = 20000;}
		else if(rank == Rank.R){rankupPrice = 30000;}
		else if(rank == Rank.Q){rankupPrice = 40000;}
		else if(rank == Rank.P){rankupPrice = 50000;}
		else if(rank == Rank.O){rankupPrice = 70000;}
		else if(rank == Rank.N){rankupPrice = 90000;}
		else if(rank == Rank.M){rankupPrice = 115000;}
		else if(rank == Rank.L){rankupPrice = 140000;}
		else if(rank == Rank.K){rankupPrice = 175000;}
		else if(rank == Rank.J){rankupPrice = 210000;}
		else if(rank == Rank.I){rankupPrice = 250000;}
		else if(rank == Rank.H){rankupPrice = 300000;}
		else if(rank == Rank.G){rankupPrice = 350000;}
		else if(rank == Rank.F){rankupPrice = 425000;}
		else if(rank == Rank.E){rankupPrice = 500000;}
		else if(rank == Rank.D){rankupPrice = 600000;}
		else if(rank == Rank.C){rankupPrice = 700000;}
		else if(rank == Rank.B){rankupPrice = 815000;}
		else if(rank == Rank.A){rankupPrice = 940000;}
		else if(rank == Rank.ZPlus){rankupPrice = 1100000;}
		else if(rank == Rank.YPlus){rankupPrice = 1275000;}
		else if(rank == Rank.XPlus){rankupPrice = 1500000;}
		else if(rank == Rank.WPlus){rankupPrice = 1750000;}
		else if(rank == Rank.VPlus){rankupPrice = 2000000;}
		else if(rank == Rank.UPlus){rankupPrice = 2500000;}
		else{}
		
		return rankupPrice;
	}
	
	public static Rank getRankupRank(Player p){
		Rank rank = StorageManager.PlayerRank.get(p);
		
		Rank nextRank = null;
		if(rank == Rank.Z){nextRank = Rank.Y;}
		if(rank == Rank.Y){nextRank = Rank.X;}
		if(rank == Rank.X){nextRank = Rank.W;}
		if(rank == Rank.W){nextRank = Rank.V;}
		if(rank == Rank.V){nextRank = Rank.U;}
		if(rank == Rank.U){nextRank = Rank.T;}
		if(rank == Rank.T){nextRank = Rank.S;}
		if(rank == Rank.S){nextRank = Rank.R;}
		if(rank == Rank.R){nextRank = Rank.Q;}
		if(rank == Rank.Q){nextRank = Rank.P;}
		if(rank == Rank.P){nextRank = Rank.O;}
		if(rank == Rank.O){nextRank = Rank.N;}
		if(rank == Rank.N){nextRank = Rank.M;}
		if(rank == Rank.M){nextRank = Rank.L;}
		if(rank == Rank.L){nextRank = Rank.K;}
		if(rank == Rank.K){nextRank = Rank.J;}
		if(rank == Rank.J){nextRank = Rank.I;}
		if(rank == Rank.I){nextRank = Rank.H;}
		if(rank == Rank.H){nextRank = Rank.G;}
		if(rank == Rank.G){nextRank = Rank.F;}
		if(rank == Rank.F){nextRank = Rank.E;}
		if(rank == Rank.E){nextRank = Rank.D;}
		if(rank == Rank.D){nextRank = Rank.C;}
		if(rank == Rank.C){nextRank = Rank.B;}
		if(rank == Rank.B){nextRank = Rank.A;}
		if(rank == Rank.A){nextRank = Rank.ZPlus;}
		if(rank == Rank.ZPlus){nextRank = Rank.YPlus;}
		if(rank == Rank.YPlus){nextRank = Rank.XPlus;}
		if(rank == Rank.XPlus){nextRank = Rank.WPlus;}
		if(rank == Rank.WPlus){nextRank = Rank.VPlus;}
		if(rank == Rank.VPlus){nextRank = Rank.UPlus;}
		if(rank == Rank.UPlus){nextRank = Rank.UPlus;}//TODO ADD NEW RANKS
		
		return nextRank;
	}
	
	public static synchronized void rankupRank(Player p){
		
		Rank nextRank = getRankupRank(p);
		String nextRankString = null;
		
		nextRankString = nextRank.toString().replaceAll("Plus", "+");
		Bukkit.broadcastMessage("§4§lPrison §8| §8" + playerDisplayName(p) + "§7 ranked up to §a§l" + nextRankString + "§7!");
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		ConfigManager.playerdata.set("players." + p.getName() + ".Rank", nextRank.toString());
		ConfigManager.savePlayerData();
		StorageManager.PlayerRank.put(p, nextRank);
	}
	
	public static String playerDisplayName(Player p){

		if(p.hasPermission("Rank.Owner")){
			return "§4§lOwner " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Moderator")){
			return "§b§lMod " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Builder")){
			return "§d§lBuilder " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Emerald")){
			return "§a§lEmerald " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Diamond")){
			return "§9§lDiamond " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Gold")){
			return "§6§lGold " + p.getName(); 
		}
		else if(p.hasPermission("Rank.Iron")){
			return "§7§lIron " + p.getName(); 
		}
		else{
			return "§8" + p.getName(); 
		}
	}
	
	public static void updateRank(Player p){
		String rankString = ConfigManager.playerdata.getString("players." + p.getName() + ".Rank");
		Rank rank = Rank.valueOf(rankString);
		StorageManager.PlayerRank.put(p, rank);
	}
	
	
	public static List<Rank> getAllRanksPassed(Player p){
		
		Rank rank = StorageManager.PlayerRank.get(p);
		
		List<Rank> ranksPasses = new ArrayList<Rank>();
		
		if(rank == Rank.Z){
			ranksPasses.add(Rank.Z);
    	}
    	if(rank == Rank.Y){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    	}
    	if(rank == Rank.X){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    	}
    	if(rank == Rank.W){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    	}
    	if(rank == Rank.V){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    	}
    	if(rank == Rank.U){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    	}
    	if(rank == Rank.T){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    	}
    	if(rank == Rank.S){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    	}
    	if(rank == Rank.R){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    	}
    	if(rank == Rank.Q){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    	}
    	if(rank == Rank.P){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    	}
    	if(rank == Rank.O){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    	}
    	if(rank == Rank.N){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    	}
    	if(rank == Rank.M){
    		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    	}
    	if(rank == Rank.L){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    	}
    	if(rank == Rank.K){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    	}
    	if(rank == Rank.J){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    	}
    	if(rank == Rank.I){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    	}
    	if(rank == Rank.H){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    	}
    	if(rank == Rank.G){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    	}
    	if(rank == Rank.F){
     		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    	}
    	if(rank == Rank.E){
     		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    	}
    	if(rank == Rank.D){
      		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    	}
    	if(rank == Rank.C){
      		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    	}
    	if(rank == Rank.B){
      		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    	}
    	if(rank == Rank.A){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    	}
    	if(rank == Rank.ZPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    	}
    	if(rank == Rank.YPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    		ranksPasses.add(Rank.YPlus);
    	}
    	if(rank == Rank.XPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    		ranksPasses.add(Rank.YPlus);
    		ranksPasses.add(Rank.XPlus);
    	}
    	if(rank == Rank.WPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    		ranksPasses.add(Rank.YPlus);
    		ranksPasses.add(Rank.XPlus);
    		ranksPasses.add(Rank.WPlus);
    	}
    	if(rank == Rank.VPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    		ranksPasses.add(Rank.YPlus);
    		ranksPasses.add(Rank.XPlus);
    		ranksPasses.add(Rank.WPlus);
    		ranksPasses.add(Rank.VPlus);
    	}
    	if(rank == Rank.UPlus){
       		ranksPasses.add(Rank.Z);
    		ranksPasses.add(Rank.Y);
    		ranksPasses.add(Rank.X);
    		ranksPasses.add(Rank.W);
    		ranksPasses.add(Rank.V);
    		ranksPasses.add(Rank.U);
    		ranksPasses.add(Rank.T);
    		ranksPasses.add(Rank.S);
    		ranksPasses.add(Rank.R);
    		ranksPasses.add(Rank.Q);
    		ranksPasses.add(Rank.P);
    		ranksPasses.add(Rank.O);
    		ranksPasses.add(Rank.N);
    		ranksPasses.add(Rank.M);
    		ranksPasses.add(Rank.L);
    		ranksPasses.add(Rank.K);
    		ranksPasses.add(Rank.J);
    		ranksPasses.add(Rank.I);
    		ranksPasses.add(Rank.H);
    		ranksPasses.add(Rank.G);
    		ranksPasses.add(Rank.F);
    		ranksPasses.add(Rank.E);
    		ranksPasses.add(Rank.D);
    		ranksPasses.add(Rank.C);
    		ranksPasses.add(Rank.B);
    		ranksPasses.add(Rank.A);
    		ranksPasses.add(Rank.ZPlus);
    		ranksPasses.add(Rank.YPlus);
    		ranksPasses.add(Rank.XPlus);
    		ranksPasses.add(Rank.WPlus);
    		ranksPasses.add(Rank.VPlus);
    		ranksPasses.add(Rank.UPlus);
    	}
		
    	return ranksPasses;
	}
	
	public static boolean isLoaded(Player p){
		
		if(StorageManager.IsLoaded.containsKey(p)){
			if(StorageManager.IsLoaded.get(p) == false){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	public static void warnPlayerNotLoaded(Player p){
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		p.sendMessage("§4§lPrison §8| §7This Server just §4restarted§7! Wait a few §4seconds§7.");
	}
	
	
	/*
	 * 
	 * Pets:
	 * 
	 */
	
	public static void removePet(Player p, String petname){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f" + petname + "§7!");
		for(World w : Bukkit.getWorlds()){
			for(Entity en : w.getEntities()){
				if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
					if(en instanceof LivingEntity){
						en.remove();
						StorageManager.owners.remove(StorageManager.ownerpets.get(p));
						StorageManager.ownerpets.remove(p);
					}
				}
			}
		}
	}
	
	public static boolean isPetActive(Player p){
		
		if(StorageManager.ownerpets.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void spawnPet(Player p, Pet pet){
		
		if(pet == Pet.MUSHROOMCOW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMushroomCow cow = new CustomMushroomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.mushroomcow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			final UUID petID = cow.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.PIG){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomPig pig = new CustomPig(nmsWorld);
		    pig.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(pig);
			pig.setAge(1);
			pig.setCustomName(StorageManager.pig.get(p.getName()));
			pig.setCustomNameVisible(true);
			
			final UUID petID = pig.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.WOLF){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomWolf wolf = new CustomWolf(nmsWorld);
		    wolf.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(wolf);
			wolf.setAge(1);
			wolf.setCustomName(StorageManager.wolf.get(p.getName()));
			wolf.setCustomNameVisible(true);
			
			final UUID petID = wolf.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SHEEP){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSheep sheep = new CustomSheep(nmsWorld);
		    sheep.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(sheep);
			sheep.setAge(1);
			sheep.setCustomName(StorageManager.sheep.get(p.getName()));
			sheep.setCustomNameVisible(true);
			
			final UUID petID = sheep.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.HORSE){
			Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
			horse.setAdult();
			horse.setCustomName(StorageManager.horse.get(p.getName()));
			horse.setCustomNameVisible(true);
			horse.setTamed(true);
			horse.setRemoveWhenFarAway(false);
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse.setColor(Horse.Color.BROWN);
			horse.setStyle(Style.WHITE);
			
			final UUID petID = horse.getUniqueId();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.MAGMACUBE){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMagmaCube magmacube = new CustomMagmaCube(nmsWorld);
		    magmacube.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(magmacube);
			magmacube.setSize(3);
			magmacube.setCustomName(StorageManager.magmacube.get(p.getName()));
			magmacube.setCustomNameVisible(true);
			
			final UUID petID = magmacube.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SLIME){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSlime slime = new CustomSlime(nmsWorld);
		    slime.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(slime);
			slime.setSize(3);
			slime.setCustomName(StorageManager.slime.get(p.getName()));
			slime.setCustomNameVisible(true);
			
			final UUID petID = slime.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.COW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomCow cow = new CustomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.cow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			final UUID petID = cow.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SILVERFISH){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSilverfish silverfish = new CustomSilverfish(nmsWorld);
		    silverfish.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(silverfish);
			silverfish.setCustomName(StorageManager.silverfish.get(p.getName()));
			silverfish.setCustomNameVisible(true);
			
			final UUID petID = silverfish.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.OCELOT){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomOcelot ocelot = new CustomOcelot(nmsWorld);
		    ocelot.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(ocelot);
			ocelot.setAge(1);
			ocelot.setCustomName(StorageManager.ocelot.get(p.getName()));
			ocelot.setCustomNameVisible(true);
			
			final UUID petID = ocelot.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
	}
	
	/*
	 * 
	 * Disguise
	 * 
	 */
	
	public static boolean isDisguised(Player p){
		
		if(DisguiseAPI.isDisguised(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeDisguise(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your Disguise!");
		DisguiseAPI.undisguiseToAll(p);
		
	}
	
	/*
	 * 
	 * Gadgets
	 * 
	 */
	
	@SuppressWarnings("deprecation")
	public static void removeGadget(Player p){
		
		String s = p.getInventory().getItem(6).getItemMeta().getDisplayName();
		
		if(s.endsWith("Stacker")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lStacker§7!");
		}
		if(s.endsWith("Paintballs")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f§lPaintballs§7!");
		}
		if(s.endsWith("Creeper Launcher")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §a§lCreeper Launcher§7!");
		}
		if(s.endsWith("Pet Ride")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §e§lPet Ride§7!");
		}
		if(s.endsWith("Book Explosion")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7§lBook Explosion§7!");
		}
		if(s.startsWith("Firework Gun")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lFirework Gun§7!");
		}
		
		p.getInventory().setItem(6, null);
		p.updateInventory();
	}
	
	/*
	 * 
	 * Wardrobe
	 * 
	 */
	
	public static boolean hasWardrobeArmor(Player p){
		
		if(p.getInventory().getChestplate() != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeWardrobeArmor(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your " + p.getInventory().getChestplate().getItemMeta().getDisplayName() +"§7!");
		
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}
	
	public static void giveLeatherWardrobeArmor(Player p, Color color, String displayname){
		
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setChestplate(item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setLeggings(item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setBoots(item);
		}
		
	}
	
	public static void giveWardrobeArmor(Player p, Material m1, Material m2, Material m3, String displayname){
		
		{
			ItemStack item = new ItemStack(m1, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setChestplate(item);
		}
		{
			ItemStack item = new ItemStack(m2, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setLeggings(item);
		}
		{
			ItemStack item = new ItemStack(m3, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setBoots(item);
		}
	}
	
	/*
	 * 
	 * Trails
	 * 
	 */
	
	public static boolean hasTrailEnabled(Player p){
		
		if(StorageManager.trail.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeTrail(Player p){
		
		String s = StorageManager.trail.get(p);
		
		if(s.equals("MobSpawner")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7Mob Spawner Trail§7!");
		}
		if(s.equals("FireWork")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cFireWork Spark Trail§7!");
		}
		if(s.equals("Crit")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §bCrit Trail§7!");
		}
		if(s.equals("Magic")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §3Magic Trail§7!");
		}
		if(s.equals("Bubble")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fBubble Trail§7!");
		}
		if(s.equals("Witch")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §5Witch Trail§7!");
		}
		if(s.equals("Music")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §dMusic Trail§7!");
		}
		if(s.equals("EnchantmentTable")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §1Enchantment Table Trail§7!");
		}
		if(s.equals("TNT")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4TNT Trail§7!");
		}
		if(s.equals("Lava")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6Lava Trail§7!");
		}
		if(s.equals("Water")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §9Water Trail§7!");
		}
		if(s.equals("Smoke")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §0Smoke Trail§7!");
		}
		if(s.equals("Rainbow")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4Rainbow Trail§7!");
		}
		if(s.equals("Snow")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fSnow Trail§7!");
		}
		if(s.equals("Hearts")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cHeart Trail§7!");
		}
		if(s.equals("HappyVillager")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aHappy Villager Trail§7!");
		}
		if(s.equals("AngryVillager")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §8Angry Villager Trail§7!");
		}
		if(s.equals("Slime")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aSlime Trail§7!");
		}
		
		StorageManager.trail.remove(p);
	}
	
	/*
	 * 
	 * Hats
	 * 
	 */
	
	public static boolean hasHat(Player p){
		
		if(p.getInventory().getHelmet() != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeHat(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your Hat!");
		
		p.getInventory().setHelmet(null);
	}
}
