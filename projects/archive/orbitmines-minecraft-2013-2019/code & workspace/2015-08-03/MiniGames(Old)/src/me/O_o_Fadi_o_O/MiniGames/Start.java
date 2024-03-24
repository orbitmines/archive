package me.O_o_Fadi_o_O.MiniGames;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.MiniGames.EntityHider.Policy;
import me.O_o_Fadi_o_O.MiniGames.NMS.ChickenKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomPig;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSheep;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSlime;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomWolf;
import me.O_o_Fadi_o_O.MiniGames.NMS.IronGolemKit;
import me.O_o_Fadi_o_O.MiniGames.events.BreakEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ClickEventENG;
import me.O_o_Fadi_o_O.MiniGames.events.DamageByEntity;
import me.O_o_Fadi_o_O.MiniGames.events.DamageEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DeathEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DropEvent;
import me.O_o_Fadi_o_O.MiniGames.events.EntityDeath;
import me.O_o_Fadi_o_O.MiniGames.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ExplodeEvent;
import me.O_o_Fadi_o_O.MiniGames.events.FoodLevelEvent;
import me.O_o_Fadi_o_O.MiniGames.events.InteractEvent;
import me.O_o_Fadi_o_O.MiniGames.events.JoinEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PickUpEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlaceEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerChat;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerMove;
import me.O_o_Fadi_o_O.MiniGames.events.ProjectileHit;
import me.O_o_Fadi_o_O.MiniGames.events.QuitEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ToggleFlightEvent;
import me.O_o_Fadi_o_O.MiniGames.inv.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.inv.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.kits.BabyChicken;
import me.O_o_Fadi_o_O.MiniGames.kits.ChickenMama;
import me.O_o_Fadi_o_O.MiniGames.kits.ChickenWarrior;
import me.O_o_Fadi_o_O.MiniGames.kits.HotWing;
import me.O_o_Fadi_o_O.MiniGames.kits.LobbyKit;
import me.O_o_Fadi_o_O.MiniGames.utils.State;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.AgeableWatcher;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;

public class Start extends JavaPlugin{
	
	public static EntityHider entityHider;
    public static EffectManager effectManager;
	public static State state;
	public Manager manager;
	
    public String Arena = "";
    public static String CurrentMap = "";
    public static String BuiltBy = "";
    
	public static HashMap<Player, String> chatcolor = new HashMap<Player, String>();
	public static HashMap<Player, String> trail = new HashMap<Player, String>();
	
	public static HashMap<String, Integer> omt = new HashMap<String, Integer>();
	public static HashMap<String, Integer> points = new HashMap<String, Integer>();
	public static HashMap<String, Integer> coins = new HashMap<String, Integer>();

	public static HashMap<String, String> Language = new HashMap<String, String>();
	
	/*
	 * ChickenFight
	 * 
	 */
	public static HashMap<String, Boolean> KitChickenMama = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> KitBabyChicken = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> KitHotWing = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> KitChickenWarrior = new HashMap<String, Boolean>();
	
	public static Chicken KitChickenMamaEquiped = null;
	public static Chicken KitChickenMamaUnEquiped = null;
	public static Chicken KitChickenMamaLocked = null;
	
	public static Chicken KitBabyChickenEquiped = null;
	public static Chicken KitBabyChickenUnEquiped = null;
	public static Chicken KitBabyChickenLocked = null;
	
	public static Chicken KitHotWingEquiped = null;
	public static Chicken KitHotWingUnEquiped = null;
	public static Chicken KitHotWingLocked = null;
	
	public static IronGolem KitChickenWarriorEquiped = null;
	public static IronGolem KitChickenWarriorUnEquiped = null;
	public static IronGolem KitChickenWarriorLocked = null;
	
	/*
	 * 
	 * 
	 */
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
	
	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> wins = new HashMap<String, Integer>();
	public static HashMap<String, Integer> loses = new HashMap<String, Integer>();
	
	public int i;
	public int i2;
	public int i3;
	
	private String getquery = "";
	private String containsquery = "";
	static Connection connection;
	
	ServerSelector sinv = new ServerSelector();
	KitNPCs kitnpcs = new KitNPCs(this);
	
	protected static Field mapStringToClassField, mapClassToStringField, mapClassToIdField, mapStringToIdField;
	//protected static Field mapIdToClassField;
	 
