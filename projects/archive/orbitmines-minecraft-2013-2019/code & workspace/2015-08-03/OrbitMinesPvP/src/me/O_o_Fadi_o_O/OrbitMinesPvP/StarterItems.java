package me.O_o_Fadi_o_O.OrbitMinesPvP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StarterItems {
	
	public static void giveStarterItems(Player p){
		
		p.getInventory().clear();
		
		// SWORD
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§bWeapon §8|| §cLocked");
		List<String> l = new ArrayList<String>();
		l.add("§c§oLocked");
		swordmeta.setLore(l);
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack((sword)));
		
		// BOW
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowmeta = bow.getItemMeta();
		bowmeta.setDisplayName("§bRocket Launcher §8|| §cLocked");
		List<String> l2 = new ArrayList<String>();
		l2.add("§c§oLocked");
		bowmeta.setLore(l2);
		bow.setItemMeta(bowmeta);
		p.getInventory().setItem(1, new ItemStack((bow)));
		
		// EMERALD
		ItemStack emerald = new ItemStack(Material.EMERALD, 1);
		ItemMeta emeraldmeta = emerald.getItemMeta();
		emeraldmeta.setDisplayName("§2Repair§7§o (Right Click)");
		List<String> l3 = new ArrayList<String>();
		l3.add("§7§oTier 1");
		swordmeta.setLore(l3);
		emerald.setItemMeta(emeraldmeta);
		p.getInventory().setItem(2, new ItemStack((emerald)));
		
		// APPLE
		ItemStack apple = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta applemeta = apple.getItemMeta();
		applemeta.setDisplayName("§aBoosters§7§o (Right Click)");
		apple.setDurability((short) 1);
		apple.setItemMeta(applemeta);
		p.getInventory().setItem(3, new ItemStack((apple)));
		
		// ENDERPEARL
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 1);
		ItemMeta enderpearlmeta = enderpearl.getItemMeta();
		enderpearlmeta.setDisplayName("§3Teleporter§7§o (Right Click)");
		enderpearl.setItemMeta(enderpearlmeta);
		p.getInventory().setItem(4, new ItemStack((enderpearl)));
		
		// REDSTONE
		ItemStack materials = new ItemStack(Material.REDSTONE, 1);
		ItemMeta materialsmeta = materials.getItemMeta();
		materialsmeta.setDisplayName("§cMaterials§7§o (Right Click)");
		materials.setItemMeta(materialsmeta);
		p.getInventory().setItem(5, new ItemStack((materials)));
		
		// BOOK
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName("§6Stats§7§o (Right Click)");
		book.setItemMeta(bookmeta);
		p.getInventory().setItem(6, new ItemStack((book)));
		
		// PAPER
		ItemStack paper = new ItemStack(Material.PAPER, 1);
		ItemMeta papermeta = paper.getItemMeta();
		papermeta.setDisplayName("§fVIP Perks§7§o (Right Click)");
		paper.setItemMeta(papermeta);
		p.getInventory().setItem(7, new ItemStack((paper)));
		
		// NETHER STAR
		ItemStack shop = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta shopmeta = shop.getItemMeta();
		shopmeta.setDisplayName("§dQuick Shop§7§o (Right Click)");
		shop.setItemMeta(shopmeta);
		p.getInventory().setItem(8, new ItemStack((shop)));
		
	}
}
