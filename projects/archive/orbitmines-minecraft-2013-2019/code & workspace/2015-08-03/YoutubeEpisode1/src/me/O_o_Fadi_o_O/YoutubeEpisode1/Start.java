package me.O_o_Fadi_o_O.YoutubeEpisode1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		
		if(cmd.getName().equalsIgnoreCase("message")){
			
			sender.sendMessage("§6Test Bericht!");
			
		}
		
		if(cmd.getName().equalsIgnoreCase("message2")){
			
			if((sender instanceof Player)){
				Player p = (Player)sender;
				p.sendMessage("§6Player Test Bericht!");
			}
			else{
				sender.sendMessage("§cDit kan niet door de Console!");
			}
			
		}
		
		return false;
	}
}
