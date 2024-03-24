package me.O_o_Fadi_o_O.OrbitMinesBungeeCord;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events.PingEvent;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events.PlayerChatEvent;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events.PlayerConnectEvent;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.events.PlayerDisconnectEvent;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.passes.Passwords;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables.AnnouncementsRunnable;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables.LoginRunnable;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables.MOTDRunnable;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables.StaffAnnouncementsRunnable;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.ConnectionReplacement;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.StaffRank;
import me.O_o_Fadi_o_O.OrbitMinesBungeeCord.utils.VIPRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.netty.PipelineUtils;
import net.md_5.bungee.scheduler.BungeeScheduler;

public class Start extends Plugin {

	public static HashMap<UUID, UUID> playerfriendrequest = new HashMap<UUID, UUID>();
	public static HashMap<UUID, VIPRank> viprank = new HashMap<UUID, VIPRank>();
	public static HashMap<UUID, StaffRank> staffrank = new HashMap<UUID, StaffRank>();
	public static HashMap<UUID, UUID> lastmsg = new HashMap<UUID, UUID>();
	public static HashMap<UUID, Boolean> showstaffmessage = new HashMap<UUID, Boolean>();
	
	public static HashMap<UUID, Boolean> silent = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> allchat = new HashMap<UUID, Boolean>();
	
	public static boolean maintenancemode = false;
	
	public static List<String> bannedplayers = new ArrayList<String>();
	public static List<String> bannedips = new ArrayList<String>();
	public static HashMap<String, String> bannedby = new HashMap<String, String>();
	public static HashMap<String, String> bannedreason = new HashMap<String, String>();
	public static HashMap<String, String> bannedon = new HashMap<String, String>();
	public static HashMap<String, String> banneduntil = new HashMap<String, String>();
	
	public static HashMap<UUID, String> lastonline = new HashMap<UUID, String>();
	
	public static HashMap<String, String> staffpasswords = new HashMap<String, String>();
	public static HashMap<ProxiedPlayer, Boolean> stafflogin = new HashMap<ProxiedPlayer, Boolean>();
	public static HashMap<ProxiedPlayer, Integer> stafflogintimeleft = new HashMap<ProxiedPlayer, Integer>();
	
	public static HashMap<UUID, ServerInfo> connectedto = new HashMap<UUID, ServerInfo>();
	
	public static HashMap<UUID, String> ips = new HashMap<UUID, String>();
	
	public static Start plugin;
	
