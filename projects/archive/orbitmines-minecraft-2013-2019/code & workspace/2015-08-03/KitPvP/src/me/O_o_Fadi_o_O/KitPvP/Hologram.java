package me.O_o_Fadi_o_O.KitPvP;

import net.minecraft.server.v1_8_R1.PacketPlayOutEntityDestroy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Hologram {

	Start start = Start.getInstance();
	
	@SuppressWarnings("deprecation")
	public void createKillHologram(Player killer, Player died, Location deathlocation, int coinsadded) {
	    
		Location l = deathlocation;
		
		final ArmorStand as1 = (ArmorStand) killer.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() + 0.5, l.getZ()), EntityType.ARMOR_STAND);
		as1.setCustomName("§7You killed §6" + died.getName() + "§7!");
		as1.setCustomNameVisible(true);
		as1.setGravity(false);
		as1.setVisible(false);
		
		final ArmorStand as2 = (ArmorStand) killer.getWorld().spawnEntity(new Location(l.getWorld(), l.getX(), l.getY() + 0.25, l.getZ()), EntityType.ARMOR_STAND);
		as2.setCustomName("§6§l+" + coinsadded + " Coins");
		as2.setCustomNameVisible(true);
		as2.setGravity(false);
		as2.setVisible(false);
        
        for(Player player : Bukkit.getOnlinePlayers()){
        	if(player != killer){
        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftArmorStand) as1).getHandle().getId()));
        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftArmorStand) as2).getHandle().getId()));
        	}
        }
        
        new BukkitRunnable(){
        	public void run(){
        		as1.remove();
        		as2.remove();
        	}
        }.runTaskLater(this.start, 100);
	}
}
