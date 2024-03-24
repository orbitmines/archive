package me.O_o_Fadi_o_O.MiniGames.managers;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

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
}
