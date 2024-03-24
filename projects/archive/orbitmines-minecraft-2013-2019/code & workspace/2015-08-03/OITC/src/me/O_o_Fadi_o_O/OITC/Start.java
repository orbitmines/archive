package me.O_o_Fadi_o_O.OITC;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import me.O_o_Fadi_o_O.OITC.events.ArrowHit;
import me.O_o_Fadi_o_O.OITC.events.BreakBlock;
import me.O_o_Fadi_o_O.OITC.events.ClickEvent;
import me.O_o_Fadi_o_O.OITC.events.EntityDamage;
import me.O_o_Fadi_o_O.OITC.events.PlaceBlock;
import me.O_o_Fadi_o_O.OITC.events.PlayerItemDrop;
import me.O_o_Fadi_o_O.OITC.events.PlayerPickupItem;
import me.O_o_Fadi_o_O.OITC.utils.Gamestate;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Start extends JavaPlugin implements Listener{
	
	public boolean EnableGame = false;
	
	public static Gamestate state;
	
	public HashMap<String, Integer> OITCKills = new HashMap<String, Integer>();
	public HashMap<String, Integer> OITCDeaths = new HashMap<String, Integer>();
	
	public int LobbyMinutes = 2;
	public int LobbySeconds = 0;
	
	public int ArenaMinutes = 2;
	public int ArenaSeconds = 0;
	
	static int totalpoints = 0;
	
	public static ArrayList<String> players = new ArrayList<>();
	public static ArrayList<String> spectators = new ArrayList<>();
	
	static World Lobby;

	static World Arena;
	
	public static String TAG = "§8[§b§lOITC§8] ";
	
	public int SpawnsAmount = 0;
	
	public static int LobbyX = 0;
	public static int LobbyY = 0;
	public static int LobbyZ = 0;
	
	public static int ArenaX = 0;
	public static int ArenaY = 0;
	public static int ArenaZ = 0;
	
	int ArenaCounter = 1;
	int GameCounter = 1;
	
	int RestartCounter = 15;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ArrowHit(), this);
		getServer().getPluginManager().registerEvents(new BreakBlock(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new PlaceBlock(), this);
		getServer().getPluginManager().registerEvents(new PlayerItemDrop(), this);
		getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		Arena = Bukkit.getWorld(getConfig().getString("ArenaWorld"));
		Lobby = Bukkit.getWorld(getConfig().getString("Lobby.world"));
		LobbyX = getConfig().getInt("Lobby.x");
		LobbyY = getConfig().getInt("Lobby.y");
		LobbyZ = getConfig().getInt("Lobby.z");
		
		ArenaX = getConfig().getInt("Spectate.x");
		ArenaY = getConfig().getInt("Spectate.y");
		ArenaZ = getConfig().getInt("Spectate.z");
		SpawnsAmount = getConfig().getInt("SpawnsAmount");
		
		LobbyMinutes = getConfig().getInt("LobbyMinutes");
		LobbySeconds = getConfig().getInt("LobbySeconds");
		
		EnableGame = getConfig().getBoolean("EnableGame");
		
		state = Gamestate.LOBBY;
		Arena.setPVP(false);
		
		if(EnableGame == true){
		LobbyCountdown();
		}
	
	}
	public static void LobbyTP(Player p){
		p.teleport(new Location(Lobby, LobbyX, LobbyY, LobbyZ));
		p.getInventory().clear();
		
		ItemStack sword = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassmeta = sword.getItemMeta();
		compassmeta.setDisplayName("§bReturn to the Hub§7 (Right Click)");
		p.getInventory().addItem(new ItemStack(sword));
	}
	public static void setSpectator(Player p){
		p.teleport(new Location(Arena, ArenaX, ArenaY, ArenaZ));
		p.setAllowFlight(true);
		p.setFlying(true);
		spectators.add(p.getName());
		
		for(Player player : Bukkit.getOnlinePlayers()){
			player.hidePlayer(p);
		}
		p.sendMessage(TAG + "§7You've joined the game as a Spectator!");
		p.getInventory().clear();
		
		ItemStack sword = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassmeta = sword.getItemMeta();
		compassmeta.setDisplayName("§bReturn to the Hub§7 (Right Click)");
		p.getInventory().addItem(new ItemStack(sword));
		
		if(players.contains(p.getName())){
			players.remove(p.getName());
		}
		spectators.add(p.getName());
		
	}
	
	public void ArenaTP(){
		
		Bukkit.broadcastMessage(TAG + "§7First to §b25§7 kills wins!");
		Bukkit.broadcastMessage(TAG + "§7Bow shots are insta kills!");
		Bukkit.broadcastMessage(TAG + "§7You'll get an arrow for every kill!");
		
		state = Gamestate.INGAME;
		Arena.setPVP(true);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(!players.contains(p.getName())){
			players.add(p.getName());
			}
			OITCKills.put(p.getName(), 0);
			OITCDeaths.put(p.getName(), 0);
			int X = getConfig().getInt("spawns." + ArenaCounter + ".x");
			int Y = getConfig().getInt("spawns." + ArenaCounter + ".y");
			int Z = getConfig().getInt("spawns." + ArenaCounter + ".z");
			p.teleport(new Location(Arena, X, Y, Z));
			p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
			p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 2004);
			ArenaScoreboard(p);
			
			ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemStack arrow = new ItemStack(Material.ARROW, 1);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack(sword));
			p.getInventory().addItem(new ItemStack(bow));
			p.getInventory().addItem(new ItemStack(arrow));
			
			ArenaCounter++;
			if(ArenaCounter == SpawnsAmount){
				ArenaCounter = 1;
			}
		}
	}
	public void deathTP(final Player p){
		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){
		int X = getConfig().getInt("spawns." + GameCounter + ".x");
		int Y = getConfig().getInt("spawns." + GameCounter + ".y");
		int Z = getConfig().getInt("spawns." + GameCounter + ".z");
		p.teleport(new Location(Arena, X, Y, Z));
		p.getInventory().clear();
		
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		p.getInventory().addItem(new ItemStack(sword));
		p.getInventory().addItem(new ItemStack(bow));
		p.getInventory().addItem(new ItemStack(arrow));
		if(p.getName() == "napestaartje"){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " arrow 64");
		}
		
		GameCounter++;
		if(GameCounter == SpawnsAmount){
			GameCounter = 1;
		}
		}
		}, 20L);
	}
	public void reloadServer(){
		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(TAG + "§7Server Restarting in §b" + RestartCounter + "§7...");
						Arena.setPVP(false);
						RestartCounter--;
						if(RestartCounter <= 0){
						for(Player p : Bukkit.getOnlinePlayers()){
							p.kickPlayer(TAG + "§7Server Restarting...");
						}
						Bukkit.getScheduler().cancelAllTasks();
						}
					}
		}, 0L, 20L);
	}
	public void endGame(final Player p){
		Bukkit.broadcastMessage(TAG + "§7Game Ended!");
		Bukkit.broadcastMessage(TAG + "§b" + p.getName() + "§7 reached §b25 Kills§7!");
		
		state = Gamestate.ENDED;
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(players.contains(player.getName())){
				int kills = OITCKills.get(player.getName());
				int deaths = OITCDeaths.get(player.getName());
				int killspoints = kills / 3;
				addKill(player, kills);
				addDeath(player, deaths);
				
				if(player.getName() == p.getName()){
					totalpoints = killspoints + 10;
					addPoints(player, totalpoints);
					addWin(player);
				}
				else{
					totalpoints = killspoints;
					addPoints(player, totalpoints);
					addLose(player);
				}
				
				player.sendMessage(TAG + "§b" + kills + " §7Kills (§b+" + killspoints + "§7)");
				if(player.getName() == p.getName()){
					player.sendMessage(TAG + "§b1st Place §7(§b+10§7)");
				}
				player.sendMessage(TAG + "§7Total: §b" + totalpoints);

			}
		}
		reloadServer();
		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new Runnable() {
					public void run() {
		Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwmeta = fw.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();
        builder.withTrail();
        builder.withFlicker();
        builder.withFade(Color.BLUE);
        builder.withFade(Color.ORANGE);
        builder.withColor(Color.BLUE);
        builder.withColor(Color.ORANGE);
        
        fwmeta.addEffects(builder.build());
        fw.setFireworkMeta(fwmeta);
					}
		}, 0, 10L);
	}
	
	public void LobbyCountdown(){
		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new Runnable() {
					public void run() {
						
						if(LobbySeconds != -1){
							LobbySeconds--;
						}
						if(LobbySeconds == -1){
							LobbyMinutes--;
							LobbySeconds = 59;
						}
						for(Player p : Bukkit.getOnlinePlayers()){
							LobbyScoreboard(p);
						}
						if(LobbyMinutes == 1){
							if(LobbySeconds == 0){
								Bukkit.broadcastMessage(TAG + "§7Starting in §b60§7 seconds!");
							}
						}
						if(LobbyMinutes == 0){
							if(LobbySeconds == 30){
								Bukkit.broadcastMessage(TAG + "§7Starting in §b" + LobbySeconds + "§7 seconds!");
							}
						}
						
						if(LobbyMinutes == 0){
							if(LobbySeconds <= 10){
								Bukkit.broadcastMessage(TAG + "§7Starting in §b" + LobbySeconds + "§7 seconds!");
								for(Player p : Bukkit.getOnlinePlayers()){
									p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
								}
								}
						}
						
						if(LobbyMinutes == 0){
							if(LobbySeconds == 0){
								if(Bukkit.getOnlinePlayers().length >= 2){
								
									ArenaTP();
									Bukkit.getServer().getScheduler().cancelAllTasks();
								
								}
								else{
									Bukkit.getScheduler().cancelAllTasks();
									Bukkit.broadcastMessage(TAG + "§7Not enough players to start! (6 Required)");
									LobbyMinutes = getConfig().getInt("LobbyMinutes");
									LobbySeconds = getConfig().getInt("LobbySeconds");
									LobbyCountdown();
							}
						}
					}
			}
		}, 0L, 20L);
	}
	
	public void LobbyScoreboard(Player p){
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("Test", "Test2");
		objective.setDisplayName("§f§l| §b§lLobby §f§l|");
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score score = objective.getScore(("§f§lTime Left:"));
		score.setScore(2);
		
		Score score1 = objective.getScore(("§b§l" + LobbyMinutes + "m" + LobbySeconds + "s"));
		score1.setScore(1);
		
		p.setScoreboard(board);
	}
	
	public void ArenaScoreboard(Player p){
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("Test3", "Test4");
		objective.setDisplayName("§f§l| §b§lOITC §f§l|");
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score score = objective.getScore("§7Kills:");
		score.setScore(OITCKills.get(p.getName()));
		
		Score score1 = objective.getScore("§7Deaths:");
		score1.setScore(OITCDeaths.get(p.getName()));
		
		p.setScoreboard(board);
	}
	public void addDeath(Player p, int i){
		getConfig().set("players." + p.getName() + ".Deaths", getConfig().getInt("players." + p.getName() + ".Deaths", 0) + i);
		saveConfig();
	}
	public void addKill(Player p, int i){
		getConfig().set("players." + p.getName() + ".Kills", getConfig().getInt("players." + p.getName() + ".Kills", 0) + i);
		saveConfig();
	}
	public void addLose(Player p){
		getConfig().set("players." + p.getName() + ".Lost", getConfig().getInt("players." + p.getName() + ".Lost", 0) + 1);
		saveConfig();
	}
	public void addWin(Player p){
		getConfig().set("players." + p.getName() + ".Won", getConfig().getInt("players." + p.getName() + ".Won", 0) + 1);
		saveConfig();
	}
	public void addGameLeft(Player p){
		getConfig().set("players." + p.getName() + ".Left", getConfig().getInt("players." + p.getName() + ".Left", 0) + 1);
		saveConfig();
	}
	public void addPoints(Player p, int i){
		getConfig().set("players." + p.getName() + ".Points", getConfig().getInt("players." + p.getName() + ".Points", 0) + i);
		saveConfig();
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] a) {

			if(sender instanceof Player){
				Player p = (Player)sender;
				
				if(cmd.getName().equalsIgnoreCase("stats")){
					p.sendMessage(TAG + "§7Your Total Stats:");
					p.sendMessage(TAG + "§7Points:§b " + getConfig().getInt("players." + p.getName() + ".Points"));
					p.sendMessage(TAG + "§7Kills:§b " + getConfig().getInt("players." + p.getName() + ".Kills"));
					p.sendMessage(TAG + "§7Deaths:§b " + getConfig().getInt("players." + p.getName() + ".Deaths"));
					p.sendMessage(TAG + "§7Games Lost:§b " + getConfig().getInt("players." + p.getName() + ".Lost"));
					p.sendMessage(TAG + "§7Games Won:§b " + getConfig().getInt("players." + p.getName() + ".Won"));
					p.sendMessage(TAG + "§7Games Left:§b " + getConfig().getInt("players." + p.getName() + ".Left"));
				}
				else if(cmd.getName().equalsIgnoreCase("oitc")){
					if(p.hasPermission("OITC.Admin")){
						
						if(a.length == 0){
							p.sendMessage(TAG + "§7Type §b/oitc help");
						}
						else if(a[0].equalsIgnoreCase("setlobby")){
							
							getConfig().set("Lobby.x", p.getLocation().getBlockX());
							getConfig().set("Lobby.y", p.getLocation().getBlockY());
							getConfig().set("Lobby.z", p.getLocation().getBlockZ());
							getConfig().set("Lobby.world", p.getWorld().getName());
							saveConfig();
							p.sendMessage(TAG + " §7Lobby Spawn Set! §7(§b" + p.getLocation().getBlockX() + "§7,§b " + p.getLocation().getBlockY() + "§7,§b " + p.getLocation().getBlockZ() + "§7,§b " + p.getWorld().getName() + "§7)");
							
						}
						else if(a[0].equalsIgnoreCase("setspectate")){
							
							getConfig().set("Spectate.x", p.getLocation().getBlockX());
							getConfig().set("Spectate.y", p.getLocation().getBlockY());
							getConfig().set("Spectate.z", p.getLocation().getBlockZ());
							saveConfig();
							p.sendMessage(TAG + " §7Lobby Spawn Set! §7(§b" + p.getLocation().getBlockX() + "§7,§b " + p.getLocation().getBlockY() + "§7,§b " + p.getLocation().getBlockZ() + "§7)");
							
						}
						else if(a[0].equalsIgnoreCase("setnextspawn")){
							
							SpawnsAmount++;
							getConfig().set("SpawnsAmount", SpawnsAmount);
							getConfig().set("spawns." + SpawnsAmount + ".x", p.getLocation().getBlockX());
							getConfig().set("spawns." + SpawnsAmount + ".y", p.getLocation().getBlockY());
							getConfig().set("spawns." + SpawnsAmount + ".z", p.getLocation().getBlockZ());
							saveConfig();
							p.sendMessage(TAG + " §7Spawn §b" + SpawnsAmount + "§7 set! (§b" + p.getLocation().getBlockX() + "§7,§b " + p.getLocation().getBlockY() + "§7,§b " + p.getLocation().getBlockZ() + "§7)");
						}
						else if(a[0].equalsIgnoreCase("help")){
							
							p.sendMessage(TAG + "§7/setlobby");
							p.sendMessage(TAG + "§7/setspectate");
							p.sendMessage(TAG + "§7/setnextspawn");
							p.sendMessage(TAG + "§7/sethelp");
						}
						else{
							p.sendMessage(TAG + "§cIncorrect Use! §b/oitc help");
						}
						
					}
					else{
						p.sendMessage(TAG + "§cAccess Denied!");
					}
				}
			}
			else{
				sender.sendMessage(Start.TAG + "§7You can't perform commands through the console!");
			}
		return false;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		
		if(e.getQuitMessage() != null){
			Player p = e.getPlayer();
			if(Start.state == Gamestate.LOBBY){
				e.setQuitMessage("§4§l§o>>> §b" + p.getName() + "§7 left the Game! (§b" + Bukkit.getOnlinePlayers().length + "§7/§b24§7)");
				p.getInventory().clear();
			}
			else if(Start.state == Gamestate.INGAME || Start.state == Gamestate.WARMUP){
				e.setQuitMessage("§4§l§o>>> §b" + p.getName() + "§7 left the Game!");
				p.getInventory().clear();
				
				addDeath(p, 1 + OITCDeaths.get(p.getName()));
				addKill(p, OITCKills.get(p.getName()));
				addGameLeft(p);
				addLose(p);
				OITCDeaths.put(p.getName(), 0);
				OITCKills.put(p.getName(), 0);
				
				if(players.contains(p.getName())){
					players.remove(p.getName());
				}
				if(spectators.contains(p.getName())){
					spectators.remove(p.getName());
				}
			}
			else{
				e.setQuitMessage("§4§l§o>>> §b" + p.getName() + "§7 left the Game!");
				p.getInventory().clear();
				
				OITCDeaths.put(p.getName(), 0);
				OITCKills.put(p.getName(), 0);
				
				if(players.contains(p.getName())){
					players.remove(p.getName());
				}
				if(spectators.contains(p.getName())){
					spectators.remove(p.getName());
				}
			}
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		if(p.getKiller() instanceof Player){
			Player killer = p.getKiller();
			
			OITCKills.put(killer.getName(), (OITCKills.get(killer.getName()) + 1));
			OITCDeaths.put(p.getName(), (OITCDeaths.get(p.getName()) + 1));
			
			ArenaScoreboard(p);
			ArenaScoreboard(killer);
			
			e.setDeathMessage(Start.TAG + "§b" + killer.getName() + "§7(§b" + OITCKills.get(killer.getName()) + "§7)" + "§7 killed §b" + p.getName() + "§7(§b" + OITCKills.get(p.getName()) + "§7)" + "§7!");
			
			ItemStack arrow = new ItemStack(Material.ARROW, 1);
			killer.getInventory().addItem(new ItemStack(arrow));
			
			deathTP(p);
			
			if(OITCKills.get(killer.getName()) == 25){
				endGame(killer);
			}
			
		}
		else{
			OITCDeaths.put(p.getName(), (OITCDeaths.get(p.getName()) + 1));
			e.setDeathMessage(Start.TAG + "§b" + p.getName() + "§7(§b" + OITCKills.get(p.getName()) + "§7)" + "died§7!");
			ArenaScoreboard(p);
			deathTP(p);
		}
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(e.getJoinMessage() != null){
			if(Start.state == Gamestate.LOBBY){
				e.setJoinMessage("§2§l§o>>> §b" + p.getName() + "§7 joined the Game! (§b" + Bukkit.getOnlinePlayers().length + "§7/§b24§7)");
				Start.LobbyTP(p);
			}
			else if(Start.state == Gamestate.INGAME || Start.state == Gamestate.WARMUP){
				e.setJoinMessage("§2§l§o>>> §b" + p.getName() + "§7 joined the Game! (§bSpectator§7)");
				Start.setSpectator(p);
			}
			else{
				e.setJoinMessage("§2§l§o>>> §b" + p.getName() + "§7 joined the Game!");
				p.kickPlayer(Start.TAG + "§7You can't join this Game!");
			}
		}
		if(Start.players.contains(p.getName())){
			Start.players.remove(p.getName());
		}
		if(Start.spectators.contains(p.getName())){
			Start.spectators.remove(p.getName());
		}
		OITCDeaths.put(p.getName(), 0);
		OITCKills.put(p.getName(), 0);
	}
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			if(e.getEntity() instanceof LivingEntity){
				if(Start.spectators.contains(p.getName())){
					e.setCancelled(true);
				}
			}
		}
	}
	@EventHandler
	public void onConnect(ServerListPingEvent e){
		
		if(state == Gamestate.LOBBY){
			e.setMotd(TAG + "§a§lJoinable§7! Lobby...");
		}
		if(state == Gamestate.INGAME || state == Gamestate.WARMUP){
			e.setMotd(TAG + "§d§lJoinable§7! (Spectate)");
		}
		else{
			e.setMotd(TAG + "§a§lJoinable§7! Lobby...");
		}
		
	}
}
