package me.O_o_Fadi_o_O.KitPvP.kits.Wizard;

import java.util.ArrayList;
import java.util.List;

import me.O_o_Fadi_o_O.KitPvP.managers.StorageManager;
import me.O_o_Fadi_o_O.KitPvP.utils.KitPlaying;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class WizardLvL2 {

	public static void give(Player p){

		StorageManager.PlayerKitSelected.put(p, KitPlaying.Wizard_LvL_2);
		
		p.getInventory().clear();
		
	    for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
	    }
		
		// STONE SWORD
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bWeapon");
		sword.setItemMeta(swordmeta);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		p.getInventory().setItem(0, new ItemStack(sword));
		
		// REGENERATION POTION
		ItemStack potion1 = new ItemStack(Material.POTION, 1);
		ItemMeta potion1meta = potion1.getItemMeta();
		potion1meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §dRegeneration Potion");
		potion1.setDurability((short) 8193);
		potion1.setItemMeta(potion1meta);
		p.getInventory().setItem(1, new ItemStack(potion1));
		
		// SPEED POTION
		ItemStack potion3 = new ItemStack(Material.POTION, 1);
		ItemMeta potion3meta = potion3.getItemMeta();
		potion3meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bSpeed Potion");
		potion3.setDurability((short) 8194);
		potion3.setItemMeta(potion3meta);
		p.getInventory().setItem(2, new ItemStack(potion3));
		
		// WEAKNESS POTION
		ItemStack potion4 = new ItemStack(Material.POTION, 1);
		ItemMeta potion4meta = potion4.getItemMeta();
		potion4meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §7Weakness Potion");
		potion4.setDurability((short) 16392);
		potion4.setItemMeta(potion4meta);
		p.getInventory().setItem(3, new ItemStack(potion4));
		
		// HEALING POTION
		ItemStack potion2 = new ItemStack(Material.POTION, 1);
		ItemMeta potion2meta = potion2.getItemMeta();
		potion2meta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §cHealing Potion");
		potion2.setDurability((short) 16389);
		potion2.setItemMeta(potion2meta);
		p.getInventory().setItem(4, new ItemStack(potion2));
		p.getInventory().setItem(5, new ItemStack(potion2));
		
		// BLAZE ROD | WAND
		ItemStack blazerod = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta blazerodmeta = blazerod.getItemMeta();
		blazerodmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §cFire Wand");
		List<String> blazerodlore = new ArrayList<String>();
		blazerodlore.add("§7Fire Spell I");
		blazerodmeta.setLore(blazerodlore);
		blazerod.setItemMeta(blazerodmeta);
		p.getInventory().setItem(6, new ItemStack(blazerod));
		
		// GOLD HELMET
		ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmetmeta = helmet.getItemMeta();
		helmetmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bHelmet");
		helmet.setItemMeta(helmetmeta);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setHelmet(helmet);
		
		// GOLD CHESTPLATE
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
		chestplatemeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bChestplate");
		chestplate.setItemMeta(chestplatemeta);
		chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setChestplate(chestplate);
		
		// GOLD LEGGINGS
		ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
		ItemMeta leggingsmeta = leggings.getItemMeta();
		leggingsmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bLeggings");
		leggings.setItemMeta(leggingsmeta);
		leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setLeggings(leggings);
		
		// GOLD BOOTS
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta bootsmeta = boots.getItemMeta();
		bootsmeta.setDisplayName("§b§lWizard §a§lLvL 2§8 || §bBoots");
		boots.setItemMeta(bootsmeta);
		boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		p.getInventory().setBoots(boots);
		
	}
}
