package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class IgnoreManager {

	public static boolean isIgnored(ProxiedPlayer sender, ProxiedPlayer receiver, String message){
		boolean ignored = false;
		
		if(!sender.hasPermission("BungeeMSG.bypass.ignore") && !sender.hasPermission("BungeeMSG.bypass.*")){
			if(!StorageManager.ignored.containsKey(receiver.getUniqueId())){
				Start.loadPlayerData(receiver);
			}
			if(!StorageManager.ignored.containsKey(sender.getUniqueId())){
				Start.loadPlayerData(sender);
			}
			
			if(StorageManager.ignored.get(sender.getUniqueId()).contains(receiver.getUniqueId())){
				ignored = true;
				Start.sendMessageNullCheck(sender, receiver, TitleManager.importTitle(sender, StorageManager.isignored.replace("&", "§").replace("%receiver%", receiver.getName())));
			}
			else{
				if(StorageManager.ignored.get(receiver.getUniqueId()).contains(sender.getUniqueId())){
					ignored = true;
					
					if(StorageManager.tellsenderifignored == true){
						String tosend = StorageManager.ignoredmessage.replace("&", "§").replace("%receiver%", receiver.getName());					
						Start.sendMessageNullCheck(sender, receiver, TitleManager.importTitle(sender, tosend));
					}
					else{
						Start.sendMessageNullCheck(sender, receiver, TitleManager.importTitle(sender, message));
					}
					
					if(StorageManager.uselog == true && StorageManager.readignores == true){
						LogManager.getLog().info("[IGNORED] " + sender.getName() + " > " + receiver.getName() + ": " + message);
					}
				}
			}
		}
		
		return ignored;
	}
	
	public static List<ProxiedPlayer> getPlayersNotIgnored(ProxiedPlayer sender, Collection<ProxiedPlayer> collection){
		if(!StorageManager.ignored.containsKey(sender.getUniqueId())){
			Start.loadPlayerData(sender);
		}
		
		List<ProxiedPlayer> list = new ArrayList<ProxiedPlayer>();
		for(ProxiedPlayer player : collection){
			list.add(player);
		}
		
		if(!sender.hasPermission("BungeeMSG.bypass.ignore") && !sender.hasPermission("BungeeMSG.bypass.*")){
			for(ProxiedPlayer player : collection){
				if(!StorageManager.ignored.containsKey(player.getUniqueId())){
					Start.loadPlayerData(player);
				}
				if(StorageManager.ignored.get(sender.getUniqueId()).contains(player.getUniqueId()) || StorageManager.ignored.get(player.getUniqueId()).contains(sender.getUniqueId())){
					list.remove(player);
				}
			}
		}
		
		return list;
	}
}
