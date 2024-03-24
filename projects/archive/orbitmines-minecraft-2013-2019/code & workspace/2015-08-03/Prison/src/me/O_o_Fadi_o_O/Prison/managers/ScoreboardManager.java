package me.O_o_Fadi_o_O.Prison.managers;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.utils.StaffRank;
import me.O_o_Fadi_o_O.Prison.utils.VIPRank;

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

		Objective o = b.registerNewObjective("Prison", "Test2");
		
		o.setDisplayName("§6§lOrbitMines");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
	
		Score score1 = o.getScore("");
		score1.setScore(12);

		Team omt = b.registerNewTeam("OMTPrison");
		omt.setSuffix(" Tokens");
		OfflinePlayer omt1 = Bukkit.getServer().getOfflinePlayer("§e§lOrbitMines");
		omt.addPlayer(omt1);
		
		Score score2 = o.getScore(omt1.getName());
		score2.setScore(11);

		if(StorageManager.orbitminestokens.get(p) != null){
			Score score3 = o.getScore(" " + StorageManager.orbitminestokens.get(p) + "  ");
			score3.setScore(10);
		}
		else{
			Score score3 = o.getScore(" " + "Loading..." + "");
			score3.setScore(10);
		}
	
		Score score4 = o.getScore(" ");
		score4.setScore(9);

		Score score5 = o.getScore("§b§lVIP Points");
		score5.setScore(8);

		if(StorageManager.vippoints.get(p) != null){
			Score score6 = o.getScore(" " + StorageManager.vippoints.get(p) + " ");
			score6.setScore(7);
		}
		else{
			Score score6 = o.getScore(" " + "Loading..." + " ");
			score6.setScore(7);
		}

		Score score7 = o.getScore("  ");
		score7.setScore(6);
		
		Score score8 = o.getScore("§6§lGold");
		score8.setScore(5);

		if(StorageManager.money.get(p) != null){
			Score score9 = o.getScore(" " + StorageManager.money.get(p) + "");
			score9.setScore(4);
		}
		else{
			Score score9 = o.getScore(" " + "Loading..." + "  ");
			score9.setScore(4);
		}

		Score score10 = o.getScore("   ");
		score10.setScore(3);
		
		Score score11 = o.getScore("§9§lRank");
		score11.setScore(2);

		if(StorageManager.playerrank.get(p) != null){
			Score score12 = o.getScore(" §a§l" + PlayerManager.getRankString(p) + "");
			score12.setScore(1);
		}
		else{
			Score score12 = o.getScore(" " + "Loading..." + "   ");
			score12.setScore(1);
		}

		Score score13 = o.getScore("    ");
		score13.setScore(0);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			
			StaffRank staff = StorageManager.staffrank.get(player);
			VIPRank vip = StorageManager.viprank.get(player);
			
			if(staff == StaffRank.Owner){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§4§lOwner §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§4§lOwner §f");
					t.addPlayer(player);
				}
			}
			else if(staff == StaffRank.Moderator){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§b§lMod §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§b§lMod §f");
					t.addPlayer(player);
				}
			}
			else if(staff == StaffRank.Builder){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§d§lBuilder §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§d§lBuilder §f");
					t.addPlayer(player);
				}
			}
			else if(vip == VIPRank.Emerald_VIP){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§a§lEmerald §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§a§lEmerald §f");
					t.addPlayer(player);
				}
			}
			else if(vip == VIPRank.Diamond_VIP){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§9§lDiamond §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§9§lDiamond §f");
					t.addPlayer(player);
				}
			}
			else if(vip == VIPRank.Gold_VIP){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§6§lGold §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§6§lGold §f");
					t.addPlayer(player);
				}
			}
			else if(vip == VIPRank.Iron_VIP){
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§7§lIron §f");
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
				else{
					Team t = b.registerNewTeam(player.getName());
					t.setPrefix("§7§lIron §f");
					t.addPlayer(player);
				}
			}
			else{
				if(StorageManager.playerrank.get(player) != null){
					Team t = b.registerNewTeam(player.getName());
					t.setSuffix(" §7>§a§l" + PlayerManager.getRankString(player) + "§7<");
					t.addPlayer(player);
				}
			}
		}
		
		
		o.setDisplayName(ScoreboardTitleManager.title);
		
		p.setScoreboard(b);
	}
}
