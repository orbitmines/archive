package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Hologram;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.MiniGamesUtils.TicketType;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ChickenFightPlayer {

	private Player player;
	private int kills;
	private int wins;
	private int loses;
	private int beststreak;
	private int roundkills;
	private int secondssurvived;
	private Kit kitselected;
	private Hologram namehologram;
	
	public ChickenFightPlayer(Player player, int kills, int wins, int loses, int beststreak){
		this.player = player;
		this.kills = kills;
		this.wins = wins;
		this.loses = loses;
		this.beststreak = beststreak;
		
		this.roundkills = 0;
		this.secondssurvived = 0;
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
		
		Database.get().update("ChickenFight-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}
	public void addKill(){
		this.kills = getKills() +1;
		
		Database.get().update("ChickenFight-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}

	public int getWins(){
		return wins;
	}
	public void setWins(int wins){
		this.wins = wins;
		
		Database.get().update("ChickenFight-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}
	public void addWin(){
		this.wins = getWins() +1;
		
		Database.get().update("ChickenFight-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}

	public int getLoses(){
		return loses;
	}
	public void setLoses(int loses){
		this.loses = loses;
		
		Database.get().update("ChickenFight-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}
	public void addLose(){
		this.loses = getLoses() +1;
		
		Database.get().update("ChickenFight-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}

	public int getBeststreak(){
		return beststreak;
	}
	public void setBeststreak(int beststreak){
		this.beststreak = beststreak;
		
		Database.get().update("ChickenFight-BestStreak", "beststreak", "" + getBeststreak(), "uuid", getUUID().toString());
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

	public int getSecondsSurvived(){
		return secondssurvived;
	}
	public void setSecondsSurvived(int secondssurvived){
		this.secondssurvived = secondssurvived;
	}

	public Kit getKit() {
		return kitselected;
	}
	public void setKit(Kit kitselected) {
		this.kitselected = kitselected;
	}
	
	public Vector getVelocity(Vector v){
		return v.multiply(getKnockbackMotifier());
	}
	
	public double getKnockbackMotifier(){
		if(getKit() != null){
			if(getKit().getKitName().equals(TicketType.CHICKEN_MAMA_KIT.toString())){
				return 1.2;
			}
			else if(getKit().getKitName().equals(TicketType.BABY_CHICKEN_KIT.toString())){
				return 1.5;
			}
			else if(getKit().getKitName().equals(TicketType.HOT_WING_KIT.toString())){
				return 1.3;
			}
			else if(getKit().getKitName().equals(TicketType.CHICKEN_WARLORD_KIT.toString())){
				return 0.9;
			}
			else if(getKit().getKitName().equals(TicketType.CHICKEN_KIT.toString())){
				return 0.95;
			}
			else{}
		}
		return 1;
	}

	public Hologram getNameHologram() {
		return namehologram;
	}
	public void setNameHologram(Hologram namehologram) {
		this.namehologram = namehologram;
	}
	public void updateHologram(){
		OMPlayer omp = OMPlayer.getOMPlayer(getPlayer());
		Arena arena = omp.getArena();
		
		if(arena != null){
			Location l = getPlayer().getLocation();
			if(getKit().getKitName().equals(TicketType.CHICKEN_MAMA_KIT.toString()) || getKit().getKitName().equals(TicketType.HOT_WING_KIT.toString())){
				l = new Location(l.getWorld(), l.getX(), l.getY() -1.25, l.getZ());
			}
			else if(getKit().getKitName().equals(TicketType.BABY_CHICKEN_KIT.toString())){
				l = new Location(l.getWorld(), l.getX(), l.getY() -1.5, l.getZ());
			}
			else if(getKit().getKitName().equals(TicketType.CHICKEN_WARLORD_KIT.toString())){
				l = new Location(l.getWorld(), l.getX(), l.getY() +0.5, l.getZ());
			}
			else if(getKit().getKitName().equals(TicketType.CHICKEN_KIT.toString())){
				l = new Location(l.getWorld(), l.getX(), l.getY() -0.75, l.getZ());
			}
			else{}
			
			if(getNameHologram() != null){
				if(arena.isSpectator(omp)){
					getNameHologram().delete();
					setNameHologram(null);
				}
				else{
					getNameHologram().setLocation(getPlayer().getLocation());
					for(ArmorStand as : getNameHologram().getArmorstands()){
						as.teleport(l);
					}
				}
			}
			else{
				if(!arena.isSpectator(omp)){
					Hologram h = Hologram.addHologram(l);
					h.addLine("§a" + getPlayer().getName());
					h.createHideFor(getPlayer());
					
					setNameHologram(h);
				}
			}
		}
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<ChickenFightPlayer> getCFPlayers(){
		return ServerStorage.cfplayers;
	}
	
	public static ChickenFightPlayer getCFPlayer(Player player){
		for(ChickenFightPlayer cfplayer : ServerStorage.cfplayers){
			if(cfplayer.getPlayer() == player){
				return cfplayer;
			}
		}
		return null;
	}
	
	public static ChickenFightPlayer addCFPlayer(Player player, int kills, int wins, int loses, int beststreak){
		ChickenFightPlayer cfplayer = new ChickenFightPlayer(player, kills, wins, loses, beststreak);
		ServerStorage.cfplayers.add(cfplayer);
		return cfplayer;
	}
}
