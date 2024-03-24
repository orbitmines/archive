package me.O_o_Fadi_o_O.Friends;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import me.O_o_Fadi_o_O.Friends.runnables.DatabaseRunnable;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {
	
	public static Connection connection;
	
	private DatabaseRunnable databaseRunnable = new DatabaseRunnable(this);
	
	public void onEnable(){
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		databaseRunnable.startDatabaseRunnable();
	}
	
	public void sendFriendsMessage(Player p){
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		p.sendMessage("§a§m----------------------------------------");
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
		p.sendMessage("§a§m----------------------------------------");
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
						
					}
				}
			}
			
		}
		
		return false;
	}
}
