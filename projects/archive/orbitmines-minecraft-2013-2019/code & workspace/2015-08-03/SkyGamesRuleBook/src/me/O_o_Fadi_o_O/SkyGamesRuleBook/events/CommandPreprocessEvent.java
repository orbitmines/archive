package me.O_o_Fadi_o_O.SkyGamesRuleBook.events;

import me.O_o_Fadi_o_O.SkyGamesRuleBook.Start;
import me.O_o_Fadi_o_O.SkyGamesRuleBook.managers.ConfigManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreprocessEvent implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String[] a = e.getMessage().split(" ");
		
		if(a[0].equalsIgnoreCase("/book") && p.hasPermission("RuleBook.reload")){
			e.setCancelled(true);
			
			if(a.length == 2 && a[1].equalsIgnoreCase("reload")){
				p.sendMessage("§7Reloading §6config.yml§7...");
				ConfigManager.reloadConfig();
				Start.getInstance().registerRuleBook();
				p.sendMessage("§7Reload §acompleted§7!");
			}
			else{
				p.sendMessage("");
				p.sendMessage("§c§lRuleBook §7- §6SkyGames");
				p.sendMessage(" §6/book reload §7- Reload the config.yml");
			}
		}
	}
}
