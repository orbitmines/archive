package me.O_o_Fadi_o_O.Creative;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

import me.O_o_Fadi_o_O.Creative.Inv.CosmeticPerks;
import me.O_o_Fadi_o_O.Creative.Inv.ServerSelector;
import me.O_o_Fadi_o_O.Creative.Inv.VIPPoints;
import me.O_o_Fadi_o_O.Creative.events.ClickEvent;
import me.O_o_Fadi_o_O.Creative.events.DamageByEntity;
import me.O_o_Fadi_o_O.Creative.events.EntityDamage;
import me.O_o_Fadi_o_O.Creative.events.JoinEvent;
import me.O_o_Fadi_o_O.Creative.events.PlayerChat;
import me.O_o_Fadi_o_O.Creative.events.PlayerMove;
import me.O_o_Fadi_o_O.Creative.events.QuitEvent;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Start extends JavaPlugin {
	
	public static HashMap<Player, String> chatcolor = new HashMap<Player, String>();
	public static HashMap<Player, String> trail = new HashMap<Player, String>();
	
	public static HashMap<String, Integer> omt = new HashMap<String, Integer>();
	public static HashMap<String, Integer> points = new HashMap<String, Integer>();
	public static HashMap<String, Integer> coins = new HashMap<String, Integer>();
	
	public static HashMap<String, String> mushroomcow = new HashMap<String, String>();
	public static HashMap<String, String> pig = new HashMap<String, String>();
	public static HashMap<String, String> wolf = new HashMap<String, String>();
	public static HashMap<String, String> sheep = new HashMap<String, String>();
	public static HashMap<String, String> horse = new HashMap<String, String>();
	public static HashMap<String, String> magmacube = new HashMap<String, String>();
	public static HashMap<String, String> slime = new HashMap<String, String>();
	public static HashMap<String, String> cow = new HashMap<String, String>();
	public static HashMap<String, String> silverfish = new HashMap<String, String>();
	public static HashMap<String, String> ocelot = new HashMap<String, String>();
	
	public static HashMap<String, Integer> white = new HashMap<String, Integer>();
	public static HashMap<String, Integer> blue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> green = new HashMap<String, Integer>();
	public static HashMap<String, Integer> black = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lightblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> pink = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lightgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> darkblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> purple = new HashMap<String, Integer>();
	public static HashMap<String, Integer> orange = new HashMap<String, Integer>();
	public static HashMap<String, Integer> red = new HashMap<String, Integer>();
	public static HashMap<String, Integer> cyan = new HashMap<String, Integer>();
	public static HashMap<String, Integer> yellow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gray = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> chatcolorwhite = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkred = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorblack = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorlightblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorpink = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorlightgreen = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkblue = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolorred = new HashMap<String, Integer>();
	public static HashMap<String, Integer> chatcolordarkgray = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> trailsfirework = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailshappyvillager = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailshearts = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsexplode = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsslime = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailssmoke = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailswitch = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailscrit = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailswater = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsnote = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailssnow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsenchantmenttable = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsbubbles = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsangryvillager = new HashMap<String, Integer>();
	public static HashMap<String, Integer> trailsmobspawner = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> hatsStoneBricks = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGreenGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCactus = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsSnow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsTNT = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCoalOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsBlackGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsFurnace = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsQuartzOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsHayBale = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedstoneOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsIce = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsWorkbench = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGrass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsBedrock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLapisOre = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsRedstoneBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsQuartzBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLapisBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMagentaGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsCoalBlock = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMelon = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsYellowGlass = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsMycelium = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsLeaves = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hatsOrangeGlass = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> disWitch = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disBat = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disChicken = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disOcelot = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disMushroomCow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSquid = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSlime = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disZombiePigman = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disMagmaCube = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSkeleton = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCow = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disWolf = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSpider = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSilverfish = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disSheep = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCaveSpider = new HashMap<String, Integer>();
	public static HashMap<String, Integer> disCreeper = new HashMap<String, Integer>();
	
	public static HashMap<UUID, Player> owners = new HashMap<UUID, Player>();
	public static HashMap<Player, UUID> ownerpets = new HashMap<Player, UUID>();
	
	public int i = 0;
	public int i2 = 0;
	public int i3 = 0;
	
	public int bi = 0;
	
	private String getquery = "";
	private String containsquery = "";
	static Connection connection;
	
	ServerSelector sinv = new ServerSelector();
	
	public void onEnable(){
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageByEntity(), this);
		
		new BukkitRunnable(){

			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()){
					
					ScoreboardManager sm = Bukkit.getScoreboardManager();
					Scoreboard b = sm.getNewScoreboard();

					Objective o = b.registerNewObjective("Test", "Test2");
					
					o.setDisplayName("§d§lCreative");
					
					o.setDisplaySlot(DisplaySlot.SIDEBAR);
				
					Score score1 = o.getScore("");
					score1.setScore(6);

					Score score2 = o.getScore("§e§lTokens");
					score2.setScore(5);

					Score score3 = o.getScore(" " + Start.omt.get(p.getName()) + "  ");
					score3.setScore(4);
				
					Score score4 = o.getScore(" ");
					score4.setScore(3);

					Score score5 = o.getScore("§b§lVIP Points");
					score5.setScore(2);

					Score score6 = o.getScore(" " + Start.points.get(p.getName()) + "");
					score6.setScore(1);

					Score score7 = o.getScore("  ");
					score7.setScore(0);
					
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
					
					p.setScoreboard(b);
					
				}

			}
		}.runTaskTimer(this, 0, 100);
		
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
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + Start.omt.get(p.getName()) + "§6 OMT", 10);
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
							BarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + Start.points.get(p.getName()) + "§6 VIP Points", 10);
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
					if(Start.ownerpets.containsKey(p)){
						UUID uuid = Start.ownerpets.get(p);
						if(Start.owners.containsKey(uuid)){
							for(World w : Bukkit.getWorlds()){
								for(Entity en : w.getEntities()){
									if(en.getUniqueId() == uuid){
										if(en instanceof LivingEntity){
											LivingEntity ent = (LivingEntity) en;
											Location l = Start.owners.get(uuid).getLocation();
											
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
				
				openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
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
				
				i++;
					
				VIPPoints.getVIPPoints1(VIPPoints.inv, i);
				VIPPoints.getVIPPoints5(VIPPoints.inv, i);
				VIPPoints.getVIPPoints10(VIPPoints.inv, i);
				VIPPoints.getVIPPoints25(VIPPoints.inv, i);
				
				if(i == 5){
					i = 0;
				}
				
			}
		}.runTaskTimer(this, 0, 20);
	}
	
	public void onDisable(){
		try{
			for(World w : Bukkit.getWorlds()){
				for(Entity en : w.getEntities()){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(Start.ownerpets.containsKey(p)){
							if(en.getUniqueId() == Start.ownerpets.get(p)){
								if(en instanceof LivingEntity){
									en.remove();
									Start.owners.remove(Start.ownerpets.get(p));
									Start.ownerpets.remove(p);
								}
							}
						}
					}
				}
			}
		}catch(Exception ex){
			
		}
	}
	
	public synchronized void openConnection(){
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public boolean containsPath(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public synchronized void insertPath(String player, String Table, String column, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + column + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean containsHats(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public boolean containsDisguises(String name, String Table, String player){

		containsquery = "SELECT `" + name + "` FROM `" + Table + "` WHERE `" + name + "`='" + player + "'";
		
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public boolean containsElement(String field, String Type, String player){
		if(Type.equals("CHATCOLOR")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("OMT")){
			containsquery = "SELECT `" + field + "` FROM `OrbitMinesTokens` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("POINTS")){
			containsquery = "SELECT `" + field + "` FROM `VIPPoints` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("MUSHROOMCOW")){
			containsquery = "SELECT `" + field + "` FROM `Pets-MushroomCow` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("PIG")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Pig` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("WOLF")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Wolf` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("SHEEP")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Sheep` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("HORSE")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Horse` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("MAGMACUBE")){
			containsquery = "SELECT `" + field + "` FROM `Pets-MagmaCube` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("SLIME")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Slime` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("COW")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Cow` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("SILVERFISH")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Silverfish` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("OCELOT")){
			containsquery = "SELECT `" + field + "` FROM `Pets-Ocelot` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("WHITE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-White` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("BLUE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Blue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("GREEN")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Green` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("BLACK")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Black` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("LIGHTBLUE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-LightBlue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("PINK")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Pink` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("LIGHTGREEN")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-LightGreen` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("DARKBLUE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-DarkBlue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("PURPLE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Purple` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("ORANGE")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Orange` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("RED")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Red` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CYAN")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Cyan` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("YELLOW")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Yellow` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("GRAY")){
			containsquery = "SELECT `" + field + "` FROM `Wardrobe-Gray` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORDARKRED")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-DarkRed` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORLIGHTGREEN")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-LightGreen` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORDARKGRAY")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-DarkGray` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORRED")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-Red` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORWHITE")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-White` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORLIGHTBLUE")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-LightBlue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORPINK")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-Pink` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORBLUE")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-Blue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORDARKBLUE")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-DarkBlue` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORDARKGREEN")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-DarkGreen` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("CHATCOLORBLACK")){
			containsquery = "SELECT `" + field + "` FROM `ChatColors-Black` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSANGRYVILLAGER")){
			containsquery = "SELECT `" + field + "` FROM `Trails-AngryVillager` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSBUBBLE")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Bubble` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSCRIT")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Crit` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSETABLE")){
			containsquery = "SELECT `" + field + "` FROM `Trails-ETable` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSEXPLODE")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Explode` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSFIREWORK")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Firework` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSHAPPYVILLAGER")){
			containsquery = "SELECT `" + field + "` FROM `Trails-HappyVillager` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSHEARTS")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Hearts` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSMOBSPAWNER")){
			containsquery = "SELECT `" + field + "` FROM `Trails-MobSpawner` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSMUSIC")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Music` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSSLIME")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Slime` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSSMOKE")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Smoke` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSSNOW")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Snow` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSWATER")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Water` WHERE `" + field + "`='" + player + "'";
		}
		if(Type.equals("TRAILSWITCH")){
			containsquery = "SELECT `" + field + "` FROM `Trails-Witch` WHERE `" + field + "`='" + player + "'";
		}
		try {
			ResultSet rs = connection.prepareStatement(containsquery).executeQuery();
			
			boolean temp = rs.next();
			rs.close();
			return temp;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return true;
		}
	}
	public synchronized void insertHats(String player, String Table, String hat, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + hat + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void insertDisguises(String player, String Table, String disguise, int i){

		getquery = "INSERT INTO `" + Table + "` (`name`, `" + disguise + "`) VALUES ('" + player + "', '" + i + "')";
		
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void insertColorCode(String player, String Type, String stats){

		if(Type.equals("CHATCOLOR")){
			getquery = "INSERT INTO `ChatColors` (`name`, `color`) VALUES ('" + player + "', '" + stats + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public synchronized void insertElement(String player, String Type, int stats){
		if(Type.equals("OMT")){
			getquery = "INSERT INTO `OrbitMinesTokens` (`name`, `omt`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("POINTS")){
			getquery = "INSERT INTO `VIPPoints` (`name`, `points`) VALUES ('" + player + "', '" + stats + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public synchronized void insertTrail(String player, String Type, int stats){
		if(Type.equals("ANGRYVILLAGER")){
			getquery = "INSERT INTO `Trails-AngryVillager` (`name`, `angryvillager`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("BUBBLE")){
			getquery = "INSERT INTO `Trails-Bubble` (`name`, `bubble`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("CRIT")){
			getquery = "INSERT INTO `Trails-Crit` (`name`, `crit`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("ETABLE")){
			getquery = "INSERT INTO `Trails-ETable` (`name`, `etable`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("EXPLODE")){
			getquery = "INSERT INTO `Trails-Explode` (`name`, `explode`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("FIREWORK")){
			getquery = "INSERT INTO `Trails-Firework` (`name`, `firework`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("HAPPYVILLAGER")){
			getquery = "INSERT INTO `Trails-HappyVillager` (`name`, `happyvillager`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("HEARTS")){
			getquery = "INSERT INTO `Trails-Hearts` (`name`, `hearts`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("MOBSPAWNER")){
			getquery = "INSERT INTO `Trails-MobSpawner` (`name`, `mobspawner`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("MUSIC")){
			getquery = "INSERT INTO `Trails-Music` (`name`, `music`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("SLIME")){
			getquery = "INSERT INTO `Trails-Slime` (`name`, `slime`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("SMOKE")){
			getquery = "INSERT INTO `Trails-Smoke` (`name`, `smoke`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("SNOW")){
			getquery = "INSERT INTO `Trails-Snow` (`name`, `snow`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("WATER")){
			getquery = "INSERT INTO `Trails-Water` (`name`, `water`) VALUES ('" + player + "', '" + stats + "')";
		}
		if(Type.equals("WITCH")){
			getquery = "INSERT INTO `Trails-Witch` (`name`, `witch`) VALUES ('" + player + "', '" + stats + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public synchronized void insertPets(String player, String Type, String petname){
		if(Type.equals("MUSHROOMCOW")){
			getquery = "INSERT INTO `Pets-MushroomCow` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("PIG")){
			getquery = "INSERT INTO `Pets-Pig` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("WOLF")){
			getquery = "INSERT INTO `Pets-Wolf` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("SHEEP")){
			getquery = "INSERT INTO `Pets-Sheep` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("HORSE")){
			getquery = "INSERT INTO `Pets-Horse` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("MAGMACUBE")){
			getquery = "INSERT INTO `Pets-MagmaCube` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("SLIME")){
			getquery = "INSERT INTO `Pets-Slime` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("COW")){
			getquery = "INSERT INTO `Pets-Cow` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("SILVERFISH")){
			getquery = "INSERT INTO `Pets-Silverfish` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		if(Type.equals("OCELOT")){
			getquery = "INSERT INTO `Pets-Ocelot` (`name`, `petname`) VALUES ('" + player + "', '" + petname + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void insertChatColors(String player, String Type, int yes){
		if(Type.equals("DARKRED")){
			getquery = "INSERT INTO `ChatColors-DarkRed` (`name`, `darkred`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("LIGHTGREEN")){
			getquery = "INSERT INTO `ChatColors-LightGreen` (`name`, `lightgreen`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("DARKGRAY")){
			getquery = "INSERT INTO `ChatColors-DarkGray` (`name`, `darkgray`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("RED")){
			getquery = "INSERT INTO `ChatColors-Red` (`name`, `red`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("WHITE")){
			getquery = "INSERT INTO `ChatColors-White` (`name`, `white`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("LIGHTBLUE")){
			getquery = "INSERT INTO `ChatColors-LightBlue` (`name`, `lightblue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("PINK")){
			getquery = "INSERT INTO `ChatColors-Pink` (`name`, `pink`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("BLUE")){
			getquery = "INSERT INTO `ChatColors-Blue` (`name`, `blue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("DARKBLUE")){
			getquery = "INSERT INTO `ChatColors-DarkBlue` (`name`, `darkblue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("GREEN")){
			getquery = "INSERT INTO `ChatColors-Green` (`name`, `green`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("BLACK")){
			getquery = "INSERT INTO `ChatColors-Black` (`name`, `black`) VALUES ('" + player + "', '" + yes + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void insertWardrobe(String player, String Type, int yes){
		if(Type.equals("WHITE")){
			getquery = "INSERT INTO `Wardrobe-White` (`name`, `white`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("BLUE")){
			getquery = "INSERT INTO `Wardrobe-Blue` (`name`, `blue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("GREEN")){
			getquery = "INSERT INTO `Wardrobe-Green` (`name`, `green`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("BLACK")){
			getquery = "INSERT INTO `Wardrobe-Black` (`name`, `black`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("LIGHTBLUE")){
			getquery = "INSERT INTO `Wardrobe-LightBlue` (`name`, `lightblue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("PINK")){
			getquery = "INSERT INTO `Wardrobe-Pink` (`name`, `pink`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("LIGHTGREEN")){
			getquery = "INSERT INTO `Wardrobe-LightGreen` (`name`, `lightgreen`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("DARKBLUE")){
			getquery = "INSERT INTO `Wardrobe-DarkBlue` (`name`, `darkblue`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("PURPLE")){
			getquery = "INSERT INTO `Wardrobe-Purple` (`name`, `purple`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("ORANGE")){
			getquery = "INSERT INTO `Wardrobe-Orange` (`name`, `orange`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("RED")){
			getquery = "INSERT INTO `Wardrobe-Red` (`name`, `red`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("CYAN")){
			getquery = "INSERT INTO `Wardrobe-Cyan` (`name`, `cyan`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("YELLOW")){
			getquery = "INSERT INTO `Wardrobe-Yellow` (`name`, `yellow`) VALUES ('" + player + "', '" + yes + "')";
		}
		if(Type.equals("GRAY")){
			getquery = "INSERT INTO `Wardrobe-Gray` (`name`, `gray`) VALUES ('" + player + "', '" + yes + "')";
		}
		
		try{
			PreparedStatement ps = connection.prepareStatement(getquery);
			ps.execute();
			ps.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public int getOMT(Player p){
		int omt = 0;
		
		String query = "SELECT `omt` FROM `OrbitMinesTokens` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				omt = rs.getInt("omt");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return omt;
	}
	public int getVIPPoints(Player p){
		int points = 0;
		
		String query = "SELECT `points` FROM `VIPPoints` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				points = rs.getInt("points");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return points;
	}
	public String getMushroomCowName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-MushroomCow` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getPigName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Pig` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getWolfName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Wolf` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getSheepName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Sheep` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getHorseName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Horse` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getMagmaCubeName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-MagmaCube` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getSlimeName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Slime` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getCowName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Cow` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getSilverfishName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Silverfish` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public String getOcelotName(Player p){
		String petname = "";
		
		String query = "SELECT `petname` FROM `Pets-Ocelot` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				petname = rs.getString("petname");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return petname;
	}
	public int getWhiteWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `white` FROM `Wardrobe-White` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("white");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getBlueWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `blue` FROM `Wardrobe-Blue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("blue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getGreenWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `green` FROM `Wardrobe-Green` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("green");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getBlackWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `black` FROM `Wardrobe-Black` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("black");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getLightBlueWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `lightblue` FROM `Wardrobe-LightBlue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("lightblue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getPinkWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `pink` FROM `Wardrobe-Pink` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("pink");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getLightGreenWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `lightgreen` FROM `Wardrobe-LightGreen` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("lightgreen");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getDarkBlueWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `darkblue` FROM `Wardrobe-DarkBlue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("darkblue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getPurpleWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `purple` FROM `Wardrobe-Purple` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("purple");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getOrangeWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `orange` FROM `Wardrobe-Orange` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("orange");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getRedWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `red` FROM `Wardrobe-Red` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("red");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getCyanWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `cyan` FROM `Wardrobe-Cyan` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("cyan");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getYellowWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `yellow` FROM `Wardrobe-Yellow` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("yellow");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getGrayWardrobe(Player p){
		int armor = 0;
		
		String query = "SELECT `gray` FROM `Wardrobe-Gray` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("gray");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public String getChatColor(Player p){
		String color = "";
		
		String query = "SELECT `color` FROM `ChatColors` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getString("color");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorDarkRed(Player p){
		int color = 0;
		
		String query = "SELECT `darkred` FROM `ChatColors-DarkRed` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("darkred");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorLightGreen(Player p){
		int color = 0;
		
		String query = "SELECT `lightgreen` FROM `ChatColors-LightGreen` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("lightgreen");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorDarkGray(Player p){
		int color = 0;
		
		String query = "SELECT `darkgray` FROM `ChatColors-DarkGray` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("darkgray");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorRed(Player p){
		int color = 0;
		
		String query = "SELECT `red` FROM `ChatColors-Red` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("red");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorWhite(Player p){
		int color = 0;
		
		String query = "SELECT `white` FROM `ChatColors-White` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("white");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorLightBlue(Player p){
		int color = 0;
		
		String query = "SELECT `lightblue` FROM `ChatColors-LightBlue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("lightblue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorPink(Player p){
		int color = 0;
		
		String query = "SELECT `pink` FROM `ChatColors-Pink` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("pink");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorBlue(Player p){
		int color = 0;
		
		String query = "SELECT `blue` FROM `ChatColors-Blue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("blue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorDarkBlue(Player p){
		int color = 0;
		
		String query = "SELECT `darkblue` FROM `ChatColors-DarkBlue` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("darkblue");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorGreen(Player p){
		int color = 0;
		
		String query = "SELECT `green` FROM `ChatColors-Green` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("green");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getChatColorBlack(Player p){
		int color = 0;
		
		String query = "SELECT `black` FROM `ChatColors-Black` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				color = rs.getInt("black");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return color;
	}
	public int getTrailAngryVillager(Player p){
		int armor = 0;
		
		String query = "SELECT `angryvillager` FROM `Trails-AngryVillager` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("angryvillager");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailBubble(Player p){
		int armor = 0;
		
		String query = "SELECT `bubble` FROM `Trails-Bubble` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("bubble");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailCrit(Player p){
		int armor = 0;
		
		String query = "SELECT `crit` FROM `Trails-Crit` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("crit");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailETable(Player p){
		int armor = 0;
		
		String query = "SELECT `etable` FROM `Trails-ETable` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("etable");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailExplode(Player p){
		int armor = 0;
		
		String query = "SELECT `explode` FROM `Trails-Explode` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("explode");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailFirework(Player p){
		int armor = 0;
		
		String query = "SELECT `firework` FROM `Trails-Firework` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("firework");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailHappyVillager(Player p){
		int armor = 0;
		
		String query = "SELECT `happyvillager` FROM `Trails-HappyVillager` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("happyvillager");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailHearts(Player p){
		int armor = 0;
		
		String query = "SELECT `hearts` FROM `Trails-Hearts` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("hearts");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailMobSpawner(Player p){
		int armor = 0;
		
		String query = "SELECT `mobspawner` FROM `Trails-MobSpawner` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("mobspawner");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailMusic(Player p){
		int armor = 0;
		
		String query = "SELECT `music` FROM `Trails-Music` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("music");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailSlime(Player p){
		int armor = 0;
		
		String query = "SELECT `slime` FROM `Trails-Slime` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("slime");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailSmoke(Player p){
		int armor = 0;
		
		String query = "SELECT `smoke` FROM `Trails-Smoke` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("smoke");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailSnow(Player p){
		int armor = 0;
		
		String query = "SELECT `snow` FROM `Trails-Snow` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("snow");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailWater(Player p){
		int armor = 0;
		
		String query = "SELECT `water` FROM `Trails-Water` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("water");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getTrailWitch(Player p){
		int armor = 0;
		
		String query = "SELECT `witch` FROM `Trails-Witch` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				armor = rs.getInt("witch");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return armor;
	}
	public int getHat(Player p, String Table, String hat){
		int hatI = 0;
		
		String query = "SELECT `" + hat + "` FROM `" + Table + "` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				hatI = rs.getInt(hat);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return hatI;
	}
	public int getDisguise(Player p, String Table, String disguise){
		int hatI = 0;
		
		String query = "SELECT `" + disguise + "` FROM `" + Table + "` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				hatI = rs.getInt(disguise);
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return hatI;
	}
	
	
	public static int getMiniGameCoins(Player p){
		int coins = 0;
		
		String query = "SELECT `coins` FROM `MiniGameCoins` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				coins = rs.getInt("coins");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return coins;
	}
	
	public void addOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getOMT(p) + OMT) + "' WHERE `name` = '" + p.getName() + "'");
		Start.omt.put(p.getName(), getOMT(p));
	}
	public void removeOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getOMT(p) - OMT) + "' WHERE `name` = '" + p.getName() + "'");
		Start.omt.put(p.getName(), getOMT(p));
	}
	public void addVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getVIPPoints(p) + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.points.put(p.getName(), getVIPPoints(p));
	}
	public void removeVIPPoints(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getVIPPoints(p) - points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.points.put(p.getName(), getVIPPoints(p));
	}
	public void setMushroomCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MushroomCow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.mushroomcow.put(p.getName(), petname);
	}
	public void setPigName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Pig` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.pig.put(p.getName(), petname);
	}
	public void setWolfName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Wolf` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.wolf.put(p.getName(), petname);
	}
	public void setSheepName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Sheep` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.sheep.put(p.getName(), petname);
	}
	public void setHorseName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Horse` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.horse.put(p.getName(), petname);
	}
	public void setMagmaCubeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-MagmaCube` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.magmacube.put(p.getName(), petname);
	}
	public void setSlimeName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Slime` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.slime.put(p.getName(), petname);
	}
	public void setCowName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Cow` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.cow.put(p.getName(), petname);
	}
	public void setSilverfishName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Silverfish` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.silverfish.put(p.getName(), petname);
	}
	public void setOcelotName(Player p, String petname) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Pets-Ocelot` SET `petname` = '" + petname + "' WHERE `name` = '" + p.getName() + "'");
		Start.ocelot.put(p.getName(), petname);
	}
	public void setWhiteWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.white.put(p.getName(), i);
	}
	public void setBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.blue.put(p.getName(), i);
	}
	public void setGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.green.put(p.getName(), i);
	}
	public void setBlackWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.black.put(p.getName(), i);
	}
	public void setLightBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.lightblue.put(p.getName(), i);
	}
	public void setPinkWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.pink.put(p.getName(), i);
	}
	public void setLightGreenWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.lightgreen.put(p.getName(), i);
	}
	public void setDarkBlueWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.darkblue.put(p.getName(), i);
	}
	public void setPurpleWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Purple` SET `purple` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.purple.put(p.getName(), i);
	}
	public void setOrangeWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Orange` SET `orange` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.orange.put(p.getName(), i);
	}
	public void setRedWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.red.put(p.getName(), i);
	}
	public void setCyanWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Cyan` SET `cyan` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.cyan.put(p.getName(), i);
	}
	public void setYellowWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Yellow` SET `yellow` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.yellow.put(p.getName(), i);
	}
	public void setGrayWardrobe(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `Wardrobe-Gray` SET `gray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.gray.put(p.getName(), i);
	}
	public void setChatColor(Player p, String i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors` SET `color` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolor.put(p, i);
	}
	public void setChatColorDarkRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkRed` SET `darkred` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkred.put(p.getName(), i);
	}
	public void setChatColorLightGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightGreen` SET `lightgreen` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorlightgreen.put(p.getName(), i);
	}
	public void setChatColorDarkGray(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkGray` SET `darkgray` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkgray.put(p.getName(), i);
	}
	public void setChatColorRed(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Red` SET `red` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorred.put(p.getName(), i);
	}
	public void setChatColorWhite(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-White` SET `white` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorwhite.put(p.getName(), i);
	}
	public void setChatColorLightBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-LightBlue` SET `lightblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorlightblue.put(p.getName(), i);
	}
	public void setChatColorPink(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Pink` SET `pink` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorpink.put(p.getName(), i);
	}
	public void setChatColorBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Blue` SET `blue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorblue.put(p.getName(), i);
	}
	public void setChatColorDarkBlue(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-DarkBlue` SET `darkblue` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolordarkblue.put(p.getName(), i);
	}
	public void setChatColorGreen(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Green` SET `green` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorgreen.put(p.getName(), i);
	}
	public void setChatColorBlack(Player p, int i) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `ChatColors-Black` SET `black` = '" + i + "' WHERE `name` = '" + p.getName() + "'");
		Start.chatcolorblack.put(p.getName(), i);
	}
	public static void addMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getMiniGameCoins(p) + points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.coins.put(p.getName(), getMiniGameCoins(p));
	}
	public void removeMiniGameCoins(Player p, int points) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `MiniGameCoins` SET `coins` = '" + (getMiniGameCoins(p) - points) + "' WHERE `name` = '" + p.getName() + "'");
		Start.coins.put(p.getName(), getVIPPoints(p));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] a) {

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
								addVIPPoints(player, i);
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
								removeVIPPoints(player, i);
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
								addOMT(player, i);
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
								removeOMT(player, i);
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
				sender.sendMessage("§8[§e§lOMT§8] §7Your OMT balance: §e§l" + Start.omt.get(sender.getName()));
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
				p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 1);
				p.openInventory(CosmeticPerks.getCosmeticPerks(p));
				
			}
		}

		return false;
	}
}
