package me.O_o_Fadi_o_O.Hub.managers;

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
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard b = sm.getNewScoreboard();

		Objective o = b.registerNewObjective("Test", "Test2");
		
		if(StorageManager.EnableScoreboard.get(p.getName()) != null && StorageManager.EnableScoreboard.get(p.getName()) == true){
			
			o.setDisplayName("§6§lOrbitMines");
			
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
			Score score1 = o.getScore("");
			score1.setScore(12);

			Team omt = b.registerNewTeam("OMT");
			omt.setSuffix(" Tokens");
			OfflinePlayer omt1 = Bukkit.getServer().getOfflinePlayer("§e§lOrbitMines");
			omt.addPlayer(omt1);
			
			Score score2 = o.getScore(omt1.getName());
			score2.setScore(11);

			if(StorageManager.omt.get(p.getName()) != null){
				Score score3 = o.getScore(" " + StorageManager.omt.get(p.getName()) + "  ");
				score3.setScore(10);
			}
			else{
				Score score3 = o.getScore(" " + "Loading..." + "  ");
				score3.setScore(10);
			}
		
			Score score4 = o.getScore(" ");
			score4.setScore(9);

			Score score5 = o.getScore("§b§lVIP Points");
			score5.setScore(8);

			if(StorageManager.points.get(p.getName()) != null){
				Score score6 = o.getScore(" " + StorageManager.points.get(p.getName()) + "");
				score6.setScore(7);
			}
			else{
				Score score6 = o.getScore(" " + "Loading..." + "");
				score6.setScore(7);
			}

			Score score7 = o.getScore("  ");
			score7.setScore(6);
			
			Team coin = b.registerNewTeam("Coins");
			coin.setSuffix(" Coins");
			OfflinePlayer coins1 = Bukkit.getServer().getOfflinePlayer("§f§lMiniGame");
			coin.addPlayer(coins1);
			
			Score score8 = o.getScore(coins1.getName());
			score8.setScore(5);
			
			if(StorageManager.coins.get(p.getName()) != null){
				Score score9 = o.getScore(" " + StorageManager.coins.get(p.getName()) + " ");
				score9.setScore(4);
			}
			else{
				Score score9 = o.getScore(" " + "Loading..." + " ");
				score9.setScore(4);
			}
	
			Score score10 = o.getScore("   ");
			score10.setScore(3);
		}
		
		Team IronVIP = b.registerNewTeam("IronVIPHub");
		IronVIP.setPrefix("§7§lIron §f");
		Team GoldVIP = b.registerNewTeam("GoldVIPHub");
		GoldVIP.setPrefix("§6§lGold §f");
		Team DiamondVIP = b.registerNewTeam("DiamondVIPHub");
		DiamondVIP.setPrefix("§9§lDiamond §f");
		Team EmeraldVIP = b.registerNewTeam("EmeraldVIPHub");
		EmeraldVIP.setPrefix("§a§lEmerald §f");
		Team Builder = b.registerNewTeam("BuilderHub");
		Builder.setPrefix("§d§lBuilder §f");
		Team Moderator = b.registerNewTeam("ModeratorHub");
		Moderator.setPrefix("§b§lMod §f");
		Team Owner = b.registerNewTeam("OwnerHub");
		Owner.setPrefix("§4§lOwner §f");
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player.hasPermission("Rank.Owner")){
				Owner.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Moderator")){
				Moderator.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Builder")){
				Builder.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Emerald")){
				EmeraldVIP.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Diamond")){
				DiamondVIP.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Gold")){
				GoldVIP.addPlayer(player);
			}
			else if(player.hasPermission("Rank.Iron")){
				IronVIP.addPlayer(player);
			}
			else{
				
			}
		}
		
		if(StorageManager.EnableScoreboard.get(p.getName()) != null && StorageManager.EnableScoreboard.get(p.getName()) == true){
			Score score11 = o.getScore("§c§lRank");
			score11.setScore(2);
			
			if(p.hasPermission("Rank.Owner")){
				Score score12 = o.getScore(" §4§lOwner");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Moderator")){
				Score score12 = o.getScore(" §b§lModerator");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Builder")){
				Score score12 = o.getScore(" §d§lBuilder");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Emerald")){
				Score score12 = o.getScore(" §a§lEmerald VIP");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Diamond")){
				Score score12 = o.getScore(" §b§lDiamond VIP");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Gold")){
				Score score12 = o.getScore(" §6§lGold VIP");
				score12.setScore(1);
			}
			else if(p.hasPermission("Rank.Iron")){
				Score score12 = o.getScore(" §7§lIron VIP");
				score12.setScore(1);
			}
			else{
				Score score12 = o.getScore(" §fNo Rank");
				score12.setScore(1);
			}
			
			Score score13 = o.getScore("    ");
			score13.setScore(0);
			
			o.setDisplayName("§6§lOrbitMines§4§lNetwork");
		}
		
		p.setScoreboard(b);
	}
	
}
