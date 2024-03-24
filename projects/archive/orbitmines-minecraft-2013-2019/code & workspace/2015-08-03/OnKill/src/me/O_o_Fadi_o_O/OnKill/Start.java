package me.O_o_Fadi_o_O.OnKill;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Start extends JavaPlugin implements Listener{
	// SET DEFAULTS
	public boolean EnableSubtract = false;
	public boolean EnableReward = true;
	
	public boolean EnableKillerMessage = true;
	public boolean EnablePlayerMessage = false;
	
	public boolean EnableKills = true;
	public boolean EnableDeaths = true;
	
	public boolean UseScoreboard = true;
	
	public String KillerMessage = "&8[&c&lOnKill&8] &7Good Job &c%killer%&7! You just killed &c%player%&7! (&c+100$&7)";
	public String PlayerMessage = "&8[&c&lOnKill&8] &7You just got killed by &c%killer%&7!";
	
	public List<String> Stats;
	
	public String Title = "&c&lOnKill";
	
	public ArrayList<String> scoreboards = new ArrayList<String>();
	
	public int Reward = 100;
	public int Subtract = 5;
	//ENABLE
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		//SETUP VAULT
		setupPermissions();
		setupEconomy();
		setupChat();
		

		SettingsManager.setup(this);
		// SETUP PLAYERDATA
		if(!SettingsManager.data.contains("players.O_o_Fadi_o_O")){
			SettingsManager.data.set("players.O_o_Fadi_o_O.Kills", 0);
			SettingsManager.data.set("players.O_o_Fadi_o_O.Deaths", 0);
			SettingsManager.saveData();
		}
		if(!SettingsManager.scoreboard.contains("Scoreboard.Title")){
			SettingsManager.scoreboard.set("Scoreboard.Title", "&c&lOnKill");
			ArrayList<String> list = new ArrayList<String>();
			list.add("");//1
			list.add("&4&lDeaths:");//2
			list.add("&4%deaths%");//3
			list.add(" ");//4
			list.add("&c&lKills:");//5
			list.add("&c%kills%");//6
			list.add("  ");//7
			list.add("&2&lMoney");//8
			list.add("&2%money%");//9
			list.add("   ");//10
			list.add("Max Rows: 15");//11
			list.add("    ");//12
			list.add("Max Characters:");//13
			list.add("16");//14
			list.add("     ");//15
			SettingsManager.scoreboard.set("Scoreboard.Board", list);
			SettingsManager.saveScoreboardData();
		}
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		// LOAD CONFIG
		KillerMessage = getConfig().getString("KillerMessage");
		PlayerMessage = getConfig().getString("PlayerMessage");
		Reward = getConfig().getInt("KillerReward");
		Subtract = getConfig().getInt("PlayerSubtract");
		EnableKillerMessage = getConfig().getBoolean("EnableKillerMessage");
		EnablePlayerMessage = getConfig().getBoolean("EnablePlayerMessage");
		EnableReward = getConfig().getBoolean("EnableReward");
		EnableSubtract = getConfig().getBoolean("EnableSubtract");
		EnableKills = getConfig().getBoolean("EnableKills");
		EnableDeaths = getConfig().getBoolean("EnableDeaths");
		UseScoreboard = getConfig().getBoolean("UseScoreboard");
		Stats = getConfig().getStringList("StatsMessage");
		
		SettingsManager.reloadData();
		SettingsManager.saveData();
		SettingsManager.reloadScoreboardData();
		SettingsManager.saveScoreboardData();
		
		scoreboards.removeAll(scoreboards);
		scoreboards.addAll(SettingsManager.scoreboard.getStringList("Scoreboard.Board"));
		
		Title = SettingsManager.scoreboard.getString("Scoreboard.Title");
		
		if(UseScoreboard == true){
		
			for(Player p : Bukkit.getOnlinePlayers()){
				onScoreboard(p);
			}
		}
	}	
	// JOIN EVENT
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		if(!SettingsManager.data.contains("players." + p.getName())){
			
			if(EnableKills == true){
				SettingsManager.data.set("players." + p.getName() + ".Kills", 0);
				SettingsManager.saveData();
			}
			
			if(EnableDeaths == true){
				SettingsManager.data.set("players." + p.getName() + ".Deaths", 0);
				SettingsManager.saveData();
			}
		}
		if(UseScoreboard == true){
			onScoreboard(p);
		}
	}
	// ADD KILL
	public void addKills(Player p, int i){
		SettingsManager.data.set("players." + p.getName() + ".Kills", SettingsManager.data.getInt("players." + p.getName() + ".Kills", 0) + i);
		SettingsManager.saveData();
		onScoreboard(p);
	} 
	// ADD DEATH
	public void addDeaths(Player p, int i){
		SettingsManager.data.set("players." + p.getName() + ".Deaths", SettingsManager.data.getInt("players." + p.getName() + ".Deaths", 0) + i);
		SettingsManager.saveData();
		onScoreboard(p);
	} 
	// DEATH EVENT
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		if(p.getKiller() instanceof Player){
			
			if(EnableKills == true){
				addKills(p.getKiller(), 1);
			}
			
			if(EnableDeaths == true){
				addDeaths(p, 1);
			}
			
			if(EnableKillerMessage == true){
				String m = KillerMessage.replaceAll("%player%", p.getName()).replaceAll("%killer%", p.getKiller().getName()).replaceAll("&", "§"); 
				
				p.getKiller().sendMessage(m);
			}
			
			if(EnablePlayerMessage == true){
				String m = PlayerMessage.replaceAll("%player%", p.getName()).replaceAll("%killer%", p.getKiller().getName()).replaceAll("&", "§"); 
				
				p.sendMessage(m);
			}
			
			if(EnableReward == true){
				economy.depositPlayer(p.getKiller().getName(), Reward);
			
			if(EnableSubtract == true){
				economy.withdrawPlayer(p.getName(), Subtract);
				}
			}
			
		}
		else{
			addDeaths(p, 1);
			
			if(EnableSubtract == true){
				economy.withdrawPlayer(p.getName(), Subtract);
			}
		}
	}
	// COMMANDS
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("onkill")){
		
		if((sender instanceof Player)){
			Player player = (Player)sender;
			
				if(player.hasPermission("OnKill.Admin") || player.hasPermission("OnKill.*")){
				
					if (a.length != 1){
					
						player.sendMessage("§8[§c§lOnKill§8] §cIncorrect Use! §6/onkill help");
					
					} // HELP COMMAND
					else if(a.length == 1){
						
						if(a[0].equalsIgnoreCase("help")){
					
						player.sendMessage("§8[§c§lOnKill§8] §cOnKill v1.2.1 §7by §cO_o_Fadi_o_O");
						player.sendMessage("§8[§c§lOnKill§8] §7All Commands:");
						player.sendMessage("§8[§c§lOnKill§8] §c/onkill help §7(Show this Menu)");
						player.sendMessage("§8[§c§lOnKill§8] §c/stats §7(Show Kills and Deaths)");
						player.sendMessage("§8[§c§lOnKill§8] §c/mystats §7(Show Kills and Deaths)");
						player.sendMessage("§8[§c§lOnKill§8] §c/onkill reload §7(Reload the Plugin)");
					
					} // RELOAD COMMAND
					else if(a[0].equalsIgnoreCase("reload")){
					
						player.sendMessage("§8[§c§lOnKill§8] §7Reloading...");

						reloadConfig();
						KillerMessage = getConfig().getString("KillerMessage");
						PlayerMessage = getConfig().getString("PlayerMessage");
						Reward = getConfig().getInt("KillerReward");
						Subtract = getConfig().getInt("PlayerSubtract");
						EnableKillerMessage = getConfig().getBoolean("EnableKillerMessage");
						EnablePlayerMessage = getConfig().getBoolean("EnablePlayerMessage");
						EnableReward = getConfig().getBoolean("EnableReward");
						EnableSubtract = getConfig().getBoolean("EnableSubtract");
						EnableKills = getConfig().getBoolean("EnableKills");
						EnableDeaths = getConfig().getBoolean("EnableDeaths");
						Stats = getConfig().getStringList("StatsMessage");
						UseScoreboard = getConfig().getBoolean("UseScoreboard");
						saveConfig();

						SettingsManager.reloadData();
						SettingsManager.saveData();
						SettingsManager.reloadScoreboardData();
						SettingsManager.saveScoreboardData();
						
						Title = SettingsManager.scoreboard.getString("Scoreboard.Title");
						
						scoreboards.removeAll(scoreboards);
						scoreboards.addAll(SettingsManager.scoreboard.getStringList("Scoreboard.Board"));
						if(UseScoreboard == true){
							for(Player p : Bukkit.getOnlinePlayers()){
								onScoreboard(p);
							}
						}
					
						player.sendMessage("§8[§c§lOnKill§8] §7Reload Complete!");
		
					}
					else{
						player.sendMessage("§8[§c§lOnKill§8] §cIncorrect Use! §f'/onkill " + a[0] + "'");
						player.sendMessage("§8[§c§lOnKill§8] §cHelp: §6/onkill help");
					}
					}
				}
				else{
					sender.sendMessage("§cAccess Denied!");
				}
			}
			else{
				sender.sendMessage("§8[§c§lOnKill§8] §cYou can't perform commands through the console!");
			}
		return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("stats") || cmd.getName().equalsIgnoreCase("mystats")){
			
			if((sender instanceof Player)){
				Player player = (Player)sender;
				
				if(player.hasPermission("OnKill.Stats") && player.hasPermission("OnKill.*")){
					
					if(EnableKills == true){
						if(EnableDeaths == false){
						
							int Kills = SettingsManager.data.getInt("players." + player.getName() + ".Kills");
						
							for(String s : Stats){
								String m = s.replaceAll("%money%", "" + economy.getBalance(player.getName())).replaceAll("%player%", player.getName()).replaceAll("%kills%", "" + Kills).replaceAll("%deaths%", "§c§o[Deaths are Disabled]").replaceAll("&", "§"); 
								player.sendMessage(m);
							}
						}
					}
					if(EnableDeaths == true){
						if(EnableKills == false){
							
							int Deaths = SettingsManager.data.getInt("players." + player.getName() + ".Deaths");
							
							for(String s : Stats){
								String m = s.replaceAll("%money%", "" + economy.getBalance(player.getName())).replaceAll("%player%", player.getName()).replaceAll("%kills%", "§c§o[Kills are Disabled]").replaceAll("%deaths%", "" + Deaths).replaceAll("&", "§");
								player.sendMessage(m);
							}
						}
					}
					if (EnableKills == true){
						if(EnableDeaths == true){
							
							int Kills = SettingsManager.data.getInt("players." + player.getName() + ".Kills");
							int Deaths = SettingsManager.data.getInt("players." + player.getName() + ".Deaths");
							
							for(String s : Stats){
								String m = s.replaceAll("%money%", "" + economy.getBalance(player.getName())).replaceAll("%player%", player.getName()).replaceAll("%player%", player.getName()).replaceAll("%kills%", "" + Kills).replaceAll("%deaths%", "" + Deaths).replaceAll("&", "§");
								player.sendMessage(m);
							}
						}
					}
					if (EnableKills == false){
						if(EnableDeaths == false){
							player.sendMessage("§8[§c§lOnKill§8]§c Stats are Disabled!");
						}
					}
				}
				else{
					sender.sendMessage("§cAccess Denied!");
				}
			}
			else{
				sender.sendMessage("§8[§c§lOnKill§8] §cYou can't perform commands through the console!");
			}
			return false;	
		}
		
		return false;
	}
	
	public void onScoreboard(Player p){
		
		try{
			ScoreboardManager s = Bukkit.getScoreboardManager();
			Scoreboard b = s.getNewScoreboard();
		
			Objective o = b.registerNewObjective("Test", "Test2");
			o.setDisplayName(Title.replaceAll("&", "§").replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
		
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			int scoreboardsize = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
		
			if(scoreboardsize >= 1){
				Score score = o.getScore(scoreboards.get(0).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 1);
			}
		
			if(scoreboardsize >= 2){
				Score score = o.getScore(scoreboards.get(1).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 2);
			}
			if(scoreboardsize >= 3){
				Score score = o.getScore(scoreboards.get(2).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 3);
			}
			if(scoreboardsize >= 4){
				Score score = o.getScore(scoreboards.get(3).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 4);
			}
			if(scoreboardsize >= 5){
				Score score = o.getScore(scoreboards.get(4).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 5);
			}
			if(scoreboardsize >= 6){
				Score score = o.getScore(scoreboards.get(5).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 6);
			}
			if(scoreboardsize >= 7){
				Score score = o.getScore(scoreboards.get(6).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 7);
			}
			if(scoreboardsize >= 8){
				Score score = o.getScore(scoreboards.get(7).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 8);
			}
			if(scoreboardsize >= 9){
				Score score = o.getScore(scoreboards.get(8).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 9);
			}
			if(scoreboardsize >= 10){
				Score score = o.getScore(scoreboards.get(9).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 10);
			}
			if(scoreboardsize >= 11){
				Score score = o.getScore(scoreboards.get(10).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 11);
			}
			if(scoreboardsize >= 12){
				Score score = o.getScore(scoreboards.get(11).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 12);
			}
			if(scoreboardsize >= 13){
				Score score = o.getScore(scoreboards.get(12).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 13);
			}
			if(scoreboardsize >= 14){
				Score score = o.getScore(scoreboards.get(13).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 14);
			}
			if(scoreboardsize >= 15){
				Score score = o.getScore(scoreboards.get(14).replaceAll("&", "§").replaceAll("%money%", "" + economy.getBalance(p.getName())).replaceAll("%deaths%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Deaths")).replaceAll("%kills%", "" + SettingsManager.data.getInt("players." + p.getName() + ".Kills")).replaceAll("%player%", p.getName()));
			
				int size = SettingsManager.scoreboard.getStringList("Scoreboard.Board").size();
				score.setScore(size - 15);
			}
			p.setScoreboard(b);
		
		}
		catch(Exception e){
			
		}
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
