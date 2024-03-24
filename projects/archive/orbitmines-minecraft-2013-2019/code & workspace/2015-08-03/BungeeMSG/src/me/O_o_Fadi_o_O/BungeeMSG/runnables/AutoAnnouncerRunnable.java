package me.O_o_Fadi_o_O.BungeeMSG.runnables;

import java.util.List;

import me.O_o_Fadi_o_O.BungeeMSG.Start;
import me.O_o_Fadi_o_O.BungeeMSG.managers.StorageManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.TitleManager;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class AutoAnnouncerRunnable implements Runnable {

	@Override
	public void run(){
		if(StorageManager.autoannouncedelay.size() > 0){
			for(String announcer : StorageManager.autoannouncedelay.keySet()){
				int delay = StorageManager.autoannouncedelay.get(announcer);
				
				int time = StorageManager.autoannouncelastmessagetime.get(announcer) +1;
				
				if(time > delay){
					int index = StorageManager.autoannouncelastmessage.get(announcer) +1;
					
					List<List<String>> messageslist = StorageManager.autoannouncemessages.get(announcer);
					if(index >= messageslist.size()){
						index = 0;
					}
					
					List<String> messages = messageslist.get(index);
					
					for(ServerInfo info : StorageManager.autoannounceservers.get(announcer)){
						for(ProxiedPlayer player : info.getPlayers()){
							for(String message : messages){
								Start.sendMessageNullCheck(player, null, TitleManager.importTitle(player, message.replace("&", "§").replace("%receiver%", player.getName()).replace("%server-receiver%", StorageManager.servernames.get(player.getServer().getInfo()).replace("&", "§"))));
							}
						}
					}
					
					StorageManager.autoannouncelastmessage.put(announcer, index);
					StorageManager.autoannouncelastmessagetime.put(announcer, 0);
				}
				else{
					StorageManager.autoannouncelastmessagetime.put(announcer, time);
				}
			}
		}
	}
}
