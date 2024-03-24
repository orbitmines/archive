package me.O_o_Fadi_o_O.Prison.runnables;

import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.managers.DatabaseManager;

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
