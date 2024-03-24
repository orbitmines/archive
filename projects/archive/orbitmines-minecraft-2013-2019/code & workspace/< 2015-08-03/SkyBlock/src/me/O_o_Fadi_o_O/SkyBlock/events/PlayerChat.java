package me.O_o_Fadi_o_O.SkyBlock.events;

import me.O_o_Fadi_o_O.SkyBlock.Start;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{

	Start start = Start.getInstance();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
			}
			else{
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
			}
			StorageManager.afk.remove(p);
		}
		
		if(StorageManager.loaded.get(p) == true){
			
			String bold = "";
			if(StorageManager.boldchatcolor.containsKey(p) && StorageManager.boldchatcolor.get(p) == true){
				bold = "§l";
			}
			
			String cursive = "";
			if(StorageManager.cursivechatcolor.containsKey(p) && StorageManager.cursivechatcolor.get(p) == true){
				cursive = "§o";
			}
			if(StorageManager.nickname.containsKey(p)){
				String color = PlayerManager.getPlayerDisplayname(p).substring(0, 2);
				e.setFormat(PlayerManager.getPlayerDisplayname(p).replaceAll(p.getName(), "*" + StorageManager.nickname.get(p) + color + "*") + "§7 » §" + StorageManager.chatcolor.get(p) + bold + cursive + "%2$s");
			}
			else{
				e.setFormat(PlayerManager.getPlayerDisplayname(p) + "§7 » §" + StorageManager.chatcolor.get(p) + bold + cursive + "%2$s");
			}
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
