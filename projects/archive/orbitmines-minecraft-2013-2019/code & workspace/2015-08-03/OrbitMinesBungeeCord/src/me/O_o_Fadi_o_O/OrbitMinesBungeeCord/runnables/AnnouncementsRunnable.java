package me.O_o_Fadi_o_O.OrbitMinesBungeeCord.runnables;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class AnnouncementsRunnable implements Runnable {

	private int i = 0;
	private String message = "";
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		setNextAnnouncement();
		
		for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){
			p.sendMessage(message);
		}
	}
	
	private void setNextAnnouncement(){
		i++;
		
		if(i == 1){
			message = "§7\n » §7Follow News & Updates at §6www.orbitmines.com §7« \n§7";
		}
		else if(i == 2){
			message = "§7\n » §7Don't forget to Vote with §b/vote §7« \n§7";
		}
		else if(i == 3){
			message = "§7\n » OrbitMines 1.8 §e§lBETA§7. Report bugs at §6www.orbitmines.com §7« \n§7";
		}
		else if(i == 4){
			message = "§7\n » §7Check out §b@OrbitMines§7 on Twitter §7« \n§7";
		}
		else if(i == 5){
			message = "§7\n » §7Support OrbitMines at §3shop.orbitmines.com §7« \n§7";
		}
		else if(i == 6){
			message = "§7\n » §7OrbitMines IP: §6Hub.OrbitMinesMC.com §7« \n§7";
		}
		else if(i == 7){
			message = "§7\n » OrbitMines 1.8 §e§lBETA§7. Report bugs at §6www.orbitmines.com §7« \n§7";
		}
		else if(i == 8){
			message = "§7\n » Report a player with §c/report <player> <reason> §7« \n§7";
		}
		else{
			i = 0;
			setNextAnnouncement();
		}
	}
}
