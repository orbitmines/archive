package me.O_o_Fadi_o_O.MiniGames;

import me.O_o_Fadi_o_O.MiniGames.NMS.ChickenKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.IronGolemKit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.IronGolem;

public class KitNPCs {

	Start plugin;
	 
	public KitNPCs(Start instance) {
		plugin = instance;
	}
	
	public static void spawnChickenFightNPCs(World w, Location l1, Location l2, Location l3, Location l4){
		
		// CHICKEN MAMA
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §c§lClick to Buy");
		    chicken.setCustomNameVisible(true);
	
		    Start.KitChickenMamaLocked = (Chicken) chicken.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §a§lClick to Equip");
		    chicken.setCustomNameVisible(true);
	
		    Start.KitChickenMamaUnEquiped = (Chicken) chicken.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l1.getX(), l1.getY(), l1.getZ(), l1.getYaw(), l1.getPitch());
		    nmsWorld.addEntity(chicken);
		    chicken.setAge(1);
		    chicken.setCustomName("§fChicken Mama §8| §e§lEquiped");
		    chicken.setCustomNameVisible(true);
	
		    Start.KitChickenMamaEquiped = (Chicken) chicken.getBukkitEntity();
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
	
		    Start.KitBabyChickenLocked = (Chicken) chicken.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(chicken);
		    ((Ageable) chicken.getBukkitEntity()).setBaby();
		    chicken.setCustomName("§fBaby Chicken §8| §a§lClick to Equip");
		    chicken.setCustomNameVisible(true);
	
		    Start.KitBabyChickenUnEquiped = (Chicken) chicken.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    ChickenKit chicken = new ChickenKit(nmsWorld);
		    chicken.setPositionRotation(l2.getX(), l2.getY(), l2.getZ(), l2.getYaw(), l2.getPitch());
		    nmsWorld.addEntity(chicken);
		    ((Ageable) chicken.getBukkitEntity()).setBaby();
		    chicken.setCustomName("§fBaby Chicken §8| §e§lEquiped");
		    chicken.setCustomNameVisible(true);
	
		    Start.KitBabyChickenEquiped = (Chicken) chicken.getBukkitEntity();
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
	
		    Start.KitHotWingLocked = (Chicken) chicken.getBukkitEntity();
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
	
		    Start.KitHotWingUnEquiped = (Chicken) chicken.getBukkitEntity();
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
	
		    Start.KitHotWingEquiped = (Chicken) chicken.getBukkitEntity();
		}
		
		// HOT WING
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §c§lClick to Buy");
		    irongolem.setCustomNameVisible(true);
	
		    Start.KitChickenWarriorLocked = (IronGolem) irongolem.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §a§lClick to Equip");
		    irongolem.setCustomNameVisible(true);
	
		    Start.KitChickenWarriorUnEquiped = (IronGolem) irongolem.getBukkitEntity();
		}
		{
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) w).getHandle();
		    IronGolemKit irongolem = new IronGolemKit(nmsWorld);
		    irongolem.setPositionRotation(l4.getX(), l4.getY(), l4.getZ(), l4.getYaw(), l4.getPitch());
		    nmsWorld.addEntity(irongolem);
		    irongolem.setCustomName("§fChicken Warrior §8| §e§lEquiped");
		    irongolem.setCustomNameVisible(true);
	
		    Start.KitChickenWarriorEquiped = (IronGolem) irongolem.getBukkitEntity();
		}
	}
}
