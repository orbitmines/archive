package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;

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
			String game = "";
			if(StorageManager.playersgame.containsKey(p)){
				if(StorageManager.playersgame.get(p) == Game.SURVIVALGAMES){
					game = "§6SG" + StorageManager.playersarena.get(p) + " §8| ";
					if(StorageManager.spectatorsinsurvivalgames.contains(p)){
						game = game + "§7Dead ";
					}
				}
				if(StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){
					game = "§fCF" + StorageManager.playersarena.get(p) + " §8| ";
					if(StorageManager.spectatorsinchickenfight.contains(p)){
						game = game + "§7Dead ";
					}
				}
			}
			else{
				game = "§fLobby §8| ";
			}
			
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
				e.setFormat(game + PlayerManager.getPlayerDisplayname(p).replaceAll(p.getName(), "*" + StorageManager.nickname.get(p) + color + "*") + "§7 » §" + StorageManager.chatcolor.get(p) + bold + cursive + "%2$s");
			}
			else{
				e.setFormat(game + PlayerManager.getPlayerDisplayname(p) + "§7 » §" + StorageManager.chatcolor.get(p) + bold + cursive + "%2$s");
			}
		}
		else{
			e.setCancelled(true);
			PlayerManager.warnPlayerNotLoaded(p);
		}
	}
}
