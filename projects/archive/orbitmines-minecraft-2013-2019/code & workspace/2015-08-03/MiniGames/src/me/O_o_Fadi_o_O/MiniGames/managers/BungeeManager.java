package me.O_o_Fadi_o_O.MiniGames.managers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.utils.Server;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeManager implements PluginMessageListener {

	Start start = Start.getInstance();
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message){
		if(!channel.equals("BungeeCord") && !channel.equals(StorageManager.thisserver.toString() + "Bungee")){
            return;
        }
		
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		 
		try{
			String subChannel = in.readUTF();			 
			 
			if(subChannel.equals("PlayerCount")){
				 
				String server = in.readUTF();
				
				if(!server.equalsIgnoreCase("all")){
					if(in.available() > 0){
						int onlineplayers = in.readInt();
						StorageManager.onlineplayers.put(Server.valueOf(server.toUpperCase()), onlineplayers);
					} 
					else{
						StorageManager.onlineplayers.put(Server.valueOf(server.toUpperCase()), -1);
					}
				}
			}
		}catch(EOFException e){
		}catch(IOException e){e.printStackTrace();}
	}
}
