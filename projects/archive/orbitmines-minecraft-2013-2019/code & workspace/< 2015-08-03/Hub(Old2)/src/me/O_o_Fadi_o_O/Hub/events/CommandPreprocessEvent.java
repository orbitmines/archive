package me.O_o_Fadi_o_O.Hub.events;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreprocessEvent implements Listener{

	Hub plugin;
	 
	public CommandPreprocessEvent(Hub instance) {
	plugin = instance;
	}
	
	public int i = 0;
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreCommand(PlayerCommandPreprocessEvent e){
	    String[] args = e.getMessage().split(" ");
	    if(args[0].equalsIgnoreCase("/help")){
	    	e.setCancelled(true);
	    	
	    	Player p = e.getPlayer();
	    	
	    	p.sendMessage("");
			p.sendMessage("§6§lOrbitMines§3§lHub §e§lPlayer Commands:");
			p.sendMessage(" §7- §6/vote §7(Show §bVote§7 Info)");
			p.sendMessage(" §7- §6/votes §7(Show your §bVotes§7)");
			p.sendMessage(" §7- §6/topvoters §7(Show the §bTop 5 Voters§7)");
			p.sendMessage(" §7- §6/perks §7(Open the §9Cosmetic Perks§7)");
			p.sendMessage(" §7- §6/servers §7(Open the §3Server Selector§7)");
			p.sendMessage(" §7- §6/omt §7(Show your §eOrbitMines Tokens§7)");
			p.sendMessage(" §7- §6/vippoints §7(Show your §bVIP Points§7)");
	    }
	    if(args[0].equalsIgnoreCase("/vote")){
	    	e.setCancelled(true);
	    
	    	Player p = e.getPlayer();
	    	
			p.sendMessage("");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §3§lHub§7 Server:");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
			p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
			p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
	    	
	    }
	}
}