	public void onEnable(){
		plugin = this;
		
		this.getProxy().getPluginManager().registerListener(this, new PingEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerChatEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerConnectEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerDisconnectEvent());
		
		new BungeeScheduler(){}.schedule(this, new StaffAnnouncementsRunnable(), 0, 15, TimeUnit.MINUTES);
		new BungeeScheduler(){}.runAsync(this, new DatabaseRunnable());
		new BungeeScheduler(){}.schedule(this, new LoginRunnable(), 0, 1, TimeUnit.SECONDS);
		new BungeeScheduler(){}.schedule(this, new MOTDRunnable(), 0, 20, TimeUnit.MILLISECONDS);
		new BungeeScheduler(){}.schedule(this, new AnnouncementsRunnable(), 0, 5, TimeUnit.MINUTES);
		
		try {
			this.setStaticFinalValue(PipelineUtils.class.getDeclaredField("SERVER_CHILD"), new ConnectionReplacement(this));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new BungeeScheduler(){}.schedule(this, new Runnable(){
			public void run(){
				for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
					try{
						connectedto.put(p.getUniqueId(), p.getServer().getInfo());
					}catch(Exception ex){
						connectedto.put(p.getUniqueId(), ProxyServer.getInstance().getServerInfo("hub"));
					}
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
		
		Passwords.register();
	}
	
	public static Start getInstance(){
		return plugin;
	}
	
	private void setStaticFinalValue(Field field, Object newValue) throws Exception {
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, newValue);
	}
	
	public static String getServer(String p){
		
		String server = "";
		
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			if(p.equalsIgnoreCase(player.getName())){
				server = player.getServer().getInfo().getName();
			}
		}
		
		if(server.equalsIgnoreCase("hub")){
			server = "§3§lHub";
		}
		else if(server.equalsIgnoreCase("kitpvp")){
			server = "§c§lKitPvP";
		}
		else if(server.equalsIgnoreCase("prison")){
			server = "§4§lPrison";
		}
		else if(server.equalsIgnoreCase("creative")){
			server = "§d§lCreative";
		}
		else if(server.equalsIgnoreCase("survival")){
			server = "§a§lSurvival";
		}
		else if(server.equalsIgnoreCase("skyblock")){
			server = "§5§lSkyBlock";
		}
		else if(server.equalsIgnoreCase("minigames")){
			server = "§f§lMiniGames";
		}
		else if(server.equalsIgnoreCase("alpha")){
			server = "§e§lAlpha";
		}
		
		return server;
	}
	
	public static String getServerName(String server){
		
		if(server.equalsIgnoreCase("hub")){
			server = "§3§lHub";
		}
		else if(server.equalsIgnoreCase("kitpvp")){
			server = "§c§lKitPvP";
		}
		else if(server.equalsIgnoreCase("prison")){
			server = "§4§lPrison";
		}
		else if(server.equalsIgnoreCase("creative")){
			server = "§d§lCreative";
		}
		else if(server.equalsIgnoreCase("survival")){
			server = "§a§lSurvival";
		}
		else if(server.equalsIgnoreCase("skyblock")){
			server = "§5§lSkyBlock";
		}
		else if(server.equalsIgnoreCase("minigames")){
			server = "§f§lMiniGames";
		}
		else if(server.equalsIgnoreCase("alpha")){
			server = "§e§lAlpha";
		}
		
		return server;
	}
	
	public static String getServerNameWithoutColor(String server){
		
		if(server.equalsIgnoreCase("hub")){
			server = "Hub";
		}
		else if(server.equalsIgnoreCase("kitpvp")){
			server = "KitPvP";
		}
		else if(server.equalsIgnoreCase("prison")){
			server = "Prison";
		}
		else if(server.equalsIgnoreCase("creative")){
			server = "Creative";
		}
		else if(server.equalsIgnoreCase("survival")){
			server = "Survival";
		}
		else if(server.equalsIgnoreCase("skyblock")){
			server = "SkyBlock";
		}
		else if(server.equalsIgnoreCase("minigames")){
			server = "MiniGames";
		}
		else if(server.equalsIgnoreCase("alpha")){
			server = "Alpha";
		}
		
		return server;
	}
	
	public static boolean hasStaffPerms(ProxiedPlayer p, StaffRank rank){
		
		UUID uuid = p.getUniqueId();
		
		if(rank == StaffRank.User){
			if(staffrank.get(uuid) == StaffRank.User || staffrank.get(uuid) == StaffRank.Builder || staffrank.get(uuid) == StaffRank.Moderator || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Builder){
			if(staffrank.get(uuid) == StaffRank.Builder || staffrank.get(uuid) == StaffRank.Moderator || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Moderator){
			if(staffrank.get(uuid) == StaffRank.Moderator || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Owner){
			if(staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
	}
	
	public static boolean hasVIPPerms(ProxiedPlayer p, VIPRank rank){
		
		UUID uuid = p.getUniqueId();
		
		if(rank == VIPRank.Iron_VIP){
			if(viprank.get(uuid) == VIPRank.Iron_VIP || viprank.get(uuid) == VIPRank.Gold_VIP || viprank.get(uuid) == VIPRank.Diamond_VIP || viprank.get(uuid) == VIPRank.Emerald_VIP || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Gold_VIP){
			if(viprank.get(uuid) == VIPRank.Gold_VIP || viprank.get(uuid) == VIPRank.Diamond_VIP || viprank.get(uuid) == VIPRank.Emerald_VIP || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Diamond_VIP){
			if(viprank.get(uuid) == VIPRank.Diamond_VIP || viprank.get(uuid) == VIPRank.Emerald_VIP || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Emerald_VIP){
			if(viprank.get(uuid) == VIPRank.Emerald_VIP || staffrank.get(uuid) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
	}
	
	public static String getPlayerDisplayname(ProxiedPlayer p){
		
		UUID uuid = p.getUniqueId();;
		
		StaffRank staff = staffrank.get(uuid);
		VIPRank vip = viprank.get(uuid);
		
		if(staff == StaffRank.Owner){
			return "§4§lOwner §4" + p.getName(); 
		}
		else if(staff == StaffRank.Moderator){
			return "§b§lMod §b" + p.getName(); 
		}
		else if(staff == StaffRank.Builder){
			return "§d§lBuilder §d" + p.getName(); 
		}
		else if(vip == VIPRank.Emerald_VIP){
			return "§a§lEmerald §a" + p.getName(); 
		}
		else if(vip == VIPRank.Diamond_VIP){
			return "§9§lDiamond §9" + p.getName(); 
		}
		else if(vip == VIPRank.Gold_VIP){
			return "§6§lGold §6" + p.getName(); 
		}
		else if(vip == VIPRank.Iron_VIP){
			return "§7§lIron §7" + p.getName(); 
		}
		else{
			return "§8" + p.getName(); 
		}
	}
}
