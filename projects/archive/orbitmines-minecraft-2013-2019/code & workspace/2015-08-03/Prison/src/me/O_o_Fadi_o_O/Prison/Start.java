package me.O_o_Fadi_o_O.Prison;

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

import me.O_o_Fadi_o_O.Prison.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Prison.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Prison.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Prison.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Prison.NMS.CustomZombie;
import me.O_o_Fadi_o_O.Prison.NMS.PetChicken;
import me.O_o_Fadi_o_O.Prison.NMS.PetCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.Prison.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.Prison.NMS.PetOcelot;
import me.O_o_Fadi_o_O.Prison.NMS.PetPig;
import me.O_o_Fadi_o_O.Prison.NMS.PetSheep;
import me.O_o_Fadi_o_O.Prison.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.Prison.NMS.PetSlime;
import me.O_o_Fadi_o_O.Prison.NMS.PetSpider;
import me.O_o_Fadi_o_O.Prison.NMS.PetSquid;
import me.O_o_Fadi_o_O.Prison.NMS.PetWolf;
import me.O_o_Fadi_o_O.Prison.events.BreakEvent;
import me.O_o_Fadi_o_O.Prison.events.ChunkUnload;
import me.O_o_Fadi_o_O.Prison.events.ClickEvent;
import me.O_o_Fadi_o_O.Prison.events.ClickEvent2;
import me.O_o_Fadi_o_O.Prison.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Prison.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.Prison.events.EntityDamage;
import me.O_o_Fadi_o_O.Prison.events.EntityDeath;
import me.O_o_Fadi_o_O.Prison.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Prison.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.Prison.events.InteractEvent;
import me.O_o_Fadi_o_O.Prison.events.JoinEvent;
import me.O_o_Fadi_o_O.Prison.events.PlaceEvent;
import me.O_o_Fadi_o_O.Prison.events.PlayerChat;
import me.O_o_Fadi_o_O.Prison.events.PlayerMove;
import me.O_o_Fadi_o_O.Prison.events.QuitEvent;
import me.O_o_Fadi_o_O.Prison.events.SignsEvent;
import me.O_o_Fadi_o_O.Prison.events.VoteEvent;
import me.O_o_Fadi_o_O.Prison.managers.BungeeManager;
import me.O_o_Fadi_o_O.Prison.managers.ConfigManager;
import me.O_o_Fadi_o_O.Prison.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Prison.managers.EmptyWorldGenerator;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.VoteManager;
import me.O_o_Fadi_o_O.Prison.runnables.ChestRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.GambleRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.MineRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.PetRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.RankLettersRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.SignRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.WoodmenRunnable;
import me.O_o_Fadi_o_O.Prison.utils.ChatColor;
import me.O_o_Fadi_o_O.Prison.utils.Disguise;
import me.O_o_Fadi_o_O.Prison.utils.Server;
import me.O_o_Fadi_o_O.Prison.utils.StaffRank;
import me.O_o_Fadi_o_O.Prison.utils.Trail;
import me.O_o_Fadi_o_O.Prison.utils.TrailType;
import me.O_o_Fadi_o_O.Prison.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin {
	
	public static String TAG = "§4§lPrison §8| §7";
	
	private ChestRunnable chestrunnable;
	private DatabaseRunnable databaserunnable;
	private GambleRunnable gamblerunnable;
	private MineRunnable minerunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private RankLettersRunnable ranklettersrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	private SignRunnable signrunnable;
	private WoodmenRunnable woodmenrunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
	public static Start plugin;
	
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
		addCustomEntity(CustomZombie.class, "CustomZombie", 54);
		
		plugin = this;
		chestrunnable = new ChestRunnable();
		databaserunnable = new DatabaseRunnable();
		gamblerunnable = new GambleRunnable();
		minerunnable = new MineRunnable();
		petrunnable = new PetRunnable();
		playerrunnable = new PlayerRunnable();
		ranklettersrunnable = new RankLettersRunnable();
		scoreboardrunnable = new ScoreboardRunnable();
	    serverselectorrunnable = new ServerSelectorRunnable();
		signrunnable = new SignRunnable();
		woodmenrunnable = new WoodmenRunnable();
	    
		scoreboardtitlemanager = new ScoreboardTitleManager();
		
		npcmanager = new NPCManager();
		pmanager = new PlayerManager();
		
		StorageManager.thisserver = Server.PRISON;
		StorageManager.spawn = new Location(StorageManager.prisonworld, -1207.5, 8, -596, 180, 0);
		
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
		
		removeAllEntities();
		
		Prison.getAllMineLocations(StorageManager.prisonworld);
		
		Prison.registerAllRankLocations(StorageManager.prisonworld);
		Prison.registerAllMineCountdownLocation(StorageManager.prisonworld);
		Prison.registerAllMineCountdowns(StorageManager.prisonworld);
		Prison.registerAllWoodmenBlocks(StorageManager.prisonworld);
		Prison.registerAllWoodmenLocations(StorageManager.prisonworld);
		Prison.registerAllRankBlocks(StorageManager.prisonworld);
		Prison.registerAllSignBlocks(StorageManager.prisonworld);
		npcmanager.spawnAllSkeletons(StorageManager.prisonworld);
		npcmanager.spawnAllWoodmen(StorageManager.prisonworld);
		npcmanager.spawnAllVillagers(StorageManager.prisonworld);
		
		registerAllEvents();
		startAllRunnables();
		
		try{
			npcmanager.spawnServerSelector(StorageManager.prisonworld, new Location(StorageManager.prisonworld, 3.5, 76, 5.5, 0, 0), "§3§lServer Selector");
			//npcmanager.spawnOMTShop(StorageManager.prisonworld, new Location(StorageManager.prisonworld, -2.5, 75, -5.5, 0, 0), "§e§lOMT Shop");
		}catch(NullPointerException ex){
			new BukkitRunnable(){
				public void run(){
					getServer().dispatchCommand(getServer().getConsoleSender(), "reload");
				}
			}.runTaskLater(this, 20);
		}
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.playersgambling.containsKey(p)){
						int Seconds = StorageManager.playergamblingseconds.get(p);
						StorageManager.playergamblingseconds.put(p, Seconds +1);
					}
				}
			}
		}.runTaskTimer(this, 0, 20);
		
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
	}
	public void teleportToSpawn(final Player p){
		new BukkitRunnable(){
			public void run(){
				p.teleport(new Location(StorageManager.spawn.getWorld(), StorageManager.spawn.getX(), StorageManager.spawn.getY() +4, StorageManager.spawn.getZ(), -90, 0));
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
		getServer().getPluginManager().registerEvents(new ChunkUnload(), this);
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
		getServer().getPluginManager().registerEvents(new SignsEvent(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
	}
	
	private void startAllRunnables(){
		chestrunnable.startChestRunnable();
		databaserunnable.startDatabaseRunnable();
		gamblerunnable.startGambleRunnable();
		minerunnable.startMineRunnable();
		petrunnable.startPetRunnable();
		playerrunnable.startPlayerRunnable();
		ranklettersrunnable.startRankLetterRunnable();
		scoreboardrunnable.startScoreboardRunnable();
		serverselectorrunnable.startServerSelectorRunnable();
		scoreboardtitlemanager.startScoreboardTitleRunnable();
		signrunnable.startSignRunnable();
		woodmenrunnable.startWoodmenRunnable();
	}
	
	private void removeAllEntities(){
		for(Entity en : StorageManager.prisonworld.getEntities()){
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
		if(cmd.getName().equalsIgnoreCase("gold")){}
		if(cmd.getName().equalsIgnoreCase("money")){}
		if(cmd.getName().equalsIgnoreCase("gtickets")){}
		if(cmd.getName().equalsIgnoreCase("gambletickets")){}
		if(cmd.getName().equalsIgnoreCase("rarechest")){}
		if(cmd.getName().equalsIgnoreCase("pay")){}
		
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
		return false;
	}
}
