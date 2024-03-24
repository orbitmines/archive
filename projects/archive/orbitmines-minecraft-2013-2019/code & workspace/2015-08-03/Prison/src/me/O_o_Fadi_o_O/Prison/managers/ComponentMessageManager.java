package me.O_o_Fadi_o_O.Prison.managers;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ComponentMessageManager {

	public static void sendComponentMessage(Player p, String messagefirst, String clickablemessage, String hoverevent, String clickevent, String hovermessage, String clickeventmessage){
		IChatBaseComponent click = ChatSerializer.a(
				"{\"text\":\"" + messagefirst +"\","
				+ "\"extra\":[{\"text\":\"" + clickablemessage + "\""
					+ ",\"hoverEvent\":{\"action\":\"" + hoverevent +"\",\"value\":\"" + hovermessage +"\"}"
					+ ",\"clickEvent\":{\"action\":\"" + clickevent +"\",\"value\":\"" + clickeventmessage + "\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(click);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
