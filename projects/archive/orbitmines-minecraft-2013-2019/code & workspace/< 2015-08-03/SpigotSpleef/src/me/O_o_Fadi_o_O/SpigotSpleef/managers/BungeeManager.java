package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefStatus;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeManager implements PluginMessageListener {
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message){
		if(!channel.equals("BungeeCord") && !channel.equals("SpigotSpleef")){
            return;
        }
		
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		 
		try{
			String subchannel = in.readUTF();
			
			if(StorageManager.bungeecord == true && StorageManager.ishubserver == true && subchannel.equals("SpigotSpleef")){		 
				 
				String arenadata = in.readUTF();
				
				try{
					String[] data = arenadata.split("\\|");
					
					String server = data[0];
					int arenaid = Integer.parseInt(data[1]);
					int minplayers = Integer.parseInt(data[2]);
					int maxplayers = Integer.parseInt(data[3]);
					String mapname = data[4];
					int players = Integer.parseInt(data[5]);
					int spectators = Integer.parseInt(data[6]);
					SpleefStatus status = SpleefStatus.valueOf(data[7]);
					int minutes = Integer.parseInt(data[8]);
					int seconds = Integer.parseInt(data[9]);
					
					BungeeArena arena = new BungeeArena(server, arenaid, minplayers, maxplayers, mapname, players, spectators, status, minutes, seconds);
					
					BungeeArena oldarena = BungeeArena.getArenaFromID(arenaid);
					if(oldarena != null){
						List<BungeeArena> arenas = StorageManager.bungeearenas;
						arenas.remove(oldarena);
						StorageManager.bungeearenas = arenas;
					}
					
					List<BungeeArena> arenas = StorageManager.bungeearenas;
					arenas.add(arena);
					StorageManager.bungeearenas = arenas;
					
				}catch(NumberFormatException ex){
				}catch(IllegalArgumentException ex){ex.printStackTrace();}
			}
		}catch(EOFException e){
		}catch(IOException e){e.printStackTrace();}
	}
}
