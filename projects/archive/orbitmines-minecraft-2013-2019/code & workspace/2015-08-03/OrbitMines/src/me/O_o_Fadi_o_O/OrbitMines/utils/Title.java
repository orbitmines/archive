package me.O_o_Fadi_o_O.OrbitMines.utils;

import java.util.Collection;
import java.util.List;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title {
	
	private PacketPlayOutTitle title;
	private PacketPlayOutTitle subtitle;
	private PacketPlayOutTitle time;
	
	public Title(String title, String subtitle){
		if(title != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + title + "\"}");
			this.title = new PacketPlayOutTitle(EnumTitleAction.TITLE, m);
		}
		if(subtitle != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
			this.subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, m);
		}
	}
	
	public Title(String title, String subtitle, int fadein, int set, int fadeout){
		if(title != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + title + "\"}");
			this.title = new PacketPlayOutTitle(EnumTitleAction.TITLE, m);
		}
		if(subtitle != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
			this.subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, m);
		}
		
		IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + "" + "\"}");
		this.time = new PacketPlayOutTitle(EnumTitleAction.TIMES, m, fadein, set, fadeout);
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
		if(this.title != null){
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
		}
		if(this.subtitle != null){
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(subtitle);
		}
		if(this.time != null){
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(time);
		}
	}
}
