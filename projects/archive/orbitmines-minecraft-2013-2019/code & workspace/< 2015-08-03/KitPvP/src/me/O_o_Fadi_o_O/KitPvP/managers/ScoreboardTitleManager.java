package me.O_o_Fadi_o_O.KitPvP.managers;

import me.O_o_Fadi_o_O.KitPvP.Start;

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
		
		if(i == 1){title = "§6§lOrbitMines§c§lKitPvP";}
		if(i == 7){title = "§e§lO§6§lrbitMines§c§lKitPvP";}
		if(i == 8){title = "§e§lOr§6§lbitMines§c§lKitPvP";}
		if(i == 9){title = "§e§lOrb§6§litMines§c§lKitPvP";}
		if(i == 10){title = "§e§lOrbi§6§ltMines§c§lKitPvP";}
		if(i == 11){title = "§e§lOrbit§6§lMines§c§lKitPvP";}
		if(i == 12){title = "§e§lOrbitM§6§lines§c§lKitPvP";}
		if(i == 13){title = "§e§lOrbitMi§6§lnes§c§lKitPvP";}
		if(i == 14){title = "§e§lOrbitMin§6§les§c§lKitPvP";}
		if(i == 15){title = "§e§lOrbitMine§6§ls§c§lKitPvP";}
		if(i == 16){title = "§e§lOrbitMines§c§lKitPvP";}
		if(i == 17){title = "§e§lOrbitMines§4§lK§c§litPvP";}
		if(i == 18){title = "§e§lOrbitMines§4§lKi§c§ltPvP";}
		if(i == 19){title = "§e§lOrbitMines§4§lKit§c§lPvP";}
		if(i == 20){title = "§e§lOrbitMines§4§lKitP§c§lvP";}
		if(i == 21){title = "§e§lOrbitMines§4§lKitPv§c§lP";}
		if(i == 22){title = "§e§lOrbitMines§4§lKitPvP";}
		if(i == 28){title = "§6§lO§e§lrbitMines§4§lKitPvP";}
		if(i == 29){title = "§6§lOr§e§lbitMines§4§lKitPvP";}
		if(i == 30){title = "§6§lOrb§e§litMines§4§lKitPvP";}
		if(i == 31){title = "§6§lOrbi§e§ltMines§4§lKitPvP";}
		if(i == 32){title = "§6§lOrbit§e§lMines§4§lKitPvP";}
		if(i == 33){title = "§6§lOrbitM§e§lines§4§lKitPvP";}
		if(i == 34){title = "§6§lOrbitMi§e§lnes§4§lKitPvP";}
		if(i == 35){title = "§6§lOrbitMin§e§les§4§lKitPvP";}
		if(i == 36){title = "§6§lOrbitMine§e§ls§4§lKitPvP";}
		if(i == 37){title = "§6§lOrbitMines§4§lKitPvP";}
		if(i == 38){title = "§6§lOrbitMines§c§lK§4§litPvP";}
		if(i == 39){title = "§6§lOrbitMines§c§lKi§4§ltPvP";}
		if(i == 40){title = "§6§lOrbitMines§c§lKit§4§lPvP";}
		if(i == 41){title = "§6§lOrbitMines§c§lKitP§4§lvP";}
		if(i == 42){title = "§6§lOrbitMines§c§lKitPv§4§lP";}
		if(i == 43){title = "§6§lOrbitMines§c§lKitPv§4§lP";}
		if(i == 44){title = "§6§lOrbitMines§c§lKitPvP"; i = 0;}
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
