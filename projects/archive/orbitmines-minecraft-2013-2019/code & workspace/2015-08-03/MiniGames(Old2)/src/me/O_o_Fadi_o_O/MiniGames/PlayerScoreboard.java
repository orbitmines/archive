package me.O_o_Fadi_o_O.MiniGames;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerScoreboard {

	static int i = 0;
	
	public static void setScoreboard(Player p){
		
		if(StorageManager.PlayersInChickenFight.contains(p) || StorageManager.SpectatorsInChickenFight.contains(p)){
			int arena = StorageManager.PlayersArena.get(p);
			if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LOBBY) || StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.LASTSECONDS)){
				
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§f§lChickenFight");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.ChickenFightPlayers.get(arena) >= 2){
					Score score1 = o.getScore("");
					score1.setScore(12);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(11);
			
					Score score3 = o.getScore(" " + StorageManager.ChickenFightMinutes.get(arena) + "m " + StorageManager.ChickenFightSeconds.get(arena) + "s");
					score3.setScore(10);
				}
				else{
					Score score1 = o.getScore("");
					score1.setScore(11);
			
					i++;
					if(i == 4){
						i = 1;
					}
					if(i == 1){
						Score score2 = o.getScore("§6§l§oWaiting.");
						score2.setScore(10);
					}
					if(i == 2){
						Score score2 = o.getScore("§6§l§oWaiting..");
						score2.setScore(10);
					}
					if(i == 3){
						Score score2 = o.getScore("§6§l§oWaiting...");
						score2.setScore(10);
					}
				}
			
				Score score4 = o.getScore(" ");
				score4.setScore(9);
		
				Score score5 = o.getScore("§a§lPlayers");
				score5.setScore(8);
				
				Score score6 = o.getScore(" " + StorageManager.ChickenFightPlayers.get(arena));
				score6.setScore(7);
		
				Score score7 = o.getScore("  ");
				score7.setScore(6);
				
				Score score8 = o.getScore("§e§lKit");
				score8.setScore(5);
				
				Score score9 = o.getScore(" " + StorageManager.ChickenFightKit.get(p));
				score9.setScore(4);
		
				Score score10 = o.getScore("   ");
				score10.setScore(3);
				
				Score score11 = o.getScore("§f§lCoins");
				score11.setScore(2);
				
				Score score12 = o.getScore(" " + StorageManager.coins.get(p.getName()) + " ");
				score12.setScore(1);
		
				Score score13 = o.getScore("    ");
				score13.setScore(0);
	
				Team IronVIP = b.registerNewTeam("IronVIPMG");
				IronVIP.setPrefix("§7§lIron §f");
				Team GoldVIP = b.registerNewTeam("GoldVIPMG");
				GoldVIP.setPrefix("§6§lGold §f");
				Team DiamondVIP = b.registerNewTeam("DiamondVIPMG");
				DiamondVIP.setPrefix("§9§lDiamond §f");
				Team EmeraldVIP = b.registerNewTeam("EmeraldVIPMG");
				EmeraldVIP.setPrefix("§a§lEmerald §f");
				Team Builder = b.registerNewTeam("BuilderMG");
				Builder.setPrefix("§d§lBuilder §f");
				Team Moderator = b.registerNewTeam("ModeratorMG");
				Moderator.setPrefix("§b§lMod §f");
				Team Owner = b.registerNewTeam("OwnerMG");
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
				
				o.setDisplayName("§f§lChicken Fight");
				
				p.setScoreboard(b);
			}
			if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.INGAME)){
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();

				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§f§lChickenFight");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.ChickenFightMinutes.get(arena) <= 1){
					Score score1 = o.getScore("");
					score1.setScore(9);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
			
					Score score3 = o.getScore(" " + StorageManager.ChickenFightMinutes.get(arena) + "m " + StorageManager.ChickenFightSeconds.get(arena) + "s");
					score3.setScore(7);
				}
			
				Score score4 = o.getScore(" ");
				score4.setScore(6);
		
				Score score5 = o.getScore("§a§lAlive");
				score5.setScore(5);
				
				Score score6 = o.getScore(" " + StorageManager.ChickenFightPlayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score8 = o.getScore("§c§lDead");
				score8.setScore(2);
				
				Score score9 = o.getScore(" " + StorageManager.ChickenFightPlayersDied.get(arena) + " ");
				score9.setScore(1);
		
				Score score10 = o.getScore("   ");
				score10.setScore(0);

				Team Players = b.registerNewTeam("PlayersMG");
				Team Spectators = b.registerNewTeam("SpectateMG");
				
				Players.setPrefix("§a");
				Spectators.setPrefix("§c");
				
				Players.setAllowFriendlyFire(true);
				Spectators.setCanSeeFriendlyInvisibles(true);
				
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							if(StorageManager.PlayersInChickenFight.contains(player)){
								Players.addPlayer(player);
							}
						}
					}
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							if(StorageManager.SpectatorsInChickenFight.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								
								if(!StorageManager.SpectatorsInChickenFight.contains(p)){
									p.hidePlayer(player);
								}
								else{
									p.showPlayer(player);
								}
							}
						}
					}
					if(StorageManager.SpectatorsInChickenFight.contains(p)){
						p.showPlayer(player);
					}
				}
				o.setDisplayName("§f§lChicken Fight");
				
				p.setScoreboard(b);
			}
			if(StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.WARMUP) || StorageManager.ChickenFightState.get(arena).equals(ChickenFightState.ENDING)){
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
			}
		}
		else if(StorageManager.PlayersInSurvivalGames.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
			int arena = StorageManager.PlayersArena.get(p);
			if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.LOBBY) || StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.LASTSECONDS)){
				
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§6§lSG");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.SurvivalGamesPlayers.get(arena) >= 2){
					Score score1 = o.getScore("");
					score1.setScore(9);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
			
					Score score3 = o.getScore(" " + StorageManager.SurvivalGamesMinutes.get(arena) + "m " + StorageManager.SurvivalGamesSeconds.get(arena) + "s");
					score3.setScore(7);
				}
				else{
					Score score1 = o.getScore("");
					score1.setScore(8);
			
					i++;
					if(i == 4){
						i = 1;
					}
					if(i == 1){
						Score score2 = o.getScore("§6§l§oWaiting.");
						score2.setScore(7);
					}
					if(i == 2){
						Score score2 = o.getScore("§6§l§oWaiting..");
						score2.setScore(7);
					}
					if(i == 3){
						Score score2 = o.getScore("§6§l§oWaiting...");
						score2.setScore(7);
					}
				}
			
				Score score4 = o.getScore(" ");
				score4.setScore(6);
		
				Score score5 = o.getScore("§a§lPlayers");
				score5.setScore(5);
				
				Score score6 = o.getScore(" " + StorageManager.SurvivalGamesPlayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score11 = o.getScore("§f§lCoins");
				score11.setScore(2);
				
				Score score12 = o.getScore(" " + StorageManager.coins.get(p.getName()) + " ");
				score12.setScore(1);
		
				Score score13 = o.getScore("    ");
				score13.setScore(0);
	
				Team IronVIP = b.registerNewTeam("IronVIPMG");
				IronVIP.setPrefix("§7§lIron §f");
				Team GoldVIP = b.registerNewTeam("GoldVIPMG");
				GoldVIP.setPrefix("§6§lGold §f");
				Team DiamondVIP = b.registerNewTeam("DiamondVIPMG");
				DiamondVIP.setPrefix("§9§lDiamond §f");
				Team EmeraldVIP = b.registerNewTeam("EmeraldVIPMG");
				EmeraldVIP.setPrefix("§a§lEmerald §f");
				Team Builder = b.registerNewTeam("BuilderMG");
				Builder.setPrefix("§d§lBuilder §f");
				Team Moderator = b.registerNewTeam("ModeratorMG");
				Moderator.setPrefix("§b§lMod §f");
				Team Owner = b.registerNewTeam("OwnerMG");
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
				
				o.setDisplayName("§6§lSurvival Games");
				
				p.setScoreboard(b);
			}
			if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.INGAME) || StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();

				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§6§lSG");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
				
				Score score1 = o.getScore("");
				score1.setScore(9);
			
				if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.INGAME)){
					Team d = b.registerNewTeam("Deathmatch");
					d.setSuffix(" in");
					@SuppressWarnings("deprecation")
					OfflinePlayer d1 = Bukkit.getServer().getOfflinePlayer("§d§lDeathmatch");
					d.addPlayer(d1);
					
					Score score2 = o.getScore(d1.getName());
					score2.setScore(8);
				}
				if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
				}
			
				Score score3 = o.getScore(" " + StorageManager.SurvivalGamesMinutes.get(arena) + "m " + StorageManager.SurvivalGamesSeconds.get(arena) + "s");
				score3.setScore(7);
				
			
				Score score4 = o.getScore(" ");
				score4.setScore(6);
		
				Score score5 = o.getScore("§a§lAlive");
				score5.setScore(5);
				
				Score score6 = o.getScore(" " + StorageManager.SurvivalGamesPlayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score8 = o.getScore("§c§lDead");
				score8.setScore(2);
				
				Score score9 = o.getScore(" " + StorageManager.SurvivalGamesPlayersDied.get(arena) + " ");
				score9.setScore(1);
		
				Score score10 = o.getScore("   ");
				score10.setScore(0);

				Team Players = b.registerNewTeam("PlayersMG");
				Team Spectators = b.registerNewTeam("SpectateMG");
				
				Players.setPrefix("§a");
				Spectators.setPrefix("§c");
				
				Players.setAllowFriendlyFire(true);
				Spectators.setCanSeeFriendlyInvisibles(true);
				
				for(Player player : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							if(StorageManager.PlayersInSurvivalGames.contains(player)){
								Players.addPlayer(player);
							}
						}
					}
					if(StorageManager.PlayersGame.containsKey(player)){
						if(StorageManager.PlayersArena.get(player).equals(arena)){
							if(StorageManager.SpectatorsInSurvivalGames.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								
								if(!StorageManager.SpectatorsInSurvivalGames.contains(p)){
									p.hidePlayer(player);
								}
								else{
									p.showPlayer(player);
								}
							}
						}
					}
					if(StorageManager.SpectatorsInSurvivalGames.contains(p)){
						p.showPlayer(player);
					}
				}
				
				o.setDisplayName("§6§lSurvival Games");
				
				p.setScoreboard(b);
			}
			if(StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.WARMUP) || StorageManager.SurvivalGamesState.get(arena).equals(SurvivalGamesState.ENDING)){
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
			}
		}
		else{
			if(!StorageManager.PlayersGame.containsKey(p)){
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§f§lMiniGames");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				Score score4 = o.getScore(" ");
				score4.setScore(9);
		
				Team omt = b.registerNewTeam("OMTMG");
				omt.setSuffix(" Tokens");
				@SuppressWarnings("deprecation")
				OfflinePlayer omt1 = Bukkit.getServer().getOfflinePlayer("§e§lOrbitMines");
				omt.addPlayer(omt1);
				
				Score score5 = o.getScore(omt1.getName());
				score5.setScore(8);
				
				if(StorageManager.omt.get(p.getName()) != null){
					Score score6 = o.getScore(" " + StorageManager.omt.get(p.getName()) + "  ");
					score6.setScore(7);
				}
				else{
					Score score6 = o.getScore(" " + "Loading..." + "  ");
					score6.setScore(7);
				}
		
				Score score7 = o.getScore("  ");
				score7.setScore(6);
				
				Score score8 = o.getScore("§b§lVIP Points");
				score8.setScore(5);
				if(StorageManager.points.get(p.getName()) != null){
					Score score9 = o.getScore(" " + StorageManager.points.get(p.getName()));
					score9.setScore(4);
				}
				else{
					Score score9 = o.getScore(" " + "Loading...");
					score9.setScore(4);
				}
		
				Score score10 = o.getScore("   ");
				score10.setScore(3);
				
				Score score11 = o.getScore("§f§lCoins");
				score11.setScore(2);
				if(StorageManager.coins.get(p.getName()) != null){
					Score score12 = o.getScore(" " + StorageManager.coins.get(p.getName()) + " ");
					score12.setScore(1);
				}
				else{
					Score score12 = o.getScore(" " + "Loading..." + " ");
					score12.setScore(1);
				}
		
				Score score13 = o.getScore("    ");
				score13.setScore(0);
	
				Team IronVIP = b.registerNewTeam("IronVIPMG");
				IronVIP.setPrefix("§7§lIron §f");
				Team GoldVIP = b.registerNewTeam("GoldVIPMG");
				GoldVIP.setPrefix("§6§lGold §f");
				Team DiamondVIP = b.registerNewTeam("DiamondVIPMG");
				DiamondVIP.setPrefix("§9§lDiamond §f");
				Team EmeraldVIP = b.registerNewTeam("EmeraldVIPMG");
				EmeraldVIP.setPrefix("§a§lEmerald §f");
				Team Builder = b.registerNewTeam("BuilderMG");
				Builder.setPrefix("§d§lBuilder §f");
				Team Moderator = b.registerNewTeam("ModeratorMG");
				Moderator.setPrefix("§b§lMod §f");
				Team Owner = b.registerNewTeam("OwnerMG");
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
				
				o.setDisplayName("§6§lOrbitMines§f§lMiniGames");
				
				p.setScoreboard(b);
			}
			else{
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);	
			}
		}
		
	}
}
