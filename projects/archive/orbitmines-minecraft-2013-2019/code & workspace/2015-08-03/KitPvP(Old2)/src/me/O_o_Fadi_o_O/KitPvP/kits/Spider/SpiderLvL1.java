package me.O_o_Fadi_o_O.KitPvP.kits.Spider;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

public class SpiderLvL1 {

	public static void give(Player p){
		
		StorageManager.PlayerKitSelected.put(p, KitPlaying.Spider_LvL_1);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// SPIDER EYE
		ItemStack sword = new ItemStack(Material.SPIDER_EYE, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("�b�lSpider �a�lLvL 1�8 || �bWeapon");
		List<String> swordlore = new ArrayList<String>();
		swordlore.add("�7Arthropods I");
		swordmeta.setLore(swordlore);
		sword.setItemMeta(swordmeta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// LEATHER HELMET
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmetmeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetmeta.setDisplayName("�b�lSpider �a�lLvL 1�8 || �bHelmet");
		helmetmeta.setColor(Color.fromBGR(0, 0, 0));
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// LEATHER CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplatemeta.setDisplayName("�b�lSpider �a�lLvL 1�8 || �bChestplate");
		chestplatemeta.setColor(Color.fromBGR(0, 0, 0));
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// LEATHER LEGGINGS
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta leggingsmeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsmeta.setDisplayName("�b�lSpider �a�lLvL 1�8 || �bLeggings");
		leggingsmeta.setColor(Color.fromBGR(0, 0, 0));
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// LEATHER BOOTS
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootsmeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsmeta.setDisplayName("�b�lSpider �a�lLvL 1�8 || �bBoots");
		bootsmeta.setColor(Color.fromBGR(0, 0, 0));
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
