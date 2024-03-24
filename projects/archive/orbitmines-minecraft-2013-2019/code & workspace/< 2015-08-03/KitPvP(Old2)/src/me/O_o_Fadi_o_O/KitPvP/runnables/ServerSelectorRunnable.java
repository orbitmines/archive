package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.Inv.ServerSelector;

import org.bukkit.scheduler.BukkitRunnable;

public class ServerSelectorRunnable {

	Start plugin;
	 
	public ServerSelectorRunnable(Start instance) {
		plugin = instance;
	}
	
	public int i = 0;
	
	public void startServerSelectorRunnable(){
				
		new BukkitRunnable(){

			@Override
			public void run() {
				
				i++;
					
				ServerSelector.KitPvPServerItem(ServerSelector.sinv, i);
				ServerSelector.PrisonServerItem(ServerSelector.sinv, i);;
				ServerSelector.CreativeServerItem(ServerSelector.sinv, i);
				ServerSelector.SurvivalServerItem(ServerSelector.sinv, i);
				ServerSelector.SkyBlockServerItem(ServerSelector.sinv, i);
				ServerSelector.MiniGamesServerItem(ServerSelector.sinv, i);
				
				if(i == 2){
					i = 0;
				}
				
			}
		}.runTaskTimer(this.plugin, 0, 3);
	}
}
