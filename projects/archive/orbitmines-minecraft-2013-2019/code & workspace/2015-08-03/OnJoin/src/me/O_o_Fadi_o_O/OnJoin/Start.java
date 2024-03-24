package me.O_o_Fadi_o_O.OnJoin;

import java.io.File;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener {
	
	public String JoinMessage = "&8[&a&lJoin&8]&6&l %player%";
	public String LeaveMessage = "&8[&4&lQuit&8]&6&l %player%";
	
	public List<String> PlayerJoinMessage = getConfig().getStringList("PlayerJoinMessage");
	
	public boolean EnableJoinMessage = true;
	public boolean EnableLeaveMessage = true;
	
	public boolean EnablePlayerJoinMessage = true;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		// LOAD CONFIG
		JoinMessage = getConfig().getString("JoinMessage");
		LeaveMessage = getConfig().getString("LeaveMessage");
		
		EnableJoinMessage = getConfig().getBoolean("EnableJoinMessage");
		EnableLeaveMessage = getConfig().getBoolean("EnableLeaveMessage");
		
		PlayerJoinMessage = getConfig().getStringList("PlayerJoinMessage");
		
		EnablePlayerJoinMessage = getConfig().getBoolean("EnablePlayerJoinMessage");
		
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		if(e.getJoinMessage() != null){
			Player p = e.getPlayer();
			if(EnableJoinMessage == true){
				
				String m = JoinMessage.replaceAll("%player%", p.getName()).replaceAll("&", "§");
				e.setJoinMessage(m);
			}
			else{
				e.setJoinMessage(null);
			}
			
			if(EnablePlayerJoinMessage == true){
				
				
				for (String s : PlayerJoinMessage)
					p.sendMessage(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
			}
			
		}	
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		if(e.getQuitMessage() != null){
			Player p = e.getPlayer();
			if(EnableLeaveMessage == true){
				
				String m = LeaveMessage.replaceAll("%player%", p.getName()).replaceAll("&", "§");
				e.setQuitMessage(m);
			}
			else{
				e.setQuitMessage(null);
			}
			
		}	
	}
	
	// COMMANDS
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label,
				String[] a) {
			
			if(cmd.getName().equalsIgnoreCase("onjoin")){
			
			if((sender instanceof Player)){
				Player player = (Player)sender;
				
					if(player.hasPermission("OnJoin.Admin") || player.hasPermission("OnJoin.*")){
					
						if (a.length != 1){
						
							player.sendMessage("§8[§a§lOnJoin§8] §cIncorrect Use! §6/onjoin help");
						
						} // HELP COMMAND
						else if(a.length == 1){
							
							if(a[0].equalsIgnoreCase("help")){
						
							player.sendMessage("§8[§a§lOnJoin§8] §aOnJoin §7by §aO_o_Fadi_o_O");
							player.sendMessage("§8[§a§lOnJoin§8] §7All Commands:");
							player.sendMessage("§8[§a§lOnJoin§8] §a/onjoin help §7(Show this Menu)");
							player.sendMessage("§8[§a§lOnJoin§8] §a/onjoin reload §7(Reload the Plugin)");
						
						} // RELOAD COMMAND
						else if(a[0].equalsIgnoreCase("reload")){
						
							player.sendMessage("§8[§a§lOnJoin§8] §7Reloading...");

							reloadConfig();
							JoinMessage = getConfig().getString("JoinMessage");
							LeaveMessage = getConfig().getString("LeaveMessage");
							
							EnableJoinMessage = getConfig().getBoolean("EnableJoinMessage");
							EnableLeaveMessage = getConfig().getBoolean("EnableLeaveMessage");
							
							EnablePlayerJoinMessage = getConfig().getBoolean("EnablePlayerJoinMessage");
							PlayerJoinMessage = getConfig().getStringList("PlayerJoinMessage");
						
							player.sendMessage("§8[§a§lOnJoin§8] §7Reload Complete!");
						
						}
						else{
							player.sendMessage("§8[§a§lOnJoin§8] §cIncorrect Use! §f'/onjoin " + a[0] + "'");
							player.sendMessage("§8[§a§lOnJoin§8] §cHelp: §6/onjoin help");
						}
						}
					}
					else{
						sender.sendMessage("§cAccess Denied!");
					}
				}
				else{
					sender.sendMessage("§8[§a§lOnJoin§8] §aYou can't perform commands through the console!");
				}
			return true;
			}
			return false;
		}
}
