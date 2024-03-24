package me.O_o_Fadi_o_O.OrbitMinesPlotGenerator;

import me.O_o_Fadi_o_O.OrbitMinesPlotGenerator.managers.PlotGenerator;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	private static Start plugin;
	
	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		return new PlotGenerator();
	}
	
	public void onEnable(){
		plugin = this;
	}
	
	public void onDisable(){
		
	}
	
	public static Start getInstance(){
		return plugin;
	}
}
