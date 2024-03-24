package me.O_o_Fadi_o_O.Friends.runnables;

import me.O_o_Fadi_o_O.Friends.Start;
import me.O_o_Fadi_o_O.Friends.managers.DatabaseManager;

import org.bukkit.scheduler.BukkitRunnable;

public class DatabaseRunnable {

	Start plugin;
	 
	public DatabaseRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startDatabaseRunnable(){
				
		new BukkitRunnable(){

			@Override
			public void run() {
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this.plugin);
	}
}
