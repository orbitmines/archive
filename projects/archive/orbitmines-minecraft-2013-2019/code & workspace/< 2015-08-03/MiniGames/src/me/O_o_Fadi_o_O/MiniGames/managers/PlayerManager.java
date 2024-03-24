package me.O_o_Fadi_o_O.MiniGames.managers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.O_o_Fadi_o_O.MiniGames.Start;
import me.O_o_Fadi_o_O.MiniGames.CosmeticPerks.Wardrobe;
import me.O_o_Fadi_o_O.MiniGames.Kits.Others.MiniGamesLobbyKit;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetChicken;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetCreeper;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetMagmaCube;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetMushroomCow;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetOcelot;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetPig;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSheep;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSilverfish;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSlime;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSpider;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetSquid;
import me.O_o_Fadi_o_O.MiniGames.NMS.PetWolf;
import me.O_o_Fadi_o_O.MiniGames.utils.ChatColor;
import me.O_o_Fadi_o_O.MiniGames.utils.Disguise;
import me.O_o_Fadi_o_O.MiniGames.utils.Gadget;
import me.O_o_Fadi_o_O.MiniGames.utils.Hat;
import me.O_o_Fadi_o_O.MiniGames.utils.Pet;
import me.O_o_Fadi_o_O.MiniGames.utils.StaffRank;
import me.O_o_Fadi_o_O.MiniGames.utils.Trail;
import me.O_o_Fadi_o_O.MiniGames.utils.TrailType;
import me.O_o_Fadi_o_O.MiniGames.utils.VIPRank;
import me.mgone.bossbarapi.BossbarAPI;
import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.GenericAttributes;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerManager {

	Start start = Start.getInstance();
	
	private static int bossbarnumber = 0;
	
	@SuppressWarnings("deprecation")
	public static void setBossBar(Player p){
		if(!BossbarAPI.hasBar(p)){
			if(bossbarnumber == 0){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6Welcome §6§l" + p.getName() + "§6!", 10);
				bossbarnumber++;
			}
			else if(bossbarnumber == 1){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.orbitminestokens.get(p) + "§6 OMT", 10);
				bossbarnumber++;
			}
			else if(bossbarnumber == 2){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6§lwww.orbitmines.com", 10);
				bossbarnumber++;
			}
			else if(bossbarnumber == 3){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6IP: §6§lHub.OrbitMinesMC.com", 10);
				bossbarnumber++;
			}
			else if(bossbarnumber == 4){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" +  StorageManager.vippoints.get(p) + "§6 VIP Points", 10);
				bossbarnumber++;
			}
			else if(bossbarnumber == 5){
				BossbarAPI.setMessage(p, "§6§lOrbitMines§4§lNetwork §8| §6You have §6§l" + StorageManager.votes.get(p.getName()) + "§6 Votes", 10);
				bossbarnumber = 0;
			}
		}
	}
	
	public static ItemStack getPlayerHead(String player){
		ItemStack item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(player);
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static ItemStack addColorToLeather(Material leather, Color color){
		ItemStack item = new ItemStack(leather, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(color);
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static void handlePlayerVIPPointsDonation(Player p, int vippoints){
		
		TitleManager.setTitle(p, "", "§b+" + vippoints + " VIP Points");
		
		DatabaseManager.addVIPPoints(p, vippoints);
	}
	
	public static void handlePlayerRankDonation(Player p, VIPRank rank){
		
		TitleManager.setTitle(p, "", getRankMessage(p, rank));
		
		if(StorageManager.viprank.get(p) != VIPRank.User){
			DatabaseManager.setVIPRank(p, rank);
		}
		else{
			StorageManager.viprank.put(p, rank);
			DatabaseManager.insertString(p.getName(), "Rank-VIP", "vip", rank.toString());
		}
	}
	
	public static String getRankMessage(Player p, VIPRank rank){
		if(rank == VIPRank.Emerald_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now an §a§lEmerald VIP§7!");
			return "§7You are now an §a§lEmerald VIP§7!";
		}
		else if(rank == VIPRank.Diamond_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now a §b§lDiamond VIP§7!");
			return "§7You are now a §b§lDiamond VIP§7!";
		}
		else if(rank == VIPRank.Gold_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now a §6§lGold VIP§7!");
			return "§7You are now a §6§lGold VIP§7!";
		}
		else if(rank == VIPRank.Iron_VIP){
			Bukkit.broadcastMessage("§3§lDonate §8| §3" + p.getName() + "§7 is now an §7§lIron VIP§7!");
			return "§7You are now an §7§lIron VIP§7!";
		}
		else{
			return "";
		}
	}
	
	public static boolean hasStaffPerms(Player p, StaffRank rank){
		if(rank == StaffRank.User){
			if(StorageManager.staffrank.get(p) == StaffRank.User || StorageManager.staffrank.get(p) == StaffRank.Builder || StorageManager.staffrank.get(p) == StaffRank.Moderator || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Builder){
			if(StorageManager.staffrank.get(p) == StaffRank.Builder || StorageManager.staffrank.get(p) == StaffRank.Moderator || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Moderator){
			if(StorageManager.staffrank.get(p) == StaffRank.Moderator || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == StaffRank.Owner){
			if(StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
	}
	
	public static boolean hasVIPPerms(Player p, VIPRank rank){
		if(rank == VIPRank.Iron_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Iron_VIP || StorageManager.viprank.get(p) == VIPRank.Gold_VIP || StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Gold_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Gold_VIP || StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Diamond_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Diamond_VIP || StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else if(rank == VIPRank.Emerald_VIP){
			if(StorageManager.viprank.get(p) == VIPRank.Emerald_VIP || StorageManager.staffrank.get(p) == StaffRank.Owner){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return true;
		}
	}
	
	public static void sendVIPPointsRequiredMessage(Player p, int price){
		p.playSound(p.getLocation(), Sound.ENDERMAN_SCREAM, 5, 1);
		int needed = price - StorageManager.vippoints.get(p);
		if(needed == 1){
			p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Point§7!");
		}
		else{
			p.sendMessage("§9Cosmetic Perks §8| §7You need §b§l" + needed + "§7 more §b§lVIP Points§7!");
		}
	}
	
	public static void setCustomTabList(Player p){
        IChatBaseComponent tab1 = ChatSerializer.a("{\"text\": \"§6§lOrbitMines§4§lNetwork\"}");
        IChatBaseComponent tab2 = ChatSerializer.a("{\"text\": \"  §7Type §l/help§7 for Help.\"}");
        PacketPlayOutPlayerListHeaderFooter pack = new PacketPlayOutPlayerListHeaderFooter(tab1);
 
        try{
            Field field = pack.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(pack, tab2);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
        	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(pack);
        }
	}
	
	public static void warnPlayerNotLoaded(Player p){
		p.playSound(p.getLocation(), Sound.CLICK, 5, 1);
		p.sendMessage("§f§lMiniGames §8| §7This Server just §frestarted§7! Wait a few §fseconds§7.");
	}
	
	public static String getPlayerDisplayname(Player p){
		
		StaffRank staff = StorageManager.staffrank.get(p);
		VIPRank vip = StorageManager.viprank.get(p);
		
		if(staff == StaffRank.Owner){
			return "§4§lOwner §4" + p.getName(); 
		}
		else if(staff == StaffRank.Moderator){
			return "§b§lMod §b" + p.getName(); 
		}
		else if(staff == StaffRank.Builder){
			return "§d§lBuilder §d" + p.getName(); 
		}
		else if(vip == VIPRank.Emerald_VIP){
			return "§a§lEmerald §a" + p.getName(); 
		}
		else if(vip == VIPRank.Diamond_VIP){
			return "§9§lDiamond §9" + p.getName(); 
		}
		else if(vip == VIPRank.Gold_VIP){
			return "§6§lGold §6" + p.getName(); 
		}
		else if(vip == VIPRank.Iron_VIP){
			return "§7§lIron §7" + p.getName(); 
		}
		else{
			return "§8" + p.getName(); 
		}
	}
	
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
		
		if(StorageManager.wardrobedisco.containsKey(p) && StorageManager.wardrobedisco.get(p) == true){
			DatabaseManager.setDiscoWardrobe(p, false);
		}
	}
	
	public static void setRandomArmorForConfirmInv(Inventory inv, Player p){
		Color c = null;
		String color = null;
		
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		int rInt = new Random().nextInt(14);
		
		if(rInt == 0){c = Color.AQUA; color = "§b";}
		if(rInt == 1){c = Color.BLACK; color = "§0";}
		if(rInt == 2){c = Color.BLUE; color = "§9";}
		if(rInt == 3){c = Color.FUCHSIA; color = "§d";}
		if(rInt == 4){c = Color.GRAY; color = "§7";}
		if(rInt == 5){c = Color.GREEN; color = "§2";}
		if(rInt == 6){c = Color.LIME; color = "§a";}
		if(rInt == 7){c = Color.NAVY; color = "§1";}
		if(rInt == 8){c = Color.ORANGE; color = "§6";}
		if(rInt == 9){c = Color.PURPLE; color = "§5";}
		if(rInt == 10){c = Color.RED; color = "§c";}
		if(rInt == 11){c = Color.TEAL; color = "§3";}
		if(rInt == 12){c = Color.WHITE; color = "§f";}
		if(rInt == 13){c = Color.YELLOW; color = "§e";}
		
		meta.setColor(c);
		meta.setDisplayName(color + "Disco Armor");
		item.setItemMeta(meta);
		
		inv.setItem(13, item);
	}
	
	public static void setRandomArmorForWardrobeInv(Inventory inv, Player p){
		Color c = null;
		String color = null;
		
		int rInt = new Random().nextInt(14);
		
		if(rInt == 0){c = Color.AQUA; color = "§b";}
		if(rInt == 1){c = Color.BLACK; color = "§0";}
		if(rInt == 2){c = Color.BLUE; color = "§9";}
		if(rInt == 3){c = Color.FUCHSIA; color = "§d";}
		if(rInt == 4){c = Color.GRAY; color = "§7";}
		if(rInt == 5){c = Color.GREEN; color = "§2";}
		if(rInt == 6){c = Color.LIME; color = "§a";}
		if(rInt == 7){c = Color.NAVY; color = "§1";}
		if(rInt == 8){c = Color.ORANGE; color = "§6";}
		if(rInt == 9){c = Color.PURPLE; color = "§5";}
		if(rInt == 10){c = Color.RED; color = "§c";}
		if(rInt == 11){c = Color.TEAL; color = "§3";}
		if(rInt == 12){c = Color.WHITE; color = "§f";}
		if(rInt == 13){c = Color.YELLOW; color = "§e";}
		
		Wardrobe.setDiscoItem(inv, p, c, color);
	}
	
	public static void setRandomArmorForPlayerInv(Player p){
		List<Color> unlockedColors = StorageManager.wardrobeunlockedcolors.get(p);
		int rInt = new Random().nextInt(unlockedColors.size());
		
		Color c = unlockedColors.get(rInt);
		
		String color = null;

		if(c == Color.AQUA){ color = "§b";}
		if(c == Color.BLACK){ color = "§0";}
		if(c == Color.BLUE){ color = "§9";}
		if(c == Color.FUCHSIA){ color = "§d";}
		if(c == Color.GRAY){ color = "§7";}
		if(c == Color.GREEN){ color = "§2";}
		if(c == Color.LIME){ color = "§a";}
		if(c == Color.NAVY){ color = "§1";}
		if(c == Color.ORANGE){ color = "§6";}
		if(c == Color.PURPLE){ color = "§5";}
		if(c == Color.RED){ color = "§c";}
		if(c == Color.TEAL){ color = "§3";}
		if(c == Color.WHITE){ color = "§f";}
		if(c == Color.YELLOW){ color = "§e";}
		
		giveLeatherWardrobeArmor(p, c, color + "Disco Armor");
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
	
	public static boolean hasTrailEnabled(Player p){
		
		if(StorageManager.trail.containsKey(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void removeTrail(Player p){
		
		Trail trail = StorageManager.trail.get(p);
		
		if(trail == Trail.MOB_SPAWNER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §7Mob Spawner Trail§7!");
		}
		if(trail == Trail.FIREWORK_SPARK){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cFireWork Spark Trail§7!");
		}
		if(trail == Trail.CRIT){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §bCrit Trail§7!");
		}
		if(trail == Trail.MAGIC){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §3Magic Trail§7!");
		}
		if(trail == Trail.BUBBLE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fBubble Trail§7!");
		}
		if(trail == Trail.WITCH){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §5Witch Trail§7!");
		}
		if(trail == Trail.MUSIC){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §dMusic Trail§7!");
		}
		if(trail == Trail.ENCHANTMENT_TABLE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §1Enchantment Table Trail§7!");
		}
		if(trail == Trail.TNT){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4TNT Trail§7!");
		}
		if(trail == Trail.LAVA){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6Lava Trail§7!");
		}
		if(trail == Trail.WATER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §9Water Trail§7!");
		}
		if(trail == Trail.SMOKE){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §0Smoke Trail§7!");
		}
		if(trail == Trail.RAINBOW){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §4Rainbow Trail§7!");
		}
		if(trail == Trail.SNOW){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §fSnow Trail§7!");
		}
		if(trail == Trail.HEART){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §cHeart Trail§7!");
		}
		if(trail == Trail.HAPPY_VILLAGER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §aHappy Villager Trail§7!");
		}
		if(trail == Trail.ANGRY_VILLAGER){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §8Angry Villager Trail§7!");
		}
		if(trail == Trail.SLIME){
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
	
	/*
	 * Gadgets
	 */
	
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
			else if(displayName.endsWith("Snowman Attack")){
				return Gadget.SNOWMAN_ATTACK;
			}
			else{
				return Gadget.STACKER;
			}
		}
		catch(Exception ex){
			return null;
		}
	}
	
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
		else if(g == Gadget.SNOWMAN_ATTACK){
			p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §6§lSnowman Attack§7!");
		}
		
		p.getInventory().setItem(5, null);
		p.updateInventory();
	}
	
	/*
	 * Pets
	 */
	
	public static void removePet(Player p, String petname){
		
		p.sendMessage("§9Cosmetic Perks §8| §c§lDISABLED §7your §f" + petname + "§7!");
		Entity en = StorageManager.petentity.get(p);
		StorageManager.pet.put(p, Pet.NONE);
		if(en instanceof LivingEntity){
			en.remove();
			StorageManager.petentity.remove(p);
			StorageManager.petowner.remove(en);
		}
		if(StorageManager.petshroomtrail.containsKey(p)){
			StorageManager.petshroomtrail.remove(p);
		}
		if(StorageManager.petbabypigs.containsKey(p) && StorageManager.petbabypigs.get(p) == true){
			for(Entity pig : StorageManager.petbabypigsentities.get(p)){
				pig.remove();
			}
			StorageManager.petbabypigs.remove(p);
		}
		if(StorageManager.petsheepdisco.containsKey(p)){
			StorageManager.petsheepdisco.remove(p);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void givePetInv(Player p){
		
		Pet pet = StorageManager.pet.get(p);
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
			if(StorageManager.petshroomtrail.get(p) == false){
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
				int size = ((MagmaCube) StorageManager.petentity.get(p)).getSize();
				ItemStack item = new ItemStack(Material.MAGMA_CREAM, size);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§c§nChange Size");
				item.setItemMeta(meta);
				p.getInventory().setItem(6, item);
			}
		}
		if(pet == Pet.PIG){
			if(StorageManager.petbabypigs.get(p) == false){
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
				if(((Pig) StorageManager.petentity.get(p)).isAdult()){
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
				int size = ((Slime) StorageManager.petentity.get(p)).getSize();
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
				if(((Wolf) StorageManager.petentity.get(p)).isAdult()){
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
				if(((Cow) StorageManager.petentity.get(p)).isAdult()){
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
			if(StorageManager.petsheepdisco.get(p) == false){
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
				Sheep s = (Sheep) StorageManager.petentity.get(p);
				
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
				Horse h = (Horse) StorageManager.petentity.get(p);
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
				Creeper c = (Creeper) StorageManager.petentity.get(p);

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
				if(((Chicken) StorageManager.petentity.get(p)).isAdult()){
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
		
		Location l = p.getLocation();
		
	    net.minecraft.server.v1_8_R1.World nmsWorld = ((CraftWorld) l.getWorld()).getHandle();
		
		if(pet == Pet.CREEPER){
		    PetCreeper petentity = new PetCreeper(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.CREEPER);
		    petentity.setCustomName(StorageManager.creeperpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SPIDER){
		    PetSpider petentity = new PetSpider(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SPIDER);
		    petentity.setCustomName(StorageManager.spiderpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.MUSHROOMCOW){
		    PetMushroomCow petentity = new PetMushroomCow(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.MUSHROOMCOW);
		    petentity.setCustomName(StorageManager.mushroomcowpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			StorageManager.petshroomtrail.put(p, false);
		}
		else if(pet == Pet.PIG){
		    PetPig petentity = new PetPig(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.PIG);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.pigpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			
			StorageManager.petbabypigs.put(p, false);
		}
		else if(pet == Pet.WOLF){
		    PetWolf petentity = new PetWolf(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.WOLF);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.wolfpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SHEEP){
		    PetSheep petentity = new PetSheep(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SHEEP);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.sheeppet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
			
			StorageManager.petsheepdisco.put(p, false);
		}
		else if(pet == Pet.HORSE){
		    StorageManager.pet.put(p, Pet.HORSE);
			Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
			horse.setAdult();
			horse.setCustomName(StorageManager.horsepet.get(p));
			horse.setCustomNameVisible(true);
			horse.setTamed(true);
			horse.setRemoveWhenFarAway(false);
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse.setColor(Horse.Color.BROWN);
			horse.setStyle(Style.WHITE);
			StorageManager.petowner.put(horse, p);
			StorageManager.petentity.put(p, horse);
			AttributeInstance currentSpeed = ((EntityInsentient) ((CraftLivingEntity) horse).getHandle()).getAttributeInstance(GenericAttributes.d);
			currentSpeed.setValue(0.25);
		}
		else if(pet == Pet.MAGMACUBE){
		    PetMagmaCube petentity = new PetMagmaCube(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    petentity.setSize(3);
		    StorageManager.pet.put(p, Pet.MAGMACUBE);
		    petentity.setCustomName(StorageManager.magmacubepet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SLIME){
		    PetSlime petentity = new PetSlime(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SLIME);
		    petentity.setSize(3);
		    petentity.setCustomName(StorageManager.slimepet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.COW){
		    PetCow petentity = new PetCow(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.COW);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.cowpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SILVERFISH){
		    PetSilverfish petentity = new PetSilverfish(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SILVERFISH);
		    petentity.setCustomName(StorageManager.silverfishpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.OCELOT){
		    PetOcelot petentity = new PetOcelot(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.OCELOT);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.ocelotpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.SQUID){
		    PetSquid petentity = new PetSquid(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.SQUID);
		    petentity.setCustomName(StorageManager.squidpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
		else if(pet == Pet.CHICKEN){
		    PetChicken petentity = new PetChicken(nmsWorld);
		    petentity.setPosition(l.getX(), l.getY(), l.getZ());
		    nmsWorld.addEntity(petentity);
		    StorageManager.pet.put(p, Pet.CHICKEN);
		    petentity.setAge(1);
		    petentity.setCustomName(StorageManager.chickenpet.get(p));
		    petentity.setCustomNameVisible(true);
			StorageManager.petowner.put(petentity.getBukkitEntity(), p);
			StorageManager.petentity.put(p, petentity.getBukkitEntity());
		}
	}
	
	public static boolean parseBoolean(String bl){
		if(bl.equals("true")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static Color parseColor(String color){
		Color c = null;
		if(color.equals("AQUA")){
			c = Color.AQUA;
		}
		else if(color.equals("BLACK")){
			c = Color.BLACK;
		}
		else if(color.equals("BLUE")){
			c = Color.BLUE;
		}
		else if(color.equals("FUCHSIA")){
			c = Color.FUCHSIA;
		}
		else if(color.equals("GRAY")){
			c = Color.GRAY;
		}
		else if(color.equals("GREEN")){
			c = Color.GREEN;
		}
		else if(color.equals("LIME")){
			c = Color.LIME;
		}
		else if(color.equals("MAROON")){
			c = Color.MAROON;
		}
		else if(color.equals("NAVY")){
			c = Color.NAVY;
		}
		else if(color.equals("OLIVE")){
			c = Color.OLIVE;
		}
		else if(color.equals("ORANGE")){
			c = Color.ORANGE;
		}
		else if(color.equals("PURPLE")){
			c = Color.PURPLE;
		}
		else if(color.equals("RED")){
			c = Color.RED;
		}
		else if(color.equals("SILVER")){
			c = Color.SILVER;
		}
		else if(color.equals("TEAL")){
			c = Color.TEAL;
		}
		else if(color.equals("WHITE")){
			c = Color.WHITE;
		}
		else if(color.equals("YELLOW")){
			c = Color.YELLOW;
		}
		else{
			c = null;
		}
		return c;
	}
	
	public static String parseStringFromColor(Color color){
		String c;
		if(color == Color.AQUA){
			c = "AQUA";
		}
		else if(color == Color.BLACK){
			c = "BLACK";
		}
		else if(color == Color.BLUE){
			c = "BLUE";
		}
		else if(color == Color.FUCHSIA){
			c = "FUCHSIA";
		}
		else if(color == Color.GRAY){
			c = "GRAY";
		}
		else if(color == Color.GREEN){
			c = "GREEN";
		}
		else if(color == Color.LIME){
			c = "LIME";
		}
		else if(color == Color.MAROON){
			c = "MAROON";
		}
		else if(color == Color.NAVY){
			c = "NAVY";
		}
		else if(color == Color.OLIVE){
			c = "OLIVE";
		}
		else if(color == Color.ORANGE){
			c = "ORANGE";
		}
		else if(color == Color.PURPLE){
			c = "PURPLE";
		}
		else if(color == Color.RED){
			c = "RED";
		}
		else if(color == Color.SILVER){
			c = "SILVER";
		}
		else if(color == Color.TEAL){
			c = "TEAL";
		}
		else if(color == Color.WHITE){
			c = "WHITE";
		}
		else if(color == Color.YELLOW){
			c = "YELLOW";
		}
		else{
			c = null;
		}
		return c;
	}
	
	public void loadPlayer(final Player p){
		PlayerManager.setCustomTabList(p);
		StorageManager.opmodeenabled.put(p, false);
		StorageManager.loaded.put(p, false);
		Start.clearInventory(p);
		MiniGamesLobbyKit.giveInventory(p, true);
		
		try{
			if(DatabaseManager.containsPath("name", "Rank-VIP", p.getName())){
				StorageManager.viprank.put(p, VIPRank.valueOf(DatabaseManager.getString(p, "Rank-VIP", "vip")));
			}
			else{
				StorageManager.viprank.put(p, VIPRank.User);
			}
			
			if(DatabaseManager.containsPath("name", "Rank-Staff", p.getName())){
				StorageManager.staffrank.put(p, StaffRank.valueOf(DatabaseManager.getString(p, "Rank-Staff", "staff")));
			}
			else{
				StorageManager.staffrank.put(p, StaffRank.User);
			}
			
			StorageManager.pet.put(p, Pet.NONE);
			
			if(!DatabaseManager.containsPath("name", "Votes", p.getName().toLowerCase())){
				DatabaseManager.insertInt(p.getName().toLowerCase(), "Votes", "votes", 0);
			}
			if(!DatabaseManager.containsPath("name", "OrbitMinesTokens", p.getName())){
				DatabaseManager.insertInt(p.getName(), "OrbitMinesTokens", "omt", 0);
			}
			if(!DatabaseManager.containsPath("name", "VIPPoints", p.getName())){
				DatabaseManager.insertInt(p.getName(), "VIPPoints", "points", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameCoins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameCoins", "coins", 0);
			}
			
			if(!DatabaseManager.containsPath("name", "MiniGameKills", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameKills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameLoses", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameLoses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("name", "MiniGameWins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "MiniGameWins", "wins", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Kills", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Kills", "kills", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Loses", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Loses", "loses", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-Wins", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-Wins", "wins", 0);
			}
			
			if(!DatabaseManager.containsPath("name", "ChickenFight-BestStreak", p.getName())){
				DatabaseManager.insertInt(p.getName(), "ChickenFight-BestStreak", "beststreak", 0);
			}
			if(!DatabaseManager.containsPath("name", "SurvivalGames-BestStreak", p.getName())){
				DatabaseManager.insertInt(p.getName(), "SurvivalGames-BestStreak", "beststreak", 0);
			}
			
			if(!DatabaseManager.containsPath("name", "Fireworks-Passes", p.getName())){
				DatabaseManager.insertInt(p.getName(), "Fireworks-Passes", "passes", 0);
			}
			
			StorageManager.chickenfightkills.put(p, DatabaseManager.getInt(p.getName(), "MiniGameKills", "kills"));
			StorageManager.chickenfightloses.put(p, DatabaseManager.getInt(p.getName(), "MiniGameLoses", "loses"));
			StorageManager.chickenfightwins.put(p, DatabaseManager.getInt(p.getName(), "MiniGameWins", "wins"));
			StorageManager.chickenfightbeststreak.put(p, DatabaseManager.getInt(p.getName(), "ChickenFight-BestStreak", "beststreak"));
			
			StorageManager.survivalgameskills.put(p, DatabaseManager.getInt(p.getName(), "SurvivalGames-Kills", "kills"));
			StorageManager.survivalgamesloses.put(p, DatabaseManager.getInt(p.getName(), "SurvivalGames-Loses", "loses"));
			StorageManager.survivalgameswins.put(p, DatabaseManager.getInt(p.getName(), "SurvivalGames-Wins", "wins"));
			StorageManager.survivalgamesbeststreak.put(p, DatabaseManager.getInt(p.getName(), "SurvivalGames-BestStreak", "beststreak"));
			
			StorageManager.orbitminestokens.put(p, DatabaseManager.getInt(p.getName(), "OrbitMinesTokens", "omt"));
			StorageManager.vippoints.put(p, DatabaseManager.getInt(p.getName(), "VIPPoints", "points"));
			StorageManager.minigamecoins.put(p, DatabaseManager.getInt(p.getName(), "MiniGameCoins", "coins"));
			
			StorageManager.kitchickenmama.put(p, false);
			
			if(DatabaseManager.containsPath("name", "ChickenFight-BabyChicken", p.getName())){
				StorageManager.kitbabychicken.put(p, false);
			}
			if(DatabaseManager.containsPath("name", "ChickenFight-HotWing", p.getName())){
				StorageManager.kithotwing.put(p, false);
			}
			if(DatabaseManager.containsPath("name", "ChickenFight-ChickenWarrior", p.getName())){
				StorageManager.kitchickenwarrior.put(p, false);
			}
			
			StorageManager.votes.put(p.getName(), DatabaseManager.getInt(p.getName().toLowerCase(), "Votes", "votes"));
			
			StorageManager.fireworkpasses.put(p, DatabaseManager.getInt(p.getName(), "Fireworks-Passes", "passes"));
			
			if(DatabaseManager.containsPath("name", "Gadgets-Paintballs", p.getName())){
				StorageManager.paintballsgadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-CreeperLauncher", p.getName())){
				StorageManager.creeperlaunchergadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-PetRide", p.getName())){
				StorageManager.petridegadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-BookExplosion", p.getName())){
				StorageManager.bookexplosiongadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-SwapTeleporter", p.getName())){
				StorageManager.swapteleportergadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-MagmaCubeSoccer", p.getName())){
				StorageManager.magmacubesoccergadget.add(p);
			}
			if(DatabaseManager.containsPath("name", "Gadgets-SnowmanAttack", p.getName())){
				StorageManager.snowmanattackgadget.add(p);
			}
			
			boolean hasPet = false;
			if(DatabaseManager.containsPath("name", "Pets-MushroomCow", p.getName())){
				StorageManager.mushroomcowpet.put(p, DatabaseManager.getString(p, "Pets-Ocelot", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Pig", p.getName())){
				StorageManager.pigpet.put(p, DatabaseManager.getString(p, "Pets-Pig", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Wolf", p.getName())){
				StorageManager.wolfpet.put(p, DatabaseManager.getString(p, "Pets-Wolf", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Sheep", p.getName())){
				StorageManager.sheeppet.put(p, DatabaseManager.getString(p, "Pets-Sheep", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Horse", p.getName())){
				StorageManager.horsepet.put(p, DatabaseManager.getString(p, "Pets-Horse", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-MagmaCube", p.getName())){
				StorageManager.magmacubepet.put(p, DatabaseManager.getString(p, "Pets-MagmaCube", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Slime", p.getName())){
				StorageManager.slimepet.put(p, DatabaseManager.getString(p, "Pets-Slime", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Cow", p.getName())){
				StorageManager.cowpet.put(p, DatabaseManager.getString(p, "Pets-Cow", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Silverfish", p.getName())){
				StorageManager.silverfishpet.put(p, DatabaseManager.getString(p, "Pets-Silverfish", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Ocelot", p.getName())){
				StorageManager.ocelotpet.put(p, DatabaseManager.getString(p, "Pets-Ocelot", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Creeper", p.getName())){
				StorageManager.creeperpet.put(p, DatabaseManager.getString(p, "Pets-Creeper", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Squid", p.getName())){
				StorageManager.squidpet.put(p, DatabaseManager.getString(p, "Pets-Squid", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Spider", p.getName())){
				StorageManager.spiderpet.put(p, DatabaseManager.getString(p, "Pets-Spider", "petname"));
				hasPet = true;
			}
			if(DatabaseManager.containsPath("name", "Pets-Chicken", p.getName())){
				StorageManager.chickenpet.put(p, DatabaseManager.getString(p, "Pets-Chicken", "petname"));
				hasPet = true;
			}
			
			StorageManager.hasunlockedpet.put(p, hasPet);
			
			List<Color> unlockedWardrobeArmor = new ArrayList<Color>();
			
			if(DatabaseManager.containsPath("name", "Wardrobe-White", p.getName())){
				StorageManager.wardrobearmor.get(Color.WHITE).add(p);
				unlockedWardrobeArmor.add(Color.WHITE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Blue", p.getName())){
				StorageManager.wardrobearmor.get(Color.BLUE).add(p);
				unlockedWardrobeArmor.add(Color.BLUE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Green", p.getName())){
				StorageManager.wardrobearmor.get(Color.GREEN).add(p);
				unlockedWardrobeArmor.add(Color.GREEN);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Black", p.getName())){
				StorageManager.wardrobearmor.get(Color.BLACK).add(p);
				unlockedWardrobeArmor.add(Color.BLACK);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightBlue", p.getName())){
				StorageManager.wardrobearmor.get(Color.AQUA).add(p);
				unlockedWardrobeArmor.add(Color.AQUA);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Pink", p.getName())){
				StorageManager.wardrobearmor.get(Color.FUCHSIA).add(p);
				unlockedWardrobeArmor.add(Color.FUCHSIA);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-LightGreen", p.getName())){
				StorageManager.wardrobearmor.get(Color.LIME).add(p);
				unlockedWardrobeArmor.add(Color.LIME);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-DarkBlue", p.getName())){
				StorageManager.wardrobearmor.get(Color.NAVY).add(p);
				unlockedWardrobeArmor.add(Color.NAVY);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Purple", p.getName())){
				StorageManager.wardrobearmor.get(Color.PURPLE).add(p);
				unlockedWardrobeArmor.add(Color.PURPLE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Orange", p.getName())){
				StorageManager.wardrobearmor.get(Color.ORANGE).add(p);
				unlockedWardrobeArmor.add(Color.ORANGE);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Red", p.getName())){
				StorageManager.wardrobearmor.get(Color.RED).add(p);
				unlockedWardrobeArmor.add(Color.RED);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Cyan", p.getName())){
				StorageManager.wardrobearmor.get(Color.TEAL).add(p);
				unlockedWardrobeArmor.add(Color.TEAL);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Yellow", p.getName())){
				StorageManager.wardrobearmor.get(Color.YELLOW).add(p);
				unlockedWardrobeArmor.add(Color.YELLOW);
			}
			if(DatabaseManager.containsPath("name", "Wardrobe-Gray", p.getName())){
				StorageManager.wardrobearmor.get(Color.GRAY).add(p);
				unlockedWardrobeArmor.add(Color.GRAY);
			}
			StorageManager.wardrobeunlockedcolors.put(p, unlockedWardrobeArmor);
			
			if(DatabaseManager.containsPath("name", "Wardrobe-Disco", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "Wardrobe-Disco", "disco");
				if(sBoolean.equals("false")){
					StorageManager.wardrobedisco.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.wardrobedisco.put(p, true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "ChatColors-DarkRed", p.getName())){
				StorageManager.chatcolors.get(ChatColor.DARK_RED).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-LightGreen", p.getName())){
				StorageManager.chatcolors.get(ChatColor.LIGHT_GREEN).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-DarkGray", p.getName())){
				StorageManager.chatcolors.get(ChatColor.DARK_GRAY).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Red", p.getName())){
				StorageManager.chatcolors.get(ChatColor.RED).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-White", p.getName())){
				StorageManager.chatcolors.get(ChatColor.WHITE).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-LightBlue", p.getName())){
				StorageManager.chatcolors.get(ChatColor.LIGHT_BLUE).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Pink", p.getName())){
				StorageManager.chatcolors.get(ChatColor.PINK).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Blue", p.getName())){
				StorageManager.chatcolors.get(ChatColor.BLUE).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-DarkBlue", p.getName())){
				StorageManager.chatcolors.get(ChatColor.DARK_BLUE).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Green", p.getName())){
				StorageManager.chatcolors.get(ChatColor.GREEN).add(p);
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Black", p.getName())){
				StorageManager.chatcolors.get(ChatColor.BLACK).add(p);
			}
			
			if(DatabaseManager.containsPath("name", "ChatColors-Bold", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "ChatColors-Bold", "bold");
				if(sBoolean.equals("false")){
					StorageManager.boldchatcolor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.boldchatcolor.put(p, true);
				}
			}
			if(DatabaseManager.containsPath("name", "ChatColors-Cursive", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "ChatColors-Cursive", "cursive");
				if(sBoolean.equals("false")){
					StorageManager.cursivechatcolor.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.cursivechatcolor.put(p, true);
				}
			}
			
			boolean hasTrail = false;
			if(DatabaseManager.containsPath("name", "Trails-AngryVillager", p.getName())){
				StorageManager.trails.get(Trail.ANGRY_VILLAGER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Hearts", p.getName())){
				StorageManager.trails.get(Trail.HEART).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Bubble", p.getName())){
				StorageManager.trails.get(Trail.BUBBLE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Crit", p.getName())){
				StorageManager.trails.get(Trail.CRIT).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-ETable", p.getName())){
				StorageManager.trails.get(Trail.ENCHANTMENT_TABLE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Explode", p.getName())){
				StorageManager.trails.get(Trail.TNT).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Firework", p.getName())){
				StorageManager.trails.get(Trail.FIREWORK_SPARK).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-HappyVillager", p.getName())){
				StorageManager.trails.get(Trail.HAPPY_VILLAGER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-MobSpawner", p.getName())){
				StorageManager.trails.get(Trail.MOB_SPAWNER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Music", p.getName())){
				StorageManager.trails.get(Trail.MUSIC).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Slime", p.getName())){
				StorageManager.trails.get(Trail.SLIME).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Smoke", p.getName())){
				StorageManager.trails.get(Trail.SMOKE).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Snow", p.getName())){
				StorageManager.trails.get(Trail.SNOW).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Water", p.getName())){
				StorageManager.trails.get(Trail.WATER).add(p);
				hasTrail = true;
			}
			if(DatabaseManager.containsPath("name", "Trails-Witch", p.getName())){
				StorageManager.trails.get(Trail.WITCH).add(p);
				hasTrail = true;
			}
			
			StorageManager.hasunlockedtrail.put(p, hasTrail);
			
			if(DatabaseManager.containsPath("name", "Trails-Type", p.getName())){
				StorageManager.trailtype.put(p, TrailType.valueOf(DatabaseManager.getString(p, "Trails-Type", "type")));
			}
			else{
				DatabaseManager.insertString(p.getName(), "Trails-Type", "type", TrailType.BASIC_TRAIL.toString());
				StorageManager.trailtype.put(p, TrailType.BASIC_TRAIL);
			}
			
			if(DatabaseManager.containsPath("name", "Trails-TypeBig", p.getName())){
				StorageManager.trailtypes.get(TrailType.BIG_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("name", "Trails-TypeBody", p.getName())){
				StorageManager.trailtypes.get(TrailType.BODY_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("name", "Trails-TypeGround", p.getName())){
				StorageManager.trailtypes.get(TrailType.GROUND_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("name", "Trails-TypeHead", p.getName())){
				StorageManager.trailtypes.get(TrailType.HEAD_TRAIL).add(p);
			}
			if(DatabaseManager.containsPath("name", "Trails-TypeVertical", p.getName())){
				StorageManager.trailtypes.get(TrailType.VERTICAL_TRAIL).add(p);
			}
			
			if(DatabaseManager.containsPath("name", "Trails-TypeSpecial", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "Trails-TypeSpecial", "special");
				if(sBoolean.equals("false")){
					StorageManager.trailspecial.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.trailspecial.put(p, true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "Trails-TypeParticlesAmount", p.getName())){
				StorageManager.trailparticlesamount.put(p, DatabaseManager.getInt(p.getName(), "Trails-TypeParticlesAmount", "amount"));
			}
			else{
				DatabaseManager.insertInt(p.getName(), "Trails-TypeParticlesAmount", "amount", 1);
				StorageManager.trailparticlesamount.put(p, 1);
			}
			
			
			if(DatabaseManager.containsPath("name", "ChatColors", p.getName())){
				StorageManager.chatcolor.put(p, DatabaseManager.getString(p, "ChatColors", "color"));
			}
			else{
				DatabaseManager.insertString(p.getName(), "ChatColors", "color", "7");
				StorageManager.chatcolor.put(p, "7");
			}
			
			boolean hasHat = false;
			if(DatabaseManager.containsPath("name", "Hats-Bedrock", p.getName())){
				StorageManager.hats.get(Hat.BEDROCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-BlackGlass", p.getName())){
				StorageManager.hats.get(Hat.BLACK_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Cactus", p.getName())){
				StorageManager.hats.get(Hat.CACTUS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalBlock", p.getName())){
				StorageManager.hats.get(Hat.COAL_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-CoalOre", p.getName())){
				StorageManager.hats.get(Hat.COAL_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Furnace", p.getName())){
				StorageManager.hats.get(Hat.FURNACE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Glass", p.getName())){
				StorageManager.hats.get(Hat.GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Grass", p.getName())){
				StorageManager.hats.get(Hat.GRASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-GreenGlass", p.getName())){
				StorageManager.hats.get(Hat.GREEN_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-HayBale", p.getName())){
				StorageManager.hats.get(Hat.HAY_BALE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Ice", p.getName())){
				StorageManager.hats.get(Hat.ICE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisBlock", p.getName())){
				StorageManager.hats.get(Hat.LAPIS_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-LapisOre", p.getName())){
				StorageManager.hats.get(Hat.LAPIS_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Leaves", p.getName())){
				StorageManager.hats.get(Hat.LEAVES).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-MagentaGlass", p.getName())){
				StorageManager.hats.get(Hat.MAGENTA_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Melon", p.getName())){
				StorageManager.hats.get(Hat.MELON).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Mycelium", p.getName())){
				StorageManager.hats.get(Hat.MYCELIUM).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-OrangeGlass", p.getName())){
				StorageManager.hats.get(Hat.ORANGE_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzBlock", p.getName())){
				StorageManager.hats.get(Hat.QUARTZ_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-QuartzOre", p.getName())){
				StorageManager.hats.get(Hat.QUARTZ_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-RedGlass", p.getName())){
				StorageManager.hats.get(Hat.RED_GLASS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneBlock", p.getName())){
				StorageManager.hats.get(Hat.REDSTONE_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-RedstoneOre", p.getName())){
				StorageManager.hats.get(Hat.REDSTONE_ORE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Snow", p.getName())){
				StorageManager.hats.get(Hat.SNOW).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-StoneBricks", p.getName())){
				StorageManager.hats.get(Hat.STONE_BRICKS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-TNT", p.getName())){
				StorageManager.hats.get(Hat.TNT).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Workbench", p.getName())){
				StorageManager.hats.get(Hat.WORKBENCH).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Diorite", p.getName())){
				StorageManager.hats.get(Hat.DIORITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-DarkPrismarine", p.getName())){
				StorageManager.hats.get(Hat.DARK_PRISMARINE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Sponge", p.getName())){
				StorageManager.hats.get(Hat.SPONGE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-SlimeBlock", p.getName())){
				StorageManager.hats.get(Hat.SLIME_BLOCK).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-SeaLantern", p.getName())){
				StorageManager.hats.get(Hat.SEA_LANTERN).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-PrismarineBricks", p.getName())){
				StorageManager.hats.get(Hat.PRISMARINE_BRICKS).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Granite", p.getName())){
				StorageManager.hats.get(Hat.GRANITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Chest", p.getName())){
				StorageManager.hats.get(Hat.CHEST).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Glowstone", p.getName())){
				StorageManager.hats.get(Hat.GLOWSTONE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-WetSponge", p.getName())){
				StorageManager.hats.get(Hat.WET_SPONGE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-Andesite", p.getName())){
				StorageManager.hats.get(Hat.ANDESITE).add(p);
				hasHat = true;
			}
			if(DatabaseManager.containsPath("name", "Hats-BlueGlass", p.getName())){
				StorageManager.hats.get(Hat.BLUE_GLASS).add(p);
				hasHat = true;
			}
			
			StorageManager.hasunlockedhat.put(p, hasHat);
			
			if(DatabaseManager.containsPath("name", "Hats-BlockTrail", p.getName())){
				String sBoolean = DatabaseManager.getString(p, "Hats-BlockTrail", "blocktrail");
				if(sBoolean.equals("false")){
					StorageManager.hatsblocktrail.put(p, false);
				}
				if(sBoolean.equals("true")){
					StorageManager.hatsblocktrail.put(p, true);
				}
			}
			
			if(DatabaseManager.containsPath("name", "Dis-Witch", p.getName())){
				StorageManager.disguises.get(Disguise.WITCH).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Bat", p.getName())){
				StorageManager.disguises.get(Disguise.BAT).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Chicken", p.getName())){
				StorageManager.disguises.get(Disguise.CHICKEN).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Ocelot", p.getName())){
				StorageManager.disguises.get(Disguise.OCELOT).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-MushroomCow", p.getName())){
				StorageManager.disguises.get(Disguise.MUSHROOM_COW).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Squid", p.getName())){
				StorageManager.disguises.get(Disguise.SQUID).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Slime", p.getName())){
				StorageManager.disguises.get(Disguise.SLIME).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-ZombiePigman", p.getName())){
				StorageManager.disguises.get(Disguise.ZOMBIE_PIGMAN).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-MagmaCube", p.getName())){
				StorageManager.disguises.get(Disguise.MAGMA_CUBE).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Skeleton", p.getName())){
				StorageManager.disguises.get(Disguise.SKELETON).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Wolf", p.getName())){
				StorageManager.disguises.get(Disguise.WOLF).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Spider", p.getName())){
				StorageManager.disguises.get(Disguise.SPIDER).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Silverfish", p.getName())){
				StorageManager.disguises.get(Disguise.SILVERFISH).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Sheep", p.getName())){
				StorageManager.disguises.get(Disguise.SHEEP).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-CaveSpider", p.getName())){
				StorageManager.disguises.get(Disguise.CAVE_SPIDER).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Creeper", p.getName())){
				StorageManager.disguises.get(Disguise.CREEPER).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Cow", p.getName())){
				StorageManager.disguises.get(Disguise.COW).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Enderman", p.getName())){
				StorageManager.disguises.get(Disguise.ENDERMAN).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Horse", p.getName())){
				StorageManager.disguises.get(Disguise.HORSE).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-IronGolem", p.getName())){
				StorageManager.disguises.get(Disguise.IRON_GOLEM).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Ghast", p.getName())){
				StorageManager.disguises.get(Disguise.GHAST).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Snowman", p.getName())){
				StorageManager.disguises.get(Disguise.SNOWMAN).add(p);
			}
			if(DatabaseManager.containsPath("name", "Dis-Rabbit", p.getName())){
				StorageManager.disguises.get(Disguise.RABBIT).add(p);
			}
			
			if(DatabaseManager.containsPath("name", "PlayerNicknames", p.getName())){
				StorageManager.nickname.put(p, DatabaseManager.getString(p, "PlayerNicknames", "nick"));
			}
			
			StorageManager.hatsinvpage.put(p, 1);
			
			if(DatabaseManager.containsPath("name", "Fireworks-Settings", p.getName())){
				String[] fwsettings = DatabaseManager.getString(p, "Fireworks-Settings", "settings").split("\\|");
				StorageManager.fireworkcolor1.put(p, parseColor(fwsettings[0]));
				StorageManager.fireworkcolor2.put(p, parseColor(fwsettings[1]));
				StorageManager.fireworkfade1.put(p, parseColor(fwsettings[2]));
				StorageManager.fireworkfade2.put(p, parseColor(fwsettings[3]));
				StorageManager.fireworkflicker.put(p, parseBoolean(fwsettings[4]));
				StorageManager.fireworktrail.put(p, parseBoolean(fwsettings[5]));
				if(fwsettings[6].equals("null")){
					StorageManager.fireworktype.put(p, Type.BALL);
				}
				else{
					StorageManager.fireworktype.put(p, Type.valueOf(fwsettings[6]));
				}
			}
			else{
				String fwsettings = "AQUA|null|null|null|false|false|BALL";
				DatabaseManager.insertString(p.getName(), "Fireworks-Settings", "settings", fwsettings);
				
				StorageManager.fireworkcolor1.put(p, Color.AQUA);
				StorageManager.fireworkcolor2.put(p, null);
				StorageManager.fireworkfade1.put(p, null);
				StorageManager.fireworkfade2.put(p, null);
				StorageManager.fireworkflicker.put(p, false);
				StorageManager.fireworktrail.put(p, false);
				StorageManager.fireworktype.put(p, Type.BALL);
			}
			
			VoteManager.checkForVotes(p);
			
			StorageManager.loaded.put(p, true);
			
			TitleManager.setTitle(p, "§6§lOrbitMines§f§lMiniGames", "");
			
			new BukkitRunnable(){
				public void run(){
					p.sendMessage("§7§m----------------------------------------");
					p.sendMessage(" §6§lOrbitMines§4§lNetwork §7- §f§lMiniGames");
					p.sendMessage(" ");
					p.sendMessage(" §7§lWebsite: §6www.orbitmines.com");
					p.sendMessage(" §7§lDonate: §3shop.orbitmines.com");
					p.sendMessage(" §7§lVote: §bwww.orbitmines.com/vote");
					p.sendMessage(" ");
					p.sendMessage(" §7§lMiniGames Spawn Built By: §d§lBuilder §drienk222");
					p.sendMessage(" §7§lDeveloped By: §4§lOwner §4O_o_Fadi_o_O");
					p.sendMessage("§7§m----------------------------------------");
				}
			}.runTaskLater(this.start, 20);
			
		}catch(Exception ex){ex.printStackTrace();}
	}
}
