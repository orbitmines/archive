package me.O_o_Fadi_o_O.Survival.managers;

import me.O_o_Fadi_o_O.Survival.Start;
import me.O_o_Fadi_o_O.Survival.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Survival.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Survival.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Survival.utils.ArmorStandType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
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
		
		as.setHelmet(helmet);
		as.setChestplate(chestplate);
		as.setLeggings(leggings);
		as.setBoots(boots);
		as.setItemInHand(hand);
		
		if(displayname != null){
			as.setCustomName(displayname);
			as.setCustomNameVisible(true);
		}
		
		if(type == ArmorStandType.PVP){
			StorageManager.pvpnpc = as;
		}
		
		StorageManager.armorstands.add(as);
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
	
	public void spawnRegionTeleporter(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomCreeper creeper = new CustomCreeper(nmsWorld);
	    creeper.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(creeper);
	    creeper.setCustomName(displayName);
	    creeper.setCustomNameVisible(true);
	    
	    creeper.setInvisible(true);
		
	    ItemStack item = new ItemStack(Material.EYE_OF_ENDER);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    creeper.getBukkitEntity().setPassenger(iEn);
	    ((CraftCreeper) creeper.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.regiontpworld1 = creeper.getBukkitEntity();
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
				    StorageManager.regiontpworld1 = creeper.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnJobManagerVillager(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomVillager villager = new CustomVillager(nmsWorld);
	    villager.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(villager);
	    villager.setCustomName(displayName);
	    villager.setCustomNameVisible(true);
	    villager.setProfession(6);
		
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    villager.getBukkitEntity().setPassenger(iEn);
	    ((CraftVillager) villager.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.jobmanagernpc = villager.getBukkitEntity();
	    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(villager.getBukkitEntity().getLocation()) >= 1){
					villager.getBukkitEntity().teleport(l);
				}
			    if(StorageManager.npcItem.get(villager.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    villager.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn2);
				    StorageManager.jobmanagernpc = villager.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnMerchantVillager(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomVillager villager = new CustomVillager(nmsWorld);
	    villager.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(villager);
	    villager.setCustomName(displayName);
	    villager.setCustomNameVisible(true);
	    villager.setProfession(8);
		
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    villager.getBukkitEntity().setPassenger(iEn);
	    ((CraftVillager) villager.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.merchantnpc = villager.getBukkitEntity();
	    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(villager.getBukkitEntity().getLocation()) >= 1){
					villager.getBukkitEntity().teleport(l);
				}
				Location l = villager.getBukkitEntity().getLocation();
				l.setYaw(-90F);
				villager.getBukkitEntity().teleport(l);
			    if(StorageManager.npcItem.get(villager.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    villager.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn2);
				    StorageManager.jobmanagernpc = villager.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	}
}