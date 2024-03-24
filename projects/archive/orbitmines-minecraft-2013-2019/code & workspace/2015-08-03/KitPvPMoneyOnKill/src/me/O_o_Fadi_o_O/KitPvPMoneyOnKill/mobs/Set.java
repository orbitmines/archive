package me.O_o_Fadi_o_O.KitPvPMoneyOnKill.mobs;

import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.Start;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Set implements Listener {
	
	static Start plugin;
	 
	public Set(Start instance) {
	plugin = instance;
	}
	
	// SET SKELETON
	public static void Skeleton(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Skeleton");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Skeleton");
	} 
	// SET ZOMBIE
	public static void Zombie(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Zombie");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Zombie");
	} 
	// SET BLAZE
	public static void Blaze(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Blaze");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Blaze");
	} 
	// SET CREEPER
	public static void Creeper(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Creeper");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Creeper");
	} 
	// SET WITCH
	public static void Witch(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Witch");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Witch");
	} 
	// SET SPIDER
	public static void Spider(Player p){
		plugin.getConfig().set(p.getName() + ".Type", "Spider");
		plugin.saveConfig();
		Start.type.put(p.getName(), "Spider");
	} 
}
