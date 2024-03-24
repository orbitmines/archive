package me.O_o_Fadi_o_O.KitPvP;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.O_o_Fadi_o_O.KitPvP.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.KitPvP.Inv.ServerSelector;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomPig;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSheep;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSlime;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomWolf;
import me.O_o_Fadi_o_O.KitPvP.events.BowShot;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent;
import me.O_o_Fadi_o_O.KitPvP.events.ClickEvent2;
import me.O_o_Fadi_o_O.KitPvP.events.CommandPreprocessEvent;
import me.O_o_Fadi_o_O.KitPvP.events.DamageEvent;
import me.O_o_Fadi_o_O.KitPvP.events.DeathEvent;
import me.O_o_Fadi_o_O.KitPvP.events.EXPPickup;
import me.O_o_Fadi_o_O.KitPvP.events.EntityDamage;
import me.O_o_Fadi_o_O.KitPvP.events.ExplodeEvent;
import me.O_o_Fadi_o_O.KitPvP.events.InventoryClick;
import me.O_o_Fadi_o_O.KitPvP.events.JoinEvent;
import me.O_o_Fadi_o_O.KitPvP.events.PlayerChat;
import me.O_o_Fadi_o_O.KitPvP.events.PlayerMove;
import me.O_o_Fadi_o_O.KitPvP.events.QuitEvent;
import me.O_o_Fadi_o_O.KitPvP.events.SignsColor;
import me.O_o_Fadi_o_O.KitPvP.events.VoteEvent;
import me.O_o_Fadi_o_O.KitPvP.managers.ConfigManager;
import me.O_o_Fadi_o_O.KitPvP.managers.DatabaseManager;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.VoteManager;
import me.confuser.barapi.BarAPI;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Start extends JavaPlugin implements Listener {
	
	public int i = 0;
	public int i2 = 0;
	public int i3 = 0;
	
	public int bi = 0;
	
	ServerSelector sinv = new ServerSelector();
	
	public static boolean FreeKitEnabled = false;
	
	public static String TAG = "§c§lKitPvP §8|§7 ";;
	
	static Connection connection;
	
	private KitSelector kitselector = new KitSelector(this);
	public JoinEvent joinEvent = new JoinEvent(this);
	
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
		
		setupPermissions();
		setupChat();
		setupEconomy();

		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new BowShot(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
		getServer().getPluginManager().registerEvents(new ClickEvent2(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
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
		
		FreeKitEnabled = getConfig().getBoolean("FreeKitEnabled");
		
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
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					onScoreboard(p);
					
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
					if(StorageManager.ownerpets.containsKey(p)){
						UUID uuid = StorageManager.ownerpets.get(p);
						if(StorageManager.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = StorageManager.owners.get(uuid).getLocation();
											
											if(ClickEvent.getDistance(l, ent.getLocation()) < 20){
												ClickEvent.navigate(ent, l, 1.2);
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
				
				DatabaseManager.openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			joinEvent.loadAfter5Seconds(p);
		}
	}
	
	public void onDisable(){
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
	
	
	public static void RandomSpawn(Player p){
		
        Random Lightning = new Random();
        int LightningInt;
        
        for(int LightningCount = 1; LightningCount <= 1; LightningCount++){
        	LightningInt = 1 + Lightning.nextInt(7);
        	
        	if(LightningInt == 1){
        		p.teleport(new Location(p.getWorld(), 824, 5, 485));
        	}
        	else if(LightningInt == 2){
        		p.teleport(new Location(p.getWorld(), 796, 5, 509));
        	}
        	else if(LightningInt == 3){
        		p.teleport(new Location(p.getWorld(), 788, 5, 466));
        	}
        	else if(LightningInt == 4){
        		p.teleport(new Location(p.getWorld(), 811, 9, 450));
        	}
        	else if(LightningInt == 5){
        		p.teleport(new Location(p.getWorld(), 853, 13, 494));
        	}
        	else if(LightningInt == 6){
        		p.teleport(new Location(p.getWorld(), 825, 5, 522));
        	}
        	else if(LightningInt == 7){
        		p.teleport(new Location(p.getWorld(), 768, 5, 502));
        	}
        }
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] a) {

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
				
				Player p = (Player)sender;
				if(cmd.getName().equalsIgnoreCase("kit")){
					p.sendMessage(Start.TAG + "Opening the Kit Selector...");
					p.openInventory(kitselector.getKitSelector(p));
					
				}
				if(cmd.getName().equalsIgnoreCase("kitpvp")){
					if(p.hasPermission("KitPvP.Admin")){
						
						if(a.length == 0){
							p.sendMessage(TAG + "§cIncorrect Use!");
						}
						else if(a[0].equalsIgnoreCase("togglefreekit")){
							
							
							if(FreeKitEnabled == true){
								
								getConfig().set("FreeKitEnabled", false);
								saveConfig();
								FreeKitEnabled = false;
							}
							else if(FreeKitEnabled == false){
								
								getConfig().set("FreeKitEnabled", true);
								saveConfig();
								FreeKitEnabled = true;
							}
							
						}
						else{
							p.sendMessage(TAG + "§cIncorrect Use!");
						}
						
					}
					else{
						p.sendMessage(TAG + "§cAccess Denied!");
					}
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
	
	public void onScoreboard(Player p){
		
		ScoreboardManager s = Bukkit.getScoreboardManager();
		Scoreboard b = s.getNewScoreboard();
		
		Objective o = b.registerNewObjective("Test", "Test2");
		o.setDisplayName("§c§lKitPvP");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		try{
			Score score = o.getScore(("§4§lDeaths:"));
			score.setScore(StorageManager.deaths.get(p.getName()));
			
			Score score1 = o.getScore(("§c§lKills:"));
			score1.setScore(StorageManager.kills.get(p.getName()));
			
			Score score2 = o.getScore(("§6§lCoins:"));
			score2.setScore(StorageManager.money.get(p.getName()));
			
			Score score3 = o.getScore(("§a§lOnline:"));
			score3.setScore(Bukkit.getOnlinePlayers().length);
			
			Score score4 = o.getScore(("§e§lTokens:"));
			score4.setScore(StorageManager.omt.get(p.getName()));
			
			Score score5 = o.getScore(("§b§lVIP Points:"));
			score5.setScore(StorageManager.points.get(p.getName()));
		}catch(Exception ex){
			
		}
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
		
		o.setDisplayName("§6§lOrbitMines§c§lKitPvP");
		
		p.setScoreboard(b);
		
	}
	
	// VAULT SETUP
	public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        
        return (economy != null);
    }
}
