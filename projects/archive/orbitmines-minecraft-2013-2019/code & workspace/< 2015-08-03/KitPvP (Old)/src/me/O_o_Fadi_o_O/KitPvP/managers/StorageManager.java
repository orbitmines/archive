package me.O_o_Fadi_o_O.KitPvP.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

public class StorageManager {
	
	public static List<String> VoteRewardsNotGiven = new ArrayList<String>();
	
	public static HashMap<String, Integer> omt = new HashMap<String, Integer>();
	public static HashMap<String, Integer> points = new HashMap<String, Integer>();
	public static HashMap<String, Integer> coins = new HashMap<String, Integer>();
	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> knight = new HashMap<String, Integer>();
	public static HashMap<String, Integer> archer = new HashMap<String, Integer>();
	public static HashMap<String, Integer> soldier = new HashMap<String, Integer>();
	public static HashMap<String, Integer> wizard = new HashMap<String, Integer>();
	public static HashMap<String, Integer> tank = new HashMap<String, Integer>();
	public static HashMap<String, Integer> drunk = new HashMap<String, Integer>();
	public static HashMap<String, Integer> pyro = new HashMap<String, Integer>();
	public static HashMap<String, Integer> bunny = new HashMap<String, Integer>();
	public static HashMap<String, Integer> necromancer = new HashMap<String, Integer>();
	public static HashMap<String, Integer> king = new HashMap<String, Integer>();
	public static HashMap<String, Integer> tree = new HashMap<String, Integer>();
	public static HashMap<String, Integer> blaze = new HashMap<String, Integer>();
	public static HashMap<String, Integer> tnt = new HashMap<String, Integer>();
	public static HashMap<String, Integer> fisherman = new HashMap<String, Integer>();
	public static HashMap<String, Integer> snowgolem = new HashMap<String, Integer>();
	public static HashMap<String, Integer> librarian = new HashMap<String, Integer>();
	public static HashMap<String, Integer> spider = new HashMap<String, Integer>();
	public static HashMap<String, Integer> villager = new HashMap<String, Integer>();
	public static HashMap<String, Integer> assassin = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lord = new HashMap<String, Integer>();
	public static HashMap<String, Integer> vampire = new HashMap<String, Integer>();
	public static HashMap<String, Integer> darkmage = new HashMap<String, Integer>();
	public static HashMap<String, Integer> beast = new HashMap<String, Integer>();
	public static HashMap<String, Integer> fish = new HashMap<String, Integer>();
	public static HashMap<String, Integer> heavy = new HashMap<String, Integer>();
	public static HashMap<String, Integer> grimreaper = new HashMap<String, Integer>();
	public static HashMap<String, Integer> miner = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> money = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> deaths = new HashMap<String, Integer>();
	public static HashMap<String, Integer> levels = new HashMap<String, Integer>();
	
	public static ArrayList<Projectile> arrow = new ArrayList<Projectile>();
	public static ArrayList<Projectile> necromancerarrowlvl1 = new ArrayList<Projectile>();
	public static ArrayList<Projectile> necromancerarrowlvl2 = new ArrayList<Projectile>();
	public static ArrayList<Projectile> tntlvl2 = new ArrayList<Projectile>();
	
	
	public static HashMap<Player, Boolean> IsLoaded = new HashMap<Player, Boolean>();
	
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
	
	public static HashMap<String, Integer> gadgetsPaintballs = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsCreeperLauncher = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsPetRide = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gadgetsBookExplosion = new HashMap<String, Integer>();
	
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
