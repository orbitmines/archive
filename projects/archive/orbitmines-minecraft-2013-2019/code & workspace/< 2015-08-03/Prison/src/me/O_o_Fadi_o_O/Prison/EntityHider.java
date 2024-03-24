package me.O_o_Fadi_o_O.Prison;

import net.minecraft.server.v1_8_R1.PacketPlayOutEntityDestroy;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EntityHider {

	public static void hideEntity(Entity en, Player... players){
		for(Player p : players){
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(en.getEntityId()));
		}
	}
}
