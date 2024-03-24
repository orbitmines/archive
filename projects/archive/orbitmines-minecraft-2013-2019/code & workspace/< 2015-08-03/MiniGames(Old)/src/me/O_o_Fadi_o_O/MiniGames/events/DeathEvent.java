package me.O_o_Fadi_o_O.MiniGames.events;

import java.sql.SQLException;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.kits.SpectatorKit;
import me.O_o_Fadi_o_O.MiniGames.utils.State;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class DeathEvent implements Listener{
	
	Start plugin;
	 
	public DeathEvent(Start instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
	
		final Player died = e.getEntity();
		died.setHealth(20D);
		e.getDrops().clear();
		e.setDeathMessage(null);
		died.setLevel(0);
		died.setExp(0);
		
		if(Start.state == State.INGAME){
			if(died.getKiller() instanceof Player){
				Player killer = died.getKiller();
				
				Manager.PlayersDied = Manager.PlayersDied +1;
				Manager.DeadPlayers.add(died);
				
				Bukkit.broadcastMessage("§7Death §6| §c" + died.getName() + "§7 killed by §c" + killer.getName());
				killer.sendMessage("§7Stats §6| §2§l+ 1 Kill");
				try {
					Start.addMiniGameKills(killer, 1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				killer.playSound(killer.getLocation(), Sound.LAVA_POP, 5, 1);
				
				if(!Manager.RoundKills.containsKey(killer)){
					Manager.RoundKills.put(killer, 0);
				}
				Manager.RoundKills.put(killer, Manager.RoundKills.get(killer) +1);
				
				Manager.Players.remove(died);
				Manager.RoundKills.put(died, 0);
				Manager.PlayersInGame = Manager.PlayersInGame -1;
				
				Manager.Spectators.add(died);
				Manager.SpectatorsInGame = Manager.SpectatorsInGame +1;
				
				died.setAllowFlight(true);
				died.setFlying(true);
			    ((CraftPlayer) died).getHandle().setInvisible(true);
			    Manager.teleportToChickenFightArena(died);
			   
				for(Player p : Bukkit.getOnlinePlayers()){
					if(Manager.Players.contains(p) || Manager.Spectators.contains(p)){
						ScoreboardManager sm = Bukkit.getScoreboardManager();
						Scoreboard b = sm.getNewScoreboard();

						Objective o = b.registerNewObjective("Test", "Test2");
						
						o.setDisplayName("§f§lChickenFight");
						
						o.setDisplaySlot(DisplaySlot.SIDEBAR);
					
						if(Manager.Minutes <= 1){
							Score score1 = o.getScore("");
							score1.setScore(9);
					
							Score score2 = o.getScore("§6§lTime Left");
							score2.setScore(8);
					
							Score score3 = o.getScore(" " + Manager.Minutes + "m " + Manager.Seconds + "s");
							score3.setScore(7);
						}
					
						Score score4 = o.getScore(" ");
						score4.setScore(6);
				
						Score score5 = o.getScore("§a§lAlive");
						score5.setScore(5);
						
						Score score6 = o.getScore(" " + Manager.PlayersInGame);
						score6.setScore(4);
				
						Score score7 = o.getScore("  ");
						score7.setScore(3);
						
						Score score8 = o.getScore("§c§lDead");
						score8.setScore(2);
						
						Score score9 = o.getScore(" " + Manager.PlayersDied + " ");
						score9.setScore(1);
				
						Score score10 = o.getScore("   ");
						score10.setScore(0);

						Team Players = b.registerNewTeam("Players");
						Team Spectators = b.registerNewTeam("Spectate");
						
						Players.setPrefix("§a");
						Spectators.setPrefix("§c");
						
						Players.setAllowFriendlyFire(true);
						Spectators.setCanSeeFriendlyInvisibles(true);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Players.contains(player)){
								Players.addPlayer(player);
							}
							if(Manager.Spectators.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								
								if(!Manager.Spectators.contains(p)){
									p.hidePlayer(player);
								}
								else{
									p.showPlayer(player);
								}
							}
							if(Manager.Spectators.contains(p)){
								p.showPlayer(player);
							}
						}
						p.setScoreboard(b);
					}
					else{
						p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
					}
				}
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						SpectatorKit.giveInventory(died);
						DisguiseAPI.undisguiseToAll(died);
				
					} 
				}, 1L);
			    
				if(Start.state == State.INGAME || Start.state == State.WARMUP){
					if(Manager.PlayersInGame == 1){
						Manager.endChickenFight();
					}
				}
			}	
			else{
				Bukkit.broadcastMessage("§7Death §6| §c" + died.getName());
				
				Manager.PlayersDied = Manager.PlayersDied +1;
				Manager.DeadPlayers.add(died);
				
				Manager.Players.remove(died);
				Manager.RoundKills.put(died, 0);
				Manager.PlayersInGame = Manager.PlayersInGame -1;
				
				Manager.Spectators.add(died);
				Manager.SpectatorsInGame = Manager.SpectatorsInGame +1;
				
				died.setAllowFlight(true);
				died.setFlying(true);
			    ((CraftPlayer) died).getHandle().setInvisible(true);
			    Manager.teleportToChickenFightArena(died);
			    
				for(Player p : Bukkit.getOnlinePlayers()){
					if(Manager.Players.contains(p) || Manager.Spectators.contains(p)){
						ScoreboardManager sm = Bukkit.getScoreboardManager();
						Scoreboard b = sm.getNewScoreboard();

						Objective o = b.registerNewObjective("Test", "Test2");
						
						o.setDisplayName("§f§lChickenFight");
						
						o.setDisplaySlot(DisplaySlot.SIDEBAR);
					
						if(Manager.Minutes <= 1){
							Score score1 = o.getScore("");
							score1.setScore(9);
					
							Score score2 = o.getScore("§6§lTime Left");
							score2.setScore(8);
					
							Score score3 = o.getScore(" " + Manager.Minutes + "m " + Manager.Seconds + "s");
							score3.setScore(7);
						}
					
						Score score4 = o.getScore(" ");
						score4.setScore(6);
				
						Score score5 = o.getScore("§a§lAlive");
						score5.setScore(5);
						
						Score score6 = o.getScore(" " + Manager.PlayersInGame);
						score6.setScore(4);
				
						Score score7 = o.getScore("  ");
						score7.setScore(3);
						
						Score score8 = o.getScore("§c§lDead");
						score8.setScore(2);
						
						Score score9 = o.getScore(" " + Manager.PlayersDied + " ");
						score9.setScore(1);
				
						Score score10 = o.getScore("   ");
						score10.setScore(0);

						Team Players = b.registerNewTeam("Players");
						Team Spectators = b.registerNewTeam("Spectate");
						
						Players.setPrefix("§c");
						Spectators.setPrefix("§a");
						
						Players.setAllowFriendlyFire(true);
						Spectators.setCanSeeFriendlyInvisibles(true);
						
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Players.contains(player)){
								Players.addPlayer(player);
							}
							if(Manager.Spectators.contains(player)){
								Spectators.addPlayer(player);
								((CraftPlayer) player).getHandle().setInvisible(true);
								p.hidePlayer(player);
							}
						}
						
						p.setScoreboard(b);
					}
					else{
						p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
					}
				}
			    
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
					public void run(){
						SpectatorKit.giveInventory(died);
						DisguiseAPI.undisguiseToAll(died);
				
					} 
				}, 1L);
				
				if(Start.state == State.INGAME || Start.state == State.WARMUP){
					if(Manager.PlayersInGame == 1){
						Manager.endChickenFight();
					}
				}
			}
		}
	}
}
