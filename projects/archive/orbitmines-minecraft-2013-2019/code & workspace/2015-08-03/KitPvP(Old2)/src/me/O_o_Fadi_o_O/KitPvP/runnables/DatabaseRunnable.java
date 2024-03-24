package me.O_o_Fadi_o_O.KitPvP.runnables;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;

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
