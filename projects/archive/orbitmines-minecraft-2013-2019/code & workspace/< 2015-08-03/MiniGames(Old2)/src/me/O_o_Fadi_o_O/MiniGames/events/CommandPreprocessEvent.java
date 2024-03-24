package me.O_o_Fadi_o_O.MiniGames.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandPreprocessEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			
			String s = e.getMessage().split(" ") [0];
			
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(s);
			
			if(topic == null){
				
				p.sendMessage("§f§lMiniGames §8| §7Unknown Command: §f" + s + "§7. Use §f/help§7 for Help!");
				e.setCancelled(true);
			}
			
		    String[] args = e.getMessage().split(" ");
		    if(args[0].equalsIgnoreCase("/vote")){
		    	e.setCancelled(true);
		    	
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §f§lMiniGames§7 Server:");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §f§l50 MiniGame Coins");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    }
		}
	}
}
