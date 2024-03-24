package me.O_o_Fadi_o_O.Event.scoreboard;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.managers.Manager;
import me.O_o_Fadi_o_O.Event.utils.GameState;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Board {

	public static int i = 0;
	public static void setScoreboard(Player p){
		
		if(Start.state != GameState.ENDING){
			ScoreboardManager sb = Bukkit.getScoreboardManager();
			Scoreboard b = sb.getNewScoreboard();	
			Objective o = b.registerNewObjective("Test1", "Test2");
		
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			o.setDisplayName("§6§lOrbitMines");
			
			if(Start.state == GameState.LOBBY){
				Score score1 = o.getScore("");
				score1.setScore(5);	
				
				if(i == 1){
					Score score2 = o.getScore("§6§lWaiting.");
					score2.setScore(4);	
				}
				else if(i == 2){
					Score score2 = o.getScore("§6§lWaiting..");
					score2.setScore(4);	
				}
				else if(i == 3){
					Score score2 = o.getScore("§6§lWaiting...");
					score2.setScore(4);	
				}
				
				Score score3 = o.getScore(" ");
				score3.setScore(3);	
				
				Score score4 = o.getScore("§a§lPlayers");
				score4.setScore(2);	
				
				Score score5 = o.getScore(" " + Manager.Players.size());
				score5.setScore(1);	
				
				Score score6 = o.getScore("  ");
				score6.setScore(0);		
			}
			if(Start.state == GameState.WARMUP){
				Score score1 = o.getScore("");
				score1.setScore(6);	
			
				Score score2 = o.getScore("§6§lTime Left");
				score2.setScore(5);	
				
				Score score3 = o.getScore(" " + Manager.Minutes + "m " + Manager.Seconds + "s");
				score3.setScore(4);	
				
				Score score4 = o.getScore(" ");
				score4.setScore(3);	
				
				Score score5 = o.getScore("§a§lPlayers");
				score5.setScore(2);	
				
				Score score6 = o.getScore(" " + Manager.Players.size());
				score6.setScore(1);	
				
				Score score7 = o.getScore("  ");
				score7.setScore(0);	
			}
			if(Start.state == GameState.INGAME){	
				
				Score score3 = o.getScore("");
				score3.setScore(9);	
				
				Score score4 = o.getScore("§a§lAlive");
				score4.setScore(8);	
				
				Score score5 = o.getScore(" " + Manager.Players.size());
				score5.setScore(7);	
				
				Score score6 = o.getScore(" ");
				score6.setScore(6);
				
				Score score7 = o.getScore("§c§lDead");
				score7.setScore(5);	
				
				Score score8 = o.getScore(" " + Manager.DeadPlayers.size() + " ");
				score8.setScore(4);
				
				Score score9 = o.getScore("  ");
				score9.setScore(3);
				
				Score score10 = o.getScore("§8§lGhosts Alive");
				score10.setScore(2);	
				
				Score score12 = o.getScore(" " + Manager.Ghosts.size() + "  ");
				score12.setScore(1);
				
				Score score13 = o.getScore("   ");
				score13.setScore(0);
			}
			
			Team Players = b.registerNewTeam("Players");
			Players.setPrefix("§a");
			
			Team Ghosts = b.registerNewTeam("Ghosts");
			Ghosts.setPrefix("§8");
			
			Team Spectators = b.registerNewTeam("Spectators");
			Spectators.setPrefix("§e");
			
			Players.setCanSeeFriendlyInvisibles(false);
			Players.setAllowFriendlyFire(false);
			Ghosts.setAllowFriendlyFire(false);
			Ghosts.setCanSeeFriendlyInvisibles(true);
			Spectators.setCanSeeFriendlyInvisibles(true);
			Spectators.setAllowFriendlyFire(false);
			
			for(Player player : Bukkit.getOnlinePlayers()){
			    if(Manager.Players.contains(player)){
					Players.addPlayer(player);
				}
				else if(Manager.Ghosts.contains(player)){
					Ghosts.addPlayer(player);
				}
				else{
					Spectators.addPlayer(player);
					if(Manager.Players.contains(p) || Manager.Ghosts.contains(p)){
						p.hidePlayer(player);
					}
				}
			}
			
			o.setDisplayName("§6§lOrbitMines §3§lEvent");
			p.setScoreboard(b);
		}
	}
}
