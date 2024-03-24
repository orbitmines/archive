package me.O_o_Fadi_o_O.MiniGames.managers;

import me.O_o_Fadi_o_O.MiniGames.Start;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class ScoreboardTitleManager {

	Start start = Start.getInstance();
	
	private int i = 0;
	public static String title = "";
	
	private void setScoreboardTitle(Player p){
		if(!StorageManager.playersgame.containsKey(p)){
			if(p.getScoreboard() != null && p.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null){
				p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(title);
			}
		}
	}
	
	private void setNextScoreboardTitle(){
		i++;
		
		if(i == 1){title = "§6§lOrbitMines§f§lMiniGames";}
		if(i == 7){title = "§e§lO§6§lrbitMines§f§lMiniGames";}
		if(i == 8){title = "§e§lOr§6§lbitMines§f§lMiniGames";}
		if(i == 9){title = "§e§lOrb§6§litMines§f§lMiniGames";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§f§lMiniGames";}
		if(i == 11){title = "§e§lOrbit§6§lMines§f§lMiniGames";}
		if(i == 12){title = "§e§lOrbitM§6§lines§f§lMiniGames";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§f§lMiniGames";}
		if(i == 14){title = "§e§lOrbitMin§6§les§f§lMiniGames";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§f§lMiniGames";}
		if(i == 16){title = "§e§lOrbitMines§f§lMiniGames";}
		if(i == 17){title = "§e§lOrbitMines§7§lM§f§liniGames";}
		if(i == 18){title = "§e§lOrbitMines§7§lMi§f§lniGames";}
		if(i == 19){title = "§e§lOrbitMines§7§lMin§f§liGames";}
		if(i == 20){title = "§e§lOrbitMines§7§lMini§f§lGames";}
		if(i == 21){title = "§e§lOrbitMines§7§lMiniG§f§lames";}
		if(i == 22){title = "§e§lOrbitMines§7§lMiniGa§f§lmes";}
		if(i == 23){title = "§e§lOrbitMines§7§lMiniGam§f§les";}
		if(i == 24){title = "§e§lOrbitMines§7§lMiniGame§f§ls";}
		if(i == 25){title = "§e§lOrbitMines§7§lMiniGames";}
		if(i == 31){title = "§6§lO§e§lrbitMines§7§lMiniGames";}
		if(i == 32){title = "§6§lOr§e§lbitMines§7§lMiniGames";}
		if(i == 33){title = "§6§lOrb§e§litMines§7§lMiniGames";}
		if(i == 34){title = "§6§lOrbi§e§ltMines§7§lMiniGames";}
		if(i == 35){title = "§6§lOrbit§e§lMines§7§lMiniGames";}
		if(i == 36){title = "§6§lOrbitM§e§lines§7§lMiniGames";}
		if(i == 37){title = "§6§lOrbitMi§e§lnes§7§lMiniGames";}
		if(i == 38){title = "§6§lOrbitMin§e§les§7§lMiniGames";}
		if(i == 39){title = "§6§lOrbitMine§e§ls§7§lMiniGames";}
		if(i == 40){title = "§6§lOrbitMines§7§lMiniGames";}
		if(i == 41){title = "§6§lOrbitMines§f§lM§7§liniGames";}
		if(i == 42){title = "§6§lOrbitMines§f§lMi§7§lniGames";}
		if(i == 43){title = "§6§lOrbitMines§f§lMin§7§liGames";}
		if(i == 44){title = "§6§lOrbitMines§f§lMini§7§lGames";}
		if(i == 45){title = "§6§lOrbitMines§f§lMiniG§7§lames";}
		if(i == 46){title = "§6§lOrbitMines§f§lMiniGa§7§lmes";}
		if(i == 47){title = "§6§lOrbitMines§f§lMiniGam§7§les";}
		if(i == 48){title = "§6§lOrbitMines§f§lMiniGame§7§ls";}
		if(i == 49){title = "§6§lOrbitMines§f§lMiniGames"; i = 0;}
	}
	
	public void startScoreboardTitleRunnable(){
		
		new BukkitRunnable(){
			@SuppressWarnings("deprecation")
			public void run(){
				
				setNextScoreboardTitle();
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.loaded.get(p) == true){
						setScoreboardTitle(p);
					}
				}
			}
		}.runTaskTimer(this.start, 0, 5);
	}
}
