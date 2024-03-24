package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;

public class StorageManager {
	
	public static HashMap<String, Integer> omt = new HashMap<String, Integer>();
	public static HashMap<String, Integer> points = new HashMap<String, Integer>();
	public static HashMap<String, Integer> coins = new HashMap<String, Integer>();
	
	public static HashMap<Player, Game> PlayersGame = new HashMap<Player, Game>();
	public static HashMap<Player, Integer> PlayersArena = new HashMap<Player, Integer>();
	
	public static Location Lobby = null;
	
	public static List<String> VoteRewardsNotGiven = new ArrayList<String>();
	
	public static HashMap<Player, Boolean> IsLoaded = new HashMap<Player, Boolean>();
	
	/*
	 * 
	 * Lobby
	 * 
	 */
	
	public static List<Entity> LobbyNPCs = new ArrayList<Entity>();
	public static HashMap<Entity, Location> LobbyNPCLocations = new HashMap<Entity, Location>();
	
	
	/*
	 * SurvivalGames
	 * 
	 */
	// ARENA DATA
	    public static HashMap<Integer, SurvivalGamesState> SurvivalGamesState = new HashMap<Integer, SurvivalGamesState>();
	
	    public static HashMap<Integer, Chest> SurvivalGamesAllChestsArena1 = new HashMap<Integer, Chest>();
	    public static HashMap<Integer, Chest> SurvivalGamesAllChestsArena2 = new HashMap<Integer, Chest>();
	    public static HashMap<Chest, Integer> SurvivalGamesChests = new HashMap<Chest, Integer>();
	    
	    public static HashMap<Integer, Integer> SurvivalGamesMinutes = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> SurvivalGamesSeconds = new HashMap<Integer, Integer>();
	
		public static ArrayList<Player> PlayersInSurvivalGames = new ArrayList<Player>();
		public static ArrayList<Player> SpectatorsInSurvivalGames = new ArrayList<Player>();
		public static ArrayList<Player> DeadPlayersInSurvivalGames = new ArrayList<Player>();
		public static ArrayList<Player> UsedEffectInSurvivalGames = new ArrayList<Player>();
	
		public static HashMap<Player, Integer> SurvivalGamesRoundKills = new HashMap<Player, Integer>();
		
		public static HashMap<Integer, Integer> SurvivalGamesBoosterMultiply = new HashMap<Integer, Integer>();
		
		public static HashMap<Integer, Player> SurvivalGamesWinner = new HashMap<Integer, Player>();
		
		public static HashMap<Player, Location> SurvivalGamesPlayerSpawn = new HashMap<Player, Location>();
		
	    public static HashMap<Integer, Integer> SurvivalGamesPlayers = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> SurvivalGamesSpectators = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> SurvivalGamesPlayersDied = new HashMap<Integer, Integer>();
	    
		public static HashMap<Integer, Boolean> SurvivalGamesEnabled = new HashMap<Integer, Boolean>();
		public static HashMap<Integer, Location> SurvivalGamesLobbyLocation = new HashMap<Integer, Location>();
		public static HashMap<Integer, String> SurvivalGamesCurrentMap = new HashMap<Integer, String>();
		
		public static HashMap<String, Location> SurvivalGamesSpectatorLocation = new HashMap<String, Location>();
		public static HashMap<String, Location> SurvivalGamesSpawnLocations = new HashMap<String, Location>();
		public static HashMap<String, Integer> SurvivalGamesSpawnAmount = new HashMap<String, Integer>();
		public static HashMap<String, String> SurvivalGamesBuiltBy = new HashMap<String, String>();
	//
	
	// STATS
		public static HashMap<String, Integer> SurvivalGamesKills = new HashMap<String, Integer>();
		public static HashMap<String, Integer> SurvivalGamesWins = new HashMap<String, Integer>();
		public static HashMap<String, Integer> SurvivalGamesLoses = new HashMap<String, Integer>();
		
		public static HashMap<String, Integer> SurvivalGamesBestStreak = new HashMap<String, Integer>();
	//
	
	/*
	 * ChickenFight
	 * 
	 */
	// ARENA DATA
	    public static HashMap<Integer, ChickenFightState> ChickenFightState = new HashMap<Integer, ChickenFightState>();
	
