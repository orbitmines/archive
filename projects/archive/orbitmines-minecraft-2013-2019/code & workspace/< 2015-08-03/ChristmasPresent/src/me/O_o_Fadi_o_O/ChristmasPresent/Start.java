package me.O_o_Fadi_o_O.ChristmasPresent;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

public class Start extends JavaPlugin implements Listener{
	
	public static List<String> PlayersReceivedPresent = new ArrayList<String>();
	static Connection connection;
	
	public static Hub Hub;
	
	public Song LetItGo = NBSDecoder.parse(new File(getDataFolder(), "LetItGo.nbs"));
	public Song TheFirstNoel = NBSDecoder.parse(new File(getDataFolder(), "TheFirstNoël.nbs"));
	public Song TheChristmasSong = NBSDecoder.parse(new File(getDataFolder(), "TheChristmasSong.nbs"));
	public Song LetItSnow = NBSDecoder.parse(new File(getDataFolder(), "LetItSnow.nbs"));
	public SongPlayer sp = null;
	
	public String SongPlaying = "";
	
	public void onEnable(){
		
		Hub = (Hub) getServer().getPluginManager().getPlugin("Hub");
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		for(String s : getConfig().getStringList("PlayersReceivedPresent")){
			PlayersReceivedPresent.add(s);
		}
	
		new BukkitRunnable(){

			@Override
			public void run() {
				
				openConnection();
				
			}
		}.runTaskAsynchronously(this);
		
		setLetItGoPlaying();
	}
	
	public void onDisable(){
		sp.setPlaying(false);
	}
	
	public void setLetItGoPlaying(){
		sp = new RadioSongPlayer(LetItGo);
		sp.setAutoDestroy(false);
		sp.setPlaying(true);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			sp.addPlayer(p);
			p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
			p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lLet It Go§7.");		
		}
		
		SongPlaying = "LetItGo";
		
