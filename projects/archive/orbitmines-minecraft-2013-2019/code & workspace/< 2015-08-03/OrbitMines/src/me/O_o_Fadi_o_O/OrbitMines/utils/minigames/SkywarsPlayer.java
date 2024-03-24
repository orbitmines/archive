package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SkywarsPlayer {

	private Player player;
	private int kills;
	private int wins;
	private int loses;
	private int beststreak;
	private int roundkills;
	private Kit kitselected;
	private TicketType cage;
	private List<Block> cageblocks;
	private OMPlayer lastprojectile;
	
	public SkywarsPlayer(Player player, int kills, int wins, int loses, int beststreak, TicketType cage){
		this.player = player;
		this.kills = kills;
		this.wins = wins;
		this.loses = loses;
		this.beststreak = beststreak;
		this.roundkills = 0;
		this.cage = cage;
		this.cageblocks = new ArrayList<Block>();
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
		
		Database.get().update("Skywars-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}
	public void addKill(){
		this.kills = getKills() +1;
		
		Database.get().update("Skywars-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}

	public int getWins(){
		return wins;
	}
	public void setWins(int wins){
		this.wins = wins;
		
		Database.get().update("Skywars-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}
	public void addWin(){
		this.wins = getWins() +1;
		
		Database.get().update("Skywars-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}

	public int getLoses(){
		return loses;
	}
	public void setLoses(int loses){
		this.loses = loses;
		
		Database.get().update("Skywars-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}
	public void addLose(){
		this.loses = getLoses() +1;
		
		Database.get().update("Skywars-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}

	public int getBeststreak(){
		return beststreak;
	}
	public void setBeststreak(int beststreak){
		this.beststreak = beststreak;
		
		Database.get().update("Skywars-BestStreak", "beststreak", "" + getBeststreak(), "uuid", getUUID().toString());
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

	public TicketType getCage() {
		return cage;
	}
	public void setCage(TicketType cage) {
		this.cage = cage;
		
		if(Database.get().containsPath("Skywars-Cage", "uuid", "uuid", getUUID().toString())){
			Database.get().update("Skywars-Cage", "cage", "" + getCage().toString(), "uuid", getUUID().toString());
		}
		else{
			Database.get().insert("Skywars-Cage", "uuid`, `cage", getUUID().toString() + "', '" + getCage().toString());
		}
	}

	public List<Block> getCageBlocks() {
		return cageblocks;
	}
	public void setCageBlocks(List<Block> cageblocks) {
		this.cageblocks = cageblocks;
	}

	public OMPlayer getLastProjectile() {
		return lastprojectile;
	}
	public void setLastProjectile(OMPlayer lastprojectile) {
		this.lastprojectile = lastprojectile;
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<SkywarsPlayer> getSWPlayers(){
		return ServerStorage.swplayers;
	}
	
	public static SkywarsPlayer getSWPlayer(Player player){
		for(SkywarsPlayer swplayer : ServerStorage.swplayers){
			if(swplayer.getPlayer() == player){
				return swplayer;
			}
		}
		return null;
	}
	
	public static SkywarsPlayer addSWPlayer(Player player, int kills, int wins, int loses, int beststreak, TicketType cage){
		SkywarsPlayer swplayer = new SkywarsPlayer(player, kills, wins, loses, beststreak, cage);
		ServerStorage.swplayers.add(swplayer);
		return swplayer;
	}
}
