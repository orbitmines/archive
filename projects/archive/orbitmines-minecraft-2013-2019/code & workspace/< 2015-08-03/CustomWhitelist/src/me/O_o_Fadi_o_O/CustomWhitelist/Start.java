package me.O_o_Fadi_o_O.CustomWhitelist;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	public String TAG = "§8[§f§lWhitelist§8]";

	public String KickMessage = "&6CustomWhitelist by O_o_Fadi_o_O";
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}
		
		KickMessage = getConfig().getString("KickMessage");
	}
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(!p.isWhitelisted()){
			String k = KickMessage.replaceAll("%player%", p.getName()).replaceAll("&", "§");
			e.setKickMessage(k);
			e.setResult(Result.KICK_WHITELIST);
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("wl")){
		
		if((sender instanceof Player)){
			Player player = (Player)sender;
			
				if(player.hasPermission("Whitelist.Admin") || player.hasPermission("Whitelist.*")){
				
					if (a.length != 1){
					
						player.sendMessage(TAG + " §cIncorrect Use! §f/wl help");
					
					}
					else if(a.length == 1){
						
						if(a[0].equalsIgnoreCase("help")){
							
						player.sendMessage(TAG + " §fCustomWhitelist v1.0 §7by §fO_o_Fadi_o_O");
						player.sendMessage(TAG + " §7All Commands:");
						player.sendMessage(TAG + " §f/wl help");
						player.sendMessage(TAG + " §f/wl reload");
					
					} 
					else if(a[0].equalsIgnoreCase("reload")){
					
						player.sendMessage(TAG + " §aReloading...");

						reloadConfig();
						KickMessage = getConfig().getString("KickMessage");
					
						player.sendMessage(TAG + " §aReload Complete!");
					
					}
					else{
						player.sendMessage(TAG + " §cIncorrect Use!: §f/wl help");
					}
					}
				}
				else{
					sender.sendMessage("§cAccess Denied!");
				}
			}
			else{
				sender.sendMessage(TAG + " §fYou can't perform commands through the Console!");
			}
		return true;
		}
		return false;
	}
}
