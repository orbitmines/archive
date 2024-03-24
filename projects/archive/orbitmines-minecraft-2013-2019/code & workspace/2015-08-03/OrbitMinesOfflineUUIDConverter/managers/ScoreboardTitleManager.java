package me.O_o_Fadi_o_O.Survival.managers;

import me.O_o_Fadi_o_O.Survival.Start;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class ScoreboardTitleManager {

	Start start = Start.getInstance();
	
	private int i = 0;
	public static String title = "";
	
	private void setScoreboardTitle(Player p){
		if(p.getScoreboard() != null && p.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null){
			p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(title);
		}
	}
	
	private void setNextScoreboardTitle(){
		i++;
		
		if(i == 1){title = "§6§lOrbitMines§a§lSurvival";}
		if(i == 7){title = "§e§lO§6§lrbitMines§a§lSurvival";}
		if(i == 8){title = "§e§lOr§6§lbitMines§a§lSurvival";}
		if(i == 9){title = "§e§lOrb§6§litMines§a§lSurvival";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§a§lSurvival";}
		if(i == 11){title = "§e§lOrbit§6§lMines§a§lSurvival";}
		if(i == 12){title = "§e§lOrbitM§6§lines§a§lSurvival";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§a§lSurvival";}
		if(i == 14){title = "§e§lOrbitMin§6§les§a§lSurvival";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§a§lSurvival";}
		if(i == 16){title = "§e§lOrbitMines§a§lSurvival";}
		if(i == 17){title = "§e§lOrbitMines§2§lS§a§lurvival";}
		if(i == 18){title = "§e§lOrbitMines§2§lSu§a§lrvival";}
		if(i == 19){title = "§e§lOrbitMines§2§lSur§a§lvival";}
		if(i == 20){title = "§e§lOrbitMines§2§lSurv§a§lival";}
		if(i == 21){title = "§e§lOrbitMines§2§lSurvi§a§lval";}
		if(i == 22){title = "§e§lOrbitMines§2§lSurviv§a§lal";}
		if(i == 23){title = "§e§lOrbitMines§2§lSurviva§a§ll";}
		if(i == 24){title = "§e§lOrbitMines§2§lSurvival";}
		if(i == 30){title = "§6§lO§e§lrbitMines§2§lSurvival";}
		if(i == 31){title = "§6§lOr§e§lbitMines§2§lSurvival";}
		if(i == 32){title = "§6§lOrb§e§litMines§2§lSurvival";}
		if(i == 33){title = "§6§lOrbi§e§ltMines§2§lSurvival";}
		if(i == 34){title = "§6§lOrbit§e§lMines§2§lSurvival";}
		if(i == 35){title = "§6§lOrbitM§e§lines§2§lSurvival";}
		if(i == 36){title = "§6§lOrbitMi§e§lnes§2§lSurvival";}
		if(i == 37){title = "§6§lOrbitMin§e§les§2§lSurvival";}
		if(i == 38){title = "§6§lOrbitMine§e§ls§2§lSurvival";}
		if(i == 39){title = "§6§lOrbitMines§2§lSurvival";}
		if(i == 40){title = "§6§lOrbitMines§a§lS§2§lurvival";}
		if(i == 41){title = "§6§lOrbitMines§a§lSu§2§lrvival";}
		if(i == 42){title = "§6§lOrbitMines§a§lSur§2§lvival";}
		if(i == 43){title = "§6§lOrbitMines§a§lSurv§2§lival";}
		if(i == 44){title = "§6§lOrbitMines§a§lSurvi§2§lval";}
		if(i == 45){title = "§6§lOrbitMines§a§lSurviv§2§lal";}
		if(i == 46){title = "§6§lOrbitMines§a§lSurviva§2§ll";}
		if(i == 47){title = "§6§lOrbitMines§a§lSurvival"; i = 0;}
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
