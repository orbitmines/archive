package me.O_o_Fadi_o_O.MiniGames;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.CosmeticPerks;
import me.O_o_Fadi_o_O.MiniGames.Inventories.ServerSelector;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
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
import me.O_o_Fadi_o_O.MiniGames.NMS.LobbyChickenFightNPC;
import me.O_o_Fadi_o_O.MiniGames.NMS.LobbySurvivalGamesNPC;
import me.O_o_Fadi_o_O.MiniGames.events.BreakEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ClickEventENG;
import me.O_o_Fadi_o_O.MiniGames.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DamageByEntity;
import me.O_o_Fadi_o_O.MiniGames.events.DamageEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DeathEvent;
import me.O_o_Fadi_o_O.MiniGames.events.DropEvent;
import me.O_o_Fadi_o_O.MiniGames.events.EntityDeath;
import me.O_o_Fadi_o_O.MiniGames.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ExplodeEvent;
import me.O_o_Fadi_o_O.MiniGames.events.InteractEvent;
import me.O_o_Fadi_o_O.MiniGames.events.JoinEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PickUpEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlaceEvent;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerChat;
import me.O_o_Fadi_o_O.MiniGames.events.PlayerMove;
import me.O_o_Fadi_o_O.MiniGames.events.ProjectileHit;
import me.O_o_Fadi_o_O.MiniGames.events.QuitEvent;
import me.O_o_Fadi_o_O.MiniGames.events.ToggleFlightEvent;
import me.O_o_Fadi_o_O.MiniGames.events.VoteEvent;
import me.O_o_Fadi_o_O.MiniGames.managers.ChickenFight;
import me.O_o_Fadi_o_O.MiniGames.managers.ConfigManager;
import me.O_o_Fadi_o_O.MiniGames.managers.DatabaseManager;
import me.O_o_Fadi_o_O.MiniGames.managers.NPCManager;
import me.O_o_Fadi_o_O.MiniGames.managers.PlayerManager;
import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.managers.SurvivalGames;
import me.O_o_Fadi_o_O.MiniGames.managers.VoteManager;
import me.O_o_Fadi_o_O.MiniGames.runnables.ChickenFightRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.EXPBarRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.OtherRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.SurvivalGamesRunnable;
import me.O_o_Fadi_o_O.MiniGames.runnables.SwapTeleporterRunnable;
import me.O_o_Fadi_o_O.MiniGames.utils.ChickenFightState;
import me.O_o_Fadi_o_O.MiniGames.utils.EntityHider;
import me.O_o_Fadi_o_O.MiniGames.utils.EntityHider.Policy;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;

public class Start extends JavaPlugin {
	
	public int i2;
	
	public static EntityHider entityHider;
    public static EffectManager effectManager;
    public int Arena;
    public String Map;
	ServerSelector sinv = new ServerSelector();
	OtherRunnable runnableOther = new OtherRunnable(this);	
	ChickenFightRunnable runnableChickenFight = new ChickenFightRunnable(this);	
	SurvivalGamesRunnable runnableSurvivalGames = new SurvivalGamesRunnable(this);
	EntityRunnable runnableEntity = new EntityRunnable(this);	
	EXPBarRunnable runnableEXPBar = new EXPBarRunnable(this);	
	SwapTeleporterRunnable runnableSwapTeleporterRunnable = new SwapTeleporterRunnable(this);	
    
	JoinEvent joinEvent = new JoinEvent(this);
	
