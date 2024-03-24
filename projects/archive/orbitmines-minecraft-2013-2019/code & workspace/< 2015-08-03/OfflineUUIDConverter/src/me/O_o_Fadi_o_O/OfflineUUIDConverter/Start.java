package me.O_o_Fadi_o_O.OfflineUUIDConverter;

import me.O_o_Fadi_o_O.OfflineUUIDConverter.managers.ConfigManager;

import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	public static Start plugin;
	
	public void onEnable(){
		plugin = this;
		ConfigManager.setup(this);
	}
	
	public static Start getInstance(){
		return plugin;
	}
}
