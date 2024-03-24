package me.O_o_Fadi_o_O.CustomBroadcast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
					
					if((sender instanceof Player)){
						Player player = (Player)sender;
						
						if(player.hasPermission("CustomBroadcast.Admin") || player.hasPermission("CustomBroadcast.*")){
							
							if(a.length == 0){
								player.sendMessage(TAG + " §cIncorrect Use!");
								player.sendMessage(TAG + " §cHelp: §6/custombroadcast help");
							}
							
							else if(a[0].equalsIgnoreCase("help")){
								
								player.sendMessage(TAG + " §6CustomBroadcast v1.1.2 §7by §6O_o_Fadi_o_O");
								player.sendMessage(TAG + " §7All Commands:");
								player.sendMessage(TAG + " §6/custombroadcast help");
								player.sendMessage(TAG + " §6/custombroadcast reload");
								player.sendMessage(TAG + " §6/custombroadcast colorcodes");
								player.sendMessage(TAG + " §6/custombroadcast setprefix <prefix>");
								player.sendMessage(TAG + " §6/custombroadcast broadcast <text>");
							}
							else if(a[0].equalsIgnoreCase("colorcodes")){
								
								player.sendMessage(TAG + " §7All Colorcodes:");
								player.sendMessage(TAG + " §a&a Green");
								player.sendMessage(TAG + " §b&b Light Blue");
								player.sendMessage(TAG + " §c&c Red");
								player.sendMessage(TAG + " §d&d Pink");
								player.sendMessage(TAG + " §e&e Yellow");
								player.sendMessage(TAG + " §f&f White");
								player.sendMessage(TAG + " §0&0 Black");
								player.sendMessage(TAG + " §1&1 Dark Blue");
								player.sendMessage(TAG + " §2&2 Dark Green");
								player.sendMessage(TAG + " §3&3 Cyan");
								player.sendMessage(TAG + " §4&4 Dark Red");
								player.sendMessage(TAG + " §5&5 Purple");
								player.sendMessage(TAG + " §6&6 Gold");
								player.sendMessage(TAG + " §7&7 Grey");
								player.sendMessage(TAG + " §8&8 Dark Grey");
								player.sendMessage(TAG + " §9&9 Light Blue");
								player.sendMessage(TAG + " §f§o&o Italic");
								player.sendMessage(TAG + " §f§n&n Underline");
								player.sendMessage(TAG + " §f§m&m Strikecross§f (&m)");
								player.sendMessage(TAG + " §f§k&k Magic§f (&k)");
								player.sendMessage(TAG + " §f§l&l Bold");
								player.sendMessage(TAG + " §r&r Reset");
							}
							else if(a[0].equalsIgnoreCase("reload")){
								
								player.sendMessage(TAG + " §7Reloading...");

								reloadConfig();
								Prefix = getConfig().getString("Prefix");
						
								player.sendMessage(TAG + " §7Reload Complete!");
							}
							else if(a[0].equalsIgnoreCase("setprefix")){
								if(a.length >= 2){
								
									StringBuilder sb = new StringBuilder();
									for (int i = 1; i < a.length; i++){
									sb.append(a[i]).append(" ");
									}
									 
									String allArgs = sb.toString().trim();
								player.sendMessage(TAG + "§7 Prefix set to: " + allArgs);
								player.sendMessage(TAG + "§7 Looks like: " + allArgs.replaceAll("&", "§"));
							
								getConfig().set("Prefix", allArgs);
								saveConfig();
								Prefix = getConfig().getString("Prefix");
								}
								else{
									player.sendMessage(TAG + " §cIncorrect Use!");
									player.sendMessage(TAG + " §6/custombroadcast setprefix <prefix>");	
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
									player.sendMessage(TAG + " §cIncorrect Use!");
									player.sendMessage(TAG + " §6/custombroadcast broadcast <text>");
								}
							}
							else{
								player.sendMessage(TAG + " §cIncorrect Use!");
								player.sendMessage(TAG + " §cHelp: §6/custombroadcast help");
							}
						}
						else{
							sender.sendMessage("§cAccess Denied!");
						}
					}
					else{
						sender.sendMessage(TAG + " §6You can't perform commands through the console!");
					}
				}
		return true;
	}
}
