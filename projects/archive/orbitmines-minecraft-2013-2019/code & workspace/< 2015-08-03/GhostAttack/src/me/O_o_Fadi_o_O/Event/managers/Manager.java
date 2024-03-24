package me.O_o_Fadi_o_O.Event.managers;

import java.util.ArrayList;

import me.O_o_Fadi_o_O.Event.Start;
import me.O_o_Fadi_o_O.Event.utils.GameState;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Manager {
	
	public static ArrayList<Player> Players = new ArrayList<Player>();
	public static ArrayList<Player> Spectators = new ArrayList<Player>();
	public static ArrayList<Player> Ghosts = new ArrayList<Player>();
	public static ArrayList<Player> DeadPlayers = new ArrayList<Player>();
	
	
	public static int Seconds = 0;
	public static int Minutes = 45;
	
	public static Player Winner = null;
	
	public static void clearInventory(Player p){
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		p.getInventory().clear();
	}
	
	public static void joinGame(Player p){
		clearInventory(p);
		
		if(Start.state == GameState.LOBBY || Start.state == GameState.WARMUP){
			if(!p.getName().equals("O_o_Fadi_o_O") && !p.getName().equals("eekhoorn2000") && !p.getName().equals("sharewoods") && !p.getName().equals("jim5491158")){
				Players.add(p);
			}
			else{
				Ghosts.add(p);
			}
		}
		else{
			setSpectator(p);
		}
	}
	
	public static void leaveGame(Player p){
		
		if(Players.contains(p)){
			Players.remove(p);
		}
		if(Ghosts.contains(p)){
			Ghosts.remove(p);
		}
		if(Spectators.contains(p)){
			Spectators.remove(p);
		}
		if(DeadPlayers.contains(p)){
			DeadPlayers.remove(p);
		}
	}
	
	public static void startGame(){
		Start.state = GameState.INGAME;
		Seconds = 1;
		Minutes = 45;
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage(" §7- §bPlayers: §cKill§7 the §8Ghosts");
		Bukkit.broadcastMessage(" §7- §bPlayers: §7Ghosts are §fInvisible§7.");
		Bukkit.broadcastMessage(" §7- §bPlayers: §7You can see the §8Ghost §7particles sometimes.");
		Bukkit.broadcastMessage(" §7- §bPlayers: §7Will §arevive§7 when there are §a2 Players§7 (Once)");
		Bukkit.broadcastMessage(" §7- §8Ghosts: §cKill§7 the §bPlayers");
		Bukkit.broadcastMessage("");
		for(Player p : Bukkit.getOnlinePlayers()){
			clearInventory(p);
			p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5, 1);
		}
	}
	
	public static void endGame(Player p){
		Winner = p;
		Start.state = GameState.ENDING;
		
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage(" §7- Winner: §a§l" + p.getName());
		Bukkit.broadcastMessage("");
		for(Player player : Bukkit.getOnlinePlayers()){
			clearInventory(player);
			player.playSound(player.getLocation(), Sound.WITHER_DEATH, 5, 1);
		}
	}
	
	public static void setSpectator(Player p){
		if(Players.contains(p)){
			Players.remove(p);
		}
		if(Ghosts.contains(p)){
			Ghosts.remove(p);
		}
		if(Spectators.contains(p)){
			Spectators.remove(p);
		}
		if(DeadPlayers.contains(p)){
			DeadPlayers.remove(p);
		}
		
		Spectators.add(p);
	}
	
	public static String getBroadcastMessage(){
		
		String s = null;		
		if(Start.state == GameState.ENDING){
			//TODO: BACK TO HUB
		}
		else if(Start.state == GameState.LOBBY){
			s = "§3§lEvent §8| §7Starting in §3" + Seconds + "§7...";
		}
		else if(Start.state == GameState.INGAME){
			//TODO: INGAME
		}
		else if(Start.state == GameState.WARMUP){
			s = "§3§lEvent §8| §7Starting in §3" + Seconds + "§7...";
		}
		else{
			
		}
		
		return s;
	}
}
