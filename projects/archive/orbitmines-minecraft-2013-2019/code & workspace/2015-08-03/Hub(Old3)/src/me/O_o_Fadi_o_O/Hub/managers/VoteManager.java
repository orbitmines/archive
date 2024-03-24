package me.O_o_Fadi_o_O.Hub.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteManager {
	
	Hub hub = Hub.getInstance();
	
	public static void giveVoteReward(Player p){
		DatabaseManager.addOMT(p, 1);
		
		UUID uuid = Hub.getUUIDfromPlayer(p);
		
		TitleManager.setTitle(p, "§b§lVote", "§e+1 OrbitMines Token");
		
		ConfigManager.playerdata.set("players." + uuid.toString() + ".Votes", StorageManager.votes.get(uuid));
		ConfigManager.savePlayerData();
		
	}
	
	public static void addVoteRewardAfter(String player){
		
		String uuid = Hub.getUUIDfromString(player).toString();
		
		boolean hasVoteWaiting = false;
		
		List<String> list = new ArrayList<String>();
		
		for(String s : StorageManager.pendingvoters){
			list.add(s);
		}
		
		if(list.size() != 0){
			for(String s : list){
				if(s.startsWith(uuid)){
					list.remove(s);
					hasVoteWaiting = true;
					String[] sList = s.split("\\|");
					int amount = Integer.parseInt(sList[1]) +1;
					
					list.add(uuid + "|" + amount + "|");
				}
			}
		}
		
		if(hasVoteWaiting == false){
			list.add(uuid + "|1|");
		}
		
		StorageManager.pendingvoters.clear();
		StorageManager.pendingvoters.addAll(list);
		
		ConfigManager.playerdata.set("VoteRewardsNotGiven", list);
		ConfigManager.savePlayerData();
	}
	
	public static void checkForVotes(Player p){
		String uuid = Hub.getUUIDfromPlayer(p).toString();
		
		List<String> list = new ArrayList<String>();
		
		for(String s : StorageManager.pendingvoters){
			list.add(s);
		}
		
		if(list.size() != 0){
			try{
				for(String s : list){
					if(s.startsWith(uuid)){
						list.remove(s);
						String[] sList = s.split("\\|");
						int amount = Integer.parseInt(sList[1]);
						
						for(int i = 1; i <= amount; i++){
							
							giveVoteReward(p);
							sendVoteBroadCast(p);
							
						}
						
						StorageManager.pendingvoters = list;
						
						ConfigManager.playerdata.set("VoteRewardsNotGiven", list);
						ConfigManager.savePlayerData();
						
					}
				}
			}catch(Exception ex){}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void registerVote(String player){
		DatabaseManager.addVote(player);
		
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
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §3§lHub§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(Hub.getUUIDfromPlayer(player)));
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
