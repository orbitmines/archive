package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.KitSelector;
import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandPreprocessEvent implements Listener {

	Start plugin;
	 
	public CommandPreprocessEvent(Start instance) {
		plugin = instance;
	}
	private KitSelector kitselector = new KitSelector(this.plugin);
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			
			String s = e.getMessage().split(" ") [0];
			
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(s);
			
			if(topic == null){
				
				p.sendMessage("§c§lKitPvP §8| §7Unknown Command: §c" + s + "§7. Use §c/kit§7!");
				e.setCancelled(true);
			}
			
		    String[] args = e.getMessage().split(" ");
		    if(args[0].equalsIgnoreCase("/vote")){
		    	e.setCancelled(true);
		    	
				p.sendMessage("");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §c§lKitPvP§7 Server:");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §6§l500 Coins");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
		    }
		    if(args[0].equalsIgnoreCase("/kit")){
		    	e.setCancelled(true);
		    	
		    	if(PlayerManager.isLoaded(p)){
		    		p.sendMessage(Start.TAG + "Opening the Kit Selector...");
					p.openInventory(kitselector.getKitSelector(p));
		    	}
		    	else{
		    		e.setCancelled(true);
		    		PlayerManager.warnPlayerNotLoaded(p);
		    	}
		    }
		}
	}
}
