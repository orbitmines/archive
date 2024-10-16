package me.O_o_Fadi_o_O.KitPvP.events;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.managers.PlayerManager;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPvPMap;
import me.O_o_Fadi_o_O.KitPvP.utils.Trail;
import me.O_o_Fadi_o_O.KitPvP.utils.TrailType;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMove implements Listener{

	Start start = Start.getInstance();
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onMove(final PlayerMoveEvent e) {

		final Player p = e.getPlayer();
		
		if(StorageManager.afk.containsKey(p)){
			if(StorageManager.afk.get(p).equals("")){
				Bukkit.broadcastMessage("�7 " + PlayerManager.getPlayerDisplayname(p) + "�7 is no longer �6AFK�7.");
			}
			else{
				Bukkit.broadcastMessage("�7 " + PlayerManager.getPlayerDisplayname(p) + "�7 is no longer �6AFK�7. (�7" + StorageManager.afk.get(p) + "�7)");
			}
			StorageManager.afk.remove(p);
		}
		if(StorageManager.currentmap == KitPvPMap.Mountain_Village){
			if(StorageManager.kitselected.containsKey(p) || StorageManager.spectators.contains(p)){
				if(p.getLocation().getY() >= 26){
					p.setVelocity(new Vector(0, 0, 0));
				    Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				    p.teleport(l);
				    p.sendMessage(Start.TAG + "�4�lStay in the Arena!");
				    p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
				}
			}
		}
		if(StorageManager.currentmap == KitPvPMap.Snow_Town){
			if(StorageManager.kitselected.containsKey(p) || StorageManager.spectators.contains(p)){
				if(p.getLocation().getY() >= 30){
					p.setVelocity(new Vector(0, 0, 0));
				    Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				    p.teleport(l);
				    p.sendMessage(Start.TAG + "�4�lStay in the Arena!");
				    p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
				}
			}
		}
		if(StorageManager.currentmap == KitPvPMap.Desert){
			if(StorageManager.kitselected.containsKey(p) || StorageManager.spectators.contains(p)){
				if(p.getLocation().getY() >= 47){
					p.setVelocity(new Vector(0, 0, 0));
				    Location l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() -2, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				    p.teleport(l);
				    p.sendMessage(Start.TAG + "�4�lStay in the Arena!");
				    p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
				}
			}
		}
		
		/*
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
		*/
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
