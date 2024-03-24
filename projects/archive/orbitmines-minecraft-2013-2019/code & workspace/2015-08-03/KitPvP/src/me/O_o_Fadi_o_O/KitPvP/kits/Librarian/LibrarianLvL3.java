package me.O_o_Fadi_o_O.KitPvP.kits.Librarian;

import me.O_o_Fadi_o_O.KitPvP.CustomItem;
import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.managers.TitleManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class LibrarianLvL3 {

	public static void give(Player p){
		
		StorageManager.kitselected.put(p, KitPlaying.Librarian_LvL_3);
		TitleManager.setTitle(p, "", "§7Selected Kit '§b§lLibrarian§7' (§aLevel 3§7)");
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// PAPER
		ItemStack sword = new ItemStack(Material.PAPER, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOOK
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §6Knockback Weapon");
		book.setItemMeta(bookmeta);
		book.addUnsafeEnchantment(Enchantment.KNOCKBACK, 6);
		p.getInventory().setItem(1, new ItemStack(book));
		
		// BOOK SHELF
		ItemStack helmet = new ItemStack(Material.BOOKSHELF, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate = CustomItem.setUnbreakable(chestplate);
		chestplate = CustomItem.hideFlags(chestplate, 4);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		leggings = CustomItem.setUnbreakable(leggings);
		leggings = CustomItem.hideFlags(leggings, 4);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lLibrarian §a§lLvL 3§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots = CustomItem.setUnbreakable(boots);
		boots = CustomItem.hideFlags(boots, 4);
		p.getInventory().setBoots(boots);
		
	}
}
