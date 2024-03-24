package me.O_o_Fadi_o_O.OrbitMines.managers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

import me.O_o_Fadi_o_O.OrbitMines.Start;
import me.O_o_Fadi_o_O.OrbitMines.utils.OMPlayer;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMines.utils.ServerData.ServerStorage;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.GameState;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.MiniGameType;
import me.O_o_Fadi_o_O.OrbitMines.utils.Utils.Server;
import me.O_o_Fadi_o_O.OrbitMines.utils.hub.MGArena;
import me.O_o_Fadi_o_O.OrbitMines.utils.minigames.Arena;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

public class BungeeManager implements PluginMessageListener {
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message){
		if(!channel.equals("BungeeCord") && !channel.equals(ServerData.getServer().toString())){
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
						ServerStorage.onlineplayers.put(Server.valueOf(server.toUpperCase()), onlineplayers);
					} 
					else{
						ServerStorage.onlineplayers.put(Server.valueOf(server.toUpperCase()), -1);
					}
				}
			}
			else if(ServerData.isServer(Server.HUB)){
				MiniGameType type = MiniGameType.fromShortName(subChannel);
				
				if(type != null){
					String[] data = in.readUTF().split("\\|");
					int arenaid = Integer.parseInt(data[0]);
					GameState state = GameState.valueOf(data[1]);
					int players = Integer.parseInt(data[2]);
					int minutes = Integer.parseInt(data[3]);
					int seconds = Integer.parseInt(data[4]);
					
					MGArena arena = MGArena.getMGArena(type, arenaid);
					arena.setState(state);
					arena.setPlayers(players);
					arena.setMinutes(minutes);
					arena.setSeconds(seconds);
					arena.setLastResponse(0);
				}
				else if(subChannel.equals("MGArea")){
					final String playername = in.readUTF();
					
					new BukkitRunnable(){
						public void run(){
							Player p = Utils.getPlayer(playername);
							
							if(p != null){
								OMPlayer omp = OMPlayer.getOMPlayer(p);
								omp.toMiniGameArea();
							}
						}
					}.runTaskLater(Start.getInstance(), 40);
				}
				else{}
			}
			else if(ServerData.isServer(Server.MINIGAMES)){
				MiniGameType type = MiniGameType.fromShortName(subChannel);
				
				if(type != null){
					String[] data = in.readUTF().split("\\|");
					int arenaid = Integer.parseInt(data[0]);
					final String playername = data[1];
					
					Arena arena = Arena.getArena(type, arenaid);
					ServerData.getMiniGames().getPlayersToJoin().put(playername, arena);
					
					new BukkitRunnable(){
						public void run(){
							ServerData.getMiniGames().getPlayersToJoin().remove(playername);
						}
					}.runTaskLater(Start.getInstance(), 1200);
				}
			}
			else{}
		}catch(EOFException e){
		}catch(IOException e){e.printStackTrace();}
	}
}
