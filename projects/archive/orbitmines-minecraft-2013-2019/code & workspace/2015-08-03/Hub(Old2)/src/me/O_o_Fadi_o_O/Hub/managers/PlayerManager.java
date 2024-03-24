package me.O_o_Fadi_o_O.Hub.managers;

import java.sql.SQLException;

import me.O_o_Fadi_o_O.Hub.NMS.CustomChicken;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.Hub.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.Hub.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.Hub.NMS.CustomPig;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSheep;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSlime;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSpider;
import me.O_o_Fadi_o_O.Hub.NMS.CustomSquid;
import me.O_o_Fadi_o_O.Hub.NMS.CustomWolf;
import me.O_o_Fadi_o_O.Hub.utils.Gadget;
import me.O_o_Fadi_o_O.Hub.utils.Pet;
import me.libraryaddict.disguise.DisguiseAPI;
import net.minecraft.server.v1_7_R3.AttributeInstance;
import net.minecraft.server.v1_7_R3.EntityInsentient;
import net.minecraft.server.v1_7_R3.GenericAttributes;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftLivingEntity;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerManager {

	/*
	 * 
	 * Other:
	 * 
	 */
	
	public static boolean isInOPMode(Player p){
		if(StorageManager.PlayerInOPMode.get(p) != null){
			if(StorageManager.PlayerInOPMode.get(p) == true){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public static String playerDisplayName(Player p){

		if(p.hasPermission("Rank.Owner")){
			return "§4§lOwner §4" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Moderator")){
			return "§b§lMod §b" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Builder")){
			return "§d§lBuilder §d" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Emerald")){
			return "§a§lEmerald §a" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Diamond")){
			return "§9§lDiamond §9" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Gold")){
			return "§6§lGold §6" + p.getName(); 
		}
		else if(p.hasPermission("Rank.Iron")){
			return "§7§lIron §7" + p.getName(); 
		}
		else{
			return "§8" + p.getName(); 
		}
	}
	
	public static boolean isLoaded(Player p){
		
		if(StorageManager.IsLoaded.containsKey(p)){
			if(StorageManager.IsLoaded.get(p) == false){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	public static void warnPlayerNotLoaded(Player p){
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		p.sendMessage("§3§lHub §8| §7This Server just §3restarted§7! Wait a few §3seconds§7.");
	}
	
	
	/*
	 * 
	 * Pets:
	 * 
	 */
	
	public static void removePet(Player p, String petname){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f" + petname + "§7!");
		Entity en = StorageManager.ownerpets.get(p);
		if(en instanceof LivingEntity){
			en.remove();
			StorageManager.owners.remove(StorageManager.ownerpets.get(p));
			StorageManager.ownerpets.remove(p);
		}
		if(StorageManager.ShroomTrail.containsKey(p)){
			StorageManager.ShroomTrail.remove(p);
		}
		if(StorageManager.BabyPigs.containsKey(p)){
			for(Entity pig : StorageManager.BabyPigsEntity.get(p)){
				pig.remove();
			}
			StorageManager.BabyPigs.remove(p);
		}
		if(StorageManager.SheepDisco.containsKey(p)){
			StorageManager.SheepDisco.remove(p);
		}
		StorageManager.PlayerPet.remove(p);
	}
	
	public static boolean isPetActive(Player p){
		
		if(StorageManager.ownerpets.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void givePetInv(Player p){
		
		Pet pet = StorageManager.PlayerPet.get(p);
		p.getInventory().clear();
		
		if(pet == Pet.SQUID){
			{
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8§nInk Bomb");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§9§nWater Spout");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SPIDER){
			{
				ItemStack item = new ItemStack(Material.WEB, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nWebs");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.SPIDER_EYE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§5§nSpider Launcher");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.MUSHROOMCOW){
			if(StorageManager.ShroomTrail.get(p) == false){
				ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_1, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§4§nShroom Trail§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.HUGE_MUSHROOM_2, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§4§nShroom Trail§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 14);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.FIREWORK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nBaby Firework");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.MAGMACUBE){
			{
				ItemStack item = new ItemStack(Material.FIREBALL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nFireball");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int size = ((MagmaCube) StorageManager.ownerpets.get(p)).getSize();
				ItemStack item = new ItemStack(Material.MAGMA_CREAM, size);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Size");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.PIG){
			if(StorageManager.BabyPigs.get(p) == false){
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nBaby Pigs§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 90);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nBaby Pigs§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				item.setDurability((short) 90);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Pig) StorageManager.ownerpets.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.PORK, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§d§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SLIME){
			{
				ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nSuper Jump");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int size = ((Slime) StorageManager.ownerpets.get(p)).getSize();
				ItemStack item = new ItemStack(Material.SLIME_BALL, size);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§a§nChange Size");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.WOLF){
			{
				ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§6§nBark");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Wolf) StorageManager.ownerpets.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.BONE, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.COW){
			{
				ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nMilk Explosion");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Cow) StorageManager.ownerpets.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.RAW_BEEF, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SHEEP){
			if(StorageManager.SheepDisco.get(p) == false){
				ItemStack item = new ItemStack(Material.WOOL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nSheep Disco§7 (§c§lDISABLED§7)");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			else{
				ItemStack item = new ItemStack(Material.WOOL, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nSheep Disco§7 (§a§lENABLED§7)");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				Sheep s = (Sheep) StorageManager.ownerpets.get(p);
				
				int DyeInt = s.getColor().getDyeData();
				
				ItemStack item = new ItemStack(Material.INK_SACK, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nChange Color§7 (" + getColorNameFromSheep(s) + "§7)");
				item.setItemMeta(meta);
				item.setDurability((short) DyeInt);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.SILVERFISH){
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nSilverfish Bomb");
				item.setItemMeta(meta);
				item.setDurability((short) 60);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.STONE_HOE, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§8§nLeap");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.HORSE){
			{
				Horse h = (Horse) StorageManager.ownerpets.get(p);
				int speed = 1;
				
				AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) h).getHandle()).getAttributeInstance(GenericAttributes.d);
				if(currentSpeed.b() == 0.25){
					speed = 1;
				}
				if(currentSpeed.b() == 0.5){
					speed = 2;
				}
				if(currentSpeed.b() == 0.75){
					speed = 3;
				}
				
				ItemStack item = new ItemStack(Material.FEATHER, speed);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§f§nChange Speed");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.LEATHER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§nChange Color");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.OCELOT){
			{
				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§e§nKitty Cannon");
				item.setItemMeta(meta);
				item.setDurability((short) 98);
				p.getInventory().setItem(2, item);
			}
			{
				ItemStack item = new ItemStack(Material.RAW_FISH, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§9§nChange Color");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.CREEPER){
			{
				ItemStack item = new ItemStack(Material.TNT, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nExplode");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				Creeper c = (Creeper) StorageManager.ownerpets.get(p);

				ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
				ItemMeta meta = item.getItemMeta();
				if(c.isPowered()){
					meta.setDisplayName("§a§nChange Type§7 (§e§lLIGHTNING§7)");
				}
				else{
					meta.setDisplayName("§a§nChange Type§7 (§6§lNORMAL§7)");
				}
				item.setItemMeta(meta);
				item.setDurability((short) 50);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.CHICKEN){
			{
				ItemStack item = new ItemStack(Material.EGG, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§7§nEgg Bomb");
				item.setItemMeta(meta);
				p.getInventory().setItem(2, item);
			}
			{
				int age = 1;
				if(((Chicken) StorageManager.ownerpets.get(p)).isAdult()){
					age = 2;
				}
				ItemStack item = new ItemStack(Material.RAW_CHICKEN, age);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Age");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static DyeColor getNextDyeColorForSheep(Sheep s){
		int DyeInt = s.getColor().getDyeData();
		
		if(DyeInt == 15){
			DyeInt = 0;
		}
		else{
			DyeInt = DyeInt +1;
		}
		
		return DyeColor.getByDyeData((byte) DyeInt);
	}
	
	public static String getColorNameFromSheep(Sheep s){
		DyeColor c = s.getColor();
	
		if(c == DyeColor.BLACK){return "§0§lBlack";}
		else if(c == DyeColor.BLUE){return "§1§lBlue";}
		else if(c == DyeColor.BROWN){return "§f§lBrown";}
		else if(c == DyeColor.CYAN){return "§3§lCyan";}
		else if(c == DyeColor.GRAY){return "§8§lGray";}
		else if(c == DyeColor.GREEN){return "§2§lGreen";}
		else if(c == DyeColor.LIGHT_BLUE){return "§b§lLight Blue";}
		else if(c == DyeColor.LIME){return "§a§lLight Green";}
		else if(c == DyeColor.MAGENTA){return "§d§lMagenta";}
		else if(c == DyeColor.ORANGE){return "§6§lOrange";}
		else if(c == DyeColor.PINK){return "§d§lPink";}
		else if(c == DyeColor.PURPLE){return "§5§lPurple";}
		else if(c == DyeColor.RED){return "§c§lRed";}
		else if(c == DyeColor.SILVER){return "§7§lLight Gray";}
		else if(c == DyeColor.WHITE){return "§f§lWhite";}
		else if(c == DyeColor.YELLOW){return "§e§lYellow";}
		else{return "";}
	}
	
	public static void spawnPet(Player p, Pet pet){
		
		StorageManager.PlayerPet.put(p, pet);
		
		if(pet == Pet.MUSHROOMCOW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMushroomCow cow = new CustomMushroomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.mushroomcow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			StorageManager.owners.put(cow.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, cow.getBukkitEntity());
			StorageManager.ShroomTrail.put(p, false);
		}
		else if(pet == Pet.PIG){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomPig pig = new CustomPig(nmsWorld);
		    pig.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(pig);
			pig.setAge(1);
			pig.setCustomName(StorageManager.pig.get(p.getName()));
			pig.setCustomNameVisible(true);
			
			StorageManager.owners.put(pig.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, pig.getBukkitEntity());
			
			StorageManager.BabyPigs.put(p, false);
		}
		else if(pet == Pet.WOLF){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomWolf wolf = new CustomWolf(nmsWorld);
		    wolf.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(wolf);
			wolf.setAge(1);
			wolf.setCustomName(StorageManager.wolf.get(p.getName()));
			wolf.setCustomNameVisible(true);
			
			StorageManager.owners.put(wolf.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, wolf.getBukkitEntity());
		}
		else if(pet == Pet.SHEEP){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSheep sheep = new CustomSheep(nmsWorld);
		    sheep.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(sheep);
			sheep.setAge(1);
			sheep.setCustomName(StorageManager.sheep.get(p.getName()));
			sheep.setCustomNameVisible(true);
			
			StorageManager.owners.put(sheep.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, sheep.getBukkitEntity());
			
			StorageManager.SheepDisco.put(p, false);
		}
		else if(pet == Pet.HORSE){
			Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
			horse.setAdult();
			horse.setCustomName(StorageManager.horse.get(p.getName()));
			horse.setCustomNameVisible(true);
			horse.setTamed(true);
			horse.setRemoveWhenFarAway(false);
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse.setColor(Horse.Color.BROWN);
			horse.setStyle(Style.WHITE);
			
			AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) horse).getHandle()).getAttributeInstance(GenericAttributes.d);
			currentSpeed.setValue(0.25);
			
			StorageManager.owners.put(horse, p);
			StorageManager.ownerpets.put(p, horse);
		}
		else if(pet == Pet.MAGMACUBE){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMagmaCube magmacube = new CustomMagmaCube(nmsWorld);
		    magmacube.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(magmacube);
			magmacube.setSize(3);
			magmacube.setCustomName(StorageManager.magmacube.get(p.getName()));
			magmacube.setCustomNameVisible(true);
			
			StorageManager.owners.put(magmacube.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, magmacube.getBukkitEntity());
		}
		else if(pet == Pet.SLIME){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSlime slime = new CustomSlime(nmsWorld);
		    slime.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(slime);
			slime.setSize(3);
			slime.setCustomName(StorageManager.slime.get(p.getName()));
			slime.setCustomNameVisible(true);
			
			StorageManager.owners.put(slime.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, slime.getBukkitEntity());
		}
		else if(pet == Pet.COW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomCow cow = new CustomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.cow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			StorageManager.owners.put(cow.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, cow.getBukkitEntity());
		}
		else if(pet == Pet.SILVERFISH){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSilverfish silverfish = new CustomSilverfish(nmsWorld);
		    silverfish.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(silverfish);
			silverfish.setCustomName(StorageManager.silverfish.get(p.getName()));
			silverfish.setCustomNameVisible(true);
			
			StorageManager.owners.put(silverfish.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, silverfish.getBukkitEntity());
		}
		else if(pet == Pet.OCELOT){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomOcelot ocelot = new CustomOcelot(nmsWorld);
		    ocelot.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(ocelot);
			ocelot.setAge(1);
			ocelot.setCustomName(StorageManager.ocelot.get(p.getName()));
			ocelot.setCustomNameVisible(true);
			
			StorageManager.owners.put(ocelot.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, ocelot.getBukkitEntity());
		}
		else if(pet == Pet.CREEPER){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomCreeper creeper = new CustomCreeper(nmsWorld);
		    creeper.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(creeper);
			creeper.setCustomName(StorageManager.creeper.get(p.getName()));
			creeper.setCustomNameVisible(true);
			
			StorageManager.owners.put(creeper.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, creeper.getBukkitEntity());
		}
		else if(pet == Pet.SPIDER){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSpider spider = new CustomSpider(nmsWorld);
		    spider.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(spider);
			spider.setCustomName(StorageManager.spider.get(p.getName()));
			spider.setCustomNameVisible(true);
			
			StorageManager.owners.put(spider.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, spider.getBukkitEntity());
		}
		else if(pet == Pet.SQUID){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSquid squid = new CustomSquid(nmsWorld);
		    squid.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(squid);
			squid.setCustomName(StorageManager.squid.get(p.getName()));
			squid.setCustomNameVisible(true);
			
			StorageManager.owners.put(squid.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, squid.getBukkitEntity());
		}
		else if(pet == Pet.CHICKEN){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomChicken chicken = new CustomChicken(nmsWorld);
		    chicken.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(chicken);
			chicken.setCustomName(StorageManager.chicken.get(p.getName()));
			chicken.setCustomNameVisible(true);
			
			StorageManager.owners.put(chicken.getBukkitEntity(), p);
			StorageManager.ownerpets.put(p, chicken.getBukkitEntity());
		}
	}
	
	/*
	 * 
	 * Disguise
	 * 
	 */
	
	public static boolean isDisguised(Player p){
		
		if(DisguiseAPI.isDisguised(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeDisguise(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your Disguise!");
		DisguiseAPI.undisguiseToAll(p);
		
	}
	
	/*
	 * 
	 * Gadgets
	 * 
	 */
	
	public static boolean hasSoccerBall(Player p){
		
		if(StorageManager.SoccerPlayerMagmaCubes.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeSoccerBall(Player p){
		Entity en = StorageManager.SoccerPlayerMagmaCubes.get(p);
		
		StorageManager.SoccerMagmaCubes.remove(en);
		StorageManager.SoccerPlayerMagmaCubes.remove(p);
		en.remove();
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cMagmaCube Ball§7!");
		p.getWorld().playEffect(en.getLocation(), Effect.STEP_SOUND, 152);
	}
	
	public static Gadget getGadgetEnabled(Player p){
		
		try{
			
			String displayName = p.getInventory().getItem(5).getItemMeta().getDisplayName();
			
			if(displayName.endsWith("Stacker")){
				return Gadget.STACKER;
			}
			else if(displayName.endsWith("Paintballs")){
				return Gadget.PAINTBALLS;
			}
			else if(displayName.endsWith("Creeper Launcher")){
				return Gadget.CREEPER_LAUNCHER;
			}
			else if(displayName.endsWith("Pet Ride")){
				return Gadget.PET_RIDE;
			}
			else if(displayName.endsWith("Book Explosion")){
				return Gadget.BOOK_EXPLOSION;
			}
			else if(displayName.endsWith("Swap Teleporter")){
				return Gadget.SWAP_TELEPORTER;
			}
			else if(displayName.startsWith("§c§nFirework Gun")){
				return Gadget.FIREWORK_GUN;
			}
			else if(displayName.endsWith("MagmaCube Soccer")){
				return Gadget.MAGMACUBE_SOCCER;
			}
			else{
				return Gadget.STACKER;
			}
		}
		catch(Exception ex){
			return Gadget.STACKER;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void removeGadget(Player p){
		
		Gadget g = getGadgetEnabled(p);
		
		if(g == Gadget.STACKER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lStacker§7!");
		}
		else if(g == Gadget.PAINTBALLS){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f§lPaintballs§7!");
		}
		else if(g == Gadget.CREEPER_LAUNCHER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §a§lCreeper Launcher§7!");
		}
		else if(g == Gadget.PET_RIDE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §e§lPet Ride§7!");
		}
		else if(g == Gadget.BOOK_EXPLOSION){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7§lBook Explosion§7!");
		}
		else if(g == Gadget.SWAP_TELEPORTER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §2§lSwap Teleporter§7!");
		}
		else if(g == Gadget.FIREWORK_GUN){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lFirework Gun§7!");
		}
		else if(g == Gadget.MAGMACUBE_SOCCER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lMagmaCube Soccer§7!");
		}
		
		p.getInventory().setItem(5, null);
		p.updateInventory();
	}
	
	/*
	 * 
	 * Wardrobe
	 * 
	 */
	
	public static boolean hasWardrobeArmor(Player p){
		
		if(p.getInventory().getChestplate() != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeWardrobeArmor(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your " + p.getInventory().getChestplate().getItemMeta().getDisplayName() +"§7!");
		
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		if(StorageManager.wardrobeDisco.containsKey(p.getName()) && StorageManager.wardrobeDisco.get(p.getName()) == true){
			try {
				DatabaseManager.setDiscoWardrobe(p, false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void giveLeatherWardrobeArmor(Player p, Color color, String displayname){
		
		{
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setChestplate(item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setLeggings(item);
		}
		{
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			itemmeta.setColor(color);
			item.setItemMeta(itemmeta);
			p.getInventory().setBoots(item);
		}
		
	}
	
	public static void giveWardrobeArmor(Player p, Material m1, Material m2, Material m3, String displayname){
		
		{
			ItemStack item = new ItemStack(m1, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setChestplate(item);
		}
		{
			ItemStack item = new ItemStack(m2, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setLeggings(item);
		}
		{
			ItemStack item = new ItemStack(m3, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(displayname);
			item.setItemMeta(itemmeta);
			p.getInventory().setBoots(item);
		}
	}
	
	/*
	 * 
	 * Trails
	 * 
	 */
	
	public static boolean hasTrailEnabled(Player p){
		
		if(StorageManager.trail.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeTrail(Player p){
		
		String s = StorageManager.trail.get(p);
		
		if(s.equals("MobSpawner")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7Mob Spawner Trail§7!");
		}
		if(s.equals("FireWork")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cFireWork Spark Trail§7!");
		}
		if(s.equals("Crit")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §bCrit Trail§7!");
		}
		if(s.equals("Magic")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §3Magic Trail§7!");
		}
		if(s.equals("Bubble")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fBubble Trail§7!");
		}
		if(s.equals("Witch")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §5Witch Trail§7!");
		}
		if(s.equals("Music")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §dMusic Trail§7!");
		}
		if(s.equals("EnchantmentTable")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §1Enchantment Table Trail§7!");
		}
		if(s.equals("TNT")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4TNT Trail§7!");
		}
		if(s.equals("Lava")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6Lava Trail§7!");
		}
		if(s.equals("Water")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §9Water Trail§7!");
		}
		if(s.equals("Smoke")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §0Smoke Trail§7!");
		}
		if(s.equals("Rainbow")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4Rainbow Trail§7!");
		}
		if(s.equals("Snow")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fSnow Trail§7!");
		}
		if(s.equals("Hearts")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cHeart Trail§7!");
		}
		if(s.equals("HappyVillager")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aHappy Villager Trail§7!");
		}
		if(s.equals("AngryVillager")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §8Angry Villager Trail§7!");
		}
		if(s.equals("Slime")){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aSlime Trail§7!");
		}
		
		StorageManager.trail.remove(p);
	}
	
	/*
	 * 
	 * Hats
	 * 
	 */
	
	public static boolean hasHat(Player p){
		
		if(p.getInventory().getHelmet() != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeHat(Player p){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your Hat!");
		
		p.getInventory().setHelmet(null);
	}
}
