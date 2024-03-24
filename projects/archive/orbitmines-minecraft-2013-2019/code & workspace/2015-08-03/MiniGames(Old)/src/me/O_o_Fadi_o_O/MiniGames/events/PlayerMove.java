package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.Manager;
import me.O_o_Fadi_o_O.MiniGames.Start;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(!Manager.Spectators.contains(p)){
			if(p.getGameMode() != GameMode.CREATIVE && p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR && !p.isFlying()){
				p.setAllowFlight(true);
			}
		}
		try{//18
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "MobSpawner"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								player.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							player.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		try{//17
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "FireWork"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "fireworksSpark", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                1, 0,(float) 0, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "fireworksSpark", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                1, 0,(float) 0, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		try{//16
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Crit"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "crit", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 1, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "crit", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 1, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//15
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Magic"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "magicCrit", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 1, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "magicCrit", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 1, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//14
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Bubble"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "spell", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 2, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "spell", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 2, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//13
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Witch"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "witchMagic", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
		                                0, 1,(float) 0, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "witchMagic", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
	                                0, 1,(float) 0, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//12
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Music"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "note", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 2, 3));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "note", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 2, 3));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//11
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "EnchantmentTable"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "enchantmenttable", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 2, 15));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "enchantmenttable", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 2, 15));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//10
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "TNT"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "explode", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 1, 5));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "explode", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 1, 5));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//9
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Lava"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "lava", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
		                                0, 0,(float) 0, 5));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "lava", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
	                                0, 0,(float) 0, 5));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//8
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Water"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "splash", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 0, 24));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "splash", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 0, 24));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//7
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Smoke"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "largesmoke", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
		                                1, 0,(float) 0, 3));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "largesmoke", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 0,
	                                1, 0,(float) 0, 3));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//6
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Rainbow"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "reddust", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 3, 8));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "reddust", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 3, 8));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//5
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Snow"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "snowshovel", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 0, 9));
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "snowballpoof", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 0, 9));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "snowshovel", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 0, 9));
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "snowballpoof", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 0, 9));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//4
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Hearts"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "heart", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
		                                0, 1,(float) 1, 2));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "heart", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
	                                0, 1,(float) 1, 2));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//3
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "HappyVillager"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "happyVillager", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
		                                1, 0,(float) 1, 4));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "happyVillager", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0,
	                                1, 0,(float) 1, 4));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "AngryVillager"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "angryVillager", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
		                                1, 1,(float) 1, 4));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "angryVillager", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 1,
	                                1, 1,(float) 1, 4));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//2
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == "Slime"){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "slime", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
		                                0, 1,(float) 1, 7));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "slime", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY(), (float) p.getLocation().getZ(), 1,
	                                0, 1,(float) 1, 7));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
		try{//1
			if(Start.trail.containsKey(p)){
				if(Start.trail.get(p) == ""){
					if(Manager.Spectators.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(Manager.Spectators.contains(player)){
								((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
		                                "mobSpell", (float) p.getLocation().getX(),
		                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
		                                0, 1,(float) 1, 4));
							}
						}
					}
					else{
						for(Player player : Bukkit.getOnlinePlayers()){
							((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
	                                "mobSpell", (float) p.getLocation().getX(),
	                                (float) p.getLocation().getY() +1, (float) p.getLocation().getZ(), 1,
	                                0, 1,(float) 1, 4));
							
						}
					}
				}
			}
		}
		catch(Exception ex){
				
		}
	}
}
