package me.O_o_Fadi_o_O.MiniGames.managers;

import java.util.UUID;

import me.O_o_Fadi_o_O.MiniGames.NMS.CustomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomPig;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSheep;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomSlime;
import me.O_o_Fadi_o_O.MiniGames.NMS.CustomWolf;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;
import me.libraryaddict.disguise.DisguiseAPI;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse.Style;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerManager {

	/*
	 * 
	 * Other:
	 * 
	 */
	
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
		p.sendMessage("§f§lMiniGames §8| §7This Server just §frestarted§7! Wait a few §fseconds§7.");
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
	
	
	/*
	 * 
	 * Pets:
	 * 
	 */
	
	public static void removePet(Player p, String petname){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f" + petname + "§7!");
		for(World w : Bukkit.getWorlds()){
			for(Entity en : w.getEntities()){
				if(en.getUniqueId() == StorageManager.ownerpets.get(p)){
					if(en instanceof LivingEntity){
						en.remove();
						StorageManager.owners.remove(StorageManager.ownerpets.get(p));
						StorageManager.ownerpets.remove(p);
					}
				}
			}
		}
	}
	
	public static boolean isPetActive(Player p){
		
		if(StorageManager.ownerpets.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void spawnPet(Player p, Pet pet){
		
		if(pet == Pet.MUSHROOMCOW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMushroomCow cow = new CustomMushroomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.mushroomcow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			final UUID petID = cow.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.PIG){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomPig pig = new CustomPig(nmsWorld);
		    pig.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(pig);
			pig.setAge(1);
			pig.setCustomName(StorageManager.pig.get(p.getName()));
			pig.setCustomNameVisible(true);
			
			final UUID petID = pig.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.WOLF){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomWolf wolf = new CustomWolf(nmsWorld);
		    wolf.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(wolf);
			wolf.setAge(1);
			wolf.setCustomName(StorageManager.wolf.get(p.getName()));
			wolf.setCustomNameVisible(true);
			
			final UUID petID = wolf.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SHEEP){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSheep sheep = new CustomSheep(nmsWorld);
		    sheep.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(sheep);
			sheep.setAge(1);
			sheep.setCustomName(StorageManager.sheep.get(p.getName()));
			sheep.setCustomNameVisible(true);
			
			final UUID petID = sheep.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.HORSE){
			Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
			horse.setAdult();
			horse.setCustomName(StorageManager.horse.get(p.getName()));
			horse.setCustomNameVisible(true);
			horse.setTamed(true);
			horse.setRemoveWhenFarAway(false);
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse.setColor(Horse.Color.BROWN);
			horse.setStyle(Style.WHITE);
			
			final UUID petID = horse.getUniqueId();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.MAGMACUBE){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomMagmaCube magmacube = new CustomMagmaCube(nmsWorld);
		    magmacube.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(magmacube);
			magmacube.setSize(3);
			magmacube.setCustomName(StorageManager.magmacube.get(p.getName()));
			magmacube.setCustomNameVisible(true);
			
			final UUID petID = magmacube.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SLIME){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSlime slime = new CustomSlime(nmsWorld);
		    slime.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(slime);
			slime.setSize(3);
			slime.setCustomName(StorageManager.slime.get(p.getName()));
			slime.setCustomNameVisible(true);
			
			final UUID petID = slime.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.COW){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomCow cow = new CustomCow(nmsWorld);
		    cow.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(cow);
			cow.setAge(1);
			cow.setCustomName(StorageManager.cow.get(p.getName()));
			cow.setCustomNameVisible(true);
			
			final UUID petID = cow.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.SILVERFISH){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomSilverfish silverfish = new CustomSilverfish(nmsWorld);
		    silverfish.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(silverfish);
			silverfish.setCustomName(StorageManager.silverfish.get(p.getName()));
			silverfish.setCustomNameVisible(true);
			
			final UUID petID = silverfish.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
		}
		if(pet == Pet.OCELOT){
			Location loc = p.getLocation();
			
		    net.minecraft.server.v1_7_R3.World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		    CustomOcelot ocelot = new CustomOcelot(nmsWorld);
		    ocelot.setPosition(loc.getX(), loc.getY(), loc.getZ());
		    nmsWorld.addEntity(ocelot);
			ocelot.setAge(1);
			ocelot.setCustomName(StorageManager.ocelot.get(p.getName()));
			ocelot.setCustomNameVisible(true);
			
			final UUID petID = ocelot.getUniqueID();
			StorageManager.owners.put(petID, p);
			StorageManager.ownerpets.put(p, petID);
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
	
	@SuppressWarnings("deprecation")
	public static void removeGadget(Player p){
		
		if(p.getInventory().getItem(6) != null && p.getInventory().getItem(6).getType() != Material.AIR){
			String s = p.getInventory().getItem(6).getItemMeta().getDisplayName();
			
			if(s.endsWith("Stacker")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lStacker§7!");
			}
			if(s.endsWith("Paintballs")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f§lPaintballs§7!");
			}
			if(s.endsWith("Creeper Launcher")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §a§lCreeper Launcher§7!");
			}
			if(s.endsWith("Pet Ride")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §e§lPet Ride§7!");
			}
			if(s.endsWith("Book Explosion")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7§lBook Explosion§7!");
			}
			if(s.startsWith("Firework Gun")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §c§lFirework Gun§7!");
			}
			if(s.endsWith("Swap Teleporter")){
				p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §2§lSwap Teleporter§7!");
			}
			
			p.getInventory().setItem(6, null);
			p.updateInventory();
		}
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
