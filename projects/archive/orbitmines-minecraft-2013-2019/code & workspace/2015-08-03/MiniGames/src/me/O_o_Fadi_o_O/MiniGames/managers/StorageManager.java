package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.utils.ChatColor;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Disguise;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.Hat;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;
import me.O_o_Fadi_o_O.MiniGames.utils.Server;
import me.O_o_Fadi_o_O.MiniGames.utils.StaffRank;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import me.O_o_Fadi_o_O.MiniGames.utils.Trail;
import me.O_o_Fadi_o_O.MiniGames.utils.TrailType;
import me.O_o_Fadi_o_O.MiniGames.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;

public class StorageManager {
	
	/*
	 * Lobby
	 */
	
	public static List<Entity> lobbynpcs = new ArrayList<Entity>();
	public static HashMap<Entity, Location> lobbynpclocations = new HashMap<Entity, Location>();
	
	/*
	 * Game
	 */
	
	public static HashMap<Player, Game> playersgame = new HashMap<Player, Game>();
	public static HashMap<Player, Integer> playersarena = new HashMap<Player, Integer>();
	
	/*
	 * SurvivalGames
	 */
	//ARENA DATA
    public static HashMap<Integer, SurvivalGamesState> survivalgamesstate = new HashMap<Integer, SurvivalGamesState>();

    public static HashMap<Integer, Chest> survivalgamesallchestsarena1 = new HashMap<Integer, Chest>();
    public static HashMap<Integer, Chest> survivalgamesallchestsarena2 = new HashMap<Integer, Chest>();
    public static HashMap<Chest, Integer> survivalgameschests = new HashMap<Chest, Integer>();
    
    public static HashMap<Integer, Integer> survivalgamesminutes = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> survivalgamesseconds = new HashMap<Integer, Integer>();

	public static ArrayList<Player> playersinsurvivalgames = new ArrayList<Player>();
	public static ArrayList<Player> spectatorsinsurvivalgames = new ArrayList<Player>();
	public static ArrayList<Player> deadplayersinsurvivalgames = new ArrayList<Player>();
	public static ArrayList<Player> usedeffectinsurvivalgames = new ArrayList<Player>();

	public static HashMap<Player, Integer> survivalgamesroundkills = new HashMap<Player, Integer>();
	
	public static HashMap<Integer, Integer> survivalgamesboostermultiply = new HashMap<Integer, Integer>();
	
	public static HashMap<Integer, Player> survivalgameswinner = new HashMap<Integer, Player>();
	
	public static HashMap<Player, Location> survivalgamesplayerspawn = new HashMap<Player, Location>();
	
    public static HashMap<Integer, Integer> survivalgamesplayers = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> survivalgamesspectators = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> survivalgamesplayersdied = new HashMap<Integer, Integer>();
    
	public static HashMap<Integer, Boolean> survivalgamesenabled = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Location> survivalgameslobbylocation = new HashMap<Integer, Location>();
	public static HashMap<Integer, String> survivalgamescurrentmap = new HashMap<Integer, String>();
	
	public static HashMap<String, Location> survivalgamesspectatorlocation = new HashMap<String, Location>();
	public static HashMap<String, Location> survivalgamesspawnlocations = new HashMap<String, Location>();
	public static HashMap<String, Integer> survivalgamesspawnamount = new HashMap<String, Integer>();
	public static HashMap<String, String> survivalgamesbuiltby = new HashMap<String, String>();
	
	//STATS
	public static HashMap<Player, Integer> survivalgameskills = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> survivalgameswins = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> survivalgamesloses = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Integer> survivalgamesbeststreak = new HashMap<Player, Integer>();
	//
	
	/*
	 * ChickenFight
	 */
	//ARENA DATA
    public static HashMap<Integer, ChickenFightState> chickenfightstate = new HashMap<Integer, ChickenFightState>();

    public static HashMap<Integer, Integer> chickenfightminutes = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> chickenfightseconds = new HashMap<Integer, Integer>();

	public static ArrayList<Player> playersinchickenfight = new ArrayList<Player>();
	public static ArrayList<Player> spectatorsinchickenfight = new ArrayList<Player>();
	public static ArrayList<Player> deadplayersinchickenfight = new ArrayList<Player>();
	public static ArrayList<Player> usedeffectinchickenfight = new ArrayList<Player>();

	public static HashMap<Player, Integer> chickenfightroundkills = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> chickenfightroundsecondssurvived = new HashMap<Player, Integer>();
	public static HashMap<Player, String> chickenfightkit = new HashMap<Player, String>();
	
	public static HashMap<Integer, Boolean> chickenfightgameeffectspeed = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Boolean> chickenfightgameeffectblindness = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Boolean> chickenfightgameeffectjump = new HashMap<Integer, Boolean>();
	
	public static HashMap<Integer, Integer> chickenfightboostermultiply = new HashMap<Integer, Integer>();
	
