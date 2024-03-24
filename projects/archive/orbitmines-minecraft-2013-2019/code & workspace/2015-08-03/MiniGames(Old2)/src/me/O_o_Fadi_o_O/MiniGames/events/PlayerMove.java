package me.O_o_Fadi_o_O.MiniGames.events;

import me.O_o_Fadi_o_O.MiniGames.managers.StorageManager;
import me.O_o_Fadi_o_O.MiniGames.utils.Game;
import me.O_o_Fadi_o_O.MiniGames.utils.SurvivalGamesState;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(!p.getAllowFlight()){
			Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
			if(!b.isEmpty()){
				if(b.getType() != Material.AIR){
					if(StorageManager.PlayersGame.containsKey(p)){
						if(StorageManager.PlayersGame.get(p) == Game.SURVIVALGAMES){
							if(StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.LOBBY || StorageManager.SurvivalGamesState.get(StorageManager.PlayersArena.get(p)) == SurvivalGamesState.LASTSECONDS){
								p.setAllowFlight(true);
							}
						}
						else if(StorageManager.PlayersGame.get(p) == Game.CHICKENFIGHT){
							p.setAllowFlight(true);
						}
					}
					else{
						p.setAllowFlight(true);
					}
				}
			}
		}
		
		try{//18
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "MobSpawner"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "FireWork"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Crit"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Magic"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Bubble"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Witch"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Music"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "EnchantmentTable"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "TNT"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Lava"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Water"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Smoke"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Rainbow"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Snow"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Hearts"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "HappyVillager"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "AngryVillager"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == "Slime"){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
			if(StorageManager.trail.containsKey(p)){
				if(StorageManager.trail.get(p) == ""){
					if(StorageManager.SpectatorsInChickenFight.contains(p) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
						for(Player player : Bukkit.getOnlinePlayers()){
							if(StorageManager.SpectatorsInChickenFight.contains(player) || StorageManager.SpectatorsInSurvivalGames.contains(p)){
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
