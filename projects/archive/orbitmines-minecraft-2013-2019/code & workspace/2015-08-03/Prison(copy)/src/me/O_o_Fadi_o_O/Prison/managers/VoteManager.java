package me.O_o_Fadi_o_O.Prison.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.utils.Rank;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteManager {
	
	Start start = Start.getInstance();
	
	public static int getMoneyByVote(Player p){
		int amount = 0;
		Rank rank = StorageManager.playerrank.get(p);
		switch(rank){
		case UPlus:
			amount = 125000;
			break;
		case VPlus:
			amount = 110000;
			break;
		case WPlus:
			amount = 95000;
			break;
		case XPlus:
			amount = 80000;
			break;
		case YPlus:
			amount = 65000;
			break;
		case ZPlus:
			amount = 50000;
			break;
		case A:
			amount = 40000;
			break;
		case B:
			amount = 30000;
			break;
		case C:
			amount = 25000;
			break;
		case D:
			amount = 20000;
			break;
		case E:
			amount = 17500;
			break;
		case F:
			amount = 15000;
			break;
		case G:
			amount = 12000;
			break;
		case H:
			amount = 8500;
			break;
		case I:
			amount = 6500;
			break;
		case J:
			amount = 5000;
			break;
		case K:
			amount = 4000;
			break;
		case L:
			amount = 3000;
			break;
		case M:
			amount = 2500;
			break;
		case N:
			amount = 2250;
			break;
		case O:
			amount = 2000;
			break;
		case P:
			amount = 1750;
			break;
		case Q:
			amount = 1500;
			break;
		case R:
			amount = 1400;
			break;
		case S:
			amount = 1150;
			break;
		case T:
			amount = 900;
			break;
		case U:
			amount = 700;
			break;
		case V:
			amount = 500;
			break;
		case W:
			amount = 350;
			break;
		case X:
			amount = 250;
			break;
		case Y:
			amount = 150;
			break;
		case Z:
			amount = 100;
			break;
		default:
			break;
		}
		
		return amount;
	}
	
	public static void giveVoteReward(Player p){
		int amount = getMoneyByVote(p);
		
		PlayerManager.giveMoney(p, amount);
		
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
		
		ConfigManager.votedata.set("VoteRewardsNotGiven", list);
		ConfigManager.savePlayerData();
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
						
						ConfigManager.votedata.set("VoteRewardsNotGiven", list);
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
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your reward in the §4§lPrison§7 Server:");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §6§l" + getMoneyByVote(player) + " Gold §7(§a§l" + PlayerManager.getRankString(p) + "§7)");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				player.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(Start.getUUIDfromPlayer(player)));
				player.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
			}
		}
	}
}