	public static HashMap<Integer, Player> chickenfightwinner = new HashMap<Integer, Player>();
	
    public static HashMap<Integer, Integer> chickenfightplayers = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> chickenfightspectators = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> chickenfightplayersdied = new HashMap<Integer, Integer>();
    
	public static HashMap<Integer, Boolean> chickenfightenabled = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Location> chickenfightlobbylocation = new HashMap<Integer, Location>();
	public static HashMap<Integer, String> chickenfightcurrentmap = new HashMap<Integer, String>();
	
	public static HashMap<String, Location> chickenfightspectatorlocation = new HashMap<String, Location>();
	public static HashMap<String, Location> chickenfightspawnlocations = new HashMap<String, Location>();
	public static HashMap<String, Integer> chickenfightspawnamount = new HashMap<String, Integer>();
	public static HashMap<String, String> chickenfightbuiltby = new HashMap<String, String>();

	// STATS
	public static HashMap<Player, Integer> chickenfightkills = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> chickenfightwins = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> chickenfightloses = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Integer> chickenfightbeststreak = new HashMap<Player, Integer>();
	
	// KITS
	public static HashMap<Player, Boolean> kitchickenmama = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> kitbabychicken = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> kithotwing = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> kitchickenwarrior = new HashMap<Player, Boolean>();
	
	// NPCS
	public static HashMap<Integer, Chicken> kitchickenmamaequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kitchickenmamaunequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kitchickenmamaLocked = new HashMap<Integer, Chicken>();

	public static HashMap<Integer, Chicken> kitbabychickenequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kitbabychickenunequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kitbabychickenLocked = new HashMap<Integer, Chicken>();
	
	public static HashMap<Integer, Chicken> kithotwingequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kithotwingunequiped = new HashMap<Integer, Chicken>();
	public static HashMap<Integer, Chicken> kithotwingLocked = new HashMap<Integer, Chicken>();

	public static HashMap<Integer, IronGolem> kitchickenwarriorequiped = new HashMap<Integer, IronGolem>();
	public static HashMap<Integer, IronGolem> kitchickenwarriorunequiped = new HashMap<Integer, IronGolem>();
	public static HashMap<Integer, IronGolem> kitchickenwarriorLocked = new HashMap<Integer, IronGolem>();
	
	/*
	 * Server
	 */
	
	public static Server thisserver;
	public static HashMap<Server, Integer> onlineplayers = new HashMap<Server, Integer>();
	
	/*
	 * Locations, Blocks
	 */
	
	public static World lobbyworld = Bukkit.getWorld("MiniGamesLobby");
	public static Location spawn;
	
	/*
	 * Entities
	 */
	
	public static HashMap<Entity, Entity> npcItem = new HashMap<Entity, Entity>(); 
	
	public static Entity alphanpc;
	public static Entity serverselector;
	public static HashMap<Entity, Player> swapteleporter = new HashMap<Entity, Player>();
	public static List<Entity> paintballs = new ArrayList<Entity>();
	public static List<Entity> soccermagmacubes = new ArrayList<Entity>();

	public static List<Entity> eggbombs = new ArrayList<Entity>();
	public static List<Entity> fireballs = new ArrayList<Entity>();
	public static List<Entity> inkbombs = new ArrayList<Entity>();
	public static HashMap<Entity, Integer> inkbombtime = new HashMap<Entity, Integer>();
	public static List<Entity> silverfishbombs = new ArrayList<Entity>();
	public static HashMap<Entity, Player> petowner = new HashMap<Entity, Player>();
	
	public static List<Entity> snowgolemattackballs = new ArrayList<Entity>();
	
	public static List<Entity> armorstands = new ArrayList<Entity>();
	
	public static Entity chickenfightnpc;
	public static Entity survivalgamesnpc;
	/*
	 * Player Data
	 */
	public static HashMap<Player, VIPRank> viprank = new HashMap<Player, VIPRank>();
	public static HashMap<Player, StaffRank> staffrank = new HashMap<Player, StaffRank>();
	
	public static HashMap<Player, EntityType> disguise = new HashMap<Player, EntityType>();
	
	public static HashMap<Player, Integer> orbitminestokens = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> vippoints = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> minigamecoins = new HashMap<Player, Integer>();
	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	public static List<String> allvoters = new ArrayList<String>();
	public static List<String> pendingvoters = new ArrayList<String>();

