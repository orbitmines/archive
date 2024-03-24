package me.O_o_Fadi_o_O.SkyBlock.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.SkyBlock.Start;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VoteManager {
	
	Start start = Start.getInstance();
	
	public static void giveVoteReward(Player p){
		{
			ItemStack item = new ItemStack(Material.COBBLESTONE, 32);
			p.getInventory().addItem(item);
		}
		{
			ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
			p.getInventory().addItem(item);
		}
		{
			ItemStack item = new ItemStack(Material.COAL, 4);
			p.getInventory().addItem(item);
		}
		
		StorageManager.votes.put(Start.getUUIDfromPlayer(p), DatabaseManager.getInt(p.getName(), "Votes", "votes"));
	}
	
	public static void addVoteRewardAfter(String player){
		
		String uuid = Start.getUUIDfromString(player).toString();
		
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
		ConfigManager.savePlayerdata();
	}
	
	public static void checkForVotes(Player p){
		String uuid = Start.getUUIDfromPlayer(p).toString();
		
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
						ConfigManager.savePlayerdata();
						
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
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §5§lSkyBlock§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §8§l32 Cobblestone");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §7§l1 Iron Ingot");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §0§l4 Coal");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(Start.getUUIDfromPlayer(player)));
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