	public void onEnable(){
		i2 = 0;
		
		entityHider = new EntityHider(this, Policy.BLACKLIST);
		addCustomEntities();
		removeAllEntities();
		
		EffectLib lib = EffectLib.instance();
	    effectManager = new EffectManager(lib);
	    
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageByEntity(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PickUpEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
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
		Bukkit.getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		
		ConfigManager.setup(this);
		
		if(ConfigManager.votedata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.votedata.getStringList("VoteRewardsNotGiven")){
				list.add(s);
			}
			StorageManager.VoteRewardsNotGiven.clear();
			StorageManager.VoteRewardsNotGiven.addAll(list);
		}
		
		ProtocolLibrary.getProtocolManager().addPacketListener(
				  new PacketAdapter(this, PacketType.Play.Server.NAMED_SOUND_EFFECT) {
				    @Override
				    public void onPacketSending(PacketEvent e) {
						// You can also get the location of the sound effect -
				        // see PacketWrapper's WrapperPlayServerNamedSoundEffect
				        String soundName = e.getPacket().getStrings().read(0);
				        e.setCancelled(soundName.startsWith("mob.skeleton"));
				    }
				});
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		spawnNPCs();
		
		try{
			StorageManager.Lobby = getLobbyLocation();
		}catch(Exception ex){
			
		}
		runnableOther.startEntityRunnable();
		runnableChickenFight.startChickenFightRunnable();
		runnableSurvivalGames.startSurvivalGamesRunnable();
		runnableEntity.startEntityRunnable();
		runnableEXPBar.startEXPBarRunnable();
		runnableSwapTeleporterRunnable.startSwapTeleporterRunnable();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			try{
				teleportToLobby(p);
				MiniGamesLobbyKit.giveInventory(p);
				p.setAllowFlight(false);
				p.setFlying(false);
			}catch(Exception ex){
				
			}
		}
		
		try{
			for(String s : ConfigManager.chickenfight.getConfigurationSection("ChickenFightMaps").getKeys(false)){
			
				ChickenFight.registerMapData(s);
			
			}
		}catch(Exception ex){
			
		}
		try{
			for(String s : ConfigManager.survivalgames.getConfigurationSection("SurvivalGamesMaps").getKeys(false)){
			
				SurvivalGames.registerMapData(s);
			
			}
		}catch(Exception ex){
			
		}
		try{
			ChickenFight.registerArenaData(1);
		}catch(Exception ex){
			
		}
		try{
			ChickenFight.registerArenaData(2);
		}catch(Exception ex){
			
		}
		try{
			SurvivalGames.registerArenaData(1);
		}catch(Exception ex){
			
		}
		try{
			SurvivalGames.registerArenaData(2);
		}catch(Exception ex){
			
		}
		
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				i2++;
					
				ServerSelector.KitPvPServerItem(ServerSelector.sinv, i2);
				ServerSelector.PrisonServerItem(ServerSelector.sinv, i2);;
				ServerSelector.CreativeServerItem(ServerSelector.sinv, i2);
				ServerSelector.SurvivalServerItem(ServerSelector.sinv, i2);
				ServerSelector.SkyBlockServerItem(ServerSelector.sinv, i2);
				ServerSelector.MiniGamesServerItem(ServerSelector.sinv, i2);
				
