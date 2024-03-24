package me.O_o_Fadi_o_O.KitPvP.kits.Bunny;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BunnyLvL2 {

	public static void give(Player p){
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// IRON SWORD
		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// CARROT
		ItemStack carrot = new ItemStack(Material.CARROT_ITEM, 1);
		ItemMeta carrotmeta = carrot.getItemMeta();
		carrotmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §6Knockback Carrot");
		carrot.setItemMeta(carrotmeta);
		carrot.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		carrot.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
		p.getInventory().setItem(1, new ItemStack(carrot));
		
		// POISON POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §2Poison Potion");
		potion1.setDurability((short) 16420);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(2, new ItemStack(potion1));
		p.getInventory().setItem(3, new ItemStack(potion1));
		
		// INSTANT DAMAGE POTION
		ItemStack potion2 = new ItemStack(Material.POTION, 1);
		ItemMeta potion2meta = potion2.getItemMeta();
		potion2meta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §4Harming Potion");
		potion2.setDurability((short) 16396);
		potion2.setItemMeta(potion2meta);
		p.getInventory().setItem(4, new ItemStack(potion2));
		p.getInventory().setItem(5, new ItemStack(potion2));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bHelmet");
		helmetmeta.setColor(Color.fromBGR(250, 250, 250));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bChestplate");
		chestplatemeta.setColor(Color.fromBGR(250, 250, 250));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bLeggings");
		leggingsmeta.setColor(Color.fromBGR(250, 250, 250));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lBunny §a§lLvL 2§8 || §bBoots");
		bootsmeta.setColor(Color.fromBGR(250, 250, 250));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		p.getInventory().setBoots(boots);
		
		// JUMP BOOST
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000000, 3));
		
	}
}
