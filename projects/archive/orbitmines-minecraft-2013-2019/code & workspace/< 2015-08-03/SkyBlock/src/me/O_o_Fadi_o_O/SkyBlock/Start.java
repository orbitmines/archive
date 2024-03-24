package me.O_o_Fadi_o_O.SkyBlock;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.SkyBlock.Inv.ServerSelector;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomVillager;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetChicken;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetCow;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetCreeper;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetOcelot;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetPig;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetSheep;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetSlime;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetSpider;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetSquid;
import me.O_o_Fadi_o_O.SkyBlock.NMS.PetWolf;
import me.O_o_Fadi_o_O.SkyBlock.events.BreakEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.ClickEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.ClickEvent2;
import me.O_o_Fadi_o_O.SkyBlock.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.EntityDamage;
import me.O_o_Fadi_o_O.SkyBlock.events.EntityDeath;
import me.O_o_Fadi_o_O.SkyBlock.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.InteractEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.JoinEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.PlaceEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.PlayerChat;
import me.O_o_Fadi_o_O.SkyBlock.events.PlayerMove;
import me.O_o_Fadi_o_O.SkyBlock.events.QuitEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.VoteEvent;
import me.O_o_Fadi_o_O.SkyBlock.inventories.ChallengesInv;
import me.O_o_Fadi_o_O.SkyBlock.inventories.IslandInfoInv;
import me.O_o_Fadi_o_O.SkyBlock.island.IslandCreator;
import me.O_o_Fadi_o_O.SkyBlock.managers.BungeeManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.ConfigManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.DatabaseManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.EmptyWorldGenerator;
import me.O_o_Fadi_o_O.SkyBlock.managers.IslandManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.NPCManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.TitleManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.VoteManager;
import me.O_o_Fadi_o_O.SkyBlock.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.SkyBlock.runnables.PetRunnable;
import me.O_o_Fadi_o_O.SkyBlock.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.SkyBlock.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.SkyBlock.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.SkyBlock.utils.ArmorStandType;
import me.O_o_Fadi_o_O.SkyBlock.utils.ChatColor;
import me.O_o_Fadi_o_O.SkyBlock.utils.Disguise;
import me.O_o_Fadi_o_O.SkyBlock.utils.IslandRank;
import me.O_o_Fadi_o_O.SkyBlock.utils.Server;
import me.O_o_Fadi_o_O.SkyBlock.utils.StaffRank;
import me.O_o_Fadi_o_O.SkyBlock.utils.Trail;
import me.O_o_Fadi_o_O.SkyBlock.utils.TrailType;
import me.O_o_Fadi_o_O.SkyBlock.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Start extends JavaPlugin {
	
	public static String TAG = "§5§lSkyBlock §8| §7";
	
	private DatabaseRunnable databaserunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
	public static Start plugin;
	
	private IslandCreator islandCreator;
	private JoinEvent joinEvent;
	ServerSelector sinv = new ServerSelector();
	
	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		return new EmptyWorldGenerator(this);
	}

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
		
		addCustomEntity(CustomVillager.class, "CustomVillager", 120);
		addCustomEntity(CustomCreeper.class, "CustomCreeper", 50);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 51);
		addCustomEntity(CustomBlaze.class, "CustomBlaze", 61);
		
		plugin = this;
		databaserunnable = new DatabaseRunnable();
		petrunnable = new PetRunnable();
		playerrunnable = new PlayerRunnable();
		scoreboardrunnable = new ScoreboardRunnable();
	    serverselectorrunnable = new ServerSelectorRunnable();
		
		scoreboardtitlemanager = new ScoreboardTitleManager();
		
		npcmanager = new NPCManager();
		pmanager = new PlayerManager();
		islandCreator = new IslandCreator();
		joinEvent = new JoinEvent();
		
		StorageManager.thisserver = Server.SKYBLOCK;
		StorageManager.spawn = new Location(StorageManager.lobbyworld, 0.5, 74, 0.5, 0, 0);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeManager());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, StorageManager.thisserver.toString() + "Bungee", new BungeeManager());
		
        ConfigManager.setup(this);
        
		if(ConfigManager.playerdata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.playerdata.getStringList("VoteRewardsNotGiven")){
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
        
        for(Disguise disguise : Disguise.values()){
        	StorageManager.disguises.put(disguise, new ArrayList<Player>());
        }
        
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
			npcmanager.spawnServerSelector(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 3.5, 76, 5.5, 0, 0), "§3§lServer Selector");
			npcmanager.spawnOMTShop(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -2.5, 75, -5.5, 0, 0), "§e§lOMT Shop");
			
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 0.5, 72.5, 20.5, 180, 0), 
					"§dJump down to §d§lPlay§d!",
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
					new ItemStack(Material.LEATHER_HELMET, 1),
					new ItemStack(Material.LEATHER_CHESTPLATE, 1),
					new ItemStack(Material.LEATHER_LEGGINGS, 1),
					new ItemStack(Material.LEATHER_BOOTS, 1),
					new ItemStack(Material.FISHING_ROD, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 2.5, 74, 12.5, -12, 0), 
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
					new ItemStack(Material.GRASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 3.25, 73.75, 12.13, -38, 0), 
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
					new ItemStack(Material.GRASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 5, 73.75, 11.79, 50, 0), 
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
					new ItemStack(Material.GRASS, 1),
					ArmorStandType.NORMAL);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 3.85, 75.1, 12.32, 47, 0), 
					null,
					true, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0.15).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(-0.05 + 0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.75 + 0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75 + 0.1).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-0.75 + 0.5).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0.6 + 0.5).setY(0).setZ(0), 
					false,
					new ItemStack(Material.LEATHER_HELMET, 1),
					new ItemStack(Material.LEATHER_CHESTPLATE, 1),
					new ItemStack(Material.LEATHER_LEGGINGS, 1),
					new ItemStack(Material.LEATHER_BOOTS, 1),
					null,
					ArmorStandType.NORMAL);
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
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		StorageManager.islandsamount = getConfig().getInt("Islands");
		
		// GATHER CHALLENGES
		StorageManager.challenges.add("Cobblestone Generator");
		StorageManager.challenges.add("Apples");
		StorageManager.challenges.add("Jack the Lumberjack");
		
		StorageManager.challenges.add("More Smoothness");
		StorageManager.challenges.add("Fishing Time!");
		StorageManager.challenges.add("Chop Chop");
		
		StorageManager.challenges.add("Navigation");
		StorageManager.challenges.add("Librarian");
		StorageManager.challenges.add("The Dark Forest");
		
		StorageManager.challenges.add("It's Time");
		StorageManager.challenges.add("Stained Clay");
		
		StorageManager.challenges.add("Sheep Shearing");
		StorageManager.challenges.add("Windows");
		
		StorageManager.challenges.add("Wood Factory");
		StorageManager.challenges.add("Lucky Fishing");
		//
		
		// FARM CHALLENGES
		StorageManager.challenges.add("Melons");
		StorageManager.challenges.add("Halloween Party");
		StorageManager.challenges.add("Sugarcane");
		
		StorageManager.challenges.add("Melon Blocks?!");
		StorageManager.challenges.add("Mushroom Hunting");
		StorageManager.challenges.add("Bacon");
		
		StorageManager.challenges.add("Rabbits");
		StorageManager.challenges.add("Baker");
		StorageManager.challenges.add("Potatoes");
		
		StorageManager.challenges.add("Cookie Monster");
		StorageManager.challenges.add("Cactus");
		
		StorageManager.challenges.add("KFC Delivery");
		StorageManager.challenges.add("Steak");
		
		StorageManager.challenges.add("Grandmother's Kitchen");
		
		StorageManager.challenges.add("Cakes");
		//
		
		// MOB CHALLENGES
		StorageManager.challenges.add("Skeletons");
		StorageManager.challenges.add("Arrows!");
		
		StorageManager.challenges.add("Zombie Apocalypse");
		StorageManager.challenges.add("Creepy Creeper");
		
		StorageManager.challenges.add("Destroy the Webs!");
		StorageManager.challenges.add("Spider Eyes");
		
		StorageManager.challenges.add("Enderwoman");
		
		//
		
		new BukkitRunnable(){
			public void run(){
				if(ConfigManager.islands.contains("islands")){
					for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
						int IslandNumber = Integer.parseInt(s);
						
						StorageManager.islandlocation.put(IslandNumber, IslandManager.getIslandLocation(IslandNumber));
						StorageManager.islandmembers.put(IslandNumber, IslandManager.getIslandMembers(IslandNumber));
						StorageManager.islandowner.put(IslandNumber, IslandManager.getIslandOwner(IslandNumber));
						StorageManager.islandcreateddate.put(IslandNumber, IslandManager.getIslandCreatedDate(IslandNumber));
						StorageManager.islandteleportenabled.put(IslandNumber, IslandManager.getIslandTeleportEnabled(IslandNumber));
					}
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					joinEvent.loadPlayerIslandInfo(p);
				}
			}
		}.runTaskLater(this, 40);
	}
	public void teleportToSpawn(final Player p){
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.spawn);
			}
		}.runTaskLater(this, 5);
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			
			//p.teleport(StorageManager.spawn);
			
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
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent2(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
	}
	
	private void startAllRunnables(){
		databaserunnable.startDatabaseRunnable();
		petrunnable.startPetRunnable();
		playerrunnable.startPlayerRunnable();
		scoreboardrunnable.startScoreboardRunnable();
		serverselectorrunnable.startServerSelectorRunnable();
		scoreboardtitlemanager.startScoreboardTitleRunnable();
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
	
	public void setIslandAmount(int IslandAmount){
		StorageManager.islandsamount = IslandAmount;
		getConfig().set("Islands", IslandAmount);
		saveConfig();
	}
	
	public static List<String> getHelpMessage(){
		
		List<String> list = new ArrayList<String>();
		list.add(TAG + "§lHelp Menu:");
		list.add(TAG + "§d/is home | h §7§o(Teleport to your Island)");
		list.add(TAG + "§d/is sethome §7§o(Set your Island Home)");
		list.add(TAG + "§d/is help §7§o(Show this Menu)");
		list.add(TAG + "§d/is invite <player> §7§o(Invite a Player)");
		list.add(TAG + "§d/is remove <player> §7§o(Remove a Player)");
		list.add(TAG + "§d/is accept §7§o(Accept an Island invite)");
		list.add(TAG + "§d/is deny §7§o(Deny an Island invite)");
		list.add(TAG + "§d/is tp | teleport <player> §7§o(Teleport to an Island)");
		list.add(TAG + "§d/is c | challenge §7§o(Open the Challenges Menu)");
		list.add(TAG + "§d/is leave §7§o(Leave your Island)");
		list.add(TAG + "§d/is restart §7§o(Restart your Island)");
		list.add(TAG + "§d/is info §7§o(Open the Island Info Menu)");
		
		return list;
	}
	
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
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
				sender.sendMessage("§5§lSkyBlock §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
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
				sender.sendMessage("§5§lSkyBlock §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("votes")){
			
			if(sender == getServer().getConsoleSender() || sender instanceof Player && StorageManager.opmodeenabled.get((Player) sender) == true){
				if(a.length == 0){
					sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(sender.getName()));
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
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(sender.getName()));
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
		if(cmd.getName().equalsIgnoreCase("is") || cmd.getName().equalsIgnoreCase("island")){
			if(sender instanceof Player){
				final Player p = (Player) sender;
				
				if(a.length == 0){
					for(String s : getHelpMessage()){
						p.sendMessage(s);
					}
				}
				else if(a[0].equalsIgnoreCase("help")){
					for(String s : getHelpMessage()){
						p.sendMessage(s);
					}
				}
				else if(a[0].equalsIgnoreCase("restart")){
					if(PlayerManager.hasIsland(p)){
						p.chat("/is leave");
						p.chat("/is h");
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("home") || a[0].equalsIgnoreCase("h") || a[0].equalsIgnoreCase("start")){
					
					if(PlayerManager.hasIsland(p)){
						if(!PlayerManager.isInTheVoid(p)){
							p.sendMessage(Start.TAG + "§7Teleporting to your §dIsland§7...");
							new BukkitRunnable(){
								public void run(){
									p.teleport(StorageManager.playersislandhomelocation.get(p));
									p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
									TitleManager.setTitle(p, "", "§7Teleported to your §dIsland§7.");
								}
							}.runTaskLater(this, 10);
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You're in the Void!");
						}
					}
					else{
						for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
							int IslandNumber = Integer.parseInt(s);
							
							StorageManager.islandlocation.put(IslandNumber, IslandManager.getIslandLocation(IslandNumber));
							StorageManager.islandmembers.put(IslandNumber, IslandManager.getIslandMembers(IslandNumber));
							StorageManager.islandowner.put(IslandNumber, IslandManager.getIslandOwner(IslandNumber));
							StorageManager.islandcreateddate.put(IslandNumber, IslandManager.getIslandCreatedDate(IslandNumber));
							StorageManager.islandteleportenabled.put(IslandNumber, IslandManager.getIslandTeleportEnabled(IslandNumber));
						}
						islandCreator.createIsland(StorageManager.islandsamount +1, p);
						for(Player player : Bukkit.getOnlinePlayers()){
							joinEvent.loadPlayerIslandInfo(player);
						}
					}
					
				}
				else if(a[0].equalsIgnoreCase("sethome") || a[0].equalsIgnoreCase("h")){
					if(PlayerManager.hasIsland(p)){
						if(PlayerManager.isOnOwnIsland(p, p.getLocation())){
							if(!PlayerManager.isInTheVoid(p)){
								if(p.getWorld().getName().equals("SkyBlock")){
									IslandManager.setPlayersIslandHomeLocation(p, p.getLocation());
									p.sendMessage(Start.TAG + "§dIsland Home§7 set!");
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 You can't set your §dIsland Home§7 here!");
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You're in the Void!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dIsland§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("invite")){
					if(PlayerManager.hasIsland(p)){
						if(StorageManager.playersislandrank.get(p) == IslandRank.OWNER){
							if(a.length == 2){
							
								if(StorageManager.islandmembers.get(StorageManager.playersislandnumber.get(p)).size() != 9){
									Player p1 = null;
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equals(a[1])){
											p1 = player;
										}
									}
								
									
									if(p1 != null){
										int IslandNumber =  StorageManager.playersislandnumber.get(p);
										List<UUID> membersuuids = StorageManager.islandmembers.get(IslandNumber);
										if(!StorageManager.playerhasisland.containsKey(p1)){
											p.sendMessage(Start.TAG + "§d" + a[1] + "§7 has been invited to your §dIsland§7!");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											StorageManager.playersislandinvite.put(p1, IslandNumber);
											p1.sendMessage(Start.TAG + "§d" + p.getName() + "§7 has invited you to their §dIsland§7!");
											p1.sendMessage(Start.TAG + "Type §d/is accept§7 to §aAccept§7 or §d/is deny§7 to §cDeny§7.");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											
											for(Player player : Bukkit.getOnlinePlayers()){
												if(membersuuids.contains(player.getUniqueId())){
													player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 invited §d" + a[1] + "§7 to your §dIsland§7!");
													player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												}
											}
											
											TitleManager.setTitle(p, "", "§7Invite sent!");
										}
										else{
											if(StorageManager.playerhasisland.get(p1) == false){
												p.sendMessage(Start.TAG + "§d" + a[1] + "§7 has been invited to your §dIsland§7!");
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												StorageManager.playersislandinvite.put(p1, IslandNumber);
												p1.sendMessage(Start.TAG + "§d" + p.getName() + "§7 has invited you to their §dIsland§7!");
												p1.sendMessage(Start.TAG + "Type §d/is accept§7 to §aAccept§7 or §d/is deny§7 to §cDeny§7.");
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												for(Player player : Bukkit.getOnlinePlayers()){
													if(membersuuids.contains(player.getUniqueId())){
														player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 invited §d" + a[1] + "§7 to your §dIsland§7!");
														player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													}
												}
												
												TitleManager.setTitle(p, "", "§7Invite sent!");
											}
											else{
												p.sendMessage(Start.TAG + "§4§lDENIED§7 §d" + a[1] + "§7 is already on an §dIsland§7!");
											}
										}
									}
									else{
										p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't §aOnline§7!");
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lDENIED§7 Your §dIsland§7 reached the §aPlayer Limit§7!");
								}
								
							}
							else{
								p.sendMessage(TAG + "Incorrect Use!");
								p.sendMessage(TAG + "Use: §d/is invite <player>");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You aren't the §downer§7 of your §dIsland§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
					
				}
				else if(a[0].equalsIgnoreCase("remove")){
					if(PlayerManager.hasIsland(p)){
						if(StorageManager.playersislandrank.get(p) == IslandRank.OWNER){
							if(a.length == 2){
								int IslandNumber = StorageManager.playersislandnumber.get(p);
								
								if(!a[1].equals(p.getName())){
									if(StorageManager.islandmembers.get(IslandNumber).contains(getUUIDfromString(a[1]))){
										
										List<UUID> membersuuids = StorageManager.islandmembers.get(IslandNumber);
										membersuuids.remove(getUUIDfromString(a[1]));
										IslandManager.setIslandMembers(IslandNumber, membersuuids);
										
										ConfigManager.playerdata.set("players." + getUUIDfromString(a[1]), null);
										ConfigManager.savePlayerdata();
										
										for(Player player : Bukkit.getOnlinePlayers()){
											if(membersuuids.contains(player.getUniqueId())){
												player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 removed §d" + a[1] + "§7 from your §dIsland§7!");
												player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											}
											if(player.getName().equals(a[1])){
												StorageManager.playerhasisland.put(player, false);
												player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 removed you from their §dIsland§7!");
												player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												clearInventory(player);
												player.chat("/spawn");
											}
										}
										
										p.sendMessage(Start.TAG + "You removed §d" + a[1] + "§7 from your §dIsland§7!");
										p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										
										for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
											int IslandNumbers = Integer.parseInt(s);
											
											StorageManager.islandlocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
											StorageManager.islandmembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
											StorageManager.islandowner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
											StorageManager.islandcreateddate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
											StorageManager.islandteleportenabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
										}
										for(Player player : Bukkit.getOnlinePlayers()){
											joinEvent.loadPlayerIslandInfo(player);
										}
										
									}
									else{
										p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't on your §dIsland§7!");
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lERROR§7 You can't remove yourself from your §dIsland§7!");
								}
							}
							else{
								p.sendMessage(TAG + "Incorrect Use!");
								p.sendMessage(TAG + "Use: §d/is remove <player>");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You aren't the §downer§7 of your §dIsland§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("accept")){
					if(StorageManager.playersislandinvite.containsKey(p)){
						if(!PlayerManager.hasIsland(p)){
							int IslandNumber = StorageManager.playersislandinvite.get(p);
							List<UUID> membersuuids = StorageManager.islandmembers.get(IslandNumber);
							if(membersuuids.size() != 9){
								StorageManager.playerhasisland.put(p, true);
								StorageManager.playersislandinvite.remove(p);
								for(Player player : Bukkit.getOnlinePlayers()){
									if(membersuuids.contains(player.getUniqueId()) || StorageManager.islandowner.get(IslandNumber) == player.getUniqueId()){
										player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 joined your §dIsland§7!");
										player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
								}
								p.sendMessage(Start.TAG + "You joined §d" + getPlayerNamefromUUID(StorageManager.islandowner.get(IslandNumber)) + "s Island§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								IslandManager.setPlayersIslandNumber(p, IslandNumber);
								IslandManager.setPlayersIslandHomeLocation(p, IslandManager.getOfflinePlayersIslandHomeLocation(StorageManager.islandowner.get(IslandNumber)));
								IslandManager.setPlayersIslandRank(p, IslandRank.MEMBER);
								
								IslandManager.addIslandMember(IslandNumber, p);
								IslandManager.resetChallenges(p);
								
								clearInventory(p);
								p.sendMessage(Start.TAG + "§7Teleporting to your §dIsland§7...");
								new BukkitRunnable(){
									public void run(){
										p.teleport(StorageManager.playersislandhomelocation.get(p));
										p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
										TitleManager.setTitle(p, "", "§7Teleported to your §dIsland§7.");
									}
								}.runTaskLater(this, 10);
								
								for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
									int IslandNumbers = Integer.parseInt(s);
									
									StorageManager.islandlocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
									StorageManager.islandmembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
									StorageManager.islandowner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
									StorageManager.islandcreateddate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
									StorageManager.islandteleportenabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
								}
								for(Player player : Bukkit.getOnlinePlayers()){
									joinEvent.loadPlayerIslandInfo(player);
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 That §dIsland§7 reached the §aPlayer Limit§7!");
								StorageManager.playersislandinvite.remove(p);
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You already have an §dIsland§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 Nobody has §dinvited§7 you yet!");
					}
					
				}
				else if(a[0].equalsIgnoreCase("deny")){
					if(StorageManager.playersislandinvite.containsKey(p)){
						if(!PlayerManager.hasIsland(p)){
							int IslandNumber = StorageManager.playersislandinvite.get(p);
							StorageManager.playersislandinvite.remove(p);
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(StorageManager.islandowner.get(IslandNumber) == player.getUniqueId()){
									player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 denied your §dinvite§7!");
									player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
							}
							p.sendMessage(Start.TAG + "You denied §d" + getPlayerNamefromUUID(StorageManager.islandowner.get(IslandNumber)) + "s invite§7!");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You already have an §dIsland§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 Nobody has §dinvited§7 you yet!");
					}
				}
				else if(a[0].equalsIgnoreCase("leave")){
					if(PlayerManager.hasIsland(p)){
						IslandRank rank = StorageManager.playersislandrank.get(p);
						int IslandNumber = StorageManager.playersislandnumber.get(p);
						List<UUID> members = StorageManager.islandmembers.get(IslandNumber);
						if(rank == IslandRank.OWNER){
							if(members.size() == 0){
								
								ConfigManager.playerdata.set("players." + p.getUniqueId().toString(), null);
								ConfigManager.savePlayerdata();
								
								
								StorageManager.playerhasisland.put(p, false);
								p.teleport(StorageManager.spawn);
								clearInventory(p);
								p.sendMessage(Start.TAG + "You left your §dIsland§7!");
								TitleManager.setTitle(p, "", "§7You left your §dIsland§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							}
							else{
								UUID pluuid = members.get(0);
								
								members.remove(pluuid);
								IslandManager.setIslandMembers(IslandNumber, members);
								IslandManager.setIslandOfflineOwner(IslandNumber, pluuid);
								IslandManager.setOfflinePlayersIslandRank(pluuid, IslandRank.OWNER);
								
								ConfigManager.playerdata.set("players." + p.getName(), null);
								ConfigManager.savePlayerdata();
								StorageManager.playerhasisland.put(p, false);
								clearInventory(p);
								p.teleport(StorageManager.spawn);
								p.sendMessage(Start.TAG + "You left your §dIsland§7!");
								TitleManager.setTitle(p, "", "§7You left your §dIsland§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								
								for(Player player : Bukkit.getOnlinePlayers()){
									if(members.contains(player.getName())){
										player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 left your §dIsland§7!");
										player.sendMessage(Start.TAG + "§d" + getPlayerNamefromUUID(pluuid) + "§7 is now the §downer§7 of your §dIsland§7!");
										player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
									if(player.getUniqueId() == StorageManager.islandowner.get(IslandNumber)){
										player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 left your §dIsland§7!");
										player.sendMessage(Start.TAG + "You are now the §downer§7 of your §dIsland§7!");
										player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
								}
							}
						}
						if(rank == IslandRank.MEMBER){
						
							members.remove(p.getName());
							IslandManager.setIslandMembers(IslandNumber, members);
							
							ConfigManager.playerdata.set("players." + p.getName(), null);
							ConfigManager.savePlayerdata();
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(members.contains(player.getName()) || player.getUniqueId() == StorageManager.islandowner.get(IslandNumber)){
									player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 left your §dIsland§7!");
									player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
							}
							StorageManager.playerhasisland.put(p, false);
							p.teleport(StorageManager.spawn);
							clearInventory(p);
							p.sendMessage(Start.TAG + "You left your §dIsland§7!");
							TitleManager.setTitle(p, "", "§7You left your §dIsland§7!");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						}
						
						for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
							int IslandNumbers = Integer.parseInt(s);
							
							StorageManager.islandlocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
							StorageManager.islandmembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
							StorageManager.islandowner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
							StorageManager.islandcreateddate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
							StorageManager.islandteleportenabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
						}
						for(Player player : Bukkit.getOnlinePlayers()){
							joinEvent.loadPlayerIslandInfo(player);
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("tp") || a[0].equalsIgnoreCase("teleport")){
					if(a.length == 2){
						
						Player p1 = null;
						for(Player player : Bukkit.getOnlinePlayers()){
							if(player.getName().equals(a[1])){
								p1 = player;
							}
						}
						
						if(p1 != null){
							if(PlayerManager.hasIsland(p1)){
								int IslandNumber = StorageManager.playersislandnumber.get(p1);
								if(StorageManager.islandteleportenabled.get(IslandNumber) == true){
									if(!PlayerManager.isInTheVoid(p)){
										teleportToIsland(p, p1);
									}
									else{
										p.sendMessage(Start.TAG + "§4§lDENIED§7 You're in the Void!");
									}
								}
								else{
									p.sendMessage(Start.TAG + "§d" + p1.getName() + "s Island§7 has §c§lDISABLED §3Teleporting§7!");
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 §d" + p1.getName() + "§7 doesn't have an §dIsland§7!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't §aOnline§7!");
						}
					}
					else{
						p.sendMessage(TAG + "Incorrect Use!");
						p.sendMessage(TAG + "Use: §d/is tp|teleport <player>");
					}
				}
				else if(a[0].equalsIgnoreCase("c") || a[0].equalsIgnoreCase("challenge")){
					if(PlayerManager.hasIsland(p)){
						p.openInventory(ChallengesInv.getChallengesInv(p));
						p.playSound(p.getLocation(), Sound.WITHER_IDLE, 5, 1);
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("info")){
					if(PlayerManager.hasIsland(p)){
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						p.openInventory(IslandInfoInv.getIslandInfoInv(p));
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have an §dIsland§7!");
					}
				}
				else{
					
					p.sendMessage(TAG + "Incorrect Use!");
					p.sendMessage(TAG + "Use: §d/is§7 for Help!");
					
				}
				
			}
			else{
				sender.sendMessage(TAG + "§cYou can't perform commands through the Console!");
			}
		}
		return false;
	}
	
	public void teleportToIsland(final Player p1, final Player p2){
		p1.sendMessage(Start.TAG + "§7Teleporting to §d" + p2.getName() + "s §dIsland§7...");
		new BukkitRunnable(){
			public void run(){
				p1.teleport(StorageManager.playersislandhomelocation.get(p2));
				p1.playSound(p1.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
				TitleManager.setTitle(p1, "", "§7Teleported to §d" + p2.getName() + "s Island§7.");
			}
		}.runTaskLater(this, 10);
	}

}
