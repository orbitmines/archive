package me.O_o_Fadi_o_O.SkyBlock.managers;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.utils.StaffRank;
import me.O_o_Fadi_o_O.SkyBlock.utils.VIPRank;

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

		Objective o = b.registerNewObjective("SkyBlock", "SkyBlock2");
			
		o.setDisplayName("§6§lOrbitMines");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
	
		Score score1 = o.getScore("");
		score1.setScore(9);

		Team omt = b.registerNewTeam("OMTSky");
		omt.setSuffix(" Tokens");
		OfflinePlayer omt1 = Bukkit.getServer().getOfflinePlayer("§e§lOrbitMines");
		omt.addPlayer(omt1);
		
		Score score2 = o.getScore(omt1.getName());
		score2.setScore(8);

		if(StorageManager.orbitminestokens.containsKey(p)){
			Score score3 = o.getScore(" " + StorageManager.orbitminestokens.get(p) + " ");
			score3.setScore(7);
		}
		else{
			Score score3 = o.getScore(" " + "Loading..." + "  ");
			score3.setScore(7);
		}
	
		Score score4 = o.getScore(" ");
		score4.setScore(6);

		Score score5 = o.getScore("§b§lVIP Points");
		score5.setScore(5);

		if(StorageManager.vippoints.containsKey(p)){
			Score score6 = o.getScore(" " + StorageManager.vippoints.get(p) + "");
			score6.setScore(4);
		}
		else{
			Score score6 = o.getScore(" " + "Loading..." + "");
			score6.setScore(4);
		}

		Score score7 = o.getScore("  ");
		score7.setScore(3);
		
		Score score8 = o.getScore("§d§lIsland Number");
		score8.setScore(2);

		if(PlayerManager.hasIsland(p)){
			Score score9 = o.getScore(" " + StorageManager.playersislandnumber.get(p) + "  ");
			score9.setScore(1);
		}
		else{
			Score score9 = o.getScore(" " + "/is h" + "");
			score9.setScore(1);
		}

		Score score10 = o.getScore("   ");
		score10.setScore(0);
		
		Team IronVIP = b.registerNewTeam("IronVIPSky");
		IronVIP.setPrefix("§7§lIron §f");
		Team GoldVIP = b.registerNewTeam("GoldVIPSky");
		GoldVIP.setPrefix("§6§lGold §f");
		Team DiamondVIP = b.registerNewTeam("DiamondVIPSky");
		DiamondVIP.setPrefix("§9§lDiamond §f");
		Team EmeraldVIP = b.registerNewTeam("EmeraldVIPSky");
		EmeraldVIP.setPrefix("§a§lEmerald §f");
		Team Builder = b.registerNewTeam("BuilderSky");
		Builder.setPrefix("§d§lBuilder §f");
		Team Moderator = b.registerNewTeam("ModeratorSky");
		Moderator.setPrefix("§b§lMod §f");
		Team Owner = b.registerNewTeam("OwnerSky");
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
		
		o.setDisplayName(ScoreboardTitleManager.title);
		
		p.setScoreboard(b);
	}
}
