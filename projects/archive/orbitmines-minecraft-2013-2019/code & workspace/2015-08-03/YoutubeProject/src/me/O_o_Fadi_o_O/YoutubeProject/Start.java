package me.O_o_Fadi_o_O.YoutubeProject;

import me.O_o_Fadi_o_O.YoutubeProject.events.ClickEvent;
import me.O_o_Fadi_o_O.YoutubeProject.events.InteractEvent;
import me.O_o_Fadi_o_O.YoutubeProject.events.JoinEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	public void onEnable(){
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
	}
	
}