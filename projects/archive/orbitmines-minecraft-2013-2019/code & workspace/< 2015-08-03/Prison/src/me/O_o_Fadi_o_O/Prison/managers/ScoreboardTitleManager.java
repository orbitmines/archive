package me.O_o_Fadi_o_O.Prison.managers;

import me.O_o_Fadi_o_O.Prison.Start;

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
		
		if(i == 1){title = "§6§lOrbitMines§4§lPrison";}
		if(i == 7){title = "§e§lO§6§lrbitMines§4§lPrison";}
		if(i == 8){title = "§e§lOr§6§lbitMines§4§lPrison";}
		if(i == 9){title = "§e§lOrb§6§litMines§4§lPrison";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§4§lPrison";}
		if(i == 11){title = "§e§lOrbit§6§lMines§4§lPrison";}
		if(i == 12){title = "§e§lOrbitM§6§lines§4§lPrison";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§4§lPrison";}
		if(i == 14){title = "§e§lOrbitMin§6§les§4§lPrison";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§4§lPrison";}
		if(i == 16){title = "§e§lOrbitMines§4§lPrison";}
		if(i == 17){title = "§e§lOrbitMines§c§lP§4§lrison";}
		if(i == 18){title = "§e§lOrbitMines§c§lPr§4§lison";}
		if(i == 19){title = "§e§lOrbitMines§c§lPri§4§lson";}
		if(i == 20){title = "§e§lOrbitMines§c§lPris§4§lon";}
		if(i == 21){title = "§e§lOrbitMines§c§lPriso§4§ln";}
		if(i == 22){title = "§e§lOrbitMines§c§lPrison";}
		if(i == 28){title = "§6§lO§e§lrbitMines§c§lPrison";}
		if(i == 29){title = "§6§lOr§e§lbitMines§c§lPrison";}
		if(i == 30){title = "§6§lOrb§e§litMines§c§lPrison";}
		if(i == 31){title = "§6§lOrbi§e§ltMines§c§lPrison";}
		if(i == 32){title = "§6§lOrbit§e§lMines§c§lPrison";}
		if(i == 33){title = "§6§lOrbitM§e§lines§c§lPrison";}
		if(i == 34){title = "§6§lOrbitMi§e§lnes§c§lPrison";}
		if(i == 35){title = "§6§lOrbitMin§e§les§c§lPrison";}
		if(i == 36){title = "§6§lOrbitMine§e§ls§c§lPrison";}
		if(i == 37){title = "§6§lOrbitMines§c§lPrison";}
		if(i == 39){title = "§6§lOrbitMines§4§lP§c§lrison";}
		if(i == 40){title = "§6§lOrbitMines§4§lPr§c§lison";}
		if(i == 41){title = "§6§lOrbitMines§4§lPri§c§lson";}
		if(i == 42){title = "§6§lOrbitMines§4§lPris§c§lon";}
		if(i == 43){title = "§6§lOrbitMines§4§lPriso§c§ln";}
		if(i == 44){title = "§6§lOrbitMines§4§lPrison"; i = 0;}
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
