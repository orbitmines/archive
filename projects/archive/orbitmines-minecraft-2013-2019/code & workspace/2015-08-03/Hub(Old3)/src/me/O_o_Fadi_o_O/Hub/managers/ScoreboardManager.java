package me.O_o_Fadi_o_O.Hub.managers;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.utils.StaffRank;
import me.O_o_Fadi_o_O.Hub.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

	Hub hub = Hub.getInstance();
	
	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p){
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard b = sm.getNewScoreboard();

		Objective o = b.registerNewObjective("Hub", "Hub2");
		
		if(StorageManager.scoreboardenabled.get(p) == true){
			
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

			if(StorageManager.orbitminestokens.containsKey(p)){
				Score score3 = o.getScore(" " + StorageManager.orbitminestokens.get(p) + "  ");
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

			if(StorageManager.vippoints.containsKey(p)){
				Score score6 = o.getScore(" " + StorageManager.vippoints.get(p) + "");
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
			
			if(StorageManager.minigamecoins.containsKey(p)){
				Score score9 = o.getScore(" " + StorageManager.minigamecoins.get(p) + " ");
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
		
			StaffRank staff = StorageManager.staffrank.get(player);
			VIPRank vip = StorageManager.viprank.get(player);
			
			if(staff == StaffRank.Owner){
				Owner.addPlayer(player);
			}
			else if(staff == StaffRank.Moderator){
				Moderator.addPlayer(player);
			}
			else if(staff == StaffRank.Builder){
				Builder.addPlayer(player);
			}
			else if(vip == VIPRank.Emerald_VIP){
				EmeraldVIP.addPlayer(player);
			}
			else if(vip == VIPRank.Diamond_VIP){
				DiamondVIP.addPlayer(player);
			}
			else if(vip == VIPRank.Gold_VIP){
				GoldVIP.addPlayer(player);
			}
			else if(vip == VIPRank.Iron_VIP){
				IronVIP.addPlayer(player);
			}
			else{
				
			}
		}
		
		if(StorageManager.scoreboardenabled.get(p) == true){
			Score score11 = o.getScore("§c§lRank");
			score11.setScore(2);
			
			StaffRank staff = StorageManager.staffrank.get(p);
			VIPRank vip = StorageManager.viprank.get(p);
			
			if(staff == StaffRank.Owner){
				Score score12 = o.getScore(" §4§lOwner");
				score12.setScore(1);
			}
			else if(staff == StaffRank.Moderator){
				Score score12 = o.getScore(" §b§lModerator");
				score12.setScore(1);
			}
			else if(staff == StaffRank.Builder){
				Score score12 = o.getScore(" §d§lBuilder");
				score12.setScore(1);
			}
			else if(vip == VIPRank.Emerald_VIP){
				Score score12 = o.getScore(" §a§lEmerald VIP");
				score12.setScore(1);
			}
			else if(vip == VIPRank.Diamond_VIP){
				Score score12 = o.getScore(" §b§lDiamond VIP");
				score12.setScore(1);
			}
			else if(vip == VIPRank.Gold_VIP){
				Score score12 = o.getScore(" §6§lGold VIP");
				score12.setScore(1);
			}
			else if(vip == VIPRank.Iron_VIP){
				Score score12 = o.getScore(" §7§lIron VIP");
				score12.setScore(1);
			}
			else{
				Score score12 = o.getScore(" §fNo Rank");
				score12.setScore(1);
			}
			
			Score score13 = o.getScore("    ");
			score13.setScore(0);
			
			o.setDisplayName(ScoreboardTitleManager.title);
		}
		
		p.setScoreboard(b);
	}
	
}
