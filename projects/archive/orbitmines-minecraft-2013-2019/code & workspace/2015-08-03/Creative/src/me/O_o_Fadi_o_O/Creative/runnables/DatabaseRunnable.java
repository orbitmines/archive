package me.O_o_Fadi_o_O.Creative.runnables;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.DatabaseManager;

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
