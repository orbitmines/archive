package me.O_o_Fadi_o_O.SpigotTestServer.events;

import me.O_o_Fadi_o_O.SpigotTestServer.Start;
import me.O_o_Fadi_o_O.SpigotTestServer.managers.ComponentMessageManager;
import me.O_o_Fadi_o_O.SpigotTestServer.managers.StorageManager;
import me.O_o_Fadi_o_O.SpigotTestServer.utils.Update;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		new BukkitRunnable(){
			public void run(){
				p.teleport(StorageManager.lobby);
				p.sendMessage("§7§m----------------------------------------");
				p.sendMessage(" §6§lSpigotMC.org §7- §6§lFadi§c§lDev§6's Projects");
				p.sendMessage(" ");
				p.sendMessage(" §7§lLatest Projects:");
				ComponentMessageManager.sendComponentMessage(p, "  §6§lSpigot§7§lSpleef §6" + Update.getLatestVersionSpigotSpleef() + " §7- ", "§e§l[Link]", "show_text", "open_url", "§6Click to Open Link:§7\n http://www.spigotmc.org/resources/spigotspleef.4997/", "http://www.spigotmc.org/resources/spigotspleef.4997/");
				ComponentMessageManager.sendComponentMessage(p, "  §6§lBungee§7§lMSG §6" + Update.getLatestVersionBungeeMSG() + " §7- ", "§e§l[Link]", "show_text", "open_url", "§6Click to Open Link:§7\n http://www.spigotmc.org/resources/bungeemsg.4512/", "http://www.spigotmc.org/resources/bungeemsg.4512/");
				p.sendMessage(" ");
				p.sendMessage("§7§m----------------------------------------");
			}
 		}.runTaskLater(Start.getInstance(), 5);
	}
}
