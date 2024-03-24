package me.O_o_Fadi_o_O.OrbitMines.utils.minigames;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMines.utils.Database;
import me.O_o_Fadi_o_O.OrbitMines.utils.Kit;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SurvivalGamesPlayer {

	private Player player;
	private int kills;
	private int wins;
	private int loses;
	private int beststreak;
	private int roundkills;
	private Color leathercolor;
	private Kit kitselected;
	private boolean doubleloot;
	private boolean enablepotions;
	
	public SurvivalGamesPlayer(Player player, int kills, int wins, int loses, int beststreak, Color leathercolor){
		this.player = player;
		this.kills = kills;
		this.wins = wins;
		this.loses = loses;
		this.beststreak = beststreak;
		this.leathercolor = leathercolor;
		this.roundkills = 0;
		this.doubleloot = false;
		this.enablepotions = false;
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
		
		Database.get().update("SurvivalGames-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}
	public void addKill(){
		this.kills = getKills() +1;
		
		Database.get().update("SurvivalGames-Kills", "kills", "" + getKills(), "uuid", getUUID().toString());
	}

	public int getWins(){
		return wins;
	}
	public void setWins(int wins){
		this.wins = wins;
		
		Database.get().update("SurvivalGames-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}
	public void addWin(){
		this.wins = getWins() +1;
		
		Database.get().update("SurvivalGames-Wins", "wins", "" + getWins(), "uuid", getUUID().toString());
	}

	public int getLoses(){
		return loses;
	}
	public void setLoses(int loses){
		this.loses = loses;
		
		Database.get().update("SurvivalGames-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}
	public void addLose(){
		this.loses = getLoses() +1;
		
		Database.get().update("SurvivalGames-Loses", "loses", "" + getLoses(), "uuid", getUUID().toString());
	}

	public int getBeststreak(){
		return beststreak;
	}
	public void setBeststreak(int beststreak){
		this.beststreak = beststreak;
		
		Database.get().update("SurvivalGames-BestStreak", "beststreak", "" + getBeststreak(), "uuid", getUUID().toString());
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

	public Color getLeatherColor() {
		return leathercolor;
	}
	public void setLeatherColor(Color leathercolor) {
		this.leathercolor = leathercolor;
		
		if(Database.get().containsPath("SurvivalGames-Color", "uuid", "uuid", getUUID().toString())){
			Database.get().update("SurvivalGames-Color", "color", "" + Utils.parseString(getLeatherColor()), "uuid", getUUID().toString());
		}
		else{
			Database.get().insert("SurvivalGames-Color", "uuid`, `color", getUUID().toString() + "', '" + Utils.parseString(getLeatherColor()));
		}
	}
	public void updateLeatherColor(){
		if(getLeatherColor() != null){
			for(ItemStack item : getPlayer().getInventory().getContents()){
				if(item != null && (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.LEATHER_HELMET)){
					LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
					meta.setColor(getLeatherColor());
					item.setItemMeta(meta);
				}
			}
		}
	}

	public boolean isDoubleLoot() {
		return doubleloot;
	}
	public void setDoubleLoot(boolean doubleloot) {
		this.doubleloot = doubleloot;
	}

	public boolean isEnablePotions() {
		return enablepotions;
	}
	public void setEnablePotions(boolean enablepotions) {
		this.enablepotions = enablepotions;
	}
	
	private UUID getUUID(){
		return getPlayer().getUniqueId();
	}
	
	public static List<SurvivalGamesPlayer> getSGPlayers(){
		return ServerStorage.sgplayers;
	}
	
	public static SurvivalGamesPlayer getSGPlayer(Player player){
		for(SurvivalGamesPlayer sgplayer : ServerStorage.sgplayers){
			if(sgplayer.getPlayer() == player){
				return sgplayer;
			}
		}
		return null;
	}
	
	public static SurvivalGamesPlayer addSGPlayer(Player player, int kills, int wins, int loses, int beststreak, Color leathercolor){
		SurvivalGamesPlayer sgplayer = new SurvivalGamesPlayer(player, kills, wins, loses, beststreak, leathercolor);
		ServerStorage.sgplayers.add(sgplayer);
		return sgplayer;
	}
}
