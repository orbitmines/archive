package me.O_o_Fadi_o_O.KitPvP.kits.Vampire;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

public class VampireLvL1 {

	public static void give(Player p){
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// IRON SWORD 1
		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §4Vampire Weapon");
		List<String> swordlore = new ArrayList<String>();
		swordlore.add("§7Vampire I");
		swordmeta.setLore(swordlore);
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// IRON SWORD 2
		ItemStack sword2 = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta2 = sword2.getItemMeta();
		swordmeta2.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bWeapon");
		List<String> swordlore2 = new ArrayList<String>();
		swordlore2.add("§7Blindness I");
		swordmeta2.setLore(swordlore2);
		sword2.setItemMeta(swordmeta2);
		p.getInventory().setItem(1, new ItemStack(sword2));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(50, 10, 150));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(50, 10, 150));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(50, 10, 150));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lVampire §a§lLvL 1§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(50, 10, 150));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setBoots(boots);
		
	}
}
