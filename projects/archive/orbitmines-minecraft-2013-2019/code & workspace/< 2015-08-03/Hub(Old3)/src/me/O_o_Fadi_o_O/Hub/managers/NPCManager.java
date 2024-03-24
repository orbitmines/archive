package me.O_o_Fadi_o_O.Hub.managers;

import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Hub.utils.ArmorStandType;
import me.O_o_Fadi_o_O.Hub.utils.Server;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSkeleton;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class NPCManager {
	
	Hub hub = Hub.getInstance();
	
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
		
		if(type == ArmorStandType.TOP_DONATOR){
			new BukkitRunnable(){
				public void run() {
					ItemStack item = as.getHelmet();
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					final String lastdonatorstring = StorageManager.lastdonatorstring;
					
					if(lastdonatorstring.equals("")){
						meta.setOwner(null);
						item.setDurability((short) 0); 
					}
					else{
						item.setDurability((short) 3); 
						meta.setOwner(lastdonatorstring);
						as.setCustomName("§7Recent Donator: §6§l" + lastdonatorstring);
						as.setCustomNameVisible(true);
					}
					item.setItemMeta(meta);
					as.setHelmet(item);
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_KITPVP){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.KITPVP) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §c§lKitPvP§7: §6§l" + StorageManager.onlineplayers.get(Server.KITPVP) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_PRISON){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.PRISON) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §4§lPrison§7: §6§l" + StorageManager.onlineplayers.get(Server.PRISON) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_CREATIVE){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.CREATIVE) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §d§lCreative§7: §6§l" + StorageManager.onlineplayers.get(Server.CREATIVE) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_SURVIVAL){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.SURVIVAL) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §a§lSurvival§7: §6§l" + StorageManager.onlineplayers.get(Server.SURVIVAL) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_SKYBLOCK){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.SKYBLOCK) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §5§lSkyBlock§7: §6§l" + StorageManager.onlineplayers.get(Server.SKYBLOCK) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
		if(type == ArmorStandType.SERVER_INFO_MINIGAMES){
			new BukkitRunnable(){
				public void run() {
			
					if(StorageManager.onlineplayers.get(Server.MINIGAMES) == -1){
						as.setCustomName("§4§lOffline");
					}
					else{
						as.setCustomName("§7Players in §f§lMiniGames§7: §6§l" + StorageManager.onlineplayers.get(Server.MINIGAMES) + "§7/§6§l100");
					}
					as.setCustomNameVisible(true);
			
				}
			}.runTaskTimer(this.hub, 0, 100);
		}
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
		}.runTaskTimer(this.hub, 0, 1);
	}
	
	public void spawnAlphaSkeleton(final World w, final Location l, final String displayName, Material hand){
		
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
	    StorageManager.alphanpc = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(hand));
	    ee.setHelmet(new ItemStack(Material.GOLD_BLOCK));
	    ee.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
	    ee.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
	    ee.setBoots(new ItemStack(Material.GOLD_BOOTS));
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
		}.runTaskTimer(this.hub, 0, 1);
	}
	
	public void spawnParkourSkeleton(final World w, final Location l, final String displayName, Material hand){
		
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
	    StorageManager.lapisparkournpc = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(hand));
	    ee.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
	    ee.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
	    ee.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
	    ee.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
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
		}.runTaskTimer(this.hub, 0, 1);
	}
	
	public void spawnMindCraftSkeleton(final World w, final Location l, final String displayName, Material hand){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    skeleton.getBukkitEntity().setPassenger(iEn);
	    ((CraftSkeleton) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn);
	    StorageManager.mindcraftnpc = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(hand));
	    ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	    LeatherArmorMeta Hmeta = (LeatherArmorMeta) helmet.getItemMeta();
	    Hmeta.setColor(Color.BLACK);
	    helmet.setItemMeta(Hmeta);
	    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	    LeatherArmorMeta Cmeta = (LeatherArmorMeta) chestplate.getItemMeta();
	    Cmeta.setColor(Color.BLACK);
	    chestplate.setItemMeta(Cmeta);
	    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	    LeatherArmorMeta Lmeta = (LeatherArmorMeta) leggings.getItemMeta();
	    Lmeta.setColor(Color.BLACK);
	    leggings.setItemMeta(Lmeta);
	    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	    LeatherArmorMeta Bmeta = (LeatherArmorMeta) boots.getItemMeta();
	    Bmeta.setColor(Color.BLACK);
	    boots.setItemMeta(Bmeta);
	    
	    ee.setHelmet(helmet);
	    ee.setChestplate(chestplate);
	    ee.setLeggings(leggings);
	    ee.setBoots(boots);
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
		}.runTaskTimer(this.hub, 0, 1);
		
		new BukkitRunnable(){
			
			@Override
			public void run() {
			    ItemStack i = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment().getItemInHand();
			    int Rint = new Random().nextInt(6);
			    
			    if(Rint == 0){i.setDurability((short) 1);}
			    if(Rint == 1){i.setDurability((short) 3);}
			    if(Rint == 2){i.setDurability((short) 4);}
			    if(Rint == 3){i.setDurability((short) 5);}
			    if(Rint == 4){i.setDurability((short) 11);}
			    if(Rint == 5){i.setDurability((short) 14);}
			    
			    ((LivingEntity) skeleton.getBukkitEntity()).getEquipment().setItemInHand(i);
			}
		}.runTaskTimer(this.hub, 0, 10);
	}
}