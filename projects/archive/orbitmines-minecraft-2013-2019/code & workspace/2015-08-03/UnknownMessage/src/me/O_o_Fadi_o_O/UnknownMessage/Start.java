package me.O_o_Fadi_o_O.UnknownMessage;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	public String UnknownMessage = "&8[&3&lUnknownMessage&8] &7Unable to find the &3%command% &7command!";
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		UnknownMessage = getConfig().getString("UnknownMessage");
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			
			String s = e.getMessage().split(" ") [0];
			
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(s);
			
			if(topic == null){
				String m = UnknownMessage.replaceAll("%command%", s).replaceAll("&", "§"); 
				
				p.sendMessage(m);
				e.setCancelled(true);
			}
		}
		
	}	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("unknownmessage") || cmd.getName().equalsIgnoreCase("um") || cmd.getName().equalsIgnoreCase("umsg")){
		
		if((sender instanceof Player)){
			Player player = (Player)sender;
			
				if(player.hasPermission("UnknownMessage.Admin") || player.hasPermission("UnknownMessage.*")){
				
					if (a.length != 1){
					
						player.sendMessage("§8[§3§lUnknownMessage§8] §cIncorrect Use! §6/unknownmessage help");
					
					} // HELP COMMAND
					else if(a.length == 1){
						
						if(a[0].equalsIgnoreCase("help")){
					
						player.sendMessage("§8[§3§lUnknownMessage§8] §3UnknownMessage v1.0 §7by §3O_o_Fadi_o_O");
						player.sendMessage("§8[§3§lUnknownMessage§8] §7All Commands:");
						player.sendMessage("§8[§3§lUnknownMessage§8] §3/unknownmessage help §7(Show this Menu)");
						player.sendMessage("§8[§3§lUnknownMessage§8] §3/unknownmessage reload §7(Reload the Plugin)");
					
					} // RELOAD COMMAND
					else if(a[0].equalsIgnoreCase("reload")){
					
						player.sendMessage("§8[§3§lUnknownMessage§8] §7Reloading...");

						reloadConfig();
						UnknownMessage = getConfig().getString("UnknownMessage");
					
						player.sendMessage("§8[§3§lUnknownMessage§8] §7Reload Complete!");
					
					}
					else{
						player.sendMessage("§8[§3§lUnknownMessage§8] §cIncorrect Use! §3/unknownmessage help §f'/unknownmessage " + a[0] + "'");
						player.sendMessage("§8[§3§lUnknownMessage§8] §cHelp: §6/unknownmessage help");
					}
					}
				}
				else{
					sender.sendMessage("§cAccess Denied!");
				}
			}
			else{
				sender.sendMessage("§8[§3§lUnknownMessage§8] §3You can't perform commands through the console!");
			}
		return true;
		}
		return false;
	}
}
