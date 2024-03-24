package me.O_o_Fadi_o_O.KitPvP.managers;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.KitPvP.utils.NPCType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class NPCManager {
	
	Start plugin;
	 
	public NPCManager(Start instance) {
		plugin = instance;
	}
	
	public void spawnAllKitSelectors(World w){
		spawnSkeleton(w, new Location(w, -47.5, 8, -1081.5, -180, 0), "§b§lKit Selector", Material.DIAMOND_CHESTPLATE, Material.GOLD_NUGGET, NPCType.KITSELECTOR);
		spawnSkeleton(w, new Location(w, -61.5, 8, -1093.5, -90, 0), "§b§lKit Selector", Material.DIAMOND_CHESTPLATE, Material.GOLD_NUGGET, NPCType.KITSELECTOR);
		spawnSkeleton(w, new Location(w, -49.5, 8, -1107.5, 0, 0), "§b§lKit Selector", Material.DIAMOND_CHESTPLATE, Material.GOLD_NUGGET, NPCType.KITSELECTOR);
		spawnSkeleton(w, new Location(w, -35.5, 8, -1095.5, 90, 0), "§b§lKit Selector", Material.DIAMOND_CHESTPLATE, Material.GOLD_NUGGET, NPCType.KITSELECTOR);
		
		spawnSkeleton(w, new Location(w, -49.5, 8, -1081.5, -180, 0), "§e§lSpectate", null, Material.ENDER_PEARL, NPCType.SPECTATE);
		spawnSkeleton(w, new Location(w, -61.5, 8, -1095.5, -90, 0), "§e§lSpectate", null, Material.ENDER_PEARL, NPCType.SPECTATE);
		spawnSkeleton(w, new Location(w, -47.5, 8, -1107.5, 0, 0), "§e§lSpectate", null, Material.ENDER_PEARL, NPCType.SPECTATE);
		spawnSkeleton(w, new Location(w, -35.5, 8, -1093.5, 90, 0), "§e§lSpectate", null, Material.ENDER_PEARL, NPCType.SPECTATE);
	}
	
	public void spawnSkeleton(World w, final Location l, String displayName, Material chestplate, Material hand, NPCType type){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    if(type == NPCType.KITSELECTOR){
	    	StorageManager.KitSelectorNPCs.add(skeleton.getBukkitEntity());
	    }
	    if(type == NPCType.SPECTATE){
	    	StorageManager.SpectateNPCs.add(skeleton.getBukkitEntity());
	    }
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    if(type == NPCType.KITSELECTOR){
	    	ee.setChestplate(new ItemStack(chestplate));
	    }
	    ee.setItemInHand(new ItemStack(hand));
	    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
			    if(l.distance(skeleton.getBukkitEntity().getLocation()) >= 1){
			    	skeleton.getBukkitEntity().teleport(l);
			    }
			}
		}.runTaskTimer(this.plugin, 0, 1);
	}
}
