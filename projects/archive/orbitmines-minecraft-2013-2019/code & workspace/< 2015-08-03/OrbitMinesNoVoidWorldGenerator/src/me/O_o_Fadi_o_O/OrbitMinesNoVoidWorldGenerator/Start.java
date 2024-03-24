package me.O_o_Fadi_o_O.OrbitMinesNoVoidWorldGenerator;

import me.O_o_Fadi_o_O.OrbitMinesNoVoidWorldGenerator.managers.NoVoidWorldManager;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		return new NoVoidWorldManager();
	}
	
	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
}
