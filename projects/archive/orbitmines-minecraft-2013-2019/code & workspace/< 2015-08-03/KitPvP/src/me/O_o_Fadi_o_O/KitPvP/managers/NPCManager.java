package me.O_o_Fadi_o_O.KitPvP.managers;

import me.O_o_Fadi_o_O.KitPvP.Start;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.KitPvP.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.KitPvP.utils.ArmorStandType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSkeleton;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class NPCManager {
	
	Start start = Start.getInstance();
	
	public void spawnArmorStand(World w, Location l, String displayname, boolean small, boolean arms, boolean baseplate, EulerAngle bodypose, boolean gravity, EulerAngle headpose, EulerAngle leftarmpose, EulerAngle leftlegpose, EulerAngle rightarmpose, EulerAngle rightlegpose, boolean visible, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, ItemStack hand, ArmorStandType type){
		final ArmorStand as = (ArmorStand) w.spawnEntity(l, EntityType.ARMOR_STAND);
		as.setSmall(small);
		as.setArms(arms);
		as.setBasePlate(baseplate);
		as.setBodyPose(bodypose);
		as.setGravity(gravity);
		as.setHeadPose(headpose);
		as.setLeftArmPose(leftarmpose);
		as.setLeftLegPose(leftlegpose);
		as.setRightArmPose(rightarmpose);
		as.setRightLegPose(rightlegpose);
		as.setVisible(visible);
		
		if(helmet != null){as.setHelmet(helmet);}
		if(chestplate != null){as.setChestplate(chestplate);}
		if(leggings != null){as.setLeggings(leggings);}
		if(boots != null){as.setBoots(boots);}
		if(hand != null){as.setItemInHand(hand);}
		
		if(displayname != null){
			as.setCustomName(displayname);
			as.setCustomNameVisible(true);
		}
		
		StorageManager.armorstands.add(as);
	}
	
	public void spawnArmorStandItem(final World w, final Location l, final String displayname, Material m){
		final ArmorStand as = (ArmorStand) w.spawnEntity(l, EntityType.ARMOR_STAND);
		as.setVisible(false);
		as.setGravity(false);
		
	    ItemStack item = new ItemStack(Material.ENDER_PEARL);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
		
		if(displayname != null){
			iEn.setCustomName(displayname);
			iEn.setCustomNameVisible(true);
		}
		
		as.setPassenger(iEn);
		
		StorageManager.armorstands.add(as);
		StorageManager.npcItem.put(as, iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
			    if(StorageManager.npcItem.get(as).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.ENDER_PEARL);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
					if(displayname != null){
						iEn.setCustomName(displayname);
						iEn.setCustomNameVisible(true);
					}
				    
					as.setPassenger(iEn2);
				    StorageManager.npcItem.put(as, iEn2);
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnServerSelector(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomCreeper creeper = new CustomCreeper(nmsWorld);
	    creeper.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(creeper);
	    creeper.setCustomName(displayName);
	    creeper.setCustomNameVisible(true);
	    
	    creeper.setInvisible(true);
		
	    ItemStack item = new ItemStack(Material.ENDER_PEARL);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    creeper.getBukkitEntity().setPassenger(iEn);
	    ((CraftCreeper) creeper.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.serverselector = creeper.getBukkitEntity();
	    StorageManager.npcItem.put(creeper.getBukkitEntity(), iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				creeper.setInvisible(true);
				   if(l.distance(creeper.getBukkitEntity().getLocation()) >= 1){
					   creeper.getBukkitEntity().teleport(l);
				   }
			    if(StorageManager.npcItem.get(creeper.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.ENDER_PEARL);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    creeper.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(creeper.getBukkitEntity(), iEn2);
				    StorageManager.serverselector = creeper.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	

	public void spawnKitSelector(final World w, final Location l, final String displayName){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    skeleton.getBukkitEntity().setPassenger(iEn);
	    ((CraftSkeleton) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn);
	    StorageManager.kitselectornpc = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
	    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
			    if(l.distance(skeleton.getBukkitEntity().getLocation()) >= 1){
			    	skeleton.getBukkitEntity().teleport(l);
			    }
			    if(StorageManager.npcItem.get(skeleton.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    skeleton.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn2);
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnSpectateNPC(final World w, final Location l, final String displayName){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    skeleton.getBukkitEntity().setPassenger(iEn);
	    ((CraftSkeleton) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn);
	    StorageManager.spectatenpc = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(Material.ENDER_PEARL));
	    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
			    if(l.distance(skeleton.getBukkitEntity().getLocation()) >= 1){
			    	skeleton.getBukkitEntity().teleport(l);
			    }
			    if(StorageManager.npcItem.get(skeleton.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    skeleton.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn2);
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnOMTShop(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomBlaze blaze = new CustomBlaze(nmsWorld);
	    blaze.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(blaze);
	    blaze.setCustomName(displayName);
	    blaze.setCustomNameVisible(true);
		
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    blaze.getBukkitEntity().setPassenger(iEn);
	    ((CraftBlaze) blaze.getBukkitEntity()).setRemoveWhenFarAway(false);
	   
	    StorageManager.omtnpc = blaze.getBukkitEntity();
	    StorageManager.npcItem.put(blaze.getBukkitEntity(), iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(blaze.getBukkitEntity().getLocation()) >= 1){
					blaze.getBukkitEntity().teleport(l);
				}
			    if(StorageManager.npcItem.get(blaze.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    blaze.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(blaze.getBukkitEntity(), iEn2);
				    StorageManager.omtnpc = blaze.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
}