	static
	{
	    try
	    {
	        mapStringToClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("c");
	        mapClassToStringField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("d");
	        //mapIdtoClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("e");
	        mapClassToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("f");
	        mapStringToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("g");
	 
	        mapStringToClassField.setAccessible(true);
	        mapClassToStringField.setAccessible(true);
	        //mapIdToClassField.setAccessible(true);
	        mapClassToIdField.setAccessible(true);
	        mapStringToIdField.setAccessible(true);
	    }
	    catch(Exception e) {e.printStackTrace();}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addCustomEntity(Class entityClass, String name, int id)
	{
	    if (mapStringToClassField == null || mapStringToIdField == null || mapClassToStringField == null || mapClassToIdField == null)
	    {
	        return;
	    }
	    else
	    {
	        try
	        {
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
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			try{
				DisguiseAPI.undisguiseToAll(p);
			}catch(Exception ex){
				
			}
		}
		effectManager.dispose();
	}
	
	public void onEnable(){
		entityHider = new EntityHider(this, Policy.BLACKLIST);
		addCustomEntity(ChickenKit.class, "ChickenKit", 93);
		addCustomEntity(IronGolemKit.class, "IronGolemKit", 99);
		addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		addCustomEntity(CustomPig.class, "CustomPig", 90);
		addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		addCustomEntity(CustomCow.class, "CustomCow", 92);
		addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		
		try{
			for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
				if(en instanceof Player){
					
				}
				else{
					en.remove();
				}
			}
		}catch(Exception ex){
			
		}
		
		SettingsManager.setup(this);
		
		EffectLib lib = EffectLib.instance();
	    effectManager = new EffectManager(lib);
		
		List<String> list = new ArrayList<String>();
		for(String s : SettingsManager.arenas.getConfigurationSection("ChickenFight").getKeys(false)){
			
			list.add(s);
		}
		
		Random r = new Random();
		CurrentMap = list.get(r.nextInt(list.size()));
		BuiltBy = SettingsManager.arenas.getString("ChickenFight." + CurrentMap + ".BuiltBy");
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		i = 0;
		i2 = 0;
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageByEntity(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PickUpEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new FoodLevelEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEventENG(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ToggleFlightEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ProjectileHit(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		
		state = State.LOBBY;
		
		try{
			TextManager.createChickenFightWord(new Location(Bukkit.getWorld("MiniGamesLobby"), 42, 70, -29));
		}catch(Exception ex){
			
		}
		if(CurrentMap.equals("Lava Island")){
			try{
				TextManager.createLavaIslandWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 32));
			}catch(Exception ex){
			
			}
		}
		if(CurrentMap.equals("Gladiator Arena")){
			try{
				TextManager.createHerobrinesTrainingWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
			}catch(Exception ex){
			
			}
		}
		if(CurrentMap.equals("The Netherlands")){
			try{
				TextManager.createTheNetherlandsWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
			}catch(Exception ex){
			
			}
		}
		try{
			World w = Bukkit.getWorld("MiniGamesLobby");
			Location l1 = new Location(w, 0.5, 65, 23.5, (float) 180, (float) 45);
			Location l2 = new Location(w, -13.5, 65, 18.5, (float) -135, (float) 45);
			Location l3 = new Location(w, -18.5, 65, 4.5, (float) -90, (float) 45);
			Location l4 = new Location(w, -13.5, 65, -9.5, (float) -45, (float) 45);
			KitNPCs.spawnChickenFightNPCs(w, l1, l2, l3, l4);
		}catch(Exception ex){
			
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			try{
				Manager.joinChickenFight(p);
			}catch(Exception ex){
				
			}
			p.setAllowFlight(false);
			p.setFlying(false);
		    ((CraftPlayer) p).getHandle().setInvisible(false);
		    for(Player player : Bukkit.getOnlinePlayers()){
		    	p.showPlayer(p);
		    	player.showPlayer(p);
		    }
		    DisguiseAPI.undisguiseToAll(p);
		}
		
		new BukkitRunnable(){
			@Override
			public void run() {
				if(state == State.LOBBY){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(KitChickenMama.get(p.getName()) == null){
							entityHider.hideEntity(p, KitChickenMamaEquiped);
							entityHider.hideEntity(p, KitChickenMamaUnEquiped);
							entityHider.showEntity(p, KitChickenMamaLocked);
						}
						else if(KitChickenMama.get(p.getName()) == false){
							entityHider.hideEntity(p, KitChickenMamaEquiped);
							entityHider.showEntity(p, KitChickenMamaUnEquiped);
							entityHider.hideEntity(p, KitChickenMamaLocked);
						}
						else if(KitChickenMama.get(p.getName()) == true){
							entityHider.showEntity(p, KitChickenMamaEquiped);
							entityHider.hideEntity(p, KitChickenMamaUnEquiped);
							entityHider.hideEntity(p, KitChickenMamaLocked);
						}
						
						if(KitBabyChicken.get(p.getName()) == null){
							entityHider.hideEntity(p, KitBabyChickenEquiped);
							entityHider.hideEntity(p, KitBabyChickenUnEquiped);
							entityHider.showEntity(p, KitBabyChickenLocked);
						}
						else if(KitBabyChicken.get(p.getName()) == false){
							entityHider.hideEntity(p, KitBabyChickenEquiped);
							entityHider.showEntity(p, KitBabyChickenUnEquiped);
							entityHider.hideEntity(p, KitBabyChickenLocked);
						}
						else if(KitBabyChicken.get(p.getName()) == true){
							entityHider.showEntity(p, KitBabyChickenEquiped);
							entityHider.hideEntity(p, KitBabyChickenUnEquiped);
							entityHider.hideEntity(p, KitBabyChickenLocked);
						}
						
						if(KitHotWing.get(p.getName()) == null){
							entityHider.hideEntity(p, KitHotWingEquiped);
							entityHider.hideEntity(p, KitHotWingUnEquiped);
							entityHider.showEntity(p, KitHotWingLocked);
						}
						else if(KitHotWing.get(p.getName()) == false){
							entityHider.hideEntity(p, KitHotWingEquiped);
							entityHider.showEntity(p, KitHotWingUnEquiped);
							entityHider.hideEntity(p, KitHotWingLocked);
						}
						else if(KitHotWing.get(p.getName()) == true){
							entityHider.showEntity(p, KitHotWingEquiped);
							entityHider.hideEntity(p, KitHotWingUnEquiped);
							entityHider.hideEntity(p, KitHotWingLocked);
						}
						
						if(KitChickenWarrior.get(p.getName()) == null){
							entityHider.hideEntity(p, KitChickenWarriorEquiped);
							entityHider.hideEntity(p, KitChickenWarriorUnEquiped);
							entityHider.showEntity(p, KitChickenWarriorLocked);
						}
						else if(KitChickenWarrior.get(p.getName()) == false){
							entityHider.hideEntity(p, KitChickenWarriorEquiped);
							entityHider.showEntity(p, KitChickenWarriorUnEquiped);
							entityHider.hideEntity(p, KitChickenWarriorLocked);
						}
						else if(KitChickenWarrior.get(p.getName()) == true){
							entityHider.showEntity(p, KitChickenWarriorEquiped);
							entityHider.hideEntity(p, KitChickenWarriorUnEquiped);
							entityHider.hideEntity(p, KitChickenWarriorLocked);
						}
					}
				}
				for(Player p : Bukkit.getOnlinePlayers()){
					if(Start.ownerpets.containsKey(p)){
						UUID uuid = Start.ownerpets.get(p);
						if(Start.owners.containsKey(uuid)){
							for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
								if(en.getUniqueId() == uuid){
									if(en instanceof LivingEntity){
										LivingEntity ent = (LivingEntity) en;
										Location l = Start.owners.get(uuid).getLocation();
										
										if(ClickEventENG.getDistance(l, ent.getLocation()) < 20){
											ClickEventENG.navigate(ent, l, 1.2);
										}
										else{
											ent.teleport(l);
										}
									}
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this, 20, 3);
		
		new BukkitRunnable(){
			
			@Override
			public void run(){
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(state == State.INGAME){
						
						if(Manager.Players.contains(p)){
							if(!Manager.DeadPlayers.contains(p)){
								float currentexp = p.getExp();
								
								if(Manager.Kit.get(p).equals("Chicken Mama")){
									if(currentexp <= 1){
										
										p.setExp(currentexp + 1F / 120F);
										
									}
								}
								if(Manager.Kit.get(p).equals("Baby Chicken")){
									if(currentexp <= 1){
										
										p.setExp(currentexp + 1F / 140F);
										
									}
								}
								if(Manager.Kit.get(p).equals("Hot Wing")){
									if(currentexp <= 1){
										
										p.setExp(currentexp + 1F / 200F);
										
									}
								}
								if(Manager.Kit.get(p).equals("Chicken Warrior")){
									if(currentexp <= 1){
										
										p.setExp(currentexp + 1F / 160F);
										
									}
								}
							}
						}
						
					// 3, 60 Ticks, 1 / 60
					// 6, 120 Ticks, 1 / 120
					// 7, 140 Ticks, 1 / 140
					// 10, 200 Ticks, 1 / 200
					// 8, 160 Ticks, 1 / 160
					}
				}
			}
		}.runTaskTimer(this, 0, 1);
		
		new BukkitRunnable(){
			
			@SuppressWarnings("deprecation")
			public void run(){
				
				for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
					if(en instanceof Item){
						Item i = (Item) en;
						
						if(i.getItemStack().getType() == Material.EGG){
							i.remove();
						}
					}
				}
				if(state == State.ENDING){
					
					i3++;
					for(Player player : Bukkit.getOnlinePlayers()){
						
						if(i3 < 5){
							player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
						}
						else{
							player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							
							List<String> list = new ArrayList<String>();
							
							for(String s : SettingsManager.arenas.getConfigurationSection("ChickenFight").getKeys(false)){
								
								list.add(s);
							}
							
							Random r = new Random();
							CurrentMap = list.get(r.nextInt(list.size()));
							BuiltBy = SettingsManager.arenas.getString("ChickenFight." + CurrentMap + ".BuiltBy");
							
							i3 = 0;
							
							for(Player p : Bukkit.getOnlinePlayers()){
								
								Manager.giveReward(p);
								
								if(Manager.RoundKills.containsKey(p)){
									Manager.RoundKills.put(p, 0);
								}
								if(Manager.RoundSecondsSurvived.containsKey(p)){
									Manager.RoundSecondsSurvived.put(p, 0);
								}
								if(Manager.Spectators.contains(p)){
									Manager.Spectators.remove(p);
									Manager.SpectatorsInGame = Manager.SpectatorsInGame -1;
									Manager.Players.add(p);
									Manager.PlayersInGame =Manager. PlayersInGame +1;
								}
								if(Manager.DeadPlayers.contains(p)){
									Manager.DeadPlayers.remove(p);
								}
								Manager.teleportToLobby(p);
								player.showPlayer(p);
								((CraftPlayer) p).getHandle().setInvisible(false);
								((CraftPlayer) player).getHandle().setInvisible(false);
								p.setAllowFlight(false);
								p.setFlying(false);
								p.showPlayer(player);
								Manager.Kit.put(p, "None");
								DisguiseAPI.undisguiseToAll(p);
								LobbyKit.giveInventory(p);
								if(Manager.UsedEffect.contains(p)){
									Manager.UsedEffect.remove(p);
								}
								//Default Kit
							    Start.KitChickenMama.put(p.getName(), false);
							    
								if(Start.KitBabyChicken.containsKey(p.getName())){
									Start.KitBabyChicken.put(p.getName(), false);
								}
								if(Start.KitHotWing.containsKey(p.getName())){
									Start.KitHotWing.put(p.getName(), false);
								}
								if(Start.KitChickenWarrior.containsKey(p.getName())){
									Start.KitChickenWarrior.put(p.getName(), false);
								}
								p.setLevel(0);
								p.setExp(0);
							}
							state = State.LOBBY;
							try{
								TextManager.createChickenFightWord(new Location(Bukkit.getWorld("MiniGamesLobby"), 42, 70, -29));
							}catch(Exception ex){
								
							}
							if(CurrentMap.equals("Lava Island")){
								try{
									TextManager.createLavaIslandWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 32));
								}catch(Exception ex){
								
								}
							}
							if(CurrentMap.equals("Gladiator Arena")){
								try{
									TextManager.createHerobrinesTrainingWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
								}catch(Exception ex){
								
								}
							}
							if(CurrentMap.equals("The Netherlands")){
								try{
									TextManager.createTheNetherlandsWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
								}catch(Exception ex){
								
								}
							}
							Manager.spawns = 0;
							Manager.Minutes = 1;
							Manager.Seconds = 0;
							Manager.PlayersDied = 0;
							Manager.PlayerWon = null;
							Manager.BoosterMultiply = 0;
							Manager.GameEffectSpeed = false;
							Manager.GameEffectBlindness = false;
							Manager.GameEffectJump = false;
						}
						
					}
				
				}
				if(state == State.WARMUP){
					
					i2++;
					for(Player p : Bukkit.getOnlinePlayers()){
						
						if(i2 < 5){
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
							
							p.getInventory().clear();
							p.getInventory().setHelmet(null);
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							
							ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 5 - i2);
							ItemMeta itemmeta = item.getItemMeta();
							itemmeta.setDisplayName("§f§oStarting in §6§o" + (5 - i2) + "§f§o...");
							item.setItemMeta(itemmeta);
							item.setDurability((short) 4);
							p.getInventory().setItem(0, item);
							p.getInventory().setItem(1, item);
							p.getInventory().setItem(2, item);
							p.getInventory().setItem(3, item);
							p.getInventory().setItem(4, item);
							p.getInventory().setItem(5, item);
							p.getInventory().setItem(6, item);
							p.getInventory().setItem(7, item);
							p.getInventory().setItem(8, item);
							
							p.updateInventory();
							
							if(Manager.Players.contains(p)){
								p.setAllowFlight(false);
								p.setFlying(false);
							}
						}
						else{
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							state = State.INGAME;
							Manager.Minutes = 20;
							Manager.Seconds = 0;
							
							if(Manager.Kit.get(p).equals("None") || Manager.Kit.get(p).equals("Chicken Mama")){
								Manager.Kit.put(p, "Chicken Mama");
								ChickenMama.giveInventory(p);
								MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
								mob.setViewSelfDisguise(true);
								FlagWatcher watcher = mob.getWatcher();
								((LivingWatcher) watcher).setCustomName(p.getName());
								((LivingWatcher) watcher).setCustomNameVisible(true);
								DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							}
							if(Manager.Kit.get(p).equals("Baby Chicken")){
								BabyChicken.giveInventory(p);
								MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
								mob.setViewSelfDisguise(true);
								FlagWatcher watcher = mob.getWatcher();
								((LivingWatcher) watcher).setCustomName(p.getName());
								((LivingWatcher) watcher).setCustomNameVisible(true);
								((AgeableWatcher) watcher).setBaby();
								DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							}
							if(Manager.Kit.get(p).equals("Hot Wing")){
								HotWing.giveInventory(p);
								MobDisguise mob = new MobDisguise(DisguiseType.CHICKEN);
								mob.setViewSelfDisguise(true);
								FlagWatcher watcher = mob.getWatcher();
								((LivingWatcher) watcher).setCustomName(p.getName());
								((LivingWatcher) watcher).setCustomNameVisible(true);
								((LivingWatcher) watcher).setBurning(true);
								DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							}
							if(Manager.Kit.get(p).equals("Chicken Warrior")){
								ChickenWarrior.giveInventory(p);
								MobDisguise mob = new MobDisguise(DisguiseType.IRON_GOLEM);
								mob.setViewSelfDisguise(true);
								FlagWatcher watcher = mob.getWatcher();
								((LivingWatcher) watcher).setCustomName(p.getName());
								((LivingWatcher) watcher).setCustomNameVisible(true);
								DisguiseAPI.disguiseToPlayers(p, mob, Bukkit.getOnlinePlayers());
							}
							p.setLevel(0);
							p.setExp(1);
							p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 5, 1);
							p.getInventory().setHeldItemSlot(0);
						}
						
					}
					if(i2 < 5){
						
					}
					else{
						i2 = 0;
					}
					
				}
				if(state == State.LOBBY || state == State.LASTSECONDS){
					try{
						TextManager.createCountdownWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -26, 70, -37), Manager.Seconds -1);
					}catch(Exception ex){
						
					}
					try{
						TextManager.createChickenFightWord(new Location(Bukkit.getWorld("MiniGamesLobby"), 42, 70, -29));
					}catch(Exception ex){
						
					}
					if(CurrentMap.equals("Lava Island")){
						try{
							TextManager.createLavaIslandWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 32));
						}catch(Exception ex){
						
						}
					}
					if(CurrentMap.equals("Gladiator Arena")){
						try{
							TextManager.createHerobrinesTrainingWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
						}catch(Exception ex){
						
						}
					}
					if(CurrentMap.equals("The Netherlands")){
						try{
							TextManager.createTheNetherlandsWord(new Location(Bukkit.getWorld("MiniGamesLobby"), -41, 70, 40));
						}catch(Exception ex){
						
						}
					}
				}
				if(Manager.PlayersInGame >= 2){
					if(state == State.LOBBY || state == State.LASTSECONDS){
						if(Manager.Seconds != -1){
							Manager.Seconds = Manager.Seconds -1;
						}
						if(Manager.Seconds == -1){
							Manager.Minutes = Manager.Minutes -1;
							Manager.Seconds = 59;
						}
						if(Manager.Seconds == 10){

							state = State.LASTSECONDS;
							Bukkit.broadcastMessage("§bGadgets §8| §c§lDISABLED");
							for(Player p : Bukkit.getOnlinePlayers()){
								if(p.getOpenInventory() != null){
									p.closeInventory();
								}
								if(p.getVehicle() != null){
									p.leaveVehicle();
								}
								if(Start.ownerpets.containsKey(p)){
									
									for(Entity en : Bukkit.getWorld("MiniGamesLobby").getEntities()){
										if(en.getUniqueId() == Start.ownerpets.get(p)){
											if(en instanceof LivingEntity){
												en.remove();
												Start.owners.remove(Start.ownerpets.get(p));
												Start.ownerpets.remove(p);
											}
										}
									}
								}
								DisguiseAPI.undisguiseToAll(p);
							}
						}
						if(Manager.Seconds <= 10 && Manager.Seconds != 0){
							Bukkit.broadcastMessage("§f§oStarting in §6§o" + Manager.Seconds + "§f§o...");
							
							for(Player p : Bukkit.getOnlinePlayers()){
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							}
						}
						if(Manager.Minutes == 0 && Manager.Seconds == 0){
							Manager.startChickenFight();
						}
						
						for(Player p : Bukkit.getOnlinePlayers()){
							if(Manager.Players.contains(p)){
								ScoreboardManager sm = Bukkit.getScoreboardManager();
								Scoreboard b = sm.getNewScoreboard();
		
								Objective o = b.registerNewObjective("Test", "Test2");
								
								o.setDisplayName("§f§lChickenFight");
								
								o.setDisplaySlot(DisplaySlot.SIDEBAR);
							
								Score score1 = o.getScore("");
								score1.setScore(12);
						
								Score score2 = o.getScore("§6§lTime Left");
								score2.setScore(11);
						
								Score score3 = o.getScore(" " + Manager.Minutes + "m " + Manager.Seconds + "s");
								score3.setScore(10);
							
								Score score4 = o.getScore(" ");
								score4.setScore(9);
						
								Score score5 = o.getScore("§a§lPlayers");
								score5.setScore(8);
								
								Score score6 = o.getScore(" " + Manager.PlayersInGame);
								score6.setScore(7);
						
								Score score7 = o.getScore("  ");
								score7.setScore(6);
								
								Score score8 = o.getScore("§e§lKit");
								score8.setScore(5);
								
								Score score9 = o.getScore(" " + Manager.Kit.get(p));
								score9.setScore(4);
						
								Score score10 = o.getScore("   ");
								score10.setScore(3);
								
								Score score11 = o.getScore("§f§lCoins");
								score11.setScore(2);
								
								Score score12 = o.getScore(" " + coins.get(p.getName()) + " ");
								score12.setScore(1);
						
								Score score13 = o.getScore("    ");
								score13.setScore(0);
		
								Team IronVIP = b.registerNewTeam("IronVIPMG");
								IronVIP.setPrefix("§7§lIron §f");
								Team GoldVIP = b.registerNewTeam("GoldVIPMG");
								GoldVIP.setPrefix("§6§lGold §f");
								Team DiamondVIP = b.registerNewTeam("DiamondVIPMG");
								DiamondVIP.setPrefix("§9§lDiamond §f");
								Team EmeraldVIP = b.registerNewTeam("EmeraldVIPMG");
								EmeraldVIP.setPrefix("§a§lEmerald §f");
								Team Builder = b.registerNewTeam("Builder");
								Builder.setPrefix("§d§lBuilder §f");
								Team Moderator = b.registerNewTeam("ModeratorMG");
								Moderator.setPrefix("§b§lMod §f");
								Team Owner = b.registerNewTeam("OwnerMG");
								Owner.setPrefix("§4§lOwner §f");
								
								for(Player player : Bukkit.getOnlinePlayers()){
									if(player.hasPermission("Rank.Owner")){
										Owner.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Moderator")){
										Moderator.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Builder")){
										Builder.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Emerald")){
										EmeraldVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Diamond")){
										DiamondVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Gold")){
										GoldVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Iron")){
										IronVIP.addPlayer(player);
									}
									else{
										
									}
								}
								
								p.setScoreboard(b);
							}
							else{
								p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
							}
						}
					}
				}
				else{
					if(state == State.LOBBY || state == State.LASTSECONDS){
				
						for(Player p : Bukkit.getOnlinePlayers()){
							if(Manager.Players.contains(p)){
								ScoreboardManager sm = Bukkit.getScoreboardManager();
								Scoreboard b = sm.getNewScoreboard();
		
								Objective o = b.registerNewObjective("Test", "Test2");
								
								o.setDisplayName("§f§lChickenFight");
								
								o.setDisplaySlot(DisplaySlot.SIDEBAR);
							
								Score score1 = o.getScore("");
								score1.setScore(11);
						
								i++;
								if(i == 4){
									i = 1;
								}
								if(i == 1){
									Score score2 = o.getScore("§6§l§oWaiting.");
									score2.setScore(10);
								}
								if(i == 2){
									Score score2 = o.getScore("§6§l§oWaiting..");
									score2.setScore(10);
								}
								if(i == 3){
									Score score2 = o.getScore("§6§l§oWaiting...");
									score2.setScore(10);
								}
							
								Score score4 = o.getScore(" ");
								score4.setScore(9);
						
								Score score5 = o.getScore("§a§lPlayers");
								score5.setScore(8);
								
								Score score6 = o.getScore(" " + Manager.PlayersInGame);
								score6.setScore(7);
						
								Score score7 = o.getScore("  ");
								score7.setScore(6);
		
								Score score8 = o.getScore("§e§lKit");
								score8.setScore(5);
								
								Score score9 = o.getScore(" " + Manager.Kit.get(p));
								score9.setScore(4);
						
								Score score10 = o.getScore("   ");
								score10.setScore(3);
								
								Score score11 = o.getScore("§f§lCoins");
								score11.setScore(2);
								
								Score score12 = o.getScore(" " + coins.get(p.getName()) + " ");
								score12.setScore(1);
						
								Score score13 = o.getScore("    ");
								score13.setScore(0);
								
								Team IronVIP = b.registerNewTeam("IronVIPMG");
								IronVIP.setPrefix("§7§lIron §f");
								Team GoldVIP = b.registerNewTeam("GoldVIPMG");
								GoldVIP.setPrefix("§6§lGold §f");
								Team DiamondVIP = b.registerNewTeam("DiamondVIPMG");
								DiamondVIP.setPrefix("§9§lDiamond §f");
								Team EmeraldVIP = b.registerNewTeam("EmeraldVIPMG");
								EmeraldVIP.setPrefix("§a§lEmerald §f");
								Team Builder = b.registerNewTeam("BuilderMG");
								Builder.setPrefix("§d§lBuilder §f");
								Team Moderator = b.registerNewTeam("ModeratorMG");
								Moderator.setPrefix("§b§lMod §f");
								Team Owner = b.registerNewTeam("OwnerMG");
								Owner.setPrefix("§4§lOwner §f");
								
								for(Player player : Bukkit.getOnlinePlayers()){
									if(player.hasPermission("Rank.Owner")){
										Owner.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Moderator")){
										Moderator.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Builder")){
										Builder.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Emerald")){
										EmeraldVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Diamond")){
										DiamondVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Gold")){
										GoldVIP.addPlayer(player);
									}
									else if(player.hasPermission("Rank.Iron")){
										IronVIP.addPlayer(player);
									}
									else{
										
									}
								}
								
								p.setScoreboard(b);
							}
							else{
								p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
							}
						}
					}
				}
				if(state == State.WARMUP || state == State.ENDING){
					for(Player p : Bukkit.getOnlinePlayers()){
						p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
					}
				}
				if(state == State.INGAME){
					
					if(Manager.Seconds != -1){
						Manager.Seconds = Manager.Seconds -1;
					}
					if(Manager.Seconds == -1){
						Manager.Minutes = Manager.Minutes -1;
						Manager.Seconds = 59;
					}
					if(Manager.Minutes == 0 && Manager.Seconds == 0){
						Manager.endChickenFight();
					}
					for(Player p : Bukkit.getOnlinePlayers()){
						if(Manager.Players.contains(p)){
							Manager.RoundSecondsSurvived.put(p, Manager.RoundSecondsSurvived.get(p) +1);
							if(Manager.GameEffectBlindness == true){
								p.removePotionEffect(PotionEffectType.BLINDNESS);
								p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
							}
							if(Manager.GameEffectJump == true){
								p.removePotionEffect(PotionEffectType.JUMP);
								p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60, 4));
							}
							if(Manager.GameEffectSpeed == true){
								p.removePotionEffect(PotionEffectType.SPEED);
								p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3));
							}
							if(Manager.Kit.get(p).equals("Chicken Warrior")){
								p.removePotionEffect(PotionEffectType.SLOW);
								p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
							}
						}
						if(Manager.Players.contains(p) || Manager.Spectators.contains(p)){
							ScoreboardManager sm = Bukkit.getScoreboardManager();
							Scoreboard b = sm.getNewScoreboard();
	
							Objective o = b.registerNewObjective("Test", "Test2");
							
							o.setDisplayName("§f§lChickenFight");
							
							o.setDisplaySlot(DisplaySlot.SIDEBAR);
						
							if(Manager.Minutes <= 1){
								Score score1 = o.getScore("");
								score1.setScore(9);
						
								Score score2 = o.getScore("§6§lTime Left");
								score2.setScore(8);
						
								Score score3 = o.getScore(" " + Manager.Minutes + "m " + Manager.Seconds + "s");
								score3.setScore(7);
							}
						
							Score score4 = o.getScore(" ");
							score4.setScore(6);
					
							Score score5 = o.getScore("§a§lAlive");
							score5.setScore(5);
							
							Score score6 = o.getScore(" " + Manager.PlayersInGame);
							score6.setScore(4);
					
							Score score7 = o.getScore("  ");
							score7.setScore(3);
							
							Score score8 = o.getScore("§c§lDead");
							score8.setScore(2);
							
							Score score9 = o.getScore(" " + Manager.PlayersDied + " ");
							score9.setScore(1);
					
							Score score10 = o.getScore("   ");
							score10.setScore(0);
	
							Team Players = b.registerNewTeam("Players");
							Team Spectators = b.registerNewTeam("Spectate");
							
							Players.setPrefix("§a");
							Spectators.setPrefix("§c");
							
							Players.setAllowFriendlyFire(true);
							Spectators.setCanSeeFriendlyInvisibles(true);
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(Manager.Players.contains(player)){
									Players.addPlayer(player);
								}
								if(Manager.Spectators.contains(player)){
									Spectators.addPlayer(player);
									((CraftPlayer) player).getHandle().setInvisible(true);
									
									if(!Manager.Spectators.contains(p)){
										p.hidePlayer(player);
									}
									else{
										p.showPlayer(player);
									}
								}
								if(Manager.Spectators.contains(p)){
									p.showPlayer(player);
								}
							}
							
							p.setScoreboard(b);
						}
						else{
							p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
						}
					}
				}
				
			}
		}.runTaskTimer(this, 0, 20);
	}
	
	public synchronized void openConnection(){
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public boolean containsPath(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public synchronized void insertInt(String player, String Table, String column, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void insertString(String player, String Table, String column, String i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static int getInt(Player p, String Table, String column){
		int integer = 0;
		
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				integer = rs.getInt(column);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return integer;
	}
	public static String getString(Player p, String Table, String column){
		String string = "";
		
		String query = "SELECT `" + column + "` FROM `" + Table + "` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				string = rs.getString(column);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return string;
	}
	
	public static void setFireworksPasses(Player p, int passes) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + passes + "' WHERE `name` = '" + p.getName() + "'");
		Start.FireworkPasses.put(p.getName(), passes);
	}
	public void addFireworksPasses(Player p, int passes) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Fireworks-Passes` SET `passes` = '" + (getInt(p, "Fireworks-Passes", "passes") + passes) + "' WHERE `name` = '" + p.getName() + "'");
		Start.FireworkPasses.put(p.getName(), getInt(p, "Fireworks-Passes", "passes"));
	}
	public void addOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getInt(p, "OrbitMinesTokens", "omt") + OMT) + "' WHERE `name` = '" + p.getName() + "'");
		Start.omt.put(p.getName(), getInt(p, "OrbitMinesTokens", "omt"));
	}
	public void removeOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getInt(p, "OrbitMinesTokens", "omt") - OMT) + "' WHERE `name` = '" + p.getName() + "'");
		Start.omt.put(p.getName(), getInt(p, "OrbitMinesTokens", "omt"));
	}
	public void addVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getInt(p, "VIPPoints", "points") + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.points.put(p.getName(), getInt(p, "VIPPoints", "points"));
	}
	public void removeVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getInt(p, "VIPPoints", "points") - points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.points.put(p.getName(), getInt(p, "VIPPoints", "points"));
	}
	public static void addMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getInt(p, "MiniGameCoins", "coins") + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.coins.put(p.getName(), getInt(p, "MiniGameCoins", "coins"));
	}
	public void removeMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getInt(p, "MiniGameCoins", "coins") - points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.coins.put(p.getName(), getInt(p, "MiniGameCoins", "coins"));
	}
	
	public static void addMiniGameKills(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameKills` SET `kills` = '" + (getInt(p, "MiniGameKills", "kills") + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.kills.put(p.getName(), getInt(p, "MiniGameKills", "kills"));
	}
	public static void addMiniGameLoses(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameLoses` SET `loses` = '" + (getInt(p, "MiniGameLoses", "loses") + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.loses.put(p.getName(), getInt(p, "MiniGameLoses", "loses"));
	}
	public static void addMiniGameWins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameWins` SET `wins` = '" + (getInt(p, "MiniGameWins", "wins") + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.wins.put(p.getName(), getInt(p, "MiniGameWins", "wins"));
	}
	public void setMushroomCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.mushroomcow.put(p.getName(), petname);
	}
	public void setPigName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.pig.put(p.getName(), petname);
	}
	public void setWolfName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.wolf.put(p.getName(), petname);
	}
	public void setSheepName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.sheep.put(p.getName(), petname);
	}
	public void setHorseName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.horse.put(p.getName(), petname);
	}
	public void setMagmaCubeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.magmacube.put(p.getName(), petname);
	}
	public void setSlimeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.slime.put(p.getName(), petname);
	}
	public void setCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.cow.put(p.getName(), petname);
	}
	public void setSilverfishName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.silverfish.put(p.getName(), petname);
	}
	public void setOcelotName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.ocelot.put(p.getName(), petname);
	}
	public void setWhiteWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.white.put(p.getName(), i);
	}
	public void setBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.blue.put(p.getName(), i);
	}
	public void setGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.green.put(p.getName(), i);
	}
	public void setBlackWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.black.put(p.getName(), i);
	}
	public void setLightBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.lightblue.put(p.getName(), i);
	}
	public void setPinkWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.pink.put(p.getName(), i);
	}
	public void setLightGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.lightgreen.put(p.getName(), i);
	}
	public void setDarkBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.darkblue.put(p.getName(), i);
	}
	public void setPurpleWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Purple` SET `purple` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.purple.put(p.getName(), i);
	}
	public void setOrangeWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Orange` SET `orange` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.orange.put(p.getName(), i);
	}
	public void setRedWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.red.put(p.getName(), i);
	}
	public void setCyanWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Cyan` SET `cyan` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.cyan.put(p.getName(), i);
	}
	public void setYellowWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Yellow` SET `yellow` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.yellow.put(p.getName(), i);
	}
	public void setGrayWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Gray` SET `gray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.gray.put(p.getName(), i);
	}
	public void setChatColor(Player p, String i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolor.put(p, i);
	}
	public void setChatColorDarkRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkRed` SET `darkred` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkred.put(p.getName(), i);
	}
	public void setChatColorLightGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorlightgreen.put(p.getName(), i);
	}
	public void setChatColorDarkGray(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkGray` SET `darkgray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkgray.put(p.getName(), i);
	}
	public void setChatColorRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorred.put(p.getName(), i);
	}
	public void setChatColorWhite(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorwhite.put(p.getName(), i);
	}
	public void setChatColorLightBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorlightblue.put(p.getName(), i);
	}
	public void setChatColorPink(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorpink.put(p.getName(), i);
	}
	public void setChatColorBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorblue.put(p.getName(), i);
	}
	public void setChatColorDarkBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkblue.put(p.getName(), i);
	}
	public void setChatColorGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorgreen.put(p.getName(), i);
	}
	public void setChatColorBlack(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorblack.put(p.getName(), i);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("vippoints")){
			
			if(sender.hasPermission("Rank.Owner")){
				
				if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								addVIPPoints(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You gave " + a[1] + " " + a[2] + " VIP Points!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else if(a[0].equalsIgnoreCase("remove")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								removeVIPPoints(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You removed " + a[2] + " VIP Points from " + a[1] + "!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else{
						sender.sendMessage("Incorrect Use!");
					}
					
				}
				else{
					sender.sendMessage("Incorrect Use!");
				}
				
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("omt")){
			
			if(sender.hasPermission("Rank.Owner")){
				
				if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								addOMT(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You gave " + a[1] + " " + a[2] + " OMT!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else if(a[0].equalsIgnoreCase("remove")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							try {
								removeOMT(player, i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							sender.sendMessage("You removed " + a[2] + " OMT from " + a[1] + "!");
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
					else{
						sender.sendMessage("Incorrect Use!");
					}
					
				}
				else{
					sender.sendMessage("Incorrect Use!");
				}
				
			}
			else{
				sender.sendMessage("§8[§e§lOMT§8] §7Your OMT balance: §e§l" + Start.omt.get(sender.getName()));
			}
		}
		if(cmd.getName().equalsIgnoreCase("mgbuykit")){
			
			if(state == State.LOBBY || state == State.LASTSECONDS){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(a.length == 1){
						
						if(a[0].equalsIgnoreCase("BabyChicken")){
							if(!KitBabyChicken.containsKey(p.getName())){
								
								if(coins.get(p.getName()) >= 1000){
									
									insertInt(p.getName(), "ChickenFight-BabyChicken", "babychicken", 1);
									
									try {
										removeMiniGameCoins(p, 1000);
									} catch (SQLException e) {
										e.printStackTrace();
									}
									
									p.sendMessage("§eKits §8| §7You have bought '§e§lBaby Chicken§7'!");
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									KitBabyChicken.put(p.getName(), false);
								}
								else{
									p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
								}
							}
						}
						else if(a[0].equalsIgnoreCase("HotWing")){
							if(!KitHotWing.containsKey(p.getName())){
								
								if(coins.get(p.getName()) >= 1000){
									
									insertInt(p.getName(), "ChickenFight-HotWing", "hotwing", 1);
									
									try {
										removeMiniGameCoins(p, 1000);
									} catch (SQLException e) {
										e.printStackTrace();
									}
									
									p.sendMessage("§eKits §8| §7You have bought '§e§lHot Wing§7'!");
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									KitHotWing.put(p.getName(), false);
								}
								else{
									p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
								}
							}
						}
						else if(a[0].equalsIgnoreCase("ChickenWarrior")){
							if(!KitChickenWarrior.containsKey(p.getName())){
								
								if(coins.get(p.getName()) >= 1000){
									
									insertInt(p.getName(), "ChickenFight-ChickenWarrior", "chickenwarrior", 1);
									
									try {
										removeMiniGameCoins(p, 1000);
									} catch (SQLException e) {
										e.printStackTrace();
									}
									
									p.sendMessage("§eKits §8| §7You have bought '§e§lChicken Warrior§7'!");
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
									KitChickenWarrior.put(p.getName(), false);
								}
								else{
									p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
								}
							}
						}
						else{
							
						}
						
					}
					else{
						
					}
				}
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("servers")){
			if(state == State.LOBBY){
				if(sender instanceof Player){
					Player p = (Player) sender;
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(sinv.getServerSelectorInv(p, 1));
				
				}	
			}
		}
		if(cmd.getName().equalsIgnoreCase("perks")){
			if(state == State.LOBBY){
				if(sender instanceof Player){
					Player p = (Player) sender;
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
					
				}
			}
		}
        if(cmd.getName().equalsIgnoreCase("hub")){
			if(sender instanceof Player){
				final Player p = (Player) sender;
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
					@SuppressWarnings("deprecation")
					public void run(){
						p.updateInventory();
				
					} 
				}, 1L);
				
			    ByteArrayOutputStream b = new ByteArrayOutputStream();
			    DataOutputStream out = new DataOutputStream(b);
			
			    try {
			        out.writeUTF("Connect");
			        out.writeUTF("hub");
			    } catch (IOException eee) {
			     
			    }
			
			    p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
			
			}
        }
        if(cmd.getName().equalsIgnoreCase("help")){
			if(sender instanceof Player){
			
			}
        }
		if(cmd.getName().equalsIgnoreCase("mg")){
			
			if(sender instanceof Player){
				
				Player p = (Player) sender;
				if(p.hasPermission("Rank.Owner")){
					if(a.length == 0){
						p.sendMessage("/mg setupcf create <name> (_ for Space)");
					
					}	
				
					else if(a[0].equalsIgnoreCase("setupcf")){
						
						if(a.length == 1){
							p.sendMessage("Incorrect Use!");
						}
						else if(a[1].equalsIgnoreCase("create")){
							
							if(a.length == 3){
								Arena = a[2];
								SettingsManager.arenas.set("ChickenFight." + Arena + ".Enabled", false);
								SettingsManager.saveArenas();
							
								p.sendMessage("Arena Created! (" + Arena + ")");
								p.sendMessage("Now: '§9/mg setupcf setlobby§f'");
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("setlobby")){
							
							String w = p.getWorld().getName();
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							float yaw = p.getLocation().getYaw();
							float pitch = p.getLocation().getPitch();
							
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.world", w);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.x", x);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.y", y);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.z", z);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.yaw", yaw);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Lobby.pitch", pitch);
							
							SettingsManager.arenas.set("ChickenFight." + Arena + ".SpawnsAmount", 0);
							
							SettingsManager.saveArenas();
							
							p.sendMessage("Lobby Set!");
							p.sendMessage("Now: '§9/mg setupcf setnextspawn§f'");
														
						}
						else if(a[1].equalsIgnoreCase("setnextspawn")){
							
							int i = SettingsManager.arenas.getInt("ChickenFight." + Arena + ".SpawnsAmount") +1;
							
							String w = p.getWorld().getName();
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							double yaw = p.getLocation().getYaw();
							double pitch = p.getLocation().getPitch();
							
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".world", w);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".x", x);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".y", y);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".z", z);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".yaw", yaw);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spawns." + i + ".pitch", pitch);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".SpawnsAmount", i);
							
							SettingsManager.saveArenas();
							
							p.sendMessage("Spawn " + i + " Set!");
							p.sendMessage("Now: '§9/mg setupcf setspectatorspawn§f'");
							
						}
						else if(a[1].equalsIgnoreCase("setspectatorspawn")){
							
							String w = p.getWorld().getName();
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							double yaw = p.getLocation().getYaw();
							double pitch = p.getLocation().getPitch();
							
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.world", w);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.x", x);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.y", y);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.z", z);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.yaw", yaw);
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Spectators.pitch", pitch);
							SettingsManager.saveArenas();
							
							p.sendMessage("Spectator Spawn Set!");
							p.sendMessage("Now: '§9/mg setupcf builtby <string>§f' (_ for Space)");
							
						}
						else if(a[1].equalsIgnoreCase("builtby")){
							
							if(a.length == 3){
								
								String s = a[2];
								
								SettingsManager.arenas.set("ChickenFight." + Arena + ".BuiltBy", s);
								SettingsManager.saveArenas();
								
								p.sendMessage("Spectator Spawn Set!");
								p.sendMessage("Now: '§9/mg setupcf finish§f'");
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("finish")){
							
							SettingsManager.arenas.set("ChickenFight." + Arena + ".Enabled", true);
							SettingsManager.saveArenas();
							
							p.sendMessage("Setup Finished!");
							
						}
						else{
							p.sendMessage("Incorrect Use!");
						}
					}
					else{
						p.sendMessage("Incorrect Use!");
					}
					
				}
				
			}
			else{
				sender.sendMessage("Cannot perform commands through the Console!");
			}
			
		}
		
		return false;
	}
}
