package me.O_o_Fadi_o_O.Prison.events;

import me.O_o_Fadi_o_O.Prison.managers.PlayerManager;
import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{

    @EventHandler
    public void onMove(final PlayerMoveEvent e) {

		Player p = e.getPlayer();
		
		if(p.getWorld() == StorageManager.PrisonWorld){
			try{
				if(PlayerManager.isLoaded(p)){
					Location l1 = p.getLocation();
					Location l2 = StorageManager.PrisonSpawn;
					
					boolean inPvP = StorageManager.PlayerInPvP.get(p);
					
					if(l1.distance(l2) >= 16 && l1.distance(l2) <= 28){
						if(inPvP == false){
							p.sendMessage("�4�lPrison �8| �7You �ajoined �7the �c�lPvP Area�7!");
							StorageManager.PlayerInPvP.put(p, true);
						}
						if(PlayerManager.isDisguised(p)){
							PlayerManager.removeDisguise(p);
						}
						if(p.getAllowFlight() == true){
							p.setFlying(false);
							p.setAllowFlight(false);
							p.sendMessage("�4�lPrison �8| �f�lFly �c�lDISABLED�7! (You're in �7the �c�lPvP Area�7)");
						}
					}
					else{
						if(inPvP == true){
							p.sendMessage("�4�lPrison �8| �7You �cleft �7the �c�lPvP Area�7!");
							StorageManager.PlayerInPvP.put(p, false);
						}
					}
				}
			}
			catch(Exception ex){
				
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
    }
}
