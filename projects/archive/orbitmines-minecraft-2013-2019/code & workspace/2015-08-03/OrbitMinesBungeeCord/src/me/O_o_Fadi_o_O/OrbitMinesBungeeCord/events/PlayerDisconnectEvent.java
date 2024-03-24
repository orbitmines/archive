package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events;

import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.DatabaseManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers.FriendManager;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.StaffRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDisconnect(ServerDisconnectEvent e){
		ProxiedPlayer p = e.getPlayer();
		
		UUID uuid = p.getUniqueId();
		
		if(p.getServer().getInfo() == e.getTarget()){
			if(FriendManager.playerfriends.containsKey(uuid)){
				List<UUID> friends = FriendManager.playerfriends.get(uuid);
				for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
					if(friends.contains(player.getUniqueId())){
						if(!Start.silent.containsKey(uuid) || Start.silent.containsKey(uuid) && Start.silent.get(uuid) == false){
							player.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 left.");
						}
						else{
							if(Start.hasStaffPerms(player, StaffRank.Moderator)){
								player.sendMessage("§2§lFriends §8| §2" + p.getName() + "§7 left. §6§l[Silent Mode]");
							}
						}
					}
				}
			}	
		}
		
		ServerInfo connectedto = Start.connectedto.get(uuid);
		if(!Start.silent.containsKey(uuid) || Start.silent.containsKey(uuid) && Start.silent.get(uuid) == false){
			for(ProxiedPlayer player : connectedto.getPlayers()){
				player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§o" + Start.getServerNameWithoutColor(connectedto.getName()) + "§4§o)");
			}
		}
		else{
			for(ProxiedPlayer player : connectedto.getPlayers()){
				if(Start.hasStaffPerms(player, StaffRank.Moderator)){
					player.sendMessage("§4§l§o<< " + p.getName() + " §4§o(§c§o" + Start.getServerNameWithoutColor(connectedto.getName()) + "§4§o) §6§l[Silent Mode]");
				}
			}
		}
		
		DatabaseManager.setLastOnline(p);
	}
}
