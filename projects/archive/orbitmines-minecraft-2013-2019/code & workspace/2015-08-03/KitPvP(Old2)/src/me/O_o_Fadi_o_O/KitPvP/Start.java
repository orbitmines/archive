package me.O_o_Fadi_o_O.KitPvP;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.O_o_Fadi_o_O.KitPvP.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.KitPvP.Inv.ServerSelector;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomPig;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSheep;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSlime;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomWolf;
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
import me.O_o_Fadi_o_O.KitPvP.managers.ConfigManager;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.NPCManager;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.VoteManager;
import me.O_o_Fadi_o_O.KitPvP.runnables.ArrowRunnables;
import me.O_o_Fadi_o_O.KitPvP.runnables.BoosterRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.DatabaseRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.DragonBarRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.FreeKitRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.MapRunnable;
import me.O_o_Fadi_o_O.KitPvP.runnables.ServerSelectorRunnable;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;

public class Start extends JavaPlugin implements Listener {
	
	public int i = 0;
	public int i3 = 0;
	
	public static ServerSelector sinv = new ServerSelector();
	
	public static boolean FreeKitEnabled = false;
	
	public static String TAG = "§c§lKitPvP §8|§7 ";;
	
	static Connection connection;
	
	public JoinEvent joinEvent = new JoinEvent(this);
	
	public NPCManager npcManager = new NPCManager(this);
	
	public DragonBarRunnable dragonBarRunnable = new DragonBarRunnable(this);
	public EntityRunnable entityRunnable = new EntityRunnable(this);
	public ServerSelectorRunnable serverSelectorRunnable = new ServerSelectorRunnable(this);
	public DatabaseRunnable databaseRunnable = new DatabaseRunnable(this);
	public ArrowRunnables arrowRunnables = new ArrowRunnables(this);
	public FreeKitRunnable freeKitRunnable = new FreeKitRunnable(this);
	public MapRunnable mapRunnable = new MapRunnable(this);
	public BoosterRunnable boosterRunnable = new BoosterRunnable(this);
	
	public static int n = 1;
	static World KitPvP = Bukkit.getWorld("KitPvPMap");
	
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
	
