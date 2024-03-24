package me.O_o_Fadi_o_O.KitPvP;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LobbyItems {

	public static void giveItems(Player p){
		
		p.getInventory().clear();
	
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
	    
	    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0));
		
		{
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta itemmeta = (BookMeta) item.getItemMeta();
			itemmeta.setDisplayName("§c§nBook of Enchantments");
			itemmeta.addPage("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25");
			itemmeta.setPage(1, 
			"\n\n          §0§lBook\n"
			+ "         §0§lof \n"
			+ "   §0§lEnchantments");
			itemmeta.setPage(2, 
			"§0§lLightning §0§o(Sword)\n"
			+ " §0§l- Lightning I\n"
			+ "  §0§oOn Hit, 25% chance for a lightning to strike on your opponent.\n"
			+ " §0§l- Lightning II\n"
			+ "  §0§oOn Hit, 33% chance for a lightning to strike on your opponent.\n");
			itemmeta.setPage(3, 
			"§0§lBlindness\n"
			+ " §0§l- Blindness I\n"
			+ "  §0§oOn Hit, giving 2 seconds of Blindness to your opponent.\n"
			+ " §0§l- Blindness II\n"
			+ "  §0§oOn Hit, giving 3 seconds of Blindness to your opponent.\n");
			itemmeta.setPage(4, 
			"§0§lHealing\n"
			+ " §0§l- Healing I\n"
			+ "  §0§oSHIFT + Right Click, giving 4 seconds of Regeneration III to yourself.\n"
			+ " §0§l- Healing II\n"
			+ "  §0§oSHIFT + Right Click, giving 5 seconds of Regeneration III to yourself.\n");
			itemmeta.setPage(5, 
			"§0§lVampire\n"
			+ " §0§l- Vampire I\n"
			+ "  §0§oOn Hit, restoring 1.5 hearts to your health.\n");
			itemmeta.setPage(6, 
			"§0§lMagic\n"
			+ " §0§l- Magic I\n"
			+ "  §0§oOn Hit, giving 4 second of Wither I to your opponent.\n");
			itemmeta.setPage(7, 
			"§0§lKnockup\n"
			+ " §0§l- Knockup I\n"
			+ "  §0§oOn Hit, 50% chance to knockup your opponent in the air.\n");
			itemmeta.setPage(8, 
			"§0§lLightning §0§o(Bow)\n"
			+ " §0§l- Lightning I\n"
			+ "  §0§oOn Hit, striking a lightning on your opponent.\n");
			itemmeta.setPage(9, 
			"§0§lUndeath\n"
			+ " §0§l- Undeath I\n"
			+ "  §0§oOn Hit, spawning 3 Undeath Knights that will attack your opponent.\n"
			+ " §0§l- Undeath II\n"
			+ "  §0§oOn Hit, spawning 3 Undeath Knights and 1 Undeath Archer that will attack your opponent.\n");
			itemmeta.setPage(10, 
			"§0§lExplode\n"
			+ " §0§l- Explode I\n"
			+ "  §0§oOn Hit, spawning a TNT at your opponents position.\n");
			itemmeta.setPage(11, 
			"§0§lArrow Split\n"
			+ " §0§l- Arrow Split I\n"
			+ "  §0§oWhen releasing an arrow, 4 more will spawn at its side.\n");
			itemmeta.setPage(12, 
			"§0§lWither Armor\n"
			+ " §0§l- Wither Armor I\n"
			+ "  §0§oWhen getting hit, 5 seconds of Wither II to your opponent.\n");
			itemmeta.setPage(13, 
			"§0§lMolten Armor\n"
			+ " §0§l- Molten Armor I\n"
			+ "  §0§oWhen getting hit, giving 5 seconds of Blindness and 5 seconds of Slowness VI to your opponent.\n");
			itemmeta.setPage(14, 
			"§0§lFire Trail\n"
			+ " §0§l- Fire Trail I\n"
			+ "  §0§oWhen walking, a path of fire will appear behind you.\n");
			itemmeta.setPage(15, 
			"§0§lLight\n"
			+ " §0§l- Light I\n"
			+ "  §0§oWhen walking over water, replacing nearby blocks with Cobblestone.\n");
			itemmeta.setPage(16, 
			"§0§lFly\n"
			+ " §0§l- Fly I\n"
			+ "  §0§oSHIFT, ability to fly!\n");
			itemmeta.setPage(17, 
			"§0§lArthropods\n"
			+ " §0§l- Arthropods I\n"
			+ "  §0§oOn Hit, 16.67% chance for a Spider to spawn on your opponent.\n"
			+ " §0§l- Arthropods II\n"
			+ "  §0§oOn Hit, 20% chance for a Spider Jockey to spawn on your opponent.\n");
			itemmeta.setPage(18,
			" §0§l- Arthropods III\n"
			+ "  §0§oOn Hit, 25% chance for a Spider and a Spider Jockey to spawn on your opponent.\n");
			itemmeta.setPage(19, 
			"§0§lWither\n"
			+ " §0§l- Wither I\n"
			+ "  §0§oRight Click, shooting 4 Wither Skulls from your position. Price: 1 Soul. Killing an opponent will give you a Soul.\n");
			itemmeta.setPage(20,
			"§0§lBarrier\n"
			+ " §0§l- Barrier I\n"
			+ "  §0§oRight Click, spawning a force shield around you, giving 5 seconds of Resistance.\n"
			+ " §0§l- Barrier II\n"
			+ "  §0§oRight Click, spawning a force shield around you, giving 5 seconds of Resistance II.\n");
			itemmeta.setPage(21,
			"§0§lTNT\n"
			+ " §0§l- TNT I\n"
			+ "  §0§oRight Click, shooting a TNT where you're looking at.\n");
			itemmeta.setPage(22,
			"§0§lFish Attack\n"
			+ " §0§l- Fish Attack I\n"
			+ "  §0§oRight Click, giving 4 seconds of Poison III to all nearby opponents.\n");
			itemmeta.setPage(23,
			"§0§lShield\n"
			+ " §0§l- Shield I\n"
			+ "  §0§oRight Click, giving 10 seconds of Resistance to yourself.\n"
			+ " §0§l- Shield II\n"
			+ "  §0§oRight Click, giving 12 seconds of Resistance II to yourself.\n");
			itemmeta.setPage(24,
			"§0§lTrade\n"
			+ " §0§l- Trade I\n"
			+ "  §0§oOn Hit, removing this item and stealing your opponents weapon.\n");
			itemmeta.setPage(25,
			"§0§lHealing Kit\n"
			+ " §0§l- Healing Kit I\n"
			+ "  §0§oRight Click, removing this item and restoring you to full health.\n");
			itemmeta.setAuthor("§6§lOrbitMines§c§lKitPvP");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(0, new ItemStack(item));
			
		}
		{
			ItemStack item = new ItemStack(Material.EXP_BOTTLE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§d§nAchievements");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(1, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3§nServer Selector");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(4, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§a§nBoosters");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(5, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§9§nCosmetic Perks");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(7, new ItemStack(item));
		}
		{
			ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§b§nKit Selector");
			item.setItemMeta(itemmeta);
			p.getInventory().setItem(8, new ItemStack(item));
		}
	}
}
