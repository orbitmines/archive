package me.O_o_Fadi_o_O.KitPvP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.KitPvP.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetChicken;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetCreeper;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetOcelot;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetPig;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetSheep;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetSlime;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetSpider;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetSquid;
import me.O_o_Fadi_o_O.KitPvP.NMS.PetWolf;
import me.O_o_Fadi_o_O.KitPvP.events.BowShot;
import me.O_o_Fadi_o_O.KitPvP.events.BreakEvent;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent2;
import me.O_o_Fadi_o_O.KitPvP.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.KitPvP.events.DamageEvent;
import me.O_o_Fadi_o_O.KitPvP.events.DeathEvent;
import me.O_o_Fadi_o_O.KitPvP.events.DropEvent;
import me.O_o_Fadi_o_O.KitPvP.events.EXPPickup;
import me.O_o_Fadi_o_O.KitPvP.events.EntityChangeBlock;
import me.O_o_Fadi_o_O.KitPvP.events.EntityDamage;
import me.O_o_Fadi_o_O.KitPvP.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.KitPvP.events.ExplodeEvent;
import me.O_o_Fadi_o_O.KitPvP.events.FoodEvent;
import me.O_o_Fadi_o_O.KitPvP.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.KitPvP.events.InventoryClick;
import me.O_o_Fadi_o_O.KitPvP.events.JoinEvent;
import me.O_o_Fadi_o_O.KitPvP.events.PlaceEvent;
import me.O_o_Fadi_o_O.KitPvP.events.PlayerChat;
import me.O_o_Fadi_o_O.KitPvP.events.PlayerMove;
import me.O_o_Fadi_o_O.KitPvP.events.ProjectileHit;
import me.O_o_Fadi_o_O.KitPvP.events.QuitEvent;
import me.O_o_Fadi_o_O.KitPvP.events.SignsColor;
import me.O_o_Fadi_o_O.KitPvP.events.SneakEvent;
import me.O_o_Fadi_o_O.KitPvP.events.ToggleFlightEvent;
import me.O_o_Fadi_o_O.KitPvP.events.VoteEvent;
import me.O_o_Fadi_o_O.KitPvP.managers.BungeeManager;
import me.O_o_Fadi_o_O.KitPvP.managers.ConfigManager;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.NPCManager;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.VoteManager;
import me.O_o_Fadi_o_O.KitPvP.runnables.ArrowRunnables;
import me.O_o_Fadi_o_O.KitPvP.runnables.BoosterRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.FreeKitRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.MapRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.PetRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.KitPvP.utils.ArmorStandType;
import me.O_o_Fadi_o_O.KitPvP.utils.ChatColor;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;
import me.O_o_Fadi_o_O.KitPvP.utils.Server;
import me.O_o_Fadi_o_O.KitPvP.utils.StaffRank;
import me.O_o_Fadi_o_O.KitPvP.utils.Trail;
import me.O_o_Fadi_o_O.KitPvP.utils.TrailType;
import me.O_o_Fadi_o_O.KitPvP.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Start extends JavaPlugin {
	
	private DatabaseRunnable databaserunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	private ArrowRunnables arrowrunnables;
	private BoosterRunnable boosterrunnable;
	private FreeKitRunnable freekitrunnable;
	private MapRunnable maprunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
	public static Start plugin;
	public static String TAG = "§c§lKitPvP §8| §7";
	public static boolean freekitenabled = false;
	
	public static HashMap<String, UUID> playeruuid = new HashMap<String, UUID>();
	public static HashMap<UUID, String> uuidplayer = new HashMap<UUID, String>();
	
	@SuppressWarnings("deprecation")
	public void onEnable(){
		addCustomEntity(PetSquid.class, "PetSquid", 94);
		addCustomEntity(PetSpider.class, "PetSpider", 52);
		addCustomEntity(PetMushroomCow.class, "PetMushroomCow", 96);
		addCustomEntity(PetMagmaCube.class, "PetMagmaCube", 62);
		addCustomEntity(PetPig.class, "PetPig", 90);
		addCustomEntity(PetSlime.class, "PetSlime", 55);
		addCustomEntity(PetWolf.class, "PetWolf", 95);
		addCustomEntity(PetCow.class, "PetCow", 92);
		addCustomEntity(PetSheep.class, "PetSheep", 91);
		addCustomEntity(PetSilverfish.class, "PetSilverfish", 60);
		addCustomEntity(PetOcelot.class, "PetHorse", 98);
		addCustomEntity(PetCreeper.class, "PetCreeper", 50);
		addCustomEntity(PetChicken.class, "PetChicken", 93);
		
		addCustomEntity(CustomCreeper.class, "CustomCreeper", 50);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 51);
		addCustomEntity(CustomBlaze.class, "CustomBlaze", 61);
		
		plugin = this;
		databaserunnable = new DatabaseRunnable();
		petrunnable = new PetRunnable();
		playerrunnable = new PlayerRunnable();
		scoreboardrunnable = new ScoreboardRunnable();
	    serverselectorrunnable = new ServerSelectorRunnable();
	    arrowrunnables = new ArrowRunnables();
	    boosterrunnable = new BoosterRunnable();
	    freekitrunnable = new FreeKitRunnable();
	    maprunnable = new MapRunnable();
		
		scoreboardtitlemanager = new ScoreboardTitleManager();
		
		npcmanager = new NPCManager();
		pmanager = new PlayerManager();
		
		StorageManager.thisserver = Server.KITPVP;
		StorageManager.spawn = new Location(StorageManager.lobbyworld, -0.5, 74, -0.5, 90, 0);
		StorageManager.snowtownspectatorspawn = new Location(StorageManager.arenaworld, -93.5, 22, -1154.5, 145, 0);
		StorageManager.mountainvillagespectatorspawn = new Location(StorageManager.arenaworld, -308.5, 16, -1326.5, 137, 0);
		StorageManager.desertspectatorspawn = new Location(StorageManager.arenaworld, -465, 43.5, -1085, 89, 17);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeManager());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee", new BungeeManager());
		
        ConfigManager.setup(this);
        
		if(ConfigManager.votedata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.votedata.getStringList("VoteRewardsNotGiven")){
				list.add(s);
			}
			StorageManager.pendingvoters.clear();
			StorageManager.pendingvoters.addAll(list);
		}
        
        /*  
        if(!ConfigManager.playerdata.contains("LastDonator")){
        	ConfigManager.playerdata.set("LastDonator", "");
        	ConfigManager.savePlayerData();
        }
        
        StorageManager.lastdonatorstring = ConfigManager.playerdata.getString("LastDonator");
        
        StorageManager.playersinlapisparkour = new ArrayList<Player>();
        StorageManager.playersinmindcraft = new ArrayList<Player>();

        StorageManager.wardrobearmor.put(Color.WHITE, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.BLUE, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.GREEN, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.BLACK, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.AQUA, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.FUCHSIA, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.LIME, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.NAVY, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.PURPLE, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.ORANGE, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.RED, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.TEAL, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.YELLOW, new ArrayList<Player>());
        StorageManager.wardrobearmor.put(Color.GRAY, new ArrayList<Player>());
        */
        for(ChatColor chatcolor : ChatColor.values()){
        	StorageManager.chatcolors.put(chatcolor, new ArrayList<Player>());
        }
        
        for(Trail trail : Trail.values()){
        	StorageManager.trails.put(trail, new ArrayList<Player>());
        }
        for(TrailType trailtype : TrailType.values()){
        	StorageManager.trailtypes.put(trailtype, new ArrayList<Player>());
        }
        
        //for(Disguise disguise : Disguise.values()){
        //	StorageManager.disguises.put(disguise, new ArrayList<Player>());
        //}
        
        //for(Hat hat : Hat.values()){
        //	StorageManager.hats.put(hat, new ArrayList<Player>());
        //}
		
		for(Server server : Server.values()){
			StorageManager.onlineplayers.put(server, -1);
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			StorageManager.loaded.put(p, false);
		}
		
		registerAllEvents();
		startAllRunnables();
		
		try{
			removeAllEntities();
			npcmanager.spawnServerSelector(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -5.5, 74, -7.5, -45, 0), "§3§lServer Selector");
			npcmanager.spawnKitSelector(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -11.5, 74, 10.5, -135, 0), "§b§lKit Selector");
			npcmanager.spawnSpectateNPC(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 10.5, 74, -11.5, 45, 0), "§e§lSpectate");
			npcmanager.spawnOMTShop(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -4.5, 75, -11.5, 0, 0), "§e§lOMT Shop");
			
			registerAllSpawns(StorageManager.arenaworld);
			
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -2.5, 75, 1, -135, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.IRON_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -2, 75, -2.5, -45, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.IRON_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 1.5, 75, -2, 45, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.IRON_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 1, 75, 1.5, 135, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.IRON_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -9.25, 73.5, 11.92, 90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-2).setY(0).setZ(0.4), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.DIAMOND_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -10.25, 73.1, 9.875, 90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-3.1).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.GOLDEN_APPLE, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -10.1, 73.15, 9.8, 60, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(-0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-3.1).setY(0).setZ(-0.25), 
					EulerAngle.ZERO.setX(0.5).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.GOLDEN_APPLE, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStandItem(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 9.5, 75, -12.5, 0, 0), null, Material.ENDER_PEARL);
			npcmanager.spawnArmorStandItem(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 10.5, 74.5, -9.5, 0, 0), null, Material.ENDER_PEARL);
		}catch(NullPointerException ex){
			new BukkitRunnable(){
				public void run(){
					getServer().dispatchCommand(getServer().getConsoleSender(), "reload");
				}
			}.runTaskLater(this, 20);
		}
		
		new BukkitRunnable(){
			
			public void run(){
				
				for(Player p : Bukkit.getOnlinePlayers()){
					clearInventory(p);
					pmanager.loadPlayer(p);	
				}
			}
		}.runTaskLater(this, 100);

		new BukkitRunnable(){
			
			public void run(){
				
				registerPlayersOnline(Server.KITPVP);
				registerPlayersOnline(Server.PRISON);
				registerPlayersOnline(Server.CREATIVE);
				registerPlayersOnline(Server.HUB);
				registerPlayersOnline(Server.SKYBLOCK);
				registerPlayersOnline(Server.SURVIVAL);
				registerPlayersOnline(Server.MINIGAMES);
			
			}
		}.runTaskTimer(this, 0, 20);
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
	
			clearInventory(p);
			p.teleport(StorageManager.spawn);

			if(StorageManager.nickname.containsKey(p)){
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", Start.getUUIDfromPlayer(p).toString())){
					DatabaseManager.setNickname(p, StorageManager.nickname.get(p));
				}
				else{
					DatabaseManager.insertString(p.getName(), "PlayerNicknames", "nick", StorageManager.nickname.get(p));
				}
			}
			else{
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", Start.getUUIDfromPlayer(p).toString())){
					DatabaseManager.removeNickname(p);
				}
			}
			
			//String fwsettings = PlayerManager.parseStringFromColor(StorageManager.fireworkcolor1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkcolor2.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade2.get(p)) + "|" + StorageManager.fireworkflicker.get(p) + "|" + StorageManager.fireworktrail.get(p) + "|" + StorageManager.fireworktype.get(p);
			//DatabaseManager.setFireworkSettings(p, fwsettings);
			
			if(StorageManager.disguise.containsKey(p)){
				DisguisePlayer.undisguisePlayer(p);
			}
			if(StorageManager.trailparticlesamount.containsKey(p)){
				DatabaseManager.setTrailTypeParticleAmount(p, StorageManager.trailparticlesamount.get(p));
			}
			if(StorageManager.trailspecial.containsKey(p)){
				DatabaseManager.setTrailTypeSpecial(p, StorageManager.trailspecial.get(p));
			}
			if(StorageManager.trailtype.containsKey(p)){
				DatabaseManager.setTrailType(p, StorageManager.trailtype.get(p));
			}
			//DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
		}
	}
	
	public static void RandomSpawn(Player p){
		if(!StorageManager.spectators.contains(p)){
	        if(StorageManager.currentmap == KitPvPMap.Mountain_Village){
	        	Random r = new Random();
	        	int i = r.nextInt(StorageManager.mountainvillagespawns.size()-1);
	        	
	        	p.teleport(StorageManager.mountainvillagespawns.get(i));
	        	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	        }
	        if(StorageManager.currentmap == KitPvPMap.Snow_Town){
	        	Random r = new Random();
	        	int i = r.nextInt(StorageManager.snowtownspawns.size()-1);
	        	
	        	p.teleport(StorageManager.snowtownspawns.get(i));
	        	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	        }
	        if(StorageManager.currentmap == KitPvPMap.Desert){
	        	Random r = new Random();
	        	int i = r.nextInt(StorageManager.desertspawns.size()-1);
	        	
	        	p.teleport(StorageManager.desertspawns.get(i));
	        	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	        }
		}
		else{
			if(StorageManager.currentmap == KitPvPMap.Mountain_Village){
				p.teleport(StorageManager.mountainvillagespectatorspawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
			if(StorageManager.currentmap == KitPvPMap.Snow_Town){
				p.teleport(StorageManager.snowtownspectatorspawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
			if(StorageManager.currentmap == KitPvPMap.Desert){
				p.teleport(StorageManager.desertspectatorspawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
			p.setAllowFlight(true);
			p.setFlying(true);
		}
        
        PlayerManager.sendMapMessage(p);
	}
	
	public static void registerAllSpawns(World w){
		StorageManager.mountainvillagespawns.add(new Location(w, -352.5, 5, -1366.5, -54, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -317.5, 4, -1329.5, 46, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -283.5, 4, -1296.5, 165, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -303.5, 5, -1315.5, 39, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -284.5, 4, -1348.5, 168, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -303.5, 4, -1345.5, 135, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -316.5, 9, -1364.5, 30, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -337.5, 5, -1344.5, -126, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -349.5, 4, -1327.5, -113, 0));
		StorageManager.mountainvillagespawns.add(new Location(w, -323.5, 5, -1296.5, -161, 0));
		
		StorageManager.snowtownspawns.add(new Location(w, -63.5, 9, -1182.5, -45, 0));
		StorageManager.snowtownspawns.add(new Location(w, -92.5, 14, -1079.5, -166, 0));
		StorageManager.snowtownspawns.add(new Location(w, -134.5, 9, -1131.5, -113, 0));
		StorageManager.snowtownspawns.add(new Location(w, -115, 12.5, -1187.5, -70, 0));
		StorageManager.snowtownspawns.add(new Location(w, -90.5, 9, -1171.5, 143, 0));
		StorageManager.snowtownspawns.add(new Location(w, -62.5, 9, -1138.5, -71, 0));
		StorageManager.snowtownspawns.add(new Location(w, -108.5, 11, -1150.5, -139, 0));
		StorageManager.snowtownspawns.add(new Location(w, -91.5, 10, -1205.5, -30, 0));
		StorageManager.snowtownspawns.add(new Location(w, -144.5, 10, -1165.5, -75, 0));
		StorageManager.snowtownspawns.add(new Location(w, -66.5, 10, -1098.5, -126, 0));
		
		
		StorageManager.desertspawns.add(new Location(w, -463.5, 29.5, -1139, 20, 0));
		StorageManager.desertspawns.add(new Location(w, -422.5, 36, -1140.5, 105, 0));
		StorageManager.desertspawns.add(new Location(w, -484, 33, -1060, 155, 0));
		StorageManager.desertspawns.add(new Location(w, -523, 40, -1084, -90, 0));
		StorageManager.desertspawns.add(new Location(w, -516.5, 37, -1123.5, 140, 0));
		StorageManager.desertspawns.add(new Location(w, -450, 29, -1042.5, 156, 0));
		StorageManager.desertspawns.add(new Location(w, -430.5, 34, -1080.5, 93, 0));
		StorageManager.desertspawns.add(new Location(w, -451.5, 29, -1098.5, 20, 0));
		StorageManager.desertspawns.add(new Location(w, -430.5, 38, -1035.5, 135, 0));
		StorageManager.desertspawns.add(new Location(w, -510.5, 36, -1099.5, -123, 0));
	}
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}
	
    public void teleportToServer(Player p, Server server){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
 
        try {
            out.writeUTF("Connect");
            out.writeUTF(server.toString().toLowerCase());
        } catch (IOException eee) {
         
        }
 
        p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }
	
	public void registerPlayersOnline(Server server){
	    
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
    
		try{
			out.writeUTF("PlayerCount");
		  	out.writeUTF(server.toString().toLowerCase());
		}catch (IOException e){
			e.printStackTrace();
		}

		Bukkit.getServer().sendPluginMessage(this, "BungeeCord", b.toByteArray());
  	}
	
	public static Start getInstance(){
		return plugin;
	}	
	
	/* UUID Methods */
	public static UUID getUUIDfromString(String player){
		if(playeruuid.containsKey(player)){
			return playeruuid.get(player);
		}
		else{
			UUID uuid = UUID.fromString(DatabaseManager.getUUID(player));
			playeruuid.put(player, uuid);
			return uuid;
		}
	}
	public static UUID getUUIDfromPlayer(Player p){
		return p.getUniqueId();
	}
	public static String getPlayerNamefromUUID(UUID uuid){
		if(uuidplayer.containsKey(uuid)){
			return uuidplayer.get(uuid);
		}
		else{
			String player = DatabaseManager.getNameFromUUID(uuid);
			uuidplayer.put(uuid, player);
			return player;
		}
	}
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new BowShot(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent2(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityChangeBlock(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new EXPPickup(), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new SignsColor(), this);
		getServer().getPluginManager().registerEvents(new SneakEvent(), this);
		getServer().getPluginManager().registerEvents(new ToggleFlightEvent(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
	}
	
	private void startAllRunnables(){
		databaserunnable.startDatabaseRunnable();
		petrunnable.startPetRunnable();
		playerrunnable.startPlayerRunnable();
		scoreboardrunnable.startScoreboardRunnable();
		serverselectorrunnable.startServerSelectorRunnable();
		scoreboardtitlemanager.startScoreboardTitleRunnable();
	    arrowrunnables.startArcherArrowRunnable();
	    arrowrunnables.startHeavyArrowRunnable();
	    arrowrunnables.startNecromancerArrowRunnable();
	    arrowrunnables.startPyroArrowRunnable();
	    arrowrunnables.startSoldierArrowRunnable();
	    arrowrunnables.startTNTArrowRunnable();
	    boosterrunnable.startBoosterRunnable();
	    freekitrunnable.startFreeKitRunnable();
	    maprunnable.startMapRunnable();
	}
	
	private void removeAllEntities(){
		for(Entity en : StorageManager.lobbyworld.getEntities()){
			if(en instanceof Player){
				
			}
			else{
				en.remove();
			}
		}
	}
	
	protected static Field mapStringToClassField, mapClassToStringField, mapIdToClassField, mapClassToIdField, mapStringToIdField;

	static{
	   try{
	        mapStringToClassField = net.minecraft.server.v1_8_R1.EntityTypes.class.getDeclaredField("c");
	        mapClassToStringField = net.minecraft.server.v1_8_R1.EntityTypes.class.getDeclaredField("d");
	        mapClassToIdField = net.minecraft.server.v1_8_R1.EntityTypes.class.getDeclaredField("f");
	        mapStringToIdField = net.minecraft.server.v1_8_R1.EntityTypes.class.getDeclaredField("g");
	 
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

    public List<Block> getBlocksBetween(Location l1, Location l2){
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++) {
            for(int z = bottomBlockZ; z <= topBlockZ; z++){
                for(int y = bottomBlockY; y <= topBlockY; y++){
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
    
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {

		//Register All Commands for CommandPreprocessEvent
		if(cmd.getName().equalsIgnoreCase("servers")){}
		if(cmd.getName().equalsIgnoreCase("perks")){}
		if(cmd.getName().equalsIgnoreCase("opmode")){}
		if(cmd.getName().equalsIgnoreCase("topvoters")){}
		if(cmd.getName().equalsIgnoreCase("feed")){}
		if(cmd.getName().equalsIgnoreCase("eat")){}
		if(cmd.getName().equalsIgnoreCase("vote")){}
		if(cmd.getName().equalsIgnoreCase("fly")){}
		if(cmd.getName().equalsIgnoreCase("gamemode")){}
		if(cmd.getName().equalsIgnoreCase("gm")){}
		if(cmd.getName().equalsIgnoreCase("gmc")){}
		if(cmd.getName().equalsIgnoreCase("gms")){}
		if(cmd.getName().equalsIgnoreCase("gma")){}
		if(cmd.getName().equalsIgnoreCase("gmspec")){}
		if(cmd.getName().equalsIgnoreCase("skull")){}
		if(cmd.getName().equalsIgnoreCase("give")){}
		if(cmd.getName().equalsIgnoreCase("tp")){}
		if(cmd.getName().equalsIgnoreCase("teleport")){}
		if(cmd.getName().equalsIgnoreCase("disguise")){}
		if(cmd.getName().equalsIgnoreCase("undisguise")){}
		if(cmd.getName().equalsIgnoreCase("nick")){}
		if(cmd.getName().equalsIgnoreCase("afk")){}
		if(cmd.getName().equalsIgnoreCase("ban")){}
		if(cmd.getName().equalsIgnoreCase("unban")){}
		if(cmd.getName().equalsIgnoreCase("kick")){}
		if(cmd.getName().equalsIgnoreCase("kickall")){}
		if(cmd.getName().equalsIgnoreCase("heal")){}
		
		if(cmd.getName().equalsIgnoreCase("setvip")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 1){
					sender.sendMessage("§4§lOP §8| §7Use §6/setvip <player> <vip>");
				}
				else if(a.length == 2){			
		    		Player p2 = null;
		    		
		    		for(Player player : Bukkit.getOnlinePlayers()){
		    			if(player.getName().equalsIgnoreCase(a[0])){
		    				p2 = player;
		    			}
		    		}
		    		
		    		if(p2 != null){
						try{
							VIPRank rank = VIPRank.valueOf(a[1]);
							
							PlayerManager.handlePlayerRankDonation(p2, rank);
							
							sender.sendMessage("§4§lOP §8| §7You set §6" + p2.getName() + "'s§7 VIP Rank to §6" + rank.toString() + "§7!");
							
						}catch(Exception ex){
							sender.sendMessage("§4§lOP §8| §7VIP Rank §6" + a[1] + "§7 isn't a valid rank!");
						}
		    		}
		    		else{
		    			sender.sendMessage("§4§lOP §8| §7Player §6" + a[0] + "§7 isn't §aOnline§7!");
		    		}
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setvip <player> <vip>");
				}
			}
			else{
				sender.sendMessage("§3§lHub §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("setstaff")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 1){
					sender.sendMessage("§4§lOP §8| §7Use §6/setstaff <player> <staff>");
				}
				else if(a.length == 2){			
		    		Player p2 = null;
		    		
		    		for(Player player : Bukkit.getOnlinePlayers()){
		    			if(player.getName().equalsIgnoreCase(a[0])){
		    				p2 = player;
		    			}
		    		}
		    		
		    		if(p2 != null){
						try{
							StaffRank rank = StaffRank.valueOf(a[1]);
							
							if(StorageManager.staffrank.get(p2) != StaffRank.User){
								DatabaseManager.setStaffRank(p2, rank);
							}
							else{
								StorageManager.staffrank.put(p2, rank);
								DatabaseManager.insertString(p2.getName(), "Rank-Staff", "staff", rank.toString());
							}
							
							sender.sendMessage("§4§lOP §8| §7You set §6" + p2.getName() + "'s§7 Staff Rank to §6" + rank.toString() + "§7!");
							
						}catch(Exception ex){
							sender.sendMessage("§4§lOP §8| §7Staff Rank §6" + a[1] + "§7 isn't a valid rank!");
						}
		    		}
		    		else{
		    			sender.sendMessage("§4§lOP §8| §7Player §6" + a[0] + "§7 isn't §aOnline§7!");
		    		}
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setstaff <player> <staff>");
				}
			}
			else{
				sender.sendMessage("§3§lHub §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("votes")){
			
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(getUUIDfromPlayer((Player) sender)));
				}
				else if(a.length == 2){
					
					if(a[0].equalsIgnoreCase("add")){
						
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7You gave §b" + a[1] + "§7 a §b§lVote§7!");
						VoteManager.registerVote(a[1]);
				
					}
					else{
						sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Use §b/votes add <player>");
					}
				}
				else{
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Use §b/votes add <player>");
				}
				
			}
			else{
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(getUUIDfromPlayer((Player) sender)));
			}
		}
		if(cmd.getName().equalsIgnoreCase("vippoints")){
			
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.vippoints.get(sender));
				}
				else if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							PlayerManager.handlePlayerVIPPointsDonation(player, i);
							
							sender.sendMessage("§b§lVIP Points §8| §7You gave §b" + a[1] + " §b§l" + a[2] + " VIP Points§7!");
							
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[1] + " §7isn't §aOnline§7!");
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
							DatabaseManager.removeVIPPoints(player, i);
							
							sender.sendMessage("§b§lVIP Points §8| §7You removed §b§l" + a[2] + " VIP Points§7 from §b" + a[1] + "§7!");
							
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[1] + " §7isn't §aOnline§7!");
						}
						
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7/vippoints give|remove <player> <amount>");
					}
					
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7/vippoints give|remove <player> <amount>");
				}
			}
			else{
				sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.vippoints.get(sender));
			}
		}
		if(cmd.getName().equalsIgnoreCase("omt")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.orbitminestokens.get(sender));
				}
				else if(a.length == 3){
					
					if(a[0].equalsIgnoreCase("give")){
						
						int i = Integer.parseInt(a[2]);
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							DatabaseManager.addOMT(player, i);
							
							sender.sendMessage("§e§lOMT §8| §7You gave §e" + a[1] + " §e§l" + a[2] + " OMT§7!");
							
						}
						else{
							sender.sendMessage("§e§lOMT §8| §7Player §e" + a[1] + " §7isn't §aOnline§7!");
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
							DatabaseManager.removeOMT(player, i);
							
							sender.sendMessage("§e§lOMT §8| §7You removed §e§l" + a[2] + " OMT§7 from §e" + a[1] + "§7!");
							
						}
						else{
							sender.sendMessage("§e§lOMT §8| §7Player §e" + a[1] + " §7isn't §aOnline§7!");
						}
						
					}
					else{
						sender.sendMessage("§e§lOMT §8| §7/omt give|remove <player> <amount>");
					}
					
				}
				else{
					sender.sendMessage("§e§lOMT §8| §7/omt give|remove <player> <amount>");
				}
				
			}
			else{
				sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.orbitminestokens.get(sender));
			}
		}
		
		return false;
	}
}
