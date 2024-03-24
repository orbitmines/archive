package me.O_o_Fadi_o_O.OrbitMinesPvP;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import me.O_o_Fadi_o_O.OrbitMinesPvP.events.ArrowPickup;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.BowShot;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.ClickEvent;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.DamageEvent;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.EnderpearlTeleport;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.InventoryClick;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.ItemDrop;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.JoinEvent;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.PlayerDeath;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.ProjectileHit;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.QuitEvent;
import me.O_o_Fadi_o_O.OrbitMinesPvP.events.SignsColor;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.SellMaterials;
import me.O_o_Fadi_o_O.OrbitMinesPvP.inventories.SwordShop;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Start extends JavaPlugin implements Listener{
	
	public static HashMap<String, Integer> WeaponTier = new HashMap<String, Integer>();
	public static HashMap<String, Integer> WeaponTierEquiped = new HashMap<String, Integer>();
	public HashMap<String, String> CurrentMap = new HashMap<String, String>();
	public static ArrayList<Projectile> arrow = new ArrayList<Projectile>();
	
	public static String Join = "§a[PvP] Join§2>> §6§l";

	public void onEnable(){
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ArrowPickup(), this);
		getServer().getPluginManager().registerEvents(new BowShot(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getServer().getPluginManager().registerEvents(new EnderpearlTeleport(), this);
		getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
		getServer().getPluginManager().registerEvents(new ItemDrop(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new SignsColor(), this);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			 
            public void run() {
                for(Projectile arrows : arrow){
                    for(Player online : Bukkit.getOnlinePlayers()){
                        Location loc = arrows.getLocation();
                        ((CraftPlayer) online).getHandle().playerConnection
                                .sendPacket(new PacketPlayOutWorldParticles(
                                        "lava", (float) loc.getX(),
                                        (float) loc.getY(), (float) loc.getZ(), 1,
                                        1, 1,(float) 0, 6));
                    }
                    }
                }
 
        }, 0, 1 / 5);
		
		for(Entity e : Bukkit.getWorld("world").getEntities()){
			if(e instanceof Villager){
				e.remove();
			}
		}
		
	}
	
	public void MapScoreboard(Player p){
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("Test1", "Test2");
		objective.setDisplayName("§4§lMap: " + CurrentMap.get(p.getName()));
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score score1 = objective.getScore("§cEnemies:");
		score1.setScore(2);
		
		Score score2 = objective.getScore("§aAllies:");
		score2.setScore(1);
		
		int level = getConfig().getInt("players." + p.getName() + ".Level");
		 
        Team team = board.registerNewTeam("Mars");
        team.setPrefix("§c[§6" + level + "§c] ");
        
        Team team2 = board.registerNewTeam("Earth");
        team2.setPrefix("§b[§6" + level + "§b] ");
        
        Team team3 = board.registerNewTeam("Venus");
        team3.setPrefix("§a[§6" + level + "§a] ");
        
        Team team4 = board.registerNewTeam("None");
        team4.setPrefix("§f[§6" + level + "§f] ");
 
        for(Player online : Bukkit.getOnlinePlayers()) {
            if(getConfig().getString("players." + online.getName() + ".Team").equals("Mars")) {
                team.addPlayer(online);
                
                if(team2.hasPlayer(online)){
                team2.removePlayer(online);
                }
                if(team3.hasPlayer(online)){
                team3.removePlayer(online);
                }
                if(team4.hasPlayer(online)){
                    team4.removePlayer(online);
                }
            }
            if(getConfig().getString("players." + online.getName() + ".Team").equals("Earth")) {
                team2.addPlayer(online);
                
                if(team.hasPlayer(online)){
                team.removePlayer(online);
                }
                if(team3.hasPlayer(online)){
                team3.removePlayer(online);
                }
                if(team4.hasPlayer(online)){
                    team4.removePlayer(online);
                }
            }
            if(getConfig().getString("players." + online.getName() + ".Team").equals("Venus")) {
                team3.addPlayer(online);
                
                if(team.hasPlayer(online)){
            	team.removePlayer(online);
                }
                if(team2.hasPlayer(online)){
                team2.removePlayer(online);
                }
                if(team4.hasPlayer(online)){
                    team4.removePlayer(online);
                }
            }
            if(getConfig().getString("players." + online.getName() + ".Team").equals("None")) {
            	team4.addPlayer(online);
            	
                if(team.hasPlayer(online)){
            	team.removePlayer(online);
                }
                if(team2.hasPlayer(online)){
                team2.removePlayer(online);
                }
                if(team3.hasPlayer(online)){
                    team3.removePlayer(online);
                }
            }
        }
        
        p.setScoreboard(board);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] a) {

			if(sender instanceof Player){
				Player p = (Player)sender;
				
				if(cmd.getName().equalsIgnoreCase("sellshop")){
					p.sendMessage("§8[§c§lMaterials§8] §7Opening Materials Sell Shop...");
					p.openInventory(SellMaterials.getSellMaterialsInventory());
					
				}
				if(cmd.getName().equalsIgnoreCase("swordshop")){
					p.sendMessage("§8[§9§lWeapons§8] §7Opening The Weapons Shop...");
					p.openInventory(SwordShop.getSwordShopInventory(p));
					
				}
			}
			return false;
	}
	
	// API
	public void addCoins(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".Coins", getConfig().getInt("players." + p.getName() + ".Coins") + i);
		saveConfig();
		MapScoreboard(p);
	}
	
	public void addGold(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".Gold", getConfig().getInt("players." + p.getName() + ".Gold") + i);
		saveConfig();
		MapScoreboard(p);
	}
	public void removeCoins(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".Coins", getConfig().getInt("players." + p.getName() + ".Coins") - i);
		saveConfig();
		MapScoreboard(p);
	}
	
	public void removeGold(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".Gold", getConfig().getInt("players." + p.getName() + ".Gold") - i);
		saveConfig();
		MapScoreboard(p);
	}
	public void addDeath(Player p){
		
		getConfig().set("players." + p.getName() + ".Deaths", getConfig().getInt("players." + p.getName() + ".Deaths") + 1);
		saveConfig();
	}
	
	public void addKill(Player p){
		
		getConfig().set("players." + p.getName() + ".Kills", getConfig().getInt("players." + p.getName() + ".Kills") + 1);
		saveConfig();
	}
	public void setWeaponTier(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".WeaponTier", i);
		WeaponTier.put(p.getName(), i);
		saveConfig();
	}
	public void setWeaponTierEquiped(Player p, int i){
		
		getConfig().set("players." + p.getName() + ".WeaponTierEquiped", i);
		WeaponTierEquiped.put(p.getName(), i);
		saveConfig();
	}
	
	@EventHandler
	public void onPlayerExpChange(PlayerExpChangeEvent e) {
		Player p = e.getPlayer();
		
		int level = getConfig().getInt("players." + p.getName() + ".Level");
		
			getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){
				
				p.setLevel(level);
				p.setExp(1);
				
			}
		}, 1L);
	}
}
