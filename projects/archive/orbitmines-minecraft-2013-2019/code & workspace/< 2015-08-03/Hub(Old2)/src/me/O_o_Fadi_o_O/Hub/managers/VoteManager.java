package me.O_o_Fadi_o_O.Hub.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteManager {
	
	public static void giveVoteReward(Player p){
		
		try {
			DatabaseManager.addOMT(p, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConfigManager.playerdata.set("players." + p.getName() + ".Votes", StorageManager.votes.get(p.getName()));
		ConfigManager.savePlayerData();
		
	}
	
	public static void addVoteRewardAfter(String player){
		
		player = player.toLowerCase();
		
		boolean hasVoteWaiting = false;
		
		List<String> list = new ArrayList<String>();
		
		for(String s : StorageManager.VoteRewardsNotGiven){
			list.add(s);
		}
		
		for(String s : list){
			if(s.startsWith(player)){
				list.remove(s);
				hasVoteWaiting = true;
				String[] sList = s.split("\\|");
				int amount = Integer.parseInt(sList[1]) +1;
				
				list.add(player + "|" + amount + "|");
			}
		}
		
		if(hasVoteWaiting == false){
			list.add(player + "|1|");
		}
		
		StorageManager.VoteRewardsNotGiven.clear();
		StorageManager.VoteRewardsNotGiven.addAll(list);	
		
		ConfigManager.playerdata.set("VoteRewardsNotGiven", list);
		ConfigManager.savePlayerData();
	}
	
	public static void checkForVotes(Player p){
		
		List<String> list = new ArrayList<String>();
		
		for(String s : StorageManager.VoteRewardsNotGiven){
			list.add(s);
		}
		
		for(String s : list){
			if(s.startsWith(p.getName().toLowerCase())){
				list.remove(s);
				String[] sList = s.split("\\|");
				int amount = Integer.parseInt(sList[1]);
				
				for(int i = 1; i <= amount; i++){
					
					giveVoteReward(p);
					sendVoteBroadCast(p);
					
				}
				
				StorageManager.VoteRewardsNotGiven.clear();
				StorageManager.VoteRewardsNotGiven.addAll(list);	
				
				ConfigManager.playerdata.set("VoteRewardsNotGiven", list);
				ConfigManager.savePlayerData();
				
			}
		}
	}
	
	public static void registerVote(String player){
		
		try {
			DatabaseManager.addVote(player);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Player voteP = null;
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getName().equalsIgnoreCase(player)){
				voteP = p;
			}
		}
		
		if(voteP == null){
			
			addVoteRewardAfter(player);
			
		}
		else{
			giveVoteReward(voteP);
			sendVoteBroadCast(voteP);
		}
	}
	
	public static void sendVoteBroadCast(Player p){
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player != p){
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §b§l" + p.getName() + "§7 has voted with §b§l/vote");
			}
			else{
				player.sendMessage("");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Thank you, §b§l" + p.getName() + " §7for your §b§lVote§7!");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §3§lHub§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
