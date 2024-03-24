package me.O_o_Fadi_o_O.MiniGames.runnables;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.ServerSelector;

import org.bukkit.scheduler.BukkitRunnable;

public class ServerSelectorRunnable {
	
	public static int i = 0;
	
	Start start = Start.getInstance();
	
	public void startServerSelectorRunnable(){
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				i++;
					
				ServerSelector.setAllServerSelectorItems();
				
				if(i == 18){
					i = 0;
				}
				
			}
		}.runTaskTimer(this.start, 0, 1);
	}
}
