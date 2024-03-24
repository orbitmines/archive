package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteManager {
	
	Start start = Start.getInstance();
	
	public static void giveVoteReward(Player p){
		DatabaseManager.addMiniGameCoins(p, 50);
		
		TitleManager.setTitle(p, "§b§lVote", "§f+50 MiniGame Coins");
		
		ConfigManager.votedata.set("players." + p.getName() + ".Votes", StorageManager.votes.get(p.getName()));
		ConfigManager.saveVoteData();
		
	}
	
	public static void addVoteRewardAfter(String player){
		
		player = player.toLowerCase();
		
		boolean hasVoteWaiting = false;
		
		List<String> list = new ArrayList<String>();
		
		for(String s : StorageManager.pendingvoters){
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
		
		StorageManager.pendingvoters = list;
		
		ConfigManager.votedata.set("VoteRewardsNotGiven", list);
		ConfigManager.saveVoteData();
	}
	
	public static void checkForVotes(Player p){
		try{
			List<String> list = new ArrayList<String>();
			
			for(String s : StorageManager.pendingvoters){
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
					
					StorageManager.pendingvoters = list;
					
					ConfigManager.votedata.set("VoteRewardsNotGiven", list);
					ConfigManager.saveVoteData();
					
				}
			}
		}catch(Exception ex){}
	}
	
	@SuppressWarnings("deprecation")
	public static void registerVote(String player){
		
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
	
	@SuppressWarnings("deprecation")
	public static void sendVoteBroadCast(Player p){
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(player != p){
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §b§l" + p.getName() + "§7 has voted with §b§l/vote");
			}
			else{
				player.sendMessage("");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Thank you, §b§l" + p.getName() + " §7for your §b§lVote§7!");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §f§lMiniGames§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §f§l50 MiniGame Coins");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
