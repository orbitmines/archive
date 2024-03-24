package me.O_o_Fadi_o_O.KitPvP.managers;

import me.O_o_Fadi_o_O.KitPvP.utils.StaffRank;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p){
			
		org.bukkit.scoreboard.ScoreboardManager s = Bukkit.getScoreboardManager();
		Scoreboard b = s.getNewScoreboard();
		
		Objective o = b.registerNewObjective("KitPvP", "KitPvP2");
		o.setDisplayName("§c§lKitPvP");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score score16 = o.getScore("");
		score16.setScore(14);
		
		Team sTeam = b.registerNewTeam("Streak");
		OfflinePlayer sPlayer = Bukkit.getServer().getOfflinePlayer("§f§lCurrent ");
		sTeam.setSuffix("Streak: §6§l" + StorageManager.currentstreak.get(p));
		sTeam.addPlayer(sPlayer);
		
		Score score15 = o.getScore(sPlayer.getName());
		score15.setScore(13);
		
		Score score14 = o.getScore(" ");
		score14.setScore(12);
		
		Score score13 = o.getScore("§7§lKit");
		score13.setScore(11);
		
		Team kTeam = b.registerNewTeam("KitSelected");
		OfflinePlayer kPlayer = null;
		if(StorageManager.kitselected.containsKey(p)){
			String[] PlayerKitString = StorageManager.kitselected.get(p).toString().split("_");
			
			kPlayer = Bukkit.getServer().getOfflinePlayer(" §b§l" + PlayerKitString[0]);
			kTeam.setSuffix(" §7(§aLvL " + PlayerKitString[2] + "§7)");
			kTeam.addPlayer(kPlayer);
			
		}
		
		if(kPlayer != null){
			Score score12 = o.getScore(kPlayer.getName());
			score12.setScore(10);
		}
		else{
			kPlayer = Bukkit.getServer().getOfflinePlayer(" Selecting ");
			kTeam.setSuffix("Kit...");
			kTeam.addPlayer(kPlayer);
			Score score12 = o.getScore(kPlayer.getName());
			score12.setScore(10);
		}
		
		Score score11 = o.getScore("  ");
		score11.setScore(9);
		
		Score score10 = o.getScore("§6§lCoins");
		score10.setScore(8);
		
		if(StorageManager.money.get(p) != null){
			Score score9 = o.getScore(" " + StorageManager.money.get(p));
			score9.setScore(7);
		}
		else{
			Score score9 = o.getScore(" Loading...");
			score9.setScore(7);
		}
		
		Score score8 = o.getScore("   ");
		score8.setScore(6);
		
		Score score7 = o.getScore("§c§lKills");
		score7.setScore(5);
		
		if(StorageManager.kills.get(p) != null){
			Score score6 = o.getScore(" " + StorageManager.kills.get(p) + " ");
			score6.setScore(4);
		}
		else{
			Score score6 = o.getScore(" Loading... ");
			score6.setScore(4);
		}
		
		Score score5 = o.getScore("    ");
		score5.setScore(3);
		
		Score score4 = o.getScore("§4§lDeaths");
		score4.setScore(2);
		
		if(StorageManager.deaths.get(p) != null){
			Score score3 = o.getScore(" " + StorageManager.deaths.get(p) + "  ");
			score3.setScore(1);
		}
		else{
			Score score3 = o.getScore(" Loading...  ");
			score3.setScore(1);
		}
		
		Score score2 = o.getScore("     ");
		score2.setScore(0);
		
		Team IronVIP = b.registerNewTeam("IronVIPPvP");
		IronVIP.setPrefix("§7§lIron §f");
		Team GoldVIP = b.registerNewTeam("GoldVIPPvP");
		GoldVIP.setPrefix("§6§lGold §f");
		Team DiamondVIP = b.registerNewTeam("DiamondVIPPvP");
		DiamondVIP.setPrefix("§9§lDiamond §f");
		Team EmeraldVIP = b.registerNewTeam("EmeraldVIPPvP");
		EmeraldVIP.setPrefix("§a§lEmerald §f");
		Team Builder = b.registerNewTeam("BuilderPvP");
		Builder.setPrefix("§d§lBuilder §f");
		Team Moderator = b.registerNewTeam("ModeratorPvP");
		Moderator.setPrefix("§b§lMod §f");
		Team Owner = b.registerNewTeam("OwnerPvP");
		Owner.setPrefix("§4§lOwner §f");
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(PlayerManager.hasStaffPerms(player, StaffRank.Owner)){
				Owner.addPlayer(player);
			}
			else if(PlayerManager.hasStaffPerms(player, StaffRank.Moderator)){
				Moderator.addPlayer(player);
			}
			else if(PlayerManager.hasStaffPerms(player, StaffRank.Builder)){
				Builder.addPlayer(player);
			}
			else if(PlayerManager.hasVIPPerms(player, VIPRank.Emerald_VIP)){
				EmeraldVIP.addPlayer(player);
			}
			else if(PlayerManager.hasVIPPerms(player, VIPRank.Diamond_VIP)){
				DiamondVIP.addPlayer(player);
			}
			else if(PlayerManager.hasVIPPerms(player, VIPRank.Gold_VIP)){
				GoldVIP.addPlayer(player);
			}
			else if(PlayerManager.hasVIPPerms(player, VIPRank.Iron_VIP)){
				IronVIP.addPlayer(player);
			}
			else{
				
			}
		}
		
		o.setDisplayName("§6§lOrbitMines§c§lKitPvP");
			
		p.setScoreboard(b);
		
	}
}
