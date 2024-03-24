package me.O_o_Fadi_o_O.BungeeFriends;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.BungeeFriends.events.PlayerChatEvent;
import me.O_o_Fadi_o_O.BungeeFriends.events.PlayerConnectEvent;
import me.O_o_Fadi_o_O.BungeeFriends.events.PlayerDisconnectEvent;
import me.O_o_Fadi_o_O.BungeeFriends.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeFriends.managers.StorageManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Start extends Plugin {
	
	public static Start plugin;
	
	@SuppressWarnings("deprecation")
	public void onEnable(){
		plugin = this;
		
		ConfigManager.setup();
		
		this.getProxy().getPluginManager().registerListener(this, new PlayerChatEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerConnectEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerDisconnectEvent());
		
		try{
			loadConfigData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeFriends] You did not setup the config.yml correctly! Error:");
			ex.printStackTrace();
		}
		try{
			loadPlayerDataData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeFriends] You did not setup the playerdata.yml correctly! Error:");
			ex.printStackTrace();
		}
	}
	
	public static Start getInstance(){
		return plugin;
	}
	
	public static String getDate(){
		Calendar c = Calendar.getInstance();
        
        Date d = new Date(c.getTimeInMillis()); 
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern( "dd-MM-yyyy HH:mm:ss" );
        return sdf.format(d) + " (" + c.getTimeZone().getDisplayName() + ")";
	}
	
	@SuppressWarnings("deprecation")
	public static void loadConfigData(){
		StorageManager.noreloadpermission = ConfigManager.config.getString("NoReloadPermission");
		StorageManager.hasmaxfriends = ConfigManager.config.getString("HasMaxFriends");
		StorageManager.alreadyfriend = ConfigManager.config.getString("AlreadyFriend");
		StorageManager.tothemselves = ConfigManager.config.getString("ToThemselves");
		StorageManager.notonline = ConfigManager.config.getString("PlayerNotOnline");
		StorageManager.notyourfriend = ConfigManager.config.getString("NotYourFriend");
		StorageManager.removed = ConfigManager.config.getString("Removed");
		StorageManager.removedfriend = ConfigManager.config.getString("RemovedFriend");
		StorageManager.acceptinvited = ConfigManager.config.getString("AcceptInvited");
		StorageManager.acceptinviter = ConfigManager.config.getString("AcceptInviter");
		StorageManager.denyinvited = ConfigManager.config.getString("DenyInvited");
		StorageManager.denyinviter = ConfigManager.config.getString("DenyInviter");
		StorageManager.norequest = ConfigManager.config.getString("NoRequest");
		StorageManager.maxfriends = ConfigManager.config.getInt("MaxFriends");
		StorageManager.statuscoloronline = ConfigManager.config.getString("StatusColor.Online");
		StorageManager.statuscoloroffline = ConfigManager.config.getString("StatusColor.Offline");
		for(String server : ProxyServer.getInstance().getServers().keySet()){
			if(ConfigManager.config.get("ServerNames." + server) != null){
				StorageManager.servernames.put(ProxyServer.getInstance().getServerInfo(server), ConfigManager.config.getString("ServerNames." + server));
			}
			else{
				ProxyServer.getInstance().getConsole().sendMessage("[BungeeFriends] §cYou did not setup the servername for " + server + "! This will cause Errors!");
			}
		}
		StorageManager.removebutton = ConfigManager.config.getString("RemoveButton");
		StorageManager.acceptbutton = ConfigManager.config.getString("AcceptButton");
		StorageManager.denybutton = ConfigManager.config.getString("DenyButton");
		StorageManager.hoverfriendonlinebutton = ConfigManager.config.getString("HoverFriendOnlineButton");
		StorageManager.hoverfriendofflinebutton = ConfigManager.config.getString("HoverFriendOfflineButton");
		StorageManager.hoverserverbutton = ConfigManager.config.getString("HoverServerButton");
		StorageManager.hoverremovebutton = ConfigManager.config.getString("HoverRemoveButton");
		StorageManager.hoveracceptbutton = ConfigManager.config.getString("HoverAcceptButton");
		StorageManager.hoverdenybutton = ConfigManager.config.getString("HoverDenyButton");
		StorageManager.friendsmessage = ConfigManager.config.getStringList("FriendsMessage");
		StorageManager.invitedmessage = ConfigManager.config.getStringList("InvitedMessage");
		StorageManager.invitermessage = ConfigManager.config.getStringList("InviterMessage");
	}
	
	public static void loadPlayerDataData(){
		for(String uuid : ConfigManager.playerdata.getKeys()){
			UUID realuuid = UUID.fromString(uuid);
			if(ConfigManager.playerdata.get(uuid + ".LastName") != null){
				StorageManager.lastname.put(realuuid, ConfigManager.playerdata.getString(uuid + ".LastName"));
			}
			if(ConfigManager.playerdata.get(uuid + ".LastOnline") != null){
				StorageManager.lastonline.put(realuuid, ConfigManager.playerdata.getString(uuid + ".LastOnline"));
			}
			if(ConfigManager.playerdata.get(uuid + ".LastSeen") != null){
				StorageManager.lastseen.put(realuuid, ConfigManager.playerdata.getString(uuid + ".LastSeen"));
			}
			if(ConfigManager.playerdata.get(uuid + ".Friends") != null){
				String[] friends = ConfigManager.playerdata.getString(uuid + ".Friends").split("\\|");
				List<UUID> uuids = new ArrayList<UUID>();
				for(String friend : friends){
					uuids.add(UUID.fromString(friend));
				}
				StorageManager.friends.put(realuuid, uuids);
			}
		}
	}
}