	    public static HashMap<Integer, Integer> ChickenFightMinutes = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> ChickenFightSeconds = new HashMap<Integer, Integer>();
	
		public static ArrayList<Player> PlayersInChickenFight = new ArrayList<Player>();
		public static ArrayList<Player> SpectatorsInChickenFight = new ArrayList<Player>();
		public static ArrayList<Player> DeadPlayersInChickenFight = new ArrayList<Player>();
		public static ArrayList<Player> UsedEffectInChickenFight = new ArrayList<Player>();
	
		public static HashMap<Player, Integer> ChickenFightRoundKills = new HashMap<Player, Integer>();
		public static HashMap<Player, Integer> ChickenFightRoundSecondsSurvived = new HashMap<Player, Integer>();
		public static HashMap<Player, String> ChickenFightKit = new HashMap<Player, String>();
		
		public static HashMap<Integer, Boolean> ChickenFightGameEffectSpeed = new HashMap<Integer, Boolean>();
		public static HashMap<Integer, Boolean> ChickenFightGameEffectBlindness = new HashMap<Integer, Boolean>();
		public static HashMap<Integer, Boolean> ChickenFightGameEffectJump = new HashMap<Integer, Boolean>();
		
		public static HashMap<Integer, Integer> ChickenFightBoosterMultiply = new HashMap<Integer, Integer>();
		
		public static HashMap<Integer, Player> ChickenFightWinner = new HashMap<Integer, Player>();
		
	    public static HashMap<Integer, Integer> ChickenFightPlayers = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> ChickenFightSpectators = new HashMap<Integer, Integer>();
	    public static HashMap<Integer, Integer> ChickenFightPlayersDied = new HashMap<Integer, Integer>();
	    
		public static HashMap<Integer, Boolean> ChickenFightEnabled = new HashMap<Integer, Boolean>();
		public static HashMap<Integer, Location> ChickenFightLobbyLocation = new HashMap<Integer, Location>();
		public static HashMap<Integer, String> ChickenFightCurrentMap = new HashMap<Integer, String>();
		
		public static HashMap<String, Location> ChickenFightSpectatorLocation = new HashMap<String, Location>();
		public static HashMap<String, Location> ChickenFightSpawnLocations = new HashMap<String, Location>();
		public static HashMap<String, Integer> ChickenFightSpawnAmount = new HashMap<String, Integer>();
		public static HashMap<String, String> ChickenFightBuiltBy = new HashMap<String, String>();
	//
	
	// STATS
		public static HashMap<String, Integer> ChickenFightKills = new HashMap<String, Integer>();
		public static HashMap<String, Integer> ChickenFightWins = new HashMap<String, Integer>();
		public static HashMap<String, Integer> ChickenFightLoses = new HashMap<String, Integer>();
		
		public static HashMap<String, Integer> ChickenFightBestStreak = new HashMap<String, Integer>();
	//
	
	// KITS
		public static HashMap<String, Boolean> KitChickenMama = new HashMap<String, Boolean>();
		public static HashMap<String, Boolean> KitBabyChicken = new HashMap<String, Boolean>();
		public static HashMap<String, Boolean> KitHotWing = new HashMap<String, Boolean>();
		public static HashMap<String, Boolean> KitChickenWarrior = new HashMap<String, Boolean>();
	//
		
	// NPCS
		public static HashMap<Integer, Chicken> KitChickenMamaEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitChickenMamaUnEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitChickenMamaLocked = new HashMap<Integer, Chicken>();
	
		public static HashMap<Integer, Chicken> KitBabyChickenEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitBabyChickenUnEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitBabyChickenLocked = new HashMap<Integer, Chicken>();
		
		public static HashMap<Integer, Chicken> KitHotWingEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitHotWingUnEquiped = new HashMap<Integer, Chicken>();
		public static HashMap<Integer, Chicken> KitHotWingLocked = new HashMap<Integer, Chicken>();
	
		public static HashMap<Integer, IronGolem> KitChickenWarriorEquiped = new HashMap<Integer, IronGolem>();
		public static HashMap<Integer, IronGolem> KitChickenWarriorUnEquiped = new HashMap<Integer, IronGolem>();
		public static HashMap<Integer, IronGolem> KitChickenWarriorLocked = new HashMap<Integer, IronGolem>();
	//
		
