package me.O_o_Fadi_o_O.Poll;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Hub.Hub;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends JavaPlugin implements Listener{
	
	public static List<String> PlayersVoted = new ArrayList<String>();
	static Connection connection;
	
	public static Hub Hub;
	
	public void onEnable(){
		
		Hub = (Hub) getServer().getPluginManager().getPlugin("Hub");
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		for(String s : getConfig().getStringList("PlayersVoted")){
			PlayersVoted.add(s);
		}
	
		new BukkitRunnable(){

			@Override
			public void run() {
				
				openConnection();
				
			}
		}.runTaskAsynchronously(this);
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
	public void addOMT(Player p, int OMT) throws SQLException{
		Statement s = connection.createStatement();
		s.executeUpdate("UPDATE `OrbitMinesTokens` SET `omt` = '" + (getOMT(p) + OMT) + "' WHERE `name` = '" + p.getName() + "'");
		me.O_o_Fadi_o_O.Hub.managers.StorageManager.omt.put(p.getName(), getOMT(p));
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
	
	public void sendPollMessage(Player p){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
		p.sendMessage("");
		p.sendMessage("§6§lPoll §8| §eO_o_Fadi_o_O, the Server Owner/Developer, is working hard to get everything updated. What do you want to be updated first?");
		p.sendMessage("");
		
		{
			IChatBaseComponent comp = ChatSerializer
			.a("{\"text\":\" \",\"extra\":[{\"text\":\"§b§lVIP Update\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§eClick Here to Vote for '§b§lVIP Update§e'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/pollvote vipupdate\"}}]}");
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
		{
			IChatBaseComponent comp = ChatSerializer
			.a("{\"text\":\" \",\"extra\":[{\"text\":\"§4§lPrison Update\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§eClick Here to Vote for '§4§lPrison Update§e'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/pollvote prisonupdate\"}}]}");
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
		{
			IChatBaseComponent comp = ChatSerializer
			.a("{\"text\":\" \",\"extra\":[{\"text\":\"§a§lSurvival Update\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§eClick Here to Vote for '§a§lSurvival Update§e'\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/pollvote survivalupdate\"}}]}");
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
		p.sendMessage("");
		p.sendMessage("§eVote in the Poll and get §b§l20 VIP Points§e! (Click on a Line)");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		final Player p = e.getPlayer();
		
		new BukkitRunnable(){
			
			@Override
			public void run(){
				
				if(!PlayersVoted.contains(p.getName())){
					sendPollMessage(p);
				}
				
			}
		}.runTaskLater(this, 40 * 2);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,String l, String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("pollvote")){
			
			if(sender instanceof Player){
				
				Player p = (Player) sender;
				
				if(a.length == 0){
					
				}
				else if(a[0].equalsIgnoreCase("vipupdate")){
					
					if(!PlayersVoted.contains(p.getName())){
						
						PlayersVoted.add(p.getName());
						getConfig().set("PlayersVoted", PlayersVoted);
						
						List<String> list = getConfig().getStringList("VotedForVIPUpdate");
						list.add(p.getName());
						getConfig().set("VotedForVIPUpdate", list);
						
						getConfig().set("VIPUpdate", getConfig().getInt("VIPUpdate") +1);
						saveConfig();
						
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
						p.sendMessage("");
						p.sendMessage("§6§lPoll §8| §eThanks for your Vote!");
						p.sendMessage("§6§lPoll §8| §eYou voted for the §b§lVIP Update§e.");
						p.sendMessage("§6§lPoll §8| §b§l+20 VIP Points");
						p.sendMessage("");
						
						try {
							addVIPPoints(p, 20);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				else if(a[0].equalsIgnoreCase("prisonupdate")){
					
					if(!PlayersVoted.contains(p.getName())){
						
						PlayersVoted.add(p.getName());
						getConfig().set("PlayersVoted", PlayersVoted);
						
						List<String> list = getConfig().getStringList("VotedForPrisonUpdate");
						list.add(p.getName());
						getConfig().set("VotedForPrisonUpdate", list);
						
						getConfig().set("PrisonUpdate", getConfig().getInt("PrisonUpdate") +1);
						saveConfig();
						
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
						p.sendMessage("");
						p.sendMessage("§6§lPoll §8| §eThanks for your Vote!");
						p.sendMessage("§6§lPoll §8| §eYou voted for the §4§lPrison Update§e.");
						p.sendMessage("§6§lPoll §8| §b§l+20 VIP Points");
						p.sendMessage("");
						
						try {
							addVIPPoints(p, 20);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				else if(a[0].equalsIgnoreCase("survivalupdate")){
					
					if(!PlayersVoted.contains(p.getName())){
						
						PlayersVoted.add(p.getName());
						getConfig().set("PlayersVoted", PlayersVoted);
						
						List<String> list = getConfig().getStringList("VotedForSurvivalUpdate");
						list.add(p.getName());
						getConfig().set("VotedForSurvivalUpdate", list);
						
						getConfig().set("SurvivalUpdate", getConfig().getInt("SurvivalUpdate") +1);
						saveConfig();
						
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
						p.sendMessage("");
						p.sendMessage("§6§lPoll §8| §eThanks for your Vote!");
						p.sendMessage("§6§lPoll §8| §eYou voted for the §a§lSurvival Update§e.");
						p.sendMessage("§6§lPoll §8| §b§l+20 VIP Points");
						p.sendMessage("");
						
						try {
							addVIPPoints(p, 20);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		
		return false;
	}
}
