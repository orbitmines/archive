package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DatabaseManager;

public class DatabaseRunnable implements Runnable{
	
	@Override
	public void run(){
		DatabaseManager.openConnection();
	}
}
