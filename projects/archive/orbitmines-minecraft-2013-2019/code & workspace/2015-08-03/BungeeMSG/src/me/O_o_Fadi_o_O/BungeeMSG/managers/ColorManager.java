package me.O_o_Fadi_o_O.BungeeMSG.managers;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ColorManager {

	public static String checkforColors(ProxiedPlayer p, String message){
		
		if(p.hasPermission("BungeeMSG.colors.black") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&0", "§0");
		}
		if(p.hasPermission("BungeeMSG.colors.dark_blue") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&1", "§1");
		}
		if(p.hasPermission("BungeeMSG.colors.green") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&2", "§2");
		}
		if(p.hasPermission("BungeeMSG.colors.cyan") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&3", "§3");
		}
		if(p.hasPermission("BungeeMSG.colors.dark_red") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&4", "§4");
		}
		if(p.hasPermission("BungeeMSG.colors.purple") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&5", "§5");
		}
		if(p.hasPermission("BungeeMSG.colors.orange") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&6", "§6");
		}
		if(p.hasPermission("BungeeMSG.colors.light_gray") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&7", "§7");
		}
		if(p.hasPermission("BungeeMSG.colors.gray") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&8", "§8");
		}
		if(p.hasPermission("BungeeMSG.colors.blue") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&9", "§9");
		}
		if(p.hasPermission("BungeeMSG.colors.lime") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&a", "§a");
		}
		if(p.hasPermission("BungeeMSG.colors.aqua") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&b", "§b");
		}
		if(p.hasPermission("BungeeMSG.colors.red") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&c", "§c");
		}
		if(p.hasPermission("BungeeMSG.colors.pink") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&d", "§d");
		}
		if(p.hasPermission("BungeeMSG.colors.yellow") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&e", "§e");
		}
		if(p.hasPermission("BungeeMSG.colors.white") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&f", "§f");
		}
		
		if(p.hasPermission("BungeeMSG.colors.reset") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&r", "§r");
		}
		if(p.hasPermission("BungeeMSG.colors.italic") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&o", "§o");
		}
		if(p.hasPermission("BungeeMSG.colors.bold") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&l", "§l");
		}
		if(p.hasPermission("BungeeMSG.colors.magic") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&k", "§k");
		}
		if(p.hasPermission("BungeeMSG.colors.strikethrough") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&m", "§m");
		}
		if(p.hasPermission("BungeeMSG.colors.underlined") || p.hasPermission("BungeeMSG.colors.*")){
			message = message.replace("&n", "§n");
		}
		
		return message;
	}
}
 