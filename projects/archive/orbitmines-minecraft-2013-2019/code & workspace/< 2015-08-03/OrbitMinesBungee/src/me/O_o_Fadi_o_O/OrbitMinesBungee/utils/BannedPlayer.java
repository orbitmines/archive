package me.O_o_Fadi_o_O.OrbitMinesBungee.utils;

import java.util.List;
import java.util.UUID;

public class BannedPlayer {

	private UUID uuid;
	private String bannedby;
	private String reason;
	private String bannedon;
	private String banneduntil;
	
	public BannedPlayer(UUID uuid, String bannedby, String reason, String bannedon, String banneduntil){
		this.uuid = uuid;
		this.bannedby = bannedby;
		this.reason = reason;
		this.bannedon = bannedon;
		this.banneduntil = banneduntil;
		
		ServerData.getBungee().getBannedPlayers().add(this);
	}

	public UUID getUUID() {
		return uuid;
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
	
	public static List<BannedPlayer> getBannedPlayers(){
		return ServerData.getBungee().getBannedPlayers();
	}
	public static BannedPlayer getBannedPlayer(UUID uuid){
		for(BannedPlayer bannedp : ServerData.getBungee().getBannedPlayers()){
			if(bannedp.getUUID().toString().equals(uuid.toString())){
				return bannedp;
			}
		}
		return null;
	}
}
