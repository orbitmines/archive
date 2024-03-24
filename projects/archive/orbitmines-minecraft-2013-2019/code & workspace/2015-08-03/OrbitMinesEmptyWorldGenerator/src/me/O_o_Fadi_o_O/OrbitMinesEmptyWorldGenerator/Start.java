package me.O_o_Fadi_o_O.OrbitMinesEmptyWorldGenerator;

import me.O_o_Fadi_o_O.OrbitMinesEmptyWorldGenerator.managers.EmptyWorldManager;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		return new EmptyWorldManager();
	}
	
	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
}
