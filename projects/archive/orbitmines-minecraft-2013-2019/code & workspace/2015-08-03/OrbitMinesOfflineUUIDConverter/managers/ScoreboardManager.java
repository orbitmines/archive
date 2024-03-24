package me.O_o_Fadi_o_O.Survival.managers;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.jobs.managers.JobManager;
import me.O_o_Fadi_o_O.Survival.jobs.utils.Job;
import me.O_o_Fadi_o_O.Survival.utils.StaffRank;
import me.O_o_Fadi_o_O.Survival.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p){
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard b = sm.getNewScoreboard();

		Objective o = b.registerNewObjective("Survival", "Survival2");
			
		o.setDisplayName("§6§lOrbitMines");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
	
		Score score1 = o.getScore("");
		score1.setScore(12);

		Team omt = b.registerNewTeam("OMTSurv");
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
		
		Score score8 = o.getScore("§6§lJob");
		score8.setScore(5);

		if(JobManager.job.containsKey(p)){
			Score score9 = o.getScore(" " + Job.getScoreboardName(JobManager.job.get(p)));
			score9.setScore(4);
		}
		else{
			Score score9 = o.getScore(" " + "-" + "");
			score9.setScore(4);
		}

		Score score10 = o.getScore("   ");
		score10.setScore(3);
		
		Team IronVIP = b.registerNewTeam("IronVIPSurv");
		IronVIP.setPrefix("§7§lIron §f");
		Team GoldVIP = b.registerNewTeam("GoldVIPSurv");
		GoldVIP.setPrefix("§6§lGold §f");
		Team DiamondVIP = b.registerNewTeam("DiamondVIPSurv");
		DiamondVIP.setPrefix("§9§lDiamond §f");
		Team EmeraldVIP = b.registerNewTeam("EmeraldVIPSurv");
		EmeraldVIP.setPrefix("§a§lEmerald §f");
		Team Builder = b.registerNewTeam("BuilderSurv");
		Builder.setPrefix("§d§lBuilder §f");
		Team Moderator = b.registerNewTeam("ModeratorSurv");
		Moderator.setPrefix("§b§lMod §f");
		Team Owner = b.registerNewTeam("OwnerSurv");
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
		
		Score score11 = o.getScore("§2§lMoney");
		score11.setScore(2);
		
		if(JobManager.money.containsKey(p)){
			Score score12 = o.getScore(" " + JobManager.money.get(p) + "$");
			score12.setScore(1);
		}
		else{
			Score score12 = o.getScore(" " + "Loading..." + " ");
			score12.setScore(1);
		}
		
		Score score13 = o.getScore("    ");
		score13.setScore(0);
		
		o.setDisplayName(ScoreboardTitleManager.title);
		
		
		p.setScoreboard(b);
	}
	
}
