package me.O_o_Fadi_o_O.SpigotSpleef.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.SpigotSpleef.utils.AbilityMotivier;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Arena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.ArenaSign;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Kit;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.KitSelector;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.LobbyItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Map;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.Message;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.NPC;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpectatorItemStack;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.SpleefPlayer;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeArena;
import me.O_o_Fadi_o_O.SpigotSpleef.utils.bungee.BungeeServer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;

public class StorageManager {

	/*
	 * BungeeCord
	 */
	
	public static boolean bungeecord = false;
	public static boolean ishubserver = false;
	public static String hubserver = "hub";
	public static int thisarenaidforhub = 1;
	public static String thisbungeeservername = "spleef-1";
	public static List<BungeeArena> bungeearenas = new ArrayList<BungeeArena>();;
	public static List<BungeeServer> bungeeservers = new ArrayList<BungeeServer>();
	public static boolean usemotd = true;
	public static boolean updatemaxplayers = true;
	
	/*
	 * Database
	 */
	
	public static boolean usemysql = false;
	public static boolean importfromplayerdata = false;
	public static String databasehostname = "";
	public static String databaseport = "";
	public static String databasename = "";
	public static String databaseusername = "";
	public static String databasepassword = "";
	
	/*
	 * Other
	 */
	
	public static String version = "v1.4.2";
	
	public static List<String> vips = new ArrayList<String>();
	public static HashMap<String, String> vippermission = new HashMap<String, String>();
	public static HashMap<String, Double> vipmultiplier = new HashMap<String, Double>();
	public static HashMap<String, String> vipmultipliername = new HashMap<String, String>();
	
	public static int lastarenaid = 0;
	public static HashMap<Player, Map> mapsetup = new HashMap<Player, Map>();
	public static HashMap<Player, Arena> arenasetup = new HashMap<Player, Arena>();
	
	public static List<Kit> kits = new ArrayList<Kit>();
	public static List<Arena> arenas = new ArrayList<Arena>();
	public static List<Map> maps = new ArrayList<Map>();
	public static List<ArenaSign> signs = new ArrayList<ArenaSign>();
	public static List<NPC> npcs = new ArrayList<NPC>();
	public static List<Message> messages = new ArrayList<Message>();
	public static List<AbilityMotivier> abilities = new ArrayList<AbilityMotivier>();
	public static List<TNTPrimed> instanttnt = new ArrayList<TNTPrimed>();
	public static HashMap<Projectile, Arena> projectiles = new HashMap<Projectile, Arena>();
	
	public static List<SpectatorItemStack> spectatorinv = new ArrayList<SpectatorItemStack>();
	public static List<LobbyItemStack> lobbyinv = new ArrayList<LobbyItemStack>();

	public static HashMap<Player, SpleefPlayer> spleefplayer = new HashMap<Player, SpleefPlayer>();
	
	public static Location minigameslobby;
		
	public static int maxplayers = 16;
	public static int minplayers = 2;//TODO: TO 3
	
	public static List<String> newplayerunlockedkits = Arrays.asList("1", "2");
	public static int newplayertokens = 0;
	
	public static List<String> startingmessageat = Arrays.asList("0:45", "0:30", "0:20", "0:10", "0:9", "0:8", "0:7", "0:6", "0:5", "0:4", "0:3", "0:2", "0:1");
	public static List<String> endingmessageat = Arrays.asList("5:0", "3:0", "1:0", "0:30", "0:10", "0:9", "0:8", "0:7", "0:6", "0:5", "0:4", "0:3", "0:2", "0:1");
	
	public static int waittimeminutes = 0;//TODO: 0
	public static int waittimeseconds = 15;//TODO: 30
	
	public static int warmuptimeseconds = 10;

	public static int maxgametimeminutes = 10;
	public static int maxgametimeseconds = 0;
	
	public static int endingtimeseconds = 10;
	
	public static boolean canpunch = true;
	
	public static boolean useperarenachat = true;
	
	public static int diewhenyis = 0;
	
	public static int tokensperkill = 3;
	public static int tokensfirstplace = 10;
	public static int tokenssecondsplace = 5;
	public static int tokensthirdplace = 3;
	
	public static boolean usevault = false;
	public static boolean usecustomtokens = true;

	public static boolean usecommandrewards = true;
	public static List<String> firstplacecommands = Arrays.asList("coins add %player% 100");
	public static List<String> secondplacecommands = Arrays.asList("coins add %player% 50");
	public static List<String> thirdplacecommands = Arrays.asList("coins add %player% 25");
	public static List<String> killcommands = Arrays.asList("coins add %player% 5");
	
	public static List<String> whitelistedcommands = Arrays.asList("/msg", "/r", "/me", "/reload");
	
	public static String scoreboardwaitingtitle = "&6&lSpigot&7&lSpleef";
	public static String scoreboardenoughplayerstitle = "&6&lSpigot&7&lSpleef";
	public static String scoreboardingametitle = "&6&lSpigot&7&lSpleef";

