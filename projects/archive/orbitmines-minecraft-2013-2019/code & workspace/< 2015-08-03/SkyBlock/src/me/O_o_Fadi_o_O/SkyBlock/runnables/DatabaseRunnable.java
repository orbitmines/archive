package me.O_o_Fadi_o_O.SkyBlock.runnables;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.DatabaseManager;

import org.bukkit.scheduler.BukkitRunnable;

public class DatabaseRunnable {

	Start start = Start.getInstance();
	
	public void startDatabaseRunnable(){
				
		new BukkitRunnable(){

			@Override
			public void run(){
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this.start);
	}
}
