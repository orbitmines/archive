package me.O_o_Fadi_o_O.SpigotSpleef.managers;

public class SignManager {

	public static void loadSigns(){
		StorageManager.signswaiting = ConfigManager.config.getStringList("Settings.Signs.Waiting");
		StorageManager.signsenoughplayers = ConfigManager.config.getStringList("Settings.Signs.EnoughPlayers");
		StorageManager.signsfull = ConfigManager.config.getStringList("Settings.Signs.Full");
		StorageManager.signsingame = ConfigManager.config.getStringList("Settings.Signs.InGame");
		StorageManager.signsrestarting = ConfigManager.config.getStringList("Settings.Signs.Restarting");
	}
}
