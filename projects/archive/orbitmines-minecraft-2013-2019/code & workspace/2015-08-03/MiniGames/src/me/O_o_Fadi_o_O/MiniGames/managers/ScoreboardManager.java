package me.O_o_Fadi_o_O.MiniGames.managers;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.StaffRank;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import me.O_o_Fadi_o_O.MiniGames.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
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
		int i = PlayerRunnable.i;
		
		if(StorageManager.playersinchickenfight.contains(p) || StorageManager.spectatorsinchickenfight.contains(p)){
			int arena = StorageManager.playersarena.get(p);
			if(StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.LOBBY) || StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.LASTSECONDS)){
				
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("MiniGames", "MiniGames2");
				
				o.setDisplayName("§f§lChickenFight");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.chickenfightplayers.get(arena) >= 2){
					Score score1 = o.getScore("");
					score1.setScore(12);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(11);
			
					Score score3 = o.getScore(" " + StorageManager.chickenfightminutes.get(arena) + "m " + StorageManager.chickenfightseconds.get(arena) + "s");
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
				
				Score score6 = o.getScore(" " + StorageManager.chickenfightplayers.get(arena));
				score6.setScore(7);
		
				Score score7 = o.getScore("  ");
				score7.setScore(6);
				
				Score score8 = o.getScore("§e§lKit");
				score8.setScore(5);
				
				Score score9 = o.getScore(" " + StorageManager.chickenfightkit.get(p));
				score9.setScore(4);
		
				Score score10 = o.getScore("   ");
				score10.setScore(3);
				
				Score score11 = o.getScore("§f§lCoins");
				score11.setScore(2);
				
				Score score12 = o.getScore(" " + StorageManager.minigamecoins.get(p) + " ");
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
				
				o.setDisplayName("§f§lChicken Fight");
				
				p.setScoreboard(b);
			}
			if(StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.INGAME)){
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();

				Objective o = b.registerNewObjective("Test", "Test2");
				
				o.setDisplayName("§f§lChickenFight");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.chickenfightminutes.get(arena) <= 1){
					Score score1 = o.getScore("");
					score1.setScore(9);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
			
					Score score3 = o.getScore(" " + StorageManager.chickenfightminutes.get(arena) + "m " + StorageManager.chickenfightseconds.get(arena) + "s");
					score3.setScore(7);
				}
			
				Score score4 = o.getScore(" ");
				score4.setScore(6);
		
				Score score5 = o.getScore("§a§lAlive");
				score5.setScore(5);
				
				Score score6 = o.getScore(" " + StorageManager.chickenfightplayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score8 = o.getScore("§c§lDead");
				score8.setScore(2);
				
				Score score9 = o.getScore(" " + StorageManager.chickenfightplayersdied.get(arena) + " ");
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
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.playersinchickenfight.contains(player)){
								Players.addPlayer(player);
							}
						}
					}
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.spectatorsinchickenfight.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								
								if(!StorageManager.spectatorsinchickenfight.contains(p)){
									p.hidePlayer(player);
								}
								else{
									p.showPlayer(player);
								}
							}
						}
					}
					if(StorageManager.spectatorsinchickenfight.contains(p)){
						p.showPlayer(player);
					}
				}
				o.setDisplayName("§f§lChickenFight");
				
				p.setScoreboard(b);
			}
			if(StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.WARMUP) || StorageManager.chickenfightstate.get(arena).equals(ChickenFightState.ENDING)){
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
			}
		}
		else if(StorageManager.playersinsurvivalgames.contains(p) || StorageManager.spectatorsinsurvivalgames.contains(p)){
			int arena = StorageManager.playersarena.get(p);
			if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.LOBBY) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.LASTSECONDS)){
				
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("MiniGames", "MiniGames2");
				
				o.setDisplayName("§6§lSG");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				if(StorageManager.survivalgamesplayers.get(arena) >= 2){
					Score score1 = o.getScore("");
					score1.setScore(9);
			
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
			
					Score score3 = o.getScore(" " + StorageManager.survivalgamesminutes.get(arena) + "m " + StorageManager.survivalgamesseconds.get(arena) + "s");
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
				
				Score score6 = o.getScore(" " + StorageManager.survivalgamesplayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score11 = o.getScore("§f§lCoins");
				score11.setScore(2);
				
				Score score12 = o.getScore(" " + StorageManager.minigamecoins.get(p) + " ");
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
				
				o.setDisplayName("§6§lSurvival Games");
				
				p.setScoreboard(b);
			}
			if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.INGAME) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();

				Objective o = b.registerNewObjective("MiniGames", "MiniGames2");
				
				o.setDisplayName("§6§lSG");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
				
				Score score1 = o.getScore("");
				score1.setScore(9);
			
				if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.INGAME)){
					Team d = b.registerNewTeam("Deathmatch");
					d.setSuffix(" in");
					OfflinePlayer d1 = Bukkit.getServer().getOfflinePlayer("§d§lDeathmatch");
					d.addPlayer(d1);
					
					Score score2 = o.getScore(d1.getName());
					score2.setScore(8);
				}
				if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.DEATHMATCH)){
					Score score2 = o.getScore("§6§lTime Left");
					score2.setScore(8);
				}
			
				Score score3 = o.getScore(" " + StorageManager.survivalgamesminutes.get(arena) + "m " + StorageManager.survivalgamesseconds.get(arena) + "s");
				score3.setScore(7);
				
			
				Score score4 = o.getScore(" ");
				score4.setScore(6);
		
				Score score5 = o.getScore("§a§lAlive");
				score5.setScore(5);
				
				Score score6 = o.getScore(" " + StorageManager.survivalgamesplayers.get(arena));
				score6.setScore(4);
		
				Score score7 = o.getScore("  ");
				score7.setScore(3);
				
				Score score8 = o.getScore("§c§lDead");
				score8.setScore(2);
				
				Score score9 = o.getScore(" " + StorageManager.survivalgamesplayersdied.get(arena) + " ");
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
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.playersinsurvivalgames.contains(player)){
								Players.addPlayer(player);
							}
						}
					}
					if(StorageManager.playersgame.containsKey(player)){
						if(StorageManager.playersarena.get(player).equals(arena)){
							if(StorageManager.spectatorsinsurvivalgames.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								
								if(!StorageManager.spectatorsinsurvivalgames.contains(p)){
									p.hidePlayer(player);
								}
								else{
									p.showPlayer(player);
								}
							}
						}
					}
					if(StorageManager.spectatorsinsurvivalgames.contains(p)){
						p.showPlayer(player);
					}
				}
				
				o.setDisplayName("§6§lSurvivalGames");
				
				p.setScoreboard(b);
			}
			if(StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.WARMUP) || StorageManager.survivalgamesstate.get(arena).equals(SurvivalGamesState.ENDING)){
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
			}
		}
		else{
			if(!StorageManager.playersgame.containsKey(p)){
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard b = sm.getNewScoreboard();
	
				Objective o = b.registerNewObjective("MiniGames", "MiniGames2");
				
				o.setDisplayName("§f§lMiniGames");
				
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				Score score4 = o.getScore(" ");
				score4.setScore(9);
		
				Team omt = b.registerNewTeam("OMTMG");
				omt.setSuffix(" Tokens");
				OfflinePlayer omt1 = Bukkit.getServer().getOfflinePlayer("§e§lOrbitMines");
				omt.addPlayer(omt1);
				
				Score score5 = o.getScore(omt1.getName());
				score5.setScore(8);
				
				if(StorageManager.orbitminestokens.get(p) != null){
					Score score6 = o.getScore(" " + StorageManager.orbitminestokens.get(p) + "  ");
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
				if(StorageManager.vippoints.get(p) != null){
					Score score9 = o.getScore(" " + StorageManager.vippoints.get(p));
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
				if(StorageManager.minigamecoins.get(p) != null){
					Score score12 = o.getScore(" " + StorageManager.minigamecoins.get(p) + " ");
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
			else{
				p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);	
			}
		}
	}
}
