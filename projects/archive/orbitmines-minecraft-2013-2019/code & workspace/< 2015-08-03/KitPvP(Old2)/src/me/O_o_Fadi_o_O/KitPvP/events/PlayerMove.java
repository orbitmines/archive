package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMove implements Listener {
	
	Start plugin;
	 
	public PlayerMove(Start instance) {
	plugin = instance;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(StorageManager.currentMap == KitPvPMap.Mountain_Village){
			if(StorageManager.PlayerKitSelected.containsKey(p) || StorageManager.Spectators.contains(p)){
				if(p.getLocation().getY() >= 26){
					p.setVelocity(new Vector(0, 0, 0));
				    Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				    p.teleport(l);
				    p.sendMessage(Start.TAG + "§4§lStay in the Arena!");
				    p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
				}
			}
		}
		if(StorageManager.currentMap == KitPvPMap.Snow_Town){
			if(StorageManager.PlayerKitSelected.containsKey(p) || StorageManager.Spectators.contains(p)){
				if(p.getLocation().getY() >= 30){
					p.setVelocity(new Vector(0, 0, 0));
				    Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				    p.teleport(l);
				    p.sendMessage(Start.TAG + "§4§lStay in the Arena!");
				    p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
				}
			}
		}
		
		try{//18
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "MobSpawner"){
				
					p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
				}
			}
		}
		catch(Exception ex){
			
		}
		try{//17
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "FireWork"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "fireworksSpark", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                1, 0,(float) 0, 8));
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		try{//16
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Crit"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "crit", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 1, 8));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//15
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Magic"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "magicCrit", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 1, 8));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//14
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Bubble"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "spell", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 2, 8));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//13
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Witch"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "witchMagic", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
                                0, 1,(float) 0, 8));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//12
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Music"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "note", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 2, 3));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//11
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "EnchantmentTable"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "enchantmenttable", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 2, 15));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//10
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "TNT"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "explode", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 1, 5));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//9
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Lava"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "lava", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
                                0, 0,(float) 0, 5));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//8
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Water"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "splash", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 0, 24));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//7
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Smoke"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "largesmoke", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
                                1, 0,(float) 0, 3));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//6
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Rainbow"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "reddust", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 3, 8));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//5
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Snow"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "snowshovel", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 0, 9));
					}
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "snowballpoof", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 0, 9));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//4
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Hearts"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "heart", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
                                0, 1,(float) 1, 2));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//3
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "HappyVillager"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "happyVillager", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
                                1, 0,(float) 1, 4));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "AngryVillager"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "angryVillager", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
                                1, 1,(float) 1, 4));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//2
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Slime"){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "slime", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
                                0, 1,(float) 1, 7));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//1
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == ""){
				
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
                                "mobSpell", (float) p.getLocation().getX(),
                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
                                0, 1,(float) 1, 4));
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{
			if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Fire Trail I")){
				
				final Block b = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
			
				if(b.isEmpty()){
					b.setType(Material.FIRE);
					
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
						public void run(){
							
							b.setType(Material.AIR);
							
						}
					}, 40);
				}
			}
		}
		catch(Exception ex){
				
		}
		try{
			if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Light I")){
				
				Location l1 = new Location(p.getWorld(), p.getLocation().getBlockX() +1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ());
				Location l2 = new Location(p.getWorld(), p.getLocation().getBlockX() -1, p.getLocation().getBlockY() -1, p.getLocation().getBlockZ() -1);
				
				for(final Block b : Start.getBlocksBetween(l1, l2)){
					if(b.getType() != Material.COBBLESTONE){
						final Material Cb = b.getType();
					
						if(b.getType().equals(Material.WATER) || b.getType().equals(Material.STATIONARY_WATER)){
							b.setType(Material.COBBLESTONE);
						}

						removeBlockBlazeBoots(p, b, Cb);
					}
				}
			}
		}
		catch(Exception ex){
				
		}
	}
	
	public void removeBlockBlazeBoots(final Player p, final Block b, final Material m){
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable(){
			public void run(){
				
				if(p.getLocation().distance(b.getLocation()) >= 3){
					b.setType(m);
				}
				else{
					removeBlockBlazeBoots(p, b, m);
				}
				
			}
		}, 30L);
	}
}
