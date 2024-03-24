package me.O_o_Fadi_o_O.Creative;

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

import me.O_o_Fadi_o_O.Creative.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Creative.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Creative.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Creative.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Creative.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Creative.NMS.PetChicken;
import me.O_o_Fadi_o_O.Creative.NMS.PetCow;
import me.O_o_Fadi_o_O.Creative.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Creative.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Creative.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Creative.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Creative.NMS.PetPig;
import me.O_o_Fadi_o_O.Creative.NMS.PetSheep;
import me.O_o_Fadi_o_O.Creative.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Creative.NMS.PetSlime;
import me.O_o_Fadi_o_O.Creative.NMS.PetSpider;
import me.O_o_Fadi_o_O.Creative.NMS.PetSquid;
import me.O_o_Fadi_o_O.Creative.NMS.PetWolf;
import me.O_o_Fadi_o_O.Creative.PlotInv.PlotEditor;
import me.O_o_Fadi_o_O.Creative.events.BlockChangeEvent;
import me.O_o_Fadi_o_O.Creative.events.BreakEvent;
import me.O_o_Fadi_o_O.Creative.events.ClickEvent;
import me.O_o_Fadi_o_O.Creative.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Creative.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.Creative.events.DropEvent;
import me.O_o_Fadi_o_O.Creative.events.EntityDamage;
import me.O_o_Fadi_o_O.Creative.events.EntityDeath;
import me.O_o_Fadi_o_O.Creative.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Creative.events.ExplodeEvent;
import me.O_o_Fadi_o_O.Creative.events.FoodEvent;
import me.O_o_Fadi_o_O.Creative.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.Creative.events.InteractEvent;
import me.O_o_Fadi_o_O.Creative.events.JoinEvent;
import me.O_o_Fadi_o_O.Creative.events.PlaceEvent;
import me.O_o_Fadi_o_O.Creative.events.PlayerChat;
import me.O_o_Fadi_o_O.Creative.events.PlayerMove;
import me.O_o_Fadi_o_O.Creative.events.ProjectileHit;
import me.O_o_Fadi_o_O.Creative.events.QuitEvent;
import me.O_o_Fadi_o_O.Creative.events.SignEvent;
import me.O_o_Fadi_o_O.Creative.events.VoteEvent;
import me.O_o_Fadi_o_O.Creative.managers.BungeeManager;
import me.O_o_Fadi_o_O.Creative.managers.ComponentMessageManager;
import me.O_o_Fadi_o_O.Creative.managers.ConfigManager;
import me.O_o_Fadi_o_O.Creative.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Creative.managers.NPCManager;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.PlotManager;
import me.O_o_Fadi_o_O.Creative.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;
import me.O_o_Fadi_o_O.Creative.managers.VoteManager;
import me.O_o_Fadi_o_O.Creative.plot.PlotCreator;
import me.O_o_Fadi_o_O.Creative.plot.PvPPlotManager;
import me.O_o_Fadi_o_O.Creative.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Creative.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Creative.utils.ArmorStandType;
import me.O_o_Fadi_o_O.Creative.utils.ChatColor;
import me.O_o_Fadi_o_O.Creative.utils.Disguise;
import me.O_o_Fadi_o_O.Creative.utils.Hat;
import me.O_o_Fadi_o_O.Creative.utils.PlotMode;
import me.O_o_Fadi_o_O.Creative.utils.Server;
import me.O_o_Fadi_o_O.Creative.utils.StaffRank;
import me.O_o_Fadi_o_O.Creative.utils.Trail;
import me.O_o_Fadi_o_O.Creative.utils.TrailType;
import me.O_o_Fadi_o_O.Creative.utils.VIPRank;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Start extends JavaPlugin {
	
	public static String TAG = "§d§lCreative §8| §7";
	
	private DatabaseRunnable databaserunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
	public static Start plugin;
	
	private PlotCreator plotCreator;
	private JoinEvent joinEvent;
	ServerSelector sinv = new ServerSelector();
	
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
		plotCreator = new PlotCreator();
		joinEvent = new JoinEvent();
		
		setupPermissions();
		
		StorageManager.thisserver = Server.CREATIVE;
		StorageManager.spawn = new Location(StorageManager.lobbyworld, 0, 74, 0, 45, 0);
		
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
		*/
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
			StorageManager.loaded.put(p, false);
		}
		
		registerAllEvents();
		startAllRunnables();
		
		try{
			removeAllEntities();
			npcmanager.spawnServerSelector(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 7.5, 74, -7.5, 45, 0), "§3§lServer Selector");
			npcmanager.spawnOMTShop(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, 4.5, 74, -9.5, 0, 0), "§e§lOMT Shop");

			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -6.5, 75, 6.5, -50, 0), 
					"§d§lCreative",
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					null,
					ArmorStandType.NORMAL,
					0);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -6.75, 75.5, 6.25, -50, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-1.1).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.WOOD_AXE, 1),
					ArmorStandType.NORMAL,
					0);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -6.75, 75.5, 7.25, 140, 0), 
					null,
					false, 
					true, 
					true, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false, 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(-1.1).setY(0).setZ(0), 
					EulerAngle.ZERO.setX(0).setY(0).setZ(0), 
					false,
					null,
					null,
					null,
					null,
					new ItemStack(Material.WOOD_AXE, 1),
					ArmorStandType.NORMAL,
					0);
			npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, 9.5, 74, -4.5, 90, 0), 
					"§d§lPlot Editor",
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
					PlayerManager.addColorToLeather(Material.LEATHER_HELMET, Color.FUCHSIA),
					PlayerManager.addColorToLeather(Material.LEATHER_CHESTPLATE, Color.FUCHSIA),
					PlayerManager.addColorToLeather(Material.LEATHER_LEGGINGS, Color.FUCHSIA),
					PlayerManager.addColorToLeather(Material.LEATHER_BOOTS, Color.FUCHSIA),
					new ItemStack(Material.WOOD_AXE, 1),
					ArmorStandType.PLOT_EDITOR,
					0);
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
		
		new BukkitRunnable(){
			public void run(){
				StorageManager.plotsamount = getConfig().getInt("Plots");
				
				if(ConfigManager.plots.contains("plots")){
					for(String s : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
						int PlotNumber = Integer.parseInt(s);
						
						StorageManager.plotmode.put(PlotNumber, PlotManager.getPlotMode(PlotNumber));
						StorageManager.plotcolor.put(PlotNumber, PlotManager.getPlotColor(PlotNumber));
						StorageManager.plotlocation.put(PlotNumber, PlotManager.getPlotLocation(PlotNumber));
						try{StorageManager.plotmembers.put(PlotNumber, PlotManager.getPlotMembers(PlotNumber));}catch(IllegalArgumentException ex){}
						try{StorageManager.plotowner.put(PlotNumber, PlotManager.getPlotOwner(PlotNumber));}catch(IllegalArgumentException ex){}
						StorageManager.plotcreateddate.put(PlotNumber, PlotManager.getPlotCreatedDate(PlotNumber));
						
						PvPPlotManager.loadPvPPlot(PlotNumber);
					}
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					joinEvent.loadPlayerPlotInfo(p);
				}			
			}
		}.runTaskTimer(this, 0, 50);
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
		PvPPlotManager.removeALLNPCs();
		
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
		getServer().getPluginManager().registerEvents(new BlockChangeEvent(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		//getServer().getPluginManager().registerEvents(new ClickEvent2(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new SignEvent(), this);
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

    public static List<Block> getBlocksBetween(Location l1, Location l2){
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
	
	public void setPlotAmount(int PlotAmount){
		StorageManager.plotsamount = PlotAmount;
		getConfig().set("Plots", PlotAmount);
		saveConfig();
	}
	
	public static List<String> getHelpMessage(){
		
		List<String> list = new ArrayList<String>();
		list.add(TAG + "§lHelp Menu:");
		list.add(TAG + "§d/plot home | h §7§o(Teleport to your Plot)");
		list.add(TAG + "§d/plot sethome §7§o(Set your Plot Home)");
		list.add(TAG + "§d/plot help §7§o(Show this Menu)");
		list.add(TAG + "§d/plot add <player> §7§o(Add a Player)");
		list.add(TAG + "§d/plot remove <player> §7§o(Remove a Player)");
		list.add(TAG + "§d/plot tp | teleport <player> §7§o(Teleport to a Plot)");
		list.add(TAG + "§d/plot clear §7§o(Clear your Plot)");
		list.add(TAG + "§d/plot info §7§o(Show Plot Info)");
		list.add(TAG + "§d/plot edit §7§o(Open the Plot Editor)");
		list.add(TAG + "§d/plot setuppvp §7§o(Setup PvP Mode)");
		list.add(TAG + "§d/plot pvpbroadcast §7§o(Broadcast Plot in PvP Mode)");
		
		return list;
	}
	
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}
	
	
	private Map<String, Long> lastBroadcast = new HashMap<String, Long>();
	private final int broadcastcooldown = 300;
	
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
				sender.sendMessage("§a§lSurvival §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
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
				sender.sendMessage("§a§lSurvival §8| §4§lDENIED§7! You have to be an §4§lOwner§7 to do this!");
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
		if(cmd.getName().equalsIgnoreCase("p") || cmd.getName().equalsIgnoreCase("plot")){
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
				else if(a[0].equalsIgnoreCase("home") || a[0].equalsIgnoreCase("h") || a[0].equalsIgnoreCase("start")){
					
					if(PlayerManager.hasPlot(p)){
						p.sendMessage(Start.TAG + "§7Teleporting to your §dPlot§7...");
						new BukkitRunnable(){
							public void run(){
								p.teleport(StorageManager.playersplothomelocation.get(p));
								p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
								TitleManager.setTitle(p, "", "§7Teleported to your §dPlot§7.");
							}
						}.runTaskLater(this, 10);
					}
					else{
						if(ConfigManager.plots.contains("plots")){
							for(String s : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
								int PlotNumber = Integer.parseInt(s);
								
								StorageManager.plotmode.put(PlotNumber, PlotManager.getPlotMode(PlotNumber));
								StorageManager.plotcolor.put(PlotNumber, PlotManager.getPlotColor(PlotNumber));
								StorageManager.plotlocation.put(PlotNumber, PlotManager.getPlotLocation(PlotNumber));
								try{StorageManager.plotmembers.put(PlotNumber, PlotManager.getPlotMembers(PlotNumber));}catch(IllegalArgumentException ex){}
								try{StorageManager.plotowner.put(PlotNumber, PlotManager.getPlotOwner(PlotNumber));}catch(IllegalArgumentException ex){}
								StorageManager.plotcreateddate.put(PlotNumber, PlotManager.getPlotCreatedDate(PlotNumber));
							}
						}
						plotCreator.createPlot(StorageManager.plotsamount +1, p);
						for(Player player : Bukkit.getOnlinePlayers()){
							joinEvent.loadPlayerPlotInfo(player);
						}
					}
					
				}
				else if(a[0].equalsIgnoreCase("sethome") || a[0].equalsIgnoreCase("h")){
					if(PlayerManager.hasPlot(p)){
						if(PlayerManager.isOnOwnPlot(p, p.getLocation())){
							if(p.getWorld().getName().equals(StorageManager.creativeworld.getName())){
								PlotManager.setPlayersPlotHomeLocation(p, p.getLocation());
								p.sendMessage(Start.TAG + "§dPlot Home§7 set!");
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 You can't set your §dPlot Home§7 here!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You're not on your own §dPlot§7!");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
					}
				}		
				else if(a[0].equalsIgnoreCase("pvpbroadcast")){
					if(PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
						if(PlayerManager.hasPlot(p)){
							int PlotNumber = StorageManager.playersplotnumber.get(p);
							
							if(StorageManager.plotmode.get(PlotNumber) == PlotMode.PVP){
								
								long lastBroadcast = 0;
								if(this.lastBroadcast.containsKey(p.getName())){
									lastBroadcast = this.lastBroadcast.get(p.getName());
								}
								int cdmillis2 = broadcastcooldown * 1000;
										
								if(System.currentTimeMillis()-lastBroadcast>=cdmillis2){

									for(Player player : Bukkit.getOnlinePlayers()){
										player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
										player.sendMessage("");
										ComponentMessageManager.sendComponentMessage(player, "§d" + p.getName() + "s Plot§7 is in §c§lPvP Mode§7! ", "§a§lClick Here to Join", "show_text", "run_command", "§aClick to Join", "/p join " + PlotNumber);
									}

									this.lastBroadcast.put(p.getName(), System.currentTimeMillis());
								}
								else{
									p.sendMessage(Start.TAG + "You can only use the §dPlot Broadcast§7 once every §d5 minutes§7.");
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 Your §dPlot§7 has to be in §c§lPvP Mode§7!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
						}
					}
					else{
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("join")){
					if(!StorageManager.playerspvpplot.containsKey(p)){
						if(a.length == 2){
							try{
								int PlotNumber = Integer.parseInt(a[1]);
								
								if(StorageManager.plotmode.containsKey(PlotNumber)){
									if(StorageManager.plotmode.get(PlotNumber) == PlotMode.PVP){
										int maxplayers = StorageManager.plotpvpmaxplayers.get(PlotNumber);
										List<Player> pvpplayers = StorageManager.plotpvpplayers.get(PlotNumber);
										
										if(pvpplayers.size() < maxplayers){
											pvpplayers.add(p);
											StorageManager.plotpvpplayers.put(PlotNumber, pvpplayers);
											StorageManager.playerspvpplot.put(p, PlotNumber);
											
											p.sendMessage(Start.TAG + "§7Joining Plot §d#" + PlotNumber + "§7...");
											p.teleport(StorageManager.plotlocation.get(PlotNumber));
											p.setGameMode(GameMode.SURVIVAL);
											TitleManager.setTitle(p, "", "§7Joined Plot §d#" + PlotNumber + "§7!");
											
											for(Player player : pvpplayers){
												player.playSound(player.getLocation(), Sound.CLICK, 5, 1);
												player.sendMessage("§d" + p.getName() + "§7 joined §dPlot #" + PlotNumber + "§7. (§d" + pvpplayers.size() + "§7/§d" + maxplayers + "§7)");
											}
											
											if(StorageManager.disguise.containsKey(p)){
												DisguisePlayer.undisguisePlayer(p);
											}
										}
										else{
											p.sendMessage(Start.TAG + "That Plot is full! (§d" + pvpplayers.size() + "§7/§d" + maxplayers + "§7)");
										}
									}
									else{
										p.sendMessage(Start.TAG + "That Plot is in §d§lBuild Mode§7!");
									}
								}
								else{
									p.sendMessage(Start.TAG + "That Plot Number doesn't exist!");
								}
							}catch(Exception ex){
								ex.printStackTrace();
								p.sendMessage(Start.TAG + "§d" + a[1] + "§7 isn't a number!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§7Incorrect Use!");
							p.sendMessage(Start.TAG + "§7Use §d/p join <plot>§7.");
						}
					}
					else{
						p.sendMessage(Start.TAG + "You are on a §c§lPvP Plot§7 leave with §d/p leave§7.");
					}
				}
				else if(a[0].equalsIgnoreCase("edit")){
					p.openInventory(PlotEditor.getPlotEditor(p));
				}
				else if(a[0].equalsIgnoreCase("clear")){
					if(PlayerManager.hasPlot(p)){
						plotCreator.resetPlot(p);
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("test")){
					p.chat("/p setuppvp");
					p.chat("/p setuppvp setlobby");
					p.chat("/p setuppvp setnpc Archer");
					p.chat("/p setuppvp setspawn");
					p.chat("/p setuppvp drops true");
					p.chat("/p setuppvp arrows true");
					p.chat("/p setuppvp build false");
					p.chat("/p setuppvp setmaxplayers 10");
				}
				else if(a[0].equalsIgnoreCase("setuppvp")){
					if(PlayerManager.hasVIPPerms(p, VIPRank.Emerald_VIP)){
						if(PlayerManager.hasPlot(p)){
							if(!StorageManager.playersinpvpsetup.contains(p)){
								int PlotNumber = StorageManager.playersplotnumber.get(p);
								
								if(StorageManager.plotmode.get(PlotNumber) == PlotMode.NORMAL){
									StorageManager.playersinpvpsetup.add(p);
									
									PvPPlotManager.resetPvPInfo(PlotNumber);
									
									PvPPlotManager.setFinishedSetup(p, false);
									
									StorageManager.plotpvpnpclocations.put(PlotNumber, new ArrayList<Location>());
									
									StorageManager.plotpvplocations.put(PlotNumber, new ArrayList<Location>());
									
									StorageManager.plotpvpkitnames.put(PlotNumber, new ArrayList<String>());
									
									StorageManager.plotpvpkits.put(PlotNumber, new ArrayList<ItemStack[]>());
									
									StorageManager.plotpvpnpcs.put(PlotNumber, new ArrayList<Entity>());
									
									StorageManager.plotpvpplayersselectedkit.put(PlotNumber, new ArrayList<Player>());
									StorageManager.plotpvpplayers.put(PlotNumber, new ArrayList<Player>());
									
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									p.sendMessage("");
									p.sendMessage("§7Entered §d§lSetup Mode§7!");
									p.sendMessage("");
									p.sendMessage("§dStep 1:");
									ComponentMessageManager.sendComponentMessage(p, "§7Set the lobby. ", "§7[§d§li§7]", "show_text", "", "§7- Spawnpoint where players will go when they join or die.\n- §7They'll be able to select a kit in that area too!", "");
									p.sendMessage("§7Use §d/p setuppvp setlobby§7.");	
								}
								else{
									p.sendMessage("§7You have to set your §7§Plot Mode§7 to Normal if you want to progress this setup.");	
								}
							}
							else{
								if(a.length >= 2){
									if(a[1].equalsIgnoreCase("setlobby")){
										
										PvPPlotManager.setLobbyLocation(p);
										
										p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										
										p.sendMessage("");
										p.sendMessage("§7Successfully set the §d§lLobby§7!");
										p.sendMessage("");
										p.sendMessage("§dStep 2:");
										ComponentMessageManager.sendComponentMessage(p, "§7Set the NPC spawns. ", "§7[§d§li§7]", "show_text", "", "§7- This is an ArmorStand which can be Right-Clicked to select a kit.", "");
										p.sendMessage("§7Use §d/p setuppvp setnpc <kitname>§7.");	
									}
									else if(a[1].equalsIgnoreCase("setnpc")){
										if(a.length == 3){
											if(a[2].length() <= 15){
												int PlotNumber = StorageManager.playersplotnumber.get(p);
												
												if(StorageManager.plotpvpnpclocations.get(PlotNumber).size() <= 3){
													PvPPlotManager.setNPCLocation(p, a[2]);
													
													p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													p.sendMessage("");
													p.sendMessage("§7Successfully set a §d§lNPC Spawn§7! (Kit: §d" + a[2] + "§7)");
													p.sendMessage("");
													p.sendMessage("§7§oYou can have a maximum of 4 NPCs. (Current Amount: " + StorageManager.plotpvpnpclocations.get(PlotNumber).size() + ")");
													p.sendMessage("");
													p.sendMessage("§dStep 3:");
													ComponentMessageManager.sendComponentMessage(p, "§7Set the In Game spawns. ", "§7[§d§li§7]", "show_text", "", "§7- Spawnpoints where players will go when they select a kit.", "");
													p.sendMessage("§7Use §d/p setuppvp setspawn§7.");
													
												}
												else{
													p.sendMessage("§7You reached the maximum amount of §dNPC Spawns§7!");
												}
											}
											else{
												p.sendMessage("§7The §dKit Name§7 cannot be longer than §d15 characters§7!");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp setnpc <kitname>§7.");	
										}
									}
									else if(a[1].equalsIgnoreCase("setspawn")){
										if(a.length == 2){
											int PlotNumber = StorageManager.playersplotnumber.get(p);
												
											if(StorageManager.plotpvplocations.get(PlotNumber).size() <= 9){
												PvPPlotManager.setSpawnLocation(p, StorageManager.plotpvplocations.get(PlotNumber).size() +1);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												p.sendMessage("");
												p.sendMessage("§7Successfully set an §d§lIn Game Spawn§7! (§d" + StorageManager.plotpvplocations.get(PlotNumber).size() + "§7)");
												p.sendMessage("");
												p.sendMessage("§7§oYou can have a maximum of 10 In Game spawns. (Current Amount: " + StorageManager.plotpvplocations.get(PlotNumber).size() + ")");
												p.sendMessage("");
												p.sendMessage("§dStep 4:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Loot Drops. ", "§7[§d§li§7]", "show_text", "", "§7- When enabled, all items in a players Inventory will drop when they die.", "");
												p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
												
											}
											else{
												p.sendMessage("§7You reached the maximum amount of §dIn Game Spawns§7!");
											}
										}
									}
									else if(a[1].equalsIgnoreCase("drops")){
										if(a.length == 3){
											try{
												boolean enabledrops = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledDrops(p, enabledrops);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												p.sendMessage("");
												if(enabledrops == true){
													p.sendMessage("§7Successfully §aenabled §d§lLoot Drops§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lLoot Drops§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 5:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Arrow Entities. ", "§7[§d§li§7]", "show_text", "", "§7- When disabled, an arrow that missed their target will be removed from the ground.", "");
												p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp drops true§7 or §d/p setuppvp drops false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("arrows")){
										if(a.length == 3){
											try{
												boolean enablearrows = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledArrows(p, enablearrows);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

												p.sendMessage("");
												if(enablearrows == true){
													p.sendMessage("§7Successfully §aenabled §d§lArrow Entities§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lArrow Entities§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 6:");
												ComponentMessageManager.sendComponentMessage(p, "§cDisable§7 or §aEnable §7Build Mode. ", "§7[§d§li§7]", "show_text", "", "§7- When enabled, all players will be able to build.", "");
												p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp arrows true§7 or §d/p setuppvp arrows false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("build")){
										if(a.length == 3){
											try{
												boolean enablebuild = Boolean.parseBoolean(a[2]);
												
												PvPPlotManager.setEnabledBuild(p, enablebuild);
												
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);

												p.sendMessage("");
												if(enablebuild == true){
													p.sendMessage("§7Successfully §aenabled §d§lBuild Mode§7!");
												}
												else{
													p.sendMessage("§7Successfully §cdisabled §d§lBuild Mode§7!");
												}
												p.sendMessage("");
												p.sendMessage("§dStep 7:");
												ComponentMessageManager.sendComponentMessage(p, "§7Set the maximum amount of players allowed. ", "§7[§d§li§7]", "show_text", "", "§7- Has to be between 4 and 50.", "");
												p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
												
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp build true§7 or §d/p setuppvp build false§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("setmaxplayers")){
										if(a.length == 3){
											try{
												int amount = Integer.parseInt(a[2]);
												
												if(amount >= 4 && amount <= 50){
													
													PvPPlotManager.setMaxPlayers(p, amount);
													
													int PlotNumber = StorageManager.playersplotnumber.get(p);
													
													PvPPlotManager.removeNPCs(PlotNumber);
													PvPPlotManager.spawnNPCs(PlotNumber);
													
													PvPPlotManager.createKitInventories(p);
													
													p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													
													p.sendMessage("");
													p.sendMessage("§7Successfully set the §d§lMax. Players§7! (§d" + amount + "§7)");
													p.sendMessage("");
													p.sendMessage("§dStep 8:");
													ComponentMessageManager.sendComponentMessage(p, "§7Click on the ArmorStands that just appeared. ", "§7[§d§li§7]", "show_text", "", "§7- Add items to these inventories to design your kits.", "");
													p.sendMessage("§7Done?");
													p.sendMessage("§7Use §d/p setuppvp finish§7.");
													
												}
												else{
													p.sendMessage("§7Only numbers between §d4§7 and §d50§7 are allowed.");
												}
											}catch(Exception ex){
												p.sendMessage("§7Incorrect Use!");
												p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
											}
										}
										else{
											p.sendMessage("§7Incorrect Use!");
											p.sendMessage("§7Use §d/p setuppvp setmaxplayers <amount>§7.");
										}
									}
									else if(a[1].equalsIgnoreCase("finish")){
										int PlotNumber = StorageManager.playersplotnumber.get(p);
										
										if(StorageManager.plotpvpspawnlocation.containsKey(PlotNumber)
										&& StorageManager.plotpvpnpclocations.get(PlotNumber).size() > 0
										&& StorageManager.plotpvplocations.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpdrops.containsKey(PlotNumber)
										&& StorageManager.plotpvparrows.containsKey(PlotNumber)
										&& StorageManager.plotpvpbuild.containsKey(PlotNumber)
										&& StorageManager.plotpvpkitnames.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpkits.get(PlotNumber).size() > 0
										&& StorageManager.plotpvpmaxplayers.containsKey(PlotNumber)
										&& StorageManager.plotpvpnpcs.get(PlotNumber).size() > 0){
											
											PvPPlotManager.setFinishedSetup(p, true);
											StorageManager.playersinpvpsetup.remove(p);
											p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
											
											p.sendMessage("");
											p.sendMessage("§7Successfully finished the §d§lSetup§7!");
											p.sendMessage("");
											p.sendMessage("§7Switch your plot to §c§lPvP Mode§7 using §d/p edit§7.");
											
										}
										else{
											p.sendMessage("§7You didn't do the setup right!");
										}
									}
									else{
										p.sendMessage("§7Incorrect Use!");
										p.sendMessage("§7Follow the steps carefully.");
									}
								}
								else{
									p.sendMessage("§7Incorrect Use!");
									p.sendMessage("§7Follow the steps carefully.");
								}
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
						}
					}
					else{
						p.playSound(p.getLocation(), Sound.LAVA_POP, 5, 1);
						p.sendMessage("§9Cosmetic Perks §8| §4§lDENIED §7Required: §a§lEmerald VIP§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("info")){
					if(PlayerManager.hasPlot(p)){
						int PlotNumber = StorageManager.playersplotnumber.get(p);
						String date = StorageManager.plotcreateddate.get(PlotNumber);
						String owner = StorageManager.plotowner.get(PlotNumber);
						List<String> members = StorageManager.plotmembers.get(PlotNumber);
						
						p.sendMessage(Start.TAG + "§7Plot Info: §d#" + PlotNumber);
						p.sendMessage(Start.TAG + "§7Created: §d" + date + "§7.");
						p.sendMessage(Start.TAG + "§7Owner: §d" + owner + "§7.");
						p.sendMessage(Start.TAG + "§7Members(" + members.size() + "):");
						for(String s : members){
							p.sendMessage(Start.TAG + " §d" + s + "§7.");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
					}
				}
				else if(a[0].equalsIgnoreCase("add")){
					if(PlayerManager.hasPlot(p)){
						if(a.length == 2){
						
							Player p1 = null;
							for(Player player : Bukkit.getOnlinePlayers()){
								if(player.getName().equals(a[1])){
									p1 = player;
								}
							}
							
							if(p1 != null){
								if(p1 != p){
									int PlotNumber =  StorageManager.playersplotnumber.get(p);
									List<String> members = StorageManager.plotmembers.get(PlotNumber);
	
									if(!members.contains(p1.getName())){
	
										p.sendMessage(Start.TAG + "§d" + p1.getName() + "§7 can now access your plot!");
										p1.sendMessage(Start.TAG + "You can now access §d" + StorageManager.plotowner.get(PlotNumber) + "s Plot§7!");
										p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										
										PlotManager.addPlotMember(PlotNumber, p1);
										
										for(String s : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
											int PlotNumbers = Integer.parseInt(s);
											
											StorageManager.plotmode.put(PlotNumbers, PlotManager.getPlotMode(PlotNumbers));
											StorageManager.plotcolor.put(PlotNumbers, PlotManager.getPlotColor(PlotNumbers));
											StorageManager.plotlocation.put(PlotNumbers, PlotManager.getPlotLocation(PlotNumbers));
											try{StorageManager.plotmembers.put(PlotNumbers, PlotManager.getPlotMembers(PlotNumbers));}catch(IllegalArgumentException ex){}
											try{StorageManager.plotowner.put(PlotNumbers, PlotManager.getPlotOwner(PlotNumbers));}catch(IllegalArgumentException ex){}
											StorageManager.plotcreateddate.put(PlotNumbers, PlotManager.getPlotCreatedDate(PlotNumbers));
										}
										for(Player player : Bukkit.getOnlinePlayers()){
											joinEvent.loadPlayerPlotInfo(player);
										}
									}
									else{
										p.sendMessage(Start.TAG + "Player §d" + a[1] +" §7is already added to your §dPlot§7!");
									}
								}
								else{
									p.sendMessage(Start.TAG + "§4§lERROR§7 You can't add yourself to your own plot!");
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't §aOnline§7!");
							}
						}
						else{
							p.sendMessage(TAG + "Incorrect Use!");
							p.sendMessage(TAG + "Use: §d/plot add <player>");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
					}
					
				}
				else if(a[0].equalsIgnoreCase("remove")){
					if(PlayerManager.hasPlot(p)){
						if(a.length == 2){
							int PlotNumber = StorageManager.playersplotnumber.get(p);
							
							if(!a[1].equals(p.getName())){
								if(StorageManager.plotmembers.get(PlotNumber).contains(a[1])){
									
									List<String> members = StorageManager.plotmembers.get(PlotNumber);
									members.remove(a[1]);
									PlotManager.setPlotMembers(PlotNumber, members);
									
									StorageManager.playersplotmemberson.get(a[1]).remove("" + PlotNumber);
									
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equals(a[1])){
											player.sendMessage(Start.TAG + "You can no longer access §d" + StorageManager.plotowner.get(PlotNumber) + "s Plot§7!");
											player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
										}
									}
									
									p.sendMessage(Start.TAG + "§d" + a[1] + "§7 can no longer access your §dPlot§7!");
									p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									
									for(String s : ConfigManager.plots.getConfigurationSection("plots").getKeys(false)){
										int PlotNumbers = Integer.parseInt(s);
										
										StorageManager.plotmode.put(PlotNumbers, PlotManager.getPlotMode(PlotNumbers));
										StorageManager.plotcolor.put(PlotNumbers, PlotManager.getPlotColor(PlotNumbers));
										StorageManager.plotlocation.put(PlotNumbers, PlotManager.getPlotLocation(PlotNumbers));
										try{StorageManager.plotmembers.put(PlotNumbers, PlotManager.getPlotMembers(PlotNumbers));}catch(IllegalArgumentException ex){}
										try{StorageManager.plotowner.put(PlotNumbers, PlotManager.getPlotOwner(PlotNumbers));}catch(IllegalArgumentException ex){}
										StorageManager.plotcreateddate.put(PlotNumbers, PlotManager.getPlotCreatedDate(PlotNumbers));
									}
									for(Player player : Bukkit.getOnlinePlayers()){
										joinEvent.loadPlayerPlotInfo(player);
									}
									
								}
								else{
									p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't on your §dPlot§7!");
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lERROR§7 You can't remove yourself from your §dPlot§7!");
							}
						}
						else{
							p.sendMessage(TAG + "Incorrect Use!");
							p.sendMessage(TAG + "Use: §d/plot remove <player>");
						}
					}
					else{
						p.sendMessage(Start.TAG + "§4§lDENIED§7 You don't have a §dPlot§7!");
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
							if(PlayerManager.hasPlot(p1)){
								teleportToPlot(p, p1);
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 §d" + p1.getName() + "§7 doesn't have a §dPlot§7!");
							}
						}
						else{
							p.sendMessage(Start.TAG + "§4§lERROR§7 Player §d" + a[1] +" §7isn't §aOnline§7!");
						}
					}
					else{
						p.sendMessage(TAG + "Incorrect Use!");
						p.sendMessage(TAG + "Use: §d/plot tp|teleport <player>");
					}
				}
				else{
					for(String s : getHelpMessage()){
						p.sendMessage(s);
					}
				}
			}
			else{
				sender.sendMessage(TAG + "§cYou can't perform commands through the Console!");
			}
		}
		return false;
	}
	
	public void teleportToPlot(final Player p1, final Player p2){
		p1.sendMessage(Start.TAG + "§7Teleporting to §d" + p2.getName() + "s §dPlot§7...");
		new BukkitRunnable(){
			public void run(){
				p1.teleport(StorageManager.playersplothomelocation.get(p2));
				p1.playSound(p1.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
				TitleManager.setTitle(p1, "", "§7Teleported to §d" + p2.getName() + "s Plot§7.");
			}
		}.runTaskLater(this, 10);
	}

    private boolean setupPermissions(){
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
}
