package me.O_o_Fadi_o_O.Creative.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.Creative.utils.ChatColor;
import me.O_o_Fadi_o_O.Creative.utils.Disguise;
import me.O_o_Fadi_o_O.Creative.utils.Hat;
import me.O_o_Fadi_o_O.Creative.utils.Pet;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;
import me.O_o_Fadi_o_O.Creative.utils.Server;
import me.O_o_Fadi_o_O.Creative.utils.StaffRank;
import me.O_o_Fadi_o_O.Creative.utils.Trail;
import me.O_o_Fadi_o_O.Creative.utils.TrailType;
import me.O_o_Fadi_o_O.Creative.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class StorageManager {
	
	/*
	 * Creative
	 */
	
	public static int plotsamount = 0;
	
	public static HashMap<Player, Boolean> playerhasplot = new HashMap<Player, Boolean>();
	public static HashMap<Player, Integer> playersplotnumber = new HashMap<Player, Integer>();
	public static HashMap<Player, Location> playersplothomelocation = new HashMap<Player, Location>();
	public static HashMap<String, List<String>> playersplotmemberson = new HashMap<String, List<String>>();
	public static HashMap<Player, List<String>> playersworldeditaccess = new HashMap<Player, List<String>>();
	public static HashMap<Player, Integer> playerspvpplot = new HashMap<Player, Integer>();
	
	public static HashMap<Integer, String> plotcreateddate = new HashMap<Integer, String>();
	public static HashMap<Integer, DyeColor> plotcolor = new HashMap<Integer, DyeColor>();
	public static HashMap<Integer, Location> plotlocation = new HashMap<Integer, Location>();
	public static HashMap<Integer, String> plotowner = new HashMap<Integer, String>();
	public static HashMap<Integer, List<String>> plotmembers = new HashMap<Integer, List<String>>();
	public static HashMap<Integer, PlotMode> plotmode = new HashMap<Integer, PlotMode>();
	
	public static List<Player> playersinpvpsetup = new ArrayList<Player>();
	public static HashMap<Integer, Boolean> plotpvpsetupfinished = new HashMap<Integer, Boolean>();
	
	public static HashMap<Integer, Location> plotpvpspawnlocation = new HashMap<Integer, Location>();
	public static HashMap<Integer, List<Location>> plotpvpnpclocations = new HashMap<Integer, List<Location>>();
	public static HashMap<Integer, List<Location>> plotpvplocations = new HashMap<Integer, List<Location>>();
	public static HashMap<Integer, Boolean> plotpvpdrops = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Boolean> plotpvparrows = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, Boolean> plotpvpbuild = new HashMap<Integer, Boolean>();
	public static HashMap<Integer, List<String>> plotpvpkitnames = new HashMap<Integer, List<String>>();
	public static HashMap<Integer, List<ItemStack[]>> plotpvpkits = new HashMap<Integer, List<ItemStack[]>>();
	
	public static HashMap<Player, List<Inventory>> plotpvpinventories = new HashMap<Player, List<Inventory>>();
	
	public static HashMap<Integer, List<Player>> plotpvpplayersselectedkit = new HashMap<Integer, List<Player>>();
	public static HashMap<Integer, List<Player>> plotpvpplayers = new HashMap<Integer, List<Player>>();
	public static HashMap<Integer, Integer> plotpvpmaxplayers = new HashMap<Integer, Integer>();
	public static HashMap<Integer, List<Entity>> plotpvpnpcs = new HashMap<Integer, List<Entity>>();
	
	/*
	 * Server
	 */
	
	public static Server thisserver;
	public static HashMap<Server, Integer> onlineplayers = new HashMap<Server, Integer>();
	
	//public static String lastdonatorstring;
	
	//public static HashMap<Server, List<Block>> serverportals = new HashMap<Server, List<Block>>();
	
	/*
	 * Locations, Blocks
	 */
	
	public static World creativeworld = Bukkit.getWorld("Creative");
	public static World lobbyworld = Bukkit.getWorld("CreativeLobby");
	public static Location spawn;
	//public static Location lapisparkourlocation;
	//public static Location mindcraftlocation;
	//public static HashMap<Integer, List<Block>> mindcraftblocksforturn = new HashMap<Integer, List<Block>>();
	//public static HashMap<Integer, List<Block>> mindcraftblocksforturnstatus = new HashMap<Integer, List<Block>>();
	//public static Location mindcraftwinssignlocation;
	//public static Location mindcraftbestgamesignlocation;
	
	//public static Location topvoter1;
	//public static Location topvoter2;
	//public static Location topvoter3;
	//public static Location topvotersign1;
	//public static Location topvotersign2;
	//public static Location topvotersign3;
	
	//public static Location lastdonator;

	/*
	 * Entities
	 */
	
	public static Entity omtnpc;
	public static Entity ploteditornpc;
	
	public static HashMap<Entity, Entity> npcItem = new HashMap<Entity, Entity>(); 
	
	public static Entity alphanpc;
	public static Entity serverselector;
	//public static HashMap<Entity, Player> swapteleporter = new HashMap<Entity, Player>();
	//public static List<Entity> paintballs = new ArrayList<Entity>();
	//public static List<Entity> soccermagmacubes = new ArrayList<Entity>();
	//public static Entity lapisparkournpc;
	//public static Entity mindcraftnpc;
	//public static List<Entity> eggbombs = new ArrayList<Entity>();
	//public static List<Entity> fireballs = new ArrayList<Entity>();
	//public static List<Entity> inkbombs = new ArrayList<Entity>();
	//public static HashMap<Entity, Integer> inkbombtime = new HashMap<Entity, Integer>();
	//public static List<Entity> silverfishbombs = new ArrayList<Entity>();
	public static HashMap<Entity, Player> petowner = new HashMap<Entity, Player>();
	
	//public static List<Entity> snowgolemattackballs = new ArrayList<Entity>();
	
	public static List<Entity> armorstands = new ArrayList<Entity>();
	/*
	 * Player Data
	 */
	
	public static HashMap<Player, Integer> spawnteleporting = new HashMap<Player, Integer>();
	
	public static HashMap<Player, VIPRank> viprank = new HashMap<Player, VIPRank>();
	public static HashMap<Player, StaffRank> staffrank = new HashMap<Player, StaffRank>();
	
	public static HashMap<Player, EntityType> disguise = new HashMap<Player, EntityType>();
	
	public static HashMap<Player, Integer> orbitminestokens = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> vippoints = new HashMap<Player, Integer>();
	//public static HashMap<Player, Integer> minigamecoins = new HashMap<Player, Integer>();
	public static HashMap<UUID, Integer> votes = new HashMap<UUID, Integer>();
	//public static List<String> allvoters = new ArrayList<String>();
	public static List<String> pendingvoters = new ArrayList<String>();
	//public static HashMap<Player, Boolean> playersenabled = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Boolean> stackerenabled = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Boolean> scoreboardenabled = new HashMap<Player, Boolean>();
	public static HashMap<Player, Pet> pet = new HashMap<Player, Pet>();
	public static HashMap<Player, Boolean> opmodeenabled = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> loaded = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Boolean> usedmonthlyvippoints = new HashMap<Player, Boolean>();
	public static HashMap<Player, String> chatcolor = new HashMap<Player, String>();
	public static HashMap<Player, Trail> trail = new HashMap<Player, Trail>();
	//public static HashMap<Player, Color> fireworkcolor1 = new HashMap<Player, Color>();
	//public static HashMap<Player, Color> fireworkcolor2 = new HashMap<Player, Color>();
	//public static HashMap<Player, Color> fireworkfade1 = new HashMap<Player, Color>();
	//public static HashMap<Player, Color> fireworkfade2 = new HashMap<Player, Color>();
	//public static HashMap<Player, Boolean> fireworkflicker = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Boolean> fireworktrail = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Type> fireworktype = new HashMap<Player, Type>();
	//public static HashMap<Player, Integer> fireworkpasses = new HashMap<Player, Integer>();
	//public static List<Player> paintballsgadget = new ArrayList<Player>();
	//public static List<Player> creeperlaunchergadget = new ArrayList<Player>();
	//public static List<Player> petridegadget = new ArrayList<Player>();
	//public static List<Player> bookexplosiongadget = new ArrayList<Player>();
	//public static List<Player> swapteleportergadget = new ArrayList<Player>();
	//public static List<Player> magmacubesoccergadget = new ArrayList<Player>();
	//public static List<Player> snowmanattackgadget = new ArrayList<Player>();
	//public static List<Player> playersinlapisparkour = new ArrayList<Player>();
	//public static HashMap<Player, Boolean> completedlapisparkour = new HashMap<Player, Boolean>();
	//public static List<Player> playersinmindcraft = new ArrayList<Player>();
	//public static HashMap<Player, Integer> mindcraftcurrentturn = new HashMap<Player, Integer>();
	//public static HashMap<Player, List<String>> mindcraftblocksfromturns = new HashMap<Player, List<String>>();
	//public static HashMap<Player, List<String>> mindcraftstatusfromturns = new HashMap<Player, List<String>>();
	//public static HashMap<Player, String> mindcraftcorrectturn = new HashMap<Player, String>();
	//public static HashMap<Player, Integer> mindcraftwins = new HashMap<Player, Integer>();
	//public static HashMap<Player, Integer> mindcraftbestgame = new HashMap<Player, Integer>();
	//public static HashMap<Player, Boolean> petshroomtrail = new HashMap<Player, Boolean>();
	//public static HashMap<Player, Boolean> petbabypigs = new HashMap<Player, Boolean>();
	//public static HashMap<Player, List<Entity>> petbabypigsentities = new HashMap<Player, List<Entity>>();
	//public static HashMap<Player, Boolean> petsheepdisco = new HashMap<Player, Boolean>();
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
	//public static HashMap<Player, Entity> soccermagmacube = new HashMap<Player, Entity>();
	
	public static HashMap<TrailType, List<Player>> trailtypes = new HashMap<TrailType, List<Player>>();
	public static HashMap<Player, Integer> trailparticlesamount = new HashMap<Player, Integer>();
	public static HashMap<Player, TrailType> trailtype = new HashMap<Player, TrailType>();
	public static HashMap<Player, Boolean> hasunlockedtrail = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> trailspecial = new HashMap<Player, Boolean>();
	
	public static HashMap<Player, Integer> hatsinvpage = new HashMap<Player, Integer>();
	
	public static HashMap<Player, String> nickname = new HashMap<Player, String>();
	public static HashMap<Player, String> afk = new HashMap<Player, String>();
	
	//public static HashMap<Player, Integer> snowgolemattackseconds = new HashMap<Player, Integer>();
	//public static HashMap<Player, Entity> snowgolemattackitem = new HashMap<Player, Entity>();
	//public static HashMap<Player, List<Entity>> snowgolemattacksnowgolems = new HashMap<Player, List<Entity>>();
	
	/*
	 *
	 */
}
