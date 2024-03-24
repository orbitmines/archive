package me.O_o_Fadi_o_O.BungeeMSG.runnables;

import java.util.Calendar;

import me.O_o_Fadi_o_O.BungeeMSG.managers.LogManager;

public class DayRunnable implements Runnable {

	int currentday = -1;
	
	@Override
	public void run(){
		Calendar c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_YEAR);
        
        if(currentday == -1){
        	currentday = day;
        }
        
        if(day != currentday){
        	currentday = day;
        	LogManager.createNewLog();
        }
	}
}
