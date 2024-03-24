package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.util.List;


public class BannedIP {

	private String ip;
	private String bannedby;
	private String reason;
	private String bannedon;
	private String banneduntil;
	
	public BannedIP(String ip, String bannedby, String reason, String bannedon, String banneduntil){
		this.ip = ip;
		this.bannedby = bannedby;
		this.reason = reason;
		this.bannedon = bannedon;
		this.banneduntil = banneduntil;

		ServerData.getBungee().getBannedIPs().add(this);
	}

	public String getIP() {
		return ip;
	}

	public String getBannedBy() {
		return bannedby;
	}

	public String getReason() {
		return reason;
	}

	public String getBannedOn() {
		return bannedon;
	}

	public String getBannedUntil() {
		return banneduntil;
	}
	
	public static List<BannedIP> getBannedIPs(){
		return ServerData.getBungee().getBannedIPs();
	}
	public static BannedIP getBannedIP(String ip){
		for(BannedIP bannedip : ServerData.getBungee().getBannedIPs()){
			if(bannedip.getIP().equals(ip)){
				return bannedip;
			}
		}
		return null;
	}
}
