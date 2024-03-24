package me.O_o_Fadi_o_O.KitPvPMoneyOnKill.mobs;

import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class Spawn {

	// SPAWN SKELETON
	public static void Skeleton(Player p){
		Skeleton skeleton = (Skeleton) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON));
	    skeleton.getEquipment().setItemInHand(new ItemStack(Material.BOW));
	    skeleton.setCustomName("§c" + p.getName());
	    skeleton.setSkeletonType(SkeletonType.NORMAL);
	}
	// SPAWN ZOMBIE
	public static void Zombie(Player p){
		Zombie zombie = (Zombie) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE));
	    zombie.setCustomName("§c" + p.getName());
	}
	// SPAWN BLAZE
	public static void Blaze(Player p){
		Blaze blaze = (Blaze) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.BLAZE));
	    blaze.setCustomName("§c" + p.getName());
		}
	// SPAWN CREEPER
	public static void Creeper(Player p){
		Creeper creeper = (Creeper) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER));
	    creeper.setCustomName("§c" + p.getName());
	}
	// SPAWN WITCH
	public static void Witch(Player p){
		Witch witch = (Witch) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.WITCH));
	    witch.setCustomName("§c" + p.getName());
	}
	// SPAWN SPIDER
	public static void Spider(Player p){
		Spider spider = (Spider) (p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER));
	    spider.setCustomName("§c" + p.getName());
	}
}