		new BukkitRunnable(){
			public void run(){
				setTheFirstNoelPlaying();
			}
		}.runTaskLater(this, 20 * (180 + 70));
	}
	
	public void setTheFirstNoelPlaying(){
		sp = new RadioSongPlayer(TheFirstNoel);
		sp.setAutoDestroy(false);
		sp.setPlaying(true);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			sp.addPlayer(p);
			p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
			p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lThe First Noël§7.");
		}
		
		SongPlaying = "TheFirstNoel";
		
		new BukkitRunnable(){
			public void run(){
				setTheChristmasSongPlaying();
			}
		}.runTaskLater(this, 20 * (230));
	}
	
	public void setTheChristmasSongPlaying(){
		sp = new RadioSongPlayer(TheChristmasSong);
		sp.setAutoDestroy(false);
		sp.setPlaying(true);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			sp.addPlayer(p);
			p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
			p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lThe Christmas Song§7.");
		}
		
		SongPlaying = "TheChristmasSong";
		
		new BukkitRunnable(){
			public void run(){
				setLetItSnowPlaying();
			}
		}.runTaskLater(this, 20 * (120 + 20));
	}
	
	public void setLetItSnowPlaying(){
		sp = new RadioSongPlayer(LetItSnow);
		sp.setAutoDestroy(false);
		sp.setPlaying(true);
		
		for(Player p : Bukkit.getOnlinePlayers()){
			sp.addPlayer(p);
			p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
			p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lLet It Snow§7.");
		}
		
		SongPlaying = "LetItSnow";
		
		new BukkitRunnable(){
			public void run(){
				setLetItGoPlaying();
			}
		}.runTaskLater(this, 20 * (120 + 10));
	}
	
	public synchronized void openConnection(){
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://sql-3.verygames.net:3306/minecraft4268", "minecraft4268", "hnfxy5h48");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void addVIPPoints(Player p, int VIPPoints) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `VIPPoints` SET `points` = '" + (getVIPPoints(p) + VIPPoints) + "' WHERE `name` = '" + p.getName() + "'");
		me.O_o_Fadi_o_O.Hub.managers.StorageManager.points.put(p.getName(), getVIPPoints(p));
	}
	
	public int getVIPPoints(Player p){
		int omt = 0;
		
		String query = "SELECT `points` FROM `VIPPoints` WHERE `name` = '" + p.getName() + "'"; 
		
		try{
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			
			while (rs.next()) {
				omt = rs.getInt("points");
			}
			
			rs.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return omt;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		new BukkitRunnable(){
			
			@Override
			public void run(){
				
				Calendar c = Calendar.getInstance();
				
				Date now = new Date(c.getTimeInMillis()); 
		        SimpleDateFormat sd = new SimpleDateFormat();
		        sd.applyPattern("dd-MM-yyyy");
		        String today = sd.format(now);
				
		        if(today.equals("25-12-2014")){
					if(!PlayersReceivedPresent.contains(p.getName())){
						p.sendMessage("§c§lX-Mas §8| §7Merry Christmas! Get a present at the §eChristmas Tree§7!");
					}
		        }
		        
				p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
				if(SongPlaying.equals("LetItGo")){
					p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lLet It Go§7.");		
				}
				if(SongPlaying.equals("TheFirstNoel")){
					p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lThe First Noël§7.");		
				}
				if(SongPlaying.equals("TheChristmasSong")){
					p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lThe ChristmasSong§7.");		
				}
				if(SongPlaying.equals("LetItSnow")){
					p.sendMessage("§c§lX-Mas §8| §7Currently Playing: §e§lLet It Snow§7.");		
				}
				
				sp.addPlayer(p);
				
			}
		}.runTaskLater(this, 50 * 2);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		
		if(b != null && b.getType() != null && b.getType() == Material.CHEST){
			
			e.setCancelled(true);
			
			Calendar c = Calendar.getInstance();
			
			Date now = new Date(c.getTimeInMillis()); 
	        SimpleDateFormat sd = new SimpleDateFormat();
	        sd.applyPattern("dd-MM-yyyy");
	        String today = sd.format(now);
			
	        if(today.equals("25-12-2014")){
				if(!PlayersReceivedPresent.contains(p.getName())){
					
					List<String> players = PlayersReceivedPresent;
					players.add(p.getName());
					
					PlayersReceivedPresent = players;
					
					getConfig().set("PlayersReceivedPresent", players);
					saveConfig();
					
					int rInt = new Random().nextInt(10);
					
					int givenVIPPoints = 0;
					
					if(rInt == 0){givenVIPPoints = 148 + 50;}
					if(rInt == 1){givenVIPPoints = 197 + 50;}
					if(rInt == 2){givenVIPPoints = 217 + 50;}
					if(rInt == 3){givenVIPPoints = 153 + 50;}
					if(rInt == 4){givenVIPPoints = 137 + 50;}
					if(rInt == 5){givenVIPPoints = 248 + 50;}
					if(rInt == 6){givenVIPPoints = 198 + 50;}
					if(rInt == 7){givenVIPPoints = 170 + 50;}
					if(rInt == 8){givenVIPPoints = 272 + 50;}
					if(rInt == 9){givenVIPPoints = 185 + 50;}
					
					Bukkit.broadcastMessage("§c§lX-Mas §8| §c" + p.getName() + "§7 got §b§l" + givenVIPPoints +" VIP Points§7 and the §fSnowman Disguise§7 from their §ePresent§7!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
					
					Location l = p.getLocation();
					
			        FireworkEffect.Builder builder = FireworkEffect.builder();
			        
			        FireworkEffect effect = builder.flicker(true).trail(true).withColor(Color.RED).withColor(Color.MAROON).withFade(Color.GRAY).withFade(Color.SILVER).with(FireworkEffect.Type.BALL).build();

			        CustomFirework.spawn(l, effect, Bukkit.getOnlinePlayers());
					
					try {
						addVIPPoints(p, givenVIPPoints);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					me.O_o_Fadi_o_O.Hub.managers.StorageManager.disSnowman.put(p.getName(), 1);
					me.O_o_Fadi_o_O.Hub.managers.DatabaseManager.insertInt(p.getName(), "Dis-Snowman", "snowman", 1);
				}
	        }
	        else{
	        	p.sendMessage("§c§lX-Mas §8| §7You have to wait until the §e25th of December§7!");
	        }
		}
	}
}
