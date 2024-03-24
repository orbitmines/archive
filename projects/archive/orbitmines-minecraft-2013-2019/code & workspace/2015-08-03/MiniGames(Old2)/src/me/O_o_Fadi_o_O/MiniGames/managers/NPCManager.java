package me.O_o_Fadi_o_O.MiniGames.managers;

import java.lang.reflect.Field;
import java.util.Map;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.NMS.ChickenKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.IronGolemKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.LobbyChickenFightNPC;
import me.O_o_Fadi_o_O.MiniGames.NMS.LobbySurvivalGamesNPC;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class NPCManager {

	Start plugin;
	 
	public NPCManager(Start instance) {
		plugin = instance;
	}
	
	public static void spawnLobbyNPCs(World w, Location l1, Location l2){
		// CHICKEN FIGHT
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    LobbyChickenFightNPC chicken = new LobbyChickenFightNPC(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setSkeletonType(1);
		    chicken.setCustomName("§f§lChicken Fight");
		    chicken.setCustomNameVisible(true);
		    
		    ((LivingEntity) chicken.getBukkitEntity()).setRemoveWhenFarAway(false);
		    
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l1);
		}
		
		// SURVIVAL GAMES
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    LobbySurvivalGamesNPC skeleton = new LobbySurvivalGamesNPC(nmsWorld);
		    skeleton.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(skeleton);
		    skeleton.setCustomName("§6§lSurvival Games");
		    skeleton.setCustomNameVisible(true);
		    skeleton.setSkeletonType(1);
		    
		    EntityEquipment ee = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
		    ee.setItemInHand(new ItemStack(Material.IRON_SWORD));
		    ee.setBoots(new ItemStack(Material.GOLD_BOOTS));
		    ee.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		    ee.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		    ee.setHelmet(new ItemStack(Material.GOLD_HELMET));
		    
		    ((LivingEntity) skeleton.getBukkitEntity()).setRemoveWhenFarAway(false);
		    
		    StorageManager.LobbyNPCs.add(skeleton.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(skeleton.getBukkitEntity(), l2);
		}
	}
	
	public static void spawnChickenFightNPCs(World w, int arena, Location l1, Location l2, Location l3, Location l4){
		
		// CHICKEN MAMA
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §c§lClick to Buy");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l1);
		    StorageManager.KitChickenMamaLocked.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §a§lClick to Equip");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l1);
		    StorageManager.KitChickenMamaUnEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §e§lEquiped");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l1);
		    StorageManager.KitChickenMamaEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		
		// BABY CHICKEN
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(chicken);
		    ((Ageable) chicken.getBukkitEntity()).setBaby();
		    chicken.setCustomName("§fBaby Chicken §8| §c§lClick to Buy");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l2);
		    StorageManager.KitBabyChickenLocked.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(chicken);
		    ((Ageable) chicken.getBukkitEntity()).setBaby();
		    chicken.setCustomName("§fBaby Chicken §8| §a§lClick to Equip");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l2);
		    StorageManager.KitBabyChickenUnEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(chicken);
		    ((Ageable) chicken.getBukkitEntity()).setBaby();
		    chicken.setCustomName("§fBaby Chicken §8| §e§lEquiped");
		    chicken.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l2);
		    StorageManager.KitBabyChickenEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		
		// HOT WING
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l3.getX(), l3.getY(), l3.getZ(), l3.getYaw(), l3.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fHot Wing §8| §c§lClick to Buy");
		    chicken.setCustomNameVisible(true);
		    chicken.getBukkitEntity().setFireTicks(Integer.MAX_VALUE);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l3);
		    StorageManager.KitHotWingLocked.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l3.getX(), l3.getY(), l3.getZ(), l3.getYaw(), l3.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fHot Wing §8| §a§lClick to Equip");
		    chicken.setCustomNameVisible(true);
		    chicken.getBukkitEntity().setFireTicks(Integer.MAX_VALUE);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l3);
		    StorageManager.KitHotWingUnEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l3.getX(), l3.getY(), l3.getZ(), l3.getYaw(), l3.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fHot Wing §8| §e§lEquiped");
		    chicken.setCustomNameVisible(true);
		    chicken.getBukkitEntity().setFireTicks(Integer.MAX_VALUE);
	
		    StorageManager.LobbyNPCs.add(chicken.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(chicken.getBukkitEntity(), l3);
		    StorageManager.KitHotWingEquiped.put(arena, (Chicken) chicken.getBukkitEntity());
		}
		
		// CHICKEN WARRIOR
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §c§lClick to Buy");
		    irongolem.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(irongolem.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(irongolem.getBukkitEntity(), l4);
		    StorageManager.KitChickenWarriorLocked.put(arena, (IronGolem) irongolem.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §a§lClick to Equip");
		    irongolem.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(irongolem.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(irongolem.getBukkitEntity(), l4);
		    StorageManager.KitChickenWarriorUnEquiped.put(arena, (IronGolem) irongolem.getBukkitEntity());
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §e§lEquiped");
		    irongolem.setCustomNameVisible(true);
	
		    StorageManager.LobbyNPCs.add(irongolem.getBukkitEntity());
		    StorageManager.LobbyNPCLocations.put(irongolem.getBukkitEntity(), l4);
		    StorageManager.KitChickenWarriorEquiped.put(arena, (IronGolem) irongolem.getBukkitEntity());
		}
	}
	
	protected static Field mapStringToClassField, mapClassToStringField, mapClassToIdField, mapStringToIdField;
	//protected static Field mapIdToClassField;
	
	static
	{
	    try
	    {
	        mapStringToClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("c");
	        mapClassToStringField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("d");
	        //mapIdtoClassField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("e");
	        mapClassToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("f");
	        mapStringToIdField = net.minecraft.server.v1_7_R3.EntityTypes.class.getDeclaredField("g");
	 
	        mapStringToClassField.setAccessible(true);
	        mapClassToStringField.setAccessible(true);
	        //mapIdToClassField.setAccessible(true);
	        mapClassToIdField.setAccessible(true);
	        mapStringToIdField.setAccessible(true);
	    }
	    catch(Exception e) {e.printStackTrace();}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public
	static void addCustomEntity(Class entityClass, String name, int id)
	{
	    if (mapStringToClassField == null || mapStringToIdField == null || mapClassToStringField == null || mapClassToIdField == null)
	    {
	        return;
	    }
	    else
	    {
	        try
	        {
	            Map mapStringToClass = (Map) mapStringToClassField.get(null);
	            Map mapStringToId = (Map) mapStringToIdField.get(null);
	            Map mapClasstoString = (Map) mapClassToStringField.get(null);
	            Map mapClassToId = (Map) mapClassToIdField.get(null);
	 
	            mapStringToClass.put(name, entityClass);
	            mapStringToId.put(name, Integer.valueOf(id));
	            mapClasstoString.put(entityClass, name);
	            mapClassToId.put(entityClass, Integer.valueOf(id));
	 
	            mapStringToClassField.set(null, mapStringToClass);
	            mapStringToIdField.set(null, mapStringToId);
	            mapClassToStringField.set(null, mapClasstoString);
	            mapClassToIdField.set(null, mapClassToId);
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
}
