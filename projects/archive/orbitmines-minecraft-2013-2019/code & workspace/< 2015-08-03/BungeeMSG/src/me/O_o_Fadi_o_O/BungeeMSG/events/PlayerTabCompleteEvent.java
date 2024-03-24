package me.O_o_Fadi_o_O.BungeeMSG.events;

import me.O_o_Fadi_o_O.BungeeMSG.managers.StorageManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerTabCompleteEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onTab(TabCompleteEvent  e){
        if(!e.getSuggestions().isEmpty()){
            return;
        }
        String[] a = e.getCursor().split(" ");

	    try{
	        if(StorageManager.messagecommand.contains(a[0].toLowerCase()) || StorageManager.replycommand.contains(a[0].toLowerCase()) || StorageManager.togglecommand.contains(a[0].toLowerCase()) || StorageManager.mutecommand.contains(a[0].toLowerCase()) || StorageManager.globalcommand.contains(a[0].toLowerCase()) || StorageManager.ignorecommand.contains(a[0].toLowerCase()) || StorageManager.reportcommand.contains(a[0].toLowerCase()) || StorageManager.helpopcommand.contains(a[0].toLowerCase())){
		        if(a.length > 1){
		        	final String checked = (a.length > 0 ? a[a.length - 1] : e.getCursor()).toLowerCase();
			        for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			            if(player.getName().toLowerCase().startsWith(checked)){
			                e.getSuggestions().add(player.getName());
			            }
			        }
		        }
		        else{
		        	if(e.getCursor().substring(a[0].length()).startsWith(" ")){
		        		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			        		e.getSuggestions().add(player.getName());
			        	}
		        	}
		        }
	        }
	        
	        if(StorageManager.muteallcommand.contains(a[0].toLowerCase())){
		        if(a.length > 1){
		        	final String checked = (a.length > 0 ? a[a.length - 1] : e.getCursor()).toLowerCase();
			        for(ServerInfo server : ProxyServer.getInstance().getServers().values()){
			            if(server.getName().toLowerCase().startsWith(checked)){
			                e.getSuggestions().add(server.getName());
			            }
			        }
		        }
		        else{
		        	if(e.getCursor().substring(a[0].length()).startsWith(" ")){
				        for(ServerInfo server : ProxyServer.getInstance().getServers().values()){
			                e.getSuggestions().add(server.getName());
			        	}
		        	}
		        }
	        }
        }catch(ArrayIndexOutOfBoundsException ex){
        	
        }
	    
        if(e.getSender() instanceof ProxiedPlayer){ 
        	ProxiedPlayer p = (ProxiedPlayer) e.getSender();
        	/*
        	 * Channels
        	 */
			String ch = "";
			
			if(!StorageManager.toggle.containsKey(p.getName()) || StorageManager.toggle.get(p.getName()) == true){
				for(String channel : StorageManager.channelstartingsymbols.keySet()){
					if(p.hasPermission(StorageManager.channelpermissions.get(channel))){
						for(String symbol : StorageManager.channelstartingsymbols.get(channel)){
							if(e.getCursor().toLowerCase().startsWith(symbol.toLowerCase())){
								ch = channel;
							}
						}
					}
				}
			}
			
			if(!ch.equals("")){
		        if(a.length > 1){
		        	final String checked = (a.length > 0 ? a[a.length - 1] : e.getCursor()).toLowerCase();
			        for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			            if(player.getName().toLowerCase().startsWith(checked)){
			                e.getSuggestions().add(player.getName());
			            }
			        }
		        }
		        else{
		        	if(e.getCursor().substring(a[0].length()).startsWith(" ")){
		        		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			        		e.getSuggestions().add(player.getName());
			        	}
		        	}
		        }
			}
			
			/*
			 * Broadcast
			 */
			String bc = "";
			
			for(String broadcast : StorageManager.broadcastcommands.keySet()){
				if(p.hasPermission(StorageManager.broadcastpermissions.get(broadcast))){
					for(String command : StorageManager.broadcastcommands.get(broadcast)){
						if(e.getCursor().toLowerCase().startsWith(command.toLowerCase())){
							bc = broadcast;
						}
					}
				}
			}
			
			if(!bc.equals("")){
		        if(a.length > 1){
		        	final String bcecked = (a.length > 0 ? a[a.length - 1] : e.getCursor()).toLowerCase();
			        for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			            if(player.getName().toLowerCase().startsWith(bcecked)){
			                e.getSuggestions().add(player.getName());
			            }
			        }
		        }
		        else{
		        	if(e.getCursor().substring(a[0].length()).startsWith(" ")){
		        		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			        		e.getSuggestions().add(player.getName());
			        	}
		        	}
		        }
			}
        }
	}
}
