package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DefaultPingManager;

public class MOTDRunnable implements Runnable {

	@Override
	public void run() {
		DefaultPingManager.setNextOrbitMinesTitle();
	}
}
