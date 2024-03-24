package me.O_o_Fadi_o_O.Hub.runnables;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;

import org.bukkit.scheduler.BukkitRunnable;

public class DatabaseRunnable {

	Hub plugin;
	 
	public DatabaseRunnable(Hub instance) {
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
