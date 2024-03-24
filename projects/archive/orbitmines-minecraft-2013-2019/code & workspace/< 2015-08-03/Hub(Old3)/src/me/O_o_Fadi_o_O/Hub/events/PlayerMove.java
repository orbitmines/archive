package me.O_o_Fadi_o_O.Hub.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.managers.PlayerManager;
import me.O_o_Fadi_o_O.Hub.managers.StorageManager;
import me.O_o_Fadi_o_O.Hub.utils.Server;
import me.O_o_Fadi_o_O.Hub.utils.Trail;
import me.O_o_Fadi_o_O.Hub.utils.TrailType;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerMove implements Listener{

	Hub hub = Hub.getInstance();
	
	private Map<String, Long> lastconnected = new HashMap<String, Long>();
	private final int connectcooldown = 3;
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onMove(final PlayerMoveEvent e) {

		final Player p = e.getPlayer();
		
		if(!StorageManager.canchat.contains(p)){
			StorageManager.canchat.add(p);
			p.sendMessage("§3§lHub §8| §7Chat §a§lENABLED§7!");
		}
		
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
			}
			else{
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
			}
			StorageManager.afk.remove(p);
		}
		
		if(p.getWorld().getName().equals(StorageManager.hubworld.getName())){
			for(Block b : StorageManager.mindcraftblocksforturn.get(0)){
				if(p.getLocation().getY() >= 43 && p.getLocation().distance(new Location(b.getWorld(), b.getLocation().getX() + 0.5, b.getLocation().getY(), b.getLocation().getZ() + 0.5)) <= 1.5){
					p.teleport(StorageManager.mindcraftlocation);
				}
			}
		
			{
				/*
				 * Server Portals..
				 */
				Block b = p.getWorld().getBlockAt(p.getLocation());
				long lastconnect = 0;
				if(lastconnected.containsKey(p.getName())){
					lastconnect = lastconnected.get(p.getName());
				}
				int cdmillis = connectcooldown * 1000;
						
				if(System.currentTimeMillis()-lastconnect>=cdmillis){
					if(StorageManager.serverportals.get(Server.KITPVP).contains(b)){
						if(StorageManager.onlineplayers.get(Server.KITPVP) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6KitPvP§7...");
							hub.teleportToServer(p, Server.KITPVP);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §c§lKitPvP§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
					if(StorageManager.serverportals.get(Server.PRISON).contains(b)){
						if(StorageManager.onlineplayers.get(Server.PRISON) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6Prison§7...");
							hub.teleportToServer(p, Server.PRISON);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §4§lPrison§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
					if(StorageManager.serverportals.get(Server.CREATIVE).contains(b)){
						if(StorageManager.onlineplayers.get(Server.CREATIVE) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6Creative§7...");
							hub.teleportToServer(p, Server.CREATIVE);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §d§lCreative§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
					if(StorageManager.serverportals.get(Server.SURVIVAL).contains(b)){
						if(StorageManager.onlineplayers.get(Server.SURVIVAL) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6Survival§7...");
							hub.teleportToServer(p, Server.SURVIVAL);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §a§lSurvival§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
					if(StorageManager.serverportals.get(Server.SKYBLOCK).contains(b)){
						if(StorageManager.onlineplayers.get(Server.SKYBLOCK) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6SkyBlock§7...");
							hub.teleportToServer(p, Server.SKYBLOCK);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §5§lSkyBlock§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
					if(StorageManager.serverportals.get(Server.MINIGAMES).contains(b)){
						if(StorageManager.onlineplayers.get(Server.MINIGAMES) != -1){
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7Connecting to §6MiniGames§7...");
							hub.teleportToServer(p, Server.MINIGAMES);
						}
						else{
							p.sendMessage("§6§lOrbitMines§4§lNetwork §8| §7The §f§lMiniGames§7 Server is §4§lOffline§7!");
						}
						lastconnected.put(p.getName(), System.currentTimeMillis());
					}
				}
			}
		}
		
		
		if(StorageManager.hatsblocktrail.containsKey(p) && StorageManager.hatsblocktrail.get(p) == true && p.getInventory().getHelmet() != null){
			
			final Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -1, p.getLocation().getZ()));
			Material mb = b.getType();
			if(!b.isEmpty() && mb.getId() != 175 && mb.getId() != 31 && mb != Material.SKULL && mb != Material.LAPIS_BLOCK && mb != Material.STEP && mb != Material.STEP && mb != Material.WATER && mb != Material.LAVA && mb != Material.WALL_SIGN && mb != Material.SIGN_POST && mb != Material.SNOW && mb != Material.STATIONARY_LAVA && mb != Material.STATIONARY_WATER && mb != Material.FENCE && mb != Material.TORCH && mb != Material.TRAP_DOOR){
				
				Material m = p.getInventory().getHelmet().getType();
				byte mB = (byte) p.getInventory().getHelmet().getDurability();
				
				for(Player player : Bukkit.getOnlinePlayers()){
					player.sendBlockChange(b.getLocation(), m, mB);
				}
				
				new BukkitRunnable(){
					public void run(){
						for(Player player : Bukkit.getOnlinePlayers()){
							player.sendBlockChange(b.getLocation(), b.getType(), b.getData());
						}
					}
				}.runTaskLater(this.hub, 40);
				
			}
		}
		if(StorageManager.trail.containsKey(p)){
			Location l = p.getLocation();
			
			int xsize = 0;
			int ysize = 0;
			int zsize = 0;
			int special = 0;
			int amount = StorageManager.trailparticlesamount.get(p);
			int yhight = 0;
			
			if(StorageManager.trailspecial.containsKey(p) && StorageManager.trailspecial.get(p) == true){
				special = 1;
			}
			
			TrailType trailtype = StorageManager.trailtype.get(p);
			if(trailtype == TrailType.BASIC_TRAIL){
				xsize = 1;
				ysize = 1;
				zsize = 1;
			}
			if(trailtype == TrailType.GROUND_TRAIL){
				xsize = 1;
				zsize = 1;
			}
			if(trailtype == TrailType.BIG_TRAIL){
				xsize = 2;
				ysize = 2;
				zsize = 2;
			}
			if(trailtype == TrailType.BODY_TRAIL){
				yhight = 1;
			}
			if(trailtype == TrailType.HEAD_TRAIL){
				yhight = 2;
			}
			if(trailtype == TrailType.VERTICAL_TRAIL){
				ysize = 2;
			}
			
			try{
				if(StorageManager.trail.get(p) == Trail.MOB_SPAWNER){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.FLAME, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.FIREWORK_SPARK){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.FIREWORKS_SPARK, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.CRIT){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.CRIT, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.MAGIC){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.CRIT_MAGIC, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.BUBBLE){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SPELL, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.WITCH){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SPELL_WITCH, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.MUSIC){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.NOTE, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.ENCHANTMENT_TABLE){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.ENCHANTMENT_TABLE, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.TNT){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.EXPLOSION_NORMAL, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.LAVA){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.LAVA, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.WATER){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.WATER_SPLASH, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.SMOKE){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SMOKE_LARGE, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.RAINBOW){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.REDSTONE, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.SNOW){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SNOW_SHOVEL, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SNOWBALL, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.HEART){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.HEART, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.HAPPY_VILLAGER){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.VILLAGER_HAPPY, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.ANGRY_VILLAGER){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.VILLAGER_ANGRY, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
				if(StorageManager.trail.get(p) == Trail.SLIME){
					for(Player player : Bukkit.getOnlinePlayers()){
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(PacketPlayOutWorldParticles.class.getConstructor(EnumParticle.class, boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class).newInstance(
						EnumParticle.SLIME, true, (float) l.getX(), (float) l.getY() + yhight, (float) l.getZ(), xsize, ysize, zsize, special, amount, null));
					}
				}
			}
			catch(Exception ex){
				
			}
		}
    }
}
