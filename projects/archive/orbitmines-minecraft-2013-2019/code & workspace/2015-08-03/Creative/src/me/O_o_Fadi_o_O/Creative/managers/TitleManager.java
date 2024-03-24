package me.O_o_Fadi_o_O.Creative.managers;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class TitleManager {
	
	public static void setTitle(Player p, String title, String subtitle){
		if(title != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + title + "\"}");
			PacketPlayOutTitle t = new PacketPlayOutTitle(EnumTitleAction.TITLE, m);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(t);
		}
		if(subtitle != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
			PacketPlayOutTitle t = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, m);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(t);
		}
	}
	public static void setTitle(Player p, String title, String subtitle, int fadein, int set, int fadeout){
		PlayerConnection c = ((CraftPlayer) p).getHandle().playerConnection;

		IChatBaseComponent time = ChatSerializer.a("{\"text\": \"" + "" + "\"}");
		PacketPlayOutTitle timepacket = new PacketPlayOutTitle(EnumTitleAction.TIMES, time, fadein, set, fadeout);
		
		IChatBaseComponent t = ChatSerializer.a("{\"text\": \"" + title + "\"}");
		PacketPlayOutTitle tpacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, t);
		
		IChatBaseComponent s = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
		PacketPlayOutTitle spacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, s);
		c.sendPacket(timepacket);
		c.sendPacket(tpacket);
		c.sendPacket(spacket);
		
	}
}