	public static HashMap<Player, Pet> pet = new HashMap<Player, Pet>();
	public static HashMap<Player, Boolean> opmodeenabled = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> loaded = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> usedmonthlyvippoints = new HashMap<Player, Boolean>();
	public static HashMap<Player, String> chatcolor = new HashMap<Player, String>();
	public static HashMap<Player, Trail> trail = new HashMap<Player, Trail>();
	public static HashMap<Player, Color> fireworkcolor1 = new HashMap<Player, Color>();
	public static HashMap<Player, Color> fireworkcolor2 = new HashMap<Player, Color>();
	public static HashMap<Player, Color> fireworkfade1 = new HashMap<Player, Color>();
	public static HashMap<Player, Color> fireworkfade2 = new HashMap<Player, Color>();
	public static HashMap<Player, Boolean> fireworkflicker = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> fireworktrail = new HashMap<Player, Boolean>();
	public static HashMap<Player, Type> fireworktype = new HashMap<Player, Type>();
	public static HashMap<Player, Integer> fireworkpasses = new HashMap<Player, Integer>();
	public static List<Player> paintballsgadget = new ArrayList<Player>();
	public static List<Player> creeperlaunchergadget = new ArrayList<Player>();
	public static List<Player> petridegadget = new ArrayList<Player>();
	public static List<Player> bookexplosiongadget = new ArrayList<Player>();
	public static List<Player> swapteleportergadget = new ArrayList<Player>();
	public static List<Player> magmacubesoccergadget = new ArrayList<Player>();
	public static List<Player> snowmanattackgadget = new ArrayList<Player>();
	public static HashMap<Player, Boolean> petshroomtrail = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> petbabypigs = new HashMap<Player, Boolean>();
	public static HashMap<Player, List<Entity>> petbabypigsentities = new HashMap<Player, List<Entity>>();
	public static HashMap<Player, Boolean> petsheepdisco = new HashMap<Player, Boolean>();
	public static HashMap<Player, String> squidpet = new HashMap<Player, String>();
	public static HashMap<Player, String> spiderpet = new HashMap<Player, String>();
	public static HashMap<Player, String> mushroomcowpet = new HashMap<Player, String>();
	public static HashMap<Player, String> magmacubepet = new HashMap<Player, String>();
	public static HashMap<Player, String> pigpet = new HashMap<Player, String>();
	public static HashMap<Player, String> slimepet = new HashMap<Player, String>();
	public static HashMap<Player, String> wolfpet = new HashMap<Player, String>();
	public static HashMap<Player, String> cowpet = new HashMap<Player, String>();
	public static HashMap<Player, String> sheeppet = new HashMap<Player, String>();
	public static HashMap<Player, String> silverfishpet = new HashMap<Player, String>();
	public static HashMap<Player, String> horsepet = new HashMap<Player, String>();
	public static HashMap<Player, String> ocelotpet = new HashMap<Player, String>();
	public static HashMap<Player, String> creeperpet = new HashMap<Player, String>();
	public static HashMap<Player, String> chickenpet = new HashMap<Player, String>();
	public static HashMap<Player, Boolean> boldchatcolor = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> cursivechatcolor = new HashMap<Player, Boolean>();
	public static HashMap<ChatColor, List<Player>> chatcolors = new HashMap<ChatColor, List<Player>>();
	public static HashMap<Disguise, List<Player>> disguises = new HashMap<Disguise, List<Player>>();
	public static HashMap<Player, Boolean> wardrobedisco = new HashMap<Player, Boolean>();
	public static HashMap<Player, List<Color>> wardrobeunlockedcolors = new HashMap<Player, List<Color>>();
	public static HashMap<Player, Boolean> hasunlockedhat = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> hasunlockedpet = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> hatsblocktrail = new HashMap<Player, Boolean>();
	public static HashMap<Color, List<Player>> wardrobearmor = new HashMap<Color, List<Player>>();
	public static HashMap<Trail, List<Player>> trails = new HashMap<Trail, List<Player>>();
	public static HashMap<Hat, List<Player>> hats = new HashMap<Hat, List<Player>>();
	public static HashMap<Player, Entity> petentity = new HashMap<Player, Entity>();
	public static HashMap<Player, Entity> soccermagmacube = new HashMap<Player, Entity>();
	
	public static HashMap<TrailType, List<Player>> trailtypes = new HashMap<TrailType, List<Player>>();
	public static HashMap<Player, Integer> trailparticlesamount = new HashMap<Player, Integer>();
	public static HashMap<Player, TrailType> trailtype = new HashMap<Player, TrailType>();
	public static HashMap<Player, Boolean> hasunlockedtrail = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> trailspecial = new HashMap<Player, Boolean>();
	
	public static HashMap<Player, Integer> hatsinvpage = new HashMap<Player, Integer>();
	
	public static HashMap<Player, String> nickname = new HashMap<Player, String>();
	public static HashMap<Player, String> afk = new HashMap<Player, String>();
	
	public static HashMap<Player, Integer> snowgolemattackseconds = new HashMap<Player, Integer>();
	public static HashMap<Player, Entity> snowgolemattackitem = new HashMap<Player, Entity>();
	public static HashMap<Player, List<Entity>> snowgolemattacksnowgolems = new HashMap<Player, List<Entity>>();

	/*
	 *
	 */
}
