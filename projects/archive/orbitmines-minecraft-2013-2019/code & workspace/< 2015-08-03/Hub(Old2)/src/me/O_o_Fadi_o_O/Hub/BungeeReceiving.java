package me.O_o_Fadi_o_O.Hub;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

import me.O_o_Fadi_o_O.Hub.managers.StorageManager;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeReceiving implements PluginMessageListener {

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord") && !channel.equals(Hub.Server + "Bungee")) {
            return;
        }
		
		 DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		 
		 try{
			 String subChannel = in.readUTF();			 
			 
			 if(subChannel.equals("PlayerCount")) {
				 
				 String server = in.readUTF();
				 
				 if(in.available() > 0){
					 int amount = in.readInt();
					 StorageManager.ServerOnlinePlayers.put(server, amount);
				 } 
				 else{
					 if(StorageManager.ServerOnlinePlayers.containsKey(server)){
						 StorageManager.ServerOnlinePlayers.remove(server);
					 }
				 }
			 }
		 
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
