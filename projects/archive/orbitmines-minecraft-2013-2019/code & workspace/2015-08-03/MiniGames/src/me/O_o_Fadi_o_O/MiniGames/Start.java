package me.O_o_Fadi_o_O.MiniGames;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomChicken;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomIronGolem;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetChicken;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetCreeper;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetOcelot;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetPig;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSheep;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSlime;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSpider;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSquid;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetWolf;
import me.O_o_Fadi_o_O.MiniGames.events.AnimationEvent;
import me.O_o_Fadi_o_O.MiniGames.events.BlockChangeEvent;
import me.O_o_Fadi_o_O.MiniGames.events.BlockFormEvent;
import me.O_o_Fadi_o_O.MiniGames.events.BreakEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ClickEvent;
import me.O_o_Fadi_o_O.MiniGames.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DamageByEntity;
import me.O_o_Fadi_o_O.MiniGames.events.DamageEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DeathEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DespawnEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DropEvent;
import me.O_o_Fadi_o_O.MiniGames.events.EntityDeath;
import me.O_o_Fadi_o_O.MiniGames.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ExplodeEvent;
import me.O_o_Fadi_o_O.MiniGames.events.InteractAtEntityEvent;
import me.O_o_Fadi_o_O.MiniGames.events.JoinEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PickUpEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlaceEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerChat;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerInteract;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerMove;
import me.O_o_Fadi_o_O.MiniGames.events.ProjectileHit;
import me.O_o_Fadi_o_O.MiniGames.events.QuitEvent;
import me.O_o_Fadi_o_O.MiniGames.events.SignEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ToggleFlightEvent;
import me.O_o_Fadi_o_O.MiniGames.events.VoteEvent;
import me.O_o_Fadi_o_O.MiniGames.managers.BungeeManager;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.ConfigManager;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.NPCManager;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.ScoreboardTitleManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.managers.TitleManager;
import me.O_o_Fadi_o_O.MiniGames.managers.VoteManager;
import me.O_o_Fadi_o_O.MiniGames.runnables.ChickenFightRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.EXPBarRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.OtherRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.PetRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.PlayerRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.ScoreboardRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.SnowGollemAttackRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.SurvivalGamesRunnable;
import me.O_o_Fadi_o_O.MiniGames.utils.ChatColor;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.Disguise;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.Hat;
import me.O_o_Fadi_o_O.MiniGames.utils.Server;
import me.O_o_Fadi_o_O.MiniGames.utils.StaffRank;
import me.O_o_Fadi_o_O.MiniGames.utils.Trail;
import me.O_o_Fadi_o_O.MiniGames.utils.TrailType;
import me.O_o_Fadi_o_O.MiniGames.utils.VIPRank;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin {
	
	private int Arena;
	private String Map;
	
	private ChickenFightRunnable chickenfightrunnable;
	private DatabaseRunnable databaserunnable;
	private EntityRunnable entityrunnable;
	private EXPBarRunnable expbarrunnable;
	private OtherRunnable otherrunnable;
	private PetRunnable petrunnable;
	private PlayerRunnable playerrunnable;
	private ScoreboardRunnable scoreboardrunnable;
	private ServerSelectorRunnable serverselectorrunnable;
	private SnowGollemAttackRunnable snowgolemattackrunnable;
	private SurvivalGamesRunnable survivalgamesrunnable;
	
	private ScoreboardTitleManager scoreboardtitlemanager;
	
	private static Start plugin;
	private NPCManager npcmanager;
	private PlayerManager pmanager;
	
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
		addCustomEntity(CustomChicken.class, "CustomChicken", 93);
		addCustomEntity(CustomIronGolem.class, "CustomIronGolem", 99);
		
		plugin = this;
		
		chickenfightrunnable = new ChickenFightRunnable();
		databaserunnable = new DatabaseRunnable();
		entityrunnable = new EntityRunnable();
		expbarrunnable = new EXPBarRunnable();
		otherrunnable = new OtherRunnable();
		petrunnable = new PetRunnable();
		playerrunnable = new PlayerRunnable();
		scoreboardrunnable = new ScoreboardRunnable();
	    serverselectorrunnable = new ServerSelectorRunnable();
		snowgolemattackrunnable = new SnowGollemAttackRunnable();
		survivalgamesrunnable = new SurvivalGamesRunnable();
		
		scoreboardtitlemanager = new ScoreboardTitleManager();
		
		npcmanager = new NPCManager();
		pmanager = new PlayerManager();
		
		StorageManager.thisserver = Server.MINIGAMES;
		StorageManager.spawn = new Location(StorageManager.lobbyworld, 0.5, 63, 4.5, 90, 0);
		
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
			
			MiniGamesLobbyKit.giveInventory(p, true);
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		
		registerArenas();
		
		registerAllEvents();
		removeAllEntities();
		startAllRunnables();
			
		try{
			npcmanager.spawnServerSelector(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -2.5, 63, 1.5, -45, 0), "§3§lServer Selector");
			npcmanager.spawnChickenFightNPC(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -13.5, 62, 19.5, 180, 0), "§f§lChicken Fight");
			npcmanager.spawnSurvivalGamesNPC(StorageManager.lobbyworld, new Location(StorageManager.lobbyworld, -45.5, 62, 12.5, -90, 0), "§6§lSurvival Games");
			
			/*npcmanager.spawnArmorStand(
					StorageManager.lobbyworld, 
					new Location(StorageManager.lobbyworld, -13.5, 62, 19.5, 180, 0), 
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
					null,
					null,
					null,
					null,
					null,
					ArmorStandType.CHICKEN_FIGHT_NPC);
					*/
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
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.teleport(StorageManager.spawn);
			
			if(StorageManager.nickname.containsKey(p)){
				if(DatabaseManager.containsPath("name", "PlayerNicknames", p.getName())){
					DatabaseManager.setNickname(p, StorageManager.nickname.get(p));
				}
				else{
					DatabaseManager.insertString(p.getName(), "PlayerNicknames", "nick", StorageManager.nickname.get(p));
				}
			}
			else{
				if(DatabaseManager.containsPath("name", "PlayerNicknames", p.getName())){
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
			
			if(p.getVehicle() != null){
				p.leaveVehicle();
			}
			if(p.getPassenger() != null){
				if(p.getPassenger().getVehicle() != null){
					p.getPassenger().leaveVehicle();
				}
			}
			if(StorageManager.disguise.containsKey(p)){
				DisguisePlayer.undisguisePlayer(p);
			}
			p.setAllowFlight(false);
			p.setFlying(false);
		    ((CraftPlayer) p).getHandle().setInvisible(false);
			for(Player player : Bukkit.getOnlinePlayers()){
				p.showPlayer(player);
			}
			teleportToLobby(p);
			MiniGamesLobbyKit.giveInventory(p, true);
			p.setLevel(0);
			p.setExp(0);
		}
		
		try{
			Start.rollback(StorageManager.survivalgamesspectatorlocation.get(StorageManager.survivalgamescurrentmap.get(1)).getWorld().getName());
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cCannot find world for SG1!");
		}
		try{
			Start.rollback(StorageManager.survivalgamesspectatorlocation.get(StorageManager.survivalgamescurrentmap.get(2)).getWorld().getName());
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cCannot find world for SG2!");
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
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new AnimationEvent(), this);
		getServer().getPluginManager().registerEvents(new BlockChangeEvent(), this);
		getServer().getPluginManager().registerEvents(new BlockFormEvent(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		getServer().getPluginManager().registerEvents(new DamageByEntity(), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new DespawnEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDeath(), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new InteractAtEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new PickUpEvent(), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new SignEvent(), this);
		getServer().getPluginManager().registerEvents(new ToggleFlightEvent(), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
	}
	
	private void startAllRunnables(){
		chickenfightrunnable.startChickenFightRunnable();
		databaserunnable.startDatabaseRunnable();
		entityrunnable.startEntityRunnable();
		expbarrunnable.startEXPBarRunnable();
		otherrunnable.startOtherRunnable();
		petrunnable.startPetRunnable();
		playerrunnable.startPlayerRunnable();
		scoreboardrunnable.startScoreboardRunnable();
		serverselectorrunnable.startServerSelectorRunnable();
		scoreboardtitlemanager.startScoreboardTitleRunnable();
		snowgolemattackrunnable.startPetSnowGollemAttackRunnable();
		survivalgamesrunnable.startSurvivalGamesRunnable();
	}
	
	public static Start getInstance(){
		return plugin;
	}
	
	public static void teleportToLobby(Player p){
		p.teleport(StorageManager.spawn);
		p.setFoodLevel(20);
		p.setHealth(20D);
	    for(PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
	    p.setFireTicks(0);
	    TitleManager.setTitle(p, "§6§lOrbitMines§f§lMiniGames", "");
	}
	
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
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
    
    public static void unloadMap(String mapname){
        Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false);
    }
   
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }

    public static void rollback(String mapname){
        unloadMap(mapname);
        loadMap(mapname);
    }
    
	public static Location getLobbyLocation(){
		return getLocationFromString((ConfigManager.minigames.getString("LobbyLocation")));
	}
	
	public static void setLobbyLocation(Location l){
		ConfigManager.minigames.set("LobbyLocation", getStringFromLocation(l));
		ConfigManager.saveMiniGames();
	}
    
	public static String getStringFromLocation(Location l){
		String world = l.getWorld().getName();
		double x = l.getX();
		double y = l.getY();
		double z = l.getZ();
		float yaw = l.getYaw();
		float pitch = l.getPitch();
		
		return world + "|" + x + "|" + y + "|" + z + "|" + yaw + "|" + pitch;
	}
	public static Location getLocationFromString(String location){
		String[] largs = location.split("\\|");
		
		World w = Bukkit.getWorld(largs[0]);
		double x = Double.parseDouble(largs[1]);
		double y = Double.parseDouble(largs[2]);
		double z = Double.parseDouble(largs[3]);
		float yaw = Float.parseFloat(largs[4]);
		float pitch = Float.parseFloat(largs[5]);
		
		return new Location(w, x, y, z, yaw, pitch);
	}
	
	private static void registerArenas(){
		try{
			for(String s : ConfigManager.chickenfight.getConfigurationSection("ChickenFightMaps").getKeys(false)){
				ChickenFight.registerMapData(s);
			}
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading the ChickenFight Maps.");
		}
		try{
			for(String s : ConfigManager.survivalgames.getConfigurationSection("SurvivalGamesMaps").getKeys(false)){
				SurvivalGames.registerMapData(s);
			}
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading the SurvivalGames Maps.");
		}
		try{
			ChickenFight.registerArenaData(1);
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading CF1.");
		}
		try{
			ChickenFight.registerArenaData(2);
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading CF2.");
		}
		try{
			SurvivalGames.registerArenaData(1);
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading SG1.");
		}
		try{
			SurvivalGames.registerArenaData(2);
		}catch(Exception ex){
			Bukkit.getConsoleSender().sendMessage("§cError while loading SG2.");
		}
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
		if(cmd.getName().equalsIgnoreCase("heal")){}
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
		
		if(cmd.getName().equalsIgnoreCase("mgbuykit")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(StorageManager.playersgame.containsKey(p) && StorageManager.playersgame.get(p) == Game.CHICKENFIGHT){		
					ChickenFightState state = StorageManager.chickenfightstate.get(StorageManager.playersarena.get(p));
					
					if(state == ChickenFightState.LOBBY || state == ChickenFightState.LASTSECONDS){
						if(a.length == 1){
							
							if(a[0].equalsIgnoreCase("BabyChicken")){
								if(!StorageManager.kitbabychicken.containsKey(p)){
									
									if(StorageManager.minigamecoins.get(p) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-BabyChicken", "babychicken", 1);
										
										DatabaseManager.removeMiniGameCoins(p, 1000);
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lBaby Chicken§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.kitbabychicken.put(p, false);
									}
									else{
										p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
									}
								}
							}
							else if(a[0].equalsIgnoreCase("HotWing")){
								if(!StorageManager.kithotwing.containsKey(p)){
									
									if(StorageManager.minigamecoins.get(p) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-HotWing", "hotwing", 1);
										
										DatabaseManager.removeMiniGameCoins(p, 1000);
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lHot Wing§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.kithotwing.put(p, false);
									}
									else{
										p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
									}
								}
							}
							else if(a[0].equalsIgnoreCase("ChickenWarrior")){
								if(!StorageManager.kitchickenwarrior.containsKey(p)){
									
									if(StorageManager.minigamecoins.get(p) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-ChickenWarrior", "chickenwarrior", 1);
										
										DatabaseManager.removeMiniGameCoins(p, 1000);
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lChicken Warrior§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.kitchickenwarrior.put(p, false);
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
		}
		if(cmd.getName().equalsIgnoreCase("mg")){
			
			if(sender instanceof Player){
				
				Player p = (Player) sender;
				if(p.hasPermission("Rank.Owner")){
					if(a.length == 0){
						p.sendMessage("/mg setuplobby");
						p.sendMessage("/mg setupcf create 1|2");
						p.sendMessage("/mg setupcfmap create <name>");
						p.sendMessage("");
						p.sendMessage("/mg setupsg create 1|2");
						p.sendMessage("/mg setupsgmap create <name>");
					
					}	
					else if(a[0].equalsIgnoreCase("setuplobby")){
						
						setLobbyLocation(p.getLocation());
						
						p.sendMessage("§f§lLobby set!");
						
					}
					else if(a[0].equalsIgnoreCase("setupcfmap")){
						
						if(a.length == 1){
							p.sendMessage("Incorrect Use!");
						}
						else if(a[1].equalsIgnoreCase("create")){
							
							if(a.length == 3){
								Map = a[2];
								ChickenFight.setMapSpawnsAmount(Map, 0);
								
								p.sendMessage("§f§lChickenFight §fMap Created! (§9" + Map + "§f)");
								p.sendMessage("Now: '§9/mg setupcfmap setnextspawn§f'");
								
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
							
						}
						else if(a[1].equalsIgnoreCase("setnextspawn")){
							
							int i = ChickenFight.getMapSpawnsAmount(Map) +1;
							
							ChickenFight.setMapSpawnLocation(Map, p.getLocation(), i);
							ChickenFight.setMapSpawnsAmount(Map, i);
							
							p.sendMessage("Spawn " + i + " Set!");
							p.sendMessage("Now: '§9/mg setupcfmap setspectatorspawn§f'");
							
						}
						else if(a[1].equalsIgnoreCase("setspectatorspawn")){
							
							ChickenFight.setMapSpectatorLocation(Map, p.getLocation());
							
							p.sendMessage("Spectator Spawn Set!");
							p.sendMessage("Now: '§9/mg setupcfmap builtby <string>§f'");
							
						}
						else if(a[1].equalsIgnoreCase("builtby")){
							
							if(a.length == 3){
								
								String s = a[2];
								
								ChickenFight.setMapBuilder(Map, s);
								
								p.sendMessage("Spectator Spawn Set!");
								p.sendMessage("Now: '§9/mg setupcfmap finish§f'");
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("finish")){
							
							ChickenFight.registerMapData(Map);
							
							p.sendMessage("Setup Finished!");
							
						}
						else{
							p.sendMessage("Incorrect Use!");
						}
					}
					else if(a[0].equalsIgnoreCase("setupcf")){
						
						if(a.length == 1){
							p.sendMessage("Incorrect Use!");
						}
						else if(a[1].equalsIgnoreCase("create")){
							
							if(a.length == 3){
								try{
									Arena = Integer.parseInt(a[2]);
									ChickenFight.setArenaDisabled(Arena);
								
									p.sendMessage("§f§lChickenFight §fArena Created! (§9" + Arena + "§f)");
									p.sendMessage("Now: '§9/mg setupcf setlobby§f'");
									
								}catch(Exception ex){
									p.sendMessage("Error!");
								}
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("setlobby")){
							
							ChickenFight.setArenaLobbyLocation(Arena, p.getLocation());
							
							p.sendMessage("Lobby Set!");
							p.sendMessage("Now: '§9/mg setupcf finish§f'");
														
						}
						else if(a[1].equalsIgnoreCase("finish")){
							
							ChickenFight.setArenaEnabled(Arena);
							ChickenFight.registerArenaData(Arena);
							
							p.sendMessage("Setup Finished!");
							
						}
						else{
							p.sendMessage("Incorrect Use!");
						}
					}
					
					
					else if(a[0].equalsIgnoreCase("setupsgmap")){
						
						if(a.length == 1){
							p.sendMessage("Incorrect Use!");
						}
						else if(a[1].equalsIgnoreCase("create")){
							
							if(a.length == 3){
								Map = a[2];
								SurvivalGames.setMapSpawnsAmount(Map, 0);
								
								p.sendMessage("§f§lSurvivalGames §fMap Created! (§9" + Map + "§f)");
								p.sendMessage("Now: '§9/mg setupsgmap setnextspawn§f'");
								
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
							
						}
						else if(a[1].equalsIgnoreCase("setnextspawn")){
							
							int i = SurvivalGames.getMapSpawnsAmount(Map) +1;
							
							SurvivalGames.setMapSpawnLocation(Map, p.getLocation(), i);
							SurvivalGames.setMapSpawnsAmount(Map, i);
							
							p.sendMessage("Spawn " + i + " Set!");
							p.sendMessage("Now: '§9/mg setupsgmap setspectatorspawn§f'");
							
						}
						else if(a[1].equalsIgnoreCase("setspectatorspawn")){
							
							SurvivalGames.setMapSpectatorLocation(Map, p.getLocation());
							
							p.sendMessage("Spectator Spawn Set!");
							p.sendMessage("Now: '§9/mg setupsgmap builtby <string>§f'");
							
						}
						else if(a[1].equalsIgnoreCase("builtby")){
							
							if(a.length == 3){
								
								String s = a[2];
								
								SurvivalGames.setMapBuilder(Map, s);
								
								p.sendMessage("Spectator Spawn Set!");
								p.sendMessage("Now: '§9/mg setupsgmap finish§f'");
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("finish")){
							
							SurvivalGames.registerMapData(Map);
							
							p.sendMessage("Setup Finished!");
							
						}
						else{
							p.sendMessage("Incorrect Use!");
						}
					}
					else if(a[0].equalsIgnoreCase("setupsg")){
						
						if(a.length == 1){
							p.sendMessage("Incorrect Use!");
						}
						else if(a[1].equalsIgnoreCase("create")){
							
							if(a.length == 3){
								try{
									Arena = Integer.parseInt(a[2]);
									SurvivalGames.setArenaDisabled(Arena);
								
									p.sendMessage("§f§lSurvivalGames §fArena Created! (§9" + Arena + "§f)");
									p.sendMessage("Now: '§9/mg setupsg setlobby§f'");
									
								}catch(Exception ex){
									p.sendMessage("Error!");
								}
							}
							else{
								p.sendMessage("Incorrect Use!");
							}
						}
						else if(a[1].equalsIgnoreCase("setlobby")){
							
							SurvivalGames.setArenaLobbyLocation(Arena, p.getLocation());
							
							p.sendMessage("Lobby Set!");
							p.sendMessage("Now: '§9/mg setupsg finish§f'");
														
						}
						else if(a[1].equalsIgnoreCase("finish")){
							
							SurvivalGames.setArenaEnabled(Arena);
							SurvivalGames.registerArenaData(Arena);
							
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
		
		return false;
	}
	
}
