package me.O_o_Fadi_o_O.KitPvP.kits.Librarian;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class LibrarianLvL2 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.Librarian_LvL_2);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// PAPER
		ItemStack sword = new ItemStack(Material.PAPER, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// BOOK
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �6Knockback Weapon");
		book.setItemMeta(bookmeta);
		book.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
		p.getInventory().setItem(1, new ItemStack(book));
		
		// BOOK SHELF
		ItemStack helmet = new ItemStack(Material.BOOKSHELF, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		p.getInventory().setHelmet(helmet);
		
		// CHAIN CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// CHAIN BOOTS
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lLibrarian �a�lLvL 2�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		p.getInventory().setBoots(boots);
		
	}
}
