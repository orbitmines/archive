package me.O_o_Fadi_o_O.KitPvP.runnables;

import java.util.Calendar;

import me.O_o_Fadi_o_O.KitPvP.Start;

import org.bukkit.scheduler.BukkitRunnable;

public class FreeKitRunnable {

	Start plugin;
	 
	public FreeKitRunnable(Start instance) {
		plugin = instance;
	}
	
	public void startFreeKitRunnable(){
		new BukkitRunnable(){
	
			@Override
			public void run() {
				
				Calendar c = Calendar.getInstance();

		        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		        if (dayOfWeek == Calendar.SATURDAY) {
		            Start.FreeKitEnabled = true;
		        }
		        else{
		        	Start.FreeKitEnabled = false;
		        }
				
			}
		}.runTaskTimer(this.plugin, 0, 20 * 60 * 60);
	}
}
