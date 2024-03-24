package me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp;

import me.O_o_Fadi_o_O.OrbitMines.utils.kitpvp.KitPvPUtils.Booster;


public class ActiveBooster {
	
	private Booster booster;
	private String player;
	private int minutes;
	private int seconds;
	
	public ActiveBooster(Booster booster, String player, int minutes, int seconds){
		this.booster = booster;
		this.player = player;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Booster getBooster() {
		return booster;
	}

	public void setBooster(Booster booster) {
		this.booster = booster;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public void tickTimer(){
		if(seconds != -1){
			seconds = seconds -1;
		}
		if(seconds == -1){
			minutes = minutes -1;
			seconds = 59;
		}
	}
	
	public boolean canCancel(){
		if(this.minutes == 0 && this.seconds == 0){
			return true;
		}
		return false;
	}
}