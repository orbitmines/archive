package me.O_o_Fadi_o_O.KitPvP.runnables;

import java.util.Calendar;

import me.O_o_Fadi_o_O.KitPvP.Start;

import org.bukkit.scheduler.BukkitRunnable;

public class FreeKitRunnable {

	Start start = Start.getInstance();
	
	public void startFreeKitRunnable(){
		new BukkitRunnable(){
	
			@Override
			public void run() {
				
				Calendar c = Calendar.getInstance();

		        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		        if (dayOfWeek == Calendar.SATURDAY) {
		            Start.freekitenabled = true;
		        }
		        else{
		        	Start.freekitenabled = false;
		        }
				
			}
		}.runTaskTimer(this.start, 0, 20 * 60 * 60);
	}
}
