package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.Collection;
import java.util.List;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
	
	private PacketPlayOutChat actionbar;
	
	public ActionBar(String actionbar){
		if(actionbar != null){
			IChatBaseComponent a = ChatSerializer.a("{\"text\": \"" + actionbar + "\"}");
			this.actionbar = new PacketPlayOutChat(a, (byte) 2);
		}
	}
	public void send(Player... players){
		for(Player player : players){
			sendPlayer(player);
		}
	}
	
	public void send(List<Player> players){
		for(Player player : players){
			sendPlayer(player);
		}
	}
	
	public void send(Collection<? extends Player> players){
		for(Player player : players){
			sendPlayer(player);
		}
	}
	
	private void sendPlayer(Player player){
		if(this.actionbar != null){
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(actionbar);
		}
	}
}
