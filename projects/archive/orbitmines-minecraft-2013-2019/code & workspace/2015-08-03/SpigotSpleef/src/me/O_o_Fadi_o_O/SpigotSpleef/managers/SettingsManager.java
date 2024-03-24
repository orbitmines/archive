package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeServer;

public class SettingsManager {

	public static void loadDatabaseSettings(){
		StorageManager.usemysql = ConfigManager.config.getBoolean("Settings.MySQLDatabase.UseMySQL");
		StorageManager.importfromplayerdata = ConfigManager.config.getBoolean("Settings.MySQLDatabase.ImportFromPlayerData");
		StorageManager.databasehostname = ConfigManager.config.getString("Settings.MySQLDatabase.hostname");
		StorageManager.databaseport = ConfigManager.config.getString("Settings.MySQLDatabase.port");
		StorageManager.databasename = ConfigManager.config.getString("Settings.MySQLDatabase.databasename");
		StorageManager.databaseusername = ConfigManager.config.getString("Settings.MySQLDatabase.username");
		StorageManager.databasepassword = ConfigManager.config.getString("Settings.MySQLDatabase.password");
	}
	
	public static void loadSettings(){
		StorageManager.bungeecord = ConfigManager.config.getBoolean("Settings.BungeeCord.BungeeCord");
		StorageManager.ishubserver = ConfigManager.config.getBoolean("Settings.BungeeCord.IsHubServer");
		StorageManager.hubserver = ConfigManager.config.getString("Settings.BungeeCord.HubServer");
		StorageManager.thisarenaidforhub = ConfigManager.config.getInt("Settings.BungeeCord.ThisArenaIDForHub");
		StorageManager.thisbungeeservername = ConfigManager.config.getString("Settings.BungeeCord.ThisBungeeServerName");
		for(String arenaid : ConfigManager.config.getConfigurationSection("Settings.BungeeCord.ServersIfHubServer").getKeys(false)){
			BungeeServer server = new BungeeServer(ConfigManager.config.getString("Settings.BungeeCord.ServersIfHubServer." + arenaid), Integer.parseInt(arenaid));
			StorageManager.bungeeservers.add(server);
		}
		StorageManager.usemotd = ConfigManager.config.getBoolean("Settings.BungeeCord.MOTD.UseMOTD");
		StorageManager.updatemaxplayers = ConfigManager.config.getBoolean("Settings.BungeeCord.MOTD.UpdateMaxPlayers");
		
		if(ConfigManager.config.contains("Settings.VIPRanks")){
			for(String vip : ConfigManager.config.getConfigurationSection("Settings.VIPRanks").getKeys(false)){
				StorageManager.vips.add(vip);
				StorageManager.vippermission.put(vip, ConfigManager.config.getString("Settings.VIPRanks." + vip + ".Permission"));
				StorageManager.vipmultiplier.put(vip, ConfigManager.config.getDouble("Settings.VIPRanks." + vip + ".Multiplier"));
				StorageManager.vipmultipliername.put(vip, ConfigManager.config.getString("Settings.VIPRanks." + vip + ".MultiplierName"));
			}
		}
		
		StorageManager.maxplayers = ConfigManager.config.getInt("Settings.MaxPlayers");
		StorageManager.minplayers = ConfigManager.config.getInt("Settings.MinPlayers");
		
		StorageManager.newplayerunlockedkits = Arrays.asList(ConfigManager.config.getString("Settings.NewPlayerUnlockedKits").replace(" ", "").split("\\|"));
		StorageManager.newplayertokens = ConfigManager.config.getInt("Settings.NewPlayerTokens");
		
		StorageManager.startingmessageat = Arrays.asList(ConfigManager.config.getString("Settings.StartingMessage").replace(" ", "").split("\\|"));
		StorageManager.endingmessageat = Arrays.asList(ConfigManager.config.getString("Settings.EndingMessage").replace(" ", "").split("\\|"));

		StorageManager.waittimeminutes = ConfigManager.config.getInt("Settings.WaitTimeMinutes");
		StorageManager.waittimeseconds = ConfigManager.config.getInt("Settings.WaitTimeSeconds");

		StorageManager.warmuptimeseconds = ConfigManager.config.getInt("Settings.WarmupTimeSeconds");

		StorageManager.maxgametimeminutes = ConfigManager.config.getInt("Settings.MaxGameTimeMinutes");
		StorageManager.maxgametimeseconds = ConfigManager.config.getInt("Settings.MaxGameTimeSeconds");

		StorageManager.endingtimeseconds = ConfigManager.config.getInt("Settings.EndingTimeSeconds");

		StorageManager.canpunch = ConfigManager.config.getBoolean("Settings.CanPunch");

		StorageManager.useperarenachat = ConfigManager.config.getBoolean("Settings.UsePerArenaChat");

		StorageManager.diewhenyis = ConfigManager.config.getInt("Settings.DieWhenYIs");
		
		StorageManager.tokensperkill = ConfigManager.config.getInt("Settings.TokensPerKill");
		StorageManager.tokensfirstplace = ConfigManager.config.getInt("Settings.TokensFirstPlace");
		StorageManager.tokenssecondsplace = ConfigManager.config.getInt("Settings.TokensSecondPlace");
		StorageManager.tokensthirdplace = ConfigManager.config.getInt("Settings.TokensThirdPlace");
		
		StorageManager.usevault = ConfigManager.config.getBoolean("Settings.TokenMotivier.UseVault");
		StorageManager.usecustomtokens = ConfigManager.config.getBoolean("Settings.TokenMotivier.UseCustomTokens");

		StorageManager.usecommandrewards = ConfigManager.config.getBoolean("Settings.CommandRewards.UseCommandRewards");
		StorageManager.firstplacecommands = stringListToLowercase(ConfigManager.config.getStringList("Settings.CommandRewards.FirstPlace"));
		StorageManager.secondplacecommands = stringListToLowercase(ConfigManager.config.getStringList("Settings.CommandRewards.SecondPlace"));
		StorageManager.thirdplacecommands = stringListToLowercase(ConfigManager.config.getStringList("Settings.CommandRewards.ThirdPlace"));
		StorageManager.killcommands = stringListToLowercase(ConfigManager.config.getStringList("Settings.CommandRewards.Kill"));
		
		StorageManager.whitelistedcommands = stringListToLowercase(ConfigManager.config.getStringList("Settings.WhitelistedCommands"));
		
		StorageManager.motdwaiting = ConfigManager.config.getString("Settings.MOTD.Waiting");
		StorageManager.motdenoughplayers = ConfigManager.config.getString("Settings.MOTD.EnoughPlayers");
		StorageManager.motdfull = ConfigManager.config.getString("Settings.MOTD.Full");
		StorageManager.motdingame = ConfigManager.config.getString("Settings.MOTD.InGame");
		StorageManager.motdrestarting = ConfigManager.config.getString("Settings.MOTD.Restarting");
		
		//Check for Vault plugin.
		Start.getInstance().setupEconomy();
	}
	
	private static List<String> stringListToLowercase(List<String> stringlist){
		List<String> lowercaselist = new ArrayList<String>();
		if(stringlist != null){
			for(String s : stringlist){
				lowercaselist.add(s.toLowerCase());
			}
		}
		return lowercaselist;
	}
}
