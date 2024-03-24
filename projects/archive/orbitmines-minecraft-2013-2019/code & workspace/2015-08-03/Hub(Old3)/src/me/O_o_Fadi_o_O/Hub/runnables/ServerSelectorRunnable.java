package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.Inv.ServerSelector;

import org.bukkit.scheduler.BukkitRunnable;

public class ServerSelectorRunnable {
	
	public static int i = 0;
	
	Hub hub = Hub.getInstance();
	
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
		}.runTaskTimer(this.hub, 0, 1);
	}
}
