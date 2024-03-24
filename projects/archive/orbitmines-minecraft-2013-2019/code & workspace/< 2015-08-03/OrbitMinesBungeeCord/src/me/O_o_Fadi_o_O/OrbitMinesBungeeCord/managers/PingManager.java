package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.StatusListener;

public class PingManager {

	private static Class<? extends StatusListener> pingExecutor = DefaultPingManager.class;
	private static int stopAfter = 10;

	public static Class<? extends StatusListener> getPingManager() {
		return PingManager.pingExecutor;
	}

	public static void setPingManager(Class<? extends StatusListener> pingManager) {
		PingManager.pingExecutor = pingManager;
	}

	public static int getStopAfter() {
		return stopAfter;
	}

	public static void setStopAfter(int seconds) {
		PingManager.stopAfter = seconds;
	}
}
