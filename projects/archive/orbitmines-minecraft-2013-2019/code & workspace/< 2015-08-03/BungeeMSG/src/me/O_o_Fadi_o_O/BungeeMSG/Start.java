package me.O_o_Fadi_o_O.BungeeMSG;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import me.O_o_Fadi_o_O.BungeeMSG.events.PlayerChatEvent;
import me.O_o_Fadi_o_O.BungeeMSG.events.PlayerTabCompleteEvent;
import me.O_o_Fadi_o_O.BungeeMSG.managers.ConfigManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.LogManager;
import me.O_o_Fadi_o_O.BungeeMSG.managers.StorageManager;
import me.O_o_Fadi_o_O.BungeeMSG.runnables.AutoAnnouncerRunnable;
import me.O_o_Fadi_o_O.BungeeMSG.runnables.DayRunnable;
import me.O_o_Fadi_o_O.BungeeMSG.utils.Update;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.scheduler.BungeeScheduler;

public class Start extends Plugin {
	
	public static Start plugin;
	
	@SuppressWarnings("deprecation")
	public void onEnable(){
		plugin = this;
		
		ConfigManager.setup();
		checkForOlderConfig();
		
		this.getProxy().getPluginManager().registerListener(this, new PlayerChatEvent());
		this.getProxy().getPluginManager().registerListener(this, new PlayerTabCompleteEvent());
		
		try{
			loadConfigData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] You did not setup the config.yml correctly! Error:");
			ex.printStackTrace();
		}
		try{
			loadMutedData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] You did not setup the muted.yml correctly! Error:");
			ex.printStackTrace();
		}
		try{
			loadBannedWordsData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] You did not setup the banned-words.yml correctly! Error:");
			ex.printStackTrace();
		}
		try{
			loadDomainWhitelistData();
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] You did not setup the domain-whitelist.yml correctly! Error:");
			ex.printStackTrace();
		}
		try{
			loadPlayerDataData(true);
		}catch(Exception ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] You did not setup the playerdata.yml correctly! Error:");
			ex.printStackTrace();
		}
		
	    try{
	        Metrics metrics = new Metrics(this);
	        metrics.start();
	    }catch(IOException ex){
			ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] Error while connecting to mcstats.org");
	    }
	    
		new BungeeScheduler(){}.schedule(this, new DayRunnable(), 0, 15, TimeUnit.MINUTES);
		new BungeeScheduler(){}.schedule(this, new AutoAnnouncerRunnable(), 0, 1, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public static void sendMessageNullCheck(ProxiedPlayer receiver, ProxiedPlayer sender, String message){
		if(message != null){
			if(receiver != null && message.contains("%suggest-player%")){
				TextComponent[] tcs = new TextComponent[3];
				
				String prevmsg = "";
				String colors = "";
				
				String s1 = "";
				String string1 = message.substring(0, message.indexOf("%suggest-player%"));
				for(String s : string1.split(" ")){
					colors = "";
					if(prevmsg.contains("§")){
						String last = "";
						for(String c : prevmsg.split("")){
							if(last.equals("§")){
								colors = colors + last + c;
							}
							last = c;
						}
					}
					
					if(s1.equals("")){
						s1 = s1	+ colors + s;
					}
					else{
						s1 = s1	+ " " + colors + s;
					}
					prevmsg = colors + s;
				}
				
				tcs[0] = new TextComponent(s1);
				
				TextComponent tc = new TextComponent(StorageManager.suggestedplayer.replace("&", "§").replace("%receiver%", sender.getName()));
				tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, StorageManager.suggestedcommand.replace("%receiver%", sender.getName()) + " "));
				tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(StorageManager.hovermessage.replaceAll("&", "§").replace("%receiver%", sender.getName())).create()));

				tcs[1] = tc;
				
				String s2 = "";
				String string2 = message.substring(message.indexOf("%suggest-player%") + 16);
				for(String s : string2.split(" ")){
					colors = "";
					if(prevmsg.contains("§")){
						String last = "";
						for(String c : prevmsg.split("")){
							if(last.equals("§")){
								colors = colors + last + c;
							}
							last = c;
						}
					}

					if(s2.equals("")){
						s2 = s2	+ colors + s;
					}
					else{
						s2 = s2	+ " " + colors + s;
					}
					prevmsg = colors + s;
				}

				tcs[2] = new TextComponent(s2);
				
				TextComponent newtc = new TextComponent(tcs);
				receiver.sendMessage(newtc);
					
			}
			else{
				receiver.sendMessage(message);
			}
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
	

	public static String getDayDate(){
		Calendar c = Calendar.getInstance();
        
        Date d = new Date(c.getTimeInMillis()); 
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern( "dd-MM-yyyy" );
        return sdf.format(d);
	}
	
	public static void loadLog(){
		if(LogManager.islogloaded == false){
			LogManager.createNewLog();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void loadConfigData(){
		String version = Update.getLatestVersion();
		if(!StorageManager.version.equals(version)){
			sendNewVersionMessage(version);
		}
		
		loadLog();
		
		StorageManager.uselog = ConfigManager.config.getBoolean("Log.UseLog");
		StorageManager.readprivatemessages = ConfigManager.config.getBoolean("Log.ReadPrivateMessages");
		StorageManager.readspies = ConfigManager.config.getBoolean("Log.ReadSpies");
		StorageManager.readtoggles = ConfigManager.config.getBoolean("Log.ReadToggles");
		StorageManager.readmutes = ConfigManager.config.getBoolean("Log.ReadMutes");
		StorageManager.readreloads = ConfigManager.config.getBoolean("Log.ReadReloads");
		StorageManager.readreloaddata = ConfigManager.config.getBoolean("Log.ReadReloadData");
		StorageManager.readbannedwords = ConfigManager.config.getBoolean("Log.ReadBannedWords");
		StorageManager.readspam = ConfigManager.config.getBoolean("Log.ReadSpam");
		StorageManager.readadvertising = ConfigManager.config.getBoolean("Log.ReadAdvertising");
		StorageManager.readglobal = ConfigManager.config.getBoolean("Log.ReadGlobal");
		StorageManager.readchannels = ConfigManager.config.getBoolean("Log.ReadChannels");
		StorageManager.readmuteall = ConfigManager.config.getBoolean("Log.ReadMuteAll");
		StorageManager.readignores = ConfigManager.config.getBoolean("Log.ReadIgnores");
		StorageManager.readreports = ConfigManager.config.getBoolean("Log.ReadReports");
		StorageManager.readhelpops = ConfigManager.config.getBoolean("Log.ReadHelpOps");

		StorageManager.useantispam = ConfigManager.config.getBoolean("AntiSpam.UseAntiSpam");
		StorageManager.cancelduplicate = ConfigManager.config.getBoolean("AntiSpam.CancelDuplicate");
		StorageManager.duplicatesensitivity = ConfigManager.config.getInt("AntiSpam.DuplicateSensitivity");
		
		if(StorageManager.duplicatesensitivity < 0){
			StorageManager.duplicatesensitivity = 0;
		}
		if(StorageManager.duplicatesensitivity > 2){
			StorageManager.duplicatesensitivity = 2;
		}
		
		StorageManager.canceltofastusage = ConfigManager.config.getBoolean("AntiSpam.CancelTooFastUsage");
		StorageManager.tofasttimecheck = ConfigManager.config.getInt("AntiSpam.TooFastTimeCheck");
		StorageManager.tofastmaxusage = ConfigManager.config.getInt("AntiSpam.TooFastMaxUsage");
		StorageManager.usecooldown = ConfigManager.config.getBoolean("AntiSpam.UseCooldown");
		StorageManager.messagecooldownpm = ConfigManager.config.getInt("AntiSpam.MessageCooldown");
		StorageManager.messagecooldownglobal = ConfigManager.config.getInt("AntiSpam.GlobalCooldown");
		StorageManager.cancelcaps = ConfigManager.config.getBoolean("AntiSpam.CancelCaps");
		StorageManager.maxcapsinmessage = ConfigManager.config.getInt("AntiSpam.MaxCapsInMessage");
		
		StorageManager.useantiadvertise = ConfigManager.config.getBoolean("AntiAdvertise.UseAntiAdvertise");
		StorageManager.cancelips = ConfigManager.config.getBoolean("AntiAdvertise.CancelIPs");
		StorageManager.canceldomainnames = ConfigManager.config.getBoolean("AntiAdvertise.CancelDomainNames");
		StorageManager.kick = ConfigManager.config.getBoolean("AntiAdvertise.Kick");
		
		StorageManager.messagecommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Message"));
		StorageManager.replycommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Reply"));
		StorageManager.reloadcommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Reload"));
		StorageManager.spycommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Spy"));
		StorageManager.togglecommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Toggle"));
		StorageManager.mutecommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Mute"));
		StorageManager.globalcommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Global"));
		StorageManager.muteallcommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.MuteAll"));
		StorageManager.ignorecommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Ignore"));
		StorageManager.reportcommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.Report"));
		StorageManager.helpopcommand = StringListToLowercase(ConfigManager.config.getStringList("Commands.HelpOp"));
		
		StorageManager.servernames.clear();
		for(String servername : ConfigManager.config.getSection("ServerNames").getKeys()){
			if(ProxyServer.getInstance().getServerInfo(servername) != null){
				StorageManager.servernames.put(ProxyServer.getInstance().getServerInfo(servername), ConfigManager.config.getString("ServerNames." + servername));
			}
		}
		
		for(ServerInfo info : ProxyServer.getInstance().getServers().values()){
			if(!StorageManager.servernames.containsKey(info)){
				StorageManager.servernames.put(info, info.getName());
			}
		}
		
		StorageManager.permissionrequiredforglobalmessage = ConfigManager.config.getBoolean("GlobalChat.PermissionRequiredForGlobalMessage");
		StorageManager.globalmessage = ConfigManager.config.getString("GlobalChat.GlobalMessage");
		StorageManager.useautoglobalchat = ConfigManager.config.getBoolean("GlobalChat.UseAutoGlobalChat");
		
		StorageManager.groupservers.clear();
		StorageManager.groupmessages.clear();
		if(ConfigManager.config.get("GlobalChat.Groups") != null){
			for(String groupid : ConfigManager.config.getSection("GlobalChat.Groups").getKeys()){
				List<ServerInfo> servers = new ArrayList<ServerInfo>();
				if(!ConfigManager.config.getString("GlobalChat.Groups." + groupid + ".Servers").equals("[ALL]")){
					for(String servername : ConfigManager.config.getString("GlobalChat.Groups." + groupid + ".Servers").split("\\|")){
						if(ProxyServer.getInstance().getServerInfo(servername) != null){
							servers.add(ProxyServer.getInstance().getServerInfo(servername));
						}
					}
				}
				else{
					for(ServerInfo info : ProxyServer.getInstance().getServers().values()){
						servers.add(info);
					}
				}
				String globalmessage = ConfigManager.config.getString("GlobalChat.Groups." + groupid + ".Message");
				
				StorageManager.groupservers.put(Integer.parseInt(groupid), servers);
				StorageManager.groupmessages.put(Integer.parseInt(groupid), globalmessage);
			}
		}
		
		StorageManager.toggledchannel.clear();
		StorageManager.channelpermissions.clear();
		StorageManager.channelmessages.clear();
		StorageManager.channelstartingsymbols.clear();
		StorageManager.channeltogglesymbols.clear();
		StorageManager.channeltoggleenabled.clear();
		StorageManager.channeltoggledisabled.clear();
		if(ConfigManager.config.get("GlobalChat.Channels") != null){
			for(String channel : ConfigManager.config.getSection("GlobalChat.Channels").getKeys()){
				StorageManager.channelpermissions.put(channel, ConfigManager.config.getString("GlobalChat.Channels." + channel + ".Permission"));
				StorageManager.channelmessages.put(channel, ConfigManager.config.getString("GlobalChat.Channels." + channel + ".Message"));
				
				List<String> startingsymbols = ConfigManager.config.getStringList("GlobalChat.Channels." + channel + ".StartingSymbol");
				if(startingsymbols != null && startingsymbols.size() > 0){
					StorageManager.channelstartingsymbols.put(channel, startingsymbols);
				}
				else{
					StorageManager.channelstartingsymbols.put(channel, Arrays.asList("@"));
					ProxyServer.getInstance().getConsole().sendMessage("");
					ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §cStartingSymbol at Channel '" + channel + "' has to be configured different for BungeeMSG v1.6.1+");
					ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §chttp://www.spigotmc.org/resources/bungeemsg.4512/");
					ProxyServer.getInstance().getConsole().sendMessage("");
				}
				
				StorageManager.channeltogglesymbols.put(channel, ConfigManager.config.getStringList("GlobalChat.Channels." + channel + ".ToggleSymbol"));
				StorageManager.channeltoggleenabled.put(channel, ConfigManager.config.getString("GlobalChat.Channels." + channel + ".ToggleEnabled"));
				StorageManager.channeltoggledisabled.put(channel, ConfigManager.config.getString("GlobalChat.Channels." + channel + ".ToggleDisabled"));
			}
		}
		
		StorageManager.broadcastpermissions.clear();
		StorageManager.broadcastnopermissions.clear();
		StorageManager.broadcastwrongusage.clear();
		StorageManager.broadcastmessages.clear();
		StorageManager.broadcastcommands.clear();
		if(ConfigManager.config.get("GlobalChat.Broadcast") != null){
			for(String channel : ConfigManager.config.getSection("GlobalChat.Broadcast").getKeys()){
				StorageManager.broadcastpermissions.put(channel, ConfigManager.config.getString("GlobalChat.Broadcast." + channel + ".Permission"));
				StorageManager.broadcastnopermissions.put(channel, ConfigManager.config.getString("GlobalChat.Broadcast." + channel + ".NoPermission"));
				StorageManager.broadcastwrongusage.put(channel, ConfigManager.config.getString("GlobalChat.Broadcast." + channel + ".WrongUsage"));
				StorageManager.broadcastmessages.put(channel, ConfigManager.config.getStringList("GlobalChat.Broadcast." + channel + ".Messages"));
				StorageManager.broadcastcommands.put(channel, ConfigManager.config.getStringList("GlobalChat.Broadcast." + channel + ".Commands"));
			}
		}
		
		StorageManager.autoannounceservers.clear();
		StorageManager.autoannouncedelay.clear();
		StorageManager.autoannouncemessages.clear();
		StorageManager.autoannouncelastmessagetime.clear();
		StorageManager.autoannouncelastmessage.clear();
		if(ConfigManager.config.get("GlobalChat.AutoAnnounce") != null){
			for(String announcer : ConfigManager.config.getSection("GlobalChat.AutoAnnounce").getKeys()){
				List<ServerInfo> servers = new ArrayList<ServerInfo>();
				if(!ConfigManager.config.getString("GlobalChat.AutoAnnounce." + announcer + ".Servers").equals("[ALL]")){
					for(String servername : ConfigManager.config.getString("GlobalChat.AutoAnnounce." + announcer + ".Servers").split("\\|")){
						if(ProxyServer.getInstance().getServerInfo(servername) != null){
							servers.add(ProxyServer.getInstance().getServerInfo(servername));
						}
					}
				}
				else{
					for(ServerInfo info : ProxyServer.getInstance().getServers().values()){
						servers.add(info);
					}
				}
				StorageManager.autoannounceservers.put(announcer, servers);
				StorageManager.autoannouncedelay.put(announcer, ConfigManager.config.getInt("GlobalChat.AutoAnnounce." + announcer + ".Delay"));
				
				List<List<String>> messageslist = new ArrayList<List<String>>();
				for(String messages : ConfigManager.config.getSection("GlobalChat.AutoAnnounce." + announcer + ".Messages").getKeys()){
					messageslist.add(ConfigManager.config.getStringList("GlobalChat.AutoAnnounce." + announcer + ".Messages." + messages));
				}
				
				StorageManager.autoannouncemessages.put(announcer, messageslist);
				StorageManager.autoannouncelastmessagetime.put(announcer, 0);
				StorageManager.autoannouncelastmessage.put(announcer, -1);
			}
		}

		StorageManager.hovermessage = ConfigManager.config.getString("PlayerNameSuggest.HoverMessage");
		StorageManager.suggestedcommand = ConfigManager.config.getString("PlayerNameSuggest.SuggestedCommand");
		StorageManager.suggestedplayer = ConfigManager.config.getString("PlayerNameSuggest.SuggestedPlayer");
		
		StorageManager.toreceiver = ConfigManager.config.getString("Receiver");
		StorageManager.tosender = ConfigManager.config.getString("Sender");
		StorageManager.infoenabled = ConfigManager.config.getBoolean("EnableInfo");
		StorageManager.info = ConfigManager.config.getString("Info");
		StorageManager.notonline = ConfigManager.config.getString("PlayerNotOnline");
		StorageManager.noreceiver = ConfigManager.config.getString("NoReceiver");
		StorageManager.tothemselves = ConfigManager.config.getString("ToThemselves");
		StorageManager.wrongusagemsg = ConfigManager.config.getString("WrongUsageMSG");
		StorageManager.wrongusagereply = ConfigManager.config.getString("WrongUsageReply");
		StorageManager.wrongusagetoggle = ConfigManager.config.getString("WrongUsageToggle");
		StorageManager.wrongusagemute = ConfigManager.config.getString("WrongUsageMute");
		StorageManager.wrongusageglobal = ConfigManager.config.getString("WrongUsageGlobal");
		StorageManager.wrongusageignore = ConfigManager.config.getString("WrongUsageIgnore");
		StorageManager.wrongusagemuteall = ConfigManager.config.getString("WrongUsageMuteAll");
		StorageManager.wrongusagereport = ConfigManager.config.getString("WrongUsageReport");
		StorageManager.wrongusagehelpop = ConfigManager.config.getString("WrongUsageHelpOp");
		StorageManager.noreloadpermission = ConfigManager.config.getString("NoReloadPermission");
		StorageManager.nospypermission = ConfigManager.config.getString("NoSpyPermission");
		StorageManager.notogglepermission = ConfigManager.config.getString("NoTogglePermission");
		StorageManager.notoggleotherpermission = ConfigManager.config.getString("NoToggleOtherPermission");
		StorageManager.nomutepermission = ConfigManager.config.getString("NoMutePermission");
		StorageManager.noglobalpermission = ConfigManager.config.getString("NoGlobalPermission");
		StorageManager.nomuteallpermission = ConfigManager.config.getString("NoMuteAllPermission");
		StorageManager.noignorepermission = ConfigManager.config.getString("NoIgnorePermission");
		StorageManager.nomessagepermission = ConfigManager.config.getString("NoMessagePermission");
		StorageManager.noreplypermission = ConfigManager.config.getString("NoReplyPermission");
		StorageManager.spyprefix = ConfigManager.config.getString("SpyPrefix");
		StorageManager.spymessage = ConfigManager.config.getString("SpyMessage");
		StorageManager.spyenable = ConfigManager.config.getString("SpyEnable");
		StorageManager.spydisable = ConfigManager.config.getString("SpyDisable");
		StorageManager.tellsenderifdisabled = ConfigManager.config.getBoolean("TellSenderIfDisabled");
		StorageManager.disabledmessage = ConfigManager.config.getString("DisabledMessage");
		StorageManager.toggleenable = ConfigManager.config.getString("ToggleEnable");
		StorageManager.toggledisable = ConfigManager.config.getString("ToggleDisable");
		StorageManager.toggleenabletosender = ConfigManager.config.getString("ToggleEnableToSender");
		StorageManager.toggleenabletoplayer = ConfigManager.config.getString("ToggleEnableToPlayer");
		StorageManager.toggledisabletosender = ConfigManager.config.getString("ToggleDisableToSender");
		StorageManager.toggledisabletoplayer = ConfigManager.config.getString("ToggleDisableToPlayer");
		StorageManager.toggleonsend = ConfigManager.config.getString("ToggleOnSend");
		StorageManager.mutetosender = ConfigManager.config.getString("MuteToSender");
		StorageManager.unmutetosender = ConfigManager.config.getString("UnmuteToSender");
		StorageManager.mutetoplayer = ConfigManager.config.getString("MuteToPlayer");
		StorageManager.unmutetoplayer = ConfigManager.config.getString("UnmuteToPlayer");
		StorageManager.mutedmessage = ConfigManager.config.getString("MutedMessage");
		StorageManager.spamduplicate = ConfigManager.config.getString("SpamDuplicate");
		StorageManager.spamtofast = ConfigManager.config.getString("SpamTooFast");
		StorageManager.spamcooldown = ConfigManager.config.getString("SpamCooldown");
		StorageManager.secondgrammervariableone = ConfigManager.config.getString("SecondGrammerVariableOne");
		StorageManager.secondgrammervariablemultiple = ConfigManager.config.getString("SecondGrammerVariableMultiple");
		StorageManager.advertisekickmessage = ConfigManager.config.getString("AdvertiseKickMessage");
		StorageManager.advertisemessage = ConfigManager.config.getString("AdvertiseMessage");
		StorageManager.typevariableips = ConfigManager.config.getString("TypeVariableIPs");
		StorageManager.typevariabledomainnames = ConfigManager.config.getString("TypeVariableDomainNames");
		StorageManager.mutealltosender = ConfigManager.config.getString("MuteAllToSender");
		StorageManager.mutealltoplayer = ConfigManager.config.getString("MuteAllToPlayer");
		StorageManager.unmutealltosender = ConfigManager.config.getString("UnmuteAllToSender");
		StorageManager.unmutealltoplayer = ConfigManager.config.getString("UnmuteAllToPlayer");
		StorageManager.muteservertosender = ConfigManager.config.getString("MuteServerToSender");
		StorageManager.unmuteservertosender = ConfigManager.config.getString("UnmuteServerToSender");
		StorageManager.useignorepermission = ConfigManager.config.getBoolean("UseIgnorePermission");
		StorageManager.ignore = ConfigManager.config.getString("Ignore");
		StorageManager.noignore = ConfigManager.config.getString("NoIgnore");
		StorageManager.isignored = ConfigManager.config.getString("IsIgnored");
		StorageManager.tellsenderifignored = ConfigManager.config.getBoolean("TellSenderIfIgnored");
		StorageManager.ignoredmessage = ConfigManager.config.getString("IgnoredMessage");
		StorageManager.usemessagepermission = ConfigManager.config.getBoolean("UseMessagePermission");
		StorageManager.usereplypermission = ConfigManager.config.getBoolean("UseReplyPermission");
		StorageManager.reportcooldown = ConfigManager.config.getInt("ReportCooldown");
		StorageManager.reportoncooldown = ConfigManager.config.getString("ReportOnCooldown");
		StorageManager.reportedmessage = ConfigManager.config.getString("ReportedMessage");
		StorageManager.reportedstaffmessage = ConfigManager.config.getString("ReportedStaffMessage");
		StorageManager.helpopcooldown = ConfigManager.config.getInt("HelpOpCooldown");
		StorageManager.helpoponcooldown = ConfigManager.config.getString("HelpOpOnCooldown");
		StorageManager.helpopmessage = ConfigManager.config.getString("HelpOpMessage");
		StorageManager.helpopstaffmessage = ConfigManager.config.getString("HelpOpStaffMessage");
	}
	
	public static void readDataToLog(String type){
		Logger log = LogManager.getLog();
		log.info("");
		log.info("Data received on " + type + ":");
		log.info("[config.yml] UseLog: " + StorageManager.uselog);
		log.info("[config.yml] ReadPrivateMessages: " + StorageManager.readprivatemessages);
		log.info("[config.yml] ReadSpies: " + StorageManager.readspies);
		log.info("[config.yml] ReadToggles: " + StorageManager.readtoggles);
		log.info("[config.yml] ReadMutes: " + StorageManager.readmutes);
		log.info("[config.yml] ReadReloads: " + StorageManager.readreloads);
		log.info("[config.yml] ReadReloadData: " + StorageManager.readreloaddata);
		log.info("[config.yml] ReadSpam: " + StorageManager.readspam);
		log.info("[config.yml] ReadGlobal: " + StorageManager.readglobal);
		log.info("[config.yml] ReadChannels: " + StorageManager.readchannels);
		log.info("[config.yml] ReadMuteAll: " + StorageManager.readmuteall);
		log.info("[config.yml] ReadIgnores: " + StorageManager.readignores);
		log.info("[config.yml] ReadReports: " + StorageManager.readreports);
		log.info("[config.yml] ReadHelpOps: " + StorageManager.readhelpops);
		log.info("[config.yml] UseAntiSpam: " + StorageManager.useantispam);
		log.info("[config.yml] CancelDuplicate: " + StorageManager.cancelduplicate);
		log.info("[config.yml] DuplicateSensitivity: " + StorageManager.duplicatesensitivity);
		log.info("[config.yml] CancelTooFastUsage: " + StorageManager.canceltofastusage);
		log.info("[config.yml] TooFastTimeCheck: " + StorageManager.tofasttimecheck);
		log.info("[config.yml] TooFastMaxUsage: " + StorageManager.tofastmaxusage);
		log.info("[config.yml] UseCooldown: " + StorageManager.usecooldown);
		log.info("[config.yml] MessageCooldown: " + StorageManager.messagecooldownpm);
		log.info("[config.yml] GlobalCooldown: " + StorageManager.messagecooldownglobal);
		log.info("[config.yml] CancelCaps: " + StorageManager.cancelcaps);
		log.info("[config.yml] MaxCapsInMessage: " + StorageManager.maxcapsinmessage);
		log.info("[config.yml] UseAntiAdvertise: " + StorageManager.useantiadvertise);
		log.info("[config.yml] CancelIPs: " + StorageManager.cancelips);
		log.info("[config.yml] CancelDomainNames: " + StorageManager.canceldomainnames);
		log.info("[config.yml] Kick: " + StorageManager.kick);
		log.info("[config.yml] Message:" + StringListAsString(StorageManager.messagecommand));
		log.info("[config.yml] Reply:" + StringListAsString(StorageManager.replycommand));
		log.info("[config.yml] Reload:" + StringListAsString(StorageManager.reloadcommand));
		log.info("[config.yml] Spy:" + StringListAsString(StorageManager.spycommand));
		log.info("[config.yml] Toggle:" + StringListAsString(StorageManager.togglecommand));
		log.info("[config.yml] Mute:" + StringListAsString(StorageManager.mutecommand));
		log.info("[config.yml] Global:" + StringListAsString(StorageManager.globalcommand));
		log.info("[config.yml] MuteAll:" + StringListAsString(StorageManager.muteallcommand));
		log.info("[config.yml] Ignore:" + StringListAsString(StorageManager.ignorecommand));
		log.info("[config.yml] Report:" + StringListAsString(StorageManager.reportcommand));
		log.info("[config.yml] HelpOp:" + StringListAsString(StorageManager.helpopcommand));
		for(ServerInfo info : StorageManager.servernames.keySet()){
			log.info("[config.yml] (ServerName) " + info.getName() + ": " + StorageManager.servernames.get(info));
		}
		for(int groupid : StorageManager.groupmessages.keySet()){
			List<String> groupservers = new ArrayList<String>();
			for(ServerInfo info : StorageManager.groupservers.get(groupid)){
				groupservers.add(info.getName());
			}
			log.info("[config.yml] (Group) " + groupid + " -> Servers: " + StringListAsString(groupservers));
			log.info("[config.yml] (Group) " + groupid + " -> Message: " + StorageManager.groupmessages.get(groupid));
		}
		for(String channel : StorageManager.channelmessages.keySet()){
			log.info("[config.yml] (Channel) " + channel + " -> Permission: " + StorageManager.channelpermissions.get(channel));
			log.info("[config.yml] (Channel) " + channel + " -> Message: " + StorageManager.channelmessages.get(channel));
			log.info("[config.yml] (Channel) " + channel + " -> StartingSymbol: " + StringListAsString(StorageManager.channelstartingsymbols.get(channel)));
			log.info("[config.yml] (Channel) " + channel + " -> ToggleSymbol: " + StringListAsString(StorageManager.channeltogglesymbols.get(channel)));
			log.info("[config.yml] (Channel) " + channel + " -> ToggleEnabled: " + StorageManager.channeltoggleenabled.get(channel));
			log.info("[config.yml] (Channel) " + channel + " -> ToggleDisabled: " + StorageManager.channeltoggledisabled.get(channel));
		}
		for(String broadcast : StorageManager.broadcastmessages.keySet()){
			log.info("[config.yml] (Broadcast) " + broadcast + " -> Permission: " + StorageManager.broadcastpermissions.get(broadcast));
			log.info("[config.yml] (Broadcast) " + broadcast + " -> NoPermission: " + StorageManager.broadcastnopermissions.get(broadcast));
			log.info("[config.yml] (Broadcast) " + broadcast + " -> WrongUsage: " + StorageManager.broadcastwrongusage.get(broadcast));
			log.info("[config.yml] (Broadcast) " + broadcast + " -> Messages: " + StringListAsString(StorageManager.broadcastmessages.get(broadcast)));
			log.info("[config.yml] (Broadcast) " + broadcast + " -> Commands: " + StringListAsString(StorageManager.broadcastcommands.get(broadcast)));
		}
		for(String announcer : StorageManager.autoannouncedelay.keySet()){
			List<String> announceservers = new ArrayList<String>();
			for(ServerInfo info : StorageManager.autoannounceservers.get(announcer)){
				announceservers.add(info.getName());
			}
			log.info("[config.yml] (AutoAnnounce) " + announcer + " -> Servers: " + StringListAsString(announceservers));
			log.info("[config.yml] (AutoAnnounce) " + announcer + " -> Delay: " + StorageManager.autoannouncedelay.get(announcer));
			for(List<String> messages : StorageManager.autoannouncemessages.get(announcer)){
				log.info("[config.yml] (AutoAnnounce) " + announcer + " -> Messages: " + StringListAsString(messages));
			}
		}
		log.info("[config.yml] HoverMessage: " + StorageManager.hovermessage);
		log.info("[config.yml] SuggestedCommand: " + StorageManager.suggestedcommand);
		log.info("[config.yml] SuggestedPlayer: " + StorageManager.suggestedplayer);
		log.info("[config.yml] Receiver: " + StorageManager.toreceiver);
		log.info("[config.yml] Sender: " + StorageManager.tosender);
		log.info("[config.yml] EnableInfo: " + StorageManager.infoenabled);
		log.info("[config.yml] Info: " + StorageManager.info);
		log.info("[config.yml] PlayerNotOnline: " + StorageManager.notonline);
		log.info("[config.yml] NoReceiver: " + StorageManager.noreceiver);
		log.info("[config.yml] ToThemselves: " + StorageManager.tothemselves);
		log.info("[config.yml] WrongUsageMSG: " + StorageManager.wrongusagemsg);
		log.info("[config.yml] WrongUsageReply: " + StorageManager.wrongusagereply);
		log.info("[config.yml] WrongUsageToggle: " + StorageManager.wrongusagetoggle);
		log.info("[config.yml] WrongUsageMute: " + StorageManager.wrongusagemute);
		log.info("[config.yml] WrongUsageGlobal: " + StorageManager.wrongusageglobal);
		log.info("[config.yml] WrongUsageMuteAll: " + StorageManager.wrongusagemuteall);
		log.info("[config.yml] WrongUsageIgnore: " + StorageManager.wrongusageignore);
		log.info("[config.yml] WrongUsageReport: " + StorageManager.wrongusagereport);
		log.info("[config.yml] WrongUsageHelpOp: " + StorageManager.wrongusagehelpop);
		log.info("[config.yml] NoReloadPermission: " + StorageManager.noreloadpermission);
		log.info("[config.yml] NoSpyPermission: " + StorageManager.nospypermission);
		log.info("[config.yml] NoTogglePermission: " + StorageManager.notogglepermission);
		log.info("[config.yml] NoToggleOtherPermission: " + StorageManager.notoggleotherpermission);
		log.info("[config.yml] NoMutePermission: " + StorageManager.nomutepermission);
		log.info("[config.yml] NoGlobalPermission: " + StorageManager.noglobalpermission);
		log.info("[config.yml] NoMuteAllPermission: " + StorageManager.nomuteallpermission);
		log.info("[config.yml] NoIgnorePermission: " + StorageManager.noignorepermission);
		log.info("[config.yml] NoMessagePermission: " + StorageManager.nomessagepermission);
		log.info("[config.yml] NoReplyPermission: " + StorageManager.noreplypermission);
		log.info("[config.yml] SpyPrefix: " + StorageManager.spyprefix);
		log.info("[config.yml] SpyMessage: " + StorageManager.spymessage);
		log.info("[config.yml] SpyEnable: " + StorageManager.spyenable);
		log.info("[config.yml] SpyDisable: " + StorageManager.spydisable);
		log.info("[config.yml] TellSenderIfDisabled: " + StorageManager.tellsenderifdisabled);
		log.info("[config.yml] DisabledMessage: " + StorageManager.disabledmessage);
		log.info("[config.yml] ToggleEnable: " + StorageManager.toggleenable);
		log.info("[config.yml] ToggleDisable: " + StorageManager.toggledisable);
		log.info("[config.yml] ToggleEnableToSender: " + StorageManager.toggleenabletosender);
		log.info("[config.yml] ToggleEnableToPlayer: " + StorageManager.toggleenabletoplayer);
		log.info("[config.yml] ToggleDisableToSender: " + StorageManager.toggledisabletosender);
		log.info("[config.yml] ToggleDisableToPlayer: " + StorageManager.toggledisabletoplayer);
		log.info("[config.yml] ToggleOnSend: " + StorageManager.toggleonsend);
		log.info("[config.yml] MuteToSender: " + StorageManager.mutetosender);
		log.info("[config.yml] UnmuteToSender: " + StorageManager.unmutetosender);
		log.info("[config.yml] MuteToPlayer: " + StorageManager.mutetoplayer);
		log.info("[config.yml] UnmuteToPlayer: " + StorageManager.unmutetoplayer);
		log.info("[config.yml] MutedMessage: " + StorageManager.mutedmessage);
		log.info("[config.yml] SpamDuplicate: " + StorageManager.spamduplicate);
		log.info("[config.yml] SpamTooFast: " + StorageManager.spamtofast);
		log.info("[config.yml] SpamCooldown: " + StorageManager.spamcooldown);
		log.info("[config.yml] SecondGrammerVariableOne: " + StorageManager.secondgrammervariableone);
		log.info("[config.yml] SecondGrammerVariableMultiple: " + StorageManager.secondgrammervariablemultiple);
		log.info("[config.yml] AdvertiseKickMessage: " + StorageManager.advertisekickmessage);
		log.info("[config.yml] AdvertiseMessage: " + StorageManager.advertisemessage);
		log.info("[config.yml] TypeVariableIPs: " + StorageManager.typevariableips);
		log.info("[config.yml] TypeVariableDomainNames: " + StorageManager.typevariabledomainnames);
		log.info("[config.yml] MuteAllToSender: " + StorageManager.mutealltosender);
		log.info("[config.yml] MuteAllToPlayer: " + StorageManager.mutealltoplayer);
		log.info("[config.yml] UnmuteAllToSender: " + StorageManager.unmutealltosender);
		log.info("[config.yml] UnmuteAllToPlayer: " + StorageManager.unmutealltoplayer);
		log.info("[config.yml] MuteServerToSender: " + StorageManager.muteservertosender);
		log.info("[config.yml] UnmuteServerToSender: " + StorageManager.unmuteservertosender);
		log.info("[config.yml] UseIgnorePermission: " + StorageManager.useignorepermission);
		log.info("[config.yml] Ignore: " + StorageManager.ignore);
		log.info("[config.yml] NoIgnore: " + StorageManager.noignore);
		log.info("[config.yml] IsIgnored: " + StorageManager.isignored);
		log.info("[config.yml] TellSenderIfIgnored: " + StorageManager.tellsenderifignored);
		log.info("[config.yml] IgnoredMessage: " + StorageManager.ignoredmessage);
		log.info("[config.yml] ReportCooldown: " + StorageManager.reportcooldown);
		log.info("[config.yml] ReportOnCooldown: " + StorageManager.reportoncooldown);
		log.info("[config.yml] ReportedMessage: " + StorageManager.reportedmessage);
		log.info("[config.yml] ReportedStaffMessage: " + StorageManager.reportedstaffmessage);
		log.info("[config.yml] HelpOpCooldown: " + StorageManager.helpopcooldown);
		log.info("[config.yml] HelpOpOnCooldown: " + StorageManager.helpoponcooldown);
		log.info("[config.yml] HelpOpMessage: " + StorageManager.helpopmessage);
		log.info("[config.yml] HelpOpStaffMessage: " + StorageManager.helpopstaffmessage);
		log.info("[muted.yml] MutedUUIDs:" + UUIDListAsString(StorageManager.mute));
		log.info("[banned-words.yml] BannedWords:" + StringListAsString(StorageManager.bannedwords));
		log.info("[banned-words.yml] Replacements:" + StringListAsString(StorageManager.replacements));
		log.info("[domain-whitelist.yml] IPs:" + StringListAsString(StorageManager.whitelistedips));
		log.info("[domain-whitelist.yml] DomainNames:" + StringListAsString(StorageManager.whitelisteddomainnames));
		for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
			log.info("[playerdata.yml] (Player: " + p.getName() + ") Ignored:" + UUIDListAsString(StorageManager.ignored.get(p.getUniqueId())));
		}
	}
	
	public static List<String> StringListToLowercase(List<String> list){
		List<String> newlist = new ArrayList<String>();
		for(String s : list){
			newlist.add(s.toLowerCase());
		}
		return newlist;
	}
	
	public static String StringListAsString(List<String> list){
		String tosend = "";
		for(String s : list){
			tosend = tosend + ", " + s;
		}
		if(tosend.startsWith(",")){
			tosend = tosend.substring(1);
		}
		return tosend;
	}
	
	public static String UUIDListAsString(List<UUID> list){
		String tosend = "";
		for(UUID uuid : list){
			tosend = tosend + ", " + uuid.toString();
		}
		if(tosend.startsWith(",")){
			tosend = tosend.substring(1);
		}
		return tosend;
	}
	
	public static void loadMutedData(){
		List<UUID> muted = new ArrayList<UUID>();
		for(String uuid : ConfigManager.muted.getStringList("MutedUUIDs")){
			muted.add(UUID.fromString(uuid));
		}
		StorageManager.mute = muted;
	}
	
	public static void loadBannedWordsData(){
		List<String> bannedwords = new ArrayList<String>();
		List<String> replacements = new ArrayList<String>();
		for(String bannedword : ConfigManager.bannedwords.getStringList("BannedWords")){
			String[] words = bannedword.split("\\|");
			bannedwords.add(words[0]);
			if(words.length > 1){
				replacements.add(words[1]);
			}
			else{
				replacements.add("");
			}
		}
		StorageManager.bannedwords = bannedwords;
		StorageManager.replacements = replacements;
	}
	
	public static void loadDomainWhitelistData(){
		List<String> whitelistedips = new ArrayList<String>();
		for(String ip : ConfigManager.domainwhitelist.getStringList("IPs")){
			whitelistedips.add(ip);
		}
		StorageManager.whitelistedips = whitelistedips;

		List<String> whitelisteddomainnames = new ArrayList<String>();
		for(String domainname : ConfigManager.domainwhitelist.getStringList("DomainNames")){
			whitelisteddomainnames.add(domainname.toLowerCase());
		}
		StorageManager.whitelisteddomainnames = whitelisteddomainnames;
	}
	
	public static void loadPlayerDataData(boolean startup){
		StorageManager.ignored.clear();
		for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
			loadPlayerData(p);
		}
		
		useLog(startup);
	}
	
	@SuppressWarnings("deprecation")
	public static void loadPlayerData(ProxiedPlayer p){
		List<UUID> uuids = new ArrayList<UUID>();
		if(ConfigManager.playerdata.get("players." + p.getUniqueId().toString() + ".Ignored") != null){
			String[] ignored = ConfigManager.playerdata.getString("players." + p.getUniqueId().toString() + ".Ignored").split("\\|");
			
			for(String uuidstring : ignored){
				try{
					UUID uuid = UUID.fromString(uuidstring);
					uuids.add(uuid);
				}catch(IllegalArgumentException ex){
					ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] Error while parsing '" + uuidstring + "' to a UUID.");
				}
			}
		}
		StorageManager.ignored.put(p.getUniqueId(), uuids);
	}
	
	public static void useLog(boolean startup){
		if(StorageManager.uselog == true){
			if(startup == true){
				LogManager.getLog().info("Loaded config.yml");
				LogManager.getLog().info("Loaded muted.yml");
				LogManager.getLog().info("Loaded banned-words.yml");
				LogManager.getLog().info("Loaded domain-whitelist.yml");
				LogManager.getLog().info("Loaded playerdata.yml");
				if(StorageManager.readreloaddata == true){
					readDataToLog("load");
				}
			}
			else{
				if(StorageManager.readreloaddata == true){
					readDataToLog("reload");
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private static void sendNewVersionMessage(String version){
		ProxyServer.getInstance().getConsole().sendMessage("");
		ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §aNew Version Available! (" + version + ")");
		ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §ahttp://www.spigotmc.org/resources/bungeemsg.4512/");
		ProxyServer.getInstance().getConsole().sendMessage("");
	}
	
	@SuppressWarnings("deprecation")
	private void sendNewConfigurationPathMessage(String version, String path){
		ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §eCreating new Configuration Path for " + version + "! (" + path + ")");
	}
	
	@SuppressWarnings("deprecation")
	private void sendRemovedConfigurationPathMessage(String version, String path){
		ProxyServer.getInstance().getConsole().sendMessage("[BungeeMSG] §4Removing old Configuration Path for " + version + "! (" + path + ")");
	}
	
	private void checkForOlderConfig(){
		//v1.1
		if(ConfigManager.config.get("NoSpyPermission") == null){
			sendNewConfigurationPathMessage("v1.1", "NoSpyPermission");
			ConfigManager.config.set("NoSpyPermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpyPrefix") == null){
			sendNewConfigurationPathMessage("v1.1", "SpyPrefix");
			ConfigManager.config.set("SpyPrefix", "&eSpy &8| ");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpyEnable") == null){
			sendNewConfigurationPathMessage("v1.1", "SpyEnable");
			ConfigManager.config.set("SpyEnable", "&aEnabled &eSpy Mode&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpyDisable") == null){
			sendNewConfigurationPathMessage("v1.1", "SpyDisable");
			ConfigManager.config.set("SpyDisable", "&cDisabled &eSpy Mode&7!");
			ConfigManager.saveConfig();
		}
		//v1.2.1
		if(ConfigManager.config.get("NoTogglePermission") == null){
			sendNewConfigurationPathMessage("v1.2.1", "NoTogglePermission");
			ConfigManager.config.set("NoTogglePermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("TellSenderIfDisabled") == null){
			sendNewConfigurationPathMessage("v1.2.1", "TellSenderIfDisabled");
			ConfigManager.config.set("TellSenderIfDisabled", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("DisabledMessage") == null){
			sendNewConfigurationPathMessage("v1.2.1", "DisabledMessage");
			ConfigManager.config.set("DisabledMessage", "&6%receiver% &cDisabled&7 Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleEnable") == null){
			sendNewConfigurationPathMessage("v1.2.1", "ToggleEnable");
			ConfigManager.config.set("ToggleEnable", "&aEnabled &7Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleDisable") == null){
			sendNewConfigurationPathMessage("v1.2.1", "ToggleDisable");
			ConfigManager.config.set("ToggleDisable", "&cDisabled &7Private Messages!");
			ConfigManager.saveConfig();
		}
		//v1.2.4
		if(ConfigManager.config.get("WrongUsageToggle") == null){
			sendNewConfigurationPathMessage("v1.2.4", "WrongUsageToggle");
			ConfigManager.config.set("WrongUsageToggle", "&7Use &6%cmd% &7or &6%cmd% <player>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageMute") == null){
			sendNewConfigurationPathMessage("v1.2.4", "WrongUsageMute");
			ConfigManager.config.set("WrongUsageMute", "&7Use &6%cmd% <player>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoToggleOtherPermission") == null){
			sendNewConfigurationPathMessage("v1.2.4", "NoToggleOtherPermission");
			ConfigManager.config.set("NoToggleOtherPermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoMutePermission") == null){
			sendNewConfigurationPathMessage("v1.2.4", "NoMutePermission");
			ConfigManager.config.set("NoMutePermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleEnableToSender") == null){
			sendNewConfigurationPathMessage("v1.2.4", "ToggleEnableToSender");
			ConfigManager.config.set("ToggleEnableToSender", "&aEnabled &6%toggled%'s &7Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleEnableToPlayer") == null){
			sendNewConfigurationPathMessage("v1.2.4", "ToggleEnableToPlayer");
			ConfigManager.config.set("ToggleEnableToPlayer", "&6%sender% &aEnabled &7your Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleDisableToSender") == null){
			sendNewConfigurationPathMessage("v1.2.4", "ToggleDisableToSender");
			ConfigManager.config.set("ToggleDisableToSender", "&cDisabled &6%toggled%'s &7Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleDisableToPlayer") == null){
			sendNewConfigurationPathMessage("v1.2.4", "ToggleDisableToPlayer");
			ConfigManager.config.set("ToggleDisableToPlayer", "&6%sender% &cDisabled &7your Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MuteToSender") == null){
			sendNewConfigurationPathMessage("v1.2.4", "MuteToSender");
			ConfigManager.config.set("MuteToSender", "&7You muted &6%muted%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UnmuteToSender") == null){
			sendNewConfigurationPathMessage("v1.2.4", "UnmuteToSender");
			ConfigManager.config.set("UnmuteToSender", "&7You unmuted &6%muted%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MuteToPlayer") == null){
			sendNewConfigurationPathMessage("v1.2.4", "MuteToPlayer");
			ConfigManager.config.set("MuteToPlayer", "&7You have been muted by &6%sender%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UnmuteToPlayer") == null){
			sendNewConfigurationPathMessage("v1.2.4", "UnmuteToPlayer");
			ConfigManager.config.set("UnmuteToPlayer", "&7You have been unmuted by &6%sender%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MutedMessage") == null){
			sendNewConfigurationPathMessage("v1.2.4", "MutedMessage");
			ConfigManager.config.set("MutedMessage", "&7You cannot use private messages. You have been muted!");
			ConfigManager.saveConfig();
		}
		//v1.3.1
		if(ConfigManager.config.get("Log.UseLog") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.UseLog");
			ConfigManager.config.set("Log.UseLog", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadPrivateMessages") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadPrivateMessages");
			ConfigManager.config.set("Log.ReadPrivateMessages", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadSpies") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadSpies");
			ConfigManager.config.set("Log.ReadSpies", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadToggles") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadToggles");
			ConfigManager.config.set("Log.ReadToggles", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadMutes") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadMutes");
			ConfigManager.config.set("Log.ReadMutes", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadReloads") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadReloads");
			ConfigManager.config.set("Log.ReadReloads", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadReloadData") == null){
			sendNewConfigurationPathMessage("v1.3.1", "Log.ReadReloadData");
			ConfigManager.config.set("Log.ReadReloadData", false);
			ConfigManager.saveConfig();
		}
		//v1.3.6
		if(ConfigManager.config.get("Log.ReadBannedWords") == null){
			sendNewConfigurationPathMessage("v1.3.6", "Log.ReadBannedWords");
			ConfigManager.config.set("Log.ReadBannedWords", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadSpam") == null){
			sendNewConfigurationPathMessage("v1.3.6", "Log.ReadSpam");
			ConfigManager.config.set("Log.ReadSpam", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.UseAntiSpam") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.UseAntiSpam");
			ConfigManager.config.set("AntiSpam.UseAntiSpam", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.CancelDuplicate") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.CancelDuplicate");
			ConfigManager.config.set("AntiSpam.CancelDuplicate", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.CancelTooFastUsage") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.CancelTooFastUsage");
			ConfigManager.config.set("AntiSpam.CancelTooFastUsage", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.TooFastTimeCheck") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.TooFastTimeCheck");
			ConfigManager.config.set("AntiSpam.TooFastTimeCheck", 5);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.TooFastMaxUsage") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.TooFastMaxUsage");
			ConfigManager.config.set("AntiSpam.TooFastMaxUsage", 3);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.UseCooldown") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.UseCooldown");
			ConfigManager.config.set("AntiSpam.UseCooldown", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.CancelCaps") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.CancelCaps");
			ConfigManager.config.set("AntiSpam.CancelCaps", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.MaxCapsInMessage") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.MaxCapsInMessage");
			ConfigManager.config.set("AntiSpam.MaxCapsInMessage", 10);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.MessageCooldown") == null){
			sendNewConfigurationPathMessage("v1.3.6", "AntiSpam.MessageCooldown");
			ConfigManager.config.set("AntiSpam.MessageCooldown", 2);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ToggleOnSend") == null){
			sendNewConfigurationPathMessage("v1.3.6", "ToggleOnSend");
			ConfigManager.config.set("ToggleOnSend", "&7Your Private Messages have been &cDisabled&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpamDuplicate") == null){
			sendNewConfigurationPathMessage("v1.3.6", "SpamDuplicate");
			ConfigManager.config.set("SpamDuplicate", "&7Spamming is not allowed here!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpamTooFast") == null){
			sendNewConfigurationPathMessage("v1.3.6", "SpamTooFast");
			ConfigManager.config.set("SpamTooFast", "&7You're sending messages too fast!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SpamCooldown") == null){
			sendNewConfigurationPathMessage("v1.3.6", "SpamCooldown");
			ConfigManager.config.set("SpamCooldown", "&7You have to wait %left% more %second-grammer% before sending a Private Message again!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SecondGrammerVariableOne") == null){
			sendNewConfigurationPathMessage("v1.3.6", "SecondGrammerVariableOne");
			ConfigManager.config.set("SecondGrammerVariableOne", "second");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("SecondGrammerVariableMultiple") == null){
			sendNewConfigurationPathMessage("v1.3.6", "SecondGrammerVariableMultiple");
			ConfigManager.config.set("SecondGrammerVariableMultiple", "seconds");
			ConfigManager.saveConfig();
		}
		//v1.3.7
		if(ConfigManager.config.get("Log.ReadAdvertising") == null){
			sendNewConfigurationPathMessage("v1.3.7", "Log.ReadAdvertising");
			ConfigManager.config.set("Log.ReadAdvertising", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiAdvertise.UseAntiAdvertise") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AntiAdvertise.UseAntiAdvertise");
			ConfigManager.config.set("AntiAdvertise.UseAntiAdvertise", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiAdvertise.CancelIPs") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AntiAdvertise.CancelIPs");
			ConfigManager.config.set("AntiAdvertise.CancelIPs", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiAdvertise.CancelDomainNames") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AntiAdvertise.CancelDomainNames");
			ConfigManager.config.set("AntiAdvertise.CancelDomainNames", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiAdvertise.Kick") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AntiAdvertise.Kick");
			ConfigManager.config.set("AntiAdvertise.Kick", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AdvertiseKickMessage") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AdvertiseKickMessage");
			ConfigManager.config.set("AdvertiseKickMessage", "&6&lKicked! &7Sending &6%type%&7 through PMs isn't allowed!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AdvertiseMessage") == null){
			sendNewConfigurationPathMessage("v1.3.7", "AdvertiseMessage");
			ConfigManager.config.set("AdvertiseMessage", "&7You're not allowed to send &6%type%&7 through Private Messages!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("TypeVariableIPs") == null){
			sendNewConfigurationPathMessage("v1.3.7", "TypeVariableIPs");
			ConfigManager.config.set("TypeVariableIPs", "IPs");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("TypeVariableDomainNames") == null){
			sendNewConfigurationPathMessage("v1.3.7", "TypeVariableDomainNames");
			ConfigManager.config.set("TypeVariableDomainNames", "websites");
			ConfigManager.saveConfig();
		}
		//v1.4.1
		
		//v1.4.3
		if(ConfigManager.config.get("Commands.Message") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Message");
			ConfigManager.config.set("Commands.Message", Arrays.asList("/msg", "/m", "/t", "/tell", "/w", "/whisper"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Reply") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Reply");
			ConfigManager.config.set("Commands.Reply", Arrays.asList("/r", "/reply"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Reload") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Reload");
			ConfigManager.config.set("Commands.Reload", Arrays.asList("/msgreload"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Spy") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Spy");
			ConfigManager.config.set("Commands.Spy", Arrays.asList("/msgspy"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Toggle") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Toggle");
			ConfigManager.config.set("Commands.Toggle", Arrays.asList("/msgtoggle"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Mute") == null){
			sendNewConfigurationPathMessage("v1.4.3", "Commands.Mute");
			ConfigManager.config.set("Commands.Mute", Arrays.asList("/msgmute"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ServerNames") == null){
			sendNewConfigurationPathMessage("v1.4.3", "ServerNames");
			ConfigManager.config.set("ServerNames.hub", "&b&lHub");
			ConfigManager.config.set("ServerNames.sg-1", "&6&lSG-1");
			ConfigManager.saveConfig();
		}
		//v1.4.5
		
		//v1.4.8
		if(ConfigManager.config.get("SpyMessage") == null){
			sendNewConfigurationPathMessage("v1.4.8", "SpyMessage");
			ConfigManager.config.set("SpyMessage", "&7[%server-sender%&7] &6%sender% &7> &7[%server-receiver%&7] &6%receiver%&7: &6%msg%");
			ConfigManager.saveConfig();
		}
		//v1.5.1
		if(ConfigManager.config.get("Log.ReadGlobal") == null){
			sendNewConfigurationPathMessage("v1.5.1", "Log.ReadGlobal");
			ConfigManager.config.set("Log.ReadGlobal", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("AntiSpam.DuplicateSensitivity") == null){
			sendNewConfigurationPathMessage("v1.5.1", "AntiSpam.DuplicateSensitivity");
			ConfigManager.config.set("AntiSpam.DuplicateSensitivity", 2);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Global") == null){
			sendNewConfigurationPathMessage("v1.5.1", "Commands.Global");
			ConfigManager.config.set("Commands.Global", Arrays.asList("/msgglobal"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("GlobalChat.PermissionRequiredForGlobalMessage") == null){
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.PermissionRequiredForGlobalMessage");
			ConfigManager.config.set("GlobalChat.PermissionRequiredForGlobalMessage", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("GlobalChat.GlobalMessage") == null){
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.GlobalMessage");
			ConfigManager.config.set("GlobalChat.GlobalMessage", "&7[&3&lGlobal&7] &7[%server-sender%&7] &6%sender%&7: &6%msg%");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("GlobalChat.UseAutoGlobalChat") == null){
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.UseAutoGlobalChat");
			ConfigManager.config.set("GlobalChat.UseAutoGlobalChat", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("GlobalChat.Groups") == null){
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.Groups.1.Servers");
			ConfigManager.config.set("GlobalChat.Groups.1.Servers", "sg-1|sg-2|sg-3");
			
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.Groups.1.Message");
			ConfigManager.config.set("GlobalChat.Groups.1.Message", "&7[%server-sender%&7] &6%sender%&7: &6%msg%");
			
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.Groups.2.Servers");
			ConfigManager.config.set("GlobalChat.Groups.2.Servers", "uhc-1|uhc-2|uhc-3");
			
			sendNewConfigurationPathMessage("v1.5.1", "GlobalChat.Groups.2.Message");
			ConfigManager.config.set("GlobalChat.Groups.2.Message", "&7[%server-sender%&7] &6%sender%&7: &6%msg%");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageGlobal") == null){
			sendNewConfigurationPathMessage("v1.5.1", "WrongUsageGlobal");
			ConfigManager.config.set("WrongUsageGlobal", "&7Use &6%cmd% <msg>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoGlobalPermission") == null){
			sendNewConfigurationPathMessage("v1.5.1", "NoGlobalPermission");
			ConfigManager.config.set("NoGlobalPermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		//v1.5.2
		if(ConfigManager.config.get("AntiSpam.GlobalCooldown") == null){
			sendNewConfigurationPathMessage("v1.5.2", "AntiSpam.GlobalCooldown");
			ConfigManager.config.set("AntiSpam.GlobalCooldown", 2);
			ConfigManager.saveConfig();
		}
		//v1.5.4
		if(ConfigManager.config.get("GlobalChat.Channels") == null){
			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Admins.Permission");
			ConfigManager.config.set("GlobalChat.Channels.Admins.Permission", "BungeeMSG.channels.admins");

			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Admins.Message");
			ConfigManager.config.set("GlobalChat.Channels.Admins.Message", "&7[&c&lAdmin&7] &7[%server-sender%&7] &6%sender%&7: &6%msg%");

			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Admins.StartingSymbol");
			ConfigManager.config.set("GlobalChat.Channels.Admins.StartingSymbol", "/admin ");

			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Staff.Permission");
			ConfigManager.config.set("GlobalChat.Channels.Staff.Permission", "BungeeMSG.channels.staff");

			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Staff.Message");
			ConfigManager.config.set("GlobalChat.Channels.Staff.Message", "&7[&b&lStaff&7] &7[%server-sender%&7] &6%sender%&7: &6%msg%");

			sendNewConfigurationPathMessage("v1.5.4", "GlobalChat.Channels.Staff.StartingSymbol");
			ConfigManager.config.set("GlobalChat.Channels.Staff.StartingSymbol", "@");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadChannels") == null){
			sendNewConfigurationPathMessage("v1.5.4", "Log.ReadChannels");
			ConfigManager.config.set("Log.ReadChannels", false);
			ConfigManager.saveConfig();
		}
		//v1.5.5
		//v1.5.6
		//v1.5.7
		if(ConfigManager.config.get("Commands.MuteAll") == null){
			sendNewConfigurationPathMessage("v1.5.7", "Commands.MuteAll");
			ConfigManager.config.set("Commands.MuteAll", Arrays.asList("/msgmuteall"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoMuteAllPermission") == null){
			sendNewConfigurationPathMessage("v1.5.7", "NoMuteAllPermission");
			ConfigManager.config.set("NoMuteAllPermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MuteAllToSender") == null){
			sendNewConfigurationPathMessage("v1.5.7", "MuteAllToSender");
			ConfigManager.config.set("MuteAllToSender", "&6Muted&7 all Players!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MuteAllToPlayer") == null){
			sendNewConfigurationPathMessage("v1.5.7", "MuteAllToPlayer");
			ConfigManager.config.set("MuteAllToPlayer", "&7You have been muted by &6%sender%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UnmuteAllToSender") == null){
			sendNewConfigurationPathMessage("v1.5.7", "UnmuteAllToSender");
			ConfigManager.config.set("UnmuteAllToSender", "&6Unmuted&7 all Players!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UnmuteAllToPlayer") == null){
			sendNewConfigurationPathMessage("v1.5.7", "UnmuteAllToPlayer");
			ConfigManager.config.set("UnmuteAllToPlayer", "&7You have been unmuted by &6%sender%&7!");
			ConfigManager.saveConfig();
		}
		//v1.6.1
		if(ConfigManager.config.get("Log.ReadMuteAll") == null){
			sendNewConfigurationPathMessage("v1.6.1", "Log.ReadMuteAll");
			ConfigManager.config.set("Log.ReadMuteAll", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Log.ReadIgnores") == null){
			sendNewConfigurationPathMessage("v1.6.1", "Log.ReadIgnores");
			ConfigManager.config.set("Log.ReadIgnores", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Ignore") == null){
			sendNewConfigurationPathMessage("v1.6.1", "Commands.Ignore");
			ConfigManager.config.set("Commands.Ignore", Arrays.asList("/ignore"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageIgnore") == null){
			sendNewConfigurationPathMessage("v1.6.1", "WrongUsageIgnore");
			ConfigManager.config.set("WrongUsageIgnore", "&7Use &6%cmd% <player>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoIgnorePermission") == null){
			sendNewConfigurationPathMessage("v1.6.1", "NoIgnorePermission");
			ConfigManager.config.set("NoIgnorePermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UseIgnorePermission") == null){
			sendNewConfigurationPathMessage("v1.6.1", "UseIgnorePermission");
			ConfigManager.config.set("UseIgnorePermission", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Ignore") == null){
			sendNewConfigurationPathMessage("v1.6.1", "Ignore");
			ConfigManager.config.set("Ignore", "&7You're now ignoring &6%ignored%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoIgnore") == null){
			sendNewConfigurationPathMessage("v1.6.1", "NoIgnore");
			ConfigManager.config.set("NoIgnore", "&7You're no longer ignoring &6%ignored%&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("IsIgnored") == null){
			sendNewConfigurationPathMessage("v1.6.1", "IsIgnored");
			ConfigManager.config.set("IsIgnored", "&7You ignored &6%receiver%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("TellSenderIfIgnored") == null){
			sendNewConfigurationPathMessage("v1.6.1", "TellSenderIfIgnored");
			ConfigManager.config.set("TellSenderIfIgnored", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("IgnoredMessage") == null){
			sendNewConfigurationPathMessage("v1.6.1", "IgnoredMessage");
			ConfigManager.config.set("IgnoredMessage", "&6%receiver%&7 ignored you.");
			ConfigManager.saveConfig();
		}
		//v1.6.2
		if(ConfigManager.config.get("GlobalChat.Channels") != null){
			int index = 0;
			for(String channel : ConfigManager.config.getSection("GlobalChat.Channels").getKeys()){
				if(ConfigManager.config.get("GlobalChat.Channels." + channel + ".ToggleSymbol") == null){
					sendNewConfigurationPathMessage("v1.6.2", "GlobalChat.Channels." + channel + ".ToggleSymbol");
					ConfigManager.config.set("GlobalChat.Channels." + channel + ".ToggleSymbol", Arrays.asList("!" + index));
					ConfigManager.saveConfig();
				}
				if(ConfigManager.config.get("GlobalChat.Channels." + channel + ".ToggleEnabled") == null){
					sendNewConfigurationPathMessage("v1.6.2", "GlobalChat.Channels." + channel + ".ToggleEnabled");
					ConfigManager.config.set("GlobalChat.Channels." + channel + ".ToggleEnabled", "&7[&e&l" + channel + "&7] &aEnabled&7 your &e" + channel + " Chat&7.");
					ConfigManager.saveConfig();
				}
				if(ConfigManager.config.get("GlobalChat.Channels." + channel + ".ToggleDisabled") == null){
					sendNewConfigurationPathMessage("v1.6.2", "GlobalChat.Channels." + channel + ".ToggleDisabled");
					ConfigManager.config.set("GlobalChat.Channels." + channel + ".ToggleDisabled", "&7[&e&l" + channel + "&7] &cDisabled&7 your &e" + channel + " Chat&7.");
					ConfigManager.saveConfig();
				}
				index++;
			}
		}
		//v1.6.3
		/* -- REMOVED
		if(ConfigManager.config.get("PlayerNameSuggest.UsePlayerNameSuggest") == null){
			sendNewConfigurationPathMessage("v1.6.3", "PlayerNameSuggest.UsePlayerNameSuggest");
			ConfigManager.config.set("PlayerNameSuggest.UsePlayerNameSuggest", true);
			ConfigManager.saveConfig();
		}*/
		if(ConfigManager.config.get("PlayerNameSuggest.HoverMessage") == null){
			sendNewConfigurationPathMessage("v1.6.3", "PlayerNameSuggest.HoverMessage");
			ConfigManager.config.set("PlayerNameSuggest.HoverMessage", "&7Click to message &6%receiver%&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("PlayerNameSuggest.SuggestedCommand") == null){
			sendNewConfigurationPathMessage("v1.6.3", "PlayerNameSuggest.SuggestedCommand");
			ConfigManager.config.set("PlayerNameSuggest.SuggestedCommand", "/msg %receiver%");
			ConfigManager.saveConfig();
		}
		//v1.6.4
		if(ConfigManager.config.get("NoMessagePermission") == null){
			sendNewConfigurationPathMessage("v1.6.4", "NoMessagePermission");
			ConfigManager.config.set("NoMessagePermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("NoReplyPermission") == null){
			sendNewConfigurationPathMessage("v1.6.4", "NoReplyPermission");
			ConfigManager.config.set("NoReplyPermission", "&7You do not have access to this command!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UseMessagePermission") == null){
			sendNewConfigurationPathMessage("v1.6.4", "UseMessagePermission");
			ConfigManager.config.set("UseMessagePermission", false);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UseReplyPermission") == null){
			sendNewConfigurationPathMessage("v1.6.4", "UseReplyPermission");
			ConfigManager.config.set("UseReplyPermission", false);
			ConfigManager.saveConfig();
		}
		//v1.6.6
		if(ConfigManager.config.get("GlobalChat.Broadcast") == null){
			sendNewConfigurationPathMessage("v1.6.6", "GlobalChat.Broadcast.Broadcast.Permission");
			ConfigManager.config.set("GlobalChat.Broadcast.Broadcast.Permission", "BungeeMSG.broadcast.broadcast");
			
			sendNewConfigurationPathMessage("v1.6.6", "GlobalChat.Broadcast.Broadcast.NoPermission");
			ConfigManager.config.set("GlobalChat.Broadcast.Broadcast.NoPermission", "&7You do not have access to this command!");
			
			sendNewConfigurationPathMessage("v1.6.6", "GlobalChat.Broadcast.Broadcast.WrongUsage");
			ConfigManager.config.set("GlobalChat.Broadcast.Broadcast.WrongUsage", "&7Use &6%cmd% <msg>&7.");

			sendNewConfigurationPathMessage("v1.6.6", "GlobalChat.Broadcast.Broadcast.Messages");
			ConfigManager.config.set("GlobalChat.Broadcast.Broadcast.Messages", Arrays.asList("&f", " &c&lBroadcast &7(&c%sender%&7)", "  &6%msg%"));

			sendNewConfigurationPathMessage("v1.6.6", "GlobalChat.Broadcast.Broadcast.Commands");
			ConfigManager.config.set("GlobalChat.Broadcast.Broadcast.Commands", Arrays.asList("/broadcast", "/bc"));
			ConfigManager.saveConfig();
		}
		//v1.6.7
		//v1.7.1
		if(ConfigManager.config.get("GlobalChat.AutoAnnounce") == null){
			sendNewConfigurationPathMessage("v1.7.1", "GlobalChat.AutoAnnounce.1.Delay");
			ConfigManager.config.set("GlobalChat.AutoAnnounce.1.Delay", 60);
			
			sendNewConfigurationPathMessage("v1.7.1", "GlobalChat.AutoAnnounce.1.Messages.1");
			ConfigManager.config.set("GlobalChat.AutoAnnounce.1.Messages.1", Arrays.asList("&f", " &6&lBungee&7&lMSG &7- &dAutoAnnouncer", "&f"));
			
			sendNewConfigurationPathMessage("v1.7.1", "GlobalChat.AutoAnnounce.1.Messages.2");
			ConfigManager.config.set("GlobalChat.AutoAnnounce.1.Messages.2", Arrays.asList("&f", " &6&lBungee&7&lMSG &7- &dNew v1.7.1 feature.", "&f"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("PlayerNameSuggest.UsePlayerNameSuggest") != null){
			sendRemovedConfigurationPathMessage("v1.7.1", "PlayerNameSuggest.UsePlayerNameSuggest");
			ConfigManager.config.set("PlayerNameSuggest.UsePlayerNameSuggest", null);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("PlayerNameSuggest.SuggestedPlayer") == null){
			sendNewConfigurationPathMessage("v1.7.1", "PlayerNameSuggest.SuggestedPlayer");
			ConfigManager.config.set("PlayerNameSuggest.SuggestedPlayer", "&6%receiver%");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageMuteAll") == null){
			sendNewConfigurationPathMessage("v1.7.1", "WrongUsageMuteAll");
			ConfigManager.config.set("WrongUsageMuteAll", "&7Use &6%cmd% &7or &6%cmd% <server>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("MuteServerToSender") == null){
			sendNewConfigurationPathMessage("v1.7.1", "MuteServerToSender");
			ConfigManager.config.set("MuteServerToSender", "&6Muted&7 all Players in %server-name%&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("UnmuteServerToSender") == null){
			sendNewConfigurationPathMessage("v1.7.1", "UnmuteServerToSender");
			ConfigManager.config.set("UnmuteServerToSender", "&6Unmuted&7 all Players in %server-name%&7!");
			ConfigManager.saveConfig();
		}
		//v1.7.2
		//v1.7.3
		if(ConfigManager.config.get("GlobalChat.AutoAnnounce") != null){
			for(String announcer : ConfigManager.config.getSection("GlobalChat.AutoAnnounce").getKeys()){
				if(ConfigManager.config.get("GlobalChat.AutoAnnounce." + announcer + ".Servers") == null){
					sendNewConfigurationPathMessage("v1.7.3", "GlobalChat.AutoAnnounce." + announcer + ".Servers");
					ConfigManager.config.set("GlobalChat.AutoAnnounce." + announcer + ".Servers", "[ALL]");
				}
			}
			ConfigManager.saveConfig();
		}
		//v1.7.4
		if(ConfigManager.config.get("Log.ReadReports") == null){
			sendNewConfigurationPathMessage("v1.7.4", "Log.ReadReports");
			ConfigManager.config.set("Log.ReadReports", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.Report") == null){
			sendNewConfigurationPathMessage("v1.7.4", "Commands.Report");
			ConfigManager.config.set("Commands.Report", Arrays.asList("/report"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageReport") == null){
			sendNewConfigurationPathMessage("v1.7.4", "WrongUsageReport");
			ConfigManager.config.set("WrongUsageReport", "&7Use &6%cmd% <player> <reason>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ReportCooldown") == null){
			sendNewConfigurationPathMessage("v1.7.4", "ReportCooldown");
			ConfigManager.config.set("ReportCooldown", 600);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ReportOnCooldown") == null){
			sendNewConfigurationPathMessage("v1.7.4", "ReportOnCooldown");
			ConfigManager.config.set("ReportOnCooldown", "&7You may only report a player once every &610 minutes&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ReportedMessage") == null){
			sendNewConfigurationPathMessage("v1.7.4", "ReportedMessage");
			ConfigManager.config.set("ReportedMessage", "&7Succesfully reported &6%reported%&7! (&6%reason%&7)");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("ReportedStaffMessage") == null){
			sendNewConfigurationPathMessage("v1.7.4", "ReportedStaffMessage");
			ConfigManager.config.set("ReportedStaffMessage", "&7[&cReport&7] [%server-sender%&7] &6%sender% &7-> [%server-reported%&7] &c%reported%&7. (&6%reason%&7)");
			ConfigManager.saveConfig();
		}
		//v1.7.6
		if(ConfigManager.config.get("Log.ReadHelpOps") == null){
			sendNewConfigurationPathMessage("v1.7.6", "Log.ReadHelpOps");
			ConfigManager.config.set("Log.ReadHelpOps", true);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("Commands.HelpOp") == null){
			sendNewConfigurationPathMessage("v1.7.6", "Commands.HelpOp");
			ConfigManager.config.set("Commands.HelpOp", Arrays.asList("/helpop"));
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("WrongUsageHelpOp") == null){
			sendNewConfigurationPathMessage("v1.7.6", "WrongUsageHelpOp");
			ConfigManager.config.set("WrongUsageHelpOp", "&7Use &6%cmd% <reason>&7.");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("HelpOpCooldown") == null){
			sendNewConfigurationPathMessage("v1.7.6", "HelpOpCooldown");
			ConfigManager.config.set("HelpOpCooldown", 300);
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("HelpOpOnCooldown") == null){
			sendNewConfigurationPathMessage("v1.7.6", "HelpOpOnCooldown");
			ConfigManager.config.set("HelpOpOnCooldown", "&7You may only ask for help every &65 minutes&7!");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("HelpOpMessage") == null){
			sendNewConfigurationPathMessage("v1.7.6", "HelpOpMessage");
			ConfigManager.config.set("HelpOpMessage", "&7Succesfully asked for help! (&6%reason%&7)");
			ConfigManager.saveConfig();
		}
		if(ConfigManager.config.get("HelpOpStaffMessage") == null){
			sendNewConfigurationPathMessage("v1.7.6", "HelpOpStaffMessage");
			ConfigManager.config.set("HelpOpStaffMessage", "&7[&dHelpOp&7] [%server-sender%&7] &6%sender%&7: &d%reason%");
			ConfigManager.saveConfig();
		}
	}
}
