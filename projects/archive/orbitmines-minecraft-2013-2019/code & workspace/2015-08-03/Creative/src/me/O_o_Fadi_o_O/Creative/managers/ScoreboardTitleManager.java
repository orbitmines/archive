package me.O_o_Fadi_o_O.Creative.managers;

import me.O_o_Fadi_o_O.Creative.Start;

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
		
		if(i == 1){title = "§6§lOrbitMines§d§lCreative";}
		if(i == 7){title = "§e§lO§6§lrbitMines§d§lCreative";}
		if(i == 8){title = "§e§lOr§6§lbitMines§d§lCreative";}
		if(i == 9){title = "§e§lOrb§6§litMines§d§lCreative";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§d§lCreative";}
		if(i == 11){title = "§e§lOrbit§6§lMines§d§lCreative";}
		if(i == 12){title = "§e§lOrbitM§6§lines§d§lCreative";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§d§lCreative";}
		if(i == 14){title = "§e§lOrbitMin§6§les§d§lCreative";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§d§lCreative";}
		if(i == 16){title = "§e§lOrbitMines§d§lCreative";}
		if(i == 17){title = "§e§lOrbitMines§5§lC§d§lreative";}
		if(i == 18){title = "§e§lOrbitMines§5§lCr§d§leative";}
		if(i == 19){title = "§e§lOrbitMines§5§lCre§d§lative";}
		if(i == 20){title = "§e§lOrbitMines§5§lCrea§d§ltive";}
		if(i == 21){title = "§e§lOrbitMines§5§lCreat§d§live";}
		if(i == 22){title = "§e§lOrbitMines§5§lCreati§d§lve";}
		if(i == 23){title = "§e§lOrbitMines§5§lCreativ§d§le";}
		if(i == 24){title = "§e§lOrbitMines§5§lCreative";}
		if(i == 30){title = "§6§lO§e§lrbitMines§5§lCreative";}
		if(i == 31){title = "§6§lOr§e§lbitMines§5§lCreative";}
		if(i == 32){title = "§6§lOrb§e§litMines§5§lCreative";}
		if(i == 33){title = "§6§lOrbi§e§ltMines§5§lCreative";}
		if(i == 34){title = "§6§lOrbit§e§lMines§5§lCreative";}
		if(i == 35){title = "§6§lOrbitM§e§lines§5§lCreative";}
		if(i == 36){title = "§6§lOrbitMi§e§lnes§5§lCreative";}
		if(i == 37){title = "§6§lOrbitMin§e§les§5§lCreative";}
		if(i == 38){title = "§6§lOrbitMine§e§ls§5§lCreative";}
		if(i == 39){title = "§6§lOrbitMines§5§lCreative";}
		if(i == 40){title = "§6§lOrbitMines§d§lC§5§lreative";}
		if(i == 41){title = "§6§lOrbitMines§d§lCr§5§leative";}
		if(i == 42){title = "§6§lOrbitMines§d§lCre§5§lative";}
		if(i == 43){title = "§6§lOrbitMines§d§lCrea§5§ltive";}
		if(i == 44){title = "§6§lOrbitMines§d§lCreat§5§live";}
		if(i == 45){title = "§6§lOrbitMines§d§lCreati§5§lve";}
		if(i == 46){title = "§6§lOrbitMines§d§lCreativ§5§le";}
		if(i == 47){title = "§6§lOrbitMines§d§lCreative"; i = 0;}
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
