package me.O_o_Fadi_o_O.MiniGames.managers;

import me.O_o_Fadi_o_O.MiniGames.Hologram;
import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomChicken;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.MiniGames.utils.ArmorStandType;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftChicken;
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
	Hologram hologram = new Hologram();
	
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
	
	public void spawnChickenFightNPC(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomChicken chicken = new CustomChicken(nmsWorld);
	    chicken.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(chicken);
	    
	    ((CraftChicken) chicken.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.chickenfightnpc = chicken.getBukkitEntity();
	    
	    hologram.createHologram(l, displayName);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(chicken.getBukkitEntity().getLocation()) >= 1){
					chicken.getBukkitEntity().teleport(l);
				}
			}
		}.runTaskTimer(this.start, 0, 1);
	}
	
	public void spawnSurvivalGamesNPC(final World w, final Location l, final String displayName){
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setSkeletonType(1);
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(Material.IRON_SWORD));
	    ee.setBoots(new ItemStack(Material.LEATHER_BOOTS));
	    ee.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
	    ee.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
	    ee.setHelmet(new ItemStack(Material.GOLD_HELMET));
	    
	    ((CraftSkeleton) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.survivalgamesnpc = skeleton.getBukkitEntity();
	    
	    hologram.createHologram(new Location(l.getWorld(), l.getX(), l.getY() +1.75, l.getZ(), l.getYaw(), l.getPitch()), displayName);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(skeleton.getBukkitEntity().getLocation()) >= 1){
					skeleton.getBukkitEntity().teleport(l);
				}
			}
		}.runTaskTimer(this.start, 0, 1);
	}
}