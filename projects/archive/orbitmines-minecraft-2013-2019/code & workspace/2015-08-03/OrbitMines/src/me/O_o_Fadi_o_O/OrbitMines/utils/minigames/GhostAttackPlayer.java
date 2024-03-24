package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;

import org.bukkit.entity.Player;

public class GhostAttackPlayer {

	private Player player;
	private int kills;
	private int ghostkills;
	private int wins;
	private int ghostwins;
	private int loses;
	private int beststreak;
	private int roundkills;
	private Kit kitselected;
	
	public GhostAttackPlayer(Player player, int kills, int ghostkills, int wins, int ghostwins, int loses, int beststreak){
		this.player = player;
		this.kills = kills;
		this.ghostkills = ghostkills;
		this.wins = wins;
		this.ghostwins = ghostwins;
		this.loses = loses;
		this.beststreak = beststreak;
		this.roundkills = 0;
	}

	public Player getPlayer(){
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}

	public int getKills(){
		return kills;
	}
	public void setKills(int kills){
		this.kills = kills;
		
		Database.get().update("GhostAttack-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}
	public void addKill(){
		this.kills = getKills() +1;
		
		Database.get().update("GhostAttack-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}

	public int getGhostKills(){
		return ghostkills;
	}
	public void setGhostKills(int ghostkills){
		this.ghostkills = ghostkills;
		
		Database.get().update("GhostAttack-GhostKills", "ghostkills", "" + getGhostKills(), "uuid", getUUID().toString());
	}
	public void addGhostKill(){
		this.ghostkills = getGhostKills() +1;
		
		Database.get().update("GhostAttack-GhostKills", "ghostkills", "" + getGhostKills(), "uuid", getUUID().toString());
	}

	public int getWins(){
		return wins;
	}
	public void setWins(int wins){
		this.wins = wins;
		
		Database.get().update("GhostAttack-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}
	public void addWin(){
		this.wins = getWins() +1;
		
		Database.get().update("GhostAttack-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}

	public int getGhostWins(){
		return ghostwins;
	}
	public void setGhostWins(int ghostwins){
		this.ghostwins = ghostwins;
		
		Database.get().update("GhostAttack-GhostWins", "ghostwins", "" + getGhostWins(), "uuid", getUUID().toString());
	}
	public void addGhostWin(){
		this.ghostwins = getGhostWins() +1;
		
		Database.get().update("GhostAttack-GhostWins", "ghostwins", "" + getGhostWins(), "uuid", getUUID().toString());
	}

	public int getLoses(){
		return loses;
	}
	public void setLoses(int loses){
		this.loses = loses;
		
		Database.get().update("GhostAttack-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}
	public void addLose(){
		this.loses = getLoses() +1;
		
		Database.get().update("GhostAttack-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}

	public int getBeststreak(){
		return beststreak;
	}
	public void setBeststreak(int beststreak){
		this.beststreak = beststreak;
		
		Database.get().update("GhostAttack-BestStreak", "beststreak", "" + getBeststreak(), "uuid", getUUID().toString());
	}

	public int getRoundKills(){
		return roundkills;
	}
	public void setRoundKills(int roundkills){
		this.roundkills = roundkills;
	}
	public void addRoundKill(){
		this.roundkills = getRoundKills() +1;
	}

	public Kit getKit() {
		return kitselected;
	}
	public void setKit(Kit kitselected) {
		this.kitselected = kitselected;
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<GhostAttackPlayer> getGAPlayers(){
		return ServerStorage.gaplayers;
	}
	
	public static GhostAttackPlayer getGAPlayer(Player player){
		for(GhostAttackPlayer gaplayer : ServerStorage.gaplayers){
			if(gaplayer.getPlayer() == player){
				return gaplayer;
			}
		}
		return null;
	}
	
	public static GhostAttackPlayer addGAPlayer(Player player, int kills, int ghostkills, int wins, int ghostwins, int loses, int beststreak){
		GhostAttackPlayer gaplayer = new GhostAttackPlayer(player, kills, ghostkills, wins, ghostwins, loses, beststreak);
		ServerStorage.gaplayers.add(gaplayer);
		return gaplayer;
	}
}
