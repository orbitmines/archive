package me.O_o_Fadi_o_O.BungeeMSG.managers;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MuteManager {

	public static boolean isMuted(ProxiedPlayer p){
		if(p.hasPermission("BungeeMSG.bypass.mute") || p.hasPermission("BungeeMSG.bypass.*") || !StorageManager.mute.contains(p.getUniqueId()) && StorageManager.allplayersmuted == false && !StorageManager.mutedservers.contains(p.getServer().getInfo())){
			return false;
		}
		return true;
	}
}
