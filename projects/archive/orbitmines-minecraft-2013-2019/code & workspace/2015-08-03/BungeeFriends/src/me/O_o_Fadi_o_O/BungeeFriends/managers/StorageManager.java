package me.O_o_Fadi_o_O.BungeeFriends.managers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;


public class StorageManager {

	public static String version = "v1.0";
	public static HashMap<ProxiedPlayer, ProxiedPlayer> friendrequest = new HashMap<ProxiedPlayer, ProxiedPlayer>();
	
	// config.yml
	public static String noreloadpermission = "&7You do not have access to this command!";
	public static String hasmaxfriends = "&7You reached the maximum amount of friends! (&6%max%&7)";
	public static String alreadyfriend = "&7You are already friends with &6%invited%&7!";
	public static String tothemselves = "&7You cannot invite yourself as a friend.";
	public static String notonline = "&6%invited% &7isn't Online!";
	public static String notyourfriend = "&6%removed% &7isn't your friend!";
	public static String removed = "&7Removed &6%removed% &7from your friends!";
	public static String removedfriend = "&6%remover%&7 removed you from their friends!";
	public static String acceptinvited = "&7You're now friends with &6%inviter%&7!";
	public static String acceptinviter = "&6%invited% &7accepted your friend request!";
	public static String denyinvited = "&7You denied &6%inviter%'s&7 friend request!";
	public static String denyinviter = "&6%invited% &7denied your friend request!";
	public static String norequest = "&7Nobody invited you to their friends!";
	public static int maxfriends = 5;
	public static String statuscoloronline = "&a";
	public static String statuscoloroffline = "&4";
	public static HashMap<ServerInfo, String> servernames = new HashMap<ServerInfo, String>();
	public static String removebutton = "&cRemove Friend";
	public static String acceptbutton = "&aAccept";
	public static String denybutton = "&cDeny";
	public static String hoverfriendonlinebutton = "&7&lInfo:\n &7UUID: &6%uuid%\n &7Status: &aOnline";
	public static String hoverfriendofflinebutton = "&7&lInfo:\n &7UUID: &6%uuid%\n &7Last Online: &6%last-online% &7Last Seen: &6%last-server%\n &7Status: &4Offline";
	public static String hoverserverbutton = "&7Click to connect to &6%server-name%&7.";
	public static String hoverremovebutton = "&7Click to remove &6%friend-name%&7.";
	public static String hoveracceptbutton = "&7Click here to &aaccept&7!";
	public static String hoverdenybutton = "&7Click here to &cdeny&7!";
	public static List<String> friendsmessage = Arrays.asList("&7&lBungee&6&lFriends", "%if-no-friends% &7Invite friends with &6/friends invite <player>&7.", "%import-all-friends% %online-color%%friend-name% &7| %server-name% &7| %remove-button%");
	public static List<String> invitedmessage = Arrays.asList("&6%inviter% &7wants to be friends!", "%accept-button% &7or %deny-button%");
	public static List<String> invitermessage = Arrays.asList("&7You sent a friend request to &6%invited%&7!");
	
	// playerdata.yml
	public static HashMap<UUID, String> lastname = new HashMap<UUID, String>();
	public static HashMap<UUID, String> lastonline = new HashMap<UUID, String>();
	public static HashMap<UUID, String> lastseen = new HashMap<UUID, String>();
	public static HashMap<UUID, List<UUID>> friends = new HashMap<UUID, List<UUID>>();
}
