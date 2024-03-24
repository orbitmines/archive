package me.O_o_Fadi_o_O.OrbitMinesBungee.passes;

import java.util.UUID;

import me.O_o_Fadi_o_O.OrbitMinesBungee.utils.ServerData.ServerStorage;

public class Password {

	private UUID uuid;
	private String password;
	
	public Password(UUID uuid, String password){
		this.uuid = uuid;
		this.password = password;
		
		ServerStorage.passwords.add(this);
	}

	public UUID getUUID() {
		return uuid;
	}
	
	public String getPassword() {
		return password;
	}
}
