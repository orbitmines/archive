package me.O_o_Fadi_o_O.Hub.managers;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class ScoreboardTitleManager {

	Hub hub = Hub.getInstance();
	
	private int i = 0;
	public static String title = "";
	
	private void setScoreboardTitle(Player p){
		if(p.getScoreboard() != null && p.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null){
			p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(title);
		}
	}
	
	private void setNextScoreboardTitle(){
		i++;
		
		if(i == 1){title = "§6§lOrbitMines§4§lNetwork";}
		if(i == 7){title = "§e§lO§6§lrbitMines§4§lNetwork";}
		if(i == 8){title = "§e§lOr§6§lbitMines§4§lNetwork";}
		if(i == 9){title = "§e§lOrb§6§litMines§4§lNetwork";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§4§lNetwork";}
		if(i == 11){title = "§e§lOrbit§6§lMines§4§lNetwork";}
		if(i == 12){title = "§e§lOrbitM§6§lines§4§lNetwork";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§4§lNetwork";}
		if(i == 14){title = "§e§lOrbitMin§6§les§4§lNetwork";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§4§lNetwork";}
		if(i == 16){title = "§e§lOrbitMines§4§lNetwork";}
		if(i == 17){title = "§e§lOrbitMines§c§lN§4§letwork";}
		if(i == 18){title = "§e§lOrbitMines§c§lNe§4§ltwork";}
		if(i == 19){title = "§e§lOrbitMines§c§lNet§4§lwork";}
		if(i == 20){title = "§e§lOrbitMines§c§lNetw§4§lork";}
		if(i == 21){title = "§e§lOrbitMines§c§lNetwo§4§lrk";}
		if(i == 22){title = "§e§lOrbitMines§c§lNetwor§4§lk";}
		if(i == 23){title = "§e§lOrbitMines§c§lNetwork";}
		if(i == 29){title = "§6§lO§e§lrbitMines§c§lNetwork";}
		if(i == 30){title = "§6§lOr§e§lbitMines§c§lNetwork";}
		if(i == 31){title = "§6§lOrb§e§litMines§c§lNetwork";}
		if(i == 32){title = "§6§lOrbi§e§ltMines§c§lNetwork";}
		if(i == 33){title = "§6§lOrbit§e§lMines§c§lNetwork";}
		if(i == 34){title = "§6§lOrbitM§e§lines§c§lNetwork";}
		if(i == 35){title = "§6§lOrbitMi§e§lnes§c§lNetwork";}
		if(i == 36){title = "§6§lOrbitMin§e§les§c§lNetwork";}
		if(i == 37){title = "§6§lOrbitMine§e§ls§c§lNetwork";}
		if(i == 38){title = "§6§lOrbitMines§c§lNetwork";}
		if(i == 39){title = "§6§lOrbitMines§4§lN§c§letwork";}
		if(i == 40){title = "§6§lOrbitMines§4§lNe§c§ltwork";}
		if(i == 41){title = "§6§lOrbitMines§4§lNet§c§lwork";}
		if(i == 42){title = "§6§lOrbitMines§4§lNetw§c§lork";}
		if(i == 43){title = "§6§lOrbitMines§4§lNetwo§c§lrk";}
		if(i == 44){title = "§6§lOrbitMines§4§lNetwor§c§lk";}
		if(i == 45){title = "§6§lOrbitMines§4§lNetwork"; i = 0;}
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
		}.runTaskTimer(this.hub, 0, 5);
	}
}
