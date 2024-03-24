package me.O_o_Fadi_o_O.Prison;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import me.O_o_Fadi_o_O.Prison.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Prison.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Prison.NMS.CustomCow;
import me.O_o_Fadi_o_O.Prison.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.Prison.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.Prison.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.Prison.NMS.CustomPig;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSheep;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSlime;
import me.O_o_Fadi_o_O.Prison.NMS.CustomWolf;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomSkeleton;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomVillager;
import me.O_o_Fadi_o_O.Prison.NMS.Prison.CustomZombie;
import me.O_o_Fadi_o_O.Prison.events.BreakEvent;
import me.O_o_Fadi_o_O.Prison.events.ChunkUnload;
import me.O_o_Fadi_o_O.Prison.events.ClickEventENG;
import me.O_o_Fadi_o_O.Prison.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.Prison.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.Prison.events.EntityDamage;
import me.O_o_Fadi_o_O.Prison.events.EntityInteractEvent;
import me.O_o_Fadi_o_O.Prison.events.JoinEvent;
import me.O_o_Fadi_o_O.Prison.events.PlaceEvent;
import me.O_o_Fadi_o_O.Prison.events.PlayerChat;
import me.O_o_Fadi_o_O.Prison.events.PlayerInteract;
import me.O_o_Fadi_o_O.Prison.events.PlayerMove;
import me.O_o_Fadi_o_O.Prison.events.QuitEvent;
import me.O_o_Fadi_o_O.Prison.events.SignsEvent;
import me.O_o_Fadi_o_O.Prison.managers.ConfigManager;
import me.O_o_Fadi_o_O.Prison.managers.DatabaseManager;
import me.O_o_Fadi_o_O.Prison.managers.NPCManager;
import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.Prison;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import me.O_o_Fadi_o_O.Prison.managers.VoteManager;
import me.O_o_Fadi_o_O.Prison.prisonInv.Shop;
import me.O_o_Fadi_o_O.Prison.runnables.ChestRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.EntityRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.GambleRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.MineRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.RankLettersRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.SignRunnable;
import me.O_o_Fadi_o_O.Prison.runnables.WoodmenRunnable;
import me.O_o_Fadi_o_O.Prison.utils.EntityHider;
import me.O_o_Fadi_o_O.Prison.utils.EntityHider.Policy;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import com.google.common.collect.MapMaker;

public class Start extends JavaPlugin {
	
	public static ConcurrentMap<Player, Location> editing = new MapMaker().weakKeys().makeMap();
	
	public int i = 0;
	public int i2 = 0;
	public int i3 = 0;
	
	public int bi = 0;
	
	public static EntityHider entityHider;
	static Connection connection;
	
	public static String TAG = "§4§lPrison §8| §7";
	
	public JoinEvent joinEvent = new JoinEvent(this);
	ServerSelector sinv = new ServerSelector();
	ChestRunnable chestRunnable = new ChestRunnable(this);
	RankLettersRunnable ranklettersRunnable = new RankLettersRunnable(this);
	EntityRunnable entityRunnable = new EntityRunnable(this);
	WoodmenRunnable woodmenRunnable = new WoodmenRunnable(this);
	SignRunnable signRunnable = new SignRunnable(this);
	MineRunnable mineRunnable = new MineRunnable(this);
	GambleRunnable gambleRunnable = new GambleRunnable(this);
	
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
		
		entityHider = new EntityHider(this, Policy.BLACKLIST);;
		
