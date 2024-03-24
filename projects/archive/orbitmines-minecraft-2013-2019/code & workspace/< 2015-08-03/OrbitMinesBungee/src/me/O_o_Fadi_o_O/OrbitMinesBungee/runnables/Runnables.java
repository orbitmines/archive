package me.O_o_Fadi_o_O.OrbitMinesBungee.runnables;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import me.O_o_Fadi_o_O.OrbitMinesBungee.managers.DefaultPingManager;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.BungeePlayer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Database;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData.BungeeServer;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils;
import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.Utils.StaffRank;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.scheduler.BungeeScheduler;

public class Runnables {

	public void startRunnables(Plugin plugin){
		new BungeeScheduler(){}.schedule(plugin, new StaffAnnouncementsRunnable(), 0, 15, TimeUnit.MINUTES);
		new BungeeScheduler(){}.runAsync(plugin, new DatabaseRunnable());
		new BungeeScheduler(){}.schedule(plugin, new LoginRunnable(), 0, 1, TimeUnit.SECONDS);
		new BungeeScheduler(){}.schedule(plugin, new MOTDRunnable(), 0, 20, TimeUnit.MILLISECONDS);
		new BungeeScheduler(){}.schedule(plugin, new AnnouncementsRunnable(), 0, 5, TimeUnit.MINUTES);
	}
	
	public class DatabaseRunnable implements Runnable {
		
		@Override
		public void run(){
			Database.get().openConnection();
		}
	}
	
	public class MOTDRunnable implements Runnable {

		@Override
		public void run() {
			DefaultPingManager.setNextOrbitMinesTitle();
		}
	}
	
	public class LoginRunnable implements Runnable {
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			for(BungeePlayer bp : BungeePlayer.getPlayers()){
				ProxiedPlayer p = bp.getPlayer();
				
				if(bp.hasPassword() && !bp.isLoggedIn()){
					bp.tickLoginTimer();
					
					if(bp.getLoginTime() == 0){
						p.disconnect("§4§lSTAFF PROTECTION\n§7Kicked!");
					}
					else{
						Title t = ProxyServer.getInstance().createTitle();
						t.fadeIn(0);
						t.fadeOut(0);
						t.stay(40);
						t.title(new TextComponent("§4§lSTAFF PROTECTION"));
						t.subTitle(new TextComponent("§7" + bp.getLoginTime() + "..."));
						t.send(p);
					}
				}
			}
		}
	}
	
	public class StaffAnnouncementsRunnable implements Runnable {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			for(BungeePlayer bp : BungeePlayer.getPlayers()){
				ProxiedPlayer p = bp.getPlayer();
				
				if(bp.hasPerms(StaffRank.Moderator)){
					if(new Random().nextBoolean()){
						p.sendMessage("§7Use §d/staffMSG§7 to toggle §dStaff Messages§7. (" + Utils.statusString(bp.canShowStaffMessage()) + "§7)");
					}
					else{
						p.sendMessage("§7Use §d@§7 to talk in the §dStaff Chat§7.");
					}
				}
			}
		}
	}
	
	public class AnnouncementsRunnable implements Runnable {
		
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			BungeeServer bungee = ServerData.getBungee();
			int index = bungee.getNextAnnouncementIndex();
			
			for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
				p.sendMessage(bungee.getAnnouncements().get(index));
			}
		}
	}
}
