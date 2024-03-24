package me.O_o_Fadi_o_O.KitPvP.kits.Tank;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TankLvL3 {

	public static void give(Player p){

		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// IRON SWORD
		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.KNOCKBACK, 2);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// GOLDEN APPLE
		ItemStack potion1 = new ItemStack(Material.GOLDEN_APPLE, 4);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("§b§lTank §a§lLvL 3§8 || §eGolden Apple");
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(1, new ItemStack(potion1));
		
		// IRON HELMET
		ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// DIAMOND CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// IRON LEGGINGS
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// IRON BOOTS
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lTank §a§lLvL 3§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
		// SLOWNESS
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000000, 2));
		
	}
}