	/*
	 * 
	 * 
	 */
	
	
	
	
	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	// VIP : COSMETIC PERKS
	
	
	
	public static HashMap<Player, String> chatcolor = new HashMap<Player, String>();
	public static HashMap<Player, String> trail = new HashMap<Player, String>();
	
	
	/*
	 * Firework
	 * 
	 */
	
	public static HashMap<String, Color> FireworkColor1 = new HashMap<String, Color>();
	public static HashMap<String, Color> FireworkColor2 = new HashMap<String, Color>();
	public static HashMap<String, Color> FireworkFade1 = new HashMap<String, Color>();
	public static HashMap<String, Color> FireworkFade2 = new HashMap<String, Color>();
	public static HashMap<String, Boolean> FireworkFlicker = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> FireworkTrail = new HashMap<String, Boolean>();
	public static HashMap<String, Type> FireworkType = new HashMap<String, Type>();
	
	public static HashMap<String, Integer> FireworkPasses = new HashMap<String, Integer>();
	
	/*
	 * 
	 * 
	 */
	
	/*
	 * Gadgets
	 * 
	 */
	
	public static List<Entity> Paintballs = new ArrayList<Entity>();
	public static HashMap<Entity, Player> SwapTeleporter = new HashMap<Entity, Player>();
	
	public static HashMap<String, Integer> gadgetsPaintballs = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsCreeperLauncher = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsPetRide = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsBookExplosion = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsSwapTeleporter = new HashMap<String, Integer>();
	
	/*
	 *
	 * 
	 */
	
	public static HashMap<String, String> mushroomcow = new HashMap<String, String>();
	public static HashMap<String, String> pig = new HashMap<String, String>();
	public static HashMap<String, String> wolf = new HashMap<String, String>();
	public static HashMap<String, String> sheep = new HashMap<String, String>();
	public static HashMap<String, String> horse = new HashMap<String, String>();
	public static HashMap<String, String> magmacube = new HashMap<String, String>();
	public static HashMap<String, String> slime = new HashMap<String, String>();
	public static HashMap<String, String> cow = new HashMap<String, String>();
	public static HashMap<String, String> silverfish = new HashMap<String, String>();
	public static HashMap<String, String> ocelot = new HashMap<String, String>();
	
	public static HashMap<String, Integer> white = new HashMap<String, Integer>();
	public static HashMap<String, Integer> blue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> green = new HashMap<String, Integer>();
	public static HashMap<String, Integer> black = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lightblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> pink = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lightgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> darkblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> purple = new HashMap<String, Integer>();
	public static HashMap<String, Integer> orange = new HashMap<String, Integer>();
	public static HashMap<String, Integer> red = new HashMap<String, Integer>();
	public static HashMap<String, Integer> cyan = new HashMap<String, Integer>();
	public static HashMap<String, Integer> yellow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gray = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> chatcolorwhite = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkred = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorblack = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorlightblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorpink = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorlightgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorred = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkgray = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> trailsfirework = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailshappyvillager = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailshearts = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsexplode = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsslime = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailssmoke = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailswitch = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailscrit = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailswater = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsnote = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailssnow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsenchantmenttable = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsbubbles = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsangryvillager = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsmobspawner = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> hatsStoneBricks = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGreenGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCactus = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsSnow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsTNT = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCoalOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsBlackGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsFurnace = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsQuartzOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsHayBale = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedstoneOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsIce = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsWorkbench = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGrass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsBedrock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLapisOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedstoneBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsQuartzBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLapisBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMagentaGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCoalBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMelon = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsYellowGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMycelium = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLeaves = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsOrangeGlass = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> disWitch = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disBat = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disChicken = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disOcelot = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disMushroomCow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSquid = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSlime = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disZombiePigman = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disMagmaCube = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSkeleton = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disWolf = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSpider = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSilverfish = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSheep = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCaveSpider = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCreeper = new HashMap<String, Integer>();
	
	public static HashMap<UUID, Player> owners = new HashMap<UUID, Player>();
	public static HashMap<Player, UUID> ownerpets = new HashMap<Player, UUID>();
}
