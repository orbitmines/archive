package me.O_o_Fadi_o_O.OrbitMinesEmptyNetherGenerator;

import me.O_o_Fadi_o_O.OrbitMinesEmptyNetherGenerator.managers.EmptyNetherManager;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		return new EmptyNetherManager();
	}
	
	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
}
