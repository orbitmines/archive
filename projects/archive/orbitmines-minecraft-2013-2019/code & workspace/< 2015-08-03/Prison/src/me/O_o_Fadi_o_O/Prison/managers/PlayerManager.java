package me.O_o_Fadi_o_O.Prison.managers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.NMS.PetChicken;
import me.O_o_Fadi_o_O.Prison.NMS.PetCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Prison.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Prison.NMS.PetPig;
import me.O_o_Fadi_o_O.Prison.NMS.PetSheep;
import me.O_o_Fadi_o_O.Prison.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Prison.NMS.PetSlime;
import me.O_o_Fadi_o_O.Prison.NMS.PetSpider;
import me.O_o_Fadi_o_O.Prison.NMS.PetSquid;
import me.O_o_Fadi_o_O.Prison.NMS.PetWolf;
import me.O_o_Fadi_o_O.Prison.utils.ChatColor;
import me.O_o_Fadi_o_O.Prison.utils.Disguise;
import me.O_o_Fadi_o_O.Prison.utils.Gadget;
import me.O_o_Fadi_o_O.Prison.utils.Pet;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.O_o_Fadi_o_O.Prison.utils.StaffRank;
import me.O_o_Fadi_o_O.Prison.utils.Trail;
import me.O_o_Fadi_o_O.Prison.utils.TrailType;
import me.O_o_Fadi_o_O.Prison.utils.VIPRank;
import me.mgone.bossbarapi.BossbarAPI;
import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.GenericAttributes;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerManager {

	Start start = Start.getInstance();
	NPCManager npcmanager = new NPCManager();
	
	public static int bossbarnumber = 0;
	
	public static void setBossBar(Player p){
		if(bossbarnumber <= 10){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!");
		}
		else if(bossbarnumber <= 20){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.orbitminestokens.get(p) + "§6 OMT");
		}
		else if(bossbarnumber <= 30){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com");
		}
		else if(bossbarnumber <= 40){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com");
		}
		else if(bossbarnumber <= 50){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" +  StorageManager.vippoints.get(p) + "§6 VIP Points");
		}
		else if(bossbarnumber <= 60){
			BossbarAPI.removeBar(p);
			BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(Start.getUUIDfromPlayer(p)) + "§6 Votes");
			bossbarnumber = 0;
		}
	}
	
	public static boolean hasMoney(Player p, int amount){
		if(StorageManager.money.get(p) >= amount){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isInPvP(Player p){
		if(StorageManager.playerinpvp.get(p) != null){
			if(StorageManager.playerinpvp.get(p) == true){
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
		StorageManager.playerclockenabled.put(p, ConfigManager.playerdata.getBoolean("players." + Start.getUUIDfromPlayer(p).toString() + ".Clock"));
	}
	public static void toggleClockEnabled(Player p){
		if(StorageManager.playerclockenabled.get(p) == true){
			ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".Clock", false);
			ConfigManager.savePlayerData();
			StorageManager.playerclockenabled.put(p, false);
			p.sendMessage(Start.TAG + "Clock §c§lDISABLED§7!");
		}
		else{
			ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".Clock", true);
			ConfigManager.savePlayerData();
			StorageManager.playerclockenabled.put(p, true);
			p.sendMessage(Start.TAG + "Clock §a§lENABLED§7!");
		}
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
	}

	public static void updateGambleTickets(Player p){
		StorageManager.playergambletickets.put(p, ConfigManager.playerdata.getInt("players." + Start.getUUIDfromPlayer(p).toString() + ".GambleTickets"));
	}
	public static void giveGambleTickets(Player p, int amount){
		ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".GambleTickets", StorageManager.playergambletickets.get(p) + amount);
		ConfigManager.savePlayerData();
		StorageManager.playergambletickets.put(p, StorageManager.playergambletickets.get(p) + amount);
	}
	public static void removeGambleTickets(Player p, int amount){
		ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".GambleTickets", StorageManager.playergambletickets.get(p) - amount);
		ConfigManager.savePlayerData();
		StorageManager.playergambletickets.put(p, StorageManager.playergambletickets.get(p) - amount);
	}
	
	public static void updateMoney(Player p){
		StorageManager.money.put(p, ConfigManager.playerdata.getInt("players." + Start.getUUIDfromPlayer(p).toString() + ".Money"));
	}
	public static void giveMoney(Player p, int amount){
		ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".Money", StorageManager.money.get(p) + amount);
		ConfigManager.savePlayerData();
		StorageManager.money.put(p, StorageManager.money.get(p) + amount);
	}
	public static void removeMoney(Player p, int amount){
		ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".Money", StorageManager.money.get(p) - amount);
		ConfigManager.savePlayerData();
		StorageManager.money.put(p, StorageManager.money.get(p) - amount);
	}
	
	public static String getRankString(Player p){
		Rank rank = StorageManager.playerrank.get(p);
		
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
		Rank rank = StorageManager.playerrank.get(p);
		
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
		Bukkit.broadcastMessage("§4§lPrison §8| §8" + getPlayerDisplayname(p) + "§7 ranked up to §a§l" + nextRankString + "§7!");
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		ConfigManager.playerdata.set("players." + Start.getUUIDfromPlayer(p).toString() + ".Rank", nextRank.toString());
		ConfigManager.savePlayerData();
		StorageManager.playerrank.put(p, nextRank);
	}
	
	public static void updateRank(Player p){
		String rankString = ConfigManager.playerdata.getString("players." + Start.getUUIDfromPlayer(p).toString() + ".Rank");
		Rank rank = Rank.valueOf(rankString);
		StorageManager.playerrank.put(p, rank);
	}
	
	
	public static List<Rank> getAllRanksPassed(Player p){
		
		Rank rank = StorageManager.playerrank.get(p);
		
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
	
	/*
	public static void setLastDonator(Player p){
		ConfigManager.playerdata.set("LastDonator", p.getName());
		ConfigManager.savePlayerData();
		
		StorageManager.lastdonatorstring = p.getName();
	}
	*/
	
	public static ItemStack getPlayerHead(String player){
		ItemStack item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(player);
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static ItemStack addColorToLeather(Material leather, Color color){
		ItemStack item = new ItemStack(leather, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(color);
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static void handlePlayerVIPPointsDonation(Player p, int vippoints){
		
		TitleManager.setTitle(p, "", "§b+" + vippoints + " VIP Points");
		
		DatabaseManager.addVIPPoints(p, vippoints);
	}
	
	public static void handlePlayerRankDonation(Player p, VIPRank rank){
		
		TitleManager.setTitle(p, "", getRankMessage(p, rank));
		
		if(StorageManager.viprank.get(p) != VIPRank.User){
			DatabaseManager.setVIPRank(p, rank);
		}
		else{
			StorageManager.viprank.put(p, rank);
			DatabaseManager.insertString(p.getName(), "Rank-VIP", "vip", rank.toString());
		}
	}
	
	public static String getRankMessage(Player p, VIPRank rank){
		if(rank == VIPRank.Emerald_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now an §a§lEmerald VIP§7!");
			return "§7You are now an §a§lEmerald VIP§7!";
		}
		else if(rank == VIPRank.Diamond_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now a §b§lDiamond VIP§7!");
			return "§7You are now a §b§lDiamond VIP§7!";
		}
		else if(rank == VIPRank.Gold_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now a §6§lGold VIP§7!");
			return "§7You are now a §6§lGold VIP§7!";
		}
		else if(rank == VIPRank.Iron_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now an §7§lIron VIP§7!");
			return "§7You are now an §7§lIron VIP§7!";
		}
		else{
			return "";
		}
	}
	
	public static boolean hasVIPPerms(Player p, VIPRank rank){
		if(rank == VIPRank.Iron_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Iron_VIP || StorageManager.viprank.get(p) == VIPRank.Gold_VIP || StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Gold_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Gold_VIP || StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Diamond_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Emerald_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
	}
	
	public static void sendVIPPointsRequiredMessage(Player p, int price){
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int needed = price - StorageManager.vippoints.get(p);
		if(needed == 1){
			p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
		}
		else{
			p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
		}
	}
	
	public static void sendOMTRequiredMessage(Player p, int price){
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int needed = price - StorageManager.orbitminestokens.get(p);
		if(needed == 1){
			p.sendMessage("§e§lOMT Shop §8| §7You need §e§l" + needed + "§7 more §e§lOrbitMines Token§7!");
		}
		else{
			p.sendMessage("§e§lOMT Shop §8| §7You need §e§l" + needed + "§7 more §e§lOrbitMines Tokens§7!");
		}
	}
	
	public static void sendMoneyRequiredMessage(Player p, int price){
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);

		p.sendMessage("§a§lMerchant §8| §7You need §2" + price + "$§7 to pay this.");
	}
	
	public static void setCustomTabList(Player p){
        IChatBaseComponent tab1 = ChatSerializer.a("{\"text\": \"§6§lOrbitMines§4§lNetwork\"}");
        IChatBaseComponent tab2 = ChatSerializer.a("{\"text\": \"  §7Type §l/help§7 for Help.\"}");
        PacketPlayOutPlayerListHeaderFooter pack = new PacketPlayOutPlayerListHeaderFooter(tab1);
 
        try{
            Field field = pack.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(pack, tab2);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
        	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(pack);
        }
	}
	
	public static void warnPlayerNotLoaded(Player p){
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		p.sendMessage("§4§lPrison §8| §7This Server just §4restarted§7! Wait a few §4seconds§7.");
	}
	
	public static String getPlayerDisplayname(Player p){
		
		StaffRank staff = StorageManager.staffrank.get(p);
		VIPRank vip = StorageManager.viprank.get(p);
		
		if(staff == StaffRank.Owner){
			return "§4§lOwner §4" + p.getName(); 
		}
		else if(staff == StaffRank.Moderator){
			return "§b§lMod §b" + p.getName(); 
		}
		else if(staff == StaffRank.Builder){
			return "§d§lBuilder §d" + p.getName(); 
		}
		else if(vip == VIPRank.Emerald_VIP){
			return "§a§lEmerald §a" + p.getName(); 
		}
		else if(vip == VIPRank.Diamond_VIP){
			return "§9§lDiamond §9" + p.getName(); 
		}
		else if(vip == VIPRank.Gold_VIP){
			return "§6§lGold §6" + p.getName(); 
		}
		else if(vip == VIPRank.Iron_VIP){
			return "§7§lIron §7" + p.getName(); 
		}
		else{
			return "§8" + p.getName(); 
		}
	}
	
	public static boolean hasWardrobeArmor(Player p){
		
		if(p.getInventory().getChestplate() != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	public static void removeWardrobeArmor(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your " + p.getInventory().getChestplate().getItemMeta().getDisplayName() +"§7!");
		
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		if(StorageManager.wardrobedisco.containsKey(p) && StorageManager.wardrobedisco.get(p) == true){
			DatabaseManager.setDiscoWardrobe(p, false);
		}
	}
	*/
	
	public static void setRandomArmorForConfirmInv(Inventory inv, Player p){
		Color c = null;
		String color = null;
		
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		int rInt = new Random().nextInt(14);
		
		if(rInt == 0){c = Color.AQUA; color = "§b";}
		if(rInt == 1){c = Color.BLACK; color = "§0";}
		if(rInt == 2){c = Color.BLUE; color = "§9";}
		if(rInt == 3){c = Color.FUCHSIA; color = "§d";}
		if(rInt == 4){c = Color.GRAY; color = "§7";}
		if(rInt == 5){c = Color.GREEN; color = "§2";}
		if(rInt == 6){c = Color.LIME; color = "§a";}
		if(rInt == 7){c = Color.NAVY; color = "§1";}
		if(rInt == 8){c = Color.ORANGE; color = "§6";}
		if(rInt == 9){c = Color.PURPLE; color = "§5";}
		if(rInt == 10){c = Color.RED; color = "§c";}
		if(rInt == 11){c = Color.TEAL; color = "§3";}
		if(rInt == 12){c = Color.WHITE; color = "§f";}
		if(rInt == 13){c = Color.YELLOW; color = "§e";}
		
		meta.setColor(c);
		meta.setDisplayName(color + "Disco Armor");
		item.setItemMeta(meta);
		
		inv.setItem(13, item);
	}
	
	/*
	public static void setRandomArmorForWardrobeInv(Inventory inv, Player p){
		Color c = null;
		String color = null;
		
		int rInt = new Random().nextInt(14);
		
		if(rInt == 0){c = Color.AQUA; color = "§b";}
		if(rInt == 1){c = Color.BLACK; color = "§0";}
		if(rInt == 2){c = Color.BLUE; color = "§9";}
		if(rInt == 3){c = Color.FUCHSIA; color = "§d";}
		if(rInt == 4){c = Color.GRAY; color = "§7";}
		if(rInt == 5){c = Color.GREEN; color = "§2";}
		if(rInt == 6){c = Color.LIME; color = "§a";}
		if(rInt == 7){c = Color.NAVY; color = "§1";}
		if(rInt == 8){c = Color.ORANGE; color = "§6";}
		if(rInt == 9){c = Color.PURPLE; color = "§5";}
		if(rInt == 10){c = Color.RED; color = "§c";}
		if(rInt == 11){c = Color.TEAL; color = "§3";}
		if(rInt == 12){c = Color.WHITE; color = "§f";}
		if(rInt == 13){c = Color.YELLOW; color = "§e";}
		
		Wardrobe.setDiscoItem(inv, p, c, color);
	}
	
	public static void setRandomArmorForPlayerInv(Player p){
		List<Color> unlockedColors = StorageManager.wardrobeunlockedcolors.get(p);
		int rInt = new Random().nextInt(unlockedColors.size());
		
		Color c = unlockedColors.get(rInt);
		
		String color = null;

		if(c == Color.AQUA){ color = "§b";}
		if(c == Color.BLACK){ color = "§0";}
		if(c == Color.BLUE){ color = "§9";}
		if(c == Color.FUCHSIA){ color = "§d";}
		if(c == Color.GRAY){ color = "§7";}
		if(c == Color.GREEN){ color = "§2";}
		if(c == Color.LIME){ color = "§a";}
		if(c == Color.NAVY){ color = "§1";}
		if(c == Color.ORANGE){ color = "§6";}
		if(c == Color.PURPLE){ color = "§5";}
		if(c == Color.RED){ color = "§c";}
		if(c == Color.TEAL){ color = "§3";}
		if(c == Color.WHITE){ color = "§f";}
		if(c == Color.YELLOW){ color = "§e";}
		
		giveLeatherWardrobeArmor(p, c, color + "Disco Armor");
	}
	*/
	
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
	
	public static boolean hasTrailEnabled(Player p){
		
		if(StorageManager.trail.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeTrail(Player p){
		
		Trail trail = StorageManager.trail.get(p);
		
		if(trail == Trail.MOB_SPAWNER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7Mob Spawner Trail§7!");
		}
		if(trail == Trail.FIREWORK_SPARK){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cFireWork Spark Trail§7!");
		}
		if(trail == Trail.CRIT){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §bCrit Trail§7!");
		}
		if(trail == Trail.MAGIC){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §3Magic Trail§7!");
		}
		if(trail == Trail.BUBBLE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fBubble Trail§7!");
		}
		if(trail == Trail.WITCH){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §5Witch Trail§7!");
		}
		if(trail == Trail.MUSIC){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §dMusic Trail§7!");
		}
		if(trail == Trail.ENCHANTMENT_TABLE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §1Enchantment Table Trail§7!");
		}
		if(trail == Trail.TNT){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4TNT Trail§7!");
		}
		if(trail == Trail.LAVA){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6Lava Trail§7!");
		}
		if(trail == Trail.WATER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §9Water Trail§7!");
		}
		if(trail == Trail.SMOKE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §0Smoke Trail§7!");
		}
		if(trail == Trail.RAINBOW){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4Rainbow Trail§7!");
		}
		if(trail == Trail.SNOW){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fSnow Trail§7!");
		}
		if(trail == Trail.HEART){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cHeart Trail§7!");
		}
		if(trail == Trail.HAPPY_VILLAGER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aHappy Villager Trail§7!");
		}
		if(trail == Trail.ANGRY_VILLAGER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §8Angry Villager Trail§7!");
		}
		if(trail == Trail.SLIME){
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
	
	/*
	 * Gadgets
	 */
	
	public static Gadget getGadgetEnabled(Player p){
		
		try{
			
			String displayName = p.getInventory().getItem(5).getItemMeta().getDisplayName();
			
			if(displayName.endsWith("Stacker")){
				return Gadget.STACKER;
			}
			else if(displayName.endsWith("Paintballs")){
				return Gadget.PAINTBALLS;
			}
			else if(displayName.endsWith("Creeper Launcher")){
				return Gadget.CREEPER_LAUNCHER;
			}
			else if(displayName.endsWith("Pet Ride")){
				return Gadget.PET_RIDE;
			}
			else if(displayName.endsWith("Book Explosion")){
				return Gadget.BOOK_EXPLOSION;
			}
			else if(displayName.endsWith("Swap Teleporter")){
				return Gadget.SWAP_TELEPORTER;
			}
			else if(displayName.startsWith("§c§nFirework Gun")){
				return Gadget.FIREWORK_GUN;
			}
			else if(displayName.endsWith("MagmaCube Soccer")){
				return Gadget.MAGMACUBE_SOCCER;
			}
			else if(displayName.endsWith("Snowman Attack")){
				return Gadget.SNOWMAN_ATTACK;
			}
			else{
				return Gadget.STACKER;
			}
		}
		catch(Exception ex){
			return null;
		}
	}
	
	public static void removeGadget(Player p){
		
		Gadget g = getGadgetEnabled(p);
		
		if(g == Gadget.STACKER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lStacker§7!");
		}
		else if(g == Gadget.PAINTBALLS){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f§lPaintballs§7!");
		}
		else if(g == Gadget.CREEPER_LAUNCHER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §a§lCreeper Launcher§7!");
		}
		else if(g == Gadget.PET_RIDE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §e§lPet Ride§7!");
		}
		else if(g == Gadget.BOOK_EXPLOSION){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7§lBook Explosion§7!");
		}
		else if(g == Gadget.SWAP_TELEPORTER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §2§lSwap Teleporter§7!");
		}
		else if(g == Gadget.FIREWORK_GUN){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lFirework Gun§7!");
		}
		else if(g == Gadget.MAGMACUBE_SOCCER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lMagmaCube Soccer§7!");
		}
		else if(g == Gadget.SNOWMAN_ATTACK){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lSnowman Attack§7!");
		}
		
		p.getInventory().setItem(5, null);
		p.updateInventory();
	}
	
	/*
	 * Pets
	 */
	
	public static void removePet(Player p, String petname){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f" + petname + "§7!");
		Entity en = StorageManager.petentity.get(p);
		StorageManager.pet.put(p, Pet.NONE);
		if(en instanceof LivingEntity){
			en.remove();
			StorageManager.petentity.remove(p);
			StorageManager.petowner.remove(en);
		}
		/*
		if(StorageManager.petshroomtrail.containsKey(p)){
			StorageManager.petshroomtrail.remove(p);
		}
		if(StorageManager.petbabypigs.containsKey(p) && StorageManager.petbabypigs.get(p) == true){
			for(Entity pig : StorageManager.petbabypigsentities.get(p)){
				pig.remove();
			}
			StorageManager.petbabypigs.remove(p);
		}
		if(StorageManager.petsheepdisco.containsKey(p)){
			StorageManager.petsheepdisco.remove(p);
		}
		*/
	}
	
	/*
	@SuppressWarnings("deprecation")
	public static void givePetInv(Player p){
		
		Pet pet = StorageManager.pet.get(p);
		p.getInventory().clear();
		
		if(pet == Pet.SQUID){
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8§nInk Bomb");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§9§nWater Spout");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SPIDER){
			{
				ItemStack item = new ItemStack(Material.WEB, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nWebs");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.SPIDER_EYE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§nSpider Launcher");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.MUSHROOMCOW){
			if(StorageManager.petshroomtrail.get(p) == false){
				ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_1, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§4§nShroom Trail§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_2, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§4§nShroom Trail§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.FIREWORK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nBaby Firework");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.MAGMACUBE){
			{
				ItemStack item = new ItemStack(Material.FIREBALL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nFireball");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int size = ((MagmaCube) StorageManager.petentity.get(p)).getSize();
				ItemStack item = new ItemStack(Material.MAGMA_CREAM, size);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Size");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.PIG){
			if(StorageManager.petbabypigs.get(p) == false){
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nBaby Pigs§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 90);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nBaby Pigs§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 90);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Pig) StorageManager.petentity.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.PORK, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SLIME){
			{
				ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nSuper Jump");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int size = ((Slime) StorageManager.petentity.get(p)).getSize();
				ItemStack item = new ItemStack(Material.SLIME_BALL, size);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§nChange Size");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.WOLF){
			{
				ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nBark");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Wolf) StorageManager.petentity.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.BONE, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.COW){
			{
				ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nMilk Explosion");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Cow) StorageManager.petentity.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.RAW_BEEF, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SHEEP){
			if(StorageManager.petsheepdisco.get(p) == false){
				ItemStack item = new ItemStack(Material.WOOL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nSheep Disco§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.WOOL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nSheep Disco§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				Sheep s = (Sheep) StorageManager.petentity.get(p);
				
				int DyeInt = s.getColor().getDyeData();
				
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nChange Color§7 (" + getColorNameFromSheep(s) + "§7)");
				item.setItemMeta(meta);
				item.setDurability((short) DyeInt);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SILVERFISH){
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nSilverfish Bomb");
				item.setItemMeta(meta);
				item.setDurability((short) 60);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.STONE_HOE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8§nLeap");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.HORSE){
			{
				Horse h = (Horse) StorageManager.petentity.get(p);
				int speed = 1;
				
				AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) h).getHandle()).getAttributeInstance(GenericAttributes.d);
				if(currentSpeed.b() == 0.25){
					speed = 1;
				}
				if(currentSpeed.b() == 0.5){
					speed = 2;
				}
				if(currentSpeed.b() == 0.75){
					speed = 3;
				}
				
				ItemStack item = new ItemStack(Material.FEATHER, speed);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nChange Speed");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.LEATHER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§nChange Color");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.OCELOT){
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§nKitty Cannon");
				item.setItemMeta(meta);
				item.setDurability((short) 98);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.RAW_FISH, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§9§nChange Color");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.CREEPER){
			{
				ItemStack item = new ItemStack(Material.TNT, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nExplode");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				Creeper c = (Creeper) StorageManager.petentity.get(p);

				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				if(c.isPowered()){
					meta.setDisplayName("§a§nChange Type§7 (§e§lLIGHTNING§7)");
				}
				else{
					meta.setDisplayName("§a§nChange Type§7 (§6§lNORMAL§7)");
				}
				item.setItemMeta(meta);
				item.setDurability((short) 50);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.CHICKEN){
			{
				ItemStack item = new ItemStack(Material.EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nEgg Bomb");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Chicken) StorageManager.petentity.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.RAW_CHICKEN, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
	}
	*/
	
	@SuppressWarnings("deprecation")
	public static DyeColor getNextDyeColorForSheep(Sheep s){
		int DyeInt = s.getColor().getDyeData();
		
		if(DyeInt == 15){
			DyeInt = 0;
		}
		else{
			DyeInt = DyeInt +1;
		}
		
		return DyeColor.getByDyeData((byte) DyeInt);
	}
	
	public static String getColorNameFromSheep(Sheep s){
		DyeColor c = s.getColor();
	
		if(c == DyeColor.BLACK){return "§0§lBlack";}
		else if(c == DyeColor.BLUE){return "§1§lBlue";}
		else if(c == DyeColor.BROWN){return "§f§lBrown";}
		else if(c == DyeColor.CYAN){return "§3§lCyan";}
		else if(c == DyeColor.GRAY){return "§8§lGray";}
		else if(c == DyeColor.GREEN){return "§2§lGreen";}
		else if(c == DyeColor.LIGHT_BLUE){return "§b§lLight Blue";}
		else if(c == DyeColor.LIME){return "§a§lLight Green";}
		else if(c == DyeColor.MAGENTA){return "§d§lMagenta";}
		else if(c == DyeColor.ORANGE){return "§6§lOrange";}
		else if(c == DyeColor.PINK){return "§d§lPink";}
		else if(c == DyeColor.PURPLE){return "§5§lPurple";}
		else if(c == DyeColor.RED){return "§c§lRed";}
		else if(c == DyeColor.SILVER){return "§7§lLight Gray";}
		else if(c == DyeColor.WHITE){return "§f§lWhite";}
		else if(c == DyeColor.YELLOW){return "§e§lYellow";}
		else{return "";}
	}
	
	public static void spawnPet(Player p, Pet pet){
		
		Location l = p.getLocation();
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) l.getWorld()).getHandle();
		
		if(pet == Pet.CREEPER){
		    PetCreeper petentity = new PetCreeper(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.CREEPER);
		    petentity.setCustomName(StorageManager.creeperpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SPIDER){
		    PetSpider petentity = new PetSpider(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SPIDER);
		    petentity.setCustomName(StorageManager.spiderpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.MUSHROOMCOW){
		    PetMushroomCow petentity = new PetMushroomCow(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.MUSHROOMCOW);
		    petentity.setCustomName(StorageManager.mushroomcowpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			//StorageManager.petshroomtrail.put(p, false);
		}
		else if(pet == Pet.PIG){
		    PetPig petentity = new PetPig(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.PIG);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.pigpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			
			//StorageManager.petbabypigs.put(p, false);
		}
		else if(pet == Pet.WOLF){
		    PetWolf petentity = new PetWolf(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.WOLF);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.wolfpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SHEEP){
		    PetSheep petentity = new PetSheep(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SHEEP);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.sheeppet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			
			//StorageManager.petsheepdisco.put(p, false);
		}
		else if(pet == Pet.HORSE){
		    StorageManager.pet.put(p, Pet.HORSE);
			Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
			horse.setAdult();
			horse.setCustomName(StorageManager.horsepet.get(p));
			horse.setCustomNameVisible(true);
			horse.setTamed(true);
			horse.setRemoveWhenFarAway(false);
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse.setColor(Horse.Color.BROWN);
			horse.setStyle(Style.WHITE);
			StorageManager.petowner.put(horse, p);
			StorageManager.petentity.put(p, horse);
			AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) horse).getHandle()).getAttributeInstance(GenericAttributes.d);
			currentSpeed.setValue(0.25);
		}
		else if(pet == Pet.MAGMACUBE){
		    PetMagmaCube petentity = new PetMagmaCube(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    petentity.setSize(3);
		    StorageManager.pet.put(p, Pet.MAGMACUBE);
		    petentity.setCustomName(StorageManager.magmacubepet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SLIME){
		    PetSlime petentity = new PetSlime(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SLIME);
		    petentity.setSize(3);
		    petentity.setCustomName(StorageManager.slimepet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.COW){
		    PetCow petentity = new PetCow(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.COW);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.cowpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SILVERFISH){
		    PetSilverfish petentity = new PetSilverfish(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SILVERFISH);
		    petentity.setCustomName(StorageManager.silverfishpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.OCELOT){
		    PetOcelot petentity = new PetOcelot(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.OCELOT);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.ocelotpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SQUID){
		    PetSquid petentity = new PetSquid(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SQUID);
		    petentity.setCustomName(StorageManager.squidpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.CHICKEN){
		    PetChicken petentity = new PetChicken(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.CHICKEN);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.chickenpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
	}
	
	public static boolean parseBoolean(String bl){
		if(bl.equals("true")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static Color parseColor(String color){
		Color c = null;
		if(color.equals("AQUA")){
			c = Color.AQUA;
		}
		else if(color.equals("BLACK")){
			c = Color.BLACK;
		}
		else if(color.equals("BLUE")){
			c = Color.BLUE;
		}
		else if(color.equals("FUCHSIA")){
			c = Color.FUCHSIA;
		}
		else if(color.equals("GRAY")){
			c = Color.GRAY;
		}
		else if(color.equals("GREEN")){
			c = Color.GREEN;
		}
		else if(color.equals("LIME")){
			c = Color.LIME;
		}
		else if(color.equals("MAROON")){
			c = Color.MAROON;
		}
		else if(color.equals("NAVY")){
			c = Color.NAVY;
		}
		else if(color.equals("OLIVE")){
			c = Color.OLIVE;
		}
		else if(color.equals("ORANGE")){
			c = Color.ORANGE;
		}
		else if(color.equals("PURPLE")){
			c = Color.PURPLE;
		}
		else if(color.equals("RED")){
			c = Color.RED;
		}
		else if(color.equals("SILVER")){
			c = Color.SILVER;
		}
		else if(color.equals("TEAL")){
			c = Color.TEAL;
		}
		else if(color.equals("WHITE")){
			c = Color.WHITE;
		}
		else if(color.equals("YELLOW")){
			c = Color.YELLOW;
		}
		else{
			c = null;
		}
		return c;
	}
	
	public static String parseStringFromColor(Color color){
		String c;
		if(color == Color.AQUA){
			c = "AQUA";
		}
		else if(color == Color.BLACK){
			c = "BLACK";
		}
		else if(color == Color.BLUE){
			c = "BLUE";
		}
		else if(color == Color.FUCHSIA){
			c = "FUCHSIA";
		}
		else if(color == Color.GRAY){
			c = "GRAY";
		}
		else if(color == Color.GREEN){
			c = "GREEN";
		}
		else if(color == Color.LIME){
			c = "LIME";
		}
		else if(color == Color.MAROON){
			c = "MAROON";
		}
		else if(color == Color.NAVY){
			c = "NAVY";
		}
		else if(color == Color.OLIVE){
			c = "OLIVE";
		}
		else if(color == Color.ORANGE){
			c = "ORANGE";
		}
		else if(color == Color.PURPLE){
			c = "PURPLE";
		}
		else if(color == Color.RED){
			c = "RED";
		}
		else if(color == Color.SILVER){
			c = "SILVER";
		}
		else if(color == Color.TEAL){
			c = "TEAL";
		}
		else if(color == Color.WHITE){
			c = "WHITE";
		}
		else if(color == Color.YELLOW){
			c = "YELLOW";
		}
		else{
			c = null;
		}
		return c;
	}
	
	public void loadPlayer(final Player p){
		PlayerManager.setCustomTabList(p);
		StorageManager.opmodeenabled.put(p, false);
		StorageManager.loaded.put(p, false);
		//JoinItems.giveItems(p);
		
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
		if(ConfigManager.playerdata.contains("players." + p.getName())){
			ConfigManager.playerdata.set("players." + uuid + ".Money", ConfigManager.playerdata.getInt("players." + p.getName() + ".Money"));
			ConfigManager.playerdata.set("players." + uuid + ".Rank", ConfigManager.playerdata.getString("players." + p.getName() + ".Rank"));
			ConfigManager.playerdata.set("players." + uuid + ".Clock", ConfigManager.playerdata.getBoolean("players." + p.getName() + ".Clock"));
			ConfigManager.playerdata.set("players." + uuid + ".GambleTickets", ConfigManager.playerdata.getInt("players." + p.getName() + ".GambleTickets"));
			try{ConfigManager.playerdata.set("players." + uuid + ".RareChests", ConfigManager.playerdata.getBoolean("players." + p.getName() + ".RareChests"));}catch(Exception ex){}
			try{ConfigManager.playerdata.set("players." + uuid + ".LegendaryChests", ConfigManager.playerdata.getInt("players." + p.getName() + ".LegendaryChests"));}catch(Exception ex){}
			
			ConfigManager.playerdata.set("players." + p.getName(), null);
			ConfigManager.savePlayerData();
		}
		
		if(!ConfigManager.playerdata.contains("players." + uuid)){
			ItemStack item = new ItemStack(Material.IRON_PICKAXE);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§9Starter Pickaxe");
			item.setItemMeta(meta);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			item.addEnchantment(Enchantment.DIG_SPEED, 3);
			p.getInventory().setItem(4, item);
		}
		try{
			
			if(!ConfigManager.playerdata.contains("players." + uuid)){
				ConfigManager.playerdata.set("players." + uuid + ".Money", 0);
				ConfigManager.playerdata.set("players." + uuid + ".Rank", "Z");
				ConfigManager.playerdata.set("players." + uuid + ".Clock", true);
				ConfigManager.savePlayerData();
			}
			if(!ConfigManager.playerdata.contains("players." + uuid + ".GambleTickets")){
				ConfigManager.playerdata.set("players." + uuid + ".GambleTickets", 0);
				ConfigManager.savePlayerData();
			}
		
			PlayerManager.updateClockEnabled(p);
			PlayerManager.updateMoney(p);
			PlayerManager.updateRank(p);
			PlayerManager.updateGambleTickets(p);
			StorageManager.playerinpvp.put(p, false);	
				
			if(DatabaseManager.containsPath("uuid", "Rank-VIP", uuid)){
				StorageManager.viprank.put(p, VIPRank.valueOf(DatabaseManager.getString(p.getName(), "Rank-VIP", "vip")));
			}
			else{
				StorageManager.viprank.put(p, VIPRank.User);
			}
			
			if(DatabaseManager.containsPath("uuid", "Rank-Staff", uuid)){
				StorageManager.staffrank.put(p, StaffRank.valueOf(DatabaseManager.getString(p.getName(), "Rank-Staff", "staff")));
			}
			else{
				StorageManager.staffrank.put(p, StaffRank.User);
			}
			
			//if(!ConfigManager.playerdata.contains("players." + p.getName() + ".ClaimedMonthlyVIPPoints")){
			//	ConfigManager.playerdata.set("players." + p.getName() + ".ClaimedMonthlyVIPPoints", false);
			//}
			
			StorageManager.pet.put(p, Pet.NONE);
			
			//StorageManager.usedmonthlyvippoints.put(p, ConfigManager.playerdata.getBoolean("players." + p.getName() + ".ClaimedMonthlyVIPPoints"));
		
			if(!DatabaseManager.containsPath("uuid", "Votes", p.getName().toLowerCase())){
				DatabaseManager.insertInt(p.getName().toLowerCase(), "Votes", "votes", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "OrbitMinesTokens", uuid)){
				DatabaseManager.insertInt(p.getName(), "OrbitMinesTokens", "omt", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "VIPPoints", uuid)){
				DatabaseManager.insertInt(p.getName(), "VIPPoints", "points", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "MiniGameCoins", uuid)){
				DatabaseManager.insertInt(p.getName(), "MiniGameCoins", "coins", 0);
			}
			
			if(!DatabaseManager.containsPath("uuid", "MiniGameKills", uuid)){
				DatabaseManager.insertInt(p.getName(), "MiniGameKills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "MiniGameLoses", uuid)){
				DatabaseManager.insertInt(p.getName(), "MiniGameLoses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "MiniGameWins", uuid)){
				DatabaseManager.insertInt(p.getName(), "MiniGameWins", "wins", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "SurvivalGames-Kills", uuid)){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Kills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "SurvivalGames-Loses", uuid)){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Loses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "SurvivalGames-Wins", uuid)){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Wins", "wins", 0);
			}
			if(!DatabaseManager.containsPath("uuid", "Fireworks-Passes", uuid)){
				DatabaseManager.insertInt(p.getName(), "Fireworks-Passes", "passes", 0);
			}
			StorageManager.orbitminestokens.put(p, DatabaseManager.getInt(p.getName(), "OrbitMinesTokens", "omt"));
			StorageManager.vippoints.put(p, DatabaseManager.getInt(p.getName(), "VIPPoints", "points"));
			//StorageManager.minigamecoins.put(p, DatabaseManager.getInt(p.getName(), "MiniGameCoins", "coins"));
			
			StorageManager.votes.put(Start.getUUIDfromPlayer(p), DatabaseManager.getInt(p.getName(), "Votes", "votes"));
			//ConfigManager.playerdata.set("players." + p.getName() + ".Votes", StorageManager.votes.get(p.getName()));
			//ConfigManager.savePlayerData();
			
			//StorageManager.fireworkpasses.put(p, DatabaseManager.getInt(p.getName(), "Fireworks-Passes", "passes"));
			
			/*
			if(DatabaseManager.containsPath("uuid", "Gadgets-Paintballs", uuid)){
				StorageManager.paintballsgadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-CreeperLauncher", uuid)){
				StorageManager.creeperlaunchergadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-PetRide", uuid)){
				StorageManager.petridegadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-BookExplosion", uuid)){
				StorageManager.bookexplosiongadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-SwapTeleporter", uuid)){
				StorageManager.swapteleportergadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-MagmaCubeSoccer", uuid)){
				StorageManager.magmacubesoccergadget.add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Gadgets-SnowmanAttack", uuid)){
				StorageManager.snowmanattackgadget.add(p);
			}
			*/
			
			boolean hasPet = false;
			if(DatabaseManager.containsPath("uuid", "Pets-MushroomCow", uuid)){
				StorageManager.mushroomcowpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Ocelot", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Pig", uuid)){
				StorageManager.pigpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Pig", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Wolf", uuid)){
				StorageManager.wolfpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Wolf", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Sheep", uuid)){
				StorageManager.sheeppet.put(p, DatabaseManager.getString(p.getName(), "Pets-Sheep", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Horse", uuid)){
				StorageManager.horsepet.put(p, DatabaseManager.getString(p.getName(), "Pets-Horse", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-MagmaCube", uuid)){
				StorageManager.magmacubepet.put(p, DatabaseManager.getString(p.getName(), "Pets-MagmaCube", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Slime", uuid)){
				StorageManager.slimepet.put(p, DatabaseManager.getString(p.getName(), "Pets-Slime", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Cow", uuid)){
				StorageManager.cowpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Cow", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Silverfish", uuid)){
				StorageManager.silverfishpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Silverfish", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Ocelot", uuid)){
				StorageManager.ocelotpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Ocelot", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Creeper", uuid)){
				StorageManager.creeperpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Creeper", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Squid", uuid)){
				StorageManager.squidpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Squid", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Spider", uuid)){
				StorageManager.spiderpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Spider", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("uuid", "Pets-Chicken", uuid)){
				StorageManager.chickenpet.put(p, DatabaseManager.getString(p.getName(), "Pets-Chicken", "petname"));
				hasPet = true;
			}
			
			StorageManager.hasunlockedpet.put(p, hasPet);
			
			/*
			List<Color> unlockedWardrobeArmor = new ArrayList<Color>();
			
			if(DatabaseManager.containsPath("uuid", "Wardrobe-White", uuid)){
				StorageManager.wardrobearmor.get(Color.WHITE).add(p);
				unlockedWardrobeArmor.add(Color.WHITE);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Blue", uuid)){
				StorageManager.wardrobearmor.get(Color.BLUE).add(p);
				unlockedWardrobeArmor.add(Color.BLUE);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Green", uuid)){
				StorageManager.wardrobearmor.get(Color.GREEN).add(p);
				unlockedWardrobeArmor.add(Color.GREEN);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Black", uuid)){
				StorageManager.wardrobearmor.get(Color.BLACK).add(p);
				unlockedWardrobeArmor.add(Color.BLACK);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-LightBlue", uuid)){
				StorageManager.wardrobearmor.get(Color.AQUA).add(p);
				unlockedWardrobeArmor.add(Color.AQUA);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Pink", uuid)){
				StorageManager.wardrobearmor.get(Color.FUCHSIA).add(p);
				unlockedWardrobeArmor.add(Color.FUCHSIA);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-LightGreen", uuid)){
				StorageManager.wardrobearmor.get(Color.LIME).add(p);
				unlockedWardrobeArmor.add(Color.LIME);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-DarkBlue", uuid)){
				StorageManager.wardrobearmor.get(Color.NAVY).add(p);
				unlockedWardrobeArmor.add(Color.NAVY);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Purple", uuid)){
				StorageManager.wardrobearmor.get(Color.PURPLE).add(p);
				unlockedWardrobeArmor.add(Color.PURPLE);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Orange", uuid)){
				StorageManager.wardrobearmor.get(Color.ORANGE).add(p);
				unlockedWardrobeArmor.add(Color.ORANGE);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Red", uuid)){
				StorageManager.wardrobearmor.get(Color.RED).add(p);
				unlockedWardrobeArmor.add(Color.RED);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Cyan", uuid)){
				StorageManager.wardrobearmor.get(Color.TEAL).add(p);
				unlockedWardrobeArmor.add(Color.TEAL);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Yellow", uuid)){
				StorageManager.wardrobearmor.get(Color.YELLOW).add(p);
				unlockedWardrobeArmor.add(Color.YELLOW);
			}
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Gray", uuid)){
				StorageManager.wardrobearmor.get(Color.GRAY).add(p);
				unlockedWardrobeArmor.add(Color.GRAY);
			}
			StorageManager.wardrobeunlockedcolors.put(p, unlockedWardrobeArmor);
			
			if(DatabaseManager.containsPath("uuid", "Wardrobe-Disco", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Wardrobe-Disco", "disco");
				if(sBoolean.equals("false")){
					StorageManager.wardrobedisco.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.wardrobedisco.put(p, true);
				}
			}
			*/
			
			if(DatabaseManager.containsPath("uuid", "ChatColors-DarkRed", uuid)){
				StorageManager.chatcolors.get(ChatColor.DARK_RED).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-LightGreen", uuid)){
				StorageManager.chatcolors.get(ChatColor.LIGHT_GREEN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-DarkGray", uuid)){
				StorageManager.chatcolors.get(ChatColor.DARK_GRAY).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Red", uuid)){
				StorageManager.chatcolors.get(ChatColor.RED).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-White", uuid)){
				StorageManager.chatcolors.get(ChatColor.WHITE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-LightBlue", uuid)){
				StorageManager.chatcolors.get(ChatColor.LIGHT_BLUE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Pink", uuid)){
				StorageManager.chatcolors.get(ChatColor.PINK).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Blue", uuid)){
				StorageManager.chatcolors.get(ChatColor.BLUE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-DarkBlue", uuid)){
				StorageManager.chatcolors.get(ChatColor.DARK_BLUE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Green", uuid)){
				StorageManager.chatcolors.get(ChatColor.GREEN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Black", uuid)){
				StorageManager.chatcolors.get(ChatColor.BLACK).add(p);
			}
			
			if(DatabaseManager.containsPath("uuid", "ChatColors-Bold", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "ChatColors-Bold", "bold");
				if(sBoolean.equals("false")){
					StorageManager.boldchatcolor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.boldchatcolor.put(p, true);
				}
			}
			if(DatabaseManager.containsPath("uuid", "ChatColors-Cursive", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "ChatColors-Cursive", "cursive");
				if(sBoolean.equals("false")){
					StorageManager.cursivechatcolor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.cursivechatcolor.put(p, true);
				}
			}
			
			boolean hasTrail = false;
			if(DatabaseManager.containsPath("uuid", "Trails-AngryVillager", uuid)){
				StorageManager.trails.get(Trail.ANGRY_VILLAGER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Hearts", uuid)){
				StorageManager.trails.get(Trail.HEART).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Bubble", uuid)){
				StorageManager.trails.get(Trail.BUBBLE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Crit", uuid)){
				StorageManager.trails.get(Trail.CRIT).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-ETable", uuid)){
				StorageManager.trails.get(Trail.ENCHANTMENT_TABLE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Explode", uuid)){
				StorageManager.trails.get(Trail.TNT).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Firework", uuid)){
				StorageManager.trails.get(Trail.FIREWORK_SPARK).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-HappyVillager", uuid)){
				StorageManager.trails.get(Trail.HAPPY_VILLAGER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-MobSpawner", uuid)){
				StorageManager.trails.get(Trail.MOB_SPAWNER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Music", uuid)){
				StorageManager.trails.get(Trail.MUSIC).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Slime", uuid)){
				StorageManager.trails.get(Trail.SLIME).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Smoke", uuid)){
				StorageManager.trails.get(Trail.SMOKE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Snow", uuid)){
				StorageManager.trails.get(Trail.SNOW).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Water", uuid)){
				StorageManager.trails.get(Trail.WATER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("uuid", "Trails-Witch", uuid)){
				StorageManager.trails.get(Trail.WITCH).add(p);
				hasTrail = true;
			}
			
			StorageManager.hasunlockedtrail.put(p, hasTrail);
			
			if(DatabaseManager.containsPath("uuid", "Trails-Type", uuid)){
				StorageManager.trailtype.put(p, TrailType.valueOf(DatabaseManager.getString(p.getName(), "Trails-Type", "type")));
			}
			else{
				DatabaseManager.insertString(p.getName(), "Trails-Type", "type", TrailType.BASIC_TRAIL.toString());
				StorageManager.trailtype.put(p, TrailType.BASIC_TRAIL);
			}
			
			if(DatabaseManager.containsPath("uuid", "Trails-TypeBig", uuid)){
				StorageManager.trailtypes.get(TrailType.BIG_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Trails-TypeBody", uuid)){
				StorageManager.trailtypes.get(TrailType.BODY_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Trails-TypeGround", uuid)){
				StorageManager.trailtypes.get(TrailType.GROUND_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Trails-TypeHead", uuid)){
				StorageManager.trailtypes.get(TrailType.HEAD_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Trails-TypeVertical", uuid)){
				StorageManager.trailtypes.get(TrailType.VERTICAL_TRAIL).add(p);
			}
			
			if(DatabaseManager.containsPath("uuid", "Trails-TypeSpecial", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Trails-TypeSpecial", "special");
				if(sBoolean.equals("false")){
					StorageManager.trailspecial.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.trailspecial.put(p, true);
				}
			}
			
			if(DatabaseManager.containsPath("uuid", "Trails-TypeParticlesAmount", uuid)){
				StorageManager.trailparticlesamount.put(p, DatabaseManager.getInt(p.getName(), "Trails-TypeParticlesAmount", "amount"));
			}
			else{
				DatabaseManager.insertInt(p.getName(), "Trails-TypeParticlesAmount", "amount", 1);
				StorageManager.trailparticlesamount.put(p, 1);
			}
			
			
			if(DatabaseManager.containsPath("uuid", "ChatColors", uuid)){
				StorageManager.chatcolor.put(p, DatabaseManager.getString(p.getName(), "ChatColors", "color"));
			}
			else{
				DatabaseManager.insertString(p.getName(), "ChatColors", "color", "7");
				StorageManager.chatcolor.put(p, "7");
			}
			
			/*
			
			boolean hasHat = false;
			if(DatabaseManager.containsPath("uuid", "Hats-Bedrock", uuid)){
				StorageManager.hats.get(Hat.BEDROCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-BlackGlass", uuid)){
				StorageManager.hats.get(Hat.BLACK_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Cactus", uuid)){
				StorageManager.hats.get(Hat.CACTUS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-CoalBlock", uuid)){
				StorageManager.hats.get(Hat.COAL_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-CoalOre", uuid)){
				StorageManager.hats.get(Hat.COAL_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Furnace", uuid)){
				StorageManager.hats.get(Hat.FURNACE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Glass", uuid)){
				StorageManager.hats.get(Hat.GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Grass", uuid)){
				StorageManager.hats.get(Hat.GRASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-GreenGlass", uuid)){
				StorageManager.hats.get(Hat.GREEN_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-HayBale", uuid)){
				StorageManager.hats.get(Hat.HAY_BALE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Ice", uuid)){
				StorageManager.hats.get(Hat.ICE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-LapisBlock", uuid)){
				StorageManager.hats.get(Hat.LAPIS_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-LapisOre", uuid)){
				StorageManager.hats.get(Hat.LAPIS_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Leaves", uuid)){
				StorageManager.hats.get(Hat.LEAVES).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-MagentaGlass", uuid)){
				StorageManager.hats.get(Hat.MAGENTA_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Melon", uuid)){
				StorageManager.hats.get(Hat.MELON).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Mycelium", uuid)){
				StorageManager.hats.get(Hat.MYCELIUM).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-OrangeGlass", uuid)){
				StorageManager.hats.get(Hat.ORANGE_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-QuartzBlock", uuid)){
				StorageManager.hats.get(Hat.QUARTZ_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-QuartzOre", uuid)){
				StorageManager.hats.get(Hat.QUARTZ_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-RedGlass", uuid)){
				StorageManager.hats.get(Hat.RED_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-RedstoneBlock", uuid)){
				StorageManager.hats.get(Hat.REDSTONE_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-RedstoneOre", uuid)){
				StorageManager.hats.get(Hat.REDSTONE_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Snow", uuid)){
				StorageManager.hats.get(Hat.SNOW).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-StoneBricks", uuid)){
				StorageManager.hats.get(Hat.STONE_BRICKS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-TNT", uuid)){
				StorageManager.hats.get(Hat.TNT).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Workbench", uuid)){
				StorageManager.hats.get(Hat.WORKBENCH).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Diorite", uuid)){
				StorageManager.hats.get(Hat.DIORITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-DarkPrismarine", uuid)){
				StorageManager.hats.get(Hat.DARK_PRISMARINE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Sponge", uuid)){
				StorageManager.hats.get(Hat.SPONGE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-SlimeBlock", uuid)){
				StorageManager.hats.get(Hat.SLIME_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-SeaLantern", uuid)){
				StorageManager.hats.get(Hat.SEA_LANTERN).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-PrismarineBricks", uuid)){
				StorageManager.hats.get(Hat.PRISMARINE_BRICKS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Granite", uuid)){
				StorageManager.hats.get(Hat.GRANITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Chest", uuid)){
				StorageManager.hats.get(Hat.CHEST).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Glowstone", uuid)){
				StorageManager.hats.get(Hat.GLOWSTONE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-WetSponge", uuid)){
				StorageManager.hats.get(Hat.WET_SPONGE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-Andesite", uuid)){
				StorageManager.hats.get(Hat.ANDESITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("uuid", "Hats-BlueGlass", uuid)){
				StorageManager.hats.get(Hat.BLUE_GLASS).add(p);
				hasHat = true;
			}
			
			StorageManager.hasunlockedhat.put(p, hasHat);
			
			if(DatabaseManager.containsPath("uuid", "Hats-BlockTrail", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Hats-BlockTrail", "blocktrail");
				if(sBoolean.equals("false")){
					StorageManager.hatsblocktrail.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.hatsblocktrail.put(p, true);
				}
			}
			
			*/
			
			if(DatabaseManager.containsPath("uuid", "Dis-Witch", uuid)){
				StorageManager.disguises.get(Disguise.WITCH).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Bat", uuid)){
				StorageManager.disguises.get(Disguise.BAT).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Chicken", uuid)){
				StorageManager.disguises.get(Disguise.CHICKEN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Ocelot", uuid)){
				StorageManager.disguises.get(Disguise.OCELOT).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-MushroomCow", uuid)){
				StorageManager.disguises.get(Disguise.MUSHROOM_COW).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Squid", uuid)){
				StorageManager.disguises.get(Disguise.SQUID).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Slime", uuid)){
				StorageManager.disguises.get(Disguise.SLIME).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-ZombiePigman", uuid)){
				StorageManager.disguises.get(Disguise.ZOMBIE_PIGMAN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-MagmaCube", uuid)){
				StorageManager.disguises.get(Disguise.MAGMA_CUBE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Skeleton", uuid)){
				StorageManager.disguises.get(Disguise.SKELETON).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Wolf", uuid)){
				StorageManager.disguises.get(Disguise.WOLF).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Spider", uuid)){
				StorageManager.disguises.get(Disguise.SPIDER).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Silverfish", uuid)){
				StorageManager.disguises.get(Disguise.SILVERFISH).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Sheep", uuid)){
				StorageManager.disguises.get(Disguise.SHEEP).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-CaveSpider", uuid)){
				StorageManager.disguises.get(Disguise.CAVE_SPIDER).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Creeper", uuid)){
				StorageManager.disguises.get(Disguise.CREEPER).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Cow", uuid)){
				StorageManager.disguises.get(Disguise.COW).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Enderman", uuid)){
				StorageManager.disguises.get(Disguise.ENDERMAN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Horse", uuid)){
				StorageManager.disguises.get(Disguise.HORSE).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-IronGolem", uuid)){
				StorageManager.disguises.get(Disguise.IRON_GOLEM).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Ghast", uuid)){
				StorageManager.disguises.get(Disguise.GHAST).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Snowman", uuid)){
				StorageManager.disguises.get(Disguise.SNOWMAN).add(p);
			}
			if(DatabaseManager.containsPath("uuid", "Dis-Rabbit", uuid)){
				StorageManager.disguises.get(Disguise.RABBIT).add(p);
			}
			
			/*
			
			if(DatabaseManager.containsPath("uuid", "ParkourCompleted", uuid)){
				StorageManager.completedlapisparkour.put(p, true);
			}
			else{
				StorageManager.completedlapisparkour.put(p, false);
			}
			
			if(DatabaseManager.containsPath("uuid", "MasterMind-Wins", uuid)){
				StorageManager.mindcraftwins.put(p, DatabaseManager.getInt(p.getName(), "MasterMind-Wins", "wins"));
			}
			else{
				DatabaseManager.insertInt(p.getName(), "MasterMind-Wins", "wins", 0);
				StorageManager.mindcraftwins.put(p, 0);
			}
			
			if(DatabaseManager.containsPath("uuid", "MasterMind-BestGame", uuid)){
				StorageManager.mindcraftbestgame.put(p, DatabaseManager.getInt(p.getName(), "MasterMind-BestGame", "turns"));
			}
			
			if(DatabaseManager.containsPath("uuid", "Hub-Players", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Hub-Players", "players");
				if(sBoolean.equals("false")){
					StorageManager.playersenabled.put(p, false);
					for(Player player : Bukkit.getOnlinePlayers()){
						p.hidePlayer(player);
					}
				}
				if(sBoolean.equals("true")){
					StorageManager.playersenabled.put(p, true);
				}
			}
			else{
				DatabaseManager.insertString(p.getName(), "Hub-Players", "players", "true");
				StorageManager.playersenabled.put(p, true);
			}
			
			if(DatabaseManager.containsPath("uuid", "Hub-Stacker", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Hub-Stacker", "stacker");
				if(sBoolean.equals("false")){
					StorageManager.stackerenabled.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.stackerenabled.put(p, true);
				}
			}
			else{
				DatabaseManager.insertString(p.getName(), "Hub-Stacker", "stacker", "true");
				StorageManager.stackerenabled.put(p, true);
			}
			
			if(DatabaseManager.containsPath("uuid", "Hub-Scoreboard", uuid)){
				String sBoolean = DatabaseManager.getString(p.getName(), "Hub-Scoreboard", "scoreboard");
				if(sBoolean.equals("false")){
					StorageManager.scoreboardenabled.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.scoreboardenabled.put(p, true);
				}
			}
			else{
				DatabaseManager.insertString(p.getName(), "Hub-Scoreboard", "scoreboard", "true");
				StorageManager.scoreboardenabled.put(p, true);
			}
			
			for(final Player player : Bukkit.getOnlinePlayers()){
				if(StorageManager.playersenabled.containsKey(player)){
					if(StorageManager.playersenabled.get(player) == false){
						player.hidePlayer(p);
					}
					else{
						player.showPlayer(p);
						
						if(StorageManager.disguise.containsKey(player)){
			    			new BukkitRunnable(){
			    				public void run(){
				        			me.O_o_Fadi_o_O.Hub.DisguisePlayer.disguisePlayer(player, StorageManager.disguise.get(player), p);
			    				}
			    			}.runTaskLater(this.hub, 40);
						}
					}
				}
			}
			
			*/
			
			if(DatabaseManager.containsPath("uuid", "PlayerNicknames", uuid)){
				StorageManager.nickname.put(p, DatabaseManager.getString(p.getName(), "PlayerNicknames", "nick"));
			}
			
			StorageManager.hatsinvpage.put(p, 1);
			
			/*
			if(DatabaseManager.containsPath("uuid", "Fireworks-Settings", uuid)){
				String[] fwsettings = DatabaseManager.getString(p.getName(), "Fireworks-Settings", "settings").split("\\|");
				StorageManager.fireworkcolor1.put(p, parseColor(fwsettings[0]));
				StorageManager.fireworkcolor2.put(p, parseColor(fwsettings[1]));
				StorageManager.fireworkfade1.put(p, parseColor(fwsettings[2]));
				StorageManager.fireworkfade2.put(p, parseColor(fwsettings[3]));
				StorageManager.fireworkflicker.put(p, parseBoolean(fwsettings[4]));
				StorageManager.fireworktrail.put(p, parseBoolean(fwsettings[5]));
				if(fwsettings[6].equals("null")){
					StorageManager.fireworktype.put(p, Type.BALL);
				}
				else{
					StorageManager.fireworktype.put(p, Type.valueOf(fwsettings[6]));
				}
			}
			else{
				String fwsettings = "AQUA|null|null|null|false|false|BALL";
				DatabaseManager.insertString(p.getName(), "Fireworks-Settings", "settings", fwsettings);
				
				StorageManager.fireworkcolor1.put(p, Color.AQUA);
				StorageManager.fireworkcolor2.put(p, null);
				StorageManager.fireworkfade1.put(p, null);
				StorageManager.fireworkfade2.put(p, null);
				StorageManager.fireworkflicker.put(p, false);
				StorageManager.fireworktrail.put(p, false);
				StorageManager.fireworktype.put(p, Type.BALL);
			}
			*/
			
			VoteManager.checkForVotes(p);
			
			StorageManager.loaded.put(p, true);
			
			TitleManager.setTitle(p, "§6§lOrbitMines§4§lPrison", "");
			
			new BukkitRunnable(){
				public void run(){
					p.sendMessage("§7§m----------------------------------------");
					p.sendMessage(" §6§lOrbitMines§4§lNetwork §7- §4§lPrison");
					p.sendMessage(" ");
					p.sendMessage(" §7§lWebsite: §6www.orbitmines.com");
					p.sendMessage(" §7§lDonate: §3shop.orbitmines.com");
					p.sendMessage(" §7§lVote: §bwww.orbitmines.com/vote");
					p.sendMessage(" ");
					p.sendMessage(" §7§lPrison Spawn Built By: §4§lOwner §4O_o_Fadi_o_O");
					p.sendMessage(" §7§lDeveloped By: §4§lOwner §4O_o_Fadi_o_O");
					p.sendMessage("§7§m----------------------------------------");
				}
			}.runTaskLater(this.start, 20);
			
			npcmanager.loadNPCs(p);
			
		}catch(Exception ex){ex.printStackTrace();}
	}
}
