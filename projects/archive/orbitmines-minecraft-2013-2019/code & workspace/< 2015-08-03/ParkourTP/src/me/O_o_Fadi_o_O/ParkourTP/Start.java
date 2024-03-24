package me.O_o_Fadi_o_O.ParkourTP;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements Listener{
	
	public String TAG = "§8[§6§LOrbitMines§4§lNetwork§8]";
	
	World world;
	
	public static Location spawn[] = new Location[1];
	
	public void onEnable(){
		
		world = Bukkit.getWorld("OrbitMinesHub");
		
		spawn[0] = new Location(world, 404, 170, 3);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("parkourtp")) {
			if((sender instanceof Player)){
				player.sendMessage(TAG + " §7Teleporting...");
				player.teleport(spawn[0]);
			}
		}
		return false;
	}
}
