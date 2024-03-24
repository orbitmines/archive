package me.O_o_Fadi_o_O.Hub;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.Hub.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Hub.NMS.PetChicken;
import me.O_o_Fadi_o_O.Hub.NMS.PetCow;
import me.O_o_Fadi_o_O.Hub.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Hub.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Hub.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Hub.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Hub.NMS.PetPig;
import me.O_o_Fadi_o_O.Hub.NMS.PetSheep;
import me.O_o_Fadi_o_O.Hub.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Hub.NMS.PetSlime;
import me.O_o_Fadi_o_O.Hub.NMS.PetSpider;
import me.O_o_Fadi_o_O.Hub.NMS.PetSquid;
import me.O_o_Fadi_o_O.Hub.NMS.PetWolf;
import me.O_o_Fadi_o_O.Hub.events.AnimationEvent;
import me.O_o_Fadi_o_O.Hub.events.BlockChangeEvent;
import me.O_o_Fadi_o_O.Hub.events.BlockFormEvent;
import me.O_o_Fadi_o_O.Hub.events.BreakEvent;
import me.O_o_Fadi_o_O.Hub.events.ClickEvent;
import me.O_o_Fadi_o_O.Hub.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Hub.events.DamageEvent;
import me.O_o_Fadi_o_O.Hub.events.DespawnEvent;
import me.O_o_Fadi_o_O.Hub.events.DropEvent;
import me.O_o_Fadi_o_O.Hub.events.EntityDamage;
import me.O_o_Fadi_o_O.Hub.events.EntityDeath;
import me.O_o_Fadi_o_O.Hub.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Hub.events.ExplodeEvent;
import me.O_o_Fadi_o_O.Hub.events.FoodEvent;
import me.O_o_Fadi_o_O.Hub.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.Hub.events.JoinEvent;
import me.O_o_Fadi_o_O.Hub.events.PickupEvent;
import me.O_o_Fadi_o_O.Hub.events.PlaceEvent;
import me.O_o_Fadi_o_O.Hub.events.PlayerChat;
import me.O_o_Fadi_o_O.Hub.events.PlayerInteract;
import me.O_o_Fadi_o_O.Hub.events.PlayerMove;
import me.O_o_Fadi_o_O.Hub.events.ProjectileHit;
import me.O_o_Fadi_o_O.Hub.events.QuitEvent;
import me.O_o_Fadi_o_O.Hub.events.SignEvent;
import me.O_o_Fadi_o_O.Hub.events.VoteEvent;
import me.O_o_Fadi_o_O.Hub.managers.BungeeManager;
import me.O_o_Fadi_o_O.Hub.managers.ConfigManager;
import me.O_o_Fadi_o_O.Hub.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Hub.managers.MindCraftManager;
import me.O_o_Fadi_o_O.Hub.managers.NPCManager;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.managers.TitleManager;
import me.O_o_Fadi_o_O.Hub.managers.VoteManager;
import me.O_o_Fadi_o_O.Hub.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.MindCraftRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ParkourRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.SnowGollemAttackRunnable;
import me.O_o_Fadi_o_O.Hub.runnables.VoteRunnable;
import me.O_o_Fadi_o_O.Hub.utils.ArmorStandType;
import me.O_o_Fadi_o_O.Hub.utils.ChatColor;
import me.O_o_Fadi_o_O.Hub.utils.Disguise;
import me.O_o_Fadi_o_O.Hub.utils.Hat;
import me.O_o_Fadi_o_O.Hub.utils.Server;
import me.O_o_Fadi_o_O.Hub.utils.StaffRank;
import me.O_o_Fadi_o_O.Hub.utils.Trail;
import me.O_o_Fadi_o_O.Hub.utils.TrailType;
import me.O_o_Fadi_o_O.Hub.utils.VIPRank;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Hub extends JavaPlugin {
	
	private DatabaseRunnable databaserunnable;
	private EntityRunnable entityrunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	private VoteRunnable voterunnable;
	private ParkourRunnable parkourrunnable;
	private MindCraftRunnable mindcraftrunnable;
	private SnowGollemAttackRunnable snowgolemattackrunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private static Hub plugin;
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
	private Hologram hologram;
	
	public static Permission permission = null;

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
		
		plugin = this;
		
		hologram = new Hologram();
		
		databaserunnable = new DatabaseRunnable();
		entityrunnable = new EntityRunnable();
		petrunnable = new PetRunnable();
		playerrunnable = new PlayerRunnable();
		scoreboardrunnable = new ScoreboardRunnable();
	    serverselectorrunnable = new ServerSelectorRunnable();
		voterunnable = new VoteRunnable();
		parkourrunnable = new ParkourRunnable();
		mindcraftrunnable = new MindCraftRunnable();
		snowgolemattackrunnable = new SnowGollemAttackRunnable();
		
		scoreboardtitlemanager = new ScoreboardTitleManager();
		
		npcmanager = new NPCManager();
		pmanager = new PlayerManager();
		
		setupPermissions();
		
		StorageManager.thisserver = Server.HUB;
		StorageManager.spawn = new Location(StorageManager.hubworld, 0.5, 75, 0.5, 90, 0);

		StorageManager.lapisparkourlocation = new Location(StorageManager.hubworld, -36.5, 75, 37.5, 100, 0);
		StorageManager.mindcraftlocation = new Location(StorageManager.hubworld, 39.5, 77, 1.5, 0, 0);
		
		StorageManager.topvoter1 = new Location(StorageManager.hubworld, -5, 78, 38);
		StorageManager.topvoter2 = new Location(StorageManager.hubworld, -5, 77, 39);
		StorageManager.topvoter3 = new Location(StorageManager.hubworld, -5, 76, 37);
		
		StorageManager.topvotersign1 = new Location(StorageManager.hubworld, -6, 77, 38);
		StorageManager.topvotersign2 = new Location(StorageManager.hubworld, -6, 76, 39);
		StorageManager.topvotersign3 = new Location(StorageManager.hubworld, -6, 75, 37);
		
		StorageManager.lastdonator = new Location(StorageManager.hubworld, -7, 76, 8);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeManager());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee", new BungeeManager());
		
        
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
        
        for(ChatColor chatcolor : ChatColor.values()){
        	StorageManager.chatcolors.put(chatcolor, new ArrayList<Player>());
        }
        
        for(Trail trail : Trail.values()){
        	StorageManager.trails.put(trail, new ArrayList<Player>());
        }
        for(TrailType trailtype : TrailType.values()){
        	StorageManager.trailtypes.put(trailtype, new ArrayList<Player>());
        }
        
        for(Disguise disguise : Disguise.values()){
        	StorageManager.disguises.put(disguise, new ArrayList<Player>());
        }
        
        for(Hat hat : Hat.values()){
        	StorageManager.hats.put(hat, new ArrayList<Player>());
        }
		
		for(Server server : Server.values()){
			StorageManager.onlineplayers.put(server, -1);
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			p.teleport(StorageManager.spawn);
			StorageManager.loaded.put(p, false);
		}
		
		registerAllEvents();
		removeAllEntities();
		startAllRunnables();
	
		new BukkitRunnable(){
			public void run(){
		        ConfigManager.setup(Hub.getInstance());
		        
		        if(!ConfigManager.playerdata.contains("LastDonator")){
		        	ConfigManager.playerdata.set("LastDonator", "");
		        	ConfigManager.savePlayerData();
		        }
		        
				if(ConfigManager.playerdata.getStringList("VoteRewardsNotGiven") != null){
					List<String> list = new ArrayList<String>();
					for(String s : ConfigManager.playerdata.getStringList("VoteRewardsNotGiven")){
						list.add(s);
					}
					StorageManager.pendingvoters.clear();
					StorageManager.pendingvoters.addAll(list);
				}
				StorageManager.lastdonatorstring = getPlayerNamefromUUID(UUID.fromString(ConfigManager.playerdata.getString("LastDonator")));
				npcmanager.spawnArmorStand(
						StorageManager.hubworld, 
						new Location(StorageManager.hubworld, -6.5, 76, 8.5, -140, 0), 
						"§7Recent Donator",
						true, 
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
						new ItemStack(Material.SKULL_ITEM, 1),
						new ItemStack(Material.CHAINMAIL_HELMET, 1),
						new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
						new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
						new ItemStack(Material.ENDER_CHEST, 1),
						ArmorStandType.TOP_DONATOR);
			}
		}.runTaskLater(this, 100);
		try{
			npcmanager.spawnParkourSkeleton(StorageManager.hubworld, new Location(StorageManager.hubworld, -37.5, 75, 40.5, -130, 0), "§1§lLapis Parkour §8| §b§l250 VIP Points", Material.DIAMOND);
			npcmanager.spawnMindCraftSkeleton(StorageManager.hubworld, new Location(StorageManager.hubworld, 31.5, 75, 5.5, 140, 0), "§c§lMindCraft §7| §e§lClick to Join", Material.WOOL);
			npcmanager.spawnAlphaSkeleton(StorageManager.hubworld, new Location(StorageManager.hubworld, 5.5, 75, 5.5, 135, 0), "§e§lAlpha (Test) Server", Material.EMPTY_MAP);
			npcmanager.spawnServerSelector(StorageManager.hubworld, new Location(StorageManager.hubworld, -3.5, 75, -3.5, -45, 0), "§3§lServer Selector");
			
			hologram.createHologram(new Location(StorageManager.hubworld, -3.5, 77, 0.5, -90, 0), "§6§lOrbitMines§4§lNetwork §3§l1.8 §e§lBETA");
			hologram.createHologram(new Location(StorageManager.hubworld, -3.5, 76.75, 0.5, -90, 0), "§d§oReport bugs at §6§owww.orbitmines.com§d§o!");
			
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -4.0, 76, 0.5, -90, 0), 
					"§7Welcome to the §6§lOrbitMines§4§lNetwork§7!",
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(-0.2), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0.2), 
					false,
					new ItemStack(Material.DIAMOND_BLOCK, 1),
					new ItemStack(Material.DIAMOND_CHESTPLATE, 1),
					new ItemStack(Material.DIAMOND_LEGGINGS, 1),
					new ItemStack(Material.DIAMOND_BOOTS, 1),
					new ItemStack(Material.DIAMOND_SWORD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 8.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("O_o_Fadi_o_O"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.RED),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.RED),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.RED),
					new ItemStack(Material.REDSTONE_COMPARATOR, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 7.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("eekhoorn2000"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.AQUA),
					new ItemStack(Material.COMPASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 6.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("sharewoods"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.AQUA),
					new ItemStack(Material.COMPASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 5.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("jim5491158"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.AQUA),
					new ItemStack(Material.COMPASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 4.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("rienk222"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.AQUA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.AQUA),
					new ItemStack(Material.COMPASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -23.5, 77, 3.5, -90, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					PlayerManager.getPlayerHead("casidas"),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.FUCHSIA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.FUCHSIA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.FUCHSIA),
					new ItemStack(Material.WOOD_AXE, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -49.5, 78, 3.5, -90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.CHAINMAIL_HELMET, 1),
					new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
					new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
					new ItemStack(Material.CHAINMAIL_BOOTS, 1),
					new ItemStack(Material.IRON_SWORD, 1),
					ArmorStandType.SERVER_INFO_KITPVP);
			ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			pickaxe.addEnchantment(Enchantment.DIG_SPEED, 1);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -43.5, 78, -33.5, -90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.IRON_HELMET, 1),
					new ItemStack(Material.IRON_CHESTPLATE, 1),
					new ItemStack(Material.IRON_LEGGINGS, 1),
					new ItemStack(Material.IRON_BOOTS, 1),
					pickaxe,
					ArmorStandType.SERVER_INFO_PRISON);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -38.5, 78, -63.5, -90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.GOLD_HELMET, 1),
					new ItemStack(Material.GOLD_CHESTPLATE, 1),
					new ItemStack(Material.GOLD_LEGGINGS, 1),
					new ItemStack(Material.GOLD_BOOTS, 1),
					new ItemStack(Material.WOOD_AXE, 1),
					ArmorStandType.SERVER_INFO_CREATIVE);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, 7.5, 78, -65.5, 0, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.LEATHER_HELMET, 1),
					new ItemStack(Material.IRON_CHESTPLATE, 1),
					new ItemStack(Material.LEATHER_LEGGINGS, 1),
					new ItemStack(Material.LEATHER_BOOTS, 1),
					new ItemStack(Material.STONE_HOE, 1),
					ArmorStandType.SERVER_INFO_SURVIVAL);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -9.5, 78, 74.5, -180, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.LEATHER_HELMET, 1),
					new ItemStack(Material.LEATHER_CHESTPLATE, 1),
					new ItemStack(Material.LEATHER_LEGGINGS, 1),
					new ItemStack(Material.LEATHER_BOOTS, 1),
					new ItemStack(Material.FISHING_ROD, 1),
					ArmorStandType.SERVER_INFO_SKYBLOCK);
			npcmanager.spawnArmorStand(
					StorageManager.hubworld, 
					new Location(StorageManager.hubworld, -40.5, 78, 48.5, -90, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.1).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					new ItemStack(Material.LEATHER_HELMET, 1),
					new ItemStack(Material.GOLD_CHESTPLATE, 1),
					new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
					new ItemStack(Material.DIAMOND_BOOTS, 1),
					new ItemStack(Material.BOW, 1),
					ArmorStandType.SERVER_INFO_MINIGAMES);
		}catch(NullPointerException ex){
			new BukkitRunnable(){
				public void run(){
					getServer().dispatchCommand(getServer().getConsoleSender(), "reload");
				}
			}.runTaskLater(this, 20);
		}
		
		MindCraftManager.registerAllBlocksForTurn(StorageManager.hubworld);
		MindCraftManager.registerAllBlockStatusForTurn(StorageManager.hubworld);
		
		StorageManager.mindcraftwinssignlocation = new Location(StorageManager.hubworld, 41, 79, 2);
		StorageManager.mindcraftbestgamesignlocation = new Location(StorageManager.hubworld, 37, 79, 2);
		
		new BukkitRunnable(){
			
			public void run(){
				
				for(Player p : Bukkit.getOnlinePlayers()){
					pmanager.loadPlayer(p);	
				}
			}
		}.runTaskLater(this, 100);
		
		registerServerPortal(Server.KITPVP);
		registerServerPortal(Server.PRISON);
		registerServerPortal(Server.CREATIVE);
		registerServerPortal(Server.SURVIVAL);
		registerServerPortal(Server.SKYBLOCK);
		registerServerPortal(Server.MINIGAMES);
		
		new BukkitRunnable(){
			
			public void run(){
				
				registerPlayersOnline(Server.KITPVP);
				registerPlayersOnline(Server.PRISON);
				registerPlayersOnline(Server.CREATIVE);
				registerPlayersOnline(Server.HUB);
				registerPlayersOnline(Server.SKYBLOCK);
				registerPlayersOnline(Server.SURVIVAL);
				registerPlayersOnline(Server.MINIGAMES);
				registerPlayersOnline(Server.ALPHA);
			
			}
		}.runTaskTimer(this, 0, 20);
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.teleport(StorageManager.spawn);
			
			if(StorageManager.nickname.containsKey(p)){
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", getUUIDfromPlayer(p).toString())){
					DatabaseManager.setNickname(p, StorageManager.nickname.get(p));
				}
				else{
					DatabaseManager.insertString(p.getName(), "PlayerNicknames", "nick", StorageManager.nickname.get(p));
				}
			}
			else{
				if(DatabaseManager.containsPath("uuid", "PlayerNicknames", getUUIDfromPlayer(p).toString())){
					DatabaseManager.removeNickname(p);
				}
			}
			
			String fwsettings = PlayerManager.parseStringFromColor(StorageManager.fireworkcolor1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkcolor2.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade1.get(p)) + "|" + PlayerManager.parseStringFromColor(StorageManager.fireworkfade2.get(p)) + "|" + StorageManager.fireworkflicker.get(p) + "|" + StorageManager.fireworktrail.get(p) + "|" + StorageManager.fireworktype.get(p);
			DatabaseManager.setFireworkSettings(p, fwsettings);
			
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
			DatabaseManager.setFireworksPasses(p, StorageManager.fireworkpasses.get(p));
		}
	}
	
	public void sendTimeMessage(final Player p, final String message, int seconds, final boolean ticksound){
		new BukkitRunnable(){
			public void run(){
				p.sendMessage(message);
				if(ticksound == true){
					p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				}
			}
		}.runTaskLater(this, seconds * 20);
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
	
	public void registerServerPortal(Server server){
		if(server == Server.KITPVP){
			Location l1 = new Location(StorageManager.hubworld, -52, 75, 6);
			Location l2 = new Location(StorageManager.hubworld, -52, 87, 0);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
		if(server == Server.PRISON){
			Location l1 = new Location(StorageManager.hubworld, -46, 87, -37);
			Location l2 = new Location(StorageManager.hubworld, -46, 75, -31);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
		if(server == Server.CREATIVE){
			Location l1 = new Location(StorageManager.hubworld, -41, 75, -61);
			Location l2 = new Location(StorageManager.hubworld, -41, 87, -67);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
		if(server == Server.SURVIVAL){
			Location l1 = new Location(StorageManager.hubworld, 4, 75, -68);
			Location l2 = new Location(StorageManager.hubworld, 10, 87, -68);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
		if(server == Server.SKYBLOCK){
			Location l1 = new Location(StorageManager.hubworld, -7, 75, 76);
			Location l2 = new Location(StorageManager.hubworld, -13, 86, 76);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
		if(server == Server.MINIGAMES){
			Location l1 = new Location(StorageManager.hubworld, -43, 75, 51);
			Location l2 = new Location(StorageManager.hubworld, -43, 87, 45);
			StorageManager.serverportals.put(server, getBlocksBetween(l1, l2));
		}
	}
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new PickupEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		getServer().getPluginManager().registerEvents(new BlockChangeEvent(), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DespawnEvent(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		getServer().getPluginManager().registerEvents(new AnimationEvent(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new SignEvent(), this);
		getServer().getPluginManager().registerEvents(new BlockFormEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
	}
	
	private void startAllRunnables(){
		databaserunnable.startDatabaseRunnable();
		entityrunnable.startEntityRunnable();
		petrunnable.startPetRunnable();
		playerrunnable.startPlayerRunnable();
		scoreboardrunnable.startScoreboardRunnable();
		serverselectorrunnable.startServerSelectorRunnable();
		voterunnable.startVoteRunnable();
		parkourrunnable.startParkourRunnable();
		mindcraftrunnable.startMindCraftRunnable();
		scoreboardtitlemanager.startScoreboardTitleRunnable();
		snowgolemattackrunnable.startPetSnowGollemAttackRunnable();
	}
	
	public static Hub getInstance(){
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
	
	private void removeAllEntities(){
		for(World w : Bukkit.getWorlds()){
			for(Entity en : w.getEntities()){
				if(en instanceof Player){
					
				}
				else{
					en.remove();
				}
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
		if(cmd.getName().equalsIgnoreCase("dis")){}
		if(cmd.getName().equalsIgnoreCase("d")){}
		if(cmd.getName().equalsIgnoreCase("builder")){}
		
		if(cmd.getName().equalsIgnoreCase("setlastdonator")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§4§lOP §8| §7Use §6/setlastdonator <player>");
				}
				else if(a.length == 1){			
		    		Player p2 = null;
		    		
		    		for(Player player : Bukkit.getOnlinePlayers()){
		    			if(player.getName().equalsIgnoreCase(a[0])){
		    				p2 = player;
		    			}
		    		}
		    		
		    		if(p2 != null){
						PlayerManager.setLastDonator(p2);
						sender.sendMessage("§4§lOP §8| §7You set §6" + p2.getName() + "§7 as the last Donator§7!");
		    		}
		    		else{
		    			sender.sendMessage("§4§lOP §8| §7Player §6" + a[0] + "§7 isn't §aOnline§7!");
		    		}
				}
				else{
					sender.sendMessage("§4§lOP §8| §7Use §6/setlastdonator <player>");
				}
			}
			else{
				sender.sendMessage("§3§lHub §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
			}
		}
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
		if(cmd.getName().equalsIgnoreCase("resetMonthlyVIPPoints")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				
				if(a.length == 1){
					Player player = null;
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(a[0])){
							player = p;
						}
					}
					
					if(player != null){
						DatabaseManager.removeUUID(getUUIDfromPlayer(player).toString(), "PlayerMonthlyVIPPoints");
						
						TitleManager.setTitle(player, "", "§7You can now claim your §bMonthly VIP Points§7.");
						
						StorageManager.usedmonthlyvippoints.put(player, false);
						sender.sendMessage("§b§lVIP Points §8| §b" + player.getName() + "§7 can claim their §b§lMonthly VIP Points§7!");
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 isn't §aOnline§7!");
					}
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7Use §b/resetMonthlyVIPPoints <player>");
				}
				
			}
		}
		if(cmd.getName().equalsIgnoreCase("giveMonthlyVIPPoints")){
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				
				if(a.length == 1){
					Player player = null;
					
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(a[0])){
							player = p;
						}
					}
					
					if(player != null){
						
						if(!StorageManager.usedmonthlyvippoints.containsKey(player)){
							if(DatabaseManager.containsPath("name", "PlayerMonthlyVIPPoints", player.getName())){
								StorageManager.usedmonthlyvippoints.put(player, true);
							}
							else{
								StorageManager.usedmonthlyvippoints.put(player, false);
							}
						}
						
						if(StorageManager.usedmonthlyvippoints.get(player) == false){
							int amount = 0;
							
							if(StorageManager.viprank.get(player) == VIPRank.Iron_VIP){
								amount = 250;
							}
							if(StorageManager.viprank.get(player) == VIPRank.Gold_VIP){
								amount = 500;
							}
							if(StorageManager.viprank.get(player) == VIPRank.Diamond_VIP){
								amount = 1250;
							}
							if(StorageManager.viprank.get(player) == VIPRank.Emerald_VIP){
								amount = 2500;
							}
							
							PlayerManager.handlePlayerVIPPointsDonation(player, amount);
							
							sender.sendMessage("§b§lVIP Points §8| §7You gave §b" + PlayerManager.getPlayerDisplayname(player) + " §b§l" + amount + " VIP Points§7!");
							DatabaseManager.insertUUID(getUUIDfromPlayer(player).toString(), "PlayerMonthlyVIPPoints");
							StorageManager.usedmonthlyvippoints.put(player, true);
						}
						else{
							sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 already claimed their §bMonthly VIP Points§7!");
							TitleManager.setTitle(player, "", "§7You already claimed your §bMonthly VIP Points§7!");
						}
					}
					else{
						sender.sendMessage("§b§lVIP Points §8| §7Player §b" + a[0] + "§7 isn't §aOnline§7!");
					}
				}
				else{
					sender.sendMessage("§b§lVIP Points §8| §7Use §b/giveMonthlyVIPPoints <player>");
				}
				
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("votes")){
			
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(((Player) sender).getUniqueId()));
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
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(((Player) sender).getUniqueId()));
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
	
    private boolean setupPermissions(){
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
}
