package me.O_o_Fadi_o_O.Prison.runnables;

import java.util.List;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.O_o_Fadi_o_O.Prison.utils.SignType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SignRunnable {

	Start start = Start.getInstance();
	
	public static String[] getSignMessage(Player p, Rank rank, SignType sType){
		
		String[] list = new String[4];
		if(sType == SignType.MINE_SIGN){
			list[0] = "";
			list[1] = "§lMine §a§l" + rank.toString().replaceAll("Plus", "+");
			list[2] = "";
			list[3] = "§lYour Stats:";
		}
		if(sType == SignType.GOLD_SIGN){
			list[0] = "";
			list[1] = "§lYour Gold";
			list[2] = "§6§l" + StorageManager.money.get(p);
			list[3] = "";
		}
		if(sType == SignType.RANK_SIGN){
			list[0] = "";
			list[1] = "§lYour Rank";
			list[2] = "§a§l" + PlayerManager.getRankString(p);
			list[3] = "";
		}
		if(sType == SignType.RANKUP_SIGN){
			list[0] = "";
			list[1] = "§lRankup Price";
			if(StorageManager.playerrank.get(p) != Rank.UPlus){list[2] = "§6§l" + PlayerManager.getRankupPrice(p); list[3] = "§o(Price to " + PlayerManager.getRankupRank(p).toString().replace("Plus", "+") + ")";
			}else{list[2] = "§4Highest Rank"; list[3] = "";}
		}
		if(sType == SignType.CLOCK_SIGN){
			list[0] = "";
			list[1] = "§lReset Timer";
			
			int Minutes = StorageManager.rankmineminutes.get(rank);
			int Seconds = StorageManager.rankmineseconds.get(rank);
			
			String mString = "";
			String sString = "";
			
			if(Minutes <= 9){
				mString = "0" + Minutes + "m";
			}
			else{
				mString = Minutes + "m";
			}
			
			if(Seconds <= 9){
				sString = "0" + Seconds + "s";
			}
			else{
				sString = Seconds + "s";
			}
			
			list[2] = "§o" + mString + " " + sString;
			list[3] = "";
		}
		if(sType == SignType.TOGGLECLOCK_SIGN){
			boolean bl = StorageManager.playerclockenabled.get(p);
			if(bl == true){
				list[0] = "Lagg Problems?";
			}
			else{
				list[0] = "";
			}
			list[1] = "§lToggle Clock";
			list[2] = "";
			if(bl == true){
				list[3] = "§lClock §a§lON";
			}
			else{
				list[3] = "§lClock §c§lOFF";
			}
		}
		
		return list;
	}
	
	public void startSignRunnable(){
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(Rank rank : Rank.values()){
					try{//TODO REMOVE
					for(Player p : Bukkit.getOnlinePlayers()){
						if(StorageManager.loaded.get(p) == true){
							List<Location> locList = StorageManager.ranksigns.get(rank);
							Location l = p.getLocation();
							if(p.getWorld() == locList.get(0).getWorld()){
								if(l.distance(locList.get(0)) <= 16){p.sendSignChange(locList.get(0), getSignMessage(p, rank, SignType.MINE_SIGN));}
								if(l.distance(locList.get(1)) <= 16){p.sendSignChange(locList.get(1), getSignMessage(p, rank, SignType.GOLD_SIGN));}
								if(l.distance(locList.get(2)) <= 16){p.sendSignChange(locList.get(2), getSignMessage(p, rank, SignType.RANK_SIGN));}
								if(l.distance(locList.get(3)) <= 16){p.sendSignChange(locList.get(3), getSignMessage(p, rank, SignType.RANKUP_SIGN));}
								if(l.distance(locList.get(4)) <= 16){p.sendSignChange(locList.get(4), getSignMessage(p, rank, SignType.CLOCK_SIGN));}
								if(l.distance(locList.get(5)) <= 16){p.sendSignChange(locList.get(5), getSignMessage(p, rank, SignType.TOGGLECLOCK_SIGN));}
							}
						}
					}
					}catch(Exception ex){}
				}
			}
		}.runTaskTimer(this.start, 20, 5);
		
	}
}
