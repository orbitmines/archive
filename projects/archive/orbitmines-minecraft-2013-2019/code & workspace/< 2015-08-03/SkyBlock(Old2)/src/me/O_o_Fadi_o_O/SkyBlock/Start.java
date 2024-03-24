package me.O_o_Fadi_o_O.SkyBlock;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.O_o_Fadi_o_O.SkyBlock.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.SkyBlock.Inv.ServerSelector;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomCow;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomPig;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomSheep;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomSlime;
import me.O_o_Fadi_o_O.SkyBlock.NMS.CustomWolf;
import me.O_o_Fadi_o_O.SkyBlock.events.BreakEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.ClickEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.ClickEventENG;
import me.O_o_Fadi_o_O.SkyBlock.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.DamageByEntityEvent;
import me.O_o_Fadi_o_O.SkyBlock.events.EntityDamage;
import me.O_o_Fadi_o_O.SkyBlock.events.EntityInteractEvent;
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
import me.O_o_Fadi_o_O.SkyBlock.managers.ConfigManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.DatabaseManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.EmptyWorldGenerator;
import me.O_o_Fadi_o_O.SkyBlock.managers.IslandManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.PlayerManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.StorageManager;
import me.O_o_Fadi_o_O.SkyBlock.managers.VoteManager;
import me.O_o_Fadi_o_O.SkyBlock.utils.IslandRank;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Start extends JavaPlugin {
	
	public int i = 0;
	public int i2 = 0;
	public int i3 = 0;
	
	public int bi = 0;
	
	static Connection connection;
	
	public static String TAG = "§5§lSkyBlock §8| §7";
	
	public boolean GenerateSkyBlockWorld = true;
	
	public IslandCreator islandCreator = new IslandCreator(this);
	public JoinEvent joinEvent = new JoinEvent(this);
	ServerSelector sinv = new ServerSelector();
	
	public ChunkGenerator getDefaultWorldGenerator(String w, String id){
		
		return new EmptyWorldGenerator(this);
	}
	
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
		
		if(Bukkit.getServer().getPluginManager().isPluginEnabled("Multiverse-Core")) {
			
			for(World w : Bukkit.getWorlds()){
				
				if(w.getName().equals("SkyBlock")){
					GenerateSkyBlockWorld = false;
				}
			}
			if(GenerateSkyBlockWorld == true){
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mv create SkyBlock normal -g SkyBlock");
			}
		}
		
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
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEventENG(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityInteractEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
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
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		StorageManager.IslandsAmount = getConfig().getInt("Islands");
		
		// GATHER CHALLENGES
		StorageManager.Challenges.add("Cobblestone Generator");
		StorageManager.Challenges.add("Apples");
		StorageManager.Challenges.add("Jack the Lumberjack");
		
		StorageManager.Challenges.add("More Smoothness");
		StorageManager.Challenges.add("Fishing Time!");
		StorageManager.Challenges.add("Chop Chop");
		
		StorageManager.Challenges.add("Navigation");
		StorageManager.Challenges.add("Librarian");
		StorageManager.Challenges.add("The Dark Forest");
		
		StorageManager.Challenges.add("It's Time");
		StorageManager.Challenges.add("Stained Clay");
		
		StorageManager.Challenges.add("Sheep Shearing");
		StorageManager.Challenges.add("Windows");
		
		StorageManager.Challenges.add("Wood Factory");
		StorageManager.Challenges.add("Lucky Fishing");
		//
		
		// FARM CHALLENGES
		StorageManager.Challenges.add("Melons");
		StorageManager.Challenges.add("Halloween Party");
		StorageManager.Challenges.add("Sugarcane");
		
		StorageManager.Challenges.add("Melon Blocks?!");
		StorageManager.Challenges.add("Mushroom Hunting");
		StorageManager.Challenges.add("Bacon");
		
		StorageManager.Challenges.add("Rabbits");
		StorageManager.Challenges.add("Baker");
		StorageManager.Challenges.add("Potatoes");
		
		StorageManager.Challenges.add("Cookie Monster");
		StorageManager.Challenges.add("Cactus");
		
		StorageManager.Challenges.add("KFC Delivery");
		StorageManager.Challenges.add("Steak");
		
		StorageManager.Challenges.add("Grandmother's Kitchen");
		
		StorageManager.Challenges.add("Cakes");
		//
		
		// MOB CHALLENGES
		StorageManager.Challenges.add("Skeletons");
		StorageManager.Challenges.add("Arrows!");
		
		StorageManager.Challenges.add("Zombie Apocalypse");
		StorageManager.Challenges.add("Creepy Creeper");
		
		StorageManager.Challenges.add("Destroy the Webs!");
		StorageManager.Challenges.add("Spider Eyes");
		
		StorageManager.Challenges.add("Enderwoman");
		
		//
		if(ConfigManager.islands.contains("islands")){
			for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
				int IslandNumber = Integer.parseInt(s);
				
				StorageManager.IslandLocation.put(IslandNumber, IslandManager.getIslandLocation(IslandNumber));
				StorageManager.IslandMembers.put(IslandNumber, IslandManager.getIslandMembers(IslandNumber));
				StorageManager.IslandOwner.put(IslandNumber, IslandManager.getIslandOwner(IslandNumber));
				StorageManager.IslandCreatedDate.put(IslandNumber, IslandManager.getIslandCreatedDate(IslandNumber));
				StorageManager.IslandTeleportEnabled.put(IslandNumber, IslandManager.getIslandTeleportEnabled(IslandNumber));
			}
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadPlayerIslandInfo(p);
		}
		
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
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					ScoreboardManager sm = Bukkit.getScoreboardManager();
					Scoreboard b = sm.getNewScoreboard();

					Objective o = b.registerNewObjective("Test", "Test2");
					
					o.setDisplayName("§6§lOrbitMines");
					
					o.setDisplaySlot(DisplaySlot.SIDEBAR);
				
					Score score1 = o.getScore("");
					score1.setScore(9);

					Team omt = b.registerNewTeam("OMT");
					omt.setSuffix(" Tokens");
					@SuppressWarnings("deprecation")
					OfflinePlayer omt1 = getServer().getOfflinePlayer("§e§lOrbitMines");
					omt.addPlayer(omt1);
					
					Score score2 = o.getScore(omt1.getName());
					score2.setScore(8);

					if(StorageManager.omt.get(p.getName()) != null){
						Score score3 = o.getScore(" " + StorageManager.omt.get(p.getName()) + "  ");
						score3.setScore(7);
					}
					else{
						Score score3 = o.getScore(" " + "Loading..." + "  ");
						score3.setScore(7);
					}
				
					Score score4 = o.getScore(" ");
					score4.setScore(6);

					Score score5 = o.getScore("§b§lVIP Points");
					score5.setScore(5);

					if(StorageManager.points.get(p.getName()) != null){
						Score score6 = o.getScore(" " + StorageManager.points.get(p.getName()) + "");
						score6.setScore(4);
					}
					else{
						Score score6 = o.getScore(" " + "Loading..." + "");
						score6.setScore(4);
					}

					Score score7 = o.getScore("  ");
					score7.setScore(3);
					
					Team coin = b.registerNewTeam("Number");
					coin.setSuffix("Number");
					@SuppressWarnings("deprecation")
					OfflinePlayer coins1 = getServer().getOfflinePlayer("§d§lIsland ");
					coin.addPlayer(coins1);
					
					Score score8 = o.getScore(coins1.getName());
					score8.setScore(2);
					if(StorageManager.PlayersIslandNumber.get(p) != null){
						Score score9 = o.getScore(" " + StorageManager.PlayersIslandNumber.get(p) + " ");
						score9.setScore(1);
					}
					else{
						Score score9 = o.getScore(" /is h");
						score9.setScore(1);
					}
					Score score10 = o.getScore("   ");
					score10.setScore(0);
					
				
					Team IronVIP = b.registerNewTeam("IronVIP");
					IronVIP.setPrefix("§7§lIron §f");
					Team GoldVIP = b.registerNewTeam("GoldVIP");
					GoldVIP.setPrefix("§6§lGold §f");
					Team DiamondVIP = b.registerNewTeam("DiamondVIP");
					DiamondVIP.setPrefix("§9§lDiamond §f");
					Team EmeraldVIP = b.registerNewTeam("EmeraldVIP");
					EmeraldVIP.setPrefix("§a§lEmerald §f");
					Team Builder = b.registerNewTeam("Builder");
					Builder.setPrefix("§d§lBuilder §f");
					Team Moderator = b.registerNewTeam("Moderator");
					Moderator.setPrefix("§b§lMod §f");
					Team Owner = b.registerNewTeam("Owner");
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
					
					o.setDisplayName("§6§lOrbitMines§5§lSkyBlock");
					
					
					p.setScoreboard(b);
					
				}

			}
		}.runTaskTimer(this, 0, 100);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					if(StorageManager.ownerpets.containsKey(p)){
						UUID uuid = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = StorageManager.owners.get(uuid).getLocation();
											
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
			}
		}.runTaskTimer(this, 20, 3);
		
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
	}
	
	public void onDisable(){
		
	}
	
	public void setIslandAmount(int IslandAmount){
		StorageManager.IslandsAmount = IslandAmount;
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
				else if(a[0].equalsIgnoreCase("home") || a[0].equalsIgnoreCase("h")){
					
					if(PlayerManager.hasIsland(p)){
						if(!PlayerManager.isInTheVoid(p)){
							p.sendMessage(Start.TAG + "§7Teleporting to your §dIsland§7...");
							new BukkitRunnable(){
								public void run(){
									p.teleport(StorageManager.PlayersIslandHomeLocation.get(p));
									p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
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
							
							StorageManager.IslandLocation.put(IslandNumber, IslandManager.getIslandLocation(IslandNumber));
							StorageManager.IslandMembers.put(IslandNumber, IslandManager.getIslandMembers(IslandNumber));
							StorageManager.IslandOwner.put(IslandNumber, IslandManager.getIslandOwner(IslandNumber));
							StorageManager.IslandCreatedDate.put(IslandNumber, IslandManager.getIslandCreatedDate(IslandNumber));
							StorageManager.IslandTeleportEnabled.put(IslandNumber, IslandManager.getIslandTeleportEnabled(IslandNumber));
						}
						islandCreator.createIsland(StorageManager.IslandsAmount +1, p);
						for(Player player : Bukkit.getOnlinePlayers()){
							joinEvent.loadPlayerIslandInfo(player);
						}
					}
					
				}
				else if(a[0].equalsIgnoreCase("sethome") || a[0].equalsIgnoreCase("h")){
					if(PlayerManager.hasIsland(p)){
						if(PlayerManager.isOnOwnIsland(p)){
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
						if(StorageManager.PlayersIslandRank.get(p) == IslandRank.OWNER){
							if(a.length == 2){
							
								if(StorageManager.IslandMembers.get(StorageManager.PlayersIslandNumber.get(p)).size() != 9){
									Player p1 = null;
									for(Player player : Bukkit.getOnlinePlayers()){
										if(player.getName().equals(a[1])){
											p1 = player;
										}
									}
								
									
									if(p1 != null){
										int IslandNumber =  StorageManager.PlayersIslandNumber.get(p);
										List<String> members = StorageManager.IslandMembers.get(IslandNumber);
										if(!StorageManager.PlayerHasIsland.containsKey(p1)){
											p.sendMessage(Start.TAG + "§d" + a[1] + "§7 has been invited to your §dIsland§7!");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											StorageManager.PlayersIslandInvite.put(p1, IslandNumber);
											p1.sendMessage(Start.TAG + "§d" + p.getName() + "§7 has invited you to their §dIsland§7!");
											p1.sendMessage(Start.TAG + "Type §d/is accept§7 to §aAccept§7 or §d/is deny§7 to §cDeny§7.");
											p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											
											for(Player player : Bukkit.getOnlinePlayers()){
												if(members.contains(player.getName())){
													player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 invited §d" + a[1] + "§7 to your §dIsland§7!");
													player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												}
											}
										}
										else{
											if(StorageManager.PlayerHasIsland.get(p1) == false){
												p.sendMessage(Start.TAG + "§d" + a[1] + "§7 has been invited to your §dIsland§7!");
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												StorageManager.PlayersIslandInvite.put(p1, IslandNumber);
												p1.sendMessage(Start.TAG + "§d" + p.getName() + "§7 has invited you to their §dIsland§7!");
												p1.sendMessage(Start.TAG + "Type §d/is accept§7 to §aAccept§7 or §d/is deny§7 to §cDeny§7.");
												p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
												
												for(Player player : Bukkit.getOnlinePlayers()){
													if(members.contains(player.getName())){
														player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 invited §d" + a[1] + "§7 to your §dIsland§7!");
														player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
													}
												}
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
						if(StorageManager.PlayersIslandRank.get(p) == IslandRank.OWNER){
							if(a.length == 2){
								int IslandNumber = StorageManager.PlayersIslandNumber.get(p);
								
								if(!a[1].equals(p.getName())){
									if(StorageManager.IslandMembers.get(IslandNumber).contains(a[1])){
										
										List<String> members = StorageManager.IslandMembers.get(IslandNumber);
										members.remove(a[1]);
										IslandManager.setIslandMembers(IslandNumber, members);
										
										ConfigManager.playerdata.set("players." + a[1], null);
										ConfigManager.savePlayerdata();
										
										for(Player player : Bukkit.getOnlinePlayers()){
											if(members.contains(player.getName())){
												player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 removed §d" + a[1] + "§7 from your §dIsland§7!");
												player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
											}
											if(player.getName().equals(a[1])){
												StorageManager.PlayerHasIsland.put(player, false);
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
											
											StorageManager.IslandLocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
											StorageManager.IslandMembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
											StorageManager.IslandOwner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
											StorageManager.IslandCreatedDate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
											StorageManager.IslandTeleportEnabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
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
					if(StorageManager.PlayersIslandInvite.containsKey(p)){
						if(!PlayerManager.hasIsland(p)){
							int IslandNumber = StorageManager.PlayersIslandInvite.get(p);
							List<String> members = StorageManager.IslandMembers.get(IslandNumber);
							if(members.size() != 9){
								StorageManager.PlayerHasIsland.put(p, true);
								StorageManager.PlayersIslandInvite.remove(p);
								for(Player player : Bukkit.getOnlinePlayers()){
									if(members.contains(player.getName()) || StorageManager.IslandOwner.get(IslandNumber).equals(player.getName())){
										player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 joined your §dIsland§7!");
										player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
								}
								p.sendMessage(Start.TAG + "You joined §d" + StorageManager.IslandOwner.get(IslandNumber) + "s Island§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								IslandManager.setPlayersIslandNumber(p, IslandNumber);
								IslandManager.setPlayersIslandHomeLocation(p, IslandManager.getOfflinePlayersIslandHomeLocation(StorageManager.IslandOwner.get(IslandNumber)));
								IslandManager.setPlayersIslandRank(p, IslandRank.MEMBER);
								
								IslandManager.addIslandMember(IslandNumber, p);
								IslandManager.resetChallenges(p);
								
								clearInventory(p);
								p.sendMessage(Start.TAG + "§7Teleporting to your §dIsland§7...");
								new BukkitRunnable(){
									public void run(){
										p.teleport(StorageManager.PlayersIslandHomeLocation.get(p));
										p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
									}
								}.runTaskLater(this, 10);
								
								for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
									int IslandNumbers = Integer.parseInt(s);
									
									StorageManager.IslandLocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
									StorageManager.IslandMembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
									StorageManager.IslandOwner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
									StorageManager.IslandCreatedDate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
									StorageManager.IslandTeleportEnabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
								}
								for(Player player : Bukkit.getOnlinePlayers()){
									joinEvent.loadPlayerIslandInfo(player);
								}
							}
							else{
								p.sendMessage(Start.TAG + "§4§lDENIED§7 That §dIsland§7 reached the §aPlayer Limit§7!");
								StorageManager.PlayersIslandInvite.remove(p);
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
					if(StorageManager.PlayersIslandInvite.containsKey(p)){
						if(!PlayerManager.hasIsland(p)){
							int IslandNumber = StorageManager.PlayersIslandInvite.get(p);
							StorageManager.PlayersIslandInvite.remove(p);
							
							for(Player player : Bukkit.getOnlinePlayers()){
								if(StorageManager.IslandOwner.get(IslandNumber).equals(player.getName())){
									player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 denied your §dinvite§7!");
									player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
							}
							p.sendMessage(Start.TAG + "You denied §d" + StorageManager.IslandOwner.get(IslandNumber) + "s invite§7!");
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
						IslandRank rank = StorageManager.PlayersIslandRank.get(p);
						int IslandNumber = StorageManager.PlayersIslandNumber.get(p);
						List<String> members = StorageManager.IslandMembers.get(IslandNumber);
						if(rank == IslandRank.OWNER){
							if(members.size() == 0){
								
								ConfigManager.playerdata.set("players." + p.getName(), null);
								ConfigManager.savePlayerdata();
								
								
								StorageManager.PlayerHasIsland.put(p, false);
								p.chat("/spawn");
								clearInventory(p);
								p.sendMessage(Start.TAG + "You left your §dIsland§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
							}
							else{
								String pl = members.get(0);
								
								members.remove(pl);
								IslandManager.setIslandMembers(IslandNumber, members);
								IslandManager.setIslandOfflineOwner(IslandNumber, pl);
								IslandManager.setOfflinePlayersIslandRank(pl, IslandRank.OWNER);
								
								ConfigManager.playerdata.set("players." + p.getName(), null);
								ConfigManager.savePlayerdata();
								StorageManager.PlayerHasIsland.put(p, false);
								clearInventory(p);
								p.chat("/spawn");
								p.sendMessage(Start.TAG + "You left your §dIsland§7!");
								p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								
								
								for(Player player : Bukkit.getOnlinePlayers()){
									if(members.contains(player.getName())){
										player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 left your §dIsland§7!");
										player.sendMessage(Start.TAG + "§d" + pl + "§7 is now the §downer§7 of your §dIsland§7!");
										player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
									}
									if(player.getName().equals(StorageManager.IslandOwner.get(IslandNumber))){
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
								if(members.contains(player.getName()) || player.getName().equals(StorageManager.IslandOwner.get(IslandNumber))){
									player.sendMessage(Start.TAG + "§d" + p.getName() + "§7 left your §dIsland§7!");
									player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
								}
							}
							StorageManager.PlayerHasIsland.put(p, false);
							p.chat("/spawn");
							clearInventory(p);
							p.sendMessage(Start.TAG + "You left your §dIsland§7!");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
						}
						
						for(String s : ConfigManager.islands.getConfigurationSection("islands").getKeys(false)){
							int IslandNumbers = Integer.parseInt(s);
							
							StorageManager.IslandLocation.put(IslandNumbers, IslandManager.getIslandLocation(IslandNumbers));
							StorageManager.IslandMembers.put(IslandNumbers, IslandManager.getIslandMembers(IslandNumbers));
							StorageManager.IslandOwner.put(IslandNumbers, IslandManager.getIslandOwner(IslandNumbers));
							StorageManager.IslandCreatedDate.put(IslandNumbers, IslandManager.getIslandCreatedDate(IslandNumbers));
							StorageManager.IslandTeleportEnabled.put(IslandNumbers, IslandManager.getIslandTeleportEnabled(IslandNumbers));
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
								int IslandNumber = StorageManager.PlayersIslandNumber.get(p1);
								if(StorageManager.IslandTeleportEnabled.get(IslandNumber) == true){
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
				p1.teleport(StorageManager.PlayersIslandHomeLocation.get(p2));
				p1.playSound(p1.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
			}
		}.runTaskLater(this, 10);
	}

}