				if(i2 == 2){
					i2 = 0;
				}
				
			}
		}.runTaskTimer(this, 0, 3);
	}
	
	public void onDisable(){
		removeAllEntities();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			try{
				if(p.getVehicle() != null){
					p.leaveVehicle();
				}
				if(p.getPassenger() != null){
					if(p.getPassenger().getVehicle() != null){
						p.getPassenger().leaveVehicle();
					}
				}
				DisguiseAPI.undisguiseToAll(p);
				p.setAllowFlight(false);
				p.setFlying(false);
			    ((CraftPlayer) p).getHandle().setInvisible(false);
				for(Player player : Bukkit.getOnlinePlayers()){
					p.showPlayer(player);
				}
				teleportToLobby(p);
				MiniGamesLobbyKit.giveInventory(p);
				p.setLevel(0);
				p.setExp(0);
			}catch(Exception ex){
				
			}
		}
		
		try{
			Start.rollback(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(1)).getWorld().getName());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			Start.rollback(StorageManager.SurvivalGamesSpectatorLocation.get(StorageManager.SurvivalGamesCurrentMap.get(2)).getWorld().getName());
		}catch(Exception ex){
			
		}
	}
	
	
    //Unloading maps, to rollback maps. Will delete all player builds until last server save
    public static void unloadMap(String mapname){
        Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false);
    }
    //Loading maps (MUST BE CALLED AFTER UNLOAD MAPS TO FINISH THE ROLLBACK PROCESS)
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }
 
    //Maprollback method, because were too lazy to type 2 lines
    public static void rollback(String mapname){
        unloadMap(mapname);
        loadMap(mapname);
    }
	
	
	public static void showChickenFightNPCs(Player p, int arena){
		if(StorageManager.KitChickenMama.get(p.getName()) == null){
			entityHider.hideEntity(p, StorageManager.KitChickenMamaEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenMamaUnEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitChickenMamaLocked.get(arena));
		}
		else if(StorageManager.KitChickenMama.get(p.getName()) == false){
			entityHider.hideEntity(p, StorageManager.KitChickenMamaEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitChickenMamaUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenMamaLocked.get(arena));
		}
		else if(StorageManager.KitChickenMama.get(p.getName()) == true){
			entityHider.showEntity(p, StorageManager.KitChickenMamaEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenMamaUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenMamaLocked.get(arena));
		}
		
		if(StorageManager.KitBabyChicken.get(p.getName()) == null){
			entityHider.hideEntity(p, StorageManager.KitBabyChickenEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitBabyChickenUnEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitBabyChickenLocked.get(arena));
		}
		else if(StorageManager.KitBabyChicken.get(p.getName()) == false){
			entityHider.hideEntity(p, StorageManager.KitBabyChickenEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitBabyChickenUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitBabyChickenLocked.get(arena));
		}
		else if(StorageManager.KitBabyChicken.get(p.getName()) == true){
			entityHider.showEntity(p, StorageManager.KitBabyChickenEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitBabyChickenUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitBabyChickenLocked.get(arena));
		}
		
		if(StorageManager.KitHotWing.get(p.getName()) == null){
			entityHider.hideEntity(p, StorageManager.KitHotWingEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitHotWingUnEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitHotWingLocked.get(arena));
		}
		else if(StorageManager.KitHotWing.get(p.getName()) == false){
			entityHider.hideEntity(p, StorageManager.KitHotWingEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitHotWingUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitHotWingLocked.get(arena));
		}
		else if(StorageManager.KitHotWing.get(p.getName()) == true){
			entityHider.showEntity(p, StorageManager.KitHotWingEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitHotWingUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitHotWingLocked.get(arena));
		}
		
		if(StorageManager.KitChickenWarrior.get(p.getName()) == null){
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorUnEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitChickenWarriorLocked.get(arena));
		}
		else if(StorageManager.KitChickenWarrior.get(p.getName()) == false){
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorEquiped.get(arena));
			entityHider.showEntity(p, StorageManager.KitChickenWarriorUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorLocked.get(arena));
		}
		else if(StorageManager.KitChickenWarrior.get(p.getName()) == true){
			entityHider.showEntity(p, StorageManager.KitChickenWarriorEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorUnEquiped.get(arena));
			entityHider.hideEntity(p, StorageManager.KitChickenWarriorLocked.get(arena));
		}
	}
	
	public static Location getLobbyLocation(){
		
		World w = Bukkit.getWorld(ConfigManager.minigames.getString("LobbyLocation.world"));
		double x = ConfigManager.minigames.getDouble("LobbyLocation.x");
		double y = ConfigManager.minigames.getDouble("LobbyLocation.y");
		double z = ConfigManager.minigames.getDouble("LobbyLocation.z");
		float yaw = ConfigManager.minigames.getInt("LobbyLocation.yaw");
		float pitch = ConfigManager.minigames.getInt("LobbyLocation.pitch");
		
		Location l = new Location(w, x, y, z, yaw, pitch);
		
		return l;
	}
	
	public static void setLobbyLocation(Location l){
		ConfigManager.minigames.set("LobbyLocation.world", l.getWorld().getName());
		ConfigManager.minigames.set("LobbyLocation.x", l.getX());
		ConfigManager.minigames.set("LobbyLocation.y", l.getY());
		ConfigManager.minigames.set("LobbyLocation.z", l.getZ());
		ConfigManager.minigames.set("LobbyLocation.yaw", l.getYaw());
		ConfigManager.minigames.set("LobbyLocation.pitch", l.getPitch());
		ConfigManager.saveMiniGames();
	}
	
	public static void teleportToLobby(Player p){
		p.teleport(StorageManager.Lobby);
		p.setFoodLevel(20);
		p.setHealth(20D);
	}
	
	public static void clearInventory(Player p){
		
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
	}
	
	public void spawnNPCs(){
		
		{
			try{
				World w = Bukkit.getWorld("MiniGamesLobby");
				Location l1 = new Location(w, -13.5, 64, 19.5, 180, 0);
				Location l2 = new Location(w, -46.5, 64, 12.5, -90, 0);
				NPCManager.spawnLobbyNPCs(w, l1, l2);	
			}catch(Exception ex){
				ex.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§cCouldn't find World: MiniGamesLobby");
			}
		}
		
		{
			try{
				World w = Bukkit.getWorld("ChickenFightLobby1");
				Location l1 = new Location(w, 0.5, 65, 23.5, (float) 180, (float) 45);
				Location l2 = new Location(w, -13.5, 65, 18.5, (float) -135, (float) 45);
				Location l3 = new Location(w, -18.5, 65, 4.5, (float) -90, (float) 45);
		 		Location l4 = new Location(w, -13.5, 65, -9.5, (float) -45, (float) 45);
		 		NPCManager.spawnChickenFightNPCs(w, 1, l1, l2, l3, l4);
			}catch(Exception ex){
				Bukkit.getConsoleSender().sendMessage("§cCouldn't find World: ChickenFightLobby1");
			}
		}
		{
			try{
				World w = Bukkit.getWorld("ChickenFightLobby2");
				Location l1 = new Location(w, 0.5, 65, 23.5, (float) 180, (float) 45);
				Location l2 = new Location(w, -13.5, 65, 18.5, (float) -135, (float) 45);
				Location l3 = new Location(w, -18.5, 65, 4.5, (float) -90, (float) 45);
				Location l4 = new Location(w, -13.5, 65, -9.5, (float) -45, (float) 45);
				NPCManager.spawnChickenFightNPCs(w, 2, l1, l2, l3, l4);	
			}catch(Exception ex){
				Bukkit.getConsoleSender().sendMessage("§cCouldn't find World: ChickenFightLobby2");
			}
		}
	}
	
	private void addCustomEntities(){
		NPCManager.addCustomEntity(ChickenKit.class, "ChickenKit", 93);
		NPCManager.addCustomEntity(IronGolemKit.class, "IronGolemKit", 99);
		NPCManager.addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		NPCManager.addCustomEntity(CustomPig.class, "CustomPig", 90);
		NPCManager.addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		NPCManager.addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		NPCManager.addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		NPCManager.addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		NPCManager.addCustomEntity(CustomCow.class, "CustomCow", 92);
		NPCManager.addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		NPCManager.addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		NPCManager.addCustomEntity(LobbySurvivalGamesNPC.class, "LobbySurvivalGamesNPC", 51);
		NPCManager.addCustomEntity(LobbyChickenFightNPC.class, "LobbyChickenFightNPC", 93);
	}
	
	private void removeAllEntities(){
		for(World w : Bukkit.getWorlds()){
			try{
				for(Entity en : w.getEntities()){
					if(en instanceof Player){
						
					}
					else{
						en.remove();
					}
				}
			}catch(Exception ex){
				
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {
		if(cmd.getName().equalsIgnoreCase("vote")){
			if(sender instanceof Player){
				//Player p = (Player) sender;
				//p.sendMessage("");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote for §b§lRewards§7!");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Reward in the §3§lHub§7 Server:");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7  - §e§l1 OrbitMines Token");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Vote at §b§lwww.orbitmines.com");
				//p.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(p.getName()));
				//p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
			}
		}
		if(cmd.getName().equalsIgnoreCase("votes")){
			
			if(sender.hasPermission("Rank.Owner")){
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
			
			if(sender.hasPermission("Rank.Owner")){
				if(a.length == 0){
					sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.points.get(sender.getName()));
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
							
							try {
								DatabaseManager.addVIPPoints(player, i);
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
								DatabaseManager.removeVIPPoints(player, i);
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
			else{
				sender.sendMessage("§b§lVIP Points §8| §7Your VIP Points: §b§l" + StorageManager.points.get(sender.getName()));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("omt")){
			if(sender.hasPermission("Rank.Owner")){
				if(a.length == 0){
					sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.omt.get(sender.getName()));
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
							
							try {
								DatabaseManager.addOMT(player, i);
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
								DatabaseManager.removeOMT(player, i);
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
				sender.sendMessage("§e§lOMT §8| §7Your OrbitMines Tokens: §e§l" + StorageManager.omt.get(sender.getName()));
			}
		}
		if(cmd.getName().equalsIgnoreCase("mgbuykit")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(StorageManager.PlayersGame.containsKey(p) && StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){		
					ChickenFightState state = StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p));
					
					if(state == ChickenFightState.LOBBY || state == ChickenFightState.LASTSECONDS){
						if(a.length == 1){
							
							if(a[0].equalsIgnoreCase("BabyChicken")){
								if(!StorageManager.KitBabyChicken.containsKey(p.getName())){
									
									if(StorageManager.coins.get(p.getName()) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-BabyChicken", "babychicken", 1);
										
										try {
											DatabaseManager.removeMiniGameCoins(p, 1000);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lBaby Chicken§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.KitBabyChicken.put(p.getName(), false);
									}
									else{
										p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
									}
								}
							}
							else if(a[0].equalsIgnoreCase("HotWing")){
								if(!StorageManager.KitHotWing.containsKey(p.getName())){
									
									if(StorageManager.coins.get(p.getName()) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-HotWing", "hotwing", 1);
										
										try {
											DatabaseManager.removeMiniGameCoins(p, 1000);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lHot Wing§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.KitHotWing.put(p.getName(), false);
									}
									else{
										p.sendMessage("§eKits §8| §7You don't have enough §f§lMiniGame Coins§7!");
									}
								}
							}
							else if(a[0].equalsIgnoreCase("ChickenWarrior")){
								if(!StorageManager.KitChickenWarrior.containsKey(p.getName())){
									
									if(StorageManager.coins.get(p.getName()) >= 1000){
										
										DatabaseManager.insertInt(p.getName(), "ChickenFight-ChickenWarrior", "chickenwarrior", 1);
										
										try {
											DatabaseManager.removeMiniGameCoins(p, 1000);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										
										p.sendMessage("§eKits §8| §7You have bought '§e§lChicken Warrior§7'!");
										p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
										StorageManager.KitChickenWarrior.put(p.getName(), false);
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
		if(cmd.getName().equalsIgnoreCase("servers")){
			boolean useAble = false;
			
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(StorageManager.PlayersGame.containsKey(p.getName())){
					
					if(StorageManager.PlayersGame.get(p.getName()) == Game.CHICKENFIGHT){		
						ChickenFightState state = StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p.getName()));
						if(state == ChickenFightState.LOBBY){
							useAble = false;
						}
					}
				}
				else{
					useAble = true;
				}
				if(useAble == true){
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(sinv.getServerSelectorInv(p, 1));
				}
			}	
			
		}
		if(cmd.getName().equalsIgnoreCase("perks")){
			
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(PlayerManager.isLoaded(p)){
					if(StorageManager.PlayersGame.containsKey(p)){
						
						if(StorageManager.PlayersGame.get(p.getName()) == Game.CHICKENFIGHT){		
							ChickenFightState state = StorageManager.ChickenFightState.get(StorageManager.PlayersArena.get(p.getName()));
							if(state == ChickenFightState.LOBBY){
								p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
								p.openInventory(CosmeticPerks.getCosmeticPerks(p));
							}
						}
						if(StorageManager.PlayersGame.get(p.getName()) == Game.SURVIVALGAMES){		
							SurvivalGamesState state = StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p.getName()));
							if(state == SurvivalGamesState.LOBBY){
								p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
								p.openInventory(CosmeticPerks.getCosmeticPerks(p));
							}
						}
					}
					else{
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
						p.openInventory(CosmeticPerks.getCosmeticPerks(p));
					}
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
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
				//Player p = (Player) sender;
				//World w = p.getWorld();
				//for(Chunk ch : w.getLoadedChunks()){
				//	for(BlockState b : ch.getTileEntities()){
				//		if(b.getType() == Material.CHEST){
				//			Chest c = (Chest) b;
				//			SurvivalGames.setRandomChestContents(c);
				//		}
				//	}
				//}
				StorageManager.SurvivalGamesSeconds.put(1, 5);
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
		
		return false;
	}
}
