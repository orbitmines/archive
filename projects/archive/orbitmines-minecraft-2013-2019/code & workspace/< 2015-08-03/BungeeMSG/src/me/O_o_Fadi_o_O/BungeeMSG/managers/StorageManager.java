package me.O_o_Fadi_o_O.BungeeMSG.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StorageManager {

	public static HashMap<ProxiedPlayer, ProxiedPlayer> lastmsg = new HashMap<ProxiedPlayer, ProxiedPlayer>();
	public static HashMap<ProxiedPlayer, String> toggledchannel = new HashMap<ProxiedPlayer, String>();
	public static HashMap<String, Boolean> spy = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> toggle = new HashMap<String, Boolean>();
	public static HashMap<String, Long> reportcooldowns = new HashMap<String, Long>();
	public static HashMap<String, Long> helpopcooldowns = new HashMap<String, Long>();
	public static List<UUID> mute = new ArrayList<UUID>(); 
	public static HashMap<UUID, List<UUID>> ignored = new HashMap<UUID, List<UUID>>();

	public static HashMap<String, Long> lastspamcheckpm = new HashMap<String, Long>();
	public static HashMap<String, Long> lastspamcheckglobal = new HashMap<String, Long>();
	public static HashMap<ProxiedPlayer, String> lastmessage = new HashMap<ProxiedPlayer, String>();

	public static HashMap<ProxiedPlayer, Long> tofaststartedcount = new HashMap<ProxiedPlayer, Long>();
	public static HashMap<ProxiedPlayer, Integer> tofastamount = new HashMap<ProxiedPlayer, Integer>();
	
	public static String version = "v1.7.6";
	
	public static boolean allplayersmuted = false;
	public static List<ServerInfo> mutedservers = new ArrayList<ServerInfo>();
	
	public static boolean uselog = true;
	public static boolean readprivatemessages = true;
	public static boolean readspies = false;
	public static boolean readtoggles = false;
	public static boolean readmutes = false;
	public static boolean readreloads = false;
	public static boolean readreloaddata = false;
	public static boolean readbannedwords = false;
	public static boolean readspam = false;
	public static boolean readadvertising = false;
	public static boolean readglobal = false;
	public static boolean readchannels = false;
	public static boolean readmuteall = false;
	public static boolean readignores = false;
	public static boolean readreports = true;
	public static boolean readhelpops = true;
	
	public static List<String> bannedwords = new ArrayList<String>();
	public static List<String> replacements = new ArrayList<String>();
	
	public static List<String> whitelistedips = new ArrayList<String>();
	public static List<String> whitelisteddomainnames = new ArrayList<String>();

	public static boolean useantispam = true;
	public static boolean cancelduplicate = true;
	public static int duplicatesensitivity = 2;
	public static boolean canceltofastusage = true;
	public static int tofasttimecheck = 5;
	public static int tofastmaxusage = 3;
	public static boolean usecooldown = true;
	public static int messagecooldownpm = 2;
	public static int messagecooldownglobal = 2;
	public static boolean cancelcaps = true;
	public static int maxcapsinmessage = 10;

	public static boolean useantiadvertise = true;
	public static boolean cancelips = true;
	public static boolean canceldomainnames = true;
	public static boolean kick = true;
	
	public static List<String> messagecommand = Arrays.asList("/msg", "/m", "/t", "/tell", "/w", "/whisper");
	public static List<String> replycommand = Arrays.asList("/reply", "/r");
	public static List<String> reloadcommand = Arrays.asList("/msgreload");
	public static List<String> spycommand = Arrays.asList("/msgspy");
	public static List<String> togglecommand = Arrays.asList("/msgtoggle");
	public static List<String> mutecommand = Arrays.asList("/msgmute");
	public static List<String> globalcommand = Arrays.asList("/msgglobal");
	public static List<String> muteallcommand = Arrays.asList("/msgmuteall");
	public static List<String> ignorecommand = Arrays.asList("/ignore");
	public static List<String> reportcommand = Arrays.asList("/report");
	public static List<String> helpopcommand = Arrays.asList("/helpop");
	
	public static HashMap<ServerInfo, String> servernames = new HashMap<ServerInfo, String>();

	public static boolean permissionrequiredforglobalmessage = false;
	public static String globalmessage = "&7[&3&lGlobal&7] &7[%server-sender%&7] &6%sender%&7: &6%msg%";
	
	public static boolean useautoglobalchat = false;
	public static HashMap<Integer, List<ServerInfo>> groupservers = new HashMap<Integer, List<ServerInfo>>();
	public static HashMap<Integer, String> groupmessages = new HashMap<Integer, String>();
	
	public static HashMap<String, String> channelpermissions = new HashMap<String, String>();
	public static HashMap<String, String> channelmessages = new HashMap<String, String>();
	public static HashMap<String, List<String>> channelstartingsymbols = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> channeltogglesymbols = new HashMap<String, List<String>>();
	public static HashMap<String, String> channeltoggleenabled = new HashMap<String, String>();
	public static HashMap<String, String> channeltoggledisabled = new HashMap<String, String>();
	
	public static HashMap<String, String> broadcastpermissions = new HashMap<String, String>();
	public static HashMap<String, String> broadcastnopermissions = new HashMap<String, String>();
	public static HashMap<String, String> broadcastwrongusage = new HashMap<String, String>();
	public static HashMap<String, List<String>> broadcastmessages = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> broadcastcommands = new HashMap<String, List<String>>();

	public static HashMap<String, List<ServerInfo>> autoannounceservers = new HashMap<String, List<ServerInfo>>();
	public static HashMap<String, Integer> autoannouncedelay = new HashMap<String, Integer>();
	public static HashMap<String, List<List<String>>> autoannouncemessages = new HashMap<String, List<List<String>>>();
	public static HashMap<String, Integer> autoannouncelastmessagetime = new HashMap<String, Integer>();
	public static HashMap<String, Integer> autoannouncelastmessage = new HashMap<String, Integer>();
	
	public static String hovermessage = "&7Click to message &6%receiver%&7.";
	public static String suggestedcommand = "/msg %receiver%";
	public static String suggestedplayer = "&6%receiver%";
	
	public static String toreceiver = "&7[%server-sender%&7] &6%sender% &7> &7[%server-receiver%&7] &6%receiver%&7: &6%msg%";
	public static String tosender = "&7[%server-sender%&7] &6%sender% &7> &7[%server-receiver%&7] &6%receiver%&7: &6%msg%";
	public static boolean infoenabled = true;
	public static String info = "&7Use &6/r <msg>&7 to reply.";
	public static String notonline = "&6%receiver% &7isn't Online!";
	public static String noreceiver = "&7You have nobody to reply to.";
	public static String tothemselves = "&7You cannot send a message to yourself!";
	public static String wrongusagemsg = "&7Use &6%cmd% <player> <msg>&7.";
	public static String wrongusagereply = "&7Use &6%cmd% <msg>&7.";
	public static String wrongusagetoggle = "&7Use &6%cmd% &7or &6%cmd% <player>&7.";
	public static String wrongusagemute = "&7Use &6%cmd% <player>&7.";
	public static String wrongusageglobal = "&7Use &6%cmd% <msg>&7.";
	public static String wrongusagemuteall = "&7Use &6%cmd% &7or &6%cmd% <server>&7.";
	public static String wrongusageignore = "&7Use &6%cmd% <player>&7.";
	public static String wrongusagereport = "&7Use &6%cmd% <player> <reason>&7.";
	public static String wrongusagehelpop = "&7Use &6%cmd% <reason>&7.";
	public static String noreloadpermission = "&7You do not have access to this command!";
	public static String nospypermission = "&7You do not have access to this command!";
	public static String notogglepermission = "&7You do not have access to this command!";
	public static String notoggleotherpermission = "&7You do not have access to this command!";
	public static String nomutepermission = "&7You do not have access to this command!";
	public static String noglobalpermission = "&7You do not have access to this command!";
	public static String nomuteallpermission = "&7You do not have access to this command!";
	public static String noignorepermission = "&7You do not have access to this command!";
	public static String nomessagepermission = "&7You do not have access to this command!";
	public static String noreplypermission = "&7You do not have access to this command!";
	public static String spyprefix = "&eSpy &8| ";
	public static String spymessage = "&7[%server-sender%&7] &6%sender% &7> &7[%server-receiver%&7] &6%receiver%&7: &6%msg%";
	public static String spyenable = "&aEnabled &eSpy Mode&7!";
	public static String spydisable = "&cDisabled &eSpy Mode&7!";
	public static boolean tellsenderifdisabled = true;
	public static String disabledmessage = "&6%receiver% &cDisabled&7 Private Messages!";
	public static String toggleenable = "&aEnabled &7Private Messages!";
	public static String toggledisable = "&cDisabled &7Private Messages!";
	public static String toggleenabletosender = "&aEnabled &6%toggled&'s &7Private Messages!";
	public static String toggleenabletoplayer = "&6%sender% &aEnabled &7your Private Messages!";
	public static String toggledisabletosender = "&cDisabled &6%toggled&'s &7Private Messages!";
	public static String toggledisabletoplayer = "&6%sender% &cDisabled &7your Private Messages!";
	public static String toggleonsend = "&7Your Private Messages have been &cDisabled&7!";
	public static String mutetosender = "&7You muted &6%muted%&7!";
	public static String unmutetosender = "&7You unmuted &6%muted%&7!";
	public static String mutetoplayer = "&7You have been muted by &6%sender%&7!";
	public static String unmutetoplayer = "&7You have been unmuted by &6%sender%&7!";
	public static String mutedmessage = "&7You cannot use private messages. You have been muted!";
	public static String spamduplicate = "&7Spamming is not allowed here!";
	public static String spamtofast = "&7You're sending messages too fast!";
	public static String spamcooldown = "&7You have to wait %left% more seconds before sending a Private Message again!";
	public static String secondgrammervariableone = "second";
	public static String secondgrammervariablemultiple = "seconds";
	public static String advertisekickmessage = "&6&lKicked! &7Sending &6%type%&7 through PMs isn't allowed!";
	public static String advertisemessage = "&7You're not allowed to send &6%type%&7 through Private Messages!";
	public static String typevariableips = "IPs";
	public static String typevariabledomainnames = "websites";
	public static String mutealltosender = "&6Muted&7 all Players!";
	public static String mutealltoplayer = "&7You have been muted by &6%sender%&7!";
	public static String unmutealltosender = "&6Unmuted&7 all Players!";
	public static String unmutealltoplayer = "&7You have been unmuted by &6%sender%&7!";
	public static String muteservertosender = "&6Muted&7 all Players in %server-name%!";
	public static String unmuteservertosender = "&6Unmuted&7 all Players in %server-name%!";
	public static boolean useignorepermission = true;
	public static String ignore = "&7You're now ignoring &6%ignored%&7!";
	public static String noignore = "&7You're no longer ignoring &6%ignored%&7.";
	public static String isignored = "&7You ignored &6%receiver%&7!";
	public static boolean tellsenderifignored = true;
	public static String ignoredmessage = "&6%receiver%&7 ignored you.";
	public static boolean usemessagepermission = false;
	public static boolean usereplypermission = false;
	public static int reportcooldown = 600;
	public static String reportoncooldown = "&7You may only report a player once every &610 minutes&7!";
	public static String reportedmessage = "&7Succesfully reported &6%reported%&7! (&6%reason%&7)";
	public static String reportedstaffmessage = "&7[&cReport&7] [%server-sender%&7] &6%sender% &7-> [%server-reported%&7] &c%reported%&7. (&6%reason%&7)";
	public static int helpopcooldown = 300;
	public static String helpoponcooldown = "&7You may only ask for help every &65 minutes&7!";
	public static String helpopmessage = "&7Succesfully asked for help! (&6%reason%&7)";
	public static String helpopstaffmessage = "&7[&dHelpOp&7] [%server-sender%&7] &6%sender%&7: &d%reason%";
}
