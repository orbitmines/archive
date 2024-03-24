package me.O_o_Fadi_o_O.SkyBlock.managers;

import me.O_o_Fadi_o_O.SkyBlock.Start;

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
		
		if(i == 1){title = "§6§lOrbitMines§5§lSkyBlock";}
		if(i == 7){title = "§e§lO§6§lrbitMines§5§lSkyBlock";}
		if(i == 8){title = "§e§lOr§6§lbitMines§5§lSkyBlock";}
		if(i == 9){title = "§e§lOrb§6§litMines§5§lSkyBlock";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§5§lSkyBlock";}
		if(i == 11){title = "§e§lOrbit§6§lMines§5§lSkyBlock";}
		if(i == 12){title = "§e§lOrbitM§6§lines§5§lSkyBlock";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§5§lSkyBlock";}
		if(i == 14){title = "§e§lOrbitMin§6§les§5§lSkyBlock";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§5§lSkyBlock";}
		if(i == 16){title = "§e§lOrbitMines§5§lSkyBlock";}
		if(i == 17){title = "§e§lOrbitMines§d§lS§5§lkyBlock";}
		if(i == 18){title = "§e§lOrbitMines§d§lSk§5§lyBlock";}
		if(i == 19){title = "§e§lOrbitMines§d§lSky§5§lBlock";}
		if(i == 20){title = "§e§lOrbitMines§d§lSkyB§5§llock";}
		if(i == 21){title = "§e§lOrbitMines§d§lSkyBl§5§lock";}
		if(i == 22){title = "§e§lOrbitMines§d§lSkyBlo§5§lck";}
		if(i == 23){title = "§e§lOrbitMines§d§lSkyBloc§5§lk";}
		if(i == 24){title = "§e§lOrbitMines§d§lSkyBlock";}
		if(i == 30){title = "§6§lO§e§lrbitMines§d§lSkyBlock";}
		if(i == 31){title = "§6§lOr§e§lbitMines§d§lSkyBlock";}
		if(i == 32){title = "§6§lOrb§e§litMines§d§lSkyBlock";}
		if(i == 33){title = "§6§lOrbi§e§ltMines§d§lSkyBlock";}
		if(i == 34){title = "§6§lOrbit§e§lMines§d§lSkyBlock";}
		if(i == 35){title = "§6§lOrbitM§e§lines§d§lSkyBlock";}
		if(i == 36){title = "§6§lOrbitMi§e§lnes§d§lSkyBlock";}
		if(i == 37){title = "§6§lOrbitMin§e§les§d§lSkyBlock";}
		if(i == 38){title = "§6§lOrbitMine§e§ls§d§lSkyBlock";}
		if(i == 39){title = "§6§lOrbitMines§d§lSkyBlock";}
		if(i == 40){title = "§6§lOrbitMines§5§lS§d§lkyBlock";}
		if(i == 41){title = "§6§lOrbitMines§5§lSk§d§lyBlock";}
		if(i == 42){title = "§6§lOrbitMines§5§lSky§d§lBlock";}
		if(i == 43){title = "§6§lOrbitMines§5§lSkyB§d§llock";}
		if(i == 44){title = "§6§lOrbitMines§5§lSkyBl§d§lock";}
		if(i == 45){title = "§6§lOrbitMines§5§lSkyBlo§d§lck";}
		if(i == 46){title = "§6§lOrbitMines§5§lSkyBloc§d§lk";}
		if(i == 47){title = "§6§lOrbitMines§5§lSkyBlock"; i = 0;}
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