	@SuppressWarnings("deprecation")
	public void onEnable(){
		
		addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		addCustomEntity(CustomPig.class, "CustomPig", 90);
		addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		addCustomEntity(CustomCow.class, "CustomCow", 92);
		addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 54);

		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
				this, ConnectionSide.SERVER_SIDE, ListenerPriority.HIGH, 
				Packets.Server.SET_SLOT, Packets.Server.WINDOW_ITEMS) {
			@Override
			public void onPacketSending(PacketEvent event) {
				if (event.getPacketID() == Packets.Server.SET_SLOT) {
					addGlow(new ItemStack[] { event.getPacket().getItemModifier().read(0) });
				} else {
					addGlow(event.getPacket().getItemArrayModifier().read(0));
				}
			}
		});
		ProtocolLibrary.getProtocolManager().addPacketListener(
				  new PacketAdapter(this, PacketType.Play.Server.NAMED_SOUND_EFFECT) {
				    @Override
				    public void onPacketSending(PacketEvent e) {
				    	if(e.getPlayer().getWorld() == StorageManager.KitPvPLobby){
				    		// You can also get the location of the sound effect -
				    		// see PacketWrapper's WrapperPlayServerNamedSoundEffect
				    		String soundName = e.getPacket().getStrings().read(0);
				        	e.setCancelled(soundName.startsWith("mob.skeleton"));
				    	}
				    }
				});
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		registerAllEvents();
		
		ConfigManager.setup(this);
		
		if(ConfigManager.votedata.getStringList("VoteRewardsNotGiven") != null){
			List<String> list = new ArrayList<String>();
			for(String s : ConfigManager.votedata.getStringList("VoteRewardsNotGiven")){
				list.add(s);
			}
			StorageManager.VoteRewardsNotGiven.clear();
			StorageManager.VoteRewardsNotGiven.addAll(list);
		}
		
		for(World w : Bukkit.getWorlds()){
			for(Entity en : w.getEntities()){
				if(!(en instanceof Player)){
					en.remove();
				}
			}
		}

		registerAllSpawns(StorageManager.KitPvPArenas);
		
		npcManager.spawnAllKitSelectors(StorageManager.KitPvPLobby);
		
		mapRunnable.startMapRunnable();
		dragonBarRunnable.startDragonBarRunnable();
		entityRunnable.startEntityRunnable();
		serverSelectorRunnable.startServerSelectorRunnable();
		databaseRunnable.startDatabaseRunnable();
		arrowRunnables.startArcherArrowRunnable();
		arrowRunnables.startSoldierArrowRunnable();
		arrowRunnables.startPyroArrowRunnable();
		arrowRunnables.startNecromancerArrowRunnable();
		arrowRunnables.startTNTArrowRunnable();
		arrowRunnables.startHeavyArrowRunnable();
		freeKitRunnable.startFreeKitRunnable();
		boosterRunnable.startBoosterRunnable();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
	}
	
	public void onDisable(){
		for(Player p : Bukkit.getOnlinePlayers()){
			Start.clearInventory(p);
			p.teleport(StorageManager.spawnLocation);
			LobbyItems.giveItems(p);
		}
		
		try{
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(StorageManager.ownerpets.containsKey(p)){
							if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
								if(en instanceof LivingEntity){
									en.remove();
									StorageManager.owners.remove(StorageManager.ownerpets.get(p));
									StorageManager.ownerpets.remove(p);
								}
							}
						}
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
	
	private void registerAllEvents(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new BowShot(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
		getServer().getPluginManager().registerEvents(new ClickEvent2(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new EXPPickup(this), this);
		getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(this), this);	
		getServer().getPluginManager().registerEvents(new SignsColor(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(this), this);
		getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		getServer().getPluginManager().registerEvents(new SneakEvent(), this);
		getServer().getPluginManager().registerEvents(new ToggleFlightEvent(), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(this), this);
		getServer().getPluginManager().registerEvents(new EntityInteractEvent(this), this);
		getServer().getPluginManager().registerEvents(new EntityChangeBlock(this), this);
		getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		getServer().getPluginManager().registerEvents(new BreakEvent(this), this);
		getServer().getPluginManager().registerEvents(new PlaceEvent(this), this);
	}
	
	public static void RandomSpawn(Player p){
		if(!StorageManager.Spectators.contains(p)){
	        if(StorageManager.currentMap == KitPvPMap.Mountain_Village){
	        	Random r = new Random();
	        	int i = r.nextInt(StorageManager.MountainVillageSpawns.size()-1);
	        	
	        	p.teleport(StorageManager.MountainVillageSpawns.get(i));
	        	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	        }
	        if(StorageManager.currentMap == KitPvPMap.Snow_Town){
	        	Random r = new Random();
	        	int i = r.nextInt(StorageManager.SnowTownSpawns.size()-1);
	        	
	        	p.teleport(StorageManager.SnowTownSpawns.get(i));
	        	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
	        }
		}
		else{
			if(StorageManager.currentMap == KitPvPMap.Mountain_Village){
				p.teleport(StorageManager.MountainVillageSpectatorSpawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
			if(StorageManager.currentMap == KitPvPMap.Snow_Town){
				p.teleport(StorageManager.SnowTownSpectatorSpawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
			p.setAllowFlight(true);
			p.setFlying(true);
		}
        
        PlayerManager.sendMapMessage(p);
	}
	
	public static void registerAllSpawns(World w){
		StorageManager.MountainVillageSpawns.add(new Location(w, -352.5, 5, -1366.5, -54, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -317.5, 4, -1329.5, 46, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -283.5, 4, -1296.5, 165, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -303.5, 5, -1315.5, 39, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -284.5, 4, -1348.5, 168, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -303.5, 4, -1345.5, 135, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -316.5, 9, -1364.5, 30, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -337.5, 5, -1344.5, -126, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -349.5, 4, -1327.5, -113, 0));
		StorageManager.MountainVillageSpawns.add(new Location(w, -323.5, 5, -1296.5, -161, 0));
		
		StorageManager.SnowTownSpawns.add(new Location(w, -63.5, 9, -1182.5, -45, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -92.5, 14, -1079.5, -166, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -134.5, 9, -1131.5, -113, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -115, 12.5, -1187.5, -70, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -90.5, 9, -1171.5, 143, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -62.5, 9, -1138.5, -71, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -108.5, 11, -1150.5, -139, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -91.5, 10, -1205.5, -30, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -144.5, 10, -1165.5, -75, 0));
		StorageManager.SnowTownSpawns.add(new Location(w, -66.5, 10, -1098.5, -126, 0));
	}
	
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}
	
	private void addGlow(ItemStack[] stacks) {
		for (ItemStack stack : stacks) {
			if (stack != null) {
				// Only update those stacks that have our flag enchantment
				if (stack.getEnchantmentLevel(Enchantment.SILK_TOUCH) == 32) {
					NbtCompound compound = (NbtCompound) NbtFactory.fromItemTag(stack);
					compound.put(NbtFactory.ofList("ench"));
				}
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] a) {

			if(cmd.getName().equalsIgnoreCase("opmode")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(p.isOp()){
						if(PlayerManager.isInOPMode(p)){
							StorageManager.PlayerInOPMode.put(p, false);
							p.sendMessage(TAG + "Your §4§lOP Mode§7 is now §c§lDISABLED§7!");
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						}
						else{
							StorageManager.PlayerInOPMode.put(p, true);
							p.sendMessage(TAG + "Your §4§lOP Mode§7 is now §a§lENABLED§7!");
							p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
						}
					}
				}
			}
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
		
			if(sender instanceof Player){
				
				if(cmd.getName().equalsIgnoreCase("kit")){

					
				}
			}
			else{
				sender.sendMessage(TAG + "§7You can't perform commands through the console!");
			}
			
			if(cmd.getName().equalsIgnoreCase("servers")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
					p.openInventory(sinv.getServerSelectorInv(p, 1));
					
				}
			}
			if(cmd.getName().equalsIgnoreCase("perks")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(PlayerManager.isLoaded(p)){
						if(!StorageManager.Spectators.contains(p)){
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
							p.openInventory(CosmeticPerks.getCosmeticPerks(p));
						}
						else{
							p.sendMessage(Start.TAG + "§4§lDENIED§7! You can't use §6/perks§7 while §espectating§7!");
						}
					}
					else{
						PlayerManager.warnPlayerNotLoaded(p);
					}
				}
			}
			
		return false;
		
	}
	
    public static List<Block> getBlocksBetween(Location l1, Location l2)
    {
        List<Block> blocks = new ArrayList<Block>();
 
        int topBlockX = (l1.getBlockX() < l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
        int bottomBlockX = (l1.getBlockX() > l2.getBlockX() ? l2.getBlockX() : l1.getBlockX());
 
        int topBlockY = (l1.getBlockY() < l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
        int bottomBlockY = (l1.getBlockY() > l2.getBlockY() ? l2.getBlockY() : l1.getBlockY());
 
        int topBlockZ = (l1.getBlockZ() < l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
        int bottomBlockZ = (l1.getBlockZ() > l2.getBlockZ() ? l2.getBlockZ() : l1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = l1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
    }
}
