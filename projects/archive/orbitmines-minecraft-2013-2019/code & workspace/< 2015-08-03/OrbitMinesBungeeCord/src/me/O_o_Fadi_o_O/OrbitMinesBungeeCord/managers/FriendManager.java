package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.managers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.Start;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.VIPRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class FriendManager {

	public static HashMap<UUID, List<UUID>> playerfriends = new HashMap<UUID, List<UUID>>();
	
	@SuppressWarnings("deprecation")
	public static void sendFriendMessage(ProxiedPlayer p){
		
		//TextComponent m = new TextComponent("§3§lServer TP");
		//m.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server minigames"));
		//m.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§fConnect to §f§lMiniGames").create()));
		//p.sendMessage(m);
		
		UUID uuid = p.getUniqueId();
	
		if(playerfriends.containsKey(uuid)){
			p.sendMessage("§a§m----------------------------------------");
			p.sendMessage(" §6§lOrbitMines§2§lFriends §7- §a§l" + p.getName());
			p.sendMessage("");
			for(UUID friendUUID : playerfriends.get(uuid)){
				String player = Utils.getName(friendUUID);
				if(isOnline(player)){
					
					TextComponent pl = new TextComponent(" §2" + player + "§7 - ");
					TextComponent remove = new TextComponent("§c§lRemove Friend");
					remove.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends remove " + player));
					remove.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cRemove " + player).create()));
					TextComponent server = new TextComponent(" §7- " + Start.getServer(player));
					server.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server " + ProxyServer.getInstance().getPlayer(player).getServer().getInfo().getName()));
					server.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§3Connect to " + Start.getServer(player)).create()));
					
					p.sendMessage(pl, remove, server);
				}
				else{
					
					TextComponent pl = new TextComponent(" §2" + player + "§7 - ");
					TextComponent remove = new TextComponent("§c§lRemove Friend");
					remove.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends remove " + player));
					remove.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cRemove " + player).create()));
					TextComponent server = new TextComponent(" §7- §4§lOffline");
					if(Start.lastonline.containsKey(friendUUID)){
						if(Start.lastonline.get(friendUUID) == null){
							server.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Offline since:\n §cUnknown").create()));
						}
						else{
							server.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Offline since:\n §c" + Start.lastonline.get(friendUUID) + " (" + Calendar.getInstance().getTimeZone().getDisplayName() + ")").create()));	
						}
					}
					else if(DatabaseManager.containsPath("uuid", "PlayerLastOnline", friendUUID.toString())){
						Start.lastonline.put(friendUUID, DatabaseManager.getString(friendUUID, "PlayerLastOnline", "date"));
						server.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Offline since:\n §c" + Start.lastonline.get(friendUUID) + " (" + Calendar.getInstance().getTimeZone().getDisplayName() + ")").create()));
					}
					else{
						Start.lastonline.put(friendUUID, null);
						server.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Offline since:\n §cUnknown").create()));
					}
					
					p.sendMessage(pl, remove, server);
				}
			}
			p.sendMessage("");
			p.sendMessage(" §7Friends: §a" + playerfriends.get(uuid).size() + "§7/§a" + getAmountFriendsAllowed(p));
			p.sendMessage("§a§m----------------------------------------");
		}
		else{
			p.sendMessage("§a§m----------------------------------------");
			p.sendMessage(" §6§lOrbitMines§2§lFriends §7- §a§l" + p.getName());
			p.sendMessage("");
			p.sendMessage(" §7Add Friends! §2/friend <player>§7.");
			p.sendMessage("");
			p.sendMessage(" §7Friends: §a0§7/§a" + getAmountFriendsAllowed(p));
			p.sendMessage("§a§m----------------------------------------");
		}
	}
	
	public static boolean isOnline(String p){
		
		boolean online = false;
		
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(p.equalsIgnoreCase(player.getName())){
				online = true;
			}
		}
		
		return online;
	}
	
	public static int getAmountFriendsAllowed(ProxiedPlayer p){
		
		int i = 5;
		
		if(Start.hasVIPPerms(p, VIPRank.Iron_VIP)){i = 10;}
		if(Start.hasVIPPerms(p, VIPRank.Gold_VIP)){i = 15;}
		if(Start.hasVIPPerms(p, VIPRank.Diamond_VIP)){i = 20;}
		if(Start.hasVIPPerms(p, VIPRank.Emerald_VIP)){i = 25;}
		
		return i;
	}
}
