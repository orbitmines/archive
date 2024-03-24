package me.O_o_Fadi_o_O.Prison.managers;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.Prison.EntityHider;
import me.O_o_Fadi_o_O.Prison.Start;
import me.O_o_Fadi_o_O.Prison.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.Prison.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Prison.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.Prison.NMS.CustomVillager;
import me.O_o_Fadi_o_O.Prison.NMS.CustomZombie;
import me.O_o_Fadi_o_O.Prison.utils.ArmorStandType;
import me.O_o_Fadi_o_O.Prison.utils.Rank;
import me.O_o_Fadi_o_O.Prison.utils.RankNPCType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftCreeper;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
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
	
	public void spawnAllWoodmen(World w){
		for(Rank rank : Rank.values()){
			try{
			spawnZombie(w, StorageManager.rankwoodmenlocation.get(rank), "§e§lLumberjack §a§l" + rank.toString().replaceAll("Plus", "+"), Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET, Material.IRON_AXE, rank);
		
			}catch(Exception ex){}
		}
	}
	
	public void spawnAllVillagers(World w){
		spawnVillager(w, new Location(w, -1199.5, 11.5, -587.5, 135, 1), "§2§lVillager Gamble");
	}
	
	public void spawnAllSkeletons(World w){
		StorageManager.shopnpcs.add(spawnSkeleton(w, new Location(w, -1205.5, 13.5, -593.5, 135, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP));
		StorageManager.shopnpcs.add(spawnSkeleton(w, new Location(w, -1211.5, 13.5, -593.5, -135, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP));
		StorageManager.shopnpcs.add(spawnSkeleton(w, new Location(w, -1211.5, 13.5, -599.5, -45, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP));
		StorageManager.shopnpcs.add(spawnSkeleton(w, new Location(w, -1205.5, 13.5, -599.5, 45, 0), "§6§lGold Shop", Material.GOLD_INGOT, null, RankNPCType.SHOP));
		
		StorageManager.spawnteleportnpcs.put(Rank.Z, spawnSkeleton(w, new Location(w, -1447.5, 11, -372.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Z, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.Y, spawnSkeleton(w, new Location(w, -1484.5, 11, -554.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Y, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.Z, spawnSkeleton(w, new Location(w, -1661.5, 11, -579.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.X, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.W, spawnSkeleton(w, new Location(w, -1641.5, 11, -379.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.X, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.V, spawnSkeleton(w, new Location(w, -1818.5, 11, -570.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.V, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.U, spawnSkeleton(w, new Location(w, -1778.5, 11, -352.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.U, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.T, spawnSkeleton(w, new Location(w, -1957.5, 11, -557.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.T, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.S, spawnSkeleton(w, new Location(w, -1919.5, 11, -343.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.S, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.R, spawnSkeleton(w, new Location(w, -2086.5, 11, -547.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.R, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.Q, spawnSkeleton(w, new Location(w, -2049.5, 11, -336.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.Q, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.P, spawnSkeleton(w, new Location(w, -2217.5, 11, -525.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.P, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.O, spawnSkeleton(w, new Location(w, -2183.5, 11, -314.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.O, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.N, spawnSkeleton(w, new Location(w, -2332.5, 11, -522.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.N, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.M, spawnSkeleton(w, new Location(w, -2314.5, 11, -305.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.M, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.L, spawnSkeleton(w, new Location(w, -2480.5, 11, -517.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.L, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.K, spawnSkeleton(w, new Location(w, -2450.5, 11, -295.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.K, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.J, spawnSkeleton(w, new Location(w, -2613.5, 11, -520.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.J, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.I, spawnSkeleton(w, new Location(w, -2577.5, 11, -297.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.I, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.H, spawnSkeleton(w, new Location(w, -2772.5, 11, -510.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.H, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.G, spawnSkeleton(w, new Location(w, -2717.5, 11, -300.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.G, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.F, spawnSkeleton(w, new Location(w, -2904.5, 11, -513.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.F, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.E, spawnSkeleton(w, new Location(w, -2866.5, 11, -299.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.E, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.D, spawnSkeleton(w, new Location(w, -3036.5, 11, -505.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.D, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.C, spawnSkeleton(w, new Location(w, -2998.5, 11, -293.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.C, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.B, spawnSkeleton(w, new Location(w, -3217.5, 11, -492.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.B, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.A, spawnSkeleton(w, new Location(w, -3164.5, 11, -290.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.A, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.ZPlus, spawnSkeleton(w, new Location(w, -3375.5, 11, -494.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.ZPlus, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.YPlus, spawnSkeleton(w, new Location(w, -3311.5, 11, -286.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.YPlus, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.XPlus, spawnSkeleton(w, new Location(w, -3494.5, 11, -493.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.XPlus, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.WPlus, spawnSkeleton(w, new Location(w, -3447.5, 11, -277.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.WPlus, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.VPlus, spawnSkeleton(w, new Location(w, -3644.5, 11, -474.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.VPlus, RankNPCType.SPAWNTELEPORT));
		StorageManager.spawnteleportnpcs.put(Rank.UPlus, spawnSkeleton(w, new Location(w, -3595.5, 11, -273.5, 90, 0), "§3§lTeleport to §a§lSpawn", Material.ENDER_PEARL, Rank.UPlus, RankNPCType.SPAWNTELEPORT));
		
		//TODO
		
	}
	
	public void spawnZombie(World w, Location l, String displayName, Material boots, Material leggings, Material chestplate, Material helmet, Material hand, Rank rank){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    CustomZombie zombie = new CustomZombie(nmsWorld);
	    zombie.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(zombie);
	   // zombie.setCustomName(displayName);
	   // zombie.setCustomNameVisible(true);
	    ((LivingEntity) zombie.getBukkitEntity()).setRemoveWhenFarAway(false);

	    EntityEquipment ee = ((LivingEntity) zombie.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(hand));
	    ee.setBoots(new ItemStack(boots));
	    ee.setLeggings(new ItemStack(leggings));
	    ee.setChestplate(new ItemStack(chestplate));
	    ee.setHelmet(new ItemStack(helmet));
	    
	    StorageManager.rankwoodmen.put(rank, zombie.getBukkitEntity());
	}
	
	public void spawnVillager(final World w, final Location l, final String displayName){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomVillager villager = new CustomVillager(nmsWorld);
	    villager.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(villager);
	    villager.setCustomName(displayName);
	    villager.setCustomNameVisible(true);
	    
	    ((LivingEntity) villager.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    villager.getBukkitEntity().setPassenger(iEn);
	    
	    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn);
	    
		new BukkitRunnable(){
			
			@Override
			public void run() {
				if(l.distance(villager.getBukkitEntity().getLocation()) >= 1){
					villager.getBukkitEntity().teleport(l);
				}
			    if(StorageManager.npcItem.get(villager.getBukkitEntity()).getVehicle() == null){
				    ItemStack item = new ItemStack(Material.ENDER_PEARL);
				    Item iEn2 = w.dropItem(l, item);
				    iEn2.setPickupDelay(Integer.MAX_VALUE);
				    iEn2.setCustomName(displayName);
				    iEn2.setCustomNameVisible(true);
				    
				    villager.getBukkitEntity().setPassenger(iEn2);
				    StorageManager.npcItem.put(villager.getBukkitEntity(), iEn2);
				    StorageManager.serverselector = villager.getBukkitEntity();
			    }
			}
		}.runTaskTimer(this.start, 0, 1);
	    
	    StorageManager.villagers.add(villager.getBukkitEntity());
	}
	
	public Entity spawnSkeleton(final World w, final Location l, final String displayName, Material material, Rank rank, RankNPCType type){
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton skeleton = new CustomSkeleton(nmsWorld);
	    skeleton.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
	    nmsWorld.addEntity(skeleton);
	    skeleton.setCustomName(displayName);
	    skeleton.setCustomNameVisible(true);
	    skeleton.setSkeletonType(1);
	    
	    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
	    ee.setItemInHand(new ItemStack(material));
	    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
	    ItemStack item = new ItemStack(Material.WOOD_BUTTON);
	    final Item iEn = w.dropItem(l, item);
	    iEn.setPickupDelay(Integer.MAX_VALUE);
	    iEn.setCustomName(displayName);
	    iEn.setCustomNameVisible(true);
	    
	    skeleton.getBukkitEntity().setPassenger(iEn);
	    
	    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn);
	    
		BukkitTask taskid = new BukkitRunnable(){
			
			@Override
			public void run() {
				if(skeleton.getBukkitEntity() != null){
					if(l.distance(skeleton.getBukkitEntity().getLocation()) >= 1){
						skeleton.getBukkitEntity().teleport(l);
					}
				    if(StorageManager.npcItem.get(skeleton.getBukkitEntity()).getVehicle() == null){
					    ItemStack item = new ItemStack(Material.ENDER_PEARL);
					    Item iEn2 = w.dropItem(l, item);
					    iEn2.setPickupDelay(Integer.MAX_VALUE);
					    iEn2.setCustomName(displayName);
					    iEn2.setCustomNameVisible(true);
					    
					    skeleton.getBukkitEntity().setPassenger(iEn2);
					    StorageManager.npcItem.put(skeleton.getBukkitEntity(), iEn2);
					    StorageManager.serverselector = skeleton.getBukkitEntity();
				    }
				}
			}
		}.runTaskTimer(this.start, 0, 1);
		
		StorageManager.entitytasks.put(skeleton.getBukkitEntity(), taskid.getTaskId());
	    
	    return skeleton.getBukkitEntity();
	}
	
	public void loadNPCs(Player p){
		unloadNPCs(p);
		
		if(StorageManager.playerrank.get(p) != PlayerManager.getRankupRank(p)){
			StorageManager.rankupnpc.put(p, getRankupEntity(p, StorageManager.prisonworld, PlayerManager.getRankupRank(p)));
		}
		
		List<Entity> teleportnpcs = new ArrayList<Entity>();
		for(Rank rank : PlayerManager.getAllRanksPassed(p)){
			teleportnpcs.add(getTeleportEntity(p, StorageManager.prisonworld, rank));
		}
		StorageManager.rankteleportnpcs.put(p, teleportnpcs);
		
		updateAllNPCs();
	}
	
	public void unloadNPCs(Player p){
		if(StorageManager.rankupnpc.containsKey(p)){
			try{Bukkit.getScheduler().cancelTask(StorageManager.entitytasks.get(StorageManager.rankupnpc.get(p)));}catch(Exception ex){}
			StorageManager.npcItem.get(StorageManager.rankupnpc.get(p)).remove();
			StorageManager.npcItem.remove(StorageManager.rankupnpc.get(p));
			StorageManager.rankupnpc.get(p).remove();
			StorageManager.rankupnpc.remove(p);
		}
		if(StorageManager.rankteleportnpcs.containsKey(p)){
			for(Entity en : StorageManager.rankteleportnpcs.get(p)){
				try{Bukkit.getScheduler().cancelTask(StorageManager.entitytasks.get(en));}catch(Exception ex){}
				StorageManager.npcItem.get(en).remove();
				StorageManager.npcItem.remove(en);
				en.remove();
			}
			StorageManager.rankteleportnpcs.remove(p);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateAllNPCs(){
		for(Player player : Bukkit.getOnlinePlayers()){
			for(Player player2 : Bukkit.getOnlinePlayers()){
				if(player != player2){
					if(StorageManager.rankupnpc.containsKey(player)){
						EntityHider.hideEntity(StorageManager.rankupnpc.get(player), player2);
						EntityHider.hideEntity(StorageManager.npcItem.get(StorageManager.rankupnpc.get(player)), player2);
					}
					if(StorageManager.rankteleportnpcs.containsKey(player)){
						for(Entity en : StorageManager.rankteleportnpcs.get(player)){
							EntityHider.hideEntity(en, player2);
							EntityHider.hideEntity(StorageManager.npcItem.get(en), player2);
						}
					}
				}
			}
		}
	}
	
	public Entity getTeleportEntity(Player p, World w, Rank rank){
		if(rank == Rank.Z){
			return spawnSkeleton(w, new Location(w, -1168.5, 11, -596.5, 90, 0), "§3§lTeleport to §a§lZ", Material.ENDER_PEARL, Rank.Z, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.Y){
			return spawnSkeleton(w, new Location(w, -1169.5, 11, -589.5, 100, 0), "§3§lTeleport to §a§lY", Material.ENDER_PEARL, Rank.Y, RankNPCType.TELEPORT);
		}
		else 	if(rank == Rank.X){
			return spawnSkeleton(w, new Location(w, -1170.5, 11, -582.5, 110, 0), "§3§lTeleport to §a§lX", Material.ENDER_PEARL, Rank.X, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.W){
			return spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 122, 0), "§3§lTeleport to §a§lW", Material.ENDER_PEARL, Rank.W, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.V){
			return spawnSkeleton(w, new Location(w, -1180.5, 11, -568.5, 135, 0), "§3§lTeleport to §a§lV", Material.ENDER_PEARL, Rank.V, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.U){
			return spawnSkeleton(w, new Location(w, -1187.5, 11, -562.5, 148, 0), "§3§lTeleport to §a§lU", Material.ENDER_PEARL, Rank.U, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.T){
			return spawnSkeleton(w, new Location(w, -1194.5, 11, -558.5, 160, 0), "§3§lTeleport to §a§lT", Material.ENDER_PEARL, Rank.T, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.S){
			return spawnSkeleton(w, new Location(w, -1201.5, 11, -557.5, 170, 0), "§3§lTeleport to §a§lS", Material.ENDER_PEARL, Rank.S, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.R){
			return spawnSkeleton(w, new Location(w, -1208.5, 11, -556.5, 180, 0), "§3§lTeleport to §a§lR", Material.ENDER_PEARL, Rank.R, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.Q){
			return spawnSkeleton(w, new Location(w, -1215.5, 11, -557.5, -170, 0), "§3§lTeleport to §a§lQ", Material.ENDER_PEARL, Rank.Q, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.P){
			return spawnSkeleton(w, new Location(w, -1222.5, 11, -558.5, -160, 0), "§3§lTeleport to §a§lP", Material.ENDER_PEARL, Rank.P, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.O){
			return spawnSkeleton(w, new Location(w, -1229.5, 11, -562.5, -148, 0), "§3§lTeleport to §a§lO", Material.ENDER_PEARL, Rank.O, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.N){
			return spawnSkeleton(w, new Location(w, -1236.5, 11, -568.5, -135, 0), "§3§lTeleport to §a§lN", Material.ENDER_PEARL, Rank.N, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.M){
			return spawnSkeleton(w, new Location(w, -1242.5, 11, -575.5, -121, 0), "§3§lTeleport to §a§lM", Material.ENDER_PEARL, Rank.M, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.L){
			return spawnSkeleton(w, new Location(w, -1246.5, 11, -582.5, -110, 0), "§3§lTeleport to §a§lL", Material.ENDER_PEARL, Rank.L, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.K){
			return spawnSkeleton(w, new Location(w, -1247.5, 11, -589.5, -100, 0), "§3§lTeleport to §a§lK", Material.ENDER_PEARL, Rank.K, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.J){
			return spawnSkeleton(w, new Location(w, -1248.5, 11, -596.5, -90, 0), "§3§lTeleport to §a§lJ", Material.ENDER_PEARL, Rank.J, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.I){
			return spawnSkeleton(w, new Location(w, -1247.5, 11, -603.5, -80, 0), "§3§lTeleport to §a§lI", Material.ENDER_PEARL, Rank.I, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.H){
			return spawnSkeleton(w, new Location(w, -1246.5, 11, -610.5, -70, 0), "§3§lTeleport to §a§lH", Material.ENDER_PEARL, Rank.H, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.G){
			return spawnSkeleton(w, new Location(w, -1242.5, 11, -617.5, -59, 0), "§3§lTeleport to §a§lG", Material.ENDER_PEARL, Rank.G, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.F){
			return spawnSkeleton(w, new Location(w, -1236.5, 11, -624.5, -45, 0), "§3§lTeleport to §a§lF", Material.ENDER_PEARL, Rank.F, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.E){
			return spawnSkeleton(w, new Location(w, -1229.5, 11, -630.5, -32, 0), "§3§lTeleport to §a§lE", Material.ENDER_PEARL, Rank.E, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.D){
			return spawnSkeleton(w, new Location(w, -1222.5, 11, -634.5, -20, 0), "§3§lTeleport to §a§lD", Material.ENDER_PEARL, Rank.D, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.C){
			return spawnSkeleton(w, new Location(w, -1215.5, 11, -635.5, -10, 0), "§3§lTeleport to §a§lC", Material.ENDER_PEARL, Rank.C, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.B){
			return spawnSkeleton(w, new Location(w, -1208.5, 11, -636.5, 0, 0), "§3§lTeleport to §a§lB", Material.ENDER_PEARL, Rank.B, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.A){
			return spawnSkeleton(w, new Location(w, -1201.5, 11, -635.5, 10, 0), "§3§lTeleport to §a§lA", Material.ENDER_PEARL, Rank.A, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.ZPlus){
			return spawnSkeleton(w, new Location(w, -1194.5, 11, -634.5, 20, 0), "§3§lTeleport to §a§lZ+", Material.ENDER_PEARL, Rank.ZPlus, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.YPlus){
			return spawnSkeleton(w, new Location(w, -1187.5, 11, -630.5, 32, 0), "§3§lTeleport to §a§lY+", Material.ENDER_PEARL, Rank.YPlus, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.XPlus){
			return spawnSkeleton(w, new Location(w, -1180.5, 11, -624.5, 45, 0), "§3§lTeleport to §a§lX+", Material.ENDER_PEARL, Rank.XPlus, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.WPlus){
			return spawnSkeleton(w, new Location(w, -1174.5, 11, -617.5, 59, 0), "§3§lTeleport to §a§lW+", Material.ENDER_PEARL, Rank.WPlus, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.VPlus){
			return spawnSkeleton(w, new Location(w, -1170.5, 11, -610.5, 70, 0), "§3§lTeleport to §a§lV+", Material.ENDER_PEARL, Rank.VPlus, RankNPCType.TELEPORT);
		}
		else if(rank == Rank.UPlus){
			return spawnSkeleton(w, new Location(w, -1169.5, 11, -603.5, 80, 0), "§3§lTeleport to §a§lU+", Material.ENDER_PEARL, Rank.UPlus, RankNPCType.TELEPORT);
		}
		else{
			return null;
		}
		//TODO: ADD NEW RANKS
	}
	
	public Entity getRankupEntity(Player p, World w, Rank rank){
		//spawnSkeleton(w, new Location(w, -1168.5, 11, -596.5, 90, 0), "§9§lRankup to §a§lZ §8| §6§l0 Gold", Material.DIAMOND_PICKAXE, Rank.Z, RankNPCType.RANKUP);
		if(rank == Rank.Y){
			return spawnSkeleton(w, new Location(w, -1169.5, 11, -589.5, 100, 0), "§9§lRankup to §a§lY §8| §6§l1000 Gold", Material.DIAMOND_PICKAXE, Rank.Y, RankNPCType.RANKUP);
		}
		else if(rank == Rank.X){
			return spawnSkeleton(w, new Location(w, -1170.5, 11, -582.5, 110, 0), "§9§lRankup to §a§lX §8| §6§l2500 Gold", Material.DIAMOND_PICKAXE, Rank.X, RankNPCType.RANKUP);
		}
		else if(rank == Rank.W){
			return spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 122, 0), "§9§lRankup to §a§lW §8| §6§l5000 Gold", Material.DIAMOND_PICKAXE, Rank.W, RankNPCType.RANKUP);
		}
		else if(rank == Rank.V){
			return spawnSkeleton(w, new Location(w, -1180.5, 11, -568.5, 135, 0), "§9§lRankup to §a§lV §8| §6§l7500 Gold", Material.DIAMOND_PICKAXE, Rank.V, RankNPCType.RANKUP);
		}
		else if(rank == Rank.U){
			return spawnSkeleton(w, new Location(w, -1187.5, 11, -562.5, 148, 0), "§9§lRankup to §a§lU §8| §6§l10000 Gold", Material.DIAMOND_PICKAXE, Rank.U, RankNPCType.RANKUP);
		}
		else if(rank == Rank.T){
			return spawnSkeleton(w, new Location(w, -1194.5, 11, -558.5, 160, 0), "§9§lRankup to §a§lT §8| §6§l15000 Gold", Material.DIAMOND_PICKAXE, Rank.T, RankNPCType.RANKUP);
		}
		else if(rank == Rank.S){
			return spawnSkeleton(w, new Location(w, -1201.5, 11, -557.5, 170, 0), "§9§lRankup to §a§lS §8| §6§l20000 Gold", Material.DIAMOND_PICKAXE, Rank.S, RankNPCType.RANKUP);
		}
		else if(rank == Rank.R){
			return spawnSkeleton(w, new Location(w, -1208.5, 11, -556.5, 180, 0), "§9§lRankup to §a§lR §8| §6§l30000 Gold", Material.DIAMOND_PICKAXE, Rank.R, RankNPCType.RANKUP);
		}
		else if(rank == Rank.Q){
			return spawnSkeleton(w, new Location(w, -1215.5, 11, -557.5, -170, 0), "§9§lRankup to §a§lQ §8| §6§l40000 Gold", Material.DIAMOND_PICKAXE, Rank.Q, RankNPCType.RANKUP);
		}
		else if(rank == Rank.P){
			return spawnSkeleton(w, new Location(w, -1222.5, 11, -558.5, -160, 0), "§9§lRankup to §a§lP §8| §6§l50000 Gold", Material.DIAMOND_PICKAXE, Rank.P, RankNPCType.RANKUP);
		}
		else if(rank == Rank.O){
			return spawnSkeleton(w, new Location(w, -1229.5, 11, -562.5, -148, 0), "§9§lRankup to §a§lO §8| §6§l70000 Gold", Material.DIAMOND_PICKAXE, Rank.O, RankNPCType.RANKUP);
		}
		else if(rank == Rank.N){
			return spawnSkeleton(w, new Location(w, -1236.5, 11, -568.5, -135, 0), "§9§lRankup to §a§lN §8| §6§l90000 Gold", Material.DIAMOND_PICKAXE, Rank.N, RankNPCType.RANKUP);
		}
		else if(rank == Rank.M){
			return spawnSkeleton(w, new Location(w, -1242.5, 11, -575.5, -121, 0), "§9§lRankup to §a§lM §8| §6§l115000 Gold", Material.DIAMOND_PICKAXE, Rank.M, RankNPCType.RANKUP);
		}
		else if(rank == Rank.L){
			return spawnSkeleton(w, new Location(w, -1246.5, 11, -582.5, -110, 0), "§9§lRankup to §a§lL §8| §6§l140000 Gold", Material.DIAMOND_PICKAXE, Rank.L, RankNPCType.RANKUP);
		}
		else if(rank == Rank.K){
			return spawnSkeleton(w, new Location(w, -1247.5, 11, -589.5, -100, 0), "§9§lRankup to §a§lK §8| §6§l175000 Gold", Material.DIAMOND_PICKAXE, Rank.K, RankNPCType.RANKUP);
		}
		else if(rank == Rank.J){
			return spawnSkeleton(w, new Location(w, -1248.5, 11, -596.5, -90, 0), "§9§lRankup to §a§lJ §8| §6§l250000 Gold", Material.DIAMOND_PICKAXE, Rank.J, RankNPCType.RANKUP);
		}
		else if(rank == Rank.I){
			return spawnSkeleton(w, new Location(w, -1247.5, 11, -603.5, -80, 0), "§9§lRankup to §a§lI §8| §6§l500000 Gold", Material.DIAMOND_PICKAXE, Rank.I, RankNPCType.RANKUP);
		}
		else if(rank == Rank.H){
			return spawnSkeleton(w, new Location(w, -1246.5, 11, -610.5, -70, 0), "§9§lRankup to §a§lH §8| §6§l750000 Gold", Material.DIAMOND_PICKAXE, Rank.H, RankNPCType.RANKUP);
		}
		else if(rank == Rank.G){
			return spawnSkeleton(w, new Location(w, -1242.5, 11, -617.5, -59, 0), "§9§lRankup to §a§lG §8| §6§l1000000 Gold", Material.DIAMOND_PICKAXE, Rank.G, RankNPCType.RANKUP);
		}
		else if(rank == Rank.F){
			return spawnSkeleton(w, new Location(w, -1236.5, 11, -624.5, -45, 0), "§9§lRankup to §a§lF §8| §6§l1250000 Gold", Material.DIAMOND_PICKAXE, Rank.F, RankNPCType.RANKUP);
		}
		else if(rank == Rank.E){
			return spawnSkeleton(w, new Location(w, -1229.5, 11, -630.5, -32, 0), "§9§lRankup to §a§lE §8| §6§l1500000 Gold", Material.DIAMOND_PICKAXE, Rank.E, RankNPCType.RANKUP);
		}
		else if(rank == Rank.D){
			return spawnSkeleton(w, new Location(w, -1222.5, 11, -634.5, -20, 0), "§9§lRankup to §a§lD §8| §6§l1750000 Gold", Material.DIAMOND_PICKAXE, Rank.D, RankNPCType.RANKUP);
		}
		else if(rank == Rank.C){
			return spawnSkeleton(w, new Location(w, -1215.5, 11, -635.5, -10, 0), "§9§lRankup to §a§lC §8| §6§l2000000 Gold", Material.DIAMOND_PICKAXE, Rank.C, RankNPCType.RANKUP);
		}
		else if(rank == Rank.B){
			return spawnSkeleton(w, new Location(w, -1208.5, 11, -636.5, 0, 0), "§9§lRankup to §a§lB §8| §6§l2500000 Gold", Material.DIAMOND_PICKAXE, Rank.B, RankNPCType.RANKUP);
		}
		else if(rank == Rank.A){	
			return spawnSkeleton(w, new Location(w, -1201.5, 11, -635.5, 10, 0), "§9§lRankup to §a§lA §8| §6§l3000000 Gold", Material.DIAMOND_PICKAXE, Rank.A, RankNPCType.RANKUP);
		}
		else if(rank == Rank.ZPlus){
			return spawnSkeleton(w, new Location(w, -1194.5, 11, -634.5, 20, 0), "§9§lRankup to §a§lZ+ §8| §6§l3500000 Gold", Material.DIAMOND_PICKAXE, Rank.ZPlus, RankNPCType.RANKUP);
		}
		else if(rank == Rank.YPlus){
			return spawnSkeleton(w, new Location(w, -1187.5, 11, -630.5, 32, 0), "§9§lRankup to §a§lY+ §8| §6§l4000000 Gold", Material.DIAMOND_PICKAXE, Rank.YPlus, RankNPCType.RANKUP);
		}
		else if(rank == Rank.XPlus){
			return spawnSkeleton(w, new Location(w, -1180.5, 11, -624.5, 45, 0), "§9§lRankup to §a§lX+ §8| §6§l4750000 Gold", Material.DIAMOND_PICKAXE, Rank.XPlus, RankNPCType.RANKUP);
		}
		else if(rank == Rank.WPlus){
			return spawnSkeleton(w, new Location(w, -1174.5, 11, -617.5, 59, 0), "§9§lRankup to §a§lW+ §8| §6§l5500000 Gold", Material.DIAMOND_PICKAXE, Rank.WPlus, RankNPCType.RANKUP);
		}
		else if(rank == Rank.VPlus){
			return spawnSkeleton(w, new Location(w, -1170.5, 11, -610.5, 70, 0), "§9§lRankup to §a§lV+ §8| §6§l7000000 Gold", Material.DIAMOND_PICKAXE, Rank.VPlus, RankNPCType.RANKUP);
		}
		else if(rank == Rank.UPlus){
			return spawnSkeleton(w, new Location(w, -1169.5, 11, -603.5, 80, 0), "§9§lRankup to §a§lU+ §8| §6§l8500000 Gold", Material.DIAMOND_PICKAXE, Rank.UPlus, RankNPCType.RANKUP);
		}
		else{
			return null;
		}
		
		//spawnSkeleton(w, new Location(w, -1174.5, 11, -575.5, 120, 0), "§9§lRankup to §a§l §8| §6§l Gold", Material.DIAMOND_PICKAXE, null, RankNPCType.RANKUP); 
		//TODO: ADD NEW RANKS
	}
}