package me.O_o_Fadi_o_O.Hub.managers;

import java.util.Random;

import me.O_o_Fadi_o_O.Hub.Hub;
import me.O_o_Fadi_o_O.Hub.NMS.CustomServerSelector;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSkeleton;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftOcelot;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class NPCManager {
	
	Hub plugin;
	 
	public NPCManager(Hub instance) {
		plugin = instance;
	}
	
	public void spawnAllOcelots(World w){
		spawnOcelot(w, new Location(w, -401.5, 16, 1027.5, 0, 0), "§3§l§nServer Selector");	
		spawnOcelot(w, new Location(w, -391.5, 16, 1027.5, 0, 0), "§3§l§nServer Selector");
		spawnOcelot(w, new Location(w, -391.5, 16, 1037.5, 0, 0), "§3§l§nServer Selector");
		spawnOcelot(w, new Location(w, -401.5, 16, 1037.5, 0, 0), "§3§l§nServer Selector");
	}
	
	public void spawnOcelot(World w, Location l, String displayName){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomServerSelector ocelot = new CustomServerSelector(nmsWorld);
	    ocelot.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(ocelot);
	    ocelot.setCustomName(displayName);
	    ocelot.setCustomNameVisible(true);
	    ocelot.setInvisible(true);
	    
		final Entity item = StorageManager.HubWorld.dropItem(l, new ItemStack(Material.ENDER_PEARL));
		ocelot.getBukkitEntity().setPassenger(item);
		item.setVelocity(new Vector(0, 0, 0));
	    StorageManager.serverSelectorOcelots.add(ocelot.getBukkitEntity());
		StorageManager.serverSelectorOcelotItem.put(ocelot.getBukkitEntity(), item);
		ocelot.setTamed(true);
		StorageManager.serverSelectorOcelotLocation.put(ocelot.getBukkitEntity(), l);
		
		if(!StorageManager.Chunks.contains(l.getChunk())){
			StorageManager.Chunks.add(l.getChunk());
		}
		
		((LivingEntity) ocelot.getBukkitEntity()).setRemoveWhenFarAway(false);
		
		new BukkitRunnable(){
			
			@Override
			public void run() {
				for(Entity en : StorageManager.serverSelectorOcelots){
					
					if(StorageManager.serverSelectorOcelotItem.get(en).isDead()){
						final Entity item = StorageManager.HubWorld.dropItem(StorageManager.serverSelectorOcelotLocation.get(en), new ItemStack(Material.ENDER_PEARL));
						en.setPassenger(item);
						StorageManager.serverSelectorOcelotItem.put(en, item);
					}
					StorageManager.serverSelectorOcelotItem.get(en).setVelocity(new Vector(0, 0, 0));
					StorageManager.serverSelectorOcelotItem.get(en).setTicksLived(1);
					en.setPassenger(StorageManager.serverSelectorOcelotItem.get(en));
					en.setTicksLived(1);
				    ((CraftOcelot) en).getHandle().setInvisible(true);
					
				    if(StorageManager.serverSelectorOcelotLocation.get(en).distance(en.getLocation()) >= 0.4){
				    	en.teleport(StorageManager.serverSelectorOcelotLocation.get(en));
				    }
					
				    
				}
			}
		}.runTaskTimer(this.plugin, 0, 1);
	}
	
	public void spawnSkeleton(World w, final Location l, String displayName, Material material){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    StorageManager.alphaEntity = skeleton.getBukkitEntity();
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(material));
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
	
	public void spawnParkourSkeleton(World w, final Location l, String displayName, Material hand){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    StorageManager.ParkourNPC = skeleton.getBukkitEntity();
	    
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
			}
		}.runTaskTimer(this.plugin, 0, 1);
	}
	
	public void spawnMasterMindSkeleton(World w, final Location l, String displayName, Material hand){
		
	    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    StorageManager.MasterMindNPC = skeleton.getBukkitEntity();
	    
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
			}
		}.runTaskTimer(this.plugin, 0, 1);
		
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
		}.runTaskTimer(this.plugin, 0, 10);
	}
}
