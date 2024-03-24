package me.O_o_Fadi_o_O.SpigotSpleef;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomBat;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCaveSpider;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomChicken;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCow;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomEnderman;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomEndermite;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomGhast;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomHorse;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomIronGolem;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomPig;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomPigZombie;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomRabbit;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSheep;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSlime;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSnowman;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSpider;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSquid;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomVillager;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomWitch;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomWolf;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomZombie;
import me.O_o_Fadi_o_O.SpigotSpleef.events.BreakEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.ClickEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.DamageEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.DropEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.ExplodeEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.FoodEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.InteractEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.JoinEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.MoveEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.PickupEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.PingEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.PlaceEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.PlayerChat;
import me.O_o_Fadi_o_O.SpigotSpleef.events.ProjHitEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.ProjShootEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.QuitEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.events.UnloadChunkEvent;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.AbilityManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ArenaManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ArenaSelectorManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.BlockManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.BungeeManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ConfigManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.DatabaseManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.KitManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.KitSelectorManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.LobbyManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.MapManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.MessageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.NPCManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.PlayerDataManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.ScoreboardManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.SettingsManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.SignManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.SpectatorManager;
import me.O_o_Fadi_o_O.SpigotSpleef.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.MessageName;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPCType;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Update;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin {

	public static Start plugin;
	public static Economy economy = null;
	
	public void onEnable(){
		plugin = this;
		registerNMS();
		
		setupEconomy();
		
		ConfigManager.setup();
		
		SettingsManager.loadDatabaseSettings();
		loadDatabase();
		
		loadMetrics();
		checkforNewVersion();
		checkForOlderConfig();
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeManager());
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "SpigotSpleef");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "SpigotSpleef", new BungeeManager());
		
		registerEvents();
		
		new BukkitRunnable(){
			public void run(){
				loadConfigData();
				loadMessagesData();
				loadMapsData();
				loadArenasData();
				
				if(StorageManager.usemysql == true){
					DatabaseManager.createTable();
					insertPlayerDataToMySQL();
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					PlayerDataManager.loadPlayerData(p);
				}
				
				clearNPCs();
			}
		}.runTaskLater(this, 100);
	}
	
	public void onDisable(){
		removeAllNPCs();

		if(StorageManager.bungeecord == true && StorageManager.ishubserver == false || StorageManager.bungeecord == false){
			for(Arena arena : StorageManager.arenas){
				for(SpleefPlayer sp : arena.getAllPlayers()){
					sp.getPlayer().setGameMode(GameMode.SURVIVAL);
					sp.getPlayer().setAllowFlight(false);
					sp.getPlayer().setFlying(false);
					sp.clearInventory();
					sp.teleportToLobby();
					sp.setArena(null);
				}
				arena.resetScoreboard();
				arena.resetMap();
				arena.cancelArena();
			}
		}
		if(StorageManager.bungeecord == true){
			for(SpleefPlayer sp : StorageManager.spleefplayer.values()){
				sp.teleportToLobby();
			}
		}
	}
	
	public static void loadMessagesData(){
		MessageManager.loadMessages();
	}
	
	public static void loadMapsData(){
		MapManager.loadMaps();
	}
	
	public static void loadArenasData(){
		ArenaManager.loadArenas();
	}
	
	public static void loadConfigData(){
		SettingsManager.loadSettings();
		SettingsManager.loadDatabaseSettings();
		SignManager.loadSigns();
		ScoreboardManager.loadScoreboards();
		LobbyManager.loadLobbyInventory();
		SpectatorManager.loadSpectatorInventory();
		ArenaSelectorManager.loadArenaSelector();
		KitSelectorManager.loadKitSelector();
		KitManager.loadKits();
		AbilityManager.loadAbilityMotiviers();
		BlockManager.loadBlocks();
	}
	
	public static Start getInstance(){
		return plugin;
	}
	
	private void loadDatabase(){
		if(StorageManager.usemysql == true){
			DatabaseManager.openConnection(StorageManager.databasehostname, StorageManager.databaseport, StorageManager.databasename, StorageManager.databaseusername, StorageManager.databasepassword);
		}
	}
	
	private void insertPlayerDataToMySQL(){
		if(StorageManager.usemysql == true && StorageManager.importfromplayerdata == true){
			for(String uuidstring : ConfigManager.playerdata.getConfigurationSection("players").getKeys(false)){
				if(!DatabaseManager.containsPath("uuid", "SpigotSpleef", UUID.fromString(uuidstring))){
					DatabaseManager.insertNewPlayer(UUID.fromString(uuidstring), ConfigManager.playerdata.getString("players." + uuidstring + ".Kits"), ConfigManager.playerdata.getInt("players." + uuidstring + ".Kills"), ConfigManager.playerdata.getInt("players." + uuidstring + ".Wins"), ConfigManager.playerdata.getInt("players." + uuidstring + ".Loses"), ConfigManager.playerdata.getInt("players." + uuidstring + ".Tokens"));
				}
			}
		}
	}
	
	private void checkforNewVersion(){
		String version = Update.getLatestVersion();
		if(version != null && !version.equals(StorageManager.version)){
			sendNewVersionMessage(version);
		}
	}
	
	private void loadMetrics(){
	    try{
	        Metrics metrics = new Metrics(this);
	        metrics.start();
	    }catch(IOException ex){
			Bukkit.getLogger().warning("[SpigotSpleef] Error while connecting to mcstats.org");
	    }
	}
	
    public boolean setupEconomy(){
    	if(StorageManager.usevault == true){
    		if(getServer().getPluginManager().getPlugin("Vault") != null){
		        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		        if(economyProvider != null){
		            economy = economyProvider.getProvider();
		        }
    		}
    		else{
    			Bukkit.getConsoleSender().sendMessage("");
    			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] §cCannot find the 'Vault' Plugin!");
    			Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] §cInstall it first before starting to use this plugin. (With UseVault set to true)");
    			Bukkit.getConsoleSender().sendMessage("");
    		}
    	}

        return (economy != null);
    }
	
	private void sendNewVersionMessage(String version){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] §aNew Version Available! (" + version + ")");
		Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] §ahttp://www.spigotmc.org/resources/spigotspleef.4997/");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	private void sendNewConfigurationPathMessage(String version, String path){
		Bukkit.getConsoleSender().sendMessage("[SpigotSpleef] §eCreating new Configuration Path for " + version + "! (" + path + ")");
	}
	
	private void checkForOlderConfig(){
		//v1.2.1
		if(!ConfigManager.config.contains("Settings.BungeeCord.BungeeCord")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.BungeeCord");
			ConfigManager.config.set("Settings.BungeeCord.BungeeCord", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.IsHubServer")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.IsHubServer");
			ConfigManager.config.set("Settings.BungeeCord.IsHubServer", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.HubServer")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.HubServer");
			ConfigManager.config.set("Settings.BungeeCord.HubServer", "hub");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.ThisArenaIDForHub")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.ThisArenaIDForHub");
			ConfigManager.config.set("Settings.BungeeCord.ThisArenaIDForHub", 1);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.ThisBungeeServerName")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.ThisBungeeServerName");
			ConfigManager.config.set("Settings.BungeeCord.ThisBungeeServerName", "spleef-1");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.ServersIfHubServer")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.ServersIfHubServer.1");
			ConfigManager.config.set("Settings.BungeeCord.ServersIfHubServer.1", "spleef-1");
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.ServersIfHubServer.2");
			ConfigManager.config.set("Settings.BungeeCord.ServersIfHubServer.2", "spleef-2");
			sendNewConfigurationPathMessage("v1.2.1", "Settings.BungeeCord.ServersIfHubServer.3");
			ConfigManager.config.set("Settings.BungeeCord.ServersIfHubServer.3", "spleef-3");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.UseMySQL")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.UseMySQL");
			ConfigManager.config.set("Settings.MySQLDatabase.UseMySQL", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.ImportFromPlayerData")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.ImportFromPlayerData");
			ConfigManager.config.set("Settings.MySQLDatabase.ImportFromPlayerData", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.hostname")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.hostname");
			ConfigManager.config.set("Settings.MySQLDatabase.hostname", "");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.port")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.port");
			ConfigManager.config.set("Settings.MySQLDatabase.port", "");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.databasename")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.databasename");
			ConfigManager.config.set("Settings.MySQLDatabase.databasename", "");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.username")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.username");
			ConfigManager.config.set("Settings.MySQLDatabase.username", "");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MySQLDatabase.password")){
			sendNewConfigurationPathMessage("v1.2.1", "Settings.MySQLDatabase.password");
			ConfigManager.config.set("Settings.MySQLDatabase.password", "");
			ConfigManager.saveConfig();
		}
		//v1.2.3
		if(!ConfigManager.config.contains("Settings.VIPRanks")){
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.VIP.Permission");
			ConfigManager.config.set("Settings.VIPRanks.VIP.Permission", "SpigotSpleef.multiplier.vip");
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.VIP.Multiplier");
			ConfigManager.config.set("Settings.VIPRanks.VIP.Multiplier", 2.0);
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.VIP.MultiplierName");
			ConfigManager.config.set("Settings.VIPRanks.VIP.MultiplierName", " &6&lx2 VIP");
			
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.MVP.Permission");
			ConfigManager.config.set("Settings.VIPRanks.MVP.Permission", "SpigotSpleef.multiplier.mvp");
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.MVP.Multiplier");
			ConfigManager.config.set("Settings.VIPRanks.MVP.Multiplier", 3.0);
			sendNewConfigurationPathMessage("v1.2.3", "Settings.VIPRanks.MVP.MultiplierName");
			ConfigManager.config.set("Settings.VIPRanks.MVP.MultiplierName", " &6&lx3 MVP");
			
			ConfigManager.saveConfig();
		}
		//v1.2.4
		//v1.3.1
		if(!ConfigManager.config.contains("Settings.BungeeCord.MOTD.UseMOTD")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.BungeeCord.MOTD.UseMOTD");
			ConfigManager.config.set("Settings.BungeeCord.MOTD.UseMOTD", true);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.BungeeCord.MOTD.UpdateMaxPlayers")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.BungeeCord.MOTD.UpdateMaxPlayers");
			ConfigManager.config.set("Settings.BungeeCord.MOTD.UpdateMaxPlayers", true);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MOTD.Waiting")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.MOTD.Waiting");
			ConfigManager.config.set("Settings.MOTD.Waiting", "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &a%players%&7/&a%max-players% &7Status: &aWaiting...");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MOTD.EnoughPlayers")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.MOTD.EnoughPlayers");
			ConfigManager.config.set("Settings.MOTD.EnoughPlayers", "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &a%players%&7/&a%max-players% &7Status: &aStarting in %seconds%...");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MOTD.Full")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.MOTD.Full");
			ConfigManager.config.set("Settings.MOTD.Full", "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &c%players%&7/&c%max-players% &7Status: &cFull");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MOTD.InGame")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.MOTD.InGame");
			ConfigManager.config.set("Settings.MOTD.InGame", "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &e%players%&7/&e%max-players% &7Status: &eIn Game");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.MOTD.Restarting")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.MOTD.Restarting");
			ConfigManager.config.set("Settings.MOTD.Restarting", "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &4&lRESTARTING");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.WhitelistedCommands")){
			sendNewConfigurationPathMessage("v1.3.1", "Settings.WhitelistedCommands");
			ConfigManager.config.set("Settings.WhitelistedCommands", Arrays.asList("/msg", "/r", "/me", "/reload"));
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("AbilityMotiviers.THROW_EGG")){
			sendNewConfigurationPathMessage("v1.3.1", "AbilityMotiviers.THROW_EGG.Cooldown");
			ConfigManager.config.set("AbilityMotiviers.THROW_EGG.Cooldown", 0);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.messages.contains("Messages.ThrowEggOnCooldown")){
			sendNewConfigurationPathMessage("v1.3.1", "Messages.ThrowEggOnCooldown.Message");
			ConfigManager.messages.set("Messages.ThrowEggOnCooldown.Message", "&6&lSpigot&7&lSpleef &7| &7You can use &6Throw Egg&7 in &6%cooldown%&7...");
			ConfigManager.saveMessage();;
		}
		if(!ConfigManager.messages.contains("Messages.WrongUsageOpenKitSelector")){
			sendNewConfigurationPathMessage("v1.3.1", "Messages.WrongUsageOpenKitSelector.Message");
			ConfigManager.messages.set("Messages.WrongUsageOpenKitSelector.Message", "&6&lSpigot&7&lSpleef &7| &7Use &6/spleef openks|openkitselector <kit-id>&7.");
			ConfigManager.saveMessage();;
		}
		if(!ConfigManager.messages.contains("Messages.UnknownKit")){
			sendNewConfigurationPathMessage("v1.3.1", "Messages.UnknownKit.Message");
			ConfigManager.messages.set("Messages.UnknownKit.Message", "&6&lSpigot&7&lSpleef &7| &7That &6Kit&7 doesn't exist!");
			ConfigManager.saveMessage();;
		}
		if(!ConfigManager.messages.contains("Messages.NotInArena")){
			sendNewConfigurationPathMessage("v1.3.1", "Messages.NotInArena.Message");
			ConfigManager.messages.set("Messages.NotInArena.Message", "&6&lSpigot&7&lSpleef &7| &7You're not in an &6Arena&7!");
			ConfigManager.saveMessage();;
		}
		//v1.3.2
		//v1.4.1
		if(!ConfigManager.config.contains("AbilityMotiviers.SPEED_BOOST")){
			sendNewConfigurationPathMessage("v1.4.1", "AbilityMotiviers.SPEED_BOOST.Cooldown");
			ConfigManager.config.set("AbilityMotiviers.SPEED_BOOST.Cooldown", 10);

			sendNewConfigurationPathMessage("v1.4.1", "AbilityMotiviers.SPEED_BOOST.Power");
			ConfigManager.config.set("AbilityMotiviers.SPEED_BOOST.Power", 2);

			sendNewConfigurationPathMessage("v1.4.1", "AbilityMotiviers.SPEED_BOOST.Duration");
			ConfigManager.config.set("AbilityMotiviers.SPEED_BOOST.Duration", 4);
			
			sendNewConfigurationPathMessage("v1.4.1", "AbilityMotiviers.SPEED_BOOST.Sound");
			ConfigManager.config.set("AbilityMotiviers.SPEED_BOOST.Sound", "DRINK");
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.CommandRewards.UseCommandRewards")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.CommandRewards.UseCommandRewards");
			ConfigManager.config.set("Settings.CommandRewards.UseCommandRewards", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.CommandRewards.FirstPlace")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.CommandRewards.FirstPlace");
			ConfigManager.config.set("Settings.CommandRewards.FirstPlace", Arrays.asList("coins add %player% 100"));
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.CommandRewards.SecondPlace")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.CommandRewards.SecondPlace");
			ConfigManager.config.set("Settings.CommandRewards.SecondPlace", Arrays.asList("coins add %player% 50"));
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.CommandRewards.ThirdPlace")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.CommandRewards.ThirdPlace");
			ConfigManager.config.set("Settings.CommandRewards.ThirdPlace", Arrays.asList("coins add %player% 25"));
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.CommandRewards.Kill")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.CommandRewards.Kill");
			ConfigManager.config.set("Settings.CommandRewards.Kill", Arrays.asList("coins add %player% 5"));
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.TokenMotivier.UseVault")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.TokenMotivier.UseVault");
			ConfigManager.config.set("Settings.TokenMotivier.UseVault", false);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.config.contains("Settings.TokenMotivier.UseCustomTokens")){
			sendNewConfigurationPathMessage("v1.4.1", "Settings.TokenMotivier.UseCustomTokens");
			ConfigManager.config.set("Settings.TokenMotivier.UseCustomTokens", true);
			ConfigManager.saveConfig();
		}
		if(!ConfigManager.messages.contains("Messages.SpeedBoostUsage")){
			sendNewConfigurationPathMessage("v1.4.1", "Messages.SpeedBoostUsage.Message");
			ConfigManager.messages.set("Messages.SpeedBoostUsage.Message", "&6&lSpigot&7&lSpleef &7| &7You used &6Speed Boost&7!");
			ConfigManager.saveMessage();;
		}
		if(!ConfigManager.messages.contains("Messages.SpeedBoostOnCooldown")){
			sendNewConfigurationPathMessage("v1.4.1", "Messages.SpeedBoostOnCooldown.Message");
			ConfigManager.messages.set("Messages.SpeedBoostOnCooldown.Message", "&6&lSpigot&7&lSpleef &7| &7You can use &6Speed Boost&7 in &6%cooldown%&7...");
			ConfigManager.saveMessage();;
		}
		//v1.4.2
		if(!ConfigManager.config.contains("AbilityMotiviers.RUNNER")){
			sendNewConfigurationPathMessage("v1.4.1", "AbilityMotiviers.RUNNER.Duration");
			ConfigManager.config.set("AbilityMotiviers.RUNNER.Duration", 2);
			ConfigManager.saveConfig();
		}
	}
	
	private void clearNPCs(){
		for(NPC npc : StorageManager.npcs){
			for(Entity en : npc.getEntity().getNearbyEntities(0.01, 0.01, 0.01)){
				if(!(en instanceof Player)){
					en.remove();
				}
			}
		}
	}
	
	private void registerEvents(){
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new MoveEvent(), this);
		getServer().getPluginManager().registerEvents(new PickupEvent(), this);
		getServer().getPluginManager().registerEvents(new PingEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new ProjHitEvent(), this);
		getServer().getPluginManager().registerEvents(new ProjShootEvent(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new UnloadChunkEvent(), this);
	}
	
	public static boolean hasPermission(CommandSender sender, String... perms){
		for(String perm : perms){
			if(sender.hasPermission("SpigotSpleef." + perm)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {

		if(cmd.getName().equalsIgnoreCase("spleef")){
			if(a.length > 0){
				if(a[0].equalsIgnoreCase("reload")){
					if(hasPermission(sender, "reload", "*")){
						checkforNewVersion();
						
						sender.sendMessage("§7Saving §6NPCs§7...");
						ArenaManager.saveArenaSelectors();
						ArenaManager.saveKitSelectors();
						sender.sendMessage("§7Cleaning up §6Arenas§7, §6NPCs§7, §6Player Data §7& §6Maps§7...");
						onDisable();
						StorageManager.vips.clear();
						StorageManager.vippermission.clear();
						StorageManager.vipmultiplier.clear();
						StorageManager.vipmultipliername.clear();
						StorageManager.mapsetup.clear();
						StorageManager.arenasetup.clear();
						StorageManager.kits.clear();
						StorageManager.arenas.clear();
						StorageManager.maps.clear();
						StorageManager.signs.clear();
						StorageManager.npcs.clear();
						StorageManager.messages.clear();
						StorageManager.abilities.clear();
						StorageManager.instanttnt.clear();
						StorageManager.projectiles.clear();
						StorageManager.spectatorinv.clear();
						StorageManager.lobbyinv.clear();
						StorageManager.spleefplayer.clear();
						StorageManager.scoreboardwaitingrows.clear();
						StorageManager.scoreboardwaitingscores.clear();
						StorageManager.scoreboardenoughplayersrows.clear();
						StorageManager.scoreboardenoughplayersscores.clear();
						StorageManager.scoreboardingamerows.clear();
						StorageManager.scoreboardingamescores.clear();
						StorageManager.signswaiting.clear();
						StorageManager.signsenoughplayers.clear();
						StorageManager.signsfull.clear();
						StorageManager.signsingame.clear();
						StorageManager.signsrestarting.clear();
						StorageManager.npcinvwaitinglore.clear();
						StorageManager.npcinvenoughplayerslore.clear();
						StorageManager.npcinvfulllore.clear();
						StorageManager.npcinvingamelore.clear();
						StorageManager.npcinvrestartinglore.clear();
						StorageManager.blocktoblock.clear();
						if(StorageManager.bungeecord == true){
							sender.sendMessage("§7Cleaning up §6BungeeCord Data§7...");
							StorageManager.bungeearenas.clear();
							StorageManager.bungeeservers.clear();
						}
						sender.sendMessage("§7Reloading §6config.yml§7...");
						ConfigManager.reloadConfig();
						loadConfigData();
						sender.sendMessage("§7Reloading §6messages.yml§7...");
						ConfigManager.reloadMessages();
						loadMessagesData();
						sender.sendMessage("§7Reloading §6maps.yml§7...");
						ConfigManager.reloadMaps();
						loadMapsData();
						sender.sendMessage("§7Reloading §6arenas.yml§7...");
						ConfigManager.reloadArenas();
						loadArenasData();
						sender.sendMessage("§7Reloading §6playerdata.yml§7...");
						ConfigManager.reloadPlayerData();
						
						if(StorageManager.usemysql == true){
							sender.sendMessage("§7Preparing §6MySQL§7...");
							DatabaseManager.createTable();
							insertPlayerDataToMySQL();
						}
						
						int players = Bukkit.getOnlinePlayers().size();
						
						if(players != 1){
							sender.sendMessage("§7Restoring Player Data for §6" + players + " Players§7...");
						}
						else{
							sender.sendMessage("§7Restoring Player Data for §6" + players + " Player§7...");
						}
						
						for(Player p : Bukkit.getOnlinePlayers()){
							PlayerDataManager.loadPlayerData(p);
						}
						
						sender.sendMessage("§7Reload §aComplete§7!");
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_RELOAD);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("setlobby")){
					if(hasPermission(sender, "setlobby", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
								
							ArenaManager.setMiniGamesLobby(p);
							
							Message m = Message.getMessage(MessageName.SET_LOBBY);
							m.replace("&", "§");
							m.send(sender);
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_SET_LOBBY);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("editnpc")){
					if(hasPermission(sender, "npc.edit", "npc.*", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
							
							NPC closest = StorageManager.spleefplayer.get(p).getNearestNPC();
							
							if(closest != null){
								NPCManager.openNPCInventory(p, closest);
							}
							else{
								Message m = Message.getMessage(MessageName.NO_NEARBY_NPCS);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_EDIT_NPC);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("openas") || a[0].equalsIgnoreCase("openarenaselector")){
					if(sender instanceof Player){
						Player p = (Player) sender;
						SpleefPlayer sp = StorageManager.spleefplayer.get(p);	
						
						sp.openArenaSelector();
					}
					else{
						Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("openks") || a[0].equalsIgnoreCase("openkitselector")){
					if(sender instanceof Player){
						Player p = (Player) sender;
						if(a.length == 2){
							try{
								SpleefPlayer sp = StorageManager.spleefplayer.get(p);	
								
								sp.openKitSelector(Kit.getKitFromID(Integer.parseInt(a[1])));
							}catch(NumberFormatException ex){
								Message m = Message.getMessage(MessageName.WRONG_USAGE_OPEN_KIT_SELECTOR);
								m.replace("&", "§");
								m.send(p);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.WRONG_USAGE_OPEN_KIT_SELECTOR);
							m.replace("&", "§");
							m.send(p);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("addas") || a[0].equalsIgnoreCase("addarenaselector")){
					if(hasPermission(sender, "arenaselector.add", "arenaselector.*", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
								
							NPC npc = new NPC(NPCType.ARENA_SELECTOR, EntityType.BLAZE, "&6&lSpigot&7&lSpleef", null, null, null);
							npc.newEntity(EntityType.BLAZE, p.getLocation(), "§6§lSpigot§7§lSpleef");
							StorageManager.npcs.add(npc);
							ArenaManager.saveArenaSelectors();

							Message m = Message.getMessage(MessageName.SPAWN_ARENA_SELECTOR);
							m.replace("&", "§");
							m.send(sender);
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_ADD_ARENA_SELECTOR);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("removeas") || a[0].equalsIgnoreCase("removearenaselector")){
					if(hasPermission(sender, "arenaselector.remove", "arenaselector.*", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;

							NPC closest = StorageManager.spleefplayer.get(p).getNearestNPC();
							
							if(closest != null && closest.getNPCType() == NPCType.ARENA_SELECTOR){
								closest.getEntity().remove();
								closest.getItem().remove();
								StorageManager.npcs.remove(closest);
								ArenaManager.saveArenaSelectors();

								Message m = Message.getMessage(MessageName.REMOVE_ARENA_SELECTOR);
								m.replace("&", "§");
								m.send(sender);
							}
							else{
								Message m = Message.getMessage(MessageName.NO_NEARBY_NPCS);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_REMOVE_ARENA_SELECTOR);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("addks") || a[0].equalsIgnoreCase("addkitselector")){
					if(hasPermission(sender, "addkitselector.add", "addkitselector.*", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
								
							NPC npc = new NPC(NPCType.KIT_SELECTOR, EntityType.BLAZE, "&7&lSelect &6&l%kit-name%", null, null, StorageManager.kits.get(0));
							npc.newEntity(EntityType.BLAZE, p.getLocation(), "&7&lSelect &6&l" + StorageManager.kits.get(0).getName());
							StorageManager.npcs.add(npc);
							ArenaManager.saveKitSelectors();

							Message m = Message.getMessage(MessageName.SPAWN_KIT_SELECTOR);
							m.replace("&", "§");
							m.send(sender);
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_ADD_KIT_SELECTOR);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("removeks") || a[0].equalsIgnoreCase("removekitselector")){
					if(hasPermission(sender, "kitselector.remove", "kitselector.*", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;

							NPC closest = StorageManager.spleefplayer.get(p).getNearestNPC();
							
							if(closest != null && closest.getNPCType() == NPCType.KIT_SELECTOR){
								closest.getEntity().remove();
								closest.getItem().remove();
								StorageManager.npcs.remove(closest);
								ArenaManager.saveKitSelectors();

								Message m = Message.getMessage(MessageName.REMOVE_KIT_SELECTOR);
								m.replace("&", "§");
								m.send(sender);
							}
							else{
								Message m = Message.getMessage(MessageName.NO_NEARBY_NPCS);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_REMOVE_KIT_SELECTOR);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("setupmap")){
					if(hasPermission(sender, "setupmap", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
							
							if(a.length == 2){
								try{
									int mapid = Integer.parseInt(a[1]);
									
									MapManager.enterSetupMode(p, mapid);
								}catch(NumberFormatException ex){
									Message m = Message.getMessage(MessageName.NOT_A_NUMBER);
									m.replace("&", "§");
									m.replace("%arg%", a[1]);
									m.send(sender);
								}
							}
							else{
								Message m = Message.getMessage(MessageName.WRONG_USAGE_SETUP_MAP);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_SETUP_MAP);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("setuparena")){
					if(hasPermission(sender, "setuparena", "*")){
						if(sender instanceof Player){
							Player p = (Player) sender;
							
							if(a.length == 2){
								try{
									int arenaid = Integer.parseInt(a[1]);
									
									ArenaManager.enterSetupMode(p, arenaid);
								}catch(NumberFormatException ex){
									Message m = Message.getMessage(MessageName.NOT_A_NUMBER);
									m.replace("&", "§");
									m.replace("%arg%", a[1]);
									m.send(sender);
								}
							}
							else{
								Message m = Message.getMessage(MessageName.WRONG_USAGE_SETUP_ARENA);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.THROUGH_CONSOLE);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_SETUP_ARENA);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("stats")){
					if(hasPermission(sender, "stats", "*")){
						if(a.length == 2){
							Player p = null;
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(player.getName().equalsIgnoreCase(a[1])){
									p = player;
								}
							}
							
							if(p != null){
								SpleefPlayer sp = StorageManager.spleefplayer.get(p);
								
								Message m = Message.getMessage(MessageName.STATS);
								m.replace("&", "§");
								m.replace("%player%", p.getName());
								m.replace("%won%", "" + sp.getWins());
								m.replace("%lost%", "" + sp.getLoses());
								m.replace("%kills%", "" + sp.getKills());
								m.replace("%tokens%", "" + sp.getTokens());
								m.send(sender);
							}
							else{
								Message m = Message.getMessage(MessageName.NOT_ONLINE);
								m.replace("&", "§");
								m.replace("%player%", a[1]);
								m.send(sender);
							}
						}
						else{
							Message m = Message.getMessage(MessageName.WRONG_USAGE_STATS);
							m.replace("&", "§");
							m.send(sender);
						}
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_STATS);
						m.replace("&", "§");
						m.send(sender);
					}
				}
				else if(a[0].equalsIgnoreCase("tokens")){
					if(a.length > 1){
						if(a[1].equalsIgnoreCase("show")){
							if(hasPermission(sender, "tokens.show", "tokens.*", "*")){
								if(a.length == 3){
									Player p = null;
									
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equalsIgnoreCase(a[2])){
											p = player;
										}
									}
									
									if(p != null){
										Message m = Message.getMessage(MessageName.TOKENS_SHOW);
										m.replace("&", "§");
										m.replace("%player%", p.getName());
										m.replace("%tokens%", "" + StorageManager.spleefplayer.get(p).getTokens());
										m.send(sender);
									}
									else{
										Message m = Message.getMessage(MessageName.NOT_ONLINE);
										m.replace("&", "§");
										m.replace("%player%", a[2]);
										m.send(sender);
									}
								}
								else{
									Message m = Message.getMessage(MessageName.WRONG_USAGE_TOKENS_SHOW);
									m.replace("&", "§");
									m.send(sender);
								}
							}
							else{
								Message m = Message.getMessage(MessageName.NO_PERM_TOKENS_SHOW);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else if(a[1].equalsIgnoreCase("add")){
							if(hasPermission(sender, "tokens.add", "tokens.*", "*")){
								if(a.length == 4){
									Player p = null;
									
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equalsIgnoreCase(a[2])){
											p = player;
										}
									}
									
									if(p != null){
										try{
											int amount = Integer.parseInt(a[3].replace("-", "").replace("+", "").replace("+", "").replace("/", ""));	
											
											SpleefPlayer sp = StorageManager.spleefplayer.get(p);
											sp.addTokens(amount);
											
											{
												Message m = Message.getMessage(MessageName.TOKENS_ADD_TO_SENDER);
												m.replace("&", "§");
												m.replace("%player%", p.getName());
												m.replace("%amount%", "" + amount);
												m.send(sender);
											}

											Message m = Message.getMessage(MessageName.TOKENS_ADD_TO_RECEIVER);
											m.replace("&", "§");
											m.replace("%amount%", "" + amount);
											m.send(p);
											
										}catch(NumberFormatException ex){
											Message m = Message.getMessage(MessageName.NOT_A_NUMBER);
											m.replace("&", "§");
											m.replace("%arg%", a[3]);
											m.send(sender);
										}
									}
									else{
										Message m = Message.getMessage(MessageName.NOT_ONLINE);
										m.replace("&", "§");
										m.replace("%player%", a[2]);
										m.send(sender);
									}
								}
								else{
									Message m = Message.getMessage(MessageName.WRONG_USAGE_TOKENS_ADD);
									m.replace("&", "§");
									m.send(sender);
								}
							}
							else{
								Message m = Message.getMessage(MessageName.NO_PERM_TOKENS_ADD);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else if(a[1].equalsIgnoreCase("remove")){
							if(hasPermission(sender, "tokens.remove", "tokens.*", "*")){
								if(a.length == 4){
									Player p = null;
									
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equalsIgnoreCase(a[2])){
											p = player;
										}
									}
									
									if(p != null){
										try{
											int amount = Integer.parseInt(a[3].replace("-", "").replace("+", "").replace("+", "").replace("/", ""));	
											
											SpleefPlayer sp = StorageManager.spleefplayer.get(p);
											sp.removeTokens(amount);
											
											{
												Message m = Message.getMessage(MessageName.TOKENS_REMOVE_TO_SENDER);
												m.replace("&", "§");
												m.replace("%player%", p.getName());
												m.replace("%amount%", "" + amount);
												m.send(sender);
											}

											Message m = Message.getMessage(MessageName.TOKENS_REMOVE_TO_RECEIVER);
											m.replace("&", "§");
											m.replace("%amount%", "" + amount);
											m.send(p);
											
										}catch(NumberFormatException ex){
											Message m = Message.getMessage(MessageName.NOT_A_NUMBER);
											m.replace("&", "§");
											m.replace("%arg%", a[3]);
											m.send(sender);
										}
									}
									else{
										Message m = Message.getMessage(MessageName.NOT_ONLINE);
										m.replace("&", "§");
										m.replace("%player%", a[2]);
										m.send(sender);
									}
								}
								else{
									Message m = Message.getMessage(MessageName.WRONG_USAGE_TOKENS_REMOVE);
									m.replace("&", "§");
									m.send(sender);
								}
							}
							else{
								Message m = Message.getMessage(MessageName.NO_PERM_TOKENS_REMOVE);
								m.replace("&", "§");
								m.send(sender);
							}
						}
						else{
							if(hasPermission(sender, "tokens.show", "tokens.add", "tokens.remove", "tokens.*", "*")){
								Message m = Message.getMessage(MessageName.WRONG_USAGE_TOKENS);
								m.replace("&", "§");
								m.send(sender);
							}
							else{
								Message m = Message.getMessage(MessageName.NO_PERM_TOKENS_ADD);
								m.replace("&", "§");
								m.send(sender);
							}
						}
					}
					else{
						if(hasPermission(sender, "tokens.show", "tokens.add", "tokens.remove", "tokens.*", "*")){
							Message m = Message.getMessage(MessageName.WRONG_USAGE_TOKENS);
							m.replace("&", "§");
							m.send(sender);
						}
						else{
							Message m = Message.getMessage(MessageName.NO_PERM_TOKENS_ADD);
							m.replace("&", "§");
							m.send(sender);
						}
					}
				}
				else{
					if(hasPermission(sender, "help", "*")){
						Message m = Message.getMessage(MessageName.HELP_MESSAGE);
						m.replace("&", "§");
						m.replace("%version%", StorageManager.version);
						m.send(sender);
					}
					else{
						Message m = Message.getMessage(MessageName.NO_PERM_HELP);
						m.replace("&", "§");
						m.send(sender);
					}
				}
			}
			else{
				if(hasPermission(sender, "help", "*")){
					Message m = Message.getMessage(MessageName.HELP_MESSAGE);
					m.replace("&", "§");
					m.replace("%version%", StorageManager.version);
					m.send(sender);
				}
				else{
					Message m = Message.getMessage(MessageName.NO_PERM_HELP);
					m.replace("&", "§");
					m.send(sender);
				}
			}
		}
		
		return false;
	}
	
	private void registerNMS(){
		addCustomEntity(CustomBat.class, "CustomBat", 65);
		addCustomEntity(CustomBlaze.class, "CustomBlaze", 61);
		addCustomEntity(CustomCaveSpider.class, "CustomCaveSpider", 59);
		addCustomEntity(CustomChicken.class, "CustomChicken", 93);
		addCustomEntity(CustomCow.class, "CustomCow", 92);
		addCustomEntity(CustomCreeper.class, "CustomCreeper", 50);
		addCustomEntity(CustomEnderman.class, "CustomEnderman", 58);
		addCustomEntity(CustomEndermite.class, "CustomEndermite", 67);
		addCustomEntity(CustomGhast.class, "CustomGhast", 56);
	//	addCustomEntity(CustomGuardian.class, "CustomGuardian", 68);
		addCustomEntity(CustomHorse.class, "CustomCreeper", 100);
		addCustomEntity(CustomIronGolem.class, "CustomIronGolem", 99);
		addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		addCustomEntity(CustomPig.class, "CustomPig", 90);
		addCustomEntity(CustomPigZombie.class, "CustomPigZombie", 57);
		addCustomEntity(CustomRabbit.class, "CustomRabbit", 101);
		addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 51);
		addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		addCustomEntity(CustomSnowman.class, "CustomSnowman", 97);
		addCustomEntity(CustomSpider.class, "CustomSpider", 52);
		addCustomEntity(CustomSquid.class, "CustomSquid", 94);
		addCustomEntity(CustomVillager.class, "CustomVillager", 120);
		addCustomEntity(CustomWitch.class, "CustomWitch", 66);
	//	addCustomEntity(CustomWither.class, "CustomWither", 64);
		addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		addCustomEntity(CustomZombie.class, "CustomZombie", 54);
	}
	
	private void removeAllNPCs(){
		for(NPC npc : StorageManager.npcs){
			npc.getEntity().remove();
			npc.getItem().remove();
		}
		StorageManager.npcs.clear();
	}
	
	protected static Field mapStringToClassField, mapClassToStringField, mapIdToClassField, mapClassToIdField, mapStringToIdField;

	static{
	   try{
	        mapStringToClassField = net.minecraft.server.v1_8_R2.EntityTypes.class.getDeclaredField("c");
	        mapClassToStringField = net.minecraft.server.v1_8_R2.EntityTypes.class.getDeclaredField("d");
	        mapClassToIdField = net.minecraft.server.v1_8_R2.EntityTypes.class.getDeclaredField("f");
	        mapStringToIdField = net.minecraft.server.v1_8_R2.EntityTypes.class.getDeclaredField("g");
	 
	        mapStringToClassField.setAccessible(true);
	        mapClassToStringField.setAccessible(true);
	        mapClassToIdField.setAccessible(true);
	        mapStringToIdField.setAccessible(true);
	    }
	    catch(Exception e){}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addCustomEntity(Class entityClass, String name, int id){
	    if (mapStringToClassField == null || mapStringToIdField == null || mapClassToStringField == null || mapClassToIdField == null){
	        return;
	    }
	    else{
	        try{
	            Map mapStringToClass = (Map) mapStringToClassField.get(null);
	            Map mapStringToId = (Map) mapStringToIdField.get(null);
	            Map mapClasstoString = (Map) mapClassToStringField.get(null);
	            Map mapClassToId = (Map) mapClassToIdField.get(null);
	 
	            mapStringToClass.put(name, entityClass);
	            mapStringToId.put(name, Integer.valueOf(id));
	            mapClasstoString.put(entityClass, name);
	            mapClassToId.put(entityClass, Integer.valueOf(id));
	 
	            mapStringToClassField.set(null, mapStringToClass);
	            mapStringToIdField.set(null, mapStringToId);
	            mapClassToStringField.set(null, mapClasstoString);
	            mapClassToIdField.set(null, mapClassToId);
	        }
	        catch(Exception e){}
	    }
	}
}
