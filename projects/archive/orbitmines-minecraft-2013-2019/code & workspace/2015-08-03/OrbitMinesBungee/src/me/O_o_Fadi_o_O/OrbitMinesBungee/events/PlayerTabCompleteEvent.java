package me.O_o_Fadi_o_O.OrbitMinesBungee.events;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BungeePlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Command;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerTabCompleteEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onTab(TabCompleteEvent e){
        if(!e.getSuggestions().isEmpty()){
            return;
        }
        ProxiedPlayer p = (ProxiedPlayer) e.getSender();
        BungeePlayer bp = BungeePlayer.getBungeePlayer(p);
        String[] a = e.getCursor().split(" ");

	    try{
	    	List<String> commands = Command.getCommands(bp);
        	final String checked = (a.length > 0 ? a[a.length - 1] : e.getCursor()).toLowerCase();
        	
	        if(a.length == 1 && a[0].startsWith("/") && !e.getCursor().endsWith(" ")){
		        for(String command : commands){
		            if(command.startsWith(checked)){
		                e.getSuggestions().add(command);
		            }
		        }
	        }
	        
	        if(a[0].startsWith("/")){
	        	List<String> servercommands = Command.getServerCommands();
	        	List<String> bungeecommands = Command.getBungeeCommands();
	        	List<ProxiedPlayer> players = new ArrayList<ProxiedPlayer>();
	        	
		        for(String command : commands){
		            if(command.startsWith(checked)){
		                if(servercommands.contains(command)){
		                	players.addAll(ProxyServer.getInstance().getServerInfo(p.getServer().getInfo().getName().toString()).getPlayers());
		                }
		                else if(bungeecommands.contains(command)){
		                	players.addAll(ProxyServer.getInstance().getPlayers());
		                }
		                else{}
		            }
		        }
		        
		        if(players.size() > 0){
			        if(a.length > 1){
				        for(ProxiedPlayer player : players){
				            if(player.getName().toLowerCase().startsWith(checked)){
				                e.getSuggestions().add(player.getName());
				            }
				        }
			        }
			        else{
			        	if(e.getCursor().substring(a[0].length()).startsWith(" ")){
			        		for(ProxiedPlayer player : players){
				        		e.getSuggestions().add(player.getName());
				        	}
			        	}
			        }
		        }
	        }
	    }catch(ArrayIndexOutOfBoundsException ex){}
	}
}
