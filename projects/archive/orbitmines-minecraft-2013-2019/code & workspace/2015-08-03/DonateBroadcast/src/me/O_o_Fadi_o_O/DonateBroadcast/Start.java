package me.O_o_Fadi_o_O.DonateBroadcast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	public String TAG = "§8[§6§lC§5§lu§3§ls§7§lt§9§lo§2§lm§1§lB§a§lr§4§lo§b§la§f§ld§d§lc§3§la§0§ls§9§lt§8]";
	
	public String Prefix = "&8[&6&lC&5&lu&3&ls&7&lt&9&lo&2&lm&1&lB&a&lr&4&lo&b&la&f&ld&d&lc&3&la&0&ls&9&lt&8]&7";
	
	public void onEnable(){
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		Prefix = getConfig().getString("Prefix");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
				if(cmd.getName().equalsIgnoreCase("custombroadcast") || cmd.getName().equalsIgnoreCase("cbroadcast") || cmd.getName().equalsIgnoreCase("cb")){
						
						if(sender.hasPermission("CustomBroadcast.Admin") || sender.hasPermission("CustomBroadcast.*")){
							
							if(a.length == 0){
								sender.sendMessage(TAG + " §cIncorrect Use!");
								sender.sendMessage(TAG + " §cHelp: §6/custombroadcast help");
							}
							
							else if(a[0].equalsIgnoreCase("help")){
								
								sender.sendMessage(TAG + " §6CustomBroadcast v1.1.2 §7by §6O_o_Fadi_o_O");
								sender.sendMessage(TAG + " §7All Commands:");
								sender.sendMessage(TAG + " §6/custombroadcast help");
								sender.sendMessage(TAG + " §6/custombroadcast reload");
								sender.sendMessage(TAG + " §6/custombroadcast colorcodes");
								sender.sendMessage(TAG + " §6/custombroadcast setprefix <prefix>");
								sender.sendMessage(TAG + " §6/custombroadcast broadcast <text>");
							}
							else if(a[0].equalsIgnoreCase("colorcodes")){
								
								sender.sendMessage(TAG + " §7All Colorcodes:");
								sender.sendMessage(TAG + " §a&a Green");
								sender.sendMessage(TAG + " §b&b Light Blue");
								sender.sendMessage(TAG + " §c&c Red");
								sender.sendMessage(TAG + " §d&d Pink");
								sender.sendMessage(TAG + " §e&e Yellow");
								sender.sendMessage(TAG + " §f&f White");
								sender.sendMessage(TAG + " §0&0 Black");
								sender.sendMessage(TAG + " §1&1 Dark Blue");
								sender.sendMessage(TAG + " §2&2 Dark Green");
								sender.sendMessage(TAG + " §3&3 Cyan");
								sender.sendMessage(TAG + " §4&4 Dark Red");
								sender.sendMessage(TAG + " §5&5 Purple");
								sender.sendMessage(TAG + " §6&6 Gold");
								sender.sendMessage(TAG + " §7&7 Grey");
								sender.sendMessage(TAG + " §8&8 Dark Grey");
								sender.sendMessage(TAG + " §9&9 Light Blue");
								sender.sendMessage(TAG + " §f§o&o Italic");
								sender.sendMessage(TAG + " §f§n&n Underline");
								sender.sendMessage(TAG + " §f§m&m Strikecross§f (&m)");
								sender.sendMessage(TAG + " §f§k&k Magic§f (&k)");
								sender.sendMessage(TAG + " §f§l&l Bold");
								sender.sendMessage(TAG + " §r&r Reset");
							}
							else if(a[0].equalsIgnoreCase("reload")){
								
								sender.sendMessage(TAG + " §7Reloading...");

								reloadConfig();
								Prefix = getConfig().getString("Prefix");
						
								sender.sendMessage(TAG + " §7Reload Complete!");
							}
							else if(a[0].equalsIgnoreCase("setprefix")){
								if(a.length >= 2){
								
									StringBuilder sb = new StringBuilder();
									for (int i = 1; i < a.length; i++){
									sb.append(a[i]).append(" ");
									}
									 
									String allArgs = sb.toString().trim();
								sender.sendMessage(TAG + "§7 Prefix set to: " + allArgs);
								sender.sendMessage(TAG + "§7 Looks like: " + allArgs.replaceAll("&", "§"));
							
								getConfig().set("Prefix", allArgs);
								saveConfig();
								Prefix = getConfig().getString("Prefix");
								}
								else{
									sender.sendMessage(TAG + " §cIncorrect Use!");
									sender.sendMessage(TAG + " §6/custombroadcast setprefix <prefix>");	
								}
							}
							else if(a[0].equalsIgnoreCase("broadcast")){
								if(a.length >= 2){
									
									StringBuilder sb = new StringBuilder();
									for (int i = 1; i < a.length; i++){
									sb.append(a[i]).append(" ");
									}
									 
									String allArgs = sb.toString().trim();
								    Bukkit.broadcastMessage(Prefix.replaceAll("&", "§") + " " + allArgs.replaceAll("&", "§"));
								}
								else{
									sender.sendMessage(TAG + " §cIncorrect Use!");
									sender.sendMessage(TAG + " §6/custombroadcast broadcast <text>");
								}
							}
							else{
								sender.sendMessage(TAG + " §cIncorrect Use!");
								sender.sendMessage(TAG + " §cHelp: §6/custombroadcast help");
							}
						}
						else{
							sender.sendMessage("§cAccess Denied!");
						}
					}
		return true;
	}
}
