package me.O_o_Fadi_o_O.KitPvP;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.runnables.MapRunnable;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerScoreboard {

	@SuppressWarnings("deprecation")
	public static void onScoreBoard(Player p){
			
		ScoreboardManager s = Bukkit.getScoreboardManager();
		Scoreboard b = s.getNewScoreboard();
		
		Objective o = b.registerNewObjective("Test", "Test2");
		o.setDisplayName("§c§lKitPvP");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
/*
		try{
			Score score = o.getScore(("§4§lDeaths:"));
			score.setScore(StorageManager.deaths.get(p.getName()));
			
			Score score1 = o.getScore(("§c§lKills:"));
			score1.setScore(StorageManager.kills.get(p.getName()));
			
			Score score2 = o.getScore(("§6§lCoins:"));
			score2.setScore(StorageManager.money.get(p.getName()));
			
			Score score3 = o.getScore(("§a§lOnline:"));
			score3.setScore(Bukkit.getOnlinePlayers().length);
			
			Score score4 = o.getScore(("§e§lTokens:"));
			score4.setScore(StorageManager.omt.get(p.getName()));
			
			Score score5 = o.getScore(("§b§lVIP Points:"));
			score5.setScore(StorageManager.points.get(p.getName()));
		}catch(Exception ex){
			
		}
		*/
		
		Score score16 = o.getScore("");
		score16.setScore(14);
		
		Team mTeam = b.registerNewTeam("MapSwitch");
		OfflinePlayer mPlayer = Bukkit.getServer().getOfflinePlayer("§cMap Switch in ");
		mTeam.setSuffix("§6§l" + MapRunnable.Minutes + "m " + MapRunnable.Seconds + "s");
		mTeam.addPlayer(mPlayer);
		
		Score score15 = o.getScore(mPlayer.getName());
		score15.setScore(13);
		
		Score score14 = o.getScore(" ");
		score14.setScore(12);
		
		Score score13 = o.getScore("§7§lKit");
		score13.setScore(11);
		
		Team kTeam = b.registerNewTeam("KitSelected");
		OfflinePlayer kPlayer = null;
		if(StorageManager.PlayerKitSelected.containsKey(p)){
			String[] PlayerKitString = StorageManager.PlayerKitSelected.get(p).toString().split("_");
			
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
		
		if(StorageManager.money.get(p.getName()) != null){
			Score score9 = o.getScore(" " + StorageManager.money.get(p.getName()));
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
		
		if(StorageManager.kills.get(p.getName()) != null){
			Score score6 = o.getScore(" " + StorageManager.kills.get(p.getName()) + " ");
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
		
		if(StorageManager.deaths.get(p.getName()) != null){
			Score score3 = o.getScore(" " + StorageManager.deaths.get(p.getName()) + "  ");
			score3.setScore(1);
		}
		else{
			Score score3 = o.getScore(" Loading...  ");
			score3.setScore(1);
		}
		
		Score score2 = o.getScore("     ");
		score2.setScore(0);
		
		Team IronVIP = b.registerNewTeam("IronVIP");
		IronVIP.setPrefix("§7§lIron §f");
		Team GoldVIP = b.registerNewTeam("GoldVIP");
		GoldVIP.setPrefix("§6§lGold §f");
		Team DiamondVIP = b.registerNewTeam("DiamondVIP");
		DiamondVIP.setPrefix("§9§lDiamond §f");
		Team EmeraldVIP = b.registerNewTeam("EmeraldVIP");
		EmeraldVIP.setPrefix("§a§lEmerald §f");
		Team Builder = b.registerNewTeam("Builder");
		Builder.setPrefix("§d§lBuilder §f");
		Team Moderator = b.registerNewTeam("Moderator");
		Moderator.setPrefix("§b§lMod §f");
		Team Owner = b.registerNewTeam("Owner");
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
		
		o.setDisplayName("§6§lOrbitMines§c§lKitPvP");
			
		p.setScoreboard(b);
		
	}
}
