package me.O_o_Fadi_o_O.KitPvPMoneyOnKill;

import java.io.File;
import java.util.HashMap;

import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.events.DeathEvent;
import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.events.JoinEvent;
import me.O_o_Fadi_o_O.KitPvPMoneyOnKill.mobs.Set;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Start extends JavaPlugin implements Listener {
	
	public static HashMap<String, String> type = new HashMap<String, String>();
	
	public static String TAG = "§8[§c§lKitPvP§8]§7 ";
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		
		getServer().getPluginManager().registerEvents(new Set(this), this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		setupPermissions();
		setupEconomy();
		setupChat();
	}
	
	public void onScoreboard(Player p){
		
		ScoreboardManager s = Bukkit.getScoreboardManager();
		Scoreboard b = s.getNewScoreboard();
		
		Objective o = b.registerNewObjective("Test", "Test2");
		o.setDisplayName("§c§lKitPvP");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score score = o.getScore(("§4§lDeaths:"));
		score.setScore(getConfig().getInt(p.getName() + ".Deaths"));
		
		Score score1 = o.getScore(("§c§lKills:"));
		score1.setScore(getConfig().getInt(p.getName() + ".Kills"));
		
		Score score2 = o.getScore(("§6§lCoins:"));
		score2.setScore((int) economy.getBalance(p.getName()));
		
		Score score3 = o.getScore(("§a§lOnline:"));
		score3.setScore(Bukkit.getOnlinePlayers().length);
		
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