		addCustomEntity(CustomMushroomCow.class, "CustomMushroomCow", 96);
		addCustomEntity(CustomPig.class, "CustomPig", 90);
		addCustomEntity(CustomWolf.class, "CustomWolf", 95);
		addCustomEntity(CustomSheep.class, "CustomSheep", 91);
		addCustomEntity(CustomMagmaCube.class, "CustomMagmaCube", 62);
		addCustomEntity(CustomSlime.class, "CustomSlime", 55);
		addCustomEntity(CustomCow.class, "CustomCow", 92);
		addCustomEntity(CustomSilverfish.class, "CustomSilverfish", 60);
		addCustomEntity(CustomOcelot.class, "CustomOcelot", 98);
		addCustomEntity(CustomSkeleton.class, "CustomSkeleton", 51);
		addCustomEntity(CustomZombie.class, "CustomZombie", 54);
		addCustomEntity(CustomVillager.class, "CustomVillager", 120);
		
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
						// You can also get the location of the sound effect -
				        // see PacketWrapper's WrapperPlayServerNamedSoundEffect
				        String soundName = e.getPacket().getStrings().read(0);
				        e.setCancelled(soundName.startsWith("mob.skeleton"));
				    }
				});
		
		try{
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					if(en instanceof Player){
						
					}
					else{
						en.remove();
					}
				}
			}
		}catch(Exception ex){
			
		}
		
		ConfigManager.setup(this);
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEventENG(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChunkUnload(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SignsEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
		
		//Prison.setMineLocation(StorageManager.PrisonWorld, Rank.UPlus);
		Prison.getAllMineLocations(StorageManager.PrisonWorld);
		
		Prison.registerAllRankLocations(StorageManager.PrisonWorld);
		Prison.registerAllMineCountdownLocation(StorageManager.PrisonWorld);
		Prison.registerAllMineCountdowns(StorageManager.PrisonWorld);
		Prison.registerAllWoodmenBlocks(StorageManager.PrisonWorld);
		Prison.registerAllWoodmenLocations(StorageManager.PrisonWorld);
		Prison.registerAllRankBlocks(StorageManager.PrisonWorld);
		Prison.registerAllSignBlocks(StorageManager.PrisonWorld);
		NPCManager.spawnAllSkeletons(StorageManager.PrisonWorld);
		NPCManager.spawnAllWoodmen(StorageManager.PrisonWorld);
		NPCManager.spawnAllVillager(StorageManager.PrisonWorld);
		
		chestRunnable.startChestRunnable();
		ranklettersRunnable.startRankLetterRunnable();
		entityRunnable.startEntityRunnable();
		woodmenRunnable.startWoodmenRunnable();
		signRunnable.startSignRunnable();
		mineRunnable.startMineRunnable();
		gambleRunnable.startGambleRunnable();
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					if(!BarAPI.hasBar(p)){
						
						if(bi == 0){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!", 10);
							bi++;
						}
						else if(bi == 1){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.omt.get(p.getName()) + "§6 OMT", 10);
							bi++;
						}
						else if(bi == 2){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com", 10);
							bi++;
						}
						else if(bi == 3){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com", 10);
							bi++;
						}
						else if(bi == 4){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.points.get(p.getName()) + "§6 VIP Points", 10);
							bi++;
						}
						else if(bi == 5){
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(p.getName()) + "§6 Votes", 10);
							bi = 0;
						}
					}
				}

			}
		}.runTaskTimer(this, 0, 20);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				Bukkit.broadcastMessage("§4§lPrison §8| §6This is an §e§lAlpha Stage§6 of the new Plugin! It's not done yet! Please report any bugs to our §e§lStaff§6!");

			}
		}.runTaskTimer(this, 0, 800);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					PlayerScoreboard.onScoreboard(p);
				}

			}
		}.runTaskTimer(this, 0, 100);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.PlayersGambling.containsKey(p)){
						int Seconds = StorageManager.PlayerGamblingSeconds.get(p);
						StorageManager.PlayerGamblingSeconds.put(p, Seconds +1);
					}
				}
			}
		}.runTaskTimer(this, 0, 20);
		
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
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
		
		Prison.resetAllMines(false);
		
	}
	
	public void onDisable(){
		for(Block c : StorageManager.rareChests){
			if(StorageManager.rareChestHolograms.containsKey(c)){
				StorageManager.rareChestHolograms.remove(c);
			}
		}
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
	
	public static void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}
	
	public static void showTeleportNPCs(Player p){
		if(StorageManager.PlayerRank.get(p) != null){
			List<Rank> passedRanks = PlayerManager.getAllRanksPassed(p);
			
			for(Rank rank : Rank.values()){
				if(passedRanks.contains(rank)){
					entityHider.showEntity(p, StorageManager.RankTeleportNPCs.get(rank));
				}
				else{
					entityHider.hideEntity(p, StorageManager.RankTeleportNPCs.get(rank));
				}
			}
		}
	}
	
	public static void showRankupNPCs(Player p){
		if(StorageManager.PlayerRank.get(p) != null){
			Rank nextRank = PlayerManager.getRankupRank(p);
			entityHider.showEntity(p, StorageManager.RankupNPCs.get(nextRank));
			
			for(Rank rank : Rank.values()){
				if(rank != Rank.Z){
					if(nextRank != rank){entityHider.hideEntity(p, StorageManager.RankupNPCs.get(rank));}
					if(StorageManager.PlayerRank.get(p) == rank){entityHider.hideEntity(p, StorageManager.RankupNPCs.get(rank));}
				}
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {

		if(cmd.getName().equalsIgnoreCase("staffhelp")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("Rank.Owner") || p.hasPermission("Rank.Moderator")){
					p.sendMessage("");
					p.sendMessage("§6§lOrbitMines§4§lPrison §e§lStaff Commands:");
					p.sendMessage(" §7- §6/opmode §7(Switch §4§lOP Mode§7)");
					p.sendMessage(" §7- §6/gold give <player> <amount> §7(Give §6§lGold§7)");
					p.sendMessage(" §7- §6/gold remove <player> <amount> §7(Remove §6§lGold§7)");
					p.sendMessage(" §7- §6/gold view <player> §7(Show a Player's §6§lGold§7)");
					p.sendMessage(" §7- §6/gtickets give <player> <amount> §7(Give §aGamble Tickets§7)");
					p.sendMessage(" §7- §6/gtickets view <player> §7(Show a Player's §aGamble Tickets§7)");
					p.sendMessage(" §7- §6/rarechest give <player> §7(Give a Player a §cRare Chest§7)");
				}
				else{
					p.sendMessage(TAG + "§4§lDENIED§7! You have to be a §b§lModerator§7 to view this!");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("gtickets") || cmd.getName().equalsIgnoreCase("gambletickets")){}
		if(cmd.getName().equalsIgnoreCase("rarechest")){}
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
		
		if(cmd.getName().equalsIgnoreCase("money") || cmd.getName().equalsIgnoreCase("gold")){
			
		}
		if(cmd.getName().equalsIgnoreCase("shop")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				Shop.openShopInv(p);
			}
		}
		if(cmd.getName().equalsIgnoreCase("pay")){
			
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
				
				if(a.length == 2){
					
					if(a[0].equalsIgnoreCase("add")){
						
						Player player = null;
						
						for(Player p : Bukkit.getOnlinePlayers()){
							
							if(p.getName().equals(a[1])){
								player = p;
							}
						}
						
						if(player != null){
							
							VoteManager.registerVote(player);
							
						}
						else{
							sender.sendMessage("Player " + a[1] + " not Found!");
						}
						
					}
				}
				else{
					sender.sendMessage("Incorrect Use!");
				}
				
			}
			else{
				sender.sendMessage("§6§lOrbitMines§b§lVote §8| §7Your Total Votes this Month: §b§l" + StorageManager.votes.get(sender.getName()));
			}
		}
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
				sender.sendMessage("§e§lOMT §8| §7Your OMT balance: §e§l" + StorageManager.omt.get(sender.getName()));
			}
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
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
					p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				}
				else{
					PlayerManager.warnPlayerNotLoaded(p);
				}
			}
		}
		return false;
	}
}
