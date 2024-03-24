package me.O_o_Fadi_o_O.BungeeSP;

import net.md_5.bungee.api.plugin.Plugin;

public class Start extends Plugin {

	static Start plugin;
	
	public void onEnable(){
		plugin = this;
	}
	
	public static Start getInstance(){
		return plugin;
	}
}
