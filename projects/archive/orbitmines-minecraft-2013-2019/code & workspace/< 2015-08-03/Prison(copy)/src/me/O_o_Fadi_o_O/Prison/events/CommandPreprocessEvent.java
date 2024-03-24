package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.DisguisePlayer;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Prison.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.VoteManager;
import me.O_o_Fadi_o_O.Prison.utils.StaffRank;
import me.O_o_Fadi_o_O.Prison.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandPreprocessEvent implements Listener{

	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreCommand(PlayerCommandPreprocessEvent e){
		
		Player p = e.getPlayer();
	    String[] args = e.getMessage().split(" ");

		    if(args[0].equalsIgnoreCase("/gtickets") || args[0].equalsIgnoreCase("/gambletickets")){
		    	e.setCancelled(true);
	    		if(StorageManager.staffrank.get(p) == StaffRank.Moderator || StorageManager.staffrank.get(p) == StaffRank.Owner){
	    			p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.playergambletickets.get(p));
	    		}
	    		else{
	    			if(args.length == 1){
	    				p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.playergambletickets.get(p));
	    			}
	    			else if(args[1].equalsIgnoreCase("give")){
	    				if(args.length == 4){
	    					if(!args[3].contains("-") && !args[2].contains("+")){
		    					String playerString = args[2];
					    		Player givenPlayer = null;
					    		for(Player player : Bukkit.getOnlinePlayers()){
					    			if(player.getName().equalsIgnoreCase(playerString)){
					    				givenPlayer = player;
					    			}
					    		}
					    		
					    		if(givenPlayer != null){
					    			try{
					    				int amount = Integer.parseInt(args[3]);
					    				
					    				PlayerManager.giveGambleTickets(givenPlayer, amount);
					    				if(amount == 1){
					    					p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " §a" + amount + " Gamble Ticket§7!");
					    					givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you §a" + amount + " Gamble Ticket§7!");
					    				}
					    				else{
					    					p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " §a" + amount + " Gamble Tickets§7!");
						    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you §a" + amount + " Gamble Tickets§7!");
					    				}
					    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
					    				
					    			}catch(Exception ex){
					    				p.sendMessage("§4§lPrison §8| §6" + args[3] + "§7 isn't a correct number§7!");
					    			}
					    		}
					    		else{
					    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
					    		}
	    					}
	    					else{
	    						p.sendMessage("§4§lPrison §8| §7You can't use §6- §7and §6+ §7symbols!");
	    					}
	    				}
	    				else{
	    					p.sendMessage("§4§lPrison §8| §7Use §6/gtickets give <player> <amount>");
	    				}
	    			}
	    			else if(args[1].equalsIgnoreCase("view")){
	    				if(args.length == 3){
	    					String playerString = args[2];
				    		Player givenPlayer = null;
				    		for(Player player : Bukkit.getOnlinePlayers()){
				    			if(player.getName().equalsIgnoreCase(playerString)){
				    				givenPlayer = player;
				    			}
				    		}
				    		
				    		if(givenPlayer != null){
				    			if(StorageManager.money.get(givenPlayer) == 1){
				    				p.sendMessage("§4§lPrison §8| §6" + givenPlayer.getName() + "§7 has §a" + StorageManager.playergambletickets.get(givenPlayer) + " Gamble Ticket§7.");
				    			}
				    			else{
				    				p.sendMessage("§4§lPrison §8| §6" + givenPlayer.getName() + "§7 has §a" + StorageManager.playergambletickets.get(givenPlayer) + " Gamble Tickets§7.");
				    			}
				    		}
				    		else{
				    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
				    		}
	    				}
	    				else{
	    					p.sendMessage("§4§lPrison §8| §7Use §6/gtickets view <player>");
	    				}
	    			}
	    			else{
	    				p.sendMessage("§4§lPrison §8| §7Your §aGamble Tickets§7: §2§l" + StorageManager.playergambletickets.get(p));
	    			}
	    		}
		    }
		    if(args[0].equalsIgnoreCase("/rarechest")){
		    	e.setCancelled(true);
	    		if(StorageManager.staffrank.get(p) == StaffRank.Moderator || StorageManager.staffrank.get(p) == StaffRank.Owner){
	    			if(args.length == 1){
	    				p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
	    			}
	    			else if(args[1].equalsIgnoreCase("give")){
	    				if(args.length == 3){
	    					String playerString = args[2];
				    		Player givenPlayer = null;
				    		for(Player player : Bukkit.getOnlinePlayers()){
				    			if(player.getName().equalsIgnoreCase(playerString)){
				    				givenPlayer = player;
				    			}
				    		}
				    		
				    		if(givenPlayer != null){
				    			ItemStack item = new ItemStack(Material.CHEST, 1);
				    			ItemMeta meta = item.getItemMeta();
				    			meta.setDisplayName("§cRare Chest");
				    			item.setItemMeta(meta);
				    			givenPlayer.getInventory().addItem(item);
				    			
								p.sendMessage("§4§lPrison §8| §7You gave §6" + givenPlayer.getName() + " a §cRare Chest§7!");
			    				givenPlayer.sendMessage("§4§lPrison §8| §6" + p.getName() + "§7 gave you a §cRare Chest§7!");
			    				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
			    				givenPlayer.playSound(givenPlayer.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
				    		}
				    		else{
				    			p.sendMessage("§4§lPrison §8| §7Player §6" + playerString + "§7 isn't §aOnline§7!");
				    		}
	    				}
	    				else{
	    					p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
	    				}
	    			}
	    			else{
	    				p.sendMessage("§4§lPrison §8| §7Use §6/rarechest give <player>");
	    			}
	    		}
	    		else{
	    			p.sendMessage(Start.TAG + "§4§lDENIED§7! You have to be a §b§lModerator§7 to do this!");
	    		}
		    }
	}
}
