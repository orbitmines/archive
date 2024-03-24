package me.O_o_Fadi_o_O.Creative.events;

import java.util.HashMap;
import java.util.Map;

import me.O_o_Fadi_o_O.Creative.Start;
import me.O_o_Fadi_o_O.Creative.managers.PlayerManager;
import me.O_o_Fadi_o_O.Creative.managers.StorageManager;
import me.O_o_Fadi_o_O.Creative.managers.TitleManager;
import me.O_o_Fadi_o_O.Creative.utils.Trail;
import me.O_o_Fadi_o_O.Creative.utils.TrailType;
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

	Start start = Start.getInstance();
	
	private Map<String, Long> lastHome = new HashMap<String, Long>();
	private final int homecooldown = 10;
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onMove(final PlayerMoveEvent e) {

		final Player p = e.getPlayer();
		
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7.");
			}
			else{
				Bukkit.broadcastMessage("§7 " + PlayerManager.getPlayerDisplayname(p) + "§7 is no longer §6AFK§7. (§7" + StorageManager.afk.get(p) + "§7)");
			}
			StorageManager.afk.remove(p);
		}
		if(StorageManager.spawnteleporting.containsKey(p)){
			StorageManager.spawnteleporting.remove(p);
			
			if(StorageManager.playerspvpplot.containsKey(p)){
				TitleManager.setTitle(p, "", "§c§lCancelled§d Plot §7Teleportation.", 0, 40, 20);
			}
			else{
				TitleManager.setTitle(p, "", "§c§lCancelled§6 Spawn §7Teleportation.", 0, 40, 20);
			}
		}
		/*
		for(Block b : StorageManager.mindcraftblocksforturn.get(0)){
			if(p.getLocation().getY() >= 43 && p.getLocation().distance(new Location(b.getWorld(), b.getLocation().getX() + 0.5, b.getLocation().getY(), b.getLocation().getZ() + 0.5)) <= 1.5){
				p.teleport(StorageManager.mindcraftlocation);
			}
		}
		*/
		if(p.getWorld().getName().equals(StorageManager.lobbyworld.getName())){
			Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ()));
			if(b != null && b.getType() != null && b.getType() == Material.BEACON){
				long lastHome = 0;
				if(this.lastHome.containsKey(p.getName())){
					lastHome = this.lastHome.get(p.getName());
				}
				int cdmillis2 = homecooldown * 1000;
						
				if(System.currentTimeMillis()-lastHome>=cdmillis2){
					p.chat("/p h");
					
					this.lastHome.put(p.getName(), System.currentTimeMillis());
				}
			}
		}
		
		if(StorageManager.hatsblocktrail.containsKey(p) && StorageManager.hatsblocktrail.get(p) == true && p.getInventory().getHelmet() != null){
			
			final Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -1, p.getLocation().getZ()));
			Material mb = b.getType();
			if(!b.isEmpty() && mb.getId() != 175 && mb.getId() != 31 && mb != Material.SKULL && mb != Material.STEP && mb != Material.STEP && mb != Material.WATER && mb != Material.LAVA && mb != Material.WALL_SIGN && mb != Material.SIGN_POST && mb != Material.SNOW && mb != Material.STATIONARY_LAVA && mb != Material.STATIONARY_WATER && mb != Material.FENCE && mb != Material.TORCH && mb != Material.TRAP_DOOR){
				
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
				}.runTaskLater(this.start, 40);
				
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
