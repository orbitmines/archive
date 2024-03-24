package me.O_o_Fadi_o_O.SpigotTestServer.managers;

import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class TitleManager {
	
	public static void setTitle(Player p, String title, String subtitle, int fadein, int stay, int fadeout){
		if(title != null){
			IChatBaseComponent m = ChatSerializer.a("{\"text\": \"" + "\"}");
			PacketPlayOutTitle t = new PacketPlayOutTitle(EnumTitleAction.TIMES, m, fadein, stay, fadeout);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(t);
		}
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
	
	public static void setActionBar(Player p, String actionbar){
		IChatBaseComponent a = ChatSerializer.a("{\"text\": \"" + actionbar + "\"}");
		PacketPlayOutChat apacket = new PacketPlayOutChat(a, (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(apacket);
	}
}
