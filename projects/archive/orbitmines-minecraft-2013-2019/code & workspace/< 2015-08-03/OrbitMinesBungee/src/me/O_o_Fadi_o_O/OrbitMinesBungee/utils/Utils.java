package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungee.NameFetcher;
import me.O_o_Fadi_o_O.OrbitMinesBungee.UUIDFetcher;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;


public class Utils {
	
	public static UUID getUUID(String playername){
		UUIDFetcher uuidf = new UUIDFetcher(Arrays.asList(playername));
		try{
			return uuidf.call().get(playername);
		}catch(Exception ex){
			return null;
		}
	}
	public static String getName(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			String name = namef.call().get(uuid).get(namef.call().get(uuid).size() -1);
			String[] nameparts = name.split(" ");
			return nameparts[0];
		}catch(Exception ex){
			return null;
		}
	}
	public static String getNameDate(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			String name = namef.call().get(uuid).get(namef.call().get(uuid).size() -1);
			String[] nameparts = name.split(" ", 1);
			return nameparts[1];
		}catch(Exception ex){
			return null;
		}
	}
	public static HashMap<String, String> getNames(UUID uuid){
		NameFetcher namef = new NameFetcher(uuid);
		try{
			HashMap<String, String> names = new HashMap<String, String>();
			for(String name : namef.call().get(uuid)){
				String[] nameparts = name.split(" ", 1);
				if(nameparts.length > 1){
					names.put(nameparts[0], nameparts[1]);
				}
				else{
					names.put(nameparts[0], null);
				}
			}
			
			return names;
		}catch(Exception ex){
			return null;
		}
	}

	public static List<UUID> getUUIDList(List<String> uuidstringlist){
		List<UUID> uuids = new ArrayList<UUID>();
		for(String uuid : uuidstringlist){
			uuids.add(UUID.fromString(uuid));
		}
		return uuids;
	}
	public static List<String> getStringList(List<UUID> uuidlist){
		List<String> uuids = new ArrayList<String>();
		for(UUID uuid : uuidlist){
			uuids.add(uuid.toString());
		}
		return uuids;
	}
	
	public static ProxiedPlayer getPlayer(String playername){
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(player.getName().equalsIgnoreCase(playername)){
				return player;
			}
		}
		return null;
	}
	public static ProxiedPlayer getPlayer(UUID uuid){
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(player.getUniqueId().toString().equals(uuid.toString())){
				return player;
			}
		}
		return null;
	}
	
	public static String statusString(boolean bl){
		if(bl == true){
			return "§a§lENABLED";
		}
		return "§c§lDISABLED";
	}
	
	public enum VIPRank {

		User,
		Iron_VIP,
		Gold_VIP,
		Diamond_VIP,
		Emerald_VIP;
		
		public int getMonthlyBonus(){
				switch(this){
				case Diamond_VIP:
					return 1250;
				case Emerald_VIP:
					return 2500;
				case Gold_VIP:
					return 500;
				case Iron_VIP:
					return 250;
				default:
					return 0;
			}
		}
		
		public String getChatPrefix(){
			switch(this){
				case Diamond_VIP:
					return "§9§lDiamond §9";
				case Emerald_VIP:
					return "§a§lEmerald §a";
				case Gold_VIP:
					return "§6§lGold §6";
				case Iron_VIP:
					return "§7§lIron §7";
				default:
					return "§8";
			}
		}
		
		public String getColor(){
			switch(this){
				case Diamond_VIP:
					return "§9";
				case Emerald_VIP:
					return "§a";
				case Gold_VIP:
					return "§6";
				case Iron_VIP:
					return "§7";
				default:
					return "§f";
			}
		}
		
		public String getScoreboardPrefix(){
			switch(this){
				case Diamond_VIP:
					return "§9§lDiamond §f";
				case Emerald_VIP:
					return "§a§lEmerald §f";
				case Gold_VIP:
					return "§6§lGold §f";
				case Iron_VIP:
					return "§7§lIron §f";
				default:
					return "§f";
			}
		}
		
		public String getRankString(){
			switch(this){
				case Diamond_VIP:
					return "§9§lDiamond";
				case Emerald_VIP:
					return "§a§lEmerald";
				case Gold_VIP:
					return "§6§lGold";
				case Iron_VIP:
					return "§7§lIron";
				default:
					return "§fNo Rank";
			}
		}
	}

	public enum StaffRank {

		User,
		Builder,
		Moderator,
		Owner;
		
		public String getChatPrefix(){
			switch(this){
				case Builder:
					return "§d§lBuilder §d";
				case Moderator:
					return "§b§lMod §b";
				case Owner:
					return "§4§lOwner §4";
				case User:
					return "§8";
				default:
					return "§8";
			}
		}
		
		public String getColor(){
			switch(this){
				case Builder:
					return "§d";
				case Moderator:
					return "§b";
				case Owner:
					return "§4";
				case User:
					return "§8";
				default:
					return "§8";
			}
		}
		
		public String getScoreboardPrefix(){
			switch(this){
				case Builder:
					return "§d§lBuilder §f";
				case Moderator:
					return "§b§lMod §f";
				case Owner:
					return "§4§lOwner §f";
				case User:
					return "§8";
				default:
					return "§8";
			}
		}
		
		public String getRankString(){
			switch(this){
				case Builder:
					return "§d§lBuilder";
				case Moderator:
					return "§b§lModerator";
				case Owner:
					return "§4§lOwner";
				case User:
					return "§fNo Rank";
				default:
					return "§fNo Rank";
			}
		}
	}

	public enum Server {

		KITPVP, 
		PRISON, 
		CREATIVE, 
		HUB, 
		SURVIVAL, 
		SKYBLOCK, 
		MINIGAMES, 
		ALPHA;
		
		public int getMaxPlayers(){
			switch(this){
				case HUB:
					return 1000;
				default:
					return 100;
			}
		}
		
		public int getOnlinePlayers(){
			return ProxyServer.getInstance().getServerInfo(this.toString().toLowerCase()).getPlayers().size();
		}
		
		public String getIP(){
			switch(this){
				case ALPHA:
					return "77.111.240.219";
				case CREATIVE:
					return "77.111.200.65";
				case HUB:
					return "77.111.240.219";
				case KITPVP:
					return "77.111.248.172"; 
				case MINIGAMES:
					return "77.111.204.209";
				case PRISON:
					return "77.111.236.34";
				case SKYBLOCK:
					return "77.111.192.151";
				case SURVIVAL:
					return "77.111.206.117";
				default:
					return null;
			}
		}
		
		public String getName(){
			switch(this){
				case ALPHA:
					return "§e§lAlpha";
				case CREATIVE:
					return "§d§lCreative";
				case HUB:
					return "§3§lHub";
				case KITPVP:
					return "§c§lKitPvP";
				case MINIGAMES:
					return "§f§lMiniGames";
				case PRISON:
					return "§4§lPrison";
				case SKYBLOCK:
					return "§5§lSkyBlock";
				case SURVIVAL:
					return "§a§lSurvival";
				default:
					return null;
			}
		}
		
		public String getNameWithoutColor(){
			switch(this){
				case ALPHA:
					return "Alpha";
				case CREATIVE:
					return "Creative";
				case HUB:
					return "Hub";
				case KITPVP:
					return "KitPvP";
				case MINIGAMES:
					return "MiniGames";
				case PRISON:
					return "Prison";
				case SKYBLOCK:
					return "SkyBlock";
				case SURVIVAL:
					return "Survival";
				default:
					return null;
			}
		}
		
		public String getVersion(){
			return "1.8";
		}
		
		public String getColor(){
			switch(this){
				case ALPHA:
					return "§e";
				case CREATIVE:
					return "§d";
				case HUB:
					return "§3";
				case KITPVP:
					return "§c";
				case MINIGAMES:
					return "§f";
				case PRISON:
					return "§4";
				case SKYBLOCK:
					return "§5";
				case SURVIVAL:
					return "§a";
				default:
					return null;
			}
		}
		
		public static Server getServer(String servername){
			return Server.valueOf(servername.toUpperCase());
		}
	}
	
	public enum Cooldown {
		
		REPORT;
		
		public int getCooldown(){
			switch(this){
				case REPORT:
					return 1800 * 1000;
				default:
					return 0;
			}
		}
	}
	
	public static class ComponentMessage {
		
		private List<TextComponent> tcs;
		
		public ComponentMessage(){
			tcs = new ArrayList<TextComponent>();
		}
		
		public void addPart(String part, ClickEvent.Action clickaction, String clickevent, HoverEvent.Action hoveraction, String hoverevent){
			TextComponent tc = new TextComponent(part);
			if(clickaction != null){
				tc.setClickEvent(new ClickEvent(clickaction, clickevent));
			}
			if(hoveraction != null){
				tc.setHoverEvent(new HoverEvent(hoveraction, new ComponentBuilder(hoverevent).create()));
			}
			
			tcs.add(tc);
		}
		
		public void send(ProxiedPlayer... players){
			TextComponent[] tcs = new TextComponent[this.tcs.size()];
			int index = 0;
			for(TextComponent tc : this.tcs){
				tcs[index] = tc;
				index++;
			}
			
			TextComponent tc = new TextComponent(tcs);
			for(ProxiedPlayer player : players){
				player.sendMessage(tc);
			}
		}
	}
}