	public static List<String> scoreboardwaitingrows = Arrays.asList("", "&f&lWaiting%animated-dots%", " ", "&6&lPlayers", " &7%players%/%max-players%", "  ", "&e&lKit", " &7%kit-name%", "   ", "&f&lSpleef Tokens", " &7%tokens%", "    ", "&a&lMap", " &7%map-name%", "     ");
	public static List<String> scoreboardwaitingscores = Arrays.asList("14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0");
	public static List<String> scoreboardenoughplayersrows = Arrays.asList("", "&f&lStarting in &6&l%seconds%", " ", "&6&lPlayers", " &7%players%/%max-players%", "  ", "&e&lKit", " &7%kit-name%", "   ", "&f&lSpleef Tokens", " &7%tokens%", "    ", "&a&lMap", " &7%map-name%", "     ");
	public static List<String> scoreboardenoughplayersscores = Arrays.asList("14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0");
	public static List<String> scoreboardingamerows = Arrays.asList("", "&a&lPlayers", " &7%players%", " ", "&e&lSpectators", " &7%spectators%", "  ");
	public static List<String> scoreboardingamescores = Arrays.asList("6", "5", "4", "3", "2", "1", "0");

	public static List<String> signswaiting = Arrays.asList("&2&lSpleef-%arena-id%", "&a%players%&0/&a%max-players%", "&2&lJoin", "&a%animated-dots%");
	public static List<String> signsenoughplayers = Arrays.asList("&2&lSpleef-%arena-id%", "&a%players%&0/&a%max-players%", "&2&lJoin", "&a%minutes%m %seconds%s");
	public static List<String> signsfull = Arrays.asList("&4&lSpleef-%arena-id%", "&c%players%&0/&c%max-players%", "&4&lFull", "&c%minutes%m %seconds%s");
	public static List<String> signsingame = Arrays.asList("&6&lSpleef-%arena-id%", "&e%players%&0/&e%max-players%", "&6&lSpectate", "&e%minutes%m %seconds%s");
	public static List<String> signsrestarting = Arrays.asList("&4&m------------", "&c&lSpleef-%arena-id%", "&0&lRESTARTING", "&4&m------------");

	public static String npcinvwaitingname = "&2&lSpleef-%arena-id%";
	public static List<String> npcinvwaitinglore = Arrays.asList("&7&lStatus: &2&lJoin", "&7&lPlayers: &a&l%players%&7&l/&a&l%max-players%");
	public static Material npcinvwaitingmaterial = Material.STAINED_GLASS;
	public static int npcinvwaitingdurability = 5;
	public static String npcinvwaitingamount = "%players%";

	public static String npcinvenoughplayersname = "&2&lSpleef-%arena-id%";
	public static List<String> npcinvenoughplayerslore = Arrays.asList("&7&lStatus: &2&lJoin", "&7&lPlayers: &a&l%players%&7&l/&a&l%max-players%", "&7&lTime Left: &a&l%minutes%m %seconds%s");
	public static Material npcinvenoughplayersmaterial = Material.STAINED_GLASS;
	public static int npcinvenoughplayersdurability = 5;
	public static String npcinvenoughplayersamount = "%players%";

	public static String npcinvfullname = "&4&lSpleef-%arena-id%";
	public static List<String> npcinvfulllore = Arrays.asList("&7&lStatus: &4&lFull", "&7&lPlayers: &c&l%players%&7&l/&c&l%max-players%", "&7&lTime Left: &c&l%minutes%m %seconds%s");
	public static Material npcinvfullmaterial = Material.STAINED_GLASS;
	public static int npcinvfulldurability = 14;
	public static String npcinvfullamount = "%players%";

	public static String npcinvingamename = "&6&lSpleef-%arena-id%";
	public static List<String> npcinvingamelore = Arrays.asList("&7&lStatus: &6&lIn Game", "&7&lPlayers: &e&l%players%&7&l/&e&l%max-players%", "&7&lSpectators: &e&l%spectators%", "&7&lTime Left: &e&l%minutes%m %seconds%s");
	public static Material npcinvingamematerial = Material.STAINED_GLASS;
	public static int npcinvingamedurability = 4;
	public static String npcinvingameamount = "%players%";

	public static String npcinvrestartingname = "&6&lSpleef-%arena-id%";
	public static List<String> npcinvrestartinglore = Arrays.asList("&7&lStatus: &8&lRestarting%animated-dots%");
	public static Material npcinvrestartingmaterial = Material.STAINED_GLASS;
	public static int npcinvrestartingdurability = 15;
	public static String npcinvrestartingamount = "%players%";
	
	public static String motdwaiting = "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &a%players%&7/&a%max-players% &7Status: &aWaiting...";
	public static String motdenoughplayers = "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &a%players%&7/&a%max-players% &7Status: &aStarting in %seconds%...";
	public static String motdfull = "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &c%players%&7/&c%max-players% &7Status: &cFull";
	public static String motdingame = "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &7Players: &e%players%&7/&e%max-players% &7Status: &eIn Game";
	public static String motdrestarting = "&6&lSpigot&7&lSpleef &7- &c&lArena %arena-id% \n &4&lRESTARTING";
	
	public static ArenaSelector arenaselector;
	public static KitSelector kitselector;
	
	public static HashMap<String, String> blocktoblock = new HashMap<String, String>();
}
