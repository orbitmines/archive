package me.O_o_Fadi_o_O.KitPvP.kits.Drunk;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrunkLvL3 {

	public static void give(Player p){

		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// DIAMOND SWORD
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �bWeapon");
		List<String> swordlore = new ArrayList<String>();
		swordlore.add("�7Blindness II");
		swordmeta.setLore(swordlore);
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.KNOCKBACK, 2);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// STRENGTH POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �5Strength Potion");
		potion1.setDurability((short) 8201);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(1, new ItemStack(potion1));
		
		// IRON HELMET
		ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// IRON CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// CHAIN LEGGINGS
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// IRON BOOTS
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lDrunk �a�lLvL 3�8 || �bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
		// NAUSEA
		p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000000, 0));
		
	}
}
